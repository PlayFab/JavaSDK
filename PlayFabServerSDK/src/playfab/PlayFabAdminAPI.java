package playfab;

import playfab.internal.*;
import playfab.PlayFabAdminModels.*;
import playfab.PlayFabErrors.*;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;


/**
 * APIs for managing title configurations, uploaded Game Server code executables, and user data
 */
public class PlayFabAdminAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-DD'T'hh:mm:ss.SSS'Z'").create();
    
    /**
     * Retrieves the relevant details for a specified user, based upon a match against a supplied unique identifier
     */
    public static FutureTask<PlayFabResult<LookupUserAccountInfoResult>> GetUserAccountInfoAsync(LookupUserAccountInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LookupUserAccountInfoResult>>() {
            public PlayFabResult<LookupUserAccountInfoResult> call() throws Exception {
                return privateGetUserAccountInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the relevant details for a specified user, based upon a match against a supplied unique identifier
     */
    public static PlayFabResult<LookupUserAccountInfoResult> GetUserAccountInfo(LookupUserAccountInfoRequest request) {
        FutureTask<PlayFabResult<LookupUserAccountInfoResult>> task = new FutureTask(new Callable<PlayFabResult<LookupUserAccountInfoResult>>() {
            public PlayFabResult<LookupUserAccountInfoResult> call() throws Exception {
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
     * Retrieves the relevant details for a specified user, based upon a match against a supplied unique identifier
     */
    private static PlayFabResult<LookupUserAccountInfoResult> privateGetUserAccountInfoAsync(LookupUserAccountInfoRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetUserAccountInfo", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LookupUserAccountInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LookupUserAccountInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LookupUserAccountInfoResult>>(){}.getType()); 
        LookupUserAccountInfoResult result = resultData.data;
        
        PlayFabResult<LookupUserAccountInfoResult> pfResult = new PlayFabResult<LookupUserAccountInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Resets all title-specific information about a particular account, including user data, virtual currency balances, inventory, purchase history, and statistics
     */
    public static FutureTask<PlayFabResult<BlankResult>> ResetUsersAsync(ResetUsersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateResetUsersAsync(request);
            }
        });
    }

    /**
     * Resets all title-specific information about a particular account, including user data, virtual currency balances, inventory, purchase history, and statistics
     */
    public static PlayFabResult<BlankResult> ResetUsers(ResetUsersRequest request) {
        FutureTask<PlayFabResult<BlankResult>> task = new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateResetUsersAsync(request);
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
     * Resets all title-specific information about a particular account, including user data, virtual currency balances, inventory, purchase history, and statistics
     */
    private static PlayFabResult<BlankResult> privateResetUsersAsync(ResetUsersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/ResetUsers", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BlankResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<BlankResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BlankResult>>(){}.getType()); 
        BlankResult result = resultData.data;
        
        PlayFabResult<BlankResult> pfResult = new PlayFabResult<BlankResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Forces an email to be sent to the registered email address for the specified account, with a link allowing the user to change the password
     */
    public static FutureTask<PlayFabResult<SendAccountRecoveryEmailResult>> SendAccountRecoveryEmailAsync(SendAccountRecoveryEmailRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SendAccountRecoveryEmailResult>>() {
            public PlayFabResult<SendAccountRecoveryEmailResult> call() throws Exception {
                return privateSendAccountRecoveryEmailAsync(request);
            }
        });
    }

    /**
     * Forces an email to be sent to the registered email address for the specified account, with a link allowing the user to change the password
     */
    public static PlayFabResult<SendAccountRecoveryEmailResult> SendAccountRecoveryEmail(SendAccountRecoveryEmailRequest request) {
        FutureTask<PlayFabResult<SendAccountRecoveryEmailResult>> task = new FutureTask(new Callable<PlayFabResult<SendAccountRecoveryEmailResult>>() {
            public PlayFabResult<SendAccountRecoveryEmailResult> call() throws Exception {
                return privateSendAccountRecoveryEmailAsync(request);
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
     * Forces an email to be sent to the registered email address for the specified account, with a link allowing the user to change the password
     */
    private static PlayFabResult<SendAccountRecoveryEmailResult> privateSendAccountRecoveryEmailAsync(SendAccountRecoveryEmailRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/SendAccountRecoveryEmail", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SendAccountRecoveryEmailResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<SendAccountRecoveryEmailResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SendAccountRecoveryEmailResult>>(){}.getType()); 
        SendAccountRecoveryEmailResult result = resultData.data;
        
        PlayFabResult<SendAccountRecoveryEmailResult> pfResult = new PlayFabResult<SendAccountRecoveryEmailResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the title specific display name for a user
     */
    public static FutureTask<PlayFabResult<UpdateUserTitleDisplayNameResult>> UpdateUserTitleDisplayNameAsync(UpdateUserTitleDisplayNameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserTitleDisplayNameResult>>() {
            public PlayFabResult<UpdateUserTitleDisplayNameResult> call() throws Exception {
                return privateUpdateUserTitleDisplayNameAsync(request);
            }
        });
    }

    /**
     * Updates the title specific display name for a user
     */
    public static PlayFabResult<UpdateUserTitleDisplayNameResult> UpdateUserTitleDisplayName(UpdateUserTitleDisplayNameRequest request) {
        FutureTask<PlayFabResult<UpdateUserTitleDisplayNameResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserTitleDisplayNameResult>>() {
            public PlayFabResult<UpdateUserTitleDisplayNameResult> call() throws Exception {
                return privateUpdateUserTitleDisplayNameAsync(request);
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
     * Updates the title specific display name for a user
     */
    private static PlayFabResult<UpdateUserTitleDisplayNameResult> privateUpdateUserTitleDisplayNameAsync(UpdateUserTitleDisplayNameRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateUserTitleDisplayName", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserTitleDisplayNameResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserTitleDisplayNameResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserTitleDisplayNameResult>>(){}.getType()); 
        UpdateUserTitleDisplayNameResult result = resultData.data;
        
        PlayFabResult<UpdateUserTitleDisplayNameResult> pfResult = new PlayFabResult<UpdateUserTitleDisplayNameResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Deletes the users for the provided game. Deletes custom data, all account linkages, and statistics.
     */
    public static FutureTask<PlayFabResult<DeleteUsersResult>> DeleteUsersAsync(DeleteUsersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteUsersResult>>() {
            public PlayFabResult<DeleteUsersResult> call() throws Exception {
                return privateDeleteUsersAsync(request);
            }
        });
    }

    /**
     * Deletes the users for the provided game. Deletes custom data, all account linkages, and statistics.
     */
    public static PlayFabResult<DeleteUsersResult> DeleteUsers(DeleteUsersRequest request) {
        FutureTask<PlayFabResult<DeleteUsersResult>> task = new FutureTask(new Callable<PlayFabResult<DeleteUsersResult>>() {
            public PlayFabResult<DeleteUsersResult> call() throws Exception {
                return privateDeleteUsersAsync(request);
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
     * Deletes the users for the provided game. Deletes custom data, all account linkages, and statistics.
     */
    private static PlayFabResult<DeleteUsersResult> privateDeleteUsersAsync(DeleteUsersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/DeleteUsers", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteUsersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<DeleteUsersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteUsersResult>>(){}.getType()); 
        DeleteUsersResult result = resultData.data;
        
        PlayFabResult<DeleteUsersResult> pfResult = new PlayFabResult<DeleteUsersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a download URL for the requested report
     */
    public static FutureTask<PlayFabResult<GetDataReportResult>> GetDataReportAsync(GetDataReportRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetDataReportResult>>() {
            public PlayFabResult<GetDataReportResult> call() throws Exception {
                return privateGetDataReportAsync(request);
            }
        });
    }

    /**
     * Retrieves a download URL for the requested report
     */
    public static PlayFabResult<GetDataReportResult> GetDataReport(GetDataReportRequest request) {
        FutureTask<PlayFabResult<GetDataReportResult>> task = new FutureTask(new Callable<PlayFabResult<GetDataReportResult>>() {
            public PlayFabResult<GetDataReportResult> call() throws Exception {
                return privateGetDataReportAsync(request);
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
     * Retrieves a download URL for the requested report
     */
    private static PlayFabResult<GetDataReportResult> privateGetDataReportAsync(GetDataReportRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetDataReport", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetDataReportResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetDataReportResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetDataReportResult>>(){}.getType()); 
        GetDataReportResult result = resultData.data;
        
        PlayFabResult<GetDataReportResult> pfResult = new PlayFabResult<GetDataReportResult>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetUserData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetUserInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetUserPublisherData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetUserPublisherInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetUserPublisherReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetUserReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Completely removes all statistics for the specified user, for the current game
     */
    public static FutureTask<PlayFabResult<ResetUserStatisticsResult>> ResetUserStatisticsAsync(ResetUserStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ResetUserStatisticsResult>>() {
            public PlayFabResult<ResetUserStatisticsResult> call() throws Exception {
                return privateResetUserStatisticsAsync(request);
            }
        });
    }

    /**
     * Completely removes all statistics for the specified user, for the current game
     */
    public static PlayFabResult<ResetUserStatisticsResult> ResetUserStatistics(ResetUserStatisticsRequest request) {
        FutureTask<PlayFabResult<ResetUserStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<ResetUserStatisticsResult>>() {
            public PlayFabResult<ResetUserStatisticsResult> call() throws Exception {
                return privateResetUserStatisticsAsync(request);
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
     * Completely removes all statistics for the specified user, for the current game
     */
    private static PlayFabResult<ResetUserStatisticsResult> privateResetUserStatisticsAsync(ResetUserStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/ResetUserStatistics", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ResetUserStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ResetUserStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ResetUserStatisticsResult>>(){}.getType()); 
        ResetUserStatisticsResult result = resultData.data;
        
        PlayFabResult<ResetUserStatisticsResult> pfResult = new PlayFabResult<ResetUserStatisticsResult>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateUserData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateUserInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateUserPublisherData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateUserPublisherInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateUserPublisherReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateUserReadOnlyData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Adds a new news item to the title's news feed
     */
    public static FutureTask<PlayFabResult<AddNewsResult>> AddNewsAsync(AddNewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddNewsResult>>() {
            public PlayFabResult<AddNewsResult> call() throws Exception {
                return privateAddNewsAsync(request);
            }
        });
    }

    /**
     * Adds a new news item to the title's news feed
     */
    public static PlayFabResult<AddNewsResult> AddNews(AddNewsRequest request) {
        FutureTask<PlayFabResult<AddNewsResult>> task = new FutureTask(new Callable<PlayFabResult<AddNewsResult>>() {
            public PlayFabResult<AddNewsResult> call() throws Exception {
                return privateAddNewsAsync(request);
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
     * Adds a new news item to the title's news feed
     */
    private static PlayFabResult<AddNewsResult> privateAddNewsAsync(AddNewsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/AddNews", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddNewsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AddNewsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddNewsResult>>(){}.getType()); 
        AddNewsResult result = resultData.data;
        
        PlayFabResult<AddNewsResult> pfResult = new PlayFabResult<AddNewsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds one or more virtual currencies to the set defined for the title. Virtual Currencies have a maximum value of 2,147,483,647 when granted to a player. Any value over that will be discarded.
     */
    public static FutureTask<PlayFabResult<BlankResult>> AddVirtualCurrencyTypesAsync(AddVirtualCurrencyTypesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateAddVirtualCurrencyTypesAsync(request);
            }
        });
    }

    /**
     * Adds one or more virtual currencies to the set defined for the title. Virtual Currencies have a maximum value of 2,147,483,647 when granted to a player. Any value over that will be discarded.
     */
    public static PlayFabResult<BlankResult> AddVirtualCurrencyTypes(AddVirtualCurrencyTypesRequest request) {
        FutureTask<PlayFabResult<BlankResult>> task = new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateAddVirtualCurrencyTypesAsync(request);
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
     * Adds one or more virtual currencies to the set defined for the title. Virtual Currencies have a maximum value of 2,147,483,647 when granted to a player. Any value over that will be discarded.
     */
    private static PlayFabResult<BlankResult> privateAddVirtualCurrencyTypesAsync(AddVirtualCurrencyTypesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/AddVirtualCurrencyTypes", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BlankResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<BlankResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BlankResult>>(){}.getType()); 
        BlankResult result = resultData.data;
        
        PlayFabResult<BlankResult> pfResult = new PlayFabResult<BlankResult>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetCatalogItems", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the random drop table configuration for the title
     */
    public static FutureTask<PlayFabResult<GetRandomResultTablesResult>> GetRandomResultTablesAsync(GetRandomResultTablesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetRandomResultTablesResult>>() {
            public PlayFabResult<GetRandomResultTablesResult> call() throws Exception {
                return privateGetRandomResultTablesAsync(request);
            }
        });
    }

    /**
     * Retrieves the random drop table configuration for the title
     */
    public static PlayFabResult<GetRandomResultTablesResult> GetRandomResultTables(GetRandomResultTablesRequest request) {
        FutureTask<PlayFabResult<GetRandomResultTablesResult>> task = new FutureTask(new Callable<PlayFabResult<GetRandomResultTablesResult>>() {
            public PlayFabResult<GetRandomResultTablesResult> call() throws Exception {
                return privateGetRandomResultTablesAsync(request);
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
     * Retrieves the random drop table configuration for the title
     */
    private static PlayFabResult<GetRandomResultTablesResult> privateGetRandomResultTablesAsync(GetRandomResultTablesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetRandomResultTables", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetRandomResultTablesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetRandomResultTablesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetRandomResultTablesResult>>(){}.getType()); 
        GetRandomResultTablesResult result = resultData.data;
        
        PlayFabResult<GetRandomResultTablesResult> pfResult = new PlayFabResult<GetRandomResultTablesResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the set of items defined for the specified store, including all prices defined
     */
    public static FutureTask<PlayFabResult<GetStoreItemsResult>> GetStoreItemsAsync(GetStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetStoreItemsResult>>() {
            public PlayFabResult<GetStoreItemsResult> call() throws Exception {
                return privateGetStoreItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves the set of items defined for the specified store, including all prices defined
     */
    public static PlayFabResult<GetStoreItemsResult> GetStoreItems(GetStoreItemsRequest request) {
        FutureTask<PlayFabResult<GetStoreItemsResult>> task = new FutureTask(new Callable<PlayFabResult<GetStoreItemsResult>>() {
            public PlayFabResult<GetStoreItemsResult> call() throws Exception {
                return privateGetStoreItemsAsync(request);
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
     * Retrieves the set of items defined for the specified store, including all prices defined
     */
    private static PlayFabResult<GetStoreItemsResult> privateGetStoreItemsAsync(GetStoreItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetStoreItems", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetStoreItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetStoreItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetStoreItemsResult>>(){}.getType()); 
        GetStoreItemsResult result = resultData.data;
        
        PlayFabResult<GetStoreItemsResult> pfResult = new PlayFabResult<GetStoreItemsResult>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetTitleData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retuns the list of all defined virtual currencies for the title
     */
    public static FutureTask<PlayFabResult<ListVirtualCurrencyTypesResult>> ListVirtualCurrencyTypesAsync(ListVirtualCurrencyTypesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListVirtualCurrencyTypesResult>>() {
            public PlayFabResult<ListVirtualCurrencyTypesResult> call() throws Exception {
                return privateListVirtualCurrencyTypesAsync(request);
            }
        });
    }

    /**
     * Retuns the list of all defined virtual currencies for the title
     */
    public static PlayFabResult<ListVirtualCurrencyTypesResult> ListVirtualCurrencyTypes(ListVirtualCurrencyTypesRequest request) {
        FutureTask<PlayFabResult<ListVirtualCurrencyTypesResult>> task = new FutureTask(new Callable<PlayFabResult<ListVirtualCurrencyTypesResult>>() {
            public PlayFabResult<ListVirtualCurrencyTypesResult> call() throws Exception {
                return privateListVirtualCurrencyTypesAsync(request);
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
     * Retuns the list of all defined virtual currencies for the title
     */
    private static PlayFabResult<ListVirtualCurrencyTypesResult> privateListVirtualCurrencyTypesAsync(ListVirtualCurrencyTypesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/ListVirtualCurrencyTypes", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListVirtualCurrencyTypesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ListVirtualCurrencyTypesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListVirtualCurrencyTypesResult>>(){}.getType()); 
        ListVirtualCurrencyTypesResult result = resultData.data;
        
        PlayFabResult<ListVirtualCurrencyTypesResult> pfResult = new PlayFabResult<ListVirtualCurrencyTypesResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Creates the catalog configuration of all virtual goods for the specified catalog version
     */
    public static FutureTask<PlayFabResult<UpdateCatalogItemsResult>> SetCatalogItemsAsync(UpdateCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateSetCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Creates the catalog configuration of all virtual goods for the specified catalog version
     */
    public static PlayFabResult<UpdateCatalogItemsResult> SetCatalogItems(UpdateCatalogItemsRequest request) {
        FutureTask<PlayFabResult<UpdateCatalogItemsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateSetCatalogItemsAsync(request);
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
     * Creates the catalog configuration of all virtual goods for the specified catalog version
     */
    private static PlayFabResult<UpdateCatalogItemsResult> privateSetCatalogItemsAsync(UpdateCatalogItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/SetCatalogItems", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCatalogItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateCatalogItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCatalogItemsResult>>(){}.getType()); 
        UpdateCatalogItemsResult result = resultData.data;
        
        PlayFabResult<UpdateCatalogItemsResult> pfResult = new PlayFabResult<UpdateCatalogItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Sets all the items in one virtual store
     */
    public static FutureTask<PlayFabResult<UpdateStoreItemsResult>> SetStoreItemsAsync(UpdateStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateSetStoreItemsAsync(request);
            }
        });
    }

    /**
     * Sets all the items in one virtual store
     */
    public static PlayFabResult<UpdateStoreItemsResult> SetStoreItems(UpdateStoreItemsRequest request) {
        FutureTask<PlayFabResult<UpdateStoreItemsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateSetStoreItemsAsync(request);
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
     * Sets all the items in one virtual store
     */
    private static PlayFabResult<UpdateStoreItemsResult> privateSetStoreItemsAsync(UpdateStoreItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/SetStoreItems", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateStoreItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateStoreItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateStoreItemsResult>>(){}.getType()); 
        UpdateStoreItemsResult result = resultData.data;
        
        PlayFabResult<UpdateStoreItemsResult> pfResult = new PlayFabResult<UpdateStoreItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Creates and updates the key-value store of custom title settings
     */
    public static FutureTask<PlayFabResult<SetTitleDataResult>> SetTitleDataAsync(SetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleDataAsync(request);
            }
        });
    }

    /**
     * Creates and updates the key-value store of custom title settings
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
     * Creates and updates the key-value store of custom title settings
     */
    private static PlayFabResult<SetTitleDataResult> privateSetTitleDataAsync(SetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/SetTitleData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Sets the Amazon Resource Name (ARN) for iOS and Android push notifications. Documentation on the exact restrictions can be found at: http://docs.aws.amazon.com/sns/latest/api/API_CreatePlatformApplication.html. Currently, Amazon device Messaging is not supported.
     */
    public static FutureTask<PlayFabResult<SetupPushNotificationResult>> SetupPushNotificationAsync(SetupPushNotificationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetupPushNotificationResult>>() {
            public PlayFabResult<SetupPushNotificationResult> call() throws Exception {
                return privateSetupPushNotificationAsync(request);
            }
        });
    }

    /**
     * Sets the Amazon Resource Name (ARN) for iOS and Android push notifications. Documentation on the exact restrictions can be found at: http://docs.aws.amazon.com/sns/latest/api/API_CreatePlatformApplication.html. Currently, Amazon device Messaging is not supported.
     */
    public static PlayFabResult<SetupPushNotificationResult> SetupPushNotification(SetupPushNotificationRequest request) {
        FutureTask<PlayFabResult<SetupPushNotificationResult>> task = new FutureTask(new Callable<PlayFabResult<SetupPushNotificationResult>>() {
            public PlayFabResult<SetupPushNotificationResult> call() throws Exception {
                return privateSetupPushNotificationAsync(request);
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
     * Sets the Amazon Resource Name (ARN) for iOS and Android push notifications. Documentation on the exact restrictions can be found at: http://docs.aws.amazon.com/sns/latest/api/API_CreatePlatformApplication.html. Currently, Amazon device Messaging is not supported.
     */
    private static PlayFabResult<SetupPushNotificationResult> privateSetupPushNotificationAsync(SetupPushNotificationRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/SetupPushNotification", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetupPushNotificationResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<SetupPushNotificationResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetupPushNotificationResult>>(){}.getType()); 
        SetupPushNotificationResult result = resultData.data;
        
        PlayFabResult<SetupPushNotificationResult> pfResult = new PlayFabResult<SetupPushNotificationResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the catalog configuration for virtual goods in the specified catalog version
     */
    public static FutureTask<PlayFabResult<UpdateCatalogItemsResult>> UpdateCatalogItemsAsync(UpdateCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateUpdateCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Updates the catalog configuration for virtual goods in the specified catalog version
     */
    public static PlayFabResult<UpdateCatalogItemsResult> UpdateCatalogItems(UpdateCatalogItemsRequest request) {
        FutureTask<PlayFabResult<UpdateCatalogItemsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateUpdateCatalogItemsAsync(request);
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
     * Updates the catalog configuration for virtual goods in the specified catalog version
     */
    private static PlayFabResult<UpdateCatalogItemsResult> privateUpdateCatalogItemsAsync(UpdateCatalogItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateCatalogItems", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCatalogItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateCatalogItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCatalogItemsResult>>(){}.getType()); 
        UpdateCatalogItemsResult result = resultData.data;
        
        PlayFabResult<UpdateCatalogItemsResult> pfResult = new PlayFabResult<UpdateCatalogItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the random drop table configuration for the title
     */
    public static FutureTask<PlayFabResult<UpdateRandomResultTablesResult>> UpdateRandomResultTablesAsync(UpdateRandomResultTablesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateRandomResultTablesResult>>() {
            public PlayFabResult<UpdateRandomResultTablesResult> call() throws Exception {
                return privateUpdateRandomResultTablesAsync(request);
            }
        });
    }

    /**
     * Updates the random drop table configuration for the title
     */
    public static PlayFabResult<UpdateRandomResultTablesResult> UpdateRandomResultTables(UpdateRandomResultTablesRequest request) {
        FutureTask<PlayFabResult<UpdateRandomResultTablesResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateRandomResultTablesResult>>() {
            public PlayFabResult<UpdateRandomResultTablesResult> call() throws Exception {
                return privateUpdateRandomResultTablesAsync(request);
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
     * Updates the random drop table configuration for the title
     */
    private static PlayFabResult<UpdateRandomResultTablesResult> privateUpdateRandomResultTablesAsync(UpdateRandomResultTablesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateRandomResultTables", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateRandomResultTablesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateRandomResultTablesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateRandomResultTablesResult>>(){}.getType()); 
        UpdateRandomResultTablesResult result = resultData.data;
        
        PlayFabResult<UpdateRandomResultTablesResult> pfResult = new PlayFabResult<UpdateRandomResultTablesResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates an existing virtual item store with new or modified items
     */
    public static FutureTask<PlayFabResult<UpdateStoreItemsResult>> UpdateStoreItemsAsync(UpdateStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateUpdateStoreItemsAsync(request);
            }
        });
    }

    /**
     * Updates an existing virtual item store with new or modified items
     */
    public static PlayFabResult<UpdateStoreItemsResult> UpdateStoreItems(UpdateStoreItemsRequest request) {
        FutureTask<PlayFabResult<UpdateStoreItemsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateUpdateStoreItemsAsync(request);
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
     * Updates an existing virtual item store with new or modified items
     */
    private static PlayFabResult<UpdateStoreItemsResult> privateUpdateStoreItemsAsync(UpdateStoreItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateStoreItems", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateStoreItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateStoreItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateStoreItemsResult>>(){}.getType()); 
        UpdateStoreItemsResult result = resultData.data;
        
        PlayFabResult<UpdateStoreItemsResult> pfResult = new PlayFabResult<UpdateStoreItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Increments the specified virtual currency by the stated amount
     */
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> AddUserVirtualCurrencyAsync(AddUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateAddUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Increments the specified virtual currency by the stated amount
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
     * Increments the specified virtual currency by the stated amount
     */
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateAddUserVirtualCurrencyAsync(AddUserVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/AddUserVirtualCurrency", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetUserInventory", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GrantItemsToUsers", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Revokes access to an item in a user's inventory
     */
    public static FutureTask<PlayFabResult<RevokeInventoryResult>> RevokeInventoryItemAsync(RevokeInventoryItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RevokeInventoryResult>>() {
            public PlayFabResult<RevokeInventoryResult> call() throws Exception {
                return privateRevokeInventoryItemAsync(request);
            }
        });
    }

    /**
     * Revokes access to an item in a user's inventory
     */
    public static PlayFabResult<RevokeInventoryResult> RevokeInventoryItem(RevokeInventoryItemRequest request) {
        FutureTask<PlayFabResult<RevokeInventoryResult>> task = new FutureTask(new Callable<PlayFabResult<RevokeInventoryResult>>() {
            public PlayFabResult<RevokeInventoryResult> call() throws Exception {
                return privateRevokeInventoryItemAsync(request);
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
     * Revokes access to an item in a user's inventory
     */
    private static PlayFabResult<RevokeInventoryResult> privateRevokeInventoryItemAsync(RevokeInventoryItemRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/RevokeInventoryItem", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RevokeInventoryResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RevokeInventoryResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RevokeInventoryResult>>(){}.getType()); 
        RevokeInventoryResult result = resultData.data;
        
        PlayFabResult<RevokeInventoryResult> pfResult = new PlayFabResult<RevokeInventoryResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Decrements the specified virtual currency by the stated amount
     */
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> SubtractUserVirtualCurrencyAsync(SubtractUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateSubtractUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Decrements the specified virtual currency by the stated amount
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
     * Decrements the specified virtual currency by the stated amount
     */
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateSubtractUserVirtualCurrencyAsync(SubtractUserVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/SubtractUserVirtualCurrency", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the details for a specific completed session, including links to standard out and standard error logs
     */
    public static FutureTask<PlayFabResult<GetMatchmakerGameInfoResult>> GetMatchmakerGameInfoAsync(GetMatchmakerGameInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameInfoResult>>() {
            public PlayFabResult<GetMatchmakerGameInfoResult> call() throws Exception {
                return privateGetMatchmakerGameInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the details for a specific completed session, including links to standard out and standard error logs
     */
    public static PlayFabResult<GetMatchmakerGameInfoResult> GetMatchmakerGameInfo(GetMatchmakerGameInfoRequest request) {
        FutureTask<PlayFabResult<GetMatchmakerGameInfoResult>> task = new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameInfoResult>>() {
            public PlayFabResult<GetMatchmakerGameInfoResult> call() throws Exception {
                return privateGetMatchmakerGameInfoAsync(request);
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
     * Retrieves the details for a specific completed session, including links to standard out and standard error logs
     */
    private static PlayFabResult<GetMatchmakerGameInfoResult> privateGetMatchmakerGameInfoAsync(GetMatchmakerGameInfoRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetMatchmakerGameInfo", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMatchmakerGameInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetMatchmakerGameInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMatchmakerGameInfoResult>>(){}.getType()); 
        GetMatchmakerGameInfoResult result = resultData.data;
        
        PlayFabResult<GetMatchmakerGameInfoResult> pfResult = new PlayFabResult<GetMatchmakerGameInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the details of defined game modes for the specified game server executable
     */
    public static FutureTask<PlayFabResult<GetMatchmakerGameModesResult>> GetMatchmakerGameModesAsync(GetMatchmakerGameModesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameModesResult>>() {
            public PlayFabResult<GetMatchmakerGameModesResult> call() throws Exception {
                return privateGetMatchmakerGameModesAsync(request);
            }
        });
    }

    /**
     * Retrieves the details of defined game modes for the specified game server executable
     */
    public static PlayFabResult<GetMatchmakerGameModesResult> GetMatchmakerGameModes(GetMatchmakerGameModesRequest request) {
        FutureTask<PlayFabResult<GetMatchmakerGameModesResult>> task = new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameModesResult>>() {
            public PlayFabResult<GetMatchmakerGameModesResult> call() throws Exception {
                return privateGetMatchmakerGameModesAsync(request);
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
     * Retrieves the details of defined game modes for the specified game server executable
     */
    private static PlayFabResult<GetMatchmakerGameModesResult> privateGetMatchmakerGameModesAsync(GetMatchmakerGameModesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetMatchmakerGameModes", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMatchmakerGameModesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetMatchmakerGameModesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMatchmakerGameModesResult>>(){}.getType()); 
        GetMatchmakerGameModesResult result = resultData.data;
        
        PlayFabResult<GetMatchmakerGameModesResult> pfResult = new PlayFabResult<GetMatchmakerGameModesResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the game server mode details for the specified game server executable
     */
    public static FutureTask<PlayFabResult<ModifyMatchmakerGameModesResult>> ModifyMatchmakerGameModesAsync(ModifyMatchmakerGameModesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyMatchmakerGameModesResult>>() {
            public PlayFabResult<ModifyMatchmakerGameModesResult> call() throws Exception {
                return privateModifyMatchmakerGameModesAsync(request);
            }
        });
    }

    /**
     * Updates the game server mode details for the specified game server executable
     */
    public static PlayFabResult<ModifyMatchmakerGameModesResult> ModifyMatchmakerGameModes(ModifyMatchmakerGameModesRequest request) {
        FutureTask<PlayFabResult<ModifyMatchmakerGameModesResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyMatchmakerGameModesResult>>() {
            public PlayFabResult<ModifyMatchmakerGameModesResult> call() throws Exception {
                return privateModifyMatchmakerGameModesAsync(request);
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
     * Updates the game server mode details for the specified game server executable
     */
    private static PlayFabResult<ModifyMatchmakerGameModesResult> privateModifyMatchmakerGameModesAsync(ModifyMatchmakerGameModesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/ModifyMatchmakerGameModes", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyMatchmakerGameModesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ModifyMatchmakerGameModesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyMatchmakerGameModesResult>>(){}.getType()); 
        ModifyMatchmakerGameModesResult result = resultData.data;
        
        PlayFabResult<ModifyMatchmakerGameModesResult> pfResult = new PlayFabResult<ModifyMatchmakerGameModesResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds the game server executable specified (previously uploaded - see GetServerBuildUploadUrl) to the set of those a client is permitted to request in a call to StartGame
     */
    public static FutureTask<PlayFabResult<AddServerBuildResult>> AddServerBuildAsync(AddServerBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddServerBuildResult>>() {
            public PlayFabResult<AddServerBuildResult> call() throws Exception {
                return privateAddServerBuildAsync(request);
            }
        });
    }

    /**
     * Adds the game server executable specified (previously uploaded - see GetServerBuildUploadUrl) to the set of those a client is permitted to request in a call to StartGame
     */
    public static PlayFabResult<AddServerBuildResult> AddServerBuild(AddServerBuildRequest request) {
        FutureTask<PlayFabResult<AddServerBuildResult>> task = new FutureTask(new Callable<PlayFabResult<AddServerBuildResult>>() {
            public PlayFabResult<AddServerBuildResult> call() throws Exception {
                return privateAddServerBuildAsync(request);
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
     * Adds the game server executable specified (previously uploaded - see GetServerBuildUploadUrl) to the set of those a client is permitted to request in a call to StartGame
     */
    private static PlayFabResult<AddServerBuildResult> privateAddServerBuildAsync(AddServerBuildRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/AddServerBuild", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddServerBuildResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AddServerBuildResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddServerBuildResult>>(){}.getType()); 
        AddServerBuildResult result = resultData.data;
        
        PlayFabResult<AddServerBuildResult> pfResult = new PlayFabResult<AddServerBuildResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the build details for the specified game server executable
     */
    public static FutureTask<PlayFabResult<GetServerBuildInfoResult>> GetServerBuildInfoAsync(GetServerBuildInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetServerBuildInfoResult>>() {
            public PlayFabResult<GetServerBuildInfoResult> call() throws Exception {
                return privateGetServerBuildInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the build details for the specified game server executable
     */
    public static PlayFabResult<GetServerBuildInfoResult> GetServerBuildInfo(GetServerBuildInfoRequest request) {
        FutureTask<PlayFabResult<GetServerBuildInfoResult>> task = new FutureTask(new Callable<PlayFabResult<GetServerBuildInfoResult>>() {
            public PlayFabResult<GetServerBuildInfoResult> call() throws Exception {
                return privateGetServerBuildInfoAsync(request);
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
     * Retrieves the build details for the specified game server executable
     */
    private static PlayFabResult<GetServerBuildInfoResult> privateGetServerBuildInfoAsync(GetServerBuildInfoRequest request) throws Exception {
        
        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetServerBuildInfo", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetServerBuildInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetServerBuildInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetServerBuildInfoResult>>(){}.getType()); 
        GetServerBuildInfoResult result = resultData.data;
        
        PlayFabResult<GetServerBuildInfoResult> pfResult = new PlayFabResult<GetServerBuildInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the pre-authorized URL for uploading a game server package containing a build (does not enable the build for use - see AddServerBuild)
     */
    public static FutureTask<PlayFabResult<GetServerBuildUploadURLResult>> GetServerBuildUploadUrlAsync(GetServerBuildUploadURLRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetServerBuildUploadURLResult>>() {
            public PlayFabResult<GetServerBuildUploadURLResult> call() throws Exception {
                return privateGetServerBuildUploadUrlAsync(request);
            }
        });
    }

    /**
     * Retrieves the pre-authorized URL for uploading a game server package containing a build (does not enable the build for use - see AddServerBuild)
     */
    public static PlayFabResult<GetServerBuildUploadURLResult> GetServerBuildUploadUrl(GetServerBuildUploadURLRequest request) {
        FutureTask<PlayFabResult<GetServerBuildUploadURLResult>> task = new FutureTask(new Callable<PlayFabResult<GetServerBuildUploadURLResult>>() {
            public PlayFabResult<GetServerBuildUploadURLResult> call() throws Exception {
                return privateGetServerBuildUploadUrlAsync(request);
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
     * Retrieves the pre-authorized URL for uploading a game server package containing a build (does not enable the build for use - see AddServerBuild)
     */
    private static PlayFabResult<GetServerBuildUploadURLResult> privateGetServerBuildUploadUrlAsync(GetServerBuildUploadURLRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetServerBuildUploadUrl", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetServerBuildUploadURLResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetServerBuildUploadURLResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetServerBuildUploadURLResult>>(){}.getType()); 
        GetServerBuildUploadURLResult result = resultData.data;
        
        PlayFabResult<GetServerBuildUploadURLResult> pfResult = new PlayFabResult<GetServerBuildUploadURLResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the build details for all game server executables which are currently defined for the title
     */
    public static FutureTask<PlayFabResult<ListBuildsResult>> ListServerBuildsAsync(ListBuildsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListBuildsResult>>() {
            public PlayFabResult<ListBuildsResult> call() throws Exception {
                return privateListServerBuildsAsync(request);
            }
        });
    }

    /**
     * Retrieves the build details for all game server executables which are currently defined for the title
     */
    public static PlayFabResult<ListBuildsResult> ListServerBuilds(ListBuildsRequest request) {
        FutureTask<PlayFabResult<ListBuildsResult>> task = new FutureTask(new Callable<PlayFabResult<ListBuildsResult>>() {
            public PlayFabResult<ListBuildsResult> call() throws Exception {
                return privateListServerBuildsAsync(request);
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
     * Retrieves the build details for all game server executables which are currently defined for the title
     */
    private static PlayFabResult<ListBuildsResult> privateListServerBuildsAsync(ListBuildsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/ListServerBuilds", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListBuildsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ListBuildsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListBuildsResult>>(){}.getType()); 
        ListBuildsResult result = resultData.data;
        
        PlayFabResult<ListBuildsResult> pfResult = new PlayFabResult<ListBuildsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the build details for the specified game server executable
     */
    public static FutureTask<PlayFabResult<ModifyServerBuildResult>> ModifyServerBuildAsync(ModifyServerBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyServerBuildResult>>() {
            public PlayFabResult<ModifyServerBuildResult> call() throws Exception {
                return privateModifyServerBuildAsync(request);
            }
        });
    }

    /**
     * Updates the build details for the specified game server executable
     */
    public static PlayFabResult<ModifyServerBuildResult> ModifyServerBuild(ModifyServerBuildRequest request) {
        FutureTask<PlayFabResult<ModifyServerBuildResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyServerBuildResult>>() {
            public PlayFabResult<ModifyServerBuildResult> call() throws Exception {
                return privateModifyServerBuildAsync(request);
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
     * Updates the build details for the specified game server executable
     */
    private static PlayFabResult<ModifyServerBuildResult> privateModifyServerBuildAsync(ModifyServerBuildRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/ModifyServerBuild", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyServerBuildResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ModifyServerBuildResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyServerBuildResult>>(){}.getType()); 
        ModifyServerBuildResult result = resultData.data;
        
        PlayFabResult<ModifyServerBuildResult> pfResult = new PlayFabResult<ModifyServerBuildResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Removes the game server executable specified from the set of those a client is permitted to request in a call to StartGame
     */
    public static FutureTask<PlayFabResult<RemoveServerBuildResult>> RemoveServerBuildAsync(RemoveServerBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemoveServerBuildResult>>() {
            public PlayFabResult<RemoveServerBuildResult> call() throws Exception {
                return privateRemoveServerBuildAsync(request);
            }
        });
    }

    /**
     * Removes the game server executable specified from the set of those a client is permitted to request in a call to StartGame
     */
    public static PlayFabResult<RemoveServerBuildResult> RemoveServerBuild(RemoveServerBuildRequest request) {
        FutureTask<PlayFabResult<RemoveServerBuildResult>> task = new FutureTask(new Callable<PlayFabResult<RemoveServerBuildResult>>() {
            public PlayFabResult<RemoveServerBuildResult> call() throws Exception {
                return privateRemoveServerBuildAsync(request);
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
     * Removes the game server executable specified from the set of those a client is permitted to request in a call to StartGame
     */
    private static PlayFabResult<RemoveServerBuildResult> privateRemoveServerBuildAsync(RemoveServerBuildRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/RemoveServerBuild", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RemoveServerBuildResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RemoveServerBuildResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RemoveServerBuildResult>>(){}.getType()); 
        RemoveServerBuildResult result = resultData.data;
        
        PlayFabResult<RemoveServerBuildResult> pfResult = new PlayFabResult<RemoveServerBuildResult>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetPublisherData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/SetPublisherData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Gets the contents and information of a specific Cloud Script revision.
     */
    public static FutureTask<PlayFabResult<GetCloudScriptRevisionResult>> GetCloudScriptRevisionAsync(GetCloudScriptRevisionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCloudScriptRevisionResult>>() {
            public PlayFabResult<GetCloudScriptRevisionResult> call() throws Exception {
                return privateGetCloudScriptRevisionAsync(request);
            }
        });
    }

    /**
     * Gets the contents and information of a specific Cloud Script revision.
     */
    public static PlayFabResult<GetCloudScriptRevisionResult> GetCloudScriptRevision(GetCloudScriptRevisionRequest request) {
        FutureTask<PlayFabResult<GetCloudScriptRevisionResult>> task = new FutureTask(new Callable<PlayFabResult<GetCloudScriptRevisionResult>>() {
            public PlayFabResult<GetCloudScriptRevisionResult> call() throws Exception {
                return privateGetCloudScriptRevisionAsync(request);
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
     * Gets the contents and information of a specific Cloud Script revision.
     */
    private static PlayFabResult<GetCloudScriptRevisionResult> privateGetCloudScriptRevisionAsync(GetCloudScriptRevisionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetCloudScriptRevision", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCloudScriptRevisionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCloudScriptRevisionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCloudScriptRevisionResult>>(){}.getType()); 
        GetCloudScriptRevisionResult result = resultData.data;
        
        PlayFabResult<GetCloudScriptRevisionResult> pfResult = new PlayFabResult<GetCloudScriptRevisionResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Lists all the current cloud script versions. For each version, information about the current published and latest revisions is also listed.
     */
    public static FutureTask<PlayFabResult<GetCloudScriptVersionsResult>> GetCloudScriptVersionsAsync(GetCloudScriptVersionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCloudScriptVersionsResult>>() {
            public PlayFabResult<GetCloudScriptVersionsResult> call() throws Exception {
                return privateGetCloudScriptVersionsAsync(request);
            }
        });
    }

    /**
     * Lists all the current cloud script versions. For each version, information about the current published and latest revisions is also listed.
     */
    public static PlayFabResult<GetCloudScriptVersionsResult> GetCloudScriptVersions(GetCloudScriptVersionsRequest request) {
        FutureTask<PlayFabResult<GetCloudScriptVersionsResult>> task = new FutureTask(new Callable<PlayFabResult<GetCloudScriptVersionsResult>>() {
            public PlayFabResult<GetCloudScriptVersionsResult> call() throws Exception {
                return privateGetCloudScriptVersionsAsync(request);
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
     * Lists all the current cloud script versions. For each version, information about the current published and latest revisions is also listed.
     */
    private static PlayFabResult<GetCloudScriptVersionsResult> privateGetCloudScriptVersionsAsync(GetCloudScriptVersionsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetCloudScriptVersions", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCloudScriptVersionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCloudScriptVersionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCloudScriptVersionsResult>>(){}.getType()); 
        GetCloudScriptVersionsResult result = resultData.data;
        
        PlayFabResult<GetCloudScriptVersionsResult> pfResult = new PlayFabResult<GetCloudScriptVersionsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Sets the currently published revision of a title Cloud Script
     */
    public static FutureTask<PlayFabResult<SetPublishedRevisionResult>> SetPublishedRevisionAsync(SetPublishedRevisionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetPublishedRevisionResult>>() {
            public PlayFabResult<SetPublishedRevisionResult> call() throws Exception {
                return privateSetPublishedRevisionAsync(request);
            }
        });
    }

    /**
     * Sets the currently published revision of a title Cloud Script
     */
    public static PlayFabResult<SetPublishedRevisionResult> SetPublishedRevision(SetPublishedRevisionRequest request) {
        FutureTask<PlayFabResult<SetPublishedRevisionResult>> task = new FutureTask(new Callable<PlayFabResult<SetPublishedRevisionResult>>() {
            public PlayFabResult<SetPublishedRevisionResult> call() throws Exception {
                return privateSetPublishedRevisionAsync(request);
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
     * Sets the currently published revision of a title Cloud Script
     */
    private static PlayFabResult<SetPublishedRevisionResult> privateSetPublishedRevisionAsync(SetPublishedRevisionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/SetPublishedRevision", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetPublishedRevisionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<SetPublishedRevisionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetPublishedRevisionResult>>(){}.getType()); 
        SetPublishedRevisionResult result = resultData.data;
        
        PlayFabResult<SetPublishedRevisionResult> pfResult = new PlayFabResult<SetPublishedRevisionResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Creates a new Cloud Script revision and uploads source code to it. Note that at this time, only one file should be submitted in the revision.
     */
    public static FutureTask<PlayFabResult<UpdateCloudScriptResult>> UpdateCloudScriptAsync(UpdateCloudScriptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCloudScriptResult>>() {
            public PlayFabResult<UpdateCloudScriptResult> call() throws Exception {
                return privateUpdateCloudScriptAsync(request);
            }
        });
    }

    /**
     * Creates a new Cloud Script revision and uploads source code to it. Note that at this time, only one file should be submitted in the revision.
     */
    public static PlayFabResult<UpdateCloudScriptResult> UpdateCloudScript(UpdateCloudScriptRequest request) {
        FutureTask<PlayFabResult<UpdateCloudScriptResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCloudScriptResult>>() {
            public PlayFabResult<UpdateCloudScriptResult> call() throws Exception {
                return privateUpdateCloudScriptAsync(request);
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
     * Creates a new Cloud Script revision and uploads source code to it. Note that at this time, only one file should be submitted in the revision.
     */
    private static PlayFabResult<UpdateCloudScriptResult> privateUpdateCloudScriptAsync(UpdateCloudScriptRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateCloudScript", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCloudScriptResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateCloudScriptResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCloudScriptResult>>(){}.getType()); 
        UpdateCloudScriptResult result = resultData.data;
        
        PlayFabResult<UpdateCloudScriptResult> pfResult = new PlayFabResult<UpdateCloudScriptResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Delete a content file from the title
     */
    public static FutureTask<PlayFabResult<BlankResult>> DeleteContentAsync(DeleteContentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateDeleteContentAsync(request);
            }
        });
    }

    /**
     * Delete a content file from the title
     */
    public static PlayFabResult<BlankResult> DeleteContent(DeleteContentRequest request) {
        FutureTask<PlayFabResult<BlankResult>> task = new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateDeleteContentAsync(request);
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
     * Delete a content file from the title
     */
    private static PlayFabResult<BlankResult> privateDeleteContentAsync(DeleteContentRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/DeleteContent", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BlankResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<BlankResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BlankResult>>(){}.getType()); 
        BlankResult result = resultData.data;
        
        PlayFabResult<BlankResult> pfResult = new PlayFabResult<BlankResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * List all contents of the title and get statistics such as size
     */
    public static FutureTask<PlayFabResult<GetContentListResult>> GetContentListAsync(GetContentListRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContentListResult>>() {
            public PlayFabResult<GetContentListResult> call() throws Exception {
                return privateGetContentListAsync(request);
            }
        });
    }

    /**
     * List all contents of the title and get statistics such as size
     */
    public static PlayFabResult<GetContentListResult> GetContentList(GetContentListRequest request) {
        FutureTask<PlayFabResult<GetContentListResult>> task = new FutureTask(new Callable<PlayFabResult<GetContentListResult>>() {
            public PlayFabResult<GetContentListResult> call() throws Exception {
                return privateGetContentListAsync(request);
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
     * List all contents of the title and get statistics such as size
     */
    private static PlayFabResult<GetContentListResult> privateGetContentListAsync(GetContentListRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetContentList", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetContentListResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetContentListResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetContentListResult>>(){}.getType()); 
        GetContentListResult result = resultData.data;
        
        PlayFabResult<GetContentListResult> pfResult = new PlayFabResult<GetContentListResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the pre-signed URL for uploading a content file. A subsequent HTTP PUT to the returned URL uploads the content.
     */
    public static FutureTask<PlayFabResult<GetContentUploadUrlResult>> GetContentUploadUrlAsync(GetContentUploadUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContentUploadUrlResult>>() {
            public PlayFabResult<GetContentUploadUrlResult> call() throws Exception {
                return privateGetContentUploadUrlAsync(request);
            }
        });
    }

    /**
     * Retrieves the pre-signed URL for uploading a content file. A subsequent HTTP PUT to the returned URL uploads the content.
     */
    public static PlayFabResult<GetContentUploadUrlResult> GetContentUploadUrl(GetContentUploadUrlRequest request) {
        FutureTask<PlayFabResult<GetContentUploadUrlResult>> task = new FutureTask(new Callable<PlayFabResult<GetContentUploadUrlResult>>() {
            public PlayFabResult<GetContentUploadUrlResult> call() throws Exception {
                return privateGetContentUploadUrlAsync(request);
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
     * Retrieves the pre-signed URL for uploading a content file. A subsequent HTTP PUT to the returned URL uploads the content.
     */
    private static PlayFabResult<GetContentUploadUrlResult> privateGetContentUploadUrlAsync(GetContentUploadUrlRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetContentUploadUrl", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetContentUploadUrlResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetContentUploadUrlResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetContentUploadUrlResult>>(){}.getType()); 
        GetContentUploadUrlResult result = resultData.data;
        
        PlayFabResult<GetContentUploadUrlResult> pfResult = new PlayFabResult<GetContentUploadUrlResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Completely removes all statistics for the specified character, for the current game
     */
    public static FutureTask<PlayFabResult<ResetCharacterStatisticsResult>> ResetCharacterStatisticsAsync(ResetCharacterStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ResetCharacterStatisticsResult>>() {
            public PlayFabResult<ResetCharacterStatisticsResult> call() throws Exception {
                return privateResetCharacterStatisticsAsync(request);
            }
        });
    }

    /**
     * Completely removes all statistics for the specified character, for the current game
     */
    public static PlayFabResult<ResetCharacterStatisticsResult> ResetCharacterStatistics(ResetCharacterStatisticsRequest request) {
        FutureTask<PlayFabResult<ResetCharacterStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<ResetCharacterStatisticsResult>>() {
            public PlayFabResult<ResetCharacterStatisticsResult> call() throws Exception {
                return privateResetCharacterStatisticsAsync(request);
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
     * Completely removes all statistics for the specified character, for the current game
     */
    private static PlayFabResult<ResetCharacterStatisticsResult> privateResetCharacterStatisticsAsync(ResetCharacterStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/ResetCharacterStatistics", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ResetCharacterStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ResetCharacterStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ResetCharacterStatisticsResult>>(){}.getType()); 
        ResetCharacterStatisticsResult result = resultData.data;
        
        PlayFabResult<ResetCharacterStatisticsResult> pfResult = new PlayFabResult<ResetCharacterStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    
}
