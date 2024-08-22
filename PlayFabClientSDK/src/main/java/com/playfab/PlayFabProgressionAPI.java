package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabProgressionModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** Manage entity statistics Manage entity leaderboards */
public class PlayFabProgressionAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Creates a new leaderboard definition.
     * @param request CreateLeaderboardDefinitionRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> CreateLeaderboardDefinitionAsync(final CreateLeaderboardDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateCreateLeaderboardDefinitionAsync(request);
            }
        });
    }

    /**
     * Creates a new leaderboard definition.
     * @param request CreateLeaderboardDefinitionRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> CreateLeaderboardDefinition(final CreateLeaderboardDefinitionRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateCreateLeaderboardDefinitionAsync(request);
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

    /** Creates a new leaderboard definition. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateCreateLeaderboardDefinitionAsync(final CreateLeaderboardDefinitionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/CreateLeaderboardDefinition"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Create a new entity statistic definition.
     * @param request CreateStatisticDefinitionRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> CreateStatisticDefinitionAsync(final CreateStatisticDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateCreateStatisticDefinitionAsync(request);
            }
        });
    }

    /**
     * Create a new entity statistic definition.
     * @param request CreateStatisticDefinitionRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> CreateStatisticDefinition(final CreateStatisticDefinitionRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateCreateStatisticDefinitionAsync(request);
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

    /** Create a new entity statistic definition. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateCreateStatisticDefinitionAsync(final CreateStatisticDefinitionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/CreateStatisticDefinition"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Deletes a leaderboard definition.
     * @param request DeleteLeaderboardDefinitionRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteLeaderboardDefinitionAsync(final DeleteLeaderboardDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteLeaderboardDefinitionAsync(request);
            }
        });
    }

    /**
     * Deletes a leaderboard definition.
     * @param request DeleteLeaderboardDefinitionRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteLeaderboardDefinition(final DeleteLeaderboardDefinitionRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteLeaderboardDefinitionAsync(request);
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

    /** Deletes a leaderboard definition. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteLeaderboardDefinitionAsync(final DeleteLeaderboardDefinitionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/DeleteLeaderboardDefinition"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Deletes the specified entries from the given leaderboard.
     * @param request DeleteLeaderboardEntriesRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteLeaderboardEntriesAsync(final DeleteLeaderboardEntriesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteLeaderboardEntriesAsync(request);
            }
        });
    }

    /**
     * Deletes the specified entries from the given leaderboard.
     * @param request DeleteLeaderboardEntriesRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteLeaderboardEntries(final DeleteLeaderboardEntriesRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteLeaderboardEntriesAsync(request);
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

    /** Deletes the specified entries from the given leaderboard. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteLeaderboardEntriesAsync(final DeleteLeaderboardEntriesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/DeleteLeaderboardEntries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Delete an entity statistic definition. Will delete all statistics on entity profiles and leaderboards.
     * @param request DeleteStatisticDefinitionRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteStatisticDefinitionAsync(final DeleteStatisticDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteStatisticDefinitionAsync(request);
            }
        });
    }

    /**
     * Delete an entity statistic definition. Will delete all statistics on entity profiles and leaderboards.
     * @param request DeleteStatisticDefinitionRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteStatisticDefinition(final DeleteStatisticDefinitionRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteStatisticDefinitionAsync(request);
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

    /** Delete an entity statistic definition. Will delete all statistics on entity profiles and leaderboards. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteStatisticDefinitionAsync(final DeleteStatisticDefinitionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/DeleteStatisticDefinition"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Delete statistics on an entity profile. This will remove all rankings from associated leaderboards.
     * @param request DeleteStatisticsRequest
     * @return Async Task will return DeleteStatisticsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteStatisticsResponse>> DeleteStatisticsAsync(final DeleteStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteStatisticsResponse>>() {
            public PlayFabResult<DeleteStatisticsResponse> call() throws Exception {
                return privateDeleteStatisticsAsync(request);
            }
        });
    }

    /**
     * Delete statistics on an entity profile. This will remove all rankings from associated leaderboards.
     * @param request DeleteStatisticsRequest
     * @return DeleteStatisticsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteStatisticsResponse> DeleteStatistics(final DeleteStatisticsRequest request) {
        FutureTask<PlayFabResult<DeleteStatisticsResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteStatisticsResponse>>() {
            public PlayFabResult<DeleteStatisticsResponse> call() throws Exception {
                return privateDeleteStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteStatisticsResponse> exceptionResult = new PlayFabResult<DeleteStatisticsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Delete statistics on an entity profile. This will remove all rankings from associated leaderboards. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteStatisticsResponse> privateDeleteStatisticsAsync(final DeleteStatisticsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/DeleteStatistics"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteStatisticsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteStatisticsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteStatisticsResponse>>(){}.getType());
        DeleteStatisticsResponse result = resultData.data;

        PlayFabResult<DeleteStatisticsResponse> pfResult = new PlayFabResult<DeleteStatisticsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get the friend leaderboard for the specified entity. A maximum of 100 friend entries are listed in the leaderboard.
     * @param request GetFriendLeaderboardForEntityRequest
     * @return Async Task will return GetEntityLeaderboardResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityLeaderboardResponse>> GetFriendLeaderboardForEntityAsync(final GetFriendLeaderboardForEntityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityLeaderboardResponse>>() {
            public PlayFabResult<GetEntityLeaderboardResponse> call() throws Exception {
                return privateGetFriendLeaderboardForEntityAsync(request);
            }
        });
    }

    /**
     * Get the friend leaderboard for the specified entity. A maximum of 100 friend entries are listed in the leaderboard.
     * @param request GetFriendLeaderboardForEntityRequest
     * @return GetEntityLeaderboardResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityLeaderboardResponse> GetFriendLeaderboardForEntity(final GetFriendLeaderboardForEntityRequest request) {
        FutureTask<PlayFabResult<GetEntityLeaderboardResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityLeaderboardResponse>>() {
            public PlayFabResult<GetEntityLeaderboardResponse> call() throws Exception {
                return privateGetFriendLeaderboardForEntityAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetEntityLeaderboardResponse> exceptionResult = new PlayFabResult<GetEntityLeaderboardResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get the friend leaderboard for the specified entity. A maximum of 100 friend entries are listed in the leaderboard. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityLeaderboardResponse> privateGetFriendLeaderboardForEntityAsync(final GetFriendLeaderboardForEntityRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/GetFriendLeaderboardForEntity"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityLeaderboardResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityLeaderboardResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityLeaderboardResponse>>(){}.getType());
        GetEntityLeaderboardResponse result = resultData.data;

        PlayFabResult<GetEntityLeaderboardResponse> pfResult = new PlayFabResult<GetEntityLeaderboardResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get the leaderboard for a specific entity type and statistic.
     * @param request GetEntityLeaderboardRequest
     * @return Async Task will return GetEntityLeaderboardResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityLeaderboardResponse>> GetLeaderboardAsync(final GetEntityLeaderboardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityLeaderboardResponse>>() {
            public PlayFabResult<GetEntityLeaderboardResponse> call() throws Exception {
                return privateGetLeaderboardAsync(request);
            }
        });
    }

    /**
     * Get the leaderboard for a specific entity type and statistic.
     * @param request GetEntityLeaderboardRequest
     * @return GetEntityLeaderboardResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityLeaderboardResponse> GetLeaderboard(final GetEntityLeaderboardRequest request) {
        FutureTask<PlayFabResult<GetEntityLeaderboardResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityLeaderboardResponse>>() {
            public PlayFabResult<GetEntityLeaderboardResponse> call() throws Exception {
                return privateGetLeaderboardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetEntityLeaderboardResponse> exceptionResult = new PlayFabResult<GetEntityLeaderboardResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get the leaderboard for a specific entity type and statistic. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityLeaderboardResponse> privateGetLeaderboardAsync(final GetEntityLeaderboardRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/GetLeaderboard"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityLeaderboardResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityLeaderboardResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityLeaderboardResponse>>(){}.getType());
        GetEntityLeaderboardResponse result = resultData.data;

        PlayFabResult<GetEntityLeaderboardResponse> pfResult = new PlayFabResult<GetEntityLeaderboardResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get the leaderboard around a specific entity.
     * @param request GetLeaderboardAroundEntityRequest
     * @return Async Task will return GetEntityLeaderboardResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityLeaderboardResponse>> GetLeaderboardAroundEntityAsync(final GetLeaderboardAroundEntityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityLeaderboardResponse>>() {
            public PlayFabResult<GetEntityLeaderboardResponse> call() throws Exception {
                return privateGetLeaderboardAroundEntityAsync(request);
            }
        });
    }

    /**
     * Get the leaderboard around a specific entity.
     * @param request GetLeaderboardAroundEntityRequest
     * @return GetEntityLeaderboardResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityLeaderboardResponse> GetLeaderboardAroundEntity(final GetLeaderboardAroundEntityRequest request) {
        FutureTask<PlayFabResult<GetEntityLeaderboardResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityLeaderboardResponse>>() {
            public PlayFabResult<GetEntityLeaderboardResponse> call() throws Exception {
                return privateGetLeaderboardAroundEntityAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetEntityLeaderboardResponse> exceptionResult = new PlayFabResult<GetEntityLeaderboardResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get the leaderboard around a specific entity. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityLeaderboardResponse> privateGetLeaderboardAroundEntityAsync(final GetLeaderboardAroundEntityRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/GetLeaderboardAroundEntity"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityLeaderboardResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityLeaderboardResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityLeaderboardResponse>>(){}.getType());
        GetEntityLeaderboardResponse result = resultData.data;

        PlayFabResult<GetEntityLeaderboardResponse> pfResult = new PlayFabResult<GetEntityLeaderboardResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the specified leaderboard definition.
     * @param request GetLeaderboardDefinitionRequest
     * @return Async Task will return GetLeaderboardDefinitionResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLeaderboardDefinitionResponse>> GetLeaderboardDefinitionAsync(final GetLeaderboardDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardDefinitionResponse>>() {
            public PlayFabResult<GetLeaderboardDefinitionResponse> call() throws Exception {
                return privateGetLeaderboardDefinitionAsync(request);
            }
        });
    }

    /**
     * Gets the specified leaderboard definition.
     * @param request GetLeaderboardDefinitionRequest
     * @return GetLeaderboardDefinitionResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLeaderboardDefinitionResponse> GetLeaderboardDefinition(final GetLeaderboardDefinitionRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardDefinitionResponse>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardDefinitionResponse>>() {
            public PlayFabResult<GetLeaderboardDefinitionResponse> call() throws Exception {
                return privateGetLeaderboardDefinitionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetLeaderboardDefinitionResponse> exceptionResult = new PlayFabResult<GetLeaderboardDefinitionResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the specified leaderboard definition. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLeaderboardDefinitionResponse> privateGetLeaderboardDefinitionAsync(final GetLeaderboardDefinitionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/GetLeaderboardDefinition"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardDefinitionResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetLeaderboardDefinitionResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardDefinitionResponse>>(){}.getType());
        GetLeaderboardDefinitionResponse result = resultData.data;

        PlayFabResult<GetLeaderboardDefinitionResponse> pfResult = new PlayFabResult<GetLeaderboardDefinitionResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get the leaderboard limited to a set of entities.
     * @param request GetLeaderboardForEntitiesRequest
     * @return Async Task will return GetEntityLeaderboardResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityLeaderboardResponse>> GetLeaderboardForEntitiesAsync(final GetLeaderboardForEntitiesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityLeaderboardResponse>>() {
            public PlayFabResult<GetEntityLeaderboardResponse> call() throws Exception {
                return privateGetLeaderboardForEntitiesAsync(request);
            }
        });
    }

    /**
     * Get the leaderboard limited to a set of entities.
     * @param request GetLeaderboardForEntitiesRequest
     * @return GetEntityLeaderboardResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityLeaderboardResponse> GetLeaderboardForEntities(final GetLeaderboardForEntitiesRequest request) {
        FutureTask<PlayFabResult<GetEntityLeaderboardResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityLeaderboardResponse>>() {
            public PlayFabResult<GetEntityLeaderboardResponse> call() throws Exception {
                return privateGetLeaderboardForEntitiesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetEntityLeaderboardResponse> exceptionResult = new PlayFabResult<GetEntityLeaderboardResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get the leaderboard limited to a set of entities. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityLeaderboardResponse> privateGetLeaderboardForEntitiesAsync(final GetLeaderboardForEntitiesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/GetLeaderboardForEntities"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityLeaderboardResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityLeaderboardResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityLeaderboardResponse>>(){}.getType());
        GetEntityLeaderboardResponse result = resultData.data;

        PlayFabResult<GetEntityLeaderboardResponse> pfResult = new PlayFabResult<GetEntityLeaderboardResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get current statistic definition information
     * @param request GetStatisticDefinitionRequest
     * @return Async Task will return GetStatisticDefinitionResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetStatisticDefinitionResponse>> GetStatisticDefinitionAsync(final GetStatisticDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetStatisticDefinitionResponse>>() {
            public PlayFabResult<GetStatisticDefinitionResponse> call() throws Exception {
                return privateGetStatisticDefinitionAsync(request);
            }
        });
    }

    /**
     * Get current statistic definition information
     * @param request GetStatisticDefinitionRequest
     * @return GetStatisticDefinitionResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetStatisticDefinitionResponse> GetStatisticDefinition(final GetStatisticDefinitionRequest request) {
        FutureTask<PlayFabResult<GetStatisticDefinitionResponse>> task = new FutureTask(new Callable<PlayFabResult<GetStatisticDefinitionResponse>>() {
            public PlayFabResult<GetStatisticDefinitionResponse> call() throws Exception {
                return privateGetStatisticDefinitionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetStatisticDefinitionResponse> exceptionResult = new PlayFabResult<GetStatisticDefinitionResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get current statistic definition information */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetStatisticDefinitionResponse> privateGetStatisticDefinitionAsync(final GetStatisticDefinitionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/GetStatisticDefinition"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetStatisticDefinitionResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetStatisticDefinitionResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetStatisticDefinitionResponse>>(){}.getType());
        GetStatisticDefinitionResponse result = resultData.data;

        PlayFabResult<GetStatisticDefinitionResponse> pfResult = new PlayFabResult<GetStatisticDefinitionResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get all current statistic definitions information
     * @param request GetStatisticDefinitionsRequest
     * @return Async Task will return GetStatisticDefinitionsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetStatisticDefinitionsResponse>> GetStatisticDefinitionsAsync(final GetStatisticDefinitionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetStatisticDefinitionsResponse>>() {
            public PlayFabResult<GetStatisticDefinitionsResponse> call() throws Exception {
                return privateGetStatisticDefinitionsAsync(request);
            }
        });
    }

    /**
     * Get all current statistic definitions information
     * @param request GetStatisticDefinitionsRequest
     * @return GetStatisticDefinitionsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetStatisticDefinitionsResponse> GetStatisticDefinitions(final GetStatisticDefinitionsRequest request) {
        FutureTask<PlayFabResult<GetStatisticDefinitionsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetStatisticDefinitionsResponse>>() {
            public PlayFabResult<GetStatisticDefinitionsResponse> call() throws Exception {
                return privateGetStatisticDefinitionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetStatisticDefinitionsResponse> exceptionResult = new PlayFabResult<GetStatisticDefinitionsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get all current statistic definitions information */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetStatisticDefinitionsResponse> privateGetStatisticDefinitionsAsync(final GetStatisticDefinitionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/GetStatisticDefinitions"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetStatisticDefinitionsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetStatisticDefinitionsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetStatisticDefinitionsResponse>>(){}.getType());
        GetStatisticDefinitionsResponse result = resultData.data;

        PlayFabResult<GetStatisticDefinitionsResponse> pfResult = new PlayFabResult<GetStatisticDefinitionsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets statistics for the specified entity.
     * @param request GetStatisticsRequest
     * @return Async Task will return GetStatisticsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetStatisticsResponse>> GetStatisticsAsync(final GetStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetStatisticsResponse>>() {
            public PlayFabResult<GetStatisticsResponse> call() throws Exception {
                return privateGetStatisticsAsync(request);
            }
        });
    }

    /**
     * Gets statistics for the specified entity.
     * @param request GetStatisticsRequest
     * @return GetStatisticsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetStatisticsResponse> GetStatistics(final GetStatisticsRequest request) {
        FutureTask<PlayFabResult<GetStatisticsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetStatisticsResponse>>() {
            public PlayFabResult<GetStatisticsResponse> call() throws Exception {
                return privateGetStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetStatisticsResponse> exceptionResult = new PlayFabResult<GetStatisticsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets statistics for the specified entity. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetStatisticsResponse> privateGetStatisticsAsync(final GetStatisticsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/GetStatistics"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetStatisticsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetStatisticsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetStatisticsResponse>>(){}.getType());
        GetStatisticsResponse result = resultData.data;

        PlayFabResult<GetStatisticsResponse> pfResult = new PlayFabResult<GetStatisticsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets statistics for the specified collection of entities.
     * @param request GetStatisticsForEntitiesRequest
     * @return Async Task will return GetStatisticsForEntitiesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetStatisticsForEntitiesResponse>> GetStatisticsForEntitiesAsync(final GetStatisticsForEntitiesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetStatisticsForEntitiesResponse>>() {
            public PlayFabResult<GetStatisticsForEntitiesResponse> call() throws Exception {
                return privateGetStatisticsForEntitiesAsync(request);
            }
        });
    }

    /**
     * Gets statistics for the specified collection of entities.
     * @param request GetStatisticsForEntitiesRequest
     * @return GetStatisticsForEntitiesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetStatisticsForEntitiesResponse> GetStatisticsForEntities(final GetStatisticsForEntitiesRequest request) {
        FutureTask<PlayFabResult<GetStatisticsForEntitiesResponse>> task = new FutureTask(new Callable<PlayFabResult<GetStatisticsForEntitiesResponse>>() {
            public PlayFabResult<GetStatisticsForEntitiesResponse> call() throws Exception {
                return privateGetStatisticsForEntitiesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetStatisticsForEntitiesResponse> exceptionResult = new PlayFabResult<GetStatisticsForEntitiesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets statistics for the specified collection of entities. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetStatisticsForEntitiesResponse> privateGetStatisticsForEntitiesAsync(final GetStatisticsForEntitiesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/GetStatisticsForEntities"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetStatisticsForEntitiesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetStatisticsForEntitiesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetStatisticsForEntitiesResponse>>(){}.getType());
        GetStatisticsForEntitiesResponse result = resultData.data;

        PlayFabResult<GetStatisticsForEntitiesResponse> pfResult = new PlayFabResult<GetStatisticsForEntitiesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Increment a leaderboard version.
     * @param request IncrementLeaderboardVersionRequest
     * @return Async Task will return IncrementLeaderboardVersionResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<IncrementLeaderboardVersionResponse>> IncrementLeaderboardVersionAsync(final IncrementLeaderboardVersionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<IncrementLeaderboardVersionResponse>>() {
            public PlayFabResult<IncrementLeaderboardVersionResponse> call() throws Exception {
                return privateIncrementLeaderboardVersionAsync(request);
            }
        });
    }

    /**
     * Increment a leaderboard version.
     * @param request IncrementLeaderboardVersionRequest
     * @return IncrementLeaderboardVersionResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<IncrementLeaderboardVersionResponse> IncrementLeaderboardVersion(final IncrementLeaderboardVersionRequest request) {
        FutureTask<PlayFabResult<IncrementLeaderboardVersionResponse>> task = new FutureTask(new Callable<PlayFabResult<IncrementLeaderboardVersionResponse>>() {
            public PlayFabResult<IncrementLeaderboardVersionResponse> call() throws Exception {
                return privateIncrementLeaderboardVersionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<IncrementLeaderboardVersionResponse> exceptionResult = new PlayFabResult<IncrementLeaderboardVersionResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Increment a leaderboard version. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<IncrementLeaderboardVersionResponse> privateIncrementLeaderboardVersionAsync(final IncrementLeaderboardVersionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/IncrementLeaderboardVersion"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<IncrementLeaderboardVersionResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<IncrementLeaderboardVersionResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<IncrementLeaderboardVersionResponse>>(){}.getType());
        IncrementLeaderboardVersionResponse result = resultData.data;

        PlayFabResult<IncrementLeaderboardVersionResponse> pfResult = new PlayFabResult<IncrementLeaderboardVersionResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Increment an entity statistic definition version.
     * @param request IncrementStatisticVersionRequest
     * @return Async Task will return IncrementStatisticVersionResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<IncrementStatisticVersionResponse>> IncrementStatisticVersionAsync(final IncrementStatisticVersionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<IncrementStatisticVersionResponse>>() {
            public PlayFabResult<IncrementStatisticVersionResponse> call() throws Exception {
                return privateIncrementStatisticVersionAsync(request);
            }
        });
    }

    /**
     * Increment an entity statistic definition version.
     * @param request IncrementStatisticVersionRequest
     * @return IncrementStatisticVersionResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<IncrementStatisticVersionResponse> IncrementStatisticVersion(final IncrementStatisticVersionRequest request) {
        FutureTask<PlayFabResult<IncrementStatisticVersionResponse>> task = new FutureTask(new Callable<PlayFabResult<IncrementStatisticVersionResponse>>() {
            public PlayFabResult<IncrementStatisticVersionResponse> call() throws Exception {
                return privateIncrementStatisticVersionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<IncrementStatisticVersionResponse> exceptionResult = new PlayFabResult<IncrementStatisticVersionResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Increment an entity statistic definition version. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<IncrementStatisticVersionResponse> privateIncrementStatisticVersionAsync(final IncrementStatisticVersionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/IncrementStatisticVersion"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<IncrementStatisticVersionResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<IncrementStatisticVersionResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<IncrementStatisticVersionResponse>>(){}.getType());
        IncrementStatisticVersionResponse result = resultData.data;

        PlayFabResult<IncrementStatisticVersionResponse> pfResult = new PlayFabResult<IncrementStatisticVersionResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists the leaderboard definitions defined for the Title.
     * @param request ListLeaderboardDefinitionsRequest
     * @return Async Task will return ListLeaderboardDefinitionsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListLeaderboardDefinitionsResponse>> ListLeaderboardDefinitionsAsync(final ListLeaderboardDefinitionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListLeaderboardDefinitionsResponse>>() {
            public PlayFabResult<ListLeaderboardDefinitionsResponse> call() throws Exception {
                return privateListLeaderboardDefinitionsAsync(request);
            }
        });
    }

    /**
     * Lists the leaderboard definitions defined for the Title.
     * @param request ListLeaderboardDefinitionsRequest
     * @return ListLeaderboardDefinitionsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListLeaderboardDefinitionsResponse> ListLeaderboardDefinitions(final ListLeaderboardDefinitionsRequest request) {
        FutureTask<PlayFabResult<ListLeaderboardDefinitionsResponse>> task = new FutureTask(new Callable<PlayFabResult<ListLeaderboardDefinitionsResponse>>() {
            public PlayFabResult<ListLeaderboardDefinitionsResponse> call() throws Exception {
                return privateListLeaderboardDefinitionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListLeaderboardDefinitionsResponse> exceptionResult = new PlayFabResult<ListLeaderboardDefinitionsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists the leaderboard definitions defined for the Title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListLeaderboardDefinitionsResponse> privateListLeaderboardDefinitionsAsync(final ListLeaderboardDefinitionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/ListLeaderboardDefinitions"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListLeaderboardDefinitionsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListLeaderboardDefinitionsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListLeaderboardDefinitionsResponse>>(){}.getType());
        ListLeaderboardDefinitionsResponse result = resultData.data;

        PlayFabResult<ListLeaderboardDefinitionsResponse> pfResult = new PlayFabResult<ListLeaderboardDefinitionsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get all current statistic definitions information
     * @param request ListStatisticDefinitionsRequest
     * @return Async Task will return ListStatisticDefinitionsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListStatisticDefinitionsResponse>> ListStatisticDefinitionsAsync(final ListStatisticDefinitionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListStatisticDefinitionsResponse>>() {
            public PlayFabResult<ListStatisticDefinitionsResponse> call() throws Exception {
                return privateListStatisticDefinitionsAsync(request);
            }
        });
    }

    /**
     * Get all current statistic definitions information
     * @param request ListStatisticDefinitionsRequest
     * @return ListStatisticDefinitionsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListStatisticDefinitionsResponse> ListStatisticDefinitions(final ListStatisticDefinitionsRequest request) {
        FutureTask<PlayFabResult<ListStatisticDefinitionsResponse>> task = new FutureTask(new Callable<PlayFabResult<ListStatisticDefinitionsResponse>>() {
            public PlayFabResult<ListStatisticDefinitionsResponse> call() throws Exception {
                return privateListStatisticDefinitionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListStatisticDefinitionsResponse> exceptionResult = new PlayFabResult<ListStatisticDefinitionsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get all current statistic definitions information */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListStatisticDefinitionsResponse> privateListStatisticDefinitionsAsync(final ListStatisticDefinitionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/ListStatisticDefinitions"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListStatisticDefinitionsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListStatisticDefinitionsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListStatisticDefinitionsResponse>>(){}.getType());
        ListStatisticDefinitionsResponse result = resultData.data;

        PlayFabResult<ListStatisticDefinitionsResponse> pfResult = new PlayFabResult<ListStatisticDefinitionsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unlinks a leaderboard definition from it's linked statistic definition.
     * @param request UnlinkLeaderboardFromStatisticRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UnlinkLeaderboardFromStatisticAsync(final UnlinkLeaderboardFromStatisticRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkLeaderboardFromStatisticAsync(request);
            }
        });
    }

    /**
     * Unlinks a leaderboard definition from it's linked statistic definition.
     * @param request UnlinkLeaderboardFromStatisticRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UnlinkLeaderboardFromStatistic(final UnlinkLeaderboardFromStatisticRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnlinkLeaderboardFromStatisticAsync(request);
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

    /** Unlinks a leaderboard definition from it's linked statistic definition. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUnlinkLeaderboardFromStatisticAsync(final UnlinkLeaderboardFromStatisticRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/UnlinkLeaderboardFromStatistic"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Adds or updates entries on the specified leaderboard.
     * @param request UpdateLeaderboardEntriesRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateLeaderboardEntriesAsync(final UpdateLeaderboardEntriesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateLeaderboardEntriesAsync(request);
            }
        });
    }

    /**
     * Adds or updates entries on the specified leaderboard.
     * @param request UpdateLeaderboardEntriesRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateLeaderboardEntries(final UpdateLeaderboardEntriesRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateLeaderboardEntriesAsync(request);
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

    /** Adds or updates entries on the specified leaderboard. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateLeaderboardEntriesAsync(final UpdateLeaderboardEntriesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Leaderboard/UpdateLeaderboardEntries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Update statistics on an entity profile. Depending on the statistic definition, this may result in entity being ranked on
     * various leaderboards.
     * @param request UpdateStatisticsRequest
     * @return Async Task will return UpdateStatisticsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateStatisticsResponse>> UpdateStatisticsAsync(final UpdateStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateStatisticsResponse>>() {
            public PlayFabResult<UpdateStatisticsResponse> call() throws Exception {
                return privateUpdateStatisticsAsync(request);
            }
        });
    }

    /**
     * Update statistics on an entity profile. Depending on the statistic definition, this may result in entity being ranked on
     * various leaderboards.
     * @param request UpdateStatisticsRequest
     * @return UpdateStatisticsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateStatisticsResponse> UpdateStatistics(final UpdateStatisticsRequest request) {
        FutureTask<PlayFabResult<UpdateStatisticsResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdateStatisticsResponse>>() {
            public PlayFabResult<UpdateStatisticsResponse> call() throws Exception {
                return privateUpdateStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateStatisticsResponse> exceptionResult = new PlayFabResult<UpdateStatisticsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Update statistics on an entity profile. Depending on the statistic definition, this may result in entity being ranked on
     * various leaderboards.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateStatisticsResponse> privateUpdateStatisticsAsync(final UpdateStatisticsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Statistic/UpdateStatistics"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateStatisticsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateStatisticsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateStatisticsResponse>>(){}.getType());
        UpdateStatisticsResponse result = resultData.data;

        PlayFabResult<UpdateStatisticsResponse> pfResult = new PlayFabResult<UpdateStatisticsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

}
