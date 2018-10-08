package cn.lab.neon.common.soa.dubbo.filter;

import cn.lab.neon.common.soa.TrackNumberContext;
import cn.lab.neon.common.soa.log.Log4JLogTailMDC;
import cn.lab.neon.common.util.UUIDUtil;
import com.alibaba.dubbo.rpc.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 打印dubbo服务调用日志
 * 调用方ip -> 被调用方ip, 服务名称
 */
public class TrackFilter implements Filter {
    private Log log = LogFactory.getLog(TrackFilter.class);

    private static String TRACK_NUMBER = "trackNumber";


    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String fromHost = null;
        String toHost = null;
        RpcContext context = RpcContext.getContext();
        String serviceName = invoker.getInterface().getName();
        String methodName = invocation.getMethodName();
        if (context.isConsumerSide()){
            // 消费者
            fromHost = "localhost";
            toHost = context.getRemoteHost();
            if (TrackNumberContext.getTrackNumber() != null) {
                context.setAttachment(TRACK_NUMBER, TrackNumberContext.getTrackNumber());
            }
            String logMsg = "dubbo服务调用: " + fromHost + " -> " + toHost + ", " + serviceName + "." + methodName;
            log.info(logMsg);
            return invoker.invoke(invocation);

        }else if(context.isProviderSide()){
            // 提供者
            fromHost = context.getRemoteHost();
            toHost = "localhost";
            String trackNumber = (String) context.getAttachment(TRACK_NUMBER);
            if(trackNumber == null){
                trackNumber = UUIDUtil.generateUuid();
            }
            TrackNumberContext.setTrackNumber(trackNumber);
            Log4JLogTailMDC.setTail(TrackNumberContext.getTrackNumber());
            String logMsg = "dubbo服务调用: " + fromHost + " -> " + toHost + ", " + serviceName + "." + methodName;
            log.info(logMsg + " -------- start");
            try {
                return invoker.invoke(invocation);
            } finally {
                log.info(logMsg + " -------- end");
                TrackNumberContext.remove();
                Log4JLogTailMDC.removeTail();
            }

        }
        return invoker.invoke(invocation);
    }
}
