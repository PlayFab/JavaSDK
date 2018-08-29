package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabGroupsModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /**
     * The Groups API is designed for any permanent or semi-permanent collections of Entities (players, or non-players). If you
     * want to make Guilds/Clans/Corporations/etc., then you should use groups. Groups can also be used to make chatrooms,
     * parties, or any other persistent collection of entities.
     */
public class PlayFabGroupsAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Accepts an outstanding invitation to to join a group
     * @param request AcceptGroupApplicationRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> AcceptGroupApplicationAsync(final AcceptGroupApplicationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateAcceptGroupApplicationAsync(request);
            }
        });
    }

    /**
     * Accepts an outstanding invitation to to join a group
     * @param request AcceptGroupApplicationRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> AcceptGroupApplication(final AcceptGroupApplicationRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateAcceptGroupApplicationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Accepts an outstanding invitation to to join a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateAcceptGroupApplicationAsync(final AcceptGroupApplicationRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/AcceptGroupApplication"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Accepts an invitation to join a group
     * @param request AcceptGroupInvitationRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> AcceptGroupInvitationAsync(final AcceptGroupInvitationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateAcceptGroupInvitationAsync(request);
            }
        });
    }

    /**
     * Accepts an invitation to join a group
     * @param request AcceptGroupInvitationRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> AcceptGroupInvitation(final AcceptGroupInvitationRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateAcceptGroupInvitationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Accepts an invitation to join a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateAcceptGroupInvitationAsync(final AcceptGroupInvitationRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/AcceptGroupInvitation"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Adds members to a group or role.
     * @param request AddMembersRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> AddMembersAsync(final AddMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateAddMembersAsync(request);
            }
        });
    }

    /**
     * Adds members to a group or role.
     * @param request AddMembersRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> AddMembers(final AddMembersRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateAddMembersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Adds members to a group or role. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateAddMembersAsync(final AddMembersRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/AddMembers"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Applies to join a group
     * @param request ApplyToGroupRequest
     * @return Async Task will return ApplyToGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ApplyToGroupResponse>> ApplyToGroupAsync(final ApplyToGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ApplyToGroupResponse>>() {
            public PlayFabResult<ApplyToGroupResponse> call() throws Exception {
                return privateApplyToGroupAsync(request);
            }
        });
    }

    /**
     * Applies to join a group
     * @param request ApplyToGroupRequest
     * @return ApplyToGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ApplyToGroupResponse> ApplyToGroup(final ApplyToGroupRequest request) {
        FutureTask<PlayFabResult<ApplyToGroupResponse>> task = new FutureTask(new Callable<PlayFabResult<ApplyToGroupResponse>>() {
            public PlayFabResult<ApplyToGroupResponse> call() throws Exception {
                return privateApplyToGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Applies to join a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ApplyToGroupResponse> privateApplyToGroupAsync(final ApplyToGroupRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/ApplyToGroup"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ApplyToGroupResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ApplyToGroupResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ApplyToGroupResponse>>(){}.getType());
        ApplyToGroupResponse result = resultData.data;

        PlayFabResult<ApplyToGroupResponse> pfResult = new PlayFabResult<ApplyToGroupResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Blocks a list of entities from joining a group.
     * @param request BlockEntityRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> BlockEntityAsync(final BlockEntityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateBlockEntityAsync(request);
            }
        });
    }

    /**
     * Blocks a list of entities from joining a group.
     * @param request BlockEntityRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> BlockEntity(final BlockEntityRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateBlockEntityAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Blocks a list of entities from joining a group. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateBlockEntityAsync(final BlockEntityRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/BlockEntity"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Changes the role membership of a list of entities from one role to another.
     * @param request ChangeMemberRoleRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> ChangeMemberRoleAsync(final ChangeMemberRoleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateChangeMemberRoleAsync(request);
            }
        });
    }

    /**
     * Changes the role membership of a list of entities from one role to another.
     * @param request ChangeMemberRoleRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> ChangeMemberRole(final ChangeMemberRoleRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateChangeMemberRoleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Changes the role membership of a list of entities from one role to another. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateChangeMemberRoleAsync(final ChangeMemberRoleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/ChangeMemberRole"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Creates a new group.
     * @param request CreateGroupRequest
     * @return Async Task will return CreateGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateGroupResponse>> CreateGroupAsync(final CreateGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateGroupResponse>>() {
            public PlayFabResult<CreateGroupResponse> call() throws Exception {
                return privateCreateGroupAsync(request);
            }
        });
    }

    /**
     * Creates a new group.
     * @param request CreateGroupRequest
     * @return CreateGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateGroupResponse> CreateGroup(final CreateGroupRequest request) {
        FutureTask<PlayFabResult<CreateGroupResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateGroupResponse>>() {
            public PlayFabResult<CreateGroupResponse> call() throws Exception {
                return privateCreateGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Creates a new group. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateGroupResponse> privateCreateGroupAsync(final CreateGroupRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/CreateGroup"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateGroupResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateGroupResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateGroupResponse>>(){}.getType());
        CreateGroupResponse result = resultData.data;

        PlayFabResult<CreateGroupResponse> pfResult = new PlayFabResult<CreateGroupResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a new group role.
     * @param request CreateGroupRoleRequest
     * @return Async Task will return CreateGroupRoleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateGroupRoleResponse>> CreateRoleAsync(final CreateGroupRoleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateGroupRoleResponse>>() {
            public PlayFabResult<CreateGroupRoleResponse> call() throws Exception {
                return privateCreateRoleAsync(request);
            }
        });
    }

    /**
     * Creates a new group role.
     * @param request CreateGroupRoleRequest
     * @return CreateGroupRoleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateGroupRoleResponse> CreateRole(final CreateGroupRoleRequest request) {
        FutureTask<PlayFabResult<CreateGroupRoleResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateGroupRoleResponse>>() {
            public PlayFabResult<CreateGroupRoleResponse> call() throws Exception {
                return privateCreateRoleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Creates a new group role. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateGroupRoleResponse> privateCreateRoleAsync(final CreateGroupRoleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/CreateRole"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateGroupRoleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateGroupRoleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateGroupRoleResponse>>(){}.getType());
        CreateGroupRoleResponse result = resultData.data;

        PlayFabResult<CreateGroupRoleResponse> pfResult = new PlayFabResult<CreateGroupRoleResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a group and all roles, invitations, join requests, and blocks associated with it.
     * @param request DeleteGroupRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteGroupAsync(final DeleteGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteGroupAsync(request);
            }
        });
    }

    /**
     * Deletes a group and all roles, invitations, join requests, and blocks associated with it.
     * @param request DeleteGroupRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteGroup(final DeleteGroupRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Deletes a group and all roles, invitations, join requests, and blocks associated with it. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteGroupAsync(final DeleteGroupRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/DeleteGroup"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Deletes an existing role in a group.
     * @param request DeleteRoleRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> DeleteRoleAsync(final DeleteRoleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteRoleAsync(request);
            }
        });
    }

    /**
     * Deletes an existing role in a group.
     * @param request DeleteRoleRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> DeleteRole(final DeleteRoleRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateDeleteRoleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Deletes an existing role in a group. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateDeleteRoleAsync(final DeleteRoleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/DeleteRole"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Gets information about a group and its roles
     * @param request GetGroupRequest
     * @return Async Task will return GetGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetGroupResponse>> GetGroupAsync(final GetGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetGroupResponse>>() {
            public PlayFabResult<GetGroupResponse> call() throws Exception {
                return privateGetGroupAsync(request);
            }
        });
    }

    /**
     * Gets information about a group and its roles
     * @param request GetGroupRequest
     * @return GetGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetGroupResponse> GetGroup(final GetGroupRequest request) {
        FutureTask<PlayFabResult<GetGroupResponse>> task = new FutureTask(new Callable<PlayFabResult<GetGroupResponse>>() {
            public PlayFabResult<GetGroupResponse> call() throws Exception {
                return privateGetGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets information about a group and its roles */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetGroupResponse> privateGetGroupAsync(final GetGroupRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/GetGroup"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetGroupResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetGroupResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetGroupResponse>>(){}.getType());
        GetGroupResponse result = resultData.data;

        PlayFabResult<GetGroupResponse> pfResult = new PlayFabResult<GetGroupResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Invites a player to join a group
     * @param request InviteToGroupRequest
     * @return Async Task will return InviteToGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<InviteToGroupResponse>> InviteToGroupAsync(final InviteToGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<InviteToGroupResponse>>() {
            public PlayFabResult<InviteToGroupResponse> call() throws Exception {
                return privateInviteToGroupAsync(request);
            }
        });
    }

    /**
     * Invites a player to join a group
     * @param request InviteToGroupRequest
     * @return InviteToGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<InviteToGroupResponse> InviteToGroup(final InviteToGroupRequest request) {
        FutureTask<PlayFabResult<InviteToGroupResponse>> task = new FutureTask(new Callable<PlayFabResult<InviteToGroupResponse>>() {
            public PlayFabResult<InviteToGroupResponse> call() throws Exception {
                return privateInviteToGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Invites a player to join a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<InviteToGroupResponse> privateInviteToGroupAsync(final InviteToGroupRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/InviteToGroup"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<InviteToGroupResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<InviteToGroupResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<InviteToGroupResponse>>(){}.getType());
        InviteToGroupResponse result = resultData.data;

        PlayFabResult<InviteToGroupResponse> pfResult = new PlayFabResult<InviteToGroupResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Checks to see if an entity is a member of a group or role within the group
     * @param request IsMemberRequest
     * @return Async Task will return IsMemberResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<IsMemberResponse>> IsMemberAsync(final IsMemberRequest request) {
        return new FutureTask(new Callable<PlayFabResult<IsMemberResponse>>() {
            public PlayFabResult<IsMemberResponse> call() throws Exception {
                return privateIsMemberAsync(request);
            }
        });
    }

    /**
     * Checks to see if an entity is a member of a group or role within the group
     * @param request IsMemberRequest
     * @return IsMemberResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<IsMemberResponse> IsMember(final IsMemberRequest request) {
        FutureTask<PlayFabResult<IsMemberResponse>> task = new FutureTask(new Callable<PlayFabResult<IsMemberResponse>>() {
            public PlayFabResult<IsMemberResponse> call() throws Exception {
                return privateIsMemberAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Checks to see if an entity is a member of a group or role within the group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<IsMemberResponse> privateIsMemberAsync(final IsMemberRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/IsMember"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<IsMemberResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<IsMemberResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<IsMemberResponse>>(){}.getType());
        IsMemberResponse result = resultData.data;

        PlayFabResult<IsMemberResponse> pfResult = new PlayFabResult<IsMemberResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all outstanding requests to join a group
     * @param request ListGroupApplicationsRequest
     * @return Async Task will return ListGroupApplicationsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListGroupApplicationsResponse>> ListGroupApplicationsAsync(final ListGroupApplicationsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListGroupApplicationsResponse>>() {
            public PlayFabResult<ListGroupApplicationsResponse> call() throws Exception {
                return privateListGroupApplicationsAsync(request);
            }
        });
    }

    /**
     * Lists all outstanding requests to join a group
     * @param request ListGroupApplicationsRequest
     * @return ListGroupApplicationsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListGroupApplicationsResponse> ListGroupApplications(final ListGroupApplicationsRequest request) {
        FutureTask<PlayFabResult<ListGroupApplicationsResponse>> task = new FutureTask(new Callable<PlayFabResult<ListGroupApplicationsResponse>>() {
            public PlayFabResult<ListGroupApplicationsResponse> call() throws Exception {
                return privateListGroupApplicationsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists all outstanding requests to join a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListGroupApplicationsResponse> privateListGroupApplicationsAsync(final ListGroupApplicationsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/ListGroupApplications"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListGroupApplicationsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListGroupApplicationsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListGroupApplicationsResponse>>(){}.getType());
        ListGroupApplicationsResponse result = resultData.data;

        PlayFabResult<ListGroupApplicationsResponse> pfResult = new PlayFabResult<ListGroupApplicationsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all entities blocked from joining a group
     * @param request ListGroupBlocksRequest
     * @return Async Task will return ListGroupBlocksResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListGroupBlocksResponse>> ListGroupBlocksAsync(final ListGroupBlocksRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListGroupBlocksResponse>>() {
            public PlayFabResult<ListGroupBlocksResponse> call() throws Exception {
                return privateListGroupBlocksAsync(request);
            }
        });
    }

    /**
     * Lists all entities blocked from joining a group
     * @param request ListGroupBlocksRequest
     * @return ListGroupBlocksResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListGroupBlocksResponse> ListGroupBlocks(final ListGroupBlocksRequest request) {
        FutureTask<PlayFabResult<ListGroupBlocksResponse>> task = new FutureTask(new Callable<PlayFabResult<ListGroupBlocksResponse>>() {
            public PlayFabResult<ListGroupBlocksResponse> call() throws Exception {
                return privateListGroupBlocksAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists all entities blocked from joining a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListGroupBlocksResponse> privateListGroupBlocksAsync(final ListGroupBlocksRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/ListGroupBlocks"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListGroupBlocksResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListGroupBlocksResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListGroupBlocksResponse>>(){}.getType());
        ListGroupBlocksResponse result = resultData.data;

        PlayFabResult<ListGroupBlocksResponse> pfResult = new PlayFabResult<ListGroupBlocksResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all outstanding invitations for a group
     * @param request ListGroupInvitationsRequest
     * @return Async Task will return ListGroupInvitationsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListGroupInvitationsResponse>> ListGroupInvitationsAsync(final ListGroupInvitationsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListGroupInvitationsResponse>>() {
            public PlayFabResult<ListGroupInvitationsResponse> call() throws Exception {
                return privateListGroupInvitationsAsync(request);
            }
        });
    }

    /**
     * Lists all outstanding invitations for a group
     * @param request ListGroupInvitationsRequest
     * @return ListGroupInvitationsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListGroupInvitationsResponse> ListGroupInvitations(final ListGroupInvitationsRequest request) {
        FutureTask<PlayFabResult<ListGroupInvitationsResponse>> task = new FutureTask(new Callable<PlayFabResult<ListGroupInvitationsResponse>>() {
            public PlayFabResult<ListGroupInvitationsResponse> call() throws Exception {
                return privateListGroupInvitationsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists all outstanding invitations for a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListGroupInvitationsResponse> privateListGroupInvitationsAsync(final ListGroupInvitationsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/ListGroupInvitations"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListGroupInvitationsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListGroupInvitationsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListGroupInvitationsResponse>>(){}.getType());
        ListGroupInvitationsResponse result = resultData.data;

        PlayFabResult<ListGroupInvitationsResponse> pfResult = new PlayFabResult<ListGroupInvitationsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all members for a group
     * @param request ListGroupMembersRequest
     * @return Async Task will return ListGroupMembersResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListGroupMembersResponse>> ListGroupMembersAsync(final ListGroupMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListGroupMembersResponse>>() {
            public PlayFabResult<ListGroupMembersResponse> call() throws Exception {
                return privateListGroupMembersAsync(request);
            }
        });
    }

    /**
     * Lists all members for a group
     * @param request ListGroupMembersRequest
     * @return ListGroupMembersResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListGroupMembersResponse> ListGroupMembers(final ListGroupMembersRequest request) {
        FutureTask<PlayFabResult<ListGroupMembersResponse>> task = new FutureTask(new Callable<PlayFabResult<ListGroupMembersResponse>>() {
            public PlayFabResult<ListGroupMembersResponse> call() throws Exception {
                return privateListGroupMembersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists all members for a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListGroupMembersResponse> privateListGroupMembersAsync(final ListGroupMembersRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/ListGroupMembers"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListGroupMembersResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListGroupMembersResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListGroupMembersResponse>>(){}.getType());
        ListGroupMembersResponse result = resultData.data;

        PlayFabResult<ListGroupMembersResponse> pfResult = new PlayFabResult<ListGroupMembersResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all groups and roles for an entity
     * @param request ListMembershipRequest
     * @return Async Task will return ListMembershipResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListMembershipResponse>> ListMembershipAsync(final ListMembershipRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListMembershipResponse>>() {
            public PlayFabResult<ListMembershipResponse> call() throws Exception {
                return privateListMembershipAsync(request);
            }
        });
    }

    /**
     * Lists all groups and roles for an entity
     * @param request ListMembershipRequest
     * @return ListMembershipResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListMembershipResponse> ListMembership(final ListMembershipRequest request) {
        FutureTask<PlayFabResult<ListMembershipResponse>> task = new FutureTask(new Callable<PlayFabResult<ListMembershipResponse>>() {
            public PlayFabResult<ListMembershipResponse> call() throws Exception {
                return privateListMembershipAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists all groups and roles for an entity */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListMembershipResponse> privateListMembershipAsync(final ListMembershipRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/ListMembership"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListMembershipResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListMembershipResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListMembershipResponse>>(){}.getType());
        ListMembershipResponse result = resultData.data;

        PlayFabResult<ListMembershipResponse> pfResult = new PlayFabResult<ListMembershipResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Lists all outstanding invitations and group applications for an entity
     * @param request ListMembershipOpportunitiesRequest
     * @return Async Task will return ListMembershipOpportunitiesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ListMembershipOpportunitiesResponse>> ListMembershipOpportunitiesAsync(final ListMembershipOpportunitiesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListMembershipOpportunitiesResponse>>() {
            public PlayFabResult<ListMembershipOpportunitiesResponse> call() throws Exception {
                return privateListMembershipOpportunitiesAsync(request);
            }
        });
    }

    /**
     * Lists all outstanding invitations and group applications for an entity
     * @param request ListMembershipOpportunitiesRequest
     * @return ListMembershipOpportunitiesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ListMembershipOpportunitiesResponse> ListMembershipOpportunities(final ListMembershipOpportunitiesRequest request) {
        FutureTask<PlayFabResult<ListMembershipOpportunitiesResponse>> task = new FutureTask(new Callable<PlayFabResult<ListMembershipOpportunitiesResponse>>() {
            public PlayFabResult<ListMembershipOpportunitiesResponse> call() throws Exception {
                return privateListMembershipOpportunitiesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Lists all outstanding invitations and group applications for an entity */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ListMembershipOpportunitiesResponse> privateListMembershipOpportunitiesAsync(final ListMembershipOpportunitiesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/ListMembershipOpportunities"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListMembershipOpportunitiesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ListMembershipOpportunitiesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListMembershipOpportunitiesResponse>>(){}.getType());
        ListMembershipOpportunitiesResponse result = resultData.data;

        PlayFabResult<ListMembershipOpportunitiesResponse> pfResult = new PlayFabResult<ListMembershipOpportunitiesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes an application to join a group
     * @param request RemoveGroupApplicationRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> RemoveGroupApplicationAsync(final RemoveGroupApplicationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateRemoveGroupApplicationAsync(request);
            }
        });
    }

    /**
     * Removes an application to join a group
     * @param request RemoveGroupApplicationRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> RemoveGroupApplication(final RemoveGroupApplicationRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateRemoveGroupApplicationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Removes an application to join a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateRemoveGroupApplicationAsync(final RemoveGroupApplicationRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/RemoveGroupApplication"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Removes an invitation join a group
     * @param request RemoveGroupInvitationRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> RemoveGroupInvitationAsync(final RemoveGroupInvitationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateRemoveGroupInvitationAsync(request);
            }
        });
    }

    /**
     * Removes an invitation join a group
     * @param request RemoveGroupInvitationRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> RemoveGroupInvitation(final RemoveGroupInvitationRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateRemoveGroupInvitationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Removes an invitation join a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateRemoveGroupInvitationAsync(final RemoveGroupInvitationRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/RemoveGroupInvitation"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Removes members from a group.
     * @param request RemoveMembersRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> RemoveMembersAsync(final RemoveMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateRemoveMembersAsync(request);
            }
        });
    }

    /**
     * Removes members from a group.
     * @param request RemoveMembersRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> RemoveMembers(final RemoveMembersRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateRemoveMembersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Removes members from a group. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateRemoveMembersAsync(final RemoveMembersRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/RemoveMembers"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Unblocks a list of entities from joining a group
     * @param request UnblockEntityRequest
     * @return Async Task will return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResponse>> UnblockEntityAsync(final UnblockEntityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnblockEntityAsync(request);
            }
        });
    }

    /**
     * Unblocks a list of entities from joining a group
     * @param request UnblockEntityRequest
     * @return EmptyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResponse> UnblockEntity(final UnblockEntityRequest request) {
        FutureTask<PlayFabResult<EmptyResponse>> task = new FutureTask(new Callable<PlayFabResult<EmptyResponse>>() {
            public PlayFabResult<EmptyResponse> call() throws Exception {
                return privateUnblockEntityAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Unblocks a list of entities from joining a group */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<EmptyResponse> privateUnblockEntityAsync(final UnblockEntityRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/UnblockEntity"), request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Updates non-membership data about a group.
     * @param request UpdateGroupRequest
     * @return Async Task will return UpdateGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateGroupResponse>> UpdateGroupAsync(final UpdateGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateGroupResponse>>() {
            public PlayFabResult<UpdateGroupResponse> call() throws Exception {
                return privateUpdateGroupAsync(request);
            }
        });
    }

    /**
     * Updates non-membership data about a group.
     * @param request UpdateGroupRequest
     * @return UpdateGroupResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateGroupResponse> UpdateGroup(final UpdateGroupRequest request) {
        FutureTask<PlayFabResult<UpdateGroupResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdateGroupResponse>>() {
            public PlayFabResult<UpdateGroupResponse> call() throws Exception {
                return privateUpdateGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Updates non-membership data about a group. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateGroupResponse> privateUpdateGroupAsync(final UpdateGroupRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/UpdateGroup"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateGroupResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateGroupResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateGroupResponse>>(){}.getType());
        UpdateGroupResponse result = resultData.data;

        PlayFabResult<UpdateGroupResponse> pfResult = new PlayFabResult<UpdateGroupResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates metadata about a role.
     * @param request UpdateGroupRoleRequest
     * @return Async Task will return UpdateGroupRoleResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateGroupRoleResponse>> UpdateRoleAsync(final UpdateGroupRoleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateGroupRoleResponse>>() {
            public PlayFabResult<UpdateGroupRoleResponse> call() throws Exception {
                return privateUpdateRoleAsync(request);
            }
        });
    }

    /**
     * Updates metadata about a role.
     * @param request UpdateGroupRoleRequest
     * @return UpdateGroupRoleResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateGroupRoleResponse> UpdateRole(final UpdateGroupRoleRequest request) {
        FutureTask<PlayFabResult<UpdateGroupRoleResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdateGroupRoleResponse>>() {
            public PlayFabResult<UpdateGroupRoleResponse> call() throws Exception {
                return privateUpdateRoleAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Updates metadata about a role. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateGroupRoleResponse> privateUpdateRoleAsync(final UpdateGroupRoleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Group/UpdateRole"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateGroupRoleResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateGroupRoleResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateGroupRoleResponse>>(){}.getType());
        UpdateGroupRoleResponse result = resultData.data;

        PlayFabResult<UpdateGroupRoleResponse> pfResult = new PlayFabResult<UpdateGroupRoleResponse>();
        pfResult.Result = result;
        return pfResult;
    }
}
