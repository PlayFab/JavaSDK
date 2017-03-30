package com.playfab.test;

import com.playfab.*;
import com.playfab.debug.PlayFabDebug;
import com.playfab.debug.PlayFabDebugInfoUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.*;

import static com.playfab.PlayFabClientAPI.*;
import static com.playfab.PlayFabClientModels.*;
import static org.junit.Assert.*;

public class PlayFabApiAsyncTest {

    /**
     * How long should a test run before considering it a failure?  Five seconds?
     */
    private static final int TIMEOUT = 5000;

    // Constants
    private static final String TEST_DATA_KEY = "testCounter";
    private static final String TEST_STAT_NAME = "str";

    // Fixed values provided from testInputs
    private static String USER_EMAIL;

    // Cached values
    private static String playFabId = null;

    private UnexpectedFailure unexpectedFailure = new UnexpectedFailure();

    @BeforeClass
    public static void oneTimeSetUp() throws FileNotFoundException {
        USER_EMAIL = PlayFabTestConfig.config().userEmail;
    }

    /**
     * CLIENT API
     * Illustrates use of the debug handler.
     */
    @Test(timeout = TIMEOUT)
    public void invalidLoginDebug() {
        PlayFabDebug playFabDebug = new PlayFabDebug("Debug Test", System.out);

        LoginWithEmailAddressRequest request = new LoginWithEmailAddressRequest();
        request.TitleId = PlayFabSettings.TitleId;
        request.Email = USER_EMAIL;
        request.Password = "INVALID";

        PlayFabService<LoginResult> service = new PlayFabService<>();
        service.start(LoginWithEmailAddressAsync(request));
        service.onFailure(playFabDebug);
        service.onSuccess(playFabDebug);
        service.onLowLevelFailure(playFabDebug);

        while (service.active())
            service.update();
    }

    /**
     * CLIENT API
     * Try to deliberately log in with an inappropriate password,
     * and verify that the error displays as expected.
     */
    @Test(timeout = TIMEOUT)
    public void invalidLogin() {
        LoginWithEmailAddressRequest request = new LoginWithEmailAddressRequest();
        request.TitleId = PlayFabSettings.TitleId;
        request.Email = USER_EMAIL;
        request.Password = "INVALID";

        PlayFabService<LoginResult> service = new PlayFabService<>();
        service.start(LoginWithEmailAddressAsync(request));
        service.onFailure(new PlayFabFailure() {
            @Override
            public void failure(PlayFabErrors.PlayFabError error) {
                String errorMessage = PlayFabDebugInfoUtil.compileErrors(error);
                assertNotNull(errorMessage, error);
            }
        });

        service.onSuccess(new UnexpectedSuccess("Unexpected login success - should have failed!"));
        service.onLowLevelFailure(unexpectedFailure);

        service.onFailure(new PlayFabFailure() {
            @Override
            public void failure(PlayFabErrors.PlayFabError error) {
                assertTrue(error.errorMessage.contains("password"));
            }
        });

        while (service.active())
            service.update();
    }

    /**
     * CLIENT API
     * Try to deliberately register a user with an invalid email and password
     * Verify that errorDetails are populated correctly.
     */
    @Test(timeout = TIMEOUT)
    public void invalidRegistration() {
        RegisterPlayFabUserRequest request = new RegisterPlayFabUserRequest();
        request.TitleId = PlayFabSettings.TitleId;
        request.Username = "x"; // Provide invalid inputs for multiple parameters, which will show up in errorDetails
        request.Email = "x"; // Provide invalid inputs for multiple parameters, which will show up in errorDetails
        request.Password = "x"; // Provide invalid inputs for multiple parameters, which will show up in errorDetails

        PlayFabService<RegisterPlayFabUserResult> service = new PlayFabService<>();

        service.start(RegisterPlayFabUserAsync(request));

        service.onSuccess(new UnexpectedSuccess("Unexpected login success - should have failed!"));
        service.onLowLevelFailure(unexpectedFailure);

        service.onFailure(new PlayFabFailure() {
            @Override
            public void failure(PlayFabErrors.PlayFabError error) {
                String expectedEmailMsg = "email address is not valid.";
                String expectedPasswordMsg = "password must be between";
                String errorDetails = PlayFabDebugInfoUtil.compileErrors(error);
                assertTrue("Expected an error about email: " + errorDetails, errorDetails.toLowerCase().contains(expectedEmailMsg));
                assertTrue("Expected an error about password: " + errorDetails, errorDetails.toLowerCase().contains(expectedPasswordMsg));
            }
        });

        while (service.active())
            service.update();

    }

