package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabMultiplayerModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** API methods for managing multiplayer servers. */
public class PlayFabMultiplayerAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Creates a multiplayer server build with a custom container.
     * @param request CreateBuildWithCustomContainerRequest
     * @return Async Task will return CreateBuildWithCustomContainerResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateBuildWithCustomContainerResponse>> CreateBuildWithCustomContainerAsync(final CreateBuildWithCustomContainerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateBuildWithCustomContainerResponse>>() {
            public PlayFabResult<CreateBuildWithCustomContainerResponse> call() throws Exception {
                return privateCreateBuildWithCustomContainerAsync(request);
            }
        });
    }

    /**
     * Creates a multiplayer server build with a custom container.
     * @param request CreateBuildWithCustomContainerRequest
     * @return CreateBuildWithCustomContainerResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateBuildWithCustomContainerResponse> CreateBuildWithCustomContainer(final CreateBuildWithCustomContainerRequest request) {
        FutureTask<PlayFabResult<CreateBuildWithCustomContainerResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateBuildWithCustomContainerResponse>>() {
            public PlayFabResult<CreateBuildWithCustomContainerResponse> call() throws Exception {
                return privateCreateBuildWithCustomContainerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Creates a multiplayer server build with a custom container. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateBuildWithCustomContainerResponse> privateCreateBuildWithCustomContainerAsync(final CreateBuildWithCustomContainerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/CreateBuildWithCustomContainer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateBuildWithCustomContainerResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateBuildWithCustomContainerResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateBuildWithCustomContainerResponse>>(){}.getType());
        CreateBuildWithCustomContainerResponse result = resultData.data;

        PlayFabResult<CreateBuildWithCustomContainerResponse> pfResult = new PlayFabResult<CreateBuildWithCustomContainerResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a multiplayer server build with a managed container.
     * @param request CreateBuildWithManagedContainerRequest
     * @return Async Task will return CreateBuildWithManagedContainerResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateBuildWithManagedContainerResponse>> CreateBuildWithManagedContainerAsync(final CreateBuildWithManagedContainerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateBuildWithManagedContainerResponse>>() {
            public PlayFabResult<CreateBuildWithManagedContainerResponse> call() throws Exception {
                return privateCreateBuildWithManagedContainerAsync(request);
            }
        });
    }

    /**
     * Creates a multiplayer server build with a managed container.
     * @param request CreateBuildWithManagedContainerRequest
     * @return CreateBuildWithManagedContainerResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateBuildWithManagedContainerResponse> CreateBuildWithManagedContainer(final CreateBuildWithManagedContainerRequest request) {
        FutureTask<PlayFabResult<CreateBuildWithManagedContainerResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateBuildWithManagedContainerResponse>>() {
            public PlayFabResult<CreateBuildWithManagedContainerResponse> call() throws Exception {
                return privateCreateBuildWithManagedContainerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Creates a multiplayer server build with a managed container. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateBuildWithManagedContainerResponse> privateCreateBuildWithManagedContainerAsync(final CreateBuildWithManagedContainerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/CreateBuildWithManagedContainer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateBuildWithManagedContainerResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateBuildWithManagedContainerResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateBuildWithManagedContainerResponse>>(){}.getType());
        CreateBuildWithManagedContainerResponse result = resultData.data;

        PlayFabResult<CreateBuildWithManagedContainerResponse> pfResult = new PlayFabResult<CreateBuildWithManagedContainerResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a remote user to log on to a VM for a multiplayer server build.
     * @param request CreateRemoteUserRequest
     * @return Async Task will return CreateRemoteUserResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateRemoteUserResponse>> CreateRemoteUserAsync(final CreateRemoteUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateRemoteUserResponse>>() {
            public PlayFabResult<CreateRemoteUserResponse> call() throws Exception {
                return privateCreateRemoteUserAsync(request);
            }
        });
    }

    /**
     * Creates a remote user to log on to a VM for a multiplayer server build.
     * @param request CreateRemoteUserRequest
     * @return CreateRemoteUserResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateRemoteUserResponse> CreateRemoteUser(final CreateRemoteUserRequest request) {
        FutureTask<PlayFabResult<CreateRemoteUserResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateRemoteUserResponse>>() {
            public PlayFabResult<CreateRemoteUserResponse> call() throws Exception {
                return privateCreateRemoteUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Creates a remote user to log on to a VM for a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateRemoteUserResponse> privateCreateRemoteUserAsync(final CreateRemoteUserRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/CreateRemoteUser"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateRemoteUserResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateRemoteUserResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateRemoteUserResponse>>(){}.getType());
        CreateRemoteUserResponse result = resultData.data;

        PlayFabResult<CreateRemoteUserResponse> pfResult = new PlayFabResult<CreateRemoteUserResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a multiplayer server game asset for a title.
     * @param request DeleteAssetRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteAssetAsync(final DeleteAssetRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteAssetAsync(request);
            }
        });
    }

    /**
     * Deletes a multiplayer server game asset for a title.
     * @param request DeleteAssetRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteAsset(final DeleteAssetRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteAssetAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Deletes a multiplayer server game asset for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteAssetAsync(final DeleteAssetRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteAsset"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Deletes a multiplayer server build.
     * @param request DeleteBuildRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteBuildAsync(final DeleteBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteBuildAsync(request);
            }
        });
    }

    /**
     * Deletes a multiplayer server build.
     * @param request DeleteBuildRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteBuild(final DeleteBuildRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteBuildAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Deletes a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteBuildAsync(final DeleteBuildRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteBuild"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Deletes a multiplayer server game certificate.
     * @param request DeleteCertificateRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteCertificateAsync(final DeleteCertificateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteCertificateAsync(request);
            }
        });
    }

    /**
     * Deletes a multiplayer server game certificate.
     * @param request DeleteCertificateRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteCertificate(final DeleteCertificateRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteCertificateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Deletes a multiplayer server game certificate. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteCertificateAsync(final DeleteCertificateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteCertificate"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Deletes a remote user to log on to a VM for a multiplayer server build.
     * @param request DeleteRemoteUserRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteRemoteUserAsync(final DeleteRemoteUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteRemoteUserAsync(request);
            }
        });
    }

    /**
     * Deletes a remote user to log on to a VM for a multiplayer server build.
     * @param request DeleteRemoteUserRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteRemoteUser(final DeleteRemoteUserRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteRemoteUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Deletes a remote user to log on to a VM for a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteRemoteUserAsync(final DeleteRemoteUserRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteRemoteUser"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Enables the multiplayer server feature for a title.
     * @param request EnableMultiplayerServersForTitleRequest
     * @return Async Task will return EnableMultiplayerServersForTitleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EnableMultiplayerServersForTitleResponse>> EnableMultiplayerServersForTitleAsync(final EnableMultiplayerServersForTitleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EnableMultiplayerServersForTitleResponse>>() {
            public PlayFabResult<EnableMultiplayerServersForTitleResponse> call() throws Exception {
                return privateEnableMultiplayerServersForTitleAsync(request);
            }
        });
    }

    /**
     * Enables the multiplayer server feature for a title.
     * @param request EnableMultiplayerServersForTitleRequest
     * @return EnableMultiplayerServersForTitleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EnableMultiplayerServersForTitleResponse> EnableMultiplayerServersForTitle(final EnableMultiplayerServersForTitleRequest request) {
        FutureTask<PlayFabResult<EnableMultiplayerServersForTitleResponse>> task = new FutureTask(new Callable<PlayFabResult<EnableMultiplayerServersForTitleResponse>>() {
            public PlayFabResult<EnableMultiplayerServersForTitleResponse> call() throws Exception {
                return privateEnableMultiplayerServersForTitleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Enables the multiplayer server feature for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EnableMultiplayerServersForTitleResponse> privateEnableMultiplayerServersForTitleAsync(final EnableMultiplayerServersForTitleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/EnableMultiplayerServersForTitle"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EnableMultiplayerServersForTitleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EnableMultiplayerServersForTitleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EnableMultiplayerServersForTitleResponse>>(){}.getType());
        EnableMultiplayerServersForTitleResponse result = resultData.data;

        PlayFabResult<EnableMultiplayerServersForTitleResponse> pfResult = new PlayFabResult<EnableMultiplayerServersForTitleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the URL to upload assets to.
     * @param request GetAssetUploadUrlRequest
     * @return Async Task will return GetAssetUploadUrlResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAssetUploadUrlResponse>> GetAssetUploadUrlAsync(final GetAssetUploadUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAssetUploadUrlResponse>>() {
            public PlayFabResult<GetAssetUploadUrlResponse> call() throws Exception {
                return privateGetAssetUploadUrlAsync(request);
            }
        });
    }

    /**
     * Gets the URL to upload assets to.
     * @param request GetAssetUploadUrlRequest
     * @return GetAssetUploadUrlResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAssetUploadUrlResponse> GetAssetUploadUrl(final GetAssetUploadUrlRequest request) {
        FutureTask<PlayFabResult<GetAssetUploadUrlResponse>> task = new FutureTask(new Callable<PlayFabResult<GetAssetUploadUrlResponse>>() {
            public PlayFabResult<GetAssetUploadUrlResponse> call() throws Exception {
                return privateGetAssetUploadUrlAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets the URL to upload assets to. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAssetUploadUrlResponse> privateGetAssetUploadUrlAsync(final GetAssetUploadUrlRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetAssetUploadUrl"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAssetUploadUrlResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAssetUploadUrlResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAssetUploadUrlResponse>>(){}.getType());
        GetAssetUploadUrlResponse result = resultData.data;

        PlayFabResult<GetAssetUploadUrlResponse> pfResult = new PlayFabResult<GetAssetUploadUrlResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a multiplayer server build.
     * @param request GetBuildRequest
     * @return Async Task will return GetBuildResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetBuildResponse>> GetBuildAsync(final GetBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetBuildResponse>>() {
            public PlayFabResult<GetBuildResponse> call() throws Exception {
                return privateGetBuildAsync(request);
            }
        });
    }

    /**
     * Gets a multiplayer server build.
     * @param request GetBuildRequest
     * @return GetBuildResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetBuildResponse> GetBuild(final GetBuildRequest request) {
        FutureTask<PlayFabResult<GetBuildResponse>> task = new FutureTask(new Callable<PlayFabResult<GetBuildResponse>>() {
            public PlayFabResult<GetBuildResponse> call() throws Exception {
                return privateGetBuildAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetBuildResponse> privateGetBuildAsync(final GetBuildRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetBuild"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetBuildResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetBuildResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetBuildResponse>>(){}.getType());
        GetBuildResponse result = resultData.data;

        PlayFabResult<GetBuildResponse> pfResult = new PlayFabResult<GetBuildResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the credentials to the container registry.
     * @param request GetContainerRegistryCredentialsRequest
     * @return Async Task will return GetContainerRegistryCredentialsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetContainerRegistryCredentialsResponse>> GetContainerRegistryCredentialsAsync(final GetContainerRegistryCredentialsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContainerRegistryCredentialsResponse>>() {
            public PlayFabResult<GetContainerRegistryCredentialsResponse> call() throws Exception {
                return privateGetContainerRegistryCredentialsAsync(request);
            }
        });
    }

    /**
     * Gets the credentials to the container registry.
     * @param request GetContainerRegistryCredentialsRequest
     * @return GetContainerRegistryCredentialsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetContainerRegistryCredentialsResponse> GetContainerRegistryCredentials(final GetContainerRegistryCredentialsRequest request) {
        FutureTask<PlayFabResult<GetContainerRegistryCredentialsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetContainerRegistryCredentialsResponse>>() {
            public PlayFabResult<GetContainerRegistryCredentialsResponse> call() throws Exception {
                return privateGetContainerRegistryCredentialsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets the credentials to the container registry. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetContainerRegistryCredentialsResponse> privateGetContainerRegistryCredentialsAsync(final GetContainerRegistryCredentialsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetContainerRegistryCredentials"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetContainerRegistryCredentialsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetContainerRegistryCredentialsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetContainerRegistryCredentialsResponse>>(){}.getType());
        GetContainerRegistryCredentialsResponse result = resultData.data;

        PlayFabResult<GetContainerRegistryCredentialsResponse> pfResult = new PlayFabResult<GetContainerRegistryCredentialsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets multiplayer server session details for a build.
     * @param request GetMultiplayerServerDetailsRequest
     * @return Async Task will return GetMultiplayerServerDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMultiplayerServerDetailsResponse>> GetMultiplayerServerDetailsAsync(final GetMultiplayerServerDetailsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMultiplayerServerDetailsResponse>>() {
            public PlayFabResult<GetMultiplayerServerDetailsResponse> call() throws Exception {
                return privateGetMultiplayerServerDetailsAsync(request);
            }
        });
    }

    /**
     * Gets multiplayer server session details for a build.
     * @param request GetMultiplayerServerDetailsRequest
     * @return GetMultiplayerServerDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMultiplayerServerDetailsResponse> GetMultiplayerServerDetails(final GetMultiplayerServerDetailsRequest request) {
        FutureTask<PlayFabResult<GetMultiplayerServerDetailsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetMultiplayerServerDetailsResponse>>() {
            public PlayFabResult<GetMultiplayerServerDetailsResponse> call() throws Exception {
                return privateGetMultiplayerServerDetailsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets multiplayer server session details for a build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMultiplayerServerDetailsResponse> privateGetMultiplayerServerDetailsAsync(final GetMultiplayerServerDetailsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetMultiplayerServerDetails"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMultiplayerServerDetailsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetMultiplayerServerDetailsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMultiplayerServerDetailsResponse>>(){}.getType());
        GetMultiplayerServerDetailsResponse result = resultData.data;

        PlayFabResult<GetMultiplayerServerDetailsResponse> pfResult = new PlayFabResult<GetMultiplayerServerDetailsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a remote login endpoint to a VM that is hosting a multiplayer server build.
     * @param request GetRemoteLoginEndpointRequest
     * @return Async Task will return GetRemoteLoginEndpointResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetRemoteLoginEndpointResponse>> GetRemoteLoginEndpointAsync(final GetRemoteLoginEndpointRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetRemoteLoginEndpointResponse>>() {
            public PlayFabResult<GetRemoteLoginEndpointResponse> call() throws Exception {
                return privateGetRemoteLoginEndpointAsync(request);
            }
        });
    }

    /**
     * Gets a remote login endpoint to a VM that is hosting a multiplayer server build.
     * @param request GetRemoteLoginEndpointRequest
     * @return GetRemoteLoginEndpointResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetRemoteLoginEndpointResponse> GetRemoteLoginEndpoint(final GetRemoteLoginEndpointRequest request) {
        FutureTask<PlayFabResult<GetRemoteLoginEndpointResponse>> task = new FutureTask(new Callable<PlayFabResult<GetRemoteLoginEndpointResponse>>() {
            public PlayFabResult<GetRemoteLoginEndpointResponse> call() throws Exception {
                return privateGetRemoteLoginEndpointAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets a remote login endpoint to a VM that is hosting a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetRemoteLoginEndpointResponse> privateGetRemoteLoginEndpointAsync(final GetRemoteLoginEndpointRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetRemoteLoginEndpoint"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetRemoteLoginEndpointResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetRemoteLoginEndpointResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetRemoteLoginEndpointResponse>>(){}.getType());
        GetRemoteLoginEndpointResponse result = resultData.data;

        PlayFabResult<GetRemoteLoginEndpointResponse> pfResult = new PlayFabResult<GetRemoteLoginEndpointResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the status of whether a title is enabled for the multiplayer server feature.
     * @param request GetTitleEnabledForMultiplayerServersStatusRequest
     * @return Async Task will return GetTitleEnabledForMultiplayerServersStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>> GetTitleEnabledForMultiplayerServersStatusAsync(final GetTitleEnabledForMultiplayerServersStatusRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>>() {
            public PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> call() throws Exception {
                return privateGetTitleEnabledForMultiplayerServersStatusAsync(request);
            }
        });
    }

    /**
     * Gets the status of whether a title is enabled for the multiplayer server feature.
     * @param request GetTitleEnabledForMultiplayerServersStatusRequest
     * @return GetTitleEnabledForMultiplayerServersStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> GetTitleEnabledForMultiplayerServersStatus(final GetTitleEnabledForMultiplayerServersStatusRequest request) {
        FutureTask<PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>> task = new FutureTask(new Callable<PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>>() {
            public PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> call() throws Exception {
                return privateGetTitleEnabledForMultiplayerServersStatusAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets the status of whether a title is enabled for the multiplayer server feature. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> privateGetTitleEnabledForMultiplayerServersStatusAsync(final GetTitleEnabledForMultiplayerServersStatusRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetTitleEnabledForMultiplayerServersStatus"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTitleEnabledForMultiplayerServersStatusResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleEnabledForMultiplayerServersStatusResponse>>(){}.getType());
        GetTitleEnabledForMultiplayerServersStatusResponse result = resultData.data;

        PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> pfResult = new PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists multiplayer server game assets for a title.
     * @param request ListAssetSummariesRequest
     * @return Async Task will return ListAssetSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListAssetSummariesResponse>> ListAssetSummariesAsync(final ListAssetSummariesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListAssetSummariesResponse>>() {
            public PlayFabResult<ListAssetSummariesResponse> call() throws Exception {
                return privateListAssetSummariesAsync(request);
            }
        });
    }

    /**
     * Lists multiplayer server game assets for a title.
     * @param request ListAssetSummariesRequest
     * @return ListAssetSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListAssetSummariesResponse> ListAssetSummaries(final ListAssetSummariesRequest request) {
        FutureTask<PlayFabResult<ListAssetSummariesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListAssetSummariesResponse>>() {
            public PlayFabResult<ListAssetSummariesResponse> call() throws Exception {
                return privateListAssetSummariesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists multiplayer server game assets for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListAssetSummariesResponse> privateListAssetSummariesAsync(final ListAssetSummariesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListAssetSummaries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListAssetSummariesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListAssetSummariesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListAssetSummariesResponse>>(){}.getType());
        ListAssetSummariesResponse result = resultData.data;

        PlayFabResult<ListAssetSummariesResponse> pfResult = new PlayFabResult<ListAssetSummariesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists summarized details of all multiplayer server builds for a title.
     * @param request ListBuildSummariesRequest
     * @return Async Task will return ListBuildSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListBuildSummariesResponse>> ListBuildSummariesAsync(final ListBuildSummariesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListBuildSummariesResponse>>() {
            public PlayFabResult<ListBuildSummariesResponse> call() throws Exception {
                return privateListBuildSummariesAsync(request);
            }
        });
    }

    /**
     * Lists summarized details of all multiplayer server builds for a title.
     * @param request ListBuildSummariesRequest
     * @return ListBuildSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListBuildSummariesResponse> ListBuildSummaries(final ListBuildSummariesRequest request) {
        FutureTask<PlayFabResult<ListBuildSummariesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListBuildSummariesResponse>>() {
            public PlayFabResult<ListBuildSummariesResponse> call() throws Exception {
                return privateListBuildSummariesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists summarized details of all multiplayer server builds for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListBuildSummariesResponse> privateListBuildSummariesAsync(final ListBuildSummariesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListBuildSummaries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListBuildSummariesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListBuildSummariesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListBuildSummariesResponse>>(){}.getType());
        ListBuildSummariesResponse result = resultData.data;

        PlayFabResult<ListBuildSummariesResponse> pfResult = new PlayFabResult<ListBuildSummariesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists multiplayer server game certificates for a title.
     * @param request ListCertificateSummariesRequest
     * @return Async Task will return ListCertificateSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListCertificateSummariesResponse>> ListCertificateSummariesAsync(final ListCertificateSummariesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListCertificateSummariesResponse>>() {
            public PlayFabResult<ListCertificateSummariesResponse> call() throws Exception {
                return privateListCertificateSummariesAsync(request);
            }
        });
    }

    /**
     * Lists multiplayer server game certificates for a title.
     * @param request ListCertificateSummariesRequest
     * @return ListCertificateSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListCertificateSummariesResponse> ListCertificateSummaries(final ListCertificateSummariesRequest request) {
        FutureTask<PlayFabResult<ListCertificateSummariesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListCertificateSummariesResponse>>() {
            public PlayFabResult<ListCertificateSummariesResponse> call() throws Exception {
                return privateListCertificateSummariesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists multiplayer server game certificates for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListCertificateSummariesResponse> privateListCertificateSummariesAsync(final ListCertificateSummariesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListCertificateSummaries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListCertificateSummariesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListCertificateSummariesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListCertificateSummariesResponse>>(){}.getType());
        ListCertificateSummariesResponse result = resultData.data;

        PlayFabResult<ListCertificateSummariesResponse> pfResult = new PlayFabResult<ListCertificateSummariesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists custom container images for a title.
     * @param request ListContainerImagesRequest
     * @return Async Task will return ListContainerImagesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListContainerImagesResponse>> ListContainerImagesAsync(final ListContainerImagesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListContainerImagesResponse>>() {
            public PlayFabResult<ListContainerImagesResponse> call() throws Exception {
                return privateListContainerImagesAsync(request);
            }
        });
    }

    /**
     * Lists custom container images for a title.
     * @param request ListContainerImagesRequest
     * @return ListContainerImagesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListContainerImagesResponse> ListContainerImages(final ListContainerImagesRequest request) {
        FutureTask<PlayFabResult<ListContainerImagesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListContainerImagesResponse>>() {
            public PlayFabResult<ListContainerImagesResponse> call() throws Exception {
                return privateListContainerImagesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists custom container images for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListContainerImagesResponse> privateListContainerImagesAsync(final ListContainerImagesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListContainerImages"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListContainerImagesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListContainerImagesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListContainerImagesResponse>>(){}.getType());
        ListContainerImagesResponse result = resultData.data;

        PlayFabResult<ListContainerImagesResponse> pfResult = new PlayFabResult<ListContainerImagesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists the tags for a custom container image.
     * @param request ListContainerImageTagsRequest
     * @return Async Task will return ListContainerImageTagsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListContainerImageTagsResponse>> ListContainerImageTagsAsync(final ListContainerImageTagsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListContainerImageTagsResponse>>() {
            public PlayFabResult<ListContainerImageTagsResponse> call() throws Exception {
                return privateListContainerImageTagsAsync(request);
            }
        });
    }

    /**
     * Lists the tags for a custom container image.
     * @param request ListContainerImageTagsRequest
     * @return ListContainerImageTagsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListContainerImageTagsResponse> ListContainerImageTags(final ListContainerImageTagsRequest request) {
        FutureTask<PlayFabResult<ListContainerImageTagsResponse>> task = new FutureTask(new Callable<PlayFabResult<ListContainerImageTagsResponse>>() {
            public PlayFabResult<ListContainerImageTagsResponse> call() throws Exception {
                return privateListContainerImageTagsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists the tags for a custom container image. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListContainerImageTagsResponse> privateListContainerImageTagsAsync(final ListContainerImageTagsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListContainerImageTags"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListContainerImageTagsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListContainerImageTagsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListContainerImageTagsResponse>>(){}.getType());
        ListContainerImageTagsResponse result = resultData.data;

        PlayFabResult<ListContainerImageTagsResponse> pfResult = new PlayFabResult<ListContainerImageTagsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists multiplayer server sessions for a build.
     * @param request ListMultiplayerServersRequest
     * @return Async Task will return ListMultiplayerServersResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListMultiplayerServersResponse>> ListMultiplayerServersAsync(final ListMultiplayerServersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListMultiplayerServersResponse>>() {
            public PlayFabResult<ListMultiplayerServersResponse> call() throws Exception {
                return privateListMultiplayerServersAsync(request);
            }
        });
    }

    /**
     * Lists multiplayer server sessions for a build.
     * @param request ListMultiplayerServersRequest
     * @return ListMultiplayerServersResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListMultiplayerServersResponse> ListMultiplayerServers(final ListMultiplayerServersRequest request) {
        FutureTask<PlayFabResult<ListMultiplayerServersResponse>> task = new FutureTask(new Callable<PlayFabResult<ListMultiplayerServersResponse>>() {
            public PlayFabResult<ListMultiplayerServersResponse> call() throws Exception {
                return privateListMultiplayerServersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists multiplayer server sessions for a build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListMultiplayerServersResponse> privateListMultiplayerServersAsync(final ListMultiplayerServersRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListMultiplayerServers"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListMultiplayerServersResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListMultiplayerServersResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListMultiplayerServersResponse>>(){}.getType());
        ListMultiplayerServersResponse result = resultData.data;

        PlayFabResult<ListMultiplayerServersResponse> pfResult = new PlayFabResult<ListMultiplayerServersResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists quality of service servers.
     * @param request ListQosServersRequest
     * @return Async Task will return ListQosServersResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListQosServersResponse>> ListQosServersAsync(final ListQosServersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListQosServersResponse>>() {
            public PlayFabResult<ListQosServersResponse> call() throws Exception {
                return privateListQosServersAsync(request);
            }
        });
    }

    /**
     * Lists quality of service servers.
     * @param request ListQosServersRequest
     * @return ListQosServersResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListQosServersResponse> ListQosServers(final ListQosServersRequest request) {
        FutureTask<PlayFabResult<ListQosServersResponse>> task = new FutureTask(new Callable<PlayFabResult<ListQosServersResponse>>() {
            public PlayFabResult<ListQosServersResponse> call() throws Exception {
                return privateListQosServersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists quality of service servers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListQosServersResponse> privateListQosServersAsync(final ListQosServersRequest request) throws Exception {

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListQosServers"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListQosServersResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListQosServersResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListQosServersResponse>>(){}.getType());
        ListQosServersResponse result = resultData.data;

        PlayFabResult<ListQosServersResponse> pfResult = new PlayFabResult<ListQosServersResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists virtual machines for a title.
     * @param request ListVirtualMachineSummariesRequest
     * @return Async Task will return ListVirtualMachineSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListVirtualMachineSummariesResponse>> ListVirtualMachineSummariesAsync(final ListVirtualMachineSummariesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListVirtualMachineSummariesResponse>>() {
            public PlayFabResult<ListVirtualMachineSummariesResponse> call() throws Exception {
                return privateListVirtualMachineSummariesAsync(request);
            }
        });
    }

    /**
     * Lists virtual machines for a title.
     * @param request ListVirtualMachineSummariesRequest
     * @return ListVirtualMachineSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListVirtualMachineSummariesResponse> ListVirtualMachineSummaries(final ListVirtualMachineSummariesRequest request) {
        FutureTask<PlayFabResult<ListVirtualMachineSummariesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListVirtualMachineSummariesResponse>>() {
            public PlayFabResult<ListVirtualMachineSummariesResponse> call() throws Exception {
                return privateListVirtualMachineSummariesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists virtual machines for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListVirtualMachineSummariesResponse> privateListVirtualMachineSummariesAsync(final ListVirtualMachineSummariesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListVirtualMachineSummaries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListVirtualMachineSummariesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListVirtualMachineSummariesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListVirtualMachineSummariesResponse>>(){}.getType());
        ListVirtualMachineSummariesResponse result = resultData.data;

        PlayFabResult<ListVirtualMachineSummariesResponse> pfResult = new PlayFabResult<ListVirtualMachineSummariesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Request a multiplayer server session. Accepts tokens for title and if game client accesss is enabled, allows game client
     * to request a server with player entity token.
     * @param request RequestMultiplayerServerRequest
     * @return Async Task will return RequestMultiplayerServerResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RequestMultiplayerServerResponse>> RequestMultiplayerServerAsync(final RequestMultiplayerServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RequestMultiplayerServerResponse>>() {
            public PlayFabResult<RequestMultiplayerServerResponse> call() throws Exception {
                return privateRequestMultiplayerServerAsync(request);
            }
        });
    }

    /**
     * Request a multiplayer server session. Accepts tokens for title and if game client accesss is enabled, allows game client
     * to request a server with player entity token.
     * @param request RequestMultiplayerServerRequest
     * @return RequestMultiplayerServerResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RequestMultiplayerServerResponse> RequestMultiplayerServer(final RequestMultiplayerServerRequest request) {
        FutureTask<PlayFabResult<RequestMultiplayerServerResponse>> task = new FutureTask(new Callable<PlayFabResult<RequestMultiplayerServerResponse>>() {
            public PlayFabResult<RequestMultiplayerServerResponse> call() throws Exception {
                return privateRequestMultiplayerServerAsync(request);
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
     * Request a multiplayer server session. Accepts tokens for title and if game client accesss is enabled, allows game client
     * to request a server with player entity token.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RequestMultiplayerServerResponse> privateRequestMultiplayerServerAsync(final RequestMultiplayerServerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/RequestMultiplayerServer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RequestMultiplayerServerResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RequestMultiplayerServerResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RequestMultiplayerServerResponse>>(){}.getType());
        RequestMultiplayerServerResponse result = resultData.data;

        PlayFabResult<RequestMultiplayerServerResponse> pfResult = new PlayFabResult<RequestMultiplayerServerResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Rolls over the credentials to the container registry.
     * @param request RolloverContainerRegistryCredentialsRequest
     * @return Async Task will return RolloverContainerRegistryCredentialsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RolloverContainerRegistryCredentialsResponse>> RolloverContainerRegistryCredentialsAsync(final RolloverContainerRegistryCredentialsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RolloverContainerRegistryCredentialsResponse>>() {
            public PlayFabResult<RolloverContainerRegistryCredentialsResponse> call() throws Exception {
                return privateRolloverContainerRegistryCredentialsAsync(request);
            }
        });
    }

    /**
     * Rolls over the credentials to the container registry.
     * @param request RolloverContainerRegistryCredentialsRequest
     * @return RolloverContainerRegistryCredentialsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RolloverContainerRegistryCredentialsResponse> RolloverContainerRegistryCredentials(final RolloverContainerRegistryCredentialsRequest request) {
        FutureTask<PlayFabResult<RolloverContainerRegistryCredentialsResponse>> task = new FutureTask(new Callable<PlayFabResult<RolloverContainerRegistryCredentialsResponse>>() {
            public PlayFabResult<RolloverContainerRegistryCredentialsResponse> call() throws Exception {
                return privateRolloverContainerRegistryCredentialsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Rolls over the credentials to the container registry. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RolloverContainerRegistryCredentialsResponse> privateRolloverContainerRegistryCredentialsAsync(final RolloverContainerRegistryCredentialsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/RolloverContainerRegistryCredentials"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RolloverContainerRegistryCredentialsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RolloverContainerRegistryCredentialsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RolloverContainerRegistryCredentialsResponse>>(){}.getType());
        RolloverContainerRegistryCredentialsResponse result = resultData.data;

        PlayFabResult<RolloverContainerRegistryCredentialsResponse> pfResult = new PlayFabResult<RolloverContainerRegistryCredentialsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Shuts down a multiplayer server session.
     * @param request ShutdownMultiplayerServerRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> ShutdownMultiplayerServerAsync(final ShutdownMultiplayerServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateShutdownMultiplayerServerAsync(request);
            }
        });
    }

    /**
     * Shuts down a multiplayer server session.
     * @param request ShutdownMultiplayerServerRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> ShutdownMultiplayerServer(final ShutdownMultiplayerServerRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateShutdownMultiplayerServerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Shuts down a multiplayer server session. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateShutdownMultiplayerServerAsync(final ShutdownMultiplayerServerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ShutdownMultiplayerServer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Updates a multiplayer server build's regions.
     * @param request UpdateBuildRegionsRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateBuildRegionsAsync(final UpdateBuildRegionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateBuildRegionsAsync(request);
            }
        });
    }

    /**
     * Updates a multiplayer server build's regions.
     * @param request UpdateBuildRegionsRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateBuildRegions(final UpdateBuildRegionsRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateBuildRegionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Updates a multiplayer server build's regions. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateBuildRegionsAsync(final UpdateBuildRegionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/UpdateBuildRegions"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Uploads a multiplayer server game certificate.
     * @param request UploadCertificateRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UploadCertificateAsync(final UploadCertificateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUploadCertificateAsync(request);
            }
        });
    }

    /**
     * Uploads a multiplayer server game certificate.
     * @param request UploadCertificateRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UploadCertificate(final UploadCertificateRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUploadCertificateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Uploads a multiplayer server game certificate. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUploadCertificateAsync(final UploadCertificateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/UploadCertificate"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
