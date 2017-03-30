package com.playfab.debug;

import com.playfab.PlayFabErrors;
import com.playfab.PlayFabFailure;
import com.playfab.PlayFabLowLevelFailure;
import com.playfab.PlayFabSuccess;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * This debugger class is a quick & dirty way to sort out issues with your PlayFab async interactions.  Use it to
 * wrap your success and you can see the values of the top level fields in the response object.
 */
public class PlayFabDebug<R> implements PlayFabSuccess<R>, PlayFabFailure, PlayFabLowLevelFailure {

    private final PlayFabSuccess<R> wrappedSuccess;
    private String name;
    private PrintStream out;

    public PlayFabDebug(String name, PrintStream out) {
        this.name = name;
        this.out = out;
        wrappedSuccess = null;
    }

    public PlayFabDebug(PlayFabSuccess<R> wrappedSuccess, String name, PrintStream out) {
        this.wrappedSuccess = wrappedSuccess;
        this.name = name;
        this.out = out;
    }

    @Override
    public void success(R result) {

        if (result == null)
            out.println("   SUCCESS>" + name + ": No value set");
        else {
            out.println("   SUCCESS>" + name + ":" + result.toString());

            for (Field field : result.getClass().getDeclaredFields()) {
                try {
                    if (field.get(result) != null)
                        out.println("     FIELD>" + field.getName() + ":" + field.get(result).toString());
                } catch (IllegalAccessException e) {
                }
            }
        }
        if (wrappedSuccess != null)
            wrappedSuccess.success(result);
    }

    @Override
    public void failure(PlayFabErrors.PlayFabError error) {
        out.println("   FAILURE>" + name + "->" + error.errorMessage);
        if (error.errorDetails != null && error.errorDetails.size() > 0) {
            Map<String, List<String>> details = error.errorDetails;
            for (String key : details.keySet()) {
                for (String value : details.get(key)) {
                    out.println("  " + key + "->" + value);
                }
            }
        }

    }

    @Override
    public boolean failure(Exception e) {
        out.println(e);
        return false;
    }
}