    /**
     * CLIENT API
     * Log in or create a user, track their PlayFabId
     */
    @Test(timeout = TIMEOUT)

    public void loginOrRegister() {
        LoginWithCustomIDRequest request = new LoginWithCustomIDRequest();
        request.TitleId = PlayFabSettings.TitleId;
        request.CustomId = PlayFabSettings.BuildIdentifier;
        request.CreateAccount = true;

        PlayFabService<LoginResult> service = new PlayFabService<>();
        service.start(LoginWithCustomIDAsync(request));

        PlayFabSuccess<LoginResult> success = new PlayFabSuccess<LoginResult>() {
            @Override
            public void success(LoginResult result) {
                assertNotNull(result.PlayFabId);
                playFabId = result.PlayFabId;
            }
        };

        PlayFabDebug<LoginResult> debugSuccess = new PlayFabDebug<>(success, "Login Or Register Debug", System.out);

        service.onSuccess(debugSuccess);
        service.onFailure(unexpectedFailure);
        service.onLowLevelFailure(unexpectedFailure);

        while (service.active())
            service.update();
    }

    /**
     * CLIENT API
     * Test that the login call sequence sends the AdvertisingId when set
     */
    @Test(timeout = TIMEOUT)

    public void loginWithAdvertisingId() {
        PlayFabSettings.AdvertisingIdType = PlayFabSettings.AD_TYPE_ANDROID_ID;
        PlayFabSettings.AdvertisingIdValue = "PlayFabTestId";

        LoginWithCustomIDRequest request = new LoginWithCustomIDRequest();
        request.TitleId = PlayFabSettings.TitleId;
        request.CustomId = PlayFabSettings.BuildIdentifier;
        request.CreateAccount = true;

        PlayFabService<LoginResult> service = new PlayFabService<>();
        service.start(LoginWithCustomIDAsync(request));
        service.onFailure(unexpectedFailure);
        service.onLowLevelFailure(unexpectedFailure);
        service.sync();

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

        PlayFabService<GetUserDataResult> getUserDataService = new PlayFabService<>();
        getUserDataService.start(GetUserDataAsync(new GetUserDataRequest()));

        getUserDataService.onFailure(unexpectedFailure);
        getUserDataService.onLowLevelFailure(unexpectedFailure);

        GetUserDataResult tempRecord = getUserDataService.sync();

        assertNotNull(tempRecord);
        assertNotNull(tempRecord.Data);
        assertNotNull(tempRecord.Data.get(TEST_DATA_KEY));

        UserDataRecord initialUserDataRecord = tempRecord.Data.get(TEST_DATA_KEY);

        assertNotNull(initialUserDataRecord);

        int testCounterValueExpected = initialUserDataRecord == null ? 0 : Integer.parseInt(initialUserDataRecord.Value);
        testCounterValueExpected = (testCounterValueExpected + 1) % 100; // This test is about the expected value changing - but not testing more complicated issues like bounds

        UpdateUserDataRequest updateRequest = new UpdateUserDataRequest();
        updateRequest.Data = new HashMap<>();
        updateRequest.Data.put(TEST_DATA_KEY, Integer.toString(testCounterValueExpected));

        PlayFabService<UpdateUserDataResult> userDataResultService = new PlayFabService<>();
        userDataResultService.start(UpdateUserDataAsync(updateRequest));

        UpdateUserDataResult updatedUserDataRecord = userDataResultService.sync();
        assertNotNull(updatedUserDataRecord);

        getUserDataService.start(GetUserDataAsync(new GetUserDataRequest()));
        tempRecord = getUserDataService.sync();

        assertNotNull(tempRecord);

        UserDataRecord newUserDataRecord = tempRecord.Data.get(TEST_DATA_KEY);
        assertNotNull(newUserDataRecord);
        assertNotNull(newUserDataRecord.Value);

        assertEquals(testCounterValueExpected, Integer.parseInt(newUserDataRecord.Value));

        assertNotNull(newUserDataRecord.LastUpdated);

        // Generate utc timestamps within 5 minutes of "now"
        //    Date now = new Date();
        //    int utcOffset = Calendar.getInstance().getTimeZone().getRawOffset();
        //    Date utcnow = new Date(now.getTime() - utcOffset);
        //    Date testMin = new Date(utcnow.getTime() - (1000 * 60 * 5));
        //    Date testMax = new Date(utcnow.getTime() + (1000 * 60 * 5));

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

        GetPlayerStatisticsRequest getRequest = new GetPlayerStatisticsRequest();

        PlayFabService<GetPlayerStatisticsResult> statisticsResultPlayFabService = new PlayFabService<>();
        statisticsResultPlayFabService.start(GetPlayerStatisticsAsync(getRequest));

        GetPlayerStatisticsResult getStatsResult = statisticsResultPlayFabService.sync();
        assertNotNull(getStatsResult);

        int testStatExpected = 0;
        for (StatisticValue eachStat : getStatsResult.Statistics)
            if (eachStat.StatisticName.equals(TEST_STAT_NAME))
                testStatExpected = eachStat.Value;
        testStatExpected = (testStatExpected + 1) % 100; // This test is about the expected value changing - but not testing more complicated issues like bounds

        UpdatePlayerStatisticsRequest updateRequest = new UpdatePlayerStatisticsRequest();
        updateRequest.Statistics = new ArrayList<>();
        StatisticUpdate statUpdate = new StatisticUpdate();
        statUpdate.StatisticName = TEST_STAT_NAME;
        statUpdate.Value = testStatExpected;
        updateRequest.Statistics.add(statUpdate);

        PlayFabService<UpdatePlayerStatisticsResult> updatePlayerStatisticsResult = new PlayFabService<>();
        updatePlayerStatisticsResult.start(UpdatePlayerStatisticsAsync(updateRequest));

        UpdatePlayerStatisticsResult updateStatsResult = updatePlayerStatisticsResult.sync();
        assertNotNull(updateStatsResult);

        PlayFabService<GetPlayerStatisticsResult> playerStatisticsResultPlayFabService = new PlayFabService<>();
        playerStatisticsResultPlayFabService.start(GetPlayerStatisticsAsync(getRequest));

        GetPlayerStatisticsResult getPlayerStatisticsResult = playerStatisticsResultPlayFabService.sync();
        assertNotNull(getPlayerStatisticsResult);

        int testStatActual = -1000;
        for (StatisticValue eachStat : getPlayerStatisticsResult.Statistics)
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

        ListUsersCharactersRequest getRequest = new ListUsersCharactersRequest();
        getRequest.PlayFabId = playFabId;

        PlayFabService<ListUsersCharactersResult> service = new PlayFabService<>();
        service.start(GetAllUsersCharactersAsync(new ListUsersCharactersRequest()));

        ListUsersCharactersResult result = service.sync();

        assertNotNull(result);
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

        GetLeaderboardRequest clientRequest = new GetLeaderboardRequest();
        clientRequest.MaxResultsCount = 3;
        clientRequest.StatisticName = TEST_STAT_NAME;

        PlayFabService<GetLeaderboardResult> service = new PlayFabService<>();
        service.start(GetLeaderboardAsync(clientRequest));
        service.onFailure(unexpectedFailure);
        service.onLowLevelFailure(unexpectedFailure);
        service.onSuccess(new PlayFabSuccess<GetLeaderboardResult>() {
            @Override
            public void success(GetLeaderboardResult result) {
                assertTrue(GetClLbCount(result.Leaderboard) > 0);
            }
        });

        while (service.active()) {
            service.update();
        }

    }

