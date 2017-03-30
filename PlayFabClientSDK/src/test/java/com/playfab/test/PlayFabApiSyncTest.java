package com.playfab.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.playfab.PlayFabClientAPI;
import com.playfab.PlayFabClientModels;
import com.playfab.PlayFabErrors.PlayFabResult;
import com.playfab.PlayFabSettings;
import com.playfab.debug.PlayFabDebugInfoUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.*;

public class PlayFabApiSyncTest {

    /**
     * How long should a test run before considering it a failure?
     */
    private static final int TIMEOUT = 5000;
    // Constants
    private static final String TEST_DATA_KEY = "testCounter";
    private static final String TEST_STAT_NAME = "str";

    // Fixed values provided from testInputs
    private static String USER_EMAIL;

    // Cached values
    private static String playFabId = null;

    @BeforeClass
    public static void oneTimeSetUp() throws FileNotFoundException {
        USER_EMAIL = PlayFabTestConfig.config().userEmail;
    }

    // Helpers
    private <RT> void verifyResult(PlayFabResult<RT> result, boolean expectSuccess) {
        assertNotNull(result);
        String errorMessage = PlayFabDebugInfoUtil.compileErrorsFromResult(result);
        if (expectSuccess) {
            assertNull(errorMessage, result.Error);
            assertNotNull(errorMessage, result.Result);
        } else {
            assertNull(errorMessage, result.Result);
            assertNotNull(errorMessage, result.Error);
        }
    }

    /**
     * CLIENT API
     * Try to deliberately log in with an inappropriate password,
     * and verify that the error displays as expected.
     */
    @Test(timeout = TIMEOUT)
    public void invalidLogin() {
        PlayFabClientModels.LoginWithEmailAddressRequest request = new PlayFabClientModels.LoginWithEmailAddressRequest();
        request.TitleId = PlayFabSettings.TitleId;
        request.Email = USER_EMAIL;
        request.Password = "INVALID";

        PlayFabResult<PlayFabClientModels.LoginResult> result = PlayFabClientAPI.LoginWithEmailAddress(request);
        verifyResult(result, false);
        assertTrue(result.Error.errorMessage.contains("password"));
    }

    /**
     * CLIENT API
     * Try to deliberately register a user with an invalid email and password
     * Verify that errorDetails are populated correctly.
     */
    @Test(timeout = TIMEOUT)
    public void invalidRegistration() {
        PlayFabClientModels.RegisterPlayFabUserRequest request = new PlayFabClientModels.RegisterPlayFabUserRequest();
        request.TitleId = PlayFabSettings.TitleId;
        request.Username = "x"; // Provide invalid inputs for multiple parameters, which will show up in errorDetails
        request.Email = "x"; // Provide invalid inputs for multiple parameters, which will show up in errorDetails
        request.Password = "x"; // Provide invalid inputs for multiple parameters, which will show up in errorDetails

        PlayFabResult<PlayFabClientModels.RegisterPlayFabUserResult> result = PlayFabClientAPI.RegisterPlayFabUser(request);
        verifyResult(result, false);

        String expectedEmailMsg = "email address is not valid.";
        String expectedPasswordMsg = "password must be between";
        String errorDetails = PlayFabDebugInfoUtil.compileErrorsFromResult(result);
        assertTrue("Expected an error about email: " + errorDetails, errorDetails.toLowerCase().contains(expectedEmailMsg));
        assertTrue("Expected an error about password: " + errorDetails, errorDetails.toLowerCase().contains(expectedPasswordMsg));
    }

    /**
     * CLIENT API
     * Log in or create a user, track their PlayFabId
     */
    @Test(timeout = TIMEOUT)
    public void loginOrRegister() {
        PlayFabClientModels.LoginWithCustomIDRequest request = new PlayFabClientModels.LoginWithCustomIDRequest();
        request.TitleId = PlayFabSettings.TitleId;
        request.CustomId = PlayFabSettings.BuildIdentifier;
        request.CreateAccount = true;

        PlayFabResult<PlayFabClientModels.LoginResult> result = PlayFabClientAPI.LoginWithCustomID(request);
        verifyResult(result, true);
        assertNotNull(result.Result.PlayFabId);
        playFabId = result.Result.PlayFabId;
    }

