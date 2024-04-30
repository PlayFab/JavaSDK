package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabMultiplayerModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /**
     * API methods for managing multiplayer servers. API methods for managing parties. The lobby service helps players group
     * together to play multiplayer games. It is often used as a rendezvous point for players to share connection information.
     * The TrueSkill service helps titles to estimate a player's skill based on their match results. The player skill values
     * from this service are commonly used by a matchmaking service to provide players with balanced matches.
     */
public class PlayFabMultiplayerAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Cancel all active tickets the player is a member of in a given queue.
     * @param request CancelAllMatchmakingTicketsForPlayerRequest
     * @return Async Task will return CancelAllMatchmakingTicketsForPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult>> CancelAllMatchmakingTicketsForPlayerAsync(final CancelAllMatchmakingTicketsForPlayerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult>>() {
            public PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult> call() throws Exception {
                return privateCancelAllMatchmakingTicketsForPlayerAsync(request);
            }
        });
    }

    /**
     * Cancel all active tickets the player is a member of in a given queue.
     * @param request CancelAllMatchmakingTicketsForPlayerRequest
     * @return CancelAllMatchmakingTicketsForPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult> CancelAllMatchmakingTicketsForPlayer(final CancelAllMatchmakingTicketsForPlayerRequest request) {
        FutureTask<PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult>> task = new FutureTask(new Callable<PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult>>() {
            public PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult> call() throws Exception {
                return privateCancelAllMatchmakingTicketsForPlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult> exceptionResult = new PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Cancel all active tickets the player is a member of in a given queue. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult> privateCancelAllMatchmakingTicketsForPlayerAsync(final CancelAllMatchmakingTicketsForPlayerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/CancelAllMatchmakingTicketsForPlayer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CancelAllMatchmakingTicketsForPlayerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CancelAllMatchmakingTicketsForPlayerResult>>(){}.getType());
        CancelAllMatchmakingTicketsForPlayerResult result = resultData.data;

        PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult> pfResult = new PlayFabResult<CancelAllMatchmakingTicketsForPlayerResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Cancel all active backfill tickets the player is a member of in a given queue.
     * @param request CancelAllServerBackfillTicketsForPlayerRequest
     * @return Async Task will return CancelAllServerBackfillTicketsForPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult>> CancelAllServerBackfillTicketsForPlayerAsync(final CancelAllServerBackfillTicketsForPlayerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult>>() {
            public PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult> call() throws Exception {
                return privateCancelAllServerBackfillTicketsForPlayerAsync(request);
            }
        });
    }

    /**
     * Cancel all active backfill tickets the player is a member of in a given queue.
     * @param request CancelAllServerBackfillTicketsForPlayerRequest
     * @return CancelAllServerBackfillTicketsForPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult> CancelAllServerBackfillTicketsForPlayer(final CancelAllServerBackfillTicketsForPlayerRequest request) {
        FutureTask<PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult>> task = new FutureTask(new Callable<PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult>>() {
            public PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult> call() throws Exception {
                return privateCancelAllServerBackfillTicketsForPlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult> exceptionResult = new PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Cancel all active backfill tickets the player is a member of in a given queue. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult> privateCancelAllServerBackfillTicketsForPlayerAsync(final CancelAllServerBackfillTicketsForPlayerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/CancelAllServerBackfillTicketsForPlayer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CancelAllServerBackfillTicketsForPlayerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CancelAllServerBackfillTicketsForPlayerResult>>(){}.getType());
        CancelAllServerBackfillTicketsForPlayerResult result = resultData.data;

        PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult> pfResult = new PlayFabResult<CancelAllServerBackfillTicketsForPlayerResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Cancel a matchmaking ticket.
     * @param request CancelMatchmakingTicketRequest
     * @return Async Task will return CancelMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CancelMatchmakingTicketResult>> CancelMatchmakingTicketAsync(final CancelMatchmakingTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CancelMatchmakingTicketResult>>() {
            public PlayFabResult<CancelMatchmakingTicketResult> call() throws Exception {
                return privateCancelMatchmakingTicketAsync(request);
            }
        });
    }

    /**
     * Cancel a matchmaking ticket.
     * @param request CancelMatchmakingTicketRequest
     * @return CancelMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CancelMatchmakingTicketResult> CancelMatchmakingTicket(final CancelMatchmakingTicketRequest request) {
        FutureTask<PlayFabResult<CancelMatchmakingTicketResult>> task = new FutureTask(new Callable<PlayFabResult<CancelMatchmakingTicketResult>>() {
            public PlayFabResult<CancelMatchmakingTicketResult> call() throws Exception {
                return privateCancelMatchmakingTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CancelMatchmakingTicketResult> exceptionResult = new PlayFabResult<CancelMatchmakingTicketResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Cancel a matchmaking ticket. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CancelMatchmakingTicketResult> privateCancelMatchmakingTicketAsync(final CancelMatchmakingTicketRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/CancelMatchmakingTicket"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CancelMatchmakingTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CancelMatchmakingTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CancelMatchmakingTicketResult>>(){}.getType());
        CancelMatchmakingTicketResult result = resultData.data;

        PlayFabResult<CancelMatchmakingTicketResult> pfResult = new PlayFabResult<CancelMatchmakingTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Cancel a server backfill ticket.
     * @param request CancelServerBackfillTicketRequest
     * @return Async Task will return CancelServerBackfillTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CancelServerBackfillTicketResult>> CancelServerBackfillTicketAsync(final CancelServerBackfillTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CancelServerBackfillTicketResult>>() {
            public PlayFabResult<CancelServerBackfillTicketResult> call() throws Exception {
                return privateCancelServerBackfillTicketAsync(request);
            }
        });
    }

    /**
     * Cancel a server backfill ticket.
     * @param request CancelServerBackfillTicketRequest
     * @return CancelServerBackfillTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CancelServerBackfillTicketResult> CancelServerBackfillTicket(final CancelServerBackfillTicketRequest request) {
        FutureTask<PlayFabResult<CancelServerBackfillTicketResult>> task = new FutureTask(new Callable<PlayFabResult<CancelServerBackfillTicketResult>>() {
            public PlayFabResult<CancelServerBackfillTicketResult> call() throws Exception {
                return privateCancelServerBackfillTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CancelServerBackfillTicketResult> exceptionResult = new PlayFabResult<CancelServerBackfillTicketResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Cancel a server backfill ticket. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CancelServerBackfillTicketResult> privateCancelServerBackfillTicketAsync(final CancelServerBackfillTicketRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/CancelServerBackfillTicket"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CancelServerBackfillTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CancelServerBackfillTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CancelServerBackfillTicketResult>>(){}.getType());
        CancelServerBackfillTicketResult result = resultData.data;

        PlayFabResult<CancelServerBackfillTicketResult> pfResult = new PlayFabResult<CancelServerBackfillTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a multiplayer server build alias.
     * @param request CreateBuildAliasRequest
     * @return Async Task will return BuildAliasDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BuildAliasDetailsResponse>> CreateBuildAliasAsync(final CreateBuildAliasRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BuildAliasDetailsResponse>>() {
            public PlayFabResult<BuildAliasDetailsResponse> call() throws Exception {
                return privateCreateBuildAliasAsync(request);
            }
        });
    }

    /**
     * Creates a multiplayer server build alias.
     * @param request CreateBuildAliasRequest
     * @return BuildAliasDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BuildAliasDetailsResponse> CreateBuildAlias(final CreateBuildAliasRequest request) {
        FutureTask<PlayFabResult<BuildAliasDetailsResponse>> task = new FutureTask(new Callable<PlayFabResult<BuildAliasDetailsResponse>>() {
            public PlayFabResult<BuildAliasDetailsResponse> call() throws Exception {
                return privateCreateBuildAliasAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<BuildAliasDetailsResponse> exceptionResult = new PlayFabResult<BuildAliasDetailsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a multiplayer server build alias. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BuildAliasDetailsResponse> privateCreateBuildAliasAsync(final CreateBuildAliasRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/CreateBuildAlias"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BuildAliasDetailsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<BuildAliasDetailsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BuildAliasDetailsResponse>>(){}.getType());
        BuildAliasDetailsResponse result = resultData.data;

        PlayFabResult<BuildAliasDetailsResponse> pfResult = new PlayFabResult<BuildAliasDetailsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a multiplayer server build with a custom container.
     * @param request CreateBuildWithCustomContainerRequest
     * @return Async Task will return CreateBuildWithCustomContainerResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateBuildWithCustomContainerResponse>> CreateBuildWithCustomContainerAsync(final CreateBuildWithCustomContainerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateBuildWithCustomContainerResponse>>() {
            public PlayFabResult<CreateBuildWithCustomContainerResponse> call() throws Exception {
                return privateCreateBuildWithCustomContainerAsync(request);
            }
        });
    }

    /**
     * Creates a multiplayer server build with a custom container.
     * @param request CreateBuildWithCustomContainerRequest
     * @return CreateBuildWithCustomContainerResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateBuildWithCustomContainerResponse> CreateBuildWithCustomContainer(final CreateBuildWithCustomContainerRequest request) {
        FutureTask<PlayFabResult<CreateBuildWithCustomContainerResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateBuildWithCustomContainerResponse>>() {
            public PlayFabResult<CreateBuildWithCustomContainerResponse> call() throws Exception {
                return privateCreateBuildWithCustomContainerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateBuildWithCustomContainerResponse> exceptionResult = new PlayFabResult<CreateBuildWithCustomContainerResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a multiplayer server build with a custom container. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateBuildWithCustomContainerResponse> privateCreateBuildWithCustomContainerAsync(final CreateBuildWithCustomContainerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/CreateBuildWithCustomContainer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateBuildWithCustomContainerResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateBuildWithCustomContainerResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateBuildWithCustomContainerResponse>>(){}.getType());
        CreateBuildWithCustomContainerResponse result = resultData.data;

        PlayFabResult<CreateBuildWithCustomContainerResponse> pfResult = new PlayFabResult<CreateBuildWithCustomContainerResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a multiplayer server build with a managed container.
     * @param request CreateBuildWithManagedContainerRequest
     * @return Async Task will return CreateBuildWithManagedContainerResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateBuildWithManagedContainerResponse>> CreateBuildWithManagedContainerAsync(final CreateBuildWithManagedContainerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateBuildWithManagedContainerResponse>>() {
            public PlayFabResult<CreateBuildWithManagedContainerResponse> call() throws Exception {
                return privateCreateBuildWithManagedContainerAsync(request);
            }
        });
    }

    /**
     * Creates a multiplayer server build with a managed container.
     * @param request CreateBuildWithManagedContainerRequest
     * @return CreateBuildWithManagedContainerResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateBuildWithManagedContainerResponse> CreateBuildWithManagedContainer(final CreateBuildWithManagedContainerRequest request) {
        FutureTask<PlayFabResult<CreateBuildWithManagedContainerResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateBuildWithManagedContainerResponse>>() {
            public PlayFabResult<CreateBuildWithManagedContainerResponse> call() throws Exception {
                return privateCreateBuildWithManagedContainerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateBuildWithManagedContainerResponse> exceptionResult = new PlayFabResult<CreateBuildWithManagedContainerResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a multiplayer server build with a managed container. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateBuildWithManagedContainerResponse> privateCreateBuildWithManagedContainerAsync(final CreateBuildWithManagedContainerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/CreateBuildWithManagedContainer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateBuildWithManagedContainerResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateBuildWithManagedContainerResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateBuildWithManagedContainerResponse>>(){}.getType());
        CreateBuildWithManagedContainerResponse result = resultData.data;

        PlayFabResult<CreateBuildWithManagedContainerResponse> pfResult = new PlayFabResult<CreateBuildWithManagedContainerResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a multiplayer server build with the server running as a process.
     * @param request CreateBuildWithProcessBasedServerRequest
     * @return Async Task will return CreateBuildWithProcessBasedServerResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateBuildWithProcessBasedServerResponse>> CreateBuildWithProcessBasedServerAsync(final CreateBuildWithProcessBasedServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateBuildWithProcessBasedServerResponse>>() {
            public PlayFabResult<CreateBuildWithProcessBasedServerResponse> call() throws Exception {
                return privateCreateBuildWithProcessBasedServerAsync(request);
            }
        });
    }

    /**
     * Creates a multiplayer server build with the server running as a process.
     * @param request CreateBuildWithProcessBasedServerRequest
     * @return CreateBuildWithProcessBasedServerResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateBuildWithProcessBasedServerResponse> CreateBuildWithProcessBasedServer(final CreateBuildWithProcessBasedServerRequest request) {
        FutureTask<PlayFabResult<CreateBuildWithProcessBasedServerResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateBuildWithProcessBasedServerResponse>>() {
            public PlayFabResult<CreateBuildWithProcessBasedServerResponse> call() throws Exception {
                return privateCreateBuildWithProcessBasedServerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateBuildWithProcessBasedServerResponse> exceptionResult = new PlayFabResult<CreateBuildWithProcessBasedServerResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a multiplayer server build with the server running as a process. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateBuildWithProcessBasedServerResponse> privateCreateBuildWithProcessBasedServerAsync(final CreateBuildWithProcessBasedServerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/CreateBuildWithProcessBasedServer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateBuildWithProcessBasedServerResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateBuildWithProcessBasedServerResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateBuildWithProcessBasedServerResponse>>(){}.getType());
        CreateBuildWithProcessBasedServerResponse result = resultData.data;

        PlayFabResult<CreateBuildWithProcessBasedServerResponse> pfResult = new PlayFabResult<CreateBuildWithProcessBasedServerResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Create a lobby.
     * @param request CreateLobbyRequest
     * @return Async Task will return CreateLobbyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateLobbyResult>> CreateLobbyAsync(final CreateLobbyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateLobbyResult>>() {
            public PlayFabResult<CreateLobbyResult> call() throws Exception {
                return privateCreateLobbyAsync(request);
            }
        });
    }

    /**
     * Create a lobby.
     * @param request CreateLobbyRequest
     * @return CreateLobbyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateLobbyResult> CreateLobby(final CreateLobbyRequest request) {
        FutureTask<PlayFabResult<CreateLobbyResult>> task = new FutureTask(new Callable<PlayFabResult<CreateLobbyResult>>() {
            public PlayFabResult<CreateLobbyResult> call() throws Exception {
                return privateCreateLobbyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateLobbyResult> exceptionResult = new PlayFabResult<CreateLobbyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Create a lobby. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateLobbyResult> privateCreateLobbyAsync(final CreateLobbyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/CreateLobby"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateLobbyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateLobbyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateLobbyResult>>(){}.getType());
        CreateLobbyResult result = resultData.data;

        PlayFabResult<CreateLobbyResult> pfResult = new PlayFabResult<CreateLobbyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Create a matchmaking ticket as a client.
     * @param request CreateMatchmakingTicketRequest
     * @return Async Task will return CreateMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateMatchmakingTicketResult>> CreateMatchmakingTicketAsync(final CreateMatchmakingTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateMatchmakingTicketResult>>() {
            public PlayFabResult<CreateMatchmakingTicketResult> call() throws Exception {
                return privateCreateMatchmakingTicketAsync(request);
            }
        });
    }

    /**
     * Create a matchmaking ticket as a client.
     * @param request CreateMatchmakingTicketRequest
     * @return CreateMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateMatchmakingTicketResult> CreateMatchmakingTicket(final CreateMatchmakingTicketRequest request) {
        FutureTask<PlayFabResult<CreateMatchmakingTicketResult>> task = new FutureTask(new Callable<PlayFabResult<CreateMatchmakingTicketResult>>() {
            public PlayFabResult<CreateMatchmakingTicketResult> call() throws Exception {
                return privateCreateMatchmakingTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateMatchmakingTicketResult> exceptionResult = new PlayFabResult<CreateMatchmakingTicketResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Create a matchmaking ticket as a client. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateMatchmakingTicketResult> privateCreateMatchmakingTicketAsync(final CreateMatchmakingTicketRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/CreateMatchmakingTicket"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateMatchmakingTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateMatchmakingTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateMatchmakingTicketResult>>(){}.getType());
        CreateMatchmakingTicketResult result = resultData.data;

        PlayFabResult<CreateMatchmakingTicketResult> pfResult = new PlayFabResult<CreateMatchmakingTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a remote user to log on to a VM for a multiplayer server build.
     * @param request CreateRemoteUserRequest
     * @return Async Task will return CreateRemoteUserResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateRemoteUserResponse>> CreateRemoteUserAsync(final CreateRemoteUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateRemoteUserResponse>>() {
            public PlayFabResult<CreateRemoteUserResponse> call() throws Exception {
                return privateCreateRemoteUserAsync(request);
            }
        });
    }

    /**
     * Creates a remote user to log on to a VM for a multiplayer server build.
     * @param request CreateRemoteUserRequest
     * @return CreateRemoteUserResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateRemoteUserResponse> CreateRemoteUser(final CreateRemoteUserRequest request) {
        FutureTask<PlayFabResult<CreateRemoteUserResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateRemoteUserResponse>>() {
            public PlayFabResult<CreateRemoteUserResponse> call() throws Exception {
                return privateCreateRemoteUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateRemoteUserResponse> exceptionResult = new PlayFabResult<CreateRemoteUserResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a remote user to log on to a VM for a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateRemoteUserResponse> privateCreateRemoteUserAsync(final CreateRemoteUserRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/CreateRemoteUser"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateRemoteUserResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateRemoteUserResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateRemoteUserResponse>>(){}.getType());
        CreateRemoteUserResponse result = resultData.data;

        PlayFabResult<CreateRemoteUserResponse> pfResult = new PlayFabResult<CreateRemoteUserResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Create a backfill matchmaking ticket as a server. A backfill ticket represents an ongoing game. The matchmaking service
     * automatically starts matching the backfill ticket against other matchmaking tickets. Backfill tickets cannot match with
     * other backfill tickets.
     * @param request CreateServerBackfillTicketRequest
     * @return Async Task will return CreateServerBackfillTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateServerBackfillTicketResult>> CreateServerBackfillTicketAsync(final CreateServerBackfillTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateServerBackfillTicketResult>>() {
            public PlayFabResult<CreateServerBackfillTicketResult> call() throws Exception {
                return privateCreateServerBackfillTicketAsync(request);
            }
        });
    }

    /**
     * Create a backfill matchmaking ticket as a server. A backfill ticket represents an ongoing game. The matchmaking service
     * automatically starts matching the backfill ticket against other matchmaking tickets. Backfill tickets cannot match with
     * other backfill tickets.
     * @param request CreateServerBackfillTicketRequest
     * @return CreateServerBackfillTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateServerBackfillTicketResult> CreateServerBackfillTicket(final CreateServerBackfillTicketRequest request) {
        FutureTask<PlayFabResult<CreateServerBackfillTicketResult>> task = new FutureTask(new Callable<PlayFabResult<CreateServerBackfillTicketResult>>() {
            public PlayFabResult<CreateServerBackfillTicketResult> call() throws Exception {
                return privateCreateServerBackfillTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateServerBackfillTicketResult> exceptionResult = new PlayFabResult<CreateServerBackfillTicketResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Create a backfill matchmaking ticket as a server. A backfill ticket represents an ongoing game. The matchmaking service
     * automatically starts matching the backfill ticket against other matchmaking tickets. Backfill tickets cannot match with
     * other backfill tickets.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateServerBackfillTicketResult> privateCreateServerBackfillTicketAsync(final CreateServerBackfillTicketRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/CreateServerBackfillTicket"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateServerBackfillTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateServerBackfillTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateServerBackfillTicketResult>>(){}.getType());
        CreateServerBackfillTicketResult result = resultData.data;

        PlayFabResult<CreateServerBackfillTicketResult> pfResult = new PlayFabResult<CreateServerBackfillTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Create a matchmaking ticket as a server. The matchmaking service automatically starts matching the ticket against other
     * matchmaking tickets.
     * @param request CreateServerMatchmakingTicketRequest
     * @return Async Task will return CreateMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateMatchmakingTicketResult>> CreateServerMatchmakingTicketAsync(final CreateServerMatchmakingTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateMatchmakingTicketResult>>() {
            public PlayFabResult<CreateMatchmakingTicketResult> call() throws Exception {
                return privateCreateServerMatchmakingTicketAsync(request);
            }
        });
    }

    /**
     * Create a matchmaking ticket as a server. The matchmaking service automatically starts matching the ticket against other
     * matchmaking tickets.
     * @param request CreateServerMatchmakingTicketRequest
     * @return CreateMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateMatchmakingTicketResult> CreateServerMatchmakingTicket(final CreateServerMatchmakingTicketRequest request) {
        FutureTask<PlayFabResult<CreateMatchmakingTicketResult>> task = new FutureTask(new Callable<PlayFabResult<CreateMatchmakingTicketResult>>() {
            public PlayFabResult<CreateMatchmakingTicketResult> call() throws Exception {
                return privateCreateServerMatchmakingTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateMatchmakingTicketResult> exceptionResult = new PlayFabResult<CreateMatchmakingTicketResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Create a matchmaking ticket as a server. The matchmaking service automatically starts matching the ticket against other
     * matchmaking tickets.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateMatchmakingTicketResult> privateCreateServerMatchmakingTicketAsync(final CreateServerMatchmakingTicketRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/CreateServerMatchmakingTicket"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateMatchmakingTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateMatchmakingTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateMatchmakingTicketResult>>(){}.getType());
        CreateMatchmakingTicketResult result = resultData.data;

        PlayFabResult<CreateMatchmakingTicketResult> pfResult = new PlayFabResult<CreateMatchmakingTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a request to change a title's multiplayer server quotas.
     * @param request CreateTitleMultiplayerServersQuotaChangeRequest
     * @return Async Task will return CreateTitleMultiplayerServersQuotaChangeResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse>> CreateTitleMultiplayerServersQuotaChangeAsync(final CreateTitleMultiplayerServersQuotaChangeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse>>() {
            public PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse> call() throws Exception {
                return privateCreateTitleMultiplayerServersQuotaChangeAsync(request);
            }
        });
    }

    /**
     * Creates a request to change a title's multiplayer server quotas.
     * @param request CreateTitleMultiplayerServersQuotaChangeRequest
     * @return CreateTitleMultiplayerServersQuotaChangeResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse> CreateTitleMultiplayerServersQuotaChange(final CreateTitleMultiplayerServersQuotaChangeRequest request) {
        FutureTask<PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse>>() {
            public PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse> call() throws Exception {
                return privateCreateTitleMultiplayerServersQuotaChangeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse> exceptionResult = new PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a request to change a title's multiplayer server quotas. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse> privateCreateTitleMultiplayerServersQuotaChangeAsync(final CreateTitleMultiplayerServersQuotaChangeRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/CreateTitleMultiplayerServersQuotaChange"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateTitleMultiplayerServersQuotaChangeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateTitleMultiplayerServersQuotaChangeResponse>>(){}.getType());
        CreateTitleMultiplayerServersQuotaChangeResponse result = resultData.data;

        PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse> pfResult = new PlayFabResult<CreateTitleMultiplayerServersQuotaChangeResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a multiplayer server game asset for a title.
     * @param request DeleteAssetRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteAssetAsync(final DeleteAssetRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteAssetAsync(request);
            }
        });
    }

    /**
     * Deletes a multiplayer server game asset for a title.
     * @param request DeleteAssetRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteAsset(final DeleteAssetRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteAssetAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a multiplayer server game asset for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteAssetAsync(final DeleteAssetRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteAsset"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a multiplayer server build.
     * @param request DeleteBuildRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteBuildAsync(final DeleteBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteBuildAsync(request);
            }
        });
    }

    /**
     * Deletes a multiplayer server build.
     * @param request DeleteBuildRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteBuild(final DeleteBuildRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteBuildAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteBuildAsync(final DeleteBuildRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteBuild"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a multiplayer server build alias.
     * @param request DeleteBuildAliasRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteBuildAliasAsync(final DeleteBuildAliasRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteBuildAliasAsync(request);
            }
        });
    }

    /**
     * Deletes a multiplayer server build alias.
     * @param request DeleteBuildAliasRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteBuildAlias(final DeleteBuildAliasRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteBuildAliasAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a multiplayer server build alias. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteBuildAliasAsync(final DeleteBuildAliasRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteBuildAlias"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes a multiplayer server build's region.
     * @param request DeleteBuildRegionRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteBuildRegionAsync(final DeleteBuildRegionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteBuildRegionAsync(request);
            }
        });
    }

    /**
     * Removes a multiplayer server build's region.
     * @param request DeleteBuildRegionRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteBuildRegion(final DeleteBuildRegionRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteBuildRegionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Removes a multiplayer server build's region. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteBuildRegionAsync(final DeleteBuildRegionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteBuildRegion"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a multiplayer server game certificate.
     * @param request DeleteCertificateRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteCertificateAsync(final DeleteCertificateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteCertificateAsync(request);
            }
        });
    }

    /**
     * Deletes a multiplayer server game certificate.
     * @param request DeleteCertificateRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteCertificate(final DeleteCertificateRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteCertificateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a multiplayer server game certificate. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteCertificateAsync(final DeleteCertificateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteCertificate"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a container image repository.
     * @param request DeleteContainerImageRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteContainerImageRepositoryAsync(final DeleteContainerImageRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteContainerImageRepositoryAsync(request);
            }
        });
    }

    /**
     * Deletes a container image repository.
     * @param request DeleteContainerImageRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteContainerImageRepository(final DeleteContainerImageRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteContainerImageRepositoryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a container image repository. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteContainerImageRepositoryAsync(final DeleteContainerImageRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteContainerImageRepository"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Delete a lobby.
     * @param request DeleteLobbyRequest
     * @return Async Task will return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LobbyEmptyResult>> DeleteLobbyAsync(final DeleteLobbyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateDeleteLobbyAsync(request);
            }
        });
    }

    /**
     * Delete a lobby.
     * @param request DeleteLobbyRequest
     * @return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LobbyEmptyResult> DeleteLobby(final DeleteLobbyRequest request) {
        FutureTask<PlayFabResult<LobbyEmptyResult>> task = new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateDeleteLobbyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LobbyEmptyResult> exceptionResult = new PlayFabResult<LobbyEmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Delete a lobby. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LobbyEmptyResult> privateDeleteLobbyAsync(final DeleteLobbyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/DeleteLobby"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LobbyEmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LobbyEmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LobbyEmptyResult>>(){}.getType());
        LobbyEmptyResult result = resultData.data;

        PlayFabResult<LobbyEmptyResult> pfResult = new PlayFabResult<LobbyEmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a remote user to log on to a VM for a multiplayer server build.
     * @param request DeleteRemoteUserRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteRemoteUserAsync(final DeleteRemoteUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteRemoteUserAsync(request);
            }
        });
    }

    /**
     * Deletes a remote user to log on to a VM for a multiplayer server build.
     * @param request DeleteRemoteUserRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteRemoteUser(final DeleteRemoteUserRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteRemoteUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a remote user to log on to a VM for a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteRemoteUserAsync(final DeleteRemoteUserRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteRemoteUser"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a multiplayer server game secret.
     * @param request DeleteSecretRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteSecretAsync(final DeleteSecretRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteSecretAsync(request);
            }
        });
    }

    /**
     * Deletes a multiplayer server game secret.
     * @param request DeleteSecretRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteSecret(final DeleteSecretRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteSecretAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes a multiplayer server game secret. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteSecretAsync(final DeleteSecretRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/DeleteSecret"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Enables the multiplayer server feature for a title.
     * @param request EnableMultiplayerServersForTitleRequest
     * @return Async Task will return EnableMultiplayerServersForTitleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EnableMultiplayerServersForTitleResponse>> EnableMultiplayerServersForTitleAsync(final EnableMultiplayerServersForTitleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EnableMultiplayerServersForTitleResponse>>() {
            public PlayFabResult<EnableMultiplayerServersForTitleResponse> call() throws Exception {
                return privateEnableMultiplayerServersForTitleAsync(request);
            }
        });
    }

    /**
     * Enables the multiplayer server feature for a title.
     * @param request EnableMultiplayerServersForTitleRequest
     * @return EnableMultiplayerServersForTitleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EnableMultiplayerServersForTitleResponse> EnableMultiplayerServersForTitle(final EnableMultiplayerServersForTitleRequest request) {
        FutureTask<PlayFabResult<EnableMultiplayerServersForTitleResponse>> task = new FutureTask(new Callable<PlayFabResult<EnableMultiplayerServersForTitleResponse>>() {
            public PlayFabResult<EnableMultiplayerServersForTitleResponse> call() throws Exception {
                return privateEnableMultiplayerServersForTitleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EnableMultiplayerServersForTitleResponse> exceptionResult = new PlayFabResult<EnableMultiplayerServersForTitleResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Enables the multiplayer server feature for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EnableMultiplayerServersForTitleResponse> privateEnableMultiplayerServersForTitleAsync(final EnableMultiplayerServersForTitleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/EnableMultiplayerServersForTitle"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EnableMultiplayerServersForTitleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EnableMultiplayerServersForTitleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EnableMultiplayerServersForTitleResponse>>(){}.getType());
        EnableMultiplayerServersForTitleResponse result = resultData.data;

        PlayFabResult<EnableMultiplayerServersForTitleResponse> pfResult = new PlayFabResult<EnableMultiplayerServersForTitleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Find lobbies which match certain criteria, and which friends are in.
     * @param request FindFriendLobbiesRequest
     * @return Async Task will return FindFriendLobbiesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<FindFriendLobbiesResult>> FindFriendLobbiesAsync(final FindFriendLobbiesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<FindFriendLobbiesResult>>() {
            public PlayFabResult<FindFriendLobbiesResult> call() throws Exception {
                return privateFindFriendLobbiesAsync(request);
            }
        });
    }

    /**
     * Find lobbies which match certain criteria, and which friends are in.
     * @param request FindFriendLobbiesRequest
     * @return FindFriendLobbiesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<FindFriendLobbiesResult> FindFriendLobbies(final FindFriendLobbiesRequest request) {
        FutureTask<PlayFabResult<FindFriendLobbiesResult>> task = new FutureTask(new Callable<PlayFabResult<FindFriendLobbiesResult>>() {
            public PlayFabResult<FindFriendLobbiesResult> call() throws Exception {
                return privateFindFriendLobbiesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<FindFriendLobbiesResult> exceptionResult = new PlayFabResult<FindFriendLobbiesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Find lobbies which match certain criteria, and which friends are in. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<FindFriendLobbiesResult> privateFindFriendLobbiesAsync(final FindFriendLobbiesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/FindFriendLobbies"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<FindFriendLobbiesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<FindFriendLobbiesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<FindFriendLobbiesResult>>(){}.getType());
        FindFriendLobbiesResult result = resultData.data;

        PlayFabResult<FindFriendLobbiesResult> pfResult = new PlayFabResult<FindFriendLobbiesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Find all the lobbies that match certain criteria.
     * @param request FindLobbiesRequest
     * @return Async Task will return FindLobbiesResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<FindLobbiesResult>> FindLobbiesAsync(final FindLobbiesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<FindLobbiesResult>>() {
            public PlayFabResult<FindLobbiesResult> call() throws Exception {
                return privateFindLobbiesAsync(request);
            }
        });
    }

    /**
     * Find all the lobbies that match certain criteria.
     * @param request FindLobbiesRequest
     * @return FindLobbiesResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<FindLobbiesResult> FindLobbies(final FindLobbiesRequest request) {
        FutureTask<PlayFabResult<FindLobbiesResult>> task = new FutureTask(new Callable<PlayFabResult<FindLobbiesResult>>() {
            public PlayFabResult<FindLobbiesResult> call() throws Exception {
                return privateFindLobbiesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<FindLobbiesResult> exceptionResult = new PlayFabResult<FindLobbiesResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Find all the lobbies that match certain criteria. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<FindLobbiesResult> privateFindLobbiesAsync(final FindLobbiesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/FindLobbies"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<FindLobbiesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<FindLobbiesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<FindLobbiesResult>>(){}.getType());
        FindLobbiesResult result = resultData.data;

        PlayFabResult<FindLobbiesResult> pfResult = new PlayFabResult<FindLobbiesResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a URL that can be used to download the specified asset. A sample pre-authenticated url -
     * https://sampleStorageAccount.blob.core.windows.net/gameassets/gameserver.zip?sv=2015-04-05&amp;ss=b&amp;srt=sco&amp;sp=rw&amp;st=startDate&amp;se=endDate&amp;spr=https&amp;sig=sampleSig&amp;api-version=2017-07-29
     * @param request GetAssetDownloadUrlRequest
     * @return Async Task will return GetAssetDownloadUrlResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAssetDownloadUrlResponse>> GetAssetDownloadUrlAsync(final GetAssetDownloadUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAssetDownloadUrlResponse>>() {
            public PlayFabResult<GetAssetDownloadUrlResponse> call() throws Exception {
                return privateGetAssetDownloadUrlAsync(request);
            }
        });
    }

    /**
     * Gets a URL that can be used to download the specified asset. A sample pre-authenticated url -
     * https://sampleStorageAccount.blob.core.windows.net/gameassets/gameserver.zip?sv=2015-04-05&amp;ss=b&amp;srt=sco&amp;sp=rw&amp;st=startDate&amp;se=endDate&amp;spr=https&amp;sig=sampleSig&amp;api-version=2017-07-29
     * @param request GetAssetDownloadUrlRequest
     * @return GetAssetDownloadUrlResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAssetDownloadUrlResponse> GetAssetDownloadUrl(final GetAssetDownloadUrlRequest request) {
        FutureTask<PlayFabResult<GetAssetDownloadUrlResponse>> task = new FutureTask(new Callable<PlayFabResult<GetAssetDownloadUrlResponse>>() {
            public PlayFabResult<GetAssetDownloadUrlResponse> call() throws Exception {
                return privateGetAssetDownloadUrlAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetAssetDownloadUrlResponse> exceptionResult = new PlayFabResult<GetAssetDownloadUrlResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Gets a URL that can be used to download the specified asset. A sample pre-authenticated url -
     * https://sampleStorageAccount.blob.core.windows.net/gameassets/gameserver.zip?sv=2015-04-05&amp;ss=b&amp;srt=sco&amp;sp=rw&amp;st=startDate&amp;se=endDate&amp;spr=https&amp;sig=sampleSig&amp;api-version=2017-07-29
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAssetDownloadUrlResponse> privateGetAssetDownloadUrlAsync(final GetAssetDownloadUrlRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetAssetDownloadUrl"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAssetDownloadUrlResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAssetDownloadUrlResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAssetDownloadUrlResponse>>(){}.getType());
        GetAssetDownloadUrlResponse result = resultData.data;

        PlayFabResult<GetAssetDownloadUrlResponse> pfResult = new PlayFabResult<GetAssetDownloadUrlResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the URL to upload assets to. A sample pre-authenticated url -
     * https://sampleStorageAccount.blob.core.windows.net/gameassets/gameserver.zip?sv=2015-04-05&amp;ss=b&amp;srt=sco&amp;sp=rw&amp;st=startDate&amp;se=endDate&amp;spr=https&amp;sig=sampleSig&amp;api-version=2017-07-29
     * @param request GetAssetUploadUrlRequest
     * @return Async Task will return GetAssetUploadUrlResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetAssetUploadUrlResponse>> GetAssetUploadUrlAsync(final GetAssetUploadUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAssetUploadUrlResponse>>() {
            public PlayFabResult<GetAssetUploadUrlResponse> call() throws Exception {
                return privateGetAssetUploadUrlAsync(request);
            }
        });
    }

    /**
     * Gets the URL to upload assets to. A sample pre-authenticated url -
     * https://sampleStorageAccount.blob.core.windows.net/gameassets/gameserver.zip?sv=2015-04-05&amp;ss=b&amp;srt=sco&amp;sp=rw&amp;st=startDate&amp;se=endDate&amp;spr=https&amp;sig=sampleSig&amp;api-version=2017-07-29
     * @param request GetAssetUploadUrlRequest
     * @return GetAssetUploadUrlResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetAssetUploadUrlResponse> GetAssetUploadUrl(final GetAssetUploadUrlRequest request) {
        FutureTask<PlayFabResult<GetAssetUploadUrlResponse>> task = new FutureTask(new Callable<PlayFabResult<GetAssetUploadUrlResponse>>() {
            public PlayFabResult<GetAssetUploadUrlResponse> call() throws Exception {
                return privateGetAssetUploadUrlAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetAssetUploadUrlResponse> exceptionResult = new PlayFabResult<GetAssetUploadUrlResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Gets the URL to upload assets to. A sample pre-authenticated url -
     * https://sampleStorageAccount.blob.core.windows.net/gameassets/gameserver.zip?sv=2015-04-05&amp;ss=b&amp;srt=sco&amp;sp=rw&amp;st=startDate&amp;se=endDate&amp;spr=https&amp;sig=sampleSig&amp;api-version=2017-07-29
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetAssetUploadUrlResponse> privateGetAssetUploadUrlAsync(final GetAssetUploadUrlRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetAssetUploadUrl"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAssetUploadUrlResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetAssetUploadUrlResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAssetUploadUrlResponse>>(){}.getType());
        GetAssetUploadUrlResponse result = resultData.data;

        PlayFabResult<GetAssetUploadUrlResponse> pfResult = new PlayFabResult<GetAssetUploadUrlResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a multiplayer server build.
     * @param request GetBuildRequest
     * @return Async Task will return GetBuildResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetBuildResponse>> GetBuildAsync(final GetBuildRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetBuildResponse>>() {
            public PlayFabResult<GetBuildResponse> call() throws Exception {
                return privateGetBuildAsync(request);
            }
        });
    }

    /**
     * Gets a multiplayer server build.
     * @param request GetBuildRequest
     * @return GetBuildResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetBuildResponse> GetBuild(final GetBuildRequest request) {
        FutureTask<PlayFabResult<GetBuildResponse>> task = new FutureTask(new Callable<PlayFabResult<GetBuildResponse>>() {
            public PlayFabResult<GetBuildResponse> call() throws Exception {
                return privateGetBuildAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetBuildResponse> exceptionResult = new PlayFabResult<GetBuildResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetBuildResponse> privateGetBuildAsync(final GetBuildRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetBuild"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetBuildResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetBuildResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetBuildResponse>>(){}.getType());
        GetBuildResponse result = resultData.data;

        PlayFabResult<GetBuildResponse> pfResult = new PlayFabResult<GetBuildResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a multiplayer server build alias.
     * @param request GetBuildAliasRequest
     * @return Async Task will return BuildAliasDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BuildAliasDetailsResponse>> GetBuildAliasAsync(final GetBuildAliasRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BuildAliasDetailsResponse>>() {
            public PlayFabResult<BuildAliasDetailsResponse> call() throws Exception {
                return privateGetBuildAliasAsync(request);
            }
        });
    }

    /**
     * Gets a multiplayer server build alias.
     * @param request GetBuildAliasRequest
     * @return BuildAliasDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BuildAliasDetailsResponse> GetBuildAlias(final GetBuildAliasRequest request) {
        FutureTask<PlayFabResult<BuildAliasDetailsResponse>> task = new FutureTask(new Callable<PlayFabResult<BuildAliasDetailsResponse>>() {
            public PlayFabResult<BuildAliasDetailsResponse> call() throws Exception {
                return privateGetBuildAliasAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<BuildAliasDetailsResponse> exceptionResult = new PlayFabResult<BuildAliasDetailsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets a multiplayer server build alias. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BuildAliasDetailsResponse> privateGetBuildAliasAsync(final GetBuildAliasRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetBuildAlias"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BuildAliasDetailsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<BuildAliasDetailsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BuildAliasDetailsResponse>>(){}.getType());
        BuildAliasDetailsResponse result = resultData.data;

        PlayFabResult<BuildAliasDetailsResponse> pfResult = new PlayFabResult<BuildAliasDetailsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the credentials to the container registry.
     * @param request GetContainerRegistryCredentialsRequest
     * @return Async Task will return GetContainerRegistryCredentialsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetContainerRegistryCredentialsResponse>> GetContainerRegistryCredentialsAsync(final GetContainerRegistryCredentialsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContainerRegistryCredentialsResponse>>() {
            public PlayFabResult<GetContainerRegistryCredentialsResponse> call() throws Exception {
                return privateGetContainerRegistryCredentialsAsync(request);
            }
        });
    }

    /**
     * Gets the credentials to the container registry.
     * @param request GetContainerRegistryCredentialsRequest
     * @return GetContainerRegistryCredentialsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetContainerRegistryCredentialsResponse> GetContainerRegistryCredentials(final GetContainerRegistryCredentialsRequest request) {
        FutureTask<PlayFabResult<GetContainerRegistryCredentialsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetContainerRegistryCredentialsResponse>>() {
            public PlayFabResult<GetContainerRegistryCredentialsResponse> call() throws Exception {
                return privateGetContainerRegistryCredentialsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetContainerRegistryCredentialsResponse> exceptionResult = new PlayFabResult<GetContainerRegistryCredentialsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the credentials to the container registry. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetContainerRegistryCredentialsResponse> privateGetContainerRegistryCredentialsAsync(final GetContainerRegistryCredentialsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetContainerRegistryCredentials"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetContainerRegistryCredentialsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetContainerRegistryCredentialsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetContainerRegistryCredentialsResponse>>(){}.getType());
        GetContainerRegistryCredentialsResponse result = resultData.data;

        PlayFabResult<GetContainerRegistryCredentialsResponse> pfResult = new PlayFabResult<GetContainerRegistryCredentialsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get a lobby.
     * @param request GetLobbyRequest
     * @return Async Task will return GetLobbyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetLobbyResult>> GetLobbyAsync(final GetLobbyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLobbyResult>>() {
            public PlayFabResult<GetLobbyResult> call() throws Exception {
                return privateGetLobbyAsync(request);
            }
        });
    }

    /**
     * Get a lobby.
     * @param request GetLobbyRequest
     * @return GetLobbyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetLobbyResult> GetLobby(final GetLobbyRequest request) {
        FutureTask<PlayFabResult<GetLobbyResult>> task = new FutureTask(new Callable<PlayFabResult<GetLobbyResult>>() {
            public PlayFabResult<GetLobbyResult> call() throws Exception {
                return privateGetLobbyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetLobbyResult> exceptionResult = new PlayFabResult<GetLobbyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get a lobby. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetLobbyResult> privateGetLobbyAsync(final GetLobbyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/GetLobby"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLobbyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetLobbyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLobbyResult>>(){}.getType());
        GetLobbyResult result = resultData.data;

        PlayFabResult<GetLobbyResult> pfResult = new PlayFabResult<GetLobbyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get a match.
     * @param request GetMatchRequest
     * @return Async Task will return GetMatchResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMatchResult>> GetMatchAsync(final GetMatchRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMatchResult>>() {
            public PlayFabResult<GetMatchResult> call() throws Exception {
                return privateGetMatchAsync(request);
            }
        });
    }

    /**
     * Get a match.
     * @param request GetMatchRequest
     * @return GetMatchResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMatchResult> GetMatch(final GetMatchRequest request) {
        FutureTask<PlayFabResult<GetMatchResult>> task = new FutureTask(new Callable<PlayFabResult<GetMatchResult>>() {
            public PlayFabResult<GetMatchResult> call() throws Exception {
                return privateGetMatchAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetMatchResult> exceptionResult = new PlayFabResult<GetMatchResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get a match. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMatchResult> privateGetMatchAsync(final GetMatchRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/GetMatch"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMatchResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetMatchResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMatchResult>>(){}.getType());
        GetMatchResult result = resultData.data;

        PlayFabResult<GetMatchResult> pfResult = new PlayFabResult<GetMatchResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get a matchmaking ticket by ticket Id.
     * @param request GetMatchmakingTicketRequest
     * @return Async Task will return GetMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMatchmakingTicketResult>> GetMatchmakingTicketAsync(final GetMatchmakingTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMatchmakingTicketResult>>() {
            public PlayFabResult<GetMatchmakingTicketResult> call() throws Exception {
                return privateGetMatchmakingTicketAsync(request);
            }
        });
    }

    /**
     * Get a matchmaking ticket by ticket Id.
     * @param request GetMatchmakingTicketRequest
     * @return GetMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMatchmakingTicketResult> GetMatchmakingTicket(final GetMatchmakingTicketRequest request) {
        FutureTask<PlayFabResult<GetMatchmakingTicketResult>> task = new FutureTask(new Callable<PlayFabResult<GetMatchmakingTicketResult>>() {
            public PlayFabResult<GetMatchmakingTicketResult> call() throws Exception {
                return privateGetMatchmakingTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetMatchmakingTicketResult> exceptionResult = new PlayFabResult<GetMatchmakingTicketResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get a matchmaking ticket by ticket Id. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMatchmakingTicketResult> privateGetMatchmakingTicketAsync(final GetMatchmakingTicketRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/GetMatchmakingTicket"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMatchmakingTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetMatchmakingTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMatchmakingTicketResult>>(){}.getType());
        GetMatchmakingTicketResult result = resultData.data;

        PlayFabResult<GetMatchmakingTicketResult> pfResult = new PlayFabResult<GetMatchmakingTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets multiplayer server session details for a build.
     * @param request GetMultiplayerServerDetailsRequest
     * @return Async Task will return GetMultiplayerServerDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMultiplayerServerDetailsResponse>> GetMultiplayerServerDetailsAsync(final GetMultiplayerServerDetailsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMultiplayerServerDetailsResponse>>() {
            public PlayFabResult<GetMultiplayerServerDetailsResponse> call() throws Exception {
                return privateGetMultiplayerServerDetailsAsync(request);
            }
        });
    }

    /**
     * Gets multiplayer server session details for a build.
     * @param request GetMultiplayerServerDetailsRequest
     * @return GetMultiplayerServerDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMultiplayerServerDetailsResponse> GetMultiplayerServerDetails(final GetMultiplayerServerDetailsRequest request) {
        FutureTask<PlayFabResult<GetMultiplayerServerDetailsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetMultiplayerServerDetailsResponse>>() {
            public PlayFabResult<GetMultiplayerServerDetailsResponse> call() throws Exception {
                return privateGetMultiplayerServerDetailsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetMultiplayerServerDetailsResponse> exceptionResult = new PlayFabResult<GetMultiplayerServerDetailsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets multiplayer server session details for a build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMultiplayerServerDetailsResponse> privateGetMultiplayerServerDetailsAsync(final GetMultiplayerServerDetailsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetMultiplayerServerDetails"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMultiplayerServerDetailsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetMultiplayerServerDetailsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMultiplayerServerDetailsResponse>>(){}.getType());
        GetMultiplayerServerDetailsResponse result = resultData.data;

        PlayFabResult<GetMultiplayerServerDetailsResponse> pfResult = new PlayFabResult<GetMultiplayerServerDetailsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets multiplayer server logs after a server has terminated.
     * @param request GetMultiplayerServerLogsRequest
     * @return Async Task will return GetMultiplayerServerLogsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMultiplayerServerLogsResponse>> GetMultiplayerServerLogsAsync(final GetMultiplayerServerLogsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMultiplayerServerLogsResponse>>() {
            public PlayFabResult<GetMultiplayerServerLogsResponse> call() throws Exception {
                return privateGetMultiplayerServerLogsAsync(request);
            }
        });
    }

    /**
     * Gets multiplayer server logs after a server has terminated.
     * @param request GetMultiplayerServerLogsRequest
     * @return GetMultiplayerServerLogsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMultiplayerServerLogsResponse> GetMultiplayerServerLogs(final GetMultiplayerServerLogsRequest request) {
        FutureTask<PlayFabResult<GetMultiplayerServerLogsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetMultiplayerServerLogsResponse>>() {
            public PlayFabResult<GetMultiplayerServerLogsResponse> call() throws Exception {
                return privateGetMultiplayerServerLogsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetMultiplayerServerLogsResponse> exceptionResult = new PlayFabResult<GetMultiplayerServerLogsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets multiplayer server logs after a server has terminated. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMultiplayerServerLogsResponse> privateGetMultiplayerServerLogsAsync(final GetMultiplayerServerLogsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetMultiplayerServerLogs"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMultiplayerServerLogsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetMultiplayerServerLogsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMultiplayerServerLogsResponse>>(){}.getType());
        GetMultiplayerServerLogsResponse result = resultData.data;

        PlayFabResult<GetMultiplayerServerLogsResponse> pfResult = new PlayFabResult<GetMultiplayerServerLogsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets multiplayer server logs after a server has terminated.
     * @param request GetMultiplayerSessionLogsBySessionIdRequest
     * @return Async Task will return GetMultiplayerServerLogsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMultiplayerServerLogsResponse>> GetMultiplayerSessionLogsBySessionIdAsync(final GetMultiplayerSessionLogsBySessionIdRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMultiplayerServerLogsResponse>>() {
            public PlayFabResult<GetMultiplayerServerLogsResponse> call() throws Exception {
                return privateGetMultiplayerSessionLogsBySessionIdAsync(request);
            }
        });
    }

    /**
     * Gets multiplayer server logs after a server has terminated.
     * @param request GetMultiplayerSessionLogsBySessionIdRequest
     * @return GetMultiplayerServerLogsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMultiplayerServerLogsResponse> GetMultiplayerSessionLogsBySessionId(final GetMultiplayerSessionLogsBySessionIdRequest request) {
        FutureTask<PlayFabResult<GetMultiplayerServerLogsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetMultiplayerServerLogsResponse>>() {
            public PlayFabResult<GetMultiplayerServerLogsResponse> call() throws Exception {
                return privateGetMultiplayerSessionLogsBySessionIdAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetMultiplayerServerLogsResponse> exceptionResult = new PlayFabResult<GetMultiplayerServerLogsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets multiplayer server logs after a server has terminated. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMultiplayerServerLogsResponse> privateGetMultiplayerSessionLogsBySessionIdAsync(final GetMultiplayerSessionLogsBySessionIdRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetMultiplayerSessionLogsBySessionId"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMultiplayerServerLogsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetMultiplayerServerLogsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMultiplayerServerLogsResponse>>(){}.getType());
        GetMultiplayerServerLogsResponse result = resultData.data;

        PlayFabResult<GetMultiplayerServerLogsResponse> pfResult = new PlayFabResult<GetMultiplayerServerLogsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get the statistics for a queue.
     * @param request GetQueueStatisticsRequest
     * @return Async Task will return GetQueueStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetQueueStatisticsResult>> GetQueueStatisticsAsync(final GetQueueStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetQueueStatisticsResult>>() {
            public PlayFabResult<GetQueueStatisticsResult> call() throws Exception {
                return privateGetQueueStatisticsAsync(request);
            }
        });
    }

    /**
     * Get the statistics for a queue.
     * @param request GetQueueStatisticsRequest
     * @return GetQueueStatisticsResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetQueueStatisticsResult> GetQueueStatistics(final GetQueueStatisticsRequest request) {
        FutureTask<PlayFabResult<GetQueueStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<GetQueueStatisticsResult>>() {
            public PlayFabResult<GetQueueStatisticsResult> call() throws Exception {
                return privateGetQueueStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetQueueStatisticsResult> exceptionResult = new PlayFabResult<GetQueueStatisticsResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get the statistics for a queue. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetQueueStatisticsResult> privateGetQueueStatisticsAsync(final GetQueueStatisticsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/GetQueueStatistics"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetQueueStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetQueueStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetQueueStatisticsResult>>(){}.getType());
        GetQueueStatisticsResult result = resultData.data;

        PlayFabResult<GetQueueStatisticsResult> pfResult = new PlayFabResult<GetQueueStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a remote login endpoint to a VM that is hosting a multiplayer server build.
     * @param request GetRemoteLoginEndpointRequest
     * @return Async Task will return GetRemoteLoginEndpointResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetRemoteLoginEndpointResponse>> GetRemoteLoginEndpointAsync(final GetRemoteLoginEndpointRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetRemoteLoginEndpointResponse>>() {
            public PlayFabResult<GetRemoteLoginEndpointResponse> call() throws Exception {
                return privateGetRemoteLoginEndpointAsync(request);
            }
        });
    }

    /**
     * Gets a remote login endpoint to a VM that is hosting a multiplayer server build.
     * @param request GetRemoteLoginEndpointRequest
     * @return GetRemoteLoginEndpointResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetRemoteLoginEndpointResponse> GetRemoteLoginEndpoint(final GetRemoteLoginEndpointRequest request) {
        FutureTask<PlayFabResult<GetRemoteLoginEndpointResponse>> task = new FutureTask(new Callable<PlayFabResult<GetRemoteLoginEndpointResponse>>() {
            public PlayFabResult<GetRemoteLoginEndpointResponse> call() throws Exception {
                return privateGetRemoteLoginEndpointAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetRemoteLoginEndpointResponse> exceptionResult = new PlayFabResult<GetRemoteLoginEndpointResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets a remote login endpoint to a VM that is hosting a multiplayer server build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetRemoteLoginEndpointResponse> privateGetRemoteLoginEndpointAsync(final GetRemoteLoginEndpointRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetRemoteLoginEndpoint"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetRemoteLoginEndpointResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetRemoteLoginEndpointResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetRemoteLoginEndpointResponse>>(){}.getType());
        GetRemoteLoginEndpointResponse result = resultData.data;

        PlayFabResult<GetRemoteLoginEndpointResponse> pfResult = new PlayFabResult<GetRemoteLoginEndpointResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get a matchmaking backfill ticket by ticket Id.
     * @param request GetServerBackfillTicketRequest
     * @return Async Task will return GetServerBackfillTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetServerBackfillTicketResult>> GetServerBackfillTicketAsync(final GetServerBackfillTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetServerBackfillTicketResult>>() {
            public PlayFabResult<GetServerBackfillTicketResult> call() throws Exception {
                return privateGetServerBackfillTicketAsync(request);
            }
        });
    }

    /**
     * Get a matchmaking backfill ticket by ticket Id.
     * @param request GetServerBackfillTicketRequest
     * @return GetServerBackfillTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetServerBackfillTicketResult> GetServerBackfillTicket(final GetServerBackfillTicketRequest request) {
        FutureTask<PlayFabResult<GetServerBackfillTicketResult>> task = new FutureTask(new Callable<PlayFabResult<GetServerBackfillTicketResult>>() {
            public PlayFabResult<GetServerBackfillTicketResult> call() throws Exception {
                return privateGetServerBackfillTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetServerBackfillTicketResult> exceptionResult = new PlayFabResult<GetServerBackfillTicketResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get a matchmaking backfill ticket by ticket Id. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetServerBackfillTicketResult> privateGetServerBackfillTicketAsync(final GetServerBackfillTicketRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/GetServerBackfillTicket"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetServerBackfillTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetServerBackfillTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetServerBackfillTicketResult>>(){}.getType());
        GetServerBackfillTicketResult result = resultData.data;

        PlayFabResult<GetServerBackfillTicketResult> pfResult = new PlayFabResult<GetServerBackfillTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the status of whether a title is enabled for the multiplayer server feature.
     * @param request GetTitleEnabledForMultiplayerServersStatusRequest
     * @return Async Task will return GetTitleEnabledForMultiplayerServersStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>> GetTitleEnabledForMultiplayerServersStatusAsync(final GetTitleEnabledForMultiplayerServersStatusRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>>() {
            public PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> call() throws Exception {
                return privateGetTitleEnabledForMultiplayerServersStatusAsync(request);
            }
        });
    }

    /**
     * Gets the status of whether a title is enabled for the multiplayer server feature.
     * @param request GetTitleEnabledForMultiplayerServersStatusRequest
     * @return GetTitleEnabledForMultiplayerServersStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> GetTitleEnabledForMultiplayerServersStatus(final GetTitleEnabledForMultiplayerServersStatusRequest request) {
        FutureTask<PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>> task = new FutureTask(new Callable<PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>>() {
            public PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> call() throws Exception {
                return privateGetTitleEnabledForMultiplayerServersStatusAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> exceptionResult = new PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the status of whether a title is enabled for the multiplayer server feature. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> privateGetTitleEnabledForMultiplayerServersStatusAsync(final GetTitleEnabledForMultiplayerServersStatusRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetTitleEnabledForMultiplayerServersStatus"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTitleEnabledForMultiplayerServersStatusResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleEnabledForMultiplayerServersStatusResponse>>(){}.getType());
        GetTitleEnabledForMultiplayerServersStatusResponse result = resultData.data;

        PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse> pfResult = new PlayFabResult<GetTitleEnabledForMultiplayerServersStatusResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets a title's server quota change request.
     * @param request GetTitleMultiplayerServersQuotaChangeRequest
     * @return Async Task will return GetTitleMultiplayerServersQuotaChangeResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse>> GetTitleMultiplayerServersQuotaChangeAsync(final GetTitleMultiplayerServersQuotaChangeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse>>() {
            public PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse> call() throws Exception {
                return privateGetTitleMultiplayerServersQuotaChangeAsync(request);
            }
        });
    }

    /**
     * Gets a title's server quota change request.
     * @param request GetTitleMultiplayerServersQuotaChangeRequest
     * @return GetTitleMultiplayerServersQuotaChangeResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse> GetTitleMultiplayerServersQuotaChange(final GetTitleMultiplayerServersQuotaChangeRequest request) {
        FutureTask<PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse>> task = new FutureTask(new Callable<PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse>>() {
            public PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse> call() throws Exception {
                return privateGetTitleMultiplayerServersQuotaChangeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse> exceptionResult = new PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets a title's server quota change request. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse> privateGetTitleMultiplayerServersQuotaChangeAsync(final GetTitleMultiplayerServersQuotaChangeRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetTitleMultiplayerServersQuotaChange"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTitleMultiplayerServersQuotaChangeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleMultiplayerServersQuotaChangeResponse>>(){}.getType());
        GetTitleMultiplayerServersQuotaChangeResponse result = resultData.data;

        PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse> pfResult = new PlayFabResult<GetTitleMultiplayerServersQuotaChangeResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the quotas for a title in relation to multiplayer servers.
     * @param request GetTitleMultiplayerServersQuotasRequest
     * @return Async Task will return GetTitleMultiplayerServersQuotasResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTitleMultiplayerServersQuotasResponse>> GetTitleMultiplayerServersQuotasAsync(final GetTitleMultiplayerServersQuotasRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleMultiplayerServersQuotasResponse>>() {
            public PlayFabResult<GetTitleMultiplayerServersQuotasResponse> call() throws Exception {
                return privateGetTitleMultiplayerServersQuotasAsync(request);
            }
        });
    }

    /**
     * Gets the quotas for a title in relation to multiplayer servers.
     * @param request GetTitleMultiplayerServersQuotasRequest
     * @return GetTitleMultiplayerServersQuotasResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTitleMultiplayerServersQuotasResponse> GetTitleMultiplayerServersQuotas(final GetTitleMultiplayerServersQuotasRequest request) {
        FutureTask<PlayFabResult<GetTitleMultiplayerServersQuotasResponse>> task = new FutureTask(new Callable<PlayFabResult<GetTitleMultiplayerServersQuotasResponse>>() {
            public PlayFabResult<GetTitleMultiplayerServersQuotasResponse> call() throws Exception {
                return privateGetTitleMultiplayerServersQuotasAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTitleMultiplayerServersQuotasResponse> exceptionResult = new PlayFabResult<GetTitleMultiplayerServersQuotasResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the quotas for a title in relation to multiplayer servers. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTitleMultiplayerServersQuotasResponse> privateGetTitleMultiplayerServersQuotasAsync(final GetTitleMultiplayerServersQuotasRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/GetTitleMultiplayerServersQuotas"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleMultiplayerServersQuotasResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTitleMultiplayerServersQuotasResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleMultiplayerServersQuotasResponse>>(){}.getType());
        GetTitleMultiplayerServersQuotasResponse result = resultData.data;

        PlayFabResult<GetTitleMultiplayerServersQuotasResponse> pfResult = new PlayFabResult<GetTitleMultiplayerServersQuotasResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Send a notification to invite a player to a lobby.
     * @param request InviteToLobbyRequest
     * @return Async Task will return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LobbyEmptyResult>> InviteToLobbyAsync(final InviteToLobbyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateInviteToLobbyAsync(request);
            }
        });
    }

    /**
     * Send a notification to invite a player to a lobby.
     * @param request InviteToLobbyRequest
     * @return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LobbyEmptyResult> InviteToLobby(final InviteToLobbyRequest request) {
        FutureTask<PlayFabResult<LobbyEmptyResult>> task = new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateInviteToLobbyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LobbyEmptyResult> exceptionResult = new PlayFabResult<LobbyEmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Send a notification to invite a player to a lobby. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LobbyEmptyResult> privateInviteToLobbyAsync(final InviteToLobbyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/InviteToLobby"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LobbyEmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LobbyEmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LobbyEmptyResult>>(){}.getType());
        LobbyEmptyResult result = resultData.data;

        PlayFabResult<LobbyEmptyResult> pfResult = new PlayFabResult<LobbyEmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Join an Arranged lobby.
     * @param request JoinArrangedLobbyRequest
     * @return Async Task will return JoinLobbyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<JoinLobbyResult>> JoinArrangedLobbyAsync(final JoinArrangedLobbyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<JoinLobbyResult>>() {
            public PlayFabResult<JoinLobbyResult> call() throws Exception {
                return privateJoinArrangedLobbyAsync(request);
            }
        });
    }

    /**
     * Join an Arranged lobby.
     * @param request JoinArrangedLobbyRequest
     * @return JoinLobbyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<JoinLobbyResult> JoinArrangedLobby(final JoinArrangedLobbyRequest request) {
        FutureTask<PlayFabResult<JoinLobbyResult>> task = new FutureTask(new Callable<PlayFabResult<JoinLobbyResult>>() {
            public PlayFabResult<JoinLobbyResult> call() throws Exception {
                return privateJoinArrangedLobbyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<JoinLobbyResult> exceptionResult = new PlayFabResult<JoinLobbyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Join an Arranged lobby. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<JoinLobbyResult> privateJoinArrangedLobbyAsync(final JoinArrangedLobbyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/JoinArrangedLobby"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<JoinLobbyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<JoinLobbyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<JoinLobbyResult>>(){}.getType());
        JoinLobbyResult result = resultData.data;

        PlayFabResult<JoinLobbyResult> pfResult = new PlayFabResult<JoinLobbyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Join a lobby.
     * @param request JoinLobbyRequest
     * @return Async Task will return JoinLobbyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<JoinLobbyResult>> JoinLobbyAsync(final JoinLobbyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<JoinLobbyResult>>() {
            public PlayFabResult<JoinLobbyResult> call() throws Exception {
                return privateJoinLobbyAsync(request);
            }
        });
    }

    /**
     * Join a lobby.
     * @param request JoinLobbyRequest
     * @return JoinLobbyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<JoinLobbyResult> JoinLobby(final JoinLobbyRequest request) {
        FutureTask<PlayFabResult<JoinLobbyResult>> task = new FutureTask(new Callable<PlayFabResult<JoinLobbyResult>>() {
            public PlayFabResult<JoinLobbyResult> call() throws Exception {
                return privateJoinLobbyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<JoinLobbyResult> exceptionResult = new PlayFabResult<JoinLobbyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Join a lobby. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<JoinLobbyResult> privateJoinLobbyAsync(final JoinLobbyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/JoinLobby"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<JoinLobbyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<JoinLobbyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<JoinLobbyResult>>(){}.getType());
        JoinLobbyResult result = resultData.data;

        PlayFabResult<JoinLobbyResult> pfResult = new PlayFabResult<JoinLobbyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Preview: Join a lobby as a server entity. This is restricted to client lobbies which are using connections.
     * @param request JoinLobbyAsServerRequest
     * @return Async Task will return JoinLobbyAsServerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<JoinLobbyAsServerResult>> JoinLobbyAsServerAsync(final JoinLobbyAsServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<JoinLobbyAsServerResult>>() {
            public PlayFabResult<JoinLobbyAsServerResult> call() throws Exception {
                return privateJoinLobbyAsServerAsync(request);
            }
        });
    }

    /**
     * Preview: Join a lobby as a server entity. This is restricted to client lobbies which are using connections.
     * @param request JoinLobbyAsServerRequest
     * @return JoinLobbyAsServerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<JoinLobbyAsServerResult> JoinLobbyAsServer(final JoinLobbyAsServerRequest request) {
        FutureTask<PlayFabResult<JoinLobbyAsServerResult>> task = new FutureTask(new Callable<PlayFabResult<JoinLobbyAsServerResult>>() {
            public PlayFabResult<JoinLobbyAsServerResult> call() throws Exception {
                return privateJoinLobbyAsServerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<JoinLobbyAsServerResult> exceptionResult = new PlayFabResult<JoinLobbyAsServerResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Preview: Join a lobby as a server entity. This is restricted to client lobbies which are using connections. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<JoinLobbyAsServerResult> privateJoinLobbyAsServerAsync(final JoinLobbyAsServerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/JoinLobbyAsServer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<JoinLobbyAsServerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<JoinLobbyAsServerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<JoinLobbyAsServerResult>>(){}.getType());
        JoinLobbyAsServerResult result = resultData.data;

        PlayFabResult<JoinLobbyAsServerResult> pfResult = new PlayFabResult<JoinLobbyAsServerResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Join a matchmaking ticket.
     * @param request JoinMatchmakingTicketRequest
     * @return Async Task will return JoinMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<JoinMatchmakingTicketResult>> JoinMatchmakingTicketAsync(final JoinMatchmakingTicketRequest request) {
        return new FutureTask(new Callable<PlayFabResult<JoinMatchmakingTicketResult>>() {
            public PlayFabResult<JoinMatchmakingTicketResult> call() throws Exception {
                return privateJoinMatchmakingTicketAsync(request);
            }
        });
    }

    /**
     * Join a matchmaking ticket.
     * @param request JoinMatchmakingTicketRequest
     * @return JoinMatchmakingTicketResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<JoinMatchmakingTicketResult> JoinMatchmakingTicket(final JoinMatchmakingTicketRequest request) {
        FutureTask<PlayFabResult<JoinMatchmakingTicketResult>> task = new FutureTask(new Callable<PlayFabResult<JoinMatchmakingTicketResult>>() {
            public PlayFabResult<JoinMatchmakingTicketResult> call() throws Exception {
                return privateJoinMatchmakingTicketAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<JoinMatchmakingTicketResult> exceptionResult = new PlayFabResult<JoinMatchmakingTicketResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Join a matchmaking ticket. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<JoinMatchmakingTicketResult> privateJoinMatchmakingTicketAsync(final JoinMatchmakingTicketRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/JoinMatchmakingTicket"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<JoinMatchmakingTicketResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<JoinMatchmakingTicketResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<JoinMatchmakingTicketResult>>(){}.getType());
        JoinMatchmakingTicketResult result = resultData.data;

        PlayFabResult<JoinMatchmakingTicketResult> pfResult = new PlayFabResult<JoinMatchmakingTicketResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Leave a lobby.
     * @param request LeaveLobbyRequest
     * @return Async Task will return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LobbyEmptyResult>> LeaveLobbyAsync(final LeaveLobbyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateLeaveLobbyAsync(request);
            }
        });
    }

    /**
     * Leave a lobby.
     * @param request LeaveLobbyRequest
     * @return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LobbyEmptyResult> LeaveLobby(final LeaveLobbyRequest request) {
        FutureTask<PlayFabResult<LobbyEmptyResult>> task = new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateLeaveLobbyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LobbyEmptyResult> exceptionResult = new PlayFabResult<LobbyEmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Leave a lobby. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LobbyEmptyResult> privateLeaveLobbyAsync(final LeaveLobbyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/LeaveLobby"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LobbyEmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LobbyEmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LobbyEmptyResult>>(){}.getType());
        LobbyEmptyResult result = resultData.data;

        PlayFabResult<LobbyEmptyResult> pfResult = new PlayFabResult<LobbyEmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Preview: Request for server to leave a lobby. This is restricted to client owned lobbies which are using connections.
     * @param request LeaveLobbyAsServerRequest
     * @return Async Task will return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LobbyEmptyResult>> LeaveLobbyAsServerAsync(final LeaveLobbyAsServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateLeaveLobbyAsServerAsync(request);
            }
        });
    }

    /**
     * Preview: Request for server to leave a lobby. This is restricted to client owned lobbies which are using connections.
     * @param request LeaveLobbyAsServerRequest
     * @return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LobbyEmptyResult> LeaveLobbyAsServer(final LeaveLobbyAsServerRequest request) {
        FutureTask<PlayFabResult<LobbyEmptyResult>> task = new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateLeaveLobbyAsServerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LobbyEmptyResult> exceptionResult = new PlayFabResult<LobbyEmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Preview: Request for server to leave a lobby. This is restricted to client owned lobbies which are using connections. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LobbyEmptyResult> privateLeaveLobbyAsServerAsync(final LeaveLobbyAsServerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/LeaveLobbyAsServer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LobbyEmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LobbyEmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LobbyEmptyResult>>(){}.getType());
        LobbyEmptyResult result = resultData.data;

        PlayFabResult<LobbyEmptyResult> pfResult = new PlayFabResult<LobbyEmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists archived multiplayer server sessions for a build.
     * @param request ListMultiplayerServersRequest
     * @return Async Task will return ListMultiplayerServersResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListMultiplayerServersResponse>> ListArchivedMultiplayerServersAsync(final ListMultiplayerServersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListMultiplayerServersResponse>>() {
            public PlayFabResult<ListMultiplayerServersResponse> call() throws Exception {
                return privateListArchivedMultiplayerServersAsync(request);
            }
        });
    }

    /**
     * Lists archived multiplayer server sessions for a build.
     * @param request ListMultiplayerServersRequest
     * @return ListMultiplayerServersResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListMultiplayerServersResponse> ListArchivedMultiplayerServers(final ListMultiplayerServersRequest request) {
        FutureTask<PlayFabResult<ListMultiplayerServersResponse>> task = new FutureTask(new Callable<PlayFabResult<ListMultiplayerServersResponse>>() {
            public PlayFabResult<ListMultiplayerServersResponse> call() throws Exception {
                return privateListArchivedMultiplayerServersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListMultiplayerServersResponse> exceptionResult = new PlayFabResult<ListMultiplayerServersResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists archived multiplayer server sessions for a build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListMultiplayerServersResponse> privateListArchivedMultiplayerServersAsync(final ListMultiplayerServersRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListArchivedMultiplayerServers"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListMultiplayerServersResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListMultiplayerServersResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListMultiplayerServersResponse>>(){}.getType());
        ListMultiplayerServersResponse result = resultData.data;

        PlayFabResult<ListMultiplayerServersResponse> pfResult = new PlayFabResult<ListMultiplayerServersResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists multiplayer server game assets for a title.
     * @param request ListAssetSummariesRequest
     * @return Async Task will return ListAssetSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListAssetSummariesResponse>> ListAssetSummariesAsync(final ListAssetSummariesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListAssetSummariesResponse>>() {
            public PlayFabResult<ListAssetSummariesResponse> call() throws Exception {
                return privateListAssetSummariesAsync(request);
            }
        });
    }

    /**
     * Lists multiplayer server game assets for a title.
     * @param request ListAssetSummariesRequest
     * @return ListAssetSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListAssetSummariesResponse> ListAssetSummaries(final ListAssetSummariesRequest request) {
        FutureTask<PlayFabResult<ListAssetSummariesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListAssetSummariesResponse>>() {
            public PlayFabResult<ListAssetSummariesResponse> call() throws Exception {
                return privateListAssetSummariesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListAssetSummariesResponse> exceptionResult = new PlayFabResult<ListAssetSummariesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists multiplayer server game assets for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListAssetSummariesResponse> privateListAssetSummariesAsync(final ListAssetSummariesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListAssetSummaries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListAssetSummariesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListAssetSummariesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListAssetSummariesResponse>>(){}.getType());
        ListAssetSummariesResponse result = resultData.data;

        PlayFabResult<ListAssetSummariesResponse> pfResult = new PlayFabResult<ListAssetSummariesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists details of all build aliases for a title. Accepts tokens for title and if game client access is enabled, allows
     * game client to request list of builds with player entity token.
     * @param request ListBuildAliasesRequest
     * @return Async Task will return ListBuildAliasesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListBuildAliasesResponse>> ListBuildAliasesAsync(final ListBuildAliasesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListBuildAliasesResponse>>() {
            public PlayFabResult<ListBuildAliasesResponse> call() throws Exception {
                return privateListBuildAliasesAsync(request);
            }
        });
    }

    /**
     * Lists details of all build aliases for a title. Accepts tokens for title and if game client access is enabled, allows
     * game client to request list of builds with player entity token.
     * @param request ListBuildAliasesRequest
     * @return ListBuildAliasesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListBuildAliasesResponse> ListBuildAliases(final ListBuildAliasesRequest request) {
        FutureTask<PlayFabResult<ListBuildAliasesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListBuildAliasesResponse>>() {
            public PlayFabResult<ListBuildAliasesResponse> call() throws Exception {
                return privateListBuildAliasesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListBuildAliasesResponse> exceptionResult = new PlayFabResult<ListBuildAliasesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Lists details of all build aliases for a title. Accepts tokens for title and if game client access is enabled, allows
     * game client to request list of builds with player entity token.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListBuildAliasesResponse> privateListBuildAliasesAsync(final ListBuildAliasesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListBuildAliases"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListBuildAliasesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListBuildAliasesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListBuildAliasesResponse>>(){}.getType());
        ListBuildAliasesResponse result = resultData.data;

        PlayFabResult<ListBuildAliasesResponse> pfResult = new PlayFabResult<ListBuildAliasesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists summarized details of all multiplayer server builds for a title. Accepts tokens for title and if game client
     * access is enabled, allows game client to request list of builds with player entity token.
     * @param request ListBuildSummariesRequest
     * @return Async Task will return ListBuildSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListBuildSummariesResponse>> ListBuildSummariesV2Async(final ListBuildSummariesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListBuildSummariesResponse>>() {
            public PlayFabResult<ListBuildSummariesResponse> call() throws Exception {
                return privateListBuildSummariesV2Async(request);
            }
        });
    }

    /**
     * Lists summarized details of all multiplayer server builds for a title. Accepts tokens for title and if game client
     * access is enabled, allows game client to request list of builds with player entity token.
     * @param request ListBuildSummariesRequest
     * @return ListBuildSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListBuildSummariesResponse> ListBuildSummariesV2(final ListBuildSummariesRequest request) {
        FutureTask<PlayFabResult<ListBuildSummariesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListBuildSummariesResponse>>() {
            public PlayFabResult<ListBuildSummariesResponse> call() throws Exception {
                return privateListBuildSummariesV2Async(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListBuildSummariesResponse> exceptionResult = new PlayFabResult<ListBuildSummariesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Lists summarized details of all multiplayer server builds for a title. Accepts tokens for title and if game client
     * access is enabled, allows game client to request list of builds with player entity token.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListBuildSummariesResponse> privateListBuildSummariesV2Async(final ListBuildSummariesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListBuildSummariesV2"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListBuildSummariesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListBuildSummariesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListBuildSummariesResponse>>(){}.getType());
        ListBuildSummariesResponse result = resultData.data;

        PlayFabResult<ListBuildSummariesResponse> pfResult = new PlayFabResult<ListBuildSummariesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists multiplayer server game certificates for a title.
     * @param request ListCertificateSummariesRequest
     * @return Async Task will return ListCertificateSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListCertificateSummariesResponse>> ListCertificateSummariesAsync(final ListCertificateSummariesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListCertificateSummariesResponse>>() {
            public PlayFabResult<ListCertificateSummariesResponse> call() throws Exception {
                return privateListCertificateSummariesAsync(request);
            }
        });
    }

    /**
     * Lists multiplayer server game certificates for a title.
     * @param request ListCertificateSummariesRequest
     * @return ListCertificateSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListCertificateSummariesResponse> ListCertificateSummaries(final ListCertificateSummariesRequest request) {
        FutureTask<PlayFabResult<ListCertificateSummariesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListCertificateSummariesResponse>>() {
            public PlayFabResult<ListCertificateSummariesResponse> call() throws Exception {
                return privateListCertificateSummariesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListCertificateSummariesResponse> exceptionResult = new PlayFabResult<ListCertificateSummariesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists multiplayer server game certificates for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListCertificateSummariesResponse> privateListCertificateSummariesAsync(final ListCertificateSummariesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListCertificateSummaries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListCertificateSummariesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListCertificateSummariesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListCertificateSummariesResponse>>(){}.getType());
        ListCertificateSummariesResponse result = resultData.data;

        PlayFabResult<ListCertificateSummariesResponse> pfResult = new PlayFabResult<ListCertificateSummariesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists custom container images for a title.
     * @param request ListContainerImagesRequest
     * @return Async Task will return ListContainerImagesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListContainerImagesResponse>> ListContainerImagesAsync(final ListContainerImagesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListContainerImagesResponse>>() {
            public PlayFabResult<ListContainerImagesResponse> call() throws Exception {
                return privateListContainerImagesAsync(request);
            }
        });
    }

    /**
     * Lists custom container images for a title.
     * @param request ListContainerImagesRequest
     * @return ListContainerImagesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListContainerImagesResponse> ListContainerImages(final ListContainerImagesRequest request) {
        FutureTask<PlayFabResult<ListContainerImagesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListContainerImagesResponse>>() {
            public PlayFabResult<ListContainerImagesResponse> call() throws Exception {
                return privateListContainerImagesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListContainerImagesResponse> exceptionResult = new PlayFabResult<ListContainerImagesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists custom container images for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListContainerImagesResponse> privateListContainerImagesAsync(final ListContainerImagesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListContainerImages"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListContainerImagesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListContainerImagesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListContainerImagesResponse>>(){}.getType());
        ListContainerImagesResponse result = resultData.data;

        PlayFabResult<ListContainerImagesResponse> pfResult = new PlayFabResult<ListContainerImagesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists the tags for a custom container image.
     * @param request ListContainerImageTagsRequest
     * @return Async Task will return ListContainerImageTagsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListContainerImageTagsResponse>> ListContainerImageTagsAsync(final ListContainerImageTagsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListContainerImageTagsResponse>>() {
            public PlayFabResult<ListContainerImageTagsResponse> call() throws Exception {
                return privateListContainerImageTagsAsync(request);
            }
        });
    }

    /**
     * Lists the tags for a custom container image.
     * @param request ListContainerImageTagsRequest
     * @return ListContainerImageTagsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListContainerImageTagsResponse> ListContainerImageTags(final ListContainerImageTagsRequest request) {
        FutureTask<PlayFabResult<ListContainerImageTagsResponse>> task = new FutureTask(new Callable<PlayFabResult<ListContainerImageTagsResponse>>() {
            public PlayFabResult<ListContainerImageTagsResponse> call() throws Exception {
                return privateListContainerImageTagsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListContainerImageTagsResponse> exceptionResult = new PlayFabResult<ListContainerImageTagsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists the tags for a custom container image. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListContainerImageTagsResponse> privateListContainerImageTagsAsync(final ListContainerImageTagsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListContainerImageTags"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListContainerImageTagsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListContainerImageTagsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListContainerImageTagsResponse>>(){}.getType());
        ListContainerImageTagsResponse result = resultData.data;

        PlayFabResult<ListContainerImageTagsResponse> pfResult = new PlayFabResult<ListContainerImageTagsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * List all matchmaking ticket Ids the user is a member of.
     * @param request ListMatchmakingTicketsForPlayerRequest
     * @return Async Task will return ListMatchmakingTicketsForPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListMatchmakingTicketsForPlayerResult>> ListMatchmakingTicketsForPlayerAsync(final ListMatchmakingTicketsForPlayerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListMatchmakingTicketsForPlayerResult>>() {
            public PlayFabResult<ListMatchmakingTicketsForPlayerResult> call() throws Exception {
                return privateListMatchmakingTicketsForPlayerAsync(request);
            }
        });
    }

    /**
     * List all matchmaking ticket Ids the user is a member of.
     * @param request ListMatchmakingTicketsForPlayerRequest
     * @return ListMatchmakingTicketsForPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListMatchmakingTicketsForPlayerResult> ListMatchmakingTicketsForPlayer(final ListMatchmakingTicketsForPlayerRequest request) {
        FutureTask<PlayFabResult<ListMatchmakingTicketsForPlayerResult>> task = new FutureTask(new Callable<PlayFabResult<ListMatchmakingTicketsForPlayerResult>>() {
            public PlayFabResult<ListMatchmakingTicketsForPlayerResult> call() throws Exception {
                return privateListMatchmakingTicketsForPlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListMatchmakingTicketsForPlayerResult> exceptionResult = new PlayFabResult<ListMatchmakingTicketsForPlayerResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** List all matchmaking ticket Ids the user is a member of. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListMatchmakingTicketsForPlayerResult> privateListMatchmakingTicketsForPlayerAsync(final ListMatchmakingTicketsForPlayerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/ListMatchmakingTicketsForPlayer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListMatchmakingTicketsForPlayerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListMatchmakingTicketsForPlayerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListMatchmakingTicketsForPlayerResult>>(){}.getType());
        ListMatchmakingTicketsForPlayerResult result = resultData.data;

        PlayFabResult<ListMatchmakingTicketsForPlayerResult> pfResult = new PlayFabResult<ListMatchmakingTicketsForPlayerResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists multiplayer server sessions for a build.
     * @param request ListMultiplayerServersRequest
     * @return Async Task will return ListMultiplayerServersResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListMultiplayerServersResponse>> ListMultiplayerServersAsync(final ListMultiplayerServersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListMultiplayerServersResponse>>() {
            public PlayFabResult<ListMultiplayerServersResponse> call() throws Exception {
                return privateListMultiplayerServersAsync(request);
            }
        });
    }

    /**
     * Lists multiplayer server sessions for a build.
     * @param request ListMultiplayerServersRequest
     * @return ListMultiplayerServersResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListMultiplayerServersResponse> ListMultiplayerServers(final ListMultiplayerServersRequest request) {
        FutureTask<PlayFabResult<ListMultiplayerServersResponse>> task = new FutureTask(new Callable<PlayFabResult<ListMultiplayerServersResponse>>() {
            public PlayFabResult<ListMultiplayerServersResponse> call() throws Exception {
                return privateListMultiplayerServersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListMultiplayerServersResponse> exceptionResult = new PlayFabResult<ListMultiplayerServersResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists multiplayer server sessions for a build. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListMultiplayerServersResponse> privateListMultiplayerServersAsync(final ListMultiplayerServersRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListMultiplayerServers"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListMultiplayerServersResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListMultiplayerServersResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListMultiplayerServersResponse>>(){}.getType());
        ListMultiplayerServersResponse result = resultData.data;

        PlayFabResult<ListMultiplayerServersResponse> pfResult = new PlayFabResult<ListMultiplayerServersResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists quality of service servers for party.
     * @param request ListPartyQosServersRequest
     * @return Async Task will return ListPartyQosServersResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListPartyQosServersResponse>> ListPartyQosServersAsync(final ListPartyQosServersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListPartyQosServersResponse>>() {
            public PlayFabResult<ListPartyQosServersResponse> call() throws Exception {
                return privateListPartyQosServersAsync(request);
            }
        });
    }

    /**
     * Lists quality of service servers for party.
     * @param request ListPartyQosServersRequest
     * @return ListPartyQosServersResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListPartyQosServersResponse> ListPartyQosServers(final ListPartyQosServersRequest request) {
        FutureTask<PlayFabResult<ListPartyQosServersResponse>> task = new FutureTask(new Callable<PlayFabResult<ListPartyQosServersResponse>>() {
            public PlayFabResult<ListPartyQosServersResponse> call() throws Exception {
                return privateListPartyQosServersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListPartyQosServersResponse> exceptionResult = new PlayFabResult<ListPartyQosServersResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists quality of service servers for party. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListPartyQosServersResponse> privateListPartyQosServersAsync(final ListPartyQosServersRequest request) throws Exception {

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListPartyQosServers"), request, null, null);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListPartyQosServersResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListPartyQosServersResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListPartyQosServersResponse>>(){}.getType());
        ListPartyQosServersResponse result = resultData.data;

        PlayFabResult<ListPartyQosServersResponse> pfResult = new PlayFabResult<ListPartyQosServersResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists quality of service servers for the title. By default, servers are only returned for regions where a Multiplayer
     * Servers build has been deployed.
     * @param request ListQosServersForTitleRequest
     * @return Async Task will return ListQosServersForTitleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListQosServersForTitleResponse>> ListQosServersForTitleAsync(final ListQosServersForTitleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListQosServersForTitleResponse>>() {
            public PlayFabResult<ListQosServersForTitleResponse> call() throws Exception {
                return privateListQosServersForTitleAsync(request);
            }
        });
    }

    /**
     * Lists quality of service servers for the title. By default, servers are only returned for regions where a Multiplayer
     * Servers build has been deployed.
     * @param request ListQosServersForTitleRequest
     * @return ListQosServersForTitleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListQosServersForTitleResponse> ListQosServersForTitle(final ListQosServersForTitleRequest request) {
        FutureTask<PlayFabResult<ListQosServersForTitleResponse>> task = new FutureTask(new Callable<PlayFabResult<ListQosServersForTitleResponse>>() {
            public PlayFabResult<ListQosServersForTitleResponse> call() throws Exception {
                return privateListQosServersForTitleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListQosServersForTitleResponse> exceptionResult = new PlayFabResult<ListQosServersForTitleResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Lists quality of service servers for the title. By default, servers are only returned for regions where a Multiplayer
     * Servers build has been deployed.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListQosServersForTitleResponse> privateListQosServersForTitleAsync(final ListQosServersForTitleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListQosServersForTitle"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListQosServersForTitleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListQosServersForTitleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListQosServersForTitleResponse>>(){}.getType());
        ListQosServersForTitleResponse result = resultData.data;

        PlayFabResult<ListQosServersForTitleResponse> pfResult = new PlayFabResult<ListQosServersForTitleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists multiplayer server game secrets for a title.
     * @param request ListSecretSummariesRequest
     * @return Async Task will return ListSecretSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListSecretSummariesResponse>> ListSecretSummariesAsync(final ListSecretSummariesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListSecretSummariesResponse>>() {
            public PlayFabResult<ListSecretSummariesResponse> call() throws Exception {
                return privateListSecretSummariesAsync(request);
            }
        });
    }

    /**
     * Lists multiplayer server game secrets for a title.
     * @param request ListSecretSummariesRequest
     * @return ListSecretSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListSecretSummariesResponse> ListSecretSummaries(final ListSecretSummariesRequest request) {
        FutureTask<PlayFabResult<ListSecretSummariesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListSecretSummariesResponse>>() {
            public PlayFabResult<ListSecretSummariesResponse> call() throws Exception {
                return privateListSecretSummariesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListSecretSummariesResponse> exceptionResult = new PlayFabResult<ListSecretSummariesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists multiplayer server game secrets for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListSecretSummariesResponse> privateListSecretSummariesAsync(final ListSecretSummariesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListSecretSummaries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListSecretSummariesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListSecretSummariesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListSecretSummariesResponse>>(){}.getType());
        ListSecretSummariesResponse result = resultData.data;

        PlayFabResult<ListSecretSummariesResponse> pfResult = new PlayFabResult<ListSecretSummariesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * List all server backfill ticket Ids the user is a member of.
     * @param request ListServerBackfillTicketsForPlayerRequest
     * @return Async Task will return ListServerBackfillTicketsForPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListServerBackfillTicketsForPlayerResult>> ListServerBackfillTicketsForPlayerAsync(final ListServerBackfillTicketsForPlayerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListServerBackfillTicketsForPlayerResult>>() {
            public PlayFabResult<ListServerBackfillTicketsForPlayerResult> call() throws Exception {
                return privateListServerBackfillTicketsForPlayerAsync(request);
            }
        });
    }

    /**
     * List all server backfill ticket Ids the user is a member of.
     * @param request ListServerBackfillTicketsForPlayerRequest
     * @return ListServerBackfillTicketsForPlayerResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListServerBackfillTicketsForPlayerResult> ListServerBackfillTicketsForPlayer(final ListServerBackfillTicketsForPlayerRequest request) {
        FutureTask<PlayFabResult<ListServerBackfillTicketsForPlayerResult>> task = new FutureTask(new Callable<PlayFabResult<ListServerBackfillTicketsForPlayerResult>>() {
            public PlayFabResult<ListServerBackfillTicketsForPlayerResult> call() throws Exception {
                return privateListServerBackfillTicketsForPlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListServerBackfillTicketsForPlayerResult> exceptionResult = new PlayFabResult<ListServerBackfillTicketsForPlayerResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** List all server backfill ticket Ids the user is a member of. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListServerBackfillTicketsForPlayerResult> privateListServerBackfillTicketsForPlayerAsync(final ListServerBackfillTicketsForPlayerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Match/ListServerBackfillTicketsForPlayer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListServerBackfillTicketsForPlayerResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListServerBackfillTicketsForPlayerResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListServerBackfillTicketsForPlayerResult>>(){}.getType());
        ListServerBackfillTicketsForPlayerResult result = resultData.data;

        PlayFabResult<ListServerBackfillTicketsForPlayerResult> pfResult = new PlayFabResult<ListServerBackfillTicketsForPlayerResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * List all server quota change requests for a title.
     * @param request ListTitleMultiplayerServersQuotaChangesRequest
     * @return Async Task will return ListTitleMultiplayerServersQuotaChangesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse>> ListTitleMultiplayerServersQuotaChangesAsync(final ListTitleMultiplayerServersQuotaChangesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse>>() {
            public PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse> call() throws Exception {
                return privateListTitleMultiplayerServersQuotaChangesAsync(request);
            }
        });
    }

    /**
     * List all server quota change requests for a title.
     * @param request ListTitleMultiplayerServersQuotaChangesRequest
     * @return ListTitleMultiplayerServersQuotaChangesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse> ListTitleMultiplayerServersQuotaChanges(final ListTitleMultiplayerServersQuotaChangesRequest request) {
        FutureTask<PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse>>() {
            public PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse> call() throws Exception {
                return privateListTitleMultiplayerServersQuotaChangesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse> exceptionResult = new PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** List all server quota change requests for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse> privateListTitleMultiplayerServersQuotaChangesAsync(final ListTitleMultiplayerServersQuotaChangesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListTitleMultiplayerServersQuotaChanges"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListTitleMultiplayerServersQuotaChangesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListTitleMultiplayerServersQuotaChangesResponse>>(){}.getType());
        ListTitleMultiplayerServersQuotaChangesResponse result = resultData.data;

        PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse> pfResult = new PlayFabResult<ListTitleMultiplayerServersQuotaChangesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists virtual machines for a title.
     * @param request ListVirtualMachineSummariesRequest
     * @return Async Task will return ListVirtualMachineSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListVirtualMachineSummariesResponse>> ListVirtualMachineSummariesAsync(final ListVirtualMachineSummariesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListVirtualMachineSummariesResponse>>() {
            public PlayFabResult<ListVirtualMachineSummariesResponse> call() throws Exception {
                return privateListVirtualMachineSummariesAsync(request);
            }
        });
    }

    /**
     * Lists virtual machines for a title.
     * @param request ListVirtualMachineSummariesRequest
     * @return ListVirtualMachineSummariesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListVirtualMachineSummariesResponse> ListVirtualMachineSummaries(final ListVirtualMachineSummariesRequest request) {
        FutureTask<PlayFabResult<ListVirtualMachineSummariesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListVirtualMachineSummariesResponse>>() {
            public PlayFabResult<ListVirtualMachineSummariesResponse> call() throws Exception {
                return privateListVirtualMachineSummariesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ListVirtualMachineSummariesResponse> exceptionResult = new PlayFabResult<ListVirtualMachineSummariesResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Lists virtual machines for a title. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListVirtualMachineSummariesResponse> privateListVirtualMachineSummariesAsync(final ListVirtualMachineSummariesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ListVirtualMachineSummaries"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListVirtualMachineSummariesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListVirtualMachineSummariesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListVirtualMachineSummariesResponse>>(){}.getType());
        ListVirtualMachineSummariesResponse result = resultData.data;

        PlayFabResult<ListVirtualMachineSummariesResponse> pfResult = new PlayFabResult<ListVirtualMachineSummariesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Remove a member from a lobby.
     * @param request RemoveMemberFromLobbyRequest
     * @return Async Task will return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LobbyEmptyResult>> RemoveMemberAsync(final RemoveMemberFromLobbyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateRemoveMemberAsync(request);
            }
        });
    }

    /**
     * Remove a member from a lobby.
     * @param request RemoveMemberFromLobbyRequest
     * @return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LobbyEmptyResult> RemoveMember(final RemoveMemberFromLobbyRequest request) {
        FutureTask<PlayFabResult<LobbyEmptyResult>> task = new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateRemoveMemberAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LobbyEmptyResult> exceptionResult = new PlayFabResult<LobbyEmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Remove a member from a lobby. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LobbyEmptyResult> privateRemoveMemberAsync(final RemoveMemberFromLobbyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/RemoveMember"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LobbyEmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LobbyEmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LobbyEmptyResult>>(){}.getType());
        LobbyEmptyResult result = resultData.data;

        PlayFabResult<LobbyEmptyResult> pfResult = new PlayFabResult<LobbyEmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Request a multiplayer server session. Accepts tokens for title and if game client access is enabled, allows game client
     * to request a server with player entity token.
     * @param request RequestMultiplayerServerRequest
     * @return Async Task will return RequestMultiplayerServerResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RequestMultiplayerServerResponse>> RequestMultiplayerServerAsync(final RequestMultiplayerServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RequestMultiplayerServerResponse>>() {
            public PlayFabResult<RequestMultiplayerServerResponse> call() throws Exception {
                return privateRequestMultiplayerServerAsync(request);
            }
        });
    }

    /**
     * Request a multiplayer server session. Accepts tokens for title and if game client access is enabled, allows game client
     * to request a server with player entity token.
     * @param request RequestMultiplayerServerRequest
     * @return RequestMultiplayerServerResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RequestMultiplayerServerResponse> RequestMultiplayerServer(final RequestMultiplayerServerRequest request) {
        FutureTask<PlayFabResult<RequestMultiplayerServerResponse>> task = new FutureTask(new Callable<PlayFabResult<RequestMultiplayerServerResponse>>() {
            public PlayFabResult<RequestMultiplayerServerResponse> call() throws Exception {
                return privateRequestMultiplayerServerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RequestMultiplayerServerResponse> exceptionResult = new PlayFabResult<RequestMultiplayerServerResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Request a multiplayer server session. Accepts tokens for title and if game client access is enabled, allows game client
     * to request a server with player entity token.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RequestMultiplayerServerResponse> privateRequestMultiplayerServerAsync(final RequestMultiplayerServerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/RequestMultiplayerServer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RequestMultiplayerServerResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RequestMultiplayerServerResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RequestMultiplayerServerResponse>>(){}.getType());
        RequestMultiplayerServerResponse result = resultData.data;

        PlayFabResult<RequestMultiplayerServerResponse> pfResult = new PlayFabResult<RequestMultiplayerServerResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Request a party session.
     * @param request RequestPartyServiceRequest
     * @return Async Task will return RequestPartyServiceResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RequestPartyServiceResponse>> RequestPartyServiceAsync(final RequestPartyServiceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RequestPartyServiceResponse>>() {
            public PlayFabResult<RequestPartyServiceResponse> call() throws Exception {
                return privateRequestPartyServiceAsync(request);
            }
        });
    }

    /**
     * Request a party session.
     * @param request RequestPartyServiceRequest
     * @return RequestPartyServiceResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RequestPartyServiceResponse> RequestPartyService(final RequestPartyServiceRequest request) {
        FutureTask<PlayFabResult<RequestPartyServiceResponse>> task = new FutureTask(new Callable<PlayFabResult<RequestPartyServiceResponse>>() {
            public PlayFabResult<RequestPartyServiceResponse> call() throws Exception {
                return privateRequestPartyServiceAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RequestPartyServiceResponse> exceptionResult = new PlayFabResult<RequestPartyServiceResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Request a party session. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RequestPartyServiceResponse> privateRequestPartyServiceAsync(final RequestPartyServiceRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Party/RequestPartyService"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RequestPartyServiceResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RequestPartyServiceResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RequestPartyServiceResponse>>(){}.getType());
        RequestPartyServiceResponse result = resultData.data;

        PlayFabResult<RequestPartyServiceResponse> pfResult = new PlayFabResult<RequestPartyServiceResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Rolls over the credentials to the container registry.
     * @param request RolloverContainerRegistryCredentialsRequest
     * @return Async Task will return RolloverContainerRegistryCredentialsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RolloverContainerRegistryCredentialsResponse>> RolloverContainerRegistryCredentialsAsync(final RolloverContainerRegistryCredentialsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RolloverContainerRegistryCredentialsResponse>>() {
            public PlayFabResult<RolloverContainerRegistryCredentialsResponse> call() throws Exception {
                return privateRolloverContainerRegistryCredentialsAsync(request);
            }
        });
    }

    /**
     * Rolls over the credentials to the container registry.
     * @param request RolloverContainerRegistryCredentialsRequest
     * @return RolloverContainerRegistryCredentialsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RolloverContainerRegistryCredentialsResponse> RolloverContainerRegistryCredentials(final RolloverContainerRegistryCredentialsRequest request) {
        FutureTask<PlayFabResult<RolloverContainerRegistryCredentialsResponse>> task = new FutureTask(new Callable<PlayFabResult<RolloverContainerRegistryCredentialsResponse>>() {
            public PlayFabResult<RolloverContainerRegistryCredentialsResponse> call() throws Exception {
                return privateRolloverContainerRegistryCredentialsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RolloverContainerRegistryCredentialsResponse> exceptionResult = new PlayFabResult<RolloverContainerRegistryCredentialsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Rolls over the credentials to the container registry. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RolloverContainerRegistryCredentialsResponse> privateRolloverContainerRegistryCredentialsAsync(final RolloverContainerRegistryCredentialsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/RolloverContainerRegistryCredentials"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RolloverContainerRegistryCredentialsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RolloverContainerRegistryCredentialsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RolloverContainerRegistryCredentialsResponse>>(){}.getType());
        RolloverContainerRegistryCredentialsResponse result = resultData.data;

        PlayFabResult<RolloverContainerRegistryCredentialsResponse> pfResult = new PlayFabResult<RolloverContainerRegistryCredentialsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Shuts down a multiplayer server session.
     * @param request ShutdownMultiplayerServerRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> ShutdownMultiplayerServerAsync(final ShutdownMultiplayerServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateShutdownMultiplayerServerAsync(request);
            }
        });
    }

    /**
     * Shuts down a multiplayer server session.
     * @param request ShutdownMultiplayerServerRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> ShutdownMultiplayerServer(final ShutdownMultiplayerServerRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateShutdownMultiplayerServerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Shuts down a multiplayer server session. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateShutdownMultiplayerServerAsync(final ShutdownMultiplayerServerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/ShutdownMultiplayerServer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Subscribe to lobby resource notifications.
     * @param request SubscribeToLobbyResourceRequest
     * @return Async Task will return SubscribeToLobbyResourceResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SubscribeToLobbyResourceResult>> SubscribeToLobbyResourceAsync(final SubscribeToLobbyResourceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SubscribeToLobbyResourceResult>>() {
            public PlayFabResult<SubscribeToLobbyResourceResult> call() throws Exception {
                return privateSubscribeToLobbyResourceAsync(request);
            }
        });
    }

    /**
     * Subscribe to lobby resource notifications.
     * @param request SubscribeToLobbyResourceRequest
     * @return SubscribeToLobbyResourceResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SubscribeToLobbyResourceResult> SubscribeToLobbyResource(final SubscribeToLobbyResourceRequest request) {
        FutureTask<PlayFabResult<SubscribeToLobbyResourceResult>> task = new FutureTask(new Callable<PlayFabResult<SubscribeToLobbyResourceResult>>() {
            public PlayFabResult<SubscribeToLobbyResourceResult> call() throws Exception {
                return privateSubscribeToLobbyResourceAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SubscribeToLobbyResourceResult> exceptionResult = new PlayFabResult<SubscribeToLobbyResourceResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Subscribe to lobby resource notifications. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SubscribeToLobbyResourceResult> privateSubscribeToLobbyResourceAsync(final SubscribeToLobbyResourceRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/SubscribeToLobbyResource"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SubscribeToLobbyResourceResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SubscribeToLobbyResourceResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SubscribeToLobbyResourceResult>>(){}.getType());
        SubscribeToLobbyResourceResult result = resultData.data;

        PlayFabResult<SubscribeToLobbyResourceResult> pfResult = new PlayFabResult<SubscribeToLobbyResourceResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unsubscribe from lobby notifications.
     * @param request UnsubscribeFromLobbyResourceRequest
     * @return Async Task will return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LobbyEmptyResult>> UnsubscribeFromLobbyResourceAsync(final UnsubscribeFromLobbyResourceRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateUnsubscribeFromLobbyResourceAsync(request);
            }
        });
    }

    /**
     * Unsubscribe from lobby notifications.
     * @param request UnsubscribeFromLobbyResourceRequest
     * @return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LobbyEmptyResult> UnsubscribeFromLobbyResource(final UnsubscribeFromLobbyResourceRequest request) {
        FutureTask<PlayFabResult<LobbyEmptyResult>> task = new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateUnsubscribeFromLobbyResourceAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LobbyEmptyResult> exceptionResult = new PlayFabResult<LobbyEmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Unsubscribe from lobby notifications. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LobbyEmptyResult> privateUnsubscribeFromLobbyResourceAsync(final UnsubscribeFromLobbyResourceRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/UnsubscribeFromLobbyResource"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LobbyEmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LobbyEmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LobbyEmptyResult>>(){}.getType());
        LobbyEmptyResult result = resultData.data;

        PlayFabResult<LobbyEmptyResult> pfResult = new PlayFabResult<LobbyEmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Untags a container image.
     * @param request UntagContainerImageRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UntagContainerImageAsync(final UntagContainerImageRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUntagContainerImageAsync(request);
            }
        });
    }

    /**
     * Untags a container image.
     * @param request UntagContainerImageRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UntagContainerImage(final UntagContainerImageRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUntagContainerImageAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Untags a container image. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUntagContainerImageAsync(final UntagContainerImageRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/UntagContainerImage"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a multiplayer server build alias.
     * @param request UpdateBuildAliasRequest
     * @return Async Task will return BuildAliasDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<BuildAliasDetailsResponse>> UpdateBuildAliasAsync(final UpdateBuildAliasRequest request) {
        return new FutureTask(new Callable<PlayFabResult<BuildAliasDetailsResponse>>() {
            public PlayFabResult<BuildAliasDetailsResponse> call() throws Exception {
                return privateUpdateBuildAliasAsync(request);
            }
        });
    }

    /**
     * Creates a multiplayer server build alias.
     * @param request UpdateBuildAliasRequest
     * @return BuildAliasDetailsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<BuildAliasDetailsResponse> UpdateBuildAlias(final UpdateBuildAliasRequest request) {
        FutureTask<PlayFabResult<BuildAliasDetailsResponse>> task = new FutureTask(new Callable<PlayFabResult<BuildAliasDetailsResponse>>() {
            public PlayFabResult<BuildAliasDetailsResponse> call() throws Exception {
                return privateUpdateBuildAliasAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<BuildAliasDetailsResponse> exceptionResult = new PlayFabResult<BuildAliasDetailsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a multiplayer server build alias. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<BuildAliasDetailsResponse> privateUpdateBuildAliasAsync(final UpdateBuildAliasRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/UpdateBuildAlias"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<BuildAliasDetailsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<BuildAliasDetailsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<BuildAliasDetailsResponse>>(){}.getType());
        BuildAliasDetailsResponse result = resultData.data;

        PlayFabResult<BuildAliasDetailsResponse> pfResult = new PlayFabResult<BuildAliasDetailsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates a multiplayer server build's name.
     * @param request UpdateBuildNameRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateBuildNameAsync(final UpdateBuildNameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateBuildNameAsync(request);
            }
        });
    }

    /**
     * Updates a multiplayer server build's name.
     * @param request UpdateBuildNameRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateBuildName(final UpdateBuildNameRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateBuildNameAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates a multiplayer server build's name. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateBuildNameAsync(final UpdateBuildNameRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/UpdateBuildName"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates a multiplayer server build's region. If the region is not yet created, it will be created
     * @param request UpdateBuildRegionRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateBuildRegionAsync(final UpdateBuildRegionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateBuildRegionAsync(request);
            }
        });
    }

    /**
     * Updates a multiplayer server build's region. If the region is not yet created, it will be created
     * @param request UpdateBuildRegionRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateBuildRegion(final UpdateBuildRegionRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateBuildRegionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates a multiplayer server build's region. If the region is not yet created, it will be created */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateBuildRegionAsync(final UpdateBuildRegionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/UpdateBuildRegion"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates a multiplayer server build's regions.
     * @param request UpdateBuildRegionsRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UpdateBuildRegionsAsync(final UpdateBuildRegionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateBuildRegionsAsync(request);
            }
        });
    }

    /**
     * Updates a multiplayer server build's regions.
     * @param request UpdateBuildRegionsRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UpdateBuildRegions(final UpdateBuildRegionsRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUpdateBuildRegionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates a multiplayer server build's regions. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUpdateBuildRegionsAsync(final UpdateBuildRegionsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/UpdateBuildRegions"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Update a lobby.
     * @param request UpdateLobbyRequest
     * @return Async Task will return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LobbyEmptyResult>> UpdateLobbyAsync(final UpdateLobbyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateUpdateLobbyAsync(request);
            }
        });
    }

    /**
     * Update a lobby.
     * @param request UpdateLobbyRequest
     * @return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LobbyEmptyResult> UpdateLobby(final UpdateLobbyRequest request) {
        FutureTask<PlayFabResult<LobbyEmptyResult>> task = new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateUpdateLobbyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LobbyEmptyResult> exceptionResult = new PlayFabResult<LobbyEmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Update a lobby. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LobbyEmptyResult> privateUpdateLobbyAsync(final UpdateLobbyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/UpdateLobby"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LobbyEmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LobbyEmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LobbyEmptyResult>>(){}.getType());
        LobbyEmptyResult result = resultData.data;

        PlayFabResult<LobbyEmptyResult> pfResult = new PlayFabResult<LobbyEmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Preview: Update fields related to a joined server in the lobby the server is in. Servers can keep a lobby from expiring
     * by being the one to "update" the lobby in some way. Servers have no impact on last member leave/last member disconnect
     * behavior.
     * @param request UpdateLobbyAsServerRequest
     * @return Async Task will return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<LobbyEmptyResult>> UpdateLobbyAsServerAsync(final UpdateLobbyAsServerRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateUpdateLobbyAsServerAsync(request);
            }
        });
    }

    /**
     * Preview: Update fields related to a joined server in the lobby the server is in. Servers can keep a lobby from expiring
     * by being the one to "update" the lobby in some way. Servers have no impact on last member leave/last member disconnect
     * behavior.
     * @param request UpdateLobbyAsServerRequest
     * @return LobbyEmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<LobbyEmptyResult> UpdateLobbyAsServer(final UpdateLobbyAsServerRequest request) {
        FutureTask<PlayFabResult<LobbyEmptyResult>> task = new FutureTask(new Callable<PlayFabResult<LobbyEmptyResult>>() {
            public PlayFabResult<LobbyEmptyResult> call() throws Exception {
                return privateUpdateLobbyAsServerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<LobbyEmptyResult> exceptionResult = new PlayFabResult<LobbyEmptyResult>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Preview: Update fields related to a joined server in the lobby the server is in. Servers can keep a lobby from expiring
     * by being the one to "update" the lobby in some way. Servers have no impact on last member leave/last member disconnect
     * behavior.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<LobbyEmptyResult> privateUpdateLobbyAsServerAsync(final UpdateLobbyAsServerRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Lobby/UpdateLobbyAsServer"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LobbyEmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<LobbyEmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LobbyEmptyResult>>(){}.getType());
        LobbyEmptyResult result = resultData.data;

        PlayFabResult<LobbyEmptyResult> pfResult = new PlayFabResult<LobbyEmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Uploads a multiplayer server game certificate.
     * @param request UploadCertificateRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UploadCertificateAsync(final UploadCertificateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUploadCertificateAsync(request);
            }
        });
    }

    /**
     * Uploads a multiplayer server game certificate.
     * @param request UploadCertificateRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UploadCertificate(final UploadCertificateRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUploadCertificateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Uploads a multiplayer server game certificate. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUploadCertificateAsync(final UploadCertificateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/UploadCertificate"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Uploads a multiplayer server game secret.
     * @param request UploadSecretRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UploadSecretAsync(final UploadSecretRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUploadSecretAsync(request);
            }
        });
    }

    /**
     * Uploads a multiplayer server game secret.
     * @param request UploadSecretRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UploadSecret(final UploadSecretRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUploadSecretAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<EmptyResponse> exceptionResult = new PlayFabResult<EmptyResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Uploads a multiplayer server game secret. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUploadSecretAsync(final UploadSecretRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/MultiplayerServer/UploadSecret"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResponse>>(){}.getType());
        EmptyResponse result = resultData.data;

        PlayFabResult<EmptyResponse> pfResult = new PlayFabResult<EmptyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

}
