Java Getting Started Guide
----

This guide will help you make your first API call in Java.

Java Project Setup
----

* OS: This guide is written for Windows 10, however it should also work fine with a Mac
* Installation
  * Download and install the latest JDK
    * http://www.oracle.com/technetwork/java/javase/downloads/index.html
  * Download the PlayFab JavaSDK
    * https://api.playfab.com/sdks/download/java
    * Download the zip file, and extract it to a location of your choice {PlayFabJavaLocation}
* New Project Setup
  * Create a new empty folder for your JavaGettingStarted project
    * Create a new empty text file called GettingStarted.java
      * We will modify this file in the next section
  * Import the PlayFab JavaSDK into this project
    * In Windows-Explorer, navigate to {PlayFabJavaLocation}/PlayFabClientSDK/src
    * Select everything in this folder (1 subfolder, and 2 jar files)
    * Copy it to your project folder
* Your project folder should look like this:
  * ![Java image](/images/Java/Installed.png)
* PlayFab Installation Complete!

Set up your first API call
----

This guide will provide the minimum steps to make your first PlayFab API call. Confirmation will be visible as console-output text.

In your favorite text-editor, update the contents of GettingStarted.java as follows:
```Java
import java.util.concurrent.*;
import java.util.*;

import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import com.playfab.PlayFabClientModels;
import com.playfab.PlayFabClientAPI;

public class GettingStarted
{
    private static boolean _running = true;

    public static void main(String[] args) {
        PlayFabSettings.TitleId = "144";

        PlayFabClientModels.LoginWithCustomIDRequest request = new PlayFabClientModels.LoginWithCustomIDRequest();
        request.CustomId = "GettingStartedGuide";
        request.CreateAccount = true;

        FutureTask<PlayFabResult<com.playfab.PlayFabClientModels.LoginResult>> loginTask = PlayFabClientAPI.LoginWithCustomIDAsync(request);
        loginTask.run();

        while (_running) {
            if (loginTask.isDone()) { // You would probably want a more sophisticated way of tracking pending async API calls in a real game
                OnLoginComplete(loginTask);
            }

            // Presumably this would be your main game loop, doing other things
            try {
                Thread.sleep(1);
            } catch(Exception e) {
                System.out.println("Critical error in the example main loop: " + e);
            }
        }
    }

    private static void OnLoginComplete(FutureTask<PlayFabResult<com.playfab.PlayFabClientModels.LoginResult>> loginTask) {
        PlayFabResult<com.playfab.PlayFabClientModels.LoginResult> result = null;
        try {
            result = loginTask.get(); // Wait for the result from the async call
        } catch(Exception e) {
            System.out.println("Exception in PlayFab api call: " + e); // Did you assign your PlayFabSettings.TitleId correctly?
        }

        if (result != null && result.Result != null) {
            System.out.println("Congratulations, you made your first successful API call!");
        } else if (result != null && result.Error != null) {
            System.out.println("Something went wrong with your first API call.");
            System.out.println("Here's some debug information:");
            System.out.println(CompileErrorsFromResult(result));
        }

        _running = false; // Because this is just an example, successful login triggers the end of the program
    }

    // This is a utility function we haven't put into the core SDK yet.  Feel free to use it.
    private static <RT> String CompileErrorsFromResult(PlayFabResult<RT> result) {
        if (result == null || result.Error == null)
            return null;

        String errorMessage = "";
        if (result.Error.errorMessage != null)
            errorMessage += result.Error.errorMessage;
        if (result.Error.errorDetails != null)
            for (Map.Entry<String, List<String>> pair : result.Error.errorDetails.entrySet() )
                for (String msg : pair.getValue())
                    errorMessage += "\n" + pair.getKey() + ": " + msg;
        return errorMessage;
    }
}
```

* Open a command window in your project folder:
  * Hold shift and right click in the empty-white-space of the Explorer window
  * ![Java image](/images/Java/CmdExe.png)
  * We will use this window in the next section to execute our program

Finish and Execute
----

* In the command window, enter the following sequence of commands:
  * javac GettingStarted.java
    * If successful, this should finish with no output
  * Java -cp . GettingStarted
    * If successful, you should see the following text:
      * Congratulations, you made your first successful API call!
* At this point, you can start making other api calls, and building your game
* For a list of all available client API calls, see our documentation:
  * https://api.playfab.com/
* Happy coding!

Deconstruct the code
----

This optional last section describes every line in GettingStarted.java in detail.

* imports
  * This is the minimal set of imports used to make PlayFab API calls
* public static void main(String[] args) {
  * Just a basic loop that kicks off an API call, and waits for it to complete
  * PlayFabSettings.TitleId = "xxxx";
    * Every PlayFab developer creates a title in Game Manager. When you publish your game, you must code that titleId into your game. This lets the client know how to access the correct data within PlayFab. For most users, just consider it a mandatory step that makes PlayFab work.
  * PlayFabClientModels.LoginWithCustomIDRequest request = new PlayFabClientModels.LoginWithCustomIDRequest();
    * Most PlayFab API methods require input parameters, and those input parameters are packed into a request object
    * Every API method requires a unique request object, with a mix of optional and mandatory parameters
      * For LoginWithCustomIDRequest, there is a mandatory parameter of CustomId, which uniquely identifies a player and CreateAccount, which allows the creation of a new account with this call.
    * For login, most developers will want to use a more appropriate login method
      * See the PlayFab Login Documentation for a list of all login methods, and input parameters. Common choices are:
        * LoginWithAndroidDeviceID
        * LoginWithIOSDeviceID
        * LoginWithEmailAddress
  * FutureTask&lt;PlayFabResult&lt;com.playfab.PlayFabClientModels.LoginResult>> loginTask = PlayFabClientAPI.LoginWithCustomIDAsync(request);
    * This begins the async request to "LoginWithCustomID", using the Java FutureTask framework
  * while (running) { if (loginTask.isDone()) { OnLoginComplete(loginTask); } }
    * Run a trivial main loop and asynchronously wait for the loginTask to complete
    * When finished call OnLoginComplete
* OnLoginComplete(loginTask)
  * result = loginTask.get();
    * Fetch the async result (this won't cause a block, because we confirmed the FutureTask is already complete
  * if (result.Result != null), the API call is successful
    * When successful, result.Result object of many API callbacks will contain the requested information
    * LoginResult specifically contains some basic information about the player, but for most users, login is simply a mandatory step before calling other APIs.
  * if (result.Error != null), the API call has failed
    * API calls can fail for many reasons, and you should always attempt to handle failure
    * Why API calls fail (In order of likelihood)
      * PlayFabSettings.TitleId is not set.  If you forget to set titleId to your title, then nothing will work.
      * Request parameters.  If you have not provided the correct or required information for a particular API call, then it will fail.  See error.errorMessage, error.errorDetails, or error.GenerateErrorReport() for more info.
      * Device connectivity issue.  Cell-phones lose/regain connectivity constantly, and so any API call at any time can fail randomly, and then work immediately after.  Going into a tunnel can disconnect you completely.
      * PlayFab server issue.   As with all software, there can be issues.  See our [release notes](https://api.playfab.com/releaseNotes/) for updates.
      * The internet is not 100% reliable.  Sometimes the message is corrupted or fails to reach the PlayFab server.
    * If you are having difficulty debugging an issue, and the information within the error callback is not sufficient, please visit us on our [forums](https://community.playfab.com/index.html)
