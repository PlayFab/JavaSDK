package com.playfab.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.playfab.PlayFabSettings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;


/**
 * This setup will look for a testTitleData.json file in either the current working directory, or if the
 * PF_TEST_TITLE_DATA_JSON environment variable is set it will look there.
 * <p>
 * You can find out about the format of the <a href="https://github
 * .com/PlayFab/SDKGenerator/blob/master/JenkinsConsoleUtility/testTitleData.md">testTitleData.json</a>.
 *
 * @throws FileNotFoundException If the file can't be found.
 * @see <a href="https://github.com/PlayFab/SDKGenerator/blob/master/JenkinsConsoleUtility/testTitleData.md">PlayFab
 * Test Data Info</a>
 */

public class PlayFabTestConfig {

    private static final String ENV_VAR = "PF_TEST_TITLE_DATA_JSON";

    /**
     * Returns the configured TitleDate
     */
    public static TitleData config() throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();

        Map<String, String> env = System.getenv();

        for(String x : env.keySet())
        {
            System.out.println(x + ":" + env.get(x));
        }

        String testTitleDataFile;
        TitleData resultData;
        if (env.get(ENV_VAR) != null) {
            testTitleDataFile = env.get(ENV_VAR);
            File file = new File(testTitleDataFile);
            if (!file.exists())
                System.err.println("Can't find " + file.getAbsolutePath() + " set via " + ENV_VAR);
            resultData = gson.fromJson(new JsonReader(new FileReader(testTitleDataFile)), TitleData.class);
        } else {
            File file = new File("testTitleData.json");
            if (!file.exists())
                System.err.println("Can't find " + file.getAbsolutePath() + " in tests.");

            resultData = gson.fromJson(new JsonReader(new FileReader("testTitleData.json")), TitleData.class);
        }

        PlayFabSettings.TitleId = resultData.titleId;

        return resultData;

    }

    public class TitleData {
        public String titleId;
        public String userEmail;
    }
}
