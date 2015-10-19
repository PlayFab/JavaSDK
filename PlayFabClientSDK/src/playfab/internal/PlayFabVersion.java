package playfab.internal;

public class PlayFabVersion {
    public static String ApiRevision = "1.7.20151019";
    public static String SdkRevision = "0.5.151019";
    public static String getVersionString() {
        return "JavaSDK-" + SdkRevision + "-" + ApiRevision;
    }
}


