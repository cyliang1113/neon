package cn.lab.neon.common.soa.dubbo.filter;

import com.alibaba.dubbo.rpc.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 打印dubbo服务调用日志
 * 调用方ip -> 被调用方ip, 服务名称
 */
public class InvokeLogFilter implements Filter {
    private Log log = LogFactory.getLog(InvokeLogFilter.class);


    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            String fromHost = null;
            String toHost = null;
            RpcContext context = RpcContext.getContext();
            String serviceName = invoker.getInterface().getName();
            String methodName = invocation.getMethodName();
            if(context.isConsumerSide()){
                fromHost = "localhost";
                toHost = context.getRemoteHost();
            }
            if(context.isProviderSide()){
                fromHost = context.getRemoteHost();
                toHost = "localhost";
            }

            StringBuffer sb = new StringBuffer();
            sb.append("dubbo服务调用: ").append(fromHost).append(" -> ").append(toHost);
            sb.append(", ").append(serviceName).append(".").append(methodName);
            log.info(sb.toString());
        } catch (Throwable t) {
            log.warn("打印调用日志异常.", t);
        }
        return invoker.invoke(invocation);
    }
}
