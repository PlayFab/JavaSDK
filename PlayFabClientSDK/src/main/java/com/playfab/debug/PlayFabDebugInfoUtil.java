package com.playfab.debug;

import com.playfab.PlayFabErrors;

import java.util.List;
import java.util.Map;

public class PlayFabDebugInfoUtil {

    public static <RT> String compileErrorsFromResult(PlayFabErrors.PlayFabResult<RT> result) {
        if (result == null || result.Error == null)
            return null;

        String errorMessage = "";
        if (result.Error.errorMessage != null)
            errorMessage += result.Error.errorMessage;
        if (result.Error.errorDetails != null)
            for (Map.Entry<String, List<String>> pair : result.Error.errorDetails.entrySet())
                for (String msg : pair.getValue())
                    errorMessage += "\n" + pair.getKey() + ": " + msg;
        return errorMessage;
    }

    public static <RT> String compileErrors(PlayFabErrors.PlayFabError error) {

        String errorMessage = "";
        if (error.errorMessage != null)
            errorMessage += error.errorMessage;
        if (error.errorDetails != null)
            for (Map.Entry<String, List<String>> pair : error.errorDetails.entrySet())
                for (String msg : pair.getValue())
                    errorMessage += "\n" + pair.getKey() + ": " + msg;
        return errorMessage;
    }
}
