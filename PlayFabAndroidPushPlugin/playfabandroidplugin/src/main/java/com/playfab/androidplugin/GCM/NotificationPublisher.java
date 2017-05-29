package com.playfab.androidplugin.GCM;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.util.Log;

public class NotificationPublisher extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.i(PlayFabConst.LOG_TAG, "OnRecieve Notification Publisher Sending Notification..");
        byte[] bytes = intent.getByteArrayExtra(PlayFabConst.NOTIFICATION_JSON);
        Parcel parcel = ParcelableUtil.unmarshall(bytes);
        PlayFabNotificationPackage notification = new PlayFabNotificationPackage(parcel);
        PlayFabNotificationSender.sendNotification(context, notification);
    }
}
