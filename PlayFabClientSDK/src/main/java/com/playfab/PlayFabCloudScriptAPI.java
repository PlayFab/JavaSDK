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
            PlayFabResult<ExecuteCloudScriptResult> exceptionResult = new PlayFabResult<ExecuteCloudScriptResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
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

    /**
     * Cloud Script is one of PlayFab's most versatile features. It allows client code to request execution of any kind of
     * custom server-side functionality you can implement, and it can be used in conjunction with virtually anything.
     * @param request ExecuteFunctionRequest
     * @return Async Task will return ExecuteFunctionResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ExecuteFunctionResult>> ExecuteFunctionAsync(final ExecuteFunctionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ExecuteFunctionResult>>() {
            public PlayFabResult<ExecuteFunctionResult> call() throws Exception {
                return privateExecuteFunctionAsync(request);
            }
        });
    }

    /**
     * Cloud Script is one of PlayFab's most versatile features. It allows client code to request execution of any kind of
     * custom server-side functionality you can implement, and it can be used in conjunction with virtually anything.
     * @param request ExecuteFunctionRequest
     * @return ExecuteFunctionResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ExecuteFunctionResult> ExecuteFunction(final ExecuteFunctionRequest request) {
        FutureTask<PlayFabResult<ExecuteFunctionResult>> task = new FutureTask(new Callable<PlayFabResult<ExecuteFunctionResult>>() {
            public PlayFabResult<ExecuteFunctionResult> call() throws Exception {
                return privateExecuteFunctionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ExecuteFunctionResult> exceptionResult = new PlayFabResult<ExecuteFunctionResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Cloud Script is one of PlayFab's most versatile features. It allows client code to request execution of any kind of
     * custom server-side functionality you can implement, and it can be used in conjunction with virtually anything.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ExecuteFunctionResult> privateExecuteFunctionAsync(final ExecuteFunctionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/ExecuteFunction"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ExecuteFunctionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ExecuteFunctionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ExecuteFunctionResult>>(){}.getType());
        ExecuteFunctionResult result = resultData.data;

        PlayFabResult<ExecuteFunctionResult> pfResult = new PlayFabResult<ExecuteFunctionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets registered Azure Functions for a given title id and function name.
     * @param request GetFunctionRequest
     * @return Async Task will return GetFunctionResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetFunctionResult>> GetFunctionAsync(final GetFunctionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetFunctionResult>>() {
            public PlayFabResult<GetFunctionResult> call() throws Exception {
                return privateGetFunctionAsync(request);
            }
        });
    }

    /**
     * Gets registered Azure Functions for a given title id and function name.
     * @param request GetFunctionRequest
     * @return GetFunctionResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetFunctionResult> GetFunction(final GetFunctionRequest request) {
        FutureTask<PlayFabResult<GetFunctionResult>> task = new FutureTask(new Callable<PlayFabResult<GetFunctionResult>>() {
            public PlayFabResult<GetFunctionResult> call() throws Exception {
                return privateGetFunctionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetFunctionResult> exceptionResult = new PlayFabResult<GetFunctionResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets registered Azure Functions for a given title id and function name. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetFunctionResult> privateGetFunctionAsync(final GetFunctionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/GetFunction"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetFunctionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetFunctionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetFunctionResult>>(){}.getType());
        GetFunctionResult result = resultData.data;

        PlayFabResult<GetFunctionResult> pfResult = new PlayFabResult<GetFunctionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all currently registered Event Hub triggered Azure Functions for a given title.
     * @param request ListFunctionsRequest
     * @return Async Task will return ListEventHubFunctionsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListEventHubFunctionsResult>> ListEventHubFunctionsAsync(final ListFunctionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListEventHubFunctionsResult>>() {
            public PlayFabResult<ListEventHubFunctionsResult> call() throws Exception {
                return privateListEventHubFunctionsAsync(request);
            }
        });
    }

    /**
     * Lists all currently registered Event Hub triggered Azure Functions for a given title.
     * @param request ListFunctionsRequest
     * @return ListEventHubFunctionsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListEventHubFunctionsResult> ListEventHubFunctions(final ListFunctionsRequest request) {
        FutureTask<PlayFabResult<ListEventHubFunctionsResult>> task = new FutureTask(new Callable<PlayFabResult<ListEventHubFunctionsResult>>() {
            public PlayFabResult<ListEventHubFunctionsResult> call() throws Exception {
                return privateListEventHubFunctionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListEventHubFunctionsResult> exceptionResult = new PlayFabResult<ListEventHubFunctionsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists all currently registered Event Hub triggered Azure Functions for a given title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListEventHubFunctionsResult> privateListEventHubFunctionsAsync(final ListFunctionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/ListEventHubFunctions"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListEventHubFunctionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListEventHubFunctionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListEventHubFunctionsResult>>(){}.getType());
        ListEventHubFunctionsResult result = resultData.data;

        PlayFabResult<ListEventHubFunctionsResult> pfResult = new PlayFabResult<ListEventHubFunctionsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all currently registered Azure Functions for a given title.
     * @param request ListFunctionsRequest
     * @return Async Task will return ListFunctionsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListFunctionsResult>> ListFunctionsAsync(final ListFunctionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListFunctionsResult>>() {
            public PlayFabResult<ListFunctionsResult> call() throws Exception {
                return privateListFunctionsAsync(request);
            }
        });
    }

    /**
     * Lists all currently registered Azure Functions for a given title.
     * @param request ListFunctionsRequest
     * @return ListFunctionsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListFunctionsResult> ListFunctions(final ListFunctionsRequest request) {
        FutureTask<PlayFabResult<ListFunctionsResult>> task = new FutureTask(new Callable<PlayFabResult<ListFunctionsResult>>() {
            public PlayFabResult<ListFunctionsResult> call() throws Exception {
                return privateListFunctionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListFunctionsResult> exceptionResult = new PlayFabResult<ListFunctionsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists all currently registered Azure Functions for a given title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListFunctionsResult> privateListFunctionsAsync(final ListFunctionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/ListFunctions"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListFunctionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListFunctionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListFunctionsResult>>(){}.getType());
        ListFunctionsResult result = resultData.data;

        PlayFabResult<ListFunctionsResult> pfResult = new PlayFabResult<ListFunctionsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all currently registered HTTP triggered Azure Functions for a given title.
     * @param request ListFunctionsRequest
     * @return Async Task will return ListHttpFunctionsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListHttpFunctionsResult>> ListHttpFunctionsAsync(final ListFunctionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListHttpFunctionsResult>>() {
            public PlayFabResult<ListHttpFunctionsResult> call() throws Exception {
                return privateListHttpFunctionsAsync(request);
            }
        });
    }

    /**
     * Lists all currently registered HTTP triggered Azure Functions for a given title.
     * @param request ListFunctionsRequest
     * @return ListHttpFunctionsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListHttpFunctionsResult> ListHttpFunctions(final ListFunctionsRequest request) {
        FutureTask<PlayFabResult<ListHttpFunctionsResult>> task = new FutureTask(new Callable<PlayFabResult<ListHttpFunctionsResult>>() {
            public PlayFabResult<ListHttpFunctionsResult> call() throws Exception {
                return privateListHttpFunctionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListHttpFunctionsResult> exceptionResult = new PlayFabResult<ListHttpFunctionsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists all currently registered HTTP triggered Azure Functions for a given title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListHttpFunctionsResult> privateListHttpFunctionsAsync(final ListFunctionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/ListHttpFunctions"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListHttpFunctionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListHttpFunctionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListHttpFunctionsResult>>(){}.getType());
        ListHttpFunctionsResult result = resultData.data;

        PlayFabResult<ListHttpFunctionsResult> pfResult = new PlayFabResult<ListHttpFunctionsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all currently registered Queue triggered Azure Functions for a given title.
     * @param request ListFunctionsRequest
     * @return Async Task will return ListQueuedFunctionsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListQueuedFunctionsResult>> ListQueuedFunctionsAsync(final ListFunctionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListQueuedFunctionsResult>>() {
            public PlayFabResult<ListQueuedFunctionsResult> call() throws Exception {
                return privateListQueuedFunctionsAsync(request);
            }
        });
    }

    /**
     * Lists all currently registered Queue triggered Azure Functions for a given title.
     * @param request ListFunctionsRequest
     * @return ListQueuedFunctionsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListQueuedFunctionsResult> ListQueuedFunctions(final ListFunctionsRequest request) {
        FutureTask<PlayFabResult<ListQueuedFunctionsResult>> task = new FutureTask(new Callable<PlayFabResult<ListQueuedFunctionsResult>>() {
            public PlayFabResult<ListQueuedFunctionsResult> call() throws Exception {
                return privateListQueuedFunctionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListQueuedFunctionsResult> exceptionResult = new PlayFabResult<ListQueuedFunctionsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists all currently registered Queue triggered Azure Functions for a given title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListQueuedFunctionsResult> privateListQueuedFunctionsAsync(final ListFunctionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/ListQueuedFunctions"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListQueuedFunctionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListQueuedFunctionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListQueuedFunctionsResult>>(){}.getType());
        ListQueuedFunctionsResult result = resultData.data;

        PlayFabResult<ListQueuedFunctionsResult> pfResult = new PlayFabResult<ListQueuedFunctionsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Generate an entity PlayStream event for the provided function result.
     * @param request PostFunctionResultForEntityTriggeredActionRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> PostFunctionResultForEntityTriggeredActionAsync(final PostFunctionResultForEntityTriggeredActionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privatePostFunctionResultForEntityTriggeredActionAsync(request);
            }
        });
    }

    /**
     * Generate an entity PlayStream event for the provided function result.
     * @param request PostFunctionResultForEntityTriggeredActionRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> PostFunctionResultForEntityTriggeredAction(final PostFunctionResultForEntityTriggeredActionRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privatePostFunctionResultForEntityTriggeredActionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Generate an entity PlayStream event for the provided function result. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privatePostFunctionResultForEntityTriggeredActionAsync(final PostFunctionResultForEntityTriggeredActionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/PostFunctionResultForEntityTriggeredAction"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Generate an entity PlayStream event for the provided function result.
     * @param request PostFunctionResultForFunctionExecutionRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> PostFunctionResultForFunctionExecutionAsync(final PostFunctionResultForFunctionExecutionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privatePostFunctionResultForFunctionExecutionAsync(request);
            }
        });
    }

    /**
     * Generate an entity PlayStream event for the provided function result.
     * @param request PostFunctionResultForFunctionExecutionRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> PostFunctionResultForFunctionExecution(final PostFunctionResultForFunctionExecutionRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privatePostFunctionResultForFunctionExecutionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Generate an entity PlayStream event for the provided function result. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privatePostFunctionResultForFunctionExecutionAsync(final PostFunctionResultForFunctionExecutionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/PostFunctionResultForFunctionExecution"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Generate a player PlayStream event for the provided function result.
     * @param request PostFunctionResultForPlayerTriggeredActionRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> PostFunctionResultForPlayerTriggeredActionAsync(final PostFunctionResultForPlayerTriggeredActionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privatePostFunctionResultForPlayerTriggeredActionAsync(request);
            }
        });
    }

    /**
     * Generate a player PlayStream event for the provided function result.
     * @param request PostFunctionResultForPlayerTriggeredActionRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> PostFunctionResultForPlayerTriggeredAction(final PostFunctionResultForPlayerTriggeredActionRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privatePostFunctionResultForPlayerTriggeredActionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Generate a player PlayStream event for the provided function result. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privatePostFunctionResultForPlayerTriggeredActionAsync(final PostFunctionResultForPlayerTriggeredActionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/PostFunctionResultForPlayerTriggeredAction"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Generate a PlayStream event for the provided function result.
     * @param request PostFunctionResultForScheduledTaskRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> PostFunctionResultForScheduledTaskAsync(final PostFunctionResultForScheduledTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privatePostFunctionResultForScheduledTaskAsync(request);
            }
        });
    }

    /**
     * Generate a PlayStream event for the provided function result.
     * @param request PostFunctionResultForScheduledTaskRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> PostFunctionResultForScheduledTask(final PostFunctionResultForScheduledTaskRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privatePostFunctionResultForScheduledTaskAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Generate a PlayStream event for the provided function result. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privatePostFunctionResultForScheduledTaskAsync(final PostFunctionResultForScheduledTaskRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/PostFunctionResultForScheduledTask"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Registers an event hub triggered Azure Function with a title.
     * @param request RegisterEventHubFunctionRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> RegisterEventHubFunctionAsync(final RegisterEventHubFunctionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRegisterEventHubFunctionAsync(request);
            }
        });
    }

    /**
     * Registers an event hub triggered Azure Function with a title.
     * @param request RegisterEventHubFunctionRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> RegisterEventHubFunction(final RegisterEventHubFunctionRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRegisterEventHubFunctionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Registers an event hub triggered Azure Function with a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateRegisterEventHubFunctionAsync(final RegisterEventHubFunctionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/RegisterEventHubFunction"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Registers an HTTP triggered Azure function with a title.
     * @param request RegisterHttpFunctionRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> RegisterHttpFunctionAsync(final RegisterHttpFunctionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRegisterHttpFunctionAsync(request);
            }
        });
    }

    /**
     * Registers an HTTP triggered Azure function with a title.
     * @param request RegisterHttpFunctionRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> RegisterHttpFunction(final RegisterHttpFunctionRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRegisterHttpFunctionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Registers an HTTP triggered Azure function with a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateRegisterHttpFunctionAsync(final RegisterHttpFunctionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/RegisterHttpFunction"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Registers a queue triggered Azure Function with a title.
     * @param request RegisterQueuedFunctionRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> RegisterQueuedFunctionAsync(final RegisterQueuedFunctionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRegisterQueuedFunctionAsync(request);
            }
        });
    }

    /**
     * Registers a queue triggered Azure Function with a title.
     * @param request RegisterQueuedFunctionRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> RegisterQueuedFunction(final RegisterQueuedFunctionRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRegisterQueuedFunctionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Registers a queue triggered Azure Function with a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateRegisterQueuedFunctionAsync(final RegisterQueuedFunctionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/RegisterQueuedFunction"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Unregisters an Azure Function with a title.
     * @param request UnregisterFunctionRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> UnregisterFunctionAsync(final UnregisterFunctionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateUnregisterFunctionAsync(request);
            }
        });
    }

    /**
     * Unregisters an Azure Function with a title.
     * @param request UnregisterFunctionRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> UnregisterFunction(final UnregisterFunctionRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateUnregisterFunctionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResult> exceptionResult = new PlayFabResult<EmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unregisters an Azure Function with a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResult> privateUnregisterFunctionAsync(final UnregisterFunctionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/CloudScript/UnregisterFunction"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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

}