    private int GetClLbCount(List<PlayerLeaderboardEntry> lb) {
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

        final GetAccountInfoRequest request = new GetAccountInfoRequest();
        request.PlayFabId = playFabId;

        PlayFabService<GetAccountInfoResult> service = new PlayFabService<>();
        service.start(GetAccountInfoAsync(request));
        service.onFailure(unexpectedFailure);
        service.onLowLevelFailure(unexpectedFailure);
        service.onSuccess(new PlayFabSuccess<GetAccountInfoResult>() {
            @Override
            public void success(GetAccountInfoResult result) {
                assertNotNull(result);
                assertNotNull(result.AccountInfo);
                assertNotNull(result.AccountInfo.TitleInfo);
                UserOrigination origin = result.AccountInfo.TitleInfo.Origination;
                Boolean validOption = Arrays.asList(UserOrigination.values()).contains(origin);
                assertTrue(validOption);
            }
        });


        while (service.active())
            service.update();
    }

    /**
     * CLIENT API
     * Test that CloudScript can be properly set up and invoked
     */
    @Test(timeout = TIMEOUT)

    public void CloudScript() {
        loginOrRegister();

        ExecuteCloudScriptRequest hwRequest = new ExecuteCloudScriptRequest();
        hwRequest.FunctionName = "helloWorld";

        PlayFabService<ExecuteCloudScriptResult> service = new PlayFabService<>();
        service.start(ExecuteCloudScriptAsync(hwRequest));
        service.onFailure(unexpectedFailure);
        service.onLowLevelFailure(unexpectedFailure);
        service.onSuccess(new PlayFabSuccess<ExecuteCloudScriptResult>() {
            @Override
            public void success(ExecuteCloudScriptResult result) {
                assertNotNull(result);
                assertNotNull(result.FunctionResult);
                Map<String, String> arbitraryResults = (Map<String, String>) result.FunctionResult;
                assertEquals(arbitraryResults.get("messageValue"), "Hello " + playFabId + "!");

            }
        });

        while (service.active())
            service.update();
    }

