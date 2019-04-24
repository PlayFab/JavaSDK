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
     * Activates the given API key. Active keys may be used for authentication.
     * @param request ActivateAPIKeyRequest
     * @return Async Task will return ActivateAPIKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ActivateAPIKeyResponse>> ActivateKeyAsync(final ActivateAPIKeyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ActivateAPIKeyResponse>>() {
            public PlayFabResult<ActivateAPIKeyResponse> call() throws Exception {
                return privateActivateKeyAsync(request);
            }
        });
    }

    /**
     * Activates the given API key. Active keys may be used for authentication.
     * @param request ActivateAPIKeyRequest
     * @return ActivateAPIKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ActivateAPIKeyResponse> ActivateKey(final ActivateAPIKeyRequest request) {
        FutureTask<PlayFabResult<ActivateAPIKeyResponse>> task = new FutureTask(new Callable<PlayFabResult<ActivateAPIKeyResponse>>() {
            public PlayFabResult<ActivateAPIKeyResponse> call() throws Exception {
                return privateActivateKeyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Activates the given API key. Active keys may be used for authentication. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ActivateAPIKeyResponse> privateActivateKeyAsync(final ActivateAPIKeyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/APIKey/ActivateKey"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ActivateAPIKeyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ActivateAPIKeyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ActivateAPIKeyResponse>>(){}.getType());
        ActivateAPIKeyResponse result = resultData.data;

        PlayFabResult<ActivateAPIKeyResponse> pfResult = new PlayFabResult<ActivateAPIKeyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates an API key for the given entity.
     * @param request CreateAPIKeyRequest
     * @return Async Task will return CreateAPIKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateAPIKeyResponse>> CreateKeyAsync(final CreateAPIKeyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateAPIKeyResponse>>() {
            public PlayFabResult<CreateAPIKeyResponse> call() throws Exception {
                return privateCreateKeyAsync(request);
            }
        });
    }

    /**
     * Creates an API key for the given entity.
     * @param request CreateAPIKeyRequest
     * @return CreateAPIKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateAPIKeyResponse> CreateKey(final CreateAPIKeyRequest request) {
        FutureTask<PlayFabResult<CreateAPIKeyResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateAPIKeyResponse>>() {
            public PlayFabResult<CreateAPIKeyResponse> call() throws Exception {
                return privateCreateKeyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Creates an API key for the given entity. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateAPIKeyResponse> privateCreateKeyAsync(final CreateAPIKeyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/APIKey/CreateKey"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateAPIKeyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateAPIKeyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateAPIKeyResponse>>(){}.getType());
        CreateAPIKeyResponse result = resultData.data;

        PlayFabResult<CreateAPIKeyResponse> pfResult = new PlayFabResult<CreateAPIKeyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deactivates the given API key, causing subsequent authentication attempts with it to fail.Deactivating a key is a way to
     * verify that the key is not in use before deleting it.
     * @param request DeactivateAPIKeyRequest
     * @return Async Task will return DeactivateAPIKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeactivateAPIKeyResponse>> DeactivateKeyAsync(final DeactivateAPIKeyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeactivateAPIKeyResponse>>() {
            public PlayFabResult<DeactivateAPIKeyResponse> call() throws Exception {
                return privateDeactivateKeyAsync(request);
            }
        });
    }

    /**
     * Deactivates the given API key, causing subsequent authentication attempts with it to fail.Deactivating a key is a way to
     * verify that the key is not in use before deleting it.
     * @param request DeactivateAPIKeyRequest
     * @return DeactivateAPIKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeactivateAPIKeyResponse> DeactivateKey(final DeactivateAPIKeyRequest request) {
        FutureTask<PlayFabResult<DeactivateAPIKeyResponse>> task = new FutureTask(new Callable<PlayFabResult<DeactivateAPIKeyResponse>>() {
            public PlayFabResult<DeactivateAPIKeyResponse> call() throws Exception {
                return privateDeactivateKeyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * Deactivates the given API key, causing subsequent authentication attempts with it to fail.Deactivating a key is a way to
     * verify that the key is not in use before deleting it.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeactivateAPIKeyResponse> privateDeactivateKeyAsync(final DeactivateAPIKeyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/APIKey/DeactivateKey"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeactivateAPIKeyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeactivateAPIKeyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeactivateAPIKeyResponse>>(){}.getType());
        DeactivateAPIKeyResponse result = resultData.data;

        PlayFabResult<DeactivateAPIKeyResponse> pfResult = new PlayFabResult<DeactivateAPIKeyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the given API key.
     * @param request DeleteAPIKeyRequest
     * @return Async Task will return DeleteAPIKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteAPIKeyResponse>> DeleteKeyAsync(final DeleteAPIKeyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteAPIKeyResponse>>() {
            public PlayFabResult<DeleteAPIKeyResponse> call() throws Exception {
                return privateDeleteKeyAsync(request);
            }
        });
    }

    /**
     * Deletes the given API key.
     * @param request DeleteAPIKeyRequest
     * @return DeleteAPIKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteAPIKeyResponse> DeleteKey(final DeleteAPIKeyRequest request) {
        FutureTask<PlayFabResult<DeleteAPIKeyResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteAPIKeyResponse>>() {
            public PlayFabResult<DeleteAPIKeyResponse> call() throws Exception {
                return privateDeleteKeyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Deletes the given API key. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteAPIKeyResponse> privateDeleteKeyAsync(final DeleteAPIKeyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/APIKey/DeleteKey"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteAPIKeyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteAPIKeyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteAPIKeyResponse>>(){}.getType());
        DeleteAPIKeyResponse result = resultData.data;

        PlayFabResult<DeleteAPIKeyResponse> pfResult = new PlayFabResult<DeleteAPIKeyResponse>();
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

    /**
     * Gets the API keys associated with the given entity.
     * @param request GetAPIKeysRequest
     * @return Async Task will return GetAPIKeysResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAPIKeysResponse>> GetKeysAsync(final GetAPIKeysRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAPIKeysResponse>>() {
            public PlayFabResult<GetAPIKeysResponse> call() throws Exception {
                return privateGetKeysAsync(request);
            }
        });
    }

    /**
     * Gets the API keys associated with the given entity.
     * @param request GetAPIKeysRequest
     * @return GetAPIKeysResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAPIKeysResponse> GetKeys(final GetAPIKeysRequest request) {
        FutureTask<PlayFabResult<GetAPIKeysResponse>> task = new FutureTask(new Callable<PlayFabResult<GetAPIKeysResponse>>() {
            public PlayFabResult<GetAPIKeysResponse> call() throws Exception {
                return privateGetKeysAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets the API keys associated with the given entity. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAPIKeysResponse> privateGetKeysAsync(final GetAPIKeysRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/APIKey/GetKeys"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAPIKeysResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAPIKeysResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAPIKeysResponse>>(){}.getType());
        GetAPIKeysResponse result = resultData.data;

        PlayFabResult<GetAPIKeysResponse> pfResult = new PlayFabResult<GetAPIKeysResponse>();
        pfResult.Result = result;
        return pfResult;
    }
}
