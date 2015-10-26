package playfab.internal;

public class PlayFabVersion {
    public static String ApiRevision = "1.8.20151026";
    public static String SdkRevision = "0.6.151026";
    public static String getVersionString() {
        return "JavaSDK-" + SdkRevision + "-" + ApiRevision;
    }
}


