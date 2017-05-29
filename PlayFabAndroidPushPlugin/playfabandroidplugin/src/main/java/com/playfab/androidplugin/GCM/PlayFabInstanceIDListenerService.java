package com.playfab.androidplugin.GCM;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.iid.InstanceIDListenerService;
import com.playfab.androidplugin.PlayFabAndroidPlugin;

/**
 * Created by Marco on 8/19/2015.
 */
public class PlayFabInstanceIDListenerService extends InstanceIDListenerService {

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. This call is initiated by the
     * InstanceID provider.
     *
     * This method ensures that even if token changes during application running, we get the notification
     */
    @Override
    public void onTokenRefresh() {
        Log.d(PlayFabAndroidPlugin.TAG,"Handling token refresh");
        PlayFabAndroidPlugin.emitGCMReady();
        PlayFabGoogleCloudMessaging.getToken(this);
    }
}
