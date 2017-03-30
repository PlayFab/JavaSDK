package com.playfab;

/**
 * This is used to register a callback for a lower-level failure than a PlayFab server error.  The main issues that
 * may arise include a NullPointerException, an InterruptedException, or an ExecutionException.  The NPE and
 * ExecutionExceptions probably indicate a threading problem.  InterruptedException is likely a networking problem.
 * <p>
 * All of these failures will cause the current task to stop.
 */
public interface PlayFabLowLevelFailure {

    /**
     * You might get a variety of networking exceptions as well as a NullPointer if the task fails.
     * <p>
     * If the failure method returns true (and you are using update, not sync), the system will try again with a longer
     * frequency.
     */
    boolean failure(Exception e);
}
