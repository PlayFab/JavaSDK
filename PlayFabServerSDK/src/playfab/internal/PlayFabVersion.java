package playfab.internal;

public class PlayFabVersion {
    public static String ApiRevision = "1.7.20151019";
    public static String SdkRevision = "1.0.2";
    public static String getVersionString() {
        return "JavaSDK-" + SdkRevision + "-" + ApiRevision;
    }
}


