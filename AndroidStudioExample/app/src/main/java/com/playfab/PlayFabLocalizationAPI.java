package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabLocalizationModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** The Localization APIs give you the tools needed to manage language setup in your title. */
public class PlayFabLocalizationAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Retrieves the list of allowed languages, only accessible by title entities
     * @param request GetLanguageListRequest
     * @return Async Task will return GetLanguageListResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLanguageListResponse>> GetLanguageListAsync(final GetLanguageListRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLanguageListResponse>>() {
            public PlayFabResult<GetLanguageListResponse> call() throws Exception {
                return privateGetLanguageListAsync(request);
            }
        });
    }

    /**
     * Retrieves the list of allowed languages, only accessible by title entities
     * @param request GetLanguageListRequest
     * @return GetLanguageListResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLanguageListResponse> GetLanguageList(final GetLanguageListRequest request) {
        FutureTask<PlayFabResult<GetLanguageListResponse>> task = new FutureTask(new Callable<PlayFabResult<GetLanguageListResponse>>() {
            public PlayFabResult<GetLanguageListResponse> call() throws Exception {
                return privateGetLanguageListAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves the list of allowed languages, only accessible by title entities */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLanguageListResponse> privateGetLanguageListAsync(final GetLanguageListRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Locale/GetLanguageList"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLanguageListResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetLanguageListResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLanguageListResponse>>(){}.getType());
        GetLanguageListResponse result = resultData.data;

        PlayFabResult<GetLanguageListResponse> pfResult = new PlayFabResult<GetLanguageListResponse>();
        pfResult.Result = result;
        return pfResult;
    }
}
