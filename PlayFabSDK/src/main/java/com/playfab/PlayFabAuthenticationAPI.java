package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabAuthenticationModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /**
     * The Authentication APIs provide a convenient way to convert classic authentication responses into entity authentication
     * models. These APIs will provide you with the entity authentication token needed for subsequent Entity API calls. The
     * game_server API is designed to create uniquely identifiable game_server entities. The game_server Entity token can be
     * used to call Matchmaking Lobby and Pubsub for server scenarios.
     */
public class PlayFabAuthenticationAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Create a game_server entity token and return a new or existing game_server entity.
     * @param request AuthenticateCustomIdRequest
     * @return Async Task will return AuthenticateCustomIdResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AuthenticateCustomIdResult>> AuthenticateGameServerWithCustomIdAsync(final AuthenticateCustomIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AuthenticateCustomIdResult>>() {
            public PlayFabResult<AuthenticateCustomIdResult> call() throws Exception {
                return privateAuthenticateGameServerWithCustomIdAsync(request);
            }
        });
    }

    /**
     * Create a game_server entity token and return a new or existing game_server entity.
     * @param request AuthenticateCustomIdRequest
     * @return AuthenticateCustomIdResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AuthenticateCustomIdResult> AuthenticateGameServerWithCustomId(final AuthenticateCustomIdRequest request) {
        FutureTask<PlayFabResult<AuthenticateCustomIdResult>> task = new FutureTask(new Callable<PlayFabResult<AuthenticateCustomIdResult>>() {
            public PlayFabResult<AuthenticateCustomIdResult> call() throws Exception {
                return privateAuthenticateGameServerWithCustomIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AuthenticateCustomIdResult> exceptionResult = new PlayFabResult<AuthenticateCustomIdResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Create a game_server entity token and return a new or existing game_server entity. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AuthenticateCustomIdResult> privateAuthenticateGameServerWithCustomIdAsync(final AuthenticateCustomIdRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/GameServerIdentity/AuthenticateGameServerWithCustomId"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AuthenticateCustomIdResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AuthenticateCustomIdResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AuthenticateCustomIdResult>>(){}.getType());
        AuthenticateCustomIdResult result = resultData.data;
        PlayFabSettings.EntityToken = (result.EntityToken != null && result.EntityToken.EntityToken != null) ? result.EntityToken.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<AuthenticateCustomIdResult> pfResult = new PlayFabResult<AuthenticateCustomIdResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Delete a game_server entity.
     * @param request DeleteRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteAsync(final DeleteRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteAsync(request);
            }
        });
    }

    /**
     * Delete a game_server entity.
     * @param request DeleteRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> Delete(final DeleteRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteAsync(request);
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

    /** Delete a game_server entity. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteAsync(final DeleteRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/GameServerIdentity/Delete"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Method to exchange a legacy AuthenticationTicket or title SecretKey for an Entity Token or to refresh a still valid
     * Entity Token.
     * @param request GetEntityTokenRequest
     * @return Async Task will return GetEntityTokenResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityTokenResponse>> GetEntityTokenAsync(final GetEntityTokenRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityTokenResponse>>() {
            public PlayFabResult<GetEntityTokenResponse> call() throws Exception {
                return privateGetEntityTokenAsync(request);
            }
        });
    }

    /**
     * Method to exchange a legacy AuthenticationTicket or title SecretKey for an Entity Token or to refresh a still valid
     * Entity Token.
     * @param request GetEntityTokenRequest
     * @return GetEntityTokenResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityTokenResponse> GetEntityToken(final GetEntityTokenRequest request) {
        FutureTask<PlayFabResult<GetEntityTokenResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityTokenResponse>>() {
            public PlayFabResult<GetEntityTokenResponse> call() throws Exception {
                return privateGetEntityTokenAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetEntityTokenResponse> exceptionResult = new PlayFabResult<GetEntityTokenResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Method to exchange a legacy AuthenticationTicket or title SecretKey for an Entity Token or to refresh a still valid
     * Entity Token.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityTokenResponse> privateGetEntityTokenAsync(final GetEntityTokenRequest request) throws Exception {
        String authKey = null, authValue = null;
        if (PlayFabSettings.EntityToken != null) { authKey = "X-EntityToken"; authValue = PlayFabSettings.EntityToken; }
        else if (PlayFabSettings.ClientSessionTicket != null) { authKey = "X-Authorization"; authValue = PlayFabSettings.ClientSessionTicket; }
        else if (PlayFabSettings.DeveloperSecretKey != null) { authKey = "X-SecretKey"; authValue = PlayFabSettings.DeveloperSecretKey; }

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Authentication/GetEntityToken"), request, authKey, authValue);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityTokenResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityTokenResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityTokenResponse>>(){}.getType());
        GetEntityTokenResponse result = resultData.data;
        PlayFabSettings.EntityToken = result.EntityToken != null ? result.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<GetEntityTokenResponse> pfResult = new PlayFabResult<GetEntityTokenResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Method for a server to validate a client provided EntityToken. Only callable by the title entity.
     * @param request ValidateEntityTokenRequest
     * @return Async Task will return ValidateEntityTokenResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ValidateEntityTokenResponse>> ValidateEntityTokenAsync(final ValidateEntityTokenRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ValidateEntityTokenResponse>>() {
            public PlayFabResult<ValidateEntityTokenResponse> call() throws Exception {
                return privateValidateEntityTokenAsync(request);
            }
        });
    }

    /**
     * Method for a server to validate a client provided EntityToken. Only callable by the title entity.
     * @param request ValidateEntityTokenRequest
     * @return ValidateEntityTokenResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ValidateEntityTokenResponse> ValidateEntityToken(final ValidateEntityTokenRequest request) {
        FutureTask<PlayFabResult<ValidateEntityTokenResponse>> task = new FutureTask(new Callable<PlayFabResult<ValidateEntityTokenResponse>>() {
            public PlayFabResult<ValidateEntityTokenResponse> call() throws Exception {
                return privateValidateEntityTokenAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ValidateEntityTokenResponse> exceptionResult = new PlayFabResult<ValidateEntityTokenResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Method for a server to validate a client provided EntityToken. Only callable by the title entity. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ValidateEntityTokenResponse> privateValidateEntityTokenAsync(final ValidateEntityTokenRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Authentication/ValidateEntityToken"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ValidateEntityTokenResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ValidateEntityTokenResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ValidateEntityTokenResponse>>(){}.getType());
        ValidateEntityTokenResponse result = resultData.data;

        PlayFabResult<ValidateEntityTokenResponse> pfResult = new PlayFabResult<ValidateEntityTokenResponse>();
        pfResult.Result = result;
        return pfResult;
    }

}
