package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabClientModels {

    public static class AcceptTradeRequest {
        /**
         * Items from the accepting player's inventory in exchange for the offered items in the trade. In the case of a gift, this
         * will be null.
         */
        public ArrayList<String> AcceptedInventoryInstanceIds;
        /** Player who opened the trade. */
        public String OfferingPlayerId;
        /** Trade identifier. */
        public String TradeId;
        
    }

    public static class AcceptTradeResponse {
        /** Details about trade which was just accepted. */
        public TradeInfo Trade;
        
    }

    public static class AdCampaignAttributionModel {
        /** UTC time stamp of attribution */
        public Date AttributedAt;
        /** Attribution campaign identifier */
        public String CampaignId;
        /** Attribution network name */
        public String Platform;
        
    }

    public static class AddFriendRequest {
        /** Email address of the user to attempt to add to the local user's friend list. */
        public String FriendEmail;
        /** PlayFab identifier of the user to attempt to add to the local user's friend list. */
        public String FriendPlayFabId;
        /** Title-specific display name of the user to attempt to add to the local user's friend list. */
        public String FriendTitleDisplayName;
        /** PlayFab username of the user to attempt to add to the local user's friend list. */
        public String FriendUsername;
        
    }

    public static class AddFriendResult {
        /** True if the friend request was processed successfully. */
        public Boolean Created;
        
    }

    public static class AddGenericIDRequest {
        /** Generic service identifier to add to the player account. */
        public GenericServiceId GenericId;
        
    }

    public static class AddGenericIDResult {
        
    }

    /**
     * This API adds a contact email to the player's profile. If the player's profile already contains a contact email, it will
     * update the contact email to the email address specified.
     */
    public static class AddOrUpdateContactEmailRequest {
        /** The new contact email to associate with the player. */
        public String EmailAddress;
        
    }

    public static class AddOrUpdateContactEmailResult {
        
    }

    public static class AddSharedGroupMembersRequest {
        /** An array of unique PlayFab assigned ID of the user on whom the operation will be performed. */
        public ArrayList<String> PlayFabIds;
        /** Unique identifier for the shared group. */
        public String SharedGroupId;
        
    }

    public static class AddSharedGroupMembersResult {
        
    }

    public static class AddUsernamePasswordRequest {
        /** User email address attached to their account */
        public String Email;
        /** Password for the PlayFab account (6-100 characters) */
        public String Password;
        /** PlayFab username for the account (3-20 characters) */
        public String Username;
        
    }

    /**
     * Each account must have a unique username and email address in the PlayFab service. Once created, the account may be
     * associated with additional accounts (Steam, Facebook, Game Center, etc.), allowing for added social network lists and
     * achievements systems. This can also be used to provide a recovery method if the user loses their original means of
     * access.
     */
    public static class AddUsernamePasswordResult {
        /** PlayFab unique user name. */
        public String Username;
        
    }

    /** This API must be enabled for use as an option in the game manager website. It is disabled by default. */
    public static class AddUserVirtualCurrencyRequest {
        /** Amount to be added to the user balance of the specified virtual currency. */
        public Integer Amount;
        /** Name of the virtual currency which is to be incremented. */
        public String VirtualCurrency;
        
    }

    /**
     * More information can be found on configuring your game for the Google Cloud Messaging service in the Google developer
     * documentation, here: http://developer.android.com/google/gcm/client.html. The steps to configure and send Push
     * Notifications is described in the PlayFab tutorials, here: https://api.playfab.com/docs/pushCrashCourse/.
     */
    public static class AndroidDevicePushNotificationRegistrationRequest {
        /** Message to display when confirming push notification. */
        public String ConfirmationMessage;
        /**
         * Registration ID provided by the Google Cloud Messaging service when the title registered to receive push notifications
         * (see the GCM documentation, here: http://developer.android.com/google/gcm/client.html).
         */
        public String DeviceToken;
        /** If true, send a test push message immediately after sucessful registration. Defaults to false. */
        public Boolean SendPushNotificationConfirmation;
        
    }

    public static class AndroidDevicePushNotificationRegistrationResult {
        
    }

    /**
     * If you have an ad attribution partner enabled, this will post an install to their service to track the device. It uses
     * the given device id to match based on clicks on ads.
     */
    public static class AttributeInstallRequest {
        /** The adid for this device. */
        public String Adid;
        /** The IdentifierForAdvertisers for iOS Devices. */
        public String Idfa;
        
    }

    public static class AttributeInstallResult {
        
    }

    public static class CancelTradeRequest {
        /** Trade identifier. */
        public String TradeId;
        
    }

    public static class CancelTradeResponse {
        /** Details about trade which was just canceled. */
        public TradeInfo Trade;
        
    }

    public static class CartItem {
        /** Description of the catalog item. */
        public String Description;
        /** Display name for the catalog item. */
        public String DisplayName;
        /** Class name to which catalog item belongs. */
        public String ItemClass;
        /** Unique identifier for the catalog item. */
        public String ItemId;
        /** Unique instance identifier for this catalog item. */
        public String ItemInstanceId;
        /** Cost of the catalog item for each applicable real world currency. */
        public Map<String,Long> RealCurrencyPrices;
        /** Amount of each applicable virtual currency which will be received as a result of purchasing this catalog item. */
        public Map<String,Long> VCAmount;
        /** Cost of the catalog item for each applicable virtual currency. */
        public Map<String,Long> VirtualCurrencyPrices;
        
    }

    /** A purchasable item from the item catalog */
    public static class CatalogItem implements Comparable<CatalogItem> {
        /**
         * defines the bundle properties for the item - bundles are items which contain other items, including random drop tables
         * and virtual currencies
         */
        public CatalogItemBundleInfo Bundle;
        /** if true, then an item instance of this type can be used to grant a character to a user. */
        public Boolean CanBecomeCharacter;
        /** catalog version for this item */
        public String CatalogVersion;
        /** defines the consumable properties (number of uses, timeout) for the item */
        public CatalogItemConsumableInfo Consumable;
        /**
         * defines the container properties for the item - what items it contains, including random drop tables and virtual
         * currencies, and what item (if any) is required to open it via the UnlockContainerItem API
         */
        public CatalogItemContainerInfo Container;
        /** game specific custom data */
        public String CustomData;
        /** text description of item, to show in-game */
        public String Description;
        /** text name for the item, to show in-game */
        public String DisplayName;
        /**
         * If the item has IsLImitedEdition set to true, and this is the first time this ItemId has been defined as a limited
         * edition item, this value determines the total number of instances to allocate for the title. Once this limit has been
         * reached, no more instances of this ItemId can be created, and attempts to purchase or grant it will return a Result of
         * false for that ItemId. If the item has already been defined to have a limited edition count, or if this value is less
         * than zero, it will be ignored.
         */
        public Integer InitialLimitedEditionCount;
        /** BETA: If true, then only a fixed number can ever be granted. */
        public Boolean IsLimitedEdition;
        /**
         * if true, then only one item instance of this type will exist and its remaininguses will be incremented instead.
         * RemainingUses will cap out at Int32.Max (2,147,483,647). All subsequent increases will be discarded
         */
        public Boolean IsStackable;
        /** if true, then an item instance of this type can be traded between players using the trading APIs */
        public Boolean IsTradable;
        /** class to which the item belongs */
        public String ItemClass;
        /** unique identifier for this item */
        public String ItemId;
        /**
         * URL to the item image. For Facebook purchase to display the image on the item purchase page, this must be set to an HTTP
         * URL.
         */
        public String ItemImageUrl;
        /** override prices for this item for specific currencies */
        public Map<String,Long> RealCurrencyPrices;
        /** list of item tags */
        @Unordered
        public ArrayList<String> Tags;
        /** price of this item in virtual currencies and "RM" (the base Real Money purchase price, in USD pennies) */
        public Map<String,Long> VirtualCurrencyPrices;
        
        public int compareTo(CatalogItem other) {
            if (other == null || other.ItemId == null) return 1;
            if (ItemId == null) return -1;
            return ItemId.compareTo(other.ItemId);
        }
    }

    public static class CatalogItemBundleInfo {
        /** unique ItemId values for all items which will be added to the player inventory when the bundle is added */
        @Unordered
        public ArrayList<String> BundledItems;
        /**
         * unique TableId values for all RandomResultTable objects which are part of the bundle (random tables will be resolved and
         * add the relevant items to the player inventory when the bundle is added)
         */
        @Unordered
        public ArrayList<String> BundledResultTables;
        /** virtual currency types and balances which will be added to the player inventory when the bundle is added */
        public Map<String,Long> BundledVirtualCurrencies;
        
    }

    public static class CatalogItemConsumableInfo {
        /** number of times this object can be used, after which it will be removed from the player inventory */
        public Long UsageCount;
        /**
         * duration in seconds for how long the item will remain in the player inventory - once elapsed, the item will be removed
         * (recommended minimum value is 5 seconds, as lower values can cause the item to expire before operations depending on
         * this item's details have completed)
         */
        public Long UsagePeriod;
        /**
         * all inventory item instances in the player inventory sharing a non-null UsagePeriodGroup have their UsagePeriod values
         * added together, and share the result - when that period has elapsed, all the items in the group will be removed
         */
        public String UsagePeriodGroup;
        
    }

    /**
     * Containers are inventory items that can hold other items defined in the catalog, as well as virtual currency, which is
     * added to the player inventory when the container is unlocked, using the UnlockContainerItem API. The items can be
     * anything defined in the catalog, as well as RandomResultTable objects which will be resolved when the container is
     * unlocked. Containers and their keys should be defined as Consumable (having a limited number of uses) in their catalog
     * defintiions, unless the intent is for the player to be able to re-use them infinitely.
     */
    public static class CatalogItemContainerInfo {
        /** unique ItemId values for all items which will be added to the player inventory, once the container has been unlocked */
        @Unordered
        public ArrayList<String> ItemContents;
        /**
         * ItemId for the catalog item used to unlock the container, if any (if not specified, a call to UnlockContainerItem will
         * open the container, adding the contents to the player inventory and currency balances)
         */
        public String KeyItemId;
        /**
         * unique TableId values for all RandomResultTable objects which are part of the container (once unlocked, random tables
         * will be resolved and add the relevant items to the player inventory)
         */
        @Unordered
        public ArrayList<String> ResultTableContents;
        /** virtual currency types and balances which will be added to the player inventory when the container is unlocked */
        public Map<String,Long> VirtualCurrencyContents;
        
    }

    public static class CharacterInventory {
        /** The id of this character. */
        public String CharacterId;
        /** The inventory of this character. */
        public ArrayList<ItemInstance> Inventory;
        
    }

    public static class CharacterLeaderboardEntry {
        /** PlayFab unique identifier of the character that belongs to the user for this leaderboard entry. */
        public String CharacterId;
        /** Title-specific display name of the character for this leaderboard entry. */
        public String CharacterName;
        /** Name of the character class for this entry. */
        public String CharacterType;
        /** Title-specific display name of the user for this leaderboard entry. */
        public String DisplayName;
        /** PlayFab unique identifier of the user for this leaderboard entry. */
        public String PlayFabId;
        /** User's overall position in the leaderboard. */
        public Integer Position;
        /** Specific value of the user's statistic. */
        public Integer StatValue;
        
    }

    public static class CharacterResult {
        /** The id for this character on this player. */
        public String CharacterId;
        /** The name of this character. */
        public String CharacterName;
        /** The type-string that was given to this character on creation. */
        public String CharacterType;
        
    }

    public static enum CloudScriptRevisionOption {
        Live,
        Latest,
        Specific
    }

    /**
     * Collection filter to include and/or exclude collections with certain key-value pairs. The filter generates a collection
     * set defined by Includes rules and then remove collections that matches the Excludes rules. A collection is considered
     * matching a rule if the rule describes a subset of the collection.
     */
    public static class CollectionFilter {
        /** List of Exclude rules, with any of which if a collection matches, it is excluded by the filter. */
        public ArrayList<Container_Dictionary_String_String> Excludes;
        /**
         * List of Include rules, with any of which if a collection matches, it is included by the filter, unless it is excluded by
         * one of the Exclude rule
         */
        public ArrayList<Container_Dictionary_String_String> Includes;
        
    }

    /**
     * The final step in the purchasing process, this API finalizes the purchase with the payment provider, where applicable,
     * adding virtual goods to the player inventory (including random drop table resolution and recursive addition of bundled
     * items) and adjusting virtual currency balances for funds used or added. Note that this is a pull operation, and should
     * be polled regularly when a purchase is in progress. Please note that the processing time for inventory grants and
     * purchases increases fractionally the more items are in the inventory, and the more items are in the grant/purchase
     * operation.
     */
    public static class ConfirmPurchaseRequest {
        /** Purchase order identifier returned from StartPurchase. */
        public String OrderId;
        
    }

    /**
     * When the FailedByPaymentProvider error is returned, it's important to check the ProviderErrorCode, ProviderErrorMessage,
     * and ProviderErrorDetails to understand the specific reason the payment was rejected, as in some rare cases, this may
     * mean that the provider hasn't completed some operation required to finalize the purchase.
     */
    public static class ConfirmPurchaseResult {
        /** Array of items purchased. */
        public ArrayList<ItemInstance> Items;
        /** Purchase order identifier. */
        public String OrderId;
        /** Date and time of the purchase. */
        public Date PurchaseDate;
        
    }

    public static class ConsumeItemRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        /** Number of uses to consume from the item. */
        public Integer ConsumeCount;
        /** Unique instance identifier of the item to be consumed. */
        public String ItemInstanceId;
        
    }

    public static class ConsumeItemResult {
        /** Unique instance identifier of the item with uses consumed. */
        public String ItemInstanceId;
        /** Number of uses remaining on the item. */
        public Integer RemainingUses;
        
    }

    public static class ConsumePSNEntitlementsRequest {
        /** Which catalog to match granted entitlements against. If null, defaults to title default catalog */
        public String CatalogVersion;
        /** Id of the PSN service label to consume entitlements from */
        public Integer ServiceLabel;
        
    }

    public static class ConsumePSNEntitlementsResult {
        /** Array of items granted to the player as a result of consuming entitlements. */
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> ItemsGranted;
        
    }

    public static class ConsumeXboxEntitlementsRequest {
        /** Catalog version to use */
        public String CatalogVersion;
        /** Token provided by the Xbox Live SDK/XDK method GetTokenAndSignatureAsync("POST", "https://playfabapi.com", ""). */
        public String XboxToken;
        
    }

    public static class ConsumeXboxEntitlementsResult {
        /** Details for the items purchased. */
        public ArrayList<ItemInstance> Items;
        
    }

    public static class ContactEmailInfoModel {
        /** The email address */
        public String EmailAddress;
        /** The name of the email info data */
        public String Name;
        /** The verification status of the email */
        public EmailVerificationStatus VerificationStatus;
        
    }

    /** A data container */
    public static class Container_Dictionary_String_String {
        /** Content of data */
        public Map<String,String> Data;
        
    }

    public static enum ContinentCode {
        AF,
        AN,
        AS,
        EU,
        NA,
        OC,
        SA
    }

    public static enum CountryCode {
        AF,
        AX,
        AL,
        DZ,
        AS,
        AD,
        AO,
        AI,
        AQ,
        AG,
        AR,
        AM,
        AW,
        AU,
        AT,
        AZ,
        BS,
        BH,
        BD,
        BB,
        BY,
        BE,
        BZ,
        BJ,
        BM,
        BT,
        BO,
        BQ,
        BA,
        BW,
        BV,
        BR,
        IO,
        BN,
        BG,
        BF,
        BI,
        KH,
        CM,
        CA,
        CV,
        KY,
        CF,
        TD,
        CL,
        CN,
        CX,
        CC,
        CO,
        KM,
        CG,
        CD,
        CK,
        CR,
        CI,
        HR,
        CU,
        CW,
        CY,
        CZ,
        DK,
        DJ,
        DM,
        DO,
        EC,
        EG,
        SV,
        GQ,
        ER,
        EE,
        ET,
        FK,
        FO,
        FJ,
        FI,
        FR,
        GF,
        PF,
        TF,
        GA,
        GM,
        GE,
        DE,
        GH,
        GI,
        GR,
        GL,
        GD,
        GP,
        GU,
        GT,
        GG,
        GN,
        GW,
        GY,
        HT,
        HM,
        VA,
        HN,
        HK,
        HU,
        IS,
        IN,
        ID,
        IR,
        IQ,
        IE,
        IM,
        IL,
        IT,
        JM,
        JP,
        JE,
        JO,
        KZ,
        KE,
        KI,
        KP,
        KR,
        KW,
        KG,
        LA,
        LV,
        LB,
        LS,
        LR,
        LY,
        LI,
        LT,
        LU,
        MO,
        MK,
        MG,
        MW,
        MY,
        MV,
        ML,
        MT,
        MH,
        MQ,
        MR,
        MU,
        YT,
        MX,
        FM,
        MD,
        MC,
        MN,
        ME,
        MS,
        MA,
        MZ,
        MM,
        NA,
        NR,
        NP,
        NL,
        NC,
        NZ,
        NI,
        NE,
        NG,
        NU,
        NF,
        MP,
        NO,
        OM,
        PK,
        PW,
        PS,
        PA,
        PG,
        PY,
        PE,
        PH,
        PN,
        PL,
        PT,
        PR,
        QA,
        RE,
        RO,
        RU,
        RW,
        BL,
        SH,
        KN,
        LC,
        MF,
        PM,
        VC,
        WS,
        SM,
        ST,
        SA,
        SN,
        RS,
        SC,
        SL,
        SG,
        SX,
        SK,
        SI,
        SB,
        SO,
        ZA,
        GS,
        SS,
        ES,
        LK,
        SD,
        SR,
        SJ,
        SZ,
        SE,
        CH,
        SY,
        TW,
        TJ,
        TZ,
        TH,
        TL,
        TG,
        TK,
        TO,
        TT,
        TN,
        TR,
        TM,
        TC,
        TV,
        UG,
        UA,
        AE,
        GB,
        US,
        UM,
        UY,
        UZ,
        VU,
        VE,
        VN,
        VG,
        VI,
        WF,
        EH,
        YE,
        ZM,
        ZW
    }

    /**
     * If SharedGroupId is specified, the service will attempt to create a group with that identifier, and will return an error
     * if it is already in use. If no SharedGroupId is specified, a random identifier will be assigned.
     */
    public static class CreateSharedGroupRequest {
        /** Unique identifier for the shared group (a random identifier will be assigned, if one is not specified). */
        public String SharedGroupId;
        
    }

    public static class CreateSharedGroupResult {
        /** Unique identifier for the shared group. */
        public String SharedGroupId;
        
    }

    public static enum Currency {
        AED,
        AFN,
        ALL,
        AMD,
        ANG,
        AOA,
        ARS,
        AUD,
        AWG,
        AZN,
        BAM,
        BBD,
        BDT,
        BGN,
        BHD,
        BIF,
        BMD,
        BND,
        BOB,
        BRL,
        BSD,
        BTN,
        BWP,
        BYR,
        BZD,
        CAD,
        CDF,
        CHF,
        CLP,
        CNY,
        COP,
        CRC,
        CUC,
        CUP,
        CVE,
        CZK,
        DJF,
        DKK,
        DOP,
        DZD,
        EGP,
        ERN,
        ETB,
        EUR,
        FJD,
        FKP,
        GBP,
        GEL,
        GGP,
        GHS,
        GIP,
        GMD,
        GNF,
        GTQ,
        GYD,
        HKD,
        HNL,
        HRK,
        HTG,
        HUF,
        IDR,
        ILS,
        IMP,
        INR,
        IQD,
        IRR,
        ISK,
        JEP,
        JMD,
        JOD,
        JPY,
        KES,
        KGS,
        KHR,
        KMF,
        KPW,
        KRW,
        KWD,
        KYD,
        KZT,
        LAK,
        LBP,
        LKR,
        LRD,
        LSL,
        LYD,
        MAD,
        MDL,
        MGA,
        MKD,
        MMK,
        MNT,
        MOP,
        MRO,
        MUR,
        MVR,
        MWK,
        MXN,
        MYR,
        MZN,
        NAD,
        NGN,
        NIO,
        NOK,
        NPR,
        NZD,
        OMR,
        PAB,
        PEN,
        PGK,
        PHP,
        PKR,
        PLN,
        PYG,
        QAR,
        RON,
        RSD,
        RUB,
        RWF,
        SAR,
        SBD,
        SCR,
        SDG,
        SEK,
        SGD,
        SHP,
        SLL,
        SOS,
        SPL,
        SRD,
        STD,
        SVC,
        SYP,
        SZL,
        THB,
        TJS,
        TMT,
        TND,
        TOP,
        TRY,
        TTD,
        TVD,
        TWD,
        TZS,
        UAH,
        UGX,
        USD,
        UYU,
        UZS,
        VEF,
        VND,
        VUV,
        WST,
        XAF,
        XCD,
        XDR,
        XOF,
        XPF,
        YER,
        ZAR,
        ZMW,
        ZWD
    }

    public static class CurrentGamesRequest {
        /** Build to match against. */
        public String BuildVersion;
        /** Game mode to look for. */
        public String GameMode;
        /** Region to check for Game Server Instances. */
        public Region Region;
        /** Statistic name to find statistic-based matches. */
        public String StatisticName;
        /** Filter to include and/or exclude Game Server Instances associated with certain tags. */
        public CollectionFilter TagFilter;
        
    }

    public static class CurrentGamesResult {
        /** number of games running */
        public Integer GameCount;
        /** array of games found */
        public ArrayList<GameInfo> Games;
        /** total number of players across all servers */
        public Integer PlayerCount;
        
    }

    /** Any arbitrary information collected by the device */
    public static class DeviceInfoRequest {
        /** Information posted to the PlayStream Event. Currently arbitrary, and specific to the environment sending it. */
        public Map<String,Object> Info;
        
    }

    public static enum EmailVerificationStatus {
        Unverified,
        Pending,
        Confirmed
    }

    public static class EmptyResponse {
        
    }

    public static class EmptyResult {
        
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://api.playfab.com/docs/tutorials/entities/entitytypes */
        public String Type;
        
    }

    public static class EntityTokenResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        /** The token used to set X-EntityToken for all entity based API calls. */
        public String EntityToken;
        /** The time the token will expire, if it is an expiring token, in UTC. */
        public Date TokenExpiration;
        
    }

    public static class ExecuteCloudScriptRequest {
        /** The name of the CloudScript function to execute */
        public String FunctionName;
        /** Object that is passed in to the function as the first argument */
        public Object FunctionParameter;
        /**
         * Generate a 'player_executed_cloudscript' PlayStream event containing the results of the function execution and other
         * contextual information. This event will show up in the PlayStream debugger console for the player in Game Manager.
         */
        public Boolean GeneratePlayStreamEvent;
        /**
         * Option for which revision of the CloudScript to execute. 'Latest' executes the most recently created revision, 'Live'
         * executes the current live, published revision, and 'Specific' executes the specified revision. The default value is
         * 'Specific', if the SpeificRevision parameter is specified, otherwise it is 'Live'.
         */
        public CloudScriptRevisionOption RevisionSelection;
        /** The specivic revision to execute, when RevisionSelection is set to 'Specific' */
        public Integer SpecificRevision;
        
    }

    public static class ExecuteCloudScriptResult {
        /** Number of PlayFab API requests issued by the CloudScript function */
        public Integer APIRequestsIssued;
        /** Information about the error, if any, that occurred during execution */
        public ScriptExecutionError Error;
        public Double ExecutionTimeSeconds;
        /** The name of the function that executed */
        public String FunctionName;
        /** The object returned from the CloudScript function, if any */
        public Object FunctionResult;
        /**
         * Flag indicating if the FunctionResult was too large and was subsequently dropped from this event. This only occurs if
         * the total event size is larger than 350KB.
         */
        public Boolean FunctionResultTooLarge;
        /** Number of external HTTP requests issued by the CloudScript function */
        public Integer HttpRequestsIssued;
        /**
         * Entries logged during the function execution. These include both entries logged in the function code using log.info()
         * and log.error() and error entries for API and HTTP request failures.
         */
        public ArrayList<LogStatement> Logs;
        /**
         * Flag indicating if the logs were too large and were subsequently dropped from this event. This only occurs if the total
         * event size is larger than 350KB after the FunctionResult was removed.
         */
        public Boolean LogsTooLarge;
        public Long MemoryConsumedBytes;
        /**
         * Processor time consumed while executing the function. This does not include time spent waiting on API calls or HTTP
         * requests.
         */
        public Double ProcessorTimeSeconds;
        /** The revision of the CloudScript that executed */
        public Integer Revision;
        
    }

    public static class FacebookInstantGamesPlayFabIdPair {
        /** Unique Facebook Instant Games identifier for a user. */
        public String FacebookInstantGamesId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Facebook Instant Games identifier. */
        public String PlayFabId;
        
    }

    public static class FacebookPlayFabIdPair {
        /** Unique Facebook identifier for a user. */
        public String FacebookId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Facebook identifier. */
        public String PlayFabId;
        
    }

    public static class FriendInfo {
        /** Available Facebook information (if the user and PlayFab friend are also connected in Facebook). */
        public UserFacebookInfo FacebookInfo;
        /** PlayFab unique identifier for this friend. */
        public String FriendPlayFabId;
        /** Available Game Center information (if the user and PlayFab friend are also connected in Game Center). */
        public UserGameCenterInfo GameCenterInfo;
        /** The profile of the user, if requested. */
        public PlayerProfileModel Profile;
        /** Available PSN information, if the user and PlayFab friend are both connected to PSN. */
        public UserPsnInfo PSNInfo;
        /** Available Steam information (if the user and PlayFab friend are also connected in Steam). */
        public UserSteamInfo SteamInfo;
        /** Tags which have been associated with this friend. */
        public ArrayList<String> Tags;
        /** Title-specific display name for this friend. */
        public String TitleDisplayName;
        /** PlayFab unique username for this friend. */
        public String Username;
        /** Available Xbox information, if the user and PlayFab friend are both connected to Xbox Live. */
        public UserXboxInfo XboxInfo;
        
    }

    public static class GameCenterPlayFabIdPair {
        /** Unique Game Center identifier for a user. */
        public String GameCenterId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Game Center identifier. */
        public String PlayFabId;
        
    }

    public static class GameInfo {
        /** build version this server is running */
        public String BuildVersion;
        /** game mode this server is running */
        public String GameMode;
        /** game session custom data */
        public String GameServerData;
        /** game specific string denoting server configuration */
        public GameInstanceState GameServerStateEnum;
        /** last heartbeat of the game server instance, used in external game server provider mode */
        public Date LastHeartbeat;
        /** unique lobby identifier for this game server */
        public String LobbyID;
        /** maximum players this server can support */
        public Integer MaxPlayers;
        /** array of current player IDs on this server */
        public ArrayList<String> PlayerUserIds;
        /** region to which this server is associated */
        public Region Region;
        /** duration in seconds this server has been running */
        public Long RunTime;
        /** IPV4 address of the server */
        public String ServerIPV4Address;
        /** IPV6 address of the server */
        public String ServerIPV6Address;
        /** port number to use for non-http communications with the server */
        public Integer ServerPort;
        /** Public DNS name (if any) of the server */
        public String ServerPublicDNSName;
        /** stastic used to match this game in player statistic matchmaking */
        public String StatisticName;
        /** game session tags */
        public Map<String,String> Tags;
        
    }

    public static enum GameInstanceState {
        Open,
        Closed
    }

    public static class GameServerRegionsRequest {
        /** version of game server for which stats are being requested */
        public String BuildVersion;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    public static class GameServerRegionsResult {
        /** array of regions found matching the request parameters */
        public ArrayList<RegionInfo> Regions;
        
    }

    public static class GenericPlayFabIdPair {
        /** Unique generic service identifier for a user. */
        public GenericServiceId GenericId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the given generic identifier. */
        public String PlayFabId;
        
    }

    public static class GenericServiceId {
        /** Name of the service for which the player has a unique identifier. */
        public String ServiceName;
        /** Unique identifier of the player in that service. */
        public String UserId;
        
    }

    public static class GetAccountInfoRequest {
        /** User email address for the account to find (if no Username is specified). */
        public String Email;
        /**
         * Unique PlayFab identifier of the user whose info is being requested. Optional, defaults to the authenticated user if no
         * other lookup identifier set.
         */
        public String PlayFabId;
        /**
         * Title-specific username for the account to find (if no Email is set). Note that if the non-unique Title Display Names
         * option is enabled for the title, attempts to look up users by Title Display Name will always return AccountNotFound.
         */
        public String TitleDisplayName;
        /** PlayFab Username for the account to find (if no PlayFabId is specified). */
        public String Username;
        
    }

    /**
     * This API retrieves details regarding the player in the PlayFab service. Note that when this call is used to retrieve
     * data about another player (not the one signed into the local client), some data, such as Personally Identifying
     * Information (PII), will be omitted for privacy reasons or to comply with the requirements of the platform belongs to.
     * The user account returned will be based on the identifier provided in priority order: PlayFabId, Username, Email, then
     * TitleDisplayName. If no identifier is specified, the currently signed in user's information will be returned.
     */
    public static class GetAccountInfoResult {
        /** Account information for the local user. */
        public UserAccountInfo AccountInfo;
        
    }

    public static class GetCatalogItemsRequest {
        /** Which catalog is being requested. If null, uses the default catalog. */
        public String CatalogVersion;
        
    }

    /**
     * If CatalogVersion is not specified, only inventory items associated with the most recent version of the catalog will be
     * returned.
     */
    public static class GetCatalogItemsResult {
        /** Array of items which can be purchased. */
        @Unordered("ItemId")
        public ArrayList<CatalogItem> Catalog;
        
    }

    /**
     * Data is stored as JSON key-value pairs. If the Keys parameter is provided, the data object returned will only contain
     * the data specific to the indicated Keys. Otherwise, the full set of custom character data will be returned.
     */
    public static class GetCharacterDataRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        /**
         * The version that currently exists according to the caller. The call will return the data for all of the keys if the
         * version in the system is greater than this.
         */
        public Long IfChangedFromDataVersion;
        /** Specific keys to search for in the custom user data. */
        public ArrayList<String> Keys;
        /** Unique PlayFab identifier of the user to load data for. Optional, defaults to yourself if not set. */
        public String PlayFabId;
        
    }

    public static class GetCharacterDataResult {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        /** User specific data for this title. */
        public Map<String,UserDataRecord> Data;
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of
         * data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        
    }

    /**
     * All items currently in the character inventory will be returned, irrespective of how they were acquired (via purchasing,
     * grants, coupons, etc.). Items that are expired, fully consumed, or are no longer valid are not considered to be in the
     * user's current inventory, and so will not be not included. Also returns their virtual currency balances.
     */
    public static class GetCharacterInventoryRequest {
        /** Used to limit results to only those from a specific catalog version. */
        public String CatalogVersion;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        
    }

    public static class GetCharacterInventoryResult {
        /** Unique identifier of the character for this inventory. */
        public String CharacterId;
        /** Array of inventory items belonging to the character. */
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> Inventory;
        /** Array of virtual currency balance(s) belonging to the character. */
        public Map<String,Integer> VirtualCurrency;
        /** Array of remaining times and timestamps for virtual currencies. */
        public Map<String,VirtualCurrencyRechargeTime> VirtualCurrencyRechargeTimes;
        
    }

    public static class GetCharacterLeaderboardRequest {
        /** Optional character type on which to filter the leaderboard entries. */
        public String CharacterType;
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        public Integer MaxResultsCount;
        /** First entry in the leaderboard to be retrieved. */
        public Integer StartPosition;
        /** Unique identifier for the title-specific statistic for the leaderboard. */
        public String StatisticName;
        
    }

    /** Note that the Position of the character in the results is for the overall leaderboard. */
    public static class GetCharacterLeaderboardResult {
        /** Ordered list of leaderboard entries. */
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    public static class GetCharacterStatisticsRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        
    }

    /** In addition to being available for use by the title, the statistics are used for all leaderboard operations in PlayFab. */
    public static class GetCharacterStatisticsResult {
        /** The requested character statistics. */
        public Map<String,Integer> CharacterStatistics;
        
    }

    public static class GetContentDownloadUrlRequest {
        /** HTTP method to fetch item - GET or HEAD. Use HEAD when only fetching metadata. Default is GET. */
        public String HttpMethod;
        /** Key of the content item to fetch, usually formatted as a path, e.g. images/a.png */
        public String Key;
        /**
         * True to download through CDN. CDN provides higher download bandwidth and lower latency. However, if you want the latest,
         * non-cached version of the content during development, set this to false. Default is true.
         */
        public Boolean ThruCDN;
        
    }

    public static class GetContentDownloadUrlResult {
        /** URL for downloading content via HTTP GET or HEAD method. The URL will expire in approximately one hour. */
        public String URL;
        
    }

    public static class GetFriendLeaderboardAroundPlayerRequest {
        /** Indicates whether Facebook friends should be included in the response. Default is true. */
        public Boolean IncludeFacebookFriends;
        /** Indicates whether Steam service friends should be included in the response. Default is true. */
        public Boolean IncludeSteamFriends;
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        public Integer MaxResultsCount;
        /** PlayFab unique identifier of the user to center the leaderboard around. If null will center on the logged in user. */
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Statistic used to rank players for this leaderboard. */
        public String StatisticName;
        /** The version of the leaderboard to get. */
        public Integer Version;
        /** Xbox token if Xbox friends should be included. Requires Xbox be configured on PlayFab. */
        public String XboxToken;
        
    }

    /**
     * Note: When calling 'GetLeaderboardAround...' APIs, the position of the user defaults to 0 when the user does not have
     * the corresponding statistic.If Facebook friends are included, make sure the access token from previous LoginWithFacebook
     * call is still valid and not expired.
     */
    public static class GetFriendLeaderboardAroundPlayerResult {
        /** Ordered listing of users and their positions in the requested leaderboard. */
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        /** The time the next scheduled reset will occur. Null if the leaderboard does not reset on a schedule. */
        public Date NextReset;
        /** The version of the leaderboard returned. */
        public Integer Version;
        
    }

    public static class GetFriendLeaderboardRequest {
        /** Indicates whether Facebook friends should be included in the response. Default is true. */
        public Boolean IncludeFacebookFriends;
        /** Indicates whether Steam service friends should be included in the response. Default is true. */
        public Boolean IncludeSteamFriends;
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        public Integer MaxResultsCount;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Position in the leaderboard to start this listing (defaults to the first entry). */
        public Integer StartPosition;
        /** Statistic used to rank friends for this leaderboard. */
        public String StatisticName;
        /** The version of the leaderboard to get. */
        public Integer Version;
        /** Xbox token if Xbox friends should be included. Requires Xbox be configured on PlayFab. */
        public String XboxToken;
        
    }

    public static class GetFriendsListRequest {
        /** Indicates whether Facebook friends should be included in the response. Default is true. */
        public Boolean IncludeFacebookFriends;
        /** Indicates whether Steam service friends should be included in the response. Default is true. */
        public Boolean IncludeSteamFriends;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Xbox token if Xbox friends should be included. Requires Xbox be configured on PlayFab. */
        public String XboxToken;
        
    }

    /**
     * If any additional services are queried for the user's friends, those friends who also have a PlayFab account registered
     * for the title will be returned in the results. For Facebook, user has to have logged into the title's Facebook app
     * recently, and only friends who also plays this game will be included.
     */
    public static class GetFriendsListResult {
        /** Array of friends found. */
        public ArrayList<FriendInfo> Friends;
        
    }

    public static class GetLeaderboardAroundCharacterRequest {
        /** Unique PlayFab assigned ID for a specific character on which to center the leaderboard. */
        public String CharacterId;
        /** Optional character type on which to filter the leaderboard entries. */
        public String CharacterType;
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        public Integer MaxResultsCount;
        /** Unique identifier for the title-specific statistic for the leaderboard. */
        public String StatisticName;
        
    }

    /**
     * Note: When calling 'GetLeaderboardAround...' APIs, the position of the character defaults to 0 when the character does
     * not have the corresponding statistic.
     */
    public static class GetLeaderboardAroundCharacterResult {
        /** Ordered list of leaderboard entries. */
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    public static class GetLeaderboardAroundPlayerRequest {
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        public Integer MaxResultsCount;
        /** PlayFab unique identifier of the user to center the leaderboard around. If null will center on the logged in user. */
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Statistic used to rank players for this leaderboard. */
        public String StatisticName;
        /** The version of the leaderboard to get. */
        public Integer Version;
        
    }

    /**
     * Note: When calling 'GetLeaderboardAround...' APIs, the position of the user defaults to 0 when the user does not have
     * the corresponding statistic.
     */
    public static class GetLeaderboardAroundPlayerResult {
        /** Ordered listing of users and their positions in the requested leaderboard. */
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        /** The time the next scheduled reset will occur. Null if the leaderboard does not reset on a schedule. */
        public Date NextReset;
        /** The version of the leaderboard returned. */
        public Integer Version;
        
    }

    public static class GetLeaderboardForUsersCharactersRequest {
        /** Maximum number of entries to retrieve. */
        public Integer MaxResultsCount;
        /** Unique identifier for the title-specific statistic for the leaderboard. */
        public String StatisticName;
        
    }

    /** Note that the Position of the character in the results is for the overall leaderboard. */
    public static class GetLeaderboardForUsersCharactersResult {
        /** Ordered list of leaderboard entries. */
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    public static class GetLeaderboardRequest {
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        public Integer MaxResultsCount;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Position in the leaderboard to start this listing (defaults to the first entry). */
        public Integer StartPosition;
        /** Statistic used to rank players for this leaderboard. */
        public String StatisticName;
        /** The version of the leaderboard to get. */
        public Integer Version;
        
    }

    /** Note: the user's Position is relative to the overall leaderboard. */
    public static class GetLeaderboardResult {
        /** Ordered listing of users and their positions in the requested leaderboard. */
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        /** The time the next scheduled reset will occur. Null if the leaderboard does not reset on a schedule. */
        public Date NextReset;
        /** The version of the leaderboard returned. */
        public Integer Version;
        
    }

    public static class GetPaymentTokenRequest {
        /** The name of service to provide the payment token. Allowed Values are: xsolla */
        public String TokenProvider;
        
    }

    public static class GetPaymentTokenResult {
        /** PlayFab's purchase order identifier. */
        public String OrderId;
        /** The token from provider. */
        public String ProviderToken;
        
    }

    public static class GetPhotonAuthenticationTokenRequest {
        /** The Photon applicationId for the game you wish to log into. */
        public String PhotonApplicationId;
        
    }

    public static class GetPhotonAuthenticationTokenResult {
        /** The Photon authentication token for this game-session. */
        public String PhotonCustomAuthenticationToken;
        
    }

    public static class GetPlayerCombinedInfoRequest {
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** PlayFabId of the user whose data will be returned. If not filled included, we return the data for the calling player. */
        public String PlayFabId;
        
    }

    public static class GetPlayerCombinedInfoRequestParams {
        /** Whether to get character inventories. Defaults to false. */
        public Boolean GetCharacterInventories;
        /** Whether to get the list of characters. Defaults to false. */
        public Boolean GetCharacterList;
        /** Whether to get player profile. Defaults to false. Has no effect for a new player. */
        public Boolean GetPlayerProfile;
        /** Whether to get player statistics. Defaults to false. */
        public Boolean GetPlayerStatistics;
        /** Whether to get title data. Defaults to false. */
        public Boolean GetTitleData;
        /** Whether to get the player's account Info. Defaults to false */
        public Boolean GetUserAccountInfo;
        /** Whether to get the player's custom data. Defaults to false */
        public Boolean GetUserData;
        /** Whether to get the player's inventory. Defaults to false */
        public Boolean GetUserInventory;
        /** Whether to get the player's read only data. Defaults to false */
        public Boolean GetUserReadOnlyData;
        /** Whether to get the player's virtual currency balances. Defaults to false */
        public Boolean GetUserVirtualCurrency;
        /** Specific statistics to retrieve. Leave null to get all keys. Has no effect if GetPlayerStatistics is false */
        public ArrayList<String> PlayerStatisticNames;
        /** Specifies the properties to return from the player profile. Defaults to returning the player's display name. */
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Specific keys to search for in the custom data. Leave null to get all keys. Has no effect if GetTitleData is false */
        public ArrayList<String> TitleDataKeys;
        /** Specific keys to search for in the custom data. Leave null to get all keys. Has no effect if GetUserData is false */
        public ArrayList<String> UserDataKeys;
        /**
         * Specific keys to search for in the custom data. Leave null to get all keys. Has no effect if GetUserReadOnlyData is
         * false
         */
        public ArrayList<String> UserReadOnlyDataKeys;
        
    }

    /**
     * Returns whatever info is requested in the response for the user. If no user is explicitly requested this defaults to the
     * authenticated user. If the user is the same as the requester, PII (like email address, facebook id) is returned if
     * available. Otherwise, only public information is returned. All parameters default to false.
     */
    public static class GetPlayerCombinedInfoResult {
        /** Results for requested info. */
        public GetPlayerCombinedInfoResultPayload InfoResultPayload;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        public String PlayFabId;
        
    }

    public static class GetPlayerCombinedInfoResultPayload {
        /** Account information for the user. This is always retrieved. */
        public UserAccountInfo AccountInfo;
        /** Inventories for each character for the user. */
        public ArrayList<CharacterInventory> CharacterInventories;
        /** List of characters for the user. */
        public ArrayList<CharacterResult> CharacterList;
        /**
         * The profile of the players. This profile is not guaranteed to be up-to-date. For a new player, this profile will not
         * exist.
         */
        public PlayerProfileModel PlayerProfile;
        /** List of statistics for this player. */
        public ArrayList<StatisticValue> PlayerStatistics;
        /** Title data for this title. */
        public Map<String,String> TitleData;
        /** User specific custom data. */
        public Map<String,UserDataRecord> UserData;
        /** The version of the UserData that was returned. */
        public Long UserDataVersion;
        /** Array of inventory items in the user's current inventory. */
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> UserInventory;
        /** User specific read-only data. */
        public Map<String,UserDataRecord> UserReadOnlyData;
        /** The version of the Read-Only UserData that was returned. */
        public Long UserReadOnlyDataVersion;
        /** Dictionary of virtual currency balance(s) belonging to the user. */
        public Map<String,Integer> UserVirtualCurrency;
        /** Dictionary of remaining times and timestamps for virtual currencies. */
        public Map<String,VirtualCurrencyRechargeTime> UserVirtualCurrencyRechargeTimes;
        
    }

    /**
     * This API allows for access to details regarding a user in the PlayFab service, usually for purposes of customer support.
     * Note that data returned may be Personally Identifying Information (PII), such as email address, and so care should be
     * taken in how this data is stored and managed. Since this call will always return the relevant information for users who
     * have accessed the title, the recommendation is to not store this data locally.
     */
    public static class GetPlayerProfileRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        
    }

    public static class GetPlayerProfileResult {
        /**
         * The profile of the player. This profile is not guaranteed to be up-to-date. For a new player, this profile will not
         * exist.
         */
        public PlayerProfileModel PlayerProfile;
        
    }

    public static class GetPlayerSegmentsRequest {
        
    }

    public static class GetPlayerSegmentsResult {
        /** Array of segments the requested player currently belongs to. */
        public ArrayList<GetSegmentResult> Segments;
        
    }

    public static class GetPlayerStatisticsRequest {
        /** statistics to return (current version will be returned for each) */
        public ArrayList<String> StatisticNames;
        /**
         * statistics to return, if StatisticNames is not set (only statistics which have a version matching that provided will be
         * returned)
         */
        public ArrayList<StatisticNameVersion> StatisticNameVersions;
        
    }

    /** In addition to being available for use by the title, the statistics are used for all leaderboard operations in PlayFab. */
    public static class GetPlayerStatisticsResult {
        /** User statistics for the requested user. */
        public ArrayList<StatisticValue> Statistics;
        
    }

    public static class GetPlayerStatisticVersionsRequest {
        /** unique name of the statistic */
        public String StatisticName;
        
    }

    public static class GetPlayerStatisticVersionsResult {
        /** version change history of the statistic */
        public ArrayList<PlayerStatisticVersion> StatisticVersions;
        
    }

    /**
     * This API will return a list of canonical tags which includes both namespace and tag's name. If namespace is not
     * provided, the result is a list of all canonical tags. TagName can be used for segmentation and Namespace is limited to
     * 128 characters.
     */
    public static class GetPlayerTagsRequest {
        /** Optional namespace to filter results by */
        public String Namespace;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        public String PlayFabId;
        
    }

    public static class GetPlayerTagsResult {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        public String PlayFabId;
        /** Canonical tags (including namespace and tag's name) for the requested user */
        public ArrayList<String> Tags;
        
    }

    public static class GetPlayerTradesRequest {
        /** Returns only trades with the given status. If null, returns all trades. */
        public TradeStatus StatusFilter;
        
    }

    public static class GetPlayerTradesResponse {
        /** History of trades which this player has accepted. */
        public ArrayList<TradeInfo> AcceptedTrades;
        /** The trades for this player which are currently available to be accepted. */
        public ArrayList<TradeInfo> OpenedTrades;
        
    }

    public static class GetPlayFabIDsFromFacebookIDsRequest {
        /** Array of unique Facebook identifiers for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> FacebookIDs;
        
    }

    /** For Facebook identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromFacebookIDsResult {
        /** Mapping of Facebook identifiers to PlayFab identifiers. */
        public ArrayList<FacebookPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromFacebookInstantGamesIdsRequest {
        /** Array of unique Facebook Instant Games identifiers for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> FacebookInstantGamesIds;
        
    }

    /** For Facebook Instant Game identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromFacebookInstantGamesIdsResult {
        /** Mapping of Facebook Instant Games identifiers to PlayFab identifiers. */
        public ArrayList<FacebookInstantGamesPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromGameCenterIDsRequest {
        /** Array of unique Game Center identifiers (the Player Identifier) for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> GameCenterIDs;
        
    }

    /** For Game Center identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromGameCenterIDsResult {
        /** Mapping of Game Center identifiers to PlayFab identifiers. */
        public ArrayList<GameCenterPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromGenericIDsRequest {
        /**
         * Array of unique generic service identifiers for which the title needs to get PlayFab identifiers. Currently limited to a
         * maximum of 10 in a single request.
         */
        public ArrayList<GenericServiceId> GenericIDs;
        
    }

    /** For generic service identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromGenericIDsResult {
        /** Mapping of generic service identifiers to PlayFab identifiers. */
        public ArrayList<GenericPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromGoogleIDsRequest {
        /** Array of unique Google identifiers (Google+ user IDs) for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> GoogleIDs;
        
    }

    /** For Google identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromGoogleIDsResult {
        /** Mapping of Google identifiers to PlayFab identifiers. */
        public ArrayList<GooglePlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromKongregateIDsRequest {
        /** Array of unique Kongregate identifiers (Kongregate's user_id) for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> KongregateIDs;
        
    }

    /** For Kongregate identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromKongregateIDsResult {
        /** Mapping of Kongregate identifiers to PlayFab identifiers. */
        public ArrayList<KongregatePlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromNintendoSwitchDeviceIdsRequest {
        /** Array of unique Nintendo Switch Device identifiers for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> NintendoSwitchDeviceIds;
        
    }

    /** For Nintendo Switch identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromNintendoSwitchDeviceIdsResult {
        /** Mapping of Nintendo Switch Device identifiers to PlayFab identifiers. */
        public ArrayList<NintendoSwitchPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromPSNAccountIDsRequest {
        /** Id of the PSN issuer environment. If null, defaults to 256 (production) */
        public Integer IssuerId;
        /** Array of unique PlayStation Network identifiers for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> PSNAccountIDs;
        
    }

    /** For PlayStation Network identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromPSNAccountIDsResult {
        /** Mapping of PlayStation Network identifiers to PlayFab identifiers. */
        public ArrayList<PSNAccountPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromSteamIDsRequest {
        /** Array of unique Steam identifiers (Steam profile IDs) for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> SteamStringIDs;
        
    }

    /** For Steam identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromSteamIDsResult {
        /** Mapping of Steam identifiers to PlayFab identifiers. */
        public ArrayList<SteamPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromTwitchIDsRequest {
        /** Array of unique Twitch identifiers (Twitch's _id) for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> TwitchIds;
        
    }

    /** For Twitch identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromTwitchIDsResult {
        /** Mapping of Twitch identifiers to PlayFab identifiers. */
        public ArrayList<TwitchPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromXboxLiveIDsRequest {
        /** The ID of Xbox Live sandbox. */
        public String Sandbox;
        /** Array of unique Xbox Live account identifiers for which the title needs to get PlayFab identifiers. */
        public ArrayList<String> XboxLiveAccountIDs;
        
    }

    /** For XboxLive identifiers which have not been linked to PlayFab accounts, null will be returned. */
    public static class GetPlayFabIDsFromXboxLiveIDsResult {
        /** Mapping of PlayStation Network identifiers to PlayFab identifiers. */
        public ArrayList<XboxLiveAccountPlayFabIdPair> Data;
        
    }

    /**
     * This API is designed to return publisher-specific values which can be read, but not written to, by the client. This data
     * is shared across all titles assigned to a particular publisher, and can be used for cross-game coordination. Only titles
     * assigned to a publisher can use this API. For more information email devrel@playfab.com. Note that there may up to a
     * minute delay in between updating title data and this API call returning the newest value.
     */
    public static class GetPublisherDataRequest {
        /** array of keys to get back data from the Publisher data blob, set by the admin tools */
        public ArrayList<String> Keys;
        
    }

    public static class GetPublisherDataResult {
        /** a dictionary object of key / value pairs */
        public Map<String,String> Data;
        
    }

    public static class GetPurchaseRequest {
        /** Purchase order identifier. */
        public String OrderId;
        
    }

    public static class GetPurchaseResult {
        /** Purchase order identifier. */
        public String OrderId;
        /** Payment provider used for transaction (If not VC) */
        public String PaymentProvider;
        /** Date and time of the purchase. */
        public Date PurchaseDate;
        /** Provider transaction ID (If not VC) */
        public String TransactionId;
        /** PlayFab transaction status */
        public String TransactionStatus;
        
    }

    public static class GetSegmentResult {
        /** Identifier of the segments AB Test, if it is attached to one. */
        public String ABTestParent;
        /** Unique identifier for this segment. */
        public String Id;
        /** Segment name. */
        public String Name;
        
    }

    public static class GetSharedGroupDataRequest {
        /** If true, return the list of all members of the shared group. */
        public Boolean GetMembers;
        /**
         * Specific keys to retrieve from the shared group (if not specified, all keys will be returned, while an empty array
         * indicates that no keys should be returned).
         */
        public ArrayList<String> Keys;
        /** Unique identifier for the shared group. */
        public String SharedGroupId;
        
    }

    public static class GetSharedGroupDataResult {
        /** Data for the requested keys. */
        public Map<String,SharedGroupDataRecord> Data;
        /** List of PlayFabId identifiers for the members of this group, if requested. */
        public ArrayList<String> Members;
        
    }

    /**
     * A store contains an array of references to items defined in one or more catalog versions of the game, along with the
     * prices for the item, in both real world and virtual currencies. These prices act as an override to any prices defined in
     * the catalog. In this way, the base definitions of the items may be defined in the catalog, with all associated
     * properties, while the pricing can be set for each store, as needed. This allows for subsets of goods to be defined for
     * different purposes (in order to simplify showing some, but not all catalog items to users, based upon different
     * characteristics), along with unique prices. Note that all prices defined in the catalog and store definitions for the
     * item are considered valid, and that a compromised client can be made to send a request for an item based upon any of
     * these definitions. If no price is specified in the store for an item, the price set in the catalog should be displayed
     * to the user.
     */
    public static class GetStoreItemsRequest {
        /** catalog version to store items from. Use default catalog version if null */
        public String CatalogVersion;
        /** Unqiue identifier for the store which is being requested. */
        public String StoreId;
        
    }

    public static class GetStoreItemsResult {
        /** The base catalog that this store is a part of. */
        public String CatalogVersion;
        /** Additional data about the store. */
        public StoreMarketingModel MarketingData;
        /** How the store was last updated (Admin or a third party). */
        public SourceType Source;
        /** Array of items which can be purchased from this store. */
        @Unordered("ItemId")
        public ArrayList<StoreItem> Store;
        /** The ID of this store. */
        public String StoreId;
        
    }

    /**
     * This query retrieves the current time from one of the servers in PlayFab. Please note that due to clock drift between
     * servers, there is a potential variance of up to 5 seconds.
     */
    public static class GetTimeRequest {
        
    }

    /** Time is always returned as Coordinated Universal Time (UTC). */
    public static class GetTimeResult {
        /** Current server time when the request was received, in UTC */
        public Date Time;
        
    }

    /**
     * This API is designed to return title specific values which can be read, but not written to, by the client. For example,
     * a developer could choose to store values which modify the user experience, such as enemy spawn rates, weapon strengths,
     * movement speeds, etc. This allows a developer to update the title without the need to create, test, and ship a new
     * build. Note that there may up to a minute delay in between updating title data and this API call returning the newest
     * value.
     */
    public static class GetTitleDataRequest {
        /** Specific keys to search for in the title data (leave null to get all keys) */
        public ArrayList<String> Keys;
        
    }

    public static class GetTitleDataResult {
        /** a dictionary object of key / value pairs */
        public Map<String,String> Data;
        
    }

    public static class GetTitleNewsRequest {
        /** Limits the results to the last n entries. Defaults to 10 if not set. */
        public Integer Count;
        
    }

    public static class GetTitleNewsResult {
        /** Array of news items. */
        public ArrayList<TitleNewsItem> News;
        
    }

    /**
     * An RSA CSP blob to be used to encrypt the payload of account creation requests when that API requires a signature
     * header. For example if Client/LoginWithCustomId requires signature headers but the player does not have an account yet
     * follow these steps: 1) Call Client/GetTitlePublicKey with one of the title's shared secrets. 2) Convert the Base64
     * encoded CSP blob to a byte array and create an RSA signing object. 3) Encrypt the UTF8 encoded JSON body of the
     * registration request and place the Base64 encoded result into the EncryptedRequest and with the TitleId field, all other
     * fields can be left empty when performing the API request. 4) Client receives authentication token as normal. Future
     * requests to LoginWithCustomId will require the X-PlayFab-Signature header.
     */
    public static class GetTitlePublicKeyRequest {
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        /** The shared secret key for this title */
        public String TitleSharedSecret;
        
    }

    public static class GetTitlePublicKeyResult {
        /** Base64 encoded RSA CSP byte array blob containing the title's public RSA key */
        public String RSAPublicKey;
        
    }

    public static class GetTradeStatusRequest {
        /** Player who opened trade. */
        public String OfferingPlayerId;
        /** Trade identifier as returned by OpenTradeOffer. */
        public String TradeId;
        
    }

    public static class GetTradeStatusResponse {
        /** Information about the requested trade. */
        public TradeInfo Trade;
        
    }

    /**
     * Data is stored as JSON key-value pairs. Every time the data is updated via any source, the version counter is
     * incremented. If the Version parameter is provided, then this call will only return data if the current version on the
     * system is greater than the value provided. If the Keys parameter is provided, the data object returned will only contain
     * the data specific to the indicated Keys. Otherwise, the full set of custom user data will be returned.
     */
    public static class GetUserDataRequest {
        /**
         * The version that currently exists according to the caller. The call will return the data for all of the keys if the
         * version in the system is greater than this.
         */
        public Long IfChangedFromDataVersion;
        /** List of unique keys to load from. */
        public ArrayList<String> Keys;
        /**
         * Unique PlayFab identifier of the user to load data for. Optional, defaults to yourself if not set. When specified to a
         * PlayFab id of another player, then this will only return public keys for that account.
         */
        public String PlayFabId;
        
    }

    public static class GetUserDataResult {
        /** User specific data for this title. */
        public Map<String,UserDataRecord> Data;
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of
         * data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        
    }

    public static class GetUserInventoryRequest {
        
    }

    /**
     * All items currently in the user inventory will be returned, irrespective of how they were acquired (via purchasing,
     * grants, coupons, etc.). Items that are expired, fully consumed, or are no longer valid are not considered to be in the
     * user's current inventory, and so will not be not included.
     */
    public static class GetUserInventoryResult {
        /** Array of inventory items belonging to the user. */
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> Inventory;
        /** Array of virtual currency balance(s) belonging to the user. */
        public Map<String,Integer> VirtualCurrency;
        /** Array of remaining times and timestamps for virtual currencies. */
        public Map<String,VirtualCurrencyRechargeTime> VirtualCurrencyRechargeTimes;
        
    }

    /** Requires the SHA256 hash of the user's public key. */
    public static class GetWindowsHelloChallengeRequest {
        /** SHA256 hash of the PublicKey generated by Windows Hello. */
        public String PublicKeyHint;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    public static class GetWindowsHelloChallengeResponse {
        /** Server generated challenge to be signed by the user. */
        public String Challenge;
        
    }

    public static class GooglePlayFabIdPair {
        /** Unique Google identifier for a user. */
        public String GoogleId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Google identifier. */
        public String PlayFabId;
        
    }

    /**
     * Grants a character to the user of the type specified by the item ID. The user must already have an instance of this item
     * in their inventory in order to allow character creation. This item can come from a purchase or grant, which must be done
     * before calling to create the character.
     */
    public static class GrantCharacterToUserRequest {
        /** Catalog version from which items are to be granted. */
        public String CatalogVersion;
        /** Non-unique display name of the character being granted (1-20 characters in length). */
        public String CharacterName;
        /**
         * Catalog item identifier of the item in the user's inventory that corresponds to the character in the catalog to be
         * created.
         */
        public String ItemId;
        
    }

    public static class GrantCharacterToUserResult {
        /** Unique identifier tagged to this character. */
        public String CharacterId;
        /** Type of character that was created. */
        public String CharacterType;
        /** Indicates whether this character was created successfully. */
        public Boolean Result;
        
    }

    /**
     * A unique instance of an item in a user's inventory. Note, to retrieve additional information for an item instance (such
     * as Tags, Description, or Custom Data that are set on the root catalog item), a call to GetCatalogItems is required. The
     * Item ID of the instance can then be matched to a catalog entry, which contains the additional information. Also note
     * that Custom Data is only set here from a call to UpdateUserInventoryItemCustomData.
     */
    public static class ItemInstance implements Comparable<ItemInstance> {
        /** Game specific comment associated with this instance when it was added to the user inventory. */
        public String Annotation;
        /** Array of unique items that were awarded when this catalog item was purchased. */
        public ArrayList<String> BundleContents;
        /**
         * Unique identifier for the parent inventory item, as defined in the catalog, for object which were added from a bundle or
         * container.
         */
        public String BundleParent;
        /** Catalog version for the inventory item, when this instance was created. */
        public String CatalogVersion;
        /** A set of custom key-value pairs on the inventory item. */
        public Map<String,String> CustomData;
        /** CatalogItem.DisplayName at the time this item was purchased. */
        public String DisplayName;
        /** Timestamp for when this instance will expire. */
        public Date Expiration;
        /** Class name for the inventory item, as defined in the catalog. */
        public String ItemClass;
        /** Unique identifier for the inventory item, as defined in the catalog. */
        public String ItemId;
        /** Unique item identifier for this specific instance of the item. */
        public String ItemInstanceId;
        /** Timestamp for when this instance was purchased. */
        public Date PurchaseDate;
        /** Total number of remaining uses, if this is a consumable item. */
        public Integer RemainingUses;
        /** Currency type for the cost of the catalog item. */
        public String UnitCurrency;
        /** Cost of the catalog item in the given currency. */
        public Long UnitPrice;
        /** The number of uses that were added or removed to this item in this call. */
        public Integer UsesIncrementedBy;
        
        public int compareTo(ItemInstance other) {
            if (other == null || other.ItemInstanceId == null) return 1;
            if (ItemInstanceId == null) return -1;
            return ItemInstanceId.compareTo(other.ItemInstanceId);
        }
    }

    public static class ItemPurchaseRequest {
        /** Title-specific text concerning this purchase. */
        public String Annotation;
        /** Unique ItemId of the item to purchase. */
        public String ItemId;
        /** How many of this item to purchase. Min 1, maximum 25. */
        public Long Quantity;
        /** Items to be upgraded as a result of this purchase (upgraded items are hidden, as they are "replaced" by the new items). */
        public ArrayList<String> UpgradeFromItems;
        
    }

    public static class KongregatePlayFabIdPair {
        /** Unique Kongregate identifier for a user. */
        public String KongregateId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Kongregate identifier. */
        public String PlayFabId;
        
    }

    public static class LinkAndroidDeviceIDRequest {
        /** Specific model of the user's device. */
        public String AndroidDevice;
        /** Android device identifier for the user's device. */
        public String AndroidDeviceId;
        /** If another user is already linked to the device, unlink the other user and re-link. */
        public Boolean ForceLink;
        /** Specific Operating System version for the user's device. */
        public String OS;
        
    }

    public static class LinkAndroidDeviceIDResult {
        
    }

    public static class LinkCustomIDRequest {
        /** Custom unique identifier for the user, generated by the title. */
        public String CustomId;
        /** If another user is already linked to the custom ID, unlink the other user and re-link. */
        public Boolean ForceLink;
        
    }

    public static class LinkCustomIDResult {
        
    }

    public static class LinkedPlatformAccountModel {
        /** Linked account email of the user on the platform, if available */
        public String Email;
        /** Authentication platform */
        public LoginIdentityProvider Platform;
        /** Unique account identifier of the user on the platform */
        public String PlatformUserId;
        /** Linked account username of the user on the platform, if available */
        public String Username;
        
    }

    /**
     * Facebook sign-in is accomplished using the Facebook User Access Token. More information on the Token can be found in the
     * Facebook developer documentation (https://developers.facebook.com/docs/facebook-login/access-tokens/). In Unity, for
     * example, the Token is available as AccessToken in the Facebook SDK ScriptableObject FB. Note that titles should never
     * re-use the same Facebook applications between PlayFab Title IDs, as Facebook provides unique user IDs per application
     * and doing so can result in issues with the Facebook ID for the user in their PlayFab account information. If you must
     * re-use an application in a new PlayFab Title ID, please be sure to first unlink all accounts from Facebook, or delete
     * all users in the first Title ID.
     */
    public static class LinkFacebookAccountRequest {
        /** Unique identifier from Facebook for the user. */
        public String AccessToken;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        public Boolean ForceLink;
        
    }

    public static class LinkFacebookAccountResult {
        
    }

    public static class LinkFacebookInstantGamesIdRequest {
        /** Facebook Instant Games signature for the user. */
        public String FacebookInstantGamesSignature;
        /** If another user is already linked to the Facebook Instant Games ID, unlink the other user and re-link. */
        public Boolean ForceLink;
        
    }

    public static class LinkFacebookInstantGamesIdResult {
        
    }

    public static class LinkGameCenterAccountRequest {
        /** If another user is already linked to the account, unlink the other user and re-link. */
        public Boolean ForceLink;
        /** Game Center identifier for the player account to be linked. */
        public String GameCenterId;
        /** The URL for the public encryption key that will be used to verify the signature. */
        public String PublicKeyUrl;
        /** A random value used to compute the hash and keep it randomized. */
        public String Salt;
        /** The verification signature of the authentication payload. */
        public String Signature;
        /**
         * The integer representation of date and time that the signature was created on. PlayFab will reject authentication
         * signatures not within 10 minutes of the server's current time.
         */
        public String Timestamp;
        
    }

    public static class LinkGameCenterAccountResult {
        
    }

    /**
     * Google sign-in is accomplished by obtaining a Google OAuth 2.0 credential using the Google sign-in for Android APIs on
     * the device and passing it to this API.
     */
    public static class LinkGoogleAccountRequest {
        /** If another user is already linked to the account, unlink the other user and re-link. */
        public Boolean ForceLink;
        /**
         * Server authentication code obtained on the client by calling getServerAuthCode()
         * (https://developers.google.com/identity/sign-in/android/offline-access) from Google Play for the user.
         */
        public String ServerAuthCode;
        
    }

    public static class LinkGoogleAccountResult {
        
    }

    public static class LinkIOSDeviceIDRequest {
        /** Vendor-specific iOS identifier for the user's device. */
        public String DeviceId;
        /** Specific model of the user's device. */
        public String DeviceModel;
        /** If another user is already linked to the device, unlink the other user and re-link. */
        public Boolean ForceLink;
        /** Specific Operating System version for the user's device. */
        public String OS;
        
    }

    public static class LinkIOSDeviceIDResult {
        
    }

    public static class LinkKongregateAccountRequest {
        /** Valid session auth ticket issued by Kongregate */
        public String AuthTicket;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        public Boolean ForceLink;
        /** Numeric user ID assigned by Kongregate */
        public String KongregateId;
        
    }

    public static class LinkKongregateAccountResult {
        
    }

    public static class LinkNintendoSwitchDeviceIdRequest {
        /** If another user is already linked to the Nintendo Switch Device ID, unlink the other user and re-link. */
        public Boolean ForceLink;
        /** Nintendo Switch unique identifier for the user's device. */
        public String NintendoSwitchDeviceId;
        
    }

    public static class LinkNintendoSwitchDeviceIdResult {
        
    }

    public static class LinkOpenIdConnectRequest {
        /** A name that identifies which configured OpenID Connect provider relationship to use. Maximum 100 characters. */
        public String ConnectionId;
        /** If another user is already linked to a specific OpenId Connect user, unlink the other user and re-link. */
        public Boolean ForceLink;
        /**
         * The JSON Web token (JWT) returned by the identity provider after login. Represented as the id_token field in the
         * identity provider's response. Used to validate the request and find the user ID (OpenID Connect subject) to link with.
         */
        public String IdToken;
        
    }

    public static class LinkPSNAccountRequest {
        /** Authentication code provided by the PlayStation Network. */
        public String AuthCode;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        public Boolean ForceLink;
        /** Id of the PSN issuer environment. If null, defaults to 256 (production) */
        public Integer IssuerId;
        /** Redirect URI supplied to PSN when requesting an auth code */
        public String RedirectUri;
        
    }

    public static class LinkPSNAccountResult {
        
    }

    /**
     * Steam authentication is accomplished with the Steam Session Ticket. More information on the Ticket can be found in the
     * Steamworks SDK, here: https://partner.steamgames.com/documentation/auth (requires sign-in). NOTE: For Steam
     * authentication to work, the title must be configured with the Steam Application ID and Publisher Key in the PlayFab Game
     * Manager (under Properties). Information on creating a Publisher Key (referred to as the Secret Key in PlayFab) for your
     * title can be found here: https://partner.steamgames.com/documentation/webapi#publisherkey.
     */
    public static class LinkSteamAccountRequest {
        /** If another user is already linked to the account, unlink the other user and re-link. */
        public Boolean ForceLink;
        /**
         * Authentication token for the user, returned as a byte array from Steam, and converted to a string (for example, the byte
         * 0x08 should become "08").
         */
        public String SteamTicket;
        
    }

    public static class LinkSteamAccountResult {
        
    }

    public static class LinkTwitchAccountRequest {
        /** Valid token issued by Twitch */
        public String AccessToken;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        public Boolean ForceLink;
        
    }

    public static class LinkTwitchAccountResult {
        
    }

    /** PublicKey must be generated using the Windows Hello Passport service. */
    public static class LinkWindowsHelloAccountRequest {
        /** Device name. */
        public String DeviceName;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        public Boolean ForceLink;
        /** PublicKey generated by Windows Hello. */
        public String PublicKey;
        /** Player's user named used by Windows Hello. */
        public String UserName;
        
    }

    public static class LinkWindowsHelloAccountResponse {
        
    }

    public static class LinkXboxAccountRequest {
        /** If another user is already linked to the account, unlink the other user and re-link. */
        public Boolean ForceLink;
        /** Token provided by the Xbox Live SDK/XDK method GetTokenAndSignatureAsync("POST", "https://playfabapi.com", ""). */
        public String XboxToken;
        
    }

    public static class LinkXboxAccountResult {
        
    }

    /** Returns a list of every character that currently belongs to a user. */
    public static class ListUsersCharactersRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        public String PlayFabId;
        
    }

    public static class ListUsersCharactersResult {
        /** The requested list of characters. */
        public ArrayList<CharacterResult> Characters;
        
    }

    public static class LocationModel {
        /** City name. */
        public String City;
        /** The two-character continent code for this location */
        public ContinentCode ContinentCode;
        /** The two-character ISO 3166-1 country code for the country associated with the location */
        public CountryCode CountryCode;
        /** Latitude coordinate of the geographic location. */
        public Double Latitude;
        /** Longitude coordinate of the geographic location. */
        public Double Longitude;
        
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
        OpenIdConnect
    }

    public static class LoginResult {
        /**
         * If LoginTitlePlayerAccountEntity flag is set on the login request the title_player_account will also be logged in and
         * returned.
         */
        public EntityTokenResponse EntityToken;
        /** Results for requested info. */
        public GetPlayerCombinedInfoResultPayload InfoResultPayload;
        /** The time of this user's previous login. If there was no previous login, then it's DateTime.MinValue */
        public Date LastLoginTime;
        /** True if the account was newly created on this login. */
        public Boolean NewlyCreated;
        /** Player's unique PlayFabId. */
        public String PlayFabId;
        /** Unique token authorizing the user and game at the server level, for the current session. */
        public String SessionTicket;
        /** Settings specific to this user. */
        public UserSettings SettingsForUser;
        
    }

    /**
     * On Android devices, the recommendation is to use the Settings.Secure.ANDROID_ID as the AndroidDeviceId, as described in
     * this blog post (http://android-developers.blogspot.com/2011/03/identifying-app-installations.html). More information on
     * this identifier can be found in the Android documentation
     * (http://developer.android.com/reference/android/provider/Settings.Secure.html). If this is the first time a user has
     * signed in with the Android device and CreateAccount is set to true, a new PlayFab account will be created and linked to
     * the Android device ID. In this case, no email or username will be associated with the PlayFab account. Otherwise, if no
     * PlayFab account is linked to the Android device, an error indicating this will be returned, so that the title can guide
     * the user through creation of a PlayFab account. Please note that while multiple devices of this type can be linked to a
     * single user account, only the one most recently used to login (or most recently linked) will be reflected in the user's
     * account information. We will be updating to show all linked devices in a future release.
     */
    public static class LoginWithAndroidDeviceIDRequest {
        /** Specific model of the user's device. */
        public String AndroidDevice;
        /** Android device identifier for the user's device. */
        public String AndroidDeviceId;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Specific Operating System version for the user's device. */
        public String OS;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * It is highly recommended that developers ensure that it is extremely unlikely that a customer could generate an ID which
     * is already in use by another customer. If this is the first time a user has signed in with the Custom ID and
     * CreateAccount is set to true, a new PlayFab account will be created and linked to the Custom ID. In this case, no email
     * or username will be associated with the PlayFab account. Otherwise, if no PlayFab account is linked to the Custom ID, an
     * error indicating this will be returned, so that the title can guide the user through creation of a PlayFab account.
     */
    public static class LoginWithCustomIDRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Custom unique identifier for the user, generated by the title. */
        public String CustomId;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * Email address and password lengths are provided for information purposes. The server will validate that data passed in
     * conforms to the field definition and report errors appropriately. It is recommended that developers not perform this
     * validation locally, so that future updates do not require client updates.
     */
    public static class LoginWithEmailAddressRequest {
        /** Email address for the account. */
        public String Email;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Password for the PlayFab account (6-100 characters) */
        public String Password;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    public static class LoginWithFacebookInstantGamesIdRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Facebook Instant Games signature for the user. */
        public String FacebookInstantGamesSignature;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * Facebook sign-in is accomplished using the Facebook User Access Token. More information on the Token can be found in the
     * Facebook developer documentation (https://developers.facebook.com/docs/facebook-login/access-tokens/). In Unity, for
     * example, the Token is available as AccessToken in the Facebook SDK ScriptableObject FB. If this is the first time a user
     * has signed in with the Facebook account and CreateAccount is set to true, a new PlayFab account will be created and
     * linked to the provided account's Facebook ID. In this case, no email or username will be associated with the PlayFab
     * account. Otherwise, if no PlayFab account is linked to the Facebook account, an error indicating this will be returned,
     * so that the title can guide the user through creation of a PlayFab account. Note that titles should never re-use the
     * same Facebook applications between PlayFab Title IDs, as Facebook provides unique user IDs per application and doing so
     * can result in issues with the Facebook ID for the user in their PlayFab account information. If you must re-use an
     * application in a new PlayFab Title ID, please be sure to first unlink all accounts from Facebook, or delete all users in
     * the first Title ID.
     */
    public static class LoginWithFacebookRequest {
        /** Unique identifier from Facebook for the user. */
        public String AccessToken;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * The Game Center player identifier
     * (https://developer.apple.com/library/ios/documentation/Accounts/Reference/ACAccountClassRef/index.html#//apple_ref/occ/instp/ACAccount/identifier)
     * is a generated string which is stored on the local device. As with device identifiers, care must be taken to never
     * expose a player's Game Center identifier to end users, as that could result in a user's account being compromised. If
     * this is the first time a user has signed in with Game Center and CreateAccount is set to true, a new PlayFab account
     * will be created and linked to the Game Center identifier. In this case, no email or username will be associated with the
     * PlayFab account. Otherwise, if no PlayFab account is linked to the Game Center account, an error indicating this will be
     * returned, so that the title can guide the user through creation of a PlayFab account.
     */
    public static class LoginWithGameCenterRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Unique Game Center player id. */
        public String PlayerId;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /** The URL for the public encryption key that will be used to verify the signature. */
        public String PublicKeyUrl;
        /** A random value used to compute the hash and keep it randomized. */
        public String Salt;
        /** The verification signature of the authentication payload. */
        public String Signature;
        /**
         * The integer representation of date and time that the signature was created on. PlayFab will reject authentication
         * signatures not within 10 minutes of the server's current time.
         */
        public String Timestamp;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * Google sign-in is accomplished by obtaining a Google OAuth 2.0 credential using the Google sign-in for Android APIs on
     * the device and passing it to this API. If this is the first time a user has signed in with the Google account and
     * CreateAccount is set to true, a new PlayFab account will be created and linked to the Google account. Otherwise, if no
     * PlayFab account is linked to the Google account, an error indicating this will be returned, so that the title can guide
     * the user through creation of a PlayFab account. The current (recommended) method for obtaining a Google account
     * credential in an Android application is to call GoogleSignInAccount.getServerAuthCode() and send the auth code as the
     * ServerAuthCode parameter of this API. Before doing this, you must create an OAuth 2.0 web application client ID in the
     * Google API Console and configure its client ID and secret in the PlayFab Game Manager Google Add-on for your title. This
     * method does not require prompting of the user for additional Google account permissions, resulting in a user experience
     * with the least possible friction. For more information about obtaining the server auth code, see
     * https://developers.google.com/identity/sign-in/android/offline-access. The previous (deprecated) method was to obtain an
     * OAuth access token by calling GetAccessToken() on the client and passing it as the AccessToken parameter to this API.
     * for the with the Google OAuth 2.0 Access Token. More information on this change can be found in the Google developer
     * documentation (https://android-developers.googleblog.com/2016/01/play-games-permissions-are-changing-in.html).
     */
    public static class LoginWithGoogleAccountRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * OAuth 2.0 server authentication code obtained on the client by calling the getServerAuthCode()
         * (https://developers.google.com/identity/sign-in/android/offline-access) Google client API.
         */
        public String ServerAuthCode;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * On iOS devices, the identifierForVendor
     * (https://developer.apple.com/library/ios/documentation/UIKit/Reference/UIDevice_Class/index.html#//apple_ref/occ/instp/UIDevice/identifierForVendor)
     * must be used as the DeviceId, as the UIDevice uniqueIdentifier has been deprecated as of iOS 5, and use of the
     * advertisingIdentifier for this purpose will result in failure of Apple's certification process. If this is the first
     * time a user has signed in with the iOS device and CreateAccount is set to true, a new PlayFab account will be created
     * and linked to the vendor-specific iOS device ID. In this case, no email or username will be associated with the PlayFab
     * account. Otherwise, if no PlayFab account is linked to the iOS device, an error indicating this will be returned, so
     * that the title can guide the user through creation of a PlayFab account. Please note that while multiple devices of this
     * type can be linked to a single user account, only the one most recently used to login (or most recently linked) will be
     * reflected in the user's account information. We will be updating to show all linked devices in a future release.
     */
    public static class LoginWithIOSDeviceIDRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Vendor-specific iOS identifier for the user's device. */
        public String DeviceId;
        /** Specific model of the user's device. */
        public String DeviceModel;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Specific Operating System version for the user's device. */
        public String OS;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * More details regarding Kongregate and their game authentication system can be found at
     * http://developers.kongregate.com/docs/virtual-goods/authentication. Developers must provide the Kongregate user ID and
     * auth token that are generated using the Kongregate client library. PlayFab will combine these identifiers with the
     * title's unique Kongregate app ID to log the player into the Kongregate system. If CreateAccount is set to true and there
     * is not already a user matched to this Kongregate ID, then PlayFab will create a new account for this user and link the
     * ID. In this case, no email or username will be associated with the PlayFab account. If there is already a different
     * PlayFab user linked with this account, then an error will be returned.
     */
    public static class LoginWithKongregateRequest {
        /** Token issued by Kongregate's client API for the user. */
        public String AuthTicket;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Numeric user ID assigned by Kongregate */
        public String KongregateId;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    public static class LoginWithNintendoSwitchDeviceIdRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Nintendo Switch unique identifier for the user's device. */
        public String NintendoSwitchDeviceId;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    public static class LoginWithOpenIdConnectRequest {
        /** A name that identifies which configured OpenID Connect provider relationship to use. Maximum 100 characters. */
        public String ConnectionId;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /**
         * The JSON Web token (JWT) returned by the identity provider after login. Represented as the id_token field in the
         * identity provider's response.
         */
        public String IdToken;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * Username and password lengths are provided for information purposes. The server will validate that data passed in
     * conforms to the field definition and report errors appropriately. It is recommended that developers not perform this
     * validation locally, so that future updates to the username or password do not require client updates.
     */
    public static class LoginWithPlayFabRequest {
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Password for the PlayFab account (6-100 characters) */
        public String Password;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        /** PlayFab username for the account. */
        public String Username;
        
    }

    /**
     * If this is the first time a user has signed in with the PlayStation Network account and CreateAccount is set to true, a
     * new PlayFab account will be created and linked to the PSN account. In this case, no email or username will be associated
     * with the PlayFab account. Otherwise, if no PlayFab account is linked to the PSN account, an error indicating this will
     * be returned, so that the title can guide the user through creation of a PlayFab account.
     */
    public static class LoginWithPSNRequest {
        /** Auth code provided by the PSN OAuth provider. */
        public String AuthCode;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Id of the PSN issuer environment. If null, defaults to 256 (production) */
        public Integer IssuerId;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /** Redirect URI supplied to PSN when requesting an auth code */
        public String RedirectUri;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * Steam sign-in is accomplished with the Steam Session Ticket. More information on the Ticket can be found in the
     * Steamworks SDK, here: https://partner.steamgames.com/documentation/auth (requires sign-in). NOTE: For Steam
     * authentication to work, the title must be configured with the Steam Application ID and Web API Key in the PlayFab Game
     * Manager (under Steam in the Add-ons Marketplace). You can obtain a Web API Key from the Permissions page of any Group
     * associated with your App ID in the Steamworks site. If this is the first time a user has signed in with the Steam
     * account and CreateAccount is set to true, a new PlayFab account will be created and linked to the provided account's
     * Steam ID. In this case, no email or username will be associated with the PlayFab account. Otherwise, if no PlayFab
     * account is linked to the Steam account, an error indicating this will be returned, so that the title can guide the user
     * through creation of a PlayFab account.
     */
    public static class LoginWithSteamRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Authentication token for the user, returned as a byte array from Steam, and converted to a string (for example, the byte
         * 0x08 should become "08").
         */
        public String SteamTicket;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * More details regarding Twitch and their authentication system can be found at
     * https://github.com/justintv/Twitch-API/blob/master/authentication.md. Developers must provide the Twitch access token
     * that is generated using one of the Twitch authentication flows. PlayFab will use the title's unique Twitch Client ID to
     * authenticate the token and log in to the PlayFab system. If CreateAccount is set to true and there is not already a user
     * matched to the Twitch username that generated the token, then PlayFab will create a new account for this user and link
     * the ID. In this case, no email or username will be associated with the PlayFab account. If there is already a different
     * PlayFab user linked with this account, then an error will be returned.
     */
    public static class LoginWithTwitchRequest {
        /** Token issued by Twitch's API for the user. */
        public String AccessToken;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /** Requires both the SHA256 hash of the user's public key as well as the signed response from GetWindowsHelloChallenge */
    public static class LoginWithWindowsHelloRequest {
        /** The signed response from the user for the Challenge. */
        public String ChallengeSignature;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** SHA256 hash of the PublicKey generated by Windows Hello. */
        public String PublicKeyHint;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    /**
     * If this is the first time a user has signed in with the Xbox Live account and CreateAccount is set to true, a new
     * PlayFab account will be created and linked to the Xbox Live account. In this case, no email or username will be
     * associated with the PlayFab account. Otherwise, if no PlayFab account is linked to the Xbox Live account, an error
     * indicating this will be returned, so that the title can guide the user through creation of a PlayFab account.
     */
    public static class LoginWithXboxRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        public Boolean CreateAccount;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        /** Token provided by the Xbox Live SDK/XDK method GetTokenAndSignatureAsync("POST", "https://playfabapi.com", ""). */
        public String XboxToken;
        
    }

    public static class LogStatement {
        /** Optional object accompanying the message as contextual information */
        public Object Data;
        /** 'Debug', 'Info', or 'Error' */
        public String Level;
        public String Message;
        
    }

    public static class MatchmakeRequest {
        /** Build version to match against. [Note: Required if LobbyId is not specified] */
        public String BuildVersion;
        /** Character to use for stats based matching. Leave null to use account stats. */
        public String CharacterId;
        /** Game mode to match make against. [Note: Required if LobbyId is not specified] */
        public String GameMode;
        /** Lobby identifier to match make against. This is used to select a specific Game Server Instance. */
        public String LobbyId;
        /** Region to match make against. [Note: Required if LobbyId is not specified] */
        public Region Region;
        /** Start a game session if one with an open slot is not found. Defaults to true. */
        public Boolean StartNewIfNoneFound;
        /** Player statistic to use in finding a match. May be null for no stat-based matching. */
        public String StatisticName;
        /** Filter to include and/or exclude Game Server Instances associated with certain Tags */
        public CollectionFilter TagFilter;
        
    }

    public static class MatchmakeResult {
        /** timestamp for when the server will expire, if applicable */
        public String Expires;
        /** unique lobby identifier of the server matched */
        public String LobbyID;
        /** time in milliseconds the application is configured to wait on matchmaking results */
        public Integer PollWaitTimeMS;
        /** IPV4 address of the server */
        public String ServerIPV4Address;
        /** IPV6 address of the server */
        public String ServerIPV6Address;
        /** port number to use for non-http communications with the server */
        public Integer ServerPort;
        /** Public DNS name (if any) of the server */
        public String ServerPublicDNSName;
        /** result of match making process */
        public MatchmakeStatus Status;
        /** server authorization ticket (used by RedeemMatchmakerTicket to validate user insertion into the game) */
        public String Ticket;
        
    }

    public static enum MatchmakeStatus {
        Complete,
        Waiting,
        GameNotFound,
        NoAvailableSlots,
        SessionClosed
    }

    public static class MembershipModel {
        /** Whether this membership is active. That is, whether the MembershipExpiration time has been reached. */
        public Boolean IsActive;
        /** The time this membership expires */
        public Date MembershipExpiration;
        /** The id of the membership */
        public String MembershipId;
        /**
         * Membership expirations can be explicitly overridden (via game manager or the admin api). If this membership has been
         * overridden, this will be the new expiration time.
         */
        public Date OverrideExpiration;
        /** The list of subscriptions that this player has for this membership */
        public ArrayList<SubscriptionModel> Subscriptions;
        
    }

    public static class ModifyUserVirtualCurrencyResult {
        /** Balance of the virtual currency after modification. */
        public Integer Balance;
        /**
         * Amount added or subtracted from the user's virtual currency. Maximum VC balance is Int32 (2,147,483,647). Any increase
         * over this value will be discarded.
         */
        public Integer BalanceChange;
        /** User currency was subtracted from. */
        public String PlayFabId;
        /** Name of the virtual currency which was modified. */
        public String VirtualCurrency;
        
    }

    public static class NintendoSwitchPlayFabIdPair {
        /** Unique Nintendo Switch Device identifier for a user. */
        public String NintendoSwitchDeviceId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Nintendo Switch Device identifier. */
        public String PlayFabId;
        
    }

    public static class OpenTradeRequest {
        /**
         * Players who are allowed to accept the trade. If null, the trade may be accepted by any player. If empty, the trade may
         * not be accepted by any player.
         */
        public ArrayList<String> AllowedPlayerIds;
        /** Player inventory items offered for trade. If not set, the trade is effectively a gift request */
        public ArrayList<String> OfferedInventoryInstanceIds;
        /** Catalog items accepted for the trade. If not set, the trade is effectively a gift. */
        public ArrayList<String> RequestedCatalogItemIds;
        
    }

    public static class OpenTradeResponse {
        /** The information about the trade that was just opened. */
        public TradeInfo Trade;
        
    }

    /**
     * This is the second step in the purchasing process, initiating the purchase transaction with the payment provider (if
     * applicable). For payment provider scenarios, the title should next present the user with the payment provider'sinterface
     * for payment. Once the player has completed the payment with the provider, the title should call ConfirmPurchase
     * tofinalize the process and add the appropriate items to the player inventory.
     */
    public static class PayForPurchaseRequest {
        /** Currency to use to fund the purchase. */
        public String Currency;
        /** Purchase order identifier returned from StartPurchase. */
        public String OrderId;
        /** Payment provider to use to fund the purchase. */
        public String ProviderName;
        /** Payment provider transaction identifier. Required for Facebook Payments. */
        public String ProviderTransactionId;
        
    }

    /**
     * For web-based payment providers, this operation returns the URL to which the user should be directed inorder to approve
     * the purchase. Items added to the user inventory as a result of this operation will be marked as unconfirmed.
     */
    public static class PayForPurchaseResult {
        /** Local credit applied to the transaction (provider specific). */
        public Long CreditApplied;
        /** Purchase order identifier. */
        public String OrderId;
        /** Provider used for the transaction. */
        public String ProviderData;
        /** A token generated by the provider to authenticate the request (provider-specific). */
        public String ProviderToken;
        /** URL to the purchase provider page that details the purchase. */
        public String PurchaseConfirmationPageURL;
        /** Currency for the transaction, may be a virtual currency or real money. */
        public String PurchaseCurrency;
        /** Cost of the transaction. */
        public Long PurchasePrice;
        /** Status of the transaction. */
        public TransactionStatus Status;
        /** Virtual currencies granted by the transaction, if any. */
        public Map<String,Integer> VCAmount;
        /** Current virtual currency balances for the user. */
        public Map<String,Integer> VirtualCurrency;
        
    }

    public static class PaymentOption {
        /** Specific currency to use to fund the purchase. */
        public String Currency;
        /** Amount of the specified currency needed for the purchase. */
        public Long Price;
        /** Name of the purchase provider for this option. */
        public String ProviderName;
        /** Amount of existing credit the user has with the provider. */
        public Long StoreCredit;
        
    }

    public static class PlayerLeaderboardEntry {
        /** Title-specific display name of the user for this leaderboard entry. */
        public String DisplayName;
        /** PlayFab unique identifier of the user for this leaderboard entry. */
        public String PlayFabId;
        /** User's overall position in the leaderboard. */
        public Integer Position;
        /** The profile of the user, if requested. */
        public PlayerProfileModel Profile;
        /** Specific value of the user's statistic. */
        public Integer StatValue;
        
    }

    public static class PlayerProfileModel {
        /** List of advertising campaigns the player has been attributed to */
        public ArrayList<AdCampaignAttributionModel> AdCampaignAttributions;
        /** URL of the player's avatar image */
        public String AvatarUrl;
        /** If the player is currently banned, the UTC Date when the ban expires */
        public Date BannedUntil;
        /** List of all contact email info associated with the player account */
        public ArrayList<ContactEmailInfoModel> ContactEmailAddresses;
        /** Player record created */
        public Date Created;
        /** Player display name */
        public String DisplayName;
        /** UTC time when the player most recently logged in to the title */
        public Date LastLogin;
        /** List of all authentication systems linked to this player account */
        public ArrayList<LinkedPlatformAccountModel> LinkedAccounts;
        /** List of geographic locations from which the player has logged in to the title */
        public ArrayList<LocationModel> Locations;
        /** List of memberships for the player, along with whether are expired. */
        public ArrayList<MembershipModel> Memberships;
        /** Player account origination */
        public LoginIdentityProvider Origination;
        /** PlayFab player account unique identifier */
        public String PlayerId;
        /** Publisher this player belongs to */
        public String PublisherId;
        /** List of configured end points registered for sending the player push notifications */
        public ArrayList<PushNotificationRegistrationModel> PushNotificationRegistrations;
        /** List of leaderboard statistic values for the player */
        public ArrayList<StatisticModel> Statistics;
        /** List of player's tags for segmentation */
        public ArrayList<TagModel> Tags;
        /** Title ID this player profile applies to */
        public String TitleId;
        /**
         * Sum of the player's purchases made with real-money currencies, converted to US dollars equivalent and represented as a
         * whole number of cents (1/100 USD). For example, 999 indicates nine dollars and ninety-nine cents.
         */
        public Long TotalValueToDateInUSD;
        /** List of the player's lifetime purchase totals, summed by real-money currency */
        public ArrayList<ValueToDateModel> ValuesToDate;
        
    }

    public static class PlayerProfileViewConstraints {
        /** Whether to show player's avatar URL. Defaults to false */
        public Boolean ShowAvatarUrl;
        /** Whether to show the banned until time. Defaults to false */
        public Boolean ShowBannedUntil;
        /** Whether to show campaign attributions. Defaults to false */
        public Boolean ShowCampaignAttributions;
        /** Whether to show contact email addresses. Defaults to false */
        public Boolean ShowContactEmailAddresses;
        /** Whether to show the created date. Defaults to false */
        public Boolean ShowCreated;
        /** Whether to show the display name. Defaults to false */
        public Boolean ShowDisplayName;
        /** Whether to show the last login time. Defaults to false */
        public Boolean ShowLastLogin;
        /** Whether to show the linked accounts. Defaults to false */
        public Boolean ShowLinkedAccounts;
        /** Whether to show player's locations. Defaults to false */
        public Boolean ShowLocations;
        /** Whether to show player's membership information. Defaults to false */
        public Boolean ShowMemberships;
        /** Whether to show origination. Defaults to false */
        public Boolean ShowOrigination;
        /** Whether to show push notification registrations. Defaults to false */
        public Boolean ShowPushNotificationRegistrations;
        /** Reserved for future development */
        public Boolean ShowStatistics;
        /** Whether to show tags. Defaults to false */
        public Boolean ShowTags;
        /** Whether to show the total value to date in usd. Defaults to false */
        public Boolean ShowTotalValueToDateInUsd;
        /** Whether to show the values to date. Defaults to false */
        public Boolean ShowValuesToDate;
        
    }

    public static class PlayerStatisticVersion {
        /** time when the statistic version became active */
        public Date ActivationTime;
        /** time when the statistic version became inactive due to statistic version incrementing */
        public Date DeactivationTime;
        /** time at which the statistic version was scheduled to become active, based on the configured ResetInterval */
        public Date ScheduledActivationTime;
        /** time at which the statistic version was scheduled to become inactive, based on the configured ResetInterval */
        public Date ScheduledDeactivationTime;
        /** name of the statistic when the version became active */
        public String StatisticName;
        /** version of the statistic */
        public Long Version;
        
    }

    public static class PSNAccountPlayFabIdPair {
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the PlayStation Network identifier. */
        public String PlayFabId;
        /** Unique PlayStation Network identifier for a user. */
        public String PSNAccountId;
        
    }

    /**
     * Please note that the processing time for inventory grants and purchases increases fractionally the more items are in the
     * inventory, and the more items are in the grant/purchase operation (with each item in a bundle being a distinct add).
     */
    public static class PurchaseItemRequest {
        /** Catalog version for the items to be purchased (defaults to most recent version. */
        public String CatalogVersion;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        /** Unique identifier of the item to purchase. */
        public String ItemId;
        /** Price the client expects to pay for the item (in case a new catalog or store was uploaded, with new prices). */
        public Integer Price;
        /** Store to buy this item through. If not set, prices default to those in the catalog. */
        public String StoreId;
        /** Virtual currency to use to purchase the item. */
        public String VirtualCurrency;
        
    }

    public static class PurchaseItemResult {
        /** Details for the items purchased. */
        public ArrayList<ItemInstance> Items;
        
    }

    public static enum PushNotificationPlatform {
        ApplePushNotificationService,
        GoogleCloudMessaging
    }

    public static class PushNotificationRegistrationModel {
        /** Notification configured endpoint */
        public String NotificationEndpointARN;
        /** Push notification platform */
        public PushNotificationPlatform Platform;
        
    }

    /**
     * Coupon codes can be created for any item, or set of items, in the catalog for the title. This operation causes the
     * coupon to be consumed, and the specific items to be awarded to the user. Attempting to re-use an already consumed code,
     * or a code which has not yet been created in the service, will result in an error.
     */
    public static class RedeemCouponRequest {
        /** Catalog version of the coupon. If null, uses the default catalog */
        public String CatalogVersion;
        /** Optional identifier for the Character that should receive the item. If null, item is added to the player */
        public String CharacterId;
        /** Generated coupon code to redeem. */
        public String CouponCode;
        
    }

    public static class RedeemCouponResult {
        /** Items granted to the player as a result of redeeming the coupon. */
        public ArrayList<ItemInstance> GrantedItems;
        
    }

    public static class RefreshPSNAuthTokenRequest {
        /** Auth code returned by PSN OAuth system. */
        public String AuthCode;
        /** Id of the PSN issuer environment. If null, defaults to 256 (production) */
        public Integer IssuerId;
        /** Redirect URI supplied to PSN when requesting an auth code */
        public String RedirectUri;
        
    }

    public static enum Region {
        USCentral,
        USEast,
        EUWest,
        Singapore,
        Japan,
        Brazil,
        Australia
    }

    public static class RegionInfo {
        /** indicates whether the server specified is available in this region */
        public Boolean Available;
        /** name of the region */
        public String Name;
        /** url to ping to get roundtrip time */
        public String PingUrl;
        /** unique identifier for the region */
        public Region Region;
        
    }

    /**
     * The steps to configure and send Push Notifications is described in the PlayFab tutorials, here:
     * https://api.playfab.com/docs/pushCrashCourse/
     */
    public static class RegisterForIOSPushNotificationRequest {
        /** Message to display when confirming push notification. */
        public String ConfirmationMessage;
        /** Unique token generated by the Apple Push Notification service when the title registered to receive push notifications. */
        public String DeviceToken;
        /** If true, send a test push message immediately after sucessful registration. Defaults to false. */
        public Boolean SendPushNotificationConfirmation;
        
    }

    public static class RegisterForIOSPushNotificationResult {
        
    }

    public static class RegisterPlayFabUserRequest {
        /** An optional parameter for setting the display name for this title (3-25 characters). */
        public String DisplayName;
        /** User email address attached to their account */
        public String Email;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Password for the PlayFab account (6-100 characters) */
        public String Password;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /**
         * An optional parameter that specifies whether both the username and email parameters are required. If true, both
         * parameters are required; if false, the user must supply either the username or email parameter. The default value is
         * true.
         */
        public Boolean RequireBothUsernameAndEmail;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        /** PlayFab username for the account (3-20 characters) */
        public String Username;
        
    }

    /**
     * Each account must have a unique email address in the PlayFab service. Once created, the account may be associated with
     * additional accounts (Steam, Facebook, Game Center, etc.), allowing for added social network lists and achievements
     * systems.
     */
    public static class RegisterPlayFabUserResult {
        /**
         * If LoginTitlePlayerAccountEntity flag is set on the login request the title_player_account will also be logged in and
         * returned.
         */
        public EntityTokenResponse EntityToken;
        /** PlayFab unique identifier for this newly created account. */
        public String PlayFabId;
        /** Unique token identifying the user and game at the server level, for the current session. */
        public String SessionTicket;
        /** Settings specific to this user. */
        public UserSettings SettingsForUser;
        /** PlayFab unique user name. */
        public String Username;
        
    }

    /** PublicKey must be generated using the Windows Hello Passport service. */
    public static class RegisterWithWindowsHelloRequest {
        /** Device name. */
        public String DeviceName;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        /** PublicKey generated by Windows Hello. */
        public String PublicKey;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        /** Player's user name used by Windows Hello. */
        public String UserName;
        
    }

    /** This API removes an existing contact email from the player's profile. */
    public static class RemoveContactEmailRequest {
        
    }

    public static class RemoveContactEmailResult {
        
    }

    public static class RemoveFriendRequest {
        /** PlayFab identifier of the friend account which is to be removed. */
        public String FriendPlayFabId;
        
    }

    public static class RemoveFriendResult {
        
    }

    public static class RemoveGenericIDRequest {
        /** Generic service identifier to be removed from the player. */
        public GenericServiceId GenericId;
        
    }

    public static class RemoveGenericIDResult {
        
    }

    public static class RemoveSharedGroupMembersRequest {
        /** An array of unique PlayFab assigned ID of the user on whom the operation will be performed. */
        public ArrayList<String> PlayFabIds;
        /** Unique identifier for the shared group. */
        public String SharedGroupId;
        
    }

    public static class RemoveSharedGroupMembersResult {
        
    }

    public static class ReportPlayerClientRequest {
        /** Optional additional comment by reporting player. */
        public String Comment;
        /** Unique PlayFab identifier of the reported player. */
        public String ReporteeId;
        
    }

    /**
     * Players are currently limited to five reports per day. Attempts by a single user account to submit reports beyond five
     * will result in Updated being returned as false.
     */
    public static class ReportPlayerClientResult {
        /** The number of remaining reports which may be filed today. */
        public Integer SubmissionsRemaining;
        
    }

    /**
     * The title should obtain a refresh receipt via restoreCompletedTransactions in the SKPaymentQueue of the Apple StoreKit
     * and pass that in to this call. The resultant receipt contains new receipt instances for all non-consumable goods
     * previously purchased by the user. This API call iterates through every purchase in the receipt and restores the items if
     * they still exist in the catalog and can be validated.
     */
    public static class RestoreIOSPurchasesRequest {
        /** Base64 encoded receipt data, passed back by the App Store as a result of a successful purchase. */
        public String ReceiptData;
        
    }

    /** Once verified, the valid items will be restored into the user's inventory. */
    public static class RestoreIOSPurchasesResult {
        
    }

    public static class ScriptExecutionError {
        /**
         * Error code, such as CloudScriptNotFound, JavascriptException, CloudScriptFunctionArgumentSizeExceeded,
         * CloudScriptAPIRequestCountExceeded, CloudScriptAPIRequestError, or CloudScriptHTTPRequestError
         */
        public String Error;
        /** Details about the error */
        public String Message;
        /** Point during the execution of the script at which the error occurred, if any */
        public String StackTrace;
        
    }

    /**
     * If the account in question is a "temporary" account (for example, one that was created via a call to
     * LoginFromIOSDeviceID), thisfunction will have no effect. Only PlayFab accounts which have valid email addresses will be
     * able to receive a password reset email using this API.
     */
    public static class SendAccountRecoveryEmailRequest {
        /** User email address attached to their account */
        public String Email;
        /** The email template id of the account recovery email template to send. */
        public String EmailTemplateId;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        public String TitleId;
        
    }

    public static class SendAccountRecoveryEmailResult {
        
    }

    /**
     * This operation is not additive. It will completely replace the tag list for the specified user. Please note that only
     * users in the PlayFab friends list can be assigned tags. Attempting to set a tag on a friend only included in the friends
     * list from a social site integration (such as Facebook or Steam) will return the AccountNotFound error.
     */
    public static class SetFriendTagsRequest {
        /** PlayFab identifier of the friend account to which the tag(s) should be applied. */
        public String FriendPlayFabId;
        /** Array of tags to set on the friend account. */
        public ArrayList<String> Tags;
        
    }

    public static class SetFriendTagsResult {
        
    }

    /**
     * APIs that require signatures require that the player have a configured Player Secret Key that is used to sign all
     * requests. Players that don't have a secret will be blocked from making API calls until it is configured. To create a
     * signature header add a SHA256 hashed string containing UTF8 encoded JSON body as it will be sent to the server, the
     * current time in UTC formatted to ISO 8601, and the players secret formatted as 'body.date.secret'. Place the resulting
     * hash into the header X-PlayFab-Signature, along with a header X-PlayFab-Timestamp of the same UTC timestamp used in the
     * signature.
     */
    public static class SetPlayerSecretRequest {
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        public String EncryptedRequest;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        public String PlayerSecret;
        
    }

    public static class SetPlayerSecretResult {
        
    }

    public static class SharedGroupDataRecord {
        /** Timestamp for when this data was last updated. */
        public Date LastUpdated;
        /** Unique PlayFab identifier of the user to last update this value. */
        public String LastUpdatedBy;
        /** Indicates whether this data can be read by all users (public) or only members of the group (private). */
        public UserDataPermission Permission;
        /** Data stored for the specified group data key. */
        public String Value;
        
    }

    public static enum SourceType {
        Admin,
        BackEnd,
        GameClient,
        GameServer,
        Partner,
        Custom,
        API
    }

    /** This API must be enabled for use as an option in the game manager website. It is disabled by default. */
    public static class StartGameRequest {
        /** version information for the build of the game server which is to be started */
        public String BuildVersion;
        /** character to use for stats based matching. Leave null to use account stats */
        public String CharacterId;
        /** custom command line argument when starting game server process */
        public String CustomCommandLineData;
        /** the title-defined game mode this server is to be running (defaults to 0 if there is only one mode) */
        public String GameMode;
        /** the region to associate this server with for match filtering */
        public Region Region;
        /** player statistic for others to use in finding this game. May be null for no stat-based matching */
        public String StatisticName;
        
    }

    public static class StartGameResult {
        /** timestamp for when the server should expire, if applicable */
        public String Expires;
        /** unique identifier for the lobby of the server started */
        public String LobbyID;
        /** password required to log into the server */
        public String Password;
        /** server IPV4 address */
        public String ServerIPV4Address;
        /** server IPV6 address */
        public String ServerIPV6Address;
        /** port on the server to be used for communication */
        public Integer ServerPort;
        /** server public DNS name */
        public String ServerPublicDNSName;
        /** unique identifier for the server */
        public String Ticket;
        
    }

    /**
     * This is the first step in the purchasing process. For security purposes, once the order (or "cart") has been created,
     * additional inventory objects may no longer be added. In addition, inventory objects will be locked to the current
     * prices, regardless of any subsequent changes at the catalog level which may occur during the next two steps.
     */
    public static class StartPurchaseRequest {
        /** Catalog version for the items to be purchased. Defaults to most recent catalog. */
        public String CatalogVersion;
        /** Array of items to purchase. */
        public ArrayList<ItemPurchaseRequest> Items;
        /** Store through which to purchase items. If not set, prices will be pulled from the catalog itself. */
        public String StoreId;
        
    }

    public static class StartPurchaseResult {
        /** Cart items to be purchased. */
        public ArrayList<CartItem> Contents;
        /** Purchase order identifier. */
        public String OrderId;
        /** Available methods by which the user can pay. */
        public ArrayList<PaymentOption> PaymentOptions;
        /** Current virtual currency totals for the user. */
        public Map<String,Integer> VirtualCurrencyBalances;
        
    }

    public static class StatisticModel {
        /** Statistic name */
        public String Name;
        /** Statistic value */
        public Integer Value;
        /** Statistic version (0 if not a versioned statistic) */
        public Integer Version;
        
    }

    public static class StatisticNameVersion {
        /** unique name of the statistic */
        public String StatisticName;
        /** the version of the statistic to be returned */
        public Long Version;
        
    }

    public static class StatisticUpdate {
        /** unique name of the statistic */
        public String StatisticName;
        /** statistic value for the player */
        public Integer Value;
        /**
         * for updates to an existing statistic value for a player, the version of the statistic when it was loaded. Null when
         * setting the statistic value for the first time.
         */
        public Long Version;
        
    }

    public static class StatisticValue {
        /** unique name of the statistic */
        public String StatisticName;
        /** statistic value for the player */
        public Integer Value;
        /** for updates to an existing statistic value for a player, the version of the statistic when it was loaded */
        public Long Version;
        
    }

    public static class SteamPlayFabIdPair {
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Steam identifier. */
        public String PlayFabId;
        /** Unique Steam identifier for a user. */
        public String SteamStringId;
        
    }

    /** A store entry that list a catalog item at a particular price */
    public static class StoreItem implements Comparable<StoreItem> {
        /** Store specific custom data. The data only exists as part of this store; it is not transferred to item instances */
        public Object CustomData;
        /** Intended display position for this item. Note that 0 is the first position */
        public Long DisplayPosition;
        /**
         * Unique identifier of the item as it exists in the catalog - note that this must exactly match the ItemId from the
         * catalog
         */
        public String ItemId;
        /** Override prices for this item for specific currencies */
        public Map<String,Long> RealCurrencyPrices;
        /** Override prices for this item in virtual currencies and "RM" (the base Real Money purchase price, in USD pennies) */
        public Map<String,Long> VirtualCurrencyPrices;
        
        public int compareTo(StoreItem other) {
            if (other == null || other.ItemId == null) return 1;
            if (ItemId == null) return -1;
            return ItemId.compareTo(other.ItemId);
        }
    }

    /** Marketing data about a specific store */
    public static class StoreMarketingModel {
        /** Tagline for a store. */
        public String Description;
        /** Display name of a store as it will appear to users. */
        public String DisplayName;
        /** Custom data about a store. */
        public Object Metadata;
        
    }

    public static class SubscriptionModel {
        /** When this subscription expires. */
        public Date Expiration;
        /** The time the subscription was orignially purchased */
        public Date InitialSubscriptionTime;
        /** Whether this subscription is currently active. That is, if Expiration &gt; now. */
        public Boolean IsActive;
        /** The status of this subscription, according to the subscription provider. */
        public SubscriptionProviderStatus Status;
        /** The id for this subscription */
        public String SubscriptionId;
        /** The item id for this subscription from the primary catalog */
        public String SubscriptionItemId;
        /** The provider for this subscription. Apple or Google Play are supported today. */
        public String SubscriptionProvider;
        
    }

    public static enum SubscriptionProviderStatus {
        NoError,
        Cancelled,
        UnknownError,
        BillingError,
        ProductUnavailable,
        CustomerDidNotAcceptPriceChange,
        FreeTrial,
        PaymentPending
    }

    /** This API must be enabled for use as an option in the game manager website. It is disabled by default. */
    public static class SubtractUserVirtualCurrencyRequest {
        /** Amount to be subtracted from the user balance of the specified virtual currency. */
        public Integer Amount;
        /** Name of the virtual currency which is to be decremented. */
        public String VirtualCurrency;
        
    }

    public static class TagModel {
        /** Full value of the tag, including namespace */
        public String TagValue;
        
    }

    public static enum TitleActivationStatus {
        None,
        ActivatedTitleKey,
        PendingSteam,
        ActivatedSteam,
        RevokedSteam
    }

    public static class TitleNewsItem {
        /** News item text. */
        public String Body;
        /** Unique identifier of news item. */
        public String NewsId;
        /** Date and time when the news item was posted. */
        public Date Timestamp;
        /** Title of the news item. */
        public String Title;
        
    }

    public static class TradeInfo {
        /** Item instances from the accepting player that are used to fulfill the trade. If null, no one has accepted the trade. */
        public ArrayList<String> AcceptedInventoryInstanceIds;
        /** The PlayFab ID of the player who accepted the trade. If null, no one has accepted the trade. */
        public String AcceptedPlayerId;
        /** An optional list of players allowed to complete this trade. If null, anybody can complete the trade. */
        public ArrayList<String> AllowedPlayerIds;
        /** If set, The UTC time when this trade was canceled. */
        public Date CancelledAt;
        /** If set, The UTC time when this trade was fulfilled. */
        public Date FilledAt;
        /** If set, The UTC time when this trade was made invalid. */
        public Date InvalidatedAt;
        /** The catalogItem Ids of the item instances being offered. */
        public ArrayList<String> OfferedCatalogItemIds;
        /** The itemInstance Ids that are being offered. */
        public ArrayList<String> OfferedInventoryInstanceIds;
        /** The PlayFabId for the offering player. */
        public String OfferingPlayerId;
        /** The UTC time when this trade was created. */
        public Date OpenedAt;
        /** The catalogItem Ids requested in exchange. */
        public ArrayList<String> RequestedCatalogItemIds;
        /** Describes the current state of this trade. */
        public TradeStatus Status;
        /** The identifier for this trade. */
        public String TradeId;
        
    }

    public static enum TradeStatus {
        Invalid,
        Opening,
        Open,
        Accepting,
        Accepted,
        Filled,
        Cancelled
    }

    public static enum TransactionStatus {
        CreateCart,
        Init,
        Approved,
        Succeeded,
        FailedByProvider,
        DisputePending,
        RefundPending,
        Refunded,
        RefundFailed,
        ChargedBack,
        FailedByUber,
        FailedByPlayFab,
        Revoked,
        TradePending,
        Traded,
        Upgraded,
        StackPending,
        Stacked,
        Other,
        Failed
    }

    public static class TwitchPlayFabIdPair {
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Twitch identifier. */
        public String PlayFabId;
        /** Unique Twitch identifier for a user. */
        public String TwitchId;
        
    }

    public static class UninkOpenIdConnectRequest {
        /** A name that identifies which configured OpenID Connect provider relationship to use. Maximum 100 characters. */
        public String ConnectionId;
        
    }

    public static class UnlinkAndroidDeviceIDRequest {
        /**
         * Android device identifier for the user's device. If not specified, the most recently signed in Android Device ID will be
         * used.
         */
        public String AndroidDeviceId;
        
    }

    public static class UnlinkAndroidDeviceIDResult {
        
    }

    public static class UnlinkCustomIDRequest {
        /**
         * Custom unique identifier for the user, generated by the title. If not specified, the most recently signed in Custom ID
         * will be used.
         */
        public String CustomId;
        
    }

    public static class UnlinkCustomIDResult {
        
    }

    public static class UnlinkFacebookAccountRequest {
        
    }

    public static class UnlinkFacebookAccountResult {
        
    }

    public static class UnlinkFacebookInstantGamesIdRequest {
        /** Facebook Instant Games identifier for the user. If not specified, the most recently signed in ID will be used. */
        public String FacebookInstantGamesId;
        
    }

    public static class UnlinkFacebookInstantGamesIdResult {
        
    }

    public static class UnlinkGameCenterAccountRequest {
        
    }

    public static class UnlinkGameCenterAccountResult {
        
    }

    public static class UnlinkGoogleAccountRequest {
        
    }

    public static class UnlinkGoogleAccountResult {
        
    }

    public static class UnlinkIOSDeviceIDRequest {
        /**
         * Vendor-specific iOS identifier for the user's device. If not specified, the most recently signed in iOS Device ID will
         * be used.
         */
        public String DeviceId;
        
    }

    public static class UnlinkIOSDeviceIDResult {
        
    }

    public static class UnlinkKongregateAccountRequest {
        
    }

    public static class UnlinkKongregateAccountResult {
        
    }

    public static class UnlinkNintendoSwitchDeviceIdRequest {
        /** Nintendo Switch Device identifier for the user. If not specified, the most recently signed in device ID will be used. */
        public String NintendoSwitchDeviceId;
        
    }

    public static class UnlinkNintendoSwitchDeviceIdResult {
        
    }

    public static class UnlinkPSNAccountRequest {
        
    }

    public static class UnlinkPSNAccountResult {
        
    }

    public static class UnlinkSteamAccountRequest {
        
    }

    public static class UnlinkSteamAccountResult {
        
    }

    public static class UnlinkTwitchAccountRequest {
        
    }

    public static class UnlinkTwitchAccountResult {
        
    }

    /** Must include the Public Key Hint */
    public static class UnlinkWindowsHelloAccountRequest {
        /** SHA256 hash of the PublicKey generated by Windows Hello. */
        public String PublicKeyHint;
        
    }

    public static class UnlinkWindowsHelloAccountResponse {
        
    }

    public static class UnlinkXboxAccountRequest {
        /** Token provided by the Xbox Live SDK/XDK method GetTokenAndSignatureAsync("POST", "https://playfabapi.com", ""). */
        public String XboxToken;
        
    }

    public static class UnlinkXboxAccountResult {
        
    }

    /** Specify the container and optionally the catalogVersion for the container to open */
    public static class UnlockContainerInstanceRequest {
        /**
         * Specifies the catalog version that should be used to determine container contents. If unspecified, uses catalog
         * associated with the item instance.
         */
        public String CatalogVersion;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        /** ItemInstanceId of the container to unlock. */
        public String ContainerItemInstanceId;
        /**
         * ItemInstanceId of the key that will be consumed by unlocking this container. If the container requires a key, this
         * parameter is required.
         */
        public String KeyItemInstanceId;
        
    }

    /** Specify the type of container to open and optionally the catalogVersion for the container to open */
    public static class UnlockContainerItemRequest {
        /**
         * Specifies the catalog version that should be used to determine container contents. If unspecified, uses default/primary
         * catalog.
         */
        public String CatalogVersion;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        /** Catalog ItemId of the container type to unlock. */
        public String ContainerItemId;
        
    }

    /** The items and vc found within the container. These will be added and stacked in the appropriate inventory. */
    public static class UnlockContainerItemResult {
        /** Items granted to the player as a result of unlocking the container. */
        public ArrayList<ItemInstance> GrantedItems;
        /** Unique instance identifier of the container unlocked. */
        public String UnlockedItemInstanceId;
        /** Unique instance identifier of the key used to unlock the container, if applicable. */
        public String UnlockedWithItemInstanceId;
        /** Virtual currency granted to the player as a result of unlocking the container. */
        public Map<String,Long> VirtualCurrency;
        
    }

    public static class UpdateAvatarUrlRequest {
        /** URL of the avatar image. If empty, it removes the existing avatar URL. */
        public String ImageUrl;
        
    }

    /**
     * This function performs an additive update of the arbitrary strings containing the custom data for the character. In
     * updating the custom data object, keys which already exist in the object will have their values overwritten, while keys
     * with null values will be removed. New keys will be added, with the given values. No other key-value pairs will be
     * changed apart from those specified in the call.
     */
    public static class UpdateCharacterDataRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may
         * not begin with a '!' character or be null.
         */
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData. Some SDKs cannot insert null-values into Data due to language
         * constraints. Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        /** Permission to be applied to all user data keys written in this request. Defaults to "private" if not set. */
        public UserDataPermission Permission;
        
    }

    public static class UpdateCharacterDataResult {
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of
         * data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        
    }

    /**
     * Enable this option with the 'Allow Client to Post Player Statistics' option in PlayFab GameManager for your title.
     * However, this is not best practice, as this data will no longer be safely controlled by the server. This operation is
     * additive. Character Statistics not currently defined will be added, while those already defined will be updated with the
     * given values. All other user statistics will remain unchanged. Character statistics are used by the
     * character-leaderboard apis, and accessible for custom game-logic.
     */
    public static class UpdateCharacterStatisticsRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        /** Statistics to be updated with the provided values. */
        public Map<String,Integer> CharacterStatistics;
        
    }

    public static class UpdateCharacterStatisticsResult {
        
    }

    /**
     * Enable this option with the 'Allow Client to Post Player Statistics' option in PlayFab GameManager for your title.
     * However, this is not best practice, as this data will no longer be safely controlled by the server. This operation is
     * additive. Statistics not currently defined will be added, while those already defined will be updated with the given
     * values. All other user statistics will remain unchanged. Note that if the statistic is intended to have a reset period,
     * the UpdatePlayerStatisticDefinition API call can be used to define that reset period. Once a statistic has been
     * versioned (reset), the now-previous version can still be written to for up a short, pre-defined period (currently 10
     * seconds), using the Version parameter in this call.
     */
    public static class UpdatePlayerStatisticsRequest {
        /** Statistics to be updated with the provided values */
        public ArrayList<StatisticUpdate> Statistics;
        
    }

    public static class UpdatePlayerStatisticsResult {
        
    }

    /**
     * Note that in the case of multiple calls to write to the same shared group data keys, the last write received by the
     * PlayFab service will determine the value available to subsequent read operations. For scenarios requiring coordination
     * of data updates, it is recommended that titles make use of user data with read permission set to public, or a
     * combination of user data and shared group data.
     */
    public static class UpdateSharedGroupDataRequest {
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may
         * not begin with a '!' character or be null.
         */
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData. Some SDKs cannot insert null-values into Data due to language
         * constraints. Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        /** Permission to be applied to all user data keys in this request. */
        public UserDataPermission Permission;
        /** Unique identifier for the shared group. */
        public String SharedGroupId;
        
    }

    public static class UpdateSharedGroupDataResult {
        
    }

    /**
     * This function performs an additive update of the arbitrary strings containing the custom data for the user. In updating
     * the custom data object, keys which already exist in the object will have their values overwritten, while keys with null
     * values will be removed. New keys will be added, with the given values. No other key-value pairs will be changed apart
     * from those specified in the call.
     */
    public static class UpdateUserDataRequest {
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may
         * not begin with a '!' character or be null.
         */
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData. Some SDKs cannot insert null-values into Data due to language
         * constraints. Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        /**
         * Permission to be applied to all user data keys written in this request. Defaults to "private" if not set. This is used
         * for requests by one player for information about another player; those requests will only return Public keys.
         */
        public UserDataPermission Permission;
        
    }

    public static class UpdateUserDataResult {
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of
         * data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        
    }

    /**
     * In addition to the PlayFab username, titles can make use of a DisplayName which is also a unique identifier, but
     * specific to the title. This allows for unique names which more closely match the theme or genre of a title, for example.
     */
    public static class UpdateUserTitleDisplayNameRequest {
        /** New title display name for the user - must be between 3 and 25 characters. */
        public String DisplayName;
        
    }

    public static class UpdateUserTitleDisplayNameResult {
        /** Current title display name for the user (this will be the original display name if the rename attempt failed). */
        public String DisplayName;
        
    }

    public static class UserAccountInfo {
        /** User Android device information, if an Android device has been linked */
        public UserAndroidDeviceInfo AndroidDeviceInfo;
        /** Timestamp indicating when the user account was created */
        public Date Created;
        /** Custom ID information, if a custom ID has been assigned */
        public UserCustomIdInfo CustomIdInfo;
        /** User Facebook information, if a Facebook account has been linked */
        public UserFacebookInfo FacebookInfo;
        /** Facebook Instant Games account information, if a Facebook Instant Games account has been linked */
        public UserFacebookInstantGamesIdInfo FacebookInstantGamesIdInfo;
        /** User Gamecenter information, if a Gamecenter account has been linked */
        public UserGameCenterInfo GameCenterInfo;
        /** User Google account information, if a Google account has been linked */
        public UserGoogleInfo GoogleInfo;
        /** User iOS device information, if an iOS device has been linked */
        public UserIosDeviceInfo IosDeviceInfo;
        /** User Kongregate account information, if a Kongregate account has been linked */
        public UserKongregateInfo KongregateInfo;
        /** Nintendo Switch account information, if a Nintendo Switch account has been linked */
        public UserNintendoSwitchDeviceIdInfo NintendoSwitchDeviceIdInfo;
        /** OpenID Connect information, if any OpenID Connect accounts have been linked */
        public ArrayList<UserOpenIdInfo> OpenIdInfo;
        /** Unique identifier for the user account */
        public String PlayFabId;
        /** Personal information for the user which is considered more sensitive */
        public UserPrivateAccountInfo PrivateInfo;
        /** User PSN account information, if a PSN account has been linked */
        public UserPsnInfo PsnInfo;
        /** User Steam information, if a Steam account has been linked */
        public UserSteamInfo SteamInfo;
        /** Title-specific information for the user account */
        public UserTitleInfo TitleInfo;
        /** User Twitch account information, if a Twitch account has been linked */
        public UserTwitchInfo TwitchInfo;
        /** User account name in the PlayFab service */
        public String Username;
        /** Windows Hello account information, if a Windows Hello account has been linked */
        public UserWindowsHelloInfo WindowsHelloInfo;
        /** User XBox account information, if a XBox account has been linked */
        public UserXboxInfo XboxInfo;
        
    }

    public static class UserAndroidDeviceInfo {
        /** Android device ID */
        public String AndroidDeviceId;
        
    }

    public static class UserCustomIdInfo {
        /** Custom ID */
        public String CustomId;
        
    }

    /**
     * Indicates whether a given data key is private (readable only by the player) or public (readable by all players). When a
     * player makes a GetUserData request about another player, only keys marked Public will be returned.
     */
    public static enum UserDataPermission {
        Private,
        Public
    }

    public static class UserDataRecord {
        /** Timestamp for when this data was last updated. */
        public Date LastUpdated;
        /**
         * Indicates whether this data can be read by all users (public) or only the user (private). This is used for GetUserData
         * requests being made by one player about another player.
         */
        public UserDataPermission Permission;
        /** Data stored for the specified user data key. */
        public String Value;
        
    }

    public static class UserFacebookInfo {
        /** Facebook identifier */
        public String FacebookId;
        /** Facebook full name */
        public String FullName;
        
    }

    public static class UserFacebookInstantGamesIdInfo {
        /** Facebook Instant Games ID */
        public String FacebookInstantGamesId;
        
    }

    public static class UserGameCenterInfo {
        /** Gamecenter identifier */
        public String GameCenterId;
        
    }

    public static class UserGoogleInfo {
        /** Email address of the Google account */
        public String GoogleEmail;
        /** Gender information of the Google account */
        public String GoogleGender;
        /** Google ID */
        public String GoogleId;
        /** Locale of the Google account */
        public String GoogleLocale;
        /** Name of the Google account user */
        public String GoogleName;
        
    }

    public static class UserIosDeviceInfo {
        /** iOS device ID */
        public String IosDeviceId;
        
    }

    public static class UserKongregateInfo {
        /** Kongregate ID */
        public String KongregateId;
        /** Kongregate Username */
        public String KongregateName;
        
    }

    public static class UserNintendoSwitchDeviceIdInfo {
        /** Nintendo Switch Device ID */
        public String NintendoSwitchDeviceId;
        
    }

    public static class UserOpenIdInfo {
        /** OpenID Connection ID */
        public String ConnectionId;
        /** OpenID Issuer */
        public String Issuer;
        /** OpenID Subject */
        public String Subject;
        
    }

    public static enum UserOrigination {
        Organic,
        Steam,
        Google,
        Amazon,
        Facebook,
        Kongregate,
        GamersFirst,
        Unknown,
        IOS,
        LoadTest,
        Android,
        PSN,
        GameCenter,
        CustomId,
        XboxLive,
        Parse,
        Twitch,
        WindowsHello,
        ServerCustomId,
        NintendoSwitchDeviceId,
        FacebookInstantGamesId,
        OpenIdConnect
    }

    public static class UserPrivateAccountInfo {
        /** user email address */
        public String Email;
        
    }

    public static class UserPsnInfo {
        /** PSN account ID */
        public String PsnAccountId;
        /** PSN online ID */
        public String PsnOnlineId;
        
    }

    public static class UserSettings {
        /** Boolean for whether this player is eligible for gathering device info. */
        public Boolean GatherDeviceInfo;
        /** Boolean for whether this player should report OnFocus play-time tracking. */
        public Boolean GatherFocusInfo;
        /** Boolean for whether this player is eligible for ad tracking. */
        public Boolean NeedsAttribution;
        
    }

    public static class UserSteamInfo {
        /** what stage of game ownership the user is listed as being in, from Steam */
        public TitleActivationStatus SteamActivationStatus;
        /** the country in which the player resides, from Steam data */
        public String SteamCountry;
        /** currency type set in the user Steam account */
        public Currency SteamCurrency;
        /** Steam identifier */
        public String SteamId;
        /** Steam display name */
        public String SteamName;
        
    }

    public static class UserTitleInfo {
        /** URL to the player's avatar. */
        public String AvatarUrl;
        /**
         * timestamp indicating when the user was first associated with this game (this can differ significantly from when the user
         * first registered with PlayFab)
         */
        public Date Created;
        /** name of the user, as it is displayed in-game */
        public String DisplayName;
        /**
         * timestamp indicating when the user first signed into this game (this can differ from the Created timestamp, as other
         * events, such as issuing a beta key to the user, can associate the title to the user)
         */
        public Date FirstLogin;
        /** boolean indicating whether or not the user is currently banned for a title */
        public Boolean isBanned;
        /** timestamp for the last user login for this title */
        public Date LastLogin;
        /** source by which the user first joined the game, if known */
        public UserOrigination Origination;
        /** Title player account entity for this user */
        public EntityKey TitlePlayerAccount;
        
    }

    public static class UserTwitchInfo {
        /** Twitch ID */
        public String TwitchId;
        /** Twitch Username */
        public String TwitchUserName;
        
    }

    public static class UserWindowsHelloInfo {
        /** Windows Hello Device Name */
        public String WindowsHelloDeviceName;
        /** Windows Hello Public Key Hash */
        public String WindowsHelloPublicKeyHash;
        
    }

    public static class UserXboxInfo {
        /** XBox user ID */
        public String XboxUserId;
        
    }

    public static class ValidateAmazonReceiptRequest {
        /** Catalog version to use when granting receipt item. If null, defaults to primary catalog. */
        public String CatalogVersion;
        /** Currency used for the purchase. */
        public String CurrencyCode;
        /** Amount of the stated currency paid for the object. */
        public Integer PurchasePrice;
        /** ReceiptId returned by the Amazon App Store in-app purchase API */
        public String ReceiptId;
        /** AmazonId of the user making the purchase as returned by the Amazon App Store in-app purchase API */
        public String UserId;
        
    }

    /** Once verified, the catalog item matching the Amazon item name will be added to the user's inventory. */
    public static class ValidateAmazonReceiptResult {
        
    }

    /**
     * The packageName and productId are defined in the GooglePlay store. The productId must match the ItemId of the inventory
     * item in the PlayFab catalog for the title. This enables the PlayFab service to securely validate that the purchase is
     * for the correct item, in order to prevent uses from passing valid receipts as being for more expensive items (passing a
     * receipt for a 99-cent purchase as being for a $19.99 purchase, for example). Each receipt may be validated only once to
     * avoid granting the same item over and over from a single purchase.
     */
    public static class ValidateGooglePlayPurchaseRequest {
        /** Currency used for the purchase. */
        public String CurrencyCode;
        /** Amount of the stated currency paid for the object. */
        public Long PurchasePrice;
        /** Original JSON string returned by the Google Play IAB API. */
        public String ReceiptJson;
        /** Signature returned by the Google Play IAB API. */
        public String Signature;
        
    }

    /**
     * Once verified, the catalog item (ItemId) matching the GooglePlay store item (productId) will be added to the user's
     * inventory.
     */
    public static class ValidateGooglePlayPurchaseResult {
        
    }

    /**
     * The CurrencyCode and PurchasePrice must match the price which was set up for the item in the Apple store. In addition,
     * The ItemId of the inventory in the PlayFab Catalog must match the Product ID as it was set up in the Apple store. This
     * enables the PlayFab service to securely validate that the purchase is for the correct item, in order to prevent uses
     * from passing valid receipts as being for more expensive items (passing a receipt for a 99-cent purchase as being for a
     * $19.99 purchase, for example).
     */
    public static class ValidateIOSReceiptRequest {
        /** Currency used for the purchase. */
        public String CurrencyCode;
        /** Amount of the stated currency paid for the object. */
        public Integer PurchasePrice;
        /** Base64 encoded receipt data, passed back by the App Store as a result of a successful purchase. */
        public String ReceiptData;
        
    }

    /** Once verified, the catalog item matching the iTunes item name will be added to the user's inventory. */
    public static class ValidateIOSReceiptResult {
        
    }

    public static class ValidateWindowsReceiptRequest {
        /** Catalog version to use when granting receipt item. If null, defaults to primary catalog. */
        public String CatalogVersion;
        /** Currency used for the purchase. */
        public String CurrencyCode;
        /** Amount of the stated currency paid for the object. */
        public Long PurchasePrice;
        /** XML Receipt returned by the Windows App Store in-app purchase API */
        public String Receipt;
        
    }

    /** Once verified, the catalog item matching the Product name will be added to the user's inventory. */
    public static class ValidateWindowsReceiptResult {
        
    }

    public static class ValueToDateModel {
        /** ISO 4217 code of the currency used in the purchases */
        public String Currency;
        /**
         * Total value of the purchases in a whole number of 1/100 monetary units. For example, 999 indicates nine dollars and
         * ninety-nine cents when Currency is 'USD')
         */
        public Long TotalValue;
        /**
         * Total value of the purchases in a string representation of decimal monetary units. For example, '9.99' indicates nine
         * dollars and ninety-nine cents when Currency is 'USD'.
         */
        public String TotalValueAsDecimal;
        
    }

    public static class VirtualCurrencyRechargeTime {
        /**
         * Maximum value to which the regenerating currency will automatically increment. Note that it can exceed this value
         * through use of the AddUserVirtualCurrency API call. However, it will not regenerate automatically until it has fallen
         * below this value.
         */
        public Integer RechargeMax;
        /** Server timestamp in UTC indicating the next time the virtual currency will be incremented. */
        public Date RechargeTime;
        /** Time remaining (in seconds) before the next recharge increment of the virtual currency. */
        public Integer SecondsToRecharge;
        
    }

    /**
     * This API is designed to write a multitude of different client-defined events into PlayStream. It supports a flexible
     * JSON schema, which allowsfor arbitrary key-value pairs to describe any character-based event. The created event will be
     * locked to the authenticated title and player.
     */
    public static class WriteClientCharacterEventRequest {
        /** Custom event properties. Each property consists of a name (string) and a value (JSON object). */
        public Map<String,Object> Body;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        public String CharacterId;
        /**
         * The name of the event, within the namespace scoped to the title. The naming convention is up to the caller, but it
         * commonly follows the subject_verb_object pattern (e.g. player_logged_in).
         */
        public String EventName;
        /** The time (in UTC) associated with this event. The value dafaults to the current time. */
        public Date Timestamp;
        
    }

    /**
     * This API is designed to write a multitude of different event types into PlayStream. It supports a flexible JSON schema,
     * which allowsfor arbitrary key-value pairs to describe any player-based event. The created event will be locked to the
     * authenticated title and player.
     */
    public static class WriteClientPlayerEventRequest {
        /** Custom data properties associated with the event. Each property consists of a name (string) and a value (JSON object). */
        public Map<String,Object> Body;
        /**
         * The name of the event, within the namespace scoped to the title. The naming convention is up to the caller, but it
         * commonly follows the subject_verb_object pattern (e.g. player_logged_in).
         */
        public String EventName;
        /** The time (in UTC) associated with this event. The value dafaults to the current time. */
        public Date Timestamp;
        
    }

    public static class WriteEventResponse {
        /**
         * The unique identifier of the event. The values of this identifier consist of ASCII characters and are not constrained to
         * any particular format.
         */
        public String EventId;
        
    }

    /**
     * This API is designed to write a multitude of different client-defined events into PlayStream. It supports a flexible
     * JSON schema, which allowsfor arbitrary key-value pairs to describe any title-based event. The created event will be
     * locked to the authenticated title.
     */
    public static class WriteTitleEventRequest {
        /** Custom event properties. Each property consists of a name (string) and a value (JSON object). */
        public Map<String,Object> Body;
        /**
         * The name of the event, within the namespace scoped to the title. The naming convention is up to the caller, but it
         * commonly follows the subject_verb_object pattern (e.g. player_logged_in).
         */
        public String EventName;
        /** The time (in UTC) associated with this event. The value dafaults to the current time. */
        public Date Timestamp;
        
    }

    public static class XboxLiveAccountPlayFabIdPair {
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Xbox Live identifier. */
        public String PlayFabId;
        /** Unique Xbox Live identifier for a user. */
        public String XboxLiveAccountId;
        
    }

}
