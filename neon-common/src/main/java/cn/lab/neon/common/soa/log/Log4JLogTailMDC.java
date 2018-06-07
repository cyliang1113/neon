package cn.lab.neon.common.soa.log;

import org.apache.log4j.MDC;

public class Log4JLogTailMDC {
    private static final String LOG_TAIL = "LOG_TAIL";

    public static void setTail(String tail) {
        MDC.put(LOG_TAIL, tail);
    }

    public static Object getTail() {
        return MDC.get(LOG_TAIL);
    }


    public static void removeTail() {
        MDC.remove(LOG_TAIL);
    }
}
