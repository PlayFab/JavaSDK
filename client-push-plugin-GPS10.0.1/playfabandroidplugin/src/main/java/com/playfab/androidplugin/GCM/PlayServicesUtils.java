package com.playfab.androidplugin.GCM;

/**
 * Created by Marco on 8/19/2015.
 */

import android.app.Activity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.playfab.androidplugin.PlayFabAndroidPlugin;

public class PlayServicesUtils {

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    public static boolean isPlayServicesAvailable(Activity activity) {
        boolean available = false;
        if(activity == null){
            Log.e(PlayFabAndroidPlugin.TAG,"ACTIVITY IS NULL");
        }
        try {
            GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
            int resultCode = googleAPI.isGooglePlayServicesAvailable(activity);
            available = (resultCode == ConnectionResult.SUCCESS);
            if (!available) {
                if (googleAPI.isUserResolvableError(resultCode)) {
                    googleAPI.getErrorDialog(activity, resultCode, PlayFabConst.PLAY_SERVICES_RESOLUTION_REQUEST).show();
                } else {
                    Log.i(PlayFabAndroidPlugin.TAG, "This device is not supported.");
                }
            }
        } catch (Exception e) {
            Log.e(PlayFabAndroidPlugin.TAG, "PlayFab GCM isPlayServicesAvailable exception: " + e.getMessage());
        }
        return available;
    }
}
