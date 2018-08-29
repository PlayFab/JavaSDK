package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabDataModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /**
     * Store arbitrary data associated with an entity. Objects are small (~1KB) JSON-compatible objects which are stored
     * directly on the entity profile. Objects are made available for use in other PlayFab contexts, such as PlayStream events
     * and CloudScript functions. Files can efficiently store data of any size or format. Both objects and files support a
     * flexible permissions system to control read and write access by other entities.
     */
public class PlayFabDataAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Abort pending file uploads to an entity's profile.
     * @param request AbortFileUploadsRequest
     * @return Async Task will return AbortFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AbortFileUploadsResponse>> AbortFileUploadsAsync(final AbortFileUploadsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AbortFileUploadsResponse>>() {
            public PlayFabResult<AbortFileUploadsResponse> call() throws Exception {
                return privateAbortFileUploadsAsync(request);
            }
        });
    }

    /**
     * Abort pending file uploads to an entity's profile.
     * @param request AbortFileUploadsRequest
     * @return AbortFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AbortFileUploadsResponse> AbortFileUploads(final AbortFileUploadsRequest request) {
        FutureTask<PlayFabResult<AbortFileUploadsResponse>> task = new FutureTask(new Callable<PlayFabResult<AbortFileUploadsResponse>>() {
            public PlayFabResult<AbortFileUploadsResponse> call() throws Exception {
                return privateAbortFileUploadsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Abort pending file uploads to an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AbortFileUploadsResponse> privateAbortFileUploadsAsync(final AbortFileUploadsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/File/AbortFileUploads"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AbortFileUploadsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AbortFileUploadsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AbortFileUploadsResponse>>(){}.getType());
        AbortFileUploadsResponse result = resultData.data;

        PlayFabResult<AbortFileUploadsResponse> pfResult = new PlayFabResult<AbortFileUploadsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Delete files on an entity's profile.
     * @param request DeleteFilesRequest
     * @return Async Task will return DeleteFilesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteFilesResponse>> DeleteFilesAsync(final DeleteFilesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteFilesResponse>>() {
            public PlayFabResult<DeleteFilesResponse> call() throws Exception {
                return privateDeleteFilesAsync(request);
            }
        });
    }

    /**
     * Delete files on an entity's profile.
     * @param request DeleteFilesRequest
     * @return DeleteFilesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteFilesResponse> DeleteFiles(final DeleteFilesRequest request) {
        FutureTask<PlayFabResult<DeleteFilesResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteFilesResponse>>() {
            public PlayFabResult<DeleteFilesResponse> call() throws Exception {
                return privateDeleteFilesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Delete files on an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteFilesResponse> privateDeleteFilesAsync(final DeleteFilesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/File/DeleteFiles"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteFilesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteFilesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteFilesResponse>>(){}.getType());
        DeleteFilesResponse result = resultData.data;

        PlayFabResult<DeleteFilesResponse> pfResult = new PlayFabResult<DeleteFilesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Finalize file uploads to an entity's profile.
     * @param request FinalizeFileUploadsRequest
     * @return Async Task will return FinalizeFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<FinalizeFileUploadsResponse>> FinalizeFileUploadsAsync(final FinalizeFileUploadsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<FinalizeFileUploadsResponse>>() {
            public PlayFabResult<FinalizeFileUploadsResponse> call() throws Exception {
                return privateFinalizeFileUploadsAsync(request);
            }
        });
    }

    /**
     * Finalize file uploads to an entity's profile.
     * @param request FinalizeFileUploadsRequest
     * @return FinalizeFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<FinalizeFileUploadsResponse> FinalizeFileUploads(final FinalizeFileUploadsRequest request) {
        FutureTask<PlayFabResult<FinalizeFileUploadsResponse>> task = new FutureTask(new Callable<PlayFabResult<FinalizeFileUploadsResponse>>() {
            public PlayFabResult<FinalizeFileUploadsResponse> call() throws Exception {
                return privateFinalizeFileUploadsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Finalize file uploads to an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<FinalizeFileUploadsResponse> privateFinalizeFileUploadsAsync(final FinalizeFileUploadsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/File/FinalizeFileUploads"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<FinalizeFileUploadsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<FinalizeFileUploadsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<FinalizeFileUploadsResponse>>(){}.getType());
        FinalizeFileUploadsResponse result = resultData.data;

        PlayFabResult<FinalizeFileUploadsResponse> pfResult = new PlayFabResult<FinalizeFileUploadsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves file metadata from an entity's profile.
     * @param request GetFilesRequest
     * @return Async Task will return GetFilesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetFilesResponse>> GetFilesAsync(final GetFilesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetFilesResponse>>() {
            public PlayFabResult<GetFilesResponse> call() throws Exception {
                return privateGetFilesAsync(request);
            }
        });
    }

    /**
     * Retrieves file metadata from an entity's profile.
     * @param request GetFilesRequest
     * @return GetFilesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetFilesResponse> GetFiles(final GetFilesRequest request) {
        FutureTask<PlayFabResult<GetFilesResponse>> task = new FutureTask(new Callable<PlayFabResult<GetFilesResponse>>() {
            public PlayFabResult<GetFilesResponse> call() throws Exception {
                return privateGetFilesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves file metadata from an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetFilesResponse> privateGetFilesAsync(final GetFilesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/File/GetFiles"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetFilesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetFilesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetFilesResponse>>(){}.getType());
        GetFilesResponse result = resultData.data;

        PlayFabResult<GetFilesResponse> pfResult = new PlayFabResult<GetFilesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves objects from an entity's profile.
     * @param request GetObjectsRequest
     * @return Async Task will return GetObjectsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetObjectsResponse>> GetObjectsAsync(final GetObjectsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetObjectsResponse>>() {
            public PlayFabResult<GetObjectsResponse> call() throws Exception {
                return privateGetObjectsAsync(request);
            }
        });
    }

    /**
     * Retrieves objects from an entity's profile.
     * @param request GetObjectsRequest
     * @return GetObjectsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetObjectsResponse> GetObjects(final GetObjectsRequest request) {
        FutureTask<PlayFabResult<GetObjectsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetObjectsResponse>>() {
            public PlayFabResult<GetObjectsResponse> call() throws Exception {
                return privateGetObjectsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves objects from an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetObjectsResponse> privateGetObjectsAsync(final GetObjectsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Object/GetObjects"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetObjectsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetObjectsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetObjectsResponse>>(){}.getType());
        GetObjectsResponse result = resultData.data;

        PlayFabResult<GetObjectsResponse> pfResult = new PlayFabResult<GetObjectsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Initiates file uploads to an entity's profile.
     * @param request InitiateFileUploadsRequest
     * @return Async Task will return InitiateFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<InitiateFileUploadsResponse>> InitiateFileUploadsAsync(final InitiateFileUploadsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<InitiateFileUploadsResponse>>() {
            public PlayFabResult<InitiateFileUploadsResponse> call() throws Exception {
                return privateInitiateFileUploadsAsync(request);
            }
        });
    }

    /**
     * Initiates file uploads to an entity's profile.
     * @param request InitiateFileUploadsRequest
     * @return InitiateFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<InitiateFileUploadsResponse> InitiateFileUploads(final InitiateFileUploadsRequest request) {
        FutureTask<PlayFabResult<InitiateFileUploadsResponse>> task = new FutureTask(new Callable<PlayFabResult<InitiateFileUploadsResponse>>() {
            public PlayFabResult<InitiateFileUploadsResponse> call() throws Exception {
                return privateInitiateFileUploadsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Initiates file uploads to an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<InitiateFileUploadsResponse> privateInitiateFileUploadsAsync(final InitiateFileUploadsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/File/InitiateFileUploads"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<InitiateFileUploadsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<InitiateFileUploadsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<InitiateFileUploadsResponse>>(){}.getType());
        InitiateFileUploadsResponse result = resultData.data;

        PlayFabResult<InitiateFileUploadsResponse> pfResult = new PlayFabResult<InitiateFileUploadsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets objects on an entity's profile.
     * @param request SetObjectsRequest
     * @return Async Task will return SetObjectsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetObjectsResponse>> SetObjectsAsync(final SetObjectsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetObjectsResponse>>() {
            public PlayFabResult<SetObjectsResponse> call() throws Exception {
                return privateSetObjectsAsync(request);
            }
        });
    }

    /**
     * Sets objects on an entity's profile.
     * @param request SetObjectsRequest
     * @return SetObjectsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetObjectsResponse> SetObjects(final SetObjectsRequest request) {
        FutureTask<PlayFabResult<SetObjectsResponse>> task = new FutureTask(new Callable<PlayFabResult<SetObjectsResponse>>() {
            public PlayFabResult<SetObjectsResponse> call() throws Exception {
                return privateSetObjectsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Sets objects on an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetObjectsResponse> privateSetObjectsAsync(final SetObjectsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Object/SetObjects"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetObjectsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetObjectsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetObjectsResponse>>(){}.getType());
        SetObjectsResponse result = resultData.data;

        PlayFabResult<SetObjectsResponse> pfResult = new PlayFabResult<SetObjectsResponse>();
        pfResult.Result = result;
        return pfResult;
    }
}
