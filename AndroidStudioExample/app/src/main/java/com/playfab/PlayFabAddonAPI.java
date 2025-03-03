package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabAddonModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** APIs for managing addons. */
public class PlayFabAddonAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Creates the Apple addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateAppleRequest
     * @return Async Task will return CreateOrUpdateAppleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateOrUpdateAppleResponse>> CreateOrUpdateAppleAsync(final CreateOrUpdateAppleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateOrUpdateAppleResponse>>() {
            public PlayFabResult<CreateOrUpdateAppleResponse> call() throws Exception {
                return privateCreateOrUpdateAppleAsync(request);
            }
        });
    }

    /**
     * Creates the Apple addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateAppleRequest
     * @return CreateOrUpdateAppleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateOrUpdateAppleResponse> CreateOrUpdateApple(final CreateOrUpdateAppleRequest request) {
        FutureTask<PlayFabResult<CreateOrUpdateAppleResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateOrUpdateAppleResponse>>() {
            public PlayFabResult<CreateOrUpdateAppleResponse> call() throws Exception {
                return privateCreateOrUpdateAppleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateOrUpdateAppleResponse> exceptionResult = new PlayFabResult<CreateOrUpdateAppleResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the Apple addon on a title, or updates it if it already exists. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateOrUpdateAppleResponse> privateCreateOrUpdateAppleAsync(final CreateOrUpdateAppleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/CreateOrUpdateApple"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateOrUpdateAppleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateOrUpdateAppleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateOrUpdateAppleResponse>>(){}.getType());
        CreateOrUpdateAppleResponse result = resultData.data;

        PlayFabResult<CreateOrUpdateAppleResponse> pfResult = new PlayFabResult<CreateOrUpdateAppleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates the Facebook addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateFacebookRequest
     * @return Async Task will return CreateOrUpdateFacebookResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateOrUpdateFacebookResponse>> CreateOrUpdateFacebookAsync(final CreateOrUpdateFacebookRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateOrUpdateFacebookResponse>>() {
            public PlayFabResult<CreateOrUpdateFacebookResponse> call() throws Exception {
                return privateCreateOrUpdateFacebookAsync(request);
            }
        });
    }

    /**
     * Creates the Facebook addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateFacebookRequest
     * @return CreateOrUpdateFacebookResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateOrUpdateFacebookResponse> CreateOrUpdateFacebook(final CreateOrUpdateFacebookRequest request) {
        FutureTask<PlayFabResult<CreateOrUpdateFacebookResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateOrUpdateFacebookResponse>>() {
            public PlayFabResult<CreateOrUpdateFacebookResponse> call() throws Exception {
                return privateCreateOrUpdateFacebookAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateOrUpdateFacebookResponse> exceptionResult = new PlayFabResult<CreateOrUpdateFacebookResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the Facebook addon on a title, or updates it if it already exists. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateOrUpdateFacebookResponse> privateCreateOrUpdateFacebookAsync(final CreateOrUpdateFacebookRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/CreateOrUpdateFacebook"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateOrUpdateFacebookResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateOrUpdateFacebookResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateOrUpdateFacebookResponse>>(){}.getType());
        CreateOrUpdateFacebookResponse result = resultData.data;

        PlayFabResult<CreateOrUpdateFacebookResponse> pfResult = new PlayFabResult<CreateOrUpdateFacebookResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates the Facebook Instant Games addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateFacebookInstantGamesRequest
     * @return Async Task will return CreateOrUpdateFacebookInstantGamesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse>> CreateOrUpdateFacebookInstantGamesAsync(final CreateOrUpdateFacebookInstantGamesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse>>() {
            public PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse> call() throws Exception {
                return privateCreateOrUpdateFacebookInstantGamesAsync(request);
            }
        });
    }

    /**
     * Creates the Facebook Instant Games addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateFacebookInstantGamesRequest
     * @return CreateOrUpdateFacebookInstantGamesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse> CreateOrUpdateFacebookInstantGames(final CreateOrUpdateFacebookInstantGamesRequest request) {
        FutureTask<PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse>>() {
            public PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse> call() throws Exception {
                return privateCreateOrUpdateFacebookInstantGamesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse> exceptionResult = new PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the Facebook Instant Games addon on a title, or updates it if it already exists. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse> privateCreateOrUpdateFacebookInstantGamesAsync(final CreateOrUpdateFacebookInstantGamesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/CreateOrUpdateFacebookInstantGames"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateOrUpdateFacebookInstantGamesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateOrUpdateFacebookInstantGamesResponse>>(){}.getType());
        CreateOrUpdateFacebookInstantGamesResponse result = resultData.data;

        PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse> pfResult = new PlayFabResult<CreateOrUpdateFacebookInstantGamesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates the Google addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateGoogleRequest
     * @return Async Task will return CreateOrUpdateGoogleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateOrUpdateGoogleResponse>> CreateOrUpdateGoogleAsync(final CreateOrUpdateGoogleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateOrUpdateGoogleResponse>>() {
            public PlayFabResult<CreateOrUpdateGoogleResponse> call() throws Exception {
                return privateCreateOrUpdateGoogleAsync(request);
            }
        });
    }

    /**
     * Creates the Google addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateGoogleRequest
     * @return CreateOrUpdateGoogleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateOrUpdateGoogleResponse> CreateOrUpdateGoogle(final CreateOrUpdateGoogleRequest request) {
        FutureTask<PlayFabResult<CreateOrUpdateGoogleResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateOrUpdateGoogleResponse>>() {
            public PlayFabResult<CreateOrUpdateGoogleResponse> call() throws Exception {
                return privateCreateOrUpdateGoogleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateOrUpdateGoogleResponse> exceptionResult = new PlayFabResult<CreateOrUpdateGoogleResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the Google addon on a title, or updates it if it already exists. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateOrUpdateGoogleResponse> privateCreateOrUpdateGoogleAsync(final CreateOrUpdateGoogleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/CreateOrUpdateGoogle"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateOrUpdateGoogleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateOrUpdateGoogleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateOrUpdateGoogleResponse>>(){}.getType());
        CreateOrUpdateGoogleResponse result = resultData.data;

        PlayFabResult<CreateOrUpdateGoogleResponse> pfResult = new PlayFabResult<CreateOrUpdateGoogleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates the Kongregate addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateKongregateRequest
     * @return Async Task will return CreateOrUpdateKongregateResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateOrUpdateKongregateResponse>> CreateOrUpdateKongregateAsync(final CreateOrUpdateKongregateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateOrUpdateKongregateResponse>>() {
            public PlayFabResult<CreateOrUpdateKongregateResponse> call() throws Exception {
                return privateCreateOrUpdateKongregateAsync(request);
            }
        });
    }

    /**
     * Creates the Kongregate addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateKongregateRequest
     * @return CreateOrUpdateKongregateResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateOrUpdateKongregateResponse> CreateOrUpdateKongregate(final CreateOrUpdateKongregateRequest request) {
        FutureTask<PlayFabResult<CreateOrUpdateKongregateResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateOrUpdateKongregateResponse>>() {
            public PlayFabResult<CreateOrUpdateKongregateResponse> call() throws Exception {
                return privateCreateOrUpdateKongregateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateOrUpdateKongregateResponse> exceptionResult = new PlayFabResult<CreateOrUpdateKongregateResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the Kongregate addon on a title, or updates it if it already exists. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateOrUpdateKongregateResponse> privateCreateOrUpdateKongregateAsync(final CreateOrUpdateKongregateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/CreateOrUpdateKongregate"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateOrUpdateKongregateResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateOrUpdateKongregateResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateOrUpdateKongregateResponse>>(){}.getType());
        CreateOrUpdateKongregateResponse result = resultData.data;

        PlayFabResult<CreateOrUpdateKongregateResponse> pfResult = new PlayFabResult<CreateOrUpdateKongregateResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates the Nintendo addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateNintendoRequest
     * @return Async Task will return CreateOrUpdateNintendoResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateOrUpdateNintendoResponse>> CreateOrUpdateNintendoAsync(final CreateOrUpdateNintendoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateOrUpdateNintendoResponse>>() {
            public PlayFabResult<CreateOrUpdateNintendoResponse> call() throws Exception {
                return privateCreateOrUpdateNintendoAsync(request);
            }
        });
    }

    /**
     * Creates the Nintendo addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateNintendoRequest
     * @return CreateOrUpdateNintendoResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateOrUpdateNintendoResponse> CreateOrUpdateNintendo(final CreateOrUpdateNintendoRequest request) {
        FutureTask<PlayFabResult<CreateOrUpdateNintendoResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateOrUpdateNintendoResponse>>() {
            public PlayFabResult<CreateOrUpdateNintendoResponse> call() throws Exception {
                return privateCreateOrUpdateNintendoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateOrUpdateNintendoResponse> exceptionResult = new PlayFabResult<CreateOrUpdateNintendoResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the Nintendo addon on a title, or updates it if it already exists. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateOrUpdateNintendoResponse> privateCreateOrUpdateNintendoAsync(final CreateOrUpdateNintendoRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/CreateOrUpdateNintendo"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateOrUpdateNintendoResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateOrUpdateNintendoResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateOrUpdateNintendoResponse>>(){}.getType());
        CreateOrUpdateNintendoResponse result = resultData.data;

        PlayFabResult<CreateOrUpdateNintendoResponse> pfResult = new PlayFabResult<CreateOrUpdateNintendoResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates the PSN addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdatePSNRequest
     * @return Async Task will return CreateOrUpdatePSNResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateOrUpdatePSNResponse>> CreateOrUpdatePSNAsync(final CreateOrUpdatePSNRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateOrUpdatePSNResponse>>() {
            public PlayFabResult<CreateOrUpdatePSNResponse> call() throws Exception {
                return privateCreateOrUpdatePSNAsync(request);
            }
        });
    }

    /**
     * Creates the PSN addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdatePSNRequest
     * @return CreateOrUpdatePSNResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateOrUpdatePSNResponse> CreateOrUpdatePSN(final CreateOrUpdatePSNRequest request) {
        FutureTask<PlayFabResult<CreateOrUpdatePSNResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateOrUpdatePSNResponse>>() {
            public PlayFabResult<CreateOrUpdatePSNResponse> call() throws Exception {
                return privateCreateOrUpdatePSNAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateOrUpdatePSNResponse> exceptionResult = new PlayFabResult<CreateOrUpdatePSNResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the PSN addon on a title, or updates it if it already exists. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateOrUpdatePSNResponse> privateCreateOrUpdatePSNAsync(final CreateOrUpdatePSNRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/CreateOrUpdatePSN"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateOrUpdatePSNResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateOrUpdatePSNResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateOrUpdatePSNResponse>>(){}.getType());
        CreateOrUpdatePSNResponse result = resultData.data;

        PlayFabResult<CreateOrUpdatePSNResponse> pfResult = new PlayFabResult<CreateOrUpdatePSNResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates the Steam addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateSteamRequest
     * @return Async Task will return CreateOrUpdateSteamResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateOrUpdateSteamResponse>> CreateOrUpdateSteamAsync(final CreateOrUpdateSteamRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateOrUpdateSteamResponse>>() {
            public PlayFabResult<CreateOrUpdateSteamResponse> call() throws Exception {
                return privateCreateOrUpdateSteamAsync(request);
            }
        });
    }

    /**
     * Creates the Steam addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateSteamRequest
     * @return CreateOrUpdateSteamResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateOrUpdateSteamResponse> CreateOrUpdateSteam(final CreateOrUpdateSteamRequest request) {
        FutureTask<PlayFabResult<CreateOrUpdateSteamResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateOrUpdateSteamResponse>>() {
            public PlayFabResult<CreateOrUpdateSteamResponse> call() throws Exception {
                return privateCreateOrUpdateSteamAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateOrUpdateSteamResponse> exceptionResult = new PlayFabResult<CreateOrUpdateSteamResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the Steam addon on a title, or updates it if it already exists. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateOrUpdateSteamResponse> privateCreateOrUpdateSteamAsync(final CreateOrUpdateSteamRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/CreateOrUpdateSteam"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateOrUpdateSteamResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateOrUpdateSteamResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateOrUpdateSteamResponse>>(){}.getType());
        CreateOrUpdateSteamResponse result = resultData.data;

        PlayFabResult<CreateOrUpdateSteamResponse> pfResult = new PlayFabResult<CreateOrUpdateSteamResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates the Twitch addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateTwitchRequest
     * @return Async Task will return CreateOrUpdateTwitchResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateOrUpdateTwitchResponse>> CreateOrUpdateTwitchAsync(final CreateOrUpdateTwitchRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateOrUpdateTwitchResponse>>() {
            public PlayFabResult<CreateOrUpdateTwitchResponse> call() throws Exception {
                return privateCreateOrUpdateTwitchAsync(request);
            }
        });
    }

    /**
     * Creates the Twitch addon on a title, or updates it if it already exists.
     * @param request CreateOrUpdateTwitchRequest
     * @return CreateOrUpdateTwitchResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateOrUpdateTwitchResponse> CreateOrUpdateTwitch(final CreateOrUpdateTwitchRequest request) {
        FutureTask<PlayFabResult<CreateOrUpdateTwitchResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateOrUpdateTwitchResponse>>() {
            public PlayFabResult<CreateOrUpdateTwitchResponse> call() throws Exception {
                return privateCreateOrUpdateTwitchAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateOrUpdateTwitchResponse> exceptionResult = new PlayFabResult<CreateOrUpdateTwitchResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the Twitch addon on a title, or updates it if it already exists. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateOrUpdateTwitchResponse> privateCreateOrUpdateTwitchAsync(final CreateOrUpdateTwitchRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/CreateOrUpdateTwitch"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateOrUpdateTwitchResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateOrUpdateTwitchResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateOrUpdateTwitchResponse>>(){}.getType());
        CreateOrUpdateTwitchResponse result = resultData.data;

        PlayFabResult<CreateOrUpdateTwitchResponse> pfResult = new PlayFabResult<CreateOrUpdateTwitchResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the Apple addon on a title.
     * @param request DeleteAppleRequest
     * @return Async Task will return DeleteAppleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteAppleResponse>> DeleteAppleAsync(final DeleteAppleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteAppleResponse>>() {
            public PlayFabResult<DeleteAppleResponse> call() throws Exception {
                return privateDeleteAppleAsync(request);
            }
        });
    }

    /**
     * Deletes the Apple addon on a title.
     * @param request DeleteAppleRequest
     * @return DeleteAppleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteAppleResponse> DeleteApple(final DeleteAppleRequest request) {
        FutureTask<PlayFabResult<DeleteAppleResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteAppleResponse>>() {
            public PlayFabResult<DeleteAppleResponse> call() throws Exception {
                return privateDeleteAppleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteAppleResponse> exceptionResult = new PlayFabResult<DeleteAppleResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes the Apple addon on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteAppleResponse> privateDeleteAppleAsync(final DeleteAppleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/DeleteApple"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteAppleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteAppleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteAppleResponse>>(){}.getType());
        DeleteAppleResponse result = resultData.data;

        PlayFabResult<DeleteAppleResponse> pfResult = new PlayFabResult<DeleteAppleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the Facebook addon on a title.
     * @param request DeleteFacebookRequest
     * @return Async Task will return DeleteFacebookResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteFacebookResponse>> DeleteFacebookAsync(final DeleteFacebookRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteFacebookResponse>>() {
            public PlayFabResult<DeleteFacebookResponse> call() throws Exception {
                return privateDeleteFacebookAsync(request);
            }
        });
    }

    /**
     * Deletes the Facebook addon on a title.
     * @param request DeleteFacebookRequest
     * @return DeleteFacebookResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteFacebookResponse> DeleteFacebook(final DeleteFacebookRequest request) {
        FutureTask<PlayFabResult<DeleteFacebookResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteFacebookResponse>>() {
            public PlayFabResult<DeleteFacebookResponse> call() throws Exception {
                return privateDeleteFacebookAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteFacebookResponse> exceptionResult = new PlayFabResult<DeleteFacebookResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes the Facebook addon on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteFacebookResponse> privateDeleteFacebookAsync(final DeleteFacebookRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/DeleteFacebook"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteFacebookResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteFacebookResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteFacebookResponse>>(){}.getType());
        DeleteFacebookResponse result = resultData.data;

        PlayFabResult<DeleteFacebookResponse> pfResult = new PlayFabResult<DeleteFacebookResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the Facebook addon on a title.
     * @param request DeleteFacebookInstantGamesRequest
     * @return Async Task will return DeleteFacebookInstantGamesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteFacebookInstantGamesResponse>> DeleteFacebookInstantGamesAsync(final DeleteFacebookInstantGamesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteFacebookInstantGamesResponse>>() {
            public PlayFabResult<DeleteFacebookInstantGamesResponse> call() throws Exception {
                return privateDeleteFacebookInstantGamesAsync(request);
            }
        });
    }

    /**
     * Deletes the Facebook addon on a title.
     * @param request DeleteFacebookInstantGamesRequest
     * @return DeleteFacebookInstantGamesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteFacebookInstantGamesResponse> DeleteFacebookInstantGames(final DeleteFacebookInstantGamesRequest request) {
        FutureTask<PlayFabResult<DeleteFacebookInstantGamesResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteFacebookInstantGamesResponse>>() {
            public PlayFabResult<DeleteFacebookInstantGamesResponse> call() throws Exception {
                return privateDeleteFacebookInstantGamesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteFacebookInstantGamesResponse> exceptionResult = new PlayFabResult<DeleteFacebookInstantGamesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes the Facebook addon on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteFacebookInstantGamesResponse> privateDeleteFacebookInstantGamesAsync(final DeleteFacebookInstantGamesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/DeleteFacebookInstantGames"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteFacebookInstantGamesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteFacebookInstantGamesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteFacebookInstantGamesResponse>>(){}.getType());
        DeleteFacebookInstantGamesResponse result = resultData.data;

        PlayFabResult<DeleteFacebookInstantGamesResponse> pfResult = new PlayFabResult<DeleteFacebookInstantGamesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the Google addon on a title.
     * @param request DeleteGoogleRequest
     * @return Async Task will return DeleteGoogleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteGoogleResponse>> DeleteGoogleAsync(final DeleteGoogleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteGoogleResponse>>() {
            public PlayFabResult<DeleteGoogleResponse> call() throws Exception {
                return privateDeleteGoogleAsync(request);
            }
        });
    }

    /**
     * Deletes the Google addon on a title.
     * @param request DeleteGoogleRequest
     * @return DeleteGoogleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteGoogleResponse> DeleteGoogle(final DeleteGoogleRequest request) {
        FutureTask<PlayFabResult<DeleteGoogleResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteGoogleResponse>>() {
            public PlayFabResult<DeleteGoogleResponse> call() throws Exception {
                return privateDeleteGoogleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteGoogleResponse> exceptionResult = new PlayFabResult<DeleteGoogleResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes the Google addon on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteGoogleResponse> privateDeleteGoogleAsync(final DeleteGoogleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/DeleteGoogle"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteGoogleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteGoogleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteGoogleResponse>>(){}.getType());
        DeleteGoogleResponse result = resultData.data;

        PlayFabResult<DeleteGoogleResponse> pfResult = new PlayFabResult<DeleteGoogleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the Kongregate addon on a title.
     * @param request DeleteKongregateRequest
     * @return Async Task will return DeleteKongregateResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteKongregateResponse>> DeleteKongregateAsync(final DeleteKongregateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteKongregateResponse>>() {
            public PlayFabResult<DeleteKongregateResponse> call() throws Exception {
                return privateDeleteKongregateAsync(request);
            }
        });
    }

    /**
     * Deletes the Kongregate addon on a title.
     * @param request DeleteKongregateRequest
     * @return DeleteKongregateResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteKongregateResponse> DeleteKongregate(final DeleteKongregateRequest request) {
        FutureTask<PlayFabResult<DeleteKongregateResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteKongregateResponse>>() {
            public PlayFabResult<DeleteKongregateResponse> call() throws Exception {
                return privateDeleteKongregateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteKongregateResponse> exceptionResult = new PlayFabResult<DeleteKongregateResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes the Kongregate addon on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteKongregateResponse> privateDeleteKongregateAsync(final DeleteKongregateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/DeleteKongregate"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteKongregateResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteKongregateResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteKongregateResponse>>(){}.getType());
        DeleteKongregateResponse result = resultData.data;

        PlayFabResult<DeleteKongregateResponse> pfResult = new PlayFabResult<DeleteKongregateResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the Nintendo addon on a title.
     * @param request DeleteNintendoRequest
     * @return Async Task will return DeleteNintendoResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteNintendoResponse>> DeleteNintendoAsync(final DeleteNintendoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteNintendoResponse>>() {
            public PlayFabResult<DeleteNintendoResponse> call() throws Exception {
                return privateDeleteNintendoAsync(request);
            }
        });
    }

    /**
     * Deletes the Nintendo addon on a title.
     * @param request DeleteNintendoRequest
     * @return DeleteNintendoResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteNintendoResponse> DeleteNintendo(final DeleteNintendoRequest request) {
        FutureTask<PlayFabResult<DeleteNintendoResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteNintendoResponse>>() {
            public PlayFabResult<DeleteNintendoResponse> call() throws Exception {
                return privateDeleteNintendoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteNintendoResponse> exceptionResult = new PlayFabResult<DeleteNintendoResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes the Nintendo addon on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteNintendoResponse> privateDeleteNintendoAsync(final DeleteNintendoRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/DeleteNintendo"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteNintendoResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteNintendoResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteNintendoResponse>>(){}.getType());
        DeleteNintendoResponse result = resultData.data;

        PlayFabResult<DeleteNintendoResponse> pfResult = new PlayFabResult<DeleteNintendoResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the PSN addon on a title.
     * @param request DeletePSNRequest
     * @return Async Task will return DeletePSNResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeletePSNResponse>> DeletePSNAsync(final DeletePSNRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeletePSNResponse>>() {
            public PlayFabResult<DeletePSNResponse> call() throws Exception {
                return privateDeletePSNAsync(request);
            }
        });
    }

    /**
     * Deletes the PSN addon on a title.
     * @param request DeletePSNRequest
     * @return DeletePSNResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeletePSNResponse> DeletePSN(final DeletePSNRequest request) {
        FutureTask<PlayFabResult<DeletePSNResponse>> task = new FutureTask(new Callable<PlayFabResult<DeletePSNResponse>>() {
            public PlayFabResult<DeletePSNResponse> call() throws Exception {
                return privateDeletePSNAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeletePSNResponse> exceptionResult = new PlayFabResult<DeletePSNResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes the PSN addon on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeletePSNResponse> privateDeletePSNAsync(final DeletePSNRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/DeletePSN"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeletePSNResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeletePSNResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeletePSNResponse>>(){}.getType());
        DeletePSNResponse result = resultData.data;

        PlayFabResult<DeletePSNResponse> pfResult = new PlayFabResult<DeletePSNResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the Steam addon on a title.
     * @param request DeleteSteamRequest
     * @return Async Task will return DeleteSteamResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteSteamResponse>> DeleteSteamAsync(final DeleteSteamRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteSteamResponse>>() {
            public PlayFabResult<DeleteSteamResponse> call() throws Exception {
                return privateDeleteSteamAsync(request);
            }
        });
    }

    /**
     * Deletes the Steam addon on a title.
     * @param request DeleteSteamRequest
     * @return DeleteSteamResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteSteamResponse> DeleteSteam(final DeleteSteamRequest request) {
        FutureTask<PlayFabResult<DeleteSteamResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteSteamResponse>>() {
            public PlayFabResult<DeleteSteamResponse> call() throws Exception {
                return privateDeleteSteamAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteSteamResponse> exceptionResult = new PlayFabResult<DeleteSteamResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes the Steam addon on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteSteamResponse> privateDeleteSteamAsync(final DeleteSteamRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/DeleteSteam"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteSteamResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteSteamResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteSteamResponse>>(){}.getType());
        DeleteSteamResponse result = resultData.data;

        PlayFabResult<DeleteSteamResponse> pfResult = new PlayFabResult<DeleteSteamResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes the Twitch addon on a title.
     * @param request DeleteTwitchRequest
     * @return Async Task will return DeleteTwitchResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteTwitchResponse>> DeleteTwitchAsync(final DeleteTwitchRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteTwitchResponse>>() {
            public PlayFabResult<DeleteTwitchResponse> call() throws Exception {
                return privateDeleteTwitchAsync(request);
            }
        });
    }

    /**
     * Deletes the Twitch addon on a title.
     * @param request DeleteTwitchRequest
     * @return DeleteTwitchResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteTwitchResponse> DeleteTwitch(final DeleteTwitchRequest request) {
        FutureTask<PlayFabResult<DeleteTwitchResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteTwitchResponse>>() {
            public PlayFabResult<DeleteTwitchResponse> call() throws Exception {
                return privateDeleteTwitchAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteTwitchResponse> exceptionResult = new PlayFabResult<DeleteTwitchResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes the Twitch addon on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteTwitchResponse> privateDeleteTwitchAsync(final DeleteTwitchRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/DeleteTwitch"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteTwitchResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteTwitchResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteTwitchResponse>>(){}.getType());
        DeleteTwitchResponse result = resultData.data;

        PlayFabResult<DeleteTwitchResponse> pfResult = new PlayFabResult<DeleteTwitchResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information of the Apple addon on a title, omits secrets.
     * @param request GetAppleRequest
     * @return Async Task will return GetAppleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAppleResponse>> GetAppleAsync(final GetAppleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAppleResponse>>() {
            public PlayFabResult<GetAppleResponse> call() throws Exception {
                return privateGetAppleAsync(request);
            }
        });
    }

    /**
     * Gets information of the Apple addon on a title, omits secrets.
     * @param request GetAppleRequest
     * @return GetAppleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAppleResponse> GetApple(final GetAppleRequest request) {
        FutureTask<PlayFabResult<GetAppleResponse>> task = new FutureTask(new Callable<PlayFabResult<GetAppleResponse>>() {
            public PlayFabResult<GetAppleResponse> call() throws Exception {
                return privateGetAppleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetAppleResponse> exceptionResult = new PlayFabResult<GetAppleResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information of the Apple addon on a title, omits secrets. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAppleResponse> privateGetAppleAsync(final GetAppleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/GetApple"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAppleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAppleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAppleResponse>>(){}.getType());
        GetAppleResponse result = resultData.data;

        PlayFabResult<GetAppleResponse> pfResult = new PlayFabResult<GetAppleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information of the Facebook addon on a title, omits secrets.
     * @param request GetFacebookRequest
     * @return Async Task will return GetFacebookResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetFacebookResponse>> GetFacebookAsync(final GetFacebookRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetFacebookResponse>>() {
            public PlayFabResult<GetFacebookResponse> call() throws Exception {
                return privateGetFacebookAsync(request);
            }
        });
    }

    /**
     * Gets information of the Facebook addon on a title, omits secrets.
     * @param request GetFacebookRequest
     * @return GetFacebookResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetFacebookResponse> GetFacebook(final GetFacebookRequest request) {
        FutureTask<PlayFabResult<GetFacebookResponse>> task = new FutureTask(new Callable<PlayFabResult<GetFacebookResponse>>() {
            public PlayFabResult<GetFacebookResponse> call() throws Exception {
                return privateGetFacebookAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetFacebookResponse> exceptionResult = new PlayFabResult<GetFacebookResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information of the Facebook addon on a title, omits secrets. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetFacebookResponse> privateGetFacebookAsync(final GetFacebookRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/GetFacebook"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetFacebookResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetFacebookResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetFacebookResponse>>(){}.getType());
        GetFacebookResponse result = resultData.data;

        PlayFabResult<GetFacebookResponse> pfResult = new PlayFabResult<GetFacebookResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information of the Facebook Instant Games addon on a title, omits secrets.
     * @param request GetFacebookInstantGamesRequest
     * @return Async Task will return GetFacebookInstantGamesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetFacebookInstantGamesResponse>> GetFacebookInstantGamesAsync(final GetFacebookInstantGamesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetFacebookInstantGamesResponse>>() {
            public PlayFabResult<GetFacebookInstantGamesResponse> call() throws Exception {
                return privateGetFacebookInstantGamesAsync(request);
            }
        });
    }

    /**
     * Gets information of the Facebook Instant Games addon on a title, omits secrets.
     * @param request GetFacebookInstantGamesRequest
     * @return GetFacebookInstantGamesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetFacebookInstantGamesResponse> GetFacebookInstantGames(final GetFacebookInstantGamesRequest request) {
        FutureTask<PlayFabResult<GetFacebookInstantGamesResponse>> task = new FutureTask(new Callable<PlayFabResult<GetFacebookInstantGamesResponse>>() {
            public PlayFabResult<GetFacebookInstantGamesResponse> call() throws Exception {
                return privateGetFacebookInstantGamesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetFacebookInstantGamesResponse> exceptionResult = new PlayFabResult<GetFacebookInstantGamesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information of the Facebook Instant Games addon on a title, omits secrets. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetFacebookInstantGamesResponse> privateGetFacebookInstantGamesAsync(final GetFacebookInstantGamesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/GetFacebookInstantGames"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetFacebookInstantGamesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetFacebookInstantGamesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetFacebookInstantGamesResponse>>(){}.getType());
        GetFacebookInstantGamesResponse result = resultData.data;

        PlayFabResult<GetFacebookInstantGamesResponse> pfResult = new PlayFabResult<GetFacebookInstantGamesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information of the Google addon on a title, omits secrets.
     * @param request GetGoogleRequest
     * @return Async Task will return GetGoogleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetGoogleResponse>> GetGoogleAsync(final GetGoogleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetGoogleResponse>>() {
            public PlayFabResult<GetGoogleResponse> call() throws Exception {
                return privateGetGoogleAsync(request);
            }
        });
    }

    /**
     * Gets information of the Google addon on a title, omits secrets.
     * @param request GetGoogleRequest
     * @return GetGoogleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetGoogleResponse> GetGoogle(final GetGoogleRequest request) {
        FutureTask<PlayFabResult<GetGoogleResponse>> task = new FutureTask(new Callable<PlayFabResult<GetGoogleResponse>>() {
            public PlayFabResult<GetGoogleResponse> call() throws Exception {
                return privateGetGoogleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetGoogleResponse> exceptionResult = new PlayFabResult<GetGoogleResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information of the Google addon on a title, omits secrets. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetGoogleResponse> privateGetGoogleAsync(final GetGoogleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/GetGoogle"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetGoogleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetGoogleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetGoogleResponse>>(){}.getType());
        GetGoogleResponse result = resultData.data;

        PlayFabResult<GetGoogleResponse> pfResult = new PlayFabResult<GetGoogleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information of the Kongregate addon on a title, omits secrets.
     * @param request GetKongregateRequest
     * @return Async Task will return GetKongregateResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetKongregateResponse>> GetKongregateAsync(final GetKongregateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetKongregateResponse>>() {
            public PlayFabResult<GetKongregateResponse> call() throws Exception {
                return privateGetKongregateAsync(request);
            }
        });
    }

    /**
     * Gets information of the Kongregate addon on a title, omits secrets.
     * @param request GetKongregateRequest
     * @return GetKongregateResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetKongregateResponse> GetKongregate(final GetKongregateRequest request) {
        FutureTask<PlayFabResult<GetKongregateResponse>> task = new FutureTask(new Callable<PlayFabResult<GetKongregateResponse>>() {
            public PlayFabResult<GetKongregateResponse> call() throws Exception {
                return privateGetKongregateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetKongregateResponse> exceptionResult = new PlayFabResult<GetKongregateResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information of the Kongregate addon on a title, omits secrets. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetKongregateResponse> privateGetKongregateAsync(final GetKongregateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/GetKongregate"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetKongregateResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetKongregateResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetKongregateResponse>>(){}.getType());
        GetKongregateResponse result = resultData.data;

        PlayFabResult<GetKongregateResponse> pfResult = new PlayFabResult<GetKongregateResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information of the Nintendo addon on a title, omits secrets.
     * @param request GetNintendoRequest
     * @return Async Task will return GetNintendoResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetNintendoResponse>> GetNintendoAsync(final GetNintendoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetNintendoResponse>>() {
            public PlayFabResult<GetNintendoResponse> call() throws Exception {
                return privateGetNintendoAsync(request);
            }
        });
    }

    /**
     * Gets information of the Nintendo addon on a title, omits secrets.
     * @param request GetNintendoRequest
     * @return GetNintendoResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetNintendoResponse> GetNintendo(final GetNintendoRequest request) {
        FutureTask<PlayFabResult<GetNintendoResponse>> task = new FutureTask(new Callable<PlayFabResult<GetNintendoResponse>>() {
            public PlayFabResult<GetNintendoResponse> call() throws Exception {
                return privateGetNintendoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetNintendoResponse> exceptionResult = new PlayFabResult<GetNintendoResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information of the Nintendo addon on a title, omits secrets. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetNintendoResponse> privateGetNintendoAsync(final GetNintendoRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/GetNintendo"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetNintendoResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetNintendoResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetNintendoResponse>>(){}.getType());
        GetNintendoResponse result = resultData.data;

        PlayFabResult<GetNintendoResponse> pfResult = new PlayFabResult<GetNintendoResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information of the PSN addon on a title, omits secrets.
     * @param request GetPSNRequest
     * @return Async Task will return GetPSNResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPSNResponse>> GetPSNAsync(final GetPSNRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPSNResponse>>() {
            public PlayFabResult<GetPSNResponse> call() throws Exception {
                return privateGetPSNAsync(request);
            }
        });
    }

    /**
     * Gets information of the PSN addon on a title, omits secrets.
     * @param request GetPSNRequest
     * @return GetPSNResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPSNResponse> GetPSN(final GetPSNRequest request) {
        FutureTask<PlayFabResult<GetPSNResponse>> task = new FutureTask(new Callable<PlayFabResult<GetPSNResponse>>() {
            public PlayFabResult<GetPSNResponse> call() throws Exception {
                return privateGetPSNAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPSNResponse> exceptionResult = new PlayFabResult<GetPSNResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information of the PSN addon on a title, omits secrets. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPSNResponse> privateGetPSNAsync(final GetPSNRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/GetPSN"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPSNResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPSNResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPSNResponse>>(){}.getType());
        GetPSNResponse result = resultData.data;

        PlayFabResult<GetPSNResponse> pfResult = new PlayFabResult<GetPSNResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information of the Steam addon on a title, omits secrets.
     * @param request GetSteamRequest
     * @return Async Task will return GetSteamResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetSteamResponse>> GetSteamAsync(final GetSteamRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetSteamResponse>>() {
            public PlayFabResult<GetSteamResponse> call() throws Exception {
                return privateGetSteamAsync(request);
            }
        });
    }

    /**
     * Gets information of the Steam addon on a title, omits secrets.
     * @param request GetSteamRequest
     * @return GetSteamResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetSteamResponse> GetSteam(final GetSteamRequest request) {
        FutureTask<PlayFabResult<GetSteamResponse>> task = new FutureTask(new Callable<PlayFabResult<GetSteamResponse>>() {
            public PlayFabResult<GetSteamResponse> call() throws Exception {
                return privateGetSteamAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetSteamResponse> exceptionResult = new PlayFabResult<GetSteamResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information of the Steam addon on a title, omits secrets. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetSteamResponse> privateGetSteamAsync(final GetSteamRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/GetSteam"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetSteamResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetSteamResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetSteamResponse>>(){}.getType());
        GetSteamResponse result = resultData.data;

        PlayFabResult<GetSteamResponse> pfResult = new PlayFabResult<GetSteamResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information of the Twitch addon on a title, omits secrets.
     * @param request GetTwitchRequest
     * @return Async Task will return GetTwitchResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTwitchResponse>> GetTwitchAsync(final GetTwitchRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTwitchResponse>>() {
            public PlayFabResult<GetTwitchResponse> call() throws Exception {
                return privateGetTwitchAsync(request);
            }
        });
    }

    /**
     * Gets information of the Twitch addon on a title, omits secrets.
     * @param request GetTwitchRequest
     * @return GetTwitchResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTwitchResponse> GetTwitch(final GetTwitchRequest request) {
        FutureTask<PlayFabResult<GetTwitchResponse>> task = new FutureTask(new Callable<PlayFabResult<GetTwitchResponse>>() {
            public PlayFabResult<GetTwitchResponse> call() throws Exception {
                return privateGetTwitchAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTwitchResponse> exceptionResult = new PlayFabResult<GetTwitchResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information of the Twitch addon on a title, omits secrets. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTwitchResponse> privateGetTwitchAsync(final GetTwitchRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Addon/GetTwitch"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTwitchResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTwitchResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTwitchResponse>>(){}.getType());
        GetTwitchResponse result = resultData.data;

        PlayFabResult<GetTwitchResponse> pfResult = new PlayFabResult<GetTwitchResponse>();
        pfResult.Result = result;
        return pfResult;
    }

}
