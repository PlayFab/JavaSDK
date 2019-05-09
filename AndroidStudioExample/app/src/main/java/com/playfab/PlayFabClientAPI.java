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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
     * please see our guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * please see our guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
            return null;
        }
    }

    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users
     * in the group can add new members. Shared Groups are designed for sharing data between a very small number of players,
     * please see our guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
            return null;
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
     * Increments the user's balance of the specified virtual currency by the stated amount
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
     * Increments the user's balance of the specified virtual currency by the stated amount
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
            return null;
        }
    }

    /** Increments the user's balance of the specified virtual currency by the stated amount */
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
            return null;
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
            return null;
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
        // Modify AdvertisingIdType:  Prevents us from sending the id multiple times, and allows automated tests to determine id was sent successfully
        PlayFabSettings.AdvertisingIdType += "_Successful";

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
            return null;
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
     * Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and virtual
     * currency balances as appropriate
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
     * Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and virtual
     * currency balances as appropriate
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
            return null;
        }
    }

    /**
     * Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and virtual
     * currency balances as appropriate
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
     * Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's inventory.
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
     * Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's inventory.
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
            return null;
        }
    }

    /** Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's inventory. */
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
            return null;
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
            return null;
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
     * https://docs.microsoft.com/en-us/gaming/playfab/features/social/groups/using-shared-group-data
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
     * https://docs.microsoft.com/en-us/gaming/playfab/features/social/groups/using-shared-group-data
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
            return null;
        }
    }

    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the
     * group. Upon creation, the current user will be the only member of the group. Shared Groups are designed for sharing data
     * between a very small number of players, please see our guide:
     * https://docs.microsoft.com/en-us/gaming/playfab/features/social/groups/using-shared-group-data
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
     * Executes a CloudScript function, with the 'currentPlayerId' set to the PlayFab ID of the authenticated player.
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
     * Executes a CloudScript function, with the 'currentPlayerId' set to the PlayFab ID of the authenticated player.
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
            return null;
        }
    }

    /** Executes a CloudScript function, with the 'currentPlayerId' set to the PlayFab ID of the authenticated player. */
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
            return null;
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
            return null;
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
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
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
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
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
            return null;
        }
    }

    /** Retrieves the specified version of the title's catalog of virtual goods, including all defined properties */
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
            return null;
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
     * Retrieves the specified character's current inventory of virtual goods
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
     * Retrieves the specified character's current inventory of virtual goods
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
            return null;
        }
    }

    /** Retrieves the specified character's current inventory of virtual goods */
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
            return null;
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
            return null;
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
            return null;
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
     * https://community.playfab.com/hc/en-us/community/posts/205469488-How-to-upload-files-to-PlayFab-s-Content-Service. Also,
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
     * https://community.playfab.com/hc/en-us/community/posts/205469488-How-to-upload-files-to-PlayFab-s-Content-Service. Also,
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
            return null;
        }
    }

    /**
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent HTTP GET to the returned
     * URL will attempt to download the content. A HEAD query to the returned URL will attempt to retrieve the metadata of the
     * content. Note that a successful result does not guarantee the existence of this content - if it has not been uploaded,
     * the query to retrieve the data will fail. See this post for more information:
     * https://community.playfab.com/hc/en-us/community/posts/205469488-How-to-upload-files-to-PlayFab-s-Content-Service. Also,
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
     * Get details about all current running game servers matching the given parameters.
     * @param request CurrentGamesRequest
     * @return Async Task will return CurrentGamesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CurrentGamesResult>> GetCurrentGamesAsync(final CurrentGamesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CurrentGamesResult>>() {
            public PlayFabResult<CurrentGamesResult> call() throws Exception {
                return privateGetCurrentGamesAsync(request);
            }
        });
    }

    /**
     * Get details about all current running game servers matching the given parameters.
     * @param request CurrentGamesRequest
     * @return CurrentGamesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CurrentGamesResult> GetCurrentGames(final CurrentGamesRequest request) {
        FutureTask<PlayFabResult<CurrentGamesResult>> task = new FutureTask(new Callable<PlayFabResult<CurrentGamesResult>>() {
            public PlayFabResult<CurrentGamesResult> call() throws Exception {
                return privateGetCurrentGamesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Get details about all current running game servers matching the given parameters. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CurrentGamesResult> privateGetCurrentGamesAsync(final CurrentGamesRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetCurrentGames"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CurrentGamesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CurrentGamesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CurrentGamesResult>>(){}.getType());
        CurrentGamesResult result = resultData.data;

        PlayFabResult<CurrentGamesResult> pfResult = new PlayFabResult<CurrentGamesResult>();
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
            return null;
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
            return null;
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
            return null;
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
     * Get details about the regions hosting game servers matching the given parameters.
     * @param request GameServerRegionsRequest
     * @return Async Task will return GameServerRegionsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GameServerRegionsResult>> GetGameServerRegionsAsync(final GameServerRegionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GameServerRegionsResult>>() {
            public PlayFabResult<GameServerRegionsResult> call() throws Exception {
                return privateGetGameServerRegionsAsync(request);
            }
        });
    }

    /**
     * Get details about the regions hosting game servers matching the given parameters.
     * @param request GameServerRegionsRequest
     * @return GameServerRegionsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GameServerRegionsResult> GetGameServerRegions(final GameServerRegionsRequest request) {
        FutureTask<PlayFabResult<GameServerRegionsResult>> task = new FutureTask(new Callable<PlayFabResult<GameServerRegionsResult>>() {
            public PlayFabResult<GameServerRegionsResult> call() throws Exception {
                return privateGetGameServerRegionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Get details about the regions hosting game servers matching the given parameters. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GameServerRegionsResult> privateGetGameServerRegionsAsync(final GameServerRegionsRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetGameServerRegions"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GameServerRegionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GameServerRegionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GameServerRegionsResult>>(){}.getType());
        GameServerRegionsResult result = resultData.data;

        PlayFabResult<GameServerRegionsResult> pfResult = new PlayFabResult<GameServerRegionsResult>();
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
     * For payments flows where the provider requires playfab (the fulfiller) to initiate the transaction, but the client
     * completes the rest of the flow. In the Xsolla case, the token returned here will be passed to Xsolla by the client to
     * create a cart. Poll GetPurchase using the returned OrderId once you've completed the payment.
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
     * For payments flows where the provider requires playfab (the fulfiller) to initiate the transaction, but the client
     * completes the rest of the flow. In the Xsolla case, the token returned here will be passed to Xsolla by the client to
     * create a cart. Poll GetPurchase using the returned OrderId once you've completed the payment.
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
            return null;
        }
    }

    /**
     * For payments flows where the provider requires playfab (the fulfiller) to initiate the transaction, but the client
     * completes the rest of the flow. In the Xsolla case, the token returned here will be passed to Xsolla by the client to
     * create a cart. Poll GetPurchase using the returned OrderId once you've completed the payment.
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
     * https://docs.microsoft.com/en-us/gaming/playfab/features/multiplayer/photon/quickstart for more details.
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
     * https://docs.microsoft.com/en-us/gaming/playfab/features/multiplayer/photon/quickstart for more details.
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
            return null;
        }
    }

    /**
     * Gets a Photon custom authentication token that can be used to securely join the player into a Photon room. See
     * https://docs.microsoft.com/en-us/gaming/playfab/features/multiplayer/photon/quickstart for more details.
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
     * Retrieves the unique PlayFab identifiers for the given set of Nintendo Switch identifiers.
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
     * Retrieves the unique PlayFab identifiers for the given set of Nintendo Switch identifiers.
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
            return null;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of Nintendo Switch identifiers. */
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
     * Retrieves the unique PlayFab identifiers for the given set of PlayStation Network identifiers.
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
     * Retrieves the unique PlayFab identifiers for the given set of PlayStation Network identifiers.
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
            return null;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of PlayStation Network identifiers. */
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
     * Retrieves a purchase along with its current PlayFab status. Returns inventory items from the purchase that are still
     * active.
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
     * Retrieves a purchase along with its current PlayFab status. Returns inventory items from the purchase that are still
     * active.
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
            return null;
        }
    }

    /**
     * Retrieves a purchase along with its current PlayFab status. Returns inventory items from the purchase that are still
     * active.
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
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
            return null;
        }
    }

    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. Non-members of the group
     * may use this to retrieve group data, including membership, but they will not receive data for keys marked as private.
     * Shared Groups are designed for sharing data between a very small number of players, please see our guide:
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * Retrieves the set of items defined for the specified store, including all prices defined
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
     * Retrieves the set of items defined for the specified store, including all prices defined
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
            return null;
        }
    }

    /** Retrieves the set of items defined for the specified store, including all prices defined */
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
     * Retrieves the user's current inventory of virtual goods
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
     * Retrieves the user's current inventory of virtual goods
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
            return null;
        }
    }

    /** Retrieves the user's current inventory of virtual goods */
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
            return null;
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
            return null;
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
            return null;
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
     * Requests a challenge from the server to be signed by Windows Hello Passport service to authenticate.
     * @param request GetWindowsHelloChallengeRequest
     * @return Async Task will return GetWindowsHelloChallengeResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetWindowsHelloChallengeResponse>> GetWindowsHelloChallengeAsync(final GetWindowsHelloChallengeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetWindowsHelloChallengeResponse>>() {
            public PlayFabResult<GetWindowsHelloChallengeResponse> call() throws Exception {
                return privateGetWindowsHelloChallengeAsync(request);
            }
        });
    }

    /**
     * Requests a challenge from the server to be signed by Windows Hello Passport service to authenticate.
     * @param request GetWindowsHelloChallengeRequest
     * @return GetWindowsHelloChallengeResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetWindowsHelloChallengeResponse> GetWindowsHelloChallenge(final GetWindowsHelloChallengeRequest request) {
        FutureTask<PlayFabResult<GetWindowsHelloChallengeResponse>> task = new FutureTask(new Callable<PlayFabResult<GetWindowsHelloChallengeResponse>>() {
            public PlayFabResult<GetWindowsHelloChallengeResponse> call() throws Exception {
                return privateGetWindowsHelloChallengeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Requests a challenge from the server to be signed by Windows Hello Passport service to authenticate. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetWindowsHelloChallengeResponse> privateGetWindowsHelloChallengeAsync(final GetWindowsHelloChallengeRequest request) throws Exception {

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/GetWindowsHelloChallenge"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetWindowsHelloChallengeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetWindowsHelloChallengeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetWindowsHelloChallengeResponse>>(){}.getType());
        GetWindowsHelloChallengeResponse result = resultData.data;

        PlayFabResult<GetWindowsHelloChallengeResponse> pfResult = new PlayFabResult<GetWindowsHelloChallengeResponse>();
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
     * Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account
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
     * Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account
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
            return null;
        }
    }

    /** Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account */
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
     * Links the PlayStation Network account associated with the provided access code to the user's PlayFab account
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
     * Links the PlayStation Network account associated with the provided access code to the user's PlayFab account
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
            return null;
        }
    }

    /** Links the PlayStation Network account associated with the provided access code to the user's PlayFab account */
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
            return null;
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
            return null;
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
     * Link Windows Hello authentication to the current PlayFab Account
     * @param request LinkWindowsHelloAccountRequest
     * @return Async Task will return LinkWindowsHelloAccountResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkWindowsHelloAccountResponse>> LinkWindowsHelloAsync(final LinkWindowsHelloAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkWindowsHelloAccountResponse>>() {
            public PlayFabResult<LinkWindowsHelloAccountResponse> call() throws Exception {
                return privateLinkWindowsHelloAsync(request);
            }
        });
    }

    /**
     * Link Windows Hello authentication to the current PlayFab Account
     * @param request LinkWindowsHelloAccountRequest
     * @return LinkWindowsHelloAccountResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkWindowsHelloAccountResponse> LinkWindowsHello(final LinkWindowsHelloAccountRequest request) {
        FutureTask<PlayFabResult<LinkWindowsHelloAccountResponse>> task = new FutureTask(new Callable<PlayFabResult<LinkWindowsHelloAccountResponse>>() {
            public PlayFabResult<LinkWindowsHelloAccountResponse> call() throws Exception {
                return privateLinkWindowsHelloAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Link Windows Hello authentication to the current PlayFab Account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkWindowsHelloAccountResponse> privateLinkWindowsHelloAsync(final LinkWindowsHelloAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LinkWindowsHello"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkWindowsHelloAccountResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkWindowsHelloAccountResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkWindowsHelloAccountResponse>>(){}.getType());
        LinkWindowsHelloAccountResponse result = resultData.data;

        PlayFabResult<LinkWindowsHelloAccountResponse> pfResult = new PlayFabResult<LinkWindowsHelloAccountResponse>();
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
            return null;
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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using an iOS Game Center player identifier, returning a session identifier that can subsequently be
     * used for API calls which require an authenticated user
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
     * used for API calls which require an authenticated user
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
            return null;
        }
    }

    /**
     * Signs the user in using an iOS Game Center player identifier, returning a session identifier that can subsequently be
     * used for API calls which require an authenticated user
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a PlayStation Network authentication code, returning a session identifier that can subsequently
     * be used for API calls which require an authenticated user
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
     * Signs the user in using a PlayStation Network authentication code, returning a session identifier that can subsequently
     * be used for API calls which require an authenticated user
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
            return null;
        }
    }

    /**
     * Signs the user in using a PlayStation Network authentication code, returning a session identifier that can subsequently
     * be used for API calls which require an authenticated user
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Completes the Windows Hello login flow by returning the signed value of the challange from GetWindowsHelloChallenge.
     * Windows Hello has a 2 step client to server authentication scheme. Step one is to request from the server a challenge
     * string. Step two is to request the user sign the string via Windows Hello and then send the signed value back to the
     * server.
     * @param request LoginWithWindowsHelloRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithWindowsHelloAsync(final LoginWithWindowsHelloRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithWindowsHelloAsync(request);
            }
        });
    }

    /**
     * Completes the Windows Hello login flow by returning the signed value of the challange from GetWindowsHelloChallenge.
     * Windows Hello has a 2 step client to server authentication scheme. Step one is to request from the server a challenge
     * string. Step two is to request the user sign the string via Windows Hello and then send the signed value back to the
     * server.
     * @param request LoginWithWindowsHelloRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> LoginWithWindowsHello(final LoginWithWindowsHelloRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithWindowsHelloAsync(request);
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
     * Completes the Windows Hello login flow by returning the signed value of the challange from GetWindowsHelloChallenge.
     * Windows Hello has a 2 step client to server authentication scheme. Step one is to request from the server a challenge
     * string. Step two is to request the user sign the string via Windows Hello and then send the signed value back to the
     * server.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateLoginWithWindowsHelloAsync(final LoginWithWindowsHelloRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/LoginWithWindowsHello"), request, null, null);
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

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
            return null;
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Attempts to locate a game session matching the given parameters. If the goal is to match the player into a specific
     * active session, only the LobbyId is required. Otherwise, the BuildVersion, GameMode, and Region are all required
     * parameters. Note that parameters specified in the search are required (they are not weighting factors). If a slot is
     * found in a server instance matching the parameters, the slot will be assigned to that player, removing it from the
     * availabe set. In that case, the information on the game session will be returned, otherwise the Status returned will be
     * GameNotFound.
     * @param request MatchmakeRequest
     * @return Async Task will return MatchmakeResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<MatchmakeResult>> MatchmakeAsync(final MatchmakeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<MatchmakeResult>>() {
            public PlayFabResult<MatchmakeResult> call() throws Exception {
                return privateMatchmakeAsync(request);
            }
        });
    }

    /**
     * Attempts to locate a game session matching the given parameters. If the goal is to match the player into a specific
     * active session, only the LobbyId is required. Otherwise, the BuildVersion, GameMode, and Region are all required
     * parameters. Note that parameters specified in the search are required (they are not weighting factors). If a slot is
     * found in a server instance matching the parameters, the slot will be assigned to that player, removing it from the
     * availabe set. In that case, the information on the game session will be returned, otherwise the Status returned will be
     * GameNotFound.
     * @param request MatchmakeRequest
     * @return MatchmakeResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<MatchmakeResult> Matchmake(final MatchmakeRequest request) {
        FutureTask<PlayFabResult<MatchmakeResult>> task = new FutureTask(new Callable<PlayFabResult<MatchmakeResult>>() {
            public PlayFabResult<MatchmakeResult> call() throws Exception {
                return privateMatchmakeAsync(request);
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
     * Attempts to locate a game session matching the given parameters. If the goal is to match the player into a specific
     * active session, only the LobbyId is required. Otherwise, the BuildVersion, GameMode, and Region are all required
     * parameters. Note that parameters specified in the search are required (they are not weighting factors). If a slot is
     * found in a server instance matching the parameters, the slot will be assigned to that player, removing it from the
     * availabe set. In that case, the information on the game session will be returned, otherwise the Status returned will be
     * GameNotFound.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<MatchmakeResult> privateMatchmakeAsync(final MatchmakeRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/Matchmake"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<MatchmakeResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<MatchmakeResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<MatchmakeResult>>(){}.getType());
        MatchmakeResult result = resultData.data;

        PlayFabResult<MatchmakeResult> pfResult = new PlayFabResult<MatchmakeResult>();
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
            return null;
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
     * Selects a payment option for purchase order created via StartPurchase
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
     * Selects a payment option for purchase order created via StartPurchase
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
            return null;
        }
    }

    /** Selects a payment option for purchase order created via StartPurchase */
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
     * Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as well as what
     * the client believes the price to be. This lets the server fail the purchase if the price has changed.
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
     * Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as well as what
     * the client believes the price to be. This lets the server fail the purchase if the price has changed.
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
            return null;
        }
    }

    /**
     * Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as well as what
     * the client believes the price to be. This lets the server fail the purchase if the price has changed.
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
     * Adds the virtual goods associated with the coupon to the user's inventory. Coupons can be generated via the
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
     * Adds the virtual goods associated with the coupon to the user's inventory. Coupons can be generated via the
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
            return null;
        }
    }

    /**
     * Adds the virtual goods associated with the coupon to the user's inventory. Coupons can be generated via the
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
     * Uses the supplied OAuth code to refresh the internally cached player PSN auth token
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
     * Uses the supplied OAuth code to refresh the internally cached player PSN auth token
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
            return null;
        }
    }

    /** Uses the supplied OAuth code to refresh the internally cached player PSN auth token */
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
            return null;
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
     * require an authenticated user. You must supply either a username or an email address.
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
     * require an authenticated user. You must supply either a username or an email address.
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
            return null;
        }
    }

    /**
     * Registers a new Playfab user account, returning a session identifier that can subsequently be used for API calls which
     * require an authenticated user. You must supply either a username or an email address.
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

        PlayFabResult<RegisterPlayFabUserResult> pfResult = new PlayFabResult<RegisterPlayFabUserResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Registers a new PlayFab user account using Windows Hello authentication, returning a session ticket that can
     * subsequently be used for API calls which require an authenticated user
     * @param request RegisterWithWindowsHelloRequest
     * @return Async Task will return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LoginResult>> RegisterWithWindowsHelloAsync(final RegisterWithWindowsHelloRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateRegisterWithWindowsHelloAsync(request);
            }
        });
    }

    /**
     * Registers a new PlayFab user account using Windows Hello authentication, returning a session ticket that can
     * subsequently be used for API calls which require an authenticated user
     * @param request RegisterWithWindowsHelloRequest
     * @return LoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LoginResult> RegisterWithWindowsHello(final RegisterWithWindowsHelloRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateRegisterWithWindowsHelloAsync(request);
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
     * Registers a new PlayFab user account using Windows Hello authentication, returning a session ticket that can
     * subsequently be used for API calls which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LoginResult> privateRegisterWithWindowsHelloAsync(final RegisterWithWindowsHelloRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
        if (request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/RegisterWithWindowsHello"), request, null, null);
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
        MultiStepClientLogin(resultData.data.SettingsForUser.NeedsAttribution);

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
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
            return null;
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
            return null;
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
            return null;
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
     * guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
            return null;
        }
    }

    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the
     * group can remove members. If as a result of the call, zero users remain with access, the group and its associated data
     * will be deleted. Shared Groups are designed for sharing data between a very small number of players, please see our
     * guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
            return null;
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
            return null;
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
     * Restores all in-app purchases based on the given restore receipt
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
     * Restores all in-app purchases based on the given restore receipt
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
            return null;
        }
    }

    /** Restores all in-app purchases based on the given restore receipt */
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
            return null;
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
            return null;
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
            return null;
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
     * Start a new game server with a given configuration, add the current player and return the connection information.
     * @param request StartGameRequest
     * @return Async Task will return StartGameResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<StartGameResult>> StartGameAsync(final StartGameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<StartGameResult>>() {
            public PlayFabResult<StartGameResult> call() throws Exception {
                return privateStartGameAsync(request);
            }
        });
    }

    /**
     * Start a new game server with a given configuration, add the current player and return the connection information.
     * @param request StartGameRequest
     * @return StartGameResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<StartGameResult> StartGame(final StartGameRequest request) {
        FutureTask<PlayFabResult<StartGameResult>> task = new FutureTask(new Callable<PlayFabResult<StartGameResult>>() {
            public PlayFabResult<StartGameResult> call() throws Exception {
                return privateStartGameAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Start a new game server with a given configuration, add the current player and return the connection information. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<StartGameResult> privateStartGameAsync(final StartGameRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/StartGame"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<StartGameResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<StartGameResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<StartGameResult>>(){}.getType());
        StartGameResult result = resultData.data;

        PlayFabResult<StartGameResult> pfResult = new PlayFabResult<StartGameResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates an order for a list of items from the title catalog
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
     * Creates an order for a list of items from the title catalog
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
            return null;
        }
    }

    /** Creates an order for a list of items from the title catalog */
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
     * Decrements the user's balance of the specified virtual currency by the stated amount. It is possible to make a VC
     * balance negative with this API.
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
     * Decrements the user's balance of the specified virtual currency by the stated amount. It is possible to make a VC
     * balance negative with this API.
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
            return null;
        }
    }

    /**
     * Decrements the user's balance of the specified virtual currency by the stated amount. It is possible to make a VC
     * balance negative with this API.
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
     * @param request UninkOpenIdConnectRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UnlinkOpenIdConnectAsync(final UninkOpenIdConnectRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkOpenIdConnectAsync(request);
            }
        });
    }

    /**
     * Unlinks an OpenID Connect account from a user's PlayFab account, based on the connection ID of an existing relationship
     * between a title and an Open ID Connect provider.
     * @param request UninkOpenIdConnectRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UnlinkOpenIdConnect(final UninkOpenIdConnectRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkOpenIdConnectAsync(request);
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
     * Unlinks an OpenID Connect account from a user's PlayFab account, based on the connection ID of an existing relationship
     * between a title and an Open ID Connect provider.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUnlinkOpenIdConnectAsync(final UninkOpenIdConnectRequest request) throws Exception {
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
     * Unlinks the related PSN account from the user's PlayFab account
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
     * Unlinks the related PSN account from the user's PlayFab account
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
            return null;
        }
    }

    /** Unlinks the related PSN account from the user's PlayFab account */
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
            return null;
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
            return null;
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
     * Unlink Windows Hello authentication from the current PlayFab Account
     * @param request UnlinkWindowsHelloAccountRequest
     * @return Async Task will return UnlinkWindowsHelloAccountResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkWindowsHelloAccountResponse>> UnlinkWindowsHelloAsync(final UnlinkWindowsHelloAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkWindowsHelloAccountResponse>>() {
            public PlayFabResult<UnlinkWindowsHelloAccountResponse> call() throws Exception {
                return privateUnlinkWindowsHelloAsync(request);
            }
        });
    }

    /**
     * Unlink Windows Hello authentication from the current PlayFab Account
     * @param request UnlinkWindowsHelloAccountRequest
     * @return UnlinkWindowsHelloAccountResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkWindowsHelloAccountResponse> UnlinkWindowsHello(final UnlinkWindowsHelloAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkWindowsHelloAccountResponse>> task = new FutureTask(new Callable<PlayFabResult<UnlinkWindowsHelloAccountResponse>>() {
            public PlayFabResult<UnlinkWindowsHelloAccountResponse> call() throws Exception {
                return privateUnlinkWindowsHelloAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Unlink Windows Hello authentication from the current PlayFab Account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkWindowsHelloAccountResponse> privateUnlinkWindowsHelloAsync(final UnlinkWindowsHelloAccountRequest request) throws Exception {
        if (PlayFabSettings.ClientSessionTicket == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Client/UnlinkWindowsHello"), request, "X-Authorization", PlayFabSettings.ClientSessionTicket);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkWindowsHelloAccountResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkWindowsHelloAccountResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkWindowsHelloAccountResponse>>(){}.getType());
        UnlinkWindowsHelloAccountResponse result = resultData.data;

        PlayFabResult<UnlinkWindowsHelloAccountResponse> pfResult = new PlayFabResult<UnlinkWindowsHelloAccountResponse>();
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
            return null;
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
     * Opens the specified container, with the specified key (when required), and returns the contents of the opened container.
     * If the container (and key when relevant) are consumable (RemainingUses &gt; 0), their RemainingUses will be decremented,
     * consistent with the operation of ConsumeItem.
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
     * Opens the specified container, with the specified key (when required), and returns the contents of the opened container.
     * If the container (and key when relevant) are consumable (RemainingUses &gt; 0), their RemainingUses will be decremented,
     * consistent with the operation of ConsumeItem.
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
            return null;
        }
    }

    /**
     * Opens the specified container, with the specified key (when required), and returns the contents of the opened container.
     * If the container (and key when relevant) are consumable (RemainingUses &gt; 0), their RemainingUses will be decremented,
     * consistent with the operation of ConsumeItem.
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
     * Searches target inventory for an ItemInstance matching the given CatalogItemId, if necessary unlocks it using an
     * appropriate key, and returns the contents of the opened container. If the container (and key when relevant) are
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
     * Searches target inventory for an ItemInstance matching the given CatalogItemId, if necessary unlocks it using an
     * appropriate key, and returns the contents of the opened container. If the container (and key when relevant) are
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
            return null;
        }
    }

    /**
     * Searches target inventory for an ItemInstance matching the given CatalogItemId, if necessary unlocks it using an
     * appropriate key, and returns the contents of the opened container. If the container (and key when relevant) are
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
            return null;
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
            return null;
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
            return null;
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
            return null;
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
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
            return null;
        }
    }

    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated
     * or added in this call will be readable by users not in the group. By default, data permissions are set to Private.
     * Regardless of the permission setting, only members of the group can update the data. Shared Groups are designed for
     * sharing data between a very small number of players, please see our guide:
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
            return null;
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
            return null;
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
            return null;
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
     * Validates with Amazon that the receipt for an Amazon App Store in-app purchase is valid and that it matches the
     * purchased catalog item
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
     * Validates with Amazon that the receipt for an Amazon App Store in-app purchase is valid and that it matches the
     * purchased catalog item
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
            return null;
        }
    }

    /**
     * Validates with Amazon that the receipt for an Amazon App Store in-app purchase is valid and that it matches the
     * purchased catalog item
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
     * Validates a Google Play purchase and gives the corresponding item to the player.
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
     * Validates a Google Play purchase and gives the corresponding item to the player.
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
            return null;
        }
    }

    /** Validates a Google Play purchase and gives the corresponding item to the player. */
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
     * Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the purchased
     * catalog item
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
     * Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the purchased
     * catalog item
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
            return null;
        }
    }

    /**
     * Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the purchased
     * catalog item
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
     * Validates with Windows that the receipt for an Windows App Store in-app purchase is valid and that it matches the
     * purchased catalog item
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
     * Validates with Windows that the receipt for an Windows App Store in-app purchase is valid and that it matches the
     * purchased catalog item
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
            return null;
        }
    }

    /**
     * Validates with Windows that the receipt for an Windows App Store in-app purchase is valid and that it matches the
     * purchased catalog item
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
            return null;
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
            return null;
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
            return null;
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

    public static void MultiStepClientLogin(Boolean needsAttribution) {
        if (needsAttribution && !PlayFabSettings.DisableAdvertising && PlayFabSettings.AdvertisingIdType != null && PlayFabSettings.AdvertisingIdValue != null) {
            PlayFabClientModels.AttributeInstallRequest request = new PlayFabClientModels.AttributeInstallRequest();
            if (PlayFabSettings.AdvertisingIdType == PlayFabSettings.AD_TYPE_IDFA)
                request.Idfa = PlayFabSettings.AdvertisingIdValue;
            else if (PlayFabSettings.AdvertisingIdType == PlayFabSettings.AD_TYPE_ANDROID_ID)
                request.Adid = PlayFabSettings.AdvertisingIdValue;
            else
                return;
            FutureTask<PlayFabResult<AttributeInstallResult>> task = AttributeInstallAsync(request);
            task.run();
        }
    }
}
