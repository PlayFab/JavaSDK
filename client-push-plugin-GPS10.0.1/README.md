# PlayFab Push Notification Plugin

## For Android build targets

We support Android Google Play Services (GPS) v 10.0.1

# 1. Overview:

This section of the repository contains the source code and documentation for building our (non-Unity) Android push notification plugin using Android Studio. The document also contains instructions for developers to start using the plugin in their Android Applications.

# 2. Prerequisites:

This document assumes familiarity with PlayFab, Java, Gradle & using Android Studio.  However, most of the work is done for you in all cases, and likely you only have to write code in your client Java classes.

* Devices will not receive push notification until properly configured.

#### PlayFab Title Setup:
  * Login to game manager and navigate to your title > Settings > Push Notifications.
  * Follow the instructions for linking your title to the GCM channel
  * Optionally, this can also be achieved via [SetupPushNotification](https://api.playfab.com/Documentation/Admin/method/SetupPushNotification) in our Admin API.
  * SetupPushNotification will reset your subscribed devices. After calling SetupPushNotification each device will need to re-subscribe. 

#### Client Android Project Setup:
Playfab Android Push Notifications Plugin is a separate JAR library that must be imported into your Android Studio application project.

#### For Additional Push-related information, see our guides:
  * [Getting Started with Playfab, Android Studio and Push Notifications](#)

# 3. Plugin Component Overview:

The source code is fairly simple and this version of the PlayFab Android Push Notifications Plugin makes use of the token-based **GCM** (Google Cloud Messaging) service.  

* **PlayFabAndroidPlugin** -  This is the single access point for the plugin.

### Most users will need very little custom code:

* Implement IPlayFabAndroidListener interface in your Main Activity
* Using Activity onCreate method, call ```PlayFabAndroidPlugin.start(this,SENDER_ID_STRING,PLAYFAB_TITLE_ID_STRING,ICON_NAME_STRING);```
* Intercept the token using onGCMTokenRefreshed method
* After new user is logged in, use the intercepted token and execute AndroidDevicePushNotificationRegistration API call

This sequence will satisfy most developers needs. The value for SENDER_ID_STRING comes from Google/FCM (see the [Push Notifications for Android](https://api.playfab.com/docs/tutorials/landing-players/push-notification-basics/push-notifications-for-android) guide for details). Setup activates the PlayFab Android Push Plugin, and generates a unique token for the user. Once you have recieved a new token, you are free to pick up the best time to call for [AndroidDevicePushNotificationRegistration](https://api.playfab.com/documentation/client/method/AndroidDevicePushNotificationRegistration) with the token.

# 4. Android Studio Source Build Instructions

### Compiling in Android Studio
*	Open the project in Android Studio
*	On the far right of the editor there is a Gradle tab.  Click that and then click the "refresh all gradle projects" button.
*	In the gradle projects window you should see two entries.  *client-push-plugin-GPS10.0.1* & *:playfabandroidplugin*. 
* Expand *:playfabandroidplugin --> Tasks --> other* and find the **exportJar** function.
*	Double-click exportJar. This will compile the plugin and export the client-push-plugin-GPS10.0.1.jar & the Android.manifest files into the /releases folder in the root of your project.  These files need to be imported as a library into your Android Studio application project.


#### Android SDK dependencies (GCM 10.0.1, appcompat/support 25.0)

Included Archive | Class Location
--- |  ---
appcompat-v7-25.1.1.aar | com.android.support.appcompat-v7 
play-services-gcm-10.0.1.aar | com.google.android.gms.play-services.gcm

Please let us know if you run into any issues and we will do our best to help.
