package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabAuthenticationModels {

    public static class ActivateAPIKeyRequest {
        /** Unique identifier for the entity API key to activate. */
        public String APIKeyId;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class ActivateAPIKeyResponse {
        
    }

    public static class CreateAPIKeyDetails {
        /**
         * Whether the key is active for authentication. Inactive keys cannot be used to authenticate.Keys can be activated or
         * deactivate using the ActivateKey and DeactivateKey APIs.Deactivating a key is a way to verify that the key is not in use
         * before deleting it.
         */
        public Boolean Active;
        /** Unique identifier for the entity API key. Set in the "X - EntityAPIKeyId" in authentication requests. */
        public String APIKeyId;
        /**
         * Secret used to authenticate requests with the key. Set in the "X - EntityAPIKeyId" in authentication requests.The secret
         * value is returned only once in this response and cannot be retrieved afterward, either via API or in Game Manager.API
         * key secrets should be stored securely only on trusted servers and never distributed in code or configuration to
         * untrusted clients.
         */
        public String APIKeySecret;
        /** The time the API key was generated, in UTC. */
        public Date Created;
        
    }

    public static class CreateAPIKeyRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class CreateAPIKeyResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** The created API key */
        public CreateAPIKeyDetails Key;
        
    }

    public static class DeactivateAPIKeyRequest {
        /** Unique identifier for the entity API key to activate. */
        public String APIKeyId;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class DeactivateAPIKeyResponse {
        
    }

    public static class DeleteAPIKeyRequest {
        /** Unique identifier for the entity API key to delete. */
        public String APIKeyId;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class DeleteAPIKeyResponse {
        
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://api.playfab.com/docs/tutorials/entities/entitytypes */
        public String Type;
        
    }

    public static class GetAPIKeyDetails {
        /**
         * Whether the key is active for authentication. Inactive keys cannot be used to authenticate.Keys can be activated or
         * deactivate using the SetAPIActivation API.Deactivating a key is a way to verify that the key is not in use be before
         * deleting it.
         */
        public Boolean Active;
        /** Unique identifier for the entity API key. Set in the "X - EntityAPIKeyId" in authentication requests. */
        public String APIKeyId;
        /** The time the API key was generated, in UTC. */
        public Date Created;
        
    }

    public static class GetAPIKeysRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class GetAPIKeysResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** The API keys associated with the given entity. */
        public ArrayList<GetAPIKeyDetails> Keys;
        
    }

    /**
     * This API must be called with X-SecretKey, X-Authentication or X-EntityToken headers. An optional EntityKey may be
     * included to attempt to set the resulting EntityToken to a specific entity, however the entity must be a relation of the
     * caller, such as the master_player_account of a character. If sending X-EntityToken the account will be marked as freshly
     * logged in and will issue a new token. If using X-Authentication or X-EntityToken the header must still be valid and
     * cannot be expired or revoked.
     */
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
