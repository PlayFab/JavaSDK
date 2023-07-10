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
