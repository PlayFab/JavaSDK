package playfab.internal;

public class PlayFabVersion {
    public static String ApiRevision = "1.9.20151109";
    public static String SdkRevision = "0.7.151109";
    public static String getVersionString() {
        return "JavaSDK-" + SdkRevision + "-" + ApiRevision;
    }
}


