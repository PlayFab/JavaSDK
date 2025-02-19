package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabAddonModels {

    @Deprecated
    public static class CreateOrUpdateAppleRequest {
        /** iOS App Bundle ID obtained after setting up your app in the App Store. */
        @Deprecated
        public String AppBundleId;
        /** iOS App Shared Secret obtained after setting up your app in the App Store. */
        @Deprecated
        public String AppSharedSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        @Deprecated
        public Boolean ErrorIfExists;
        /**
         * Ignore expiration date for identity tokens. Be aware that when set to true this can invalidate expired tokens in the
         * case where Apple rotates their signing keys.
         */
        @Deprecated
        public Boolean IgnoreExpirationDate;
        /** Require secure authentication only for this app. */
        @Deprecated
        public Boolean RequireSecureAuthentication;
        
    }

    @Deprecated
    public static class CreateOrUpdateAppleResponse {
        
    }

    @Deprecated
    public static class CreateOrUpdateFacebookInstantGamesRequest {
        /** Facebook App ID obtained after setting up your app in Facebook Instant Games. */
        @Deprecated
        public String AppID;
        /** Facebook App Secret obtained after setting up your app in Facebook Instant Games. */
        @Deprecated
        public String AppSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        @Deprecated
        public Boolean ErrorIfExists;
        
    }

    @Deprecated
    public static class CreateOrUpdateFacebookInstantGamesResponse {
        
    }

    @Deprecated
    public static class CreateOrUpdateFacebookRequest {
        /** Facebook App ID obtained after setting up your app in Facebook. */
        @Deprecated
        public String AppID;
        /** Facebook App Secret obtained after setting up your app in Facebook. */
        @Deprecated
        public String AppSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        @Deprecated
        public Boolean ErrorIfExists;
        /** Email address for purchase dispute notifications. */
        @Deprecated
        public String NotificationEmail;
        
    }

    @Deprecated
    public static class CreateOrUpdateFacebookResponse {
        
    }

    @Deprecated
    public static class CreateOrUpdateGoogleRequest {
        /**
         * Google App License Key obtained after setting up your app in the Google Play developer portal. Required if using Google
         * receipt validation.
         */
        @Deprecated
        public String AppLicenseKey;
        /**
         * Google App Package ID obtained after setting up your app in the Google Play developer portal. Required if using Google
         * receipt validation.
         */
        @Deprecated
        public String AppPackageID;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        @Deprecated
        public Boolean ErrorIfExists;
        /**
         * Google OAuth Client ID obtained through the Google Developer Console by creating a new set of "OAuth Client ID".
         * Required if using Google Authentication.
         */
        @Deprecated
        public String OAuthClientID;
        /**
         * Google OAuth Client Secret obtained through the Google Developer Console by creating a new set of "OAuth Client ID".
         * Required if using Google Authentication.
         */
        @Deprecated
        public String OAuthClientSecret;
        /**
         * Authorized Redirect Uri obtained through the Google Developer Console. This currently defaults to
         * https://oauth.playfab.com/oauth2/google. If you are authenticating players via browser, please update this to your own
         * domain.
         */
        @Deprecated
        public String OAuthCustomRedirectUri;
        /** Needed to enable pending purchase handling and subscription processing. */
        @Deprecated
        public String ServiceAccountKey;
        
    }

    @Deprecated
    public static class CreateOrUpdateGoogleResponse {
        
    }

    @Deprecated
    public static class CreateOrUpdateKongregateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        @Deprecated
        public Boolean ErrorIfExists;
        /** Kongregate Secret API Key obtained after setting up your game in your Kongregate developer account. */
        @Deprecated
        public String SecretAPIKey;
        
    }

    @Deprecated
    public static class CreateOrUpdateKongregateResponse {
        
    }

    @Deprecated
    public static class CreateOrUpdateNintendoRequest {
        /** Nintendo Switch Application ID, without the "0x" prefix. */
        @Deprecated
        public String ApplicationID;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** List of Nintendo Environments, currently supporting up to 4. Needs Catalog enabled. */
        @Deprecated
        public ArrayList<NintendoEnvironment> Environments;
        /** If an error should be returned if the addon already exists. */
        @Deprecated
        public Boolean ErrorIfExists;
        
    }

    @Deprecated
    public static class CreateOrUpdateNintendoResponse {
        
    }

    @Deprecated
    public static class CreateOrUpdatePSNRequest {
        /** Client ID obtained after setting up your game with Sony. This one is associated with the existing PS4 marketplace. */
        @Deprecated
        public String ClientID;
        /** Client secret obtained after setting up your game with Sony. This one is associated with the existing PS4 marketplace. */
        @Deprecated
        public String ClientSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        @Deprecated
        public Boolean ErrorIfExists;
        /**
         * Client ID obtained after setting up your game with Sony. This one is associated with the modern marketplace, which
         * includes PS5, cross-generation for PS4, and unified entitlements.
         */
        @Deprecated
        public String NextGenClientID;
        /**
         * Client secret obtained after setting up your game with Sony. This one is associated with the modern marketplace, which
         * includes PS5, cross-generation for PS4, and unified entitlements.
         */
        @Deprecated
        public String NextGenClientSecret;
        
    }

    @Deprecated
    public static class CreateOrUpdatePSNResponse {
        
    }

    @Deprecated
    public static class CreateOrUpdateSteamRequest {
        /** Application ID obtained after setting up your app in Valve's developer portal. */
        @Deprecated
        public String ApplicationId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Enforce usage of AzurePlayFab identity in user authentication tickets. */
        @Deprecated
        public Boolean EnforceServiceSpecificTickets;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        @Deprecated
        public Boolean ErrorIfExists;
        /** Sercet Key obtained after setting up your app in Valve's developer portal. */
        @Deprecated
        public String SecretKey;
        /** Use Steam Payments sandbox endpoint for test transactions. */
        @Deprecated
        public Boolean UseSandbox;
        
    }

    @Deprecated
    public static class CreateOrUpdateSteamResponse {
        
    }

    @Deprecated
    public static class CreateOrUpdateTwitchRequest {
        /** Client ID obtained after creating your Twitch developer account. */
        @Deprecated
        public String ClientID;
        /** Client Secret obtained after creating your Twitch developer account. */
        @Deprecated
        public String ClientSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        @Deprecated
        public Boolean ErrorIfExists;
        
    }

    @Deprecated
    public static class CreateOrUpdateTwitchResponse {
        
    }

    @Deprecated
    public static class DeleteAppleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeleteAppleResponse {
        
    }

    @Deprecated
    public static class DeleteFacebookInstantGamesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeleteFacebookInstantGamesResponse {
        
    }

    @Deprecated
    public static class DeleteFacebookRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeleteFacebookResponse {
        
    }

    @Deprecated
    public static class DeleteGoogleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeleteGoogleResponse {
        
    }

    @Deprecated
    public static class DeleteKongregateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeleteKongregateResponse {
        
    }

    @Deprecated
    public static class DeleteNintendoRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeleteNintendoResponse {
        
    }

    @Deprecated
    public static class DeletePSNRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeletePSNResponse {
        
    }

    @Deprecated
    public static class DeleteSteamRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeleteSteamResponse {
        
    }

    @Deprecated
    public static class DeleteTwitchRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeleteTwitchResponse {
        
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    @Deprecated
    public static class EntityKey {
        /** Unique ID of the entity. */
        @Deprecated
        public String Id;
        /** Entity type. See https://docs.microsoft.com/gaming/playfab/features/data/entities/available-built-in-entity-types */
        @Deprecated
        public String Type;
        
    }

    @Deprecated
    public static class GetAppleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetAppleResponse {
        /** iOS App Bundle ID obtained after setting up your app in the App Store. */
        @Deprecated
        public String AppBundleId;
        /** Addon status. */
        @Deprecated
        public Boolean Created;
        /** Ignore expiration date for identity tokens. */
        @Deprecated
        public Boolean IgnoreExpirationDate;
        /** Require secure authentication only for this app. */
        @Deprecated
        public Boolean RequireSecureAuthentication;
        
    }

    @Deprecated
    public static class GetFacebookInstantGamesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetFacebookInstantGamesResponse {
        /** Facebook App ID obtained after setting up your app in Facebook Instant Games. */
        @Deprecated
        public String AppID;
        /** Addon status. */
        @Deprecated
        public Boolean Created;
        
    }

    @Deprecated
    public static class GetFacebookRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetFacebookResponse {
        /** Facebook App ID obtained after setting up your app in Facebook. */
        @Deprecated
        public String AppID;
        /** Addon status. */
        @Deprecated
        public Boolean Created;
        /** Email address for purchase dispute notifications. */
        @Deprecated
        public String NotificationEmail;
        
    }

    @Deprecated
    public static class GetGoogleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetGoogleResponse {
        /**
         * Google App Package ID obtained after setting up your app in the Google Play developer portal. Required if using Google
         * receipt validation.
         */
        @Deprecated
        public String AppPackageID;
        /** Addon status. */
        @Deprecated
        public Boolean Created;
        /**
         * Google OAuth Client ID obtained through the Google Developer Console by creating a new set of "OAuth Client ID".
         * Required if using Google Authentication.
         */
        @Deprecated
        public String OAuthClientID;
        /**
         * Authorized Redirect Uri obtained through the Google Developer Console. This currently defaults to
         * https://oauth.playfab.com/oauth2/google. If you are authenticating players via browser, please update this to your own
         * domain.
         */
        @Deprecated
        public String OauthCustomRedirectUri;
        
    }

    @Deprecated
    public static class GetKongregateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetKongregateResponse {
        /** Addon status. */
        @Deprecated
        public Boolean Created;
        
    }

    @Deprecated
    public static class GetNintendoRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetNintendoResponse {
        /** Nintendo Switch Application ID, without the "0x" prefix. */
        @Deprecated
        public String ApplicationID;
        /** Addon status. */
        @Deprecated
        public Boolean Created;
        /** List of Nintendo Environments, currently supporting up to 4. */
        @Deprecated
        public ArrayList<NintendoEnvironment> Environments;
        
    }

    @Deprecated
    public static class GetPSNRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetPSNResponse {
        /** Client ID obtained after setting up your game with Sony. This one is associated with the existing PS4 marketplace. */
        @Deprecated
        public String ClientID;
        /** Addon status. */
        @Deprecated
        public Boolean Created;
        /**
         * Client ID obtained after setting up your game with Sony. This one is associated with the modern marketplace, which
         * includes PS5, cross-generation for PS4, and unified entitlements.
         */
        @Deprecated
        public String NextGenClientID;
        
    }

    @Deprecated
    public static class GetSteamRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetSteamResponse {
        /** Application ID obtained after setting up your game in Valve's developer portal. */
        @Deprecated
        public String ApplicationId;
        /** Addon status. */
        @Deprecated
        public Boolean Created;
        /** Enforce usage of AzurePlayFab identity in user authentication tickets. */
        @Deprecated
        public Boolean EnforceServiceSpecificTickets;
        /** Use Steam Payments sandbox endpoint for test transactions. */
        @Deprecated
        public Boolean UseSandbox;
        
    }

    @Deprecated
    public static class GetTwitchRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetTwitchResponse {
        /** Client ID obtained after creating your Twitch developer account. */
        @Deprecated
        public String ClientID;
        /** Addon status. */
        @Deprecated
        public Boolean Created;
        
    }

    @Deprecated
    public static class NintendoEnvironment {
        /** Client ID for the Nintendo Environment. */
        @Deprecated
        public String ClientID;
        /** Client Secret for the Nintendo Environment. */
        @Deprecated
        public String ClientSecret;
        /** ID for the Nintendo Environment. */
        @Deprecated
        public String ID;
        
    }

}
