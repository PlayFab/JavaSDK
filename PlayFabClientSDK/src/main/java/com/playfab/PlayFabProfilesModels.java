package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabProfilesModels {

    public static enum EffectType {
        Allow,
        Deny
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

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://api.playfab.com/docs/tutorials/entities/entitytypes */
        public String Type;
        
    }

    public static class EntityLineage {
        /** The Character Id of the associated entity. */
        public String CharacterId;
        /** The Group Id of the associated entity. */
        public String GroupId;
        /** The Master Player Account Id of the associated entity. */
        public String MasterPlayerAccountId;
        /** The Namespace Id of the associated entity. */
        public String NamespaceId;
        /** The Title Id of the associated entity. */
        public String TitleId;
        /** The Title Player Account Id of the associated entity. */
        public String TitlePlayerAccountId;
        
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
        /** Avatar URL for the entity. */
        public String AvatarUrl;
        /** The creation time of this profile in UTC. */
        public Date Created;
        /**
         * The display name of the entity. This field may serve different purposes for different entity types. i.e.: for a title
         * player account it could represent the display name of the player, whereas on a character it could be character's name.
         */
        public String DisplayName;
        /** The entity id and type. */
        public EntityKey Entity;
        /** The chain of responsibility for this entity. Use Lineage. */
        public String EntityChain;
        /** The files on this profile. */
        public Map<String,EntityProfileFileMetadata> Files;
        /** The language on this profile. */
        public String Language;
        /** The lineage of this profile. */
        public EntityLineage Lineage;
        /** The objects on this profile. */
        public Map<String,EntityDataObject> Objects;
        /**
         * The permissions that govern access to this entity profile and its properties. Only includes permissions set on this
         * profile, not global statements from titles and namespaces.
         */
        public ArrayList<EntityPermissionStatement> Permissions;
        /** The statistics on this profile. */
        public Map<String,EntityStatisticValue> Statistics;
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

    public static class EntityStatisticChildValue {
        /** Child name value, if child statistic */
        public String ChildName;
        /** Child statistic metadata */
        public String Metadata;
        /** Child statistic value */
        public Integer Value;
        
    }

    public static class EntityStatisticValue {
        /** Child statistic values */
        public Map<String,EntityStatisticChildValue> ChildStatistics;
        /** Statistic metadata */
        public String Metadata;
        /** Statistic name */
        public String Name;
        /** Statistic value */
        public Integer Value;
        /** Statistic version */
        public Integer Version;
        
    }

    /**
     * Given an entity type and entity identifier will retrieve the profile from the entity store. If the profile being
     * retrieved is the caller's, then the read operation is consistent, if not it is an inconsistent read. An inconsistent
     * read means that we do not guarantee all committed writes have occurred before reading the profile, allowing for a stale
     * read. If consistency is important the Version Number on the result can be used to compare which version of the profile
     * any reader has.
     */
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

    /**
     * Given a set of entity types and entity identifiers will retrieve all readable profiles properties for the caller.
     * Profiles that the caller is not allowed to read will silently not be included in the results.
     */
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

    /**
     * Retrieves the title access policy that is used before the profile's policy is inspected during a request. If never
     * customized this will return the default starter policy built by PlayFab.
     */
    public static class GetGlobalPolicyRequest {
        
    }

    public static class GetGlobalPolicyResponse {
        /** The permissions that govern access to all entities under this title or namespace. */
        public ArrayList<EntityPermissionStatement> Permissions;
        
    }

    public static enum OperationTypes {
        Created,
        Updated,
        Deleted,
        None
    }

    /**
     * This will set the access policy statements on the given entity profile. This is not additive, any existing statements
     * will be replaced with the statements in this request.
     */
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

    /**
     * Updates the title access policy that is used before the profile's policy is inspected during a request. Policies are
     * compiled and cached for several minutes so an update here may not be reflected in behavior for a short time.
     */
    public static class SetGlobalPolicyRequest {
        /** The permissions that govern access to all entities under this title or namespace. */
        public ArrayList<EntityPermissionStatement> Permissions;
        
    }

    public static class SetGlobalPolicyResponse {
        
    }

    /**
     * Given an entity profile, will update its language to the one passed in if the profile's version is equal to the one
     * passed in.
     */
    public static class SetProfileLanguageRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The expected version of a profile to perform this update on */
        public Integer ExpectedVersion;
        /** The language to set on the given entity. Deletes the profile's language if passed in a null string. */
        public String Language;
        
    }

    public static class SetProfileLanguageResponse {
        /** The type of operation that occured on the profile's language */
        public OperationTypes OperationResult;
        /** The updated version of the profile after the language update */
        public Integer VersionNumber;
        
    }

}
