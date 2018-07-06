package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabEntityModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /**
     * PlayFab Entity APIs provide a variety of core PlayFab features and work consistently across a broad set of entities,
     * such as titles, players, characters, and more. API methods for executing CloudScript with an Entity Profile
     */
public class PlayFabEntityAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Abort pending file uploads to an entity's profile.
     * @param request AbortFileUploadsRequest
     * @return Async Task will return AbortFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AbortFileUploadsResponse>> AbortFileUploadsAsync(final AbortFileUploadsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AbortFileUploadsResponse>>() {
            public PlayFabResult<AbortFileUploadsResponse> call() throws Exception {
                return privateAbortFileUploadsAsync(request);
            }
        });
    }

    /**
     * Abort pending file uploads to an entity's profile.
     * @param request AbortFileUploadsRequest
     * @return AbortFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AbortFileUploadsResponse> AbortFileUploads(final AbortFileUploadsRequest request) {
        FutureTask<PlayFabResult<AbortFileUploadsResponse>> task = new FutureTask(new Callable<PlayFabResult<AbortFileUploadsResponse>>() {
            public PlayFabResult<AbortFileUploadsResponse> call() throws Exception {
                return privateAbortFileUploadsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Abort pending file uploads to an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AbortFileUploadsResponse> privateAbortFileUploadsAsync(final AbortFileUploadsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/File/AbortFileUploads", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AbortFileUploadsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AbortFileUploadsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AbortFileUploadsResponse>>(){}.getType());
        AbortFileUploadsResponse result = resultData.data;

        PlayFabResult<AbortFileUploadsResponse> pfResult = new PlayFabResult<AbortFileUploadsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Accepts an outstanding invitation to to join a group
     * @param request AcceptGroupApplicationRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> AcceptGroupApplicationAsync(final AcceptGroupApplicationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateAcceptGroupApplicationAsync(request);
            }
        });
    }

    /**
     * Accepts an outstanding invitation to to join a group
     * @param request AcceptGroupApplicationRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> AcceptGroupApplication(final AcceptGroupApplicationRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateAcceptGroupApplicationAsync(final AcceptGroupApplicationRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/AcceptGroupApplication", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Accepts an invitation to join a group
     * @param request AcceptGroupInvitationRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> AcceptGroupInvitationAsync(final AcceptGroupInvitationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateAcceptGroupInvitationAsync(request);
            }
        });
    }

    /**
     * Accepts an invitation to join a group
     * @param request AcceptGroupInvitationRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> AcceptGroupInvitation(final AcceptGroupInvitationRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateAcceptGroupInvitationAsync(final AcceptGroupInvitationRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/AcceptGroupInvitation", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Adds members to a group or role.
     * @param request AddMembersRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> AddMembersAsync(final AddMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateAddMembersAsync(request);
            }
        });
    }

    /**
     * Adds members to a group or role.
     * @param request AddMembersRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> AddMembers(final AddMembersRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateAddMembersAsync(final AddMembersRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/AddMembers", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/ApplyToGroup", request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> BlockEntityAsync(final BlockEntityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateBlockEntityAsync(request);
            }
        });
    }

    /**
     * Blocks a list of entities from joining a group.
     * @param request BlockEntityRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> BlockEntity(final BlockEntityRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateBlockEntityAsync(final BlockEntityRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/BlockEntity", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Changes the role membership of a list of entities from one role to another.
     * @param request ChangeMemberRoleRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> ChangeMemberRoleAsync(final ChangeMemberRoleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateChangeMemberRoleAsync(request);
            }
        });
    }

    /**
     * Changes the role membership of a list of entities from one role to another.
     * @param request ChangeMemberRoleRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> ChangeMemberRole(final ChangeMemberRoleRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateChangeMemberRoleAsync(final ChangeMemberRoleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/ChangeMemberRole", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/CreateGroup", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/CreateRole", request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Delete files on an entity's profile.
     * @param request DeleteFilesRequest
     * @return Async Task will return DeleteFilesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteFilesResponse>> DeleteFilesAsync(final DeleteFilesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteFilesResponse>>() {
            public PlayFabResult<DeleteFilesResponse> call() throws Exception {
                return privateDeleteFilesAsync(request);
            }
        });
    }

    /**
     * Delete files on an entity's profile.
     * @param request DeleteFilesRequest
     * @return DeleteFilesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteFilesResponse> DeleteFiles(final DeleteFilesRequest request) {
        FutureTask<PlayFabResult<DeleteFilesResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteFilesResponse>>() {
            public PlayFabResult<DeleteFilesResponse> call() throws Exception {
                return privateDeleteFilesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Delete files on an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteFilesResponse> privateDeleteFilesAsync(final DeleteFilesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/File/DeleteFiles", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteFilesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteFilesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteFilesResponse>>(){}.getType());
        DeleteFilesResponse result = resultData.data;

        PlayFabResult<DeleteFilesResponse> pfResult = new PlayFabResult<DeleteFilesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes a group and all roles, invitations, join requests, and blocks associated with it.
     * @param request DeleteGroupRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> DeleteGroupAsync(final DeleteGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateDeleteGroupAsync(request);
            }
        });
    }

    /**
     * Deletes a group and all roles, invitations, join requests, and blocks associated with it.
     * @param request DeleteGroupRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> DeleteGroup(final DeleteGroupRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateDeleteGroupAsync(final DeleteGroupRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/DeleteGroup", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes an existing role in a group.
     * @param request DeleteRoleRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> DeleteRoleAsync(final DeleteRoleRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateDeleteRoleAsync(request);
            }
        });
    }

    /**
     * Deletes an existing role in a group.
     * @param request DeleteRoleRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> DeleteRole(final DeleteRoleRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateDeleteRoleAsync(final DeleteRoleRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/DeleteRole", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Executes CloudScript using the Entity Profile
     * @param request ExecuteEntityCloudScriptRequest
     * @return Async Task will return ExecuteCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ExecuteCloudScriptResult>> ExecuteEntityCloudScriptAsync(final ExecuteEntityCloudScriptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ExecuteCloudScriptResult>>() {
            public PlayFabResult<ExecuteCloudScriptResult> call() throws Exception {
                return privateExecuteEntityCloudScriptAsync(request);
            }
        });
    }

    /**
     * Executes CloudScript using the Entity Profile
     * @param request ExecuteEntityCloudScriptRequest
     * @return ExecuteCloudScriptResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ExecuteCloudScriptResult> ExecuteEntityCloudScript(final ExecuteEntityCloudScriptRequest request) {
        FutureTask<PlayFabResult<ExecuteCloudScriptResult>> task = new FutureTask(new Callable<PlayFabResult<ExecuteCloudScriptResult>>() {
            public PlayFabResult<ExecuteCloudScriptResult> call() throws Exception {
                return privateExecuteEntityCloudScriptAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Executes CloudScript using the Entity Profile */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ExecuteCloudScriptResult> privateExecuteEntityCloudScriptAsync(final ExecuteEntityCloudScriptRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/CloudScript/ExecuteEntityCloudScript", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ExecuteCloudScriptResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ExecuteCloudScriptResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ExecuteCloudScriptResult>>(){}.getType());
        ExecuteCloudScriptResult result = resultData.data;

        PlayFabResult<ExecuteCloudScriptResult> pfResult = new PlayFabResult<ExecuteCloudScriptResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Finalize file uploads to an entity's profile.
     * @param request FinalizeFileUploadsRequest
     * @return Async Task will return FinalizeFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<FinalizeFileUploadsResponse>> FinalizeFileUploadsAsync(final FinalizeFileUploadsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<FinalizeFileUploadsResponse>>() {
            public PlayFabResult<FinalizeFileUploadsResponse> call() throws Exception {
                return privateFinalizeFileUploadsAsync(request);
            }
        });
    }

    /**
     * Finalize file uploads to an entity's profile.
     * @param request FinalizeFileUploadsRequest
     * @return FinalizeFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<FinalizeFileUploadsResponse> FinalizeFileUploads(final FinalizeFileUploadsRequest request) {
        FutureTask<PlayFabResult<FinalizeFileUploadsResponse>> task = new FutureTask(new Callable<PlayFabResult<FinalizeFileUploadsResponse>>() {
            public PlayFabResult<FinalizeFileUploadsResponse> call() throws Exception {
                return privateFinalizeFileUploadsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Finalize file uploads to an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<FinalizeFileUploadsResponse> privateFinalizeFileUploadsAsync(final FinalizeFileUploadsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/File/FinalizeFileUploads", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<FinalizeFileUploadsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<FinalizeFileUploadsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<FinalizeFileUploadsResponse>>(){}.getType());
        FinalizeFileUploadsResponse result = resultData.data;

        PlayFabResult<FinalizeFileUploadsResponse> pfResult = new PlayFabResult<FinalizeFileUploadsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Method to exchange a legacy AuthenticationTicket or title SecretKey for an Entity Token or to refresh a still valid
     * Entity Token.
     * @param request GetEntityTokenRequest
     * @return Async Task will return GetEntityTokenResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityTokenResponse>> GetEntityTokenAsync(final GetEntityTokenRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityTokenResponse>>() {
            public PlayFabResult<GetEntityTokenResponse> call() throws Exception {
                return privateGetEntityTokenAsync(request);
            }
        });
    }

    /**
     * Method to exchange a legacy AuthenticationTicket or title SecretKey for an Entity Token or to refresh a still valid
     * Entity Token.
     * @param request GetEntityTokenRequest
     * @return GetEntityTokenResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityTokenResponse> GetEntityToken(final GetEntityTokenRequest request) {
        FutureTask<PlayFabResult<GetEntityTokenResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityTokenResponse>>() {
            public PlayFabResult<GetEntityTokenResponse> call() throws Exception {
                return privateGetEntityTokenAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * Method to exchange a legacy AuthenticationTicket or title SecretKey for an Entity Token or to refresh a still valid
     * Entity Token.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityTokenResponse> privateGetEntityTokenAsync(final GetEntityTokenRequest request) throws Exception {
        String authKey = null, authValue = null;
        if (PlayFabSettings.EntityToken != null) { authKey = "X-EntityToken"; authValue = PlayFabSettings.EntityToken; }
        else if (PlayFabSettings.ClientSessionTicket != null) { authKey = "X-Authorization"; authValue = PlayFabSettings.ClientSessionTicket; }
        else if (PlayFabSettings.DeveloperSecretKey != null) { authKey = "X-SecretKey"; authValue = PlayFabSettings.DeveloperSecretKey; }

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Authentication/GetEntityToken", request, authKey, authValue);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityTokenResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityTokenResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityTokenResponse>>(){}.getType());
        GetEntityTokenResponse result = resultData.data;
        PlayFabSettings.EntityToken = result.EntityToken != null ? result.EntityToken : PlayFabSettings.EntityToken;

        PlayFabResult<GetEntityTokenResponse> pfResult = new PlayFabResult<GetEntityTokenResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves file metadata from an entity's profile.
     * @param request GetFilesRequest
     * @return Async Task will return GetFilesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetFilesResponse>> GetFilesAsync(final GetFilesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetFilesResponse>>() {
            public PlayFabResult<GetFilesResponse> call() throws Exception {
                return privateGetFilesAsync(request);
            }
        });
    }

    /**
     * Retrieves file metadata from an entity's profile.
     * @param request GetFilesRequest
     * @return GetFilesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetFilesResponse> GetFiles(final GetFilesRequest request) {
        FutureTask<PlayFabResult<GetFilesResponse>> task = new FutureTask(new Callable<PlayFabResult<GetFilesResponse>>() {
            public PlayFabResult<GetFilesResponse> call() throws Exception {
                return privateGetFilesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves file metadata from an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetFilesResponse> privateGetFilesAsync(final GetFilesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/File/GetFiles", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetFilesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetFilesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetFilesResponse>>(){}.getType());
        GetFilesResponse result = resultData.data;

        PlayFabResult<GetFilesResponse> pfResult = new PlayFabResult<GetFilesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the global title access policy
     * @param request GetGlobalPolicyRequest
     * @return Async Task will return GetGlobalPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetGlobalPolicyResponse>> GetGlobalPolicyAsync(final GetGlobalPolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetGlobalPolicyResponse>>() {
            public PlayFabResult<GetGlobalPolicyResponse> call() throws Exception {
                return privateGetGlobalPolicyAsync(request);
            }
        });
    }

    /**
     * Gets the global title access policy
     * @param request GetGlobalPolicyRequest
     * @return GetGlobalPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetGlobalPolicyResponse> GetGlobalPolicy(final GetGlobalPolicyRequest request) {
        FutureTask<PlayFabResult<GetGlobalPolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<GetGlobalPolicyResponse>>() {
            public PlayFabResult<GetGlobalPolicyResponse> call() throws Exception {
                return privateGetGlobalPolicyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Gets the global title access policy */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetGlobalPolicyResponse> privateGetGlobalPolicyAsync(final GetGlobalPolicyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Profile/GetGlobalPolicy", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetGlobalPolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetGlobalPolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetGlobalPolicyResponse>>(){}.getType());
        GetGlobalPolicyResponse result = resultData.data;

        PlayFabResult<GetGlobalPolicyResponse> pfResult = new PlayFabResult<GetGlobalPolicyResponse>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/GetGroup", request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * Retrieves objects from an entity's profile.
     * @param request GetObjectsRequest
     * @return Async Task will return GetObjectsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetObjectsResponse>> GetObjectsAsync(final GetObjectsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetObjectsResponse>>() {
            public PlayFabResult<GetObjectsResponse> call() throws Exception {
                return privateGetObjectsAsync(request);
            }
        });
    }

    /**
     * Retrieves objects from an entity's profile.
     * @param request GetObjectsRequest
     * @return GetObjectsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetObjectsResponse> GetObjects(final GetObjectsRequest request) {
        FutureTask<PlayFabResult<GetObjectsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetObjectsResponse>>() {
            public PlayFabResult<GetObjectsResponse> call() throws Exception {
                return privateGetObjectsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves objects from an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetObjectsResponse> privateGetObjectsAsync(final GetObjectsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Object/GetObjects", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetObjectsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetObjectsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetObjectsResponse>>(){}.getType());
        GetObjectsResponse result = resultData.data;

        PlayFabResult<GetObjectsResponse> pfResult = new PlayFabResult<GetObjectsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the entity's profile.
     * @param request GetEntityProfileRequest
     * @return Async Task will return GetEntityProfileResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityProfileResponse>> GetProfileAsync(final GetEntityProfileRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityProfileResponse>>() {
            public PlayFabResult<GetEntityProfileResponse> call() throws Exception {
                return privateGetProfileAsync(request);
            }
        });
    }

    /**
     * Retrieves the entity's profile.
     * @param request GetEntityProfileRequest
     * @return GetEntityProfileResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityProfileResponse> GetProfile(final GetEntityProfileRequest request) {
        FutureTask<PlayFabResult<GetEntityProfileResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityProfileResponse>>() {
            public PlayFabResult<GetEntityProfileResponse> call() throws Exception {
                return privateGetProfileAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves the entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityProfileResponse> privateGetProfileAsync(final GetEntityProfileRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Profile/GetProfile", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityProfileResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityProfileResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityProfileResponse>>(){}.getType());
        GetEntityProfileResponse result = resultData.data;

        PlayFabResult<GetEntityProfileResponse> pfResult = new PlayFabResult<GetEntityProfileResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves the entity's profile.
     * @param request GetEntityProfilesRequest
     * @return Async Task will return GetEntityProfilesResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityProfilesResponse>> GetProfilesAsync(final GetEntityProfilesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityProfilesResponse>>() {
            public PlayFabResult<GetEntityProfilesResponse> call() throws Exception {
                return privateGetProfilesAsync(request);
            }
        });
    }

    /**
     * Retrieves the entity's profile.
     * @param request GetEntityProfilesRequest
     * @return GetEntityProfilesResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityProfilesResponse> GetProfiles(final GetEntityProfilesRequest request) {
        FutureTask<PlayFabResult<GetEntityProfilesResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityProfilesResponse>>() {
            public PlayFabResult<GetEntityProfilesResponse> call() throws Exception {
                return privateGetProfilesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Retrieves the entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityProfilesResponse> privateGetProfilesAsync(final GetEntityProfilesRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Profile/GetProfiles", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityProfilesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityProfilesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityProfilesResponse>>(){}.getType());
        GetEntityProfilesResponse result = resultData.data;

        PlayFabResult<GetEntityProfilesResponse> pfResult = new PlayFabResult<GetEntityProfilesResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Initiates file uploads to an entity's profile.
     * @param request InitiateFileUploadsRequest
     * @return Async Task will return InitiateFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<InitiateFileUploadsResponse>> InitiateFileUploadsAsync(final InitiateFileUploadsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<InitiateFileUploadsResponse>>() {
            public PlayFabResult<InitiateFileUploadsResponse> call() throws Exception {
                return privateInitiateFileUploadsAsync(request);
            }
        });
    }

    /**
     * Initiates file uploads to an entity's profile.
     * @param request InitiateFileUploadsRequest
     * @return InitiateFileUploadsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<InitiateFileUploadsResponse> InitiateFileUploads(final InitiateFileUploadsRequest request) {
        FutureTask<PlayFabResult<InitiateFileUploadsResponse>> task = new FutureTask(new Callable<PlayFabResult<InitiateFileUploadsResponse>>() {
            public PlayFabResult<InitiateFileUploadsResponse> call() throws Exception {
                return privateInitiateFileUploadsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Initiates file uploads to an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<InitiateFileUploadsResponse> privateInitiateFileUploadsAsync(final InitiateFileUploadsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/File/InitiateFileUploads", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<InitiateFileUploadsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<InitiateFileUploadsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<InitiateFileUploadsResponse>>(){}.getType());
        InitiateFileUploadsResponse result = resultData.data;

        PlayFabResult<InitiateFileUploadsResponse> pfResult = new PlayFabResult<InitiateFileUploadsResponse>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/InviteToGroup", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/IsMember", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/ListGroupApplications", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/ListGroupBlocks", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/ListGroupInvitations", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/ListGroupMembers", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/ListMembership", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/ListMembershipOpportunities", request, "X-EntityToken", PlayFabSettings.EntityToken);
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
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> RemoveGroupApplicationAsync(final RemoveGroupApplicationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRemoveGroupApplicationAsync(request);
            }
        });
    }

    /**
     * Removes an application to join a group
     * @param request RemoveGroupApplicationRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> RemoveGroupApplication(final RemoveGroupApplicationRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateRemoveGroupApplicationAsync(final RemoveGroupApplicationRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/RemoveGroupApplication", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes an invitation join a group
     * @param request RemoveGroupInvitationRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> RemoveGroupInvitationAsync(final RemoveGroupInvitationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRemoveGroupInvitationAsync(request);
            }
        });
    }

    /**
     * Removes an invitation join a group
     * @param request RemoveGroupInvitationRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> RemoveGroupInvitation(final RemoveGroupInvitationRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateRemoveGroupInvitationAsync(final RemoveGroupInvitationRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/RemoveGroupInvitation", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes members from a group.
     * @param request RemoveMembersRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> RemoveMembersAsync(final RemoveMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateRemoveMembersAsync(request);
            }
        });
    }

    /**
     * Removes members from a group.
     * @param request RemoveMembersRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> RemoveMembers(final RemoveMembersRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateRemoveMembersAsync(final RemoveMembersRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/RemoveMembers", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the global title access policy
     * @param request SetGlobalPolicyRequest
     * @return Async Task will return SetGlobalPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetGlobalPolicyResponse>> SetGlobalPolicyAsync(final SetGlobalPolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetGlobalPolicyResponse>>() {
            public PlayFabResult<SetGlobalPolicyResponse> call() throws Exception {
                return privateSetGlobalPolicyAsync(request);
            }
        });
    }

    /**
     * Sets the global title access policy
     * @param request SetGlobalPolicyRequest
     * @return SetGlobalPolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetGlobalPolicyResponse> SetGlobalPolicy(final SetGlobalPolicyRequest request) {
        FutureTask<PlayFabResult<SetGlobalPolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<SetGlobalPolicyResponse>>() {
            public PlayFabResult<SetGlobalPolicyResponse> call() throws Exception {
                return privateSetGlobalPolicyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Sets the global title access policy */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetGlobalPolicyResponse> privateSetGlobalPolicyAsync(final SetGlobalPolicyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Profile/SetGlobalPolicy", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetGlobalPolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetGlobalPolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetGlobalPolicyResponse>>(){}.getType());
        SetGlobalPolicyResponse result = resultData.data;

        PlayFabResult<SetGlobalPolicyResponse> pfResult = new PlayFabResult<SetGlobalPolicyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets objects on an entity's profile.
     * @param request SetObjectsRequest
     * @return Async Task will return SetObjectsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetObjectsResponse>> SetObjectsAsync(final SetObjectsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetObjectsResponse>>() {
            public PlayFabResult<SetObjectsResponse> call() throws Exception {
                return privateSetObjectsAsync(request);
            }
        });
    }

    /**
     * Sets objects on an entity's profile.
     * @param request SetObjectsRequest
     * @return SetObjectsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetObjectsResponse> SetObjects(final SetObjectsRequest request) {
        FutureTask<PlayFabResult<SetObjectsResponse>> task = new FutureTask(new Callable<PlayFabResult<SetObjectsResponse>>() {
            public PlayFabResult<SetObjectsResponse> call() throws Exception {
                return privateSetObjectsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Sets objects on an entity's profile. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetObjectsResponse> privateSetObjectsAsync(final SetObjectsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Object/SetObjects", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetObjectsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetObjectsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetObjectsResponse>>(){}.getType());
        SetObjectsResponse result = resultData.data;

        PlayFabResult<SetObjectsResponse> pfResult = new PlayFabResult<SetObjectsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the profiles access policy
     * @param request SetEntityProfilePolicyRequest
     * @return Async Task will return SetEntityProfilePolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetEntityProfilePolicyResponse>> SetProfilePolicyAsync(final SetEntityProfilePolicyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetEntityProfilePolicyResponse>>() {
            public PlayFabResult<SetEntityProfilePolicyResponse> call() throws Exception {
                return privateSetProfilePolicyAsync(request);
            }
        });
    }

    /**
     * Sets the profiles access policy
     * @param request SetEntityProfilePolicyRequest
     * @return SetEntityProfilePolicyResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetEntityProfilePolicyResponse> SetProfilePolicy(final SetEntityProfilePolicyRequest request) {
        FutureTask<PlayFabResult<SetEntityProfilePolicyResponse>> task = new FutureTask(new Callable<PlayFabResult<SetEntityProfilePolicyResponse>>() {
            public PlayFabResult<SetEntityProfilePolicyResponse> call() throws Exception {
                return privateSetProfilePolicyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Sets the profiles access policy */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetEntityProfilePolicyResponse> privateSetProfilePolicyAsync(final SetEntityProfilePolicyRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Profile/SetProfilePolicy", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetEntityProfilePolicyResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetEntityProfilePolicyResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetEntityProfilePolicyResponse>>(){}.getType());
        SetEntityProfilePolicyResponse result = resultData.data;

        PlayFabResult<SetEntityProfilePolicyResponse> pfResult = new PlayFabResult<SetEntityProfilePolicyResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Unblocks a list of entities from joining a group
     * @param request UnblockEntityRequest
     * @return Async Task will return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<EmptyResult>> UnblockEntityAsync(final UnblockEntityRequest request) {
        return new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
                return privateUnblockEntityAsync(request);
            }
        });
    }

    /**
     * Unblocks a list of entities from joining a group
     * @param request UnblockEntityRequest
     * @return EmptyResult
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<EmptyResult> UnblockEntity(final UnblockEntityRequest request) {
        FutureTask<PlayFabResult<EmptyResult>> task = new FutureTask(new Callable<PlayFabResult<EmptyResult>>() {
            public PlayFabResult<EmptyResult> call() throws Exception {
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
    private static PlayFabResult<EmptyResult> privateUnblockEntityAsync(final UnblockEntityRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/UnblockEntity", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<EmptyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<EmptyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<EmptyResult>>(){}.getType());
        EmptyResult result = resultData.data;

        PlayFabResult<EmptyResult> pfResult = new PlayFabResult<EmptyResult>();
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/UpdateGroup", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Group/UpdateRole", request, "X-EntityToken", PlayFabSettings.EntityToken);
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

    /**
     * Write batches of entity based events to PlayStream.
     * @param request WriteEventsRequest
     * @return Async Task will return WriteEventsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<WriteEventsResponse>> WriteEventsAsync(final WriteEventsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<WriteEventsResponse>>() {
            public PlayFabResult<WriteEventsResponse> call() throws Exception {
                return privateWriteEventsAsync(request);
            }
        });
    }

    /**
     * Write batches of entity based events to PlayStream.
     * @param request WriteEventsRequest
     * @return WriteEventsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<WriteEventsResponse> WriteEvents(final WriteEventsRequest request) {
        FutureTask<PlayFabResult<WriteEventsResponse>> task = new FutureTask(new Callable<PlayFabResult<WriteEventsResponse>>() {
            public PlayFabResult<WriteEventsResponse> call() throws Exception {
                return privateWriteEventsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }

    /** Write batches of entity based events to PlayStream. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<WriteEventsResponse> privateWriteEventsAsync(final WriteEventsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Event/WriteEvents", request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<WriteEventsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<WriteEventsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<WriteEventsResponse>>(){}.getType());
        WriteEventsResponse result = resultData.data;

        PlayFabResult<WriteEventsResponse> pfResult = new PlayFabResult<WriteEventsResponse>();
        pfResult.Result = result;
        return pfResult;
    }
}
