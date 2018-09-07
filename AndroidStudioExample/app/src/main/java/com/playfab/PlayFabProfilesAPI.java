package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabProfilesModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /**
     * All PlayFab entities have profiles, which hold top-level properties about the entity. These APIs give you the tools
     * needed to manage entity profiles.
     */
public class PlayFabProfilesAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Gets the global title access policy
     * @param request GetGlobalPolicyRequest
     * @return Async Task will return GetGlobalPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetGlobalPolicyResponse>> GetGlobalPolicyAsync(final GetGlobalPolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetGlobalPolicyResponse>>() {
            public PlayFabResult<GetGlobalPolicyResponse> call() throws Exception {
                return privateGetGlobalPolicyAsync(request);
            }
        });
    }

    /**
     * Gets the global title access policy
     * @param request GetGlobalPolicyRequest
     * @return GetGlobalPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetGlobalPolicyResponse> GetGlobalPolicy(final GetGlobalPolicyRequest request) {
        FutureTask<PlayFabResult<GetGlobalPolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<GetGlobalPolicyResponse>>() {
            public PlayFabResult<GetGlobalPolicyResponse> call() throws Exception {
                return privateGetGlobalPolicyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets the global title access policy */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetGlobalPolicyResponse> privateGetGlobalPolicyAsync(final GetGlobalPolicyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Profile/GetGlobalPolicy"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetGlobalPolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetGlobalPolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetGlobalPolicyResponse>>(){}.getType());
        GetGlobalPolicyResponse result = resultData.data;

        PlayFabResult<GetGlobalPolicyResponse> pfResult = new PlayFabResult<GetGlobalPolicyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the entity's profile.
     * @param request GetEntityProfileRequest
     * @return Async Task will return GetEntityProfileResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityProfileResponse>> GetProfileAsync(final GetEntityProfileRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityProfileResponse>>() {
            public PlayFabResult<GetEntityProfileResponse> call() throws Exception {
                return privateGetProfileAsync(request);
            }
        });
    }

    /**
     * Retrieves the entity's profile.
     * @param request GetEntityProfileRequest
     * @return GetEntityProfileResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityProfileResponse> GetProfile(final GetEntityProfileRequest request) {
        FutureTask<PlayFabResult<GetEntityProfileResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityProfileResponse>>() {
            public PlayFabResult<GetEntityProfileResponse> call() throws Exception {
                return privateGetProfileAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves the entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityProfileResponse> privateGetProfileAsync(final GetEntityProfileRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Profile/GetProfile"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityProfileResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityProfileResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityProfileResponse>>(){}.getType());
        GetEntityProfileResponse result = resultData.data;

        PlayFabResult<GetEntityProfileResponse> pfResult = new PlayFabResult<GetEntityProfileResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the entity's profile.
     * @param request GetEntityProfilesRequest
     * @return Async Task will return GetEntityProfilesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityProfilesResponse>> GetProfilesAsync(final GetEntityProfilesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityProfilesResponse>>() {
            public PlayFabResult<GetEntityProfilesResponse> call() throws Exception {
                return privateGetProfilesAsync(request);
            }
        });
    }

    /**
     * Retrieves the entity's profile.
     * @param request GetEntityProfilesRequest
     * @return GetEntityProfilesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityProfilesResponse> GetProfiles(final GetEntityProfilesRequest request) {
        FutureTask<PlayFabResult<GetEntityProfilesResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityProfilesResponse>>() {
            public PlayFabResult<GetEntityProfilesResponse> call() throws Exception {
                return privateGetProfilesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves the entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityProfilesResponse> privateGetProfilesAsync(final GetEntityProfilesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Profile/GetProfiles"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityProfilesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityProfilesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityProfilesResponse>>(){}.getType());
        GetEntityProfilesResponse result = resultData.data;

        PlayFabResult<GetEntityProfilesResponse> pfResult = new PlayFabResult<GetEntityProfilesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the global title access policy
     * @param request SetGlobalPolicyRequest
     * @return Async Task will return SetGlobalPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetGlobalPolicyResponse>> SetGlobalPolicyAsync(final SetGlobalPolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetGlobalPolicyResponse>>() {
            public PlayFabResult<SetGlobalPolicyResponse> call() throws Exception {
                return privateSetGlobalPolicyAsync(request);
            }
        });
    }

    /**
     * Sets the global title access policy
     * @param request SetGlobalPolicyRequest
     * @return SetGlobalPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetGlobalPolicyResponse> SetGlobalPolicy(final SetGlobalPolicyRequest request) {
        FutureTask<PlayFabResult<SetGlobalPolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<SetGlobalPolicyResponse>>() {
            public PlayFabResult<SetGlobalPolicyResponse> call() throws Exception {
                return privateSetGlobalPolicyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Sets the global title access policy */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetGlobalPolicyResponse> privateSetGlobalPolicyAsync(final SetGlobalPolicyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Profile/SetGlobalPolicy"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetGlobalPolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetGlobalPolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetGlobalPolicyResponse>>(){}.getType());
        SetGlobalPolicyResponse result = resultData.data;

        PlayFabResult<SetGlobalPolicyResponse> pfResult = new PlayFabResult<SetGlobalPolicyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the entity's language. The precedence hierarchy for communication to the player is Title Player Account
     * language, Master Player Account language, and then title default language if the first two aren't set or supported.
     * @param request SetProfileLanguageRequest
     * @return Async Task will return SetProfileLanguageResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetProfileLanguageResponse>> SetProfileLanguageAsync(final SetProfileLanguageRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetProfileLanguageResponse>>() {
            public PlayFabResult<SetProfileLanguageResponse> call() throws Exception {
                return privateSetProfileLanguageAsync(request);
            }
        });
    }

    /**
     * Updates the entity's language. The precedence hierarchy for communication to the player is Title Player Account
     * language, Master Player Account language, and then title default language if the first two aren't set or supported.
     * @param request SetProfileLanguageRequest
     * @return SetProfileLanguageResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetProfileLanguageResponse> SetProfileLanguage(final SetProfileLanguageRequest request) {
        FutureTask<PlayFabResult<SetProfileLanguageResponse>> task = new FutureTask(new Callable<PlayFabResult<SetProfileLanguageResponse>>() {
            public PlayFabResult<SetProfileLanguageResponse> call() throws Exception {
                return privateSetProfileLanguageAsync(request);
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
     * Updates the entity's language. The precedence hierarchy for communication to the player is Title Player Account
     * language, Master Player Account language, and then title default language if the first two aren't set or supported.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetProfileLanguageResponse> privateSetProfileLanguageAsync(final SetProfileLanguageRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Profile/SetProfileLanguage"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetProfileLanguageResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetProfileLanguageResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetProfileLanguageResponse>>(){}.getType());
        SetProfileLanguageResponse result = resultData.data;

        PlayFabResult<SetProfileLanguageResponse> pfResult = new PlayFabResult<SetProfileLanguageResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the profiles access policy
     * @param request SetEntityProfilePolicyRequest
     * @return Async Task will return SetEntityProfilePolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetEntityProfilePolicyResponse>> SetProfilePolicyAsync(final SetEntityProfilePolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetEntityProfilePolicyResponse>>() {
            public PlayFabResult<SetEntityProfilePolicyResponse> call() throws Exception {
                return privateSetProfilePolicyAsync(request);
            }
        });
    }

    /**
     * Sets the profiles access policy
     * @param request SetEntityProfilePolicyRequest
     * @return SetEntityProfilePolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetEntityProfilePolicyResponse> SetProfilePolicy(final SetEntityProfilePolicyRequest request) {
        FutureTask<PlayFabResult<SetEntityProfilePolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<SetEntityProfilePolicyResponse>>() {
            public PlayFabResult<SetEntityProfilePolicyResponse> call() throws Exception {
                return privateSetProfilePolicyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Sets the profiles access policy */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetEntityProfilePolicyResponse> privateSetProfilePolicyAsync(final SetEntityProfilePolicyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Profile/SetProfilePolicy"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetEntityProfilePolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetEntityProfilePolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetEntityProfilePolicyResponse>>(){}.getType());
        SetEntityProfilePolicyResponse result = resultData.data;

        PlayFabResult<SetEntityProfilePolicyResponse> pfResult = new PlayFabResult<SetEntityProfilePolicyResponse>();
        pfResult.Result = result;
        return pfResult;
    }
}
