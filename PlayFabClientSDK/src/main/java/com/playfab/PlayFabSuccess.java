package com.playfab;

public interface PlayFabSuccess<R> {
    /**
     * Called when the service returns successfully
     */
    void success(R result);
}
