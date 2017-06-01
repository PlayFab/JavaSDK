package com.foo.playfab.app;

import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.playfab.PlayFabClientAPI;
import com.playfab.PlayFabClientModels;
import com.playfab.PlayFabErrors;
import com.playfab.PlayFabSettings;
import com.playfab.androidplugin.GCM.PlayFabNotificationPackage;
import com.playfab.androidplugin.GCM.PlayFabNotificationSender;
import com.playfab.androidplugin.IPlayFabAndroidListener;
import com.playfab.androidplugin.PlayFabAndroidPlugin;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IPlayFabAndroidListener {

    private String currentToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlayFabSettings.TitleId = "E050";

        PlayFabAndroidPlugin.start(this,"398834786021","E050","ic_stat_blur_on");

        Button signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        //Craft some sort of unique device identifier
                        String android_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
                        PlayFabClientModels.LoginWithAndroidDeviceIDRequest request = new PlayFabClientModels.LoginWithAndroidDeviceIDRequest();
                        request.CreateAccount = true;
                        request.AndroidDeviceId = android_id;
                        PlayFabErrors.PlayFabResult<PlayFabClientModels.LoginResult> result =
                                PlayFabClientAPI.LoginWithAndroidDeviceID(request);

                        if(!processResult(result)) return;

                        Log.d("Playfab", "Token: " + currentToken);

                        PlayFabClientModels.AndroidDevicePushNotificationRegistrationRequest gcmRequest =
                                new PlayFabClientModels.AndroidDevicePushNotificationRegistrationRequest();
                        gcmRequest.DeviceToken = currentToken;
                        PlayFabErrors.PlayFabResult<PlayFabClientModels.AndroidDevicePushNotificationRegistrationResult> gcmResult =
                                PlayFabClientAPI.AndroidDevicePushNotificationRegistration(gcmRequest);

                        if(!processResult(gcmResult)) return;


                        sendNotification();


                    }
                });
            }
        });
    }

    private void sendNotification() {

        PlayFabNotificationPackage package1 = PlayFabNotificationSender.createNotificationPackageFromMessage(this, "This is scheduled message", 0,
                new Date(System.currentTimeMillis() + 30 * 1000),false);
        //PlayFabNotificationPackage package2 = PlayFabNotificationSender.createNotificationPackage(this, "This is scheduled local message", 0,
        //        new GregorianCalendar(2017, 4, 26,2,5,0).getTime(), true);
        PlayFabNotificationSender.send(this, package1);
        //PlayFabNotificationSender.send(this, package2);
    }

    private <T> boolean processResult(PlayFabErrors.PlayFabResult<T> result){
        if (result.Error != null) {
            Log.d("Playfab", CompileErrorsFromResult(result));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onGCMReady() {
        Log.d("FooPlayfabApp","GCMReady");
    }

    @Override
    public void onGCMTokenRefreshed(String s) {
        Log.d("FooPlayfabApp","New Token: "+s);
        currentToken = s;
    }

    @Override
    public void onGCMMessageRecieved(PlayFabNotificationPackage s) {
        Log.d("FooPlayfabApp","New Message"+s.Title);
    }

    private static <RT> String CompileErrorsFromResult(PlayFabErrors.PlayFabResult<RT> result) {
        if (result == null || result.Error == null)
            return null;

        String errorMessage = "";
        if (result.Error.errorMessage != null)
            errorMessage += result.Error.errorMessage;
        if (result.Error.errorDetails != null)
            for (Map.Entry<String, List<String>> pair : result.Error.errorDetails.entrySet())
                for (String msg : pair.getValue())
                    errorMessage += "\n" + pair.getKey() + ": " + msg;

        return errorMessage;
    }

}
