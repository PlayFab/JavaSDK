package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabEventsModels {

    public static class CreateTelemetryKeyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** The name of the new key. Telemetry key names must be unique within the scope of the title. */
        public String KeyName;
        
    }

    public static class CreateTelemetryKeyResponse {
        /** Details about the newly created telemetry key. */
        public TelemetryKeyDetails NewKeyDetails;
        
    }

    public static class DataConnectionAzureBlobSettings {
        /** Name of the storage account. */
        public String AccountName;
        /** Name of the container. */
        public String ContainerName;
        /** Azure Entra Tenant Id. */
        public String TenantId;
        
    }

    public static class DataConnectionAzureDataExplorerSettings {
        /** The URI of the ADX cluster. */
        public String ClusterUri;
        /** The database to write to. */
        public String Database;
        /** The table to write to. */
        public String Table;
        
    }

    public static class DataConnectionDetails {
        /** Settings of the data connection. */
        public DataConnectionSettings ConnectionSettings;
        /** Whether or not the connection is currently active. */
        public Boolean IsActive;
        /** The name of the data connection. */
        public String Name;
        /** Current status of the data connection, if any. */
        public DataConnectionStatusDetails Status;
        /** The type of data connection. */
        public DataConnectionType Type;
        
    }

    public static enum DataConnectionErrorState {
        OK,
        Error
    }

    public static class DataConnectionFabricKQLSettings {
        /** The URI of the Fabric cluster. */
        public String ClusterUri;
        /** The database to write to. */
        public String Database;
        /** The table to write to. */
        public String Table;
        
    }

    public static class DataConnectionSettings {
        /** Settings if the type of connection is AzureBlobStorage. */
        public DataConnectionAzureBlobSettings AzureBlobSettings;
        /** Settings if the type of connection is AzureDataExplorer. */
        public DataConnectionAzureDataExplorerSettings AzureDataExplorerSettings;
        /** Settings if the type of connection is FabricKQL. */
        public DataConnectionFabricKQLSettings AzureFabricKQLSettings;
        
    }

    public static class DataConnectionStatusDetails {
        /** The name of the error affecting the data connection, if any. */
        public String Error;
        /** A description of the error affecting the data connection, if any. This may be empty for some errors. */
        public String ErrorMessage;
        /** The most recent time of the error affecting the data connection, if any. */
        public Date MostRecentErrorTime;
        /** Indicates if the connection is in a normal state or error state. */
        public DataConnectionErrorState State;
        
    }

    public static enum DataConnectionType {
        AzureBlobStorage,
        AzureDataExplorer,
        FabricKQL
    }

    public static class DeleteDataConnectionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the data connection to delete. */
        public String Name;
        
    }

    public static class DeleteDataConnectionResponse {
        /** Indicates whether or not the connection was deleted as part of the request. */
        public Boolean WasDeleted;
        
    }

    public static class DeleteTelemetryKeyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** The name of the key to delete. */
        public String KeyName;
        
    }

    public static class DeleteTelemetryKeyResponse {
        /** Indicates whether or not the key was deleted. If false, no key with that name existed. */
        public Boolean WasKeyDeleted;
        
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://docs.microsoft.com/gaming/playfab/features/data/entities/available-built-in-entity-types */
        public String Type;
        
    }

    public static class EventContents {
        /**
         * The optional custom tags associated with the event (e.g. build number, external trace identifiers, etc.). Before an
         * event is written, this collection and the base request custom tags will be merged, but not overriden. This enables the
         * caller to specify static tags and per event tags.
         */
        public Map<String,String> CustomTags;
        /** Entity associated with the event. If null, the event will apply to the calling entity. */
        public EntityKey Entity;
        /** The namespace in which the event is defined. Allowed namespaces can vary by API. */
        public String EventNamespace;
        /** The name of this event. */
        public String Name;
        /**
         * The original unique identifier associated with this event before it was posted to PlayFab. The value might differ from
         * the EventId value, which is assigned when the event is received by the server.
         */
        public String OriginalId;
        /**
         * The time (in UTC) associated with this event when it occurred. If specified, this value is stored in the
         * OriginalTimestamp property of the PlayStream event.
         */
        public Date OriginalTimestamp;
        /** Arbitrary data associated with the event. Only one of Payload or PayloadJSON is allowed. */
        public Object Payload;
        /**
         * Arbitrary data associated with the event, represented as a JSON serialized string. Only one of Payload or PayloadJSON is
         * allowed.
         */
        public String PayloadJSON;
        
    }

    public static class GetDataConnectionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the data connection to retrieve. */
        public String Name;
        
    }

    public static class GetDataConnectionResponse {
        /** The details of the queried Data Connection. */
        public DataConnectionDetails DataConnection;
        
    }

    public static class GetTelemetryKeyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** The name of the key to retrieve. */
        public String KeyName;
        
    }

    public static class GetTelemetryKeyResponse {
        /** Details about the requested telemetry key. */
        public TelemetryKeyDetails KeyDetails;
        
    }

    public static class ListDataConnectionsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class ListDataConnectionsResponse {
        /** The list of existing Data Connections. */
        public ArrayList<DataConnectionDetails> DataConnections;
        
    }

    public static class ListTelemetryKeysRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class ListTelemetryKeysResponse {
        /** The telemetry keys configured for the title. */
        public ArrayList<TelemetryKeyDetails> KeyDetails;
        
    }

    public static class SetDataConnectionActiveRequest {
        /** Whether to set the data connection to active (true) or deactivated (false). */
        public Boolean Active;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the data connection to update. */
        public String Name;
        
    }

    public static class SetDataConnectionActiveResponse {
        /** The most current details about the data connection that was to be updated. */
        public DataConnectionDetails DataConnection;
        /**
         * Indicates whether or not the data connection was updated. If false, the data connection was already in the desired
         * state.
         */
        public Boolean WasUpdated;
        
    }

    public static class SetDataConnectionRequest {
        /** Settings of the data connection. */
        public DataConnectionSettings ConnectionSettings;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Whether or not the connection is currently active. */
        public Boolean IsActive;
        /** The name of the data connection to update or create. */
        public String Name;
        /** The type of data connection. */
        public DataConnectionType Type;
        
    }

    public static class SetDataConnectionResponse {
        /** The details of the Data Connection to be created or updated. */
        public DataConnectionDetails DataConnection;
        
    }

    public static class SetTelemetryKeyActiveRequest {
        /** Whether to set the key to active (true) or deactivated (false). */
        public Boolean Active;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** The name of the key to update. */
        public String KeyName;
        
    }

    public static class SetTelemetryKeyActiveResponse {
        /** The most current details about the telemetry key that was to be updated. */
        public TelemetryKeyDetails KeyDetails;
        /** Indicates whether or not the key was updated. If false, the key was already in the desired state. */
        public Boolean WasKeyUpdated;
        
    }

    public static class TelemetryKeyDetails {
        /** When the key was created. */
        public Date CreateTime;
        /** Whether or not the key is currently active. Deactivated keys cannot be used for telemetry ingestion. */
        public Boolean IsActive;
        /** The key that can be distributed to clients for use during telemetry ingestion. */
        public String KeyValue;
        /** When the key was last updated. */
        public Date LastUpdateTime;
        /** The name of the key. Telemetry key names are unique within the scope of the title. */
        public String Name;
        
    }

    public static class WriteEventsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The collection of events to write. Up to 200 events can be written per request. */
        public ArrayList<EventContents> Events;
        
    }

    public static class WriteEventsResponse {
        /**
         * The unique identifiers assigned by the server to the events, in the same order as the events in the request. Only
         * returned if FlushToPlayStream option is true.
         */
        public ArrayList<String> AssignedEventIds;
        
    }

}
