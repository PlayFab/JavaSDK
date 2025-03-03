package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabInsightsModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** Manage the Insights performance level and data storage retention settings. */
public class PlayFabInsightsAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Gets the current values for the Insights performance and data storage retention, list of pending operations, and the
     * performance and data storage retention limits.
     * @param request InsightsEmptyRequest
     * @return Async Task will return InsightsGetDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<InsightsGetDetailsResponse>> GetDetailsAsync(final InsightsEmptyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<InsightsGetDetailsResponse>>() {
            public PlayFabResult<InsightsGetDetailsResponse> call() throws Exception {
                return privateGetDetailsAsync(request);
            }
        });
    }

    /**
     * Gets the current values for the Insights performance and data storage retention, list of pending operations, and the
     * performance and data storage retention limits.
     * @param request InsightsEmptyRequest
     * @return InsightsGetDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<InsightsGetDetailsResponse> GetDetails(final InsightsEmptyRequest request) {
        FutureTask<PlayFabResult<InsightsGetDetailsResponse>> task = new FutureTask(new Callable<PlayFabResult<InsightsGetDetailsResponse>>() {
            public PlayFabResult<InsightsGetDetailsResponse> call() throws Exception {
                return privateGetDetailsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<InsightsGetDetailsResponse> exceptionResult = new PlayFabResult<InsightsGetDetailsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Gets the current values for the Insights performance and data storage retention, list of pending operations, and the
     * performance and data storage retention limits.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<InsightsGetDetailsResponse> privateGetDetailsAsync(final InsightsEmptyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Insights/GetDetails"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<InsightsGetDetailsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<InsightsGetDetailsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<InsightsGetDetailsResponse>>(){}.getType());
        InsightsGetDetailsResponse result = resultData.data;

        PlayFabResult<InsightsGetDetailsResponse> pfResult = new PlayFabResult<InsightsGetDetailsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the range of allowed values for performance and data storage retention values as well as the submeter details
     * for each performance level.
     * @param request InsightsEmptyRequest
     * @return Async Task will return InsightsGetLimitsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<InsightsGetLimitsResponse>> GetLimitsAsync(final InsightsEmptyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<InsightsGetLimitsResponse>>() {
            public PlayFabResult<InsightsGetLimitsResponse> call() throws Exception {
                return privateGetLimitsAsync(request);
            }
        });
    }

    /**
     * Retrieves the range of allowed values for performance and data storage retention values as well as the submeter details
     * for each performance level.
     * @param request InsightsEmptyRequest
     * @return InsightsGetLimitsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<InsightsGetLimitsResponse> GetLimits(final InsightsEmptyRequest request) {
        FutureTask<PlayFabResult<InsightsGetLimitsResponse>> task = new FutureTask(new Callable<PlayFabResult<InsightsGetLimitsResponse>>() {
            public PlayFabResult<InsightsGetLimitsResponse> call() throws Exception {
                return privateGetLimitsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<InsightsGetLimitsResponse> exceptionResult = new PlayFabResult<InsightsGetLimitsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the range of allowed values for performance and data storage retention values as well as the submeter details
     * for each performance level.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<InsightsGetLimitsResponse> privateGetLimitsAsync(final InsightsEmptyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Insights/GetLimits"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<InsightsGetLimitsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<InsightsGetLimitsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<InsightsGetLimitsResponse>>(){}.getType());
        InsightsGetLimitsResponse result = resultData.data;

        PlayFabResult<InsightsGetLimitsResponse> pfResult = new PlayFabResult<InsightsGetLimitsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the status of a SetPerformance or SetStorageRetention operation.
     * @param request InsightsGetOperationStatusRequest
     * @return Async Task will return InsightsGetOperationStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<InsightsGetOperationStatusResponse>> GetOperationStatusAsync(final InsightsGetOperationStatusRequest request) {
        return new FutureTask(new Callable<PlayFabResult<InsightsGetOperationStatusResponse>>() {
            public PlayFabResult<InsightsGetOperationStatusResponse> call() throws Exception {
                return privateGetOperationStatusAsync(request);
            }
        });
    }

    /**
     * Gets the status of a SetPerformance or SetStorageRetention operation.
     * @param request InsightsGetOperationStatusRequest
     * @return InsightsGetOperationStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<InsightsGetOperationStatusResponse> GetOperationStatus(final InsightsGetOperationStatusRequest request) {
        FutureTask<PlayFabResult<InsightsGetOperationStatusResponse>> task = new FutureTask(new Callable<PlayFabResult<InsightsGetOperationStatusResponse>>() {
            public PlayFabResult<InsightsGetOperationStatusResponse> call() throws Exception {
                return privateGetOperationStatusAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<InsightsGetOperationStatusResponse> exceptionResult = new PlayFabResult<InsightsGetOperationStatusResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the status of a SetPerformance or SetStorageRetention operation. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<InsightsGetOperationStatusResponse> privateGetOperationStatusAsync(final InsightsGetOperationStatusRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Insights/GetOperationStatus"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<InsightsGetOperationStatusResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<InsightsGetOperationStatusResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<InsightsGetOperationStatusResponse>>(){}.getType());
        InsightsGetOperationStatusResponse result = resultData.data;

        PlayFabResult<InsightsGetOperationStatusResponse> pfResult = new PlayFabResult<InsightsGetOperationStatusResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a list of pending SetPerformance and/or SetStorageRetention operations for the title.
     * @param request InsightsGetPendingOperationsRequest
     * @return Async Task will return InsightsGetPendingOperationsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<InsightsGetPendingOperationsResponse>> GetPendingOperationsAsync(final InsightsGetPendingOperationsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<InsightsGetPendingOperationsResponse>>() {
            public PlayFabResult<InsightsGetPendingOperationsResponse> call() throws Exception {
                return privateGetPendingOperationsAsync(request);
            }
        });
    }

    /**
     * Gets a list of pending SetPerformance and/or SetStorageRetention operations for the title.
     * @param request InsightsGetPendingOperationsRequest
     * @return InsightsGetPendingOperationsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<InsightsGetPendingOperationsResponse> GetPendingOperations(final InsightsGetPendingOperationsRequest request) {
        FutureTask<PlayFabResult<InsightsGetPendingOperationsResponse>> task = new FutureTask(new Callable<PlayFabResult<InsightsGetPendingOperationsResponse>>() {
            public PlayFabResult<InsightsGetPendingOperationsResponse> call() throws Exception {
                return privateGetPendingOperationsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<InsightsGetPendingOperationsResponse> exceptionResult = new PlayFabResult<InsightsGetPendingOperationsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets a list of pending SetPerformance and/or SetStorageRetention operations for the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<InsightsGetPendingOperationsResponse> privateGetPendingOperationsAsync(final InsightsGetPendingOperationsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Insights/GetPendingOperations"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<InsightsGetPendingOperationsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<InsightsGetPendingOperationsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<InsightsGetPendingOperationsResponse>>(){}.getType());
        InsightsGetPendingOperationsResponse result = resultData.data;

        PlayFabResult<InsightsGetPendingOperationsResponse> pfResult = new PlayFabResult<InsightsGetPendingOperationsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the Insights performance level value for the title.
     * @param request InsightsSetPerformanceRequest
     * @return Async Task will return InsightsOperationResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<InsightsOperationResponse>> SetPerformanceAsync(final InsightsSetPerformanceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<InsightsOperationResponse>>() {
            public PlayFabResult<InsightsOperationResponse> call() throws Exception {
                return privateSetPerformanceAsync(request);
            }
        });
    }

    /**
     * Sets the Insights performance level value for the title.
     * @param request InsightsSetPerformanceRequest
     * @return InsightsOperationResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<InsightsOperationResponse> SetPerformance(final InsightsSetPerformanceRequest request) {
        FutureTask<PlayFabResult<InsightsOperationResponse>> task = new FutureTask(new Callable<PlayFabResult<InsightsOperationResponse>>() {
            public PlayFabResult<InsightsOperationResponse> call() throws Exception {
                return privateSetPerformanceAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<InsightsOperationResponse> exceptionResult = new PlayFabResult<InsightsOperationResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Sets the Insights performance level value for the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<InsightsOperationResponse> privateSetPerformanceAsync(final InsightsSetPerformanceRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Insights/SetPerformance"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<InsightsOperationResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<InsightsOperationResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<InsightsOperationResponse>>(){}.getType());
        InsightsOperationResponse result = resultData.data;

        PlayFabResult<InsightsOperationResponse> pfResult = new PlayFabResult<InsightsOperationResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the Insights data storage retention days value for the title.
     * @param request InsightsSetStorageRetentionRequest
     * @return Async Task will return InsightsOperationResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<InsightsOperationResponse>> SetStorageRetentionAsync(final InsightsSetStorageRetentionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<InsightsOperationResponse>>() {
            public PlayFabResult<InsightsOperationResponse> call() throws Exception {
                return privateSetStorageRetentionAsync(request);
            }
        });
    }

    /**
     * Sets the Insights data storage retention days value for the title.
     * @param request InsightsSetStorageRetentionRequest
     * @return InsightsOperationResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<InsightsOperationResponse> SetStorageRetention(final InsightsSetStorageRetentionRequest request) {
        FutureTask<PlayFabResult<InsightsOperationResponse>> task = new FutureTask(new Callable<PlayFabResult<InsightsOperationResponse>>() {
            public PlayFabResult<InsightsOperationResponse> call() throws Exception {
                return privateSetStorageRetentionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<InsightsOperationResponse> exceptionResult = new PlayFabResult<InsightsOperationResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Sets the Insights data storage retention days value for the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<InsightsOperationResponse> privateSetStorageRetentionAsync(final InsightsSetStorageRetentionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Insights/SetStorageRetention"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<InsightsOperationResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<InsightsOperationResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<InsightsOperationResponse>>(){}.getType());
        InsightsOperationResponse result = resultData.data;

        PlayFabResult<InsightsOperationResponse> pfResult = new PlayFabResult<InsightsOperationResponse>();
        pfResult.Result = result;
        return pfResult;
    }

}
