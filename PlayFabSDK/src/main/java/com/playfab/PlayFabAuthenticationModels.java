package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabAuthenticationModels {

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://docs.microsoft.com/gaming/playfab/features/data/entities/available-built-in-entity-types */
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

    public static enum LoginIdentityProvider {
        Unknown,
        PlayFab,
        Custom,
        GameCenter,
        GooglePlay,
        Steam,
        XBoxLive,
        PSN,
        Kongregate,
        Facebook,
        IOSDevice,
        AndroidDevice,
        Twitch,
        WindowsHello,
        GameServer,
        CustomServer,
        NintendoSwitch,
        FacebookInstantGames,
        OpenIdConnect,
        Apple,
        NintendoSwitchAccount
    }

    /** Given an entity token, validates that it hasn't exipired or been revoked and will return details of the owner. */
    public static class ValidateEntityTokenRequest {
        /** Client EntityToken */
        public String EntityToken;
        
    }

    public static class ValidateEntityTokenResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** The identity provider for this entity, for the given login */
        public LoginIdentityProvider IdentityProvider;
        /** The lineage of this profile. */
        public EntityLineage Lineage;
        
    }

}
