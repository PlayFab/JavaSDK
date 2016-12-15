AndroidStudio example in JavaSDK for PlayFab README
========
1. Overview:
----
This document describes the AndroidStudio example in the JavaSDK.


2. Prerequisites:
----
* Users should be very familiar with the topics covered in our [getting started guide](https://playfab.com/docs/getting-started-with-playfab/).

To connect to the PlayFab service, your machine must be running TLS v1.2 or better.
* For Windows, this means Windows 7 and above
* [Official Microsoft Documentation](https://msdn.microsoft.com/en-us/library/windows/desktop/aa380516%28v=vs.85%29.aspx)
* [Support for SSL/TLS protocols on Windows](http://blogs.msdn.com/b/kaushal/archive/2011/10/02/support-for-ssl-tls-protocols-on-windows.aspx)


3. Contents, Installation & Configuration Instructions:
----
This package contains the standard JavaSDKs and the Android Studio Example.
* AndroidStudioExample - Client-only integration of PlayFabSDK into an AndroidStudio example project

The JavaSDK/PlayFabClientSDK folder is ready-made for integration with an existing AndroidStudio project.
* Unzip JavaSDK to {JavaSDK-Location}
* Locate your AndroidStudio project at {YourProject-Location}
* Navigate to {JavaSDK-Location}/PlayFabClientSDK/src
* Copy the {JavaSDK-Location}/PlayFabClientSDK/src/com folder to:
 * {YourProject-Location}\app\src\main\java
 * This will install PlayFab and Google-gson (a requirement), into your project.
* Modify your AndroidManifest.xml
 * {JavaSDK-Location}\AndroidStudioExample\app\src\main\AndroidManifest.xml
 * Add this line:
  * <uses-permission android:name="android.permission.INTERNET" />
   * The PlayFab service is an online cloud service, and internet access is required

The JavaSDK/AndroidStudioExample is a suitable starting place for a new project, or to test PlayFab api-calls
* Unzip JavaSDK to {JavaSDK-Location}
* Open the {JavaSDK-Location}/AndroidStudioExample project in Android Studio
 * Expand the Project tab
  * Navigate to "app/java/com.playfab/PlayFabApiTests"
   * Double clicking this file will open the test suite, and allow you to set your title information
    * The AndroidStudio does not currently load a TestTitleData.json file like other projects
    * Set your own title id and user information at the top of the file.
    * The example information is not valid, and you must set it to your own title and login information
   * Right click (in project "app/java/com.playfab/PlayFabApiTests") and "run PlayFabApiTests"
    * This will prompt to launch an android emulator - accept
    * You should see output in the Event Log and Run windows to indicate test execution and results


4. Troubleshooting:
----
For a complete list of available APIs, check out the [online documentation](http://api.playfab.com/Documentation/).

#### Contact Us
We love to hear from our developer community!
Do you have ideas on how we can make our products and services better?

Our Developer Success Team can assist with answering any questions as well as process any feedback you have about PlayFab services.

[Forums, Support and Knowledge Base](https://community.playfab.com/index.html)


5. Copyright and Licensing Information:
----
  Apache License --
  Version 2.0, January 2004
  http://www.apache.org/licenses/

  Full details available within the LICENSE file.

  Initial code Submitted to PlayFab by nicosio2 (https://github.com/nicosio2)
