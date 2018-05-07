package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabEntityModels {

    public static class AbortFileUploadsRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** Names of the files to have their pending uploads aborted. */
        public ArrayList<String> FileNames;
        /**
         * The expected version of the profile, if set and doesn't match the current version of the profile the operation will not
         * be performed.
         */
        public Integer ProfileVersion;
        
    }

    public static class AbortFileUploadsResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** The current version of the profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        
    }

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

    public static class DeleteFilesRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** Names of the files to be deleted. */
        public ArrayList<String> FileNames;
        /**
         * The expected version of the profile, if set and doesn't match the current version of the profile the operation will not
         * be performed.
         */
        public Integer ProfileVersion;
        
    }

    public static class DeleteFilesResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** The current version of the profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        
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

    public static enum EffectType {
        Allow,
        Deny
    }

    public static class EmptyResult {
        
    }

    /** An entity object and its associated meta data. */
    public static class EntityDataObject {
        /** Un-escaped JSON object, if DataAsObject is true. */
        public Object DataObject;
        /** Escaped string JSON body of the object, if DataAsObject is default or false. */
        public String EscapedDataObject;
        /** Name of this object. */
        public String ObjectName;
        
    }

    /** Entity identifier class that contains both the ID and type. */
    public static class EntityKey {
        /** Entity profile ID. */
        public String Id;
        /** Entity type. Optional to be used but one of EntityType or EntityTypeString must be set. */
        public EntityTypes Type;
        /** Entity type. Optional to be used but one of EntityType or EntityTypeString must be set. */
        public String TypeString;
        
    }

    public static class EntityMemberRole {
        /** The list of members in the role */
        public ArrayList<EntityWithLineage> Members;
        /** The ID of the role. */
        public String RoleId;
        /** The name of the role */
        public String RoleName;
        
    }

    public static class EntityPermissionStatement {
        /** The action this statement effects. May be 'Read', 'Write' or '*' for both read and write. */
        public String Action;
        /** A comment about the statement. Intended solely for bookkeeping and debugging. */
        public String Comment;
        /** Additional conditions to be applied for entity resources. */
        public Object Condition;
        /** The effect this statement will have. It may be either Allow or Deny */
        public EffectType Effect;
        /** The principal this statement will effect. */
        public Object Principal;
        /** The resource this statements effects. Similar to 'pfrn:data--title![Title ID]/Profile/*' */
        public String Resource;
        
    }

    public static class EntityProfileBody {
        /** The entity id and type. */
        public EntityKey Entity;
        /**
         * The chain of responsibility for this entity. This is a representation of 'ownership'. It is constructed using the
         * following formats (replace '[ID]' with the unique identifier for the given entity): Namespace: 'namespace![Namespace
         * ID]' Title: 'title![Namespace ID]/[Title ID]' Master Player Account: 'master_player_account![Namespace
         * ID]/[MasterPlayerAccount ID]' Title Player Account: 'title_player_account![Namespace ID]/[Title ID]/[MasterPlayerAccount
         * ID]/[TitlePlayerAccount ID]' Character: 'character![Namespace ID]/[Title ID]/[MasterPlayerAccount
         * ID]/[TitlePlayerAccount ID]/[Character ID]'
         */
        public String EntityChain;
        /** The files on this profile. */
        public Map<String,EntityProfileFileMetadata> Files;
        /** The objects on this profile. */
        public Map<String,EntityDataObject> Objects;
        /**
         * The permissions that govern access to this entity profile and its properties. Only includes permissions set on this
         * profile, not global statements from titles and namespaces.
         */
        public ArrayList<EntityPermissionStatement> Permissions;
        /**
         * The version number of the profile in persistent storage at the time of the read. Used for optional optimistic
         * concurrency during update.
         */
        public Integer VersionNumber;
        
    }

    /** An entity file's meta data. To get a download URL call File/GetFiles API. */
    public static class EntityProfileFileMetadata {
        /** Checksum value for the file */
        public String Checksum;
        /** Name of the file */
        public String FileName;
        /** Last UTC time the file was modified */
        public Date LastModified;
        /** Storage service's reported byte count */
        public Integer Size;
        
    }

    public static enum EntityTypes {
        title,
        master_player_account,
        title_player_account,
        character,
        group
    }

    /** Entity wrapper class that contains the entity key and the entities that make up the lineage of the entity. */
    public static class EntityWithLineage {
        /** The entity key for the specified entity */
        public EntityKey Key;
        /** Dictionary of entity keys for related entities. Dictionary key is entity type. */
        public Map<String,EntityKey> Lineage;
        
    }

    public static class FinalizeFileUploadsRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** Names of the files to be finalized. Restricted to a-Z, 0-9, '(', ')', '_', '-' and '.' */
        public ArrayList<String> FileNames;
        
    }

    public static class FinalizeFileUploadsResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** Collection of metadata for the entity's files */
        public Map<String,GetFileMetadata> Metadata;
        /** The current version of the profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        
    }

    public static class GetEntityProfileRequest {
        /**
         * Determines whether the objects will be returned as an escaped JSON string or as a un-escaped JSON object. Default is
         * JSON string.
         */
        public Boolean DataAsObject;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class GetEntityProfileResponse {
        /** Entity profile */
        public EntityProfileBody Profile;
        
    }

    public static class GetEntityProfilesRequest {
        /**
         * Determines whether the objects will be returned as an escaped JSON string or as a un-escaped JSON object. Default is
         * JSON string.
         */
        public Boolean DataAsObject;
        /** Entity keys of the profiles to load. Must be between 1 and 25 */
        public ArrayList<EntityKey> Entities;
        
    }

    public static class GetEntityProfilesResponse {
        /** Entity profiles */
        public ArrayList<EntityProfileBody> Profiles;
        
    }

    public static class GetEntityTokenRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class GetEntityTokenResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** The token used to set X-EntityToken for all entity based API calls. */
        public String EntityToken;
        /** The time the token will expire, if it is an expiring token, in UTC. */
        public Date TokenExpiration;
        
    }

    public static class GetFileMetadata {
        /** Checksum value for the file */
        public String Checksum;
        /** Download URL where the file can be retrieved */
        public String DownloadUrl;
        /** Name of the file */
        public String FileName;
        /** Last UTC time the file was modified */
        public Date LastModified;
        /** Storage service's reported byte count */
        public Integer Size;
        
    }

    public static class GetFilesRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class GetFilesResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** Collection of metadata for the entity's files */
        public Map<String,GetFileMetadata> Metadata;
        /** The current version of the profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        
    }

    public static class GetGlobalPolicyRequest {
        
    }

    public static class GetGlobalPolicyResponse {
        /** The permissions that govern access to all entities under this title or namespace. */
        public ArrayList<EntityPermissionStatement> Permissions;
        
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

    public static class GetObjectsRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * Determines whether the object will be returned as an escaped JSON string or as a un-escaped JSON object. Default is JSON
         * object.
         */
        public Boolean EscapeObject;
        
    }

    public static class GetObjectsResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** Requested objects that the calling entity has access to */
        public Map<String,ObjectResult> Objects;
        /** The current version of the profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        
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

    public static class InitiateFileUploadMetadata {
        /** Name of the file. */
        public String FileName;
        /** Location the data should be sent to via an HTTP PUT operation. */
        public String UploadUrl;
        
    }

    public static class InitiateFileUploadsRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** Names of the files to be set. Restricted to a-Z, 0-9, '(', ')', '_', '-' and '.' */
        public ArrayList<String> FileNames;
        /**
         * The expected version of the profile, if set and doesn't match the current version of the profile the operation will not
         * be performed.
         */
        public Integer ProfileVersion;
        
    }

    public static class InitiateFileUploadsResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** The current version of the profile, can be used for concurrency control during updates. */
        public Integer ProfileVersion;
        /** Collection of file names and upload urls */
        public ArrayList<InitiateFileUploadMetadata> UploadDetails;
        
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

    public static class ObjectResult {
        /** Un-escaped JSON object, if EscapeObject false or default. */
        public Object DataObject;
        /** Escaped string JSON body of the object, if EscapeObject is true. */
        public String EscapedDataObject;
        /** Name of the object. Restricted to a-Z, 0-9, '(', ')', '_', '-' and '.' */
        public String ObjectName;
        
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

    public static class SetEntityProfilePolicyRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The statements to include in the access policy. */
        public ArrayList<EntityPermissionStatement> Statements;
        
    }

    public static class SetEntityProfilePolicyResponse {
        /**
         * The permissions that govern access to this entity profile and its properties. Only includes permissions set on this
         * profile, not global statements from titles and namespaces.
         */
        public ArrayList<EntityPermissionStatement> Permissions;
        
    }

    public static class SetGlobalPolicyRequest {
        /** The permissions that govern access to all entities under this title or namespace. */
        public ArrayList<EntityPermissionStatement> Permissions;
        
    }

    public static class SetGlobalPolicyResponse {
        
    }

    public static class SetObject {
        /**
         * Body of the object to be saved. If empty and DeleteObject is true object will be deleted if it exists, or no operation
         * will occur if it does not exist. Only one of Object or EscapedDataObject fields may be used.
         */
        public Object DataObject;
        /** Flag to indicate that this object should be deleted. Both DataObject and EscapedDataObject must not be set as well. */
        public Boolean DeleteObject;
        /**
         * Body of the object to be saved as an escaped JSON string. If empty and DeleteObject is true object will be deleted if it
         * exists, or no operation will occur if it does not exist. Only one of DataObject or EscapedDataObject fields may be used.
         */
        public String EscapedDataObject;
        /** Name of object. Restricted to a-Z, 0-9, '(', ')', '_', '-' and '.'. */
        public String ObjectName;
        
    }

    public static class SetObjectInfo {
        /** Name of the object */
        public String ObjectName;
        /** Optional reason to explain why the operation was the result that it was. */
        public String OperationReason;
        /** Indicates which operation was completed, either Created, Updated, Deleted or None. */
        public OperationTypes SetResult;
        
    }

    public static class SetObjectsRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * Optional field used for concurrency control. By specifying the previously returned value of ProfileVersion from
         * GetProfile API, you can ensure that the object set will only be performed if the profile has not been updated by any
         * other clients since the version you last loaded.
         */
        public Integer ExpectedProfileVersion;
        /** Collection of objects to set on the profile. */
        public ArrayList<SetObject> Objects;
        
    }

    public static class SetObjectsResponse {
        /** New version of the entity profile. */
        public Integer ProfileVersion;
        /** New version of the entity profile. */
        public ArrayList<SetObjectInfo> SetResults;
        
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
