package com.playfab;

import com.playfab.PlayFabErrors.PlayFabResult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Utility wrapper to let you use simple callbacks instead of having to deal with the FutureTask directly.
 *
 * @param <R> PlayFab Result
 * @see FutureTask the lower-level API used by PlayFab.
 */

public class PlayFabService<R> implements PlayFabSuccess<R> {

    private FutureTask<PlayFabResult<R>> task;

    private PlayFabSuccess<R> successCallback;
    private PlayFabFailure failureCallback;
    private PlayFabLowLevelFailure lowLevelFailureCallback;
    private float frequency = 50.0f;
    private float accumulator = 0;
    private R result;

    /**
     * Returns true if this service is currently waiting for a response from PlayFab
     */
    public boolean active() {
        return (!(task == null));
    }

    /**
     * How often the service is currently looking for a response
     */
    public float getFrequency() {
        return frequency;
    }

    /**
     * Set the frequency to check the result when updating. By default the frequency is 50ms.  This frequency is
     * modified by the service automatically if you specify automatic retries.
     */
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    /**
     * Actually fires off the request and looks for a response
     */
    public void start(FutureTask<PlayFabResult<R>> task) {

        if (this.task != null)
            throw new IllegalStateException("Should only have one live service request at a time!");

        this.task = task;
        this.task.run();
    }

    /**
     * Called by the service when the request comes back successfully
     */
    public void onSuccess(PlayFabSuccess<R> callback) {
        this.successCallback = callback;
    }

    /**
     * Called by the service when the request comes back with a PlayFab server failure
     */
    public void onFailure(PlayFabFailure callback) {
        this.failureCallback = callback;
    }

    /**
     * Called by the service when there is an error or exception that's not a response from the PlayFab servers.
     */
    public void onLowLevelFailure(PlayFabLowLevelFailure lowLevelFailureCallback) {
        this.lowLevelFailureCallback = lowLevelFailureCallback;
    }

    /**
     * Call this to cause the service to process the response and notify any callbacks.
     *
     * @param delta The time since the last check - typically this is the same delta you are getting from your game
     *              engine for a render.
     */
    public void update(float delta) {

        accumulator = accumulator + delta;

        if (accumulator > frequency) {
            accumulator = 0;
            updateTask(task);
        }
    }

    /**
     * Call this to update the service directly on whatever schedule you like.  This version does not do any
     * throttling for updates.
     */
    public void update() {
        updateTask(task);
    }

    /**
     * Treat this request as if it was a sync request.  It will block until success - there is no timeout. It will
     * return the results of the successful run on completion, and call the failure modes if not successful.
     * <p>
     * This WILL override the existing success callback!
     */
    public R sync() {

        onSuccess(this);

        while (this.active())
            update();

        return result;
    }

    /**
     * Handles the actual processing of the FutureTask and dispatching the results back to the callbacks.
     */
    private void updateTask(FutureTask<PlayFabResult<R>> x) {

        if (x != null && x.isDone()) {
            try {

                PlayFabResult<R> result = x.get();

                if (result != null && result.Result != null) {
                    if (successCallback != null) {
                        successCallback.success(result.Result);
                        frequency = 50.0f;
                    }
                }

                if (result == null)
                    if (failureCallback != null)
                        lowLevelFailureCallback.failure(new NullPointerException());

                if (result != null && result.Error != null)
                    if (failureCallback != null)
                        failureCallback.failure(result.Error);

            } catch (InterruptedException e) {
                if (failureCallback != null)
                    if (lowLevelFailureCallback.failure(e))
                        rerun();
            } catch (ExecutionException e) {
                if (failureCallback != null)
                    if (lowLevelFailureCallback.failure(e))
                        rerun();
            }

            task = null;
        }
    }

    private void rerun() {
        if (frequency < 2000)
            frequency = frequency + 100.0f;
        task.run();
    }

    @Override
    public void success(R result) {
        this.result = result;

    }
}
