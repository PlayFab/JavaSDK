# Java SDK for PlayFab README

## 0. Install via Maven or Gradle:

Check the [Maven Central Repository](https://search.maven.org/#search%7Cga%7C1%7Ccom.playfab) for latest versions of our SDKs.  
When using **Maven**, use the following snippet as part of your dependencies set:  
(Use `client-sdk` or `server-sdk` or `combo-sdk` as ARTIFACT)  

```
<dependency>
    <groupId>com.playfab</groupId>
    <artifactId>ARTIFACT</artifactId>
    <version>VERSION</version>
</dependency>
```

When using **Gradle**, make sure Maven Central Repository is linked:  

```
repositories {
    mavenCentral()
}
```

Use the following snippet to add `client-sdk` or `server-sdk` or `combo-sdk` to your dependencies set:  

```
dependencies {
    compile('com.playfab.client-sdk:VERSION')
    compile('com.playfab.server-sdk:VERSION')
    compile('com.playfab.combo-sdk:VERSION')
}
```

## 1. Overview:

This document describes the process of configuring and building the PlayFab Java SDK.


## 2. Prerequisites:

* Users should be very familiar with the topics covered in our [getting started guide](https://api.playfab.com/docs/general-getting-started).

To connect to the PlayFab service, your machine must be running TLS v1.2 or better.
* For Windows, this means Windows 7 and above
* [Official Microsoft Documentation](https://msdn.microsoft.com/en-us/library/windows/desktop/aa380516%28v=vs.85%29.aspx)
* [Support for SSL/TLS protocols on Windows](http://blogs.msdn.com/b/kaushal/archive/2011/10/02/support-for-ssl-tls-protocols-on-windows.aspx)


## 3. Source Code & Key Repository Components:

This package contains three different versions of the PlayFab SDK.
* PlayFabClientSDK - This version contains only client libraries and is designed for integration with your game client
* PlayFabServerSDK - Contains server and admin APIs designed to be called from your custom logic server or build process
* PlayFabSDK - Contains all APIs in one SDK.
* AndroidStudioExample - Client-only integration of PlayFabSDK into an AndroidStudio example project


## 4. Installation & Configuration Instructions:

The playfab API source code is located within one of the following:

* Client: https://github.com/PlayFab/JavaSDK/tree/master/PlayFabClientSDK/src/main/java/com/playfab
* Server: https://github.com/PlayFab/JavaSDK/tree/master/PlayFabServerSDK/src/main/java/com/playfab
* Combo: https://github.com/PlayFab/JavaSDK/tree/master/PlayFabSDK/src/main/java/com/playfab

The playfab API relies on the Google gson library.  The dependency is described in each pom.xml file, Example:

* Client: https://github.com/PlayFab/JavaSDK/blob/master/PlayFabClientSDK/pom.xml#L48
* Server: https://github.com/PlayFab/JavaSDK/blob/master/PlayFabServerSDK/pom.xml#L48
* Combo: https://github.com/PlayFab/JavaSDK/blob/master/PlayFabSDK/pom.xml#L48

PlayFab does not submit this SDK to the Maven Central repository. For now, you must copy/paste the appropriate /src/main/java/com/playfab/ subfolder from one of the root folders (PlayFabClientSDK, PlayFabSDK, PlayFabSDK), and paste it into your project. We hope to improve this later, but there is no ETA for completion.


## 5. testTitleData.json file required for example test files:

This sdk includes an optional example project that is used by PlayFab to verify sdk features are fully functional.

Please read about the testTitleData.json format, and purpose here:
* https://github.com/PlayFab/SDKGenerator/blob/master/JenkinsConsoleUtility/testTitleData.md
You must create a testTitleData.json file according to these instructions, and create an environment variable PF_TEST_TITLE_DATA_JSON which contains the absolute path to this file.


### Building and testing with Maven:

The Example PlayFabApiTests can be run from the console.  These instructions assume Windows operating system.

* Install [Apache Maven](https://maven.apache.org/download.cgi)
* Extract the JavaSDK Sdk to your computer (referenced as {JavaSDK-Location} within this document)
* Navigate to: {JavaSDK-Location}/PlayFabSDK
* Open a command prompt, and enter "mvn site verify"
  * This will build the project, execute tests, build documentation, and verify the package


## 6. Troubleshooting:

For a complete list of available APIs, check out the [online documentation](http://api.playfab.com/Documentation/).

#### Contact Us
We love to hear from our developer community!
Do you have ideas on how we can make our products and services better?

Our Developer Success Team can assist with answering any questions as well as process any feedback you have about PlayFab services.

[Forums, Support and Knowledge Base](https://community.playfab.com/index.html)


## 7. Acknowlegements

The PlayFab Java SDK was initially created and submitted to PlayFab by [nicosio2](https://github.com/nicosio2)

The PlayFab Java SDK has been restructured for Maven support by Will Iverson at [Game Studio One](https://gamestudioone.com/)


## 8. Copyright and Licensing Information:

Apache License --
Version 2.0, January 2004
http://www.apache.org/licenses/

Full details available within the LICENSE file.
