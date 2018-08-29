package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabAuthenticationModels {

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://api.playfab.com/docs/tutorials/entities/entitytypes */
        public String Type;
        
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
