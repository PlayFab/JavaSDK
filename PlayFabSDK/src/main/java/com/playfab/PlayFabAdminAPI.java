package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabAdminModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** APIs for managing title configurations, uploaded Game Server code executables, and user data */
public class PlayFabAdminAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Abort an ongoing task instance.
     * @param request AbortTaskInstanceRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> AbortTaskInstanceAsync(final AbortTaskInstanceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateAbortTaskInstanceAsync(request);
            }
        });
    }

    /**
     * Abort an ongoing task instance.
     * @param request AbortTaskInstanceRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> AbortTaskInstance(final AbortTaskInstanceRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateAbortTaskInstanceAsync(request);
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

    /** Abort an ongoing task instance. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateAbortTaskInstanceAsync(final AbortTaskInstanceRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/AbortTaskInstance"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Update news item to include localized version
     * @param request AddLocalizedNewsRequest
     * @return Async Task will return AddLocalizedNewsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddLocalizedNewsResult>> AddLocalizedNewsAsync(final AddLocalizedNewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddLocalizedNewsResult>>() {
            public PlayFabResult<AddLocalizedNewsResult> call() throws Exception {
                return privateAddLocalizedNewsAsync(request);
            }
        });
    }

    /**
     * Update news item to include localized version
     * @param request AddLocalizedNewsRequest
     * @return AddLocalizedNewsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddLocalizedNewsResult> AddLocalizedNews(final AddLocalizedNewsRequest request) {
        FutureTask<PlayFabResult<AddLocalizedNewsResult>> task = new FutureTask(new Callable<PlayFabResult<AddLocalizedNewsResult>>() {
            public PlayFabResult<AddLocalizedNewsResult> call() throws Exception {
                return privateAddLocalizedNewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AddLocalizedNewsResult> exceptionResult = new PlayFabResult<AddLocalizedNewsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Update news item to include localized version */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddLocalizedNewsResult> privateAddLocalizedNewsAsync(final AddLocalizedNewsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/AddLocalizedNews"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddLocalizedNewsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AddLocalizedNewsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddLocalizedNewsResult>>(){}.getType());
        AddLocalizedNewsResult result = resultData.data;

        PlayFabResult<AddLocalizedNewsResult> pfResult = new PlayFabResult<AddLocalizedNewsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds a new news item to the title's news feed
     * @param request AddNewsRequest
     * @return Async Task will return AddNewsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddNewsResult>> AddNewsAsync(final AddNewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddNewsResult>>() {
            public PlayFabResult<AddNewsResult> call() throws Exception {
                return privateAddNewsAsync(request);
            }
        });
    }

    /**
     * Adds a new news item to the title's news feed
     * @param request AddNewsRequest
     * @return AddNewsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddNewsResult> AddNews(final AddNewsRequest request) {
        FutureTask<PlayFabResult<AddNewsResult>> task = new FutureTask(new Callable<PlayFabResult<AddNewsResult>>() {
            public PlayFabResult<AddNewsResult> call() throws Exception {
                return privateAddNewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AddNewsResult> exceptionResult = new PlayFabResult<AddNewsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Adds a new news item to the title's news feed */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddNewsResult> privateAddNewsAsync(final AddNewsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/AddNews"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddNewsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AddNewsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddNewsResult>>(){}.getType());
        AddNewsResult result = resultData.data;

        PlayFabResult<AddNewsResult> pfResult = new PlayFabResult<AddNewsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds a given tag to a player profile. The tag's namespace is automatically generated based on the source of the tag.
     * @param request AddPlayerTagRequest
     * @return Async Task will return AddPlayerTagResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddPlayerTagResult>> AddPlayerTagAsync(final AddPlayerTagRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddPlayerTagResult>>() {
            public PlayFabResult<AddPlayerTagResult> call() throws Exception {
                return privateAddPlayerTagAsync(request);
            }
        });
    }

    /**
     * Adds a given tag to a player profile. The tag's namespace is automatically generated based on the source of the tag.
     * @param request AddPlayerTagRequest
     * @return AddPlayerTagResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddPlayerTagResult> AddPlayerTag(final AddPlayerTagRequest request) {
        FutureTask<PlayFabResult<AddPlayerTagResult>> task = new FutureTask(new Callable<PlayFabResult<AddPlayerTagResult>>() {
            public PlayFabResult<AddPlayerTagResult> call() throws Exception {
                return privateAddPlayerTagAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AddPlayerTagResult> exceptionResult = new PlayFabResult<AddPlayerTagResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Adds a given tag to a player profile. The tag's namespace is automatically generated based on the source of the tag. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddPlayerTagResult> privateAddPlayerTagAsync(final AddPlayerTagRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/AddPlayerTag"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddPlayerTagResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AddPlayerTagResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddPlayerTagResult>>(){}.getType());
        AddPlayerTagResult result = resultData.data;

        PlayFabResult<AddPlayerTagResult> pfResult = new PlayFabResult<AddPlayerTagResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Increments the specified virtual currency by the stated amount
     * @param request AddUserVirtualCurrencyRequest
     * @return Async Task will return ModifyUserVirtualCurrencyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> AddUserVirtualCurrencyAsync(final AddUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateAddUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Increments the specified virtual currency by the stated amount
     * @param request AddUserVirtualCurrencyRequest
     * @return ModifyUserVirtualCurrencyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyUserVirtualCurrencyResult> AddUserVirtualCurrency(final AddUserVirtualCurrencyRequest request) {
        FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateAddUserVirtualCurrencyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ModifyUserVirtualCurrencyResult> exceptionResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Increments the specified virtual currency by the stated amount */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateAddUserVirtualCurrencyAsync(final AddUserVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/AddUserVirtualCurrency"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult>>(){}.getType());
        ModifyUserVirtualCurrencyResult result = resultData.data;

        PlayFabResult<ModifyUserVirtualCurrencyResult> pfResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds one or more virtual currencies to the set defined for the title. Virtual Currencies have a maximum value of
     * 2,147,483,647 when granted to a player. Any value over that will be discarded.
     * @param request AddVirtualCurrencyTypesRequest
     * @return Async Task will return BlankResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BlankResult>> AddVirtualCurrencyTypesAsync(final AddVirtualCurrencyTypesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateAddVirtualCurrencyTypesAsync(request);
            }
        });
    }

    /**
     * Adds one or more virtual currencies to the set defined for the title. Virtual Currencies have a maximum value of
     * 2,147,483,647 when granted to a player. Any value over that will be discarded.
     * @param request AddVirtualCurrencyTypesRequest
     * @return BlankResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BlankResult> AddVirtualCurrencyTypes(final AddVirtualCurrencyTypesRequest request) {
        FutureTask<PlayFabResult<BlankResult>> task = new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateAddVirtualCurrencyTypesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<BlankResult> exceptionResult = new PlayFabResult<BlankResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Adds one or more virtual currencies to the set defined for the title. Virtual Currencies have a maximum value of
     * 2,147,483,647 when granted to a player. Any value over that will be discarded.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BlankResult> privateAddVirtualCurrencyTypesAsync(final AddVirtualCurrencyTypesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/AddVirtualCurrencyTypes"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BlankResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<BlankResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BlankResult>>(){}.getType());
        BlankResult result = resultData.data;

        PlayFabResult<BlankResult> pfResult = new PlayFabResult<BlankResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Bans users by PlayFab ID with optional IP address, or MAC address for the provided game.
     * @param request BanUsersRequest
     * @return Async Task will return BanUsersResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BanUsersResult>> BanUsersAsync(final BanUsersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BanUsersResult>>() {
            public PlayFabResult<BanUsersResult> call() throws Exception {
                return privateBanUsersAsync(request);
            }
        });
    }

    /**
     * Bans users by PlayFab ID with optional IP address, or MAC address for the provided game.
     * @param request BanUsersRequest
     * @return BanUsersResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BanUsersResult> BanUsers(final BanUsersRequest request) {
        FutureTask<PlayFabResult<BanUsersResult>> task = new FutureTask(new Callable<PlayFabResult<BanUsersResult>>() {
            public PlayFabResult<BanUsersResult> call() throws Exception {
                return privateBanUsersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<BanUsersResult> exceptionResult = new PlayFabResult<BanUsersResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Bans users by PlayFab ID with optional IP address, or MAC address for the provided game. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BanUsersResult> privateBanUsersAsync(final BanUsersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/BanUsers"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BanUsersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<BanUsersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BanUsersResult>>(){}.getType());
        BanUsersResult result = resultData.data;

        PlayFabResult<BanUsersResult> pfResult = new PlayFabResult<BanUsersResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Checks the global count for the limited edition item.
     * @param request CheckLimitedEditionItemAvailabilityRequest
     * @return Async Task will return CheckLimitedEditionItemAvailabilityResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CheckLimitedEditionItemAvailabilityResult>> CheckLimitedEditionItemAvailabilityAsync(final CheckLimitedEditionItemAvailabilityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CheckLimitedEditionItemAvailabilityResult>>() {
            public PlayFabResult<CheckLimitedEditionItemAvailabilityResult> call() throws Exception {
                return privateCheckLimitedEditionItemAvailabilityAsync(request);
            }
        });
    }

    /**
     * Checks the global count for the limited edition item.
     * @param request CheckLimitedEditionItemAvailabilityRequest
     * @return CheckLimitedEditionItemAvailabilityResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CheckLimitedEditionItemAvailabilityResult> CheckLimitedEditionItemAvailability(final CheckLimitedEditionItemAvailabilityRequest request) {
        FutureTask<PlayFabResult<CheckLimitedEditionItemAvailabilityResult>> task = new FutureTask(new Callable<PlayFabResult<CheckLimitedEditionItemAvailabilityResult>>() {
            public PlayFabResult<CheckLimitedEditionItemAvailabilityResult> call() throws Exception {
                return privateCheckLimitedEditionItemAvailabilityAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CheckLimitedEditionItemAvailabilityResult> exceptionResult = new PlayFabResult<CheckLimitedEditionItemAvailabilityResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Checks the global count for the limited edition item. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CheckLimitedEditionItemAvailabilityResult> privateCheckLimitedEditionItemAvailabilityAsync(final CheckLimitedEditionItemAvailabilityRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/CheckLimitedEditionItemAvailability"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CheckLimitedEditionItemAvailabilityResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CheckLimitedEditionItemAvailabilityResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CheckLimitedEditionItemAvailabilityResult>>(){}.getType());
        CheckLimitedEditionItemAvailabilityResult result = resultData.data;

        PlayFabResult<CheckLimitedEditionItemAvailabilityResult> pfResult = new PlayFabResult<CheckLimitedEditionItemAvailabilityResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Create an ActionsOnPlayersInSegment task, which iterates through all players in a segment to execute action.
     * @param request CreateActionsOnPlayerSegmentTaskRequest
     * @return Async Task will return CreateTaskResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateTaskResult>> CreateActionsOnPlayersInSegmentTaskAsync(final CreateActionsOnPlayerSegmentTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateActionsOnPlayersInSegmentTaskAsync(request);
            }
        });
    }

    /**
     * Create an ActionsOnPlayersInSegment task, which iterates through all players in a segment to execute action.
     * @param request CreateActionsOnPlayerSegmentTaskRequest
     * @return CreateTaskResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateTaskResult> CreateActionsOnPlayersInSegmentTask(final CreateActionsOnPlayerSegmentTaskRequest request) {
        FutureTask<PlayFabResult<CreateTaskResult>> task = new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateActionsOnPlayersInSegmentTaskAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateTaskResult> exceptionResult = new PlayFabResult<CreateTaskResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Create an ActionsOnPlayersInSegment task, which iterates through all players in a segment to execute action. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateTaskResult> privateCreateActionsOnPlayersInSegmentTaskAsync(final CreateActionsOnPlayerSegmentTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/CreateActionsOnPlayersInSegmentTask"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateTaskResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateTaskResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateTaskResult>>(){}.getType());
        CreateTaskResult result = resultData.data;

        PlayFabResult<CreateTaskResult> pfResult = new PlayFabResult<CreateTaskResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Create a CloudScript task, which can run a CloudScript on a schedule.
     * @param request CreateCloudScriptTaskRequest
     * @return Async Task will return CreateTaskResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateTaskResult>> CreateCloudScriptTaskAsync(final CreateCloudScriptTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateCloudScriptTaskAsync(request);
            }
        });
    }

    /**
     * Create a CloudScript task, which can run a CloudScript on a schedule.
     * @param request CreateCloudScriptTaskRequest
     * @return CreateTaskResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateTaskResult> CreateCloudScriptTask(final CreateCloudScriptTaskRequest request) {
        FutureTask<PlayFabResult<CreateTaskResult>> task = new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateCloudScriptTaskAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateTaskResult> exceptionResult = new PlayFabResult<CreateTaskResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Create a CloudScript task, which can run a CloudScript on a schedule. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateTaskResult> privateCreateCloudScriptTaskAsync(final CreateCloudScriptTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/CreateCloudScriptTask"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateTaskResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateTaskResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateTaskResult>>(){}.getType());
        CreateTaskResult result = resultData.data;

        PlayFabResult<CreateTaskResult> pfResult = new PlayFabResult<CreateTaskResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Create a Insights Scheduled Scaling task, which can scale Insights Performance Units on a schedule
     * @param request CreateInsightsScheduledScalingTaskRequest
     * @return Async Task will return CreateTaskResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateTaskResult>> CreateInsightsScheduledScalingTaskAsync(final CreateInsightsScheduledScalingTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateInsightsScheduledScalingTaskAsync(request);
            }
        });
    }

    /**
     * Create a Insights Scheduled Scaling task, which can scale Insights Performance Units on a schedule
     * @param request CreateInsightsScheduledScalingTaskRequest
     * @return CreateTaskResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateTaskResult> CreateInsightsScheduledScalingTask(final CreateInsightsScheduledScalingTaskRequest request) {
        FutureTask<PlayFabResult<CreateTaskResult>> task = new FutureTask(new Callable<PlayFabResult<CreateTaskResult>>() {
            public PlayFabResult<CreateTaskResult> call() throws Exception {
                return privateCreateInsightsScheduledScalingTaskAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateTaskResult> exceptionResult = new PlayFabResult<CreateTaskResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Create a Insights Scheduled Scaling task, which can scale Insights Performance Units on a schedule */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateTaskResult> privateCreateInsightsScheduledScalingTaskAsync(final CreateInsightsScheduledScalingTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/CreateInsightsScheduledScalingTask"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateTaskResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateTaskResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateTaskResult>>(){}.getType());
        CreateTaskResult result = resultData.data;

        PlayFabResult<CreateTaskResult> pfResult = new PlayFabResult<CreateTaskResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Registers a relationship between a title and an Open ID Connect provider.
     * @param request CreateOpenIdConnectionRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> CreateOpenIdConnectionAsync(final CreateOpenIdConnectionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateCreateOpenIdConnectionAsync(request);
            }
        });
    }

    /**
     * Registers a relationship between a title and an Open ID Connect provider.
     * @param request CreateOpenIdConnectionRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> CreateOpenIdConnection(final CreateOpenIdConnectionRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateCreateOpenIdConnectionAsync(request);
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

    /** Registers a relationship between a title and an Open ID Connect provider. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateCreateOpenIdConnectionAsync(final CreateOpenIdConnectionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/CreateOpenIdConnection"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Creates a new Player Shared Secret Key. It may take up to 5 minutes for this key to become generally available after
     * this API returns.
     * @param request CreatePlayerSharedSecretRequest
     * @return Async Task will return CreatePlayerSharedSecretResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreatePlayerSharedSecretResult>> CreatePlayerSharedSecretAsync(final CreatePlayerSharedSecretRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreatePlayerSharedSecretResult>>() {
            public PlayFabResult<CreatePlayerSharedSecretResult> call() throws Exception {
                return privateCreatePlayerSharedSecretAsync(request);
            }
        });
    }

    /**
     * Creates a new Player Shared Secret Key. It may take up to 5 minutes for this key to become generally available after
     * this API returns.
     * @param request CreatePlayerSharedSecretRequest
     * @return CreatePlayerSharedSecretResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreatePlayerSharedSecretResult> CreatePlayerSharedSecret(final CreatePlayerSharedSecretRequest request) {
        FutureTask<PlayFabResult<CreatePlayerSharedSecretResult>> task = new FutureTask(new Callable<PlayFabResult<CreatePlayerSharedSecretResult>>() {
            public PlayFabResult<CreatePlayerSharedSecretResult> call() throws Exception {
                return privateCreatePlayerSharedSecretAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreatePlayerSharedSecretResult> exceptionResult = new PlayFabResult<CreatePlayerSharedSecretResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Creates a new Player Shared Secret Key. It may take up to 5 minutes for this key to become generally available after
     * this API returns.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreatePlayerSharedSecretResult> privateCreatePlayerSharedSecretAsync(final CreatePlayerSharedSecretRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/CreatePlayerSharedSecret"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreatePlayerSharedSecretResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreatePlayerSharedSecretResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreatePlayerSharedSecretResult>>(){}.getType());
        CreatePlayerSharedSecretResult result = resultData.data;

        PlayFabResult<CreatePlayerSharedSecretResult> pfResult = new PlayFabResult<CreatePlayerSharedSecretResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds a new player statistic configuration to the title, optionally allowing the developer to specify a reset interval
     * and an aggregation method.
     * @param request CreatePlayerStatisticDefinitionRequest
     * @return Async Task will return CreatePlayerStatisticDefinitionResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreatePlayerStatisticDefinitionResult>> CreatePlayerStatisticDefinitionAsync(final CreatePlayerStatisticDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreatePlayerStatisticDefinitionResult>>() {
            public PlayFabResult<CreatePlayerStatisticDefinitionResult> call() throws Exception {
                return privateCreatePlayerStatisticDefinitionAsync(request);
            }
        });
    }

    /**
     * Adds a new player statistic configuration to the title, optionally allowing the developer to specify a reset interval
     * and an aggregation method.
     * @param request CreatePlayerStatisticDefinitionRequest
     * @return CreatePlayerStatisticDefinitionResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreatePlayerStatisticDefinitionResult> CreatePlayerStatisticDefinition(final CreatePlayerStatisticDefinitionRequest request) {
        FutureTask<PlayFabResult<CreatePlayerStatisticDefinitionResult>> task = new FutureTask(new Callable<PlayFabResult<CreatePlayerStatisticDefinitionResult>>() {
            public PlayFabResult<CreatePlayerStatisticDefinitionResult> call() throws Exception {
                return privateCreatePlayerStatisticDefinitionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreatePlayerStatisticDefinitionResult> exceptionResult = new PlayFabResult<CreatePlayerStatisticDefinitionResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Adds a new player statistic configuration to the title, optionally allowing the developer to specify a reset interval
     * and an aggregation method.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreatePlayerStatisticDefinitionResult> privateCreatePlayerStatisticDefinitionAsync(final CreatePlayerStatisticDefinitionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/CreatePlayerStatisticDefinition"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreatePlayerStatisticDefinitionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreatePlayerStatisticDefinitionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreatePlayerStatisticDefinitionResult>>(){}.getType());
        CreatePlayerStatisticDefinitionResult result = resultData.data;

        PlayFabResult<CreatePlayerStatisticDefinitionResult> pfResult = new PlayFabResult<CreatePlayerStatisticDefinitionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a new player segment by defining the conditions on player properties. Also, create actions to target the player
     * segments for a title.
     * @param request CreateSegmentRequest
     * @return Async Task will return CreateSegmentResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateSegmentResponse>> CreateSegmentAsync(final CreateSegmentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateSegmentResponse>>() {
            public PlayFabResult<CreateSegmentResponse> call() throws Exception {
                return privateCreateSegmentAsync(request);
            }
        });
    }

    /**
     * Creates a new player segment by defining the conditions on player properties. Also, create actions to target the player
     * segments for a title.
     * @param request CreateSegmentRequest
     * @return CreateSegmentResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateSegmentResponse> CreateSegment(final CreateSegmentRequest request) {
        FutureTask<PlayFabResult<CreateSegmentResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateSegmentResponse>>() {
            public PlayFabResult<CreateSegmentResponse> call() throws Exception {
                return privateCreateSegmentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateSegmentResponse> exceptionResult = new PlayFabResult<CreateSegmentResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Creates a new player segment by defining the conditions on player properties. Also, create actions to target the player
     * segments for a title.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateSegmentResponse> privateCreateSegmentAsync(final CreateSegmentRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/CreateSegment"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateSegmentResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateSegmentResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateSegmentResponse>>(){}.getType());
        CreateSegmentResponse result = resultData.data;

        PlayFabResult<CreateSegmentResponse> pfResult = new PlayFabResult<CreateSegmentResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Delete a content file from the title. When deleting a file that does not exist, it returns success.
     * @param request DeleteContentRequest
     * @return Async Task will return BlankResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BlankResult>> DeleteContentAsync(final DeleteContentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateDeleteContentAsync(request);
            }
        });
    }

    /**
     * Delete a content file from the title. When deleting a file that does not exist, it returns success.
     * @param request DeleteContentRequest
     * @return BlankResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BlankResult> DeleteContent(final DeleteContentRequest request) {
        FutureTask<PlayFabResult<BlankResult>> task = new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateDeleteContentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<BlankResult> exceptionResult = new PlayFabResult<BlankResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Delete a content file from the title. When deleting a file that does not exist, it returns success. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BlankResult> privateDeleteContentAsync(final DeleteContentRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeleteContent"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BlankResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<BlankResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BlankResult>>(){}.getType());
        BlankResult result = resultData.data;

        PlayFabResult<BlankResult> pfResult = new PlayFabResult<BlankResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes a master player account entirely from all titles and deletes all associated data
     * @param request DeleteMasterPlayerAccountRequest
     * @return Async Task will return DeleteMasterPlayerAccountResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteMasterPlayerAccountResult>> DeleteMasterPlayerAccountAsync(final DeleteMasterPlayerAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteMasterPlayerAccountResult>>() {
            public PlayFabResult<DeleteMasterPlayerAccountResult> call() throws Exception {
                return privateDeleteMasterPlayerAccountAsync(request);
            }
        });
    }

    /**
     * Removes a master player account entirely from all titles and deletes all associated data
     * @param request DeleteMasterPlayerAccountRequest
     * @return DeleteMasterPlayerAccountResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteMasterPlayerAccountResult> DeleteMasterPlayerAccount(final DeleteMasterPlayerAccountRequest request) {
        FutureTask<PlayFabResult<DeleteMasterPlayerAccountResult>> task = new FutureTask(new Callable<PlayFabResult<DeleteMasterPlayerAccountResult>>() {
            public PlayFabResult<DeleteMasterPlayerAccountResult> call() throws Exception {
                return privateDeleteMasterPlayerAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteMasterPlayerAccountResult> exceptionResult = new PlayFabResult<DeleteMasterPlayerAccountResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Removes a master player account entirely from all titles and deletes all associated data */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteMasterPlayerAccountResult> privateDeleteMasterPlayerAccountAsync(final DeleteMasterPlayerAccountRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeleteMasterPlayerAccount"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteMasterPlayerAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteMasterPlayerAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteMasterPlayerAccountResult>>(){}.getType());
        DeleteMasterPlayerAccountResult result = resultData.data;

        PlayFabResult<DeleteMasterPlayerAccountResult> pfResult = new PlayFabResult<DeleteMasterPlayerAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a player's subscription
     * @param request DeleteMembershipSubscriptionRequest
     * @return Async Task will return DeleteMembershipSubscriptionResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteMembershipSubscriptionResult>> DeleteMembershipSubscriptionAsync(final DeleteMembershipSubscriptionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteMembershipSubscriptionResult>>() {
            public PlayFabResult<DeleteMembershipSubscriptionResult> call() throws Exception {
                return privateDeleteMembershipSubscriptionAsync(request);
            }
        });
    }

    /**
     * Deletes a player's subscription
     * @param request DeleteMembershipSubscriptionRequest
     * @return DeleteMembershipSubscriptionResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteMembershipSubscriptionResult> DeleteMembershipSubscription(final DeleteMembershipSubscriptionRequest request) {
        FutureTask<PlayFabResult<DeleteMembershipSubscriptionResult>> task = new FutureTask(new Callable<PlayFabResult<DeleteMembershipSubscriptionResult>>() {
            public PlayFabResult<DeleteMembershipSubscriptionResult> call() throws Exception {
                return privateDeleteMembershipSubscriptionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteMembershipSubscriptionResult> exceptionResult = new PlayFabResult<DeleteMembershipSubscriptionResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a player's subscription */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteMembershipSubscriptionResult> privateDeleteMembershipSubscriptionAsync(final DeleteMembershipSubscriptionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeleteMembershipSubscription"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteMembershipSubscriptionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteMembershipSubscriptionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteMembershipSubscriptionResult>>(){}.getType());
        DeleteMembershipSubscriptionResult result = resultData.data;

        PlayFabResult<DeleteMembershipSubscriptionResult> pfResult = new PlayFabResult<DeleteMembershipSubscriptionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes a relationship between a title and an OpenID Connect provider.
     * @param request DeleteOpenIdConnectionRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteOpenIdConnectionAsync(final DeleteOpenIdConnectionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteOpenIdConnectionAsync(request);
            }
        });
    }

    /**
     * Removes a relationship between a title and an OpenID Connect provider.
     * @param request DeleteOpenIdConnectionRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteOpenIdConnection(final DeleteOpenIdConnectionRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteOpenIdConnectionAsync(request);
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

    /** Removes a relationship between a title and an OpenID Connect provider. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteOpenIdConnectionAsync(final DeleteOpenIdConnectionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeleteOpenIdConnection"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Removes a user's player account from a title and deletes all associated data
     * @param request DeletePlayerRequest
     * @return Async Task will return DeletePlayerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeletePlayerResult>> DeletePlayerAsync(final DeletePlayerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeletePlayerResult>>() {
            public PlayFabResult<DeletePlayerResult> call() throws Exception {
                return privateDeletePlayerAsync(request);
            }
        });
    }

    /**
     * Removes a user's player account from a title and deletes all associated data
     * @param request DeletePlayerRequest
     * @return DeletePlayerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeletePlayerResult> DeletePlayer(final DeletePlayerRequest request) {
        FutureTask<PlayFabResult<DeletePlayerResult>> task = new FutureTask(new Callable<PlayFabResult<DeletePlayerResult>>() {
            public PlayFabResult<DeletePlayerResult> call() throws Exception {
                return privateDeletePlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeletePlayerResult> exceptionResult = new PlayFabResult<DeletePlayerResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Removes a user's player account from a title and deletes all associated data */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeletePlayerResult> privateDeletePlayerAsync(final DeletePlayerRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeletePlayer"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeletePlayerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeletePlayerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeletePlayerResult>>(){}.getType());
        DeletePlayerResult result = resultData.data;

        PlayFabResult<DeletePlayerResult> pfResult = new PlayFabResult<DeletePlayerResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes an existing Player Shared Secret Key. It may take up to 5 minutes for this delete to be reflected after this API
     * returns.
     * @param request DeletePlayerSharedSecretRequest
     * @return Async Task will return DeletePlayerSharedSecretResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeletePlayerSharedSecretResult>> DeletePlayerSharedSecretAsync(final DeletePlayerSharedSecretRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeletePlayerSharedSecretResult>>() {
            public PlayFabResult<DeletePlayerSharedSecretResult> call() throws Exception {
                return privateDeletePlayerSharedSecretAsync(request);
            }
        });
    }

    /**
     * Deletes an existing Player Shared Secret Key. It may take up to 5 minutes for this delete to be reflected after this API
     * returns.
     * @param request DeletePlayerSharedSecretRequest
     * @return DeletePlayerSharedSecretResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeletePlayerSharedSecretResult> DeletePlayerSharedSecret(final DeletePlayerSharedSecretRequest request) {
        FutureTask<PlayFabResult<DeletePlayerSharedSecretResult>> task = new FutureTask(new Callable<PlayFabResult<DeletePlayerSharedSecretResult>>() {
            public PlayFabResult<DeletePlayerSharedSecretResult> call() throws Exception {
                return privateDeletePlayerSharedSecretAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeletePlayerSharedSecretResult> exceptionResult = new PlayFabResult<DeletePlayerSharedSecretResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Deletes an existing Player Shared Secret Key. It may take up to 5 minutes for this delete to be reflected after this API
     * returns.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeletePlayerSharedSecretResult> privateDeletePlayerSharedSecretAsync(final DeletePlayerSharedSecretRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeletePlayerSharedSecret"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeletePlayerSharedSecretResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeletePlayerSharedSecretResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeletePlayerSharedSecretResult>>(){}.getType());
        DeletePlayerSharedSecretResult result = resultData.data;

        PlayFabResult<DeletePlayerSharedSecretResult> pfResult = new PlayFabResult<DeletePlayerSharedSecretResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes an existing player segment and its associated action(s) for a title.
     * @param request DeleteSegmentRequest
     * @return Async Task will return DeleteSegmentsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteSegmentsResponse>> DeleteSegmentAsync(final DeleteSegmentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteSegmentsResponse>>() {
            public PlayFabResult<DeleteSegmentsResponse> call() throws Exception {
                return privateDeleteSegmentAsync(request);
            }
        });
    }

    /**
     * Deletes an existing player segment and its associated action(s) for a title.
     * @param request DeleteSegmentRequest
     * @return DeleteSegmentsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteSegmentsResponse> DeleteSegment(final DeleteSegmentRequest request) {
        FutureTask<PlayFabResult<DeleteSegmentsResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteSegmentsResponse>>() {
            public PlayFabResult<DeleteSegmentsResponse> call() throws Exception {
                return privateDeleteSegmentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteSegmentsResponse> exceptionResult = new PlayFabResult<DeleteSegmentsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes an existing player segment and its associated action(s) for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteSegmentsResponse> privateDeleteSegmentAsync(final DeleteSegmentRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeleteSegment"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteSegmentsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteSegmentsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteSegmentsResponse>>(){}.getType());
        DeleteSegmentsResponse result = resultData.data;

        PlayFabResult<DeleteSegmentsResponse> pfResult = new PlayFabResult<DeleteSegmentsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes an existing virtual item store
     * @param request DeleteStoreRequest
     * @return Async Task will return DeleteStoreResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteStoreResult>> DeleteStoreAsync(final DeleteStoreRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteStoreResult>>() {
            public PlayFabResult<DeleteStoreResult> call() throws Exception {
                return privateDeleteStoreAsync(request);
            }
        });
    }

    /**
     * Deletes an existing virtual item store
     * @param request DeleteStoreRequest
     * @return DeleteStoreResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteStoreResult> DeleteStore(final DeleteStoreRequest request) {
        FutureTask<PlayFabResult<DeleteStoreResult>> task = new FutureTask(new Callable<PlayFabResult<DeleteStoreResult>>() {
            public PlayFabResult<DeleteStoreResult> call() throws Exception {
                return privateDeleteStoreAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteStoreResult> exceptionResult = new PlayFabResult<DeleteStoreResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes an existing virtual item store */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteStoreResult> privateDeleteStoreAsync(final DeleteStoreRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeleteStore"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteStoreResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteStoreResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteStoreResult>>(){}.getType());
        DeleteStoreResult result = resultData.data;

        PlayFabResult<DeleteStoreResult> pfResult = new PlayFabResult<DeleteStoreResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Delete a task.
     * @param request DeleteTaskRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteTaskAsync(final DeleteTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteTaskAsync(request);
            }
        });
    }

    /**
     * Delete a task.
     * @param request DeleteTaskRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteTask(final DeleteTaskRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteTaskAsync(request);
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

    /** Delete a task. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteTaskAsync(final DeleteTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeleteTask"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Permanently deletes a title and all associated configuration
     * @param request DeleteTitleRequest
     * @return Async Task will return DeleteTitleResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteTitleResult>> DeleteTitleAsync(final DeleteTitleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteTitleResult>>() {
            public PlayFabResult<DeleteTitleResult> call() throws Exception {
                return privateDeleteTitleAsync(request);
            }
        });
    }

    /**
     * Permanently deletes a title and all associated configuration
     * @param request DeleteTitleRequest
     * @return DeleteTitleResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteTitleResult> DeleteTitle(final DeleteTitleRequest request) {
        FutureTask<PlayFabResult<DeleteTitleResult>> task = new FutureTask(new Callable<PlayFabResult<DeleteTitleResult>>() {
            public PlayFabResult<DeleteTitleResult> call() throws Exception {
                return privateDeleteTitleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteTitleResult> exceptionResult = new PlayFabResult<DeleteTitleResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Permanently deletes a title and all associated configuration */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteTitleResult> privateDeleteTitleAsync(final DeleteTitleRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeleteTitle"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteTitleResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteTitleResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteTitleResult>>(){}.getType());
        DeleteTitleResult result = resultData.data;

        PlayFabResult<DeleteTitleResult> pfResult = new PlayFabResult<DeleteTitleResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a specified set of title data overrides.
     * @param request DeleteTitleDataOverrideRequest
     * @return Async Task will return DeleteTitleDataOverrideResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteTitleDataOverrideResult>> DeleteTitleDataOverrideAsync(final DeleteTitleDataOverrideRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteTitleDataOverrideResult>>() {
            public PlayFabResult<DeleteTitleDataOverrideResult> call() throws Exception {
                return privateDeleteTitleDataOverrideAsync(request);
            }
        });
    }

    /**
     * Deletes a specified set of title data overrides.
     * @param request DeleteTitleDataOverrideRequest
     * @return DeleteTitleDataOverrideResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteTitleDataOverrideResult> DeleteTitleDataOverride(final DeleteTitleDataOverrideRequest request) {
        FutureTask<PlayFabResult<DeleteTitleDataOverrideResult>> task = new FutureTask(new Callable<PlayFabResult<DeleteTitleDataOverrideResult>>() {
            public PlayFabResult<DeleteTitleDataOverrideResult> call() throws Exception {
                return privateDeleteTitleDataOverrideAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteTitleDataOverrideResult> exceptionResult = new PlayFabResult<DeleteTitleDataOverrideResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a specified set of title data overrides. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteTitleDataOverrideResult> privateDeleteTitleDataOverrideAsync(final DeleteTitleDataOverrideRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/DeleteTitleDataOverride"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteTitleDataOverrideResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteTitleDataOverrideResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteTitleDataOverrideResult>>(){}.getType());
        DeleteTitleDataOverrideResult result = resultData.data;

        PlayFabResult<DeleteTitleDataOverrideResult> pfResult = new PlayFabResult<DeleteTitleDataOverrideResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Exports all associated data of a master player account
     * @param request ExportMasterPlayerDataRequest
     * @return Async Task will return ExportMasterPlayerDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ExportMasterPlayerDataResult>> ExportMasterPlayerDataAsync(final ExportMasterPlayerDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ExportMasterPlayerDataResult>>() {
            public PlayFabResult<ExportMasterPlayerDataResult> call() throws Exception {
                return privateExportMasterPlayerDataAsync(request);
            }
        });
    }

    /**
     * Exports all associated data of a master player account
     * @param request ExportMasterPlayerDataRequest
     * @return ExportMasterPlayerDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ExportMasterPlayerDataResult> ExportMasterPlayerData(final ExportMasterPlayerDataRequest request) {
        FutureTask<PlayFabResult<ExportMasterPlayerDataResult>> task = new FutureTask(new Callable<PlayFabResult<ExportMasterPlayerDataResult>>() {
            public PlayFabResult<ExportMasterPlayerDataResult> call() throws Exception {
                return privateExportMasterPlayerDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ExportMasterPlayerDataResult> exceptionResult = new PlayFabResult<ExportMasterPlayerDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Exports all associated data of a master player account */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ExportMasterPlayerDataResult> privateExportMasterPlayerDataAsync(final ExportMasterPlayerDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/ExportMasterPlayerData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ExportMasterPlayerDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ExportMasterPlayerDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ExportMasterPlayerDataResult>>(){}.getType());
        ExportMasterPlayerDataResult result = resultData.data;

        PlayFabResult<ExportMasterPlayerDataResult> pfResult = new PlayFabResult<ExportMasterPlayerDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Starts an export for the player profiles in a segment. This API creates a snapshot of all the player profiles which
     * match the segment definition at the time of the API call. Profiles which change while an export is in progress will not
     * be reflected in the results.
     * @param request ExportPlayersInSegmentRequest
     * @return Async Task will return ExportPlayersInSegmentResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ExportPlayersInSegmentResult>> ExportPlayersInSegmentAsync(final ExportPlayersInSegmentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ExportPlayersInSegmentResult>>() {
            public PlayFabResult<ExportPlayersInSegmentResult> call() throws Exception {
                return privateExportPlayersInSegmentAsync(request);
            }
        });
    }

    /**
     * Starts an export for the player profiles in a segment. This API creates a snapshot of all the player profiles which
     * match the segment definition at the time of the API call. Profiles which change while an export is in progress will not
     * be reflected in the results.
     * @param request ExportPlayersInSegmentRequest
     * @return ExportPlayersInSegmentResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ExportPlayersInSegmentResult> ExportPlayersInSegment(final ExportPlayersInSegmentRequest request) {
        FutureTask<PlayFabResult<ExportPlayersInSegmentResult>> task = new FutureTask(new Callable<PlayFabResult<ExportPlayersInSegmentResult>>() {
            public PlayFabResult<ExportPlayersInSegmentResult> call() throws Exception {
                return privateExportPlayersInSegmentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ExportPlayersInSegmentResult> exceptionResult = new PlayFabResult<ExportPlayersInSegmentResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Starts an export for the player profiles in a segment. This API creates a snapshot of all the player profiles which
     * match the segment definition at the time of the API call. Profiles which change while an export is in progress will not
     * be reflected in the results.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ExportPlayersInSegmentResult> privateExportPlayersInSegmentAsync(final ExportPlayersInSegmentRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/ExportPlayersInSegment"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ExportPlayersInSegmentResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ExportPlayersInSegmentResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ExportPlayersInSegmentResult>>(){}.getType());
        ExportPlayersInSegmentResult result = resultData.data;

        PlayFabResult<ExportPlayersInSegmentResult> pfResult = new PlayFabResult<ExportPlayersInSegmentResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get information about a ActionsOnPlayersInSegment task instance.
     * @param request GetTaskInstanceRequest
     * @return Async Task will return GetActionsOnPlayersInSegmentTaskInstanceResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>> GetActionsOnPlayersInSegmentTaskInstanceAsync(final GetTaskInstanceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>>() {
            public PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> call() throws Exception {
                return privateGetActionsOnPlayersInSegmentTaskInstanceAsync(request);
            }
        });
    }

    /**
     * Get information about a ActionsOnPlayersInSegment task instance.
     * @param request GetTaskInstanceRequest
     * @return GetActionsOnPlayersInSegmentTaskInstanceResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> GetActionsOnPlayersInSegmentTaskInstance(final GetTaskInstanceRequest request) {
        FutureTask<PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>> task = new FutureTask(new Callable<PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>>() {
            public PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> call() throws Exception {
                return privateGetActionsOnPlayersInSegmentTaskInstanceAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> exceptionResult = new PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get information about a ActionsOnPlayersInSegment task instance. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> privateGetActionsOnPlayersInSegmentTaskInstanceAsync(final GetTaskInstanceRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetActionsOnPlayersInSegmentTaskInstance"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetActionsOnPlayersInSegmentTaskInstanceResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetActionsOnPlayersInSegmentTaskInstanceResult>>(){}.getType());
        GetActionsOnPlayersInSegmentTaskInstanceResult result = resultData.data;

        PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult> pfResult = new PlayFabResult<GetActionsOnPlayersInSegmentTaskInstanceResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves an array of player segment definitions. Results from this can be used in subsequent API calls such as
     * GetPlayersInSegment which requires a Segment ID. While segment names can change the ID for that segment will not change.
     * @param request GetAllSegmentsRequest
     * @return Async Task will return GetAllSegmentsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAllSegmentsResult>> GetAllSegmentsAsync(final GetAllSegmentsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAllSegmentsResult>>() {
            public PlayFabResult<GetAllSegmentsResult> call() throws Exception {
                return privateGetAllSegmentsAsync(request);
            }
        });
    }

    /**
     * Retrieves an array of player segment definitions. Results from this can be used in subsequent API calls such as
     * GetPlayersInSegment which requires a Segment ID. While segment names can change the ID for that segment will not change.
     * @param request GetAllSegmentsRequest
     * @return GetAllSegmentsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAllSegmentsResult> GetAllSegments(final GetAllSegmentsRequest request) {
        FutureTask<PlayFabResult<GetAllSegmentsResult>> task = new FutureTask(new Callable<PlayFabResult<GetAllSegmentsResult>>() {
            public PlayFabResult<GetAllSegmentsResult> call() throws Exception {
                return privateGetAllSegmentsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetAllSegmentsResult> exceptionResult = new PlayFabResult<GetAllSegmentsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves an array of player segment definitions. Results from this can be used in subsequent API calls such as
     * GetPlayersInSegment which requires a Segment ID. While segment names can change the ID for that segment will not change.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAllSegmentsResult> privateGetAllSegmentsAsync(final GetAllSegmentsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetAllSegments"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAllSegmentsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAllSegmentsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAllSegmentsResult>>(){}.getType());
        GetAllSegmentsResult result = resultData.data;

        PlayFabResult<GetAllSegmentsResult> pfResult = new PlayFabResult<GetAllSegmentsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     * @param request GetCatalogItemsRequest
     * @return Async Task will return GetCatalogItemsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCatalogItemsResult>> GetCatalogItemsAsync(final GetCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCatalogItemsResult>>() {
            public PlayFabResult<GetCatalogItemsResult> call() throws Exception {
                return privateGetCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     * @param request GetCatalogItemsRequest
     * @return GetCatalogItemsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCatalogItemsResult> GetCatalogItems(final GetCatalogItemsRequest request) {
        FutureTask<PlayFabResult<GetCatalogItemsResult>> task = new FutureTask(new Callable<PlayFabResult<GetCatalogItemsResult>>() {
            public PlayFabResult<GetCatalogItemsResult> call() throws Exception {
                return privateGetCatalogItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCatalogItemsResult> exceptionResult = new PlayFabResult<GetCatalogItemsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the specified version of the title's catalog of virtual goods, including all defined properties */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCatalogItemsResult> privateGetCatalogItemsAsync(final GetCatalogItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetCatalogItems"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCatalogItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetCatalogItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCatalogItemsResult>>(){}.getType());
        GetCatalogItemsResult result = resultData.data;

        PlayFabResult<GetCatalogItemsResult> pfResult = new PlayFabResult<GetCatalogItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the contents and information of a specific Cloud Script revision.
     * @param request GetCloudScriptRevisionRequest
     * @return Async Task will return GetCloudScriptRevisionResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCloudScriptRevisionResult>> GetCloudScriptRevisionAsync(final GetCloudScriptRevisionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCloudScriptRevisionResult>>() {
            public PlayFabResult<GetCloudScriptRevisionResult> call() throws Exception {
                return privateGetCloudScriptRevisionAsync(request);
            }
        });
    }

    /**
     * Gets the contents and information of a specific Cloud Script revision.
     * @param request GetCloudScriptRevisionRequest
     * @return GetCloudScriptRevisionResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCloudScriptRevisionResult> GetCloudScriptRevision(final GetCloudScriptRevisionRequest request) {
        FutureTask<PlayFabResult<GetCloudScriptRevisionResult>> task = new FutureTask(new Callable<PlayFabResult<GetCloudScriptRevisionResult>>() {
            public PlayFabResult<GetCloudScriptRevisionResult> call() throws Exception {
                return privateGetCloudScriptRevisionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCloudScriptRevisionResult> exceptionResult = new PlayFabResult<GetCloudScriptRevisionResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the contents and information of a specific Cloud Script revision. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCloudScriptRevisionResult> privateGetCloudScriptRevisionAsync(final GetCloudScriptRevisionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetCloudScriptRevision"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCloudScriptRevisionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetCloudScriptRevisionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCloudScriptRevisionResult>>(){}.getType());
        GetCloudScriptRevisionResult result = resultData.data;

        PlayFabResult<GetCloudScriptRevisionResult> pfResult = new PlayFabResult<GetCloudScriptRevisionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get detail information about a CloudScript task instance.
     * @param request GetTaskInstanceRequest
     * @return Async Task will return GetCloudScriptTaskInstanceResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCloudScriptTaskInstanceResult>> GetCloudScriptTaskInstanceAsync(final GetTaskInstanceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCloudScriptTaskInstanceResult>>() {
            public PlayFabResult<GetCloudScriptTaskInstanceResult> call() throws Exception {
                return privateGetCloudScriptTaskInstanceAsync(request);
            }
        });
    }

    /**
     * Get detail information about a CloudScript task instance.
     * @param request GetTaskInstanceRequest
     * @return GetCloudScriptTaskInstanceResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCloudScriptTaskInstanceResult> GetCloudScriptTaskInstance(final GetTaskInstanceRequest request) {
        FutureTask<PlayFabResult<GetCloudScriptTaskInstanceResult>> task = new FutureTask(new Callable<PlayFabResult<GetCloudScriptTaskInstanceResult>>() {
            public PlayFabResult<GetCloudScriptTaskInstanceResult> call() throws Exception {
                return privateGetCloudScriptTaskInstanceAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCloudScriptTaskInstanceResult> exceptionResult = new PlayFabResult<GetCloudScriptTaskInstanceResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get detail information about a CloudScript task instance. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCloudScriptTaskInstanceResult> privateGetCloudScriptTaskInstanceAsync(final GetTaskInstanceRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetCloudScriptTaskInstance"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCloudScriptTaskInstanceResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetCloudScriptTaskInstanceResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCloudScriptTaskInstanceResult>>(){}.getType());
        GetCloudScriptTaskInstanceResult result = resultData.data;

        PlayFabResult<GetCloudScriptTaskInstanceResult> pfResult = new PlayFabResult<GetCloudScriptTaskInstanceResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all the current cloud script versions. For each version, information about the current published and latest
     * revisions is also listed.
     * @param request GetCloudScriptVersionsRequest
     * @return Async Task will return GetCloudScriptVersionsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCloudScriptVersionsResult>> GetCloudScriptVersionsAsync(final GetCloudScriptVersionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCloudScriptVersionsResult>>() {
            public PlayFabResult<GetCloudScriptVersionsResult> call() throws Exception {
                return privateGetCloudScriptVersionsAsync(request);
            }
        });
    }

    /**
     * Lists all the current cloud script versions. For each version, information about the current published and latest
     * revisions is also listed.
     * @param request GetCloudScriptVersionsRequest
     * @return GetCloudScriptVersionsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCloudScriptVersionsResult> GetCloudScriptVersions(final GetCloudScriptVersionsRequest request) {
        FutureTask<PlayFabResult<GetCloudScriptVersionsResult>> task = new FutureTask(new Callable<PlayFabResult<GetCloudScriptVersionsResult>>() {
            public PlayFabResult<GetCloudScriptVersionsResult> call() throws Exception {
                return privateGetCloudScriptVersionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCloudScriptVersionsResult> exceptionResult = new PlayFabResult<GetCloudScriptVersionsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Lists all the current cloud script versions. For each version, information about the current published and latest
     * revisions is also listed.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCloudScriptVersionsResult> privateGetCloudScriptVersionsAsync(final GetCloudScriptVersionsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetCloudScriptVersions"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCloudScriptVersionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetCloudScriptVersionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCloudScriptVersionsResult>>(){}.getType());
        GetCloudScriptVersionsResult result = resultData.data;

        PlayFabResult<GetCloudScriptVersionsResult> pfResult = new PlayFabResult<GetCloudScriptVersionsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * List all contents of the title and get statistics such as size
     * @param request GetContentListRequest
     * @return Async Task will return GetContentListResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetContentListResult>> GetContentListAsync(final GetContentListRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContentListResult>>() {
            public PlayFabResult<GetContentListResult> call() throws Exception {
                return privateGetContentListAsync(request);
            }
        });
    }

    /**
     * List all contents of the title and get statistics such as size
     * @param request GetContentListRequest
     * @return GetContentListResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetContentListResult> GetContentList(final GetContentListRequest request) {
        FutureTask<PlayFabResult<GetContentListResult>> task = new FutureTask(new Callable<PlayFabResult<GetContentListResult>>() {
            public PlayFabResult<GetContentListResult> call() throws Exception {
                return privateGetContentListAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetContentListResult> exceptionResult = new PlayFabResult<GetContentListResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** List all contents of the title and get statistics such as size */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetContentListResult> privateGetContentListAsync(final GetContentListRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetContentList"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetContentListResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetContentListResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetContentListResult>>(){}.getType());
        GetContentListResult result = resultData.data;

        PlayFabResult<GetContentListResult> pfResult = new PlayFabResult<GetContentListResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the pre-signed URL for uploading a content file. A subsequent HTTP PUT to the returned URL uploads the
     * content. Also, please be aware that the Content service is specifically PlayFab's CDN offering, for which standard CDN
     * rates apply.
     * @param request GetContentUploadUrlRequest
     * @return Async Task will return GetContentUploadUrlResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetContentUploadUrlResult>> GetContentUploadUrlAsync(final GetContentUploadUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContentUploadUrlResult>>() {
            public PlayFabResult<GetContentUploadUrlResult> call() throws Exception {
                return privateGetContentUploadUrlAsync(request);
            }
        });
    }

    /**
     * Retrieves the pre-signed URL for uploading a content file. A subsequent HTTP PUT to the returned URL uploads the
     * content. Also, please be aware that the Content service is specifically PlayFab's CDN offering, for which standard CDN
     * rates apply.
     * @param request GetContentUploadUrlRequest
     * @return GetContentUploadUrlResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetContentUploadUrlResult> GetContentUploadUrl(final GetContentUploadUrlRequest request) {
        FutureTask<PlayFabResult<GetContentUploadUrlResult>> task = new FutureTask(new Callable<PlayFabResult<GetContentUploadUrlResult>>() {
            public PlayFabResult<GetContentUploadUrlResult> call() throws Exception {
                return privateGetContentUploadUrlAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetContentUploadUrlResult> exceptionResult = new PlayFabResult<GetContentUploadUrlResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the pre-signed URL for uploading a content file. A subsequent HTTP PUT to the returned URL uploads the
     * content. Also, please be aware that the Content service is specifically PlayFab's CDN offering, for which standard CDN
     * rates apply.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetContentUploadUrlResult> privateGetContentUploadUrlAsync(final GetContentUploadUrlRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetContentUploadUrl"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetContentUploadUrlResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetContentUploadUrlResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetContentUploadUrlResult>>(){}.getType());
        GetContentUploadUrlResult result = resultData.data;

        PlayFabResult<GetContentUploadUrlResult> pfResult = new PlayFabResult<GetContentUploadUrlResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves a download URL for the requested report
     * @param request GetDataReportRequest
     * @return Async Task will return GetDataReportResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetDataReportResult>> GetDataReportAsync(final GetDataReportRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetDataReportResult>>() {
            public PlayFabResult<GetDataReportResult> call() throws Exception {
                return privateGetDataReportAsync(request);
            }
        });
    }

    /**
     * Retrieves a download URL for the requested report
     * @param request GetDataReportRequest
     * @return GetDataReportResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetDataReportResult> GetDataReport(final GetDataReportRequest request) {
        FutureTask<PlayFabResult<GetDataReportResult>> task = new FutureTask(new Callable<PlayFabResult<GetDataReportResult>>() {
            public PlayFabResult<GetDataReportResult> call() throws Exception {
                return privateGetDataReportAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetDataReportResult> exceptionResult = new PlayFabResult<GetDataReportResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves a download URL for the requested report */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetDataReportResult> privateGetDataReportAsync(final GetDataReportRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetDataReport"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetDataReportResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetDataReportResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetDataReportResult>>(){}.getType());
        GetDataReportResult result = resultData.data;

        PlayFabResult<GetDataReportResult> pfResult = new PlayFabResult<GetDataReportResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the details for a specific completed session, including links to standard out and standard error logs
     * @param request GetMatchmakerGameInfoRequest
     * @return Async Task will return GetMatchmakerGameInfoResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMatchmakerGameInfoResult>> GetMatchmakerGameInfoAsync(final GetMatchmakerGameInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameInfoResult>>() {
            public PlayFabResult<GetMatchmakerGameInfoResult> call() throws Exception {
                return privateGetMatchmakerGameInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the details for a specific completed session, including links to standard out and standard error logs
     * @param request GetMatchmakerGameInfoRequest
     * @return GetMatchmakerGameInfoResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMatchmakerGameInfoResult> GetMatchmakerGameInfo(final GetMatchmakerGameInfoRequest request) {
        FutureTask<PlayFabResult<GetMatchmakerGameInfoResult>> task = new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameInfoResult>>() {
            public PlayFabResult<GetMatchmakerGameInfoResult> call() throws Exception {
                return privateGetMatchmakerGameInfoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetMatchmakerGameInfoResult> exceptionResult = new PlayFabResult<GetMatchmakerGameInfoResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the details for a specific completed session, including links to standard out and standard error logs */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMatchmakerGameInfoResult> privateGetMatchmakerGameInfoAsync(final GetMatchmakerGameInfoRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetMatchmakerGameInfo"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMatchmakerGameInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetMatchmakerGameInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMatchmakerGameInfoResult>>(){}.getType());
        GetMatchmakerGameInfoResult result = resultData.data;

        PlayFabResult<GetMatchmakerGameInfoResult> pfResult = new PlayFabResult<GetMatchmakerGameInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the details of defined game modes for the specified game server executable
     * @param request GetMatchmakerGameModesRequest
     * @return Async Task will return GetMatchmakerGameModesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMatchmakerGameModesResult>> GetMatchmakerGameModesAsync(final GetMatchmakerGameModesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameModesResult>>() {
            public PlayFabResult<GetMatchmakerGameModesResult> call() throws Exception {
                return privateGetMatchmakerGameModesAsync(request);
            }
        });
    }

    /**
     * Retrieves the details of defined game modes for the specified game server executable
     * @param request GetMatchmakerGameModesRequest
     * @return GetMatchmakerGameModesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMatchmakerGameModesResult> GetMatchmakerGameModes(final GetMatchmakerGameModesRequest request) {
        FutureTask<PlayFabResult<GetMatchmakerGameModesResult>> task = new FutureTask(new Callable<PlayFabResult<GetMatchmakerGameModesResult>>() {
            public PlayFabResult<GetMatchmakerGameModesResult> call() throws Exception {
                return privateGetMatchmakerGameModesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetMatchmakerGameModesResult> exceptionResult = new PlayFabResult<GetMatchmakerGameModesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the details of defined game modes for the specified game server executable */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMatchmakerGameModesResult> privateGetMatchmakerGameModesAsync(final GetMatchmakerGameModesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetMatchmakerGameModes"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMatchmakerGameModesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetMatchmakerGameModesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMatchmakerGameModesResult>>(){}.getType());
        GetMatchmakerGameModesResult result = resultData.data;

        PlayFabResult<GetMatchmakerGameModesResult> pfResult = new PlayFabResult<GetMatchmakerGameModesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get the list of titles that the player has played
     * @param request GetPlayedTitleListRequest
     * @return Async Task will return GetPlayedTitleListResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayedTitleListResult>> GetPlayedTitleListAsync(final GetPlayedTitleListRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayedTitleListResult>>() {
            public PlayFabResult<GetPlayedTitleListResult> call() throws Exception {
                return privateGetPlayedTitleListAsync(request);
            }
        });
    }

    /**
     * Get the list of titles that the player has played
     * @param request GetPlayedTitleListRequest
     * @return GetPlayedTitleListResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayedTitleListResult> GetPlayedTitleList(final GetPlayedTitleListRequest request) {
        FutureTask<PlayFabResult<GetPlayedTitleListResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayedTitleListResult>>() {
            public PlayFabResult<GetPlayedTitleListResult> call() throws Exception {
                return privateGetPlayedTitleListAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayedTitleListResult> exceptionResult = new PlayFabResult<GetPlayedTitleListResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get the list of titles that the player has played */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayedTitleListResult> privateGetPlayedTitleListAsync(final GetPlayedTitleListRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPlayedTitleList"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayedTitleListResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayedTitleListResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayedTitleListResult>>(){}.getType());
        GetPlayedTitleListResult result = resultData.data;

        PlayFabResult<GetPlayedTitleListResult> pfResult = new PlayFabResult<GetPlayedTitleListResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a player's ID from an auth token.
     * @param request GetPlayerIdFromAuthTokenRequest
     * @return Async Task will return GetPlayerIdFromAuthTokenResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerIdFromAuthTokenResult>> GetPlayerIdFromAuthTokenAsync(final GetPlayerIdFromAuthTokenRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerIdFromAuthTokenResult>>() {
            public PlayFabResult<GetPlayerIdFromAuthTokenResult> call() throws Exception {
                return privateGetPlayerIdFromAuthTokenAsync(request);
            }
        });
    }

    /**
     * Gets a player's ID from an auth token.
     * @param request GetPlayerIdFromAuthTokenRequest
     * @return GetPlayerIdFromAuthTokenResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerIdFromAuthTokenResult> GetPlayerIdFromAuthToken(final GetPlayerIdFromAuthTokenRequest request) {
        FutureTask<PlayFabResult<GetPlayerIdFromAuthTokenResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerIdFromAuthTokenResult>>() {
            public PlayFabResult<GetPlayerIdFromAuthTokenResult> call() throws Exception {
                return privateGetPlayerIdFromAuthTokenAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerIdFromAuthTokenResult> exceptionResult = new PlayFabResult<GetPlayerIdFromAuthTokenResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets a player's ID from an auth token. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerIdFromAuthTokenResult> privateGetPlayerIdFromAuthTokenAsync(final GetPlayerIdFromAuthTokenRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPlayerIdFromAuthToken"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerIdFromAuthTokenResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerIdFromAuthTokenResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerIdFromAuthTokenResult>>(){}.getType());
        GetPlayerIdFromAuthTokenResult result = resultData.data;

        PlayFabResult<GetPlayerIdFromAuthTokenResult> pfResult = new PlayFabResult<GetPlayerIdFromAuthTokenResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the player's profile
     * @param request GetPlayerProfileRequest
     * @return Async Task will return GetPlayerProfileResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerProfileResult>> GetPlayerProfileAsync(final GetPlayerProfileRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerProfileResult>>() {
            public PlayFabResult<GetPlayerProfileResult> call() throws Exception {
                return privateGetPlayerProfileAsync(request);
            }
        });
    }

    /**
     * Retrieves the player's profile
     * @param request GetPlayerProfileRequest
     * @return GetPlayerProfileResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerProfileResult> GetPlayerProfile(final GetPlayerProfileRequest request) {
        FutureTask<PlayFabResult<GetPlayerProfileResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerProfileResult>>() {
            public PlayFabResult<GetPlayerProfileResult> call() throws Exception {
                return privateGetPlayerProfileAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerProfileResult> exceptionResult = new PlayFabResult<GetPlayerProfileResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the player's profile */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerProfileResult> privateGetPlayerProfileAsync(final GetPlayerProfileRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPlayerProfile"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerProfileResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerProfileResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerProfileResult>>(){}.getType());
        GetPlayerProfileResult result = resultData.data;

        PlayFabResult<GetPlayerProfileResult> pfResult = new PlayFabResult<GetPlayerProfileResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * List all segments that a player currently belongs to at this moment in time.
     * @param request GetPlayersSegmentsRequest
     * @return Async Task will return GetPlayerSegmentsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerSegmentsResult>> GetPlayerSegmentsAsync(final GetPlayersSegmentsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerSegmentsResult>>() {
            public PlayFabResult<GetPlayerSegmentsResult> call() throws Exception {
                return privateGetPlayerSegmentsAsync(request);
            }
        });
    }

    /**
     * List all segments that a player currently belongs to at this moment in time.
     * @param request GetPlayersSegmentsRequest
     * @return GetPlayerSegmentsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerSegmentsResult> GetPlayerSegments(final GetPlayersSegmentsRequest request) {
        FutureTask<PlayFabResult<GetPlayerSegmentsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerSegmentsResult>>() {
            public PlayFabResult<GetPlayerSegmentsResult> call() throws Exception {
                return privateGetPlayerSegmentsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerSegmentsResult> exceptionResult = new PlayFabResult<GetPlayerSegmentsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** List all segments that a player currently belongs to at this moment in time. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerSegmentsResult> privateGetPlayerSegmentsAsync(final GetPlayersSegmentsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPlayerSegments"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerSegmentsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerSegmentsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerSegmentsResult>>(){}.getType());
        GetPlayerSegmentsResult result = resultData.data;

        PlayFabResult<GetPlayerSegmentsResult> pfResult = new PlayFabResult<GetPlayerSegmentsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Returns all Player Shared Secret Keys including disabled and expired.
     * @param request GetPlayerSharedSecretsRequest
     * @return Async Task will return GetPlayerSharedSecretsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerSharedSecretsResult>> GetPlayerSharedSecretsAsync(final GetPlayerSharedSecretsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerSharedSecretsResult>>() {
            public PlayFabResult<GetPlayerSharedSecretsResult> call() throws Exception {
                return privateGetPlayerSharedSecretsAsync(request);
            }
        });
    }

    /**
     * Returns all Player Shared Secret Keys including disabled and expired.
     * @param request GetPlayerSharedSecretsRequest
     * @return GetPlayerSharedSecretsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerSharedSecretsResult> GetPlayerSharedSecrets(final GetPlayerSharedSecretsRequest request) {
        FutureTask<PlayFabResult<GetPlayerSharedSecretsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerSharedSecretsResult>>() {
            public PlayFabResult<GetPlayerSharedSecretsResult> call() throws Exception {
                return privateGetPlayerSharedSecretsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerSharedSecretsResult> exceptionResult = new PlayFabResult<GetPlayerSharedSecretsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Returns all Player Shared Secret Keys including disabled and expired. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerSharedSecretsResult> privateGetPlayerSharedSecretsAsync(final GetPlayerSharedSecretsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPlayerSharedSecrets"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerSharedSecretsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerSharedSecretsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerSharedSecretsResult>>(){}.getType());
        GetPlayerSharedSecretsResult result = resultData.data;

        PlayFabResult<GetPlayerSharedSecretsResult> pfResult = new PlayFabResult<GetPlayerSharedSecretsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Allows for paging through all players in a given segment. This API creates a snapshot of all player profiles that match
     * the segment definition at the time of its creation and lives through the Total Seconds to Live, refreshing its life span
     * on each subsequent use of the Continuation Token. Profiles that change during the course of paging will not be reflected
     * in the results. AB Test segments are currently not supported by this operation. NOTE: This API is limited to being
     * called 30 times in one minute. You will be returned an error if you exceed this threshold.
     * @param request GetPlayersInSegmentRequest
     * @return Async Task will return GetPlayersInSegmentResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayersInSegmentResult>> GetPlayersInSegmentAsync(final GetPlayersInSegmentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayersInSegmentResult>>() {
            public PlayFabResult<GetPlayersInSegmentResult> call() throws Exception {
                return privateGetPlayersInSegmentAsync(request);
            }
        });
    }

    /**
     * Allows for paging through all players in a given segment. This API creates a snapshot of all player profiles that match
     * the segment definition at the time of its creation and lives through the Total Seconds to Live, refreshing its life span
     * on each subsequent use of the Continuation Token. Profiles that change during the course of paging will not be reflected
     * in the results. AB Test segments are currently not supported by this operation. NOTE: This API is limited to being
     * called 30 times in one minute. You will be returned an error if you exceed this threshold.
     * @param request GetPlayersInSegmentRequest
     * @return GetPlayersInSegmentResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayersInSegmentResult> GetPlayersInSegment(final GetPlayersInSegmentRequest request) {
        FutureTask<PlayFabResult<GetPlayersInSegmentResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayersInSegmentResult>>() {
            public PlayFabResult<GetPlayersInSegmentResult> call() throws Exception {
                return privateGetPlayersInSegmentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayersInSegmentResult> exceptionResult = new PlayFabResult<GetPlayersInSegmentResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Allows for paging through all players in a given segment. This API creates a snapshot of all player profiles that match
     * the segment definition at the time of its creation and lives through the Total Seconds to Live, refreshing its life span
     * on each subsequent use of the Continuation Token. Profiles that change during the course of paging will not be reflected
     * in the results. AB Test segments are currently not supported by this operation. NOTE: This API is limited to being
     * called 30 times in one minute. You will be returned an error if you exceed this threshold.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayersInSegmentResult> privateGetPlayersInSegmentAsync(final GetPlayersInSegmentRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPlayersInSegment"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayersInSegmentResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayersInSegmentResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayersInSegmentResult>>(){}.getType());
        GetPlayersInSegmentResult result = resultData.data;

        PlayFabResult<GetPlayersInSegmentResult> pfResult = new PlayFabResult<GetPlayersInSegmentResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the configuration information for all player statistics defined in the title, regardless of whether they have
     * a reset interval.
     * @param request GetPlayerStatisticDefinitionsRequest
     * @return Async Task will return GetPlayerStatisticDefinitionsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerStatisticDefinitionsResult>> GetPlayerStatisticDefinitionsAsync(final GetPlayerStatisticDefinitionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticDefinitionsResult>>() {
            public PlayFabResult<GetPlayerStatisticDefinitionsResult> call() throws Exception {
                return privateGetPlayerStatisticDefinitionsAsync(request);
            }
        });
    }

    /**
     * Retrieves the configuration information for all player statistics defined in the title, regardless of whether they have
     * a reset interval.
     * @param request GetPlayerStatisticDefinitionsRequest
     * @return GetPlayerStatisticDefinitionsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerStatisticDefinitionsResult> GetPlayerStatisticDefinitions(final GetPlayerStatisticDefinitionsRequest request) {
        FutureTask<PlayFabResult<GetPlayerStatisticDefinitionsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticDefinitionsResult>>() {
            public PlayFabResult<GetPlayerStatisticDefinitionsResult> call() throws Exception {
                return privateGetPlayerStatisticDefinitionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerStatisticDefinitionsResult> exceptionResult = new PlayFabResult<GetPlayerStatisticDefinitionsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the configuration information for all player statistics defined in the title, regardless of whether they have
     * a reset interval.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerStatisticDefinitionsResult> privateGetPlayerStatisticDefinitionsAsync(final GetPlayerStatisticDefinitionsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPlayerStatisticDefinitions"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerStatisticDefinitionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerStatisticDefinitionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerStatisticDefinitionsResult>>(){}.getType());
        GetPlayerStatisticDefinitionsResult result = resultData.data;

        PlayFabResult<GetPlayerStatisticDefinitionsResult> pfResult = new PlayFabResult<GetPlayerStatisticDefinitionsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the information on the available versions of the specified statistic.
     * @param request GetPlayerStatisticVersionsRequest
     * @return Async Task will return GetPlayerStatisticVersionsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerStatisticVersionsResult>> GetPlayerStatisticVersionsAsync(final GetPlayerStatisticVersionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticVersionsResult>>() {
            public PlayFabResult<GetPlayerStatisticVersionsResult> call() throws Exception {
                return privateGetPlayerStatisticVersionsAsync(request);
            }
        });
    }

    /**
     * Retrieves the information on the available versions of the specified statistic.
     * @param request GetPlayerStatisticVersionsRequest
     * @return GetPlayerStatisticVersionsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerStatisticVersionsResult> GetPlayerStatisticVersions(final GetPlayerStatisticVersionsRequest request) {
        FutureTask<PlayFabResult<GetPlayerStatisticVersionsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerStatisticVersionsResult>>() {
            public PlayFabResult<GetPlayerStatisticVersionsResult> call() throws Exception {
                return privateGetPlayerStatisticVersionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerStatisticVersionsResult> exceptionResult = new PlayFabResult<GetPlayerStatisticVersionsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the information on the available versions of the specified statistic. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerStatisticVersionsResult> privateGetPlayerStatisticVersionsAsync(final GetPlayerStatisticVersionsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPlayerStatisticVersions"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerStatisticVersionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerStatisticVersionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerStatisticVersionsResult>>(){}.getType());
        GetPlayerStatisticVersionsResult result = resultData.data;

        PlayFabResult<GetPlayerStatisticVersionsResult> pfResult = new PlayFabResult<GetPlayerStatisticVersionsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get all tags with a given Namespace (optional) from a player profile.
     * @param request GetPlayerTagsRequest
     * @return Async Task will return GetPlayerTagsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayerTagsResult>> GetPlayerTagsAsync(final GetPlayerTagsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerTagsResult>>() {
            public PlayFabResult<GetPlayerTagsResult> call() throws Exception {
                return privateGetPlayerTagsAsync(request);
            }
        });
    }

    /**
     * Get all tags with a given Namespace (optional) from a player profile.
     * @param request GetPlayerTagsRequest
     * @return GetPlayerTagsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayerTagsResult> GetPlayerTags(final GetPlayerTagsRequest request) {
        FutureTask<PlayFabResult<GetPlayerTagsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerTagsResult>>() {
            public PlayFabResult<GetPlayerTagsResult> call() throws Exception {
                return privateGetPlayerTagsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayerTagsResult> exceptionResult = new PlayFabResult<GetPlayerTagsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get all tags with a given Namespace (optional) from a player profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayerTagsResult> privateGetPlayerTagsAsync(final GetPlayerTagsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPlayerTags"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerTagsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayerTagsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerTagsResult>>(){}.getType());
        GetPlayerTagsResult result = resultData.data;

        PlayFabResult<GetPlayerTagsResult> pfResult = new PlayFabResult<GetPlayerTagsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the requested policy.
     * @param request GetPolicyRequest
     * @return Async Task will return GetPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPolicyResponse>> GetPolicyAsync(final GetPolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPolicyResponse>>() {
            public PlayFabResult<GetPolicyResponse> call() throws Exception {
                return privateGetPolicyAsync(request);
            }
        });
    }

    /**
     * Gets the requested policy.
     * @param request GetPolicyRequest
     * @return GetPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPolicyResponse> GetPolicy(final GetPolicyRequest request) {
        FutureTask<PlayFabResult<GetPolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<GetPolicyResponse>>() {
            public PlayFabResult<GetPolicyResponse> call() throws Exception {
                return privateGetPolicyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPolicyResponse> exceptionResult = new PlayFabResult<GetPolicyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the requested policy. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPolicyResponse> privateGetPolicyAsync(final GetPolicyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPolicy"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPolicyResponse>>(){}.getType());
        GetPolicyResponse result = resultData.data;

        PlayFabResult<GetPolicyResponse> pfResult = new PlayFabResult<GetPolicyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the key-value store of custom publisher settings
     * @param request GetPublisherDataRequest
     * @return Async Task will return GetPublisherDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPublisherDataResult>> GetPublisherDataAsync(final GetPublisherDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPublisherDataResult>>() {
            public PlayFabResult<GetPublisherDataResult> call() throws Exception {
                return privateGetPublisherDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom publisher settings
     * @param request GetPublisherDataRequest
     * @return GetPublisherDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPublisherDataResult> GetPublisherData(final GetPublisherDataRequest request) {
        FutureTask<PlayFabResult<GetPublisherDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetPublisherDataResult>>() {
            public PlayFabResult<GetPublisherDataResult> call() throws Exception {
                return privateGetPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPublisherDataResult> exceptionResult = new PlayFabResult<GetPublisherDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the key-value store of custom publisher settings */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPublisherDataResult> privateGetPublisherDataAsync(final GetPublisherDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetPublisherData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPublisherDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPublisherDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPublisherDataResult>>(){}.getType());
        GetPublisherDataResult result = resultData.data;

        PlayFabResult<GetPublisherDataResult> pfResult = new PlayFabResult<GetPublisherDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the random drop table configuration for the title
     * @param request GetRandomResultTablesRequest
     * @return Async Task will return GetRandomResultTablesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetRandomResultTablesResult>> GetRandomResultTablesAsync(final GetRandomResultTablesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetRandomResultTablesResult>>() {
            public PlayFabResult<GetRandomResultTablesResult> call() throws Exception {
                return privateGetRandomResultTablesAsync(request);
            }
        });
    }

    /**
     * Retrieves the random drop table configuration for the title
     * @param request GetRandomResultTablesRequest
     * @return GetRandomResultTablesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetRandomResultTablesResult> GetRandomResultTables(final GetRandomResultTablesRequest request) {
        FutureTask<PlayFabResult<GetRandomResultTablesResult>> task = new FutureTask(new Callable<PlayFabResult<GetRandomResultTablesResult>>() {
            public PlayFabResult<GetRandomResultTablesResult> call() throws Exception {
                return privateGetRandomResultTablesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetRandomResultTablesResult> exceptionResult = new PlayFabResult<GetRandomResultTablesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the random drop table configuration for the title */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetRandomResultTablesResult> privateGetRandomResultTablesAsync(final GetRandomResultTablesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetRandomResultTables"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetRandomResultTablesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetRandomResultTablesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetRandomResultTablesResult>>(){}.getType());
        GetRandomResultTablesResult result = resultData.data;

        PlayFabResult<GetRandomResultTablesResult> pfResult = new PlayFabResult<GetRandomResultTablesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the result of an export started by ExportPlayersInSegment API. If the ExportPlayersInSegment is successful and
     * complete, this API returns the IndexUrl from which the index file can be downloaded. The index file has a list of urls
     * from which the files containing the player profile data can be downloaded. Otherwise, it returns the current 'State' of
     * the export
     * @param request GetPlayersInSegmentExportRequest
     * @return Async Task will return GetPlayersInSegmentExportResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetPlayersInSegmentExportResponse>> GetSegmentExportAsync(final GetPlayersInSegmentExportRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayersInSegmentExportResponse>>() {
            public PlayFabResult<GetPlayersInSegmentExportResponse> call() throws Exception {
                return privateGetSegmentExportAsync(request);
            }
        });
    }

    /**
     * Retrieves the result of an export started by ExportPlayersInSegment API. If the ExportPlayersInSegment is successful and
     * complete, this API returns the IndexUrl from which the index file can be downloaded. The index file has a list of urls
     * from which the files containing the player profile data can be downloaded. Otherwise, it returns the current 'State' of
     * the export
     * @param request GetPlayersInSegmentExportRequest
     * @return GetPlayersInSegmentExportResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetPlayersInSegmentExportResponse> GetSegmentExport(final GetPlayersInSegmentExportRequest request) {
        FutureTask<PlayFabResult<GetPlayersInSegmentExportResponse>> task = new FutureTask(new Callable<PlayFabResult<GetPlayersInSegmentExportResponse>>() {
            public PlayFabResult<GetPlayersInSegmentExportResponse> call() throws Exception {
                return privateGetSegmentExportAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetPlayersInSegmentExportResponse> exceptionResult = new PlayFabResult<GetPlayersInSegmentExportResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves the result of an export started by ExportPlayersInSegment API. If the ExportPlayersInSegment is successful and
     * complete, this API returns the IndexUrl from which the index file can be downloaded. The index file has a list of urls
     * from which the files containing the player profile data can be downloaded. Otherwise, it returns the current 'State' of
     * the export
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetPlayersInSegmentExportResponse> privateGetSegmentExportAsync(final GetPlayersInSegmentExportRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetSegmentExport"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayersInSegmentExportResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetPlayersInSegmentExportResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayersInSegmentExportResponse>>(){}.getType());
        GetPlayersInSegmentExportResponse result = resultData.data;

        PlayFabResult<GetPlayersInSegmentExportResponse> pfResult = new PlayFabResult<GetPlayersInSegmentExportResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get detail information of a segment and its associated definition(s) and action(s) for a title.
     * @param request GetSegmentsRequest
     * @return Async Task will return GetSegmentsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetSegmentsResponse>> GetSegmentsAsync(final GetSegmentsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetSegmentsResponse>>() {
            public PlayFabResult<GetSegmentsResponse> call() throws Exception {
                return privateGetSegmentsAsync(request);
            }
        });
    }

    /**
     * Get detail information of a segment and its associated definition(s) and action(s) for a title.
     * @param request GetSegmentsRequest
     * @return GetSegmentsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetSegmentsResponse> GetSegments(final GetSegmentsRequest request) {
        FutureTask<PlayFabResult<GetSegmentsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetSegmentsResponse>>() {
            public PlayFabResult<GetSegmentsResponse> call() throws Exception {
                return privateGetSegmentsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetSegmentsResponse> exceptionResult = new PlayFabResult<GetSegmentsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get detail information of a segment and its associated definition(s) and action(s) for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetSegmentsResponse> privateGetSegmentsAsync(final GetSegmentsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetSegments"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetSegmentsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetSegmentsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetSegmentsResponse>>(){}.getType());
        GetSegmentsResponse result = resultData.data;

        PlayFabResult<GetSegmentsResponse> pfResult = new PlayFabResult<GetSegmentsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the set of items defined for the specified store, including all prices defined
     * @param request GetStoreItemsRequest
     * @return Async Task will return GetStoreItemsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetStoreItemsResult>> GetStoreItemsAsync(final GetStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetStoreItemsResult>>() {
            public PlayFabResult<GetStoreItemsResult> call() throws Exception {
                return privateGetStoreItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves the set of items defined for the specified store, including all prices defined
     * @param request GetStoreItemsRequest
     * @return GetStoreItemsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetStoreItemsResult> GetStoreItems(final GetStoreItemsRequest request) {
        FutureTask<PlayFabResult<GetStoreItemsResult>> task = new FutureTask(new Callable<PlayFabResult<GetStoreItemsResult>>() {
            public PlayFabResult<GetStoreItemsResult> call() throws Exception {
                return privateGetStoreItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetStoreItemsResult> exceptionResult = new PlayFabResult<GetStoreItemsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the set of items defined for the specified store, including all prices defined */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetStoreItemsResult> privateGetStoreItemsAsync(final GetStoreItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetStoreItems"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetStoreItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetStoreItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetStoreItemsResult>>(){}.getType());
        GetStoreItemsResult result = resultData.data;

        PlayFabResult<GetStoreItemsResult> pfResult = new PlayFabResult<GetStoreItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Query for task instances by task, status, or time range.
     * @param request GetTaskInstancesRequest
     * @return Async Task will return GetTaskInstancesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTaskInstancesResult>> GetTaskInstancesAsync(final GetTaskInstancesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTaskInstancesResult>>() {
            public PlayFabResult<GetTaskInstancesResult> call() throws Exception {
                return privateGetTaskInstancesAsync(request);
            }
        });
    }

    /**
     * Query for task instances by task, status, or time range.
     * @param request GetTaskInstancesRequest
     * @return GetTaskInstancesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTaskInstancesResult> GetTaskInstances(final GetTaskInstancesRequest request) {
        FutureTask<PlayFabResult<GetTaskInstancesResult>> task = new FutureTask(new Callable<PlayFabResult<GetTaskInstancesResult>>() {
            public PlayFabResult<GetTaskInstancesResult> call() throws Exception {
                return privateGetTaskInstancesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTaskInstancesResult> exceptionResult = new PlayFabResult<GetTaskInstancesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Query for task instances by task, status, or time range. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTaskInstancesResult> privateGetTaskInstancesAsync(final GetTaskInstancesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetTaskInstances"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTaskInstancesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTaskInstancesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTaskInstancesResult>>(){}.getType());
        GetTaskInstancesResult result = resultData.data;

        PlayFabResult<GetTaskInstancesResult> pfResult = new PlayFabResult<GetTaskInstancesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get definition information on a specified task or all tasks within a title.
     * @param request GetTasksRequest
     * @return Async Task will return GetTasksResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTasksResult>> GetTasksAsync(final GetTasksRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTasksResult>>() {
            public PlayFabResult<GetTasksResult> call() throws Exception {
                return privateGetTasksAsync(request);
            }
        });
    }

    /**
     * Get definition information on a specified task or all tasks within a title.
     * @param request GetTasksRequest
     * @return GetTasksResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTasksResult> GetTasks(final GetTasksRequest request) {
        FutureTask<PlayFabResult<GetTasksResult>> task = new FutureTask(new Callable<PlayFabResult<GetTasksResult>>() {
            public PlayFabResult<GetTasksResult> call() throws Exception {
                return privateGetTasksAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTasksResult> exceptionResult = new PlayFabResult<GetTasksResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get definition information on a specified task or all tasks within a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTasksResult> privateGetTasksAsync(final GetTasksRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetTasks"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTasksResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTasksResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTasksResult>>(){}.getType());
        GetTasksResult result = resultData.data;

        PlayFabResult<GetTasksResult> pfResult = new PlayFabResult<GetTasksResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the key-value store of custom title settings which can be read by the client
     * @param request GetTitleDataRequest
     * @return Async Task will return GetTitleDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitleDataResult>> GetTitleDataAsync(final GetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom title settings which can be read by the client
     * @param request GetTitleDataRequest
     * @return GetTitleDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitleDataResult> GetTitleData(final GetTitleDataRequest request) {
        FutureTask<PlayFabResult<GetTitleDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTitleDataResult> exceptionResult = new PlayFabResult<GetTitleDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the key-value store of custom title settings which can be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleDataResult> privateGetTitleDataAsync(final GetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetTitleData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTitleDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleDataResult>>(){}.getType());
        GetTitleDataResult result = resultData.data;

        PlayFabResult<GetTitleDataResult> pfResult = new PlayFabResult<GetTitleDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the key-value store of custom title settings which cannot be read by the client
     * @param request GetTitleDataRequest
     * @return Async Task will return GetTitleDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitleDataResult>> GetTitleInternalDataAsync(final GetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom title settings which cannot be read by the client
     * @param request GetTitleDataRequest
     * @return GetTitleDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitleDataResult> GetTitleInternalData(final GetTitleDataRequest request) {
        FutureTask<PlayFabResult<GetTitleDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTitleDataResult> exceptionResult = new PlayFabResult<GetTitleDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the key-value store of custom title settings which cannot be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleDataResult> privateGetTitleInternalDataAsync(final GetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetTitleInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTitleDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleDataResult>>(){}.getType());
        GetTitleDataResult result = resultData.data;

        PlayFabResult<GetTitleDataResult> pfResult = new PlayFabResult<GetTitleDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the relevant details for a specified user, based upon a match against a supplied unique identifier
     * @param request LookupUserAccountInfoRequest
     * @return Async Task will return LookupUserAccountInfoResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LookupUserAccountInfoResult>> GetUserAccountInfoAsync(final LookupUserAccountInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LookupUserAccountInfoResult>>() {
            public PlayFabResult<LookupUserAccountInfoResult> call() throws Exception {
                return privateGetUserAccountInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the relevant details for a specified user, based upon a match against a supplied unique identifier
     * @param request LookupUserAccountInfoRequest
     * @return LookupUserAccountInfoResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LookupUserAccountInfoResult> GetUserAccountInfo(final LookupUserAccountInfoRequest request) {
        FutureTask<PlayFabResult<LookupUserAccountInfoResult>> task = new FutureTask(new Callable<PlayFabResult<LookupUserAccountInfoResult>>() {
            public PlayFabResult<LookupUserAccountInfoResult> call() throws Exception {
                return privateGetUserAccountInfoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LookupUserAccountInfoResult> exceptionResult = new PlayFabResult<LookupUserAccountInfoResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the relevant details for a specified user, based upon a match against a supplied unique identifier */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LookupUserAccountInfoResult> privateGetUserAccountInfoAsync(final LookupUserAccountInfoRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetUserAccountInfo"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LookupUserAccountInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LookupUserAccountInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LookupUserAccountInfoResult>>(){}.getType());
        LookupUserAccountInfoResult result = resultData.data;

        PlayFabResult<LookupUserAccountInfoResult> pfResult = new PlayFabResult<LookupUserAccountInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets all bans for a user.
     * @param request GetUserBansRequest
     * @return Async Task will return GetUserBansResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserBansResult>> GetUserBansAsync(final GetUserBansRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserBansResult>>() {
            public PlayFabResult<GetUserBansResult> call() throws Exception {
                return privateGetUserBansAsync(request);
            }
        });
    }

    /**
     * Gets all bans for a user.
     * @param request GetUserBansRequest
     * @return GetUserBansResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserBansResult> GetUserBans(final GetUserBansRequest request) {
        FutureTask<PlayFabResult<GetUserBansResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserBansResult>>() {
            public PlayFabResult<GetUserBansResult> call() throws Exception {
                return privateGetUserBansAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetUserBansResult> exceptionResult = new PlayFabResult<GetUserBansResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets all bans for a user. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserBansResult> privateGetUserBansAsync(final GetUserBansRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetUserBans"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserBansResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetUserBansResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserBansResult>>(){}.getType());
        GetUserBansResult result = resultData.data;

        PlayFabResult<GetUserBansResult> pfResult = new PlayFabResult<GetUserBansResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     * @param request GetUserDataRequest
     * @return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserData(final GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the title-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetUserData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType());
        GetUserDataResult result = resultData.data;

        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the title-specific custom data for the user which cannot be accessed by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserInternalDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which cannot be accessed by the client
     * @param request GetUserDataRequest
     * @return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserInternalData(final GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the title-specific custom data for the user which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserInternalDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetUserInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType());
        GetUserDataResult result = resultData.data;

        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the specified user's current inventory of virtual goods
     * @param request GetUserInventoryRequest
     * @return Async Task will return GetUserInventoryResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserInventoryResult>> GetUserInventoryAsync(final GetUserInventoryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserInventoryResult>>() {
            public PlayFabResult<GetUserInventoryResult> call() throws Exception {
                return privateGetUserInventoryAsync(request);
            }
        });
    }

    /**
     * Retrieves the specified user's current inventory of virtual goods
     * @param request GetUserInventoryRequest
     * @return GetUserInventoryResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserInventoryResult> GetUserInventory(final GetUserInventoryRequest request) {
        FutureTask<PlayFabResult<GetUserInventoryResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserInventoryResult>>() {
            public PlayFabResult<GetUserInventoryResult> call() throws Exception {
                return privateGetUserInventoryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetUserInventoryResult> exceptionResult = new PlayFabResult<GetUserInventoryResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the specified user's current inventory of virtual goods */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserInventoryResult> privateGetUserInventoryAsync(final GetUserInventoryRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetUserInventory"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserInventoryResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetUserInventoryResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserInventoryResult>>(){}.getType());
        GetUserInventoryResult result = resultData.data;

        PlayFabResult<GetUserInventoryResult> pfResult = new PlayFabResult<GetUserInventoryResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     * @param request GetUserDataRequest
     * @return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserPublisherData(final GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the publisher-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetUserPublisherData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType());
        GetUserDataResult result = resultData.data;

        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the publisher-specific custom data for the user which cannot be accessed by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherInternalDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherInternalDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which cannot be accessed by the client
     * @param request GetUserDataRequest
     * @return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserPublisherInternalData(final GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the publisher-specific custom data for the user which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherInternalDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetUserPublisherInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType());
        GetUserDataResult result = resultData.data;

        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the publisher-specific custom data for the user which can only be read by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherReadOnlyDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which can only be read by the client
     * @param request GetUserDataRequest
     * @return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserPublisherReadOnlyData(final GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the publisher-specific custom data for the user which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherReadOnlyDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetUserPublisherReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType());
        GetUserDataResult result = resultData.data;

        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the title-specific custom data for the user which can only be read by the client
     * @param request GetUserDataRequest
     * @return Async Task will return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserReadOnlyDataAsync(final GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which can only be read by the client
     * @param request GetUserDataRequest
     * @return GetUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetUserDataResult> GetUserReadOnlyData(final GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetUserDataResult> exceptionResult = new PlayFabResult<GetUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves the title-specific custom data for the user which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetUserDataResult> privateGetUserReadOnlyDataAsync(final GetUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GetUserReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType());
        GetUserDataResult result = resultData.data;

        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds the specified items to the specified user inventories
     * @param request GrantItemsToUsersRequest
     * @return Async Task will return GrantItemsToUsersResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GrantItemsToUsersResult>> GrantItemsToUsersAsync(final GrantItemsToUsersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantItemsToUsersResult>>() {
            public PlayFabResult<GrantItemsToUsersResult> call() throws Exception {
                return privateGrantItemsToUsersAsync(request);
            }
        });
    }

    /**
     * Adds the specified items to the specified user inventories
     * @param request GrantItemsToUsersRequest
     * @return GrantItemsToUsersResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GrantItemsToUsersResult> GrantItemsToUsers(final GrantItemsToUsersRequest request) {
        FutureTask<PlayFabResult<GrantItemsToUsersResult>> task = new FutureTask(new Callable<PlayFabResult<GrantItemsToUsersResult>>() {
            public PlayFabResult<GrantItemsToUsersResult> call() throws Exception {
                return privateGrantItemsToUsersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GrantItemsToUsersResult> exceptionResult = new PlayFabResult<GrantItemsToUsersResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Adds the specified items to the specified user inventories */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GrantItemsToUsersResult> privateGrantItemsToUsersAsync(final GrantItemsToUsersRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/GrantItemsToUsers"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GrantItemsToUsersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GrantItemsToUsersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GrantItemsToUsersResult>>(){}.getType());
        GrantItemsToUsersResult result = resultData.data;

        PlayFabResult<GrantItemsToUsersResult> pfResult = new PlayFabResult<GrantItemsToUsersResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Increases the global count for the given scarce resource.
     * @param request IncrementLimitedEditionItemAvailabilityRequest
     * @return Async Task will return IncrementLimitedEditionItemAvailabilityResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<IncrementLimitedEditionItemAvailabilityResult>> IncrementLimitedEditionItemAvailabilityAsync(final IncrementLimitedEditionItemAvailabilityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<IncrementLimitedEditionItemAvailabilityResult>>() {
            public PlayFabResult<IncrementLimitedEditionItemAvailabilityResult> call() throws Exception {
                return privateIncrementLimitedEditionItemAvailabilityAsync(request);
            }
        });
    }

    /**
     * Increases the global count for the given scarce resource.
     * @param request IncrementLimitedEditionItemAvailabilityRequest
     * @return IncrementLimitedEditionItemAvailabilityResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<IncrementLimitedEditionItemAvailabilityResult> IncrementLimitedEditionItemAvailability(final IncrementLimitedEditionItemAvailabilityRequest request) {
        FutureTask<PlayFabResult<IncrementLimitedEditionItemAvailabilityResult>> task = new FutureTask(new Callable<PlayFabResult<IncrementLimitedEditionItemAvailabilityResult>>() {
            public PlayFabResult<IncrementLimitedEditionItemAvailabilityResult> call() throws Exception {
                return privateIncrementLimitedEditionItemAvailabilityAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<IncrementLimitedEditionItemAvailabilityResult> exceptionResult = new PlayFabResult<IncrementLimitedEditionItemAvailabilityResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Increases the global count for the given scarce resource. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<IncrementLimitedEditionItemAvailabilityResult> privateIncrementLimitedEditionItemAvailabilityAsync(final IncrementLimitedEditionItemAvailabilityRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/IncrementLimitedEditionItemAvailability"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<IncrementLimitedEditionItemAvailabilityResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<IncrementLimitedEditionItemAvailabilityResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<IncrementLimitedEditionItemAvailabilityResult>>(){}.getType());
        IncrementLimitedEditionItemAvailabilityResult result = resultData.data;

        PlayFabResult<IncrementLimitedEditionItemAvailabilityResult> pfResult = new PlayFabResult<IncrementLimitedEditionItemAvailabilityResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Resets the indicated statistic, removing all player entries for it and backing up the old values.
     * @param request IncrementPlayerStatisticVersionRequest
     * @return Async Task will return IncrementPlayerStatisticVersionResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<IncrementPlayerStatisticVersionResult>> IncrementPlayerStatisticVersionAsync(final IncrementPlayerStatisticVersionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<IncrementPlayerStatisticVersionResult>>() {
            public PlayFabResult<IncrementPlayerStatisticVersionResult> call() throws Exception {
                return privateIncrementPlayerStatisticVersionAsync(request);
            }
        });
    }

    /**
     * Resets the indicated statistic, removing all player entries for it and backing up the old values.
     * @param request IncrementPlayerStatisticVersionRequest
     * @return IncrementPlayerStatisticVersionResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<IncrementPlayerStatisticVersionResult> IncrementPlayerStatisticVersion(final IncrementPlayerStatisticVersionRequest request) {
        FutureTask<PlayFabResult<IncrementPlayerStatisticVersionResult>> task = new FutureTask(new Callable<PlayFabResult<IncrementPlayerStatisticVersionResult>>() {
            public PlayFabResult<IncrementPlayerStatisticVersionResult> call() throws Exception {
                return privateIncrementPlayerStatisticVersionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<IncrementPlayerStatisticVersionResult> exceptionResult = new PlayFabResult<IncrementPlayerStatisticVersionResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Resets the indicated statistic, removing all player entries for it and backing up the old values. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<IncrementPlayerStatisticVersionResult> privateIncrementPlayerStatisticVersionAsync(final IncrementPlayerStatisticVersionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/IncrementPlayerStatisticVersion"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<IncrementPlayerStatisticVersionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<IncrementPlayerStatisticVersionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<IncrementPlayerStatisticVersionResult>>(){}.getType());
        IncrementPlayerStatisticVersionResult result = resultData.data;

        PlayFabResult<IncrementPlayerStatisticVersionResult> pfResult = new PlayFabResult<IncrementPlayerStatisticVersionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves a list of all Open ID Connect providers registered to a title.
     * @param request ListOpenIdConnectionRequest
     * @return Async Task will return ListOpenIdConnectionResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListOpenIdConnectionResponse>> ListOpenIdConnectionAsync(final ListOpenIdConnectionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListOpenIdConnectionResponse>>() {
            public PlayFabResult<ListOpenIdConnectionResponse> call() throws Exception {
                return privateListOpenIdConnectionAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of all Open ID Connect providers registered to a title.
     * @param request ListOpenIdConnectionRequest
     * @return ListOpenIdConnectionResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListOpenIdConnectionResponse> ListOpenIdConnection(final ListOpenIdConnectionRequest request) {
        FutureTask<PlayFabResult<ListOpenIdConnectionResponse>> task = new FutureTask(new Callable<PlayFabResult<ListOpenIdConnectionResponse>>() {
            public PlayFabResult<ListOpenIdConnectionResponse> call() throws Exception {
                return privateListOpenIdConnectionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListOpenIdConnectionResponse> exceptionResult = new PlayFabResult<ListOpenIdConnectionResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves a list of all Open ID Connect providers registered to a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListOpenIdConnectionResponse> privateListOpenIdConnectionAsync(final ListOpenIdConnectionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/ListOpenIdConnection"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListOpenIdConnectionResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListOpenIdConnectionResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListOpenIdConnectionResponse>>(){}.getType());
        ListOpenIdConnectionResponse result = resultData.data;

        PlayFabResult<ListOpenIdConnectionResponse> pfResult = new PlayFabResult<ListOpenIdConnectionResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retuns the list of all defined virtual currencies for the title
     * @param request ListVirtualCurrencyTypesRequest
     * @return Async Task will return ListVirtualCurrencyTypesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListVirtualCurrencyTypesResult>> ListVirtualCurrencyTypesAsync(final ListVirtualCurrencyTypesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListVirtualCurrencyTypesResult>>() {
            public PlayFabResult<ListVirtualCurrencyTypesResult> call() throws Exception {
                return privateListVirtualCurrencyTypesAsync(request);
            }
        });
    }

    /**
     * Retuns the list of all defined virtual currencies for the title
     * @param request ListVirtualCurrencyTypesRequest
     * @return ListVirtualCurrencyTypesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListVirtualCurrencyTypesResult> ListVirtualCurrencyTypes(final ListVirtualCurrencyTypesRequest request) {
        FutureTask<PlayFabResult<ListVirtualCurrencyTypesResult>> task = new FutureTask(new Callable<PlayFabResult<ListVirtualCurrencyTypesResult>>() {
            public PlayFabResult<ListVirtualCurrencyTypesResult> call() throws Exception {
                return privateListVirtualCurrencyTypesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListVirtualCurrencyTypesResult> exceptionResult = new PlayFabResult<ListVirtualCurrencyTypesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retuns the list of all defined virtual currencies for the title */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListVirtualCurrencyTypesResult> privateListVirtualCurrencyTypesAsync(final ListVirtualCurrencyTypesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/ListVirtualCurrencyTypes"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListVirtualCurrencyTypesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListVirtualCurrencyTypesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListVirtualCurrencyTypesResult>>(){}.getType());
        ListVirtualCurrencyTypesResult result = resultData.data;

        PlayFabResult<ListVirtualCurrencyTypesResult> pfResult = new PlayFabResult<ListVirtualCurrencyTypesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the build details for the specified game server executable
     * @param request ModifyServerBuildRequest
     * @return Async Task will return ModifyServerBuildResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyServerBuildResult>> ModifyServerBuildAsync(final ModifyServerBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyServerBuildResult>>() {
            public PlayFabResult<ModifyServerBuildResult> call() throws Exception {
                return privateModifyServerBuildAsync(request);
            }
        });
    }

    /**
     * Updates the build details for the specified game server executable
     * @param request ModifyServerBuildRequest
     * @return ModifyServerBuildResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyServerBuildResult> ModifyServerBuild(final ModifyServerBuildRequest request) {
        FutureTask<PlayFabResult<ModifyServerBuildResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyServerBuildResult>>() {
            public PlayFabResult<ModifyServerBuildResult> call() throws Exception {
                return privateModifyServerBuildAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ModifyServerBuildResult> exceptionResult = new PlayFabResult<ModifyServerBuildResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the build details for the specified game server executable */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyServerBuildResult> privateModifyServerBuildAsync(final ModifyServerBuildRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/ModifyServerBuild"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyServerBuildResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ModifyServerBuildResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyServerBuildResult>>(){}.getType());
        ModifyServerBuildResult result = resultData.data;

        PlayFabResult<ModifyServerBuildResult> pfResult = new PlayFabResult<ModifyServerBuildResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Attempts to process an order refund through the original real money payment provider.
     * @param request RefundPurchaseRequest
     * @return Async Task will return RefundPurchaseResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RefundPurchaseResponse>> RefundPurchaseAsync(final RefundPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RefundPurchaseResponse>>() {
            public PlayFabResult<RefundPurchaseResponse> call() throws Exception {
                return privateRefundPurchaseAsync(request);
            }
        });
    }

    /**
     * Attempts to process an order refund through the original real money payment provider.
     * @param request RefundPurchaseRequest
     * @return RefundPurchaseResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RefundPurchaseResponse> RefundPurchase(final RefundPurchaseRequest request) {
        FutureTask<PlayFabResult<RefundPurchaseResponse>> task = new FutureTask(new Callable<PlayFabResult<RefundPurchaseResponse>>() {
            public PlayFabResult<RefundPurchaseResponse> call() throws Exception {
                return privateRefundPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RefundPurchaseResponse> exceptionResult = new PlayFabResult<RefundPurchaseResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Attempts to process an order refund through the original real money payment provider. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RefundPurchaseResponse> privateRefundPurchaseAsync(final RefundPurchaseRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/RefundPurchase"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RefundPurchaseResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RefundPurchaseResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RefundPurchaseResponse>>(){}.getType());
        RefundPurchaseResponse result = resultData.data;

        PlayFabResult<RefundPurchaseResponse> pfResult = new PlayFabResult<RefundPurchaseResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Remove a given tag from a player profile. The tag's namespace is automatically generated based on the source of the tag.
     * @param request RemovePlayerTagRequest
     * @return Async Task will return RemovePlayerTagResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RemovePlayerTagResult>> RemovePlayerTagAsync(final RemovePlayerTagRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemovePlayerTagResult>>() {
            public PlayFabResult<RemovePlayerTagResult> call() throws Exception {
                return privateRemovePlayerTagAsync(request);
            }
        });
    }

    /**
     * Remove a given tag from a player profile. The tag's namespace is automatically generated based on the source of the tag.
     * @param request RemovePlayerTagRequest
     * @return RemovePlayerTagResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RemovePlayerTagResult> RemovePlayerTag(final RemovePlayerTagRequest request) {
        FutureTask<PlayFabResult<RemovePlayerTagResult>> task = new FutureTask(new Callable<PlayFabResult<RemovePlayerTagResult>>() {
            public PlayFabResult<RemovePlayerTagResult> call() throws Exception {
                return privateRemovePlayerTagAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RemovePlayerTagResult> exceptionResult = new PlayFabResult<RemovePlayerTagResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Remove a given tag from a player profile. The tag's namespace is automatically generated based on the source of the tag. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RemovePlayerTagResult> privateRemovePlayerTagAsync(final RemovePlayerTagRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/RemovePlayerTag"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RemovePlayerTagResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RemovePlayerTagResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RemovePlayerTagResult>>(){}.getType());
        RemovePlayerTagResult result = resultData.data;

        PlayFabResult<RemovePlayerTagResult> pfResult = new PlayFabResult<RemovePlayerTagResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes one or more virtual currencies from the set defined for the title.
     * @param request RemoveVirtualCurrencyTypesRequest
     * @return Async Task will return BlankResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BlankResult>> RemoveVirtualCurrencyTypesAsync(final RemoveVirtualCurrencyTypesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateRemoveVirtualCurrencyTypesAsync(request);
            }
        });
    }

    /**
     * Removes one or more virtual currencies from the set defined for the title.
     * @param request RemoveVirtualCurrencyTypesRequest
     * @return BlankResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BlankResult> RemoveVirtualCurrencyTypes(final RemoveVirtualCurrencyTypesRequest request) {
        FutureTask<PlayFabResult<BlankResult>> task = new FutureTask(new Callable<PlayFabResult<BlankResult>>() {
            public PlayFabResult<BlankResult> call() throws Exception {
                return privateRemoveVirtualCurrencyTypesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<BlankResult> exceptionResult = new PlayFabResult<BlankResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Removes one or more virtual currencies from the set defined for the title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BlankResult> privateRemoveVirtualCurrencyTypesAsync(final RemoveVirtualCurrencyTypesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/RemoveVirtualCurrencyTypes"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BlankResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<BlankResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BlankResult>>(){}.getType());
        BlankResult result = resultData.data;

        PlayFabResult<BlankResult> pfResult = new PlayFabResult<BlankResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Completely removes all statistics for the specified character, for the current game
     * @param request ResetCharacterStatisticsRequest
     * @return Async Task will return ResetCharacterStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ResetCharacterStatisticsResult>> ResetCharacterStatisticsAsync(final ResetCharacterStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ResetCharacterStatisticsResult>>() {
            public PlayFabResult<ResetCharacterStatisticsResult> call() throws Exception {
                return privateResetCharacterStatisticsAsync(request);
            }
        });
    }

    /**
     * Completely removes all statistics for the specified character, for the current game
     * @param request ResetCharacterStatisticsRequest
     * @return ResetCharacterStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ResetCharacterStatisticsResult> ResetCharacterStatistics(final ResetCharacterStatisticsRequest request) {
        FutureTask<PlayFabResult<ResetCharacterStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<ResetCharacterStatisticsResult>>() {
            public PlayFabResult<ResetCharacterStatisticsResult> call() throws Exception {
                return privateResetCharacterStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ResetCharacterStatisticsResult> exceptionResult = new PlayFabResult<ResetCharacterStatisticsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Completely removes all statistics for the specified character, for the current game */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ResetCharacterStatisticsResult> privateResetCharacterStatisticsAsync(final ResetCharacterStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/ResetCharacterStatistics"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ResetCharacterStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ResetCharacterStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ResetCharacterStatisticsResult>>(){}.getType());
        ResetCharacterStatisticsResult result = resultData.data;

        PlayFabResult<ResetCharacterStatisticsResult> pfResult = new PlayFabResult<ResetCharacterStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Reset a player's password for a given title.
     * @param request ResetPasswordRequest
     * @return Async Task will return ResetPasswordResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ResetPasswordResult>> ResetPasswordAsync(final ResetPasswordRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ResetPasswordResult>>() {
            public PlayFabResult<ResetPasswordResult> call() throws Exception {
                return privateResetPasswordAsync(request);
            }
        });
    }

    /**
     * Reset a player's password for a given title.
     * @param request ResetPasswordRequest
     * @return ResetPasswordResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ResetPasswordResult> ResetPassword(final ResetPasswordRequest request) {
        FutureTask<PlayFabResult<ResetPasswordResult>> task = new FutureTask(new Callable<PlayFabResult<ResetPasswordResult>>() {
            public PlayFabResult<ResetPasswordResult> call() throws Exception {
                return privateResetPasswordAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ResetPasswordResult> exceptionResult = new PlayFabResult<ResetPasswordResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Reset a player's password for a given title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ResetPasswordResult> privateResetPasswordAsync(final ResetPasswordRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/ResetPassword"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ResetPasswordResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ResetPasswordResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ResetPasswordResult>>(){}.getType());
        ResetPasswordResult result = resultData.data;

        PlayFabResult<ResetPasswordResult> pfResult = new PlayFabResult<ResetPasswordResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Completely removes all statistics for the specified user, for the current game
     * @param request ResetUserStatisticsRequest
     * @return Async Task will return ResetUserStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ResetUserStatisticsResult>> ResetUserStatisticsAsync(final ResetUserStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ResetUserStatisticsResult>>() {
            public PlayFabResult<ResetUserStatisticsResult> call() throws Exception {
                return privateResetUserStatisticsAsync(request);
            }
        });
    }

    /**
     * Completely removes all statistics for the specified user, for the current game
     * @param request ResetUserStatisticsRequest
     * @return ResetUserStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ResetUserStatisticsResult> ResetUserStatistics(final ResetUserStatisticsRequest request) {
        FutureTask<PlayFabResult<ResetUserStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<ResetUserStatisticsResult>>() {
            public PlayFabResult<ResetUserStatisticsResult> call() throws Exception {
                return privateResetUserStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ResetUserStatisticsResult> exceptionResult = new PlayFabResult<ResetUserStatisticsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Completely removes all statistics for the specified user, for the current game */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ResetUserStatisticsResult> privateResetUserStatisticsAsync(final ResetUserStatisticsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/ResetUserStatistics"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ResetUserStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ResetUserStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ResetUserStatisticsResult>>(){}.getType());
        ResetUserStatisticsResult result = resultData.data;

        PlayFabResult<ResetUserStatisticsResult> pfResult = new PlayFabResult<ResetUserStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Attempts to resolve a dispute with the original order's payment provider.
     * @param request ResolvePurchaseDisputeRequest
     * @return Async Task will return ResolvePurchaseDisputeResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ResolvePurchaseDisputeResponse>> ResolvePurchaseDisputeAsync(final ResolvePurchaseDisputeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ResolvePurchaseDisputeResponse>>() {
            public PlayFabResult<ResolvePurchaseDisputeResponse> call() throws Exception {
                return privateResolvePurchaseDisputeAsync(request);
            }
        });
    }

    /**
     * Attempts to resolve a dispute with the original order's payment provider.
     * @param request ResolvePurchaseDisputeRequest
     * @return ResolvePurchaseDisputeResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ResolvePurchaseDisputeResponse> ResolvePurchaseDispute(final ResolvePurchaseDisputeRequest request) {
        FutureTask<PlayFabResult<ResolvePurchaseDisputeResponse>> task = new FutureTask(new Callable<PlayFabResult<ResolvePurchaseDisputeResponse>>() {
            public PlayFabResult<ResolvePurchaseDisputeResponse> call() throws Exception {
                return privateResolvePurchaseDisputeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ResolvePurchaseDisputeResponse> exceptionResult = new PlayFabResult<ResolvePurchaseDisputeResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Attempts to resolve a dispute with the original order's payment provider. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ResolvePurchaseDisputeResponse> privateResolvePurchaseDisputeAsync(final ResolvePurchaseDisputeRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/ResolvePurchaseDispute"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ResolvePurchaseDisputeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ResolvePurchaseDisputeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ResolvePurchaseDisputeResponse>>(){}.getType());
        ResolvePurchaseDisputeResponse result = resultData.data;

        PlayFabResult<ResolvePurchaseDisputeResponse> pfResult = new PlayFabResult<ResolvePurchaseDisputeResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Revoke all active bans for a user.
     * @param request RevokeAllBansForUserRequest
     * @return Async Task will return RevokeAllBansForUserResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RevokeAllBansForUserResult>> RevokeAllBansForUserAsync(final RevokeAllBansForUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RevokeAllBansForUserResult>>() {
            public PlayFabResult<RevokeAllBansForUserResult> call() throws Exception {
                return privateRevokeAllBansForUserAsync(request);
            }
        });
    }

    /**
     * Revoke all active bans for a user.
     * @param request RevokeAllBansForUserRequest
     * @return RevokeAllBansForUserResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RevokeAllBansForUserResult> RevokeAllBansForUser(final RevokeAllBansForUserRequest request) {
        FutureTask<PlayFabResult<RevokeAllBansForUserResult>> task = new FutureTask(new Callable<PlayFabResult<RevokeAllBansForUserResult>>() {
            public PlayFabResult<RevokeAllBansForUserResult> call() throws Exception {
                return privateRevokeAllBansForUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RevokeAllBansForUserResult> exceptionResult = new PlayFabResult<RevokeAllBansForUserResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Revoke all active bans for a user. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeAllBansForUserResult> privateRevokeAllBansForUserAsync(final RevokeAllBansForUserRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/RevokeAllBansForUser"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RevokeAllBansForUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RevokeAllBansForUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RevokeAllBansForUserResult>>(){}.getType());
        RevokeAllBansForUserResult result = resultData.data;

        PlayFabResult<RevokeAllBansForUserResult> pfResult = new PlayFabResult<RevokeAllBansForUserResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Revoke all active bans specified with BanId.
     * @param request RevokeBansRequest
     * @return Async Task will return RevokeBansResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RevokeBansResult>> RevokeBansAsync(final RevokeBansRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RevokeBansResult>>() {
            public PlayFabResult<RevokeBansResult> call() throws Exception {
                return privateRevokeBansAsync(request);
            }
        });
    }

    /**
     * Revoke all active bans specified with BanId.
     * @param request RevokeBansRequest
     * @return RevokeBansResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RevokeBansResult> RevokeBans(final RevokeBansRequest request) {
        FutureTask<PlayFabResult<RevokeBansResult>> task = new FutureTask(new Callable<PlayFabResult<RevokeBansResult>>() {
            public PlayFabResult<RevokeBansResult> call() throws Exception {
                return privateRevokeBansAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RevokeBansResult> exceptionResult = new PlayFabResult<RevokeBansResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Revoke all active bans specified with BanId. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeBansResult> privateRevokeBansAsync(final RevokeBansRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/RevokeBans"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RevokeBansResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RevokeBansResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RevokeBansResult>>(){}.getType());
        RevokeBansResult result = resultData.data;

        PlayFabResult<RevokeBansResult> pfResult = new PlayFabResult<RevokeBansResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Revokes access to an item in a user's inventory
     * @param request RevokeInventoryItemRequest
     * @return Async Task will return RevokeInventoryResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RevokeInventoryResult>> RevokeInventoryItemAsync(final RevokeInventoryItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RevokeInventoryResult>>() {
            public PlayFabResult<RevokeInventoryResult> call() throws Exception {
                return privateRevokeInventoryItemAsync(request);
            }
        });
    }

    /**
     * Revokes access to an item in a user's inventory
     * @param request RevokeInventoryItemRequest
     * @return RevokeInventoryResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RevokeInventoryResult> RevokeInventoryItem(final RevokeInventoryItemRequest request) {
        FutureTask<PlayFabResult<RevokeInventoryResult>> task = new FutureTask(new Callable<PlayFabResult<RevokeInventoryResult>>() {
            public PlayFabResult<RevokeInventoryResult> call() throws Exception {
                return privateRevokeInventoryItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RevokeInventoryResult> exceptionResult = new PlayFabResult<RevokeInventoryResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Revokes access to an item in a user's inventory */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeInventoryResult> privateRevokeInventoryItemAsync(final RevokeInventoryItemRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/RevokeInventoryItem"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RevokeInventoryResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RevokeInventoryResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RevokeInventoryResult>>(){}.getType());
        RevokeInventoryResult result = resultData.data;

        PlayFabResult<RevokeInventoryResult> pfResult = new PlayFabResult<RevokeInventoryResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Revokes access for up to 25 items across multiple users and characters.
     * @param request RevokeInventoryItemsRequest
     * @return Async Task will return RevokeInventoryItemsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RevokeInventoryItemsResult>> RevokeInventoryItemsAsync(final RevokeInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RevokeInventoryItemsResult>>() {
            public PlayFabResult<RevokeInventoryItemsResult> call() throws Exception {
                return privateRevokeInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Revokes access for up to 25 items across multiple users and characters.
     * @param request RevokeInventoryItemsRequest
     * @return RevokeInventoryItemsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RevokeInventoryItemsResult> RevokeInventoryItems(final RevokeInventoryItemsRequest request) {
        FutureTask<PlayFabResult<RevokeInventoryItemsResult>> task = new FutureTask(new Callable<PlayFabResult<RevokeInventoryItemsResult>>() {
            public PlayFabResult<RevokeInventoryItemsResult> call() throws Exception {
                return privateRevokeInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RevokeInventoryItemsResult> exceptionResult = new PlayFabResult<RevokeInventoryItemsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Revokes access for up to 25 items across multiple users and characters. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RevokeInventoryItemsResult> privateRevokeInventoryItemsAsync(final RevokeInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/RevokeInventoryItems"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RevokeInventoryItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RevokeInventoryItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RevokeInventoryItemsResult>>(){}.getType());
        RevokeInventoryItemsResult result = resultData.data;

        PlayFabResult<RevokeInventoryItemsResult> pfResult = new PlayFabResult<RevokeInventoryItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Run a task immediately regardless of its schedule.
     * @param request RunTaskRequest
     * @return Async Task will return RunTaskResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RunTaskResult>> RunTaskAsync(final RunTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RunTaskResult>>() {
            public PlayFabResult<RunTaskResult> call() throws Exception {
                return privateRunTaskAsync(request);
            }
        });
    }

    /**
     * Run a task immediately regardless of its schedule.
     * @param request RunTaskRequest
     * @return RunTaskResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RunTaskResult> RunTask(final RunTaskRequest request) {
        FutureTask<PlayFabResult<RunTaskResult>> task = new FutureTask(new Callable<PlayFabResult<RunTaskResult>>() {
            public PlayFabResult<RunTaskResult> call() throws Exception {
                return privateRunTaskAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RunTaskResult> exceptionResult = new PlayFabResult<RunTaskResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Run a task immediately regardless of its schedule. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RunTaskResult> privateRunTaskAsync(final RunTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/RunTask"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RunTaskResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RunTaskResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RunTaskResult>>(){}.getType());
        RunTaskResult result = resultData.data;

        PlayFabResult<RunTaskResult> pfResult = new PlayFabResult<RunTaskResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to
     * change the password.If an account recovery email template ID is provided, an email using the custom email template will
     * be used.
     * @param request SendAccountRecoveryEmailRequest
     * @return Async Task will return SendAccountRecoveryEmailResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SendAccountRecoveryEmailResult>> SendAccountRecoveryEmailAsync(final SendAccountRecoveryEmailRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SendAccountRecoveryEmailResult>>() {
            public PlayFabResult<SendAccountRecoveryEmailResult> call() throws Exception {
                return privateSendAccountRecoveryEmailAsync(request);
            }
        });
    }

    /**
     * Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to
     * change the password.If an account recovery email template ID is provided, an email using the custom email template will
     * be used.
     * @param request SendAccountRecoveryEmailRequest
     * @return SendAccountRecoveryEmailResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SendAccountRecoveryEmailResult> SendAccountRecoveryEmail(final SendAccountRecoveryEmailRequest request) {
        FutureTask<PlayFabResult<SendAccountRecoveryEmailResult>> task = new FutureTask(new Callable<PlayFabResult<SendAccountRecoveryEmailResult>>() {
            public PlayFabResult<SendAccountRecoveryEmailResult> call() throws Exception {
                return privateSendAccountRecoveryEmailAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SendAccountRecoveryEmailResult> exceptionResult = new PlayFabResult<SendAccountRecoveryEmailResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to
     * change the password.If an account recovery email template ID is provided, an email using the custom email template will
     * be used.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SendAccountRecoveryEmailResult> privateSendAccountRecoveryEmailAsync(final SendAccountRecoveryEmailRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SendAccountRecoveryEmail"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SendAccountRecoveryEmailResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SendAccountRecoveryEmailResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SendAccountRecoveryEmailResult>>(){}.getType());
        SendAccountRecoveryEmailResult result = resultData.data;

        PlayFabResult<SendAccountRecoveryEmailResult> pfResult = new PlayFabResult<SendAccountRecoveryEmailResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates the catalog configuration of all virtual goods for the specified catalog version
     * @param request UpdateCatalogItemsRequest
     * @return Async Task will return UpdateCatalogItemsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCatalogItemsResult>> SetCatalogItemsAsync(final UpdateCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateSetCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Creates the catalog configuration of all virtual goods for the specified catalog version
     * @param request UpdateCatalogItemsRequest
     * @return UpdateCatalogItemsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCatalogItemsResult> SetCatalogItems(final UpdateCatalogItemsRequest request) {
        FutureTask<PlayFabResult<UpdateCatalogItemsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateSetCatalogItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateCatalogItemsResult> exceptionResult = new PlayFabResult<UpdateCatalogItemsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates the catalog configuration of all virtual goods for the specified catalog version */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCatalogItemsResult> privateSetCatalogItemsAsync(final UpdateCatalogItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetCatalogItems"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCatalogItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateCatalogItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCatalogItemsResult>>(){}.getType());
        UpdateCatalogItemsResult result = resultData.data;

        PlayFabResult<UpdateCatalogItemsResult> pfResult = new PlayFabResult<UpdateCatalogItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the override expiration for a membership subscription
     * @param request SetMembershipOverrideRequest
     * @return Async Task will return SetMembershipOverrideResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetMembershipOverrideResult>> SetMembershipOverrideAsync(final SetMembershipOverrideRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetMembershipOverrideResult>>() {
            public PlayFabResult<SetMembershipOverrideResult> call() throws Exception {
                return privateSetMembershipOverrideAsync(request);
            }
        });
    }

    /**
     * Sets the override expiration for a membership subscription
     * @param request SetMembershipOverrideRequest
     * @return SetMembershipOverrideResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetMembershipOverrideResult> SetMembershipOverride(final SetMembershipOverrideRequest request) {
        FutureTask<PlayFabResult<SetMembershipOverrideResult>> task = new FutureTask(new Callable<PlayFabResult<SetMembershipOverrideResult>>() {
            public PlayFabResult<SetMembershipOverrideResult> call() throws Exception {
                return privateSetMembershipOverrideAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetMembershipOverrideResult> exceptionResult = new PlayFabResult<SetMembershipOverrideResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Sets the override expiration for a membership subscription */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetMembershipOverrideResult> privateSetMembershipOverrideAsync(final SetMembershipOverrideRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetMembershipOverride"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetMembershipOverrideResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetMembershipOverrideResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetMembershipOverrideResult>>(){}.getType());
        SetMembershipOverrideResult result = resultData.data;

        PlayFabResult<SetMembershipOverrideResult> pfResult = new PlayFabResult<SetMembershipOverrideResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets or resets the player's secret. Player secrets are used to sign API requests.
     * @param request SetPlayerSecretRequest
     * @return Async Task will return SetPlayerSecretResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetPlayerSecretResult>> SetPlayerSecretAsync(final SetPlayerSecretRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetPlayerSecretResult>>() {
            public PlayFabResult<SetPlayerSecretResult> call() throws Exception {
                return privateSetPlayerSecretAsync(request);
            }
        });
    }

    /**
     * Sets or resets the player's secret. Player secrets are used to sign API requests.
     * @param request SetPlayerSecretRequest
     * @return SetPlayerSecretResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetPlayerSecretResult> SetPlayerSecret(final SetPlayerSecretRequest request) {
        FutureTask<PlayFabResult<SetPlayerSecretResult>> task = new FutureTask(new Callable<PlayFabResult<SetPlayerSecretResult>>() {
            public PlayFabResult<SetPlayerSecretResult> call() throws Exception {
                return privateSetPlayerSecretAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetPlayerSecretResult> exceptionResult = new PlayFabResult<SetPlayerSecretResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Sets or resets the player's secret. Player secrets are used to sign API requests. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetPlayerSecretResult> privateSetPlayerSecretAsync(final SetPlayerSecretRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetPlayerSecret"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetPlayerSecretResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetPlayerSecretResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetPlayerSecretResult>>(){}.getType());
        SetPlayerSecretResult result = resultData.data;

        PlayFabResult<SetPlayerSecretResult> pfResult = new PlayFabResult<SetPlayerSecretResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the currently published revision of a title Cloud Script
     * @param request SetPublishedRevisionRequest
     * @return Async Task will return SetPublishedRevisionResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetPublishedRevisionResult>> SetPublishedRevisionAsync(final SetPublishedRevisionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetPublishedRevisionResult>>() {
            public PlayFabResult<SetPublishedRevisionResult> call() throws Exception {
                return privateSetPublishedRevisionAsync(request);
            }
        });
    }

    /**
     * Sets the currently published revision of a title Cloud Script
     * @param request SetPublishedRevisionRequest
     * @return SetPublishedRevisionResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetPublishedRevisionResult> SetPublishedRevision(final SetPublishedRevisionRequest request) {
        FutureTask<PlayFabResult<SetPublishedRevisionResult>> task = new FutureTask(new Callable<PlayFabResult<SetPublishedRevisionResult>>() {
            public PlayFabResult<SetPublishedRevisionResult> call() throws Exception {
                return privateSetPublishedRevisionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetPublishedRevisionResult> exceptionResult = new PlayFabResult<SetPublishedRevisionResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Sets the currently published revision of a title Cloud Script */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetPublishedRevisionResult> privateSetPublishedRevisionAsync(final SetPublishedRevisionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetPublishedRevision"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetPublishedRevisionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetPublishedRevisionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetPublishedRevisionResult>>(){}.getType());
        SetPublishedRevisionResult result = resultData.data;

        PlayFabResult<SetPublishedRevisionResult> pfResult = new PlayFabResult<SetPublishedRevisionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the key-value store of custom publisher settings
     * @param request SetPublisherDataRequest
     * @return Async Task will return SetPublisherDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetPublisherDataResult>> SetPublisherDataAsync(final SetPublisherDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetPublisherDataResult>>() {
            public PlayFabResult<SetPublisherDataResult> call() throws Exception {
                return privateSetPublisherDataAsync(request);
            }
        });
    }

    /**
     * Updates the key-value store of custom publisher settings
     * @param request SetPublisherDataRequest
     * @return SetPublisherDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetPublisherDataResult> SetPublisherData(final SetPublisherDataRequest request) {
        FutureTask<PlayFabResult<SetPublisherDataResult>> task = new FutureTask(new Callable<PlayFabResult<SetPublisherDataResult>>() {
            public PlayFabResult<SetPublisherDataResult> call() throws Exception {
                return privateSetPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetPublisherDataResult> exceptionResult = new PlayFabResult<SetPublisherDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the key-value store of custom publisher settings */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetPublisherDataResult> privateSetPublisherDataAsync(final SetPublisherDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetPublisherData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetPublisherDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetPublisherDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetPublisherDataResult>>(){}.getType());
        SetPublisherDataResult result = resultData.data;

        PlayFabResult<SetPublisherDataResult> pfResult = new PlayFabResult<SetPublisherDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets all the items in one virtual store
     * @param request UpdateStoreItemsRequest
     * @return Async Task will return UpdateStoreItemsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateStoreItemsResult>> SetStoreItemsAsync(final UpdateStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateSetStoreItemsAsync(request);
            }
        });
    }

    /**
     * Sets all the items in one virtual store
     * @param request UpdateStoreItemsRequest
     * @return UpdateStoreItemsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateStoreItemsResult> SetStoreItems(final UpdateStoreItemsRequest request) {
        FutureTask<PlayFabResult<UpdateStoreItemsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateSetStoreItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateStoreItemsResult> exceptionResult = new PlayFabResult<UpdateStoreItemsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Sets all the items in one virtual store */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateStoreItemsResult> privateSetStoreItemsAsync(final UpdateStoreItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetStoreItems"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateStoreItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateStoreItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateStoreItemsResult>>(){}.getType());
        UpdateStoreItemsResult result = resultData.data;

        PlayFabResult<UpdateStoreItemsResult> pfResult = new PlayFabResult<UpdateStoreItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates and updates the key-value store of custom title settings which can be read by the client
     * @param request SetTitleDataRequest
     * @return Async Task will return SetTitleDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetTitleDataResult>> SetTitleDataAsync(final SetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleDataAsync(request);
            }
        });
    }

    /**
     * Creates and updates the key-value store of custom title settings which can be read by the client
     * @param request SetTitleDataRequest
     * @return SetTitleDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetTitleDataResult> SetTitleData(final SetTitleDataRequest request) {
        FutureTask<PlayFabResult<SetTitleDataResult>> task = new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetTitleDataResult> exceptionResult = new PlayFabResult<SetTitleDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates and updates the key-value store of custom title settings which can be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetTitleDataResult> privateSetTitleDataAsync(final SetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetTitleData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetTitleDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetTitleDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetTitleDataResult>>(){}.getType());
        SetTitleDataResult result = resultData.data;

        PlayFabResult<SetTitleDataResult> pfResult = new PlayFabResult<SetTitleDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Set and delete key-value pairs in a title data override instance.
     * @param request SetTitleDataAndOverridesRequest
     * @return Async Task will return SetTitleDataAndOverridesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetTitleDataAndOverridesResult>> SetTitleDataAndOverridesAsync(final SetTitleDataAndOverridesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTitleDataAndOverridesResult>>() {
            public PlayFabResult<SetTitleDataAndOverridesResult> call() throws Exception {
                return privateSetTitleDataAndOverridesAsync(request);
            }
        });
    }

    /**
     * Set and delete key-value pairs in a title data override instance.
     * @param request SetTitleDataAndOverridesRequest
     * @return SetTitleDataAndOverridesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetTitleDataAndOverridesResult> SetTitleDataAndOverrides(final SetTitleDataAndOverridesRequest request) {
        FutureTask<PlayFabResult<SetTitleDataAndOverridesResult>> task = new FutureTask(new Callable<PlayFabResult<SetTitleDataAndOverridesResult>>() {
            public PlayFabResult<SetTitleDataAndOverridesResult> call() throws Exception {
                return privateSetTitleDataAndOverridesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetTitleDataAndOverridesResult> exceptionResult = new PlayFabResult<SetTitleDataAndOverridesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Set and delete key-value pairs in a title data override instance. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetTitleDataAndOverridesResult> privateSetTitleDataAndOverridesAsync(final SetTitleDataAndOverridesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetTitleDataAndOverrides"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetTitleDataAndOverridesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetTitleDataAndOverridesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetTitleDataAndOverridesResult>>(){}.getType());
        SetTitleDataAndOverridesResult result = resultData.data;

        PlayFabResult<SetTitleDataAndOverridesResult> pfResult = new PlayFabResult<SetTitleDataAndOverridesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the key-value store of custom title settings which cannot be read by the client
     * @param request SetTitleDataRequest
     * @return Async Task will return SetTitleDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetTitleDataResult>> SetTitleInternalDataAsync(final SetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the key-value store of custom title settings which cannot be read by the client
     * @param request SetTitleDataRequest
     * @return SetTitleDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetTitleDataResult> SetTitleInternalData(final SetTitleDataRequest request) {
        FutureTask<PlayFabResult<SetTitleDataResult>> task = new FutureTask(new Callable<PlayFabResult<SetTitleDataResult>>() {
            public PlayFabResult<SetTitleDataResult> call() throws Exception {
                return privateSetTitleInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetTitleDataResult> exceptionResult = new PlayFabResult<SetTitleDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the key-value store of custom title settings which cannot be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetTitleDataResult> privateSetTitleInternalDataAsync(final SetTitleDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetTitleInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetTitleDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetTitleDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetTitleDataResult>>(){}.getType());
        SetTitleDataResult result = resultData.data;

        PlayFabResult<SetTitleDataResult> pfResult = new PlayFabResult<SetTitleDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Set and delete key-value pairs in a title internal data override instance.
     * @param request SetTitleDataAndOverridesRequest
     * @return Async Task will return SetTitleDataAndOverridesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetTitleDataAndOverridesResult>> SetTitleInternalDataAndOverridesAsync(final SetTitleDataAndOverridesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetTitleDataAndOverridesResult>>() {
            public PlayFabResult<SetTitleDataAndOverridesResult> call() throws Exception {
                return privateSetTitleInternalDataAndOverridesAsync(request);
            }
        });
    }

    /**
     * Set and delete key-value pairs in a title internal data override instance.
     * @param request SetTitleDataAndOverridesRequest
     * @return SetTitleDataAndOverridesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetTitleDataAndOverridesResult> SetTitleInternalDataAndOverrides(final SetTitleDataAndOverridesRequest request) {
        FutureTask<PlayFabResult<SetTitleDataAndOverridesResult>> task = new FutureTask(new Callable<PlayFabResult<SetTitleDataAndOverridesResult>>() {
            public PlayFabResult<SetTitleDataAndOverridesResult> call() throws Exception {
                return privateSetTitleInternalDataAndOverridesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetTitleDataAndOverridesResult> exceptionResult = new PlayFabResult<SetTitleDataAndOverridesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Set and delete key-value pairs in a title internal data override instance. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetTitleDataAndOverridesResult> privateSetTitleInternalDataAndOverridesAsync(final SetTitleDataAndOverridesRequest request) throws Exception {

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetTitleInternalDataAndOverrides"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetTitleDataAndOverridesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetTitleDataAndOverridesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetTitleDataAndOverridesResult>>(){}.getType());
        SetTitleDataAndOverridesResult result = resultData.data;

        PlayFabResult<SetTitleDataAndOverridesResult> pfResult = new PlayFabResult<SetTitleDataAndOverridesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the Amazon Resource Name (ARN) for iOS and Android push notifications. Documentation on the exact restrictions can
     * be found at: http://docs.aws.amazon.com/sns/latest/api/API_CreatePlatformApplication.html. Currently, Amazon device
     * Messaging is not supported.
     * @param request SetupPushNotificationRequest
     * @return Async Task will return SetupPushNotificationResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetupPushNotificationResult>> SetupPushNotificationAsync(final SetupPushNotificationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetupPushNotificationResult>>() {
            public PlayFabResult<SetupPushNotificationResult> call() throws Exception {
                return privateSetupPushNotificationAsync(request);
            }
        });
    }

    /**
     * Sets the Amazon Resource Name (ARN) for iOS and Android push notifications. Documentation on the exact restrictions can
     * be found at: http://docs.aws.amazon.com/sns/latest/api/API_CreatePlatformApplication.html. Currently, Amazon device
     * Messaging is not supported.
     * @param request SetupPushNotificationRequest
     * @return SetupPushNotificationResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetupPushNotificationResult> SetupPushNotification(final SetupPushNotificationRequest request) {
        FutureTask<PlayFabResult<SetupPushNotificationResult>> task = new FutureTask(new Callable<PlayFabResult<SetupPushNotificationResult>>() {
            public PlayFabResult<SetupPushNotificationResult> call() throws Exception {
                return privateSetupPushNotificationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetupPushNotificationResult> exceptionResult = new PlayFabResult<SetupPushNotificationResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Sets the Amazon Resource Name (ARN) for iOS and Android push notifications. Documentation on the exact restrictions can
     * be found at: http://docs.aws.amazon.com/sns/latest/api/API_CreatePlatformApplication.html. Currently, Amazon device
     * Messaging is not supported.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetupPushNotificationResult> privateSetupPushNotificationAsync(final SetupPushNotificationRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SetupPushNotification"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetupPushNotificationResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetupPushNotificationResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetupPushNotificationResult>>(){}.getType());
        SetupPushNotificationResult result = resultData.data;

        PlayFabResult<SetupPushNotificationResult> pfResult = new PlayFabResult<SetupPushNotificationResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Decrements the specified virtual currency by the stated amount
     * @param request SubtractUserVirtualCurrencyRequest
     * @return Async Task will return ModifyUserVirtualCurrencyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> SubtractUserVirtualCurrencyAsync(final SubtractUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateSubtractUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Decrements the specified virtual currency by the stated amount
     * @param request SubtractUserVirtualCurrencyRequest
     * @return ModifyUserVirtualCurrencyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ModifyUserVirtualCurrencyResult> SubtractUserVirtualCurrency(final SubtractUserVirtualCurrencyRequest request) {
        FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateSubtractUserVirtualCurrencyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ModifyUserVirtualCurrencyResult> exceptionResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Decrements the specified virtual currency by the stated amount */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateSubtractUserVirtualCurrencyAsync(final SubtractUserVirtualCurrencyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/SubtractUserVirtualCurrency"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult>>(){}.getType());
        ModifyUserVirtualCurrencyResult result = resultData.data;

        PlayFabResult<ModifyUserVirtualCurrencyResult> pfResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates information of a list of existing bans specified with Ban Ids.
     * @param request UpdateBansRequest
     * @return Async Task will return UpdateBansResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateBansResult>> UpdateBansAsync(final UpdateBansRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateBansResult>>() {
            public PlayFabResult<UpdateBansResult> call() throws Exception {
                return privateUpdateBansAsync(request);
            }
        });
    }

    /**
     * Updates information of a list of existing bans specified with Ban Ids.
     * @param request UpdateBansRequest
     * @return UpdateBansResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateBansResult> UpdateBans(final UpdateBansRequest request) {
        FutureTask<PlayFabResult<UpdateBansResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateBansResult>>() {
            public PlayFabResult<UpdateBansResult> call() throws Exception {
                return privateUpdateBansAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateBansResult> exceptionResult = new PlayFabResult<UpdateBansResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates information of a list of existing bans specified with Ban Ids. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateBansResult> privateUpdateBansAsync(final UpdateBansRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateBans"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateBansResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateBansResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateBansResult>>(){}.getType());
        UpdateBansResult result = resultData.data;

        PlayFabResult<UpdateBansResult> pfResult = new PlayFabResult<UpdateBansResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the catalog configuration for virtual goods in the specified catalog version
     * @param request UpdateCatalogItemsRequest
     * @return Async Task will return UpdateCatalogItemsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCatalogItemsResult>> UpdateCatalogItemsAsync(final UpdateCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateUpdateCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Updates the catalog configuration for virtual goods in the specified catalog version
     * @param request UpdateCatalogItemsRequest
     * @return UpdateCatalogItemsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCatalogItemsResult> UpdateCatalogItems(final UpdateCatalogItemsRequest request) {
        FutureTask<PlayFabResult<UpdateCatalogItemsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCatalogItemsResult>>() {
            public PlayFabResult<UpdateCatalogItemsResult> call() throws Exception {
                return privateUpdateCatalogItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateCatalogItemsResult> exceptionResult = new PlayFabResult<UpdateCatalogItemsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the catalog configuration for virtual goods in the specified catalog version */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCatalogItemsResult> privateUpdateCatalogItemsAsync(final UpdateCatalogItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateCatalogItems"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCatalogItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateCatalogItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCatalogItemsResult>>(){}.getType());
        UpdateCatalogItemsResult result = resultData.data;

        PlayFabResult<UpdateCatalogItemsResult> pfResult = new PlayFabResult<UpdateCatalogItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a new Cloud Script revision and uploads source code to it. Note that at this time, only one file should be
     * submitted in the revision.
     * @param request UpdateCloudScriptRequest
     * @return Async Task will return UpdateCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCloudScriptResult>> UpdateCloudScriptAsync(final UpdateCloudScriptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCloudScriptResult>>() {
            public PlayFabResult<UpdateCloudScriptResult> call() throws Exception {
                return privateUpdateCloudScriptAsync(request);
            }
        });
    }

    /**
     * Creates a new Cloud Script revision and uploads source code to it. Note that at this time, only one file should be
     * submitted in the revision.
     * @param request UpdateCloudScriptRequest
     * @return UpdateCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCloudScriptResult> UpdateCloudScript(final UpdateCloudScriptRequest request) {
        FutureTask<PlayFabResult<UpdateCloudScriptResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCloudScriptResult>>() {
            public PlayFabResult<UpdateCloudScriptResult> call() throws Exception {
                return privateUpdateCloudScriptAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateCloudScriptResult> exceptionResult = new PlayFabResult<UpdateCloudScriptResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Creates a new Cloud Script revision and uploads source code to it. Note that at this time, only one file should be
     * submitted in the revision.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCloudScriptResult> privateUpdateCloudScriptAsync(final UpdateCloudScriptRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateCloudScript"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCloudScriptResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateCloudScriptResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCloudScriptResult>>(){}.getType());
        UpdateCloudScriptResult result = resultData.data;

        PlayFabResult<UpdateCloudScriptResult> pfResult = new PlayFabResult<UpdateCloudScriptResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Modifies data and credentials for an existing relationship between a title and an Open ID Connect provider
     * @param request UpdateOpenIdConnectionRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateOpenIdConnectionAsync(final UpdateOpenIdConnectionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateOpenIdConnectionAsync(request);
            }
        });
    }

    /**
     * Modifies data and credentials for an existing relationship between a title and an Open ID Connect provider
     * @param request UpdateOpenIdConnectionRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateOpenIdConnection(final UpdateOpenIdConnectionRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateOpenIdConnectionAsync(request);
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

    /** Modifies data and credentials for an existing relationship between a title and an Open ID Connect provider */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateOpenIdConnectionAsync(final UpdateOpenIdConnectionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateOpenIdConnection"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates a existing Player Shared Secret Key. It may take up to 5 minutes for this update to become generally available
     * after this API returns.
     * @param request UpdatePlayerSharedSecretRequest
     * @return Async Task will return UpdatePlayerSharedSecretResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdatePlayerSharedSecretResult>> UpdatePlayerSharedSecretAsync(final UpdatePlayerSharedSecretRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdatePlayerSharedSecretResult>>() {
            public PlayFabResult<UpdatePlayerSharedSecretResult> call() throws Exception {
                return privateUpdatePlayerSharedSecretAsync(request);
            }
        });
    }

    /**
     * Updates a existing Player Shared Secret Key. It may take up to 5 minutes for this update to become generally available
     * after this API returns.
     * @param request UpdatePlayerSharedSecretRequest
     * @return UpdatePlayerSharedSecretResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdatePlayerSharedSecretResult> UpdatePlayerSharedSecret(final UpdatePlayerSharedSecretRequest request) {
        FutureTask<PlayFabResult<UpdatePlayerSharedSecretResult>> task = new FutureTask(new Callable<PlayFabResult<UpdatePlayerSharedSecretResult>>() {
            public PlayFabResult<UpdatePlayerSharedSecretResult> call() throws Exception {
                return privateUpdatePlayerSharedSecretAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdatePlayerSharedSecretResult> exceptionResult = new PlayFabResult<UpdatePlayerSharedSecretResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Updates a existing Player Shared Secret Key. It may take up to 5 minutes for this update to become generally available
     * after this API returns.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdatePlayerSharedSecretResult> privateUpdatePlayerSharedSecretAsync(final UpdatePlayerSharedSecretRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdatePlayerSharedSecret"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdatePlayerSharedSecretResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdatePlayerSharedSecretResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdatePlayerSharedSecretResult>>(){}.getType());
        UpdatePlayerSharedSecretResult result = resultData.data;

        PlayFabResult<UpdatePlayerSharedSecretResult> pfResult = new PlayFabResult<UpdatePlayerSharedSecretResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates a player statistic configuration for the title, optionally allowing the developer to specify a reset interval.
     * @param request UpdatePlayerStatisticDefinitionRequest
     * @return Async Task will return UpdatePlayerStatisticDefinitionResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdatePlayerStatisticDefinitionResult>> UpdatePlayerStatisticDefinitionAsync(final UpdatePlayerStatisticDefinitionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdatePlayerStatisticDefinitionResult>>() {
            public PlayFabResult<UpdatePlayerStatisticDefinitionResult> call() throws Exception {
                return privateUpdatePlayerStatisticDefinitionAsync(request);
            }
        });
    }

    /**
     * Updates a player statistic configuration for the title, optionally allowing the developer to specify a reset interval.
     * @param request UpdatePlayerStatisticDefinitionRequest
     * @return UpdatePlayerStatisticDefinitionResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdatePlayerStatisticDefinitionResult> UpdatePlayerStatisticDefinition(final UpdatePlayerStatisticDefinitionRequest request) {
        FutureTask<PlayFabResult<UpdatePlayerStatisticDefinitionResult>> task = new FutureTask(new Callable<PlayFabResult<UpdatePlayerStatisticDefinitionResult>>() {
            public PlayFabResult<UpdatePlayerStatisticDefinitionResult> call() throws Exception {
                return privateUpdatePlayerStatisticDefinitionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdatePlayerStatisticDefinitionResult> exceptionResult = new PlayFabResult<UpdatePlayerStatisticDefinitionResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates a player statistic configuration for the title, optionally allowing the developer to specify a reset interval. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdatePlayerStatisticDefinitionResult> privateUpdatePlayerStatisticDefinitionAsync(final UpdatePlayerStatisticDefinitionRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdatePlayerStatisticDefinition"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdatePlayerStatisticDefinitionResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdatePlayerStatisticDefinitionResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdatePlayerStatisticDefinitionResult>>(){}.getType());
        UpdatePlayerStatisticDefinitionResult result = resultData.data;

        PlayFabResult<UpdatePlayerStatisticDefinitionResult> pfResult = new PlayFabResult<UpdatePlayerStatisticDefinitionResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Changes a policy for a title
     * @param request UpdatePolicyRequest
     * @return Async Task will return UpdatePolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdatePolicyResponse>> UpdatePolicyAsync(final UpdatePolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdatePolicyResponse>>() {
            public PlayFabResult<UpdatePolicyResponse> call() throws Exception {
                return privateUpdatePolicyAsync(request);
            }
        });
    }

    /**
     * Changes a policy for a title
     * @param request UpdatePolicyRequest
     * @return UpdatePolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdatePolicyResponse> UpdatePolicy(final UpdatePolicyRequest request) {
        FutureTask<PlayFabResult<UpdatePolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdatePolicyResponse>>() {
            public PlayFabResult<UpdatePolicyResponse> call() throws Exception {
                return privateUpdatePolicyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdatePolicyResponse> exceptionResult = new PlayFabResult<UpdatePolicyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Changes a policy for a title */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdatePolicyResponse> privateUpdatePolicyAsync(final UpdatePolicyRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdatePolicy"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdatePolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdatePolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdatePolicyResponse>>(){}.getType());
        UpdatePolicyResponse result = resultData.data;

        PlayFabResult<UpdatePolicyResponse> pfResult = new PlayFabResult<UpdatePolicyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the random drop table configuration for the title
     * @param request UpdateRandomResultTablesRequest
     * @return Async Task will return UpdateRandomResultTablesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateRandomResultTablesResult>> UpdateRandomResultTablesAsync(final UpdateRandomResultTablesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateRandomResultTablesResult>>() {
            public PlayFabResult<UpdateRandomResultTablesResult> call() throws Exception {
                return privateUpdateRandomResultTablesAsync(request);
            }
        });
    }

    /**
     * Updates the random drop table configuration for the title
     * @param request UpdateRandomResultTablesRequest
     * @return UpdateRandomResultTablesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateRandomResultTablesResult> UpdateRandomResultTables(final UpdateRandomResultTablesRequest request) {
        FutureTask<PlayFabResult<UpdateRandomResultTablesResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateRandomResultTablesResult>>() {
            public PlayFabResult<UpdateRandomResultTablesResult> call() throws Exception {
                return privateUpdateRandomResultTablesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateRandomResultTablesResult> exceptionResult = new PlayFabResult<UpdateRandomResultTablesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the random drop table configuration for the title */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateRandomResultTablesResult> privateUpdateRandomResultTablesAsync(final UpdateRandomResultTablesRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateRandomResultTables"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateRandomResultTablesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateRandomResultTablesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateRandomResultTablesResult>>(){}.getType());
        UpdateRandomResultTablesResult result = resultData.data;

        PlayFabResult<UpdateRandomResultTablesResult> pfResult = new PlayFabResult<UpdateRandomResultTablesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates an existing player segment and its associated definition(s) and action(s) for a title.
     * @param request UpdateSegmentRequest
     * @return Async Task will return UpdateSegmentResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateSegmentResponse>> UpdateSegmentAsync(final UpdateSegmentRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateSegmentResponse>>() {
            public PlayFabResult<UpdateSegmentResponse> call() throws Exception {
                return privateUpdateSegmentAsync(request);
            }
        });
    }

    /**
     * Updates an existing player segment and its associated definition(s) and action(s) for a title.
     * @param request UpdateSegmentRequest
     * @return UpdateSegmentResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateSegmentResponse> UpdateSegment(final UpdateSegmentRequest request) {
        FutureTask<PlayFabResult<UpdateSegmentResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdateSegmentResponse>>() {
            public PlayFabResult<UpdateSegmentResponse> call() throws Exception {
                return privateUpdateSegmentAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateSegmentResponse> exceptionResult = new PlayFabResult<UpdateSegmentResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates an existing player segment and its associated definition(s) and action(s) for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateSegmentResponse> privateUpdateSegmentAsync(final UpdateSegmentRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateSegment"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateSegmentResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateSegmentResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateSegmentResponse>>(){}.getType());
        UpdateSegmentResponse result = resultData.data;

        PlayFabResult<UpdateSegmentResponse> pfResult = new PlayFabResult<UpdateSegmentResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates an existing virtual item store with new or modified items
     * @param request UpdateStoreItemsRequest
     * @return Async Task will return UpdateStoreItemsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateStoreItemsResult>> UpdateStoreItemsAsync(final UpdateStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateUpdateStoreItemsAsync(request);
            }
        });
    }

    /**
     * Updates an existing virtual item store with new or modified items
     * @param request UpdateStoreItemsRequest
     * @return UpdateStoreItemsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateStoreItemsResult> UpdateStoreItems(final UpdateStoreItemsRequest request) {
        FutureTask<PlayFabResult<UpdateStoreItemsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateStoreItemsResult>>() {
            public PlayFabResult<UpdateStoreItemsResult> call() throws Exception {
                return privateUpdateStoreItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateStoreItemsResult> exceptionResult = new PlayFabResult<UpdateStoreItemsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates an existing virtual item store with new or modified items */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateStoreItemsResult> privateUpdateStoreItemsAsync(final UpdateStoreItemsRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateStoreItems"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateStoreItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateStoreItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateStoreItemsResult>>(){}.getType());
        UpdateStoreItemsResult result = resultData.data;

        PlayFabResult<UpdateStoreItemsResult> pfResult = new PlayFabResult<UpdateStoreItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Update an existing task.
     * @param request UpdateTaskRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateTaskAsync(final UpdateTaskRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateTaskAsync(request);
            }
        });
    }

    /**
     * Update an existing task.
     * @param request UpdateTaskRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateTask(final UpdateTaskRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateTaskAsync(request);
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

    /** Update an existing task. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateTaskAsync(final UpdateTaskRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateTask"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
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
     * Updates the title-specific custom data for the user which is readable and writable by the client
     * @param request UpdateUserDataRequest
     * @return Async Task will return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserDataAsync(final UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user which is readable and writable by the client
     * @param request UpdateUserDataRequest
     * @return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserData(final UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateUserDataResult> exceptionResult = new PlayFabResult<UpdateUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the title-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateUserData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType());
        UpdateUserDataResult result = resultData.data;

        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the title-specific custom data for the user which cannot be accessed by the client
     * @param request UpdateUserInternalDataRequest
     * @return Async Task will return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserInternalDataAsync(final UpdateUserInternalDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user which cannot be accessed by the client
     * @param request UpdateUserInternalDataRequest
     * @return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserInternalData(final UpdateUserInternalDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateUserDataResult> exceptionResult = new PlayFabResult<UpdateUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the title-specific custom data for the user which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserInternalDataAsync(final UpdateUserInternalDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateUserInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType());
        UpdateUserDataResult result = resultData.data;

        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the publisher-specific custom data for the user which is readable and writable by the client
     * @param request UpdateUserDataRequest
     * @return Async Task will return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherDataAsync(final UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherDataAsync(request);
            }
        });
    }

    /**
     * Updates the publisher-specific custom data for the user which is readable and writable by the client
     * @param request UpdateUserDataRequest
     * @return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherData(final UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateUserDataResult> exceptionResult = new PlayFabResult<UpdateUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the publisher-specific custom data for the user which is readable and writable by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateUserPublisherData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType());
        UpdateUserDataResult result = resultData.data;

        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the publisher-specific custom data for the user which cannot be accessed by the client
     * @param request UpdateUserInternalDataRequest
     * @return Async Task will return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherInternalDataAsync(final UpdateUserInternalDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherInternalDataAsync(request);
            }
        });
    }

    /**
     * Updates the publisher-specific custom data for the user which cannot be accessed by the client
     * @param request UpdateUserInternalDataRequest
     * @return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherInternalData(final UpdateUserInternalDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherInternalDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateUserDataResult> exceptionResult = new PlayFabResult<UpdateUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the publisher-specific custom data for the user which cannot be accessed by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherInternalDataAsync(final UpdateUserInternalDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateUserPublisherInternalData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType());
        UpdateUserDataResult result = resultData.data;

        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the publisher-specific custom data for the user which can only be read by the client
     * @param request UpdateUserDataRequest
     * @return Async Task will return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherReadOnlyDataAsync(final UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Updates the publisher-specific custom data for the user which can only be read by the client
     * @param request UpdateUserDataRequest
     * @return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherReadOnlyData(final UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateUserDataResult> exceptionResult = new PlayFabResult<UpdateUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the publisher-specific custom data for the user which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherReadOnlyDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateUserPublisherReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType());
        UpdateUserDataResult result = resultData.data;

        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the title-specific custom data for the user which can only be read by the client
     * @param request UpdateUserDataRequest
     * @return Async Task will return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserReadOnlyDataAsync(final UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Updates the title-specific custom data for the user which can only be read by the client
     * @param request UpdateUserDataRequest
     * @return UpdateUserDataResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserDataResult> UpdateUserReadOnlyData(final UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateUserDataResult> exceptionResult = new PlayFabResult<UpdateUserDataResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the title-specific custom data for the user which can only be read by the client */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserReadOnlyDataAsync(final UpdateUserDataRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateUserReadOnlyData"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType());
        UpdateUserDataResult result = resultData.data;

        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the title specific display name for a user
     * @param request UpdateUserTitleDisplayNameRequest
     * @return Async Task will return UpdateUserTitleDisplayNameResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateUserTitleDisplayNameResult>> UpdateUserTitleDisplayNameAsync(final UpdateUserTitleDisplayNameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserTitleDisplayNameResult>>() {
            public PlayFabResult<UpdateUserTitleDisplayNameResult> call() throws Exception {
                return privateUpdateUserTitleDisplayNameAsync(request);
            }
        });
    }

    /**
     * Updates the title specific display name for a user
     * @param request UpdateUserTitleDisplayNameRequest
     * @return UpdateUserTitleDisplayNameResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateUserTitleDisplayNameResult> UpdateUserTitleDisplayName(final UpdateUserTitleDisplayNameRequest request) {
        FutureTask<PlayFabResult<UpdateUserTitleDisplayNameResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserTitleDisplayNameResult>>() {
            public PlayFabResult<UpdateUserTitleDisplayNameResult> call() throws Exception {
                return privateUpdateUserTitleDisplayNameAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateUserTitleDisplayNameResult> exceptionResult = new PlayFabResult<UpdateUserTitleDisplayNameResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the title specific display name for a user */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateUserTitleDisplayNameResult> privateUpdateUserTitleDisplayNameAsync(final UpdateUserTitleDisplayNameRequest request) throws Exception {
        if (PlayFabSettings.DeveloperSecretKey == null) throw new Exception ("Must have PlayFabSettings.DeveloperSecretKey set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Admin/UpdateUserTitleDisplayName"), request, "X-SecretKey", PlayFabSettings.DeveloperSecretKey);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserTitleDisplayNameResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateUserTitleDisplayNameResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserTitleDisplayNameResult>>(){}.getType());
        UpdateUserTitleDisplayNameResult result = resultData.data;

        PlayFabResult<UpdateUserTitleDisplayNameResult> pfResult = new PlayFabResult<UpdateUserTitleDisplayNameResult>();
        pfResult.Result = result;
        return pfResult;
    }

}
