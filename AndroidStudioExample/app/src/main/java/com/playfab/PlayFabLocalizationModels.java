package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabLocalizationModels {

    @Deprecated
    public static class GetLanguageListRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class GetLanguageListResponse {
        /** The list of allowed languages, in BCP47 two-letter format */
        @Deprecated
        public ArrayList<String> LanguageList;
        
    }

}