    /**
     * CLIENT API
     * Test that the login call sequence sends the AdvertisingId when set
     */
    @Test(timeout = TIMEOUT)
    public void loginWithAdvertisingId() {
        PlayFabSettings.AdvertisingIdType = PlayFabSettings.AD_TYPE_ANDROID_ID;
        PlayFabSettings.AdvertisingIdValue = "PlayFabTestId";

        PlayFabClientModels.LoginWithCustomIDRequest request = new PlayFabClientModels.LoginWithCustomIDRequest();
        request.TitleId = PlayFabSettings.TitleId;
        request.CustomId = PlayFabSettings.BuildIdentifier;
        request.CreateAccount = true;
        PlayFabResult<PlayFabClientModels.LoginResult> result = PlayFabClientAPI.LoginWithCustomID(request);

        assertEquals(PlayFabSettings.AD_TYPE_ANDROID_ID + "_Successful", PlayFabSettings.AdvertisingIdType);
    }

    /**
     * CLIENT API
     * Test a sequence of calls that modifies saved data,
     * and verifies that the next sequential API call contains updated data.
     * Verify that the data is correctly modified on the next call.
     * Parameter types tested: string, Dictionary<string, string>, DateTime
     */
    @Test(timeout = TIMEOUT)
    public void userDataApi() {
        loginOrRegister();

        PlayFabClientModels.GetUserDataRequest getRequest = new PlayFabClientModels.GetUserDataRequest();
        PlayFabResult<PlayFabClientModels.GetUserDataResult> getDataResult = PlayFabClientAPI.GetUserData(getRequest);
        verifyResult(getDataResult, true);
        PlayFabClientModels.UserDataRecord tempRecord = getDataResult.Result.Data == null ? null : getDataResult.Result.Data.get(TEST_DATA_KEY);
        int testCounterValueExpected = tempRecord == null ? 0 : Integer.parseInt(tempRecord.Value);
        testCounterValueExpected = (testCounterValueExpected + 1) % 100; // This test is about the expected value changing - but not testing more complicated issues like bounds

        PlayFabClientModels.UpdateUserDataRequest updateRequest = new PlayFabClientModels.UpdateUserDataRequest();
        updateRequest.Data = new HashMap<String, String>();
        updateRequest.Data.put(TEST_DATA_KEY, Integer.toString(testCounterValueExpected));
        PlayFabResult<PlayFabClientModels.UpdateUserDataResult> updateDataResult = PlayFabClientAPI.UpdateUserData(updateRequest);
        verifyResult(updateDataResult, true);

        getDataResult = PlayFabClientAPI.GetUserData(getRequest);
        verifyResult(getDataResult, true);
        tempRecord = getDataResult.Result.Data.get(TEST_DATA_KEY);
        int testCounterValueActual = tempRecord == null ? 0 : Integer.parseInt(tempRecord.Value);
        assertEquals(testCounterValueExpected, testCounterValueActual);

        // Get the UTC timestamp for when the record was updated
        Date timeUpdated = tempRecord.LastUpdated;

        // Generate utc timestamps within 5 minutes of "now"
        Date now = new Date();
        int utcOffset = Calendar.getInstance().getTimeZone().getRawOffset();
        Date utcnow = new Date(now.getTime() - utcOffset);
        Date testMin = new Date(utcnow.getTime() - (1000 * 60 * 5));
        Date testMax = new Date(utcnow.getTime() + (1000 * 60 * 5));

        // Verify that the update time is sufficiently close to now
        // TODO: This is not correct now that we're in daylight savings - FIX!!!
        // assertTrue("Update time does not match: " + timeUpdated + " != " + utcnow, testMin.before(timeUpdated) && timeUpdated.before(testMax));
    }

