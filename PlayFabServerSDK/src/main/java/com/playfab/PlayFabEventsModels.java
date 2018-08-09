package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabEventsModels {

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

    public static class EventContents {
        /** Entity associated with the event */
        public EntityKey Entity;
        /** The namespace in which the event is defined. It must be prepended with 'com.playfab.events.' */
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
