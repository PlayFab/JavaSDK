package com.playfab.playfabexample;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;

import com.playfab.PlayFabClientAPI;
import com.playfab.PlayFabClientModels;
import com.playfab.PlayFabErrors;
import com.playfab.PlayFabSettings;

import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {
    FutureTask<PlayFabErrors.PlayFabResult<PlayFabClientModels.LoginResult>> loginTask = null;
    Runnable r = new Runnable() {
        public void run() {
            mainLoop();
        }
    };
    Handler handler = new Handler();

    private class PrintError implements PlayFabErrors.ErrorCallback {
        @Override
        public void callback(PlayFabErrors.PlayFabError error) {
            TextView status = (TextView) findViewById(R.id.Status);
            status.setText(error.errorMessage);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlayFabSettings.androidContext = this;
        PlayFabSettings.GlobalErrorHandler = new PrintError();

        TextView status = (TextView) findViewById(R.id.Status);
        status.setText("starting");

        handler.postDelayed(r, 100);
    }

    private void mainLoop() {
        TextView status = (TextView) findViewById(R.id.Status);
        TextView advertType = (TextView) findViewById(R.id.AdvertType);
        TextView advertId = (TextView) findViewById(R.id.AdvertId);
        TextView isDisabled = (TextView) findViewById(R.id.IsDisabled);

        advertType.setText(PlayFabSettings.AdvertisingIdType);
        advertId.setText(PlayFabSettings.AdvertisingIdValue);
        isDisabled.setText(PlayFabSettings.DisableAdvertising ? "true" : "false");

        if (loginTask != null && loginTask.isDone()) {
            status.setText("Logged in");
            loginTask = null;
        }

        String statusText = status.getText() + ".";
        statusText = statusText.replace(".....", "");
        status.setText(statusText);

        handler.postDelayed(r, 100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnLoginClicked(View v) {
        PlayFabClientModels.LoginWithAndroidDeviceIDRequest request = new PlayFabClientModels.LoginWithAndroidDeviceIDRequest();

        EditText titleIdWidget = (EditText) findViewById(R.id.TitleId);

        PlayFabSettings.TitleId = request.TitleId = titleIdWidget.getText().toString();
        request.AndroidDeviceId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID); ;
        request.CreateAccount = true;
        loginTask = PlayFabClientAPI.LoginWithAndroidDeviceIDAsync(request);
        Thread thread = new Thread(loginTask);
        thread.start();

        TextView status = (TextView) findViewById(R.id.Status);
        status.setText("logging in");
    }
}
