package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabClientModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /**
     * APIs which provide the full range of PlayFab features available to the client - authentication, account and data
     * management, inventory, friends, matchmaking, reporting, and platform-specific functionality
     */
public class PlayFabClientAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Accepts an open trade (one that has not yet been accepted or cancelled), if the locally signed-in player is in the
     * allowed player list for the trade, or it is open to all players. If the call is successful, the offered and accepted
     * items will be swapped between the two players' inventories.
     * @param request AcceptTradeRequest
     * @return Async Task will return AcceptTradeResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AcceptTradeResponse>> AcceptTradeAsync(final AcceptTradeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AcceptTradeResponse>>() {
            public PlayFabResult<AcceptTradeResponse> call() throws Exception {
                return privateAcceptTradeAsync(request);
            }
        });
    }

    /**
     * Accepts an open trade (one that has not yet been accepted or cancelled), if the locally signed-in player is in the
     * allowed player list for the trade, or it is open to all players. If the call is successful, the offered and accepted
     * items will be swapped between the two players' inventories.
     * @param request AcceptTradeRequest
     * @return AcceptTradeResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AcceptTradeResponse> AcceptTrade(final AcceptTradeRequest request) {
        FutureTask<PlayFabResult<AcceptTradeResponse>> task = new FutureTask(new Callable<PlayFabResult<AcceptTradeResponse>>() {
            public PlayFabResult<AcceptTradeResponse> call() throws Exception {
                return privateAcceptTradeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AcceptTradeResponse> exceptionResult = new PlayFabResult<AcceptTradeResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Accepts an open trade (one that has not yet been accepted or cancelled), if the locally signed-in player is in the
     * allowed player list for the trade, or it is open to all players. If the call is successful, the offered and accepted
     * items will be swapped between the two players' inventories.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AcceptTradeResponse> privateAcceptTradeAsync(final AcceptTradeRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/AcceptTrade"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AcceptTradeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AcceptTradeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AcceptTradeResponse>>(){}.getType());
        AcceptTradeResponse result = resultData.data;

        PlayFabResult<AcceptTradeResponse> pfResult = new PlayFabResult<AcceptTradeResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds the PlayFab user, based upon a match against a supplied unique identifier, to the friend list of the local user. At
     * least one of FriendPlayFabId,FriendUsername,FriendEmail, or FriendTitleDisplayName should be initialized.
     * @param request AddFriendRequest
     * @return Async Task will return AddFriendResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddFriendResult>> AddFriendAsync(final AddFriendRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddFriendResult>>() {
            public PlayFabResult<AddFriendResult> call() throws Exception {
                return privateAddFriendAsync(request);
            }
        });
    }

    /**
     * Adds the PlayFab user, based upon a match against a supplied unique identifier, to the friend list of the local user. At
     * least one of FriendPlayFabId,FriendUsername,FriendEmail, or FriendTitleDisplayName should be initialized.
     * @param request AddFriendRequest
     * @return AddFriendResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddFriendResult> AddFriend(final AddFriendRequest request) {
        FutureTask<PlayFabResult<AddFriendResult>> task = new FutureTask(new Callable<PlayFabResult<AddFriendResult>>() {
            public PlayFabResult<AddFriendResult> call() throws Exception {
                return privateAddFriendAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AddFriendResult> exceptionResult = new PlayFabResult<AddFriendResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Adds the PlayFab user, based upon a match against a supplied unique identifier, to the friend list of the local user. At
     * least one of FriendPlayFabId,FriendUsername,FriendEmail, or FriendTitleDisplayName should be initialized.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddFriendResult> privateAddFriendAsync(final AddFriendRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/AddFriend"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddFriendResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AddFriendResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddFriendResult>>(){}.getType());
        AddFriendResult result = resultData.data;

        PlayFabResult<AddFriendResult> pfResult = new PlayFabResult<AddFriendResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds the specified generic service identifier to the player's PlayFab account. This is designed to allow for a PlayFab
     * ID lookup of any arbitrary service identifier a title wants to add. This identifier should never be used as
     * authentication credentials, as the intent is that it is easily accessible by other players.
     * @param request AddGenericIDRequest
     * @return Async Task will return AddGenericIDResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddGenericIDResult>> AddGenericIDAsync(final AddGenericIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddGenericIDResult>>() {
            public PlayFabResult<AddGenericIDResult> call() throws Exception {
                return privateAddGenericIDAsync(request);
            }
        });
    }

    /**
     * Adds the specified generic service identifier to the player's PlayFab account. This is designed to allow for a PlayFab
     * ID lookup of any arbitrary service identifier a title wants to add. This identifier should never be used as
     * authentication credentials, as the intent is that it is easily accessible by other players.
     * @param request AddGenericIDRequest
     * @return AddGenericIDResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddGenericIDResult> AddGenericID(final AddGenericIDRequest request) {
        FutureTask<PlayFabResult<AddGenericIDResult>> task = new FutureTask(new Callable<PlayFabResult<AddGenericIDResult>>() {
            public PlayFabResult<AddGenericIDResult> call() throws Exception {
                return privateAddGenericIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AddGenericIDResult> exceptionResult = new PlayFabResult<AddGenericIDResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Adds the specified generic service identifier to the player's PlayFab account. This is designed to allow for a PlayFab
     * ID lookup of any arbitrary service identifier a title wants to add. This identifier should never be used as
     * authentication credentials, as the intent is that it is easily accessible by other players.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddGenericIDResult> privateAddGenericIDAsync(final AddGenericIDRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/AddGenericID"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddGenericIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AddGenericIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddGenericIDResult>>(){}.getType());
        AddGenericIDResult result = resultData.data;

        PlayFabResult<AddGenericIDResult> pfResult = new PlayFabResult<AddGenericIDResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds or updates a contact email to the player's profile.
     * @param request AddOrUpdateContactEmailRequest
     * @return Async Task will return AddOrUpdateContactEmailResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddOrUpdateContactEmailResult>> AddOrUpdateContactEmailAsync(final AddOrUpdateContactEmailRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddOrUpdateContactEmailResult>>() {
            public PlayFabResult<AddOrUpdateContactEmailResult> call() throws Exception {
                return privateAddOrUpdateContactEmailAsync(request);
            }
        });
    }

    /**
     * Adds or updates a contact email to the player's profile.
     * @param request AddOrUpdateContactEmailRequest
     * @return AddOrUpdateContactEmailResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddOrUpdateContactEmailResult> AddOrUpdateContactEmail(final AddOrUpdateContactEmailRequest request) {
        FutureTask<PlayFabResult<AddOrUpdateContactEmailResult>> task = new FutureTask(new Callable<PlayFabResult<AddOrUpdateContactEmailResult>>() {
            public PlayFabResult<AddOrUpdateContactEmailResult> call() throws Exception {
                return privateAddOrUpdateContactEmailAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AddOrUpdateContactEmailResult> exceptionResult = new PlayFabResult<AddOrUpdateContactEmailResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Adds or updates a contact email to the player's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddOrUpdateContactEmailResult> privateAddOrUpdateContactEmailAsync(final AddOrUpdateContactEmailRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/AddOrUpdateContactEmail"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddOrUpdateContactEmailResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AddOrUpdateContactEmailResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddOrUpdateContactEmailResult>>(){}.getType());
        AddOrUpdateContactEmailResult result = resultData.data;

        PlayFabResult<AddOrUpdateContactEmailResult> pfResult = new PlayFabResult<AddOrUpdateContactEmailResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users
     * in the group can add new members. Shared Groups are designed for sharing data between a very small number of players,
     * please see our guide: https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request AddSharedGroupMembersRequest
     * @return Async Task will return AddSharedGroupMembersResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddSharedGroupMembersResult>> AddSharedGroupMembersAsync(final AddSharedGroupMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddSharedGroupMembersResult>>() {
            public PlayFabResult<AddSharedGroupMembersResult> call() throws Exception {
                return privateAddSharedGroupMembersAsync(request);
            }
        });
    }

    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users
     * in the group can add new members. Shared Groups are designed for sharing data between a very small number of players,
     * please see our guide: https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request AddSharedGroupMembersRequest
     * @return AddSharedGroupMembersResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddSharedGroupMembersResult> AddSharedGroupMembers(final AddSharedGroupMembersRequest request) {
        FutureTask<PlayFabResult<AddSharedGroupMembersResult>> task = new FutureTask(new Callable<PlayFabResult<AddSharedGroupMembersResult>>() {
            public PlayFabResult<AddSharedGroupMembersResult> call() throws Exception {
                return privateAddSharedGroupMembersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AddSharedGroupMembersResult> exceptionResult = new PlayFabResult<AddSharedGroupMembersResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users
     * in the group can add new members. Shared Groups are designed for sharing data between a very small number of players,
     * please see our guide: https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddSharedGroupMembersResult> privateAddSharedGroupMembersAsync(final AddSharedGroupMembersRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/AddSharedGroupMembers"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Adds playfab username/password auth to an existing account created via an anonymous auth method, e.g. automatic device
     * ID login.
     * @param request AddUsernamePasswordRequest
     * @return Async Task will return AddUsernamePasswordResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddUsernamePasswordResult>> AddUsernamePasswordAsync(final AddUsernamePasswordRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddUsernamePasswordResult>>() {
            public PlayFabResult<AddUsernamePasswordResult> call() throws Exception {
                return privateAddUsernamePasswordAsync(request);
            }
        });
    }

    /**
     * Adds playfab username/password auth to an existing account created via an anonymous auth method, e.g. automatic device
     * ID login.
     * @param request AddUsernamePasswordRequest
     * @return AddUsernamePasswordResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddUsernamePasswordResult> AddUsernamePassword(final AddUsernamePasswordRequest request) {
        FutureTask<PlayFabResult<AddUsernamePasswordResult>> task = new FutureTask(new Callable<PlayFabResult<AddUsernamePasswordResult>>() {
            public PlayFabResult<AddUsernamePasswordResult> call() throws Exception {
                return privateAddUsernamePasswordAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AddUsernamePasswordResult> exceptionResult = new PlayFabResult<AddUsernamePasswordResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Adds playfab username/password auth to an existing account created via an anonymous auth method, e.g. automatic device
     * ID login.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddUsernamePasswordResult> privateAddUsernamePasswordAsync(final AddUsernamePasswordRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/AddUsernamePassword"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddUsernamePasswordResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AddUsernamePasswordResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddUsernamePasswordResult>>(){}.getType());
        AddUsernamePasswordResult result = resultData.data;

        PlayFabResult<AddUsernamePasswordResult> pfResult = new PlayFabResult<AddUsernamePasswordResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Increments the user's balance of the specified virtual currency by the stated amount
     * @param request AddUserVirtualCurrencyRequest
     * @return Async Task will return ModifyUserVirtualCurrencyResult
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Increments the user's balance of the specified virtual currency by the stated amount
     * @param request AddUserVirtualCurrencyRequest
     * @return ModifyUserVirtualCurrencyResult
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
            PlayFabResult<ModifyUserVirtualCurrencyResult> exceptionResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Increments the user's balance of the specified virtual currency by the stated amount
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateAddUserVirtualCurrencyAsync(final AddUserVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/AddUserVirtualCurrency"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Registers the Android device to receive push notifications
     * @param request AndroidDevicePushNotificationRegistrationRequest
     * @return Async Task will return AndroidDevicePushNotificationRegistrationResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AndroidDevicePushNotificationRegistrationResult>> AndroidDevicePushNotificationRegistrationAsync(final AndroidDevicePushNotificationRegistrationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AndroidDevicePushNotificationRegistrationResult>>() {
            public PlayFabResult<AndroidDevicePushNotificationRegistrationResult> call() throws Exception {
                return privateAndroidDevicePushNotificationRegistrationAsync(request);
            }
        });
    }

    /**
     * Registers the Android device to receive push notifications
     * @param request AndroidDevicePushNotificationRegistrationRequest
     * @return AndroidDevicePushNotificationRegistrationResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AndroidDevicePushNotificationRegistrationResult> AndroidDevicePushNotificationRegistration(final AndroidDevicePushNotificationRegistrationRequest request) {
        FutureTask<PlayFabResult<AndroidDevicePushNotificationRegistrationResult>> task = new FutureTask(new Callable<PlayFabResult<AndroidDevicePushNotificationRegistrationResult>>() {
            public PlayFabResult<AndroidDevicePushNotificationRegistrationResult> call() throws Exception {
                return privateAndroidDevicePushNotificationRegistrationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AndroidDevicePushNotificationRegistrationResult> exceptionResult = new PlayFabResult<AndroidDevicePushNotificationRegistrationResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Registers the Android device to receive push notifications */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AndroidDevicePushNotificationRegistrationResult> privateAndroidDevicePushNotificationRegistrationAsync(final AndroidDevicePushNotificationRegistrationRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/AndroidDevicePushNotificationRegistration"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AndroidDevicePushNotificationRegistrationResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AndroidDevicePushNotificationRegistrationResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AndroidDevicePushNotificationRegistrationResult>>(){}.getType());
        AndroidDevicePushNotificationRegistrationResult result = resultData.data;

        PlayFabResult<AndroidDevicePushNotificationRegistrationResult> pfResult = new PlayFabResult<AndroidDevicePushNotificationRegistrationResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Attributes an install for advertisment.
     * @param request AttributeInstallRequest
     * @return Async Task will return AttributeInstallResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AttributeInstallResult>> AttributeInstallAsync(final AttributeInstallRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AttributeInstallResult>>() {
            public PlayFabResult<AttributeInstallResult> call() throws Exception {
                return privateAttributeInstallAsync(request);
            }
        });
    }

    /**
     * Attributes an install for advertisment.
     * @param request AttributeInstallRequest
     * @return AttributeInstallResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AttributeInstallResult> AttributeInstall(final AttributeInstallRequest request) {
        FutureTask<PlayFabResult<AttributeInstallResult>> task = new FutureTask(new Callable<PlayFabResult<AttributeInstallResult>>() {
            public PlayFabResult<AttributeInstallResult> call() throws Exception {
                return privateAttributeInstallAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AttributeInstallResult> exceptionResult = new PlayFabResult<AttributeInstallResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Attributes an install for advertisment. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AttributeInstallResult> privateAttributeInstallAsync(final AttributeInstallRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/AttributeInstall"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AttributeInstallResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AttributeInstallResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AttributeInstallResult>>(){}.getType());
        AttributeInstallResult result = resultData.data;

        PlayFabResult<AttributeInstallResult> pfResult = new PlayFabResult<AttributeInstallResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Cancels an open trade (one that has not yet been accepted or cancelled). Note that only the player who created the trade
     * can cancel it via this API call, to prevent griefing of the trade system (cancelling trades in order to prevent other
     * players from accepting them, for trades that can be claimed by more than one player).
     * @param request CancelTradeRequest
     * @return Async Task will return CancelTradeResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CancelTradeResponse>> CancelTradeAsync(final CancelTradeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CancelTradeResponse>>() {
            public PlayFabResult<CancelTradeResponse> call() throws Exception {
                return privateCancelTradeAsync(request);
            }
        });
    }

    /**
     * Cancels an open trade (one that has not yet been accepted or cancelled). Note that only the player who created the trade
     * can cancel it via this API call, to prevent griefing of the trade system (cancelling trades in order to prevent other
     * players from accepting them, for trades that can be claimed by more than one player).
     * @param request CancelTradeRequest
     * @return CancelTradeResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CancelTradeResponse> CancelTrade(final CancelTradeRequest request) {
        FutureTask<PlayFabResult<CancelTradeResponse>> task = new FutureTask(new Callable<PlayFabResult<CancelTradeResponse>>() {
            public PlayFabResult<CancelTradeResponse> call() throws Exception {
                return privateCancelTradeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CancelTradeResponse> exceptionResult = new PlayFabResult<CancelTradeResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Cancels an open trade (one that has not yet been accepted or cancelled). Note that only the player who created the trade
     * can cancel it via this API call, to prevent griefing of the trade system (cancelling trades in order to prevent other
     * players from accepting them, for trades that can be claimed by more than one player).
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CancelTradeResponse> privateCancelTradeAsync(final CancelTradeRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/CancelTrade"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CancelTradeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CancelTradeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CancelTradeResponse>>(){}.getType());
        CancelTradeResponse result = resultData.data;

        PlayFabResult<CancelTradeResponse> pfResult = new PlayFabResult<CancelTradeResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and
     * virtual currency balances as appropriate
     * @param request ConfirmPurchaseRequest
     * @return Async Task will return ConfirmPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ConfirmPurchaseResult>> ConfirmPurchaseAsync(final ConfirmPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ConfirmPurchaseResult>>() {
            public PlayFabResult<ConfirmPurchaseResult> call() throws Exception {
                return privateConfirmPurchaseAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and
     * virtual currency balances as appropriate
     * @param request ConfirmPurchaseRequest
     * @return ConfirmPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ConfirmPurchaseResult> ConfirmPurchase(final ConfirmPurchaseRequest request) {
        FutureTask<PlayFabResult<ConfirmPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<ConfirmPurchaseResult>>() {
            public PlayFabResult<ConfirmPurchaseResult> call() throws Exception {
                return privateConfirmPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ConfirmPurchaseResult> exceptionResult = new PlayFabResult<ConfirmPurchaseResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and
     * virtual currency balances as appropriate
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ConfirmPurchaseResult> privateConfirmPurchaseAsync(final ConfirmPurchaseRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ConfirmPurchase"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ConfirmPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ConfirmPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ConfirmPurchaseResult>>(){}.getType());
        ConfirmPurchaseResult result = resultData.data;

        PlayFabResult<ConfirmPurchaseResult> pfResult = new PlayFabResult<ConfirmPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's
     * inventory.
     * @param request ConsumeItemRequest
     * @return Async Task will return ConsumeItemResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ConsumeItemResult>> ConsumeItemAsync(final ConsumeItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ConsumeItemResult>>() {
            public PlayFabResult<ConsumeItemResult> call() throws Exception {
                return privateConsumeItemAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's
     * inventory.
     * @param request ConsumeItemRequest
     * @return ConsumeItemResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ConsumeItemResult> ConsumeItem(final ConsumeItemRequest request) {
        FutureTask<PlayFabResult<ConsumeItemResult>> task = new FutureTask(new Callable<PlayFabResult<ConsumeItemResult>>() {
            public PlayFabResult<ConsumeItemResult> call() throws Exception {
                return privateConsumeItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ConsumeItemResult> exceptionResult = new PlayFabResult<ConsumeItemResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's
     * inventory.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ConsumeItemResult> privateConsumeItemAsync(final ConsumeItemRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ConsumeItem"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ConsumeItemResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ConsumeItemResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ConsumeItemResult>>(){}.getType());
        ConsumeItemResult result = resultData.data;

        PlayFabResult<ConsumeItemResult> pfResult = new PlayFabResult<ConsumeItemResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Grants the player's current entitlements from Microsoft Store's Collection API
     * @param request ConsumeMicrosoftStoreEntitlementsRequest
     * @return Async Task will return ConsumeMicrosoftStoreEntitlementsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse>> ConsumeMicrosoftStoreEntitlementsAsync(final ConsumeMicrosoftStoreEntitlementsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse>>() {
            public PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse> call() throws Exception {
                return privateConsumeMicrosoftStoreEntitlementsAsync(request);
            }
        });
    }

    /**
     * Grants the player's current entitlements from Microsoft Store's Collection API
     * @param request ConsumeMicrosoftStoreEntitlementsRequest
     * @return ConsumeMicrosoftStoreEntitlementsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse> ConsumeMicrosoftStoreEntitlements(final ConsumeMicrosoftStoreEntitlementsRequest request) {
        FutureTask<PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse>> task = new FutureTask(new Callable<PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse>>() {
            public PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse> call() throws Exception {
                return privateConsumeMicrosoftStoreEntitlementsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse> exceptionResult = new PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Grants the player's current entitlements from Microsoft Store's Collection API */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse> privateConsumeMicrosoftStoreEntitlementsAsync(final ConsumeMicrosoftStoreEntitlementsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ConsumeMicrosoftStoreEntitlements"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ConsumeMicrosoftStoreEntitlementsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ConsumeMicrosoftStoreEntitlementsResponse>>(){}.getType());
        ConsumeMicrosoftStoreEntitlementsResponse result = resultData.data;

        PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse> pfResult = new PlayFabResult<ConsumeMicrosoftStoreEntitlementsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Checks for any new consumable entitlements. If any are found, they are consumed (if they're consumables) and added as
     * PlayFab items
     * @param request ConsumePS5EntitlementsRequest
     * @return Async Task will return ConsumePS5EntitlementsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ConsumePS5EntitlementsResult>> ConsumePS5EntitlementsAsync(final ConsumePS5EntitlementsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ConsumePS5EntitlementsResult>>() {
            public PlayFabResult<ConsumePS5EntitlementsResult> call() throws Exception {
                return privateConsumePS5EntitlementsAsync(request);
            }
        });
    }

    /**
     * Checks for any new consumable entitlements. If any are found, they are consumed (if they're consumables) and added as
     * PlayFab items
     * @param request ConsumePS5EntitlementsRequest
     * @return ConsumePS5EntitlementsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ConsumePS5EntitlementsResult> ConsumePS5Entitlements(final ConsumePS5EntitlementsRequest request) {
        FutureTask<PlayFabResult<ConsumePS5EntitlementsResult>> task = new FutureTask(new Callable<PlayFabResult<ConsumePS5EntitlementsResult>>() {
            public PlayFabResult<ConsumePS5EntitlementsResult> call() throws Exception {
                return privateConsumePS5EntitlementsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ConsumePS5EntitlementsResult> exceptionResult = new PlayFabResult<ConsumePS5EntitlementsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Checks for any new consumable entitlements. If any are found, they are consumed (if they're consumables) and added as
     * PlayFab items
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ConsumePS5EntitlementsResult> privateConsumePS5EntitlementsAsync(final ConsumePS5EntitlementsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ConsumePS5Entitlements"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ConsumePS5EntitlementsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ConsumePS5EntitlementsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ConsumePS5EntitlementsResult>>(){}.getType());
        ConsumePS5EntitlementsResult result = resultData.data;

        PlayFabResult<ConsumePS5EntitlementsResult> pfResult = new PlayFabResult<ConsumePS5EntitlementsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Checks for any new consumable entitlements. If any are found, they are consumed and added as PlayFab items
     * @param request ConsumePSNEntitlementsRequest
     * @return Async Task will return ConsumePSNEntitlementsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ConsumePSNEntitlementsResult>> ConsumePSNEntitlementsAsync(final ConsumePSNEntitlementsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ConsumePSNEntitlementsResult>>() {
            public PlayFabResult<ConsumePSNEntitlementsResult> call() throws Exception {
                return privateConsumePSNEntitlementsAsync(request);
            }
        });
    }

    /**
     * Checks for any new consumable entitlements. If any are found, they are consumed and added as PlayFab items
     * @param request ConsumePSNEntitlementsRequest
     * @return ConsumePSNEntitlementsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ConsumePSNEntitlementsResult> ConsumePSNEntitlements(final ConsumePSNEntitlementsRequest request) {
        FutureTask<PlayFabResult<ConsumePSNEntitlementsResult>> task = new FutureTask(new Callable<PlayFabResult<ConsumePSNEntitlementsResult>>() {
            public PlayFabResult<ConsumePSNEntitlementsResult> call() throws Exception {
                return privateConsumePSNEntitlementsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ConsumePSNEntitlementsResult> exceptionResult = new PlayFabResult<ConsumePSNEntitlementsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Checks for any new consumable entitlements. If any are found, they are consumed and added as PlayFab items */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ConsumePSNEntitlementsResult> privateConsumePSNEntitlementsAsync(final ConsumePSNEntitlementsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ConsumePSNEntitlements"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ConsumePSNEntitlementsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ConsumePSNEntitlementsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ConsumePSNEntitlementsResult>>(){}.getType());
        ConsumePSNEntitlementsResult result = resultData.data;

        PlayFabResult<ConsumePSNEntitlementsResult> pfResult = new PlayFabResult<ConsumePSNEntitlementsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Grants the player's current entitlements from Xbox Live, consuming all availble items in Xbox and granting them to the
     * player's PlayFab inventory. This call is idempotent and will not grant previously granted items to the player.
     * @param request ConsumeXboxEntitlementsRequest
     * @return Async Task will return ConsumeXboxEntitlementsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ConsumeXboxEntitlementsResult>> ConsumeXboxEntitlementsAsync(final ConsumeXboxEntitlementsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ConsumeXboxEntitlementsResult>>() {
            public PlayFabResult<ConsumeXboxEntitlementsResult> call() throws Exception {
                return privateConsumeXboxEntitlementsAsync(request);
            }
        });
    }

    /**
     * Grants the player's current entitlements from Xbox Live, consuming all availble items in Xbox and granting them to the
     * player's PlayFab inventory. This call is idempotent and will not grant previously granted items to the player.
     * @param request ConsumeXboxEntitlementsRequest
     * @return ConsumeXboxEntitlementsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ConsumeXboxEntitlementsResult> ConsumeXboxEntitlements(final ConsumeXboxEntitlementsRequest request) {
        FutureTask<PlayFabResult<ConsumeXboxEntitlementsResult>> task = new FutureTask(new Callable<PlayFabResult<ConsumeXboxEntitlementsResult>>() {
            public PlayFabResult<ConsumeXboxEntitlementsResult> call() throws Exception {
                return privateConsumeXboxEntitlementsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ConsumeXboxEntitlementsResult> exceptionResult = new PlayFabResult<ConsumeXboxEntitlementsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Grants the player's current entitlements from Xbox Live, consuming all availble items in Xbox and granting them to the
     * player's PlayFab inventory. This call is idempotent and will not grant previously granted items to the player.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ConsumeXboxEntitlementsResult> privateConsumeXboxEntitlementsAsync(final ConsumeXboxEntitlementsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ConsumeXboxEntitlements"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ConsumeXboxEntitlementsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ConsumeXboxEntitlementsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ConsumeXboxEntitlementsResult>>(){}.getType());
        ConsumeXboxEntitlementsResult result = resultData.data;

        PlayFabResult<ConsumeXboxEntitlementsResult> pfResult = new PlayFabResult<ConsumeXboxEntitlementsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the
     * group. Upon creation, the current user will be the only member of the group. Shared Groups are designed for sharing data
     * between a very small number of players, please see our guide:
     * https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request CreateSharedGroupRequest
     * @return Async Task will return CreateSharedGroupResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateSharedGroupResult>> CreateSharedGroupAsync(final CreateSharedGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateSharedGroupResult>>() {
            public PlayFabResult<CreateSharedGroupResult> call() throws Exception {
                return privateCreateSharedGroupAsync(request);
            }
        });
    }

    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the
     * group. Upon creation, the current user will be the only member of the group. Shared Groups are designed for sharing data
     * between a very small number of players, please see our guide:
     * https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request CreateSharedGroupRequest
     * @return CreateSharedGroupResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateSharedGroupResult> CreateSharedGroup(final CreateSharedGroupRequest request) {
        FutureTask<PlayFabResult<CreateSharedGroupResult>> task = new FutureTask(new Callable<PlayFabResult<CreateSharedGroupResult>>() {
            public PlayFabResult<CreateSharedGroupResult> call() throws Exception {
                return privateCreateSharedGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateSharedGroupResult> exceptionResult = new PlayFabResult<CreateSharedGroupResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the
     * group. Upon creation, the current user will be the only member of the group. Shared Groups are designed for sharing data
     * between a very small number of players, please see our guide:
     * https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateSharedGroupResult> privateCreateSharedGroupAsync(final CreateSharedGroupRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/CreateSharedGroup"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Executes a CloudScript function, with the 'currentPlayerId' set to the PlayFab ID of the authenticated player. The
     * PlayFab ID is the entity ID of the player's master_player_account entity.
     * @param request ExecuteCloudScriptRequest
     * @return Async Task will return ExecuteCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ExecuteCloudScriptResult>> ExecuteCloudScriptAsync(final ExecuteCloudScriptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ExecuteCloudScriptResult>>() {
            public PlayFabResult<ExecuteCloudScriptResult> call() throws Exception {
                return privateExecuteCloudScriptAsync(request);
            }
        });
    }

    /**
     * Executes a CloudScript function, with the 'currentPlayerId' set to the PlayFab ID of the authenticated player. The
     * PlayFab ID is the entity ID of the player's master_player_account entity.
     * @param request ExecuteCloudScriptRequest
     * @return ExecuteCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ExecuteCloudScriptResult> ExecuteCloudScript(final ExecuteCloudScriptRequest request) {
        FutureTask<PlayFabResult<ExecuteCloudScriptResult>> task = new FutureTask(new Callable<PlayFabResult<ExecuteCloudScriptResult>>() {
            public PlayFabResult<ExecuteCloudScriptResult> call() throws Exception {
                return privateExecuteCloudScriptAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ExecuteCloudScriptResult> exceptionResult = new PlayFabResult<ExecuteCloudScriptResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Executes a CloudScript function, with the 'currentPlayerId' set to the PlayFab ID of the authenticated player. The
     * PlayFab ID is the entity ID of the player's master_player_account entity.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ExecuteCloudScriptResult> privateExecuteCloudScriptAsync(final ExecuteCloudScriptRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ExecuteCloudScript"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ExecuteCloudScriptResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ExecuteCloudScriptResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ExecuteCloudScriptResult>>(){}.getType());
        ExecuteCloudScriptResult result = resultData.data;

        PlayFabResult<ExecuteCloudScriptResult> pfResult = new PlayFabResult<ExecuteCloudScriptResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the user's PlayFab account details
     * @param request GetAccountInfoRequest
     * @return Async Task will return GetAccountInfoResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAccountInfoResult>> GetAccountInfoAsync(final GetAccountInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAccountInfoResult>>() {
            public PlayFabResult<GetAccountInfoResult> call() throws Exception {
                return privateGetAccountInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the user's PlayFab account details
     * @param request GetAccountInfoRequest
     * @return GetAccountInfoResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAccountInfoResult> GetAccountInfo(final GetAccountInfoRequest request) {
        FutureTask<PlayFabResult<GetAccountInfoResult>> task = new FutureTask(new Callable<PlayFabResult<GetAccountInfoResult>>() {
            public PlayFabResult<GetAccountInfoResult> call() throws Exception {
                return privateGetAccountInfoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetAccountInfoResult> exceptionResult = new PlayFabResult<GetAccountInfoResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the user's PlayFab account details */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAccountInfoResult> privateGetAccountInfoAsync(final GetAccountInfoRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetAccountInfo"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAccountInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAccountInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAccountInfoResult>>(){}.getType());
        GetAccountInfoResult result = resultData.data;

        PlayFabResult<GetAccountInfoResult> pfResult = new PlayFabResult<GetAccountInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Returns a list of ad placements and a reward for each
     * @param request GetAdPlacementsRequest
     * @return Async Task will return GetAdPlacementsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAdPlacementsResult>> GetAdPlacementsAsync(final GetAdPlacementsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAdPlacementsResult>>() {
            public PlayFabResult<GetAdPlacementsResult> call() throws Exception {
                return privateGetAdPlacementsAsync(request);
            }
        });
    }

    /**
     * Returns a list of ad placements and a reward for each
     * @param request GetAdPlacementsRequest
     * @return GetAdPlacementsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAdPlacementsResult> GetAdPlacements(final GetAdPlacementsRequest request) {
        FutureTask<PlayFabResult<GetAdPlacementsResult>> task = new FutureTask(new Callable<PlayFabResult<GetAdPlacementsResult>>() {
            public PlayFabResult<GetAdPlacementsResult> call() throws Exception {
                return privateGetAdPlacementsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetAdPlacementsResult> exceptionResult = new PlayFabResult<GetAdPlacementsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Returns a list of ad placements and a reward for each */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAdPlacementsResult> privateGetAdPlacementsAsync(final GetAdPlacementsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetAdPlacements"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAdPlacementsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAdPlacementsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAdPlacementsResult>>(){}.getType());
        GetAdPlacementsResult result = resultData.data;

        PlayFabResult<GetAdPlacementsResult> pfResult = new PlayFabResult<GetAdPlacementsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all of the characters that belong to a specific user. CharacterIds are not globally unique; characterId must be
     * evaluated with the parent PlayFabId to guarantee uniqueness.
     * @param request ListUsersCharactersRequest
     * @return Async Task will return ListUsersCharactersResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListUsersCharactersResult>> GetAllUsersCharactersAsync(final ListUsersCharactersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListUsersCharactersResult>>() {
            public PlayFabResult<ListUsersCharactersResult> call() throws Exception {
                return privateGetAllUsersCharactersAsync(request);
            }
        });
    }

    /**
     * Lists all of the characters that belong to a specific user. CharacterIds are not globally unique; characterId must be
     * evaluated with the parent PlayFabId to guarantee uniqueness.
     * @param request ListUsersCharactersRequest
     * @return ListUsersCharactersResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListUsersCharactersResult> GetAllUsersCharacters(final ListUsersCharactersRequest request) {
        FutureTask<PlayFabResult<ListUsersCharactersResult>> task = new FutureTask(new Callable<PlayFabResult<ListUsersCharactersResult>>() {
            public PlayFabResult<ListUsersCharactersResult> call() throws Exception {
                return privateGetAllUsersCharactersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListUsersCharactersResult> exceptionResult = new PlayFabResult<ListUsersCharactersResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Lists all of the characters that belong to a specific user. CharacterIds are not globally unique; characterId must be
     * evaluated with the parent PlayFabId to guarantee uniqueness.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListUsersCharactersResult> privateGetAllUsersCharactersAsync(final ListUsersCharactersRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetAllUsersCharacters"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     * @param request GetCatalogItemsRequest
     * @return Async Task will return GetCatalogItemsResult
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     * @param request GetCatalogItemsRequest
     * @return GetCatalogItemsResult
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
            PlayFabResult<GetCatalogItemsResult> exceptionResult = new PlayFabResult<GetCatalogItemsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCatalogItemsResult> privateGetCatalogItemsAsync(final GetCatalogItemsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetCatalogItems"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves the title-specific custom data for the character which is readable and writable by the client
     * @param request GetCharacterDataRequest
     * @return Async Task will return GetCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCharacterDataResult>> GetCharacterDataAsync(final GetCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the character which is readable and writable by the client
     * @param request GetCharacterDataRequest
     * @return GetCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCharacterDataResult> GetCharacterData(final GetCharacterDataRequest request) {
        FutureTask<PlayFabResult<GetCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCharacterDataResult> exceptionResult = new PlayFabResult<GetCharacterDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the title-specific custom data for the character which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterDataAsync(final GetCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetCharacterData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the specified character's current inventory of virtual goods
     * @param request GetCharacterInventoryRequest
     * @return Async Task will return GetCharacterInventoryResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCharacterInventoryResult>> GetCharacterInventoryAsync(final GetCharacterInventoryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterInventoryResult>>() {
            public PlayFabResult<GetCharacterInventoryResult> call() throws Exception {
                return privateGetCharacterInventoryAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the specified character's current inventory of virtual goods
     * @param request GetCharacterInventoryRequest
     * @return GetCharacterInventoryResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCharacterInventoryResult> GetCharacterInventory(final GetCharacterInventoryRequest request) {
        FutureTask<PlayFabResult<GetCharacterInventoryResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterInventoryResult>>() {
            public PlayFabResult<GetCharacterInventoryResult> call() throws Exception {
                return privateGetCharacterInventoryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCharacterInventoryResult> exceptionResult = new PlayFabResult<GetCharacterInventoryResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the specified character's current inventory of virtual goods
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCharacterInventoryResult> privateGetCharacterInventoryAsync(final GetCharacterInventoryRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetCharacterInventory"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves a list of ranked characters for the given statistic, starting from the indicated point in the leaderboard
     * @param request GetCharacterLeaderboardRequest
     * @return Async Task will return GetCharacterLeaderboardResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCharacterLeaderboardResult>> GetCharacterLeaderboardAsync(final GetCharacterLeaderboardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterLeaderboardResult>>() {
            public PlayFabResult<GetCharacterLeaderboardResult> call() throws Exception {
                return privateGetCharacterLeaderboardAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked characters for the given statistic, starting from the indicated point in the leaderboard
     * @param request GetCharacterLeaderboardRequest
     * @return GetCharacterLeaderboardResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCharacterLeaderboardResult> GetCharacterLeaderboard(final GetCharacterLeaderboardRequest request) {
        FutureTask<PlayFabResult<GetCharacterLeaderboardResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterLeaderboardResult>>() {
            public PlayFabResult<GetCharacterLeaderboardResult> call() throws Exception {
                return privateGetCharacterLeaderboardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCharacterLeaderboardResult> exceptionResult = new PlayFabResult<GetCharacterLeaderboardResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves a list of ranked characters for the given statistic, starting from the indicated point in the leaderboard */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCharacterLeaderboardResult> privateGetCharacterLeaderboardAsync(final GetCharacterLeaderboardRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetCharacterLeaderboard"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves the title-specific custom data for the character which can only be read by the client
     * @param request GetCharacterDataRequest
     * @return Async Task will return GetCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCharacterDataResult>> GetCharacterReadOnlyDataAsync(final GetCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the character which can only be read by the client
     * @param request GetCharacterDataRequest
     * @return GetCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCharacterDataResult> GetCharacterReadOnlyData(final GetCharacterDataRequest request) {
        FutureTask<PlayFabResult<GetCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCharacterDataResult> exceptionResult = new PlayFabResult<GetCharacterDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the title-specific custom data for the character which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterReadOnlyDataAsync(final GetCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetCharacterReadOnlyData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves the details of all title-specific statistics for the user
     * @param request GetCharacterStatisticsRequest
     * @return Async Task will return GetCharacterStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCharacterStatisticsResult>> GetCharacterStatisticsAsync(final GetCharacterStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterStatisticsResult>>() {
            public PlayFabResult<GetCharacterStatisticsResult> call() throws Exception {
                return privateGetCharacterStatisticsAsync(request);
            }
        });
    }

    /**
     * Retrieves the details of all title-specific statistics for the user
     * @param request GetCharacterStatisticsRequest
     * @return GetCharacterStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCharacterStatisticsResult> GetCharacterStatistics(final GetCharacterStatisticsRequest request) {
        FutureTask<PlayFabResult<GetCharacterStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterStatisticsResult>>() {
            public PlayFabResult<GetCharacterStatisticsResult> call() throws Exception {
                return privateGetCharacterStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCharacterStatisticsResult> exceptionResult = new PlayFabResult<GetCharacterStatisticsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the details of all title-specific statistics for the user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCharacterStatisticsResult> privateGetCharacterStatisticsAsync(final GetCharacterStatisticsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetCharacterStatistics"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent HTTP GET to the returned
     * URL will attempt to download the content. A HEAD query to the returned URL will attempt to retrieve the metadata of the
     * content. Note that a successful result does not guarantee the existence of this content - if it has not been uploaded,
     * the query to retrieve the data will fail. See this post for more information:
     * https://community.playfab.com/hc/community/posts/205469488-How-to-upload-files-to-PlayFab-s-Content-Service. Also,
     * please be aware that the Content service is specifically PlayFab's CDN offering, for which standard CDN rates apply.
     * @param request GetContentDownloadUrlRequest
     * @return Async Task will return GetContentDownloadUrlResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetContentDownloadUrlResult>> GetContentDownloadUrlAsync(final GetContentDownloadUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContentDownloadUrlResult>>() {
            public PlayFabResult<GetContentDownloadUrlResult> call() throws Exception {
                return privateGetContentDownloadUrlAsync(request);
            }
        });
    }

    /**
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent HTTP GET to the returned
     * URL will attempt to download the content. A HEAD query to the returned URL will attempt to retrieve the metadata of the
     * content. Note that a successful result does not guarantee the existence of this content - if it has not been uploaded,
     * the query to retrieve the data will fail. See this post for more information:
     * https://community.playfab.com/hc/community/posts/205469488-How-to-upload-files-to-PlayFab-s-Content-Service. Also,
     * please be aware that the Content service is specifically PlayFab's CDN offering, for which standard CDN rates apply.
     * @param request GetContentDownloadUrlRequest
     * @return GetContentDownloadUrlResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetContentDownloadUrlResult> GetContentDownloadUrl(final GetContentDownloadUrlRequest request) {
        FutureTask<PlayFabResult<GetContentDownloadUrlResult>> task = new FutureTask(new Callable<PlayFabResult<GetContentDownloadUrlResult>>() {
            public PlayFabResult<GetContentDownloadUrlResult> call() throws Exception {
                return privateGetContentDownloadUrlAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetContentDownloadUrlResult> exceptionResult = new PlayFabResult<GetContentDownloadUrlResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent HTTP GET to the returned
     * URL will attempt to download the content. A HEAD query to the returned URL will attempt to retrieve the metadata of the
     * content. Note that a successful result does not guarantee the existence of this content - if it has not been uploaded,
     * the query to retrieve the data will fail. See this post for more information:
     * https://community.playfab.com/hc/community/posts/205469488-How-to-upload-files-to-PlayFab-s-Content-Service. Also,
     * please be aware that the Content service is specifically PlayFab's CDN offering, for which standard CDN rates apply.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetContentDownloadUrlResult> privateGetContentDownloadUrlAsync(final GetContentDownloadUrlRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetContentDownloadUrl"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves a list of ranked friends of the current player for the given statistic, starting from the indicated point in
     * the leaderboard
     * @param request GetFriendLeaderboardRequest
     * @return Async Task will return GetLeaderboardResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLeaderboardResult>> GetFriendLeaderboardAsync(final GetFriendLeaderboardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetFriendLeaderboardAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked friends of the current player for the given statistic, starting from the indicated point in
     * the leaderboard
     * @param request GetFriendLeaderboardRequest
     * @return GetLeaderboardResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLeaderboardResult> GetFriendLeaderboard(final GetFriendLeaderboardRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetFriendLeaderboardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetLeaderboardResult> exceptionResult = new PlayFabResult<GetLeaderboardResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves a list of ranked friends of the current player for the given statistic, starting from the indicated point in
     * the leaderboard
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardResult> privateGetFriendLeaderboardAsync(final GetFriendLeaderboardRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetFriendLeaderboard"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves a list of ranked friends of the current player for the given statistic, centered on the requested PlayFab
     * user. If PlayFabId is empty or null will return currently logged in user.
     * @param request GetFriendLeaderboardAroundPlayerRequest
     * @return Async Task will return GetFriendLeaderboardAroundPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetFriendLeaderboardAroundPlayerResult>> GetFriendLeaderboardAroundPlayerAsync(final GetFriendLeaderboardAroundPlayerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetFriendLeaderboardAroundPlayerResult>>() {
            public PlayFabResult<GetFriendLeaderboardAroundPlayerResult> call() throws Exception {
                return privateGetFriendLeaderboardAroundPlayerAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked friends of the current player for the given statistic, centered on the requested PlayFab
     * user. If PlayFabId is empty or null will return currently logged in user.
     * @param request GetFriendLeaderboardAroundPlayerRequest
     * @return GetFriendLeaderboardAroundPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetFriendLeaderboardAroundPlayerResult> GetFriendLeaderboardAroundPlayer(final GetFriendLeaderboardAroundPlayerRequest request) {
        FutureTask<PlayFabResult<GetFriendLeaderboardAroundPlayerResult>> task = new FutureTask(new Callable<PlayFabResult<GetFriendLeaderboardAroundPlayerResult>>() {
            public PlayFabResult<GetFriendLeaderboardAroundPlayerResult> call() throws Exception {
                return privateGetFriendLeaderboardAroundPlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetFriendLeaderboardAroundPlayerResult> exceptionResult = new PlayFabResult<GetFriendLeaderboardAroundPlayerResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves a list of ranked friends of the current player for the given statistic, centered on the requested PlayFab
     * user. If PlayFabId is empty or null will return currently logged in user.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetFriendLeaderboardAroundPlayerResult> privateGetFriendLeaderboardAroundPlayerAsync(final GetFriendLeaderboardAroundPlayerRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetFriendLeaderboardAroundPlayer"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetFriendLeaderboardAroundPlayerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetFriendLeaderboardAroundPlayerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetFriendLeaderboardAroundPlayerResult>>(){}.getType());
        GetFriendLeaderboardAroundPlayerResult result = resultData.data;

        PlayFabResult<GetFriendLeaderboardAroundPlayerResult> pfResult = new PlayFabResult<GetFriendLeaderboardAroundPlayerResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the current friend list for the local user, constrained to users who have PlayFab accounts. Friends from
     * linked accounts (Facebook, Steam) are also included. You may optionally exclude some linked services' friends.
     * @param request GetFriendsListRequest
     * @return Async Task will return GetFriendsListResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetFriendsListResult>> GetFriendsListAsync(final GetFriendsListRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetFriendsListResult>>() {
            public PlayFabResult<GetFriendsListResult> call() throws Exception {
                return privateGetFriendsListAsync(request);
            }
        });
    }

    /**
     * Retrieves the current friend list for the local user, constrained to users who have PlayFab accounts. Friends from
     * linked accounts (Facebook, Steam) are also included. You may optionally exclude some linked services' friends.
     * @param request GetFriendsListRequest
     * @return GetFriendsListResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetFriendsListResult> GetFriendsList(final GetFriendsListRequest request) {
        FutureTask<PlayFabResult<GetFriendsListResult>> task = new FutureTask(new Callable<PlayFabResult<GetFriendsListResult>>() {
            public PlayFabResult<GetFriendsListResult> call() throws Exception {
                return privateGetFriendsListAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetFriendsListResult> exceptionResult = new PlayFabResult<GetFriendsListResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the current friend list for the local user, constrained to users who have PlayFab accounts. Friends from
     * linked accounts (Facebook, Steam) are also included. You may optionally exclude some linked services' friends.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetFriendsListResult> privateGetFriendsListAsync(final GetFriendsListRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetFriendsList"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetFriendsListResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetFriendsListResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetFriendsListResult>>(){}.getType());
        GetFriendsListResult result = resultData.data;

        PlayFabResult<GetFriendsListResult> pfResult = new PlayFabResult<GetFriendsListResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard
     * @param request GetLeaderboardRequest
     * @return Async Task will return GetLeaderboardResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLeaderboardResult>> GetLeaderboardAsync(final GetLeaderboardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetLeaderboardAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard
     * @param request GetLeaderboardRequest
     * @return GetLeaderboardResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLeaderboardResult> GetLeaderboard(final GetLeaderboardRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetLeaderboardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetLeaderboardResult> exceptionResult = new PlayFabResult<GetLeaderboardResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardResult> privateGetLeaderboardAsync(final GetLeaderboardRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetLeaderboard"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves a list of ranked characters for the given statistic, centered on the requested Character ID
     * @param request GetLeaderboardAroundCharacterRequest
     * @return Async Task will return GetLeaderboardAroundCharacterResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLeaderboardAroundCharacterResult>> GetLeaderboardAroundCharacterAsync(final GetLeaderboardAroundCharacterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundCharacterResult>>() {
            public PlayFabResult<GetLeaderboardAroundCharacterResult> call() throws Exception {
                return privateGetLeaderboardAroundCharacterAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked characters for the given statistic, centered on the requested Character ID
     * @param request GetLeaderboardAroundCharacterRequest
     * @return GetLeaderboardAroundCharacterResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLeaderboardAroundCharacterResult> GetLeaderboardAroundCharacter(final GetLeaderboardAroundCharacterRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardAroundCharacterResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundCharacterResult>>() {
            public PlayFabResult<GetLeaderboardAroundCharacterResult> call() throws Exception {
                return privateGetLeaderboardAroundCharacterAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetLeaderboardAroundCharacterResult> exceptionResult = new PlayFabResult<GetLeaderboardAroundCharacterResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves a list of ranked characters for the given statistic, centered on the requested Character ID */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardAroundCharacterResult> privateGetLeaderboardAroundCharacterAsync(final GetLeaderboardAroundCharacterRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetLeaderboardAroundCharacter"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves a list of ranked users for the given statistic, centered on the requested player. If PlayFabId is empty or
     * null will return currently logged in user.
     * @param request GetLeaderboardAroundPlayerRequest
     * @return Async Task will return GetLeaderboardAroundPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLeaderboardAroundPlayerResult>> GetLeaderboardAroundPlayerAsync(final GetLeaderboardAroundPlayerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundPlayerResult>>() {
            public PlayFabResult<GetLeaderboardAroundPlayerResult> call() throws Exception {
                return privateGetLeaderboardAroundPlayerAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked users for the given statistic, centered on the requested player. If PlayFabId is empty or
     * null will return currently logged in user.
     * @param request GetLeaderboardAroundPlayerRequest
     * @return GetLeaderboardAroundPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLeaderboardAroundPlayerResult> GetLeaderboardAroundPlayer(final GetLeaderboardAroundPlayerRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardAroundPlayerResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundPlayerResult>>() {
            public PlayFabResult<GetLeaderboardAroundPlayerResult> call() throws Exception {
                return privateGetLeaderboardAroundPlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetLeaderboardAroundPlayerResult> exceptionResult = new PlayFabResult<GetLeaderboardAroundPlayerResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves a list of ranked users for the given statistic, centered on the requested player. If PlayFabId is empty or
     * null will return currently logged in user.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardAroundPlayerResult> privateGetLeaderboardAroundPlayerAsync(final GetLeaderboardAroundPlayerRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetLeaderboardAroundPlayer"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardAroundPlayerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetLeaderboardAroundPlayerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardAroundPlayerResult>>(){}.getType());
        GetLeaderboardAroundPlayerResult result = resultData.data;

        PlayFabResult<GetLeaderboardAroundPlayerResult> pfResult = new PlayFabResult<GetLeaderboardAroundPlayerResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves a list of all of the user's characters for the given statistic.
     * @param request GetLeaderboardForUsersCharactersRequest
     * @return Async Task will return GetLeaderboardForUsersCharactersResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLeaderboardForUsersCharactersResult>> GetLeaderboardForUserCharactersAsync(final GetLeaderboardForUsersCharactersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardForUsersCharactersResult>>() {
            public PlayFabResult<GetLeaderboardForUsersCharactersResult> call() throws Exception {
                return privateGetLeaderboardForUserCharactersAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of all of the user's characters for the given statistic.
     * @param request GetLeaderboardForUsersCharactersRequest
     * @return GetLeaderboardForUsersCharactersResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLeaderboardForUsersCharactersResult> GetLeaderboardForUserCharacters(final GetLeaderboardForUsersCharactersRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardForUsersCharactersResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardForUsersCharactersResult>>() {
            public PlayFabResult<GetLeaderboardForUsersCharactersResult> call() throws Exception {
                return privateGetLeaderboardForUserCharactersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetLeaderboardForUsersCharactersResult> exceptionResult = new PlayFabResult<GetLeaderboardForUsersCharactersResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves a list of all of the user's characters for the given statistic. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardForUsersCharactersResult> privateGetLeaderboardForUserCharactersAsync(final GetLeaderboardForUsersCharactersRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetLeaderboardForUserCharacters"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ For payments flows where the provider requires playfab (the fulfiller) to initiate the transaction, but the
     * client completes the rest of the flow. In the Xsolla case, the token returned here will be passed to Xsolla by the
     * client to create a cart. Poll GetPurchase using the returned OrderId once you've completed the payment.
     * @param request GetPaymentTokenRequest
     * @return Async Task will return GetPaymentTokenResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPaymentTokenResult>> GetPaymentTokenAsync(final GetPaymentTokenRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPaymentTokenResult>>() {
            public PlayFabResult<GetPaymentTokenResult> call() throws Exception {
                return privateGetPaymentTokenAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ For payments flows where the provider requires playfab (the fulfiller) to initiate the transaction, but the
     * client completes the rest of the flow. In the Xsolla case, the token returned here will be passed to Xsolla by the
     * client to create a cart. Poll GetPurchase using the returned OrderId once you've completed the payment.
     * @param request GetPaymentTokenRequest
     * @return GetPaymentTokenResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPaymentTokenResult> GetPaymentToken(final GetPaymentTokenRequest request) {
        FutureTask<PlayFabResult<GetPaymentTokenResult>> task = new FutureTask(new Callable<PlayFabResult<GetPaymentTokenResult>>() {
            public PlayFabResult<GetPaymentTokenResult> call() throws Exception {
                return privateGetPaymentTokenAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPaymentTokenResult> exceptionResult = new PlayFabResult<GetPaymentTokenResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ For payments flows where the provider requires playfab (the fulfiller) to initiate the transaction, but the
     * client completes the rest of the flow. In the Xsolla case, the token returned here will be passed to Xsolla by the
     * client to create a cart. Poll GetPurchase using the returned OrderId once you've completed the payment.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPaymentTokenResult> privateGetPaymentTokenAsync(final GetPaymentTokenRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPaymentToken"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPaymentTokenResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPaymentTokenResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPaymentTokenResult>>(){}.getType());
        GetPaymentTokenResult result = resultData.data;

        PlayFabResult<GetPaymentTokenResult> pfResult = new PlayFabResult<GetPaymentTokenResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a Photon custom authentication token that can be used to securely join the player into a Photon room. See
     * https://docs.microsoft.com/gaming/playfab/features/multiplayer/photon/quickstart for more details.
     * @param request GetPhotonAuthenticationTokenRequest
     * @return Async Task will return GetPhotonAuthenticationTokenResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPhotonAuthenticationTokenResult>> GetPhotonAuthenticationTokenAsync(final GetPhotonAuthenticationTokenRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPhotonAuthenticationTokenResult>>() {
            public PlayFabResult<GetPhotonAuthenticationTokenResult> call() throws Exception {
                return privateGetPhotonAuthenticationTokenAsync(request);
            }
        });
    }

    /**
     * Gets a Photon custom authentication token that can be used to securely join the player into a Photon room. See
     * https://docs.microsoft.com/gaming/playfab/features/multiplayer/photon/quickstart for more details.
     * @param request GetPhotonAuthenticationTokenRequest
     * @return GetPhotonAuthenticationTokenResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPhotonAuthenticationTokenResult> GetPhotonAuthenticationToken(final GetPhotonAuthenticationTokenRequest request) {
        FutureTask<PlayFabResult<GetPhotonAuthenticationTokenResult>> task = new FutureTask(new Callable<PlayFabResult<GetPhotonAuthenticationTokenResult>>() {
            public PlayFabResult<GetPhotonAuthenticationTokenResult> call() throws Exception {
                return privateGetPhotonAuthenticationTokenAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPhotonAuthenticationTokenResult> exceptionResult = new PlayFabResult<GetPhotonAuthenticationTokenResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Gets a Photon custom authentication token that can be used to securely join the player into a Photon room. See
     * https://docs.microsoft.com/gaming/playfab/features/multiplayer/photon/quickstart for more details.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPhotonAuthenticationTokenResult> privateGetPhotonAuthenticationTokenAsync(final GetPhotonAuthenticationTokenRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPhotonAuthenticationToken"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPhotonAuthenticationTokenResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPhotonAuthenticationTokenResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPhotonAuthenticationTokenResult>>(){}.getType());
        GetPhotonAuthenticationTokenResult result = resultData.data;

        PlayFabResult<GetPhotonAuthenticationTokenResult> pfResult = new PlayFabResult<GetPhotonAuthenticationTokenResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves all of the user's different kinds of info.
     * @param request GetPlayerCombinedInfoRequest
     * @return Async Task will return GetPlayerCombinedInfoResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerCombinedInfoResult>> GetPlayerCombinedInfoAsync(final GetPlayerCombinedInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerCombinedInfoResult>>() {
            public PlayFabResult<GetPlayerCombinedInfoResult> call() throws Exception {
                return privateGetPlayerCombinedInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves all of the user's different kinds of info.
     * @param request GetPlayerCombinedInfoRequest
     * @return GetPlayerCombinedInfoResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerCombinedInfoResult> GetPlayerCombinedInfo(final GetPlayerCombinedInfoRequest request) {
        FutureTask<PlayFabResult<GetPlayerCombinedInfoResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerCombinedInfoResult>>() {
            public PlayFabResult<GetPlayerCombinedInfoResult> call() throws Exception {
                return privateGetPlayerCombinedInfoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerCombinedInfoResult> exceptionResult = new PlayFabResult<GetPlayerCombinedInfoResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves all of the user's different kinds of info. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerCombinedInfoResult> privateGetPlayerCombinedInfoAsync(final GetPlayerCombinedInfoRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayerCombinedInfo"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerCombinedInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerCombinedInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerCombinedInfoResult>>(){}.getType());
        GetPlayerCombinedInfoResult result = resultData.data;

        PlayFabResult<GetPlayerCombinedInfoResult> pfResult = new PlayFabResult<GetPlayerCombinedInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the player's profile
     * @param request GetPlayerProfileRequest
     * @return Async Task will return GetPlayerProfileResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerProfileResult>> GetPlayerProfileAsync(final GetPlayerProfileRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerProfileResult>>() {
            public PlayFabResult<GetPlayerProfileResult> call() throws Exception {
                return privateGetPlayerProfileAsync(request);
            }
        });
    }

    /**
     * Retrieves the player's profile
     * @param request GetPlayerProfileRequest
     * @return GetPlayerProfileResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerProfileResult> GetPlayerProfile(final GetPlayerProfileRequest request) {
        FutureTask<PlayFabResult<GetPlayerProfileResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerProfileResult>>() {
            public PlayFabResult<GetPlayerProfileResult> call() throws Exception {
                return privateGetPlayerProfileAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerProfileResult> exceptionResult = new PlayFabResult<GetPlayerProfileResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the player's profile */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerProfileResult> privateGetPlayerProfileAsync(final GetPlayerProfileRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayerProfile"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerProfileResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerProfileResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerProfileResult>>(){}.getType());
        GetPlayerProfileResult result = resultData.data;

        PlayFabResult<GetPlayerProfileResult> pfResult = new PlayFabResult<GetPlayerProfileResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * List all segments that a player currently belongs to at this moment in time.
     * @param request GetPlayerSegmentsRequest
     * @return Async Task will return GetPlayerSegmentsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerSegmentsResult>> GetPlayerSegmentsAsync(final GetPlayerSegmentsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerSegmentsResult>>() {
            public PlayFabResult<GetPlayerSegmentsResult> call() throws Exception {
                return privateGetPlayerSegmentsAsync(request);
            }
        });
    }

    /**
     * List all segments that a player currently belongs to at this moment in time.
     * @param request GetPlayerSegmentsRequest
     * @return GetPlayerSegmentsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerSegmentsResult> GetPlayerSegments(final GetPlayerSegmentsRequest request) {
        FutureTask<PlayFabResult<GetPlayerSegmentsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerSegmentsResult>>() {
            public PlayFabResult<GetPlayerSegmentsResult> call() throws Exception {
                return privateGetPlayerSegmentsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerSegmentsResult> exceptionResult = new PlayFabResult<GetPlayerSegmentsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** List all segments that a player currently belongs to at this moment in time. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerSegmentsResult> privateGetPlayerSegmentsAsync(final GetPlayerSegmentsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayerSegments"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves the indicated statistics (current version and values for all statistics, if none are specified), for the local
     * player.
     * @param request GetPlayerStatisticsRequest
     * @return Async Task will return GetPlayerStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerStatisticsResult>> GetPlayerStatisticsAsync(final GetPlayerStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticsResult>>() {
            public PlayFabResult<GetPlayerStatisticsResult> call() throws Exception {
                return privateGetPlayerStatisticsAsync(request);
            }
        });
    }

    /**
     * Retrieves the indicated statistics (current version and values for all statistics, if none are specified), for the local
     * player.
     * @param request GetPlayerStatisticsRequest
     * @return GetPlayerStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerStatisticsResult> GetPlayerStatistics(final GetPlayerStatisticsRequest request) {
        FutureTask<PlayFabResult<GetPlayerStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticsResult>>() {
            public PlayFabResult<GetPlayerStatisticsResult> call() throws Exception {
                return privateGetPlayerStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerStatisticsResult> exceptionResult = new PlayFabResult<GetPlayerStatisticsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the indicated statistics (current version and values for all statistics, if none are specified), for the local
     * player.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerStatisticsResult> privateGetPlayerStatisticsAsync(final GetPlayerStatisticsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayerStatistics"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerStatisticsResult>>(){}.getType());
        GetPlayerStatisticsResult result = resultData.data;

        PlayFabResult<GetPlayerStatisticsResult> pfResult = new PlayFabResult<GetPlayerStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the information on the available versions of the specified statistic.
     * @param request GetPlayerStatisticVersionsRequest
     * @return Async Task will return GetPlayerStatisticVersionsResult
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
     * @param request GetPlayerStatisticVersionsRequest
     * @return GetPlayerStatisticVersionsResult
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
            PlayFabResult<GetPlayerStatisticVersionsResult> exceptionResult = new PlayFabResult<GetPlayerStatisticVersionsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the information on the available versions of the specified statistic. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerStatisticVersionsResult> privateGetPlayerStatisticVersionsAsync(final GetPlayerStatisticVersionsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayerStatisticVersions"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Get all tags with a given Namespace (optional) from a player profile.
     * @param request GetPlayerTagsRequest
     * @return Async Task will return GetPlayerTagsResult
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
     * @param request GetPlayerTagsRequest
     * @return GetPlayerTagsResult
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
            PlayFabResult<GetPlayerTagsResult> exceptionResult = new PlayFabResult<GetPlayerTagsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get all tags with a given Namespace (optional) from a player profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerTagsResult> privateGetPlayerTagsAsync(final GetPlayerTagsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayerTags"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Gets all trades the player has either opened or accepted, optionally filtered by trade status.
     * @param request GetPlayerTradesRequest
     * @return Async Task will return GetPlayerTradesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerTradesResponse>> GetPlayerTradesAsync(final GetPlayerTradesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerTradesResponse>>() {
            public PlayFabResult<GetPlayerTradesResponse> call() throws Exception {
                return privateGetPlayerTradesAsync(request);
            }
        });
    }

    /**
     * Gets all trades the player has either opened or accepted, optionally filtered by trade status.
     * @param request GetPlayerTradesRequest
     * @return GetPlayerTradesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerTradesResponse> GetPlayerTrades(final GetPlayerTradesRequest request) {
        FutureTask<PlayFabResult<GetPlayerTradesResponse>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerTradesResponse>>() {
            public PlayFabResult<GetPlayerTradesResponse> call() throws Exception {
                return privateGetPlayerTradesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerTradesResponse> exceptionResult = new PlayFabResult<GetPlayerTradesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets all trades the player has either opened or accepted, optionally filtered by trade status. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerTradesResponse> privateGetPlayerTradesAsync(final GetPlayerTradesRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayerTrades"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerTradesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerTradesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerTradesResponse>>(){}.getType());
        GetPlayerTradesResponse result = resultData.data;

        PlayFabResult<GetPlayerTradesResponse> pfResult = new PlayFabResult<GetPlayerTradesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers.
     * @param request GetPlayFabIDsFromFacebookIDsRequest
     * @return Async Task will return GetPlayFabIDsFromFacebookIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>> GetPlayFabIDsFromFacebookIDsAsync(final GetPlayFabIDsFromFacebookIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromFacebookIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers.
     * @param request GetPlayFabIDsFromFacebookIDsRequest
     * @return GetPlayFabIDsFromFacebookIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> GetPlayFabIDsFromFacebookIDs(final GetPlayFabIDsFromFacebookIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromFacebookIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> privateGetPlayFabIDsFromFacebookIDsAsync(final GetPlayFabIDsFromFacebookIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromFacebookIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves the unique PlayFab identifiers for the given set of Facebook Instant Game identifiers.
     * @param request GetPlayFabIDsFromFacebookInstantGamesIdsRequest
     * @return Async Task will return GetPlayFabIDsFromFacebookInstantGamesIdsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult>> GetPlayFabIDsFromFacebookInstantGamesIdsAsync(final GetPlayFabIDsFromFacebookInstantGamesIdsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult> call() throws Exception {
                return privateGetPlayFabIDsFromFacebookInstantGamesIdsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Facebook Instant Game identifiers.
     * @param request GetPlayFabIDsFromFacebookInstantGamesIdsRequest
     * @return GetPlayFabIDsFromFacebookInstantGamesIdsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult> GetPlayFabIDsFromFacebookInstantGamesIds(final GetPlayFabIDsFromFacebookInstantGamesIdsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult> call() throws Exception {
                return privateGetPlayFabIDsFromFacebookInstantGamesIdsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of Facebook Instant Game identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult> privateGetPlayFabIDsFromFacebookInstantGamesIdsAsync(final GetPlayFabIDsFromFacebookInstantGamesIdsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromFacebookInstantGamesIds"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromFacebookInstantGamesIdsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromFacebookInstantGamesIdsResult>>(){}.getType());
        GetPlayFabIDsFromFacebookInstantGamesIdsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Game Center identifiers (referenced in the Game Center
     * Programming Guide as the Player Identifier).
     * @param request GetPlayFabIDsFromGameCenterIDsRequest
     * @return Async Task will return GetPlayFabIDsFromGameCenterIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>> GetPlayFabIDsFromGameCenterIDsAsync(final GetPlayFabIDsFromGameCenterIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGameCenterIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Game Center identifiers (referenced in the Game Center
     * Programming Guide as the Player Identifier).
     * @param request GetPlayFabIDsFromGameCenterIDsRequest
     * @return GetPlayFabIDsFromGameCenterIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> GetPlayFabIDsFromGameCenterIDs(final GetPlayFabIDsFromGameCenterIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGameCenterIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Game Center identifiers (referenced in the Game Center
     * Programming Guide as the Player Identifier).
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> privateGetPlayFabIDsFromGameCenterIDsAsync(final GetPlayFabIDsFromGameCenterIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromGameCenterIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromGameCenterIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromGameCenterIDsResult>>(){}.getType());
        GetPlayFabIDsFromGameCenterIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of generic service identifiers. A generic identifier is the
     * service name plus the service-specific ID for the player, as specified by the title when the generic identifier was
     * added to the player account.
     * @param request GetPlayFabIDsFromGenericIDsRequest
     * @return Async Task will return GetPlayFabIDsFromGenericIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromGenericIDsResult>> GetPlayFabIDsFromGenericIDsAsync(final GetPlayFabIDsFromGenericIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGenericIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGenericIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGenericIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of generic service identifiers. A generic identifier is the
     * service name plus the service-specific ID for the player, as specified by the title when the generic identifier was
     * added to the player account.
     * @param request GetPlayFabIDsFromGenericIDsRequest
     * @return GetPlayFabIDsFromGenericIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromGenericIDsResult> GetPlayFabIDsFromGenericIDs(final GetPlayFabIDsFromGenericIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromGenericIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGenericIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGenericIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGenericIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromGenericIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromGenericIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of generic service identifiers. A generic identifier is the
     * service name plus the service-specific ID for the player, as specified by the title when the generic identifier was
     * added to the player account.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromGenericIDsResult> privateGetPlayFabIDsFromGenericIDsAsync(final GetPlayFabIDsFromGenericIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromGenericIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromGenericIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromGenericIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromGenericIDsResult>>(){}.getType());
        GetPlayFabIDsFromGenericIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromGenericIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromGenericIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Google identifiers. The Google identifiers are the IDs for
     * the user accounts, available as "id" in the Google+ People API calls.
     * @param request GetPlayFabIDsFromGoogleIDsRequest
     * @return Async Task will return GetPlayFabIDsFromGoogleIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>> GetPlayFabIDsFromGoogleIDsAsync(final GetPlayFabIDsFromGoogleIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGoogleIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Google identifiers. The Google identifiers are the IDs for
     * the user accounts, available as "id" in the Google+ People API calls.
     * @param request GetPlayFabIDsFromGoogleIDsRequest
     * @return GetPlayFabIDsFromGoogleIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> GetPlayFabIDsFromGoogleIDs(final GetPlayFabIDsFromGoogleIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGoogleIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Google identifiers. The Google identifiers are the IDs for
     * the user accounts, available as "id" in the Google+ People API calls.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> privateGetPlayFabIDsFromGoogleIDsAsync(final GetPlayFabIDsFromGoogleIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromGoogleIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromGoogleIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromGoogleIDsResult>>(){}.getType());
        GetPlayFabIDsFromGoogleIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Google Play Games identifiers. The Google Play Games
     * identifiers are the IDs for the user accounts, available as "playerId" in the Google Play Games Services - Players API
     * calls.
     * @param request GetPlayFabIDsFromGooglePlayGamesPlayerIDsRequest
     * @return Async Task will return GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult>> GetPlayFabIDsFromGooglePlayGamesPlayerIDsAsync(final GetPlayFabIDsFromGooglePlayGamesPlayerIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGooglePlayGamesPlayerIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Google Play Games identifiers. The Google Play Games
     * identifiers are the IDs for the user accounts, available as "playerId" in the Google Play Games Services - Players API
     * calls.
     * @param request GetPlayFabIDsFromGooglePlayGamesPlayerIDsRequest
     * @return GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult> GetPlayFabIDsFromGooglePlayGamesPlayerIDs(final GetPlayFabIDsFromGooglePlayGamesPlayerIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGooglePlayGamesPlayerIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Google Play Games identifiers. The Google Play Games
     * identifiers are the IDs for the user accounts, available as "playerId" in the Google Play Games Services - Players API
     * calls.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult> privateGetPlayFabIDsFromGooglePlayGamesPlayerIDsAsync(final GetPlayFabIDsFromGooglePlayGamesPlayerIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromGooglePlayGamesPlayerIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult>>(){}.getType());
        GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Kongregate identifiers. The Kongregate identifiers are the
     * IDs for the user accounts, available as "user_id" from the Kongregate API methods(ex:
     * http://developers.kongregate.com/docs/client/getUserId).
     * @param request GetPlayFabIDsFromKongregateIDsRequest
     * @return Async Task will return GetPlayFabIDsFromKongregateIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromKongregateIDsResult>> GetPlayFabIDsFromKongregateIDsAsync(final GetPlayFabIDsFromKongregateIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromKongregateIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromKongregateIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromKongregateIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Kongregate identifiers. The Kongregate identifiers are the
     * IDs for the user accounts, available as "user_id" from the Kongregate API methods(ex:
     * http://developers.kongregate.com/docs/client/getUserId).
     * @param request GetPlayFabIDsFromKongregateIDsRequest
     * @return GetPlayFabIDsFromKongregateIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromKongregateIDsResult> GetPlayFabIDsFromKongregateIDs(final GetPlayFabIDsFromKongregateIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromKongregateIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromKongregateIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromKongregateIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromKongregateIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromKongregateIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromKongregateIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Kongregate identifiers. The Kongregate identifiers are the
     * IDs for the user accounts, available as "user_id" from the Kongregate API methods(ex:
     * http://developers.kongregate.com/docs/client/getUserId).
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromKongregateIDsResult> privateGetPlayFabIDsFromKongregateIDsAsync(final GetPlayFabIDsFromKongregateIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromKongregateIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromKongregateIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromKongregateIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromKongregateIDsResult>>(){}.getType());
        GetPlayFabIDsFromKongregateIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromKongregateIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromKongregateIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Nintendo Service Account identifiers.
     * @param request GetPlayFabIDsFromNintendoServiceAccountIdsRequest
     * @return Async Task will return GetPlayFabIDsFromNintendoServiceAccountIdsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult>> GetPlayFabIDsFromNintendoServiceAccountIdsAsync(final GetPlayFabIDsFromNintendoServiceAccountIdsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult> call() throws Exception {
                return privateGetPlayFabIDsFromNintendoServiceAccountIdsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Nintendo Service Account identifiers.
     * @param request GetPlayFabIDsFromNintendoServiceAccountIdsRequest
     * @return GetPlayFabIDsFromNintendoServiceAccountIdsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult> GetPlayFabIDsFromNintendoServiceAccountIds(final GetPlayFabIDsFromNintendoServiceAccountIdsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult> call() throws Exception {
                return privateGetPlayFabIDsFromNintendoServiceAccountIdsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of Nintendo Service Account identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult> privateGetPlayFabIDsFromNintendoServiceAccountIdsAsync(final GetPlayFabIDsFromNintendoServiceAccountIdsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromNintendoServiceAccountIds"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromNintendoServiceAccountIdsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromNintendoServiceAccountIdsResult>>(){}.getType());
        GetPlayFabIDsFromNintendoServiceAccountIdsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromNintendoServiceAccountIdsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Nintendo Switch Device identifiers.
     * @param request GetPlayFabIDsFromNintendoSwitchDeviceIdsRequest
     * @return Async Task will return GetPlayFabIDsFromNintendoSwitchDeviceIdsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult>> GetPlayFabIDsFromNintendoSwitchDeviceIdsAsync(final GetPlayFabIDsFromNintendoSwitchDeviceIdsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult> call() throws Exception {
                return privateGetPlayFabIDsFromNintendoSwitchDeviceIdsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Nintendo Switch Device identifiers.
     * @param request GetPlayFabIDsFromNintendoSwitchDeviceIdsRequest
     * @return GetPlayFabIDsFromNintendoSwitchDeviceIdsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult> GetPlayFabIDsFromNintendoSwitchDeviceIds(final GetPlayFabIDsFromNintendoSwitchDeviceIdsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult> call() throws Exception {
                return privateGetPlayFabIDsFromNintendoSwitchDeviceIdsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of Nintendo Switch Device identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult> privateGetPlayFabIDsFromNintendoSwitchDeviceIdsAsync(final GetPlayFabIDsFromNintendoSwitchDeviceIdsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromNintendoSwitchDeviceIds"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult>>(){}.getType());
        GetPlayFabIDsFromNintendoSwitchDeviceIdsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of PlayStation :tm: Network identifiers.
     * @param request GetPlayFabIDsFromPSNAccountIDsRequest
     * @return Async Task will return GetPlayFabIDsFromPSNAccountIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult>> GetPlayFabIDsFromPSNAccountIDsAsync(final GetPlayFabIDsFromPSNAccountIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromPSNAccountIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of PlayStation :tm: Network identifiers.
     * @param request GetPlayFabIDsFromPSNAccountIDsRequest
     * @return GetPlayFabIDsFromPSNAccountIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult> GetPlayFabIDsFromPSNAccountIDs(final GetPlayFabIDsFromPSNAccountIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromPSNAccountIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of PlayStation :tm: Network identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult> privateGetPlayFabIDsFromPSNAccountIDsAsync(final GetPlayFabIDsFromPSNAccountIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromPSNAccountIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromPSNAccountIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromPSNAccountIDsResult>>(){}.getType());
        GetPlayFabIDsFromPSNAccountIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromPSNAccountIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of PlayStation :tm: Network identifiers.
     * @param request GetPlayFabIDsFromPSNOnlineIDsRequest
     * @return Async Task will return GetPlayFabIDsFromPSNOnlineIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult>> GetPlayFabIDsFromPSNOnlineIDsAsync(final GetPlayFabIDsFromPSNOnlineIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromPSNOnlineIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of PlayStation :tm: Network identifiers.
     * @param request GetPlayFabIDsFromPSNOnlineIDsRequest
     * @return GetPlayFabIDsFromPSNOnlineIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult> GetPlayFabIDsFromPSNOnlineIDs(final GetPlayFabIDsFromPSNOnlineIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromPSNOnlineIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of PlayStation :tm: Network identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult> privateGetPlayFabIDsFromPSNOnlineIDsAsync(final GetPlayFabIDsFromPSNOnlineIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromPSNOnlineIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromPSNOnlineIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromPSNOnlineIDsResult>>(){}.getType());
        GetPlayFabIDsFromPSNOnlineIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromPSNOnlineIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Steam identifiers. The Steam identifiers are the profile
     * IDs for the user accounts, available as SteamId in the Steamworks Community API calls.
     * @param request GetPlayFabIDsFromSteamIDsRequest
     * @return Async Task will return GetPlayFabIDsFromSteamIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromSteamIDsResult>> GetPlayFabIDsFromSteamIDsAsync(final GetPlayFabIDsFromSteamIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromSteamIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromSteamIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromSteamIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Steam identifiers. The Steam identifiers are the profile
     * IDs for the user accounts, available as SteamId in the Steamworks Community API calls.
     * @param request GetPlayFabIDsFromSteamIDsRequest
     * @return GetPlayFabIDsFromSteamIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromSteamIDsResult> GetPlayFabIDsFromSteamIDs(final GetPlayFabIDsFromSteamIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromSteamIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromSteamIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromSteamIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromSteamIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromSteamIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromSteamIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Steam identifiers. The Steam identifiers are the profile
     * IDs for the user accounts, available as SteamId in the Steamworks Community API calls.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromSteamIDsResult> privateGetPlayFabIDsFromSteamIDsAsync(final GetPlayFabIDsFromSteamIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromSteamIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromSteamIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromSteamIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromSteamIDsResult>>(){}.getType());
        GetPlayFabIDsFromSteamIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromSteamIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromSteamIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Twitch identifiers. The Twitch identifiers are the IDs for
     * the user accounts, available as "_id" from the Twitch API methods (ex:
     * https://github.com/justintv/Twitch-API/blob/master/v3_resources/users.md#get-usersuser).
     * @param request GetPlayFabIDsFromTwitchIDsRequest
     * @return Async Task will return GetPlayFabIDsFromTwitchIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromTwitchIDsResult>> GetPlayFabIDsFromTwitchIDsAsync(final GetPlayFabIDsFromTwitchIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromTwitchIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromTwitchIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromTwitchIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Twitch identifiers. The Twitch identifiers are the IDs for
     * the user accounts, available as "_id" from the Twitch API methods (ex:
     * https://github.com/justintv/Twitch-API/blob/master/v3_resources/users.md#get-usersuser).
     * @param request GetPlayFabIDsFromTwitchIDsRequest
     * @return GetPlayFabIDsFromTwitchIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromTwitchIDsResult> GetPlayFabIDsFromTwitchIDs(final GetPlayFabIDsFromTwitchIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromTwitchIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromTwitchIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromTwitchIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromTwitchIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromTwitchIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromTwitchIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Twitch identifiers. The Twitch identifiers are the IDs for
     * the user accounts, available as "_id" from the Twitch API methods (ex:
     * https://github.com/justintv/Twitch-API/blob/master/v3_resources/users.md#get-usersuser).
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromTwitchIDsResult> privateGetPlayFabIDsFromTwitchIDsAsync(final GetPlayFabIDsFromTwitchIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromTwitchIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromTwitchIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromTwitchIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromTwitchIDsResult>>(){}.getType());
        GetPlayFabIDsFromTwitchIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromTwitchIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromTwitchIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of XboxLive identifiers.
     * @param request GetPlayFabIDsFromXboxLiveIDsRequest
     * @return Async Task will return GetPlayFabIDsFromXboxLiveIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult>> GetPlayFabIDsFromXboxLiveIDsAsync(final GetPlayFabIDsFromXboxLiveIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromXboxLiveIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of XboxLive identifiers.
     * @param request GetPlayFabIDsFromXboxLiveIDsRequest
     * @return GetPlayFabIDsFromXboxLiveIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult> GetPlayFabIDsFromXboxLiveIDs(final GetPlayFabIDsFromXboxLiveIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromXboxLiveIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult> exceptionResult = new PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of XboxLive identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult> privateGetPlayFabIDsFromXboxLiveIDsAsync(final GetPlayFabIDsFromXboxLiveIDsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPlayFabIDsFromXboxLiveIDs"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayFabIDsFromXboxLiveIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromXboxLiveIDsResult>>(){}.getType());
        GetPlayFabIDsFromXboxLiveIDsResult result = resultData.data;

        PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromXboxLiveIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the key-value store of custom publisher settings
     * @param request GetPublisherDataRequest
     * @return Async Task will return GetPublisherDataResult
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
     * @param request GetPublisherDataRequest
     * @return GetPublisherDataResult
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
            PlayFabResult<GetPublisherDataResult> exceptionResult = new PlayFabResult<GetPublisherDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the key-value store of custom publisher settings */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPublisherDataResult> privateGetPublisherDataAsync(final GetPublisherDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPublisherData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves a purchase along with its current PlayFab status. Returns inventory items from the purchase that
     * are still active.
     * @param request GetPurchaseRequest
     * @return Async Task will return GetPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPurchaseResult>> GetPurchaseAsync(final GetPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPurchaseResult>>() {
            public PlayFabResult<GetPurchaseResult> call() throws Exception {
                return privateGetPurchaseAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves a purchase along with its current PlayFab status. Returns inventory items from the purchase that
     * are still active.
     * @param request GetPurchaseRequest
     * @return GetPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPurchaseResult> GetPurchase(final GetPurchaseRequest request) {
        FutureTask<PlayFabResult<GetPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<GetPurchaseResult>>() {
            public PlayFabResult<GetPurchaseResult> call() throws Exception {
                return privateGetPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPurchaseResult> exceptionResult = new PlayFabResult<GetPurchaseResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves a purchase along with its current PlayFab status. Returns inventory items from the purchase that
     * are still active.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPurchaseResult> privateGetPurchaseAsync(final GetPurchaseRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetPurchase"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPurchaseResult>>(){}.getType());
        GetPurchaseResult result = resultData.data;

        PlayFabResult<GetPurchaseResult> pfResult = new PlayFabResult<GetPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. Non-members of the group
     * may use this to retrieve group data, including membership, but they will not receive data for keys marked as private.
     * Shared Groups are designed for sharing data between a very small number of players, please see our guide:
     * https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request GetSharedGroupDataRequest
     * @return Async Task will return GetSharedGroupDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetSharedGroupDataResult>> GetSharedGroupDataAsync(final GetSharedGroupDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetSharedGroupDataResult>>() {
            public PlayFabResult<GetSharedGroupDataResult> call() throws Exception {
                return privateGetSharedGroupDataAsync(request);
            }
        });
    }

    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. Non-members of the group
     * may use this to retrieve group data, including membership, but they will not receive data for keys marked as private.
     * Shared Groups are designed for sharing data between a very small number of players, please see our guide:
     * https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request GetSharedGroupDataRequest
     * @return GetSharedGroupDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetSharedGroupDataResult> GetSharedGroupData(final GetSharedGroupDataRequest request) {
        FutureTask<PlayFabResult<GetSharedGroupDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetSharedGroupDataResult>>() {
            public PlayFabResult<GetSharedGroupDataResult> call() throws Exception {
                return privateGetSharedGroupDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetSharedGroupDataResult> exceptionResult = new PlayFabResult<GetSharedGroupDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. Non-members of the group
     * may use this to retrieve group data, including membership, but they will not receive data for keys marked as private.
     * Shared Groups are designed for sharing data between a very small number of players, please see our guide:
     * https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetSharedGroupDataResult> privateGetSharedGroupDataAsync(final GetSharedGroupDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetSharedGroupData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the set of items defined for the specified store, including all prices defined
     * @param request GetStoreItemsRequest
     * @return Async Task will return GetStoreItemsResult
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the set of items defined for the specified store, including all prices defined
     * @param request GetStoreItemsRequest
     * @return GetStoreItemsResult
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
            PlayFabResult<GetStoreItemsResult> exceptionResult = new PlayFabResult<GetStoreItemsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the set of items defined for the specified store, including all prices defined
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetStoreItemsResult> privateGetStoreItemsAsync(final GetStoreItemsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetStoreItems"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves the current server time
     * @param request GetTimeRequest
     * @return Async Task will return GetTimeResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTimeResult>> GetTimeAsync(final GetTimeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTimeResult>>() {
            public PlayFabResult<GetTimeResult> call() throws Exception {
                return privateGetTimeAsync(request);
            }
        });
    }

    /**
     * Retrieves the current server time
     * @param request GetTimeRequest
     * @return GetTimeResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTimeResult> GetTime(final GetTimeRequest request) {
        FutureTask<PlayFabResult<GetTimeResult>> task = new FutureTask(new Callable<PlayFabResult<GetTimeResult>>() {
            public PlayFabResult<GetTimeResult> call() throws Exception {
                return privateGetTimeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTimeResult> exceptionResult = new PlayFabResult<GetTimeResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the current server time */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTimeResult> privateGetTimeAsync(final GetTimeRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetTime"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTimeResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTimeResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTimeResult>>(){}.getType());
        GetTimeResult result = resultData.data;

        PlayFabResult<GetTimeResult> pfResult = new PlayFabResult<GetTimeResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the key-value store of custom title settings
     * @param request GetTitleDataRequest
     * @return Async Task will return GetTitleDataResult
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
     * Retrieves the key-value store of custom title settings
     * @param request GetTitleDataRequest
     * @return GetTitleDataResult
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
            PlayFabResult<GetTitleDataResult> exceptionResult = new PlayFabResult<GetTitleDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the key-value store of custom title settings */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleDataResult> privateGetTitleDataAsync(final GetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetTitleData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request GetTitleNewsRequest
     * @return Async Task will return GetTitleNewsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitleNewsResult>> GetTitleNewsAsync(final GetTitleNewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleNewsResult>>() {
            public PlayFabResult<GetTitleNewsResult> call() throws Exception {
                return privateGetTitleNewsAsync(request);
            }
        });
    }

    /**
     * Retrieves the title news feed, as configured in the developer portal
     * @param request GetTitleNewsRequest
     * @return GetTitleNewsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitleNewsResult> GetTitleNews(final GetTitleNewsRequest request) {
        FutureTask<PlayFabResult<GetTitleNewsResult>> task = new FutureTask(new Callable<PlayFabResult<GetTitleNewsResult>>() {
            public PlayFabResult<GetTitleNewsResult> call() throws Exception {
                return privateGetTitleNewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTitleNewsResult> exceptionResult = new PlayFabResult<GetTitleNewsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the title news feed, as configured in the developer portal */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleNewsResult> privateGetTitleNewsAsync(final GetTitleNewsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetTitleNews"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Returns the title's base 64 encoded RSA CSP blob.
     * @param request GetTitlePublicKeyRequest
     * @return Async Task will return GetTitlePublicKeyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitlePublicKeyResult>> GetTitlePublicKeyAsync(final GetTitlePublicKeyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitlePublicKeyResult>>() {
            public PlayFabResult<GetTitlePublicKeyResult> call() throws Exception {
                return privateGetTitlePublicKeyAsync(request);
            }
        });
    }

    /**
     * Returns the title's base 64 encoded RSA CSP blob.
     * @param request GetTitlePublicKeyRequest
     * @return GetTitlePublicKeyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitlePublicKeyResult> GetTitlePublicKey(final GetTitlePublicKeyRequest request) {
        FutureTask<PlayFabResult<GetTitlePublicKeyResult>> task = new FutureTask(new Callable<PlayFabResult<GetTitlePublicKeyResult>>() {
            public PlayFabResult<GetTitlePublicKeyResult> call() throws Exception {
                return privateGetTitlePublicKeyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTitlePublicKeyResult> exceptionResult = new PlayFabResult<GetTitlePublicKeyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Returns the title's base 64 encoded RSA CSP blob. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitlePublicKeyResult> privateGetTitlePublicKeyAsync(final GetTitlePublicKeyRequest request) throws Exception {

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetTitlePublicKey"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitlePublicKeyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTitlePublicKeyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitlePublicKeyResult>>(){}.getType());
        GetTitlePublicKeyResult result = resultData.data;

        PlayFabResult<GetTitlePublicKeyResult> pfResult = new PlayFabResult<GetTitlePublicKeyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the current status of an existing trade.
     * @param request GetTradeStatusRequest
     * @return Async Task will return GetTradeStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTradeStatusResponse>> GetTradeStatusAsync(final GetTradeStatusRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTradeStatusResponse>>() {
            public PlayFabResult<GetTradeStatusResponse> call() throws Exception {
                return privateGetTradeStatusAsync(request);
            }
        });
    }

    /**
     * Gets the current status of an existing trade.
     * @param request GetTradeStatusRequest
     * @return GetTradeStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTradeStatusResponse> GetTradeStatus(final GetTradeStatusRequest request) {
        FutureTask<PlayFabResult<GetTradeStatusResponse>> task = new FutureTask(new Callable<PlayFabResult<GetTradeStatusResponse>>() {
            public PlayFabResult<GetTradeStatusResponse> call() throws Exception {
                return privateGetTradeStatusAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTradeStatusResponse> exceptionResult = new PlayFabResult<GetTradeStatusResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the current status of an existing trade. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTradeStatusResponse> privateGetTradeStatusAsync(final GetTradeStatusRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetTradeStatus"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTradeStatusResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTradeStatusResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTradeStatusResponse>>(){}.getType());
        GetTradeStatusResponse result = resultData.data;

        PlayFabResult<GetTradeStatusResponse> pfResult = new PlayFabResult<GetTradeStatusResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
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
     * @param request GetUserDataRequest
     * @return GetUserDataResult
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
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the title-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetUserData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the user's current inventory of virtual goods
     * @param request GetUserInventoryRequest
     * @return Async Task will return GetUserInventoryResult
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the user's current inventory of virtual goods
     * @param request GetUserInventoryRequest
     * @return GetUserInventoryResult
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
            PlayFabResult<GetUserInventoryResult> exceptionResult = new PlayFabResult<GetUserInventoryResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Retrieves the user's current inventory of virtual goods
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserInventoryResult> privateGetUserInventoryAsync(final GetUserInventoryRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetUserInventory"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
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
     * @param request GetUserDataRequest
     * @return GetUserDataResult
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
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the publisher-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetUserPublisherData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
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
     * @param request GetUserDataRequest
     * @return GetUserDataResult
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
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the publisher-specific custom data for the user which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherReadOnlyDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetUserPublisherReadOnlyData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
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
     * @param request GetUserDataRequest
     * @return GetUserDataResult
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
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the title-specific custom data for the user which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserReadOnlyDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetUserReadOnlyData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Grants the specified character type to the user. CharacterIds are not globally unique; characterId must be evaluated
     * with the parent PlayFabId to guarantee uniqueness.
     * @param request GrantCharacterToUserRequest
     * @return Async Task will return GrantCharacterToUserResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GrantCharacterToUserResult>> GrantCharacterToUserAsync(final GrantCharacterToUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantCharacterToUserResult>>() {
            public PlayFabResult<GrantCharacterToUserResult> call() throws Exception {
                return privateGrantCharacterToUserAsync(request);
            }
        });
    }

    /**
     * Grants the specified character type to the user. CharacterIds are not globally unique; characterId must be evaluated
     * with the parent PlayFabId to guarantee uniqueness.
     * @param request GrantCharacterToUserRequest
     * @return GrantCharacterToUserResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GrantCharacterToUserResult> GrantCharacterToUser(final GrantCharacterToUserRequest request) {
        FutureTask<PlayFabResult<GrantCharacterToUserResult>> task = new FutureTask(new Callable<PlayFabResult<GrantCharacterToUserResult>>() {
            public PlayFabResult<GrantCharacterToUserResult> call() throws Exception {
                return privateGrantCharacterToUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GrantCharacterToUserResult> exceptionResult = new PlayFabResult<GrantCharacterToUserResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Grants the specified character type to the user. CharacterIds are not globally unique; characterId must be evaluated
     * with the parent PlayFabId to guarantee uniqueness.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GrantCharacterToUserResult> privateGrantCharacterToUserAsync(final GrantCharacterToUserRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GrantCharacterToUser"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Links the Android device identifier to the user's PlayFab account
     * @param request LinkAndroidDeviceIDRequest
     * @return Async Task will return LinkAndroidDeviceIDResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkAndroidDeviceIDResult>> LinkAndroidDeviceIDAsync(final LinkAndroidDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkAndroidDeviceIDResult>>() {
            public PlayFabResult<LinkAndroidDeviceIDResult> call() throws Exception {
                return privateLinkAndroidDeviceIDAsync(request);
            }
        });
    }

    /**
     * Links the Android device identifier to the user's PlayFab account
     * @param request LinkAndroidDeviceIDRequest
     * @return LinkAndroidDeviceIDResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkAndroidDeviceIDResult> LinkAndroidDeviceID(final LinkAndroidDeviceIDRequest request) {
        FutureTask<PlayFabResult<LinkAndroidDeviceIDResult>> task = new FutureTask(new Callable<PlayFabResult<LinkAndroidDeviceIDResult>>() {
            public PlayFabResult<LinkAndroidDeviceIDResult> call() throws Exception {
                return privateLinkAndroidDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkAndroidDeviceIDResult> exceptionResult = new PlayFabResult<LinkAndroidDeviceIDResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the Android device identifier to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkAndroidDeviceIDResult> privateLinkAndroidDeviceIDAsync(final LinkAndroidDeviceIDRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkAndroidDeviceID"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkAndroidDeviceIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkAndroidDeviceIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkAndroidDeviceIDResult>>(){}.getType());
        LinkAndroidDeviceIDResult result = resultData.data;

        PlayFabResult<LinkAndroidDeviceIDResult> pfResult = new PlayFabResult<LinkAndroidDeviceIDResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the Apple account associated with the token to the user's PlayFab account.
     * @param request LinkAppleRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> LinkAppleAsync(final LinkAppleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateLinkAppleAsync(request);
            }
        });
    }

    /**
     * Links the Apple account associated with the token to the user's PlayFab account.
     * @param request LinkAppleRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> LinkApple(final LinkAppleRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateLinkAppleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the Apple account associated with the token to the user's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateLinkAppleAsync(final LinkAppleRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkApple"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Links the custom identifier, generated by the title, to the user's PlayFab account
     * @param request LinkCustomIDRequest
     * @return Async Task will return LinkCustomIDResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkCustomIDResult>> LinkCustomIDAsync(final LinkCustomIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkCustomIDResult>>() {
            public PlayFabResult<LinkCustomIDResult> call() throws Exception {
                return privateLinkCustomIDAsync(request);
            }
        });
    }

    /**
     * Links the custom identifier, generated by the title, to the user's PlayFab account
     * @param request LinkCustomIDRequest
     * @return LinkCustomIDResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkCustomIDResult> LinkCustomID(final LinkCustomIDRequest request) {
        FutureTask<PlayFabResult<LinkCustomIDResult>> task = new FutureTask(new Callable<PlayFabResult<LinkCustomIDResult>>() {
            public PlayFabResult<LinkCustomIDResult> call() throws Exception {
                return privateLinkCustomIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkCustomIDResult> exceptionResult = new PlayFabResult<LinkCustomIDResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the custom identifier, generated by the title, to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkCustomIDResult> privateLinkCustomIDAsync(final LinkCustomIDRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkCustomID"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkCustomIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkCustomIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkCustomIDResult>>(){}.getType());
        LinkCustomIDResult result = resultData.data;

        PlayFabResult<LinkCustomIDResult> pfResult = new PlayFabResult<LinkCustomIDResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the Facebook account associated with the provided Facebook access token to the user's PlayFab account
     * @param request LinkFacebookAccountRequest
     * @return Async Task will return LinkFacebookAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkFacebookAccountResult>> LinkFacebookAccountAsync(final LinkFacebookAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkFacebookAccountResult>>() {
            public PlayFabResult<LinkFacebookAccountResult> call() throws Exception {
                return privateLinkFacebookAccountAsync(request);
            }
        });
    }

    /**
     * Links the Facebook account associated with the provided Facebook access token to the user's PlayFab account
     * @param request LinkFacebookAccountRequest
     * @return LinkFacebookAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkFacebookAccountResult> LinkFacebookAccount(final LinkFacebookAccountRequest request) {
        FutureTask<PlayFabResult<LinkFacebookAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkFacebookAccountResult>>() {
            public PlayFabResult<LinkFacebookAccountResult> call() throws Exception {
                return privateLinkFacebookAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkFacebookAccountResult> exceptionResult = new PlayFabResult<LinkFacebookAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the Facebook account associated with the provided Facebook access token to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkFacebookAccountResult> privateLinkFacebookAccountAsync(final LinkFacebookAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkFacebookAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkFacebookAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkFacebookAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkFacebookAccountResult>>(){}.getType());
        LinkFacebookAccountResult result = resultData.data;

        PlayFabResult<LinkFacebookAccountResult> pfResult = new PlayFabResult<LinkFacebookAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the Facebook Instant Games Id to the user's PlayFab account
     * @param request LinkFacebookInstantGamesIdRequest
     * @return Async Task will return LinkFacebookInstantGamesIdResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkFacebookInstantGamesIdResult>> LinkFacebookInstantGamesIdAsync(final LinkFacebookInstantGamesIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkFacebookInstantGamesIdResult>>() {
            public PlayFabResult<LinkFacebookInstantGamesIdResult> call() throws Exception {
                return privateLinkFacebookInstantGamesIdAsync(request);
            }
        });
    }

    /**
     * Links the Facebook Instant Games Id to the user's PlayFab account
     * @param request LinkFacebookInstantGamesIdRequest
     * @return LinkFacebookInstantGamesIdResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkFacebookInstantGamesIdResult> LinkFacebookInstantGamesId(final LinkFacebookInstantGamesIdRequest request) {
        FutureTask<PlayFabResult<LinkFacebookInstantGamesIdResult>> task = new FutureTask(new Callable<PlayFabResult<LinkFacebookInstantGamesIdResult>>() {
            public PlayFabResult<LinkFacebookInstantGamesIdResult> call() throws Exception {
                return privateLinkFacebookInstantGamesIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkFacebookInstantGamesIdResult> exceptionResult = new PlayFabResult<LinkFacebookInstantGamesIdResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the Facebook Instant Games Id to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkFacebookInstantGamesIdResult> privateLinkFacebookInstantGamesIdAsync(final LinkFacebookInstantGamesIdRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkFacebookInstantGamesId"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkFacebookInstantGamesIdResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkFacebookInstantGamesIdResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkFacebookInstantGamesIdResult>>(){}.getType());
        LinkFacebookInstantGamesIdResult result = resultData.data;

        PlayFabResult<LinkFacebookInstantGamesIdResult> pfResult = new PlayFabResult<LinkFacebookInstantGamesIdResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account. Logging in with
     * a Game Center ID is insecure if you do not include the optional PublicKeyUrl, Salt, Signature, and Timestamp parameters
     * in this request. It is recommended you require these parameters on all Game Center calls by going to the Apple Add-ons
     * page in the PlayFab Game Manager and enabling the 'Require secure authentication only for this app' option.
     * @param request LinkGameCenterAccountRequest
     * @return Async Task will return LinkGameCenterAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkGameCenterAccountResult>> LinkGameCenterAccountAsync(final LinkGameCenterAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkGameCenterAccountResult>>() {
            public PlayFabResult<LinkGameCenterAccountResult> call() throws Exception {
                return privateLinkGameCenterAccountAsync(request);
            }
        });
    }

    /**
     * Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account. Logging in with
     * a Game Center ID is insecure if you do not include the optional PublicKeyUrl, Salt, Signature, and Timestamp parameters
     * in this request. It is recommended you require these parameters on all Game Center calls by going to the Apple Add-ons
     * page in the PlayFab Game Manager and enabling the 'Require secure authentication only for this app' option.
     * @param request LinkGameCenterAccountRequest
     * @return LinkGameCenterAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkGameCenterAccountResult> LinkGameCenterAccount(final LinkGameCenterAccountRequest request) {
        FutureTask<PlayFabResult<LinkGameCenterAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkGameCenterAccountResult>>() {
            public PlayFabResult<LinkGameCenterAccountResult> call() throws Exception {
                return privateLinkGameCenterAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkGameCenterAccountResult> exceptionResult = new PlayFabResult<LinkGameCenterAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account. Logging in with
     * a Game Center ID is insecure if you do not include the optional PublicKeyUrl, Salt, Signature, and Timestamp parameters
     * in this request. It is recommended you require these parameters on all Game Center calls by going to the Apple Add-ons
     * page in the PlayFab Game Manager and enabling the 'Require secure authentication only for this app' option.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkGameCenterAccountResult> privateLinkGameCenterAccountAsync(final LinkGameCenterAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkGameCenterAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkGameCenterAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkGameCenterAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkGameCenterAccountResult>>(){}.getType());
        LinkGameCenterAccountResult result = resultData.data;

        PlayFabResult<LinkGameCenterAccountResult> pfResult = new PlayFabResult<LinkGameCenterAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the currently signed-in user account to their Google account, using their Google account credentials
     * @param request LinkGoogleAccountRequest
     * @return Async Task will return LinkGoogleAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkGoogleAccountResult>> LinkGoogleAccountAsync(final LinkGoogleAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkGoogleAccountResult>>() {
            public PlayFabResult<LinkGoogleAccountResult> call() throws Exception {
                return privateLinkGoogleAccountAsync(request);
            }
        });
    }

    /**
     * Links the currently signed-in user account to their Google account, using their Google account credentials
     * @param request LinkGoogleAccountRequest
     * @return LinkGoogleAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkGoogleAccountResult> LinkGoogleAccount(final LinkGoogleAccountRequest request) {
        FutureTask<PlayFabResult<LinkGoogleAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkGoogleAccountResult>>() {
            public PlayFabResult<LinkGoogleAccountResult> call() throws Exception {
                return privateLinkGoogleAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkGoogleAccountResult> exceptionResult = new PlayFabResult<LinkGoogleAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the currently signed-in user account to their Google account, using their Google account credentials */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkGoogleAccountResult> privateLinkGoogleAccountAsync(final LinkGoogleAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkGoogleAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkGoogleAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkGoogleAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkGoogleAccountResult>>(){}.getType());
        LinkGoogleAccountResult result = resultData.data;

        PlayFabResult<LinkGoogleAccountResult> pfResult = new PlayFabResult<LinkGoogleAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the currently signed-in user account to their Google Play Games account, using their Google Play Games account
     * credentials
     * @param request LinkGooglePlayGamesServicesAccountRequest
     * @return Async Task will return LinkGooglePlayGamesServicesAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkGooglePlayGamesServicesAccountResult>> LinkGooglePlayGamesServicesAccountAsync(final LinkGooglePlayGamesServicesAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkGooglePlayGamesServicesAccountResult>>() {
            public PlayFabResult<LinkGooglePlayGamesServicesAccountResult> call() throws Exception {
                return privateLinkGooglePlayGamesServicesAccountAsync(request);
            }
        });
    }

    /**
     * Links the currently signed-in user account to their Google Play Games account, using their Google Play Games account
     * credentials
     * @param request LinkGooglePlayGamesServicesAccountRequest
     * @return LinkGooglePlayGamesServicesAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkGooglePlayGamesServicesAccountResult> LinkGooglePlayGamesServicesAccount(final LinkGooglePlayGamesServicesAccountRequest request) {
        FutureTask<PlayFabResult<LinkGooglePlayGamesServicesAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkGooglePlayGamesServicesAccountResult>>() {
            public PlayFabResult<LinkGooglePlayGamesServicesAccountResult> call() throws Exception {
                return privateLinkGooglePlayGamesServicesAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkGooglePlayGamesServicesAccountResult> exceptionResult = new PlayFabResult<LinkGooglePlayGamesServicesAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Links the currently signed-in user account to their Google Play Games account, using their Google Play Games account
     * credentials
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkGooglePlayGamesServicesAccountResult> privateLinkGooglePlayGamesServicesAccountAsync(final LinkGooglePlayGamesServicesAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkGooglePlayGamesServicesAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkGooglePlayGamesServicesAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkGooglePlayGamesServicesAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkGooglePlayGamesServicesAccountResult>>(){}.getType());
        LinkGooglePlayGamesServicesAccountResult result = resultData.data;

        PlayFabResult<LinkGooglePlayGamesServicesAccountResult> pfResult = new PlayFabResult<LinkGooglePlayGamesServicesAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the vendor-specific iOS device identifier to the user's PlayFab account
     * @param request LinkIOSDeviceIDRequest
     * @return Async Task will return LinkIOSDeviceIDResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkIOSDeviceIDResult>> LinkIOSDeviceIDAsync(final LinkIOSDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkIOSDeviceIDResult>>() {
            public PlayFabResult<LinkIOSDeviceIDResult> call() throws Exception {
                return privateLinkIOSDeviceIDAsync(request);
            }
        });
    }

    /**
     * Links the vendor-specific iOS device identifier to the user's PlayFab account
     * @param request LinkIOSDeviceIDRequest
     * @return LinkIOSDeviceIDResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkIOSDeviceIDResult> LinkIOSDeviceID(final LinkIOSDeviceIDRequest request) {
        FutureTask<PlayFabResult<LinkIOSDeviceIDResult>> task = new FutureTask(new Callable<PlayFabResult<LinkIOSDeviceIDResult>>() {
            public PlayFabResult<LinkIOSDeviceIDResult> call() throws Exception {
                return privateLinkIOSDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkIOSDeviceIDResult> exceptionResult = new PlayFabResult<LinkIOSDeviceIDResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the vendor-specific iOS device identifier to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkIOSDeviceIDResult> privateLinkIOSDeviceIDAsync(final LinkIOSDeviceIDRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkIOSDeviceID"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkIOSDeviceIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkIOSDeviceIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkIOSDeviceIDResult>>(){}.getType());
        LinkIOSDeviceIDResult result = resultData.data;

        PlayFabResult<LinkIOSDeviceIDResult> pfResult = new PlayFabResult<LinkIOSDeviceIDResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the Kongregate identifier to the user's PlayFab account
     * @param request LinkKongregateAccountRequest
     * @return Async Task will return LinkKongregateAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkKongregateAccountResult>> LinkKongregateAsync(final LinkKongregateAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkKongregateAccountResult>>() {
            public PlayFabResult<LinkKongregateAccountResult> call() throws Exception {
                return privateLinkKongregateAsync(request);
            }
        });
    }

    /**
     * Links the Kongregate identifier to the user's PlayFab account
     * @param request LinkKongregateAccountRequest
     * @return LinkKongregateAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkKongregateAccountResult> LinkKongregate(final LinkKongregateAccountRequest request) {
        FutureTask<PlayFabResult<LinkKongregateAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkKongregateAccountResult>>() {
            public PlayFabResult<LinkKongregateAccountResult> call() throws Exception {
                return privateLinkKongregateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkKongregateAccountResult> exceptionResult = new PlayFabResult<LinkKongregateAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the Kongregate identifier to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkKongregateAccountResult> privateLinkKongregateAsync(final LinkKongregateAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkKongregate"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkKongregateAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkKongregateAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkKongregateAccountResult>>(){}.getType());
        LinkKongregateAccountResult result = resultData.data;

        PlayFabResult<LinkKongregateAccountResult> pfResult = new PlayFabResult<LinkKongregateAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the Nintendo account associated with the token to the user's PlayFab account.
     * @param request LinkNintendoServiceAccountRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> LinkNintendoServiceAccountAsync(final LinkNintendoServiceAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateLinkNintendoServiceAccountAsync(request);
            }
        });
    }

    /**
     * Links the Nintendo account associated with the token to the user's PlayFab account.
     * @param request LinkNintendoServiceAccountRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> LinkNintendoServiceAccount(final LinkNintendoServiceAccountRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateLinkNintendoServiceAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the Nintendo account associated with the token to the user's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateLinkNintendoServiceAccountAsync(final LinkNintendoServiceAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkNintendoServiceAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Links the NintendoSwitchDeviceId to the user's PlayFab account
     * @param request LinkNintendoSwitchDeviceIdRequest
     * @return Async Task will return LinkNintendoSwitchDeviceIdResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkNintendoSwitchDeviceIdResult>> LinkNintendoSwitchDeviceIdAsync(final LinkNintendoSwitchDeviceIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkNintendoSwitchDeviceIdResult>>() {
            public PlayFabResult<LinkNintendoSwitchDeviceIdResult> call() throws Exception {
                return privateLinkNintendoSwitchDeviceIdAsync(request);
            }
        });
    }

    /**
     * Links the NintendoSwitchDeviceId to the user's PlayFab account
     * @param request LinkNintendoSwitchDeviceIdRequest
     * @return LinkNintendoSwitchDeviceIdResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkNintendoSwitchDeviceIdResult> LinkNintendoSwitchDeviceId(final LinkNintendoSwitchDeviceIdRequest request) {
        FutureTask<PlayFabResult<LinkNintendoSwitchDeviceIdResult>> task = new FutureTask(new Callable<PlayFabResult<LinkNintendoSwitchDeviceIdResult>>() {
            public PlayFabResult<LinkNintendoSwitchDeviceIdResult> call() throws Exception {
                return privateLinkNintendoSwitchDeviceIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkNintendoSwitchDeviceIdResult> exceptionResult = new PlayFabResult<LinkNintendoSwitchDeviceIdResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the NintendoSwitchDeviceId to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkNintendoSwitchDeviceIdResult> privateLinkNintendoSwitchDeviceIdAsync(final LinkNintendoSwitchDeviceIdRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkNintendoSwitchDeviceId"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkNintendoSwitchDeviceIdResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkNintendoSwitchDeviceIdResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkNintendoSwitchDeviceIdResult>>(){}.getType());
        LinkNintendoSwitchDeviceIdResult result = resultData.data;

        PlayFabResult<LinkNintendoSwitchDeviceIdResult> pfResult = new PlayFabResult<LinkNintendoSwitchDeviceIdResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links an OpenID Connect account to a user's PlayFab account, based on an existing relationship between a title and an
     * Open ID Connect provider and the OpenId Connect JWT from that provider.
     * @param request LinkOpenIdConnectRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> LinkOpenIdConnectAsync(final LinkOpenIdConnectRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateLinkOpenIdConnectAsync(request);
            }
        });
    }

    /**
     * Links an OpenID Connect account to a user's PlayFab account, based on an existing relationship between a title and an
     * Open ID Connect provider and the OpenId Connect JWT from that provider.
     * @param request LinkOpenIdConnectRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> LinkOpenIdConnect(final LinkOpenIdConnectRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateLinkOpenIdConnectAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Links an OpenID Connect account to a user's PlayFab account, based on an existing relationship between a title and an
     * Open ID Connect provider and the OpenId Connect JWT from that provider.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateLinkOpenIdConnectAsync(final LinkOpenIdConnectRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkOpenIdConnect"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Links the PlayStation :tm: Network account associated with the provided access code to the user's PlayFab account
     * @param request LinkPSNAccountRequest
     * @return Async Task will return LinkPSNAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkPSNAccountResult>> LinkPSNAccountAsync(final LinkPSNAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkPSNAccountResult>>() {
            public PlayFabResult<LinkPSNAccountResult> call() throws Exception {
                return privateLinkPSNAccountAsync(request);
            }
        });
    }

    /**
     * Links the PlayStation :tm: Network account associated with the provided access code to the user's PlayFab account
     * @param request LinkPSNAccountRequest
     * @return LinkPSNAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkPSNAccountResult> LinkPSNAccount(final LinkPSNAccountRequest request) {
        FutureTask<PlayFabResult<LinkPSNAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkPSNAccountResult>>() {
            public PlayFabResult<LinkPSNAccountResult> call() throws Exception {
                return privateLinkPSNAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkPSNAccountResult> exceptionResult = new PlayFabResult<LinkPSNAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the PlayStation :tm: Network account associated with the provided access code to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkPSNAccountResult> privateLinkPSNAccountAsync(final LinkPSNAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkPSNAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkPSNAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkPSNAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkPSNAccountResult>>(){}.getType());
        LinkPSNAccountResult result = resultData.data;

        PlayFabResult<LinkPSNAccountResult> pfResult = new PlayFabResult<LinkPSNAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the Steam account associated with the provided Steam authentication ticket to the user's PlayFab account
     * @param request LinkSteamAccountRequest
     * @return Async Task will return LinkSteamAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkSteamAccountResult>> LinkSteamAccountAsync(final LinkSteamAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkSteamAccountResult>>() {
            public PlayFabResult<LinkSteamAccountResult> call() throws Exception {
                return privateLinkSteamAccountAsync(request);
            }
        });
    }

    /**
     * Links the Steam account associated with the provided Steam authentication ticket to the user's PlayFab account
     * @param request LinkSteamAccountRequest
     * @return LinkSteamAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkSteamAccountResult> LinkSteamAccount(final LinkSteamAccountRequest request) {
        FutureTask<PlayFabResult<LinkSteamAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkSteamAccountResult>>() {
            public PlayFabResult<LinkSteamAccountResult> call() throws Exception {
                return privateLinkSteamAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkSteamAccountResult> exceptionResult = new PlayFabResult<LinkSteamAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the Steam account associated with the provided Steam authentication ticket to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkSteamAccountResult> privateLinkSteamAccountAsync(final LinkSteamAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkSteamAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkSteamAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkSteamAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkSteamAccountResult>>(){}.getType());
        LinkSteamAccountResult result = resultData.data;

        PlayFabResult<LinkSteamAccountResult> pfResult = new PlayFabResult<LinkSteamAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the Twitch account associated with the token to the user's PlayFab account.
     * @param request LinkTwitchAccountRequest
     * @return Async Task will return LinkTwitchAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkTwitchAccountResult>> LinkTwitchAsync(final LinkTwitchAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkTwitchAccountResult>>() {
            public PlayFabResult<LinkTwitchAccountResult> call() throws Exception {
                return privateLinkTwitchAsync(request);
            }
        });
    }

    /**
     * Links the Twitch account associated with the token to the user's PlayFab account.
     * @param request LinkTwitchAccountRequest
     * @return LinkTwitchAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkTwitchAccountResult> LinkTwitch(final LinkTwitchAccountRequest request) {
        FutureTask<PlayFabResult<LinkTwitchAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkTwitchAccountResult>>() {
            public PlayFabResult<LinkTwitchAccountResult> call() throws Exception {
                return privateLinkTwitchAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkTwitchAccountResult> exceptionResult = new PlayFabResult<LinkTwitchAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the Twitch account associated with the token to the user's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkTwitchAccountResult> privateLinkTwitchAsync(final LinkTwitchAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkTwitch"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkTwitchAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkTwitchAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkTwitchAccountResult>>(){}.getType());
        LinkTwitchAccountResult result = resultData.data;

        PlayFabResult<LinkTwitchAccountResult> pfResult = new PlayFabResult<LinkTwitchAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Links the Xbox Live account associated with the provided access code to the user's PlayFab account
     * @param request LinkXboxAccountRequest
     * @return Async Task will return LinkXboxAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkXboxAccountResult>> LinkXboxAccountAsync(final LinkXboxAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkXboxAccountResult>>() {
            public PlayFabResult<LinkXboxAccountResult> call() throws Exception {
                return privateLinkXboxAccountAsync(request);
            }
        });
    }

    /**
     * Links the Xbox Live account associated with the provided access code to the user's PlayFab account
     * @param request LinkXboxAccountRequest
     * @return LinkXboxAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkXboxAccountResult> LinkXboxAccount(final LinkXboxAccountRequest request) {
        FutureTask<PlayFabResult<LinkXboxAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkXboxAccountResult>>() {
            public PlayFabResult<LinkXboxAccountResult> call() throws Exception {
                return privateLinkXboxAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LinkXboxAccountResult> exceptionResult = new PlayFabResult<LinkXboxAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Links the Xbox Live account associated with the provided access code to the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkXboxAccountResult> privateLinkXboxAccountAsync(final LinkXboxAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkXboxAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkXboxAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkXboxAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkXboxAccountResult>>(){}.getType());
        LinkXboxAccountResult result = resultData.data;

        PlayFabResult<LinkXboxAccountResult> pfResult = new PlayFabResult<LinkXboxAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using the Android device identifier, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user
     * @param request LoginWithAndroidDeviceIDRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithAndroidDeviceIDAsync(final LoginWithAndroidDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithAndroidDeviceIDAsync(request);
            }
        });
    }

    /**
     * Signs the user in using the Android device identifier, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user
     * @param request LoginWithAndroidDeviceIDRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithAndroidDeviceID(final LoginWithAndroidDeviceIDRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithAndroidDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using the Android device identifier, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithAndroidDeviceIDAsync(final LoginWithAndroidDeviceIDRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithAndroidDeviceID"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs in the user with a Sign in with Apple identity token.
     * @param request LoginWithAppleRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithAppleAsync(final LoginWithAppleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithAppleAsync(request);
            }
        });
    }

    /**
     * Signs in the user with a Sign in with Apple identity token.
     * @param request LoginWithAppleRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithApple(final LoginWithAppleRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithAppleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Signs in the user with a Sign in with Apple identity token. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithAppleAsync(final LoginWithAppleRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithApple"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a custom unique identifier generated by the title, returning a session identifier that can
     * subsequently be used for API calls which require an authenticated user
     * @param request LoginWithCustomIDRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithCustomIDAsync(final LoginWithCustomIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithCustomIDAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a custom unique identifier generated by the title, returning a session identifier that can
     * subsequently be used for API calls which require an authenticated user
     * @param request LoginWithCustomIDRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithCustomID(final LoginWithCustomIDRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithCustomIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using a custom unique identifier generated by the title, returning a session identifier that can
     * subsequently be used for API calls which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithCustomIDAsync(final LoginWithCustomIDRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithCustomID"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls
     * which require an authenticated user. Unlike most other login API calls, LoginWithEmailAddress does not permit the
     * creation of new accounts via the CreateAccountFlag. Email addresses may be used to create accounts via
     * RegisterPlayFabUser.
     * @param request LoginWithEmailAddressRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithEmailAddressAsync(final LoginWithEmailAddressRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithEmailAddressAsync(request);
            }
        });
    }

    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls
     * which require an authenticated user. Unlike most other login API calls, LoginWithEmailAddress does not permit the
     * creation of new accounts via the CreateAccountFlag. Email addresses may be used to create accounts via
     * RegisterPlayFabUser.
     * @param request LoginWithEmailAddressRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithEmailAddress(final LoginWithEmailAddressRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithEmailAddressAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls
     * which require an authenticated user. Unlike most other login API calls, LoginWithEmailAddress does not permit the
     * creation of new accounts via the CreateAccountFlag. Email addresses may be used to create accounts via
     * RegisterPlayFabUser.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithEmailAddressAsync(final LoginWithEmailAddressRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithEmailAddress"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a Facebook access token, returning a session identifier that can subsequently be used for API
     * calls which require an authenticated user
     * @param request LoginWithFacebookRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithFacebookAsync(final LoginWithFacebookRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithFacebookAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Facebook access token, returning a session identifier that can subsequently be used for API
     * calls which require an authenticated user
     * @param request LoginWithFacebookRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithFacebook(final LoginWithFacebookRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithFacebookAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using a Facebook access token, returning a session identifier that can subsequently be used for API
     * calls which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithFacebookAsync(final LoginWithFacebookRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithFacebook"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a Facebook Instant Games ID, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user. Requires Facebook Instant Games to be configured.
     * @param request LoginWithFacebookInstantGamesIdRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithFacebookInstantGamesIdAsync(final LoginWithFacebookInstantGamesIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithFacebookInstantGamesIdAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Facebook Instant Games ID, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user. Requires Facebook Instant Games to be configured.
     * @param request LoginWithFacebookInstantGamesIdRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithFacebookInstantGamesId(final LoginWithFacebookInstantGamesIdRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithFacebookInstantGamesIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using a Facebook Instant Games ID, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user. Requires Facebook Instant Games to be configured.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithFacebookInstantGamesIdAsync(final LoginWithFacebookInstantGamesIdRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithFacebookInstantGamesId"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using an iOS Game Center player identifier, returning a session identifier that can subsequently be
     * used for API calls which require an authenticated user. Logging in with a Game Center ID is insecure if you do not
     * include the optional PublicKeyUrl, Salt, Signature, and Timestamp parameters in this request. It is recommended you
     * require these parameters on all Game Center calls by going to the Apple Add-ons page in the PlayFab Game Manager and
     * enabling the 'Require secure authentication only for this app' option.
     * @param request LoginWithGameCenterRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithGameCenterAsync(final LoginWithGameCenterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithGameCenterAsync(request);
            }
        });
    }

    /**
     * Signs the user in using an iOS Game Center player identifier, returning a session identifier that can subsequently be
     * used for API calls which require an authenticated user. Logging in with a Game Center ID is insecure if you do not
     * include the optional PublicKeyUrl, Salt, Signature, and Timestamp parameters in this request. It is recommended you
     * require these parameters on all Game Center calls by going to the Apple Add-ons page in the PlayFab Game Manager and
     * enabling the 'Require secure authentication only for this app' option.
     * @param request LoginWithGameCenterRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithGameCenter(final LoginWithGameCenterRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithGameCenterAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using an iOS Game Center player identifier, returning a session identifier that can subsequently be
     * used for API calls which require an authenticated user. Logging in with a Game Center ID is insecure if you do not
     * include the optional PublicKeyUrl, Salt, Signature, and Timestamp parameters in this request. It is recommended you
     * require these parameters on all Game Center calls by going to the Apple Add-ons page in the PlayFab Game Manager and
     * enabling the 'Require secure authentication only for this app' option.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithGameCenterAsync(final LoginWithGameCenterRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithGameCenter"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using their Google account credentials
     * @param request LoginWithGoogleAccountRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithGoogleAccountAsync(final LoginWithGoogleAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithGoogleAccountAsync(request);
            }
        });
    }

    /**
     * Signs the user in using their Google account credentials
     * @param request LoginWithGoogleAccountRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithGoogleAccount(final LoginWithGoogleAccountRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithGoogleAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Signs the user in using their Google account credentials */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithGoogleAccountAsync(final LoginWithGoogleAccountRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithGoogleAccount"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using their Google Play Games account credentials
     * @param request LoginWithGooglePlayGamesServicesRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithGooglePlayGamesServicesAsync(final LoginWithGooglePlayGamesServicesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithGooglePlayGamesServicesAsync(request);
            }
        });
    }

    /**
     * Signs the user in using their Google Play Games account credentials
     * @param request LoginWithGooglePlayGamesServicesRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithGooglePlayGamesServices(final LoginWithGooglePlayGamesServicesRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithGooglePlayGamesServicesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Signs the user in using their Google Play Games account credentials */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithGooglePlayGamesServicesAsync(final LoginWithGooglePlayGamesServicesRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithGooglePlayGamesServices"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using the vendor-specific iOS device identifier, returning a session identifier that can subsequently
     * be used for API calls which require an authenticated user
     * @param request LoginWithIOSDeviceIDRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithIOSDeviceIDAsync(final LoginWithIOSDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithIOSDeviceIDAsync(request);
            }
        });
    }

    /**
     * Signs the user in using the vendor-specific iOS device identifier, returning a session identifier that can subsequently
     * be used for API calls which require an authenticated user
     * @param request LoginWithIOSDeviceIDRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithIOSDeviceID(final LoginWithIOSDeviceIDRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithIOSDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using the vendor-specific iOS device identifier, returning a session identifier that can subsequently
     * be used for API calls which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithIOSDeviceIDAsync(final LoginWithIOSDeviceIDRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithIOSDeviceID"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a Kongregate player account.
     * @param request LoginWithKongregateRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithKongregateAsync(final LoginWithKongregateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithKongregateAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Kongregate player account.
     * @param request LoginWithKongregateRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithKongregate(final LoginWithKongregateRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithKongregateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Signs the user in using a Kongregate player account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithKongregateAsync(final LoginWithKongregateRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithKongregate"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs in the user with a Nintendo service account token.
     * @param request LoginWithNintendoServiceAccountRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithNintendoServiceAccountAsync(final LoginWithNintendoServiceAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithNintendoServiceAccountAsync(request);
            }
        });
    }

    /**
     * Signs in the user with a Nintendo service account token.
     * @param request LoginWithNintendoServiceAccountRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithNintendoServiceAccount(final LoginWithNintendoServiceAccountRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithNintendoServiceAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Signs in the user with a Nintendo service account token. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithNintendoServiceAccountAsync(final LoginWithNintendoServiceAccountRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithNintendoServiceAccount"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a Nintendo Switch Device ID, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user
     * @param request LoginWithNintendoSwitchDeviceIdRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithNintendoSwitchDeviceIdAsync(final LoginWithNintendoSwitchDeviceIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithNintendoSwitchDeviceIdAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Nintendo Switch Device ID, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user
     * @param request LoginWithNintendoSwitchDeviceIdRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithNintendoSwitchDeviceId(final LoginWithNintendoSwitchDeviceIdRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithNintendoSwitchDeviceIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using a Nintendo Switch Device ID, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithNintendoSwitchDeviceIdAsync(final LoginWithNintendoSwitchDeviceIdRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithNintendoSwitchDeviceId"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Logs in a user with an Open ID Connect JWT created by an existing relationship between a title and an Open ID Connect
     * provider.
     * @param request LoginWithOpenIdConnectRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithOpenIdConnectAsync(final LoginWithOpenIdConnectRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithOpenIdConnectAsync(request);
            }
        });
    }

    /**
     * Logs in a user with an Open ID Connect JWT created by an existing relationship between a title and an Open ID Connect
     * provider.
     * @param request LoginWithOpenIdConnectRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithOpenIdConnect(final LoginWithOpenIdConnectRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithOpenIdConnectAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Logs in a user with an Open ID Connect JWT created by an existing relationship between a title and an Open ID Connect
     * provider.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithOpenIdConnectAsync(final LoginWithOpenIdConnectRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithOpenIdConnect"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls
     * which require an authenticated user. Unlike most other login API calls, LoginWithPlayFab does not permit the creation of
     * new accounts via the CreateAccountFlag. Username/Password credentials may be used to create accounts via
     * RegisterPlayFabUser, or added to existing accounts using AddUsernamePassword.
     * @param request LoginWithPlayFabRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithPlayFabAsync(final LoginWithPlayFabRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithPlayFabAsync(request);
            }
        });
    }

    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls
     * which require an authenticated user. Unlike most other login API calls, LoginWithPlayFab does not permit the creation of
     * new accounts via the CreateAccountFlag. Username/Password credentials may be used to create accounts via
     * RegisterPlayFabUser, or added to existing accounts using AddUsernamePassword.
     * @param request LoginWithPlayFabRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithPlayFab(final LoginWithPlayFabRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithPlayFabAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls
     * which require an authenticated user. Unlike most other login API calls, LoginWithPlayFab does not permit the creation of
     * new accounts via the CreateAccountFlag. Username/Password credentials may be used to create accounts via
     * RegisterPlayFabUser, or added to existing accounts using AddUsernamePassword.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithPlayFabAsync(final LoginWithPlayFabRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithPlayFab"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a PlayStation :tm: Network authentication code, returning a session identifier that can
     * subsequently be used for API calls which require an authenticated user
     * @param request LoginWithPSNRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithPSNAsync(final LoginWithPSNRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithPSNAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a PlayStation :tm: Network authentication code, returning a session identifier that can
     * subsequently be used for API calls which require an authenticated user
     * @param request LoginWithPSNRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithPSN(final LoginWithPSNRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithPSNAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using a PlayStation :tm: Network authentication code, returning a session identifier that can
     * subsequently be used for API calls which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithPSNAsync(final LoginWithPSNRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithPSN"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a Steam authentication ticket, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user
     * @param request LoginWithSteamRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithSteamAsync(final LoginWithSteamRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithSteamAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Steam authentication ticket, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user
     * @param request LoginWithSteamRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithSteam(final LoginWithSteamRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithSteamAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using a Steam authentication ticket, returning a session identifier that can subsequently be used for
     * API calls which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithSteamAsync(final LoginWithSteamRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithSteam"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a Twitch access token.
     * @param request LoginWithTwitchRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithTwitchAsync(final LoginWithTwitchRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithTwitchAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Twitch access token.
     * @param request LoginWithTwitchRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithTwitch(final LoginWithTwitchRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithTwitchAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Signs the user in using a Twitch access token. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithTwitchAsync(final LoginWithTwitchRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithTwitch"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a Xbox Live Token, returning a session identifier that can subsequently be used for API calls
     * which require an authenticated user
     * @param request LoginWithXboxRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithXboxAsync(final LoginWithXboxRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithXboxAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Xbox Live Token, returning a session identifier that can subsequently be used for API calls
     * which require an authenticated user
     * @param request LoginWithXboxRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithXbox(final LoginWithXboxRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithXboxAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LoginResult> exceptionResult = new PlayFabResult<LoginResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Signs the user in using a Xbox Live Token, returning a session identifier that can subsequently be used for API calls
     * which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithXboxAsync(final LoginWithXboxRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithXbox"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType());
        LoginResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Opens a new outstanding trade. Note that a given item instance may only be in one open trade at a time.
     * @param request OpenTradeRequest
     * @return Async Task will return OpenTradeResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<OpenTradeResponse>> OpenTradeAsync(final OpenTradeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<OpenTradeResponse>>() {
            public PlayFabResult<OpenTradeResponse> call() throws Exception {
                return privateOpenTradeAsync(request);
            }
        });
    }

    /**
     * Opens a new outstanding trade. Note that a given item instance may only be in one open trade at a time.
     * @param request OpenTradeRequest
     * @return OpenTradeResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<OpenTradeResponse> OpenTrade(final OpenTradeRequest request) {
        FutureTask<PlayFabResult<OpenTradeResponse>> task = new FutureTask(new Callable<PlayFabResult<OpenTradeResponse>>() {
            public PlayFabResult<OpenTradeResponse> call() throws Exception {
                return privateOpenTradeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<OpenTradeResponse> exceptionResult = new PlayFabResult<OpenTradeResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Opens a new outstanding trade. Note that a given item instance may only be in one open trade at a time. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<OpenTradeResponse> privateOpenTradeAsync(final OpenTradeRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/OpenTrade"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<OpenTradeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<OpenTradeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<OpenTradeResponse>>(){}.getType());
        OpenTradeResponse result = resultData.data;

        PlayFabResult<OpenTradeResponse> pfResult = new PlayFabResult<OpenTradeResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Selects a payment option for purchase order created via StartPurchase
     * @param request PayForPurchaseRequest
     * @return Async Task will return PayForPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<PayForPurchaseResult>> PayForPurchaseAsync(final PayForPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<PayForPurchaseResult>>() {
            public PlayFabResult<PayForPurchaseResult> call() throws Exception {
                return privatePayForPurchaseAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Selects a payment option for purchase order created via StartPurchase
     * @param request PayForPurchaseRequest
     * @return PayForPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<PayForPurchaseResult> PayForPurchase(final PayForPurchaseRequest request) {
        FutureTask<PlayFabResult<PayForPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<PayForPurchaseResult>>() {
            public PlayFabResult<PayForPurchaseResult> call() throws Exception {
                return privatePayForPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<PayForPurchaseResult> exceptionResult = new PlayFabResult<PayForPurchaseResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Selects a payment option for purchase order created via StartPurchase
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<PayForPurchaseResult> privatePayForPurchaseAsync(final PayForPurchaseRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/PayForPurchase"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<PayForPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<PayForPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<PayForPurchaseResult>>(){}.getType());
        PayForPurchaseResult result = resultData.data;

        PlayFabResult<PayForPurchaseResult> pfResult = new PlayFabResult<PayForPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as
     * well as what the client believes the price to be. This lets the server fail the purchase if the price has changed.
     * @param request PurchaseItemRequest
     * @return Async Task will return PurchaseItemResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<PurchaseItemResult>> PurchaseItemAsync(final PurchaseItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<PurchaseItemResult>>() {
            public PlayFabResult<PurchaseItemResult> call() throws Exception {
                return privatePurchaseItemAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as
     * well as what the client believes the price to be. This lets the server fail the purchase if the price has changed.
     * @param request PurchaseItemRequest
     * @return PurchaseItemResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<PurchaseItemResult> PurchaseItem(final PurchaseItemRequest request) {
        FutureTask<PlayFabResult<PurchaseItemResult>> task = new FutureTask(new Callable<PlayFabResult<PurchaseItemResult>>() {
            public PlayFabResult<PurchaseItemResult> call() throws Exception {
                return privatePurchaseItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<PurchaseItemResult> exceptionResult = new PlayFabResult<PurchaseItemResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as
     * well as what the client believes the price to be. This lets the server fail the purchase if the price has changed.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<PurchaseItemResult> privatePurchaseItemAsync(final PurchaseItemRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/PurchaseItem"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<PurchaseItemResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<PurchaseItemResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<PurchaseItemResult>>(){}.getType());
        PurchaseItemResult result = resultData.data;

        PlayFabResult<PurchaseItemResult> pfResult = new PlayFabResult<PurchaseItemResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Adds the virtual goods associated with the coupon to the user's inventory. Coupons can be generated via the
     * Economy-&gt;Catalogs tab in the PlayFab Game Manager.
     * @param request RedeemCouponRequest
     * @return Async Task will return RedeemCouponResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RedeemCouponResult>> RedeemCouponAsync(final RedeemCouponRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemCouponResult>>() {
            public PlayFabResult<RedeemCouponResult> call() throws Exception {
                return privateRedeemCouponAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Adds the virtual goods associated with the coupon to the user's inventory. Coupons can be generated via the
     * Economy-&gt;Catalogs tab in the PlayFab Game Manager.
     * @param request RedeemCouponRequest
     * @return RedeemCouponResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RedeemCouponResult> RedeemCoupon(final RedeemCouponRequest request) {
        FutureTask<PlayFabResult<RedeemCouponResult>> task = new FutureTask(new Callable<PlayFabResult<RedeemCouponResult>>() {
            public PlayFabResult<RedeemCouponResult> call() throws Exception {
                return privateRedeemCouponAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RedeemCouponResult> exceptionResult = new PlayFabResult<RedeemCouponResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Adds the virtual goods associated with the coupon to the user's inventory. Coupons can be generated via the
     * Economy-&gt;Catalogs tab in the PlayFab Game Manager.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RedeemCouponResult> privateRedeemCouponAsync(final RedeemCouponRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RedeemCoupon"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RedeemCouponResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RedeemCouponResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RedeemCouponResult>>(){}.getType());
        RedeemCouponResult result = resultData.data;

        PlayFabResult<RedeemCouponResult> pfResult = new PlayFabResult<RedeemCouponResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Uses the supplied OAuth code to refresh the internally cached player PlayStation :tm: Network auth token
     * @param request RefreshPSNAuthTokenRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> RefreshPSNAuthTokenAsync(final RefreshPSNAuthTokenRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateRefreshPSNAuthTokenAsync(request);
            }
        });
    }

    /**
     * Uses the supplied OAuth code to refresh the internally cached player PlayStation :tm: Network auth token
     * @param request RefreshPSNAuthTokenRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> RefreshPSNAuthToken(final RefreshPSNAuthTokenRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateRefreshPSNAuthTokenAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Uses the supplied OAuth code to refresh the internally cached player PlayStation :tm: Network auth token */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateRefreshPSNAuthTokenAsync(final RefreshPSNAuthTokenRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RefreshPSNAuthToken"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Registers the iOS device to receive push notifications
     * @param request RegisterForIOSPushNotificationRequest
     * @return Async Task will return RegisterForIOSPushNotificationResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RegisterForIOSPushNotificationResult>> RegisterForIOSPushNotificationAsync(final RegisterForIOSPushNotificationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RegisterForIOSPushNotificationResult>>() {
            public PlayFabResult<RegisterForIOSPushNotificationResult> call() throws Exception {
                return privateRegisterForIOSPushNotificationAsync(request);
            }
        });
    }

    /**
     * Registers the iOS device to receive push notifications
     * @param request RegisterForIOSPushNotificationRequest
     * @return RegisterForIOSPushNotificationResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RegisterForIOSPushNotificationResult> RegisterForIOSPushNotification(final RegisterForIOSPushNotificationRequest request) {
        FutureTask<PlayFabResult<RegisterForIOSPushNotificationResult>> task = new FutureTask(new Callable<PlayFabResult<RegisterForIOSPushNotificationResult>>() {
            public PlayFabResult<RegisterForIOSPushNotificationResult> call() throws Exception {
                return privateRegisterForIOSPushNotificationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RegisterForIOSPushNotificationResult> exceptionResult = new PlayFabResult<RegisterForIOSPushNotificationResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Registers the iOS device to receive push notifications */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RegisterForIOSPushNotificationResult> privateRegisterForIOSPushNotificationAsync(final RegisterForIOSPushNotificationRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RegisterForIOSPushNotification"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RegisterForIOSPushNotificationResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RegisterForIOSPushNotificationResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RegisterForIOSPushNotificationResult>>(){}.getType());
        RegisterForIOSPushNotificationResult result = resultData.data;

        PlayFabResult<RegisterForIOSPushNotificationResult> pfResult = new PlayFabResult<RegisterForIOSPushNotificationResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Registers a new Playfab user account, returning a session identifier that can subsequently be used for API calls which
     * require an authenticated user. You must supply a username and an email address.
     * @param request RegisterPlayFabUserRequest
     * @return Async Task will return RegisterPlayFabUserResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RegisterPlayFabUserResult>> RegisterPlayFabUserAsync(final RegisterPlayFabUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RegisterPlayFabUserResult>>() {
            public PlayFabResult<RegisterPlayFabUserResult> call() throws Exception {
                return privateRegisterPlayFabUserAsync(request);
            }
        });
    }

    /**
     * Registers a new Playfab user account, returning a session identifier that can subsequently be used for API calls which
     * require an authenticated user. You must supply a username and an email address.
     * @param request RegisterPlayFabUserRequest
     * @return RegisterPlayFabUserResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RegisterPlayFabUserResult> RegisterPlayFabUser(final RegisterPlayFabUserRequest request) {
        FutureTask<PlayFabResult<RegisterPlayFabUserResult>> task = new FutureTask(new Callable<PlayFabResult<RegisterPlayFabUserResult>>() {
            public PlayFabResult<RegisterPlayFabUserResult> call() throws Exception {
                return privateRegisterPlayFabUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RegisterPlayFabUserResult> exceptionResult = new PlayFabResult<RegisterPlayFabUserResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Registers a new Playfab user account, returning a session identifier that can subsequently be used for API calls which
     * require an authenticated user. You must supply a username and an email address.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RegisterPlayFabUserResult> privateRegisterPlayFabUserAsync(final RegisterPlayFabUserRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RegisterPlayFabUser"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RegisterPlayFabUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RegisterPlayFabUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RegisterPlayFabUserResult>>(){}.getType());
        RegisterPlayFabUserResult result = resultData.data;
        PlayFabSettings.ClientSessionTicket = result.SessionTicket != null ? result.SessionTicket : PlayFabSettings.ClientSessionTicket;
        if (result.EntityToken != null) PlayFabSettings.EntityToken = result.EntityToken.EntityToken != null ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<RegisterPlayFabUserResult> pfResult = new PlayFabResult<RegisterPlayFabUserResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes a contact email from the player's profile.
     * @param request RemoveContactEmailRequest
     * @return Async Task will return RemoveContactEmailResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RemoveContactEmailResult>> RemoveContactEmailAsync(final RemoveContactEmailRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemoveContactEmailResult>>() {
            public PlayFabResult<RemoveContactEmailResult> call() throws Exception {
                return privateRemoveContactEmailAsync(request);
            }
        });
    }

    /**
     * Removes a contact email from the player's profile.
     * @param request RemoveContactEmailRequest
     * @return RemoveContactEmailResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RemoveContactEmailResult> RemoveContactEmail(final RemoveContactEmailRequest request) {
        FutureTask<PlayFabResult<RemoveContactEmailResult>> task = new FutureTask(new Callable<PlayFabResult<RemoveContactEmailResult>>() {
            public PlayFabResult<RemoveContactEmailResult> call() throws Exception {
                return privateRemoveContactEmailAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RemoveContactEmailResult> exceptionResult = new PlayFabResult<RemoveContactEmailResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Removes a contact email from the player's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RemoveContactEmailResult> privateRemoveContactEmailAsync(final RemoveContactEmailRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RemoveContactEmail"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RemoveContactEmailResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RemoveContactEmailResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RemoveContactEmailResult>>(){}.getType());
        RemoveContactEmailResult result = resultData.data;

        PlayFabResult<RemoveContactEmailResult> pfResult = new PlayFabResult<RemoveContactEmailResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes a specified user from the friend list of the local user
     * @param request RemoveFriendRequest
     * @return Async Task will return RemoveFriendResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RemoveFriendResult>> RemoveFriendAsync(final RemoveFriendRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemoveFriendResult>>() {
            public PlayFabResult<RemoveFriendResult> call() throws Exception {
                return privateRemoveFriendAsync(request);
            }
        });
    }

    /**
     * Removes a specified user from the friend list of the local user
     * @param request RemoveFriendRequest
     * @return RemoveFriendResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RemoveFriendResult> RemoveFriend(final RemoveFriendRequest request) {
        FutureTask<PlayFabResult<RemoveFriendResult>> task = new FutureTask(new Callable<PlayFabResult<RemoveFriendResult>>() {
            public PlayFabResult<RemoveFriendResult> call() throws Exception {
                return privateRemoveFriendAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RemoveFriendResult> exceptionResult = new PlayFabResult<RemoveFriendResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Removes a specified user from the friend list of the local user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RemoveFriendResult> privateRemoveFriendAsync(final RemoveFriendRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RemoveFriend"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RemoveFriendResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RemoveFriendResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RemoveFriendResult>>(){}.getType());
        RemoveFriendResult result = resultData.data;

        PlayFabResult<RemoveFriendResult> pfResult = new PlayFabResult<RemoveFriendResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes the specified generic service identifier from the player's PlayFab account.
     * @param request RemoveGenericIDRequest
     * @return Async Task will return RemoveGenericIDResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RemoveGenericIDResult>> RemoveGenericIDAsync(final RemoveGenericIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemoveGenericIDResult>>() {
            public PlayFabResult<RemoveGenericIDResult> call() throws Exception {
                return privateRemoveGenericIDAsync(request);
            }
        });
    }

    /**
     * Removes the specified generic service identifier from the player's PlayFab account.
     * @param request RemoveGenericIDRequest
     * @return RemoveGenericIDResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RemoveGenericIDResult> RemoveGenericID(final RemoveGenericIDRequest request) {
        FutureTask<PlayFabResult<RemoveGenericIDResult>> task = new FutureTask(new Callable<PlayFabResult<RemoveGenericIDResult>>() {
            public PlayFabResult<RemoveGenericIDResult> call() throws Exception {
                return privateRemoveGenericIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RemoveGenericIDResult> exceptionResult = new PlayFabResult<RemoveGenericIDResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Removes the specified generic service identifier from the player's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RemoveGenericIDResult> privateRemoveGenericIDAsync(final RemoveGenericIDRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RemoveGenericID"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RemoveGenericIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RemoveGenericIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RemoveGenericIDResult>>(){}.getType());
        RemoveGenericIDResult result = resultData.data;

        PlayFabResult<RemoveGenericIDResult> pfResult = new PlayFabResult<RemoveGenericIDResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the
     * group can remove members. If as a result of the call, zero users remain with access, the group and its associated data
     * will be deleted. Shared Groups are designed for sharing data between a very small number of players, please see our
     * guide: https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request RemoveSharedGroupMembersRequest
     * @return Async Task will return RemoveSharedGroupMembersResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RemoveSharedGroupMembersResult>> RemoveSharedGroupMembersAsync(final RemoveSharedGroupMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemoveSharedGroupMembersResult>>() {
            public PlayFabResult<RemoveSharedGroupMembersResult> call() throws Exception {
                return privateRemoveSharedGroupMembersAsync(request);
            }
        });
    }

    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the
     * group can remove members. If as a result of the call, zero users remain with access, the group and its associated data
     * will be deleted. Shared Groups are designed for sharing data between a very small number of players, please see our
     * guide: https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request RemoveSharedGroupMembersRequest
     * @return RemoveSharedGroupMembersResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RemoveSharedGroupMembersResult> RemoveSharedGroupMembers(final RemoveSharedGroupMembersRequest request) {
        FutureTask<PlayFabResult<RemoveSharedGroupMembersResult>> task = new FutureTask(new Callable<PlayFabResult<RemoveSharedGroupMembersResult>>() {
            public PlayFabResult<RemoveSharedGroupMembersResult> call() throws Exception {
                return privateRemoveSharedGroupMembersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RemoveSharedGroupMembersResult> exceptionResult = new PlayFabResult<RemoveSharedGroupMembersResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the
     * group can remove members. If as a result of the call, zero users remain with access, the group and its associated data
     * will be deleted. Shared Groups are designed for sharing data between a very small number of players, please see our
     * guide: https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RemoveSharedGroupMembersResult> privateRemoveSharedGroupMembersAsync(final RemoveSharedGroupMembersRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RemoveSharedGroupMembers"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Report player's ad activity
     * @param request ReportAdActivityRequest
     * @return Async Task will return ReportAdActivityResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ReportAdActivityResult>> ReportAdActivityAsync(final ReportAdActivityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReportAdActivityResult>>() {
            public PlayFabResult<ReportAdActivityResult> call() throws Exception {
                return privateReportAdActivityAsync(request);
            }
        });
    }

    /**
     * Report player's ad activity
     * @param request ReportAdActivityRequest
     * @return ReportAdActivityResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ReportAdActivityResult> ReportAdActivity(final ReportAdActivityRequest request) {
        FutureTask<PlayFabResult<ReportAdActivityResult>> task = new FutureTask(new Callable<PlayFabResult<ReportAdActivityResult>>() {
            public PlayFabResult<ReportAdActivityResult> call() throws Exception {
                return privateReportAdActivityAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ReportAdActivityResult> exceptionResult = new PlayFabResult<ReportAdActivityResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Report player's ad activity */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ReportAdActivityResult> privateReportAdActivityAsync(final ReportAdActivityRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ReportAdActivity"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReportAdActivityResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ReportAdActivityResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReportAdActivityResult>>(){}.getType());
        ReportAdActivityResult result = resultData.data;

        PlayFabResult<ReportAdActivityResult> pfResult = new PlayFabResult<ReportAdActivityResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Write a PlayStream event to describe the provided player device information. This API method is not designed to be
     * called directly by developers. Each PlayFab client SDK will eventually report this information automatically.
     * @param request DeviceInfoRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> ReportDeviceInfoAsync(final DeviceInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateReportDeviceInfoAsync(request);
            }
        });
    }

    /**
     * Write a PlayStream event to describe the provided player device information. This API method is not designed to be
     * called directly by developers. Each PlayFab client SDK will eventually report this information automatically.
     * @param request DeviceInfoRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> ReportDeviceInfo(final DeviceInfoRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateReportDeviceInfoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Write a PlayStream event to describe the provided player device information. This API method is not designed to be
     * called directly by developers. Each PlayFab client SDK will eventually report this information automatically.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateReportDeviceInfoAsync(final DeviceInfoRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ReportDeviceInfo"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Submit a report for another player (due to bad bahavior, etc.), so that customer service representatives for the title
     * can take action concerning potentially toxic players.
     * @param request ReportPlayerClientRequest
     * @return Async Task will return ReportPlayerClientResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ReportPlayerClientResult>> ReportPlayerAsync(final ReportPlayerClientRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReportPlayerClientResult>>() {
            public PlayFabResult<ReportPlayerClientResult> call() throws Exception {
                return privateReportPlayerAsync(request);
            }
        });
    }

    /**
     * Submit a report for another player (due to bad bahavior, etc.), so that customer service representatives for the title
     * can take action concerning potentially toxic players.
     * @param request ReportPlayerClientRequest
     * @return ReportPlayerClientResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ReportPlayerClientResult> ReportPlayer(final ReportPlayerClientRequest request) {
        FutureTask<PlayFabResult<ReportPlayerClientResult>> task = new FutureTask(new Callable<PlayFabResult<ReportPlayerClientResult>>() {
            public PlayFabResult<ReportPlayerClientResult> call() throws Exception {
                return privateReportPlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ReportPlayerClientResult> exceptionResult = new PlayFabResult<ReportPlayerClientResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Submit a report for another player (due to bad bahavior, etc.), so that customer service representatives for the title
     * can take action concerning potentially toxic players.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ReportPlayerClientResult> privateReportPlayerAsync(final ReportPlayerClientRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ReportPlayer"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReportPlayerClientResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ReportPlayerClientResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReportPlayerClientResult>>(){}.getType());
        ReportPlayerClientResult result = resultData.data;

        PlayFabResult<ReportPlayerClientResult> pfResult = new PlayFabResult<ReportPlayerClientResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Restores all in-app purchases based on the given restore receipt
     * @param request RestoreIOSPurchasesRequest
     * @return Async Task will return RestoreIOSPurchasesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RestoreIOSPurchasesResult>> RestoreIOSPurchasesAsync(final RestoreIOSPurchasesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RestoreIOSPurchasesResult>>() {
            public PlayFabResult<RestoreIOSPurchasesResult> call() throws Exception {
                return privateRestoreIOSPurchasesAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Restores all in-app purchases based on the given restore receipt
     * @param request RestoreIOSPurchasesRequest
     * @return RestoreIOSPurchasesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RestoreIOSPurchasesResult> RestoreIOSPurchases(final RestoreIOSPurchasesRequest request) {
        FutureTask<PlayFabResult<RestoreIOSPurchasesResult>> task = new FutureTask(new Callable<PlayFabResult<RestoreIOSPurchasesResult>>() {
            public PlayFabResult<RestoreIOSPurchasesResult> call() throws Exception {
                return privateRestoreIOSPurchasesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RestoreIOSPurchasesResult> exceptionResult = new PlayFabResult<RestoreIOSPurchasesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Restores all in-app purchases based on the given restore receipt
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RestoreIOSPurchasesResult> privateRestoreIOSPurchasesAsync(final RestoreIOSPurchasesRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RestoreIOSPurchases"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RestoreIOSPurchasesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RestoreIOSPurchasesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RestoreIOSPurchasesResult>>(){}.getType());
        RestoreIOSPurchasesResult result = resultData.data;

        PlayFabResult<RestoreIOSPurchasesResult> pfResult = new PlayFabResult<RestoreIOSPurchasesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Reward player's ad activity
     * @param request RewardAdActivityRequest
     * @return Async Task will return RewardAdActivityResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RewardAdActivityResult>> RewardAdActivityAsync(final RewardAdActivityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RewardAdActivityResult>>() {
            public PlayFabResult<RewardAdActivityResult> call() throws Exception {
                return privateRewardAdActivityAsync(request);
            }
        });
    }

    /**
     * Reward player's ad activity
     * @param request RewardAdActivityRequest
     * @return RewardAdActivityResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RewardAdActivityResult> RewardAdActivity(final RewardAdActivityRequest request) {
        FutureTask<PlayFabResult<RewardAdActivityResult>> task = new FutureTask(new Callable<PlayFabResult<RewardAdActivityResult>>() {
            public PlayFabResult<RewardAdActivityResult> call() throws Exception {
                return privateRewardAdActivityAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RewardAdActivityResult> exceptionResult = new PlayFabResult<RewardAdActivityResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Reward player's ad activity */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RewardAdActivityResult> privateRewardAdActivityAsync(final RewardAdActivityRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RewardAdActivity"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RewardAdActivityResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RewardAdActivityResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RewardAdActivityResult>>(){}.getType());
        RewardAdActivityResult result = resultData.data;

        PlayFabResult<RewardAdActivityResult> pfResult = new PlayFabResult<RewardAdActivityResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to
     * change the password.If an account recovery email template ID is provided, an email using the custom email template will
     * be used.
     * @param request SendAccountRecoveryEmailRequest
     * @return Async Task will return SendAccountRecoveryEmailResult
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
     * Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to
     * change the password.If an account recovery email template ID is provided, an email using the custom email template will
     * be used.
     * @param request SendAccountRecoveryEmailRequest
     * @return SendAccountRecoveryEmailResult
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
            PlayFabResult<SendAccountRecoveryEmailResult> exceptionResult = new PlayFabResult<SendAccountRecoveryEmailResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to
     * change the password.If an account recovery email template ID is provided, an email using the custom email template will
     * be used.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SendAccountRecoveryEmailResult> privateSendAccountRecoveryEmailAsync(final SendAccountRecoveryEmailRequest request) throws Exception {

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/SendAccountRecoveryEmail"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Updates the tag list for a specified user in the friend list of the local user
     * @param request SetFriendTagsRequest
     * @return Async Task will return SetFriendTagsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetFriendTagsResult>> SetFriendTagsAsync(final SetFriendTagsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetFriendTagsResult>>() {
            public PlayFabResult<SetFriendTagsResult> call() throws Exception {
                return privateSetFriendTagsAsync(request);
            }
        });
    }

    /**
     * Updates the tag list for a specified user in the friend list of the local user
     * @param request SetFriendTagsRequest
     * @return SetFriendTagsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetFriendTagsResult> SetFriendTags(final SetFriendTagsRequest request) {
        FutureTask<PlayFabResult<SetFriendTagsResult>> task = new FutureTask(new Callable<PlayFabResult<SetFriendTagsResult>>() {
            public PlayFabResult<SetFriendTagsResult> call() throws Exception {
                return privateSetFriendTagsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetFriendTagsResult> exceptionResult = new PlayFabResult<SetFriendTagsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the tag list for a specified user in the friend list of the local user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetFriendTagsResult> privateSetFriendTagsAsync(final SetFriendTagsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/SetFriendTags"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetFriendTagsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetFriendTagsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetFriendTagsResult>>(){}.getType());
        SetFriendTagsResult result = resultData.data;

        PlayFabResult<SetFriendTagsResult> pfResult = new PlayFabResult<SetFriendTagsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the player's secret if it is not already set. Player secrets are used to sign API requests. To reset a player's
     * secret use the Admin or Server API method SetPlayerSecret.
     * @param request SetPlayerSecretRequest
     * @return Async Task will return SetPlayerSecretResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetPlayerSecretResult>> SetPlayerSecretAsync(final SetPlayerSecretRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetPlayerSecretResult>>() {
            public PlayFabResult<SetPlayerSecretResult> call() throws Exception {
                return privateSetPlayerSecretAsync(request);
            }
        });
    }

    /**
     * Sets the player's secret if it is not already set. Player secrets are used to sign API requests. To reset a player's
     * secret use the Admin or Server API method SetPlayerSecret.
     * @param request SetPlayerSecretRequest
     * @return SetPlayerSecretResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetPlayerSecretResult> SetPlayerSecret(final SetPlayerSecretRequest request) {
        FutureTask<PlayFabResult<SetPlayerSecretResult>> task = new FutureTask(new Callable<PlayFabResult<SetPlayerSecretResult>>() {
            public PlayFabResult<SetPlayerSecretResult> call() throws Exception {
                return privateSetPlayerSecretAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetPlayerSecretResult> exceptionResult = new PlayFabResult<SetPlayerSecretResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Sets the player's secret if it is not already set. Player secrets are used to sign API requests. To reset a player's
     * secret use the Admin or Server API method SetPlayerSecret.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetPlayerSecretResult> privateSetPlayerSecretAsync(final SetPlayerSecretRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/SetPlayerSecret"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetPlayerSecretResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetPlayerSecretResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetPlayerSecretResult>>(){}.getType());
        SetPlayerSecretResult result = resultData.data;

        PlayFabResult<SetPlayerSecretResult> pfResult = new PlayFabResult<SetPlayerSecretResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Creates an order for a list of items from the title catalog
     * @param request StartPurchaseRequest
     * @return Async Task will return StartPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<StartPurchaseResult>> StartPurchaseAsync(final StartPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<StartPurchaseResult>>() {
            public PlayFabResult<StartPurchaseResult> call() throws Exception {
                return privateStartPurchaseAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Creates an order for a list of items from the title catalog
     * @param request StartPurchaseRequest
     * @return StartPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<StartPurchaseResult> StartPurchase(final StartPurchaseRequest request) {
        FutureTask<PlayFabResult<StartPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<StartPurchaseResult>>() {
            public PlayFabResult<StartPurchaseResult> call() throws Exception {
                return privateStartPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<StartPurchaseResult> exceptionResult = new PlayFabResult<StartPurchaseResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Creates an order for a list of items from the title catalog
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<StartPurchaseResult> privateStartPurchaseAsync(final StartPurchaseRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/StartPurchase"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<StartPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<StartPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<StartPurchaseResult>>(){}.getType());
        StartPurchaseResult result = resultData.data;

        PlayFabResult<StartPurchaseResult> pfResult = new PlayFabResult<StartPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Decrements the user's balance of the specified virtual currency by the stated amount. It is possible to make
     * a VC balance negative with this API.
     * @param request SubtractUserVirtualCurrencyRequest
     * @return Async Task will return ModifyUserVirtualCurrencyResult
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Decrements the user's balance of the specified virtual currency by the stated amount. It is possible to make
     * a VC balance negative with this API.
     * @param request SubtractUserVirtualCurrencyRequest
     * @return ModifyUserVirtualCurrencyResult
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
            PlayFabResult<ModifyUserVirtualCurrencyResult> exceptionResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Decrements the user's balance of the specified virtual currency by the stated amount. It is possible to make
     * a VC balance negative with this API.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateSubtractUserVirtualCurrencyAsync(final SubtractUserVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/SubtractUserVirtualCurrency"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Unlinks the related Android device identifier from the user's PlayFab account
     * @param request UnlinkAndroidDeviceIDRequest
     * @return Async Task will return UnlinkAndroidDeviceIDResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkAndroidDeviceIDResult>> UnlinkAndroidDeviceIDAsync(final UnlinkAndroidDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkAndroidDeviceIDResult>>() {
            public PlayFabResult<UnlinkAndroidDeviceIDResult> call() throws Exception {
                return privateUnlinkAndroidDeviceIDAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Android device identifier from the user's PlayFab account
     * @param request UnlinkAndroidDeviceIDRequest
     * @return UnlinkAndroidDeviceIDResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkAndroidDeviceIDResult> UnlinkAndroidDeviceID(final UnlinkAndroidDeviceIDRequest request) {
        FutureTask<PlayFabResult<UnlinkAndroidDeviceIDResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkAndroidDeviceIDResult>>() {
            public PlayFabResult<UnlinkAndroidDeviceIDResult> call() throws Exception {
                return privateUnlinkAndroidDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkAndroidDeviceIDResult> exceptionResult = new PlayFabResult<UnlinkAndroidDeviceIDResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Android device identifier from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkAndroidDeviceIDResult> privateUnlinkAndroidDeviceIDAsync(final UnlinkAndroidDeviceIDRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkAndroidDeviceID"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkAndroidDeviceIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkAndroidDeviceIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkAndroidDeviceIDResult>>(){}.getType());
        UnlinkAndroidDeviceIDResult result = resultData.data;

        PlayFabResult<UnlinkAndroidDeviceIDResult> pfResult = new PlayFabResult<UnlinkAndroidDeviceIDResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Apple account from the user's PlayFab account.
     * @param request UnlinkAppleRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UnlinkAppleAsync(final UnlinkAppleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkAppleAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Apple account from the user's PlayFab account.
     * @param request UnlinkAppleRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UnlinkApple(final UnlinkAppleRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkAppleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Apple account from the user's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUnlinkAppleAsync(final UnlinkAppleRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkApple"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related custom identifier from the user's PlayFab account
     * @param request UnlinkCustomIDRequest
     * @return Async Task will return UnlinkCustomIDResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkCustomIDResult>> UnlinkCustomIDAsync(final UnlinkCustomIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkCustomIDResult>>() {
            public PlayFabResult<UnlinkCustomIDResult> call() throws Exception {
                return privateUnlinkCustomIDAsync(request);
            }
        });
    }

    /**
     * Unlinks the related custom identifier from the user's PlayFab account
     * @param request UnlinkCustomIDRequest
     * @return UnlinkCustomIDResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkCustomIDResult> UnlinkCustomID(final UnlinkCustomIDRequest request) {
        FutureTask<PlayFabResult<UnlinkCustomIDResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkCustomIDResult>>() {
            public PlayFabResult<UnlinkCustomIDResult> call() throws Exception {
                return privateUnlinkCustomIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkCustomIDResult> exceptionResult = new PlayFabResult<UnlinkCustomIDResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related custom identifier from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkCustomIDResult> privateUnlinkCustomIDAsync(final UnlinkCustomIDRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkCustomID"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkCustomIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkCustomIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkCustomIDResult>>(){}.getType());
        UnlinkCustomIDResult result = resultData.data;

        PlayFabResult<UnlinkCustomIDResult> pfResult = new PlayFabResult<UnlinkCustomIDResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Facebook account from the user's PlayFab account
     * @param request UnlinkFacebookAccountRequest
     * @return Async Task will return UnlinkFacebookAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkFacebookAccountResult>> UnlinkFacebookAccountAsync(final UnlinkFacebookAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkFacebookAccountResult>>() {
            public PlayFabResult<UnlinkFacebookAccountResult> call() throws Exception {
                return privateUnlinkFacebookAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Facebook account from the user's PlayFab account
     * @param request UnlinkFacebookAccountRequest
     * @return UnlinkFacebookAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkFacebookAccountResult> UnlinkFacebookAccount(final UnlinkFacebookAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkFacebookAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkFacebookAccountResult>>() {
            public PlayFabResult<UnlinkFacebookAccountResult> call() throws Exception {
                return privateUnlinkFacebookAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkFacebookAccountResult> exceptionResult = new PlayFabResult<UnlinkFacebookAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Facebook account from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkFacebookAccountResult> privateUnlinkFacebookAccountAsync(final UnlinkFacebookAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkFacebookAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkFacebookAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkFacebookAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkFacebookAccountResult>>(){}.getType());
        UnlinkFacebookAccountResult result = resultData.data;

        PlayFabResult<UnlinkFacebookAccountResult> pfResult = new PlayFabResult<UnlinkFacebookAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Facebook Instant Game Ids from the user's PlayFab account
     * @param request UnlinkFacebookInstantGamesIdRequest
     * @return Async Task will return UnlinkFacebookInstantGamesIdResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkFacebookInstantGamesIdResult>> UnlinkFacebookInstantGamesIdAsync(final UnlinkFacebookInstantGamesIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkFacebookInstantGamesIdResult>>() {
            public PlayFabResult<UnlinkFacebookInstantGamesIdResult> call() throws Exception {
                return privateUnlinkFacebookInstantGamesIdAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Facebook Instant Game Ids from the user's PlayFab account
     * @param request UnlinkFacebookInstantGamesIdRequest
     * @return UnlinkFacebookInstantGamesIdResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkFacebookInstantGamesIdResult> UnlinkFacebookInstantGamesId(final UnlinkFacebookInstantGamesIdRequest request) {
        FutureTask<PlayFabResult<UnlinkFacebookInstantGamesIdResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkFacebookInstantGamesIdResult>>() {
            public PlayFabResult<UnlinkFacebookInstantGamesIdResult> call() throws Exception {
                return privateUnlinkFacebookInstantGamesIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkFacebookInstantGamesIdResult> exceptionResult = new PlayFabResult<UnlinkFacebookInstantGamesIdResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Facebook Instant Game Ids from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkFacebookInstantGamesIdResult> privateUnlinkFacebookInstantGamesIdAsync(final UnlinkFacebookInstantGamesIdRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkFacebookInstantGamesId"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkFacebookInstantGamesIdResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkFacebookInstantGamesIdResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkFacebookInstantGamesIdResult>>(){}.getType());
        UnlinkFacebookInstantGamesIdResult result = resultData.data;

        PlayFabResult<UnlinkFacebookInstantGamesIdResult> pfResult = new PlayFabResult<UnlinkFacebookInstantGamesIdResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Game Center account from the user's PlayFab account
     * @param request UnlinkGameCenterAccountRequest
     * @return Async Task will return UnlinkGameCenterAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkGameCenterAccountResult>> UnlinkGameCenterAccountAsync(final UnlinkGameCenterAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkGameCenterAccountResult>>() {
            public PlayFabResult<UnlinkGameCenterAccountResult> call() throws Exception {
                return privateUnlinkGameCenterAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Game Center account from the user's PlayFab account
     * @param request UnlinkGameCenterAccountRequest
     * @return UnlinkGameCenterAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkGameCenterAccountResult> UnlinkGameCenterAccount(final UnlinkGameCenterAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkGameCenterAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkGameCenterAccountResult>>() {
            public PlayFabResult<UnlinkGameCenterAccountResult> call() throws Exception {
                return privateUnlinkGameCenterAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkGameCenterAccountResult> exceptionResult = new PlayFabResult<UnlinkGameCenterAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Game Center account from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkGameCenterAccountResult> privateUnlinkGameCenterAccountAsync(final UnlinkGameCenterAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkGameCenterAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkGameCenterAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkGameCenterAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkGameCenterAccountResult>>(){}.getType());
        UnlinkGameCenterAccountResult result = resultData.data;

        PlayFabResult<UnlinkGameCenterAccountResult> pfResult = new PlayFabResult<UnlinkGameCenterAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Google account from the user's PlayFab account
     * (https://developers.google.com/android/reference/com/google/android/gms/auth/GoogleAuthUtil#public-methods).
     * @param request UnlinkGoogleAccountRequest
     * @return Async Task will return UnlinkGoogleAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkGoogleAccountResult>> UnlinkGoogleAccountAsync(final UnlinkGoogleAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkGoogleAccountResult>>() {
            public PlayFabResult<UnlinkGoogleAccountResult> call() throws Exception {
                return privateUnlinkGoogleAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Google account from the user's PlayFab account
     * (https://developers.google.com/android/reference/com/google/android/gms/auth/GoogleAuthUtil#public-methods).
     * @param request UnlinkGoogleAccountRequest
     * @return UnlinkGoogleAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkGoogleAccountResult> UnlinkGoogleAccount(final UnlinkGoogleAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkGoogleAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkGoogleAccountResult>>() {
            public PlayFabResult<UnlinkGoogleAccountResult> call() throws Exception {
                return privateUnlinkGoogleAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkGoogleAccountResult> exceptionResult = new PlayFabResult<UnlinkGoogleAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Unlinks the related Google account from the user's PlayFab account
     * (https://developers.google.com/android/reference/com/google/android/gms/auth/GoogleAuthUtil#public-methods).
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkGoogleAccountResult> privateUnlinkGoogleAccountAsync(final UnlinkGoogleAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkGoogleAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkGoogleAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkGoogleAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkGoogleAccountResult>>(){}.getType());
        UnlinkGoogleAccountResult result = resultData.data;

        PlayFabResult<UnlinkGoogleAccountResult> pfResult = new PlayFabResult<UnlinkGoogleAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Google Play Games account from the user's PlayFab account.
     * @param request UnlinkGooglePlayGamesServicesAccountRequest
     * @return Async Task will return UnlinkGooglePlayGamesServicesAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult>> UnlinkGooglePlayGamesServicesAccountAsync(final UnlinkGooglePlayGamesServicesAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult>>() {
            public PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult> call() throws Exception {
                return privateUnlinkGooglePlayGamesServicesAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Google Play Games account from the user's PlayFab account.
     * @param request UnlinkGooglePlayGamesServicesAccountRequest
     * @return UnlinkGooglePlayGamesServicesAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult> UnlinkGooglePlayGamesServicesAccount(final UnlinkGooglePlayGamesServicesAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult>>() {
            public PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult> call() throws Exception {
                return privateUnlinkGooglePlayGamesServicesAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult> exceptionResult = new PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Google Play Games account from the user's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult> privateUnlinkGooglePlayGamesServicesAccountAsync(final UnlinkGooglePlayGamesServicesAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkGooglePlayGamesServicesAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkGooglePlayGamesServicesAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkGooglePlayGamesServicesAccountResult>>(){}.getType());
        UnlinkGooglePlayGamesServicesAccountResult result = resultData.data;

        PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult> pfResult = new PlayFabResult<UnlinkGooglePlayGamesServicesAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related iOS device identifier from the user's PlayFab account
     * @param request UnlinkIOSDeviceIDRequest
     * @return Async Task will return UnlinkIOSDeviceIDResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkIOSDeviceIDResult>> UnlinkIOSDeviceIDAsync(final UnlinkIOSDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkIOSDeviceIDResult>>() {
            public PlayFabResult<UnlinkIOSDeviceIDResult> call() throws Exception {
                return privateUnlinkIOSDeviceIDAsync(request);
            }
        });
    }

    /**
     * Unlinks the related iOS device identifier from the user's PlayFab account
     * @param request UnlinkIOSDeviceIDRequest
     * @return UnlinkIOSDeviceIDResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkIOSDeviceIDResult> UnlinkIOSDeviceID(final UnlinkIOSDeviceIDRequest request) {
        FutureTask<PlayFabResult<UnlinkIOSDeviceIDResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkIOSDeviceIDResult>>() {
            public PlayFabResult<UnlinkIOSDeviceIDResult> call() throws Exception {
                return privateUnlinkIOSDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkIOSDeviceIDResult> exceptionResult = new PlayFabResult<UnlinkIOSDeviceIDResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related iOS device identifier from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkIOSDeviceIDResult> privateUnlinkIOSDeviceIDAsync(final UnlinkIOSDeviceIDRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkIOSDeviceID"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkIOSDeviceIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkIOSDeviceIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkIOSDeviceIDResult>>(){}.getType());
        UnlinkIOSDeviceIDResult result = resultData.data;

        PlayFabResult<UnlinkIOSDeviceIDResult> pfResult = new PlayFabResult<UnlinkIOSDeviceIDResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Kongregate identifier from the user's PlayFab account
     * @param request UnlinkKongregateAccountRequest
     * @return Async Task will return UnlinkKongregateAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkKongregateAccountResult>> UnlinkKongregateAsync(final UnlinkKongregateAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkKongregateAccountResult>>() {
            public PlayFabResult<UnlinkKongregateAccountResult> call() throws Exception {
                return privateUnlinkKongregateAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Kongregate identifier from the user's PlayFab account
     * @param request UnlinkKongregateAccountRequest
     * @return UnlinkKongregateAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkKongregateAccountResult> UnlinkKongregate(final UnlinkKongregateAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkKongregateAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkKongregateAccountResult>>() {
            public PlayFabResult<UnlinkKongregateAccountResult> call() throws Exception {
                return privateUnlinkKongregateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkKongregateAccountResult> exceptionResult = new PlayFabResult<UnlinkKongregateAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Kongregate identifier from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkKongregateAccountResult> privateUnlinkKongregateAsync(final UnlinkKongregateAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkKongregate"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkKongregateAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkKongregateAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkKongregateAccountResult>>(){}.getType());
        UnlinkKongregateAccountResult result = resultData.data;

        PlayFabResult<UnlinkKongregateAccountResult> pfResult = new PlayFabResult<UnlinkKongregateAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Nintendo account from the user's PlayFab account.
     * @param request UnlinkNintendoServiceAccountRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UnlinkNintendoServiceAccountAsync(final UnlinkNintendoServiceAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkNintendoServiceAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Nintendo account from the user's PlayFab account.
     * @param request UnlinkNintendoServiceAccountRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UnlinkNintendoServiceAccount(final UnlinkNintendoServiceAccountRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkNintendoServiceAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Nintendo account from the user's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUnlinkNintendoServiceAccountAsync(final UnlinkNintendoServiceAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkNintendoServiceAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related NintendoSwitchDeviceId from the user's PlayFab account
     * @param request UnlinkNintendoSwitchDeviceIdRequest
     * @return Async Task will return UnlinkNintendoSwitchDeviceIdResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkNintendoSwitchDeviceIdResult>> UnlinkNintendoSwitchDeviceIdAsync(final UnlinkNintendoSwitchDeviceIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkNintendoSwitchDeviceIdResult>>() {
            public PlayFabResult<UnlinkNintendoSwitchDeviceIdResult> call() throws Exception {
                return privateUnlinkNintendoSwitchDeviceIdAsync(request);
            }
        });
    }

    /**
     * Unlinks the related NintendoSwitchDeviceId from the user's PlayFab account
     * @param request UnlinkNintendoSwitchDeviceIdRequest
     * @return UnlinkNintendoSwitchDeviceIdResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkNintendoSwitchDeviceIdResult> UnlinkNintendoSwitchDeviceId(final UnlinkNintendoSwitchDeviceIdRequest request) {
        FutureTask<PlayFabResult<UnlinkNintendoSwitchDeviceIdResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkNintendoSwitchDeviceIdResult>>() {
            public PlayFabResult<UnlinkNintendoSwitchDeviceIdResult> call() throws Exception {
                return privateUnlinkNintendoSwitchDeviceIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkNintendoSwitchDeviceIdResult> exceptionResult = new PlayFabResult<UnlinkNintendoSwitchDeviceIdResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related NintendoSwitchDeviceId from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkNintendoSwitchDeviceIdResult> privateUnlinkNintendoSwitchDeviceIdAsync(final UnlinkNintendoSwitchDeviceIdRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkNintendoSwitchDeviceId"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkNintendoSwitchDeviceIdResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkNintendoSwitchDeviceIdResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkNintendoSwitchDeviceIdResult>>(){}.getType());
        UnlinkNintendoSwitchDeviceIdResult result = resultData.data;

        PlayFabResult<UnlinkNintendoSwitchDeviceIdResult> pfResult = new PlayFabResult<UnlinkNintendoSwitchDeviceIdResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks an OpenID Connect account from a user's PlayFab account, based on the connection ID of an existing relationship
     * between a title and an Open ID Connect provider.
     * @param request UnlinkOpenIdConnectRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UnlinkOpenIdConnectAsync(final UnlinkOpenIdConnectRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkOpenIdConnectAsync(request);
            }
        });
    }

    /**
     * Unlinks an OpenID Connect account from a user's PlayFab account, based on the connection ID of an existing relationship
     * between a title and an Open ID Connect provider.
     * @param request UnlinkOpenIdConnectRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UnlinkOpenIdConnect(final UnlinkOpenIdConnectRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkOpenIdConnectAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Unlinks an OpenID Connect account from a user's PlayFab account, based on the connection ID of an existing relationship
     * between a title and an Open ID Connect provider.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUnlinkOpenIdConnectAsync(final UnlinkOpenIdConnectRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkOpenIdConnect"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related PlayStation :tm: Network account from the user's PlayFab account
     * @param request UnlinkPSNAccountRequest
     * @return Async Task will return UnlinkPSNAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkPSNAccountResult>> UnlinkPSNAccountAsync(final UnlinkPSNAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkPSNAccountResult>>() {
            public PlayFabResult<UnlinkPSNAccountResult> call() throws Exception {
                return privateUnlinkPSNAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related PlayStation :tm: Network account from the user's PlayFab account
     * @param request UnlinkPSNAccountRequest
     * @return UnlinkPSNAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkPSNAccountResult> UnlinkPSNAccount(final UnlinkPSNAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkPSNAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkPSNAccountResult>>() {
            public PlayFabResult<UnlinkPSNAccountResult> call() throws Exception {
                return privateUnlinkPSNAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkPSNAccountResult> exceptionResult = new PlayFabResult<UnlinkPSNAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related PlayStation :tm: Network account from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkPSNAccountResult> privateUnlinkPSNAccountAsync(final UnlinkPSNAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkPSNAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkPSNAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkPSNAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkPSNAccountResult>>(){}.getType());
        UnlinkPSNAccountResult result = resultData.data;

        PlayFabResult<UnlinkPSNAccountResult> pfResult = new PlayFabResult<UnlinkPSNAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Steam account from the user's PlayFab account
     * @param request UnlinkSteamAccountRequest
     * @return Async Task will return UnlinkSteamAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkSteamAccountResult>> UnlinkSteamAccountAsync(final UnlinkSteamAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkSteamAccountResult>>() {
            public PlayFabResult<UnlinkSteamAccountResult> call() throws Exception {
                return privateUnlinkSteamAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Steam account from the user's PlayFab account
     * @param request UnlinkSteamAccountRequest
     * @return UnlinkSteamAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkSteamAccountResult> UnlinkSteamAccount(final UnlinkSteamAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkSteamAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkSteamAccountResult>>() {
            public PlayFabResult<UnlinkSteamAccountResult> call() throws Exception {
                return privateUnlinkSteamAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkSteamAccountResult> exceptionResult = new PlayFabResult<UnlinkSteamAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Steam account from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkSteamAccountResult> privateUnlinkSteamAccountAsync(final UnlinkSteamAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkSteamAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkSteamAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkSteamAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkSteamAccountResult>>(){}.getType());
        UnlinkSteamAccountResult result = resultData.data;

        PlayFabResult<UnlinkSteamAccountResult> pfResult = new PlayFabResult<UnlinkSteamAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Twitch account from the user's PlayFab account.
     * @param request UnlinkTwitchAccountRequest
     * @return Async Task will return UnlinkTwitchAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkTwitchAccountResult>> UnlinkTwitchAsync(final UnlinkTwitchAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkTwitchAccountResult>>() {
            public PlayFabResult<UnlinkTwitchAccountResult> call() throws Exception {
                return privateUnlinkTwitchAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Twitch account from the user's PlayFab account.
     * @param request UnlinkTwitchAccountRequest
     * @return UnlinkTwitchAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkTwitchAccountResult> UnlinkTwitch(final UnlinkTwitchAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkTwitchAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkTwitchAccountResult>>() {
            public PlayFabResult<UnlinkTwitchAccountResult> call() throws Exception {
                return privateUnlinkTwitchAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkTwitchAccountResult> exceptionResult = new PlayFabResult<UnlinkTwitchAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Twitch account from the user's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkTwitchAccountResult> privateUnlinkTwitchAsync(final UnlinkTwitchAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkTwitch"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkTwitchAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkTwitchAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkTwitchAccountResult>>(){}.getType());
        UnlinkTwitchAccountResult result = resultData.data;

        PlayFabResult<UnlinkTwitchAccountResult> pfResult = new PlayFabResult<UnlinkTwitchAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks the related Xbox Live account from the user's PlayFab account
     * @param request UnlinkXboxAccountRequest
     * @return Async Task will return UnlinkXboxAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkXboxAccountResult>> UnlinkXboxAccountAsync(final UnlinkXboxAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkXboxAccountResult>>() {
            public PlayFabResult<UnlinkXboxAccountResult> call() throws Exception {
                return privateUnlinkXboxAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Xbox Live account from the user's PlayFab account
     * @param request UnlinkXboxAccountRequest
     * @return UnlinkXboxAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkXboxAccountResult> UnlinkXboxAccount(final UnlinkXboxAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkXboxAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkXboxAccountResult>>() {
            public PlayFabResult<UnlinkXboxAccountResult> call() throws Exception {
                return privateUnlinkXboxAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlinkXboxAccountResult> exceptionResult = new PlayFabResult<UnlinkXboxAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unlinks the related Xbox Live account from the user's PlayFab account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkXboxAccountResult> privateUnlinkXboxAccountAsync(final UnlinkXboxAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkXboxAccount"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkXboxAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkXboxAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkXboxAccountResult>>(){}.getType());
        UnlinkXboxAccountResult result = resultData.data;

        PlayFabResult<UnlinkXboxAccountResult> pfResult = new PlayFabResult<UnlinkXboxAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Opens the specified container, with the specified key (when required), and returns the contents of the
     * opened container. If the container (and key when relevant) are consumable (RemainingUses &gt; 0), their RemainingUses will
     * be decremented, consistent with the operation of ConsumeItem.
     * @param request UnlockContainerInstanceRequest
     * @return Async Task will return UnlockContainerItemResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlockContainerItemResult>> UnlockContainerInstanceAsync(final UnlockContainerInstanceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlockContainerItemResult>>() {
            public PlayFabResult<UnlockContainerItemResult> call() throws Exception {
                return privateUnlockContainerInstanceAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Opens the specified container, with the specified key (when required), and returns the contents of the
     * opened container. If the container (and key when relevant) are consumable (RemainingUses &gt; 0), their RemainingUses will
     * be decremented, consistent with the operation of ConsumeItem.
     * @param request UnlockContainerInstanceRequest
     * @return UnlockContainerItemResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlockContainerItemResult> UnlockContainerInstance(final UnlockContainerInstanceRequest request) {
        FutureTask<PlayFabResult<UnlockContainerItemResult>> task = new FutureTask(new Callable<PlayFabResult<UnlockContainerItemResult>>() {
            public PlayFabResult<UnlockContainerItemResult> call() throws Exception {
                return privateUnlockContainerInstanceAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlockContainerItemResult> exceptionResult = new PlayFabResult<UnlockContainerItemResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Opens the specified container, with the specified key (when required), and returns the contents of the
     * opened container. If the container (and key when relevant) are consumable (RemainingUses &gt; 0), their RemainingUses will
     * be decremented, consistent with the operation of ConsumeItem.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlockContainerItemResult> privateUnlockContainerInstanceAsync(final UnlockContainerInstanceRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlockContainerInstance"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlockContainerItemResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlockContainerItemResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlockContainerItemResult>>(){}.getType());
        UnlockContainerItemResult result = resultData.data;

        PlayFabResult<UnlockContainerItemResult> pfResult = new PlayFabResult<UnlockContainerItemResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Searches target inventory for an ItemInstance matching the given CatalogItemId, if necessary unlocks it
     * using an appropriate key, and returns the contents of the opened container. If the container (and key when relevant) are
     * consumable (RemainingUses &gt; 0), their RemainingUses will be decremented, consistent with the operation of ConsumeItem.
     * @param request UnlockContainerItemRequest
     * @return Async Task will return UnlockContainerItemResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlockContainerItemResult>> UnlockContainerItemAsync(final UnlockContainerItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlockContainerItemResult>>() {
            public PlayFabResult<UnlockContainerItemResult> call() throws Exception {
                return privateUnlockContainerItemAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Searches target inventory for an ItemInstance matching the given CatalogItemId, if necessary unlocks it
     * using an appropriate key, and returns the contents of the opened container. If the container (and key when relevant) are
     * consumable (RemainingUses &gt; 0), their RemainingUses will be decremented, consistent with the operation of ConsumeItem.
     * @param request UnlockContainerItemRequest
     * @return UnlockContainerItemResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlockContainerItemResult> UnlockContainerItem(final UnlockContainerItemRequest request) {
        FutureTask<PlayFabResult<UnlockContainerItemResult>> task = new FutureTask(new Callable<PlayFabResult<UnlockContainerItemResult>>() {
            public PlayFabResult<UnlockContainerItemResult> call() throws Exception {
                return privateUnlockContainerItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UnlockContainerItemResult> exceptionResult = new PlayFabResult<UnlockContainerItemResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Searches target inventory for an ItemInstance matching the given CatalogItemId, if necessary unlocks it
     * using an appropriate key, and returns the contents of the opened container. If the container (and key when relevant) are
     * consumable (RemainingUses &gt; 0), their RemainingUses will be decremented, consistent with the operation of ConsumeItem.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlockContainerItemResult> privateUnlockContainerItemAsync(final UnlockContainerItemRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlockContainerItem"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlockContainerItemResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlockContainerItemResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlockContainerItemResult>>(){}.getType());
        UnlockContainerItemResult result = resultData.data;

        PlayFabResult<UnlockContainerItemResult> pfResult = new PlayFabResult<UnlockContainerItemResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Update the avatar URL of the player
     * @param request UpdateAvatarUrlRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateAvatarUrlAsync(final UpdateAvatarUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateAvatarUrlAsync(request);
            }
        });
    }

    /**
     * Update the avatar URL of the player
     * @param request UpdateAvatarUrlRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateAvatarUrl(final UpdateAvatarUrlRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateAvatarUrlAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Update the avatar URL of the player */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateAvatarUrlAsync(final UpdateAvatarUrlRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UpdateAvatarUrl"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates and updates the title-specific custom data for the user's character which is readable and writable by the client
     * @param request UpdateCharacterDataRequest
     * @return Async Task will return UpdateCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCharacterDataResult>> UpdateCharacterDataAsync(final UpdateCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterDataAsync(request);
            }
        });
    }

    /**
     * Creates and updates the title-specific custom data for the user's character which is readable and writable by the client
     * @param request UpdateCharacterDataRequest
     * @return UpdateCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCharacterDataResult> UpdateCharacterData(final UpdateCharacterDataRequest request) {
        FutureTask<PlayFabResult<UpdateCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateCharacterDataResult> exceptionResult = new PlayFabResult<UpdateCharacterDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates and updates the title-specific custom data for the user's character which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCharacterDataResult> privateUpdateCharacterDataAsync(final UpdateCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UpdateCharacterData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Updates the values of the specified title-specific statistics for the specific character. By default, clients are not
     * permitted to update statistics. Developers may override this setting in the Game Manager &gt; Settings &gt; API Features.
     * @param request UpdateCharacterStatisticsRequest
     * @return Async Task will return UpdateCharacterStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCharacterStatisticsResult>> UpdateCharacterStatisticsAsync(final UpdateCharacterStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCharacterStatisticsResult>>() {
            public PlayFabResult<UpdateCharacterStatisticsResult> call() throws Exception {
                return privateUpdateCharacterStatisticsAsync(request);
            }
        });
    }

    /**
     * Updates the values of the specified title-specific statistics for the specific character. By default, clients are not
     * permitted to update statistics. Developers may override this setting in the Game Manager &gt; Settings &gt; API Features.
     * @param request UpdateCharacterStatisticsRequest
     * @return UpdateCharacterStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCharacterStatisticsResult> UpdateCharacterStatistics(final UpdateCharacterStatisticsRequest request) {
        FutureTask<PlayFabResult<UpdateCharacterStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCharacterStatisticsResult>>() {
            public PlayFabResult<UpdateCharacterStatisticsResult> call() throws Exception {
                return privateUpdateCharacterStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateCharacterStatisticsResult> exceptionResult = new PlayFabResult<UpdateCharacterStatisticsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Updates the values of the specified title-specific statistics for the specific character. By default, clients are not
     * permitted to update statistics. Developers may override this setting in the Game Manager &gt; Settings &gt; API Features.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCharacterStatisticsResult> privateUpdateCharacterStatisticsAsync(final UpdateCharacterStatisticsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UpdateCharacterStatistics"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Updates the values of the specified title-specific statistics for the user. By default, clients are not permitted to
     * update statistics. Developers may override this setting in the Game Manager &gt; Settings &gt; API Features.
     * @param request UpdatePlayerStatisticsRequest
     * @return Async Task will return UpdatePlayerStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdatePlayerStatisticsResult>> UpdatePlayerStatisticsAsync(final UpdatePlayerStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdatePlayerStatisticsResult>>() {
            public PlayFabResult<UpdatePlayerStatisticsResult> call() throws Exception {
                return privateUpdatePlayerStatisticsAsync(request);
            }
        });
    }

    /**
     * Updates the values of the specified title-specific statistics for the user. By default, clients are not permitted to
     * update statistics. Developers may override this setting in the Game Manager &gt; Settings &gt; API Features.
     * @param request UpdatePlayerStatisticsRequest
     * @return UpdatePlayerStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdatePlayerStatisticsResult> UpdatePlayerStatistics(final UpdatePlayerStatisticsRequest request) {
        FutureTask<PlayFabResult<UpdatePlayerStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdatePlayerStatisticsResult>>() {
            public PlayFabResult<UpdatePlayerStatisticsResult> call() throws Exception {
                return privateUpdatePlayerStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdatePlayerStatisticsResult> exceptionResult = new PlayFabResult<UpdatePlayerStatisticsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Updates the values of the specified title-specific statistics for the user. By default, clients are not permitted to
     * update statistics. Developers may override this setting in the Game Manager &gt; Settings &gt; API Features.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdatePlayerStatisticsResult> privateUpdatePlayerStatisticsAsync(final UpdatePlayerStatisticsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UpdatePlayerStatistics"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdatePlayerStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdatePlayerStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdatePlayerStatisticsResult>>(){}.getType());
        UpdatePlayerStatisticsResult result = resultData.data;

        PlayFabResult<UpdatePlayerStatisticsResult> pfResult = new PlayFabResult<UpdatePlayerStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated
     * or added in this call will be readable by users not in the group. By default, data permissions are set to Private.
     * Regardless of the permission setting, only members of the group can update the data. Shared Groups are designed for
     * sharing data between a very small number of players, please see our guide:
     * https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request UpdateSharedGroupDataRequest
     * @return Async Task will return UpdateSharedGroupDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateSharedGroupDataResult>> UpdateSharedGroupDataAsync(final UpdateSharedGroupDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateSharedGroupDataResult>>() {
            public PlayFabResult<UpdateSharedGroupDataResult> call() throws Exception {
                return privateUpdateSharedGroupDataAsync(request);
            }
        });
    }

    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated
     * or added in this call will be readable by users not in the group. By default, data permissions are set to Private.
     * Regardless of the permission setting, only members of the group can update the data. Shared Groups are designed for
     * sharing data between a very small number of players, please see our guide:
     * https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     * @param request UpdateSharedGroupDataRequest
     * @return UpdateSharedGroupDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateSharedGroupDataResult> UpdateSharedGroupData(final UpdateSharedGroupDataRequest request) {
        FutureTask<PlayFabResult<UpdateSharedGroupDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateSharedGroupDataResult>>() {
            public PlayFabResult<UpdateSharedGroupDataResult> call() throws Exception {
                return privateUpdateSharedGroupDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateSharedGroupDataResult> exceptionResult = new PlayFabResult<UpdateSharedGroupDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated
     * or added in this call will be readable by users not in the group. By default, data permissions are set to Private.
     * Regardless of the permission setting, only members of the group can update the data. Shared Groups are designed for
     * sharing data between a very small number of players, please see our guide:
     * https://docs.microsoft.com/gaming/playfab/features/social/groups/using-shared-group-data
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateSharedGroupDataResult> privateUpdateSharedGroupDataAsync(final UpdateSharedGroupDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UpdateSharedGroupData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Creates and updates the title-specific custom data for the user which is readable and writable by the client
     * @param request UpdateUserDataRequest
     * @return Async Task will return UpdateUserDataResult
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
     * Creates and updates the title-specific custom data for the user which is readable and writable by the client
     * @param request UpdateUserDataRequest
     * @return UpdateUserDataResult
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
            PlayFabResult<UpdateUserDataResult> exceptionResult = new PlayFabResult<UpdateUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates and updates the title-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UpdateUserData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Creates and updates the publisher-specific custom data for the user which is readable and writable by the client
     * @param request UpdateUserDataRequest
     * @return Async Task will return UpdateUserDataResult
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
     * Creates and updates the publisher-specific custom data for the user which is readable and writable by the client
     * @param request UpdateUserDataRequest
     * @return UpdateUserDataResult
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
            PlayFabResult<UpdateUserDataResult> exceptionResult = new PlayFabResult<UpdateUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates and updates the publisher-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UpdateUserPublisherData"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Updates the title specific display name for the user
     * @param request UpdateUserTitleDisplayNameRequest
     * @return Async Task will return UpdateUserTitleDisplayNameResult
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
     * Updates the title specific display name for the user
     * @param request UpdateUserTitleDisplayNameRequest
     * @return UpdateUserTitleDisplayNameResult
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
            PlayFabResult<UpdateUserTitleDisplayNameResult> exceptionResult = new PlayFabResult<UpdateUserTitleDisplayNameResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the title specific display name for the user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserTitleDisplayNameResult> privateUpdateUserTitleDisplayNameAsync(final UpdateUserTitleDisplayNameRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UpdateUserTitleDisplayName"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates with Amazon that the receipt for an Amazon App Store in-app purchase is valid and that it matches
     * the purchased catalog item
     * @param request ValidateAmazonReceiptRequest
     * @return Async Task will return ValidateAmazonReceiptResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ValidateAmazonReceiptResult>> ValidateAmazonIAPReceiptAsync(final ValidateAmazonReceiptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ValidateAmazonReceiptResult>>() {
            public PlayFabResult<ValidateAmazonReceiptResult> call() throws Exception {
                return privateValidateAmazonIAPReceiptAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates with Amazon that the receipt for an Amazon App Store in-app purchase is valid and that it matches
     * the purchased catalog item
     * @param request ValidateAmazonReceiptRequest
     * @return ValidateAmazonReceiptResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ValidateAmazonReceiptResult> ValidateAmazonIAPReceipt(final ValidateAmazonReceiptRequest request) {
        FutureTask<PlayFabResult<ValidateAmazonReceiptResult>> task = new FutureTask(new Callable<PlayFabResult<ValidateAmazonReceiptResult>>() {
            public PlayFabResult<ValidateAmazonReceiptResult> call() throws Exception {
                return privateValidateAmazonIAPReceiptAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ValidateAmazonReceiptResult> exceptionResult = new PlayFabResult<ValidateAmazonReceiptResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates with Amazon that the receipt for an Amazon App Store in-app purchase is valid and that it matches
     * the purchased catalog item
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ValidateAmazonReceiptResult> privateValidateAmazonIAPReceiptAsync(final ValidateAmazonReceiptRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ValidateAmazonIAPReceipt"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ValidateAmazonReceiptResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ValidateAmazonReceiptResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ValidateAmazonReceiptResult>>(){}.getType());
        ValidateAmazonReceiptResult result = resultData.data;

        PlayFabResult<ValidateAmazonReceiptResult> pfResult = new PlayFabResult<ValidateAmazonReceiptResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates a Google Play purchase and gives the corresponding item to the player.
     * @param request ValidateGooglePlayPurchaseRequest
     * @return Async Task will return ValidateGooglePlayPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ValidateGooglePlayPurchaseResult>> ValidateGooglePlayPurchaseAsync(final ValidateGooglePlayPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ValidateGooglePlayPurchaseResult>>() {
            public PlayFabResult<ValidateGooglePlayPurchaseResult> call() throws Exception {
                return privateValidateGooglePlayPurchaseAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates a Google Play purchase and gives the corresponding item to the player.
     * @param request ValidateGooglePlayPurchaseRequest
     * @return ValidateGooglePlayPurchaseResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ValidateGooglePlayPurchaseResult> ValidateGooglePlayPurchase(final ValidateGooglePlayPurchaseRequest request) {
        FutureTask<PlayFabResult<ValidateGooglePlayPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<ValidateGooglePlayPurchaseResult>>() {
            public PlayFabResult<ValidateGooglePlayPurchaseResult> call() throws Exception {
                return privateValidateGooglePlayPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ValidateGooglePlayPurchaseResult> exceptionResult = new PlayFabResult<ValidateGooglePlayPurchaseResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates a Google Play purchase and gives the corresponding item to the player.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ValidateGooglePlayPurchaseResult> privateValidateGooglePlayPurchaseAsync(final ValidateGooglePlayPurchaseRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ValidateGooglePlayPurchase"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ValidateGooglePlayPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ValidateGooglePlayPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ValidateGooglePlayPurchaseResult>>(){}.getType());
        ValidateGooglePlayPurchaseResult result = resultData.data;

        PlayFabResult<ValidateGooglePlayPurchaseResult> pfResult = new PlayFabResult<ValidateGooglePlayPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the
     * purchased catalog item
     * @param request ValidateIOSReceiptRequest
     * @return Async Task will return ValidateIOSReceiptResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ValidateIOSReceiptResult>> ValidateIOSReceiptAsync(final ValidateIOSReceiptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ValidateIOSReceiptResult>>() {
            public PlayFabResult<ValidateIOSReceiptResult> call() throws Exception {
                return privateValidateIOSReceiptAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the
     * purchased catalog item
     * @param request ValidateIOSReceiptRequest
     * @return ValidateIOSReceiptResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ValidateIOSReceiptResult> ValidateIOSReceipt(final ValidateIOSReceiptRequest request) {
        FutureTask<PlayFabResult<ValidateIOSReceiptResult>> task = new FutureTask(new Callable<PlayFabResult<ValidateIOSReceiptResult>>() {
            public PlayFabResult<ValidateIOSReceiptResult> call() throws Exception {
                return privateValidateIOSReceiptAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ValidateIOSReceiptResult> exceptionResult = new PlayFabResult<ValidateIOSReceiptResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the
     * purchased catalog item
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ValidateIOSReceiptResult> privateValidateIOSReceiptAsync(final ValidateIOSReceiptRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ValidateIOSReceipt"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ValidateIOSReceiptResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ValidateIOSReceiptResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ValidateIOSReceiptResult>>(){}.getType());
        ValidateIOSReceiptResult result = resultData.data;

        PlayFabResult<ValidateIOSReceiptResult> pfResult = new PlayFabResult<ValidateIOSReceiptResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates with Windows that the receipt for an Windows App Store in-app purchase is valid and that it
     * matches the purchased catalog item
     * @param request ValidateWindowsReceiptRequest
     * @return Async Task will return ValidateWindowsReceiptResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ValidateWindowsReceiptResult>> ValidateWindowsStoreReceiptAsync(final ValidateWindowsReceiptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ValidateWindowsReceiptResult>>() {
            public PlayFabResult<ValidateWindowsReceiptResult> call() throws Exception {
                return privateValidateWindowsStoreReceiptAsync(request);
            }
        });
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates with Windows that the receipt for an Windows App Store in-app purchase is valid and that it
     * matches the purchased catalog item
     * @param request ValidateWindowsReceiptRequest
     * @return ValidateWindowsReceiptResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ValidateWindowsReceiptResult> ValidateWindowsStoreReceipt(final ValidateWindowsReceiptRequest request) {
        FutureTask<PlayFabResult<ValidateWindowsReceiptResult>> task = new FutureTask(new Callable<PlayFabResult<ValidateWindowsReceiptResult>>() {
            public PlayFabResult<ValidateWindowsReceiptResult> call() throws Exception {
                return privateValidateWindowsStoreReceiptAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ValidateWindowsReceiptResult> exceptionResult = new PlayFabResult<ValidateWindowsReceiptResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * _NOTE: This is a Legacy Economy API, and is in bugfix-only mode. All new Economy features are being developed only for
     * version 2._ Validates with Windows that the receipt for an Windows App Store in-app purchase is valid and that it
     * matches the purchased catalog item
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ValidateWindowsReceiptResult> privateValidateWindowsStoreReceiptAsync(final ValidateWindowsReceiptRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/ValidateWindowsStoreReceipt"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ValidateWindowsReceiptResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ValidateWindowsReceiptResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ValidateWindowsReceiptResult>>(){}.getType());
        ValidateWindowsReceiptResult result = resultData.data;

        PlayFabResult<ValidateWindowsReceiptResult> pfResult = new PlayFabResult<ValidateWindowsReceiptResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Writes a character-based event into PlayStream.
     * @param request WriteClientCharacterEventRequest
     * @return Async Task will return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<WriteEventResponse>> WriteCharacterEventAsync(final WriteClientCharacterEventRequest request) {
        return new FutureTask(new Callable<PlayFabResult<WriteEventResponse>>() {
            public PlayFabResult<WriteEventResponse> call() throws Exception {
                return privateWriteCharacterEventAsync(request);
            }
        });
    }

    /**
     * Writes a character-based event into PlayStream.
     * @param request WriteClientCharacterEventRequest
     * @return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<WriteEventResponse> WriteCharacterEvent(final WriteClientCharacterEventRequest request) {
        FutureTask<PlayFabResult<WriteEventResponse>> task = new FutureTask(new Callable<PlayFabResult<WriteEventResponse>>() {
            public PlayFabResult<WriteEventResponse> call() throws Exception {
                return privateWriteCharacterEventAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<WriteEventResponse> exceptionResult = new PlayFabResult<WriteEventResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Writes a character-based event into PlayStream. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<WriteEventResponse> privateWriteCharacterEventAsync(final WriteClientCharacterEventRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/WriteCharacterEvent"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<WriteEventResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<WriteEventResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<WriteEventResponse>>(){}.getType());
        WriteEventResponse result = resultData.data;

        PlayFabResult<WriteEventResponse> pfResult = new PlayFabResult<WriteEventResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Writes a player-based event into PlayStream.
     * @param request WriteClientPlayerEventRequest
     * @return Async Task will return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<WriteEventResponse>> WritePlayerEventAsync(final WriteClientPlayerEventRequest request) {
        return new FutureTask(new Callable<PlayFabResult<WriteEventResponse>>() {
            public PlayFabResult<WriteEventResponse> call() throws Exception {
                return privateWritePlayerEventAsync(request);
            }
        });
    }

    /**
     * Writes a player-based event into PlayStream.
     * @param request WriteClientPlayerEventRequest
     * @return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<WriteEventResponse> WritePlayerEvent(final WriteClientPlayerEventRequest request) {
        FutureTask<PlayFabResult<WriteEventResponse>> task = new FutureTask(new Callable<PlayFabResult<WriteEventResponse>>() {
            public PlayFabResult<WriteEventResponse> call() throws Exception {
                return privateWritePlayerEventAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<WriteEventResponse> exceptionResult = new PlayFabResult<WriteEventResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Writes a player-based event into PlayStream. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<WriteEventResponse> privateWritePlayerEventAsync(final WriteClientPlayerEventRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/WritePlayerEvent"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<WriteEventResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<WriteEventResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<WriteEventResponse>>(){}.getType());
        WriteEventResponse result = resultData.data;

        PlayFabResult<WriteEventResponse> pfResult = new PlayFabResult<WriteEventResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Writes a title-based event into PlayStream.
     * @param request WriteTitleEventRequest
     * @return Async Task will return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<WriteEventResponse>> WriteTitleEventAsync(final WriteTitleEventRequest request) {
        return new FutureTask(new Callable<PlayFabResult<WriteEventResponse>>() {
            public PlayFabResult<WriteEventResponse> call() throws Exception {
                return privateWriteTitleEventAsync(request);
            }
        });
    }

    /**
     * Writes a title-based event into PlayStream.
     * @param request WriteTitleEventRequest
     * @return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<WriteEventResponse> WriteTitleEvent(final WriteTitleEventRequest request) {
        FutureTask<PlayFabResult<WriteEventResponse>> task = new FutureTask(new Callable<PlayFabResult<WriteEventResponse>>() {
            public PlayFabResult<WriteEventResponse> call() throws Exception {
                return privateWriteTitleEventAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<WriteEventResponse> exceptionResult = new PlayFabResult<WriteEventResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Writes a title-based event into PlayStream. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<WriteEventResponse> privateWriteTitleEventAsync(final WriteTitleEventRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/WriteTitleEvent"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<WriteEventResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<WriteEventResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<WriteEventResponse>>(){}.getType());
        WriteEventResponse result = resultData.data;

        PlayFabResult<WriteEventResponse> pfResult = new PlayFabResult<WriteEventResponse>();
        pfResult.Result = result;
        return pfResult;
    }

}
