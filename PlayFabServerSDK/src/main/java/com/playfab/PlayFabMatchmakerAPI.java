package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabMatchmakerModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** Enables the use of an external match-making service in conjunction with PlayFab hosted Game Server instances */
public class PlayFabMatchmakerAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Validates a user with the PlayFab service
     * @param request AuthUserRequest
     * @return Async Task will return AuthUserResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AuthUserResponse>> AuthUserAsync(final AuthUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AuthUserResponse>>() {
            public PlayFabResult<AuthUserResponse> call() throws Exception {
                return privateAuthUserAsync(request);
            }
        });
    }

    /**
     * Validates a user with the PlayFab service
     * @param request AuthUserRequest
     * @return AuthUserResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AuthUserResponse> AuthUser(final AuthUserRequest request) {
        FutureTask<PlayFabResult<AuthUserResponse>> task = new FutureTask(new Callable<PlayFabResult<AuthUserResponse>>() {
            public PlayFabResult<AuthUserResponse> call() throws Exception {
                return privateAuthUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Validates a user with the PlayFab service */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AuthUserResponse> privateAuthUserAsync(final AuthUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Matchmaker/AuthUser"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AuthUserResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AuthUserResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AuthUserResponse>>(){}.getType());
        AuthUserResponse result = resultData.data;

        PlayFabResult<AuthUserResponse> pfResult = new PlayFabResult<AuthUserResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Informs the PlayFab game server hosting service that the indicated user has joined the Game Server Instance specified
     * @param request PlayerJoinedRequest
     * @return Async Task will return PlayerJoinedResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<PlayerJoinedResponse>> PlayerJoinedAsync(final PlayerJoinedRequest request) {
        return new FutureTask(new Callable<PlayFabResult<PlayerJoinedResponse>>() {
            public PlayFabResult<PlayerJoinedResponse> call() throws Exception {
                return privatePlayerJoinedAsync(request);
            }
        });
    }

    /**
     * Informs the PlayFab game server hosting service that the indicated user has joined the Game Server Instance specified
     * @param request PlayerJoinedRequest
     * @return PlayerJoinedResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<PlayerJoinedResponse> PlayerJoined(final PlayerJoinedRequest request) {
        FutureTask<PlayFabResult<PlayerJoinedResponse>> task = new FutureTask(new Callable<PlayFabResult<PlayerJoinedResponse>>() {
            public PlayFabResult<PlayerJoinedResponse> call() throws Exception {
                return privatePlayerJoinedAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Informs the PlayFab game server hosting service that the indicated user has joined the Game Server Instance specified */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<PlayerJoinedResponse> privatePlayerJoinedAsync(final PlayerJoinedRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Matchmaker/PlayerJoined"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<PlayerJoinedResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<PlayerJoinedResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<PlayerJoinedResponse>>(){}.getType());
        PlayerJoinedResponse result = resultData.data;

        PlayFabResult<PlayerJoinedResponse> pfResult = new PlayFabResult<PlayerJoinedResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Informs the PlayFab game server hosting service that the indicated user has left the Game Server Instance specified
     * @param request PlayerLeftRequest
     * @return Async Task will return PlayerLeftResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<PlayerLeftResponse>> PlayerLeftAsync(final PlayerLeftRequest request) {
        return new FutureTask(new Callable<PlayFabResult<PlayerLeftResponse>>() {
            public PlayFabResult<PlayerLeftResponse> call() throws Exception {
                return privatePlayerLeftAsync(request);
            }
        });
    }

    /**
     * Informs the PlayFab game server hosting service that the indicated user has left the Game Server Instance specified
     * @param request PlayerLeftRequest
     * @return PlayerLeftResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<PlayerLeftResponse> PlayerLeft(final PlayerLeftRequest request) {
        FutureTask<PlayFabResult<PlayerLeftResponse>> task = new FutureTask(new Callable<PlayFabResult<PlayerLeftResponse>>() {
            public PlayFabResult<PlayerLeftResponse> call() throws Exception {
                return privatePlayerLeftAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Informs the PlayFab game server hosting service that the indicated user has left the Game Server Instance specified */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<PlayerLeftResponse> privatePlayerLeftAsync(final PlayerLeftRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Matchmaker/PlayerLeft"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<PlayerLeftResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<PlayerLeftResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<PlayerLeftResponse>>(){}.getType());
        PlayerLeftResponse result = resultData.data;

        PlayFabResult<PlayerLeftResponse> pfResult = new PlayFabResult<PlayerLeftResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Instructs the PlayFab game server hosting service to instantiate a new Game Server Instance
     * @param request StartGameRequest
     * @return Async Task will return StartGameResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<StartGameResponse>> StartGameAsync(final StartGameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<StartGameResponse>>() {
            public PlayFabResult<StartGameResponse> call() throws Exception {
                return privateStartGameAsync(request);
            }
        });
    }

    /**
     * Instructs the PlayFab game server hosting service to instantiate a new Game Server Instance
     * @param request StartGameRequest
     * @return StartGameResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<StartGameResponse> StartGame(final StartGameRequest request) {
        FutureTask<PlayFabResult<StartGameResponse>> task = new FutureTask(new Callable<PlayFabResult<StartGameResponse>>() {
            public PlayFabResult<StartGameResponse> call() throws Exception {
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

    /** Instructs the PlayFab game server hosting service to instantiate a new Game Server Instance */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<StartGameResponse> privateStartGameAsync(final StartGameRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Matchmaker/StartGame"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<StartGameResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<StartGameResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<StartGameResponse>>(){}.getType());
        StartGameResponse result = resultData.data;

        PlayFabResult<StartGameResponse> pfResult = new PlayFabResult<StartGameResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the relevant details for a specified user, which the external match-making service can then use to compute
     * effective matches
     * @param request UserInfoRequest
     * @return Async Task will return UserInfoResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UserInfoResponse>> UserInfoAsync(final UserInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UserInfoResponse>>() {
            public PlayFabResult<UserInfoResponse> call() throws Exception {
                return privateUserInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the relevant details for a specified user, which the external match-making service can then use to compute
     * effective matches
     * @param request UserInfoRequest
     * @return UserInfoResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UserInfoResponse> UserInfo(final UserInfoRequest request) {
        FutureTask<PlayFabResult<UserInfoResponse>> task = new FutureTask(new Callable<PlayFabResult<UserInfoResponse>>() {
            public PlayFabResult<UserInfoResponse> call() throws Exception {
                return privateUserInfoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * Retrieves the relevant details for a specified user, which the external match-making service can then use to compute
     * effective matches
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UserInfoResponse> privateUserInfoAsync(final UserInfoRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Matchmaker/UserInfo"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UserInfoResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UserInfoResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UserInfoResponse>>(){}.getType());
        UserInfoResponse result = resultData.data;

        PlayFabResult<UserInfoResponse> pfResult = new PlayFabResult<UserInfoResponse>();
        pfResult.Result = result;
        return pfResult;
    }
}
