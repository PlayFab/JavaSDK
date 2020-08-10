package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabLocalizationModels {

    public static class GetLanguageListRequest extends PlayFabRequestSettingsModel{
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public GetLanguageListRequest() {
        }

        public GetLanguageListRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetLanguageListResponse {
        /** The list of allowed languages, in BCP47 two-letter format */
        public ArrayList<String> LanguageList;
        
    }

}
