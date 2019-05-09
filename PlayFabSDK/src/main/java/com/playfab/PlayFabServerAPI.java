package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabServerModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /**
     * Provides functionality to allow external (developer-controlled) servers to interact with user inventories and data in a
     * trusted manner, and to handle matchmaking and client connection orchestration
     */
public class PlayFabServerAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Increments the character's balance of the specified virtual currency by the stated amount
     * @param request AddCharacterVirtualCurrencyRequest
     * @return Async Task will return ModifyCharacterVirtualCurrencyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyCharacterVirtualCurrencyResult>> AddCharacterVirtualCurrencyAsync(final AddCharacterVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyCharacterVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyCharacterVirtualCurrencyResult> call() throws Exception {
                return privateAddCharacterVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Increments the character's balance of the specified virtual currency by the stated amount
     * @param request AddCharacterVirtualCurrencyRequest
     * @return ModifyCharacterVirtualCurrencyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyCharacterVirtualCurrencyResult> AddCharacterVirtualCurrency(final AddCharacterVirtualCurrencyRequest request) {
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

    /** Increments the character's balance of the specified virtual currency by the stated amount */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyCharacterVirtualCurrencyResult> privateAddCharacterVirtualCurrencyAsync(final AddCharacterVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/AddCharacterVirtualCurrency"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Adds the Friend user to the friendlist of the user with PlayFabId. At least one of
     * FriendPlayFabId,FriendUsername,FriendEmail, or FriendTitleDisplayName should be initialized.
     * @param request AddFriendRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> AddFriendAsync(final AddFriendRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateAddFriendAsync(request);
            }
        });
    }

    /**
     * Adds the Friend user to the friendlist of the user with PlayFabId. At least one of
     * FriendPlayFabId,FriendUsername,FriendEmail, or FriendTitleDisplayName should be initialized.
     * @param request AddFriendRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> AddFriend(final AddFriendRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
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
     * Adds the Friend user to the friendlist of the user with PlayFabId. At least one of
     * FriendPlayFabId,FriendUsername,FriendEmail, or FriendTitleDisplayName should be initialized.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateAddFriendAsync(final AddFriendRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/AddFriend"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Adds the specified generic service identifier to the player's PlayFab account. This is designed to allow for a PlayFab
     * ID lookup of any arbitrary service identifier a title wants to add. This identifier should never be used as
     * authentication credentials, as the intent is that it is easily accessible by other players.
     * @param request AddGenericIDRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> AddGenericIDAsync(final AddGenericIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateAddGenericIDAsync(request);
            }
        });
    }

    /**
     * Adds the specified generic service identifier to the player's PlayFab account. This is designed to allow for a PlayFab
     * ID lookup of any arbitrary service identifier a title wants to add. This identifier should never be used as
     * authentication credentials, as the intent is that it is easily accessible by other players.
     * @param request AddGenericIDRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> AddGenericID(final AddGenericIDRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateAddGenericIDAsync(final AddGenericIDRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/AddGenericID"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Adds a given tag to a player profile. The tag's namespace is automatically generated based on the source of the tag.
     * @param request AddPlayerTagRequest
     * @return Async Task will return AddPlayerTagResult
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
     * @param request AddPlayerTagRequest
     * @return AddPlayerTagResult
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

    /** Adds a given tag to a player profile. The tag's namespace is automatically generated based on the source of the tag. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddPlayerTagResult> privateAddPlayerTagAsync(final AddPlayerTagRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/AddPlayerTag"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users
     * in the group (and the server) can add new members. Shared Groups are designed for sharing data between a very small
     * number of players, please see our guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * in the group (and the server) can add new members. Shared Groups are designed for sharing data between a very small
     * number of players, please see our guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * in the group (and the server) can add new members. Shared Groups are designed for sharing data between a very small
     * number of players, please see our guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddSharedGroupMembersResult> privateAddSharedGroupMembersAsync(final AddSharedGroupMembersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/AddSharedGroupMembers"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/AddUserVirtualCurrency"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Validated a client's session ticket, and if successful, returns details for that user
     * @param request AuthenticateSessionTicketRequest
     * @return Async Task will return AuthenticateSessionTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AuthenticateSessionTicketResult>> AuthenticateSessionTicketAsync(final AuthenticateSessionTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AuthenticateSessionTicketResult>>() {
            public PlayFabResult<AuthenticateSessionTicketResult> call() throws Exception {
                return privateAuthenticateSessionTicketAsync(request);
            }
        });
    }

    /**
     * Validated a client's session ticket, and if successful, returns details for that user
     * @param request AuthenticateSessionTicketRequest
     * @return AuthenticateSessionTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AuthenticateSessionTicketResult> AuthenticateSessionTicket(final AuthenticateSessionTicketRequest request) {
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

    /** Validated a client's session ticket, and if successful, returns details for that user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AuthenticateSessionTicketResult> privateAuthenticateSessionTicketAsync(final AuthenticateSessionTicketRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/AuthenticateSessionTicket"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Awards the specified users the specified Steam achievements
     * @param request AwardSteamAchievementRequest
     * @return Async Task will return AwardSteamAchievementResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AwardSteamAchievementResult>> AwardSteamAchievementAsync(final AwardSteamAchievementRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AwardSteamAchievementResult>>() {
            public PlayFabResult<AwardSteamAchievementResult> call() throws Exception {
                return privateAwardSteamAchievementAsync(request);
            }
        });
    }

    /**
     * Awards the specified users the specified Steam achievements
     * @param request AwardSteamAchievementRequest
     * @return AwardSteamAchievementResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AwardSteamAchievementResult> AwardSteamAchievement(final AwardSteamAchievementRequest request) {
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

    /** Awards the specified users the specified Steam achievements */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AwardSteamAchievementResult> privateAwardSteamAchievementAsync(final AwardSteamAchievementRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/AwardSteamAchievement"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Bans users by PlayFab ID with optional IP address, or MAC address for the provided game.
     * @param request BanUsersRequest
     * @return Async Task will return BanUsersResult
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
     * @param request BanUsersRequest
     * @return BanUsersResult
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

    /** Bans users by PlayFab ID with optional IP address, or MAC address for the provided game. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BanUsersResult> privateBanUsersAsync(final BanUsersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/BanUsers"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/ConsumeItem"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the
     * group. When created by a server, the group will initially have no members. Shared Groups are designed for sharing data
     * between a very small number of players, please see our guide:
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * group. When created by a server, the group will initially have no members. Shared Groups are designed for sharing data
     * between a very small number of players, please see our guide:
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * group. When created by a server, the group will initially have no members. Shared Groups are designed for sharing data
     * between a very small number of players, please see our guide:
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateSharedGroupResult> privateCreateSharedGroupAsync(final CreateSharedGroupRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/CreateSharedGroup"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Deletes the specific character ID from the specified user.
     * @param request DeleteCharacterFromUserRequest
     * @return Async Task will return DeleteCharacterFromUserResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteCharacterFromUserResult>> DeleteCharacterFromUserAsync(final DeleteCharacterFromUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteCharacterFromUserResult>>() {
            public PlayFabResult<DeleteCharacterFromUserResult> call() throws Exception {
                return privateDeleteCharacterFromUserAsync(request);
            }
        });
    }

    /**
     * Deletes the specific character ID from the specified user.
     * @param request DeleteCharacterFromUserRequest
     * @return DeleteCharacterFromUserResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteCharacterFromUserResult> DeleteCharacterFromUser(final DeleteCharacterFromUserRequest request) {
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

    /** Deletes the specific character ID from the specified user. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteCharacterFromUserResult> privateDeleteCharacterFromUserAsync(final DeleteCharacterFromUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/DeleteCharacterFromUser"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Removes a user's player account from a title and deletes all associated data
     * @param request DeletePlayerRequest
     * @return Async Task will return DeletePlayerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeletePlayerResult>> DeletePlayerAsync(final DeletePlayerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeletePlayerResult>>() {
            public PlayFabResult<DeletePlayerResult> call() throws Exception {
                return privateDeletePlayerAsync(request);
            }
        });
    }

    /**
     * Removes a user's player account from a title and deletes all associated data
     * @param request DeletePlayerRequest
     * @return DeletePlayerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeletePlayerResult> DeletePlayer(final DeletePlayerRequest request) {
        FutureTask<PlayFabResult<DeletePlayerResult>> task = new FutureTask(new Callable<PlayFabResult<DeletePlayerResult>>() {
            public PlayFabResult<DeletePlayerResult> call() throws Exception {
                return privateDeletePlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Removes a user's player account from a title and deletes all associated data */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeletePlayerResult> privateDeletePlayerAsync(final DeletePlayerRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/DeletePlayer"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeletePlayerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeletePlayerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeletePlayerResult>>(){}.getType());
        DeletePlayerResult result = resultData.data;

        PlayFabResult<DeletePlayerResult> pfResult = new PlayFabResult<DeletePlayerResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes push notification template for title
     * @param request DeletePushNotificationTemplateRequest
     * @return Async Task will return DeletePushNotificationTemplateResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeletePushNotificationTemplateResult>> DeletePushNotificationTemplateAsync(final DeletePushNotificationTemplateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeletePushNotificationTemplateResult>>() {
            public PlayFabResult<DeletePushNotificationTemplateResult> call() throws Exception {
                return privateDeletePushNotificationTemplateAsync(request);
            }
        });
    }

    /**
     * Deletes push notification template for title
     * @param request DeletePushNotificationTemplateRequest
     * @return DeletePushNotificationTemplateResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeletePushNotificationTemplateResult> DeletePushNotificationTemplate(final DeletePushNotificationTemplateRequest request) {
        FutureTask<PlayFabResult<DeletePushNotificationTemplateResult>> task = new FutureTask(new Callable<PlayFabResult<DeletePushNotificationTemplateResult>>() {
            public PlayFabResult<DeletePushNotificationTemplateResult> call() throws Exception {
                return privateDeletePushNotificationTemplateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Deletes push notification template for title */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeletePushNotificationTemplateResult> privateDeletePushNotificationTemplateAsync(final DeletePushNotificationTemplateRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/DeletePushNotificationTemplate"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeletePushNotificationTemplateResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeletePushNotificationTemplateResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeletePushNotificationTemplateResult>>(){}.getType());
        DeletePushNotificationTemplateResult result = resultData.data;

        PlayFabResult<DeletePushNotificationTemplateResult> pfResult = new PlayFabResult<DeletePushNotificationTemplateResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a shared group, freeing up the shared group ID to be reused for a new group. Shared Groups are designed for
     * sharing data between a very small number of players, please see our guide:
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
     * @param request DeleteSharedGroupRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteSharedGroupAsync(final DeleteSharedGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteSharedGroupAsync(request);
            }
        });
    }

    /**
     * Deletes a shared group, freeing up the shared group ID to be reused for a new group. Shared Groups are designed for
     * sharing data between a very small number of players, please see our guide:
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
     * @param request DeleteSharedGroupRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteSharedGroup(final DeleteSharedGroupRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
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
     * Deletes a shared group, freeing up the shared group ID to be reused for a new group. Shared Groups are designed for
     * sharing data between a very small number of players, please see our guide:
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteSharedGroupAsync(final DeleteSharedGroupRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/DeleteSharedGroup"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Inform the matchmaker that a Game Server Instance is removed.
     * @param request DeregisterGameRequest
     * @return Async Task will return DeregisterGameResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeregisterGameResponse>> DeregisterGameAsync(final DeregisterGameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeregisterGameResponse>>() {
            public PlayFabResult<DeregisterGameResponse> call() throws Exception {
                return privateDeregisterGameAsync(request);
            }
        });
    }

    /**
     * Inform the matchmaker that a Game Server Instance is removed.
     * @param request DeregisterGameRequest
     * @return DeregisterGameResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeregisterGameResponse> DeregisterGame(final DeregisterGameRequest request) {
        FutureTask<PlayFabResult<DeregisterGameResponse>> task = new FutureTask(new Callable<PlayFabResult<DeregisterGameResponse>>() {
            public PlayFabResult<DeregisterGameResponse> call() throws Exception {
                return privateDeregisterGameAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Inform the matchmaker that a Game Server Instance is removed. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeregisterGameResponse> privateDeregisterGameAsync(final DeregisterGameRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/DeregisterGame"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeregisterGameResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeregisterGameResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeregisterGameResponse>>(){}.getType());
        DeregisterGameResponse result = resultData.data;

        PlayFabResult<DeregisterGameResponse> pfResult = new PlayFabResult<DeregisterGameResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Returns the result of an evaluation of a Random Result Table - the ItemId from the game Catalog which would have been
     * added to the player inventory, if the Random Result Table were added via a Bundle or a call to UnlockContainer.
     * @param request EvaluateRandomResultTableRequest
     * @return Async Task will return EvaluateRandomResultTableResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EvaluateRandomResultTableResult>> EvaluateRandomResultTableAsync(final EvaluateRandomResultTableRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EvaluateRandomResultTableResult>>() {
            public PlayFabResult<EvaluateRandomResultTableResult> call() throws Exception {
                return privateEvaluateRandomResultTableAsync(request);
            }
        });
    }

    /**
     * Returns the result of an evaluation of a Random Result Table - the ItemId from the game Catalog which would have been
     * added to the player inventory, if the Random Result Table were added via a Bundle or a call to UnlockContainer.
     * @param request EvaluateRandomResultTableRequest
     * @return EvaluateRandomResultTableResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EvaluateRandomResultTableResult> EvaluateRandomResultTable(final EvaluateRandomResultTableRequest request) {
        FutureTask<PlayFabResult<EvaluateRandomResultTableResult>> task = new FutureTask(new Callable<PlayFabResult<EvaluateRandomResultTableResult>>() {
            public PlayFabResult<EvaluateRandomResultTableResult> call() throws Exception {
                return privateEvaluateRandomResultTableAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * Returns the result of an evaluation of a Random Result Table - the ItemId from the game Catalog which would have been
     * added to the player inventory, if the Random Result Table were added via a Bundle or a call to UnlockContainer.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EvaluateRandomResultTableResult> privateEvaluateRandomResultTableAsync(final EvaluateRandomResultTableRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/EvaluateRandomResultTable"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EvaluateRandomResultTableResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EvaluateRandomResultTableResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EvaluateRandomResultTableResult>>(){}.getType());
        EvaluateRandomResultTableResult result = resultData.data;

        PlayFabResult<EvaluateRandomResultTableResult> pfResult = new PlayFabResult<EvaluateRandomResultTableResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Executes a CloudScript function, with the 'currentPlayerId' variable set to the specified PlayFabId parameter value.
     * @param request ExecuteCloudScriptServerRequest
     * @return Async Task will return ExecuteCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ExecuteCloudScriptResult>> ExecuteCloudScriptAsync(final ExecuteCloudScriptServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ExecuteCloudScriptResult>>() {
            public PlayFabResult<ExecuteCloudScriptResult> call() throws Exception {
                return privateExecuteCloudScriptAsync(request);
            }
        });
    }

    /**
     * Executes a CloudScript function, with the 'currentPlayerId' variable set to the specified PlayFabId parameter value.
     * @param request ExecuteCloudScriptServerRequest
     * @return ExecuteCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ExecuteCloudScriptResult> ExecuteCloudScript(final ExecuteCloudScriptServerRequest request) {
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

    /** Executes a CloudScript function, with the 'currentPlayerId' variable set to the specified PlayFabId parameter value. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ExecuteCloudScriptResult> privateExecuteCloudScriptAsync(final ExecuteCloudScriptServerRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/ExecuteCloudScript"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves an array of player segment definitions. Results from this can be used in subsequent API calls such as
     * GetPlayersInSegment which requires a Segment ID. While segment names can change the ID for that segment will not change.
     * @param request GetAllSegmentsRequest
     * @return Async Task will return GetAllSegmentsResult
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
     * Retrieves an array of player segment definitions. Results from this can be used in subsequent API calls such as
     * GetPlayersInSegment which requires a Segment ID. While segment names can change the ID for that segment will not change.
     * @param request GetAllSegmentsRequest
     * @return GetAllSegmentsResult
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
     * Retrieves an array of player segment definitions. Results from this can be used in subsequent API calls such as
     * GetPlayersInSegment which requires a Segment ID. While segment names can change the ID for that segment will not change.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAllSegmentsResult> privateGetAllSegmentsAsync(final GetAllSegmentsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetAllSegments"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetAllUsersCharacters"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetCatalogItems"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
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
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
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

    /** Retrieves the title-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterDataAsync(final GetCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetCharacterData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the title-specific custom data for the user's character which cannot be accessed by the client
     * @param request GetCharacterDataRequest
     * @return Async Task will return GetCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCharacterDataResult>> GetCharacterInternalDataAsync(final GetCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user's character which cannot be accessed by the client
     * @param request GetCharacterDataRequest
     * @return GetCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCharacterDataResult> GetCharacterInternalData(final GetCharacterDataRequest request) {
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

    /** Retrieves the title-specific custom data for the user's character which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterInternalDataAsync(final GetCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetCharacterInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetCharacterInventory"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetCharacterLeaderboard"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the title-specific custom data for the user's character which can only be read by the client
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
     * Retrieves the title-specific custom data for the user's character which can only be read by the client
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

    /** Retrieves the title-specific custom data for the user's character which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterReadOnlyDataAsync(final GetCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetCharacterReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the details of all title-specific statistics for the specific character
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
     * Retrieves the details of all title-specific statistics for the specific character
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

    /** Retrieves the details of all title-specific statistics for the specific character */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCharacterStatisticsResult> privateGetCharacterStatisticsAsync(final GetCharacterStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetCharacterStatistics"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetContentDownloadUrl"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves a list of ranked friends of the given player for the given statistic, starting from the indicated point in the
     * leaderboard
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
     * Retrieves a list of ranked friends of the given player for the given statistic, starting from the indicated point in the
     * leaderboard
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
     * Retrieves a list of ranked friends of the given player for the given statistic, starting from the indicated point in the
     * leaderboard
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardResult> privateGetFriendLeaderboardAsync(final GetFriendLeaderboardRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetFriendLeaderboard"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the current friends for the user with PlayFabId, constrained to users who have PlayFab accounts. Friends from
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
     * Retrieves the current friends for the user with PlayFabId, constrained to users who have PlayFab accounts. Friends from
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
     * Retrieves the current friends for the user with PlayFabId, constrained to users who have PlayFab accounts. Friends from
     * linked accounts (Facebook, Steam) are also included. You may optionally exclude some linked services' friends.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetFriendsListResult> privateGetFriendsListAsync(final GetFriendsListRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetFriendsList"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
            return null;
        }
    }

    /** Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardResult> privateGetLeaderboardAsync(final GetLeaderboardRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetLeaderboard"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves a list of ranked characters for the given statistic, centered on the requested user
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
     * Retrieves a list of ranked characters for the given statistic, centered on the requested user
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

    /** Retrieves a list of ranked characters for the given statistic, centered on the requested user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardAroundCharacterResult> privateGetLeaderboardAroundCharacterAsync(final GetLeaderboardAroundCharacterRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetLeaderboardAroundCharacter"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user
     * @param request GetLeaderboardAroundUserRequest
     * @return Async Task will return GetLeaderboardAroundUserResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLeaderboardAroundUserResult>> GetLeaderboardAroundUserAsync(final GetLeaderboardAroundUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundUserResult>>() {
            public PlayFabResult<GetLeaderboardAroundUserResult> call() throws Exception {
                return privateGetLeaderboardAroundUserAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user
     * @param request GetLeaderboardAroundUserRequest
     * @return GetLeaderboardAroundUserResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLeaderboardAroundUserResult> GetLeaderboardAroundUser(final GetLeaderboardAroundUserRequest request) {
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

    /** Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardAroundUserResult> privateGetLeaderboardAroundUserAsync(final GetLeaderboardAroundUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetLeaderboardAroundUser"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetLeaderboardForUserCharacters"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Returns whatever info is requested in the response for the user. Note that PII (like email address, facebook id) may be
     * returned. All parameters default to false.
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
     * Returns whatever info is requested in the response for the user. Note that PII (like email address, facebook id) may be
     * returned. All parameters default to false.
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

    /**
     * Returns whatever info is requested in the response for the user. Note that PII (like email address, facebook id) may be
     * returned. All parameters default to false.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerCombinedInfoResult> privateGetPlayerCombinedInfoAsync(final GetPlayerCombinedInfoRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayerCombinedInfo"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayerProfile"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * @param request GetPlayersSegmentsRequest
     * @return Async Task will return GetPlayerSegmentsResult
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
     * @param request GetPlayersSegmentsRequest
     * @return GetPlayerSegmentsResult
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

    /** List all segments that a player currently belongs to at this moment in time. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerSegmentsResult> privateGetPlayerSegmentsAsync(final GetPlayersSegmentsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayerSegments"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Allows for paging through all players in a given segment. This API creates a snapshot of all player profiles that match
     * the segment definition at the time of its creation and lives through the Total Seconds to Live, refreshing its life span
     * on each subsequent use of the Continuation Token. Profiles that change during the course of paging will not be reflected
     * in the results. AB Test segments are currently not supported by this operation.
     * @param request GetPlayersInSegmentRequest
     * @return Async Task will return GetPlayersInSegmentResult
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
     * Allows for paging through all players in a given segment. This API creates a snapshot of all player profiles that match
     * the segment definition at the time of its creation and lives through the Total Seconds to Live, refreshing its life span
     * on each subsequent use of the Continuation Token. Profiles that change during the course of paging will not be reflected
     * in the results. AB Test segments are currently not supported by this operation.
     * @param request GetPlayersInSegmentRequest
     * @return GetPlayersInSegmentResult
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
     * Allows for paging through all players in a given segment. This API creates a snapshot of all player profiles that match
     * the segment definition at the time of its creation and lives through the Total Seconds to Live, refreshing its life span
     * on each subsequent use of the Continuation Token. Profiles that change during the course of paging will not be reflected
     * in the results. AB Test segments are currently not supported by this operation.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayersInSegmentResult> privateGetPlayersInSegmentAsync(final GetPlayersInSegmentRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayersInSegment"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves the current version and values for the indicated statistics, for the local player.
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
     * Retrieves the current version and values for the indicated statistics, for the local player.
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

    /** Retrieves the current version and values for the indicated statistics, for the local player. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerStatisticsResult> privateGetPlayerStatisticsAsync(final GetPlayerStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayerStatistics"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayerStatisticVersions"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayerTags"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayFabIDsFromFacebookIDs"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the unique PlayFab identifiers for the given set of Facebook Instant Games identifiers.
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
     * Retrieves the unique PlayFab identifiers for the given set of Facebook Instant Games identifiers.
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

    /** Retrieves the unique PlayFab identifiers for the given set of Facebook Instant Games identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromFacebookInstantGamesIdsResult> privateGetPlayFabIDsFromFacebookInstantGamesIdsAsync(final GetPlayFabIDsFromFacebookInstantGamesIdsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayFabIDsFromFacebookInstantGamesIds"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayFabIDsFromGenericIDs"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
            return null;
        }
    }

    /** Retrieves the unique PlayFab identifiers for the given set of Nintendo Switch Device identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayFabIDsFromNintendoSwitchDeviceIdsResult> privateGetPlayFabIDsFromNintendoSwitchDeviceIdsAsync(final GetPlayFabIDsFromNintendoSwitchDeviceIdsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayFabIDsFromNintendoSwitchDeviceIds"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayFabIDsFromPSNAccountIDs"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayFabIDsFromSteamIDs"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPlayFabIDsFromXboxLiveIDs"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetPublisherData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the configuration information for the specified random results tables for the title, including all ItemId
     * values and weights
     * @param request GetRandomResultTablesRequest
     * @return Async Task will return GetRandomResultTablesResult
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
     * Retrieves the configuration information for the specified random results tables for the title, including all ItemId
     * values and weights
     * @param request GetRandomResultTablesRequest
     * @return GetRandomResultTablesResult
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
     * Retrieves the configuration information for the specified random results tables for the title, including all ItemId
     * values and weights
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetRandomResultTablesResult> privateGetRandomResultTablesAsync(final GetRandomResultTablesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetRandomResultTables"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Retrieves the associated PlayFab account identifiers for the given set of server custom identifiers.
     * @param request GetServerCustomIDsFromPlayFabIDsRequest
     * @return Async Task will return GetServerCustomIDsFromPlayFabIDsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult>> GetServerCustomIDsFromPlayFabIDsAsync(final GetServerCustomIDsFromPlayFabIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult>>() {
            public PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult> call() throws Exception {
                return privateGetServerCustomIDsFromPlayFabIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the associated PlayFab account identifiers for the given set of server custom identifiers.
     * @param request GetServerCustomIDsFromPlayFabIDsRequest
     * @return GetServerCustomIDsFromPlayFabIDsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult> GetServerCustomIDsFromPlayFabIDs(final GetServerCustomIDsFromPlayFabIDsRequest request) {
        FutureTask<PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult>>() {
            public PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult> call() throws Exception {
                return privateGetServerCustomIDsFromPlayFabIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves the associated PlayFab account identifiers for the given set of server custom identifiers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult> privateGetServerCustomIDsFromPlayFabIDsAsync(final GetServerCustomIDsFromPlayFabIDsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetServerCustomIDsFromPlayFabIDs"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetServerCustomIDsFromPlayFabIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetServerCustomIDsFromPlayFabIDsResult>>(){}.getType());
        GetServerCustomIDsFromPlayFabIDsResult result = resultData.data;

        PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult> pfResult = new PlayFabResult<GetServerCustomIDsFromPlayFabIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. The server can access all
     * public and private group data. Shared Groups are designed for sharing data between a very small number of players,
     * please see our guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * Retrieves data stored in a shared group object, as well as the list of members in the group. The server can access all
     * public and private group data. Shared Groups are designed for sharing data between a very small number of players,
     * please see our guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
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
     * Retrieves data stored in a shared group object, as well as the list of members in the group. The server can access all
     * public and private group data. Shared Groups are designed for sharing data between a very small number of players,
     * please see our guide: https://api.playfab.com/docs/tutorials/landing-players/shared-groups
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetSharedGroupDataResult> privateGetSharedGroupDataAsync(final GetSharedGroupDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetSharedGroupData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetTime"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetTitleData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the key-value store of custom internal title settings
     * @param request GetTitleDataRequest
     * @return Async Task will return GetTitleDataResult
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
     * Retrieves the key-value store of custom internal title settings
     * @param request GetTitleDataRequest
     * @return GetTitleDataResult
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

    /** Retrieves the key-value store of custom internal title settings */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleDataResult> privateGetTitleInternalDataAsync(final GetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetTitleInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetTitleNews"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the relevant details for a specified user
     * @param request GetUserAccountInfoRequest
     * @return Async Task will return GetUserAccountInfoResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserAccountInfoResult>> GetUserAccountInfoAsync(final GetUserAccountInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserAccountInfoResult>>() {
            public PlayFabResult<GetUserAccountInfoResult> call() throws Exception {
                return privateGetUserAccountInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the relevant details for a specified user
     * @param request GetUserAccountInfoRequest
     * @return GetUserAccountInfoResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserAccountInfoResult> GetUserAccountInfo(final GetUserAccountInfoRequest request) {
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

    /** Retrieves the relevant details for a specified user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserAccountInfoResult> privateGetUserAccountInfoAsync(final GetUserAccountInfoRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetUserAccountInfo"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Gets all bans for a user.
     * @param request GetUserBansRequest
     * @return Async Task will return GetUserBansResult
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
     * @param request GetUserBansRequest
     * @return GetUserBansResult
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

    /** Gets all bans for a user. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserBansResult> privateGetUserBansAsync(final GetUserBansRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetUserBans"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetUserData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the title-specific custom data for the user which cannot be accessed by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
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
     * @param request GetUserDataRequest
     * @return GetUserDataResult
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

    /** Retrieves the title-specific custom data for the user which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserInternalDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetUserInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the specified user's current inventory of virtual goods
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
     * Retrieves the specified user's current inventory of virtual goods
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

    /** Retrieves the specified user's current inventory of virtual goods */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserInventoryResult> privateGetUserInventoryAsync(final GetUserInventoryRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetUserInventory"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetUserPublisherData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Retrieves the publisher-specific custom data for the user which cannot be accessed by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
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
     * @param request GetUserDataRequest
     * @return GetUserDataResult
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

    /** Retrieves the publisher-specific custom data for the user which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherInternalDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetUserPublisherInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetUserPublisherReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GetUserReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
            return null;
        }
    }

    /**
     * Grants the specified character type to the user. CharacterIds are not globally unique; characterId must be evaluated
     * with the parent PlayFabId to guarantee uniqueness.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GrantCharacterToUserResult> privateGrantCharacterToUserAsync(final GrantCharacterToUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GrantCharacterToUser"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Adds the specified items to the specified character's inventory
     * @param request GrantItemsToCharacterRequest
     * @return Async Task will return GrantItemsToCharacterResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GrantItemsToCharacterResult>> GrantItemsToCharacterAsync(final GrantItemsToCharacterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantItemsToCharacterResult>>() {
            public PlayFabResult<GrantItemsToCharacterResult> call() throws Exception {
                return privateGrantItemsToCharacterAsync(request);
            }
        });
    }

    /**
     * Adds the specified items to the specified character's inventory
     * @param request GrantItemsToCharacterRequest
     * @return GrantItemsToCharacterResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GrantItemsToCharacterResult> GrantItemsToCharacter(final GrantItemsToCharacterRequest request) {
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

    /** Adds the specified items to the specified character's inventory */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GrantItemsToCharacterResult> privateGrantItemsToCharacterAsync(final GrantItemsToCharacterRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GrantItemsToCharacter"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request GrantItemsToUserRequest
     * @return Async Task will return GrantItemsToUserResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GrantItemsToUserResult>> GrantItemsToUserAsync(final GrantItemsToUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantItemsToUserResult>>() {
            public PlayFabResult<GrantItemsToUserResult> call() throws Exception {
                return privateGrantItemsToUserAsync(request);
            }
        });
    }

    /**
     * Adds the specified items to the specified user's inventory
     * @param request GrantItemsToUserRequest
     * @return GrantItemsToUserResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GrantItemsToUserResult> GrantItemsToUser(final GrantItemsToUserRequest request) {
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

    /** Adds the specified items to the specified user's inventory */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GrantItemsToUserResult> privateGrantItemsToUserAsync(final GrantItemsToUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GrantItemsToUser"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request GrantItemsToUsersRequest
     * @return Async Task will return GrantItemsToUsersResult
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
     * @param request GrantItemsToUsersRequest
     * @return GrantItemsToUsersResult
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

    /** Adds the specified items to the specified user inventories */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GrantItemsToUsersResult> privateGrantItemsToUsersAsync(final GrantItemsToUsersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/GrantItemsToUsers"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Links the custom server identifier, generated by the title, to the user's PlayFab account.
     * @param request LinkServerCustomIdRequest
     * @return Async Task will return LinkServerCustomIdResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LinkServerCustomIdResult>> LinkServerCustomIdAsync(final LinkServerCustomIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkServerCustomIdResult>>() {
            public PlayFabResult<LinkServerCustomIdResult> call() throws Exception {
                return privateLinkServerCustomIdAsync(request);
            }
        });
    }

    /**
     * Links the custom server identifier, generated by the title, to the user's PlayFab account.
     * @param request LinkServerCustomIdRequest
     * @return LinkServerCustomIdResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LinkServerCustomIdResult> LinkServerCustomId(final LinkServerCustomIdRequest request) {
        FutureTask<PlayFabResult<LinkServerCustomIdResult>> task = new FutureTask(new Callable<PlayFabResult<LinkServerCustomIdResult>>() {
            public PlayFabResult<LinkServerCustomIdResult> call() throws Exception {
                return privateLinkServerCustomIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Links the custom server identifier, generated by the title, to the user's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LinkServerCustomIdResult> privateLinkServerCustomIdAsync(final LinkServerCustomIdRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/LinkServerCustomId"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkServerCustomIdResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LinkServerCustomIdResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkServerCustomIdResult>>(){}.getType());
        LinkServerCustomIdResult result = resultData.data;

        PlayFabResult<LinkServerCustomIdResult> pfResult = new PlayFabResult<LinkServerCustomIdResult>();
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/LinkXboxAccount"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Securely login a game client from an external server backend using a custom identifier for that player. Server Custom ID
     * and Client Custom ID are mutually exclusive and cannot be used to retrieve the same player account.
     * @param request LoginWithServerCustomIdRequest
     * @return Async Task will return ServerLoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ServerLoginResult>> LoginWithServerCustomIdAsync(final LoginWithServerCustomIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ServerLoginResult>>() {
            public PlayFabResult<ServerLoginResult> call() throws Exception {
                return privateLoginWithServerCustomIdAsync(request);
            }
        });
    }

    /**
     * Securely login a game client from an external server backend using a custom identifier for that player. Server Custom ID
     * and Client Custom ID are mutually exclusive and cannot be used to retrieve the same player account.
     * @param request LoginWithServerCustomIdRequest
     * @return ServerLoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ServerLoginResult> LoginWithServerCustomId(final LoginWithServerCustomIdRequest request) {
        FutureTask<PlayFabResult<ServerLoginResult>> task = new FutureTask(new Callable<PlayFabResult<ServerLoginResult>>() {
            public PlayFabResult<ServerLoginResult> call() throws Exception {
                return privateLoginWithServerCustomIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * Securely login a game client from an external server backend using a custom identifier for that player. Server Custom ID
     * and Client Custom ID are mutually exclusive and cannot be used to retrieve the same player account.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ServerLoginResult> privateLoginWithServerCustomIdAsync(final LoginWithServerCustomIdRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/LoginWithServerCustomId"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ServerLoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ServerLoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ServerLoginResult>>(){}.getType());
        ServerLoginResult result = resultData.data;

        PlayFabResult<ServerLoginResult> pfResult = new PlayFabResult<ServerLoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Signs the user in using a Xbox Live Token from an external server backend, returning a session identifier that can
     * subsequently be used for API calls which require an authenticated user
     * @param request LoginWithXboxRequest
     * @return Async Task will return ServerLoginResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ServerLoginResult>> LoginWithXboxAsync(final LoginWithXboxRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ServerLoginResult>>() {
            public PlayFabResult<ServerLoginResult> call() throws Exception {
                return privateLoginWithXboxAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Xbox Live Token from an external server backend, returning a session identifier that can
     * subsequently be used for API calls which require an authenticated user
     * @param request LoginWithXboxRequest
     * @return ServerLoginResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ServerLoginResult> LoginWithXbox(final LoginWithXboxRequest request) {
        FutureTask<PlayFabResult<ServerLoginResult>> task = new FutureTask(new Callable<PlayFabResult<ServerLoginResult>>() {
            public PlayFabResult<ServerLoginResult> call() throws Exception {
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
     * Signs the user in using a Xbox Live Token from an external server backend, returning a session identifier that can
     * subsequently be used for API calls which require an authenticated user
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ServerLoginResult> privateLoginWithXboxAsync(final LoginWithXboxRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/LoginWithXbox"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ServerLoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ServerLoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ServerLoginResult>>(){}.getType());
        ServerLoginResult result = resultData.data;

        PlayFabResult<ServerLoginResult> pfResult = new PlayFabResult<ServerLoginResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Modifies the number of remaining uses of a player's inventory item
     * @param request ModifyItemUsesRequest
     * @return Async Task will return ModifyItemUsesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyItemUsesResult>> ModifyItemUsesAsync(final ModifyItemUsesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyItemUsesResult>>() {
            public PlayFabResult<ModifyItemUsesResult> call() throws Exception {
                return privateModifyItemUsesAsync(request);
            }
        });
    }

    /**
     * Modifies the number of remaining uses of a player's inventory item
     * @param request ModifyItemUsesRequest
     * @return ModifyItemUsesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyItemUsesResult> ModifyItemUses(final ModifyItemUsesRequest request) {
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

    /** Modifies the number of remaining uses of a player's inventory item */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyItemUsesResult> privateModifyItemUsesAsync(final ModifyItemUsesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/ModifyItemUses"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request MoveItemToCharacterFromCharacterRequest
     * @return Async Task will return MoveItemToCharacterFromCharacterResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<MoveItemToCharacterFromCharacterResult>> MoveItemToCharacterFromCharacterAsync(final MoveItemToCharacterFromCharacterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<MoveItemToCharacterFromCharacterResult>>() {
            public PlayFabResult<MoveItemToCharacterFromCharacterResult> call() throws Exception {
                return privateMoveItemToCharacterFromCharacterAsync(request);
            }
        });
    }

    /**
     * Moves an item from a character's inventory into another of the users's character's inventory.
     * @param request MoveItemToCharacterFromCharacterRequest
     * @return MoveItemToCharacterFromCharacterResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<MoveItemToCharacterFromCharacterResult> MoveItemToCharacterFromCharacter(final MoveItemToCharacterFromCharacterRequest request) {
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

    /** Moves an item from a character's inventory into another of the users's character's inventory. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<MoveItemToCharacterFromCharacterResult> privateMoveItemToCharacterFromCharacterAsync(final MoveItemToCharacterFromCharacterRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/MoveItemToCharacterFromCharacter"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request MoveItemToCharacterFromUserRequest
     * @return Async Task will return MoveItemToCharacterFromUserResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<MoveItemToCharacterFromUserResult>> MoveItemToCharacterFromUserAsync(final MoveItemToCharacterFromUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<MoveItemToCharacterFromUserResult>>() {
            public PlayFabResult<MoveItemToCharacterFromUserResult> call() throws Exception {
                return privateMoveItemToCharacterFromUserAsync(request);
            }
        });
    }

    /**
     * Moves an item from a user's inventory into their character's inventory.
     * @param request MoveItemToCharacterFromUserRequest
     * @return MoveItemToCharacterFromUserResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<MoveItemToCharacterFromUserResult> MoveItemToCharacterFromUser(final MoveItemToCharacterFromUserRequest request) {
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

    /** Moves an item from a user's inventory into their character's inventory. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<MoveItemToCharacterFromUserResult> privateMoveItemToCharacterFromUserAsync(final MoveItemToCharacterFromUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/MoveItemToCharacterFromUser"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request MoveItemToUserFromCharacterRequest
     * @return Async Task will return MoveItemToUserFromCharacterResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<MoveItemToUserFromCharacterResult>> MoveItemToUserFromCharacterAsync(final MoveItemToUserFromCharacterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<MoveItemToUserFromCharacterResult>>() {
            public PlayFabResult<MoveItemToUserFromCharacterResult> call() throws Exception {
                return privateMoveItemToUserFromCharacterAsync(request);
            }
        });
    }

    /**
     * Moves an item from a character's inventory into the owning user's inventory.
     * @param request MoveItemToUserFromCharacterRequest
     * @return MoveItemToUserFromCharacterResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<MoveItemToUserFromCharacterResult> MoveItemToUserFromCharacter(final MoveItemToUserFromCharacterRequest request) {
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

    /** Moves an item from a character's inventory into the owning user's inventory. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<MoveItemToUserFromCharacterResult> privateMoveItemToUserFromCharacterAsync(final MoveItemToUserFromCharacterRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/MoveItemToUserFromCharacter"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Informs the PlayFab match-making service that the user specified has left the Game Server Instance
     * @param request NotifyMatchmakerPlayerLeftRequest
     * @return Async Task will return NotifyMatchmakerPlayerLeftResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<NotifyMatchmakerPlayerLeftResult>> NotifyMatchmakerPlayerLeftAsync(final NotifyMatchmakerPlayerLeftRequest request) {
        return new FutureTask(new Callable<PlayFabResult<NotifyMatchmakerPlayerLeftResult>>() {
            public PlayFabResult<NotifyMatchmakerPlayerLeftResult> call() throws Exception {
                return privateNotifyMatchmakerPlayerLeftAsync(request);
            }
        });
    }

    /**
     * Informs the PlayFab match-making service that the user specified has left the Game Server Instance
     * @param request NotifyMatchmakerPlayerLeftRequest
     * @return NotifyMatchmakerPlayerLeftResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<NotifyMatchmakerPlayerLeftResult> NotifyMatchmakerPlayerLeft(final NotifyMatchmakerPlayerLeftRequest request) {
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

    /** Informs the PlayFab match-making service that the user specified has left the Game Server Instance */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<NotifyMatchmakerPlayerLeftResult> privateNotifyMatchmakerPlayerLeftAsync(final NotifyMatchmakerPlayerLeftRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/NotifyMatchmakerPlayerLeft"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RedeemCoupon"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Validates a Game Server session ticket and returns details about the user
     * @param request RedeemMatchmakerTicketRequest
     * @return Async Task will return RedeemMatchmakerTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RedeemMatchmakerTicketResult>> RedeemMatchmakerTicketAsync(final RedeemMatchmakerTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemMatchmakerTicketResult>>() {
            public PlayFabResult<RedeemMatchmakerTicketResult> call() throws Exception {
                return privateRedeemMatchmakerTicketAsync(request);
            }
        });
    }

    /**
     * Validates a Game Server session ticket and returns details about the user
     * @param request RedeemMatchmakerTicketRequest
     * @return RedeemMatchmakerTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RedeemMatchmakerTicketResult> RedeemMatchmakerTicket(final RedeemMatchmakerTicketRequest request) {
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

    /** Validates a Game Server session ticket and returns details about the user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RedeemMatchmakerTicketResult> privateRedeemMatchmakerTicketAsync(final RedeemMatchmakerTicketRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RedeemMatchmakerTicket"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Set the state of the indicated Game Server Instance. Also update the heartbeat for the instance.
     * @param request RefreshGameServerInstanceHeartbeatRequest
     * @return Async Task will return RefreshGameServerInstanceHeartbeatResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RefreshGameServerInstanceHeartbeatResult>> RefreshGameServerInstanceHeartbeatAsync(final RefreshGameServerInstanceHeartbeatRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RefreshGameServerInstanceHeartbeatResult>>() {
            public PlayFabResult<RefreshGameServerInstanceHeartbeatResult> call() throws Exception {
                return privateRefreshGameServerInstanceHeartbeatAsync(request);
            }
        });
    }

    /**
     * Set the state of the indicated Game Server Instance. Also update the heartbeat for the instance.
     * @param request RefreshGameServerInstanceHeartbeatRequest
     * @return RefreshGameServerInstanceHeartbeatResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RefreshGameServerInstanceHeartbeatResult> RefreshGameServerInstanceHeartbeat(final RefreshGameServerInstanceHeartbeatRequest request) {
        FutureTask<PlayFabResult<RefreshGameServerInstanceHeartbeatResult>> task = new FutureTask(new Callable<PlayFabResult<RefreshGameServerInstanceHeartbeatResult>>() {
            public PlayFabResult<RefreshGameServerInstanceHeartbeatResult> call() throws Exception {
                return privateRefreshGameServerInstanceHeartbeatAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Set the state of the indicated Game Server Instance. Also update the heartbeat for the instance. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RefreshGameServerInstanceHeartbeatResult> privateRefreshGameServerInstanceHeartbeatAsync(final RefreshGameServerInstanceHeartbeatRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RefreshGameServerInstanceHeartbeat"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RefreshGameServerInstanceHeartbeatResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RefreshGameServerInstanceHeartbeatResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RefreshGameServerInstanceHeartbeatResult>>(){}.getType());
        RefreshGameServerInstanceHeartbeatResult result = resultData.data;

        PlayFabResult<RefreshGameServerInstanceHeartbeatResult> pfResult = new PlayFabResult<RefreshGameServerInstanceHeartbeatResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Inform the matchmaker that a new Game Server Instance is added.
     * @param request RegisterGameRequest
     * @return Async Task will return RegisterGameResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RegisterGameResponse>> RegisterGameAsync(final RegisterGameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RegisterGameResponse>>() {
            public PlayFabResult<RegisterGameResponse> call() throws Exception {
                return privateRegisterGameAsync(request);
            }
        });
    }

    /**
     * Inform the matchmaker that a new Game Server Instance is added.
     * @param request RegisterGameRequest
     * @return RegisterGameResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RegisterGameResponse> RegisterGame(final RegisterGameRequest request) {
        FutureTask<PlayFabResult<RegisterGameResponse>> task = new FutureTask(new Callable<PlayFabResult<RegisterGameResponse>>() {
            public PlayFabResult<RegisterGameResponse> call() throws Exception {
                return privateRegisterGameAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Inform the matchmaker that a new Game Server Instance is added. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RegisterGameResponse> privateRegisterGameAsync(final RegisterGameRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RegisterGame"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RegisterGameResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RegisterGameResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RegisterGameResponse>>(){}.getType());
        RegisterGameResponse result = resultData.data;

        PlayFabResult<RegisterGameResponse> pfResult = new PlayFabResult<RegisterGameResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes the specified friend from the the user's friend list
     * @param request RemoveFriendRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> RemoveFriendAsync(final RemoveFriendRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateRemoveFriendAsync(request);
            }
        });
    }

    /**
     * Removes the specified friend from the the user's friend list
     * @param request RemoveFriendRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> RemoveFriend(final RemoveFriendRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
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

    /** Removes the specified friend from the the user's friend list */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateRemoveFriendAsync(final RemoveFriendRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RemoveFriend"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Removes the specified generic service identifier from the player's PlayFab account.
     * @param request RemoveGenericIDRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> RemoveGenericIDAsync(final RemoveGenericIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRemoveGenericIDAsync(request);
            }
        });
    }

    /**
     * Removes the specified generic service identifier from the player's PlayFab account.
     * @param request RemoveGenericIDRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> RemoveGenericID(final RemoveGenericIDRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateRemoveGenericIDAsync(final RemoveGenericIDRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RemoveGenericID"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Remove a given tag from a player profile. The tag's namespace is automatically generated based on the source of the tag.
     * @param request RemovePlayerTagRequest
     * @return Async Task will return RemovePlayerTagResult
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
     * @param request RemovePlayerTagRequest
     * @return RemovePlayerTagResult
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

    /** Remove a given tag from a player profile. The tag's namespace is automatically generated based on the source of the tag. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RemovePlayerTagResult> privateRemovePlayerTagAsync(final RemovePlayerTagRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RemovePlayerTag"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RemoveSharedGroupMembers"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Submit a report about a player (due to bad bahavior, etc.) on behalf of another player, so that customer service
     * representatives for the title can take action concerning potentially toxic players.
     * @param request ReportPlayerServerRequest
     * @return Async Task will return ReportPlayerServerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ReportPlayerServerResult>> ReportPlayerAsync(final ReportPlayerServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReportPlayerServerResult>>() {
            public PlayFabResult<ReportPlayerServerResult> call() throws Exception {
                return privateReportPlayerAsync(request);
            }
        });
    }

    /**
     * Submit a report about a player (due to bad bahavior, etc.) on behalf of another player, so that customer service
     * representatives for the title can take action concerning potentially toxic players.
     * @param request ReportPlayerServerRequest
     * @return ReportPlayerServerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ReportPlayerServerResult> ReportPlayer(final ReportPlayerServerRequest request) {
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
     * Submit a report about a player (due to bad bahavior, etc.) on behalf of another player, so that customer service
     * representatives for the title can take action concerning potentially toxic players.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ReportPlayerServerResult> privateReportPlayerAsync(final ReportPlayerServerRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/ReportPlayer"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Revoke all active bans for a user.
     * @param request RevokeAllBansForUserRequest
     * @return Async Task will return RevokeAllBansForUserResult
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
     * @param request RevokeAllBansForUserRequest
     * @return RevokeAllBansForUserResult
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

    /** Revoke all active bans for a user. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeAllBansForUserResult> privateRevokeAllBansForUserAsync(final RevokeAllBansForUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RevokeAllBansForUser"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request RevokeBansRequest
     * @return Async Task will return RevokeBansResult
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
     * @param request RevokeBansRequest
     * @return RevokeBansResult
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

    /** Revoke all active bans specified with BanId. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeBansResult> privateRevokeBansAsync(final RevokeBansRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RevokeBans"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Revokes access to an item in a user's inventory
     * @param request RevokeInventoryItemRequest
     * @return Async Task will return RevokeInventoryResult
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
     * @param request RevokeInventoryItemRequest
     * @return RevokeInventoryResult
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

    /** Revokes access to an item in a user's inventory */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeInventoryResult> privateRevokeInventoryItemAsync(final RevokeInventoryItemRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RevokeInventoryItem"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Revokes access for up to 25 items across multiple users and characters.
     * @param request RevokeInventoryItemsRequest
     * @return Async Task will return RevokeInventoryItemsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RevokeInventoryItemsResult>> RevokeInventoryItemsAsync(final RevokeInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RevokeInventoryItemsResult>>() {
            public PlayFabResult<RevokeInventoryItemsResult> call() throws Exception {
                return privateRevokeInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Revokes access for up to 25 items across multiple users and characters.
     * @param request RevokeInventoryItemsRequest
     * @return RevokeInventoryItemsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RevokeInventoryItemsResult> RevokeInventoryItems(final RevokeInventoryItemsRequest request) {
        FutureTask<PlayFabResult<RevokeInventoryItemsResult>> task = new FutureTask(new Callable<PlayFabResult<RevokeInventoryItemsResult>>() {
            public PlayFabResult<RevokeInventoryItemsResult> call() throws Exception {
                return privateRevokeInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Revokes access for up to 25 items across multiple users and characters. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeInventoryItemsResult> privateRevokeInventoryItemsAsync(final RevokeInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/RevokeInventoryItems"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RevokeInventoryItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RevokeInventoryItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RevokeInventoryItemsResult>>(){}.getType());
        RevokeInventoryItemsResult result = resultData.data;

        PlayFabResult<RevokeInventoryItemsResult> pfResult = new PlayFabResult<RevokeInventoryItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Saves push notification template for title
     * @param request SavePushNotificationTemplateRequest
     * @return Async Task will return SavePushNotificationTemplateResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SavePushNotificationTemplateResult>> SavePushNotificationTemplateAsync(final SavePushNotificationTemplateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SavePushNotificationTemplateResult>>() {
            public PlayFabResult<SavePushNotificationTemplateResult> call() throws Exception {
                return privateSavePushNotificationTemplateAsync(request);
            }
        });
    }

    /**
     * Saves push notification template for title
     * @param request SavePushNotificationTemplateRequest
     * @return SavePushNotificationTemplateResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SavePushNotificationTemplateResult> SavePushNotificationTemplate(final SavePushNotificationTemplateRequest request) {
        FutureTask<PlayFabResult<SavePushNotificationTemplateResult>> task = new FutureTask(new Callable<PlayFabResult<SavePushNotificationTemplateResult>>() {
            public PlayFabResult<SavePushNotificationTemplateResult> call() throws Exception {
                return privateSavePushNotificationTemplateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Saves push notification template for title */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SavePushNotificationTemplateResult> privateSavePushNotificationTemplateAsync(final SavePushNotificationTemplateRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SavePushNotificationTemplate"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SavePushNotificationTemplateResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SavePushNotificationTemplateResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SavePushNotificationTemplateResult>>(){}.getType());
        SavePushNotificationTemplateResult result = resultData.data;

        PlayFabResult<SavePushNotificationTemplateResult> pfResult = new PlayFabResult<SavePushNotificationTemplateResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Forces an email to be sent to the registered contact email address for the user's account based on an account recovery
     * email template
     * @param request SendCustomAccountRecoveryEmailRequest
     * @return Async Task will return SendCustomAccountRecoveryEmailResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SendCustomAccountRecoveryEmailResult>> SendCustomAccountRecoveryEmailAsync(final SendCustomAccountRecoveryEmailRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SendCustomAccountRecoveryEmailResult>>() {
            public PlayFabResult<SendCustomAccountRecoveryEmailResult> call() throws Exception {
                return privateSendCustomAccountRecoveryEmailAsync(request);
            }
        });
    }

    /**
     * Forces an email to be sent to the registered contact email address for the user's account based on an account recovery
     * email template
     * @param request SendCustomAccountRecoveryEmailRequest
     * @return SendCustomAccountRecoveryEmailResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SendCustomAccountRecoveryEmailResult> SendCustomAccountRecoveryEmail(final SendCustomAccountRecoveryEmailRequest request) {
        FutureTask<PlayFabResult<SendCustomAccountRecoveryEmailResult>> task = new FutureTask(new Callable<PlayFabResult<SendCustomAccountRecoveryEmailResult>>() {
            public PlayFabResult<SendCustomAccountRecoveryEmailResult> call() throws Exception {
                return privateSendCustomAccountRecoveryEmailAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * Forces an email to be sent to the registered contact email address for the user's account based on an account recovery
     * email template
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SendCustomAccountRecoveryEmailResult> privateSendCustomAccountRecoveryEmailAsync(final SendCustomAccountRecoveryEmailRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SendCustomAccountRecoveryEmail"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SendCustomAccountRecoveryEmailResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SendCustomAccountRecoveryEmailResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SendCustomAccountRecoveryEmailResult>>(){}.getType());
        SendCustomAccountRecoveryEmailResult result = resultData.data;

        PlayFabResult<SendCustomAccountRecoveryEmailResult> pfResult = new PlayFabResult<SendCustomAccountRecoveryEmailResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sends an email based on an email template to a player's contact email
     * @param request SendEmailFromTemplateRequest
     * @return Async Task will return SendEmailFromTemplateResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SendEmailFromTemplateResult>> SendEmailFromTemplateAsync(final SendEmailFromTemplateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SendEmailFromTemplateResult>>() {
            public PlayFabResult<SendEmailFromTemplateResult> call() throws Exception {
                return privateSendEmailFromTemplateAsync(request);
            }
        });
    }

    /**
     * Sends an email based on an email template to a player's contact email
     * @param request SendEmailFromTemplateRequest
     * @return SendEmailFromTemplateResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SendEmailFromTemplateResult> SendEmailFromTemplate(final SendEmailFromTemplateRequest request) {
        FutureTask<PlayFabResult<SendEmailFromTemplateResult>> task = new FutureTask(new Callable<PlayFabResult<SendEmailFromTemplateResult>>() {
            public PlayFabResult<SendEmailFromTemplateResult> call() throws Exception {
                return privateSendEmailFromTemplateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Sends an email based on an email template to a player's contact email */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SendEmailFromTemplateResult> privateSendEmailFromTemplateAsync(final SendEmailFromTemplateRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SendEmailFromTemplate"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SendEmailFromTemplateResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SendEmailFromTemplateResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SendEmailFromTemplateResult>>(){}.getType());
        SendEmailFromTemplateResult result = resultData.data;

        PlayFabResult<SendEmailFromTemplateResult> pfResult = new PlayFabResult<SendEmailFromTemplateResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sends an iOS/Android Push Notification to a specific user, if that user's device has been configured for Push
     * Notifications in PlayFab. If a user has linked both Android and iOS devices, both will be notified.
     * @param request SendPushNotificationRequest
     * @return Async Task will return SendPushNotificationResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SendPushNotificationResult>> SendPushNotificationAsync(final SendPushNotificationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SendPushNotificationResult>>() {
            public PlayFabResult<SendPushNotificationResult> call() throws Exception {
                return privateSendPushNotificationAsync(request);
            }
        });
    }

    /**
     * Sends an iOS/Android Push Notification to a specific user, if that user's device has been configured for Push
     * Notifications in PlayFab. If a user has linked both Android and iOS devices, both will be notified.
     * @param request SendPushNotificationRequest
     * @return SendPushNotificationResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SendPushNotificationResult> SendPushNotification(final SendPushNotificationRequest request) {
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
     * Sends an iOS/Android Push Notification to a specific user, if that user's device has been configured for Push
     * Notifications in PlayFab. If a user has linked both Android and iOS devices, both will be notified.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SendPushNotificationResult> privateSendPushNotificationAsync(final SendPushNotificationRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SendPushNotification"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Sends an iOS/Android Push Notification template to a specific user, if that user's device has been configured for Push
     * Notifications in PlayFab. If a user has linked both Android and iOS devices, both will be notified.
     * @param request SendPushNotificationFromTemplateRequest
     * @return Async Task will return SendPushNotificationResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SendPushNotificationResult>> SendPushNotificationFromTemplateAsync(final SendPushNotificationFromTemplateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SendPushNotificationResult>>() {
            public PlayFabResult<SendPushNotificationResult> call() throws Exception {
                return privateSendPushNotificationFromTemplateAsync(request);
            }
        });
    }

    /**
     * Sends an iOS/Android Push Notification template to a specific user, if that user's device has been configured for Push
     * Notifications in PlayFab. If a user has linked both Android and iOS devices, both will be notified.
     * @param request SendPushNotificationFromTemplateRequest
     * @return SendPushNotificationResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SendPushNotificationResult> SendPushNotificationFromTemplate(final SendPushNotificationFromTemplateRequest request) {
        FutureTask<PlayFabResult<SendPushNotificationResult>> task = new FutureTask(new Callable<PlayFabResult<SendPushNotificationResult>>() {
            public PlayFabResult<SendPushNotificationResult> call() throws Exception {
                return privateSendPushNotificationFromTemplateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * Sends an iOS/Android Push Notification template to a specific user, if that user's device has been configured for Push
     * Notifications in PlayFab. If a user has linked both Android and iOS devices, both will be notified.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SendPushNotificationResult> privateSendPushNotificationFromTemplateAsync(final SendPushNotificationFromTemplateRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SendPushNotificationFromTemplate"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Updates the tag list for a specified user in the friend list of another user
     * @param request SetFriendTagsRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> SetFriendTagsAsync(final SetFriendTagsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateSetFriendTagsAsync(request);
            }
        });
    }

    /**
     * Updates the tag list for a specified user in the friend list of another user
     * @param request SetFriendTagsRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> SetFriendTags(final SetFriendTagsRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
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

    /** Updates the tag list for a specified user in the friend list of another user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateSetFriendTagsAsync(final SetFriendTagsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SetFriendTags"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Sets the custom data of the indicated Game Server Instance
     * @param request SetGameServerInstanceDataRequest
     * @return Async Task will return SetGameServerInstanceDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetGameServerInstanceDataResult>> SetGameServerInstanceDataAsync(final SetGameServerInstanceDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetGameServerInstanceDataResult>>() {
            public PlayFabResult<SetGameServerInstanceDataResult> call() throws Exception {
                return privateSetGameServerInstanceDataAsync(request);
            }
        });
    }

    /**
     * Sets the custom data of the indicated Game Server Instance
     * @param request SetGameServerInstanceDataRequest
     * @return SetGameServerInstanceDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetGameServerInstanceDataResult> SetGameServerInstanceData(final SetGameServerInstanceDataRequest request) {
        FutureTask<PlayFabResult<SetGameServerInstanceDataResult>> task = new FutureTask(new Callable<PlayFabResult<SetGameServerInstanceDataResult>>() {
            public PlayFabResult<SetGameServerInstanceDataResult> call() throws Exception {
                return privateSetGameServerInstanceDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Sets the custom data of the indicated Game Server Instance */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetGameServerInstanceDataResult> privateSetGameServerInstanceDataAsync(final SetGameServerInstanceDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SetGameServerInstanceData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetGameServerInstanceDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetGameServerInstanceDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetGameServerInstanceDataResult>>(){}.getType());
        SetGameServerInstanceDataResult result = resultData.data;

        PlayFabResult<SetGameServerInstanceDataResult> pfResult = new PlayFabResult<SetGameServerInstanceDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Set the state of the indicated Game Server Instance.
     * @param request SetGameServerInstanceStateRequest
     * @return Async Task will return SetGameServerInstanceStateResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetGameServerInstanceStateResult>> SetGameServerInstanceStateAsync(final SetGameServerInstanceStateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetGameServerInstanceStateResult>>() {
            public PlayFabResult<SetGameServerInstanceStateResult> call() throws Exception {
                return privateSetGameServerInstanceStateAsync(request);
            }
        });
    }

    /**
     * Set the state of the indicated Game Server Instance.
     * @param request SetGameServerInstanceStateRequest
     * @return SetGameServerInstanceStateResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetGameServerInstanceStateResult> SetGameServerInstanceState(final SetGameServerInstanceStateRequest request) {
        FutureTask<PlayFabResult<SetGameServerInstanceStateResult>> task = new FutureTask(new Callable<PlayFabResult<SetGameServerInstanceStateResult>>() {
            public PlayFabResult<SetGameServerInstanceStateResult> call() throws Exception {
                return privateSetGameServerInstanceStateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Set the state of the indicated Game Server Instance. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetGameServerInstanceStateResult> privateSetGameServerInstanceStateAsync(final SetGameServerInstanceStateRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SetGameServerInstanceState"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetGameServerInstanceStateResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetGameServerInstanceStateResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetGameServerInstanceStateResult>>(){}.getType());
        SetGameServerInstanceStateResult result = resultData.data;

        PlayFabResult<SetGameServerInstanceStateResult> pfResult = new PlayFabResult<SetGameServerInstanceStateResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Set custom tags for the specified Game Server Instance
     * @param request SetGameServerInstanceTagsRequest
     * @return Async Task will return SetGameServerInstanceTagsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetGameServerInstanceTagsResult>> SetGameServerInstanceTagsAsync(final SetGameServerInstanceTagsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetGameServerInstanceTagsResult>>() {
            public PlayFabResult<SetGameServerInstanceTagsResult> call() throws Exception {
                return privateSetGameServerInstanceTagsAsync(request);
            }
        });
    }

    /**
     * Set custom tags for the specified Game Server Instance
     * @param request SetGameServerInstanceTagsRequest
     * @return SetGameServerInstanceTagsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetGameServerInstanceTagsResult> SetGameServerInstanceTags(final SetGameServerInstanceTagsRequest request) {
        FutureTask<PlayFabResult<SetGameServerInstanceTagsResult>> task = new FutureTask(new Callable<PlayFabResult<SetGameServerInstanceTagsResult>>() {
            public PlayFabResult<SetGameServerInstanceTagsResult> call() throws Exception {
                return privateSetGameServerInstanceTagsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Set custom tags for the specified Game Server Instance */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetGameServerInstanceTagsResult> privateSetGameServerInstanceTagsAsync(final SetGameServerInstanceTagsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SetGameServerInstanceTags"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetGameServerInstanceTagsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetGameServerInstanceTagsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetGameServerInstanceTagsResult>>(){}.getType());
        SetGameServerInstanceTagsResult result = resultData.data;

        PlayFabResult<SetGameServerInstanceTagsResult> pfResult = new PlayFabResult<SetGameServerInstanceTagsResult>();
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SetPlayerSecret"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the key-value store of custom publisher settings
     * @param request SetPublisherDataRequest
     * @return Async Task will return SetPublisherDataResult
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
     * @param request SetPublisherDataRequest
     * @return SetPublisherDataResult
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

    /** Updates the key-value store of custom publisher settings */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetPublisherDataResult> privateSetPublisherDataAsync(final SetPublisherDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SetPublisherData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Updates the key-value store of custom title settings
     * @param request SetTitleDataRequest
     * @return Async Task will return SetTitleDataResult
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
     * Updates the key-value store of custom title settings
     * @param request SetTitleDataRequest
     * @return SetTitleDataResult
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

    /** Updates the key-value store of custom title settings */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetTitleDataResult> privateSetTitleDataAsync(final SetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SetTitleData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * @param request SetTitleDataRequest
     * @return Async Task will return SetTitleDataResult
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
     * Updates the key-value store of custom title settings
     * @param request SetTitleDataRequest
     * @return SetTitleDataResult
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

    /** Updates the key-value store of custom title settings */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetTitleDataResult> privateSetTitleInternalDataAsync(final SetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SetTitleInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Decrements the character's balance of the specified virtual currency by the stated amount. It is possible to make a VC
     * balance negative with this API.
     * @param request SubtractCharacterVirtualCurrencyRequest
     * @return Async Task will return ModifyCharacterVirtualCurrencyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyCharacterVirtualCurrencyResult>> SubtractCharacterVirtualCurrencyAsync(final SubtractCharacterVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyCharacterVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyCharacterVirtualCurrencyResult> call() throws Exception {
                return privateSubtractCharacterVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Decrements the character's balance of the specified virtual currency by the stated amount. It is possible to make a VC
     * balance negative with this API.
     * @param request SubtractCharacterVirtualCurrencyRequest
     * @return ModifyCharacterVirtualCurrencyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyCharacterVirtualCurrencyResult> SubtractCharacterVirtualCurrency(final SubtractCharacterVirtualCurrencyRequest request) {
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
     * Decrements the character's balance of the specified virtual currency by the stated amount. It is possible to make a VC
     * balance negative with this API.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyCharacterVirtualCurrencyResult> privateSubtractCharacterVirtualCurrencyAsync(final SubtractCharacterVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SubtractCharacterVirtualCurrency"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/SubtractUserVirtualCurrency"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Unlinks the custom server identifier from the user's PlayFab account.
     * @param request UnlinkServerCustomIdRequest
     * @return Async Task will return UnlinkServerCustomIdResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UnlinkServerCustomIdResult>> UnlinkServerCustomIdAsync(final UnlinkServerCustomIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkServerCustomIdResult>>() {
            public PlayFabResult<UnlinkServerCustomIdResult> call() throws Exception {
                return privateUnlinkServerCustomIdAsync(request);
            }
        });
    }

    /**
     * Unlinks the custom server identifier from the user's PlayFab account.
     * @param request UnlinkServerCustomIdRequest
     * @return UnlinkServerCustomIdResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UnlinkServerCustomIdResult> UnlinkServerCustomId(final UnlinkServerCustomIdRequest request) {
        FutureTask<PlayFabResult<UnlinkServerCustomIdResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkServerCustomIdResult>>() {
            public PlayFabResult<UnlinkServerCustomIdResult> call() throws Exception {
                return privateUnlinkServerCustomIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Unlinks the custom server identifier from the user's PlayFab account. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlinkServerCustomIdResult> privateUnlinkServerCustomIdAsync(final UnlinkServerCustomIdRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UnlinkServerCustomId"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkServerCustomIdResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UnlinkServerCustomIdResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkServerCustomIdResult>>(){}.getType());
        UnlinkServerCustomIdResult result = resultData.data;

        PlayFabResult<UnlinkServerCustomIdResult> pfResult = new PlayFabResult<UnlinkServerCustomIdResult>();
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UnlinkXboxAccount"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Opens a specific container (ContainerItemInstanceId), with a specific key (KeyItemInstanceId, when required), and
     * returns the contents of the opened container. If the container (and key when relevant) are consumable (RemainingUses &gt;
     * 0), their RemainingUses will be decremented, consistent with the operation of ConsumeItem.
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
     * Opens a specific container (ContainerItemInstanceId), with a specific key (KeyItemInstanceId, when required), and
     * returns the contents of the opened container. If the container (and key when relevant) are consumable (RemainingUses &gt;
     * 0), their RemainingUses will be decremented, consistent with the operation of ConsumeItem.
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
     * Opens a specific container (ContainerItemInstanceId), with a specific key (KeyItemInstanceId, when required), and
     * returns the contents of the opened container. If the container (and key when relevant) are consumable (RemainingUses &gt;
     * 0), their RemainingUses will be decremented, consistent with the operation of ConsumeItem.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlockContainerItemResult> privateUnlockContainerInstanceAsync(final UnlockContainerInstanceRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UnlockContainerInstance"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Searches Player or Character inventory for any ItemInstance matching the given CatalogItemId, if necessary unlocks it
     * using any appropriate key, and returns the contents of the opened container. If the container (and key when relevant)
     * are consumable (RemainingUses &gt; 0), their RemainingUses will be decremented, consistent with the operation of
     * ConsumeItem.
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
     * Searches Player or Character inventory for any ItemInstance matching the given CatalogItemId, if necessary unlocks it
     * using any appropriate key, and returns the contents of the opened container. If the container (and key when relevant)
     * are consumable (RemainingUses &gt; 0), their RemainingUses will be decremented, consistent with the operation of
     * ConsumeItem.
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
     * Searches Player or Character inventory for any ItemInstance matching the given CatalogItemId, if necessary unlocks it
     * using any appropriate key, and returns the contents of the opened container. If the container (and key when relevant)
     * are consumable (RemainingUses &gt; 0), their RemainingUses will be decremented, consistent with the operation of
     * ConsumeItem.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UnlockContainerItemResult> privateUnlockContainerItemAsync(final UnlockContainerItemRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UnlockContainerItem"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Update the avatar URL of the specified player
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
     * Update the avatar URL of the specified player
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

    /** Update the avatar URL of the specified player */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateAvatarUrlAsync(final UpdateAvatarUrlRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateAvatarUrl"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates information of a list of existing bans specified with Ban Ids.
     * @param request UpdateBansRequest
     * @return Async Task will return UpdateBansResult
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
     * @param request UpdateBansRequest
     * @return UpdateBansResult
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

    /** Updates information of a list of existing bans specified with Ban Ids. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateBansResult> privateUpdateBansAsync(final UpdateBansRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateBans"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
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
     * Updates the title-specific custom data for the user's character which is readable and writable by the client
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
     * Updates the title-specific custom data for the user's character which is readable and writable by the client
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

    /** Updates the title-specific custom data for the user's character which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCharacterDataResult> privateUpdateCharacterDataAsync(final UpdateCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateCharacterData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the title-specific custom data for the user's character which cannot be accessed by the client
     * @param request UpdateCharacterDataRequest
     * @return Async Task will return UpdateCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCharacterDataResult>> UpdateCharacterInternalDataAsync(final UpdateCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user's character which cannot be accessed by the client
     * @param request UpdateCharacterDataRequest
     * @return UpdateCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCharacterDataResult> UpdateCharacterInternalData(final UpdateCharacterDataRequest request) {
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

    /** Updates the title-specific custom data for the user's character which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCharacterDataResult> privateUpdateCharacterInternalDataAsync(final UpdateCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateCharacterInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the title-specific custom data for the user's character which can only be read by the client
     * @param request UpdateCharacterDataRequest
     * @return Async Task will return UpdateCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCharacterDataResult>> UpdateCharacterReadOnlyDataAsync(final UpdateCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user's character which can only be read by the client
     * @param request UpdateCharacterDataRequest
     * @return UpdateCharacterDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCharacterDataResult> UpdateCharacterReadOnlyData(final UpdateCharacterDataRequest request) {
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

    /** Updates the title-specific custom data for the user's character which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCharacterDataResult> privateUpdateCharacterReadOnlyDataAsync(final UpdateCharacterDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateCharacterReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the values of the specified title-specific statistics for the specific character
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
     * Updates the values of the specified title-specific statistics for the specific character
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

    /** Updates the values of the specified title-specific statistics for the specific character */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCharacterStatisticsResult> privateUpdateCharacterStatisticsAsync(final UpdateCharacterStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateCharacterStatistics"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the values of the specified title-specific statistics for the user
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
     * Updates the values of the specified title-specific statistics for the user
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

    /** Updates the values of the specified title-specific statistics for the user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdatePlayerStatisticsResult> privateUpdatePlayerStatisticsAsync(final UpdatePlayerStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdatePlayerStatistics"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Regardless of the permission setting, only members of the group (and the server) can update the data. Shared Groups are
     * designed for sharing data between a very small number of players, please see our guide:
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
     * Regardless of the permission setting, only members of the group (and the server) can update the data. Shared Groups are
     * designed for sharing data between a very small number of players, please see our guide:
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
     * Regardless of the permission setting, only members of the group (and the server) can update the data. Shared Groups are
     * designed for sharing data between a very small number of players, please see our guide:
     * https://api.playfab.com/docs/tutorials/landing-players/shared-groups
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateSharedGroupDataResult> privateUpdateSharedGroupDataAsync(final UpdateSharedGroupDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateSharedGroupData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the title-specific custom data for the user which is readable and writable by the client
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
     * Updates the title-specific custom data for the user which is readable and writable by the client
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

    /** Updates the title-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateUserData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the title-specific custom data for the user which cannot be accessed by the client
     * @param request UpdateUserInternalDataRequest
     * @return Async Task will return UpdateUserDataResult
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
     * @param request UpdateUserInternalDataRequest
     * @return UpdateUserDataResult
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

    /** Updates the title-specific custom data for the user which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserInternalDataAsync(final UpdateUserInternalDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateUserInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the key-value pair data tagged to the specified item, which is read-only from the client.
     * @param request UpdateUserInventoryItemDataRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateUserInventoryItemCustomDataAsync(final UpdateUserInventoryItemDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateUserInventoryItemCustomDataAsync(request);
            }
        });
    }

    /**
     * Updates the key-value pair data tagged to the specified item, which is read-only from the client.
     * @param request UpdateUserInventoryItemDataRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateUserInventoryItemCustomData(final UpdateUserInventoryItemDataRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
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

    /** Updates the key-value pair data tagged to the specified item, which is read-only from the client. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateUserInventoryItemCustomDataAsync(final UpdateUserInventoryItemDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateUserInventoryItemCustomData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the publisher-specific custom data for the user which is readable and writable by the client
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
     * Updates the publisher-specific custom data for the user which is readable and writable by the client
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

    /** Updates the publisher-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateUserPublisherData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the publisher-specific custom data for the user which cannot be accessed by the client
     * @param request UpdateUserInternalDataRequest
     * @return Async Task will return UpdateUserDataResult
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
     * @param request UpdateUserInternalDataRequest
     * @return UpdateUserDataResult
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

    /** Updates the publisher-specific custom data for the user which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherInternalDataAsync(final UpdateUserInternalDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateUserPublisherInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the publisher-specific custom data for the user which can only be read by the client
     * @param request UpdateUserDataRequest
     * @return Async Task will return UpdateUserDataResult
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
     * @param request UpdateUserDataRequest
     * @return UpdateUserDataResult
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

    /** Updates the publisher-specific custom data for the user which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherReadOnlyDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateUserPublisherReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the title-specific custom data for the user which can only be read by the client
     * @param request UpdateUserDataRequest
     * @return Async Task will return UpdateUserDataResult
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
     * @param request UpdateUserDataRequest
     * @return UpdateUserDataResult
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

    /** Updates the title-specific custom data for the user which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserReadOnlyDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/UpdateUserReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Writes a character-based event into PlayStream.
     * @param request WriteServerCharacterEventRequest
     * @return Async Task will return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<WriteEventResponse>> WriteCharacterEventAsync(final WriteServerCharacterEventRequest request) {
        return new FutureTask(new Callable<PlayFabResult<WriteEventResponse>>() {
            public PlayFabResult<WriteEventResponse> call() throws Exception {
                return privateWriteCharacterEventAsync(request);
            }
        });
    }

    /**
     * Writes a character-based event into PlayStream.
     * @param request WriteServerCharacterEventRequest
     * @return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<WriteEventResponse> WriteCharacterEvent(final WriteServerCharacterEventRequest request) {
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
    private static PlayFabResult<WriteEventResponse> privateWriteCharacterEventAsync(final WriteServerCharacterEventRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/WriteCharacterEvent"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * @param request WriteServerPlayerEventRequest
     * @return Async Task will return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<WriteEventResponse>> WritePlayerEventAsync(final WriteServerPlayerEventRequest request) {
        return new FutureTask(new Callable<PlayFabResult<WriteEventResponse>>() {
            public PlayFabResult<WriteEventResponse> call() throws Exception {
                return privateWritePlayerEventAsync(request);
            }
        });
    }

    /**
     * Writes a player-based event into PlayStream.
     * @param request WriteServerPlayerEventRequest
     * @return WriteEventResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<WriteEventResponse> WritePlayerEvent(final WriteServerPlayerEventRequest request) {
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
    private static PlayFabResult<WriteEventResponse> privateWritePlayerEventAsync(final WriteServerPlayerEventRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/WritePlayerEvent"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Server/WriteTitleEvent"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