    /**
     * CLIENT API
     * Test that CloudScript errors can be deciphered
     */
    @Test(timeout = TIMEOUT)
    public void CloudScriptError() {
        loginOrRegister();

        ExecuteCloudScriptRequest errRequest = new ExecuteCloudScriptRequest();
        errRequest.FunctionName = "throwError";

        PlayFabService<ExecuteCloudScriptResult> service = new PlayFabService<>();
        service.onLowLevelFailure(unexpectedFailure);
        service.onFailure(unexpectedFailure);
        service.start(ExecuteCloudScriptAsync(errRequest));
        service.onSuccess(
                new PlayFabSuccess<ExecuteCloudScriptResult>() {
                    @Override
                    public void success(ExecuteCloudScriptResult result) {
                        assertNotNull(result);
                        assertEquals(result.Error.Error, "JavascriptException");
                    }
                }
        );


        while (service.active())
            service.update();

    }

    /**
     * CLIENT API
     * Test that the client can publish custom PlayStream events
     */
    @Test(timeout = TIMEOUT)
    public void WriteEvent() {
        loginOrRegister();

        WriteClientPlayerEventRequest request = new WriteClientPlayerEventRequest();
        request.EventName = "ForumPostEvent";
        request.Timestamp = new Date();
        request.Body = new HashMap<String, Object>();
        request.Body.put("Subject", "My First Post");
        request.Body.put("Body", "My awesome post.");

        PlayFabService<WriteEventResponse> service = new PlayFabService<>();

        service.start(WritePlayerEventAsync(request));

        assertNotNull(service.sync());
    }

    /**
     * Throws an exception if the success callback was not expected
     */
    private static class UnexpectedSuccess implements PlayFabSuccess {

        private String message;

        public UnexpectedSuccess(String message) {
            this.message = message;
        }

        @Override
        public void success(Object result) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * Throws an exception if the failure callback was not expected
     */
    private class UnexpectedFailure implements PlayFabFailure, PlayFabLowLevelFailure {
        @Override
        public void failure(PlayFabErrors.PlayFabError error) {
            throw new IllegalStateException(PlayFabDebugInfoUtil.compileErrors(error));
        }

        @Override
        public boolean failure(Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

