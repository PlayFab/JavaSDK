package com.playfab;

public interface PlayFabFailure {
    /**
     * Standard error returned from PlayFab
     */
    void failure(PlayFabErrors.PlayFabError error);


}
