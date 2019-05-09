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
     * models. These APIs will provide you with the entity authentication token needed for subsequent Entity API calls. Manage
     * API keys for authenticating any entity.
     */
public class PlayFabAuthenticationAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

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
            return null;
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
}
