package cn.lab.neon.common.soa;

public class TrackNumberContext {
    private static final ThreadLocal<String> trackNumber = new ThreadLocal();
    public static String appName;

    public static void setTrackNumber(String trackNumber) {
        TrackNumberContext.trackNumber.set(trackNumber);
    }

    public static String getTrackNumber() {
        return trackNumber.get();
    }


    public static void remove() {
        trackNumber.remove();
    }
}
