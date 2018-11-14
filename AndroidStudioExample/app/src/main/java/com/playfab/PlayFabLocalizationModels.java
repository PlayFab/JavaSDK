package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabLocalizationModels {

    public static class GetLanguageListRequest {
        
    }

    public static class GetLanguageListResponse {
        /** The list of allowed languages, in BCP47 two-letter format */
        public ArrayList<String> LanguageList;
        
    }

}
