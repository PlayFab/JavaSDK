package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabEventsModels {

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://api.playfab.com/docs/tutorials/entities/entitytypes */
        public String Type;
        
    }

    public static class EventContents {
        /** Entity associated with the event. If null, the event will apply to the calling entity. */
        public EntityKey Entity;
        /** The namespace in which the event is defined. It must begin with 'com.playfab.events.' */
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

    public static class WriteEventsRequest {
        /** Collection of events to write to PlayStream. */
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
