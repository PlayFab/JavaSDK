package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabGroupsModels {

    public static class AcceptGroupApplicationRequest {
        /**
         * Optional. Type of the entity to accept as. If specified, must be the same entity as the claimant or an entity that is a
         * child of the claimant entity. Defaults to the claimant entity.
         */
        public EntityKey Entity;
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    public static class AcceptGroupInvitationRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    public static class AddMembersRequest {
        /** The identifier of the group */
        public EntityKey Group;
        /** List of entities to add to the group. Only entities of type title_player_account and character may be added to groups. */
        public ArrayList<EntityKey> Members;
        /**
         * Optional: The ID of the existing role to add the entities to. If this is not specified, the default member role for the
         * group will be used. Role IDs must be between 1 and 64 characters long.
         */
        public String RoleId;
        
    }

    public static class ApplyToGroupRequest {
        /** Optional, default true. Automatically accept an outstanding invitation if one exists instead of creating an application */
        public Boolean AutoAcceptOutstandingInvite;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    /** Describes an application to join a group */
    public static class ApplyToGroupResponse {
        /** Type of entity that requested membership */
        public EntityWithLineage Entity;
        /** When the application to join will expire and be deleted */
        public Date Expires;
        /** ID of the group that the entity requesting membership to */
        public EntityKey Group;
        
    }

    public static class BlockEntityRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    public static class ChangeMemberRoleRequest {
        /**
         * The ID of the role that the entities will become a member of. This must be an existing role. Role IDs must be between 1
         * and 64 characters long.
         */
        public String DestinationRoleId;
        /** The identifier of the group */
        public EntityKey Group;
        /**
         * List of entities to move between roles in the group. All entities in this list must be members of the group and origin
         * role.
         */
        public ArrayList<EntityKey> Members;
        /** The ID of the role that the entities currently are a member of. Role IDs must be between 1 and 64 characters long. */
        public String OriginRoleId;
        
    }

    public static class CreateGroupRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The name of the group. This is unique at the title level by default. */
        public String GroupName;
        
    }

    public static class CreateGroupResponse {
        /** The ID of the administrator role for the group. */
        public String AdminRoleId;
        /** The server date and time the group was created. */
        public Date Created;
        /** The identifier of the group */
        public EntityKey Group;
        /** The name of the group. */
        public String GroupName;
        /** The ID of the default member role for the group. */
        public String MemberRoleId;
        /** The current version of the profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        /** The list of roles and names that belong to the group. */
        public Map<String,String> Roles;
        
    }

    public static class CreateGroupRoleRequest {
        /** The identifier of the group */
        public EntityKey Group;
        /**
         * The ID of the role. This must be unique within the group and cannot be changed. Role IDs must be between 1 and 64
         * characters long.
         */
        public String RoleId;
        /**
         * The name of the role. This must be unique within the group and can be changed later. Role names must be between 1 and
         * 100 characters long
         */
        public String RoleName;
        
    }

    public static class CreateGroupRoleResponse {
        /** The current version of the group profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        /** ID for the role */
        public String RoleId;
        /** The name of the role */
        public String RoleName;
        
    }

    public static class DeleteGroupRequest {
        /** ID of the group or role to remove */
        public EntityKey Group;
        
    }

    public static class DeleteRoleRequest {
        /** The identifier of the group */
        public EntityKey Group;
        /** The ID of the role to delete. Role IDs must be between 1 and 64 characters long. */
        public String RoleId;
        
    }

    public static class EmptyResponse {
        
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://api.playfab.com/docs/tutorials/entities/entitytypes */
        public String Type;
        
    }

    public static class EntityMemberRole {
        /** The list of members in the role */
        public ArrayList<EntityWithLineage> Members;
        /** The ID of the role. */
        public String RoleId;
        /** The name of the role */
        public String RoleName;
        
    }

    /** Entity wrapper class that contains the entity key and the entities that make up the lineage of the entity. */
    public static class EntityWithLineage {
        /** The entity key for the specified entity */
        public EntityKey Key;
        /** Dictionary of entity keys for related entities. Dictionary key is entity type. */
        public Map<String,EntityKey> Lineage;
        
    }

    public static class GetGroupRequest {
        /** The identifier of the group */
        public EntityKey Group;
        /** The full name of the group */
        public String GroupName;
        
    }

    public static class GetGroupResponse {
        /** The ID of the administrator role for the group. */
        public String AdminRoleId;
        /** The server date and time the group was created. */
        public Date Created;
        /** The identifier of the group */
        public EntityKey Group;
        /** The name of the group. */
        public String GroupName;
        /** The ID of the default member role for the group. */
        public String MemberRoleId;
        /** The current version of the profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        /** The list of roles and names that belong to the group. */
        public Map<String,String> Roles;
        
    }

    /** Describes an application to join a group */
    public static class GroupApplication {
        /** Type of entity that requested membership */
        public EntityWithLineage Entity;
        /** When the application to join will expire and be deleted */
        public Date Expires;
        /** ID of the group that the entity requesting membership to */
        public EntityKey Group;
        
    }

    /** Describes an entity that is blocked from joining a group. */
    public static class GroupBlock {
        /** The entity that is blocked */
        public EntityWithLineage Entity;
        /** ID of the group that the entity is blocked from */
        public EntityKey Group;
        
    }

    /** Describes an invitation to a group. */
    public static class GroupInvitation {
        /** When the invitation will expire and be deleted */
        public Date Expires;
        /** The group that the entity invited to */
        public EntityKey Group;
        /** The entity that created the invitation */
        public EntityWithLineage InvitedByEntity;
        /** The entity that is invited */
        public EntityWithLineage InvitedEntity;
        /** ID of the role in the group to assign the user to. */
        public String RoleId;
        
    }

    /** Describes a group role */
    public static class GroupRole {
        /** ID for the role */
        public String RoleId;
        /** The name of the role */
        public String RoleName;
        
    }

    /** Describes a group and the roles that it contains */
    public static class GroupWithRoles {
        /** ID for the group */
        public EntityKey Group;
        /** The name of the group */
        public String GroupName;
        /** The current version of the profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        /** The list of roles within the group */
        public ArrayList<GroupRole> Roles;
        
    }

    public static class InviteToGroupRequest {
        /** Optional, default true. Automatically accept an application if one exists instead of creating an invitation */
        public Boolean AutoAcceptOutstandingApplication;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The identifier of the group */
        public EntityKey Group;
        /**
         * Optional. ID of an existing a role in the group to assign the user to. The group's default member role is used if this
         * is not specified. Role IDs must be between 1 and 64 characters long.
         */
        public String RoleId;
        
    }

    /** Describes an invitation to a group. */
    public static class InviteToGroupResponse {
        /** When the invitation will expire and be deleted */
        public Date Expires;
        /** The group that the entity invited to */
        public EntityKey Group;
        /** The entity that created the invitation */
        public EntityWithLineage InvitedByEntity;
        /** The entity that is invited */
        public EntityWithLineage InvitedEntity;
        /** ID of the role in the group to assign the user to. */
        public String RoleId;
        
    }

    public static class IsMemberRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The identifier of the group */
        public EntityKey Group;
        /**
         * Optional: ID of the role to check membership of. Defaults to any role (that is, check to see if the entity is a member
         * of the group in any capacity) if not specified.
         */
        public String RoleId;
        
    }

    public static class IsMemberResponse {
        /** A value indicating whether or not the entity is a member. */
        public Boolean IsMember;
        
    }

    public static class ListGroupApplicationsRequest {
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    public static class ListGroupApplicationsResponse {
        /** The requested list of applications to the group. */
        public ArrayList<GroupApplication> Applications;
        
    }

    public static class ListGroupBlocksRequest {
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    public static class ListGroupBlocksResponse {
        /** The requested list blocked entities. */
        public ArrayList<GroupBlock> BlockedEntities;
        
    }

    public static class ListGroupInvitationsRequest {
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    public static class ListGroupInvitationsResponse {
        /** The requested list of group invitations. */
        public ArrayList<GroupInvitation> Invitations;
        
    }

    public static class ListGroupMembersRequest {
        /** ID of the group to list the members and roles for */
        public EntityKey Group;
        
    }

    public static class ListGroupMembersResponse {
        /** The requested list of roles and member entity IDs. */
        public ArrayList<EntityMemberRole> Members;
        
    }

    public static class ListMembershipOpportunitiesRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class ListMembershipOpportunitiesResponse {
        /** The requested list of group applications. */
        public ArrayList<GroupApplication> Applications;
        /** The requested list of group invitations. */
        public ArrayList<GroupInvitation> Invitations;
        
    }

    public static class ListMembershipRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class ListMembershipResponse {
        /** The list of groups */
        public ArrayList<GroupWithRoles> Groups;
        
    }

    public static enum OperationTypes {
        Created,
        Updated,
        Deleted,
        None
    }

    public static class RemoveGroupApplicationRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    public static class RemoveGroupInvitationRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    public static class RemoveMembersRequest {
        /** The identifier of the group */
        public EntityKey Group;
        /** List of entities to remove */
        public ArrayList<EntityKey> Members;
        /** The ID of the role to remove the entities from. */
        public String RoleId;
        
    }

    public static class UnblockEntityRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The identifier of the group */
        public EntityKey Group;
        
    }

    public static class UpdateGroupRequest {
        /** Optional: the ID of an existing role to set as the new administrator role for the group */
        public String AdminRoleId;
        /**
         * Optional field used for concurrency control. By specifying the previously returned value of ProfileVersion from the
         * GetGroup API, you can ensure that the group data update will only be performed if the group has not been updated by any
         * other clients since the version you last loaded.
         */
        public Integer ExpectedProfileVersion;
        /** The identifier of the group */
        public EntityKey Group;
        /** Optional: the new name of the group */
        public String GroupName;
        /** Optional: the ID of an existing role to set as the new member role for the group */
        public String MemberRoleId;
        
    }

    public static class UpdateGroupResponse {
        /** Optional reason to explain why the operation was the result that it was. */
        public String OperationReason;
        /** New version of the group data. */
        public Integer ProfileVersion;
        /** Indicates which operation was completed, either Created, Updated, Deleted or None. */
        public OperationTypes SetResult;
        
    }

    public static class UpdateGroupRoleRequest {
        /**
         * Optional field used for concurrency control. By specifying the previously returned value of ProfileVersion from the
         * GetGroup API, you can ensure that the group data update will only be performed if the group has not been updated by any
         * other clients since the version you last loaded.
         */
        public Integer ExpectedProfileVersion;
        /** The identifier of the group */
        public EntityKey Group;
        /** ID of the role to update. Role IDs must be between 1 and 64 characters long. */
        public String RoleId;
        /** The new name of the role */
        public String RoleName;
        
    }

    public static class UpdateGroupRoleResponse {
        /** Optional reason to explain why the operation was the result that it was. */
        public String OperationReason;
        /** New version of the role data. */
        public Integer ProfileVersion;
        /** Indicates which operation was completed, either Created, Updated, Deleted or None. */
        public OperationTypes SetResult;
        
    }

}
