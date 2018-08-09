package com.playfab.test;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;
import java.io.*;
import java.util.Properties;

import com.google.gson.*;
import com.google.gson.reflect.*;

import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;

import com.playfab.PlayFabServerModels;
import com.playfab.PlayFabServerAPI;

import com.playfab.PlayFabAuthenticationModels;
import com.playfab.PlayFabAuthenticationAPI;
import com.playfab.PlayFabDataModels;
import com.playfab.PlayFabDataAPI;

public class PlayFabApiTest
{
    // Constants
    private static final String TEST_DATA_KEY = "testCounter";
    private static final String TEST_STAT_NAME = "str";

    // Fixed values provided from testInputs
    private static String USER_EMAIL;

    // Cached values
    private static String playFabId = "1337D00D"; // This is not a valid player id, but Cloud Script doesn't care unless that id is used by the Cloud Script handler.

    // Helpers
    private <RT> void VerifyResult(PlayFabResult<RT> result, boolean expectSuccess)
    {
        assertNotNull(result);
        String errorMessage = CompileErrorsFromResult(result);
        if (expectSuccess)
        {
            assertNull(errorMessage, result.Error);
            assertNotNull(errorMessage, result.Result);
        }
        else
        {
            assertNull(errorMessage, result.Result);
            assertNotNull(errorMessage, result.Error);
        }
    }

    private <RT> String CompileErrorsFromResult(PlayFabResult<RT> result)
    {
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

    private class TitleData
    {
        public String titleId;
        public String developerSecretKey;
        public String userEmail;
    }

    @BeforeClass
    public static void oneTimeSetUp() {
        Map<String, String> env = System.getenv();
        String testTitleDataFile = env.get("PF_TEST_TITLE_DATA_JSON"); // Set the PF_TEST_TITLE_DATA_JSON env-var to the path of a testTitleData.json file (described here: https://github.com/PlayFab/SDKGenerator/blob/master/JenkinsConsoleUtility/testTitleData.md)
        String testTitleJson;
        try {
            File file = new File(testTitleDataFile);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            testTitleJson = new String(data);
        } catch (IOException e) {
            // NOTE: Un-Comment and put your title-specific information here to test your title, or use PF_TEST_TITLE_DATA_JSON above
            //PlayFabSettings.TitleId = "TODO: TitleID";
            //PlayFabSettings.DeveloperSecretKey = "TODO: A big long secret key that you should NEVER publish with your client";
            //USER_EMAIL = "TODO: an email associated with an existing account on your title";
            return;
        }
        Gson gson = new GsonBuilder().create();
        TitleData resultData = gson.fromJson(testTitleJson, new TypeToken<TitleData>(){}.getType());
        PlayFabSettings.TitleId = resultData.titleId;
        USER_EMAIL = resultData.userEmail;
        PlayFabSettings.DeveloperSecretKey = resultData.developerSecretKey;
    }

    /**
     *  SERVER API
     *  Get or create the given test character for the given user
     *  Parameter types tested: Contained-Classes, string
     */
    @Test
    public void UserCharacterServer()
    {
        PlayFabServerModels.ListUsersCharactersRequest getRequest = new PlayFabServerModels.ListUsersCharactersRequest();
        getRequest.PlayFabId = playFabId;
        PlayFabResult<PlayFabServerModels.ListUsersCharactersResult> getCharsResult = PlayFabServerAPI.GetAllUsersCharacters(getRequest);
        VerifyResult(getCharsResult, true);
    }

    /**
     *  SERVER API
     *  Test that leaderboard results can be requested
     *  Parameter types tested: List of contained-classes
     */
    @Test
    public void LeaderBoardServer()
    {
        PlayFabServerModels.GetLeaderboardRequest serverRequest = new PlayFabServerModels.GetLeaderboardRequest();
        serverRequest.MaxResultsCount = 3;
        serverRequest.StatisticName = TEST_STAT_NAME;
        PlayFabResult<PlayFabServerModels.GetLeaderboardResult> serverResult = PlayFabServerAPI.GetLeaderboard(serverRequest);
        VerifyResult(serverResult, true);
        assertTrue(GetSvLbCount(serverResult.Result.Leaderboard) > 0);
    }
    private int GetSvLbCount(List<PlayFabServerModels.PlayerLeaderboardEntry> lb)
    {
        int count = 0;
        if (lb != null)
            count = lb.size();
        return count;
    }

    /*
     *  SERVER API
     *  Test that CloudScript can be properly set up and invoked
     */
    @Test
    public void CloudScriptServer()
    {
        PlayFabServerModels.ExecuteCloudScriptServerRequest hwRequest = new PlayFabServerModels.ExecuteCloudScriptServerRequest();
        hwRequest.FunctionName = "helloWorld";
        hwRequest.PlayFabId = playFabId;
        PlayFabResult<PlayFabServerModels.ExecuteCloudScriptResult> hwResult = PlayFabServerAPI.ExecuteCloudScript(hwRequest);
        VerifyResult(hwResult, true);
        assertNotNull(hwResult.Result.FunctionResult);
        Map<String, String> arbitraryResults = (Map<String, String>)hwResult.Result.FunctionResult;
        assertEquals(arbitraryResults.get("messageValue"), "Hello " + playFabId + "!");
    }

    /*
     *  SERVER API
     *  Test that CloudScript errors can be deciphered
     */
    @Test
    public void CloudScriptErrorServer()
    {
        PlayFabServerModels.ExecuteCloudScriptServerRequest errRequest = new PlayFabServerModels.ExecuteCloudScriptServerRequest();
        errRequest.FunctionName = "throwError";
        errRequest.PlayFabId = playFabId;
        PlayFabResult<PlayFabServerModels.ExecuteCloudScriptResult> errResult = PlayFabServerAPI.ExecuteCloudScript(errRequest);
        VerifyResult(errResult, true);
        assertTrue(errResult.Result.FunctionResult == null);
        assertNotNull(errResult.Result.Error);
        assertEquals(errResult.Result.Error.Error, "JavascriptException");
    }
}
