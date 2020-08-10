package com.playfab;

public class PlayFabRequestSettingsModel {
    public String titleId;
    public String developerSecretKey;

    public PlayFabRequestSettingsModel() {
    }

    public PlayFabRequestSettingsModel(String titleId, String developerSecretKey) {
        this.titleId = titleId;
        this.developerSecretKey = developerSecretKey;
    }
}
