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
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null);
            return exceptionResult;
        }
    }

    /** Write batches of entity based events to PlayStream. The namespace of the Event must be 'custom' or start with 'custom.'. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<WriteEventsResponse> privateWriteEventsAsync(final WriteEventsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/WriteEvents", request), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Event/WriteTelemetryEvents", request), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
