package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabExperimentationModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** APIs for managing experiments. */
public class PlayFabExperimentationAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Creates a new experiment for a title.
     * @param request CreateExperimentRequest
     * @return Async Task will return CreateExperimentResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateExperimentResult>> CreateExperimentAsync(final CreateExperimentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateExperimentResult>>() {
            public PlayFabResult<CreateExperimentResult> call() throws Exception {
                return privateCreateExperimentAsync(request);
            }
        });
    }

    /**
     * Creates a new experiment for a title.
     * @param request CreateExperimentRequest
     * @return CreateExperimentResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateExperimentResult> CreateExperiment(final CreateExperimentRequest request) {
        FutureTask<PlayFabResult<CreateExperimentResult>> task = new FutureTask(new Callable<PlayFabResult<CreateExperimentResult>>() {
            public PlayFabResult<CreateExperimentResult> call() throws Exception {
                return privateCreateExperimentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Creates a new experiment for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateExperimentResult> privateCreateExperimentAsync(final CreateExperimentRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Experimentation/CreateExperiment"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateExperimentResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateExperimentResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateExperimentResult>>(){}.getType());
        CreateExperimentResult result = resultData.data;

        PlayFabResult<CreateExperimentResult> pfResult = new PlayFabResult<CreateExperimentResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes an existing experiment for a title.
     * @param request DeleteExperimentRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteExperimentAsync(final DeleteExperimentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteExperimentAsync(request);
            }
        });
    }

    /**
     * Deletes an existing experiment for a title.
     * @param request DeleteExperimentRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteExperiment(final DeleteExperimentRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteExperimentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Deletes an existing experiment for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteExperimentAsync(final DeleteExperimentRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Experimentation/DeleteExperiment"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Gets the details of all experiments for a title.
     * @param request GetExperimentsRequest
     * @return Async Task will return GetExperimentsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetExperimentsResult>> GetExperimentsAsync(final GetExperimentsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetExperimentsResult>>() {
            public PlayFabResult<GetExperimentsResult> call() throws Exception {
                return privateGetExperimentsAsync(request);
            }
        });
    }

    /**
     * Gets the details of all experiments for a title.
     * @param request GetExperimentsRequest
     * @return GetExperimentsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetExperimentsResult> GetExperiments(final GetExperimentsRequest request) {
        FutureTask<PlayFabResult<GetExperimentsResult>> task = new FutureTask(new Callable<PlayFabResult<GetExperimentsResult>>() {
            public PlayFabResult<GetExperimentsResult> call() throws Exception {
                return privateGetExperimentsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets the details of all experiments for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetExperimentsResult> privateGetExperimentsAsync(final GetExperimentsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Experimentation/GetExperiments"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetExperimentsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetExperimentsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetExperimentsResult>>(){}.getType());
        GetExperimentsResult result = resultData.data;

        PlayFabResult<GetExperimentsResult> pfResult = new PlayFabResult<GetExperimentsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the latest scorecard of the experiment for the title.
     * @param request GetLatestScorecardRequest
     * @return Async Task will return GetLatestScorecardResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLatestScorecardResult>> GetLatestScorecardAsync(final GetLatestScorecardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLatestScorecardResult>>() {
            public PlayFabResult<GetLatestScorecardResult> call() throws Exception {
                return privateGetLatestScorecardAsync(request);
            }
        });
    }

    /**
     * Gets the latest scorecard of the experiment for the title.
     * @param request GetLatestScorecardRequest
     * @return GetLatestScorecardResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLatestScorecardResult> GetLatestScorecard(final GetLatestScorecardRequest request) {
        FutureTask<PlayFabResult<GetLatestScorecardResult>> task = new FutureTask(new Callable<PlayFabResult<GetLatestScorecardResult>>() {
            public PlayFabResult<GetLatestScorecardResult> call() throws Exception {
                return privateGetLatestScorecardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets the latest scorecard of the experiment for the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLatestScorecardResult> privateGetLatestScorecardAsync(final GetLatestScorecardRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Experimentation/GetLatestScorecard"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLatestScorecardResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetLatestScorecardResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLatestScorecardResult>>(){}.getType());
        GetLatestScorecardResult result = resultData.data;

        PlayFabResult<GetLatestScorecardResult> pfResult = new PlayFabResult<GetLatestScorecardResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the treatment assignments for a player for every running experiment in the title.
     * @param request GetTreatmentAssignmentRequest
     * @return Async Task will return GetTreatmentAssignmentResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTreatmentAssignmentResult>> GetTreatmentAssignmentAsync(final GetTreatmentAssignmentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTreatmentAssignmentResult>>() {
            public PlayFabResult<GetTreatmentAssignmentResult> call() throws Exception {
                return privateGetTreatmentAssignmentAsync(request);
            }
        });
    }

    /**
     * Gets the treatment assignments for a player for every running experiment in the title.
     * @param request GetTreatmentAssignmentRequest
     * @return GetTreatmentAssignmentResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTreatmentAssignmentResult> GetTreatmentAssignment(final GetTreatmentAssignmentRequest request) {
        FutureTask<PlayFabResult<GetTreatmentAssignmentResult>> task = new FutureTask(new Callable<PlayFabResult<GetTreatmentAssignmentResult>>() {
            public PlayFabResult<GetTreatmentAssignmentResult> call() throws Exception {
                return privateGetTreatmentAssignmentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets the treatment assignments for a player for every running experiment in the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTreatmentAssignmentResult> privateGetTreatmentAssignmentAsync(final GetTreatmentAssignmentRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Experimentation/GetTreatmentAssignment"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTreatmentAssignmentResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTreatmentAssignmentResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTreatmentAssignmentResult>>(){}.getType());
        GetTreatmentAssignmentResult result = resultData.data;

        PlayFabResult<GetTreatmentAssignmentResult> pfResult = new PlayFabResult<GetTreatmentAssignmentResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Starts an existing experiment for a title.
     * @param request StartExperimentRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> StartExperimentAsync(final StartExperimentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateStartExperimentAsync(request);
            }
        });
    }

    /**
     * Starts an existing experiment for a title.
     * @param request StartExperimentRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> StartExperiment(final StartExperimentRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateStartExperimentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Starts an existing experiment for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateStartExperimentAsync(final StartExperimentRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Experimentation/StartExperiment"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Stops an existing experiment for a title.
     * @param request StopExperimentRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> StopExperimentAsync(final StopExperimentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateStopExperimentAsync(request);
            }
        });
    }

    /**
     * Stops an existing experiment for a title.
     * @param request StopExperimentRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> StopExperiment(final StopExperimentRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateStopExperimentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Stops an existing experiment for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateStopExperimentAsync(final StopExperimentRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Experimentation/StopExperiment"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Updates an existing experiment for a title.
     * @param request UpdateExperimentRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateExperimentAsync(final UpdateExperimentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateExperimentAsync(request);
            }
        });
    }

    /**
     * Updates an existing experiment for a title.
     * @param request UpdateExperimentRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateExperiment(final UpdateExperimentRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateExperimentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Updates an existing experiment for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateExperimentAsync(final UpdateExperimentRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Experimentation/UpdateExperiment"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
}