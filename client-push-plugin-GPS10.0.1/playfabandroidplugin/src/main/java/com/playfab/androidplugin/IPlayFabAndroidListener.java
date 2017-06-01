package com.playfab.androidplugin;

import com.playfab.androidplugin.GCM.PlayFabNotificationPackage;

public interface IPlayFabAndroidListener {
    void onGCMReady();
    void onGCMTokenRefreshed(String token);
    void onGCMMessageRecieved(PlayFabNotificationPackage token);
}