    /**
     * CLIENT API
     * Test a sequence of calls that modifies saved data,
     * and verifies that the next sequential API call contains updated data.
     * Verify that the data is saved correctly, and that specific types are tested
     * Parameter types tested: Dictionary<string, int>
     */
    @Test(timeout = TIMEOUT)
    public void PlayerStatisticsApi() {
        loginOrRegister();
        Gson gson = new GsonBuilder().create();

        PlayFabClientModels.GetPlayerStatisticsRequest getRequest = new PlayFabClientModels.GetPlayerStatisticsRequest();
        PlayFabResult<PlayFabClientModels.GetPlayerStatisticsResult> getStatsResult1 = PlayFabClientAPI.GetPlayerStatistics(getRequest);
        verifyResult(getStatsResult1, true);
        int testStatExpected = 0;
        for (PlayFabClientModels.StatisticValue eachStat : getStatsResult1.Result.Statistics)
            if (eachStat.StatisticName.equals(TEST_STAT_NAME))
                testStatExpected = eachStat.Value;
        testStatExpected = (testStatExpected + 1) % 100; // This test is about the expected value changing - but not testing more complicated issues like bounds

        PlayFabClientModels.UpdatePlayerStatisticsRequest updateRequest = new PlayFabClientModels.UpdatePlayerStatisticsRequest();
        updateRequest.Statistics = new ArrayList<PlayFabClientModels.StatisticUpdate>();
        PlayFabClientModels.StatisticUpdate statUpdate = new PlayFabClientModels.StatisticUpdate();
        statUpdate.StatisticName = TEST_STAT_NAME;
        statUpdate.Value = testStatExpected;
        updateRequest.Statistics.add(statUpdate);
        PlayFabResult<PlayFabClientModels.UpdatePlayerStatisticsResult> updateStatsResult = PlayFabClientAPI.UpdatePlayerStatistics(updateRequest);
        verifyResult(updateStatsResult, true);

        PlayFabResult<PlayFabClientModels.GetPlayerStatisticsResult> getStatsResult2 = PlayFabClientAPI.GetPlayerStatistics(getRequest);
        verifyResult(getStatsResult2, true);
        int testStatActual = -1000;
        for (PlayFabClientModels.StatisticValue eachStat : getStatsResult2.Result.Statistics)
            if (eachStat.StatisticName.equals(TEST_STAT_NAME))
                testStatActual = eachStat.Value;
        assertTrue(String.format("Stat not found: %d, Actual: %d", testStatExpected, testStatActual), testStatActual != -1000);
        assertEquals(String.format("Stats were not updated.  Expected: %d, Actual: %d", testStatExpected, testStatActual), testStatExpected, testStatActual);
    }

    /**
     * CLIENT API
     * Get or create the given test character for the given user
     * Parameter types tested: Contained-Classes, string
     */
    @Test(timeout = TIMEOUT)
    public void UserCharacter() {
        loginOrRegister();

        PlayFabClientModels.ListUsersCharactersRequest getRequest = new PlayFabClientModels.ListUsersCharactersRequest();
        getRequest.PlayFabId = playFabId;
        PlayFabResult<PlayFabClientModels.ListUsersCharactersResult> getCharsResult = PlayFabClientAPI.GetAllUsersCharacters(getRequest);
        verifyResult(getCharsResult, true);
    }

    /**
     * CLIENT API
     * Test that leaderboard results can be requested
     * Parameter types tested: List of contained-classes
     */
    @Test(timeout = TIMEOUT)
    public void LeaderBoard() {
        loginOrRegister();
        PlayerStatisticsApi();

        PlayFabClientModels.GetLeaderboardRequest clientRequest = new PlayFabClientModels.GetLeaderboardRequest();
        clientRequest.MaxResultsCount = 3;
        clientRequest.StatisticName = TEST_STAT_NAME;
        PlayFabResult<PlayFabClientModels.GetLeaderboardResult> clientResult = PlayFabClientAPI.GetLeaderboard(clientRequest);
        verifyResult(clientResult, true);
        assertTrue(GetClLbCount(clientResult.Result.Leaderboard) > 0);
    }

