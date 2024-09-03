package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabAddonModels {

    public static class CreateOrUpdateAppleRequest {
        /** iOS App Bundle ID obtained after setting up your app in the App Store. */
        public String AppBundleId;
        /** iOS App Shared Secret obtained after setting up your app in the App Store. */
        public String AppSharedSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        public Boolean ErrorIfExists;
        /**
         * Ignore expiration date for identity tokens. Be aware that when set to true this can invalidate expired tokens in the
         * case where Apple rotates their signing keys.
         */
        public Boolean IgnoreExpirationDate;
        /** Require secure authentication only for this app. */
        public Boolean RequireSecureAuthentication;
        
    }

    public static class CreateOrUpdateAppleResponse {
        
    }

    public static class CreateOrUpdateFacebookInstantGamesRequest {
        /** Facebook App ID obtained after setting up your app in Facebook Instant Games. */
        public String AppID;
        /** Facebook App Secret obtained after setting up your app in Facebook Instant Games. */
        public String AppSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        public Boolean ErrorIfExists;
        
    }

    public static class CreateOrUpdateFacebookInstantGamesResponse {
        
    }

    public static class CreateOrUpdateFacebookRequest {
        /** Facebook App ID obtained after setting up your app in Facebook. */
        public String AppID;
        /** Facebook App Secret obtained after setting up your app in Facebook. */
        public String AppSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        public Boolean ErrorIfExists;
        /** Email address for purchase dispute notifications. */
        public String NotificationEmail;
        
    }

    public static class CreateOrUpdateFacebookResponse {
        
    }

    public static class CreateOrUpdateGoogleRequest {
        /**
         * Google App License Key obtained after setting up your app in the Google Play developer portal. Required if using Google
         * receipt validation.
         */
        public String AppLicenseKey;
        /**
         * Google App Package ID obtained after setting up your app in the Google Play developer portal. Required if using Google
         * receipt validation.
         */
        public String AppPackageID;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        public Boolean ErrorIfExists;
        /**
         * Google OAuth Client ID obtained through the Google Developer Console by creating a new set of "OAuth Client ID".
         * Required if using Google Authentication.
         */
        public String OAuthClientID;
        /**
         * Google OAuth Client Secret obtained through the Google Developer Console by creating a new set of "OAuth Client ID".
         * Required if using Google Authentication.
         */
        public String OAuthClientSecret;
        /**
         * Authorized Redirect Uri obtained through the Google Developer Console. This currently defaults to
         * https://oauth.playfab.com/oauth2/google. If you are authenticating players via browser, please update this to your own
         * domain.
         */
        public String OAuthCustomRedirectUri;
        /** Needed to enable pending purchase handling and subscription processing. */
        public String ServiceAccountKey;
        
    }

    public static class CreateOrUpdateGoogleResponse {
        
    }

    public static class CreateOrUpdateKongregateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        public Boolean ErrorIfExists;
        /** Kongregate Secret API Key obtained after setting up your game in your Kongregate developer account. */
        public String SecretAPIKey;
        
    }

    public static class CreateOrUpdateKongregateResponse {
        
    }

    public static class CreateOrUpdateNintendoRequest {
        /** Nintendo Switch Application ID, without the "0x" prefix. */
        public String ApplicationID;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** List of Nintendo Environments, currently supporting up to 4. Needs Catalog enabled. */
        public ArrayList<NintendoEnvironment> Environments;
        /** If an error should be returned if the addon already exists. */
        public Boolean ErrorIfExists;
        
    }

    public static class CreateOrUpdateNintendoResponse {
        
    }

    public static class CreateOrUpdatePSNRequest {
        /** Client ID obtained after setting up your game with Sony. This one is associated with the existing PS4 marketplace. */
        public String ClientID;
        /** Client secret obtained after setting up your game with Sony. This one is associated with the existing PS4 marketplace. */
        public String ClientSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        public Boolean ErrorIfExists;
        /**
         * Client ID obtained after setting up your game with Sony. This one is associated with the modern marketplace, which
         * includes PS5, cross-generation for PS4, and unified entitlements.
         */
        public String NextGenClientID;
        /**
         * Client secret obtained after setting up your game with Sony. This one is associated with the modern marketplace, which
         * includes PS5, cross-generation for PS4, and unified entitlements.
         */
        public String NextGenClientSecret;
        
    }

    public static class CreateOrUpdatePSNResponse {
        
    }

    public static class CreateOrUpdateSteamRequest {
        /** Application ID obtained after setting up your app in Valve's developer portal. */
        public String ApplicationId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Enforce usage of AzurePlayFab identity in user authentication tickets. */
        public Boolean EnforceServiceSpecificTickets;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        public Boolean ErrorIfExists;
        /** Sercet Key obtained after setting up your app in Valve's developer portal. */
        public String SecretKey;
        /** Use Steam Payments sandbox endpoint for test transactions. */
        public Boolean UseSandbox;
        
    }

    public static class CreateOrUpdateSteamResponse {
        
    }

    public static class CreateOrUpdateTwitchRequest {
        /** Client ID obtained after creating your Twitch developer account. */
        public String ClientID;
        /** Client Secret obtained after creating your Twitch developer account. */
        public String ClientSecret;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** If an error should be returned if the addon already exists. */
        public Boolean ErrorIfExists;
        
    }

    public static class CreateOrUpdateTwitchResponse {
        
    }

    public static class DeleteAppleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class DeleteAppleResponse {
        
    }

    public static class DeleteFacebookInstantGamesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class DeleteFacebookInstantGamesResponse {
        
    }

    public static class DeleteFacebookRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class DeleteFacebookResponse {
        
    }

    public static class DeleteGoogleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class DeleteGoogleResponse {
        
    }

    public static class DeleteKongregateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class DeleteKongregateResponse {
        
    }

    public static class DeleteNintendoRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class DeleteNintendoResponse {
        
    }

    public static class DeletePSNRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class DeletePSNResponse {
        
    }

    public static class DeleteSteamRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class DeleteSteamResponse {
        
    }

    public static class DeleteTwitchRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class DeleteTwitchResponse {
        
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://docs.microsoft.com/gaming/playfab/features/data/entities/available-built-in-entity-types */
        public String Type;
        
    }

    public static class GetAppleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetAppleResponse {
        /** iOS App Bundle ID obtained after setting up your app in the App Store. */
        public String AppBundleId;
        /** Addon status. */
        public Boolean Created;
        /** Ignore expiration date for identity tokens. */
        public Boolean IgnoreExpirationDate;
        /** Require secure authentication only for this app. */
        public Boolean RequireSecureAuthentication;
        
    }

    public static class GetFacebookInstantGamesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetFacebookInstantGamesResponse {
        /** Facebook App ID obtained after setting up your app in Facebook Instant Games. */
        public String AppID;
        /** Addon status. */
        public Boolean Created;
        
    }

    public static class GetFacebookRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetFacebookResponse {
        /** Facebook App ID obtained after setting up your app in Facebook. */
        public String AppID;
        /** Addon status. */
        public Boolean Created;
        /** Email address for purchase dispute notifications. */
        public String NotificationEmail;
        
    }

    public static class GetGoogleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetGoogleResponse {
        /**
         * Google App Package ID obtained after setting up your app in the Google Play developer portal. Required if using Google
         * receipt validation.
         */
        public String AppPackageID;
        /** Addon status. */
        public Boolean Created;
        /**
         * Google OAuth Client ID obtained through the Google Developer Console by creating a new set of "OAuth Client ID".
         * Required if using Google Authentication.
         */
        public String OAuthClientID;
        /**
         * Authorized Redirect Uri obtained through the Google Developer Console. This currently defaults to
         * https://oauth.playfab.com/oauth2/google. If you are authenticating players via browser, please update this to your own
         * domain.
         */
        public String OauthCustomRedirectUri;
        
    }

    public static class GetKongregateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetKongregateResponse {
        /** Addon status. */
        public Boolean Created;
        
    }

    public static class GetNintendoRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetNintendoResponse {
        /** Nintendo Switch Application ID, without the "0x" prefix. */
        public String ApplicationID;
        /** Addon status. */
        public Boolean Created;
        /** List of Nintendo Environments, currently supporting up to 4. */
        public ArrayList<NintendoEnvironment> Environments;
        
    }

    public static class GetPSNRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetPSNResponse {
        /** Client ID obtained after setting up your game with Sony. This one is associated with the existing PS4 marketplace. */
        public String ClientID;
        /** Addon status. */
        public Boolean Created;
        /**
         * Client ID obtained after setting up your game with Sony. This one is associated with the modern marketplace, which
         * includes PS5, cross-generation for PS4, and unified entitlements.
         */
        public String NextGenClientID;
        
    }

    public static class GetSteamRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetSteamResponse {
        /** Application ID obtained after setting up your game in Valve's developer portal. */
        public String ApplicationId;
        /** Addon status. */
        public Boolean Created;
        /** Enforce usage of AzurePlayFab identity in user authentication tickets. */
        public Boolean EnforceServiceSpecificTickets;
        /** Use Steam Payments sandbox endpoint for test transactions. */
        public Boolean UseSandbox;
        
    }

    public static class GetTwitchRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetTwitchResponse {
        /** Client ID obtained after creating your Twitch developer account. */
        public String ClientID;
        /** Addon status. */
        public Boolean Created;
        
    }

    public static class NintendoEnvironment {
        /** Client ID for the Nintendo Environment. */
        public String ClientID;
        /** Client Secret for the Nintendo Environment. */
        public String ClientSecret;
        /** ID for the Nintendo Environment. */
        public String ID;
        
    }

}
