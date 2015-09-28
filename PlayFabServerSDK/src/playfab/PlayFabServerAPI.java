package playfab;

import playfab.internal.*;
import playfab.PlayFabServerModels.*;
import playfab.PlayFabErrors.*;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;


/**
 * Provides functionality to allow external (developer-controlled) servers to interact with user inventories and data in a trusted manner, and to handle matchmaking and client connection orchestration
 */
public class PlayFabServerAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-DD'T'hh:mm:ss.SSS'Z'").create();
    
    /**
     * Validated a client's session ticket, and if successful, returns details for that user
     */
    public static FutureTask<PlayFabResult<AuthenticateSessionTicketResult>> AuthenticateSessionTicketAsync(AuthenticateSessionTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AuthenticateSessionTicketResult>>() {
            public PlayFabResult<AuthenticateSessionTicketResult> call() throws Exception {
                return privateAuthenticateSessionTicketAsync(request);
            }
        });
    }

    /**
     * Validated a client's session ticket, and if successful, returns details for that user
     */
    public static PlayFabResult<AuthenticateSessionTicketResult> AuthenticateSessionTicket(AuthenticateSessionTicketRequest request) {
        FutureTask<PlayFabResult<AuthenticateSessionTicketResult>> task = new FutureTask(new Callable<PlayFabResult<AuthenticateSessionTicketResult>>() {
            public PlayFabResult<AuthenticateSessionTicketResult> call() throws Exception {
                return privateAuthenticateSessionTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Validated a client's session ticket, and if successful, returns details for that user
     */
    private static PlayFabResult<AuthenticateSessionTicketResult> privateAuthenticateSessionTicketAsync(AuthenticateSessionTicketRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/AuthenticateSessionTicket", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AuthenticateSessionTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AuthenticateSessionTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AuthenticateSessionTicketResult>>(){}.getType()); 
        AuthenticateSessionTicketResult result = resultData.data;
        
        PlayFabResult<AuthenticateSessionTicketResult> pfResult = new PlayFabResult<AuthenticateSessionTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers.
     */
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>> GetPlayFabIDsFromFacebookIDsAsync(GetPlayFabIDsFromFacebookIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromFacebookIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers.
     */
    public static PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> GetPlayFabIDsFromFacebookIDs(GetPlayFabIDsFromFacebookIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromFacebookIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers.
     */
    private static PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> privateGetPlayFabIDsFromFacebookIDsAsync(GetPlayFabIDsFromFacebookIDsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetPlayFabIDsFromFacebookIDs", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPlayFabIDsFromFacebookIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromFacebookIDsResult>>(){}.getType()); 
        GetPlayFabIDsFromFacebookIDsResult result = resultData.data;
        
        PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the relevant details for a specified user
     */
    public static FutureTask<PlayFabResult<GetUserAccountInfoResult>> GetUserAccountInfoAsync(GetUserAccountInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserAccountInfoResult>>() {
            public PlayFabResult<GetUserAccountInfoResult> call() throws Exception {
                return privateGetUserAccountInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the relevant details for a specified user
     */
    public static PlayFabResult<GetUserAccountInfoResult> GetUserAccountInfo(GetUserAccountInfoRequest request) {
        FutureTask<PlayFabResult<GetUserAccountInfoResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserAccountInfoResult>>() {
            public PlayFabResult<GetUserAccountInfoResult> call() throws Exception {
                return privateGetUserAccountInfoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the relevant details for a specified user
     */
    private static PlayFabResult<GetUserAccountInfoResult> privateGetUserAccountInfoAsync(GetUserAccountInfoRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetUserAccountInfo", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserAccountInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserAccountInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserAccountInfoResult>>(){}.getType()); 
        GetUserAccountInfoResult result = resultData.data;
        
        PlayFabResult<GetUserAccountInfoResult> pfResult = new PlayFabResult<GetUserAccountInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Sends an iOS/Android Push Notification to a specific user, if that user's device has been configured for Push Notifications in PlayFab. If a user has linked both Android and iOS devices, both will be notified.
     */
    public static FutureTask<PlayFabResult<SendPushNotificationResult>> SendPushNotificationAsync(SendPushNotificationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SendPushNotificationResult>>() {
            public PlayFabResult<SendPushNotificationResult> call() throws Exception {
                return privateSendPushNotificationAsync(request);
            }
        });
    }

    /**
     * Sends an iOS/Android Push Notification to a specific user, if that user's device has been configured for Push Notifications in PlayFab. If a user has linked both Android and iOS devices, both will be notified.
     */
    public static PlayFabResult<SendPushNotificationResult> SendPushNotification(SendPushNotificationRequest request) {
        FutureTask<PlayFabResult<SendPushNotificationResult>> task = new FutureTask(new Callable<PlayFabResult<SendPushNotificationResult>>() {
            public PlayFabResult<SendPushNotificationResult> call() throws Exception {
                return privateSendPushNotificationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Sends an iOS/Android Push Notification to a specific user, if that user's device has been configured for Push Notifications in PlayFab. If a user has linked both Android and iOS devices, both will be notified.
     */
    private static PlayFabResult<SendPushNotificationResult> privateSendPushNotificationAsync(SendPushNotificationRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/SendPushNotification", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SendPushNotificationResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<SendPushNotificationResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SendPushNotificationResult>>(){}.getType()); 
        SendPushNotificationResult result = resultData.data;
        
        PlayFabResult<SendPushNotificationResult> pfResult = new PlayFabResult<SendPushNotificationResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard
     */
    public static FutureTask<PlayFabResult<GetLeaderboardResult>> GetLeaderboardAsync(GetLeaderboardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetLeaderboardAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard
     */
    public static PlayFabResult<GetLeaderboardResult> GetLeaderboard(GetLeaderboardRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetLeaderboardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard
     */
    private static PlayFabResult<GetLeaderboardResult> privateGetLeaderboardAsync(GetLeaderboardRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetLeaderboard", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetLeaderboardResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardResult>>(){}.getType()); 
        GetLeaderboardResult result = resultData.data;
        
        PlayFabResult<GetLeaderboardResult> pfResult = new PlayFabResult<GetLeaderboardResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user
     */
    public static FutureTask<PlayFabResult<GetLeaderboardAroundUserResult>> GetLeaderboardAroundUserAsync(GetLeaderboardAroundUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundUserResult>>() {
            public PlayFabResult<GetLeaderboardAroundUserResult> call() throws Exception {
                return privateGetLeaderboardAroundUserAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user
     */
    public static PlayFabResult<GetLeaderboardAroundUserResult> GetLeaderboardAroundUser(GetLeaderboardAroundUserRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardAroundUserResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundUserResult>>() {
            public PlayFabResult<GetLeaderboardAroundUserResult> call() throws Exception {
                return privateGetLeaderboardAroundUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user
     */
    private static PlayFabResult<GetLeaderboardAroundUserResult> privateGetLeaderboardAroundUserAsync(GetLeaderboardAroundUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetLeaderboardAroundUser", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardAroundUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetLeaderboardAroundUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardAroundUserResult>>(){}.getType()); 
        GetLeaderboardAroundUserResult result = resultData.data;
        
        PlayFabResult<GetLeaderboardAroundUserResult> pfResult = new PlayFabResult<GetLeaderboardAroundUserResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserDataAsync(GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetUserData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the user which cannot be accessed by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserInternalDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which cannot be accessed by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserInternalData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the user which cannot be accessed by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserInternalDataAsync(GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetUserInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserPublisherData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherDataAsync(GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetUserPublisherData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the publisher-specific custom data for the user which cannot be accessed by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherInternalDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which cannot be accessed by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserPublisherInternalData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the publisher-specific custom data for the user which cannot be accessed by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherInternalDataAsync(GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetUserPublisherInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the publisher-specific custom data for the user which can only be read by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherReadOnlyDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which can only be read by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserPublisherReadOnlyData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the publisher-specific custom data for the user which can only be read by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherReadOnlyDataAsync(GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetUserPublisherReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the user which can only be read by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserReadOnlyDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which can only be read by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserReadOnlyData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the user which can only be read by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserReadOnlyDataAsync(GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetUserReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the details of all title-specific statistics for the user
     */
    public static FutureTask<PlayFabResult<GetUserStatisticsResult>> GetUserStatisticsAsync(GetUserStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserStatisticsResult>>() {
            public PlayFabResult<GetUserStatisticsResult> call() throws Exception {
                return privateGetUserStatisticsAsync(request);
            }
        });
    }

    /**
     * Retrieves the details of all title-specific statistics for the user
     */
    public static PlayFabResult<GetUserStatisticsResult> GetUserStatistics(GetUserStatisticsRequest request) {
        FutureTask<PlayFabResult<GetUserStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserStatisticsResult>>() {
            public PlayFabResult<GetUserStatisticsResult> call() throws Exception {
                return privateGetUserStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the details of all title-specific statistics for the user
     */
    private static PlayFabResult<GetUserStatisticsResult> privateGetUserStatisticsAsync(GetUserStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetUserStatistics", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserStatisticsResult>>(){}.getType()); 
        GetUserStatisticsResult result = resultData.data;
        
        PlayFabResult<GetUserStatisticsResult> pfResult = new PlayFabResult<GetUserStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the title-specific custom data for the user which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserDataAsync(UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user which is readable and writable by the client
     */
    public static PlayFabResult<UpdateUserDataResult> UpdateUserData(UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the title-specific custom data for the user which is readable and writable by the client
     */
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserDataAsync(UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateUserData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType()); 
        UpdateUserDataResult result = resultData.data;
        
        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the title-specific custom data for the user which cannot be accessed by the client
     */
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserInternalDataAsync(UpdateUserInternalDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user which cannot be accessed by the client
     */
    public static PlayFabResult<UpdateUserDataResult> UpdateUserInternalData(UpdateUserInternalDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the title-specific custom data for the user which cannot be accessed by the client
     */
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserInternalDataAsync(UpdateUserInternalDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateUserInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType()); 
        UpdateUserDataResult result = resultData.data;
        
        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the publisher-specific custom data for the user which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherDataAsync(UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherDataAsync(request);
            }
        });
    }

    /**
     * Updates the publisher-specific custom data for the user which is readable and writable by the client
     */
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherData(UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the publisher-specific custom data for the user which is readable and writable by the client
     */
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherDataAsync(UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateUserPublisherData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType()); 
        UpdateUserDataResult result = resultData.data;
        
        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the publisher-specific custom data for the user which cannot be accessed by the client
     */
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherInternalDataAsync(UpdateUserInternalDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the publisher-specific custom data for the user which cannot be accessed by the client
     */
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherInternalData(UpdateUserInternalDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the publisher-specific custom data for the user which cannot be accessed by the client
     */
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherInternalDataAsync(UpdateUserInternalDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateUserPublisherInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType()); 
        UpdateUserDataResult result = resultData.data;
        
        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the publisher-specific custom data for the user which can only be read by the client
     */
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherReadOnlyDataAsync(UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Updates the publisher-specific custom data for the user which can only be read by the client
     */
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherReadOnlyData(UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the publisher-specific custom data for the user which can only be read by the client
     */
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherReadOnlyDataAsync(UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateUserPublisherReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType()); 
        UpdateUserDataResult result = resultData.data;
        
        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the title-specific custom data for the user which can only be read by the client
     */
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserReadOnlyDataAsync(UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user which can only be read by the client
     */
    public static PlayFabResult<UpdateUserDataResult> UpdateUserReadOnlyData(UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the title-specific custom data for the user which can only be read by the client
     */
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserReadOnlyDataAsync(UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateUserReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType()); 
        UpdateUserDataResult result = resultData.data;
        
        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the values of the specified title-specific statistics for the user
     */
    public static FutureTask<PlayFabResult<UpdateUserStatisticsResult>> UpdateUserStatisticsAsync(UpdateUserStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserStatisticsResult>>() {
            public PlayFabResult<UpdateUserStatisticsResult> call() throws Exception {
                return privateUpdateUserStatisticsAsync(request);
            }
        });
    }

    /**
     * Updates the values of the specified title-specific statistics for the user
     */
    public static PlayFabResult<UpdateUserStatisticsResult> UpdateUserStatistics(UpdateUserStatisticsRequest request) {
        FutureTask<PlayFabResult<UpdateUserStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserStatisticsResult>>() {
            public PlayFabResult<UpdateUserStatisticsResult> call() throws Exception {
                return privateUpdateUserStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the values of the specified title-specific statistics for the user
     */
    private static PlayFabResult<UpdateUserStatisticsResult> privateUpdateUserStatisticsAsync(UpdateUserStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateUserStatistics", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserStatisticsResult>>(){}.getType()); 
        UpdateUserStatisticsResult result = resultData.data;
        
        PlayFabResult<UpdateUserStatisticsResult> pfResult = new PlayFabResult<UpdateUserStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     */
    public static FutureTask<PlayFabResult<GetCatalogItemsResult>> GetCatalogItemsAsync(GetCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCatalogItemsResult>>() {
            public PlayFabResult<GetCatalogItemsResult> call() throws Exception {
                return privateGetCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     */
    public static PlayFabResult<GetCatalogItemsResult> GetCatalogItems(GetCatalogItemsRequest request) {
        FutureTask<PlayFabResult<GetCatalogItemsResult>> task = new FutureTask(new Callable<PlayFabResult<GetCatalogItemsResult>>() {
            public PlayFabResult<GetCatalogItemsResult> call() throws Exception {
                return privateGetCatalogItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     */
    private static PlayFabResult<GetCatalogItemsResult> privateGetCatalogItemsAsync(GetCatalogItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetCatalogItems", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCatalogItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCatalogItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCatalogItemsResult>>(){}.getType()); 
        GetCatalogItemsResult result = resultData.data;
        
        PlayFabResult<GetCatalogItemsResult> pfResult = new PlayFabResult<GetCatalogItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the key-value store of custom title settings
     */
    public static FutureTask<PlayFabResult<GetTitleDataResult>> GetTitleDataAsync(GetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom title settings
     */
    public static PlayFabResult<GetTitleDataResult> GetTitleData(GetTitleDataRequest request) {
        FutureTask<PlayFabResult<GetTitleDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the key-value store of custom title settings
     */
    private static PlayFabResult<GetTitleDataResult> privateGetTitleDataAsync(GetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetTitleData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetTitleDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleDataResult>>(){}.getType()); 
        GetTitleDataResult result = resultData.data;
        
        PlayFabResult<GetTitleDataResult> pfResult = new PlayFabResult<GetTitleDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the key-value store of custom internal title settings
     */
    public static FutureTask<PlayFabResult<GetTitleDataResult>> GetTitleInternalDataAsync(GetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom internal title settings
     */
    public static PlayFabResult<GetTitleDataResult> GetTitleInternalData(GetTitleDataRequest request) {
        FutureTask<PlayFabResult<GetTitleDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the key-value store of custom internal title settings
     */
    private static PlayFabResult<GetTitleDataResult> privateGetTitleInternalDataAsync(GetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetTitleInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetTitleDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleDataResult>>(){}.getType()); 
        GetTitleDataResult result = resultData.data;
        
        PlayFabResult<GetTitleDataResult> pfResult = new PlayFabResult<GetTitleDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title news feed, as configured in the developer portal
     */
    public static FutureTask<PlayFabResult<GetTitleNewsResult>> GetTitleNewsAsync(GetTitleNewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleNewsResult>>() {
            public PlayFabResult<GetTitleNewsResult> call() throws Exception {
                return privateGetTitleNewsAsync(request);
            }
        });
    }

    /**
     * Retrieves the title news feed, as configured in the developer portal
     */
    public static PlayFabResult<GetTitleNewsResult> GetTitleNews(GetTitleNewsRequest request) {
        FutureTask<PlayFabResult<GetTitleNewsResult>> task = new FutureTask(new Callable<PlayFabResult<GetTitleNewsResult>>() {
            public PlayFabResult<GetTitleNewsResult> call() throws Exception {
                return privateGetTitleNewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title news feed, as configured in the developer portal
     */
    private static PlayFabResult<GetTitleNewsResult> privateGetTitleNewsAsync(GetTitleNewsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetTitleNews", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleNewsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetTitleNewsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleNewsResult>>(){}.getType()); 
        GetTitleNewsResult result = resultData.data;
        
        PlayFabResult<GetTitleNewsResult> pfResult = new PlayFabResult<GetTitleNewsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the key-value store of custom title settings
     */
    public static FutureTask<PlayFabResult<SetTitleDataResult>> SetTitleDataAsync(SetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleDataAsync(request);
            }
        });
    }

    /**
     * Updates the key-value store of custom title settings
     */
    public static PlayFabResult<SetTitleDataResult> SetTitleData(SetTitleDataRequest request) {
        FutureTask<PlayFabResult<SetTitleDataResult>> task = new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the key-value store of custom title settings
     */
    private static PlayFabResult<SetTitleDataResult> privateSetTitleDataAsync(SetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/SetTitleData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetTitleDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<SetTitleDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetTitleDataResult>>(){}.getType()); 
        SetTitleDataResult result = resultData.data;
        
        PlayFabResult<SetTitleDataResult> pfResult = new PlayFabResult<SetTitleDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the key-value store of custom title settings
     */
    public static FutureTask<PlayFabResult<SetTitleDataResult>> SetTitleInternalDataAsync(SetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the key-value store of custom title settings
     */
    public static PlayFabResult<SetTitleDataResult> SetTitleInternalData(SetTitleDataRequest request) {
        FutureTask<PlayFabResult<SetTitleDataResult>> task = new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the key-value store of custom title settings
     */
    private static PlayFabResult<SetTitleDataResult> privateSetTitleInternalDataAsync(SetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/SetTitleInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetTitleDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<SetTitleDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetTitleDataResult>>(){}.getType()); 
        SetTitleDataResult result = resultData.data;
        
        PlayFabResult<SetTitleDataResult> pfResult = new PlayFabResult<SetTitleDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Increments  the character's balance of the specified virtual currency by the stated amount
     */
    public static FutureTask<PlayFabResult<ModifyCharacterVirtualCurrencyResult>> AddCharacterVirtualCurrencyAsync(AddCharacterVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyCharacterVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyCharacterVirtualCurrencyResult> call() throws Exception {
                return privateAddCharacterVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Increments  the character's balance of the specified virtual currency by the stated amount
     */
    public static PlayFabResult<ModifyCharacterVirtualCurrencyResult> AddCharacterVirtualCurrency(AddCharacterVirtualCurrencyRequest request) {
        FutureTask<PlayFabResult<ModifyCharacterVirtualCurrencyResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyCharacterVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyCharacterVirtualCurrencyResult> call() throws Exception {
                return privateAddCharacterVirtualCurrencyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Increments  the character's balance of the specified virtual currency by the stated amount
     */
    private static PlayFabResult<ModifyCharacterVirtualCurrencyResult> privateAddCharacterVirtualCurrencyAsync(AddCharacterVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/AddCharacterVirtualCurrency", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyCharacterVirtualCurrencyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ModifyCharacterVirtualCurrencyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyCharacterVirtualCurrencyResult>>(){}.getType()); 
        ModifyCharacterVirtualCurrencyResult result = resultData.data;
        
        PlayFabResult<ModifyCharacterVirtualCurrencyResult> pfResult = new PlayFabResult<ModifyCharacterVirtualCurrencyResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Increments  the user's balance of the specified virtual currency by the stated amount
     */
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> AddUserVirtualCurrencyAsync(AddUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateAddUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Increments  the user's balance of the specified virtual currency by the stated amount
     */
    public static PlayFabResult<ModifyUserVirtualCurrencyResult> AddUserVirtualCurrency(AddUserVirtualCurrencyRequest request) {
        FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateAddUserVirtualCurrencyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Increments  the user's balance of the specified virtual currency by the stated amount
     */
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateAddUserVirtualCurrencyAsync(AddUserVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/AddUserVirtualCurrency", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult>>(){}.getType()); 
        ModifyUserVirtualCurrencyResult result = resultData.data;
        
        PlayFabResult<ModifyUserVirtualCurrencyResult> pfResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the specified character's current inventory of virtual goods
     */
    public static FutureTask<PlayFabResult<GetCharacterInventoryResult>> GetCharacterInventoryAsync(GetCharacterInventoryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterInventoryResult>>() {
            public PlayFabResult<GetCharacterInventoryResult> call() throws Exception {
                return privateGetCharacterInventoryAsync(request);
            }
        });
    }

    /**
     * Retrieves the specified character's current inventory of virtual goods
     */
    public static PlayFabResult<GetCharacterInventoryResult> GetCharacterInventory(GetCharacterInventoryRequest request) {
        FutureTask<PlayFabResult<GetCharacterInventoryResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterInventoryResult>>() {
            public PlayFabResult<GetCharacterInventoryResult> call() throws Exception {
                return privateGetCharacterInventoryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the specified character's current inventory of virtual goods
     */
    private static PlayFabResult<GetCharacterInventoryResult> privateGetCharacterInventoryAsync(GetCharacterInventoryRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetCharacterInventory", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterInventoryResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterInventoryResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterInventoryResult>>(){}.getType()); 
        GetCharacterInventoryResult result = resultData.data;
        
        PlayFabResult<GetCharacterInventoryResult> pfResult = new PlayFabResult<GetCharacterInventoryResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the specified user's current inventory of virtual goods
     */
    public static FutureTask<PlayFabResult<GetUserInventoryResult>> GetUserInventoryAsync(GetUserInventoryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserInventoryResult>>() {
            public PlayFabResult<GetUserInventoryResult> call() throws Exception {
                return privateGetUserInventoryAsync(request);
            }
        });
    }

    /**
     * Retrieves the specified user's current inventory of virtual goods
     */
    public static PlayFabResult<GetUserInventoryResult> GetUserInventory(GetUserInventoryRequest request) {
        FutureTask<PlayFabResult<GetUserInventoryResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserInventoryResult>>() {
            public PlayFabResult<GetUserInventoryResult> call() throws Exception {
                return privateGetUserInventoryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the specified user's current inventory of virtual goods
     */
    private static PlayFabResult<GetUserInventoryResult> privateGetUserInventoryAsync(GetUserInventoryRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetUserInventory", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserInventoryResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserInventoryResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserInventoryResult>>(){}.getType()); 
        GetUserInventoryResult result = resultData.data;
        
        PlayFabResult<GetUserInventoryResult> pfResult = new PlayFabResult<GetUserInventoryResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds the specified items to the specified character's inventory
     */
    public static FutureTask<PlayFabResult<GrantItemsToCharacterResult>> GrantItemsToCharacterAsync(GrantItemsToCharacterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantItemsToCharacterResult>>() {
            public PlayFabResult<GrantItemsToCharacterResult> call() throws Exception {
                return privateGrantItemsToCharacterAsync(request);
            }
        });
    }

    /**
     * Adds the specified items to the specified character's inventory
     */
    public static PlayFabResult<GrantItemsToCharacterResult> GrantItemsToCharacter(GrantItemsToCharacterRequest request) {
        FutureTask<PlayFabResult<GrantItemsToCharacterResult>> task = new FutureTask(new Callable<PlayFabResult<GrantItemsToCharacterResult>>() {
            public PlayFabResult<GrantItemsToCharacterResult> call() throws Exception {
                return privateGrantItemsToCharacterAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds the specified items to the specified character's inventory
     */
    private static PlayFabResult<GrantItemsToCharacterResult> privateGrantItemsToCharacterAsync(GrantItemsToCharacterRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GrantItemsToCharacter", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GrantItemsToCharacterResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GrantItemsToCharacterResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GrantItemsToCharacterResult>>(){}.getType()); 
        GrantItemsToCharacterResult result = resultData.data;
        
        PlayFabResult<GrantItemsToCharacterResult> pfResult = new PlayFabResult<GrantItemsToCharacterResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds the specified items to the specified user's inventory
     */
    public static FutureTask<PlayFabResult<GrantItemsToUserResult>> GrantItemsToUserAsync(GrantItemsToUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantItemsToUserResult>>() {
            public PlayFabResult<GrantItemsToUserResult> call() throws Exception {
                return privateGrantItemsToUserAsync(request);
            }
        });
    }

    /**
     * Adds the specified items to the specified user's inventory
     */
    public static PlayFabResult<GrantItemsToUserResult> GrantItemsToUser(GrantItemsToUserRequest request) {
        FutureTask<PlayFabResult<GrantItemsToUserResult>> task = new FutureTask(new Callable<PlayFabResult<GrantItemsToUserResult>>() {
            public PlayFabResult<GrantItemsToUserResult> call() throws Exception {
                return privateGrantItemsToUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds the specified items to the specified user's inventory
     */
    private static PlayFabResult<GrantItemsToUserResult> privateGrantItemsToUserAsync(GrantItemsToUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GrantItemsToUser", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GrantItemsToUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GrantItemsToUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GrantItemsToUserResult>>(){}.getType()); 
        GrantItemsToUserResult result = resultData.data;
        
        PlayFabResult<GrantItemsToUserResult> pfResult = new PlayFabResult<GrantItemsToUserResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds the specified items to the specified user inventories
     */
    public static FutureTask<PlayFabResult<GrantItemsToUsersResult>> GrantItemsToUsersAsync(GrantItemsToUsersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantItemsToUsersResult>>() {
            public PlayFabResult<GrantItemsToUsersResult> call() throws Exception {
                return privateGrantItemsToUsersAsync(request);
            }
        });
    }

    /**
     * Adds the specified items to the specified user inventories
     */
    public static PlayFabResult<GrantItemsToUsersResult> GrantItemsToUsers(GrantItemsToUsersRequest request) {
        FutureTask<PlayFabResult<GrantItemsToUsersResult>> task = new FutureTask(new Callable<PlayFabResult<GrantItemsToUsersResult>>() {
            public PlayFabResult<GrantItemsToUsersResult> call() throws Exception {
                return privateGrantItemsToUsersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds the specified items to the specified user inventories
     */
    private static PlayFabResult<GrantItemsToUsersResult> privateGrantItemsToUsersAsync(GrantItemsToUsersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GrantItemsToUsers", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GrantItemsToUsersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GrantItemsToUsersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GrantItemsToUsersResult>>(){}.getType()); 
        GrantItemsToUsersResult result = resultData.data;
        
        PlayFabResult<GrantItemsToUsersResult> pfResult = new PlayFabResult<GrantItemsToUsersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Modifies the number of remaining uses of a player's inventory item
     */
    public static FutureTask<PlayFabResult<ModifyItemUsesResult>> ModifyItemUsesAsync(ModifyItemUsesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyItemUsesResult>>() {
            public PlayFabResult<ModifyItemUsesResult> call() throws Exception {
                return privateModifyItemUsesAsync(request);
            }
        });
    }

    /**
     * Modifies the number of remaining uses of a player's inventory item
     */
    public static PlayFabResult<ModifyItemUsesResult> ModifyItemUses(ModifyItemUsesRequest request) {
        FutureTask<PlayFabResult<ModifyItemUsesResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyItemUsesResult>>() {
            public PlayFabResult<ModifyItemUsesResult> call() throws Exception {
                return privateModifyItemUsesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Modifies the number of remaining uses of a player's inventory item
     */
    private static PlayFabResult<ModifyItemUsesResult> privateModifyItemUsesAsync(ModifyItemUsesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/ModifyItemUses", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyItemUsesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ModifyItemUsesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyItemUsesResult>>(){}.getType()); 
        ModifyItemUsesResult result = resultData.data;
        
        PlayFabResult<ModifyItemUsesResult> pfResult = new PlayFabResult<ModifyItemUsesResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Moves an item from a character's inventory into another of the users's character's inventory.
     */
    public static FutureTask<PlayFabResult<MoveItemToCharacterFromCharacterResult>> MoveItemToCharacterFromCharacterAsync(MoveItemToCharacterFromCharacterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<MoveItemToCharacterFromCharacterResult>>() {
            public PlayFabResult<MoveItemToCharacterFromCharacterResult> call() throws Exception {
                return privateMoveItemToCharacterFromCharacterAsync(request);
            }
        });
    }

    /**
     * Moves an item from a character's inventory into another of the users's character's inventory.
     */
    public static PlayFabResult<MoveItemToCharacterFromCharacterResult> MoveItemToCharacterFromCharacter(MoveItemToCharacterFromCharacterRequest request) {
        FutureTask<PlayFabResult<MoveItemToCharacterFromCharacterResult>> task = new FutureTask(new Callable<PlayFabResult<MoveItemToCharacterFromCharacterResult>>() {
            public PlayFabResult<MoveItemToCharacterFromCharacterResult> call() throws Exception {
                return privateMoveItemToCharacterFromCharacterAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Moves an item from a character's inventory into another of the users's character's inventory.
     */
    private static PlayFabResult<MoveItemToCharacterFromCharacterResult> privateMoveItemToCharacterFromCharacterAsync(MoveItemToCharacterFromCharacterRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/MoveItemToCharacterFromCharacter", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<MoveItemToCharacterFromCharacterResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<MoveItemToCharacterFromCharacterResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<MoveItemToCharacterFromCharacterResult>>(){}.getType()); 
        MoveItemToCharacterFromCharacterResult result = resultData.data;
        
        PlayFabResult<MoveItemToCharacterFromCharacterResult> pfResult = new PlayFabResult<MoveItemToCharacterFromCharacterResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Moves an item from a user's inventory into their character's inventory.
     */
    public static FutureTask<PlayFabResult<MoveItemToCharacterFromUserResult>> MoveItemToCharacterFromUserAsync(MoveItemToCharacterFromUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<MoveItemToCharacterFromUserResult>>() {
            public PlayFabResult<MoveItemToCharacterFromUserResult> call() throws Exception {
                return privateMoveItemToCharacterFromUserAsync(request);
            }
        });
    }

    /**
     * Moves an item from a user's inventory into their character's inventory.
     */
    public static PlayFabResult<MoveItemToCharacterFromUserResult> MoveItemToCharacterFromUser(MoveItemToCharacterFromUserRequest request) {
        FutureTask<PlayFabResult<MoveItemToCharacterFromUserResult>> task = new FutureTask(new Callable<PlayFabResult<MoveItemToCharacterFromUserResult>>() {
            public PlayFabResult<MoveItemToCharacterFromUserResult> call() throws Exception {
                return privateMoveItemToCharacterFromUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Moves an item from a user's inventory into their character's inventory.
     */
    private static PlayFabResult<MoveItemToCharacterFromUserResult> privateMoveItemToCharacterFromUserAsync(MoveItemToCharacterFromUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/MoveItemToCharacterFromUser", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<MoveItemToCharacterFromUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<MoveItemToCharacterFromUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<MoveItemToCharacterFromUserResult>>(){}.getType()); 
        MoveItemToCharacterFromUserResult result = resultData.data;
        
        PlayFabResult<MoveItemToCharacterFromUserResult> pfResult = new PlayFabResult<MoveItemToCharacterFromUserResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Moves an item from a character's inventory into the owning user's inventory.
     */
    public static FutureTask<PlayFabResult<MoveItemToUserFromCharacterResult>> MoveItemToUserFromCharacterAsync(MoveItemToUserFromCharacterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<MoveItemToUserFromCharacterResult>>() {
            public PlayFabResult<MoveItemToUserFromCharacterResult> call() throws Exception {
                return privateMoveItemToUserFromCharacterAsync(request);
            }
        });
    }

    /**
     * Moves an item from a character's inventory into the owning user's inventory.
     */
    public static PlayFabResult<MoveItemToUserFromCharacterResult> MoveItemToUserFromCharacter(MoveItemToUserFromCharacterRequest request) {
        FutureTask<PlayFabResult<MoveItemToUserFromCharacterResult>> task = new FutureTask(new Callable<PlayFabResult<MoveItemToUserFromCharacterResult>>() {
            public PlayFabResult<MoveItemToUserFromCharacterResult> call() throws Exception {
                return privateMoveItemToUserFromCharacterAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Moves an item from a character's inventory into the owning user's inventory.
     */
    private static PlayFabResult<MoveItemToUserFromCharacterResult> privateMoveItemToUserFromCharacterAsync(MoveItemToUserFromCharacterRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/MoveItemToUserFromCharacter", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<MoveItemToUserFromCharacterResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<MoveItemToUserFromCharacterResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<MoveItemToUserFromCharacterResult>>(){}.getType()); 
        MoveItemToUserFromCharacterResult result = resultData.data;
        
        PlayFabResult<MoveItemToUserFromCharacterResult> pfResult = new PlayFabResult<MoveItemToUserFromCharacterResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Submit a report about a player (due to bad bahavior, etc.) on behalf of another player, so that customer service representatives for the title can take action concerning potentially poxic players.
     */
    public static FutureTask<PlayFabResult<ReportPlayerServerResult>> ReportPlayerAsync(ReportPlayerServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReportPlayerServerResult>>() {
            public PlayFabResult<ReportPlayerServerResult> call() throws Exception {
                return privateReportPlayerAsync(request);
            }
        });
    }

    /**
     * Submit a report about a player (due to bad bahavior, etc.) on behalf of another player, so that customer service representatives for the title can take action concerning potentially poxic players.
     */
    public static PlayFabResult<ReportPlayerServerResult> ReportPlayer(ReportPlayerServerRequest request) {
        FutureTask<PlayFabResult<ReportPlayerServerResult>> task = new FutureTask(new Callable<PlayFabResult<ReportPlayerServerResult>>() {
            public PlayFabResult<ReportPlayerServerResult> call() throws Exception {
                return privateReportPlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Submit a report about a player (due to bad bahavior, etc.) on behalf of another player, so that customer service representatives for the title can take action concerning potentially poxic players.
     */
    private static PlayFabResult<ReportPlayerServerResult> privateReportPlayerAsync(ReportPlayerServerRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/ReportPlayer", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReportPlayerServerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ReportPlayerServerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReportPlayerServerResult>>(){}.getType()); 
        ReportPlayerServerResult result = resultData.data;
        
        PlayFabResult<ReportPlayerServerResult> pfResult = new PlayFabResult<ReportPlayerServerResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Decrements the character's balance of the specified virtual currency by the stated amount
     */
    public static FutureTask<PlayFabResult<ModifyCharacterVirtualCurrencyResult>> SubtractCharacterVirtualCurrencyAsync(SubtractCharacterVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyCharacterVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyCharacterVirtualCurrencyResult> call() throws Exception {
                return privateSubtractCharacterVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Decrements the character's balance of the specified virtual currency by the stated amount
     */
    public static PlayFabResult<ModifyCharacterVirtualCurrencyResult> SubtractCharacterVirtualCurrency(SubtractCharacterVirtualCurrencyRequest request) {
        FutureTask<PlayFabResult<ModifyCharacterVirtualCurrencyResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyCharacterVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyCharacterVirtualCurrencyResult> call() throws Exception {
                return privateSubtractCharacterVirtualCurrencyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Decrements the character's balance of the specified virtual currency by the stated amount
     */
    private static PlayFabResult<ModifyCharacterVirtualCurrencyResult> privateSubtractCharacterVirtualCurrencyAsync(SubtractCharacterVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/SubtractCharacterVirtualCurrency", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyCharacterVirtualCurrencyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ModifyCharacterVirtualCurrencyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyCharacterVirtualCurrencyResult>>(){}.getType()); 
        ModifyCharacterVirtualCurrencyResult result = resultData.data;
        
        PlayFabResult<ModifyCharacterVirtualCurrencyResult> pfResult = new PlayFabResult<ModifyCharacterVirtualCurrencyResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Decrements the user's balance of the specified virtual currency by the stated amount
     */
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> SubtractUserVirtualCurrencyAsync(SubtractUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateSubtractUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Decrements the user's balance of the specified virtual currency by the stated amount
     */
    public static PlayFabResult<ModifyUserVirtualCurrencyResult> SubtractUserVirtualCurrency(SubtractUserVirtualCurrencyRequest request) {
        FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateSubtractUserVirtualCurrencyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Decrements the user's balance of the specified virtual currency by the stated amount
     */
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateSubtractUserVirtualCurrencyAsync(SubtractUserVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/SubtractUserVirtualCurrency", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult>>(){}.getType()); 
        ModifyUserVirtualCurrencyResult result = resultData.data;
        
        PlayFabResult<ModifyUserVirtualCurrencyResult> pfResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the key-value pair data tagged to the specified item, which is read-only from the client.
     */
    public static FutureTask<PlayFabResult<UpdateUserInventoryItemDataResult>> UpdateUserInventoryItemCustomDataAsync(UpdateUserInventoryItemDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserInventoryItemDataResult>>() {
            public PlayFabResult<UpdateUserInventoryItemDataResult> call() throws Exception {
                return privateUpdateUserInventoryItemCustomDataAsync(request);
            }
        });
    }

    /**
     * Updates the key-value pair data tagged to the specified item, which is read-only from the client.
     */
    public static PlayFabResult<UpdateUserInventoryItemDataResult> UpdateUserInventoryItemCustomData(UpdateUserInventoryItemDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserInventoryItemDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserInventoryItemDataResult>>() {
            public PlayFabResult<UpdateUserInventoryItemDataResult> call() throws Exception {
                return privateUpdateUserInventoryItemCustomDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the key-value pair data tagged to the specified item, which is read-only from the client.
     */
    private static PlayFabResult<UpdateUserInventoryItemDataResult> privateUpdateUserInventoryItemCustomDataAsync(UpdateUserInventoryItemDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateUserInventoryItemCustomData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserInventoryItemDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserInventoryItemDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserInventoryItemDataResult>>(){}.getType()); 
        UpdateUserInventoryItemDataResult result = resultData.data;
        
        PlayFabResult<UpdateUserInventoryItemDataResult> pfResult = new PlayFabResult<UpdateUserInventoryItemDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Informs the PlayFab match-making service that the user specified has left the Game Server Instance
     */
    public static FutureTask<PlayFabResult<NotifyMatchmakerPlayerLeftResult>> NotifyMatchmakerPlayerLeftAsync(NotifyMatchmakerPlayerLeftRequest request) {
        return new FutureTask(new Callable<PlayFabResult<NotifyMatchmakerPlayerLeftResult>>() {
            public PlayFabResult<NotifyMatchmakerPlayerLeftResult> call() throws Exception {
                return privateNotifyMatchmakerPlayerLeftAsync(request);
            }
        });
    }

    /**
     * Informs the PlayFab match-making service that the user specified has left the Game Server Instance
     */
    public static PlayFabResult<NotifyMatchmakerPlayerLeftResult> NotifyMatchmakerPlayerLeft(NotifyMatchmakerPlayerLeftRequest request) {
        FutureTask<PlayFabResult<NotifyMatchmakerPlayerLeftResult>> task = new FutureTask(new Callable<PlayFabResult<NotifyMatchmakerPlayerLeftResult>>() {
            public PlayFabResult<NotifyMatchmakerPlayerLeftResult> call() throws Exception {
                return privateNotifyMatchmakerPlayerLeftAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Informs the PlayFab match-making service that the user specified has left the Game Server Instance
     */
    private static PlayFabResult<NotifyMatchmakerPlayerLeftResult> privateNotifyMatchmakerPlayerLeftAsync(NotifyMatchmakerPlayerLeftRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/NotifyMatchmakerPlayerLeft", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<NotifyMatchmakerPlayerLeftResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<NotifyMatchmakerPlayerLeftResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<NotifyMatchmakerPlayerLeftResult>>(){}.getType()); 
        NotifyMatchmakerPlayerLeftResult result = resultData.data;
        
        PlayFabResult<NotifyMatchmakerPlayerLeftResult> pfResult = new PlayFabResult<NotifyMatchmakerPlayerLeftResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Validates a Game Server session ticket and returns details about the user
     */
    public static FutureTask<PlayFabResult<RedeemMatchmakerTicketResult>> RedeemMatchmakerTicketAsync(RedeemMatchmakerTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemMatchmakerTicketResult>>() {
            public PlayFabResult<RedeemMatchmakerTicketResult> call() throws Exception {
                return privateRedeemMatchmakerTicketAsync(request);
            }
        });
    }

    /**
     * Validates a Game Server session ticket and returns details about the user
     */
    public static PlayFabResult<RedeemMatchmakerTicketResult> RedeemMatchmakerTicket(RedeemMatchmakerTicketRequest request) {
        FutureTask<PlayFabResult<RedeemMatchmakerTicketResult>> task = new FutureTask(new Callable<PlayFabResult<RedeemMatchmakerTicketResult>>() {
            public PlayFabResult<RedeemMatchmakerTicketResult> call() throws Exception {
                return privateRedeemMatchmakerTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Validates a Game Server session ticket and returns details about the user
     */
    private static PlayFabResult<RedeemMatchmakerTicketResult> privateRedeemMatchmakerTicketAsync(RedeemMatchmakerTicketRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/RedeemMatchmakerTicket", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RedeemMatchmakerTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RedeemMatchmakerTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RedeemMatchmakerTicketResult>>(){}.getType()); 
        RedeemMatchmakerTicketResult result = resultData.data;
        
        PlayFabResult<RedeemMatchmakerTicketResult> pfResult = new PlayFabResult<RedeemMatchmakerTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Awards the specified users the specified Steam achievements
     */
    public static FutureTask<PlayFabResult<AwardSteamAchievementResult>> AwardSteamAchievementAsync(AwardSteamAchievementRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AwardSteamAchievementResult>>() {
            public PlayFabResult<AwardSteamAchievementResult> call() throws Exception {
                return privateAwardSteamAchievementAsync(request);
            }
        });
    }

    /**
     * Awards the specified users the specified Steam achievements
     */
    public static PlayFabResult<AwardSteamAchievementResult> AwardSteamAchievement(AwardSteamAchievementRequest request) {
        FutureTask<PlayFabResult<AwardSteamAchievementResult>> task = new FutureTask(new Callable<PlayFabResult<AwardSteamAchievementResult>>() {
            public PlayFabResult<AwardSteamAchievementResult> call() throws Exception {
                return privateAwardSteamAchievementAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Awards the specified users the specified Steam achievements
     */
    private static PlayFabResult<AwardSteamAchievementResult> privateAwardSteamAchievementAsync(AwardSteamAchievementRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/AwardSteamAchievement", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AwardSteamAchievementResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AwardSteamAchievementResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AwardSteamAchievementResult>>(){}.getType()); 
        AwardSteamAchievementResult result = resultData.data;
        
        PlayFabResult<AwardSteamAchievementResult> pfResult = new PlayFabResult<AwardSteamAchievementResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Logs a custom analytics event
     */
    public static FutureTask<PlayFabResult<LogEventResult>> LogEventAsync(LogEventRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LogEventResult>>() {
            public PlayFabResult<LogEventResult> call() throws Exception {
                return privateLogEventAsync(request);
            }
        });
    }

    /**
     * Logs a custom analytics event
     */
    public static PlayFabResult<LogEventResult> LogEvent(LogEventRequest request) {
        FutureTask<PlayFabResult<LogEventResult>> task = new FutureTask(new Callable<PlayFabResult<LogEventResult>>() {
            public PlayFabResult<LogEventResult> call() throws Exception {
                return privateLogEventAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Logs a custom analytics event
     */
    private static PlayFabResult<LogEventResult> privateLogEventAsync(LogEventRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/LogEvent", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LogEventResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LogEventResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LogEventResult>>(){}.getType()); 
        LogEventResult result = resultData.data;
        
        PlayFabResult<LogEventResult> pfResult = new PlayFabResult<LogEventResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users in the group (and the server) can add new members.
     */
    public static FutureTask<PlayFabResult<AddSharedGroupMembersResult>> AddSharedGroupMembersAsync(AddSharedGroupMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddSharedGroupMembersResult>>() {
            public PlayFabResult<AddSharedGroupMembersResult> call() throws Exception {
                return privateAddSharedGroupMembersAsync(request);
            }
        });
    }

    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users in the group (and the server) can add new members.
     */
    public static PlayFabResult<AddSharedGroupMembersResult> AddSharedGroupMembers(AddSharedGroupMembersRequest request) {
        FutureTask<PlayFabResult<AddSharedGroupMembersResult>> task = new FutureTask(new Callable<PlayFabResult<AddSharedGroupMembersResult>>() {
            public PlayFabResult<AddSharedGroupMembersResult> call() throws Exception {
                return privateAddSharedGroupMembersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users in the group (and the server) can add new members.
     */
    private static PlayFabResult<AddSharedGroupMembersResult> privateAddSharedGroupMembersAsync(AddSharedGroupMembersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/AddSharedGroupMembers", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddSharedGroupMembersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AddSharedGroupMembersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddSharedGroupMembersResult>>(){}.getType()); 
        AddSharedGroupMembersResult result = resultData.data;
        
        PlayFabResult<AddSharedGroupMembersResult> pfResult = new PlayFabResult<AddSharedGroupMembersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the group. When created by a server, the group will initially have no members.
     */
    public static FutureTask<PlayFabResult<CreateSharedGroupResult>> CreateSharedGroupAsync(CreateSharedGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateSharedGroupResult>>() {
            public PlayFabResult<CreateSharedGroupResult> call() throws Exception {
                return privateCreateSharedGroupAsync(request);
            }
        });
    }

    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the group. When created by a server, the group will initially have no members.
     */
    public static PlayFabResult<CreateSharedGroupResult> CreateSharedGroup(CreateSharedGroupRequest request) {
        FutureTask<PlayFabResult<CreateSharedGroupResult>> task = new FutureTask(new Callable<PlayFabResult<CreateSharedGroupResult>>() {
            public PlayFabResult<CreateSharedGroupResult> call() throws Exception {
                return privateCreateSharedGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the group. When created by a server, the group will initially have no members.
     */
    private static PlayFabResult<CreateSharedGroupResult> privateCreateSharedGroupAsync(CreateSharedGroupRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/CreateSharedGroup", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateSharedGroupResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<CreateSharedGroupResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateSharedGroupResult>>(){}.getType()); 
        CreateSharedGroupResult result = resultData.data;
        
        PlayFabResult<CreateSharedGroupResult> pfResult = new PlayFabResult<CreateSharedGroupResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Deletes a shared group, freeing up the shared group ID to be reused for a new group
     */
    public static FutureTask<PlayFabResult<EmptyResult>> DeleteSharedGroupAsync(DeleteSharedGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateDeleteSharedGroupAsync(request);
            }
        });
    }

    /**
     * Deletes a shared group, freeing up the shared group ID to be reused for a new group
     */
    public static PlayFabResult<EmptyResult> DeleteSharedGroup(DeleteSharedGroupRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateDeleteSharedGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Deletes a shared group, freeing up the shared group ID to be reused for a new group
     */
    private static PlayFabResult<EmptyResult> privateDeleteSharedGroupAsync(DeleteSharedGroupRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/DeleteSharedGroup", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType()); 
        EmptyResult result = resultData.data;
        
        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the key-value store of custom publisher settings
     */
    public static FutureTask<PlayFabResult<GetPublisherDataResult>> GetPublisherDataAsync(GetPublisherDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPublisherDataResult>>() {
            public PlayFabResult<GetPublisherDataResult> call() throws Exception {
                return privateGetPublisherDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom publisher settings
     */
    public static PlayFabResult<GetPublisherDataResult> GetPublisherData(GetPublisherDataRequest request) {
        FutureTask<PlayFabResult<GetPublisherDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetPublisherDataResult>>() {
            public PlayFabResult<GetPublisherDataResult> call() throws Exception {
                return privateGetPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the key-value store of custom publisher settings
     */
    private static PlayFabResult<GetPublisherDataResult> privateGetPublisherDataAsync(GetPublisherDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetPublisherData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPublisherDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPublisherDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPublisherDataResult>>(){}.getType()); 
        GetPublisherDataResult result = resultData.data;
        
        PlayFabResult<GetPublisherDataResult> pfResult = new PlayFabResult<GetPublisherDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. The server can access all public and private group data.
     */
    public static FutureTask<PlayFabResult<GetSharedGroupDataResult>> GetSharedGroupDataAsync(GetSharedGroupDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetSharedGroupDataResult>>() {
            public PlayFabResult<GetSharedGroupDataResult> call() throws Exception {
                return privateGetSharedGroupDataAsync(request);
            }
        });
    }

    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. The server can access all public and private group data.
     */
    public static PlayFabResult<GetSharedGroupDataResult> GetSharedGroupData(GetSharedGroupDataRequest request) {
        FutureTask<PlayFabResult<GetSharedGroupDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetSharedGroupDataResult>>() {
            public PlayFabResult<GetSharedGroupDataResult> call() throws Exception {
                return privateGetSharedGroupDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. The server can access all public and private group data.
     */
    private static PlayFabResult<GetSharedGroupDataResult> privateGetSharedGroupDataAsync(GetSharedGroupDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetSharedGroupData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetSharedGroupDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetSharedGroupDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetSharedGroupDataResult>>(){}.getType()); 
        GetSharedGroupDataResult result = resultData.data;
        
        PlayFabResult<GetSharedGroupDataResult> pfResult = new PlayFabResult<GetSharedGroupDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the group can remove members. If as a result of the call, zero users remain with access, the group and its associated data will be deleted.
     */
    public static FutureTask<PlayFabResult<RemoveSharedGroupMembersResult>> RemoveSharedGroupMembersAsync(RemoveSharedGroupMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemoveSharedGroupMembersResult>>() {
            public PlayFabResult<RemoveSharedGroupMembersResult> call() throws Exception {
                return privateRemoveSharedGroupMembersAsync(request);
            }
        });
    }

    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the group can remove members. If as a result of the call, zero users remain with access, the group and its associated data will be deleted.
     */
    public static PlayFabResult<RemoveSharedGroupMembersResult> RemoveSharedGroupMembers(RemoveSharedGroupMembersRequest request) {
        FutureTask<PlayFabResult<RemoveSharedGroupMembersResult>> task = new FutureTask(new Callable<PlayFabResult<RemoveSharedGroupMembersResult>>() {
            public PlayFabResult<RemoveSharedGroupMembersResult> call() throws Exception {
                return privateRemoveSharedGroupMembersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the group can remove members. If as a result of the call, zero users remain with access, the group and its associated data will be deleted.
     */
    private static PlayFabResult<RemoveSharedGroupMembersResult> privateRemoveSharedGroupMembersAsync(RemoveSharedGroupMembersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/RemoveSharedGroupMembers", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RemoveSharedGroupMembersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RemoveSharedGroupMembersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RemoveSharedGroupMembersResult>>(){}.getType()); 
        RemoveSharedGroupMembersResult result = resultData.data;
        
        PlayFabResult<RemoveSharedGroupMembersResult> pfResult = new PlayFabResult<RemoveSharedGroupMembersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the key-value store of custom publisher settings
     */
    public static FutureTask<PlayFabResult<SetPublisherDataResult>> SetPublisherDataAsync(SetPublisherDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetPublisherDataResult>>() {
            public PlayFabResult<SetPublisherDataResult> call() throws Exception {
                return privateSetPublisherDataAsync(request);
            }
        });
    }

    /**
     * Updates the key-value store of custom publisher settings
     */
    public static PlayFabResult<SetPublisherDataResult> SetPublisherData(SetPublisherDataRequest request) {
        FutureTask<PlayFabResult<SetPublisherDataResult>> task = new FutureTask(new Callable<PlayFabResult<SetPublisherDataResult>>() {
            public PlayFabResult<SetPublisherDataResult> call() throws Exception {
                return privateSetPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the key-value store of custom publisher settings
     */
    private static PlayFabResult<SetPublisherDataResult> privateSetPublisherDataAsync(SetPublisherDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/SetPublisherData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetPublisherDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<SetPublisherDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetPublisherDataResult>>(){}.getType()); 
        SetPublisherDataResult result = resultData.data;
        
        PlayFabResult<SetPublisherDataResult> pfResult = new PlayFabResult<SetPublisherDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated or added in this call will be readable by users not in the group. By default, data permissions are set to Private. Regardless of the permission setting, only members of the group (and the server) can update the data.
     */
    public static FutureTask<PlayFabResult<UpdateSharedGroupDataResult>> UpdateSharedGroupDataAsync(UpdateSharedGroupDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateSharedGroupDataResult>>() {
            public PlayFabResult<UpdateSharedGroupDataResult> call() throws Exception {
                return privateUpdateSharedGroupDataAsync(request);
            }
        });
    }

    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated or added in this call will be readable by users not in the group. By default, data permissions are set to Private. Regardless of the permission setting, only members of the group (and the server) can update the data.
     */
    public static PlayFabResult<UpdateSharedGroupDataResult> UpdateSharedGroupData(UpdateSharedGroupDataRequest request) {
        FutureTask<PlayFabResult<UpdateSharedGroupDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateSharedGroupDataResult>>() {
            public PlayFabResult<UpdateSharedGroupDataResult> call() throws Exception {
                return privateUpdateSharedGroupDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated or added in this call will be readable by users not in the group. By default, data permissions are set to Private. Regardless of the permission setting, only members of the group (and the server) can update the data.
     */
    private static PlayFabResult<UpdateSharedGroupDataResult> privateUpdateSharedGroupDataAsync(UpdateSharedGroupDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateSharedGroupData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateSharedGroupDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateSharedGroupDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateSharedGroupDataResult>>(){}.getType()); 
        UpdateSharedGroupDataResult result = resultData.data;
        
        PlayFabResult<UpdateSharedGroupDataResult> pfResult = new PlayFabResult<UpdateSharedGroupDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent  HTTP GET to the returned URL will attempt to download the content. A HEAD query to the returned URL will attempt to  retrieve the metadata of the content. Note that a successful result does not guarantee the existence of this content -  if it has not been uploaded, the query to retrieve the data will fail. See this post for more information:  https://support.playfab.com/support/discussions/topics/1000059929
     */
    public static FutureTask<PlayFabResult<GetContentDownloadUrlResult>> GetContentDownloadUrlAsync(GetContentDownloadUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContentDownloadUrlResult>>() {
            public PlayFabResult<GetContentDownloadUrlResult> call() throws Exception {
                return privateGetContentDownloadUrlAsync(request);
            }
        });
    }

    /**
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent  HTTP GET to the returned URL will attempt to download the content. A HEAD query to the returned URL will attempt to  retrieve the metadata of the content. Note that a successful result does not guarantee the existence of this content -  if it has not been uploaded, the query to retrieve the data will fail. See this post for more information:  https://support.playfab.com/support/discussions/topics/1000059929
     */
    public static PlayFabResult<GetContentDownloadUrlResult> GetContentDownloadUrl(GetContentDownloadUrlRequest request) {
        FutureTask<PlayFabResult<GetContentDownloadUrlResult>> task = new FutureTask(new Callable<PlayFabResult<GetContentDownloadUrlResult>>() {
            public PlayFabResult<GetContentDownloadUrlResult> call() throws Exception {
                return privateGetContentDownloadUrlAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent  HTTP GET to the returned URL will attempt to download the content. A HEAD query to the returned URL will attempt to  retrieve the metadata of the content. Note that a successful result does not guarantee the existence of this content -  if it has not been uploaded, the query to retrieve the data will fail. See this post for more information:  https://support.playfab.com/support/discussions/topics/1000059929
     */
    private static PlayFabResult<GetContentDownloadUrlResult> privateGetContentDownloadUrlAsync(GetContentDownloadUrlRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetContentDownloadUrl", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetContentDownloadUrlResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetContentDownloadUrlResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetContentDownloadUrlResult>>(){}.getType()); 
        GetContentDownloadUrlResult result = resultData.data;
        
        PlayFabResult<GetContentDownloadUrlResult> pfResult = new PlayFabResult<GetContentDownloadUrlResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Deletes the specific character ID from the specified user.
     */
    public static FutureTask<PlayFabResult<DeleteCharacterFromUserResult>> DeleteCharacterFromUserAsync(DeleteCharacterFromUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteCharacterFromUserResult>>() {
            public PlayFabResult<DeleteCharacterFromUserResult> call() throws Exception {
                return privateDeleteCharacterFromUserAsync(request);
            }
        });
    }

    /**
     * Deletes the specific character ID from the specified user.
     */
    public static PlayFabResult<DeleteCharacterFromUserResult> DeleteCharacterFromUser(DeleteCharacterFromUserRequest request) {
        FutureTask<PlayFabResult<DeleteCharacterFromUserResult>> task = new FutureTask(new Callable<PlayFabResult<DeleteCharacterFromUserResult>>() {
            public PlayFabResult<DeleteCharacterFromUserResult> call() throws Exception {
                return privateDeleteCharacterFromUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Deletes the specific character ID from the specified user.
     */
    private static PlayFabResult<DeleteCharacterFromUserResult> privateDeleteCharacterFromUserAsync(DeleteCharacterFromUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/DeleteCharacterFromUser", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteCharacterFromUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<DeleteCharacterFromUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteCharacterFromUserResult>>(){}.getType()); 
        DeleteCharacterFromUserResult result = resultData.data;
        
        PlayFabResult<DeleteCharacterFromUserResult> pfResult = new PlayFabResult<DeleteCharacterFromUserResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Lists all of the characters that belong to a specific user.
     */
    public static FutureTask<PlayFabResult<ListUsersCharactersResult>> GetAllUsersCharactersAsync(ListUsersCharactersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListUsersCharactersResult>>() {
            public PlayFabResult<ListUsersCharactersResult> call() throws Exception {
                return privateGetAllUsersCharactersAsync(request);
            }
        });
    }

    /**
     * Lists all of the characters that belong to a specific user.
     */
    public static PlayFabResult<ListUsersCharactersResult> GetAllUsersCharacters(ListUsersCharactersRequest request) {
        FutureTask<PlayFabResult<ListUsersCharactersResult>> task = new FutureTask(new Callable<PlayFabResult<ListUsersCharactersResult>>() {
            public PlayFabResult<ListUsersCharactersResult> call() throws Exception {
                return privateGetAllUsersCharactersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Lists all of the characters that belong to a specific user.
     */
    private static PlayFabResult<ListUsersCharactersResult> privateGetAllUsersCharactersAsync(ListUsersCharactersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetAllUsersCharacters", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListUsersCharactersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ListUsersCharactersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListUsersCharactersResult>>(){}.getType()); 
        ListUsersCharactersResult result = resultData.data;
        
        PlayFabResult<ListUsersCharactersResult> pfResult = new PlayFabResult<ListUsersCharactersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of ranked characters for the given statistic, starting from the indicated point in the leaderboard
     */
    public static FutureTask<PlayFabResult<GetCharacterLeaderboardResult>> GetCharacterLeaderboardAsync(GetCharacterLeaderboardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterLeaderboardResult>>() {
            public PlayFabResult<GetCharacterLeaderboardResult> call() throws Exception {
                return privateGetCharacterLeaderboardAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked characters for the given statistic, starting from the indicated point in the leaderboard
     */
    public static PlayFabResult<GetCharacterLeaderboardResult> GetCharacterLeaderboard(GetCharacterLeaderboardRequest request) {
        FutureTask<PlayFabResult<GetCharacterLeaderboardResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterLeaderboardResult>>() {
            public PlayFabResult<GetCharacterLeaderboardResult> call() throws Exception {
                return privateGetCharacterLeaderboardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of ranked characters for the given statistic, starting from the indicated point in the leaderboard
     */
    private static PlayFabResult<GetCharacterLeaderboardResult> privateGetCharacterLeaderboardAsync(GetCharacterLeaderboardRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetCharacterLeaderboard", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterLeaderboardResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterLeaderboardResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterLeaderboardResult>>(){}.getType()); 
        GetCharacterLeaderboardResult result = resultData.data;
        
        PlayFabResult<GetCharacterLeaderboardResult> pfResult = new PlayFabResult<GetCharacterLeaderboardResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the details of all title-specific statistics for the specific character
     */
    public static FutureTask<PlayFabResult<GetCharacterStatisticsResult>> GetCharacterStatisticsAsync(GetCharacterStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterStatisticsResult>>() {
            public PlayFabResult<GetCharacterStatisticsResult> call() throws Exception {
                return privateGetCharacterStatisticsAsync(request);
            }
        });
    }

    /**
     * Retrieves the details of all title-specific statistics for the specific character
     */
    public static PlayFabResult<GetCharacterStatisticsResult> GetCharacterStatistics(GetCharacterStatisticsRequest request) {
        FutureTask<PlayFabResult<GetCharacterStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterStatisticsResult>>() {
            public PlayFabResult<GetCharacterStatisticsResult> call() throws Exception {
                return privateGetCharacterStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the details of all title-specific statistics for the specific character
     */
    private static PlayFabResult<GetCharacterStatisticsResult> privateGetCharacterStatisticsAsync(GetCharacterStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetCharacterStatistics", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterStatisticsResult>>(){}.getType()); 
        GetCharacterStatisticsResult result = resultData.data;
        
        PlayFabResult<GetCharacterStatisticsResult> pfResult = new PlayFabResult<GetCharacterStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of ranked characters for the given statistic, centered on the requested user
     */
    public static FutureTask<PlayFabResult<GetLeaderboardAroundCharacterResult>> GetLeaderboardAroundCharacterAsync(GetLeaderboardAroundCharacterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundCharacterResult>>() {
            public PlayFabResult<GetLeaderboardAroundCharacterResult> call() throws Exception {
                return privateGetLeaderboardAroundCharacterAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked characters for the given statistic, centered on the requested user
     */
    public static PlayFabResult<GetLeaderboardAroundCharacterResult> GetLeaderboardAroundCharacter(GetLeaderboardAroundCharacterRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardAroundCharacterResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundCharacterResult>>() {
            public PlayFabResult<GetLeaderboardAroundCharacterResult> call() throws Exception {
                return privateGetLeaderboardAroundCharacterAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of ranked characters for the given statistic, centered on the requested user
     */
    private static PlayFabResult<GetLeaderboardAroundCharacterResult> privateGetLeaderboardAroundCharacterAsync(GetLeaderboardAroundCharacterRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetLeaderboardAroundCharacter", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardAroundCharacterResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetLeaderboardAroundCharacterResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardAroundCharacterResult>>(){}.getType()); 
        GetLeaderboardAroundCharacterResult result = resultData.data;
        
        PlayFabResult<GetLeaderboardAroundCharacterResult> pfResult = new PlayFabResult<GetLeaderboardAroundCharacterResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of all of the user's characters for the given statistic.
     */
    public static FutureTask<PlayFabResult<GetLeaderboardForUsersCharactersResult>> GetLeaderboardForUserCharactersAsync(GetLeaderboardForUsersCharactersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardForUsersCharactersResult>>() {
            public PlayFabResult<GetLeaderboardForUsersCharactersResult> call() throws Exception {
                return privateGetLeaderboardForUserCharactersAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of all of the user's characters for the given statistic.
     */
    public static PlayFabResult<GetLeaderboardForUsersCharactersResult> GetLeaderboardForUserCharacters(GetLeaderboardForUsersCharactersRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardForUsersCharactersResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardForUsersCharactersResult>>() {
            public PlayFabResult<GetLeaderboardForUsersCharactersResult> call() throws Exception {
                return privateGetLeaderboardForUserCharactersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of all of the user's characters for the given statistic.
     */
    private static PlayFabResult<GetLeaderboardForUsersCharactersResult> privateGetLeaderboardForUserCharactersAsync(GetLeaderboardForUsersCharactersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetLeaderboardForUserCharacters", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardForUsersCharactersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetLeaderboardForUsersCharactersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardForUsersCharactersResult>>(){}.getType()); 
        GetLeaderboardForUsersCharactersResult result = resultData.data;
        
        PlayFabResult<GetLeaderboardForUsersCharactersResult> pfResult = new PlayFabResult<GetLeaderboardForUsersCharactersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Grants the specified character type to the user.
     */
    public static FutureTask<PlayFabResult<GrantCharacterToUserResult>> GrantCharacterToUserAsync(GrantCharacterToUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantCharacterToUserResult>>() {
            public PlayFabResult<GrantCharacterToUserResult> call() throws Exception {
                return privateGrantCharacterToUserAsync(request);
            }
        });
    }

    /**
     * Grants the specified character type to the user.
     */
    public static PlayFabResult<GrantCharacterToUserResult> GrantCharacterToUser(GrantCharacterToUserRequest request) {
        FutureTask<PlayFabResult<GrantCharacterToUserResult>> task = new FutureTask(new Callable<PlayFabResult<GrantCharacterToUserResult>>() {
            public PlayFabResult<GrantCharacterToUserResult> call() throws Exception {
                return privateGrantCharacterToUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Grants the specified character type to the user.
     */
    private static PlayFabResult<GrantCharacterToUserResult> privateGrantCharacterToUserAsync(GrantCharacterToUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GrantCharacterToUser", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GrantCharacterToUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GrantCharacterToUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GrantCharacterToUserResult>>(){}.getType()); 
        GrantCharacterToUserResult result = resultData.data;
        
        PlayFabResult<GrantCharacterToUserResult> pfResult = new PlayFabResult<GrantCharacterToUserResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the values of the specified title-specific statistics for the specific character
     */
    public static FutureTask<PlayFabResult<UpdateCharacterStatisticsResult>> UpdateCharacterStatisticsAsync(UpdateCharacterStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCharacterStatisticsResult>>() {
            public PlayFabResult<UpdateCharacterStatisticsResult> call() throws Exception {
                return privateUpdateCharacterStatisticsAsync(request);
            }
        });
    }

    /**
     * Updates the values of the specified title-specific statistics for the specific character
     */
    public static PlayFabResult<UpdateCharacterStatisticsResult> UpdateCharacterStatistics(UpdateCharacterStatisticsRequest request) {
        FutureTask<PlayFabResult<UpdateCharacterStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCharacterStatisticsResult>>() {
            public PlayFabResult<UpdateCharacterStatisticsResult> call() throws Exception {
                return privateUpdateCharacterStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the values of the specified title-specific statistics for the specific character
     */
    private static PlayFabResult<UpdateCharacterStatisticsResult> privateUpdateCharacterStatisticsAsync(UpdateCharacterStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateCharacterStatistics", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCharacterStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateCharacterStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCharacterStatisticsResult>>(){}.getType()); 
        UpdateCharacterStatisticsResult result = resultData.data;
        
        PlayFabResult<UpdateCharacterStatisticsResult> pfResult = new PlayFabResult<UpdateCharacterStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<GetCharacterDataResult>> GetCharacterDataAsync(GetCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    public static PlayFabResult<GetCharacterDataResult> GetCharacterData(GetCharacterDataRequest request) {
        FutureTask<PlayFabResult<GetCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterDataAsync(GetCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetCharacterData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterDataResult>>(){}.getType()); 
        GetCharacterDataResult result = resultData.data;
        
        PlayFabResult<GetCharacterDataResult> pfResult = new PlayFabResult<GetCharacterDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the user's character which cannot be accessed by the client
     */
    public static FutureTask<PlayFabResult<GetCharacterDataResult>> GetCharacterInternalDataAsync(GetCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user's character which cannot be accessed by the client
     */
    public static PlayFabResult<GetCharacterDataResult> GetCharacterInternalData(GetCharacterDataRequest request) {
        FutureTask<PlayFabResult<GetCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the user's character which cannot be accessed by the client
     */
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterInternalDataAsync(GetCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetCharacterInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterDataResult>>(){}.getType()); 
        GetCharacterDataResult result = resultData.data;
        
        PlayFabResult<GetCharacterDataResult> pfResult = new PlayFabResult<GetCharacterDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the user's character which can only be read by the client
     */
    public static FutureTask<PlayFabResult<GetCharacterDataResult>> GetCharacterReadOnlyDataAsync(GetCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user's character which can only be read by the client
     */
    public static PlayFabResult<GetCharacterDataResult> GetCharacterReadOnlyData(GetCharacterDataRequest request) {
        FutureTask<PlayFabResult<GetCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the user's character which can only be read by the client
     */
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterReadOnlyDataAsync(GetCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/GetCharacterReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterDataResult>>(){}.getType()); 
        GetCharacterDataResult result = resultData.data;
        
        PlayFabResult<GetCharacterDataResult> pfResult = new PlayFabResult<GetCharacterDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the title-specific custom data for the user's chjaracter which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<UpdateCharacterDataResult>> UpdateCharacterDataAsync(UpdateCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user's chjaracter which is readable and writable by the client
     */
    public static PlayFabResult<UpdateCharacterDataResult> UpdateCharacterData(UpdateCharacterDataRequest request) {
        FutureTask<PlayFabResult<UpdateCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the title-specific custom data for the user's chjaracter which is readable and writable by the client
     */
    private static PlayFabResult<UpdateCharacterDataResult> privateUpdateCharacterDataAsync(UpdateCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateCharacterData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCharacterDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateCharacterDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCharacterDataResult>>(){}.getType()); 
        UpdateCharacterDataResult result = resultData.data;
        
        PlayFabResult<UpdateCharacterDataResult> pfResult = new PlayFabResult<UpdateCharacterDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the title-specific custom data for the user's character which cannot  be accessed by the client
     */
    public static FutureTask<PlayFabResult<UpdateCharacterDataResult>> UpdateCharacterInternalDataAsync(UpdateCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user's character which cannot  be accessed by the client
     */
    public static PlayFabResult<UpdateCharacterDataResult> UpdateCharacterInternalData(UpdateCharacterDataRequest request) {
        FutureTask<PlayFabResult<UpdateCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the title-specific custom data for the user's character which cannot  be accessed by the client
     */
    private static PlayFabResult<UpdateCharacterDataResult> privateUpdateCharacterInternalDataAsync(UpdateCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateCharacterInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCharacterDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateCharacterDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCharacterDataResult>>(){}.getType()); 
        UpdateCharacterDataResult result = resultData.data;
        
        PlayFabResult<UpdateCharacterDataResult> pfResult = new PlayFabResult<UpdateCharacterDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the title-specific custom data for the user's character which can only be read by the client
     */
    public static FutureTask<PlayFabResult<UpdateCharacterDataResult>> UpdateCharacterReadOnlyDataAsync(UpdateCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user's character which can only be read by the client
     */
    public static PlayFabResult<UpdateCharacterDataResult> UpdateCharacterReadOnlyData(UpdateCharacterDataRequest request) {
        FutureTask<PlayFabResult<UpdateCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the title-specific custom data for the user's character which can only be read by the client
     */
    private static PlayFabResult<UpdateCharacterDataResult> privateUpdateCharacterReadOnlyDataAsync(UpdateCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Server/UpdateCharacterReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCharacterDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateCharacterDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCharacterDataResult>>(){}.getType()); 
        UpdateCharacterDataResult result = resultData.data;
        
        PlayFabResult<UpdateCharacterDataResult> pfResult = new PlayFabResult<UpdateCharacterDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    
}
