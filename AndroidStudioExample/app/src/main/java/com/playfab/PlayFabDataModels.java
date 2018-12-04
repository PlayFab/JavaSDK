package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabDataModels {

    /** Aborts the pending upload of the requested files. */
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

    /** Deletes the requested files from the entity's profile. */
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

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://api.playfab.com/docs/tutorials/entities/entitytypes */
        public String Type;
        
    }

    /**
     * Finalizes the upload of the requested files. Verifies that the files have been successfully uploaded and moves the file
     * pointers from pending to live.
     */
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

    /**
     * Returns URLs that may be used to download the files for a profile for a limited length of time. Only returns files that
     * have been successfully uploaded, files that are still pending will either return the old value, if it exists, or
     * nothing.
     */
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

    /** Gets JSON objects from an entity profile and returns it. */
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

    /**
     * Returns URLs that may be used to upload the files for a profile 5 minutes. After using the upload calls
     * FinalizeFileUploads must be called to move the file status from pending to live.
     */
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

    /**
     * Sets JSON objects on the requested entity profile. May include a version number to be used to perform optimistic
     * concurrency operations during update. If the current version differs from the version in the request the request will be
     * ignored. If no version is set on the request then the value will always be updated if the values differ. Using the
     * version value does not guarantee a write though, ConcurrentEditError may still occur if multiple clients are attempting
     * to update the same profile.
     */
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
