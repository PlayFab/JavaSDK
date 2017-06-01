/**
 * Created by Marco on 8/19/2015.
 */
package com.playfab.androidplugin;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Debug;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.android.gms.iid.InstanceID;
import com.playfab.androidplugin.GCM.PlayFabConst;
import com.playfab.androidplugin.GCM.PlayFabGcmListenerService;
import com.playfab.androidplugin.GCM.PlayFabGoogleCloudMessaging;
import com.playfab.androidplugin.GCM.PlayFabNotificationPackage;
import com.playfab.androidplugin.GCM.PlayServicesUtils;

public class PlayFabAndroidPlugin extends Service {
    public static final String TAG = "PlayFabAP"; //PlayFabAndroidPlugin
    public static final String UNITY_EVENT_OBJECT = "_PlayFabGO";
    public static final String PROPERTY_GAME_TITLE = "_PlayFab_GameTitle";
    public static final String PROPERTY_APP_ICON = "_PlayFab_AppIcon";
    public static final String PROPERTY_SENDER_ID = "_PlayFab_SenderID";
    public static final String SENT_TOKEN_TO_SERVER = "sentTokenToServer";
    public static boolean AlwaysShowOnNotificationBar = true;

    private static boolean mServiceBound = false;
    private static PlayFabAndroidPlugin mBoundService;
    private static String mGameTitle;
    private static String mSenderId;
    private static String mAppIcon;

    private IBinder mBinder = new LocalPlayFabBinder();
    private IPlayFabAndroidListener listener;

    public static boolean isBound() {
        return getInstance() != null && getInstance().hasListener();
    }

    private boolean hasListener() {
        return listener != null;
    }



    public class LocalPlayFabBinder extends Binder {
        public PlayFabAndroidPlugin getService() {
            return PlayFabAndroidPlugin.this;
        }
    }

    @Override
    public void onCreate() {
        if(msInstance != null){
            Log.e(TAG,"PlayFabAndroidPlugin Service is already running!");
            return;
        }
        msInstance = this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "PlayFabAndroidPlugin Service onBind");
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "PlayFabAndroidPlugin Service onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "PlayFabAndroidPlugin Service onUnbind");
        return true;
    }

    private <T extends Activity & IPlayFabAndroidListener> void assignListener(T listener) {

        if(listener == null){
            this.listener = null;
            Log.d(TAG,"Setting listener to null");
            return;
        }
        if (PlayServicesUtils.isPlayServicesAvailable(listener)) {
            this.listener = listener;
            Log.d(TAG,"Listener set");
        } else {
            Log.e(TAG,"Listening activity does not have Play Services available");
        }
    }

    public static void emitGCMTokenRefreshed(String token){
        Log.d(TAG,"Should emit GCMTokenRefreshed" + token);
        PlayFabAndroidPlugin instance = getInstance();
        if(instance != null) {
            instance.listener.onGCMTokenRefreshed(token);
        } else {
            Log.d(TAG, "But instance is null");
        }
    }

    public static void emitMessageRecieved(PlayFabNotificationPackage message) {
        Log.d(TAG,"Should emit GCMMessage Recieved" + message);
        PlayFabAndroidPlugin instance = getInstance();
        if(instance != null) {
            instance.listener.onGCMMessageRecieved(message);
        } else {
            Log.d(TAG, "But instance is null");
        }
    }

    public static void emitGCMReady() {
        Log.d(TAG,"Should emit GCMReady");
        PlayFabAndroidPlugin instance = getInstance();
        if(instance != null) {
            instance.listener.onGCMReady();
        } else {
            Log.d(TAG, "But instance is null");
        }
    }

    private static PlayFabAndroidPlugin msInstance;

    public static PlayFabAndroidPlugin getInstance() {
        return msInstance;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(msInstance == this){
            msInstance = null;
        }
    }

    private void initGCM(String senderId, String gameTitle) {
        try {

            if (!PlayFabConst.hideLogs)
                Log.i(PlayFabConst.LOG_TAG, "PlayFab GCM Init, saving prefs.");
            if (!PlayFabConst.hideLogs)
                Log.i(PlayFabConst.LOG_TAG, "Setting SenderId: " + senderId);
            mSenderId = senderId;
            mGameTitle = gameTitle;

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(PROPERTY_SENDER_ID, mSenderId);
            editor.putString(PROPERTY_GAME_TITLE, mGameTitle);
            if (mAppIcon != null) {
                editor.putString(PROPERTY_APP_ICON, mAppIcon);
            }
            editor.commit();


            emitGCMReady();
            PlayFabGoogleCloudMessaging.getToken(this);
        } catch (Exception e) {
            Log.e(TAG, "PlayFab GCM initGCM exception: " + e.getMessage());
        }
    }

    private void initGCM(String senderId, String gameTitle, String appIcon) {
        try {
            mAppIcon = appIcon;
            initGCM(senderId, gameTitle);
        } catch (Exception e) {
            Log.e(TAG, "PlayFab GCM initGCM exception: " + e.getMessage());
        }
    }

    public static <T extends Activity & IPlayFabAndroidListener> void start(final T listener, final String senderId, final String mGameTitle, final String appIcon) {

        ServiceConnection serviceConnection = new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName className, final IBinder service) {

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG,"Starting with activity: "+listener.getClass().getName());
                        // cast the IBinder and get MyService instance
                        PlayFabAndroidPlugin.LocalPlayFabBinder binder = (PlayFabAndroidPlugin.LocalPlayFabBinder) service;
                        PlayFabAndroidPlugin androidPlayFabPlugin = binder.getService();
                        androidPlayFabPlugin.assignListener(listener); // register
                        if(appIcon == null || appIcon.isEmpty()){
                            androidPlayFabPlugin.initGCM(senderId,mGameTitle);
                        } else {
                            androidPlayFabPlugin.initGCM(senderId,mGameTitle,appIcon);
                        }
                    }
                });


            }

            @Override
            public void onServiceDisconnected(ComponentName arg0) {
            }
        };

        Intent intent = new Intent(listener, PlayFabAndroidPlugin.class);
        listener.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE | Context.BIND_NOT_FOREGROUND);

    }

    public static void stopPluginService() {
        if(msInstance != null) {
            msInstance.assignListener(null);
        }
    }

    public static void alwaysShowOnNotificationBar(boolean showAlways) {
        AlwaysShowOnNotificationBar = showAlways;
    }

}