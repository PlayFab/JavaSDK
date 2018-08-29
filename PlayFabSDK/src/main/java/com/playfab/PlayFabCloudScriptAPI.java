package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabCloudScriptModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** API methods for executing CloudScript using an Entity Profile */
public class PlayFabCloudScriptAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Cloud Script is one of PlayFab's most versatile features. It allows client code to request execution of any kind of
     * custom server-side functionality you can implement, and it can be used in conjunction with virtually anything.
     * @param request ExecuteEntityCloudScriptRequest
     * @return Async Task will return ExecuteCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ExecuteCloudScriptResult>> ExecuteEntityCloudScriptAsync(final ExecuteEntityCloudScriptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ExecuteCloudScriptResult>>() {
            public PlayFabResult<ExecuteCloudScriptResult> call() throws Exception {
                return privateExecuteEntityCloudScriptAsync(request);
            }
        });
    }

    /**
     * Cloud Script is one of PlayFab's most versatile features. It allows client code to request execution of any kind of
     * custom server-side functionality you can implement, and it can be used in conjunction with virtually anything.
     * @param request ExecuteEntityCloudScriptRequest
     * @return ExecuteCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ExecuteCloudScriptResult> ExecuteEntityCloudScript(final ExecuteEntityCloudScriptRequest request) {
        FutureTask<PlayFabResult<ExecuteCloudScriptResult>> task = new FutureTask(new Callable<PlayFabResult<ExecuteCloudScriptResult>>() {
            public PlayFabResult<ExecuteCloudScriptResult> call() throws Exception {
                return privateExecuteEntityCloudScriptAsync(request);
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
     * Cloud Script is one of PlayFab's most versatile features. It allows client code to request execution of any kind of
     * custom server-side functionality you can implement, and it can be used in conjunction with virtually anything.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ExecuteCloudScriptResult> privateExecuteEntityCloudScriptAsync(final ExecuteEntityCloudScriptRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/ExecuteEntityCloudScript"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
}
