Java SDK for PlayFab README
========
1. Overview:
----
This document describes the process of configuring and building the PlayFab Java SDK.


2. Prerequisites:
----
* Users should be very familiar with the topics covered in our [getting started guide](https://playfab.com/docs/getting-started-with-playfab/).

To connect to the PlayFab service, your machine must be running TLS v1.2 or better.
* For Windows, this means Windows 7 and above
* [Official Microsoft Documentation](https://msdn.microsoft.com/en-us/library/windows/desktop/aa380516%28v=vs.85%29.aspx)
* [Support for SSL/TLS protocols on Windows](http://blogs.msdn.com/b/kaushal/archive/2011/10/02/support-for-ssl-tls-protocols-on-windows.aspx)


3. Source Code & Key Repository Components:
----
This package contains three different versions of the PlayFab SDK.
* PlayFabClientSDK - This version contains only client libraries and is designed for integration with your game client
* PlayFabServerSDK - Contains server and admin APIs designed to be called from your custom logic server or build process
* PlayFabSDK - Contains all APIs in one SDK.
* AndroidStudioExample - Client-only integration of PlayFabSDK into an AndroidStudio example project


4. Installation & Configuration Instructions:
----

The playfab API source code is located within:

    {JavaSDK-Location}/PlayFabSDK/src/playfab

The playfab API relies on the Google gson library, located within:

    {JavaSDK-Location}/PlayFabSDK/src/com

To create a new project using PlayFab, copy the indicated playfab and com directories into the source directory for your project.


5. Using the example project:
----

The PlayFabApiTest example project can be run from the console.  These instructions assume Windows operating system.

* Extract the JavaSDK Sdk to your computer (referenced as {JavaSDK-Location} within this document)
* Navigate to: {JavaSDK-Location}/PlayFabSDK/src
* Open {JavaSDK-Location}/PlayFabSDK/src/RunPfTests.bat in a text editor such as Notepad++ or FlashDevelop (Regular notepad may not load unix line endings properly)
* Update the titleData path in your RunPfTests.bat file:
 * java -DtestTitleData=C:\depot\pf-main\tools\SDKBuildScripts\testTitleData.json ... etc
 * You will need to create a new testTitleData.json file, and change the above path to match your new file (see next section for details)
* Executing RunPfTests.bat should compile the example project, execute the project, make a handful of API calls, and exit
 * This uses the standard JUnit testing suite
 * The exit code for the example will be 0 for success, or non-zero for failure
 * Detailed info about test failures will be in the console output (stdout)


6. testTitleData.json file required for example test files.
----

This sdk includes an optional example project that is used by PlayFab to verify sdk features are fully functional.

Please read about the testTitleData.json format, and purpose here:
* https://github.com/PlayFab/SDKGenerator/blob/master/JenkinsConsoleUtility/testTitleData.md
See the previous section for how to use this file in the example test project.


7. Troubleshooting:
----
For a complete list of available APIs, check out the [online documentation](http://api.playfab.com/Documentation/).

#### Contact Us
We love to hear from our developer community!
Do you have ideas on how we can make our products and services better?

Our Developer Success Team can assist with answering any questions as well as process any feedback you have about PlayFab services.

[Forums, Support and Knowledge Base](https://community.playfab.com/index.html)


8. Acknowlegements
----

The PlayFab Java SDK was initially created and submitted to PlayFab by [nicosio2](https://github.com/nicosio2)

The PlayFab Java SDK has been restructured for Maven support by Will Iverson at [Game Studio One](https://gamestudioone.com/)


9. Copyright and Licensing Information:
----
  Apache License --
  Version 2.0, January 2004
  http://www.apache.org/licenses/

  Full details available within the LICENSE file.

  Initial code Submitted to PlayFab by nicosio2 (https://github.com/nicosio2)
