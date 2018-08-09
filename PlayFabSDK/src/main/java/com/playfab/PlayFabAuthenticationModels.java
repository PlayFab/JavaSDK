package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabAuthenticationModels {

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

}
