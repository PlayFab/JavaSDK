package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabDataModels {

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

    /** Entity identifier class that contains both the ID and type. */
    public static class EntityKey {
        /** Entity profile ID. */
        public String Id;
        /** Entity type. Optional to be used but one of EntityType or EntityTypeString must be set. */
        public EntityTypes Type;
        /** Entity type. Optional to be used but one of EntityType or EntityTypeString must be set. */
        public String TypeString;
        
    }

    public static enum EntityTypes {
        title,
        master_player_account,
        title_player_account,
        character,
        group,
        service
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

}
