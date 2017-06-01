package com.playfab.androidplugin.GCM;


import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;
import com.playfab.androidplugin.PlayFabAndroidPlugin;
import java.util.Set;

/**
 * Monitors the Notification channel and listens for and processes incoming GCM notifications
 */
public class PlayFabGcmListenerService extends GcmListenerService {
    /**
     * Called when message is received.
     *
     * @param from SenderID of the sender.
     * @param data Data bundle containing message data as key/value pairs.
     *             For Set of keys use data.keySet().
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(String from, Bundle data) {
        Set<String> keys = data.keySet();
        for (String key : keys) {
            Object o = data.get(key);
            if (!PlayFabConst.hideLogs) Log.i(PlayFabConst.LOG_TAG, key);
            if (!PlayFabConst.hideLogs) Log.i(PlayFabConst.LOG_TAG, o.getClass().toString());
            if (o.getClass().getName().contains("String")) {
                String msg = data.getString(key);
                if (!PlayFabConst.hideLogs) Log.i(PlayFabConst.LOG_TAG, msg);
            }
        }

        Log.i(PlayFabConst.LOG_TAG, "DEBUG THIS: " + data.toString());

        String message = "";
        //Check for message first, if this message was sent via GCM API then it will contain "message"
        //otherwise it might have been sent via AWS Simple Notification Service, in which the message is in the default key.
        if (data.containsKey("message")) {
            message = data.getString("message");
        } else if (data.containsKey("default")) {
            message = data.getString("default");
        }

        int id = 0;
        if (data.containsKey("Id"))
            data.getInt("Id");

        if (!PlayFabConst.hideLogs)
            Log.i(PlayFabConst.LOG_TAG, "Push Message Received: " + message);

        PlayFabNotificationPackage notification = PlayFabNotificationSender.createNotificationPackage(this, message, id);
        PlayFabNotificationSender.send(this, notification);
    }
}
