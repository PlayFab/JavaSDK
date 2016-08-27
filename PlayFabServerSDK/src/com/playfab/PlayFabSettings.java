package com.playfab;

import com.playfab.PlayFabErrors.ErrorCallback;

public class PlayFabSettings {
    public static String SdkVersion = "0.34.160822";
    public static String BuildIdentifier = "jbuild_javasdk_0";
    public static String SdkVersionString = "JavaSDK-0.34.160822";

    public static String TitleId = null; // You must set this value for PlayFabSdk to work properly (Found in the Game Manager for your title, at the PlayFab Website)
    public static ErrorCallback GlobalErrorHandler;
    public static String DeveloperSecretKey = null; // You must set this value for PlayFabSdk to work properly (Found in the Game Manager for your title, at the PlayFab Website)

    public static String GetURL() {
        return "https://" + TitleId + ".playfabapi.com";
    }
}
