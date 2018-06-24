package cn.lab.neon.common.soa.log;

import cn.lab.neon.common.soa.TrackNumberContext;
import org.apache.log4j.MDC;

public class Log4JLogTailMDC {
    private static final String LOG_TAIL = "LOG_TAIL";

    public static void setTail(String trackNumber) {
        String logTail = "[trackNumber=" + trackNumber + "]";
        MDC.put(LOG_TAIL, logTail);
    }

    public static Object getTail() {
        return MDC.get(LOG_TAIL);
    }


    public static void removeTail() {
        MDC.remove(LOG_TAIL);
    }
}
