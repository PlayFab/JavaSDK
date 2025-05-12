package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabEventsModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /**
     * Write custom PlayStream and Telemetry events for any PlayFab entity. Telemetry events can be used for analytic,
     * reporting, or debugging. PlayStream events can do all of that and also trigger custom actions in near real-time.
     */
public class PlayFabEventsAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Creates a new telemetry key for the title.
     * @param request CreateTelemetryKeyRequest
     * @return Async Task will return CreateTelemetryKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateTelemetryKeyResponse>> CreateTelemetryKeyAsync(final CreateTelemetryKeyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateTelemetryKeyResponse>>() {
            public PlayFabResult<CreateTelemetryKeyResponse> call() throws Exception {
                return privateCreateTelemetryKeyAsync(request);
            }
        });
    }

    /**
     * Creates a new telemetry key for the title.
     * @param request CreateTelemetryKeyRequest
     * @return CreateTelemetryKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateTelemetryKeyResponse> CreateTelemetryKey(final CreateTelemetryKeyRequest request) {
        FutureTask<PlayFabResult<CreateTelemetryKeyResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateTelemetryKeyResponse>>() {
            public PlayFabResult<CreateTelemetryKeyResponse> call() throws Exception {
                return privateCreateTelemetryKeyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateTelemetryKeyResponse> exceptionResult = new PlayFabResult<CreateTelemetryKeyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a new telemetry key for the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateTelemetryKeyResponse> privateCreateTelemetryKeyAsync(final CreateTelemetryKeyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/CreateTelemetryKey"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateTelemetryKeyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateTelemetryKeyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateTelemetryKeyResponse>>(){}.getType());
        CreateTelemetryKeyResponse result = resultData.data;

        PlayFabResult<CreateTelemetryKeyResponse> pfResult = new PlayFabResult<CreateTelemetryKeyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a Data Connection from a title.
     * @param request DeleteDataConnectionRequest
     * @return Async Task will return DeleteDataConnectionResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteDataConnectionResponse>> DeleteDataConnectionAsync(final DeleteDataConnectionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteDataConnectionResponse>>() {
            public PlayFabResult<DeleteDataConnectionResponse> call() throws Exception {
                return privateDeleteDataConnectionAsync(request);
            }
        });
    }

    /**
     * Deletes a Data Connection from a title.
     * @param request DeleteDataConnectionRequest
     * @return DeleteDataConnectionResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteDataConnectionResponse> DeleteDataConnection(final DeleteDataConnectionRequest request) {
        FutureTask<PlayFabResult<DeleteDataConnectionResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteDataConnectionResponse>>() {
            public PlayFabResult<DeleteDataConnectionResponse> call() throws Exception {
                return privateDeleteDataConnectionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteDataConnectionResponse> exceptionResult = new PlayFabResult<DeleteDataConnectionResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a Data Connection from a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteDataConnectionResponse> privateDeleteDataConnectionAsync(final DeleteDataConnectionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/DeleteDataConnection"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteDataConnectionResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteDataConnectionResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteDataConnectionResponse>>(){}.getType());
        DeleteDataConnectionResponse result = resultData.data;

        PlayFabResult<DeleteDataConnectionResponse> pfResult = new PlayFabResult<DeleteDataConnectionResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a telemetry key configured for the title.
     * @param request DeleteTelemetryKeyRequest
     * @return Async Task will return DeleteTelemetryKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteTelemetryKeyResponse>> DeleteTelemetryKeyAsync(final DeleteTelemetryKeyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteTelemetryKeyResponse>>() {
            public PlayFabResult<DeleteTelemetryKeyResponse> call() throws Exception {
                return privateDeleteTelemetryKeyAsync(request);
            }
        });
    }

    /**
     * Deletes a telemetry key configured for the title.
     * @param request DeleteTelemetryKeyRequest
     * @return DeleteTelemetryKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteTelemetryKeyResponse> DeleteTelemetryKey(final DeleteTelemetryKeyRequest request) {
        FutureTask<PlayFabResult<DeleteTelemetryKeyResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteTelemetryKeyResponse>>() {
            public PlayFabResult<DeleteTelemetryKeyResponse> call() throws Exception {
                return privateDeleteTelemetryKeyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteTelemetryKeyResponse> exceptionResult = new PlayFabResult<DeleteTelemetryKeyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a telemetry key configured for the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteTelemetryKeyResponse> privateDeleteTelemetryKeyAsync(final DeleteTelemetryKeyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/DeleteTelemetryKey"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteTelemetryKeyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteTelemetryKeyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteTelemetryKeyResponse>>(){}.getType());
        DeleteTelemetryKeyResponse result = resultData.data;

        PlayFabResult<DeleteTelemetryKeyResponse> pfResult = new PlayFabResult<DeleteTelemetryKeyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves a single Data Connection associated with a title.
     * @param request GetDataConnectionRequest
     * @return Async Task will return GetDataConnectionResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetDataConnectionResponse>> GetDataConnectionAsync(final GetDataConnectionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetDataConnectionResponse>>() {
            public PlayFabResult<GetDataConnectionResponse> call() throws Exception {
                return privateGetDataConnectionAsync(request);
            }
        });
    }

    /**
     * Retrieves a single Data Connection associated with a title.
     * @param request GetDataConnectionRequest
     * @return GetDataConnectionResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetDataConnectionResponse> GetDataConnection(final GetDataConnectionRequest request) {
        FutureTask<PlayFabResult<GetDataConnectionResponse>> task = new FutureTask(new Callable<PlayFabResult<GetDataConnectionResponse>>() {
            public PlayFabResult<GetDataConnectionResponse> call() throws Exception {
                return privateGetDataConnectionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetDataConnectionResponse> exceptionResult = new PlayFabResult<GetDataConnectionResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves a single Data Connection associated with a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetDataConnectionResponse> privateGetDataConnectionAsync(final GetDataConnectionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/GetDataConnection"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetDataConnectionResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetDataConnectionResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetDataConnectionResponse>>(){}.getType());
        GetDataConnectionResponse result = resultData.data;

        PlayFabResult<GetDataConnectionResponse> pfResult = new PlayFabResult<GetDataConnectionResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets information about a telemetry key configured for the title.
     * @param request GetTelemetryKeyRequest
     * @return Async Task will return GetTelemetryKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTelemetryKeyResponse>> GetTelemetryKeyAsync(final GetTelemetryKeyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTelemetryKeyResponse>>() {
            public PlayFabResult<GetTelemetryKeyResponse> call() throws Exception {
                return privateGetTelemetryKeyAsync(request);
            }
        });
    }

    /**
     * Gets information about a telemetry key configured for the title.
     * @param request GetTelemetryKeyRequest
     * @return GetTelemetryKeyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTelemetryKeyResponse> GetTelemetryKey(final GetTelemetryKeyRequest request) {
        FutureTask<PlayFabResult<GetTelemetryKeyResponse>> task = new FutureTask(new Callable<PlayFabResult<GetTelemetryKeyResponse>>() {
            public PlayFabResult<GetTelemetryKeyResponse> call() throws Exception {
                return privateGetTelemetryKeyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTelemetryKeyResponse> exceptionResult = new PlayFabResult<GetTelemetryKeyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets information about a telemetry key configured for the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTelemetryKeyResponse> privateGetTelemetryKeyAsync(final GetTelemetryKeyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/GetTelemetryKey"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTelemetryKeyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTelemetryKeyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTelemetryKeyResponse>>(){}.getType());
        GetTelemetryKeyResponse result = resultData.data;

        PlayFabResult<GetTelemetryKeyResponse> pfResult = new PlayFabResult<GetTelemetryKeyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the list of Data Connections associated with a title.
     * @param request ListDataConnectionsRequest
     * @return Async Task will return ListDataConnectionsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListDataConnectionsResponse>> ListDataConnectionsAsync(final ListDataConnectionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListDataConnectionsResponse>>() {
            public PlayFabResult<ListDataConnectionsResponse> call() throws Exception {
                return privateListDataConnectionsAsync(request);
            }
        });
    }

    /**
     * Retrieves the list of Data Connections associated with a title.
     * @param request ListDataConnectionsRequest
     * @return ListDataConnectionsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListDataConnectionsResponse> ListDataConnections(final ListDataConnectionsRequest request) {
        FutureTask<PlayFabResult<ListDataConnectionsResponse>> task = new FutureTask(new Callable<PlayFabResult<ListDataConnectionsResponse>>() {
            public PlayFabResult<ListDataConnectionsResponse> call() throws Exception {
                return privateListDataConnectionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListDataConnectionsResponse> exceptionResult = new PlayFabResult<ListDataConnectionsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the list of Data Connections associated with a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListDataConnectionsResponse> privateListDataConnectionsAsync(final ListDataConnectionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/ListDataConnections"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListDataConnectionsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListDataConnectionsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListDataConnectionsResponse>>(){}.getType());
        ListDataConnectionsResponse result = resultData.data;

        PlayFabResult<ListDataConnectionsResponse> pfResult = new PlayFabResult<ListDataConnectionsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all telemetry keys configured for the title.
     * @param request ListTelemetryKeysRequest
     * @return Async Task will return ListTelemetryKeysResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListTelemetryKeysResponse>> ListTelemetryKeysAsync(final ListTelemetryKeysRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListTelemetryKeysResponse>>() {
            public PlayFabResult<ListTelemetryKeysResponse> call() throws Exception {
                return privateListTelemetryKeysAsync(request);
            }
        });
    }

    /**
     * Lists all telemetry keys configured for the title.
     * @param request ListTelemetryKeysRequest
     * @return ListTelemetryKeysResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListTelemetryKeysResponse> ListTelemetryKeys(final ListTelemetryKeysRequest request) {
        FutureTask<PlayFabResult<ListTelemetryKeysResponse>> task = new FutureTask(new Callable<PlayFabResult<ListTelemetryKeysResponse>>() {
            public PlayFabResult<ListTelemetryKeysResponse> call() throws Exception {
                return privateListTelemetryKeysAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListTelemetryKeysResponse> exceptionResult = new PlayFabResult<ListTelemetryKeysResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists all telemetry keys configured for the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListTelemetryKeysResponse> privateListTelemetryKeysAsync(final ListTelemetryKeysRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/ListTelemetryKeys"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListTelemetryKeysResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListTelemetryKeysResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListTelemetryKeysResponse>>(){}.getType());
        ListTelemetryKeysResponse result = resultData.data;

        PlayFabResult<ListTelemetryKeysResponse> pfResult = new PlayFabResult<ListTelemetryKeysResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates or updates a Data Connection on a title.
     * @param request SetDataConnectionRequest
     * @return Async Task will return SetDataConnectionResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetDataConnectionResponse>> SetDataConnectionAsync(final SetDataConnectionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetDataConnectionResponse>>() {
            public PlayFabResult<SetDataConnectionResponse> call() throws Exception {
                return privateSetDataConnectionAsync(request);
            }
        });
    }

    /**
     * Creates or updates a Data Connection on a title.
     * @param request SetDataConnectionRequest
     * @return SetDataConnectionResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetDataConnectionResponse> SetDataConnection(final SetDataConnectionRequest request) {
        FutureTask<PlayFabResult<SetDataConnectionResponse>> task = new FutureTask(new Callable<PlayFabResult<SetDataConnectionResponse>>() {
            public PlayFabResult<SetDataConnectionResponse> call() throws Exception {
                return privateSetDataConnectionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetDataConnectionResponse> exceptionResult = new PlayFabResult<SetDataConnectionResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates or updates a Data Connection on a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetDataConnectionResponse> privateSetDataConnectionAsync(final SetDataConnectionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/SetDataConnection"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetDataConnectionResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetDataConnectionResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetDataConnectionResponse>>(){}.getType());
        SetDataConnectionResponse result = resultData.data;

        PlayFabResult<SetDataConnectionResponse> pfResult = new PlayFabResult<SetDataConnectionResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets a Data Connection for the title to either the active or deactivated state.
     * @param request SetDataConnectionActiveRequest
     * @return Async Task will return SetDataConnectionActiveResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetDataConnectionActiveResponse>> SetDataConnectionActiveAsync(final SetDataConnectionActiveRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetDataConnectionActiveResponse>>() {
            public PlayFabResult<SetDataConnectionActiveResponse> call() throws Exception {
                return privateSetDataConnectionActiveAsync(request);
            }
        });
    }

    /**
     * Sets a Data Connection for the title to either the active or deactivated state.
     * @param request SetDataConnectionActiveRequest
     * @return SetDataConnectionActiveResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetDataConnectionActiveResponse> SetDataConnectionActive(final SetDataConnectionActiveRequest request) {
        FutureTask<PlayFabResult<SetDataConnectionActiveResponse>> task = new FutureTask(new Callable<PlayFabResult<SetDataConnectionActiveResponse>>() {
            public PlayFabResult<SetDataConnectionActiveResponse> call() throws Exception {
                return privateSetDataConnectionActiveAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetDataConnectionActiveResponse> exceptionResult = new PlayFabResult<SetDataConnectionActiveResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Sets a Data Connection for the title to either the active or deactivated state. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetDataConnectionActiveResponse> privateSetDataConnectionActiveAsync(final SetDataConnectionActiveRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/SetDataConnectionActive"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetDataConnectionActiveResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetDataConnectionActiveResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetDataConnectionActiveResponse>>(){}.getType());
        SetDataConnectionActiveResponse result = resultData.data;

        PlayFabResult<SetDataConnectionActiveResponse> pfResult = new PlayFabResult<SetDataConnectionActiveResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets a telemetry key to the active or deactivated state.
     * @param request SetTelemetryKeyActiveRequest
     * @return Async Task will return SetTelemetryKeyActiveResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetTelemetryKeyActiveResponse>> SetTelemetryKeyActiveAsync(final SetTelemetryKeyActiveRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTelemetryKeyActiveResponse>>() {
            public PlayFabResult<SetTelemetryKeyActiveResponse> call() throws Exception {
                return privateSetTelemetryKeyActiveAsync(request);
            }
        });
    }

    /**
     * Sets a telemetry key to the active or deactivated state.
     * @param request SetTelemetryKeyActiveRequest
     * @return SetTelemetryKeyActiveResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetTelemetryKeyActiveResponse> SetTelemetryKeyActive(final SetTelemetryKeyActiveRequest request) {
        FutureTask<PlayFabResult<SetTelemetryKeyActiveResponse>> task = new FutureTask(new Callable<PlayFabResult<SetTelemetryKeyActiveResponse>>() {
            public PlayFabResult<SetTelemetryKeyActiveResponse> call() throws Exception {
                return privateSetTelemetryKeyActiveAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetTelemetryKeyActiveResponse> exceptionResult = new PlayFabResult<SetTelemetryKeyActiveResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Sets a telemetry key to the active or deactivated state. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetTelemetryKeyActiveResponse> privateSetTelemetryKeyActiveAsync(final SetTelemetryKeyActiveRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/SetTelemetryKeyActive"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetTelemetryKeyActiveResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetTelemetryKeyActiveResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetTelemetryKeyActiveResponse>>(){}.getType());
        SetTelemetryKeyActiveResponse result = resultData.data;

        PlayFabResult<SetTelemetryKeyActiveResponse> pfResult = new PlayFabResult<SetTelemetryKeyActiveResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Write batches of entity based events to PlayStream. The namespace of the Event must be 'custom' or start with 'custom.'.
     * @param request WriteEventsRequest
     * @return Async Task will return WriteEventsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<WriteEventsResponse>> WriteEventsAsync(final WriteEventsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<WriteEventsResponse>>() {
            public PlayFabResult<WriteEventsResponse> call() throws Exception {
                return privateWriteEventsAsync(request);
            }
        });
    }

    /**
     * Write batches of entity based events to PlayStream. The namespace of the Event must be 'custom' or start with 'custom.'.
     * @param request WriteEventsRequest
     * @return WriteEventsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<WriteEventsResponse> WriteEvents(final WriteEventsRequest request) {
        FutureTask<PlayFabResult<WriteEventsResponse>> task = new FutureTask(new Callable<PlayFabResult<WriteEventsResponse>>() {
            public PlayFabResult<WriteEventsResponse> call() throws Exception {
                return privateWriteEventsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<WriteEventsResponse> exceptionResult = new PlayFabResult<WriteEventsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Write batches of entity based events to PlayStream. The namespace of the Event must be 'custom' or start with 'custom.'. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<WriteEventsResponse> privateWriteEventsAsync(final WriteEventsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/WriteEvents"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<WriteEventsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<WriteEventsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<WriteEventsResponse>>(){}.getType());
        WriteEventsResponse result = resultData.data;

        PlayFabResult<WriteEventsResponse> pfResult = new PlayFabResult<WriteEventsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Write batches of entity based events to as Telemetry events (bypass PlayStream). The namespace must be 'custom' or start
     * with 'custom.'
     * @param request WriteEventsRequest
     * @return Async Task will return WriteEventsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<WriteEventsResponse>> WriteTelemetryEventsAsync(final WriteEventsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<WriteEventsResponse>>() {
            public PlayFabResult<WriteEventsResponse> call() throws Exception {
                return privateWriteTelemetryEventsAsync(request);
            }
        });
    }

    /**
     * Write batches of entity based events to as Telemetry events (bypass PlayStream). The namespace must be 'custom' or start
     * with 'custom.'
     * @param request WriteEventsRequest
     * @return WriteEventsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<WriteEventsResponse> WriteTelemetryEvents(final WriteEventsRequest request) {
        FutureTask<PlayFabResult<WriteEventsResponse>> task = new FutureTask(new Callable<PlayFabResult<WriteEventsResponse>>() {
            public PlayFabResult<WriteEventsResponse> call() throws Exception {
                return privateWriteTelemetryEventsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<WriteEventsResponse> exceptionResult = new PlayFabResult<WriteEventsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Write batches of entity based events to as Telemetry events (bypass PlayStream). The namespace must be 'custom' or start
     * with 'custom.'
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<WriteEventsResponse> privateWriteTelemetryEventsAsync(final WriteEventsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/WriteTelemetryEvents"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<WriteEventsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<WriteEventsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<WriteEventsResponse>>(){}.getType());
        WriteEventsResponse result = resultData.data;

        PlayFabResult<WriteEventsResponse> pfResult = new PlayFabResult<WriteEventsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

}
