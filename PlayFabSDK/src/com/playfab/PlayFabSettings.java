package com.playfab;

import com.playfab.PlayFabErrors.ErrorCallback;

public class PlayFabSettings {
    public static String SdkVersion = "0.33.160815";
    public static String BuildIdentifier = "jbuild_javasdk_0";
    public static String SdkVersionString = "JavaSDK-0.33.160815";

    public static String TitleId = null; // You must set this value for PlayFabSdk to work properly (Found in the Game Manager for your title, at the PlayFab Website)
    public static ErrorCallback GlobalErrorHandler;
    public static String DeveloperSecretKey = null; // You must set this value for PlayFabSdk to work properly (Found in the Game Manager for your title, at the PlayFab Website)
    public static String LogicServerURL = null; // Deprecated
    public static String AdvertisingIdType = null; // Set this to the appropriate AD_TYPE_X constant below
    public static String AdvertisingIdValue = null; // Set this to corresponding device value

    // DisableAdvertising is provided for completeness, but changing it is not suggested
    // Disabling this may prevent your advertising-related PlayFab marketplace partners from working correctly
    public static Boolean DisableAdvertising = false;
    public static final String AD_TYPE_IDFA = "Idfa";
    public static final String AD_TYPE_ANDROID_ID = "Android_Id";

    public static String GetLogicURL() {
        return LogicServerURL;
    }

    public static String GetURL() {
        return "https://" + TitleId + ".playfabapi.com";
    }
}
