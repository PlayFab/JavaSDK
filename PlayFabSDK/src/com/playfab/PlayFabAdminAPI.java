package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabAdminModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;


/**
 * APIs for managing title configurations, uploaded Game Server code executables, and user data
 */
public class PlayFabAdminAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Gets the requested policy.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPolicyResponse>> GetPolicyAsync(final GetPolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPolicyResponse>>() {
            public PlayFabResult<GetPolicyResponse> call() throws Exception {
                return privateGetPolicyAsync(request);
            }
        });
    }

    /**
     * Gets the requested policy.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPolicyResponse> GetPolicy(final GetPolicyRequest request) {
        FutureTask<PlayFabResult<GetPolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<GetPolicyResponse>>() {
            public PlayFabResult<GetPolicyResponse> call() throws Exception {
                return privateGetPolicyAsync(request);
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
     * Gets the requested policy.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPolicyResponse> privateGetPolicyAsync(final GetPolicyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetPolicy", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPolicyResponse>>(){}.getType());
        GetPolicyResponse result = resultData.data;

        PlayFabResult<GetPolicyResponse> pfResult = new PlayFabResult<GetPolicyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Changes a policy for a title
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdatePolicyResponse>> UpdatePolicyAsync(final UpdatePolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdatePolicyResponse>>() {
            public PlayFabResult<UpdatePolicyResponse> call() throws Exception {
                return privateUpdatePolicyAsync(request);
            }
        });
    }

    /**
     * Changes a policy for a title
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdatePolicyResponse> UpdatePolicy(final UpdatePolicyRequest request) {
        FutureTask<PlayFabResult<UpdatePolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdatePolicyResponse>>() {
            public PlayFabResult<UpdatePolicyResponse> call() throws Exception {
                return privateUpdatePolicyAsync(request);
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
     * Changes a policy for a title
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdatePolicyResponse> privateUpdatePolicyAsync(final UpdatePolicyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdatePolicy", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdatePolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdatePolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdatePolicyResponse>>(){}.getType());
        UpdatePolicyResponse result = resultData.data;

        PlayFabResult<UpdatePolicyResponse> pfResult = new PlayFabResult<UpdatePolicyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Bans users by PlayFab ID with optional IP address, or MAC address for the provided game.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BanUsersResult>> BanUsersAsync(final BanUsersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BanUsersResult>>() {
            public PlayFabResult<BanUsersResult> call() throws Exception {
                return privateBanUsersAsync(request);
            }
        });
    }

    /**
     * Bans users by PlayFab ID with optional IP address, or MAC address for the provided game.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BanUsersResult> BanUsers(final BanUsersRequest request) {
        FutureTask<PlayFabResult<BanUsersResult>> task = new FutureTask(new Callable<PlayFabResult<BanUsersResult>>() {
            public PlayFabResult<BanUsersResult> call() throws Exception {
                return privateBanUsersAsync(request);
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
     * Bans users by PlayFab ID with optional IP address, or MAC address for the provided game.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BanUsersResult> privateBanUsersAsync(final BanUsersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/BanUsers", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BanUsersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<BanUsersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BanUsersResult>>(){}.getType());
        BanUsersResult result = resultData.data;

        PlayFabResult<BanUsersResult> pfResult = new PlayFabResult<BanUsersResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the relevant details for a specified user, based upon a match against a supplied unique identifier
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LookupUserAccountInfoResult>> GetUserAccountInfoAsync(final LookupUserAccountInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LookupUserAccountInfoResult>>() {
            public PlayFabResult<LookupUserAccountInfoResult> call() throws Exception {
                return privateGetUserAccountInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the relevant details for a specified user, based upon a match against a supplied unique identifier
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LookupUserAccountInfoResult> GetUserAccountInfo(final LookupUserAccountInfoRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LookupUserAccountInfoResult> privateGetUserAccountInfoAsync(final LookupUserAccountInfoRequest request) throws Exception {
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
     * Gets all bans for a user.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserBansResult>> GetUserBansAsync(final GetUserBansRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserBansResult>>() {
            public PlayFabResult<GetUserBansResult> call() throws Exception {
                return privateGetUserBansAsync(request);
            }
        });
    }

    /**
     * Gets all bans for a user.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserBansResult> GetUserBans(final GetUserBansRequest request) {
        FutureTask<PlayFabResult<GetUserBansResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserBansResult>>() {
            public PlayFabResult<GetUserBansResult> call() throws Exception {
                return privateGetUserBansAsync(request);
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
     * Gets all bans for a user.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserBansResult> privateGetUserBansAsync(final GetUserBansRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetUserBans", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserBansResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetUserBansResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserBansResult>>(){}.getType());
        GetUserBansResult result = resultData.data;

        PlayFabResult<GetUserBansResult> pfResult = new PlayFabResult<GetUserBansResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Resets all title-specific information about a particular account, including user data, virtual currency balances, inventory, purchase history, and statistics
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BlankResult>> ResetUsersAsync(final ResetUsersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateResetUsersAsync(request);
            }
        });
    }

    /**
     * Resets all title-specific information about a particular account, including user data, virtual currency balances, inventory, purchase history, and statistics
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BlankResult> ResetUsers(final ResetUsersRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BlankResult> privateResetUsersAsync(final ResetUsersRequest request) throws Exception {
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
     * Revoke all active bans for a user.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RevokeAllBansForUserResult>> RevokeAllBansForUserAsync(final RevokeAllBansForUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RevokeAllBansForUserResult>>() {
            public PlayFabResult<RevokeAllBansForUserResult> call() throws Exception {
                return privateRevokeAllBansForUserAsync(request);
            }
        });
    }

    /**
     * Revoke all active bans for a user.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RevokeAllBansForUserResult> RevokeAllBansForUser(final RevokeAllBansForUserRequest request) {
        FutureTask<PlayFabResult<RevokeAllBansForUserResult>> task = new FutureTask(new Callable<PlayFabResult<RevokeAllBansForUserResult>>() {
            public PlayFabResult<RevokeAllBansForUserResult> call() throws Exception {
                return privateRevokeAllBansForUserAsync(request);
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
     * Revoke all active bans for a user.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeAllBansForUserResult> privateRevokeAllBansForUserAsync(final RevokeAllBansForUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/RevokeAllBansForUser", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RevokeAllBansForUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RevokeAllBansForUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RevokeAllBansForUserResult>>(){}.getType());
        RevokeAllBansForUserResult result = resultData.data;

        PlayFabResult<RevokeAllBansForUserResult> pfResult = new PlayFabResult<RevokeAllBansForUserResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Revoke all active bans specified with BanId.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RevokeBansResult>> RevokeBansAsync(final RevokeBansRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RevokeBansResult>>() {
            public PlayFabResult<RevokeBansResult> call() throws Exception {
                return privateRevokeBansAsync(request);
            }
        });
    }

    /**
     * Revoke all active bans specified with BanId.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RevokeBansResult> RevokeBans(final RevokeBansRequest request) {
        FutureTask<PlayFabResult<RevokeBansResult>> task = new FutureTask(new Callable<PlayFabResult<RevokeBansResult>>() {
            public PlayFabResult<RevokeBansResult> call() throws Exception {
                return privateRevokeBansAsync(request);
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
     * Revoke all active bans specified with BanId.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeBansResult> privateRevokeBansAsync(final RevokeBansRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/RevokeBans", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RevokeBansResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RevokeBansResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RevokeBansResult>>(){}.getType());
        RevokeBansResult result = resultData.data;

        PlayFabResult<RevokeBansResult> pfResult = new PlayFabResult<RevokeBansResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Forces an email to be sent to the registered email address for the specified account, with a link allowing the user to change the password
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SendAccountRecoveryEmailResult>> SendAccountRecoveryEmailAsync(final SendAccountRecoveryEmailRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SendAccountRecoveryEmailResult>>() {
            public PlayFabResult<SendAccountRecoveryEmailResult> call() throws Exception {
                return privateSendAccountRecoveryEmailAsync(request);
            }
        });
    }

    /**
     * Forces an email to be sent to the registered email address for the specified account, with a link allowing the user to change the password
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SendAccountRecoveryEmailResult> SendAccountRecoveryEmail(final SendAccountRecoveryEmailRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SendAccountRecoveryEmailResult> privateSendAccountRecoveryEmailAsync(final SendAccountRecoveryEmailRequest request) throws Exception {
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
     * Updates information of a list of existing bans specified with Ban Ids.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateBansResult>> UpdateBansAsync(final UpdateBansRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateBansResult>>() {
            public PlayFabResult<UpdateBansResult> call() throws Exception {
                return privateUpdateBansAsync(request);
            }
        });
    }

    /**
     * Updates information of a list of existing bans specified with Ban Ids.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateBansResult> UpdateBans(final UpdateBansRequest request) {
        FutureTask<PlayFabResult<UpdateBansResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateBansResult>>() {
            public PlayFabResult<UpdateBansResult> call() throws Exception {
                return privateUpdateBansAsync(request);
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
     * Updates information of a list of existing bans specified with Ban Ids.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateBansResult> privateUpdateBansAsync(final UpdateBansRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateBans", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateBansResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateBansResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateBansResult>>(){}.getType());
        UpdateBansResult result = resultData.data;

        PlayFabResult<UpdateBansResult> pfResult = new PlayFabResult<UpdateBansResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the title specific display name for a user
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserTitleDisplayNameResult>> UpdateUserTitleDisplayNameAsync(final UpdateUserTitleDisplayNameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserTitleDisplayNameResult>>() {
            public PlayFabResult<UpdateUserTitleDisplayNameResult> call() throws Exception {
                return privateUpdateUserTitleDisplayNameAsync(request);
            }
        });
    }

    /**
     * Updates the title specific display name for a user
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserTitleDisplayNameResult> UpdateUserTitleDisplayName(final UpdateUserTitleDisplayNameRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserTitleDisplayNameResult> privateUpdateUserTitleDisplayNameAsync(final UpdateUserTitleDisplayNameRequest request) throws Exception {
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
     * Adds a new player statistic configuration to the title, optionally allowing the developer to specify a reset interval and an aggregation method.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreatePlayerStatisticDefinitionResult>> CreatePlayerStatisticDefinitionAsync(final CreatePlayerStatisticDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreatePlayerStatisticDefinitionResult>>() {
            public PlayFabResult<CreatePlayerStatisticDefinitionResult> call() throws Exception {
                return privateCreatePlayerStatisticDefinitionAsync(request);
            }
        });
    }

    /**
     * Adds a new player statistic configuration to the title, optionally allowing the developer to specify a reset interval and an aggregation method.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreatePlayerStatisticDefinitionResult> CreatePlayerStatisticDefinition(final CreatePlayerStatisticDefinitionRequest request) {
        FutureTask<PlayFabResult<CreatePlayerStatisticDefinitionResult>> task = new FutureTask(new Callable<PlayFabResult<CreatePlayerStatisticDefinitionResult>>() {
            public PlayFabResult<CreatePlayerStatisticDefinitionResult> call() throws Exception {
                return privateCreatePlayerStatisticDefinitionAsync(request);
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
     * Adds a new player statistic configuration to the title, optionally allowing the developer to specify a reset interval and an aggregation method.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreatePlayerStatisticDefinitionResult> privateCreatePlayerStatisticDefinitionAsync(final CreatePlayerStatisticDefinitionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/CreatePlayerStatisticDefinition", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreatePlayerStatisticDefinitionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreatePlayerStatisticDefinitionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreatePlayerStatisticDefinitionResult>>(){}.getType());
        CreatePlayerStatisticDefinitionResult result = resultData.data;

        PlayFabResult<CreatePlayerStatisticDefinitionResult> pfResult = new PlayFabResult<CreatePlayerStatisticDefinitionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the users for the provided game. Deletes custom data, all account linkages, and statistics. This method does not remove the player's event history, login history, inventory items, nor virtual currencies.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteUsersResult>> DeleteUsersAsync(final DeleteUsersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteUsersResult>>() {
            public PlayFabResult<DeleteUsersResult> call() throws Exception {
                return privateDeleteUsersAsync(request);
            }
        });
    }

    /**
     * Deletes the users for the provided game. Deletes custom data, all account linkages, and statistics. This method does not remove the player's event history, login history, inventory items, nor virtual currencies.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteUsersResult> DeleteUsers(final DeleteUsersRequest request) {
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
     * Deletes the users for the provided game. Deletes custom data, all account linkages, and statistics. This method does not remove the player's event history, login history, inventory items, nor virtual currencies.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteUsersResult> privateDeleteUsersAsync(final DeleteUsersRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetDataReportResult>> GetDataReportAsync(final GetDataReportRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetDataReportResult>>() {
            public PlayFabResult<GetDataReportResult> call() throws Exception {
                return privateGetDataReportAsync(request);
            }
        });
    }

    /**
     * Retrieves a download URL for the requested report
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetDataReportResult> GetDataReport(final GetDataReportRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetDataReportResult> privateGetDataReportAsync(final GetDataReportRequest request) throws Exception {
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
     * Retrieves the configuration information for all player statistics defined in the title, regardless of whether they have a reset interval.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerStatisticDefinitionsResult>> GetPlayerStatisticDefinitionsAsync(final GetPlayerStatisticDefinitionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticDefinitionsResult>>() {
            public PlayFabResult<GetPlayerStatisticDefinitionsResult> call() throws Exception {
                return privateGetPlayerStatisticDefinitionsAsync(request);
            }
        });
    }

    /**
     * Retrieves the configuration information for all player statistics defined in the title, regardless of whether they have a reset interval.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerStatisticDefinitionsResult> GetPlayerStatisticDefinitions(final GetPlayerStatisticDefinitionsRequest request) {
        FutureTask<PlayFabResult<GetPlayerStatisticDefinitionsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticDefinitionsResult>>() {
            public PlayFabResult<GetPlayerStatisticDefinitionsResult> call() throws Exception {
                return privateGetPlayerStatisticDefinitionsAsync(request);
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
     * Retrieves the configuration information for all player statistics defined in the title, regardless of whether they have a reset interval.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerStatisticDefinitionsResult> privateGetPlayerStatisticDefinitionsAsync(final GetPlayerStatisticDefinitionsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetPlayerStatisticDefinitions", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerStatisticDefinitionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerStatisticDefinitionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerStatisticDefinitionsResult>>(){}.getType());
        GetPlayerStatisticDefinitionsResult result = resultData.data;

        PlayFabResult<GetPlayerStatisticDefinitionsResult> pfResult = new PlayFabResult<GetPlayerStatisticDefinitionsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the information on the available versions of the specified statistic.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerStatisticVersionsResult>> GetPlayerStatisticVersionsAsync(final GetPlayerStatisticVersionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticVersionsResult>>() {
            public PlayFabResult<GetPlayerStatisticVersionsResult> call() throws Exception {
                return privateGetPlayerStatisticVersionsAsync(request);
            }
        });
    }

    /**
     * Retrieves the information on the available versions of the specified statistic.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerStatisticVersionsResult> GetPlayerStatisticVersions(final GetPlayerStatisticVersionsRequest request) {
        FutureTask<PlayFabResult<GetPlayerStatisticVersionsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticVersionsResult>>() {
            public PlayFabResult<GetPlayerStatisticVersionsResult> call() throws Exception {
                return privateGetPlayerStatisticVersionsAsync(request);
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
     * Retrieves the information on the available versions of the specified statistic.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerStatisticVersionsResult> privateGetPlayerStatisticVersionsAsync(final GetPlayerStatisticVersionsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetPlayerStatisticVersions", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerStatisticVersionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerStatisticVersionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerStatisticVersionsResult>>(){}.getType());
        GetPlayerStatisticVersionsResult result = resultData.data;

        PlayFabResult<GetPlayerStatisticVersionsResult> pfResult = new PlayFabResult<GetPlayerStatisticVersionsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserData(final GetUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserDataAsync(final GetUserDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserInternalDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which cannot be accessed by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserInternalData(final GetUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserInternalDataAsync(final GetUserDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserPublisherData(final GetUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherDataAsync(final GetUserDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherInternalDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which cannot be accessed by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserPublisherInternalData(final GetUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherInternalDataAsync(final GetUserDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherReadOnlyDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which can only be read by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserPublisherReadOnlyData(final GetUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherReadOnlyDataAsync(final GetUserDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserReadOnlyDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which can only be read by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserReadOnlyData(final GetUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserReadOnlyDataAsync(final GetUserDataRequest request) throws Exception {
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
     * Resets the indicated statistic, removing all player entries for it and backing up the old values.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<IncrementPlayerStatisticVersionResult>> IncrementPlayerStatisticVersionAsync(final IncrementPlayerStatisticVersionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<IncrementPlayerStatisticVersionResult>>() {
            public PlayFabResult<IncrementPlayerStatisticVersionResult> call() throws Exception {
                return privateIncrementPlayerStatisticVersionAsync(request);
            }
        });
    }

    /**
     * Resets the indicated statistic, removing all player entries for it and backing up the old values.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<IncrementPlayerStatisticVersionResult> IncrementPlayerStatisticVersion(final IncrementPlayerStatisticVersionRequest request) {
        FutureTask<PlayFabResult<IncrementPlayerStatisticVersionResult>> task = new FutureTask(new Callable<PlayFabResult<IncrementPlayerStatisticVersionResult>>() {
            public PlayFabResult<IncrementPlayerStatisticVersionResult> call() throws Exception {
                return privateIncrementPlayerStatisticVersionAsync(request);
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
     * Resets the indicated statistic, removing all player entries for it and backing up the old values.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<IncrementPlayerStatisticVersionResult> privateIncrementPlayerStatisticVersionAsync(final IncrementPlayerStatisticVersionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/IncrementPlayerStatisticVersion", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<IncrementPlayerStatisticVersionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<IncrementPlayerStatisticVersionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<IncrementPlayerStatisticVersionResult>>(){}.getType());
        IncrementPlayerStatisticVersionResult result = resultData.data;

        PlayFabResult<IncrementPlayerStatisticVersionResult> pfResult = new PlayFabResult<IncrementPlayerStatisticVersionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Attempts to process an order refund through the original real money payment provider.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RefundPurchaseResponse>> RefundPurchaseAsync(final RefundPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RefundPurchaseResponse>>() {
            public PlayFabResult<RefundPurchaseResponse> call() throws Exception {
                return privateRefundPurchaseAsync(request);
            }
        });
    }

    /**
     * Attempts to process an order refund through the original real money payment provider.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RefundPurchaseResponse> RefundPurchase(final RefundPurchaseRequest request) {
        FutureTask<PlayFabResult<RefundPurchaseResponse>> task = new FutureTask(new Callable<PlayFabResult<RefundPurchaseResponse>>() {
            public PlayFabResult<RefundPurchaseResponse> call() throws Exception {
                return privateRefundPurchaseAsync(request);
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
     * Attempts to process an order refund through the original real money payment provider.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RefundPurchaseResponse> privateRefundPurchaseAsync(final RefundPurchaseRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/RefundPurchase", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RefundPurchaseResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RefundPurchaseResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RefundPurchaseResponse>>(){}.getType());
        RefundPurchaseResponse result = resultData.data;

        PlayFabResult<RefundPurchaseResponse> pfResult = new PlayFabResult<RefundPurchaseResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Completely removes all statistics for the specified user, for the current game
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ResetUserStatisticsResult>> ResetUserStatisticsAsync(final ResetUserStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ResetUserStatisticsResult>>() {
            public PlayFabResult<ResetUserStatisticsResult> call() throws Exception {
                return privateResetUserStatisticsAsync(request);
            }
        });
    }

    /**
     * Completely removes all statistics for the specified user, for the current game
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ResetUserStatisticsResult> ResetUserStatistics(final ResetUserStatisticsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ResetUserStatisticsResult> privateResetUserStatisticsAsync(final ResetUserStatisticsRequest request) throws Exception {
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
     * Attempts to resolve a dispute with the original order's payment provider.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ResolvePurchaseDisputeResponse>> ResolvePurchaseDisputeAsync(final ResolvePurchaseDisputeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ResolvePurchaseDisputeResponse>>() {
            public PlayFabResult<ResolvePurchaseDisputeResponse> call() throws Exception {
                return privateResolvePurchaseDisputeAsync(request);
            }
        });
    }

    /**
     * Attempts to resolve a dispute with the original order's payment provider.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ResolvePurchaseDisputeResponse> ResolvePurchaseDispute(final ResolvePurchaseDisputeRequest request) {
        FutureTask<PlayFabResult<ResolvePurchaseDisputeResponse>> task = new FutureTask(new Callable<PlayFabResult<ResolvePurchaseDisputeResponse>>() {
            public PlayFabResult<ResolvePurchaseDisputeResponse> call() throws Exception {
                return privateResolvePurchaseDisputeAsync(request);
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
     * Attempts to resolve a dispute with the original order's payment provider.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ResolvePurchaseDisputeResponse> privateResolvePurchaseDisputeAsync(final ResolvePurchaseDisputeRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/ResolvePurchaseDispute", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ResolvePurchaseDisputeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ResolvePurchaseDisputeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ResolvePurchaseDisputeResponse>>(){}.getType());
        ResolvePurchaseDisputeResponse result = resultData.data;

        PlayFabResult<ResolvePurchaseDisputeResponse> pfResult = new PlayFabResult<ResolvePurchaseDisputeResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates a player statistic configuration for the title, optionally allowing the developer to specify a reset interval.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdatePlayerStatisticDefinitionResult>> UpdatePlayerStatisticDefinitionAsync(final UpdatePlayerStatisticDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdatePlayerStatisticDefinitionResult>>() {
            public PlayFabResult<UpdatePlayerStatisticDefinitionResult> call() throws Exception {
                return privateUpdatePlayerStatisticDefinitionAsync(request);
            }
        });
    }

    /**
     * Updates a player statistic configuration for the title, optionally allowing the developer to specify a reset interval.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdatePlayerStatisticDefinitionResult> UpdatePlayerStatisticDefinition(final UpdatePlayerStatisticDefinitionRequest request) {
        FutureTask<PlayFabResult<UpdatePlayerStatisticDefinitionResult>> task = new FutureTask(new Callable<PlayFabResult<UpdatePlayerStatisticDefinitionResult>>() {
            public PlayFabResult<UpdatePlayerStatisticDefinitionResult> call() throws Exception {
                return privateUpdatePlayerStatisticDefinitionAsync(request);
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
     * Updates a player statistic configuration for the title, optionally allowing the developer to specify a reset interval.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdatePlayerStatisticDefinitionResult> privateUpdatePlayerStatisticDefinitionAsync(final UpdatePlayerStatisticDefinitionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdatePlayerStatisticDefinition", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdatePlayerStatisticDefinitionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdatePlayerStatisticDefinitionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdatePlayerStatisticDefinitionResult>>(){}.getType());
        UpdatePlayerStatisticDefinitionResult result = resultData.data;

        PlayFabResult<UpdatePlayerStatisticDefinitionResult> pfResult = new PlayFabResult<UpdatePlayerStatisticDefinitionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the title-specific custom data for the user which is readable and writable by the client
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserDataAsync(final UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user which is readable and writable by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserData(final UpdateUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserDataAsync(final UpdateUserDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserInternalDataAsync(final UpdateUserInternalDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user which cannot be accessed by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserInternalData(final UpdateUserInternalDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserInternalDataAsync(final UpdateUserInternalDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherDataAsync(final UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherDataAsync(request);
            }
        });
    }

    /**
     * Updates the publisher-specific custom data for the user which is readable and writable by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherData(final UpdateUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherDataAsync(final UpdateUserDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherInternalDataAsync(final UpdateUserInternalDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the publisher-specific custom data for the user which cannot be accessed by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherInternalData(final UpdateUserInternalDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherInternalDataAsync(final UpdateUserInternalDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherReadOnlyDataAsync(final UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Updates the publisher-specific custom data for the user which can only be read by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherReadOnlyData(final UpdateUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherReadOnlyDataAsync(final UpdateUserDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserReadOnlyDataAsync(final UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user which can only be read by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserReadOnlyData(final UpdateUserDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserReadOnlyDataAsync(final UpdateUserDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddNewsResult>> AddNewsAsync(final AddNewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddNewsResult>>() {
            public PlayFabResult<AddNewsResult> call() throws Exception {
                return privateAddNewsAsync(request);
            }
        });
    }

    /**
     * Adds a new news item to the title's news feed
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddNewsResult> AddNews(final AddNewsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddNewsResult> privateAddNewsAsync(final AddNewsRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BlankResult>> AddVirtualCurrencyTypesAsync(final AddVirtualCurrencyTypesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateAddVirtualCurrencyTypesAsync(request);
            }
        });
    }

    /**
     * Adds one or more virtual currencies to the set defined for the title. Virtual Currencies have a maximum value of 2,147,483,647 when granted to a player. Any value over that will be discarded.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BlankResult> AddVirtualCurrencyTypes(final AddVirtualCurrencyTypesRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BlankResult> privateAddVirtualCurrencyTypesAsync(final AddVirtualCurrencyTypesRequest request) throws Exception {
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
     * Deletes an existing virtual item store
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteStoreResult>> DeleteStoreAsync(final DeleteStoreRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteStoreResult>>() {
            public PlayFabResult<DeleteStoreResult> call() throws Exception {
                return privateDeleteStoreAsync(request);
            }
        });
    }

    /**
     * Deletes an existing virtual item store
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteStoreResult> DeleteStore(final DeleteStoreRequest request) {
        FutureTask<PlayFabResult<DeleteStoreResult>> task = new FutureTask(new Callable<PlayFabResult<DeleteStoreResult>>() {
            public PlayFabResult<DeleteStoreResult> call() throws Exception {
                return privateDeleteStoreAsync(request);
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
     * Deletes an existing virtual item store
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteStoreResult> privateDeleteStoreAsync(final DeleteStoreRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/DeleteStore", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteStoreResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteStoreResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteStoreResult>>(){}.getType());
        DeleteStoreResult result = resultData.data;

        PlayFabResult<DeleteStoreResult> pfResult = new PlayFabResult<DeleteStoreResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCatalogItemsResult>> GetCatalogItemsAsync(final GetCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCatalogItemsResult>>() {
            public PlayFabResult<GetCatalogItemsResult> call() throws Exception {
                return privateGetCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCatalogItemsResult> GetCatalogItems(final GetCatalogItemsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCatalogItemsResult> privateGetCatalogItemsAsync(final GetCatalogItemsRequest request) throws Exception {
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
     * Retrieves the key-value store of custom publisher settings
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPublisherDataResult>> GetPublisherDataAsync(final GetPublisherDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPublisherDataResult>>() {
            public PlayFabResult<GetPublisherDataResult> call() throws Exception {
                return privateGetPublisherDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom publisher settings
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPublisherDataResult> GetPublisherData(final GetPublisherDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPublisherDataResult> privateGetPublisherDataAsync(final GetPublisherDataRequest request) throws Exception {
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
     * Retrieves the random drop table configuration for the title
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetRandomResultTablesResult>> GetRandomResultTablesAsync(final GetRandomResultTablesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetRandomResultTablesResult>>() {
            public PlayFabResult<GetRandomResultTablesResult> call() throws Exception {
                return privateGetRandomResultTablesAsync(request);
            }
        });
    }

    /**
     * Retrieves the random drop table configuration for the title
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetRandomResultTablesResult> GetRandomResultTables(final GetRandomResultTablesRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetRandomResultTablesResult> privateGetRandomResultTablesAsync(final GetRandomResultTablesRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetStoreItemsResult>> GetStoreItemsAsync(final GetStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetStoreItemsResult>>() {
            public PlayFabResult<GetStoreItemsResult> call() throws Exception {
                return privateGetStoreItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves the set of items defined for the specified store, including all prices defined
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetStoreItemsResult> GetStoreItems(final GetStoreItemsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetStoreItemsResult> privateGetStoreItemsAsync(final GetStoreItemsRequest request) throws Exception {
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
     * Retrieves the key-value store of custom title settings which can be read by the client
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitleDataResult>> GetTitleDataAsync(final GetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom title settings which can be read by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitleDataResult> GetTitleData(final GetTitleDataRequest request) {
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
     * Retrieves the key-value store of custom title settings which can be read by the client
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleDataResult> privateGetTitleDataAsync(final GetTitleDataRequest request) throws Exception {
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
     * Retrieves the key-value store of custom title settings which cannot be read by the client
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitleDataResult>> GetTitleInternalDataAsync(final GetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom title settings which cannot be read by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitleDataResult> GetTitleInternalData(final GetTitleDataRequest request) {
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
     * Retrieves the key-value store of custom title settings which cannot be read by the client
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleDataResult> privateGetTitleInternalDataAsync(final GetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetTitleInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListVirtualCurrencyTypesResult>> ListVirtualCurrencyTypesAsync(final ListVirtualCurrencyTypesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListVirtualCurrencyTypesResult>>() {
            public PlayFabResult<ListVirtualCurrencyTypesResult> call() throws Exception {
                return privateListVirtualCurrencyTypesAsync(request);
            }
        });
    }

    /**
     * Retuns the list of all defined virtual currencies for the title
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListVirtualCurrencyTypesResult> ListVirtualCurrencyTypes(final ListVirtualCurrencyTypesRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListVirtualCurrencyTypesResult> privateListVirtualCurrencyTypesAsync(final ListVirtualCurrencyTypesRequest request) throws Exception {
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
     * Removes one or more virtual currencies from the set defined for the title.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BlankResult>> RemoveVirtualCurrencyTypesAsync(final RemoveVirtualCurrencyTypesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateRemoveVirtualCurrencyTypesAsync(request);
            }
        });
    }

    /**
     * Removes one or more virtual currencies from the set defined for the title.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BlankResult> RemoveVirtualCurrencyTypes(final RemoveVirtualCurrencyTypesRequest request) {
        FutureTask<PlayFabResult<BlankResult>> task = new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateRemoveVirtualCurrencyTypesAsync(request);
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
     * Removes one or more virtual currencies from the set defined for the title.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BlankResult> privateRemoveVirtualCurrencyTypesAsync(final RemoveVirtualCurrencyTypesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/RemoveVirtualCurrencyTypes", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Creates the catalog configuration of all virtual goods for the specified catalog version
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCatalogItemsResult>> SetCatalogItemsAsync(final UpdateCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateSetCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Creates the catalog configuration of all virtual goods for the specified catalog version
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCatalogItemsResult> SetCatalogItems(final UpdateCatalogItemsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCatalogItemsResult> privateSetCatalogItemsAsync(final UpdateCatalogItemsRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateStoreItemsResult>> SetStoreItemsAsync(final UpdateStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateSetStoreItemsAsync(request);
            }
        });
    }

    /**
     * Sets all the items in one virtual store
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateStoreItemsResult> SetStoreItems(final UpdateStoreItemsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateStoreItemsResult> privateSetStoreItemsAsync(final UpdateStoreItemsRequest request) throws Exception {
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
     * Creates and updates the key-value store of custom title settings which can be read by the client
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetTitleDataResult>> SetTitleDataAsync(final SetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleDataAsync(request);
            }
        });
    }

    /**
     * Creates and updates the key-value store of custom title settings which can be read by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetTitleDataResult> SetTitleData(final SetTitleDataRequest request) {
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
     * Creates and updates the key-value store of custom title settings which can be read by the client
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetTitleDataResult> privateSetTitleDataAsync(final SetTitleDataRequest request) throws Exception {
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
     * Updates the key-value store of custom title settings which cannot be read by the client
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetTitleDataResult>> SetTitleInternalDataAsync(final SetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the key-value store of custom title settings which cannot be read by the client
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetTitleDataResult> SetTitleInternalData(final SetTitleDataRequest request) {
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
     * Updates the key-value store of custom title settings which cannot be read by the client
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetTitleDataResult> privateSetTitleInternalDataAsync(final SetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/SetTitleInternalData", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetupPushNotificationResult>> SetupPushNotificationAsync(final SetupPushNotificationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetupPushNotificationResult>>() {
            public PlayFabResult<SetupPushNotificationResult> call() throws Exception {
                return privateSetupPushNotificationAsync(request);
            }
        });
    }

    /**
     * Sets the Amazon Resource Name (ARN) for iOS and Android push notifications. Documentation on the exact restrictions can be found at: http://docs.aws.amazon.com/sns/latest/api/API_CreatePlatformApplication.html. Currently, Amazon device Messaging is not supported.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetupPushNotificationResult> SetupPushNotification(final SetupPushNotificationRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetupPushNotificationResult> privateSetupPushNotificationAsync(final SetupPushNotificationRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCatalogItemsResult>> UpdateCatalogItemsAsync(final UpdateCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateUpdateCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Updates the catalog configuration for virtual goods in the specified catalog version
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCatalogItemsResult> UpdateCatalogItems(final UpdateCatalogItemsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCatalogItemsResult> privateUpdateCatalogItemsAsync(final UpdateCatalogItemsRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateRandomResultTablesResult>> UpdateRandomResultTablesAsync(final UpdateRandomResultTablesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateRandomResultTablesResult>>() {
            public PlayFabResult<UpdateRandomResultTablesResult> call() throws Exception {
                return privateUpdateRandomResultTablesAsync(request);
            }
        });
    }

    /**
     * Updates the random drop table configuration for the title
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateRandomResultTablesResult> UpdateRandomResultTables(final UpdateRandomResultTablesRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateRandomResultTablesResult> privateUpdateRandomResultTablesAsync(final UpdateRandomResultTablesRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateStoreItemsResult>> UpdateStoreItemsAsync(final UpdateStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateUpdateStoreItemsAsync(request);
            }
        });
    }

    /**
     * Updates an existing virtual item store with new or modified items
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateStoreItemsResult> UpdateStoreItems(final UpdateStoreItemsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateStoreItemsResult> privateUpdateStoreItemsAsync(final UpdateStoreItemsRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> AddUserVirtualCurrencyAsync(final AddUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateAddUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Increments the specified virtual currency by the stated amount
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyUserVirtualCurrencyResult> AddUserVirtualCurrency(final AddUserVirtualCurrencyRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateAddUserVirtualCurrencyAsync(final AddUserVirtualCurrencyRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserInventoryResult>> GetUserInventoryAsync(final GetUserInventoryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserInventoryResult>>() {
            public PlayFabResult<GetUserInventoryResult> call() throws Exception {
                return privateGetUserInventoryAsync(request);
            }
        });
    }

    /**
     * Retrieves the specified user's current inventory of virtual goods
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserInventoryResult> GetUserInventory(final GetUserInventoryRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserInventoryResult> privateGetUserInventoryAsync(final GetUserInventoryRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GrantItemsToUsersResult>> GrantItemsToUsersAsync(final GrantItemsToUsersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantItemsToUsersResult>>() {
            public PlayFabResult<GrantItemsToUsersResult> call() throws Exception {
                return privateGrantItemsToUsersAsync(request);
            }
        });
    }

    /**
     * Adds the specified items to the specified user inventories
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GrantItemsToUsersResult> GrantItemsToUsers(final GrantItemsToUsersRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GrantItemsToUsersResult> privateGrantItemsToUsersAsync(final GrantItemsToUsersRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RevokeInventoryResult>> RevokeInventoryItemAsync(final RevokeInventoryItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RevokeInventoryResult>>() {
            public PlayFabResult<RevokeInventoryResult> call() throws Exception {
                return privateRevokeInventoryItemAsync(request);
            }
        });
    }

    /**
     * Revokes access to an item in a user's inventory
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RevokeInventoryResult> RevokeInventoryItem(final RevokeInventoryItemRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeInventoryResult> privateRevokeInventoryItemAsync(final RevokeInventoryItemRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> SubtractUserVirtualCurrencyAsync(final SubtractUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateSubtractUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Decrements the specified virtual currency by the stated amount
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyUserVirtualCurrencyResult> SubtractUserVirtualCurrency(final SubtractUserVirtualCurrencyRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateSubtractUserVirtualCurrencyAsync(final SubtractUserVirtualCurrencyRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMatchmakerGameInfoResult>> GetMatchmakerGameInfoAsync(final GetMatchmakerGameInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameInfoResult>>() {
            public PlayFabResult<GetMatchmakerGameInfoResult> call() throws Exception {
                return privateGetMatchmakerGameInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the details for a specific completed session, including links to standard out and standard error logs
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMatchmakerGameInfoResult> GetMatchmakerGameInfo(final GetMatchmakerGameInfoRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMatchmakerGameInfoResult> privateGetMatchmakerGameInfoAsync(final GetMatchmakerGameInfoRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMatchmakerGameModesResult>> GetMatchmakerGameModesAsync(final GetMatchmakerGameModesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameModesResult>>() {
            public PlayFabResult<GetMatchmakerGameModesResult> call() throws Exception {
                return privateGetMatchmakerGameModesAsync(request);
            }
        });
    }

    /**
     * Retrieves the details of defined game modes for the specified game server executable
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMatchmakerGameModesResult> GetMatchmakerGameModes(final GetMatchmakerGameModesRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMatchmakerGameModesResult> privateGetMatchmakerGameModesAsync(final GetMatchmakerGameModesRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyMatchmakerGameModesResult>> ModifyMatchmakerGameModesAsync(final ModifyMatchmakerGameModesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyMatchmakerGameModesResult>>() {
            public PlayFabResult<ModifyMatchmakerGameModesResult> call() throws Exception {
                return privateModifyMatchmakerGameModesAsync(request);
            }
        });
    }

    /**
     * Updates the game server mode details for the specified game server executable
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyMatchmakerGameModesResult> ModifyMatchmakerGameModes(final ModifyMatchmakerGameModesRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyMatchmakerGameModesResult> privateModifyMatchmakerGameModesAsync(final ModifyMatchmakerGameModesRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddServerBuildResult>> AddServerBuildAsync(final AddServerBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddServerBuildResult>>() {
            public PlayFabResult<AddServerBuildResult> call() throws Exception {
                return privateAddServerBuildAsync(request);
            }
        });
    }

    /**
     * Adds the game server executable specified (previously uploaded - see GetServerBuildUploadUrl) to the set of those a client is permitted to request in a call to StartGame
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddServerBuildResult> AddServerBuild(final AddServerBuildRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddServerBuildResult> privateAddServerBuildAsync(final AddServerBuildRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetServerBuildInfoResult>> GetServerBuildInfoAsync(final GetServerBuildInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetServerBuildInfoResult>>() {
            public PlayFabResult<GetServerBuildInfoResult> call() throws Exception {
                return privateGetServerBuildInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the build details for the specified game server executable
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetServerBuildInfoResult> GetServerBuildInfo(final GetServerBuildInfoRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetServerBuildInfoResult> privateGetServerBuildInfoAsync(final GetServerBuildInfoRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetServerBuildInfo", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetServerBuildUploadURLResult>> GetServerBuildUploadUrlAsync(final GetServerBuildUploadURLRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetServerBuildUploadURLResult>>() {
            public PlayFabResult<GetServerBuildUploadURLResult> call() throws Exception {
                return privateGetServerBuildUploadUrlAsync(request);
            }
        });
    }

    /**
     * Retrieves the pre-authorized URL for uploading a game server package containing a build (does not enable the build for use - see AddServerBuild)
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetServerBuildUploadURLResult> GetServerBuildUploadUrl(final GetServerBuildUploadURLRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetServerBuildUploadURLResult> privateGetServerBuildUploadUrlAsync(final GetServerBuildUploadURLRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListBuildsResult>> ListServerBuildsAsync(final ListBuildsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListBuildsResult>>() {
            public PlayFabResult<ListBuildsResult> call() throws Exception {
                return privateListServerBuildsAsync(request);
            }
        });
    }

    /**
     * Retrieves the build details for all game server executables which are currently defined for the title
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListBuildsResult> ListServerBuilds(final ListBuildsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListBuildsResult> privateListServerBuildsAsync(final ListBuildsRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyServerBuildResult>> ModifyServerBuildAsync(final ModifyServerBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyServerBuildResult>>() {
            public PlayFabResult<ModifyServerBuildResult> call() throws Exception {
                return privateModifyServerBuildAsync(request);
            }
        });
    }

    /**
     * Updates the build details for the specified game server executable
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyServerBuildResult> ModifyServerBuild(final ModifyServerBuildRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyServerBuildResult> privateModifyServerBuildAsync(final ModifyServerBuildRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RemoveServerBuildResult>> RemoveServerBuildAsync(final RemoveServerBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemoveServerBuildResult>>() {
            public PlayFabResult<RemoveServerBuildResult> call() throws Exception {
                return privateRemoveServerBuildAsync(request);
            }
        });
    }

    /**
     * Removes the game server executable specified from the set of those a client is permitted to request in a call to StartGame
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RemoveServerBuildResult> RemoveServerBuild(final RemoveServerBuildRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RemoveServerBuildResult> privateRemoveServerBuildAsync(final RemoveServerBuildRequest request) throws Exception {
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
     * Updates the key-value store of custom publisher settings
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetPublisherDataResult>> SetPublisherDataAsync(final SetPublisherDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetPublisherDataResult>>() {
            public PlayFabResult<SetPublisherDataResult> call() throws Exception {
                return privateSetPublisherDataAsync(request);
            }
        });
    }

    /**
     * Updates the key-value store of custom publisher settings
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetPublisherDataResult> SetPublisherData(final SetPublisherDataRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetPublisherDataResult> privateSetPublisherDataAsync(final SetPublisherDataRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCloudScriptRevisionResult>> GetCloudScriptRevisionAsync(final GetCloudScriptRevisionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCloudScriptRevisionResult>>() {
            public PlayFabResult<GetCloudScriptRevisionResult> call() throws Exception {
                return privateGetCloudScriptRevisionAsync(request);
            }
        });
    }

    /**
     * Gets the contents and information of a specific Cloud Script revision.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCloudScriptRevisionResult> GetCloudScriptRevision(final GetCloudScriptRevisionRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCloudScriptRevisionResult> privateGetCloudScriptRevisionAsync(final GetCloudScriptRevisionRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCloudScriptVersionsResult>> GetCloudScriptVersionsAsync(final GetCloudScriptVersionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCloudScriptVersionsResult>>() {
            public PlayFabResult<GetCloudScriptVersionsResult> call() throws Exception {
                return privateGetCloudScriptVersionsAsync(request);
            }
        });
    }

    /**
     * Lists all the current cloud script versions. For each version, information about the current published and latest revisions is also listed.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCloudScriptVersionsResult> GetCloudScriptVersions(final GetCloudScriptVersionsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCloudScriptVersionsResult> privateGetCloudScriptVersionsAsync(final GetCloudScriptVersionsRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetPublishedRevisionResult>> SetPublishedRevisionAsync(final SetPublishedRevisionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetPublishedRevisionResult>>() {
            public PlayFabResult<SetPublishedRevisionResult> call() throws Exception {
                return privateSetPublishedRevisionAsync(request);
            }
        });
    }

    /**
     * Sets the currently published revision of a title Cloud Script
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetPublishedRevisionResult> SetPublishedRevision(final SetPublishedRevisionRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetPublishedRevisionResult> privateSetPublishedRevisionAsync(final SetPublishedRevisionRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCloudScriptResult>> UpdateCloudScriptAsync(final UpdateCloudScriptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCloudScriptResult>>() {
            public PlayFabResult<UpdateCloudScriptResult> call() throws Exception {
                return privateUpdateCloudScriptAsync(request);
            }
        });
    }

    /**
     * Creates a new Cloud Script revision and uploads source code to it. Note that at this time, only one file should be submitted in the revision.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCloudScriptResult> UpdateCloudScript(final UpdateCloudScriptRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCloudScriptResult> privateUpdateCloudScriptAsync(final UpdateCloudScriptRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BlankResult>> DeleteContentAsync(final DeleteContentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateDeleteContentAsync(request);
            }
        });
    }

    /**
     * Delete a content file from the title
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BlankResult> DeleteContent(final DeleteContentRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BlankResult> privateDeleteContentAsync(final DeleteContentRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetContentListResult>> GetContentListAsync(final GetContentListRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContentListResult>>() {
            public PlayFabResult<GetContentListResult> call() throws Exception {
                return privateGetContentListAsync(request);
            }
        });
    }

    /**
     * List all contents of the title and get statistics such as size
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetContentListResult> GetContentList(final GetContentListRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetContentListResult> privateGetContentListAsync(final GetContentListRequest request) throws Exception {
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
     * Retrieves the pre-signed URL for uploading a content file. A subsequent HTTP PUT to the returned URL uploads the  content. Also, please be aware that the Content service is specifically PlayFab's CDN offering, for which standard CDN rates apply.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetContentUploadUrlResult>> GetContentUploadUrlAsync(final GetContentUploadUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContentUploadUrlResult>>() {
            public PlayFabResult<GetContentUploadUrlResult> call() throws Exception {
                return privateGetContentUploadUrlAsync(request);
            }
        });
    }

    /**
     * Retrieves the pre-signed URL for uploading a content file. A subsequent HTTP PUT to the returned URL uploads the  content. Also, please be aware that the Content service is specifically PlayFab's CDN offering, for which standard CDN rates apply.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetContentUploadUrlResult> GetContentUploadUrl(final GetContentUploadUrlRequest request) {
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
     * Retrieves the pre-signed URL for uploading a content file. A subsequent HTTP PUT to the returned URL uploads the  content. Also, please be aware that the Content service is specifically PlayFab's CDN offering, for which standard CDN rates apply.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetContentUploadUrlResult> privateGetContentUploadUrlAsync(final GetContentUploadUrlRequest request) throws Exception {
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
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ResetCharacterStatisticsResult>> ResetCharacterStatisticsAsync(final ResetCharacterStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ResetCharacterStatisticsResult>>() {
            public PlayFabResult<ResetCharacterStatisticsResult> call() throws Exception {
                return privateResetCharacterStatisticsAsync(request);
            }
        });
    }

    /**
     * Completely removes all statistics for the specified character, for the current game
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ResetCharacterStatisticsResult> ResetCharacterStatistics(final ResetCharacterStatisticsRequest request) {
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
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ResetCharacterStatisticsResult> privateResetCharacterStatisticsAsync(final ResetCharacterStatisticsRequest request) throws Exception {
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

    /**
     * Adds a given tag to a player profile. The tag's namespace is automatically generated based on the source of the tag.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddPlayerTagResult>> AddPlayerTagAsync(final AddPlayerTagRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddPlayerTagResult>>() {
            public PlayFabResult<AddPlayerTagResult> call() throws Exception {
                return privateAddPlayerTagAsync(request);
            }
        });
    }

    /**
     * Adds a given tag to a player profile. The tag's namespace is automatically generated based on the source of the tag.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddPlayerTagResult> AddPlayerTag(final AddPlayerTagRequest request) {
        FutureTask<PlayFabResult<AddPlayerTagResult>> task = new FutureTask(new Callable<PlayFabResult<AddPlayerTagResult>>() {
            public PlayFabResult<AddPlayerTagResult> call() throws Exception {
                return privateAddPlayerTagAsync(request);
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
     * Adds a given tag to a player profile. The tag's namespace is automatically generated based on the source of the tag.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddPlayerTagResult> privateAddPlayerTagAsync(final AddPlayerTagRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/AddPlayerTag", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddPlayerTagResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AddPlayerTagResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddPlayerTagResult>>(){}.getType());
        AddPlayerTagResult result = resultData.data;

        PlayFabResult<AddPlayerTagResult> pfResult = new PlayFabResult<AddPlayerTagResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieve a list of all PlayStream actions groups.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAllActionGroupsResult>> GetAllActionGroupsAsync(final GetAllActionGroupsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAllActionGroupsResult>>() {
            public PlayFabResult<GetAllActionGroupsResult> call() throws Exception {
                return privateGetAllActionGroupsAsync(request);
            }
        });
    }

    /**
     * Retrieve a list of all PlayStream actions groups.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAllActionGroupsResult> GetAllActionGroups(final GetAllActionGroupsRequest request) {
        FutureTask<PlayFabResult<GetAllActionGroupsResult>> task = new FutureTask(new Callable<PlayFabResult<GetAllActionGroupsResult>>() {
            public PlayFabResult<GetAllActionGroupsResult> call() throws Exception {
                return privateGetAllActionGroupsAsync(request);
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
     * Retrieve a list of all PlayStream actions groups.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAllActionGroupsResult> privateGetAllActionGroupsAsync(final GetAllActionGroupsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetAllActionGroups", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAllActionGroupsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAllActionGroupsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAllActionGroupsResult>>(){}.getType());
        GetAllActionGroupsResult result = resultData.data;

        PlayFabResult<GetAllActionGroupsResult> pfResult = new PlayFabResult<GetAllActionGroupsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves an array of player segment definitions. Results from this can be used in subsequent API calls such as GetPlayersInSegment which requires a Segment ID. While segment names can change the ID for that segment will not change.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAllSegmentsResult>> GetAllSegmentsAsync(final GetAllSegmentsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAllSegmentsResult>>() {
            public PlayFabResult<GetAllSegmentsResult> call() throws Exception {
                return privateGetAllSegmentsAsync(request);
            }
        });
    }

    /**
     * Retrieves an array of player segment definitions. Results from this can be used in subsequent API calls such as GetPlayersInSegment which requires a Segment ID. While segment names can change the ID for that segment will not change.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAllSegmentsResult> GetAllSegments(final GetAllSegmentsRequest request) {
        FutureTask<PlayFabResult<GetAllSegmentsResult>> task = new FutureTask(new Callable<PlayFabResult<GetAllSegmentsResult>>() {
            public PlayFabResult<GetAllSegmentsResult> call() throws Exception {
                return privateGetAllSegmentsAsync(request);
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
     * Retrieves an array of player segment definitions. Results from this can be used in subsequent API calls such as GetPlayersInSegment which requires a Segment ID. While segment names can change the ID for that segment will not change.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAllSegmentsResult> privateGetAllSegmentsAsync(final GetAllSegmentsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetAllSegments", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAllSegmentsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAllSegmentsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAllSegmentsResult>>(){}.getType());
        GetAllSegmentsResult result = resultData.data;

        PlayFabResult<GetAllSegmentsResult> pfResult = new PlayFabResult<GetAllSegmentsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * List all segments that a player currently belongs to at this moment in time.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerSegmentsResult>> GetPlayerSegmentsAsync(final GetPlayersSegmentsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerSegmentsResult>>() {
            public PlayFabResult<GetPlayerSegmentsResult> call() throws Exception {
                return privateGetPlayerSegmentsAsync(request);
            }
        });
    }

    /**
     * List all segments that a player currently belongs to at this moment in time.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerSegmentsResult> GetPlayerSegments(final GetPlayersSegmentsRequest request) {
        FutureTask<PlayFabResult<GetPlayerSegmentsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerSegmentsResult>>() {
            public PlayFabResult<GetPlayerSegmentsResult> call() throws Exception {
                return privateGetPlayerSegmentsAsync(request);
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
     * List all segments that a player currently belongs to at this moment in time.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerSegmentsResult> privateGetPlayerSegmentsAsync(final GetPlayersSegmentsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetPlayerSegments", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerSegmentsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerSegmentsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerSegmentsResult>>(){}.getType());
        GetPlayerSegmentsResult result = resultData.data;

        PlayFabResult<GetPlayerSegmentsResult> pfResult = new PlayFabResult<GetPlayerSegmentsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Allows for paging through all players in a given segment. This API creates a snapshot of all player profiles that match the segment definition at the time of its creation and lives through the Total Seconds to Live, refreshing its life span on each subsequent use of the Continuation Token. Profiles that change during the course of paging will not be reflected in the results. AB Test segments are currently not supported by this operation.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayersInSegmentResult>> GetPlayersInSegmentAsync(final GetPlayersInSegmentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayersInSegmentResult>>() {
            public PlayFabResult<GetPlayersInSegmentResult> call() throws Exception {
                return privateGetPlayersInSegmentAsync(request);
            }
        });
    }

    /**
     * Allows for paging through all players in a given segment. This API creates a snapshot of all player profiles that match the segment definition at the time of its creation and lives through the Total Seconds to Live, refreshing its life span on each subsequent use of the Continuation Token. Profiles that change during the course of paging will not be reflected in the results. AB Test segments are currently not supported by this operation.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayersInSegmentResult> GetPlayersInSegment(final GetPlayersInSegmentRequest request) {
        FutureTask<PlayFabResult<GetPlayersInSegmentResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayersInSegmentResult>>() {
            public PlayFabResult<GetPlayersInSegmentResult> call() throws Exception {
                return privateGetPlayersInSegmentAsync(request);
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
     * Allows for paging through all players in a given segment. This API creates a snapshot of all player profiles that match the segment definition at the time of its creation and lives through the Total Seconds to Live, refreshing its life span on each subsequent use of the Continuation Token. Profiles that change during the course of paging will not be reflected in the results. AB Test segments are currently not supported by this operation.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayersInSegmentResult> privateGetPlayersInSegmentAsync(final GetPlayersInSegmentRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetPlayersInSegment", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayersInSegmentResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayersInSegmentResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayersInSegmentResult>>(){}.getType());
        GetPlayersInSegmentResult result = resultData.data;

        PlayFabResult<GetPlayersInSegmentResult> pfResult = new PlayFabResult<GetPlayersInSegmentResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get all tags with a given Namespace (optional) from a player profile.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerTagsResult>> GetPlayerTagsAsync(final GetPlayerTagsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerTagsResult>>() {
            public PlayFabResult<GetPlayerTagsResult> call() throws Exception {
                return privateGetPlayerTagsAsync(request);
            }
        });
    }

    /**
     * Get all tags with a given Namespace (optional) from a player profile.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerTagsResult> GetPlayerTags(final GetPlayerTagsRequest request) {
        FutureTask<PlayFabResult<GetPlayerTagsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerTagsResult>>() {
            public PlayFabResult<GetPlayerTagsResult> call() throws Exception {
                return privateGetPlayerTagsAsync(request);
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
     * Get all tags with a given Namespace (optional) from a player profile.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerTagsResult> privateGetPlayerTagsAsync(final GetPlayerTagsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetPlayerTags", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerTagsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerTagsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerTagsResult>>(){}.getType());
        GetPlayerTagsResult result = resultData.data;

        PlayFabResult<GetPlayerTagsResult> pfResult = new PlayFabResult<GetPlayerTagsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Remove a given tag from a player profile. The tag's namespace is automatically generated based on the source of the tag.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RemovePlayerTagResult>> RemovePlayerTagAsync(final RemovePlayerTagRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemovePlayerTagResult>>() {
            public PlayFabResult<RemovePlayerTagResult> call() throws Exception {
                return privateRemovePlayerTagAsync(request);
            }
        });
    }

    /**
     * Remove a given tag from a player profile. The tag's namespace is automatically generated based on the source of the tag.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RemovePlayerTagResult> RemovePlayerTag(final RemovePlayerTagRequest request) {
        FutureTask<PlayFabResult<RemovePlayerTagResult>> task = new FutureTask(new Callable<PlayFabResult<RemovePlayerTagResult>>() {
            public PlayFabResult<RemovePlayerTagResult> call() throws Exception {
                return privateRemovePlayerTagAsync(request);
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
     * Remove a given tag from a player profile. The tag's namespace is automatically generated based on the source of the tag.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RemovePlayerTagResult> privateRemovePlayerTagAsync(final RemovePlayerTagRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/RemovePlayerTag", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RemovePlayerTagResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RemovePlayerTagResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RemovePlayerTagResult>>(){}.getType());
        RemovePlayerTagResult result = resultData.data;

        PlayFabResult<RemovePlayerTagResult> pfResult = new PlayFabResult<RemovePlayerTagResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Abort an ongoing task instance.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> AbortTaskInstanceAsync(final AbortTaskInstanceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateAbortTaskInstanceAsync(request);
            }
        });
    }

    /**
     * Abort an ongoing task instance.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> AbortTaskInstance(final AbortTaskInstanceRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateAbortTaskInstanceAsync(request);
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
     * Abort an ongoing task instance.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateAbortTaskInstanceAsync(final AbortTaskInstanceRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/AbortTaskInstance", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Create an ActionsOnPlayersInSegment task, which iterates through all players in a segment to execute action.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateTaskResult>> CreateActionsOnPlayersInSegmentTaskAsync(final CreateActionsOnPlayerSegmentTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateActionsOnPlayersInSegmentTaskAsync(request);
            }
        });
    }

    /**
     * Create an ActionsOnPlayersInSegment task, which iterates through all players in a segment to execute action.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateTaskResult> CreateActionsOnPlayersInSegmentTask(final CreateActionsOnPlayerSegmentTaskRequest request) {
        FutureTask<PlayFabResult<CreateTaskResult>> task = new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateActionsOnPlayersInSegmentTaskAsync(request);
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
     * Create an ActionsOnPlayersInSegment task, which iterates through all players in a segment to execute action.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateTaskResult> privateCreateActionsOnPlayersInSegmentTaskAsync(final CreateActionsOnPlayerSegmentTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/CreateActionsOnPlayersInSegmentTask", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateTaskResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateTaskResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateTaskResult>>(){}.getType());
        CreateTaskResult result = resultData.data;

        PlayFabResult<CreateTaskResult> pfResult = new PlayFabResult<CreateTaskResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Create a CloudScript task, which can run a CloudScript on a schedule.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateTaskResult>> CreateCloudScriptTaskAsync(final CreateCloudScriptTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateCloudScriptTaskAsync(request);
            }
        });
    }

    /**
     * Create a CloudScript task, which can run a CloudScript on a schedule.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateTaskResult> CreateCloudScriptTask(final CreateCloudScriptTaskRequest request) {
        FutureTask<PlayFabResult<CreateTaskResult>> task = new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateCloudScriptTaskAsync(request);
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
     * Create a CloudScript task, which can run a CloudScript on a schedule.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateTaskResult> privateCreateCloudScriptTaskAsync(final CreateCloudScriptTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/CreateCloudScriptTask", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateTaskResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateTaskResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateTaskResult>>(){}.getType());
        CreateTaskResult result = resultData.data;

        PlayFabResult<CreateTaskResult> pfResult = new PlayFabResult<CreateTaskResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Delete a task.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> DeleteTaskAsync(final DeleteTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateDeleteTaskAsync(request);
            }
        });
    }

    /**
     * Delete a task.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> DeleteTask(final DeleteTaskRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateDeleteTaskAsync(request);
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
     * Delete a task.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateDeleteTaskAsync(final DeleteTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/DeleteTask", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Get information about a ActionsOnPlayersInSegment task instance.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>> GetActionsOnPlayersInSegmentTaskInstanceAsync(final GetTaskInstanceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>>() {
            public PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> call() throws Exception {
                return privateGetActionsOnPlayersInSegmentTaskInstanceAsync(request);
            }
        });
    }

    /**
     * Get information about a ActionsOnPlayersInSegment task instance.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> GetActionsOnPlayersInSegmentTaskInstance(final GetTaskInstanceRequest request) {
        FutureTask<PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>> task = new FutureTask(new Callable<PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>>() {
            public PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> call() throws Exception {
                return privateGetActionsOnPlayersInSegmentTaskInstanceAsync(request);
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
     * Get information about a ActionsOnPlayersInSegment task instance.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> privateGetActionsOnPlayersInSegmentTaskInstanceAsync(final GetTaskInstanceRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetActionsOnPlayersInSegmentTaskInstance", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetActionsOnPlayersInSegmentTaskInstanceResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetActionsOnPlayersInSegmentTaskInstanceResult>>(){}.getType());
        GetActionsOnPlayersInSegmentTaskInstanceResult result = resultData.data;

        PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> pfResult = new PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get detail information about a CloudScript task instance.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCloudScriptTaskInstanceResult>> GetCloudScriptTaskInstanceAsync(final GetTaskInstanceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCloudScriptTaskInstanceResult>>() {
            public PlayFabResult<GetCloudScriptTaskInstanceResult> call() throws Exception {
                return privateGetCloudScriptTaskInstanceAsync(request);
            }
        });
    }

    /**
     * Get detail information about a CloudScript task instance.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCloudScriptTaskInstanceResult> GetCloudScriptTaskInstance(final GetTaskInstanceRequest request) {
        FutureTask<PlayFabResult<GetCloudScriptTaskInstanceResult>> task = new FutureTask(new Callable<PlayFabResult<GetCloudScriptTaskInstanceResult>>() {
            public PlayFabResult<GetCloudScriptTaskInstanceResult> call() throws Exception {
                return privateGetCloudScriptTaskInstanceAsync(request);
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
     * Get detail information about a CloudScript task instance.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCloudScriptTaskInstanceResult> privateGetCloudScriptTaskInstanceAsync(final GetTaskInstanceRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetCloudScriptTaskInstance", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCloudScriptTaskInstanceResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetCloudScriptTaskInstanceResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCloudScriptTaskInstanceResult>>(){}.getType());
        GetCloudScriptTaskInstanceResult result = resultData.data;

        PlayFabResult<GetCloudScriptTaskInstanceResult> pfResult = new PlayFabResult<GetCloudScriptTaskInstanceResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Query for task instances by task, status, or time range.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTaskInstancesResult>> GetTaskInstancesAsync(final GetTaskInstancesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTaskInstancesResult>>() {
            public PlayFabResult<GetTaskInstancesResult> call() throws Exception {
                return privateGetTaskInstancesAsync(request);
            }
        });
    }

    /**
     * Query for task instances by task, status, or time range.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTaskInstancesResult> GetTaskInstances(final GetTaskInstancesRequest request) {
        FutureTask<PlayFabResult<GetTaskInstancesResult>> task = new FutureTask(new Callable<PlayFabResult<GetTaskInstancesResult>>() {
            public PlayFabResult<GetTaskInstancesResult> call() throws Exception {
                return privateGetTaskInstancesAsync(request);
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
     * Query for task instances by task, status, or time range.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTaskInstancesResult> privateGetTaskInstancesAsync(final GetTaskInstancesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetTaskInstances", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTaskInstancesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTaskInstancesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTaskInstancesResult>>(){}.getType());
        GetTaskInstancesResult result = resultData.data;

        PlayFabResult<GetTaskInstancesResult> pfResult = new PlayFabResult<GetTaskInstancesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get definition information on a specified task or all tasks within a title.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTasksResult>> GetTasksAsync(final GetTasksRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTasksResult>>() {
            public PlayFabResult<GetTasksResult> call() throws Exception {
                return privateGetTasksAsync(request);
            }
        });
    }

    /**
     * Get definition information on a specified task or all tasks within a title.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTasksResult> GetTasks(final GetTasksRequest request) {
        FutureTask<PlayFabResult<GetTasksResult>> task = new FutureTask(new Callable<PlayFabResult<GetTasksResult>>() {
            public PlayFabResult<GetTasksResult> call() throws Exception {
                return privateGetTasksAsync(request);
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
     * Get definition information on a specified task or all tasks within a title.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTasksResult> privateGetTasksAsync(final GetTasksRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/GetTasks", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTasksResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTasksResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTasksResult>>(){}.getType());
        GetTasksResult result = resultData.data;

        PlayFabResult<GetTasksResult> pfResult = new PlayFabResult<GetTasksResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Run a task immediately regardless of its schedule.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RunTaskResult>> RunTaskAsync(final RunTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RunTaskResult>>() {
            public PlayFabResult<RunTaskResult> call() throws Exception {
                return privateRunTaskAsync(request);
            }
        });
    }

    /**
     * Run a task immediately regardless of its schedule.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RunTaskResult> RunTask(final RunTaskRequest request) {
        FutureTask<PlayFabResult<RunTaskResult>> task = new FutureTask(new Callable<PlayFabResult<RunTaskResult>>() {
            public PlayFabResult<RunTaskResult> call() throws Exception {
                return privateRunTaskAsync(request);
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
     * Run a task immediately regardless of its schedule.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RunTaskResult> privateRunTaskAsync(final RunTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/RunTask", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RunTaskResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RunTaskResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RunTaskResult>>(){}.getType());
        RunTaskResult result = resultData.data;

        PlayFabResult<RunTaskResult> pfResult = new PlayFabResult<RunTaskResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Update an existing task.
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> UpdateTaskAsync(final UpdateTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateUpdateTaskAsync(request);
            }
        });
    }

    /**
     * Update an existing task.
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> UpdateTask(final UpdateTaskRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateUpdateTaskAsync(request);
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
     * Update an existing task.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateUpdateTaskAsync(final UpdateTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Admin/UpdateTask", request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
}