    private int GetClLbCount(List<PlayFabClientModels.PlayerLeaderboardEntry> lb) {
        int count = 0;
        if (lb != null)
            count = lb.size();
        return count;
    }

    /**
     * CLIENT API
     * Test that AccountInfo can be requested
     * Parameter types tested: List of enum-as-strings converted to list of enums
     */
    @Test(timeout = TIMEOUT)
    public void AccountInfo() {
        loginOrRegister();

        PlayFabClientModels.GetAccountInfoRequest request = new PlayFabClientModels.GetAccountInfoRequest();
        request.PlayFabId = playFabId;
        PlayFabResult<PlayFabClientModels.GetAccountInfoResult> result = PlayFabClientAPI.GetAccountInfo(request);
        verifyResult(result, true);
        assertNotNull(result.Result.AccountInfo);
        assertNotNull(result.Result.AccountInfo.TitleInfo);
        PlayFabClientModels.UserOrigination origin = result.Result.AccountInfo.TitleInfo.Origination;
        Boolean validOption = Arrays.asList(PlayFabClientModels.UserOrigination.values()).contains(origin);
        assertTrue(validOption);
    }

    /**
     * CLIENT API
     * Test that CloudScript can be properly set up and invoked
     */
    @Test(timeout = TIMEOUT)
    public void CloudScript() {
        loginOrRegister();

        PlayFabClientModels.ExecuteCloudScriptRequest hwRequest = new PlayFabClientModels.ExecuteCloudScriptRequest();
        hwRequest.FunctionName = "helloWorld";
        PlayFabResult<PlayFabClientModels.ExecuteCloudScriptResult> hwResult = PlayFabClientAPI.ExecuteCloudScript(hwRequest);
        verifyResult(hwResult, true);
        assertNotNull(hwResult.Result.FunctionResult);
        Map<String, String> arbitraryResults = (Map<String, String>) hwResult.Result.FunctionResult;
        assertEquals(arbitraryResults.get("messageValue"), "Hello " + playFabId + "!");
    }

    /**
     * CLIENT API
     * Test that CloudScript errors can be deciphered
     */
    @Test(timeout = TIMEOUT)
    public void CloudScriptError() {
        loginOrRegister();

        PlayFabClientModels.ExecuteCloudScriptRequest errRequest = new PlayFabClientModels.ExecuteCloudScriptRequest();
        errRequest.FunctionName = "throwError";
        PlayFabResult<PlayFabClientModels.ExecuteCloudScriptResult> errResult = PlayFabClientAPI.ExecuteCloudScript(errRequest);
        verifyResult(errResult, true);
        assertTrue(errResult.Result.FunctionResult == null);
        assertNotNull(errResult.Result.Error);
        assertEquals(errResult.Result.Error.Error, "JavascriptException");
    }

    /**
     * CLIENT API
     * Test that the client can publish custom PlayStream events
     */
    @Test(timeout = TIMEOUT)
    public void WriteEvent() {
        loginOrRegister();

        PlayFabClientModels.WriteClientPlayerEventRequest request = new PlayFabClientModels.WriteClientPlayerEventRequest();
        request.EventName = "ForumPostEvent";
        request.Timestamp = new Date();
        request.Body = new HashMap<String, Object>();
        request.Body.put("Subject", "My First Post");
        request.Body.put("Body", "My awesome post.");
        PlayFabResult<PlayFabClientModels.WriteEventResponse> result = PlayFabClientAPI.WritePlayerEvent(request);
        verifyResult(result, true);
    }
}

