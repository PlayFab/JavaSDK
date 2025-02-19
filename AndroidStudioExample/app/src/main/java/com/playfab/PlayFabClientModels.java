package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabClientModels {

    @Deprecated
    public static class AcceptTradeRequest {
        /**
         * Items from the accepting player's inventory in exchange for the offered items in the trade. In the case of a gift, this
         * will be null.
         */
        @Deprecated
        public ArrayList<String> AcceptedInventoryInstanceIds;
        /** Player who opened the trade. */
        @Deprecated
        public String OfferingPlayerId;
        /** Trade identifier. */
        @Deprecated
        public String TradeId;
        
    }

    @Deprecated
    public static class AcceptTradeResponse {
        /** Details about trade which was just accepted. */
        @Deprecated
        public TradeInfo Trade;
        
    }

    @Deprecated
    public static enum AdActivity {
        Opened,
        Closed,
        Start,
        End
    }

    @Deprecated
    public static class AdCampaignAttributionModel {
        /** UTC time stamp of attribution */
        @Deprecated
        public Date AttributedAt;
        /** Attribution campaign identifier */
        @Deprecated
        public String CampaignId;
        /** Attribution network name */
        @Deprecated
        public String Platform;
        
    }

    @Deprecated
    public static class AddFriendRequest {
        /** Email address of the user to attempt to add to the local user's friend list. */
        @Deprecated
        public String FriendEmail;
        /** PlayFab identifier of the user to attempt to add to the local user's friend list. */
        @Deprecated
        public String FriendPlayFabId;
        /** Title-specific display name of the user to attempt to add to the local user's friend list. */
        @Deprecated
        public String FriendTitleDisplayName;
        /** PlayFab username of the user to attempt to add to the local user's friend list. */
        @Deprecated
        public String FriendUsername;
        
    }

    @Deprecated
    public static class AddFriendResult {
        /** True if the friend request was processed successfully. */
        @Deprecated
        public Boolean Created;
        
    }

    @Deprecated
    public static class AddGenericIDRequest {
        /** Generic service identifier to add to the player account. */
        @Deprecated
        public GenericServiceId GenericId;
        
    }

    @Deprecated
    public static class AddGenericIDResult {
        
    }

    /**
     * This API adds a contact email to the player's profile. If the player's profile already contains a contact email, it will
     * update the contact email to the email address specified.
     */
    @Deprecated
    public static class AddOrUpdateContactEmailRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The new contact email to associate with the player. */
        @Deprecated
        public String EmailAddress;
        
    }

    @Deprecated
    public static class AddOrUpdateContactEmailResult {
        
    }

    @Deprecated
    public static class AddSharedGroupMembersRequest {
        /** An array of unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public ArrayList<String> PlayFabIds;
        /** Unique identifier for the shared group. */
        @Deprecated
        public String SharedGroupId;
        
    }

    @Deprecated
    public static class AddSharedGroupMembersResult {
        
    }

    @Deprecated
    public static class AddUsernamePasswordRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** User email address attached to their account */
        @Deprecated
        public String Email;
        /** Password for the PlayFab account (6-100 characters) */
        @Deprecated
        public String Password;
        /** PlayFab username for the account (3-20 characters) */
        @Deprecated
        public String Username;
        
    }

    /**
     * Each account must have a unique username and email address in the PlayFab service. Once created, the account may be
     * associated with additional accounts (Steam, Facebook, Game Center, etc.), allowing for added social network lists and
     * achievements systems. This can also be used to provide a recovery method if the user loses their original means of
     * access.
     */
    @Deprecated
    public static class AddUsernamePasswordResult {
        /** PlayFab unique user name. */
        @Deprecated
        public String Username;
        
    }

    /** This API must be enabled for use as an option in the game manager website. It is disabled by default. */
    @Deprecated
    public static class AddUserVirtualCurrencyRequest {
        /** Amount to be added to the user balance of the specified virtual currency. */
        @Deprecated
        public Integer Amount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Name of the virtual currency which is to be incremented. */
        @Deprecated
        public String VirtualCurrency;
        
    }

    /** A single ad placement details including placement and reward information */
    @Deprecated
    public static class AdPlacementDetails {
        /** Placement unique ID */
        @Deprecated
        public String PlacementId;
        /** Placement name */
        @Deprecated
        public String PlacementName;
        /** If placement has viewing limits indicates how many views are left */
        @Deprecated
        public Integer PlacementViewsRemaining;
        /** If placement has viewing limits indicates when they will next reset */
        @Deprecated
        public Double PlacementViewsResetMinutes;
        /** Optional URL to a reward asset */
        @Deprecated
        public String RewardAssetUrl;
        /** Reward description */
        @Deprecated
        public String RewardDescription;
        /** Reward unique ID */
        @Deprecated
        public String RewardId;
        /** Reward name */
        @Deprecated
        public String RewardName;
        
    }

    /** Details for each item granted */
    @Deprecated
    public static class AdRewardItemGranted {
        /** Catalog ID */
        @Deprecated
        public String CatalogId;
        /** Catalog item display name */
        @Deprecated
        public String DisplayName;
        /** Inventory instance ID */
        @Deprecated
        public String InstanceId;
        /** Item ID */
        @Deprecated
        public String ItemId;
        
    }

    /** Details on what was granted to the player */
    @Deprecated
    public static class AdRewardResults {
        /** Array of the items granted to the player */
        @Deprecated
        public ArrayList<AdRewardItemGranted> GrantedItems;
        /** Dictionary of virtual currencies that were granted to the player */
        @Deprecated
        public Map<String,Integer> GrantedVirtualCurrencies;
        /** Dictionary of statistics that were modified for the player */
        @Deprecated
        public Map<String,Integer> IncrementedStatistics;
        
    }

    /**
     * More information can be found on configuring your game for the Google Cloud Messaging service in the Google developer
     * documentation, here: http://developer.android.com/google/gcm/client.html. The steps to configure and send Push
     * Notifications is described in the PlayFab tutorials, here:
     * https://docs.microsoft.com/gaming/playfab/features/engagement/push-notifications/quickstart.
     */
    @Deprecated
    public static class AndroidDevicePushNotificationRegistrationRequest {
        /** Message to display when confirming push notification. */
        @Deprecated
        public String ConfirmationMessage;
        /**
         * Registration ID provided by the Google Cloud Messaging service when the title registered to receive push notifications
         * (see the GCM documentation, here: http://developer.android.com/google/gcm/client.html).
         */
        @Deprecated
        public String DeviceToken;
        /** If true, send a test push message immediately after sucessful registration. Defaults to false. */
        @Deprecated
        public Boolean SendPushNotificationConfirmation;
        
    }

    @Deprecated
    public static class AndroidDevicePushNotificationRegistrationResult {
        
    }

    /**
     * If you have an ad attribution partner enabled, this will post an install to their service to track the device. It uses
     * the given device id to match based on clicks on ads.
     */
    @Deprecated
    public static class AttributeInstallRequest {
        /** The adid for this device. */
        @Deprecated
        public String Adid;
        /** The IdentifierForAdvertisers for iOS Devices. */
        @Deprecated
        public String Idfa;
        
    }

    @Deprecated
    public static class AttributeInstallResult {
        
    }

    @Deprecated
    public static class CancelTradeRequest {
        /** Trade identifier. */
        @Deprecated
        public String TradeId;
        
    }

    @Deprecated
    public static class CancelTradeResponse {
        /** Details about trade which was just canceled. */
        @Deprecated
        public TradeInfo Trade;
        
    }

    @Deprecated
    public static class CartItem {
        /** Description of the catalog item. */
        @Deprecated
        public String Description;
        /** Display name for the catalog item. */
        @Deprecated
        public String DisplayName;
        /** Class name to which catalog item belongs. */
        @Deprecated
        public String ItemClass;
        /** Unique identifier for the catalog item. */
        @Deprecated
        public String ItemId;
        /** Unique instance identifier for this catalog item. */
        @Deprecated
        public String ItemInstanceId;
        /** Cost of the catalog item for each applicable real world currency. */
        @Deprecated
        public Map<String,Long> RealCurrencyPrices;
        /** Amount of each applicable virtual currency which will be received as a result of purchasing this catalog item. */
        @Deprecated
        public Map<String,Long> VCAmount;
        /** Cost of the catalog item for each applicable virtual currency. */
        @Deprecated
        public Map<String,Long> VirtualCurrencyPrices;
        
    }

    /** A purchasable item from the item catalog */
    @Deprecated
    public static class CatalogItem implements Comparable<CatalogItem> {
        /**
         * defines the bundle properties for the item - bundles are items which contain other items, including random drop tables
         * and virtual currencies
         */
        @Deprecated
        public CatalogItemBundleInfo Bundle;
        /** if true, then an item instance of this type can be used to grant a character to a user. */
        @Deprecated
        public Boolean CanBecomeCharacter;
        /** catalog version for this item */
        @Deprecated
        public String CatalogVersion;
        /** defines the consumable properties (number of uses, timeout) for the item */
        @Deprecated
        public CatalogItemConsumableInfo Consumable;
        /**
         * defines the container properties for the item - what items it contains, including random drop tables and virtual
         * currencies, and what item (if any) is required to open it via the UnlockContainerItem API
         */
        @Deprecated
        public CatalogItemContainerInfo Container;
        /** game specific custom data */
        @Deprecated
        public String CustomData;
        /** text description of item, to show in-game */
        @Deprecated
        public String Description;
        /** text name for the item, to show in-game */
        @Deprecated
        public String DisplayName;
        /**
         * If the item has IsLImitedEdition set to true, and this is the first time this ItemId has been defined as a limited
         * edition item, this value determines the total number of instances to allocate for the title. Once this limit has been
         * reached, no more instances of this ItemId can be created, and attempts to purchase or grant it will return a Result of
         * false for that ItemId. If the item has already been defined to have a limited edition count, or if this value is less
         * than zero, it will be ignored.
         */
        @Deprecated
        public Integer InitialLimitedEditionCount;
        /** BETA: If true, then only a fixed number can ever be granted. */
        @Deprecated
        public Boolean IsLimitedEdition;
        /**
         * if true, then only one item instance of this type will exist and its remaininguses will be incremented instead.
         * RemainingUses will cap out at Int32.Max (2,147,483,647). All subsequent increases will be discarded
         */
        @Deprecated
        public Boolean IsStackable;
        /** if true, then an item instance of this type can be traded between players using the trading APIs */
        @Deprecated
        public Boolean IsTradable;
        /** class to which the item belongs */
        @Deprecated
        public String ItemClass;
        /** unique identifier for this item */
        @Deprecated
        public String ItemId;
        /**
         * URL to the item image. For Facebook purchase to display the image on the item purchase page, this must be set to an HTTP
         * URL.
         */
        @Deprecated
        public String ItemImageUrl;
        /** override prices for this item for specific currencies */
        @Deprecated
        public Map<String,Long> RealCurrencyPrices;
        /** list of item tags */
        @Deprecated
        @Unordered
        public ArrayList<String> Tags;
        /** price of this item in virtual currencies and "RM" (the base Real Money purchase price, in USD pennies) */
        @Deprecated
        public Map<String,Long> VirtualCurrencyPrices;
        
        public int compareTo(CatalogItem other) {
            if (other == null || other.ItemId == null) return 1;
            if (ItemId == null) return -1;
            return ItemId.compareTo(other.ItemId);
        }
    }

    @Deprecated
    public static class CatalogItemBundleInfo {
        /** unique ItemId values for all items which will be added to the player inventory when the bundle is added */
        @Deprecated
        @Unordered
        public ArrayList<String> BundledItems;
        /**
         * unique TableId values for all RandomResultTable objects which are part of the bundle (random tables will be resolved and
         * add the relevant items to the player inventory when the bundle is added)
         */
        @Deprecated
        @Unordered
        public ArrayList<String> BundledResultTables;
        /** virtual currency types and balances which will be added to the player inventory when the bundle is added */
        @Deprecated
        public Map<String,Long> BundledVirtualCurrencies;
        
    }

    @Deprecated
    public static class CatalogItemConsumableInfo {
        /** number of times this object can be used, after which it will be removed from the player inventory */
        @Deprecated
        public Long UsageCount;
        /**
         * duration in seconds for how long the item will remain in the player inventory - once elapsed, the item will be removed
         * (recommended minimum value is 5 seconds, as lower values can cause the item to expire before operations depending on
         * this item's details have completed)
         */
        @Deprecated
        public Long UsagePeriod;
        /**
         * all inventory item instances in the player inventory sharing a non-null UsagePeriodGroup have their UsagePeriod values
         * added together, and share the result - when that period has elapsed, all the items in the group will be removed
         */
        @Deprecated
        public String UsagePeriodGroup;
        
    }

    /**
     * Containers are inventory items that can hold other items defined in the catalog, as well as virtual currency, which is
     * added to the player inventory when the container is unlocked, using the UnlockContainerItem API. The items can be
     * anything defined in the catalog, as well as RandomResultTable objects which will be resolved when the container is
     * unlocked. Containers and their keys should be defined as Consumable (having a limited number of uses) in their catalog
     * defintiions, unless the intent is for the player to be able to re-use them infinitely.
     */
    @Deprecated
    public static class CatalogItemContainerInfo {
        /** unique ItemId values for all items which will be added to the player inventory, once the container has been unlocked */
        @Deprecated
        @Unordered
        public ArrayList<String> ItemContents;
        /**
         * ItemId for the catalog item used to unlock the container, if any (if not specified, a call to UnlockContainerItem will
         * open the container, adding the contents to the player inventory and currency balances)
         */
        @Deprecated
        public String KeyItemId;
        /**
         * unique TableId values for all RandomResultTable objects which are part of the container (once unlocked, random tables
         * will be resolved and add the relevant items to the player inventory)
         */
        @Deprecated
        @Unordered
        public ArrayList<String> ResultTableContents;
        /** virtual currency types and balances which will be added to the player inventory when the container is unlocked */
        @Deprecated
        public Map<String,Long> VirtualCurrencyContents;
        
    }

    @Deprecated
    public static class CharacterInventory {
        /** The id of this character. */
        @Deprecated
        public String CharacterId;
        /** The inventory of this character. */
        @Deprecated
        public ArrayList<ItemInstance> Inventory;
        
    }

    @Deprecated
    public static class CharacterLeaderboardEntry {
        /** PlayFab unique identifier of the character that belongs to the user for this leaderboard entry. */
        @Deprecated
        public String CharacterId;
        /** Title-specific display name of the character for this leaderboard entry. */
        @Deprecated
        public String CharacterName;
        /** Name of the character class for this entry. */
        @Deprecated
        public String CharacterType;
        /** Title-specific display name of the user for this leaderboard entry. */
        @Deprecated
        public String DisplayName;
        /** PlayFab unique identifier of the user for this leaderboard entry. */
        @Deprecated
        public String PlayFabId;
        /** User's overall position in the leaderboard. */
        @Deprecated
        public Integer Position;
        /** Specific value of the user's statistic. */
        @Deprecated
        public Integer StatValue;
        
    }

    @Deprecated
    public static class CharacterResult {
        /** The id for this character on this player. */
        @Deprecated
        public String CharacterId;
        /** The name of this character. */
        @Deprecated
        public String CharacterName;
        /** The type-string that was given to this character on creation. */
        @Deprecated
        public String CharacterType;
        
    }

    @Deprecated
    public static enum CloudScriptRevisionOption {
        Live,
        Latest,
        Specific
    }

    /**
     * The final step in the purchasing process, this API finalizes the purchase with the payment provider, where applicable,
     * adding virtual goods to the player inventory (including random drop table resolution and recursive addition of bundled
     * items) and adjusting virtual currency balances for funds used or added. Note that this is a pull operation, and should
     * be polled regularly when a purchase is in progress. Please note that the processing time for inventory grants and
     * purchases increases fractionally the more items are in the inventory, and the more items are in the grant/purchase
     * operation.
     */
    @Deprecated
    public static class ConfirmPurchaseRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Purchase order identifier returned from StartPurchase. */
        @Deprecated
        public String OrderId;
        
    }

    /**
     * When the FailedByPaymentProvider error is returned, it's important to check the ProviderErrorCode, ProviderErrorMessage,
     * and ProviderErrorDetails to understand the specific reason the payment was rejected, as in some rare cases, this may
     * mean that the provider hasn't completed some operation required to finalize the purchase.
     */
    @Deprecated
    public static class ConfirmPurchaseResult {
        /** Array of items purchased. */
        @Deprecated
        public ArrayList<ItemInstance> Items;
        /** Purchase order identifier. */
        @Deprecated
        public String OrderId;
        /** Date and time of the purchase. */
        @Deprecated
        public Date PurchaseDate;
        
    }

    @Deprecated
    public static class ConsumeItemRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Number of uses to consume from the item. */
        @Deprecated
        public Integer ConsumeCount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique instance identifier of the item to be consumed. */
        @Deprecated
        public String ItemInstanceId;
        
    }

    @Deprecated
    public static class ConsumeItemResult {
        /** Unique instance identifier of the item with uses consumed. */
        @Deprecated
        public String ItemInstanceId;
        /** Number of uses remaining on the item. */
        @Deprecated
        public Integer RemainingUses;
        
    }

    @Deprecated
    public static class ConsumeMicrosoftStoreEntitlementsRequest {
        /** Catalog version to use */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Marketplace specific payload containing details to fetch in app purchase transactions */
        @Deprecated
        public MicrosoftStorePayload MarketplaceSpecificData;
        
    }

    @Deprecated
    public static class ConsumeMicrosoftStoreEntitlementsResponse {
        /** Details for the items purchased. */
        @Deprecated
        public ArrayList<ItemInstance> Items;
        
    }

    @Deprecated
    public static class ConsumePS5EntitlementsRequest {
        /** Catalog version to use */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Marketplace specific payload containing details to fetch in app purchase transactions */
        @Deprecated
        public PlayStation5Payload MarketplaceSpecificData;
        
    }

    @Deprecated
    public static class ConsumePS5EntitlementsResult {
        /** Details for the items purchased. */
        @Deprecated
        public ArrayList<ItemInstance> Items;
        
    }

    @Deprecated
    public static class ConsumePSNEntitlementsRequest {
        /** Which catalog to match granted entitlements against. If null, defaults to title default catalog */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Id of the PlayStation :tm: Network service label to consume entitlements from */
        @Deprecated
        public Integer ServiceLabel;
        
    }

    @Deprecated
    public static class ConsumePSNEntitlementsResult {
        /** Array of items granted to the player as a result of consuming entitlements. */
        @Deprecated
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> ItemsGranted;
        
    }

    @Deprecated
    public static class ConsumeXboxEntitlementsRequest {
        /** Catalog version to use */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Token provided by the Xbox Live SDK/XDK method GetTokenAndSignatureAsync("POST", "https://playfabapi.com/", ""). */
        @Deprecated
        public String XboxToken;
        
    }

    @Deprecated
    public static class ConsumeXboxEntitlementsResult {
        /** Details for the items purchased. */
        @Deprecated
        public ArrayList<ItemInstance> Items;
        
    }

    @Deprecated
    public static class ContactEmailInfoModel {
        /** The email address */
        @Deprecated
        public String EmailAddress;
        /** The name of the email info data */
        @Deprecated
        public String Name;
        /** The verification status of the email */
        @Deprecated
        public EmailVerificationStatus VerificationStatus;
        
    }

    @Deprecated
    public static enum ContinentCode {
        AF,
        AN,
        AS,
        EU,
        NA,
        OC,
        SA,
        Unknown
    }

    @Deprecated
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
        ZW,
        Unknown
    }

    /**
     * If SharedGroupId is specified, the service will attempt to create a group with that identifier, and will return an error
     * if it is already in use. If no SharedGroupId is specified, a random identifier will be assigned.
     */
    @Deprecated
    public static class CreateSharedGroupRequest {
        /** Unique identifier for the shared group (a random identifier will be assigned, if one is not specified). */
        @Deprecated
        public String SharedGroupId;
        
    }

    @Deprecated
    public static class CreateSharedGroupResult {
        /** Unique identifier for the shared group. */
        @Deprecated
        public String SharedGroupId;
        
    }

    @Deprecated
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

    /** Any arbitrary information collected by the device */
    @Deprecated
    public static class DeviceInfoRequest {
        /** Information posted to the PlayStream Event. Currently arbitrary, and specific to the environment sending it. */
        @Deprecated
        public Map<String,Object> Info;
        
    }

    @Deprecated
    public static enum EmailVerificationStatus {
        Unverified,
        Pending,
        Confirmed
    }

    @Deprecated
    public static class EmptyResponse {
        
    }

    @Deprecated
    public static class EmptyResult {
        
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
    public static class EntityTokenResponse {
        /** The entity id and type. */
        @Deprecated
        public EntityKey Entity;
        /** The token used to set X-EntityToken for all entity based API calls. */
        @Deprecated
        public String EntityToken;
        /** The time the token will expire, if it is an expiring token, in UTC. */
        @Deprecated
        public Date TokenExpiration;
        
    }

    @Deprecated
    public static class ExecuteCloudScriptRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the CloudScript function to execute */
        @Deprecated
        public String FunctionName;
        /** Object that is passed in to the function as the first argument */
        @Deprecated
        public Object FunctionParameter;
        /**
         * Generate a 'player_executed_cloudscript' PlayStream event containing the results of the function execution and other
         * contextual information. This event will show up in the PlayStream debugger console for the player in Game Manager.
         */
        @Deprecated
        public Boolean GeneratePlayStreamEvent;
        /**
         * Option for which revision of the CloudScript to execute. 'Latest' executes the most recently created revision, 'Live'
         * executes the current live, published revision, and 'Specific' executes the specified revision. The default value is
         * 'Specific', if the SpeificRevision parameter is specified, otherwise it is 'Live'.
         */
        @Deprecated
        public CloudScriptRevisionOption RevisionSelection;
        /** The specivic revision to execute, when RevisionSelection is set to 'Specific' */
        @Deprecated
        public Integer SpecificRevision;
        
    }

    @Deprecated
    public static class ExecuteCloudScriptResult {
        /** Number of PlayFab API requests issued by the CloudScript function */
        @Deprecated
        public Integer APIRequestsIssued;
        /** Information about the error, if any, that occurred during execution */
        @Deprecated
        public ScriptExecutionError Error;
        @Deprecated
        public Double ExecutionTimeSeconds;
        /** The name of the function that executed */
        @Deprecated
        public String FunctionName;
        /** The object returned from the CloudScript function, if any */
        @Deprecated
        public Object FunctionResult;
        /**
         * Flag indicating if the FunctionResult was too large and was subsequently dropped from this event. This only occurs if
         * the total event size is larger than 350KB.
         */
        @Deprecated
        public Boolean FunctionResultTooLarge;
        /** Number of external HTTP requests issued by the CloudScript function */
        @Deprecated
        public Integer HttpRequestsIssued;
        /**
         * Entries logged during the function execution. These include both entries logged in the function code using log.info()
         * and log.error() and error entries for API and HTTP request failures.
         */
        @Deprecated
        public ArrayList<LogStatement> Logs;
        /**
         * Flag indicating if the logs were too large and were subsequently dropped from this event. This only occurs if the total
         * event size is larger than 350KB after the FunctionResult was removed.
         */
        @Deprecated
        public Boolean LogsTooLarge;
        @Deprecated
        public Long MemoryConsumedBytes;
        /**
         * Processor time consumed while executing the function. This does not include time spent waiting on API calls or HTTP
         * requests.
         */
        @Deprecated
        public Double ProcessorTimeSeconds;
        /** The revision of the CloudScript that executed */
        @Deprecated
        public Integer Revision;
        
    }

    @Deprecated
    public static enum ExternalFriendSources {
        None,
        Steam,
        Facebook,
        Xbox,
        Psn,
        All
    }

    @Deprecated
    public static class FacebookInstantGamesPlayFabIdPair {
        /** Unique Facebook Instant Games identifier for a user. */
        @Deprecated
        public String FacebookInstantGamesId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Facebook Instant Games identifier. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class FacebookPlayFabIdPair {
        /** Unique Facebook identifier for a user. */
        @Deprecated
        public String FacebookId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Facebook identifier. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class FriendInfo {
        /** Available Facebook information (if the user and connected Facebook friend both have PlayFab Accounts in the same title). */
        @Deprecated
        public UserFacebookInfo FacebookInfo;
        /** PlayFab unique identifier for this friend. */
        @Deprecated
        public String FriendPlayFabId;
        /**
         * Available Game Center information (if the user and connected Game Center friend both have PlayFab Accounts in the same
         * title).
         */
        @Deprecated
        public UserGameCenterInfo GameCenterInfo;
        /** The profile of the user, if requested. */
        @Deprecated
        public PlayerProfileModel Profile;
        /**
         * Available PlayStation :tm: Network information, if the user connected PlayStation :tm Network friend both have PlayFab
         * Accounts in the same title.
         */
        @Deprecated
        public UserPsnInfo PSNInfo;
        /** Available Steam information (if the user and connected Steam friend both have PlayFab Accounts in the same title). */
        @Deprecated
        public UserSteamInfo SteamInfo;
        /** Tags which have been associated with this friend. */
        @Deprecated
        public ArrayList<String> Tags;
        /** Title-specific display name for this friend. */
        @Deprecated
        public String TitleDisplayName;
        /** PlayFab unique username for this friend. */
        @Deprecated
        public String Username;
        /** Available Xbox information, (if the user and connected Xbox Live friend both have PlayFab Accounts in the same title). */
        @Deprecated
        public UserXboxInfo XboxInfo;
        
    }

    @Deprecated
    public static class GameCenterPlayFabIdPair {
        /** Unique Game Center identifier for a user. */
        @Deprecated
        public String GameCenterId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Game Center identifier. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GenericPlayFabIdPair {
        /** Unique generic service identifier for a user. */
        @Deprecated
        public GenericServiceId GenericId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the given generic identifier. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GenericServiceId {
        /** Name of the service for which the player has a unique identifier. */
        @Deprecated
        public String ServiceName;
        /** Unique identifier of the player in that service. */
        @Deprecated
        public String UserId;
        
    }

    @Deprecated
    public static class GetAccountInfoRequest {
        /** User email address for the account to find (if no Username is specified). */
        @Deprecated
        public String Email;
        /**
         * Unique PlayFab identifier of the user whose info is being requested. Optional, defaults to the authenticated user if no
         * other lookup identifier set.
         */
        @Deprecated
        public String PlayFabId;
        /**
         * Title-specific username for the account to find (if no Email is set). Note that if the non-unique Title Display Names
         * option is enabled for the title, attempts to look up users by Title Display Name will always return AccountNotFound.
         */
        @Deprecated
        public String TitleDisplayName;
        /** PlayFab Username for the account to find (if no PlayFabId is specified). */
        @Deprecated
        public String Username;
        
    }

    /**
     * This API retrieves details regarding the player in the PlayFab service. Note that when this call is used to retrieve
     * data about another player (not the one signed into the local client), some data, such as Personally Identifying
     * Information (PII), will be omitted for privacy reasons or to comply with the requirements of the platform belongs to.
     * The user account returned will be based on the identifier provided in priority order: PlayFabId, Username, Email, then
     * TitleDisplayName. If no identifier is specified, the currently signed in user's information will be returned.
     */
    @Deprecated
    public static class GetAccountInfoResult {
        /** Account information for the local user. */
        @Deprecated
        public UserAccountInfo AccountInfo;
        
    }

    /** Using an AppId to return a list of valid ad placements for a player. */
    @Deprecated
    public static class GetAdPlacementsRequest {
        /** The current AppId to use */
        @Deprecated
        public String AppId;
        /** Using the name or unique identifier, filter the result for get a specific placement. */
        @Deprecated
        public NameIdentifier Identifier;
        
    }

    /** Array of AdPlacementDetails */
    @Deprecated
    public static class GetAdPlacementsResult {
        /** Array of results */
        @Deprecated
        public ArrayList<AdPlacementDetails> AdPlacements;
        
    }

    @Deprecated
    public static class GetCatalogItemsRequest {
        /** Which catalog is being requested. If null, uses the default catalog. */
        @Deprecated
        public String CatalogVersion;
        
    }

    /**
     * If CatalogVersion is not specified, only inventory items associated with the most recent version of the catalog will be
     * returned.
     */
    @Deprecated
    public static class GetCatalogItemsResult {
        /** Array of items which can be purchased. */
        @Deprecated
        @Unordered("ItemId")
        public ArrayList<CatalogItem> Catalog;
        
    }

    /**
     * Data is stored as JSON key-value pairs. If the Keys parameter is provided, the data object returned will only contain
     * the data specific to the indicated Keys. Otherwise, the full set of custom character data will be returned.
     */
    @Deprecated
    public static class GetCharacterDataRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /**
         * The version that currently exists according to the caller. The call will return the data for all of the keys if the
         * version in the system is greater than this.
         */
        @Deprecated
        public Long IfChangedFromDataVersion;
        /** Specific keys to search for in the custom user data. */
        @Deprecated
        public ArrayList<String> Keys;
        /** Unique PlayFab identifier of the user to load data for. Optional, defaults to yourself if not set. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetCharacterDataResult {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** User specific data for this title. */
        @Deprecated
        public Map<String,UserDataRecord> Data;
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of
         * data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        @Deprecated
        public Long DataVersion;
        
    }

    /**
     * All items currently in the character inventory will be returned, irrespective of how they were acquired (via purchasing,
     * grants, coupons, etc.). Items that are expired, fully consumed, or are no longer valid are not considered to be in the
     * user's current inventory, and so will not be not included. Also returns their virtual currency balances.
     */
    @Deprecated
    public static class GetCharacterInventoryRequest {
        /** Used to limit results to only those from a specific catalog version. */
        @Deprecated
        public String CatalogVersion;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class GetCharacterInventoryResult {
        /** Unique identifier of the character for this inventory. */
        @Deprecated
        public String CharacterId;
        /** Array of inventory items belonging to the character. */
        @Deprecated
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> Inventory;
        /** Array of virtual currency balance(s) belonging to the character. */
        @Deprecated
        public Map<String,Integer> VirtualCurrency;
        /** Array of remaining times and timestamps for virtual currencies. */
        @Deprecated
        public Map<String,VirtualCurrencyRechargeTime> VirtualCurrencyRechargeTimes;
        
    }

    @Deprecated
    public static class GetCharacterLeaderboardRequest {
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        @Deprecated
        public Integer MaxResultsCount;
        /** First entry in the leaderboard to be retrieved. */
        @Deprecated
        public Integer StartPosition;
        /** Unique identifier for the title-specific statistic for the leaderboard. */
        @Deprecated
        public String StatisticName;
        
    }

    /** Note that the Position of the character in the results is for the overall leaderboard. */
    @Deprecated
    public static class GetCharacterLeaderboardResult {
        /** Ordered list of leaderboard entries. */
        @Deprecated
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    @Deprecated
    public static class GetCharacterStatisticsRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        
    }

    /** In addition to being available for use by the title, the statistics are used for all leaderboard operations in PlayFab. */
    @Deprecated
    public static class GetCharacterStatisticsResult {
        /** The requested character statistics. */
        @Deprecated
        public Map<String,Integer> CharacterStatistics;
        
    }

    @Deprecated
    public static class GetContentDownloadUrlRequest {
        /** HTTP method to fetch item - GET or HEAD. Use HEAD when only fetching metadata. Default is GET. */
        @Deprecated
        public String HttpMethod;
        /** Key of the content item to fetch, usually formatted as a path, e.g. images/a.png */
        @Deprecated
        public String Key;
        /**
         * True to download through CDN. CDN provides higher download bandwidth and lower latency. However, if you want the latest,
         * non-cached version of the content during development, set this to false. Default is true.
         */
        @Deprecated
        public Boolean ThruCDN;
        
    }

    @Deprecated
    public static class GetContentDownloadUrlResult {
        /** URL for downloading content via HTTP GET or HEAD method. The URL will expire in approximately one hour. */
        @Deprecated
        public String URL;
        
    }

    @Deprecated
    public static class GetFriendLeaderboardAroundPlayerRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Indicates which other platforms' friends should be included in the response. In HTTP, it is represented as a
         * comma-separated list of platforms.
         */
        @Deprecated
        public ExternalFriendSources ExternalPlatformFriends;
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        @Deprecated
        public Integer MaxResultsCount;
        /** PlayFab unique identifier of the user to center the leaderboard around. If null will center on the logged in user. */
        @Deprecated
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        @Deprecated
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Statistic used to rank players for this leaderboard. */
        @Deprecated
        public String StatisticName;
        /** The version of the leaderboard to get. */
        @Deprecated
        public Integer Version;
        /** Xbox token if Xbox friends should be included. Requires Xbox be configured on PlayFab. */
        @Deprecated
        public String XboxToken;
        
    }

    /**
     * Note: When calling 'GetLeaderboardAround...' APIs, the position of the user defaults to 0 when the user does not have
     * the corresponding statistic.If Facebook friends are included, make sure the access token from previous LoginWithFacebook
     * call is still valid and not expired. If Xbox Live friends are included, make sure the access token from the previous
     * LoginWithXbox call is still valid and not expired.
     */
    @Deprecated
    public static class GetFriendLeaderboardAroundPlayerResult {
        /** Ordered listing of users and their positions in the requested leaderboard. */
        @Deprecated
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        /** The time the next scheduled reset will occur. Null if the leaderboard does not reset on a schedule. */
        @Deprecated
        public Date NextReset;
        /** The version of the leaderboard returned. */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static class GetFriendLeaderboardRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Indicates which other platforms' friends should be included in the response. In HTTP, it is represented as a
         * comma-separated list of platforms.
         */
        @Deprecated
        public ExternalFriendSources ExternalPlatformFriends;
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        @Deprecated
        public Integer MaxResultsCount;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        @Deprecated
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Position in the leaderboard to start this listing (defaults to the first entry). */
        @Deprecated
        public Integer StartPosition;
        /** Statistic used to rank friends for this leaderboard. */
        @Deprecated
        public String StatisticName;
        /** The version of the leaderboard to get. */
        @Deprecated
        public Integer Version;
        /** Xbox token if Xbox friends should be included. Requires Xbox be configured on PlayFab. */
        @Deprecated
        public String XboxToken;
        
    }

    @Deprecated
    public static class GetFriendsListRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Indicates which other platforms' friends should be included in the response. In HTTP, it is represented as a
         * comma-separated list of platforms.
         */
        @Deprecated
        public ExternalFriendSources ExternalPlatformFriends;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        @Deprecated
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Xbox token if Xbox friends should be included. Requires Xbox be configured on PlayFab. */
        @Deprecated
        public String XboxToken;
        
    }

    /**
     * If any additional services are queried for the user's friends, those friends who also have a PlayFab account registered
     * for the title will be returned in the results. For Facebook, user has to have logged into the title's Facebook app
     * recently, and only friends who also plays this game will be included. Note: If the user authenticated with
     * AuthenticationToken when calling LoginWithFacebook, instead of AcessToken, an empty list will be returned. For Xbox
     * Live, user has to have logged into the Xbox Live recently, and only friends who also play this game will be included.
     */
    @Deprecated
    public static class GetFriendsListResult {
        /** Array of friends found. */
        @Deprecated
        public ArrayList<FriendInfo> Friends;
        
    }

    @Deprecated
    public static class GetLeaderboardAroundCharacterRequest {
        /** Unique PlayFab assigned ID for a specific character on which to center the leaderboard. */
        @Deprecated
        public String CharacterId;
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        @Deprecated
        public Integer MaxResultsCount;
        /** Unique identifier for the title-specific statistic for the leaderboard. */
        @Deprecated
        public String StatisticName;
        
    }

    /**
     * Note: When calling 'GetLeaderboardAround...' APIs, the position of the character defaults to 0 when the character does
     * not have the corresponding statistic.
     */
    @Deprecated
    public static class GetLeaderboardAroundCharacterResult {
        /** Ordered list of leaderboard entries. */
        @Deprecated
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    @Deprecated
    public static class GetLeaderboardAroundPlayerRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        @Deprecated
        public Integer MaxResultsCount;
        /** PlayFab unique identifier of the user to center the leaderboard around. If null will center on the logged in user. */
        @Deprecated
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        @Deprecated
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Statistic used to rank players for this leaderboard. */
        @Deprecated
        public String StatisticName;
        /** The version of the leaderboard to get. */
        @Deprecated
        public Integer Version;
        
    }

    /**
     * Note: When calling 'GetLeaderboardAround...' APIs, the position of the user defaults to 0 when the user does not have
     * the corresponding statistic.
     */
    @Deprecated
    public static class GetLeaderboardAroundPlayerResult {
        /** Ordered listing of users and their positions in the requested leaderboard. */
        @Deprecated
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        /** The time the next scheduled reset will occur. Null if the leaderboard does not reset on a schedule. */
        @Deprecated
        public Date NextReset;
        /** The version of the leaderboard returned. */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static class GetLeaderboardForUsersCharactersRequest {
        /** Unique identifier for the title-specific statistic for the leaderboard. */
        @Deprecated
        public String StatisticName;
        
    }

    /**
     * NOTE: The position of the character in the results is relative to the other characters for that specific user. This mean
     * the values will always be between 0 and one less than the number of characters returned regardless of the size of the
     * actual leaderboard.
     */
    @Deprecated
    public static class GetLeaderboardForUsersCharactersResult {
        /** Ordered list of leaderboard entries. */
        @Deprecated
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    @Deprecated
    public static class GetLeaderboardRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Maximum number of entries to retrieve. Default 10, maximum 100. */
        @Deprecated
        public Integer MaxResultsCount;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        @Deprecated
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Position in the leaderboard to start this listing (defaults to the first entry). */
        @Deprecated
        public Integer StartPosition;
        /** Statistic used to rank players for this leaderboard. */
        @Deprecated
        public String StatisticName;
        /** The version of the leaderboard to get. */
        @Deprecated
        public Integer Version;
        
    }

    /** Note: the user's Position is relative to the overall leaderboard. */
    @Deprecated
    public static class GetLeaderboardResult {
        /** Ordered listing of users and their positions in the requested leaderboard. */
        @Deprecated
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        /** The time the next scheduled reset will occur. Null if the leaderboard does not reset on a schedule. */
        @Deprecated
        public Date NextReset;
        /** The version of the leaderboard returned. */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static class GetPaymentTokenRequest {
        /** The name of service to provide the payment token. Allowed Values are: xsolla */
        @Deprecated
        public String TokenProvider;
        
    }

    @Deprecated
    public static class GetPaymentTokenResult {
        /** PlayFab's purchase order identifier. */
        @Deprecated
        public String OrderId;
        /** The token from provider. */
        @Deprecated
        public String ProviderToken;
        
    }

    @Deprecated
    public static class GetPhotonAuthenticationTokenRequest {
        /** The Photon applicationId for the game you wish to log into. */
        @Deprecated
        public String PhotonApplicationId;
        
    }

    @Deprecated
    public static class GetPhotonAuthenticationTokenResult {
        /** The Photon authentication token for this game-session. */
        @Deprecated
        public String PhotonCustomAuthenticationToken;
        
    }

    @Deprecated
    public static class GetPlayerCombinedInfoRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** PlayFabId of the user whose data will be returned. If not filled included, we return the data for the calling player. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetPlayerCombinedInfoRequestParams {
        /** Whether to get character inventories. Defaults to false. */
        @Deprecated
        public Boolean GetCharacterInventories;
        /** Whether to get the list of characters. Defaults to false. */
        @Deprecated
        public Boolean GetCharacterList;
        /** Whether to get player profile. Defaults to false. Has no effect for a new player. */
        @Deprecated
        public Boolean GetPlayerProfile;
        /** Whether to get player statistics. Defaults to false. */
        @Deprecated
        public Boolean GetPlayerStatistics;
        /** Whether to get title data. Defaults to false. */
        @Deprecated
        public Boolean GetTitleData;
        /** Whether to get the player's account Info. Defaults to false */
        @Deprecated
        public Boolean GetUserAccountInfo;
        /** Whether to get the player's custom data. Defaults to false */
        @Deprecated
        public Boolean GetUserData;
        /** Whether to get the player's inventory. Defaults to false */
        @Deprecated
        public Boolean GetUserInventory;
        /** Whether to get the player's read only data. Defaults to false */
        @Deprecated
        public Boolean GetUserReadOnlyData;
        /** Whether to get the player's virtual currency balances. Defaults to false */
        @Deprecated
        public Boolean GetUserVirtualCurrency;
        /** Specific statistics to retrieve. Leave null to get all keys. Has no effect if GetPlayerStatistics is false */
        @Deprecated
        public ArrayList<String> PlayerStatisticNames;
        /** Specifies the properties to return from the player profile. Defaults to returning the player's display name. */
        @Deprecated
        public PlayerProfileViewConstraints ProfileConstraints;
        /** Specific keys to search for in the custom data. Leave null to get all keys. Has no effect if GetTitleData is false */
        @Deprecated
        public ArrayList<String> TitleDataKeys;
        /** Specific keys to search for in the custom data. Leave null to get all keys. Has no effect if GetUserData is false */
        @Deprecated
        public ArrayList<String> UserDataKeys;
        /**
         * Specific keys to search for in the custom data. Leave null to get all keys. Has no effect if GetUserReadOnlyData is
         * false
         */
        @Deprecated
        public ArrayList<String> UserReadOnlyDataKeys;
        
    }

    /**
     * Returns whatever info is requested in the response for the user. If no user is explicitly requested this defaults to the
     * authenticated user. If the user is the same as the requester, PII (like email address, facebook id) is returned if
     * available. Otherwise, only public information is returned. All parameters default to false.
     */
    @Deprecated
    public static class GetPlayerCombinedInfoResult {
        /** Results for requested info. */
        @Deprecated
        public GetPlayerCombinedInfoResultPayload InfoResultPayload;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetPlayerCombinedInfoResultPayload {
        /** Account information for the user. This is always retrieved. */
        @Deprecated
        public UserAccountInfo AccountInfo;
        /** Inventories for each character for the user. */
        @Deprecated
        public ArrayList<CharacterInventory> CharacterInventories;
        /** List of characters for the user. */
        @Deprecated
        public ArrayList<CharacterResult> CharacterList;
        /**
         * The profile of the players. This profile is not guaranteed to be up-to-date. For a new player, this profile will not
         * exist.
         */
        @Deprecated
        public PlayerProfileModel PlayerProfile;
        /** List of statistics for this player. */
        @Deprecated
        public ArrayList<StatisticValue> PlayerStatistics;
        /** Title data for this title. */
        @Deprecated
        public Map<String,String> TitleData;
        /** User specific custom data. */
        @Deprecated
        public Map<String,UserDataRecord> UserData;
        /** The version of the UserData that was returned. */
        @Deprecated
        public Long UserDataVersion;
        /** Array of inventory items in the user's current inventory. */
        @Deprecated
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> UserInventory;
        /** User specific read-only data. */
        @Deprecated
        public Map<String,UserDataRecord> UserReadOnlyData;
        /** The version of the Read-Only UserData that was returned. */
        @Deprecated
        public Long UserReadOnlyDataVersion;
        /** Dictionary of virtual currency balance(s) belonging to the user. */
        @Deprecated
        public Map<String,Integer> UserVirtualCurrency;
        /** Dictionary of remaining times and timestamps for virtual currencies. */
        @Deprecated
        public Map<String,VirtualCurrencyRechargeTime> UserVirtualCurrencyRechargeTimes;
        
    }

    /**
     * This API allows for access to details regarding a user in the PlayFab service, usually for purposes of customer support.
     * Note that data returned may be Personally Identifying Information (PII), such as email address, and so care should be
     * taken in how this data is stored and managed. Since this call will always return the relevant information for users who
     * have accessed the title, the recommendation is to not store this data locally.
     */
    @Deprecated
    public static class GetPlayerProfileRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        @Deprecated
        public PlayerProfileViewConstraints ProfileConstraints;
        
    }

    @Deprecated
    public static class GetPlayerProfileResult {
        /**
         * The profile of the player. This profile is not guaranteed to be up-to-date. For a new player, this profile will not
         * exist.
         */
        @Deprecated
        public PlayerProfileModel PlayerProfile;
        
    }

    @Deprecated
    public static class GetPlayerSegmentsRequest {
        
    }

    @Deprecated
    public static class GetPlayerSegmentsResult {
        /** Array of segments the requested player currently belongs to. */
        @Deprecated
        public ArrayList<GetSegmentResult> Segments;
        
    }

    @Deprecated
    public static class GetPlayerStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** statistics to return (current version will be returned for each) */
        @Deprecated
        public ArrayList<String> StatisticNames;
        /**
         * statistics to return, if StatisticNames is not set (only statistics which have a version matching that provided will be
         * returned)
         */
        @Deprecated
        public ArrayList<StatisticNameVersion> StatisticNameVersions;
        
    }

    /** In addition to being available for use by the title, the statistics are used for all leaderboard operations in PlayFab. */
    @Deprecated
    public static class GetPlayerStatisticsResult {
        /** User statistics for the requested user. */
        @Deprecated
        public ArrayList<StatisticValue> Statistics;
        
    }

    @Deprecated
    public static class GetPlayerStatisticVersionsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** unique name of the statistic */
        @Deprecated
        public String StatisticName;
        
    }

    @Deprecated
    public static class GetPlayerStatisticVersionsResult {
        /** version change history of the statistic */
        @Deprecated
        public ArrayList<PlayerStatisticVersion> StatisticVersions;
        
    }

    /**
     * This API will return a list of canonical tags which includes both namespace and tag's name. If namespace is not
     * provided, the result is a list of all canonical tags. TagName can be used for segmentation and Namespace is limited to
     * 128 characters.
     */
    @Deprecated
    public static class GetPlayerTagsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Optional namespace to filter results by */
        @Deprecated
        public String Namespace;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetPlayerTagsResult {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Canonical tags (including namespace and tag's name) for the requested user */
        @Deprecated
        public ArrayList<String> Tags;
        
    }

    @Deprecated
    public static class GetPlayerTradesRequest {
        /** Returns only trades with the given status. If null, returns all trades. */
        @Deprecated
        public TradeStatus StatusFilter;
        
    }

    @Deprecated
    public static class GetPlayerTradesResponse {
        /** History of trades which this player has accepted. */
        @Deprecated
        public ArrayList<TradeInfo> AcceptedTrades;
        /** The trades for this player which are currently available to be accepted. */
        @Deprecated
        public ArrayList<TradeInfo> OpenedTrades;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromFacebookIDsRequest {
        /**
         * Array of unique Facebook identifiers for which the title needs to get PlayFab identifiers. The array cannot exceed 2,000
         * in length.
         */
        @Deprecated
        public ArrayList<String> FacebookIDs;
        
    }

    /** For Facebook identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromFacebookIDsResult {
        /** Mapping of Facebook identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<FacebookPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromFacebookInstantGamesIdsRequest {
        /**
         * Array of unique Facebook Instant Games identifiers for which the title needs to get PlayFab identifiers. The array
         * cannot exceed 25 in length.
         */
        @Deprecated
        public ArrayList<String> FacebookInstantGamesIds;
        
    }

    /** For Facebook Instant Game identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromFacebookInstantGamesIdsResult {
        /** Mapping of Facebook Instant Games identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<FacebookInstantGamesPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromGameCenterIDsRequest {
        /**
         * Array of unique Game Center identifiers (the Player Identifier) for which the title needs to get PlayFab identifiers.
         * The array cannot exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> GameCenterIDs;
        
    }

    /** For Game Center identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromGameCenterIDsResult {
        /** Mapping of Game Center identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<GameCenterPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromGenericIDsRequest {
        /**
         * Array of unique generic service identifiers for which the title needs to get PlayFab identifiers. Currently limited to a
         * maximum of 10 in a single request.
         */
        @Deprecated
        public ArrayList<GenericServiceId> GenericIDs;
        
    }

    /** For generic service identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromGenericIDsResult {
        /** Mapping of generic service identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<GenericPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromGoogleIDsRequest {
        /**
         * Array of unique Google identifiers (Google+ user IDs) for which the title needs to get PlayFab identifiers. The array
         * cannot exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> GoogleIDs;
        
    }

    /** For Google identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromGoogleIDsResult {
        /** Mapping of Google identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<GooglePlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromGooglePlayGamesPlayerIDsRequest {
        /**
         * Array of unique Google Play Games identifiers (Google+ user IDs) for which the title needs to get PlayFab identifiers.
         * The array cannot exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> GooglePlayGamesPlayerIDs;
        
    }

    /** For Google Play Games identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromGooglePlayGamesPlayerIDsResult {
        /** Mapping of Google Play Games identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<GooglePlayGamesPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromKongregateIDsRequest {
        /**
         * Array of unique Kongregate identifiers (Kongregate's user_id) for which the title needs to get PlayFab identifiers. The
         * array cannot exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> KongregateIDs;
        
    }

    /** For Kongregate identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromKongregateIDsResult {
        /** Mapping of Kongregate identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<KongregatePlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromNintendoServiceAccountIdsRequest {
        /**
         * Array of unique Nintendo Switch Account identifiers for which the title needs to get PlayFab identifiers. The array
         * cannot exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> NintendoAccountIds;
        
    }

    /** For Nintendo Service Account identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromNintendoServiceAccountIdsResult {
        /** Mapping of Nintendo Switch Service Account identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<NintendoServiceAccountPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromNintendoSwitchDeviceIdsRequest {
        /**
         * Array of unique Nintendo Switch Device identifiers for which the title needs to get PlayFab identifiers. The array
         * cannot exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> NintendoSwitchDeviceIds;
        
    }

    /** For Nintendo Switch identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromNintendoSwitchDeviceIdsResult {
        /** Mapping of Nintendo Switch Device identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<NintendoSwitchPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromPSNAccountIDsRequest {
        /** Id of the PlayStation :tm: Network issuer environment. If null, defaults to production environment. */
        @Deprecated
        public Integer IssuerId;
        /**
         * Array of unique PlayStation :tm: Network identifiers for which the title needs to get PlayFab identifiers. The array
         * cannot exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> PSNAccountIDs;
        
    }

    /** For PlayStation :tm: Network identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromPSNAccountIDsResult {
        /** Mapping of PlayStation :tm: Network identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<PSNAccountPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromPSNOnlineIDsRequest {
        /** Id of the PlayStation :tm: Network issuer environment. If null, defaults to production environment. */
        @Deprecated
        public Integer IssuerId;
        /**
         * Array of unique PlayStation :tm: Network identifiers for which the title needs to get PlayFab identifiers. The array
         * cannot exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> PSNOnlineIDs;
        
    }

    /** For PlayStation :tm: Network identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromPSNOnlineIDsResult {
        /** Mapping of PlayStation :tm: Network identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<PSNOnlinePlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromSteamIDsRequest {
        /**
         * Array of unique Steam identifiers (Steam profile IDs) for which the title needs to get PlayFab identifiers. The array
         * cannot exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> SteamStringIDs;
        
    }

    /** For Steam identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromSteamIDsResult {
        /** Mapping of Steam identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<SteamPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromSteamNamesRequest {
        /**
         * Array of unique Steam identifiers for which the title needs to get PlayFab identifiers. The array cannot exceed 2,000 in
         * length.
         */
        @Deprecated
        public ArrayList<String> SteamNames;
        
    }

    /**
     * For Steam identifiers which have not been linked to PlayFab accounts, or if the user has not logged in recently, null
     * will be returned.
     */
    @Deprecated
    public static class GetPlayFabIDsFromSteamNamesResult {
        /** Mapping of Steam identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<SteamNamePlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromTwitchIDsRequest {
        /**
         * Array of unique Twitch identifiers (Twitch's _id) for which the title needs to get PlayFab identifiers. The array cannot
         * exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> TwitchIds;
        
    }

    /** For Twitch identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromTwitchIDsResult {
        /** Mapping of Twitch identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<TwitchPlayFabIdPair> Data;
        
    }

    @Deprecated
    public static class GetPlayFabIDsFromXboxLiveIDsRequest {
        /** The ID of Xbox Live sandbox. */
        @Deprecated
        public String Sandbox;
        /**
         * Array of unique Xbox Live account identifiers for which the title needs to get PlayFab identifiers. The array cannot
         * exceed 2,000 in length.
         */
        @Deprecated
        public ArrayList<String> XboxLiveAccountIDs;
        
    }

    /** For XboxLive identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromXboxLiveIDsResult {
        /** Mapping of Xbox Live identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<XboxLiveAccountPlayFabIdPair> Data;
        
    }

    /**
     * This API is designed to return publisher-specific values which can be read, but not written to, by the client. This data
     * is shared across all titles assigned to a particular publisher, and can be used for cross-game coordination. Only titles
     * assigned to a publisher can use this API. For more information email helloplayfab@microsoft.com. Note that there may up
     * to a minute delay in between updating title data and this API call returning the newest value.
     */
    @Deprecated
    public static class GetPublisherDataRequest {
        /** array of keys to get back data from the Publisher data blob, set by the admin tools */
        @Deprecated
        public ArrayList<String> Keys;
        
    }

    @Deprecated
    public static class GetPublisherDataResult {
        /** a dictionary object of key / value pairs */
        @Deprecated
        public Map<String,String> Data;
        
    }

    @Deprecated
    public static class GetPurchaseRequest {
        /** Purchase order identifier. */
        @Deprecated
        public String OrderId;
        
    }

    @Deprecated
    public static class GetPurchaseResult {
        /** Purchase order identifier. */
        @Deprecated
        public String OrderId;
        /** Payment provider used for transaction (If not VC) */
        @Deprecated
        public String PaymentProvider;
        /** Date and time of the purchase. */
        @Deprecated
        public Date PurchaseDate;
        /** Provider transaction ID (If not VC) */
        @Deprecated
        public String TransactionId;
        /** PlayFab transaction status */
        @Deprecated
        public String TransactionStatus;
        
    }

    @Deprecated
    public static class GetSegmentResult {
        /** Identifier of the segments AB Test, if it is attached to one. */
        @Deprecated
        public String ABTestParent;
        /** Unique identifier for this segment. */
        @Deprecated
        public String Id;
        /** Segment name. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class GetSharedGroupDataRequest {
        /** If true, return the list of all members of the shared group. */
        @Deprecated
        public Boolean GetMembers;
        /**
         * Specific keys to retrieve from the shared group (if not specified, all keys will be returned, while an empty array
         * indicates that no keys should be returned).
         */
        @Deprecated
        public ArrayList<String> Keys;
        /** Unique identifier for the shared group. */
        @Deprecated
        public String SharedGroupId;
        
    }

    @Deprecated
    public static class GetSharedGroupDataResult {
        /** Data for the requested keys. */
        @Deprecated
        public Map<String,SharedGroupDataRecord> Data;
        /** List of PlayFabId identifiers for the members of this group, if requested. */
        @Deprecated
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
    @Deprecated
    public static class GetStoreItemsRequest {
        /** Catalog version to store items from. Use default catalog version if null */
        @Deprecated
        public String CatalogVersion;
        /** Unqiue identifier for the store which is being requested. */
        @Deprecated
        public String StoreId;
        
    }

    @Deprecated
    public static class GetStoreItemsResult {
        /** The base catalog that this store is a part of. */
        @Deprecated
        public String CatalogVersion;
        /** Additional data about the store. */
        @Deprecated
        public StoreMarketingModel MarketingData;
        /** How the store was last updated (Admin or a third party). */
        @Deprecated
        public SourceType Source;
        /** Array of items which can be purchased from this store. */
        @Deprecated
        @Unordered("ItemId")
        public ArrayList<StoreItem> Store;
        /** The ID of this store. */
        @Deprecated
        public String StoreId;
        
    }

    /**
     * This query retrieves the current time from one of the servers in PlayFab. Please note that due to clock drift between
     * servers, there is a potential variance of up to 5 seconds.
     */
    @Deprecated
    public static class GetTimeRequest {
        
    }

    /** Time is always returned as Coordinated Universal Time (UTC). */
    @Deprecated
    public static class GetTimeResult {
        /** Current server time when the request was received, in UTC */
        @Deprecated
        public Date Time;
        
    }

    /**
     * This API is designed to return title specific values which can be read, but not written to, by the client. For example,
     * a developer could choose to store values which modify the user experience, such as enemy spawn rates, weapon strengths,
     * movement speeds, etc. This allows a developer to update the title without the need to create, test, and ship a new
     * build. If the player belongs to an experiment variant that uses title data overrides, the overrides are applied
     * automatically and returned with the title data. Note that there may up to a minute delay in between updating title data
     * and this API call returning the newest value.
     */
    @Deprecated
    public static class GetTitleDataRequest {
        /** Specific keys to search for in the title data (leave null to get all keys) */
        @Deprecated
        public ArrayList<String> Keys;
        /**
         * Optional field that specifies the name of an override. This value is ignored when used by the game client; otherwise,
         * the overrides are applied automatically to the title data.
         */
        @Deprecated
        public String OverrideLabel;
        
    }

    @Deprecated
    public static class GetTitleDataResult {
        /** a dictionary object of key / value pairs */
        @Deprecated
        public Map<String,String> Data;
        
    }

    @Deprecated
    public static class GetTitleNewsRequest {
        /** Limits the results to the last n entries. Defaults to 10 if not set. */
        @Deprecated
        public Integer Count;
        
    }

    @Deprecated
    public static class GetTitleNewsResult {
        /** Array of news items. */
        @Deprecated
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
    @Deprecated
    public static class GetTitlePublicKeyRequest {
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        /** The shared secret key for this title */
        @Deprecated
        public String TitleSharedSecret;
        
    }

    @Deprecated
    public static class GetTitlePublicKeyResult {
        /** Base64 encoded RSA CSP byte array blob containing the title's public RSA key */
        @Deprecated
        public String RSAPublicKey;
        
    }

    @Deprecated
    public static class GetTradeStatusRequest {
        /** Player who opened trade. */
        @Deprecated
        public String OfferingPlayerId;
        /** Trade identifier as returned by OpenTradeOffer. */
        @Deprecated
        public String TradeId;
        
    }

    @Deprecated
    public static class GetTradeStatusResponse {
        /** Information about the requested trade. */
        @Deprecated
        public TradeInfo Trade;
        
    }

    /**
     * Data is stored as JSON key-value pairs. Every time the data is updated via any source, the version counter is
     * incremented. If the Version parameter is provided, then this call will only return data if the current version on the
     * system is greater than the value provided. If the Keys parameter is provided, the data object returned will only contain
     * the data specific to the indicated Keys. Otherwise, the full set of custom user data will be returned.
     */
    @Deprecated
    public static class GetUserDataRequest {
        /**
         * The version that currently exists according to the caller. The call will return the data for all of the keys if the
         * version in the system is greater than this.
         */
        @Deprecated
        public Long IfChangedFromDataVersion;
        /** List of unique keys to load from. */
        @Deprecated
        public ArrayList<String> Keys;
        /**
         * Unique PlayFab identifier of the user to load data for. Optional, defaults to yourself if not set. When specified to a
         * PlayFab id of another player, then this will only return public keys for that account.
         */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetUserDataResult {
        /** User specific data for this title. */
        @Deprecated
        public Map<String,UserDataRecord> Data;
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of
         * data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        @Deprecated
        public Long DataVersion;
        
    }

    @Deprecated
    public static class GetUserInventoryRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    /**
     * All items currently in the user inventory will be returned, irrespective of how they were acquired (via purchasing,
     * grants, coupons, etc.). Items that are expired, fully consumed, or are no longer valid are not considered to be in the
     * user's current inventory, and so will not be not included.
     */
    @Deprecated
    public static class GetUserInventoryResult {
        /** Array of inventory items belonging to the user. */
        @Deprecated
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> Inventory;
        /** Array of virtual currency balance(s) belonging to the user. */
        @Deprecated
        public Map<String,Integer> VirtualCurrency;
        /** Array of remaining times and timestamps for virtual currencies. */
        @Deprecated
        public Map<String,VirtualCurrencyRechargeTime> VirtualCurrencyRechargeTimes;
        
    }

    @Deprecated
    public static class GooglePlayFabIdPair {
        /** Unique Google identifier for a user. */
        @Deprecated
        public String GoogleId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Google identifier. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GooglePlayGamesPlayFabIdPair {
        /** Unique Google Play Games identifier for a user. */
        @Deprecated
        public String GooglePlayGamesPlayerId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Google Play Games identifier. */
        @Deprecated
        public String PlayFabId;
        
    }

    /**
     * Grants a character to the user of the type specified by the item ID. The user must already have an instance of this item
     * in their inventory in order to allow character creation. This item can come from a purchase or grant, which must be done
     * before calling to create the character.
     */
    @Deprecated
    public static class GrantCharacterToUserRequest {
        /** Catalog version from which items are to be granted. */
        @Deprecated
        public String CatalogVersion;
        /** Non-unique display name of the character being granted (1-40 characters in length). */
        @Deprecated
        public String CharacterName;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Catalog item identifier of the item in the user's inventory that corresponds to the character in the catalog to be
         * created.
         */
        @Deprecated
        public String ItemId;
        
    }

    @Deprecated
    public static class GrantCharacterToUserResult {
        /** Unique identifier tagged to this character. */
        @Deprecated
        public String CharacterId;
        /** Type of character that was created. */
        @Deprecated
        public String CharacterType;
        /** Indicates whether this character was created successfully. */
        @Deprecated
        public Boolean Result;
        
    }

    /**
     * A unique instance of an item in a user's inventory. Note, to retrieve additional information for an item such as Tags,
     * Description that are the same across all instances of the item, a call to GetCatalogItems is required. The ItemID of can
     * be matched to a catalog entry, which contains the additional information. Also note that Custom Data is only set when
     * the User's specific instance has updated the CustomData via a call to UpdateUserInventoryItemCustomData. Other fields
     * such as UnitPrice and UnitCurrency are only set when the item was granted via a purchase.
     */
    @Deprecated
    public static class ItemInstance implements Comparable<ItemInstance> {
        /** Game specific comment associated with this instance when it was added to the user inventory. */
        @Deprecated
        public String Annotation;
        /** Array of unique items that were awarded when this catalog item was purchased. */
        @Deprecated
        public ArrayList<String> BundleContents;
        /**
         * Unique identifier for the parent inventory item, as defined in the catalog, for object which were added from a bundle or
         * container.
         */
        @Deprecated
        public String BundleParent;
        /** Catalog version for the inventory item, when this instance was created. */
        @Deprecated
        public String CatalogVersion;
        /**
         * A set of custom key-value pairs on the instance of the inventory item, which is not to be confused with the catalog
         * item's custom data.
         */
        @Deprecated
        public Map<String,String> CustomData;
        /** CatalogItem.DisplayName at the time this item was purchased. */
        @Deprecated
        public String DisplayName;
        /** Timestamp for when this instance will expire. */
        @Deprecated
        public Date Expiration;
        /** Class name for the inventory item, as defined in the catalog. */
        @Deprecated
        public String ItemClass;
        /** Unique identifier for the inventory item, as defined in the catalog. */
        @Deprecated
        public String ItemId;
        /** Unique item identifier for this specific instance of the item. */
        @Deprecated
        public String ItemInstanceId;
        /** Timestamp for when this instance was purchased. */
        @Deprecated
        public Date PurchaseDate;
        /** Total number of remaining uses, if this is a consumable item. */
        @Deprecated
        public Integer RemainingUses;
        /** Currency type for the cost of the catalog item. Not available when granting items. */
        @Deprecated
        public String UnitCurrency;
        /** Cost of the catalog item in the given currency. Not available when granting items. */
        @Deprecated
        public Long UnitPrice;
        /** The number of uses that were added or removed to this item in this call. */
        @Deprecated
        public Integer UsesIncrementedBy;
        
        public int compareTo(ItemInstance other) {
            if (other == null || other.ItemInstanceId == null) return 1;
            if (ItemInstanceId == null) return -1;
            return ItemInstanceId.compareTo(other.ItemInstanceId);
        }
    }

    @Deprecated
    public static class ItemPurchaseRequest {
        /** Title-specific text concerning this purchase. */
        @Deprecated
        public String Annotation;
        /** Unique ItemId of the item to purchase. */
        @Deprecated
        public String ItemId;
        /** How many of this item to purchase. Min 1, maximum 25. */
        @Deprecated
        public Long Quantity;
        /** Items to be upgraded as a result of this purchase (upgraded items are hidden, as they are "replaced" by the new items). */
        @Deprecated
        public ArrayList<String> UpgradeFromItems;
        
    }

    @Deprecated
    public static class KongregatePlayFabIdPair {
        /** Unique Kongregate identifier for a user. */
        @Deprecated
        public String KongregateId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Kongregate identifier. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class LinkAndroidDeviceIDRequest {
        /** Specific model of the user's device. */
        @Deprecated
        public String AndroidDevice;
        /** Android device identifier for the user's device. */
        @Deprecated
        public String AndroidDeviceId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the device, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Specific Operating System version for the user's device. */
        @Deprecated
        public String OS;
        
    }

    @Deprecated
    public static class LinkAndroidDeviceIDResult {
        
    }

    @Deprecated
    public static class LinkAppleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to a specific Apple account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /**
         * The JSON Web token (JWT) returned by Apple after login. Represented as the identityToken field in the authorization
         * credential payload. Used to validate the request and find the user ID (Apple subject) to link with.
         */
        @Deprecated
        public String IdentityToken;
        
    }

    @Deprecated
    public static class LinkCustomIDRequest {
        /** Custom unique identifier for the user, generated by the title. */
        @Deprecated
        public String CustomId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the custom ID, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        
    }

    @Deprecated
    public static class LinkCustomIDResult {
        
    }

    @Deprecated
    public static class LinkedPlatformAccountModel {
        /** Linked account email of the user on the platform, if available */
        @Deprecated
        public String Email;
        /** Authentication platform */
        @Deprecated
        public LoginIdentityProvider Platform;
        /** Unique account identifier of the user on the platform */
        @Deprecated
        public String PlatformUserId;
        /** Linked account username of the user on the platform, if available */
        @Deprecated
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
    @Deprecated
    public static class LinkFacebookAccountRequest {
        /** Unique identifier from Facebook for the user. */
        @Deprecated
        public String AccessToken;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        
    }

    @Deprecated
    public static class LinkFacebookAccountResult {
        
    }

    @Deprecated
    public static class LinkFacebookInstantGamesIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Facebook Instant Games signature for the user. */
        @Deprecated
        public String FacebookInstantGamesSignature;
        /** If another user is already linked to the Facebook Instant Games ID, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        
    }

    @Deprecated
    public static class LinkFacebookInstantGamesIdResult {
        
    }

    @Deprecated
    public static class LinkGameCenterAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * If another user is already linked to the account, unlink the other user and re-link. If the current user is already
         * linked, link both accounts
         */
        @Deprecated
        public Boolean ForceLink;
        /** Game Center identifier for the player account to be linked. */
        @Deprecated
        public String GameCenterId;
        /** The URL for the public encryption key that will be used to verify the signature. */
        @Deprecated
        public String PublicKeyUrl;
        /** A random value used to compute the hash and keep it randomized. */
        @Deprecated
        public String Salt;
        /** The verification signature of the authentication payload. */
        @Deprecated
        public String Signature;
        /**
         * The integer representation of date and time that the signature was created on. PlayFab will reject authentication
         * signatures not within 10 minutes of the server's current time.
         */
        @Deprecated
        public String Timestamp;
        
    }

    @Deprecated
    public static class LinkGameCenterAccountResult {
        
    }

    /**
     * Google sign-in is accomplished by obtaining a Google OAuth 2.0 credential using the Google sign-in for Android APIs on
     * the device and passing it to this API.
     */
    @Deprecated
    public static class LinkGoogleAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * If another user is already linked to the account, unlink the other user and re-link. If the current user is already
         * linked, link both accounts
         */
        @Deprecated
        public Boolean ForceLink;
        /**
         * Server authentication code obtained on the client by calling getServerAuthCode()
         * (https://developers.google.com/identity/sign-in/android/offline-access) from Google Play for the user.
         */
        @Deprecated
        public String ServerAuthCode;
        
    }

    @Deprecated
    public static class LinkGoogleAccountResult {
        
    }

    /**
     * Google Play Games sign-in is accomplished by obtaining a Google OAuth 2.0 credential using the Google Play Games sign-in
     * for Android APIs on the device and passing it to this API.
     */
    @Deprecated
    public static class LinkGooglePlayGamesServicesAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * If another user is already linked to the account, unlink the other user and re-link. If the current user is already
         * linked, link both accounts
         */
        @Deprecated
        public Boolean ForceLink;
        /**
         * OAuth 2.0 server authentication code obtained on the client by calling the requestServerSideAccess()
         * (https://developers.google.com/games/services/android/signin) Google Play Games client API.
         */
        @Deprecated
        public String ServerAuthCode;
        
    }

    @Deprecated
    public static class LinkGooglePlayGamesServicesAccountResult {
        
    }

    @Deprecated
    public static class LinkIOSDeviceIDRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Vendor-specific iOS identifier for the user's device. */
        @Deprecated
        public String DeviceId;
        /** Specific model of the user's device. */
        @Deprecated
        public String DeviceModel;
        /** If another user is already linked to the device, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Specific Operating System version for the user's device. */
        @Deprecated
        public String OS;
        
    }

    @Deprecated
    public static class LinkIOSDeviceIDResult {
        
    }

    @Deprecated
    public static class LinkKongregateAccountRequest {
        /** Valid session auth ticket issued by Kongregate */
        @Deprecated
        public String AuthTicket;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Numeric user ID assigned by Kongregate */
        @Deprecated
        public String KongregateId;
        
    }

    @Deprecated
    public static class LinkKongregateAccountResult {
        
    }

    @Deprecated
    public static class LinkNintendoServiceAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to a specific Nintendo Switch account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /**
         * The JSON Web token (JWT) returned by Nintendo after login. Used to validate the request and find the user ID (Nintendo
         * Switch subject) to link with.
         */
        @Deprecated
        public String IdentityToken;
        
    }

    @Deprecated
    public static class LinkNintendoSwitchDeviceIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the Nintendo Switch Device ID, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Nintendo Switch unique identifier for the user's device. */
        @Deprecated
        public String NintendoSwitchDeviceId;
        
    }

    @Deprecated
    public static class LinkNintendoSwitchDeviceIdResult {
        
    }

    @Deprecated
    public static class LinkOpenIdConnectRequest {
        /** A name that identifies which configured OpenID Connect provider relationship to use. Maximum 100 characters. */
        @Deprecated
        public String ConnectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to a specific OpenId Connect user, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /**
         * The JSON Web token (JWT) returned by the identity provider after login. Represented as the id_token field in the
         * identity provider's response. Used to validate the request and find the user ID (OpenID Connect subject) to link with.
         */
        @Deprecated
        public String IdToken;
        
    }

    @Deprecated
    public static class LinkPSNAccountRequest {
        /** Authentication code provided by the PlayStation :tm: Network. */
        @Deprecated
        public String AuthCode;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Id of the PlayStation :tm: Network issuer environment. If null, defaults to production environment. */
        @Deprecated
        public Integer IssuerId;
        /** Redirect URI supplied to PlayStation :tm: Network when requesting an auth code */
        @Deprecated
        public String RedirectUri;
        
    }

    @Deprecated
    public static class LinkPSNAccountResult {
        
    }

    /**
     * Steam authentication is accomplished with the Steam Session Ticket. More information on the Ticket can be found in the
     * Steamworks SDK, here: https://partner.steamgames.com/documentation/auth (requires sign-in). NOTE: For Steam
     * authentication to work, the title must be configured with the Steam Application ID and Publisher Key in the PlayFab Game
     * Manager (under Properties). Information on creating a Publisher Key (referred to as the Secret Key in PlayFab) for your
     * title can be found here: https://partner.steamgames.com/documentation/webapi#publisherkey.
     */
    @Deprecated
    public static class LinkSteamAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /**
         * Authentication token for the user, returned as a byte array from Steam, and converted to a string (for example, the byte
         * 0x08 should become "08").
         */
        @Deprecated
        public String SteamTicket;
        /**
         * True if ticket was generated using ISteamUser::GetAuthTicketForWebAPI() using "AzurePlayFab" as the identity string.
         * False if the ticket was generated with ISteamUser::GetAuthSessionTicket().
         */
        @Deprecated
        public Boolean TicketIsServiceSpecific;
        
    }

    @Deprecated
    public static class LinkSteamAccountResult {
        
    }

    @Deprecated
    public static class LinkTwitchAccountRequest {
        /** Valid token issued by Twitch */
        @Deprecated
        public String AccessToken;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        
    }

    @Deprecated
    public static class LinkTwitchAccountResult {
        
    }

    @Deprecated
    public static class LinkXboxAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Token provided by the Xbox Live SDK/XDK method GetTokenAndSignatureAsync("POST", "https://playfabapi.com/", ""). */
        @Deprecated
        public String XboxToken;
        
    }

    @Deprecated
    public static class LinkXboxAccountResult {
        
    }

    /** Returns a list of every character that currently belongs to a user. */
    @Deprecated
    public static class ListUsersCharactersRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class ListUsersCharactersResult {
        /** The requested list of characters. */
        @Deprecated
        public ArrayList<CharacterResult> Characters;
        
    }

    @Deprecated
    public static class LocationModel {
        /** City name. */
        @Deprecated
        public String City;
        /** The two-character continent code for this location */
        @Deprecated
        public ContinentCode ContinentCode;
        /** The two-character ISO 3166-1 country code for the country associated with the location */
        @Deprecated
        public CountryCode CountryCode;
        /** Latitude coordinate of the geographic location. */
        @Deprecated
        public Double Latitude;
        /** Longitude coordinate of the geographic location. */
        @Deprecated
        public Double Longitude;
        
    }

    @Deprecated
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
        NintendoSwitchAccount,
        GooglePlayGames,
        XboxMobileStore,
        King
    }

    @Deprecated
    public static class LoginResult {
        /**
         * If LoginTitlePlayerAccountEntity flag is set on the login request the title_player_account will also be logged in and
         * returned.
         */
        @Deprecated
        public EntityTokenResponse EntityToken;
        /** Results for requested info. */
        @Deprecated
        public GetPlayerCombinedInfoResultPayload InfoResultPayload;
        /** The time of this user's previous login. If there was no previous login, then it's DateTime.MinValue */
        @Deprecated
        public Date LastLoginTime;
        /** True if the master_player_account was newly created on this login. */
        @Deprecated
        public Boolean NewlyCreated;
        /** Player's unique PlayFabId. */
        @Deprecated
        public String PlayFabId;
        /** Unique token authorizing the user and game at the server level, for the current session. */
        @Deprecated
        public String SessionTicket;
        /** Settings specific to this user. */
        @Deprecated
        public UserSettings SettingsForUser;
        /** The experimentation treatments for this user at the time of login. */
        @Deprecated
        public TreatmentAssignment TreatmentAssignment;
        
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
    @Deprecated
    public static class LoginWithAndroidDeviceIDRequest {
        /** Specific model of the user's device. */
        @Deprecated
        public String AndroidDevice;
        /** Android device identifier for the user's device. */
        @Deprecated
        public String AndroidDeviceId;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Specific Operating System version for the user's device. */
        @Deprecated
        public String OS;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    @Deprecated
    public static class LoginWithAppleRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /**
         * The JSON Web token (JWT) returned by Apple after login. Represented as the identityToken field in the authorization
         * credential payload. If you choose to ignore the expiration date for identity tokens, you will receive an NotAuthorized
         * error if Apple rotates the signing key. In this case, users have to login to provide a fresh identity token.
         */
        @Deprecated
        public String IdentityToken;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    /**
     * It is highly recommended that developers ensure that it is extremely unlikely that a customer could generate an ID which
     * is already in use by another customer. If this is the first time a user has signed in with the Custom ID and
     * CreateAccount is set to true, a new PlayFab account will be created and linked to the Custom ID. In this case, no email
     * or username will be associated with the PlayFab account. Otherwise, if no PlayFab account is linked to the Custom ID, an
     * error indicating this will be returned, so that the title can guide the user through creation of a PlayFab account.
     */
    @Deprecated
    public static class LoginWithCustomIDRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** Custom unique identifier for the user, generated by the title. */
        @Deprecated
        public String CustomId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    /**
     * Email address and password lengths are provided for information purposes. The server will validate that data passed in
     * conforms to the field definition and report errors appropriately. It is recommended that developers not perform this
     * validation locally, so that future updates do not require client updates.
     */
    @Deprecated
    public static class LoginWithEmailAddressRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Email address for the account. */
        @Deprecated
        public String Email;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Password for the PlayFab account (6-100 characters) */
        @Deprecated
        public String Password;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    @Deprecated
    public static class LoginWithFacebookInstantGamesIdRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Facebook Instant Games signature for the user. */
        @Deprecated
        public String FacebookInstantGamesSignature;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
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
     * the first Title ID. Note: If the user is authenticated with AuthenticationToken, instead of AccessToken, the
     * GetFriendsList API will return an empty list.
     */
    @Deprecated
    public static class LoginWithFacebookRequest {
        /** Unique identifier from Facebook for the user. */
        @Deprecated
        public String AccessToken;
        /** Token used for limited login authentication. */
        @Deprecated
        public String AuthenticationToken;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
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
     * returned, so that the title can guide the user through creation of a PlayFab account. If an invalid iOS Game Center
     * player identifier is used, an error indicating this will be returned.
     */
    @Deprecated
    public static class LoginWithGameCenterRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Unique Game Center player id. */
        @Deprecated
        public String PlayerId;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /** The URL for the public encryption key that will be used to verify the signature. */
        @Deprecated
        public String PublicKeyUrl;
        /** A random value used to compute the hash and keep it randomized. */
        @Deprecated
        public String Salt;
        /** The verification signature of the authentication payload. */
        @Deprecated
        public String Signature;
        /**
         * The integer representation of date and time that the signature was created on. PlayFab will reject authentication
         * signatures not within 10 minutes of the server's current time.
         */
        @Deprecated
        public String Timestamp;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
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
    @Deprecated
    public static class LoginWithGoogleAccountRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * OAuth 2.0 server authentication code obtained on the client by calling the getServerAuthCode()
         * (https://developers.google.com/identity/sign-in/android/offline-access) Google client API.
         */
        @Deprecated
        public String ServerAuthCode;
        /** Optional boolean to opt out of setting the MPA email when creating a Google account, defaults to true. */
        @Deprecated
        public Boolean SetEmail;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    /**
     * Google Play Games sign-in is accomplished by obtaining a Google OAuth 2.0 credential using the Google Play Games sign-in
     * for Android APIs on the device and passing it to this API. If this is the first time a user has signed in with the
     * Google Play Games account and CreateAccount is set to true, a new PlayFab account will be created and linked to the
     * Google Play Games account. Otherwise, if no PlayFab account is linked to the Google Play Games account, an error
     * indicating this will be returned, so that the title can guide the user through creation of a PlayFab account. The
     * current (recommended) method for obtaining a Google Play Games account credential in an Android application is to call
     * GamesSignInClient.requestServerSideAccess() and send the auth code as the ServerAuthCode parameter of this API. Before
     * doing this, you must create an OAuth 2.0 web application client ID in the Google API Console and configure its client ID
     * and secret in the PlayFab Game Manager Google Add-on for your title. This method does not require prompting of the user
     * for additional Google account permissions, resulting in a user experience with the least possible friction. For more
     * information about obtaining the server auth code, see https://developers.google.com/games/services/android/signin.
     */
    @Deprecated
    public static class LoginWithGooglePlayGamesServicesRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * OAuth 2.0 server authentication code obtained on the client by calling the requestServerSideAccess()
         * (https://developers.google.com/games/services/android/signin) Google Play Games client API.
         */
        @Deprecated
        public String ServerAuthCode;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
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
    @Deprecated
    public static class LoginWithIOSDeviceIDRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Vendor-specific iOS identifier for the user's device. */
        @Deprecated
        public String DeviceId;
        /** Specific model of the user's device. */
        @Deprecated
        public String DeviceModel;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Specific Operating System version for the user's device. */
        @Deprecated
        public String OS;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
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
    @Deprecated
    public static class LoginWithKongregateRequest {
        /** Token issued by Kongregate's client API for the user. */
        @Deprecated
        public String AuthTicket;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Numeric user ID assigned by Kongregate */
        @Deprecated
        public String KongregateId;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    @Deprecated
    public static class LoginWithNintendoServiceAccountRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** The JSON Web token (JWT) returned by Nintendo after login. */
        @Deprecated
        public String IdentityToken;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    @Deprecated
    public static class LoginWithNintendoSwitchDeviceIdRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Nintendo Switch unique identifier for the user's device. */
        @Deprecated
        public String NintendoSwitchDeviceId;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    @Deprecated
    public static class LoginWithOpenIdConnectRequest {
        /** A name that identifies which configured OpenID Connect provider relationship to use. Maximum 100 characters. */
        @Deprecated
        public String ConnectionId;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /**
         * The JSON Web token (JWT) returned by the identity provider after login. Represented as the id_token field in the
         * identity provider's response.
         */
        @Deprecated
        public String IdToken;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    /**
     * Username and password lengths are provided for information purposes. The server will validate that data passed in
     * conforms to the field definition and report errors appropriately. It is recommended that developers not perform this
     * validation locally, so that future updates to the username or password do not require client updates.
     */
    @Deprecated
    public static class LoginWithPlayFabRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Password for the PlayFab account (6-100 characters) */
        @Deprecated
        public String Password;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        /** PlayFab username for the account. */
        @Deprecated
        public String Username;
        
    }

    /**
     * If this is the first time a user has signed in with the PlayStation :tm: Network account and CreateAccount is set to
     * true, a new PlayFab account will be created and linked to the PlayStation :tm: Network account. In this case, no email
     * or username will be associated with the PlayFab account. Otherwise, if no PlayFab account is linked to the PlayStation
     * :tm: Network account, an error indicating this will be returned, so that the title can guide the user through creation
     * of a PlayFab account.
     */
    @Deprecated
    public static class LoginWithPSNRequest {
        /** Auth code provided by the PlayStation :tm: Network OAuth provider. */
        @Deprecated
        public String AuthCode;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Id of the PlayStation :tm: Network issuer environment. If null, defaults to production environment. */
        @Deprecated
        public Integer IssuerId;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /** Redirect URI supplied to PlayStation :tm: Network when requesting an auth code */
        @Deprecated
        public String RedirectUri;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    /**
     * Steam sign-in is accomplished with the Steam Session Ticket. More information on the Ticket can be found in the
     * Steamworks SDK, here: https://partner.steamgames.com/documentation/auth. NOTE: For Steam authentication to work, the
     * title must be configured with the Steam Application ID and Web API Key in the PlayFab Game Manager (under Steam in the
     * Add-ons Marketplace). You can obtain a Web API Key from the Permissions page of any Group associated with your App ID in
     * the Steamworks site. If this is the first time a user has signed in with the Steam account and CreateAccount is set to
     * true, a new PlayFab account will be created and linked to the provided account's Steam ID. In this case, no email or
     * username will be associated with the PlayFab account. Otherwise, if no PlayFab account is linked to the Steam account,
     * an error indicating this will be returned, so that the title can guide the user through creation of a PlayFab account.
     */
    @Deprecated
    public static class LoginWithSteamRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Authentication token for the user, returned as a byte array from Steam, and converted to a string (for example, the byte
         * 0x08 should become "08").
         */
        @Deprecated
        public String SteamTicket;
        /**
         * True if ticket was generated using ISteamUser::GetAuthTicketForWebAPI() using "AzurePlayFab" as the identity string.
         * False if the ticket was generated with ISteamUser::GetAuthSessionTicket().
         */
        @Deprecated
        public Boolean TicketIsServiceSpecific;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
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
    @Deprecated
    public static class LoginWithTwitchRequest {
        /** Token issued by Twitch's API for the user. */
        @Deprecated
        public String AccessToken;
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    /**
     * If this is the first time a user has signed in with the Xbox Live account and CreateAccount is set to true, a new
     * PlayFab account will be created and linked to the Xbox Live account. In this case, no email or username will be
     * associated with the PlayFab account. Otherwise, if no PlayFab account is linked to the Xbox Live account, an error
     * indicating this will be returned, so that the title can guide the user through creation of a PlayFab account.
     */
    @Deprecated
    public static class LoginWithXboxRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        /** Token provided by the Xbox Live SDK/XDK method GetTokenAndSignatureAsync("POST", "https://playfabapi.com/", ""). */
        @Deprecated
        public String XboxToken;
        
    }

    @Deprecated
    public static class LogStatement {
        /** Optional object accompanying the message as contextual information */
        @Deprecated
        public Object Data;
        /** 'Debug', 'Info', or 'Error' */
        @Deprecated
        public String Level;
        @Deprecated
        public String Message;
        
    }

    @Deprecated
    public static class MembershipModel {
        /** Whether this membership is active. That is, whether the MembershipExpiration time has been reached. */
        @Deprecated
        public Boolean IsActive;
        /** The time this membership expires */
        @Deprecated
        public Date MembershipExpiration;
        /** The id of the membership */
        @Deprecated
        public String MembershipId;
        /**
         * Membership expirations can be explicitly overridden (via game manager or the admin api). If this membership has been
         * overridden, this will be the new expiration time.
         */
        @Deprecated
        public Date OverrideExpiration;
        /** The list of subscriptions that this player has for this membership */
        @Deprecated
        public ArrayList<SubscriptionModel> Subscriptions;
        
    }

    @Deprecated
    public static class MicrosoftStorePayload {
        /** Microsoft store ID key. This is optional. Alternatively you can use XboxToken */
        @Deprecated
        public String CollectionsMsIdKey;
        /** If collectionsMsIdKey is provided, this will verify the user id in the collectionsMsIdKey is the same. */
        @Deprecated
        public String UserId;
        /**
         * Token provided by the Xbox Live SDK/XDK method GetTokenAndSignatureAsync("POST", "https://playfabapi.com/", ""). This is
         * optional. Alternatively can use CollectionsMsIdKey
         */
        @Deprecated
        public String XboxToken;
        
    }

    @Deprecated
    public static class ModifyUserVirtualCurrencyResult {
        /** Balance of the virtual currency after modification. */
        @Deprecated
        public Integer Balance;
        /**
         * Amount added or subtracted from the user's virtual currency. Maximum VC balance is Int32 (2,147,483,647). Any increase
         * over this value will be discarded.
         */
        @Deprecated
        public Integer BalanceChange;
        /** User currency was subtracted from. */
        @Deprecated
        public String PlayFabId;
        /** Name of the virtual currency which was modified. */
        @Deprecated
        public String VirtualCurrency;
        
    }

    /**
     * Identifier by either name or ID. Note that a name may change due to renaming, or reused after being deleted. ID is
     * immutable and unique.
     */
    @Deprecated
    public static class NameIdentifier {
        /** Id Identifier, if present */
        @Deprecated
        public String Id;
        /** Name Identifier, if present */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class NintendoServiceAccountPlayFabIdPair {
        /** Unique Nintendo Switch Service Account identifier for a user. */
        @Deprecated
        public String NintendoServiceAccountId;
        /**
         * Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Nintendo Switch Service Account
         * identifier.
         */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class NintendoSwitchPlayFabIdPair {
        /** Unique Nintendo Switch Device identifier for a user. */
        @Deprecated
        public String NintendoSwitchDeviceId;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Nintendo Switch Device identifier. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class OpenTradeRequest {
        /**
         * Players who are allowed to accept the trade. If null, the trade may be accepted by any player. If empty, the trade may
         * not be accepted by any player.
         */
        @Deprecated
        public ArrayList<String> AllowedPlayerIds;
        /** Player inventory items offered for trade. If not set, the trade is effectively a gift request */
        @Deprecated
        public ArrayList<String> OfferedInventoryInstanceIds;
        /** Catalog items accepted for the trade. If not set, the trade is effectively a gift. */
        @Deprecated
        public ArrayList<String> RequestedCatalogItemIds;
        
    }

    @Deprecated
    public static class OpenTradeResponse {
        /** The information about the trade that was just opened. */
        @Deprecated
        public TradeInfo Trade;
        
    }

    /**
     * This is the second step in the purchasing process, initiating the purchase transaction with the payment provider (if
     * applicable). For payment provider scenarios, the title should next present the user with the payment provider'sinterface
     * for payment. Once the player has completed the payment with the provider, the title should call ConfirmPurchase
     * tofinalize the process and add the appropriate items to the player inventory.
     */
    @Deprecated
    public static class PayForPurchaseRequest {
        /** Currency to use to fund the purchase. */
        @Deprecated
        public String Currency;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Purchase order identifier returned from StartPurchase. */
        @Deprecated
        public String OrderId;
        /** Payment provider to use to fund the purchase. */
        @Deprecated
        public String ProviderName;
        /** Payment provider transaction identifier. Required for Facebook Payments. */
        @Deprecated
        public String ProviderTransactionId;
        
    }

    /**
     * For web-based payment providers, this operation returns the URL to which the user should be directed inorder to approve
     * the purchase. Items added to the user inventory as a result of this operation will be marked as unconfirmed.
     */
    @Deprecated
    public static class PayForPurchaseResult {
        /** Local credit applied to the transaction (provider specific). */
        @Deprecated
        public Long CreditApplied;
        /** Purchase order identifier. */
        @Deprecated
        public String OrderId;
        /** Provider used for the transaction. */
        @Deprecated
        public String ProviderData;
        /** A token generated by the provider to authenticate the request (provider-specific). */
        @Deprecated
        public String ProviderToken;
        /** URL to the purchase provider page that details the purchase. */
        @Deprecated
        public String PurchaseConfirmationPageURL;
        /** Currency for the transaction, may be a virtual currency or real money. */
        @Deprecated
        public String PurchaseCurrency;
        /** Cost of the transaction. */
        @Deprecated
        public Long PurchasePrice;
        /** Status of the transaction. */
        @Deprecated
        public TransactionStatus Status;
        /** Virtual currencies granted by the transaction, if any. */
        @Deprecated
        public Map<String,Integer> VCAmount;
        /** Current virtual currency balances for the user. */
        @Deprecated
        public Map<String,Integer> VirtualCurrency;
        
    }

    @Deprecated
    public static class PaymentOption {
        /** Specific currency to use to fund the purchase. */
        @Deprecated
        public String Currency;
        /** Amount of the specified currency needed for the purchase. */
        @Deprecated
        public Long Price;
        /** Name of the purchase provider for this option. */
        @Deprecated
        public String ProviderName;
        /** Amount of existing credit the user has with the provider. */
        @Deprecated
        public Long StoreCredit;
        
    }

    @Deprecated
    public static class PlayerLeaderboardEntry {
        /** Title-specific display name of the user for this leaderboard entry. */
        @Deprecated
        public String DisplayName;
        /** PlayFab unique identifier of the user for this leaderboard entry. */
        @Deprecated
        public String PlayFabId;
        /** User's overall position in the leaderboard. */
        @Deprecated
        public Integer Position;
        /** The profile of the user, if requested. */
        @Deprecated
        public PlayerProfileModel Profile;
        /** Specific value of the user's statistic. */
        @Deprecated
        public Integer StatValue;
        
    }

    @Deprecated
    public static class PlayerProfileModel {
        /** List of advertising campaigns the player has been attributed to */
        @Deprecated
        public ArrayList<AdCampaignAttributionModel> AdCampaignAttributions;
        /** URL of the player's avatar image */
        @Deprecated
        public String AvatarUrl;
        /** If the player is currently banned, the UTC Date when the ban expires */
        @Deprecated
        public Date BannedUntil;
        /** List of all contact email info associated with the player account */
        @Deprecated
        public ArrayList<ContactEmailInfoModel> ContactEmailAddresses;
        /** Player record created */
        @Deprecated
        public Date Created;
        /** Player display name */
        @Deprecated
        public String DisplayName;
        /**
         * List of experiment variants for the player. Note that these variants are not guaranteed to be up-to-date when returned
         * during login because the player profile is updated only after login. Instead, use the LoginResult.TreatmentAssignment
         * property during login to get the correct variants and variables.
         */
        @Deprecated
        public ArrayList<String> ExperimentVariants;
        /** UTC time when the player most recently logged in to the title */
        @Deprecated
        public Date LastLogin;
        /** List of all authentication systems linked to this player account */
        @Deprecated
        public ArrayList<LinkedPlatformAccountModel> LinkedAccounts;
        /** List of geographic locations from which the player has logged in to the title */
        @Deprecated
        public ArrayList<LocationModel> Locations;
        /** List of memberships for the player, along with whether are expired. */
        @Deprecated
        public ArrayList<MembershipModel> Memberships;
        /** Player account origination */
        @Deprecated
        public LoginIdentityProvider Origination;
        /** PlayFab player account unique identifier */
        @Deprecated
        public String PlayerId;
        /** Publisher this player belongs to */
        @Deprecated
        public String PublisherId;
        /** List of configured end points registered for sending the player push notifications */
        @Deprecated
        public ArrayList<PushNotificationRegistrationModel> PushNotificationRegistrations;
        /** List of leaderboard statistic values for the player */
        @Deprecated
        public ArrayList<StatisticModel> Statistics;
        /** List of player's tags for segmentation */
        @Deprecated
        public ArrayList<TagModel> Tags;
        /** Title ID this player profile applies to */
        @Deprecated
        public String TitleId;
        /**
         * Sum of the player's purchases made with real-money currencies, converted to US dollars equivalent and represented as a
         * whole number of cents (1/100 USD). For example, 999 indicates nine dollars and ninety-nine cents.
         */
        @Deprecated
        public Long TotalValueToDateInUSD;
        /** List of the player's lifetime purchase totals, summed by real-money currency */
        @Deprecated
        public ArrayList<ValueToDateModel> ValuesToDate;
        
    }

    @Deprecated
    public static class PlayerProfileViewConstraints {
        /** Whether to show player's avatar URL. Defaults to false */
        @Deprecated
        public Boolean ShowAvatarUrl;
        /** Whether to show the banned until time. Defaults to false */
        @Deprecated
        public Boolean ShowBannedUntil;
        /** Whether to show campaign attributions. Defaults to false */
        @Deprecated
        public Boolean ShowCampaignAttributions;
        /** Whether to show contact email addresses. Defaults to false */
        @Deprecated
        public Boolean ShowContactEmailAddresses;
        /** Whether to show the created date. Defaults to false */
        @Deprecated
        public Boolean ShowCreated;
        /** Whether to show the display name. Defaults to false */
        @Deprecated
        public Boolean ShowDisplayName;
        /** Whether to show player's experiment variants. Defaults to false */
        @Deprecated
        public Boolean ShowExperimentVariants;
        /** Whether to show the last login time. Defaults to false */
        @Deprecated
        public Boolean ShowLastLogin;
        /** Whether to show the linked accounts. Defaults to false */
        @Deprecated
        public Boolean ShowLinkedAccounts;
        /** Whether to show player's locations. Defaults to false */
        @Deprecated
        public Boolean ShowLocations;
        /** Whether to show player's membership information. Defaults to false */
        @Deprecated
        public Boolean ShowMemberships;
        /** Whether to show origination. Defaults to false */
        @Deprecated
        public Boolean ShowOrigination;
        /** Whether to show push notification registrations. Defaults to false */
        @Deprecated
        public Boolean ShowPushNotificationRegistrations;
        /** Reserved for future development */
        @Deprecated
        public Boolean ShowStatistics;
        /** Whether to show tags. Defaults to false */
        @Deprecated
        public Boolean ShowTags;
        /** Whether to show the total value to date in usd. Defaults to false */
        @Deprecated
        public Boolean ShowTotalValueToDateInUsd;
        /** Whether to show the values to date. Defaults to false */
        @Deprecated
        public Boolean ShowValuesToDate;
        
    }

    @Deprecated
    public static class PlayerStatisticVersion {
        /** time when the statistic version became active */
        @Deprecated
        public Date ActivationTime;
        /** time when the statistic version became inactive due to statistic version incrementing */
        @Deprecated
        public Date DeactivationTime;
        /** time at which the statistic version was scheduled to become active, based on the configured ResetInterval */
        @Deprecated
        public Date ScheduledActivationTime;
        /** time at which the statistic version was scheduled to become inactive, based on the configured ResetInterval */
        @Deprecated
        public Date ScheduledDeactivationTime;
        /** name of the statistic when the version became active */
        @Deprecated
        public String StatisticName;
        /** version of the statistic */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class PlayStation5Payload {
        /** An optional list of entitlement ids to query against PlayStation :tm: Network */
        @Deprecated
        public ArrayList<String> Ids;
        /** Id of the PlayStation :tm: Network service label to consume entitlements from */
        @Deprecated
        public String ServiceLabel;
        
    }

    @Deprecated
    public static class PSNAccountPlayFabIdPair {
        /**
         * Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the PlayStation :tm: Network
         * identifier.
         */
        @Deprecated
        public String PlayFabId;
        /** Unique PlayStation :tm: Network identifier for a user. */
        @Deprecated
        public String PSNAccountId;
        
    }

    @Deprecated
    public static class PSNOnlinePlayFabIdPair {
        /**
         * Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the PlayStation :tm: Network
         * identifier.
         */
        @Deprecated
        public String PlayFabId;
        /** Unique PlayStation :tm: Network identifier for a user. */
        @Deprecated
        public String PSNOnlineId;
        
    }

    /**
     * Please note that the processing time for inventory grants and purchases increases fractionally the more items are in the
     * inventory, and the more items are in the grant/purchase operation (with each item in a bundle being a distinct add).
     */
    @Deprecated
    public static class PurchaseItemRequest {
        /** Catalog version for the items to be purchased (defaults to most recent version. */
        @Deprecated
        public String CatalogVersion;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique identifier of the item to purchase. */
        @Deprecated
        public String ItemId;
        /** Price the client expects to pay for the item (in case a new catalog or store was uploaded, with new prices). */
        @Deprecated
        public Integer Price;
        /** Store to buy this item through. If not set, prices default to those in the catalog. */
        @Deprecated
        public String StoreId;
        /** Virtual currency to use to purchase the item. */
        @Deprecated
        public String VirtualCurrency;
        
    }

    @Deprecated
    public static class PurchaseItemResult {
        /** Details for the items purchased. */
        @Deprecated
        public ArrayList<ItemInstance> Items;
        
    }

    @Deprecated
    public static class PurchaseReceiptFulfillment {
        /** Items granted to the player in fulfillment of the validated receipt. */
        @Deprecated
        public ArrayList<ItemInstance> FulfilledItems;
        /**
         * Source of the payment price information for the recorded purchase transaction. A value of 'Request' indicates that the
         * price specified in the request was used, whereas a value of 'Catalog' indicates that the real-money price of the catalog
         * item matching the product ID in the validated receipt transaction and the currency specified in the request (defaulting
         * to USD) was used.
         */
        @Deprecated
        public String RecordedPriceSource;
        /** Currency used to purchase the items (ISO 4217 currency code). */
        @Deprecated
        public String RecordedTransactionCurrency;
        /** Amount of the stated currency paid for the items, in centesimal units */
        @Deprecated
        public Long RecordedTransactionTotal;
        
    }

    @Deprecated
    public static enum PushNotificationPlatform {
        ApplePushNotificationService,
        GoogleCloudMessaging
    }

    @Deprecated
    public static class PushNotificationRegistrationModel {
        /** Notification configured endpoint */
        @Deprecated
        public String NotificationEndpointARN;
        /** Push notification platform */
        @Deprecated
        public PushNotificationPlatform Platform;
        
    }

    /**
     * Coupon codes can be created for any item, or set of items, in the catalog for the title. This operation causes the
     * coupon to be consumed, and the specific items to be awarded to the user. Attempting to re-use an already consumed code,
     * or a code which has not yet been created in the service, will result in an error.
     */
    @Deprecated
    public static class RedeemCouponRequest {
        /** Catalog version of the coupon. If null, uses the default catalog */
        @Deprecated
        public String CatalogVersion;
        /** Optional identifier for the Character that should receive the item. If null, item is added to the player */
        @Deprecated
        public String CharacterId;
        /** Generated coupon code to redeem. */
        @Deprecated
        public String CouponCode;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class RedeemCouponResult {
        /** Items granted to the player as a result of redeeming the coupon. */
        @Deprecated
        public ArrayList<ItemInstance> GrantedItems;
        
    }

    @Deprecated
    public static class RefreshPSNAuthTokenRequest {
        /** Auth code returned by PlayStation :tm: Network OAuth system. */
        @Deprecated
        public String AuthCode;
        /** Id of the PlayStation :tm: Network issuer environment. If null, defaults to production environment. */
        @Deprecated
        public Integer IssuerId;
        /** Redirect URI supplied to PlayStation :tm: Network when requesting an auth code */
        @Deprecated
        public String RedirectUri;
        
    }

    /**
     * The steps to configure and send Push Notifications is described in the PlayFab tutorials, here:
     * https://docs.microsoft.com/gaming/playfab/features/engagement/push-notifications/quickstart
     */
    @Deprecated
    public static class RegisterForIOSPushNotificationRequest {
        /** Message to display when confirming push notification. */
        @Deprecated
        public String ConfirmationMessage;
        /** Unique token generated by the Apple Push Notification service when the title registered to receive push notifications. */
        @Deprecated
        public String DeviceToken;
        /** If true, send a test push message immediately after sucessful registration. Defaults to false. */
        @Deprecated
        public Boolean SendPushNotificationConfirmation;
        
    }

    @Deprecated
    public static class RegisterForIOSPushNotificationResult {
        
    }

    @Deprecated
    public static class RegisterPlayFabUserRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** An optional parameter for setting the display name for this title (3-25 characters). */
        @Deprecated
        public String DisplayName;
        /** User email address attached to their account */
        @Deprecated
        public String Email;
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Password for the PlayFab account (6-100 characters) */
        @Deprecated
        public String Password;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /**
         * An optional parameter that specifies whether both the username and email parameters are required. If true, both
         * parameters are required; if false, the user must supply either the username or email parameter. The default value is
         * true.
         */
        @Deprecated
        public Boolean RequireBothUsernameAndEmail;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        /** PlayFab username for the account (3-20 characters) */
        @Deprecated
        public String Username;
        
    }

    /**
     * Each account must have a unique email address in the PlayFab service. Once created, the account may be associated with
     * additional accounts (Steam, Facebook, Game Center, etc.), allowing for added social network lists and achievements
     * systems.
     */
    @Deprecated
    public static class RegisterPlayFabUserResult {
        /**
         * If LoginTitlePlayerAccountEntity flag is set on the login request the title_player_account will also be logged in and
         * returned.
         */
        @Deprecated
        public EntityTokenResponse EntityToken;
        /** PlayFab unique identifier for this newly created account. */
        @Deprecated
        public String PlayFabId;
        /** Unique token identifying the user and game at the server level, for the current session. */
        @Deprecated
        public String SessionTicket;
        /** Settings specific to this user. */
        @Deprecated
        public UserSettings SettingsForUser;
        /** PlayFab unique user name. */
        @Deprecated
        public String Username;
        
    }

    /** This API removes an existing contact email from the player's profile. */
    @Deprecated
    public static class RemoveContactEmailRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class RemoveContactEmailResult {
        
    }

    @Deprecated
    public static class RemoveFriendRequest {
        /** PlayFab identifier of the friend account which is to be removed. */
        @Deprecated
        public String FriendPlayFabId;
        
    }

    @Deprecated
    public static class RemoveFriendResult {
        
    }

    @Deprecated
    public static class RemoveGenericIDRequest {
        /** Generic service identifier to be removed from the player. */
        @Deprecated
        public GenericServiceId GenericId;
        
    }

    @Deprecated
    public static class RemoveGenericIDResult {
        
    }

    @Deprecated
    public static class RemoveSharedGroupMembersRequest {
        /** An array of unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public ArrayList<String> PlayFabIds;
        /** Unique identifier for the shared group. */
        @Deprecated
        public String SharedGroupId;
        
    }

    @Deprecated
    public static class RemoveSharedGroupMembersResult {
        
    }

    /** Report ad activity */
    @Deprecated
    public static class ReportAdActivityRequest {
        /** Type of activity, may be Opened, Closed, Start or End */
        @Deprecated
        public AdActivity Activity;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique ID of the placement to report for */
        @Deprecated
        public String PlacementId;
        /** Unique ID of the reward the player was offered */
        @Deprecated
        public String RewardId;
        
    }

    /** Report ad activity response has no body */
    @Deprecated
    public static class ReportAdActivityResult {
        
    }

    @Deprecated
    public static class ReportPlayerClientRequest {
        /** Optional additional comment by reporting player. */
        @Deprecated
        public String Comment;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab identifier of the reported player. */
        @Deprecated
        public String ReporteeId;
        
    }

    /**
     * Players are currently limited to five reports per day. Attempts by a single user account to submit reports beyond five
     * will result in Updated being returned as false.
     */
    @Deprecated
    public static class ReportPlayerClientResult {
        /** The number of remaining reports which may be filed today. */
        @Deprecated
        public Integer SubmissionsRemaining;
        
    }

    /**
     * The title should obtain a refresh receipt via restoreCompletedTransactions in the SKPaymentQueue of the Apple StoreKit
     * and pass that in to this call. The resultant receipt contains new receipt instances for all non-consumable goods
     * previously purchased by the user. This API call iterates through every purchase in the receipt and restores the items if
     * they still exist in the catalog and can be validated.
     */
    @Deprecated
    public static class RestoreIOSPurchasesRequest {
        /** Catalog version of the restored items. If null, defaults to primary catalog. */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Base64 encoded receipt data, passed back by the App Store as a result of a successful purchase. */
        @Deprecated
        public String ReceiptData;
        
    }

    /**
     * Once verified, the valid items will be restored into the user's inventory. This result should be used for immediate
     * updates to the local client game state as opposed to the GetUserInventory API which can have an up to half second delay.
     */
    @Deprecated
    public static class RestoreIOSPurchasesResult {
        /** Fulfilled inventory items and recorded purchases in fulfillment of the validated receipt transactions. */
        @Deprecated
        public ArrayList<PurchaseReceiptFulfillment> Fulfillments;
        
    }

    /** Details on which placement and reward to perform a grant on */
    @Deprecated
    public static class RewardAdActivityRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Placement unique ID */
        @Deprecated
        public String PlacementId;
        /** Reward unique ID */
        @Deprecated
        public String RewardId;
        
    }

    /** Result for rewarding an ad activity */
    @Deprecated
    public static class RewardAdActivityResult {
        /** PlayStream Event ID that was generated by this reward (all subsequent events are associated with this event identifier) */
        @Deprecated
        public String AdActivityEventId;
        /** Debug results from the grants */
        @Deprecated
        public ArrayList<String> DebugResults;
        /** Id of the placement the reward was for */
        @Deprecated
        public String PlacementId;
        /** Name of the placement the reward was for */
        @Deprecated
        public String PlacementName;
        /** If placement has viewing limits indicates how many views are left */
        @Deprecated
        public Integer PlacementViewsRemaining;
        /** If placement has viewing limits indicates when they will next reset */
        @Deprecated
        public Double PlacementViewsResetMinutes;
        /** Reward results */
        @Deprecated
        public AdRewardResults RewardResults;
        
    }

    @Deprecated
    public static class ScriptExecutionError {
        /**
         * Error code, such as CloudScriptNotFound, JavascriptException, CloudScriptFunctionArgumentSizeExceeded,
         * CloudScriptAPIRequestCountExceeded, CloudScriptAPIRequestError, or CloudScriptHTTPRequestError
         */
        @Deprecated
        public String Error;
        /** Details about the error */
        @Deprecated
        public String Message;
        /** Point during the execution of the script at which the error occurred, if any */
        @Deprecated
        public String StackTrace;
        
    }

    /**
     * If the account in question is a "temporary" account (for example, one that was created via a call to
     * LoginFromIOSDeviceID), thisfunction will have no effect. Only PlayFab accounts which have valid email addresses will be
     * able to receive a password reset email using this API.
     */
    @Deprecated
    public static class SendAccountRecoveryEmailRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** User email address attached to their account */
        @Deprecated
        public String Email;
        /** The email template id of the account recovery email template to send. */
        @Deprecated
        public String EmailTemplateId;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a
         * title has been selected.
         */
        @Deprecated
        public String TitleId;
        
    }

    @Deprecated
    public static class SendAccountRecoveryEmailResult {
        
    }

    /**
     * This operation is not additive. It will completely replace the tag list for the specified user. Please note that only
     * users in the PlayFab friends list can be assigned tags. Attempting to set a tag on a friend only included in the friends
     * list from a social site integration (such as Facebook or Steam) will return the AccountNotFound error.
     */
    @Deprecated
    public static class SetFriendTagsRequest {
        /** PlayFab identifier of the friend account to which the tag(s) should be applied. */
        @Deprecated
        public String FriendPlayFabId;
        /** Array of tags to set on the friend account. */
        @Deprecated
        public ArrayList<String> Tags;
        
    }

    @Deprecated
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
    @Deprecated
    public static class SetPlayerSecretRequest {
        /** Base64 encoded body that is encrypted with the Title's public RSA key (Enterprise Only). */
        @Deprecated
        public String EncryptedRequest;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        
    }

    @Deprecated
    public static class SetPlayerSecretResult {
        
    }

    @Deprecated
    public static class SharedGroupDataRecord {
        /** Timestamp for when this data was last updated. */
        @Deprecated
        public Date LastUpdated;
        /** Unique PlayFab identifier of the user to last update this value. */
        @Deprecated
        public String LastUpdatedBy;
        /** Indicates whether this data can be read by all users (public) or only members of the group (private). */
        @Deprecated
        public UserDataPermission Permission;
        /** Data stored for the specified group data key. */
        @Deprecated
        public String Value;
        
    }

    @Deprecated
    public static enum SourceType {
        Admin,
        BackEnd,
        GameClient,
        GameServer,
        Partner,
        Custom,
        API
    }

    /**
     * This is the first step in the purchasing process. For security purposes, once the order (or "cart") has been created,
     * additional inventory objects may no longer be added. In addition, inventory objects will be locked to the current
     * prices, regardless of any subsequent changes at the catalog level which may occur during the next two steps.
     */
    @Deprecated
    public static class StartPurchaseRequest {
        /** Catalog version for the items to be purchased. Defaults to most recent catalog. */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Array of items to purchase. */
        @Deprecated
        public ArrayList<ItemPurchaseRequest> Items;
        /** Store through which to purchase items. If not set, prices will be pulled from the catalog itself. */
        @Deprecated
        public String StoreId;
        
    }

    @Deprecated
    public static class StartPurchaseResult {
        /** Cart items to be purchased. */
        @Deprecated
        public ArrayList<CartItem> Contents;
        /** Purchase order identifier. */
        @Deprecated
        public String OrderId;
        /** Available methods by which the user can pay. */
        @Deprecated
        public ArrayList<PaymentOption> PaymentOptions;
        /** Current virtual currency totals for the user. */
        @Deprecated
        public Map<String,Integer> VirtualCurrencyBalances;
        
    }

    @Deprecated
    public static class StatisticModel {
        /** Statistic name */
        @Deprecated
        public String Name;
        /** Statistic value */
        @Deprecated
        public Integer Value;
        /** Statistic version (0 if not a versioned statistic) */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static class StatisticNameVersion {
        /** unique name of the statistic */
        @Deprecated
        public String StatisticName;
        /** the version of the statistic to be returned */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class StatisticUpdate {
        /** unique name of the statistic */
        @Deprecated
        public String StatisticName;
        /** statistic value for the player */
        @Deprecated
        public Integer Value;
        /**
         * for updates to an existing statistic value for a player, the version of the statistic when it was loaded. Null when
         * setting the statistic value for the first time.
         */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class StatisticValue {
        /** unique name of the statistic */
        @Deprecated
        public String StatisticName;
        /** statistic value for the player */
        @Deprecated
        public Integer Value;
        /** for updates to an existing statistic value for a player, the version of the statistic when it was loaded */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class SteamNamePlayFabIdPair {
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Steam identifier. */
        @Deprecated
        public String PlayFabId;
        /** Unique Steam identifier for a user, also known as Steam persona name. */
        @Deprecated
        public String SteamName;
        
    }

    @Deprecated
    public static class SteamPlayFabIdPair {
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Steam identifier. */
        @Deprecated
        public String PlayFabId;
        /** Unique Steam identifier for a user. */
        @Deprecated
        public String SteamStringId;
        
    }

    /** A store entry that list a catalog item at a particular price */
    @Deprecated
    public static class StoreItem implements Comparable<StoreItem> {
        /** Store specific custom data. The data only exists as part of this store; it is not transferred to item instances */
        @Deprecated
        public Object CustomData;
        /** Intended display position for this item. Note that 0 is the first position */
        @Deprecated
        public Long DisplayPosition;
        /**
         * Unique identifier of the item as it exists in the catalog - note that this must exactly match the ItemId from the
         * catalog
         */
        @Deprecated
        public String ItemId;
        /** Override prices for this item for specific currencies */
        @Deprecated
        public Map<String,Long> RealCurrencyPrices;
        /** Override prices for this item in virtual currencies and "RM" (the base Real Money purchase price, in USD pennies) */
        @Deprecated
        public Map<String,Long> VirtualCurrencyPrices;
        
        public int compareTo(StoreItem other) {
            if (other == null || other.ItemId == null) return 1;
            if (ItemId == null) return -1;
            return ItemId.compareTo(other.ItemId);
        }
    }

    /** Marketing data about a specific store */
    @Deprecated
    public static class StoreMarketingModel {
        /** Tagline for a store. */
        @Deprecated
        public String Description;
        /** Display name of a store as it will appear to users. */
        @Deprecated
        public String DisplayName;
        /** Custom data about a store. */
        @Deprecated
        public Object Metadata;
        
    }

    @Deprecated
    public static class SubscriptionModel {
        /** When this subscription expires. */
        @Deprecated
        public Date Expiration;
        /** The time the subscription was orignially purchased */
        @Deprecated
        public Date InitialSubscriptionTime;
        /** Whether this subscription is currently active. That is, if Expiration &gt; now. */
        @Deprecated
        public Boolean IsActive;
        /** The status of this subscription, according to the subscription provider. */
        @Deprecated
        public SubscriptionProviderStatus Status;
        /** The id for this subscription */
        @Deprecated
        public String SubscriptionId;
        /** The item id for this subscription from the primary catalog */
        @Deprecated
        public String SubscriptionItemId;
        /** The provider for this subscription. Apple or Google Play are supported today. */
        @Deprecated
        public String SubscriptionProvider;
        
    }

    @Deprecated
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
    @Deprecated
    public static class SubtractUserVirtualCurrencyRequest {
        /** Amount to be subtracted from the user balance of the specified virtual currency. */
        @Deprecated
        public Integer Amount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Name of the virtual currency which is to be decremented. */
        @Deprecated
        public String VirtualCurrency;
        
    }

    @Deprecated
    public static class TagModel {
        /** Full value of the tag, including namespace */
        @Deprecated
        public String TagValue;
        
    }

    @Deprecated
    public static enum TitleActivationStatus {
        None,
        ActivatedTitleKey,
        PendingSteam,
        ActivatedSteam,
        RevokedSteam
    }

    @Deprecated
    public static class TitleNewsItem {
        /** News item text. */
        @Deprecated
        public String Body;
        /** Unique identifier of news item. */
        @Deprecated
        public String NewsId;
        /** Date and time when the news item was posted. */
        @Deprecated
        public Date Timestamp;
        /** Title of the news item. */
        @Deprecated
        public String Title;
        
    }

    @Deprecated
    public static class TradeInfo {
        /** Item instances from the accepting player that are used to fulfill the trade. If null, no one has accepted the trade. */
        @Deprecated
        public ArrayList<String> AcceptedInventoryInstanceIds;
        /** The PlayFab ID of the player who accepted the trade. If null, no one has accepted the trade. */
        @Deprecated
        public String AcceptedPlayerId;
        /** An optional list of players allowed to complete this trade. If null, anybody can complete the trade. */
        @Deprecated
        public ArrayList<String> AllowedPlayerIds;
        /** If set, The UTC time when this trade was canceled. */
        @Deprecated
        public Date CancelledAt;
        /** If set, The UTC time when this trade was fulfilled. */
        @Deprecated
        public Date FilledAt;
        /** If set, The UTC time when this trade was made invalid. */
        @Deprecated
        public Date InvalidatedAt;
        /** The catalogItem Ids of the item instances being offered. */
        @Deprecated
        public ArrayList<String> OfferedCatalogItemIds;
        /** The itemInstance Ids that are being offered. */
        @Deprecated
        public ArrayList<String> OfferedInventoryInstanceIds;
        /** The PlayFabId for the offering player. */
        @Deprecated
        public String OfferingPlayerId;
        /** The UTC time when this trade was created. */
        @Deprecated
        public Date OpenedAt;
        /** The catalogItem Ids requested in exchange. */
        @Deprecated
        public ArrayList<String> RequestedCatalogItemIds;
        /** Describes the current state of this trade. */
        @Deprecated
        public TradeStatus Status;
        /** The identifier for this trade. */
        @Deprecated
        public String TradeId;
        
    }

    @Deprecated
    public static enum TradeStatus {
        Invalid,
        Opening,
        Open,
        Accepting,
        Accepted,
        Filled,
        Cancelled
    }

    @Deprecated
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

    @Deprecated
    public static class TreatmentAssignment {
        /** List of the experiment variables. */
        @Deprecated
        public ArrayList<Variable> Variables;
        /** List of the experiment variants. */
        @Deprecated
        public ArrayList<String> Variants;
        
    }

    @Deprecated
    public static class TwitchPlayFabIdPair {
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Twitch identifier. */
        @Deprecated
        public String PlayFabId;
        /** Unique Twitch identifier for a user. */
        @Deprecated
        public String TwitchId;
        
    }

    @Deprecated
    public static class UnlinkAndroidDeviceIDRequest {
        /**
         * Android device identifier for the user's device. If not specified, the most recently signed in Android Device ID will be
         * used.
         */
        @Deprecated
        public String AndroidDeviceId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkAndroidDeviceIDResult {
        
    }

    @Deprecated
    public static class UnlinkAppleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkCustomIDRequest {
        /**
         * Custom unique identifier for the user, generated by the title. If not specified, the most recently signed in Custom ID
         * will be used.
         */
        @Deprecated
        public String CustomId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkCustomIDResult {
        
    }

    @Deprecated
    public static class UnlinkFacebookAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkFacebookAccountResult {
        
    }

    @Deprecated
    public static class UnlinkFacebookInstantGamesIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Facebook Instant Games identifier for the user. If not specified, the most recently signed in ID will be used. */
        @Deprecated
        public String FacebookInstantGamesId;
        
    }

    @Deprecated
    public static class UnlinkFacebookInstantGamesIdResult {
        
    }

    @Deprecated
    public static class UnlinkGameCenterAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkGameCenterAccountResult {
        
    }

    @Deprecated
    public static class UnlinkGoogleAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkGoogleAccountResult {
        
    }

    @Deprecated
    public static class UnlinkGooglePlayGamesServicesAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkGooglePlayGamesServicesAccountResult {
        
    }

    @Deprecated
    public static class UnlinkIOSDeviceIDRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Vendor-specific iOS identifier for the user's device. If not specified, the most recently signed in iOS Device ID will
         * be used.
         */
        @Deprecated
        public String DeviceId;
        
    }

    @Deprecated
    public static class UnlinkIOSDeviceIDResult {
        
    }

    @Deprecated
    public static class UnlinkKongregateAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkKongregateAccountResult {
        
    }

    @Deprecated
    public static class UnlinkNintendoServiceAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkNintendoSwitchDeviceIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Nintendo Switch Device identifier for the user. If not specified, the most recently signed in device ID will be used. */
        @Deprecated
        public String NintendoSwitchDeviceId;
        
    }

    @Deprecated
    public static class UnlinkNintendoSwitchDeviceIdResult {
        
    }

    @Deprecated
    public static class UnlinkOpenIdConnectRequest {
        /** A name that identifies which configured OpenID Connect provider relationship to use. Maximum 100 characters. */
        @Deprecated
        public String ConnectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkPSNAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkPSNAccountResult {
        
    }

    @Deprecated
    public static class UnlinkSteamAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkSteamAccountResult {
        
    }

    @Deprecated
    public static class UnlinkTwitchAccountRequest {
        /**
         * Valid token issued by Twitch. Used to specify which twitch account to unlink from the profile. By default it uses the
         * one that is present on the profile.
         */
        @Deprecated
        public String AccessToken;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkTwitchAccountResult {
        
    }

    @Deprecated
    public static class UnlinkXboxAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UnlinkXboxAccountResult {
        
    }

    /** Specify the container and optionally the catalogVersion for the container to open */
    @Deprecated
    public static class UnlockContainerInstanceRequest {
        /**
         * Specifies the catalog version that should be used to determine container contents. If unspecified, uses catalog
         * associated with the item instance.
         */
        @Deprecated
        public String CatalogVersion;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** ItemInstanceId of the container to unlock. */
        @Deprecated
        public String ContainerItemInstanceId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * ItemInstanceId of the key that will be consumed by unlocking this container. If the container requires a key, this
         * parameter is required.
         */
        @Deprecated
        public String KeyItemInstanceId;
        
    }

    /** Specify the type of container to open and optionally the catalogVersion for the container to open */
    @Deprecated
    public static class UnlockContainerItemRequest {
        /**
         * Specifies the catalog version that should be used to determine container contents. If unspecified, uses default/primary
         * catalog.
         */
        @Deprecated
        public String CatalogVersion;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Catalog ItemId of the container type to unlock. */
        @Deprecated
        public String ContainerItemId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    /** The items and vc found within the container. These will be added and stacked in the appropriate inventory. */
    @Deprecated
    public static class UnlockContainerItemResult {
        /** Items granted to the player as a result of unlocking the container. */
        @Deprecated
        public ArrayList<ItemInstance> GrantedItems;
        /** Unique instance identifier of the container unlocked. */
        @Deprecated
        public String UnlockedItemInstanceId;
        /** Unique instance identifier of the key used to unlock the container, if applicable. */
        @Deprecated
        public String UnlockedWithItemInstanceId;
        /** Virtual currency granted to the player as a result of unlocking the container. */
        @Deprecated
        public Map<String,Long> VirtualCurrency;
        
    }

    @Deprecated
    public static class UpdateAvatarUrlRequest {
        /** URL of the avatar image. If empty, it removes the existing avatar URL. */
        @Deprecated
        public String ImageUrl;
        
    }

    /**
     * This function performs an additive update of the arbitrary strings containing the custom data for the character. In
     * updating the custom data object, keys which already exist in the object will have their values overwritten, while keys
     * with null values will be removed. New keys will be added, with the given values. No other key-value pairs will be
     * changed apart from those specified in the call.
     */
    @Deprecated
    public static class UpdateCharacterDataRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may
         * not begin with a '!' character or be null.
         */
        @Deprecated
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData. Some SDKs cannot insert null-values into Data due to language
         * constraints. Use this to delete the keys directly.
         */
        @Deprecated
        public ArrayList<String> KeysToRemove;
        /** Permission to be applied to all user data keys written in this request. Defaults to "private" if not set. */
        @Deprecated
        public UserDataPermission Permission;
        
    }

    @Deprecated
    public static class UpdateCharacterDataResult {
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of
         * data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        @Deprecated
        public Long DataVersion;
        
    }

    /**
     * Enable this option with the 'Allow Client to Post Player Statistics' option in PlayFab GameManager for your title.
     * However, this is not best practice, as this data will no longer be safely controlled by the server. This operation is
     * additive. Character Statistics not currently defined will be added, while those already defined will be updated with the
     * given values. All other user statistics will remain unchanged. Character statistics are used by the
     * character-leaderboard apis, and accessible for custom game-logic.
     */
    @Deprecated
    public static class UpdateCharacterStatisticsRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Statistics to be updated with the provided values, in the Key(string), Value(int) pattern. */
        @Deprecated
        public Map<String,Integer> CharacterStatistics;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
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
    @Deprecated
    public static class UpdatePlayerStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Statistics to be updated with the provided values */
        @Deprecated
        public ArrayList<StatisticUpdate> Statistics;
        
    }

    @Deprecated
    public static class UpdatePlayerStatisticsResult {
        
    }

    /**
     * Note that in the case of multiple calls to write to the same shared group data keys, the last write received by the
     * PlayFab service will determine the value available to subsequent read operations. For scenarios requiring coordination
     * of data updates, it is recommended that titles make use of user data with read permission set to public, or a
     * combination of user data and shared group data.
     */
    @Deprecated
    public static class UpdateSharedGroupDataRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may
         * not begin with a '!' character or be null.
         */
        @Deprecated
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData. Some SDKs cannot insert null-values into Data due to language
         * constraints. Use this to delete the keys directly.
         */
        @Deprecated
        public ArrayList<String> KeysToRemove;
        /** Permission to be applied to all user data keys in this request. */
        @Deprecated
        public UserDataPermission Permission;
        /** Unique identifier for the shared group. */
        @Deprecated
        public String SharedGroupId;
        
    }

    @Deprecated
    public static class UpdateSharedGroupDataResult {
        
    }

    /**
     * This function performs an additive update of the arbitrary strings containing the custom data for the user. In updating
     * the custom data object, keys which already exist in the object will have their values overwritten, while keys with null
     * values will be removed. New keys will be added, with the given values. No other key-value pairs will be changed apart
     * from those specified in the call.
     */
    @Deprecated
    public static class UpdateUserDataRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may
         * not begin with a '!' character or be null.
         */
        @Deprecated
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData. Some SDKs cannot insert null-values into Data due to language
         * constraints. Use this to delete the keys directly.
         */
        @Deprecated
        public ArrayList<String> KeysToRemove;
        /**
         * Permission to be applied to all user data keys written in this request. Defaults to "private" if not set. This is used
         * for requests by one player for information about another player; those requests will only return Public keys.
         */
        @Deprecated
        public UserDataPermission Permission;
        
    }

    @Deprecated
    public static class UpdateUserDataResult {
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of
         * data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        @Deprecated
        public Long DataVersion;
        
    }

    /**
     * In addition to the PlayFab username, titles can make use of a DisplayName which is also a unique identifier, but
     * specific to the title. This allows for unique names which more closely match the theme or genre of a title, for example.
     */
    @Deprecated
    public static class UpdateUserTitleDisplayNameRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** New title display name for the user - must be between 3 and 25 characters. */
        @Deprecated
        public String DisplayName;
        
    }

    @Deprecated
    public static class UpdateUserTitleDisplayNameResult {
        /** Current title display name for the user (this will be the original display name if the rename attempt failed). */
        @Deprecated
        public String DisplayName;
        
    }

    @Deprecated
    public static class UserAccountInfo {
        /** User Android device information, if an Android device has been linked */
        @Deprecated
        public UserAndroidDeviceInfo AndroidDeviceInfo;
        /** Sign in with Apple account information, if an Apple account has been linked */
        @Deprecated
        public UserAppleIdInfo AppleAccountInfo;
        /** Timestamp indicating when the user account was created */
        @Deprecated
        public Date Created;
        /** Custom ID information, if a custom ID has been assigned */
        @Deprecated
        public UserCustomIdInfo CustomIdInfo;
        /** User Facebook information, if a Facebook account has been linked */
        @Deprecated
        public UserFacebookInfo FacebookInfo;
        /** Facebook Instant Games account information, if a Facebook Instant Games account has been linked */
        @Deprecated
        public UserFacebookInstantGamesIdInfo FacebookInstantGamesIdInfo;
        /** User Gamecenter information, if a Gamecenter account has been linked */
        @Deprecated
        public UserGameCenterInfo GameCenterInfo;
        /** User Google account information, if a Google account has been linked */
        @Deprecated
        public UserGoogleInfo GoogleInfo;
        /** User Google Play Games account information, if a Google Play Games account has been linked */
        @Deprecated
        public UserGooglePlayGamesInfo GooglePlayGamesInfo;
        /** User iOS device information, if an iOS device has been linked */
        @Deprecated
        public UserIosDeviceInfo IosDeviceInfo;
        /** User Kongregate account information, if a Kongregate account has been linked */
        @Deprecated
        public UserKongregateInfo KongregateInfo;
        /** Nintendo Switch account information, if a Nintendo Switch account has been linked */
        @Deprecated
        public UserNintendoSwitchAccountIdInfo NintendoSwitchAccountInfo;
        /** Nintendo Switch device information, if a Nintendo Switch device has been linked */
        @Deprecated
        public UserNintendoSwitchDeviceIdInfo NintendoSwitchDeviceIdInfo;
        /** OpenID Connect information, if any OpenID Connect accounts have been linked */
        @Deprecated
        public ArrayList<UserOpenIdInfo> OpenIdInfo;
        /** Unique identifier for the user account */
        @Deprecated
        public String PlayFabId;
        /** Personal information for the user which is considered more sensitive */
        @Deprecated
        public UserPrivateAccountInfo PrivateInfo;
        /** User PlayStation :tm: Network account information, if a PlayStation :tm: Network account has been linked */
        @Deprecated
        public UserPsnInfo PsnInfo;
        /** Server Custom ID information, if a server custom ID has been assigned */
        @Deprecated
        public UserServerCustomIdInfo ServerCustomIdInfo;
        /** User Steam information, if a Steam account has been linked */
        @Deprecated
        public UserSteamInfo SteamInfo;
        /** Title-specific information for the user account */
        @Deprecated
        public UserTitleInfo TitleInfo;
        /** User Twitch account information, if a Twitch account has been linked */
        @Deprecated
        public UserTwitchInfo TwitchInfo;
        /** User account name in the PlayFab service */
        @Deprecated
        public String Username;
        /** User XBox account information, if a XBox account has been linked */
        @Deprecated
        public UserXboxInfo XboxInfo;
        
    }

    @Deprecated
    public static class UserAndroidDeviceInfo {
        /** Android device ID */
        @Deprecated
        public String AndroidDeviceId;
        
    }

    @Deprecated
    public static class UserAppleIdInfo {
        /** Apple subject ID */
        @Deprecated
        public String AppleSubjectId;
        
    }

    @Deprecated
    public static class UserCustomIdInfo {
        /** Custom ID */
        @Deprecated
        public String CustomId;
        
    }

    /**
     * Indicates whether a given data key is private (readable only by the player) or public (readable by all players). When a
     * player makes a GetUserData request about another player, only keys marked Public will be returned.
     */
    @Deprecated
    public static enum UserDataPermission {
        Private,
        Public
    }

    @Deprecated
    public static class UserDataRecord {
        /** Timestamp for when this data was last updated. */
        @Deprecated
        public Date LastUpdated;
        /**
         * Indicates whether this data can be read by all users (public) or only the user (private). This is used for GetUserData
         * requests being made by one player about another player.
         */
        @Deprecated
        public UserDataPermission Permission;
        /** Data stored for the specified user data key. */
        @Deprecated
        public String Value;
        
    }

    @Deprecated
    public static class UserFacebookInfo {
        /** Facebook identifier */
        @Deprecated
        public String FacebookId;
        /** Facebook full name */
        @Deprecated
        public String FullName;
        
    }

    @Deprecated
    public static class UserFacebookInstantGamesIdInfo {
        /** Facebook Instant Games ID */
        @Deprecated
        public String FacebookInstantGamesId;
        
    }

    @Deprecated
    public static class UserGameCenterInfo {
        /** Gamecenter identifier */
        @Deprecated
        public String GameCenterId;
        
    }

    @Deprecated
    public static class UserGoogleInfo {
        /** Email address of the Google account */
        @Deprecated
        public String GoogleEmail;
        /** Gender information of the Google account */
        @Deprecated
        public String GoogleGender;
        /** Google ID */
        @Deprecated
        public String GoogleId;
        /** Locale of the Google account */
        @Deprecated
        public String GoogleLocale;
        /** Name of the Google account user */
        @Deprecated
        public String GoogleName;
        
    }

    @Deprecated
    public static class UserGooglePlayGamesInfo {
        /** Avatar image url of the Google Play Games player */
        @Deprecated
        public String GooglePlayGamesPlayerAvatarImageUrl;
        /** Display name of the Google Play Games player */
        @Deprecated
        public String GooglePlayGamesPlayerDisplayName;
        /** Google Play Games player ID */
        @Deprecated
        public String GooglePlayGamesPlayerId;
        
    }

    @Deprecated
    public static class UserIosDeviceInfo {
        /** iOS device ID */
        @Deprecated
        public String IosDeviceId;
        
    }

    @Deprecated
    public static class UserKongregateInfo {
        /** Kongregate ID */
        @Deprecated
        public String KongregateId;
        /** Kongregate Username */
        @Deprecated
        public String KongregateName;
        
    }

    @Deprecated
    public static class UserNintendoSwitchAccountIdInfo {
        /** Nintendo Switch account subject ID */
        @Deprecated
        public String NintendoSwitchAccountSubjectId;
        
    }

    @Deprecated
    public static class UserNintendoSwitchDeviceIdInfo {
        /** Nintendo Switch Device ID */
        @Deprecated
        public String NintendoSwitchDeviceId;
        
    }

    @Deprecated
    public static class UserOpenIdInfo {
        /** OpenID Connection ID */
        @Deprecated
        public String ConnectionId;
        /** OpenID Issuer */
        @Deprecated
        public String Issuer;
        /** OpenID Subject */
        @Deprecated
        public String Subject;
        
    }

    @Deprecated
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
        ServerCustomId,
        NintendoSwitchDeviceId,
        FacebookInstantGamesId,
        OpenIdConnect,
        Apple,
        NintendoSwitchAccount,
        GooglePlayGames,
        XboxMobileStore,
        King
    }

    @Deprecated
    public static class UserPrivateAccountInfo {
        /** user email address */
        @Deprecated
        public String Email;
        
    }

    @Deprecated
    public static class UserPsnInfo {
        /** PlayStation :tm: Network account ID */
        @Deprecated
        public String PsnAccountId;
        /** PlayStation :tm: Network online ID */
        @Deprecated
        public String PsnOnlineId;
        
    }

    @Deprecated
    public static class UserServerCustomIdInfo {
        /** Custom ID */
        @Deprecated
        public String CustomId;
        
    }

    @Deprecated
    public static class UserSettings {
        /** Boolean for whether this player is eligible for gathering device info. */
        @Deprecated
        public Boolean GatherDeviceInfo;
        /** Boolean for whether this player should report OnFocus play-time tracking. */
        @Deprecated
        public Boolean GatherFocusInfo;
        /** Boolean for whether this player is eligible for ad tracking. */
        @Deprecated
        public Boolean NeedsAttribution;
        
    }

    @Deprecated
    public static class UserSteamInfo {
        /** what stage of game ownership the user is listed as being in, from Steam */
        @Deprecated
        public TitleActivationStatus SteamActivationStatus;
        /** the country in which the player resides, from Steam data */
        @Deprecated
        public String SteamCountry;
        /** currency type set in the user Steam account */
        @Deprecated
        public Currency SteamCurrency;
        /** Steam identifier */
        @Deprecated
        public String SteamId;
        /** Steam display name */
        @Deprecated
        public String SteamName;
        
    }

    @Deprecated
    public static class UserTitleInfo {
        /** URL to the player's avatar. */
        @Deprecated
        public String AvatarUrl;
        /**
         * timestamp indicating when the user was first associated with this game (this can differ significantly from when the user
         * first registered with PlayFab)
         */
        @Deprecated
        public Date Created;
        /** name of the user, as it is displayed in-game */
        @Deprecated
        public String DisplayName;
        /**
         * timestamp indicating when the user first signed into this game (this can differ from the Created timestamp, as other
         * events, such as issuing a beta key to the user, can associate the title to the user)
         */
        @Deprecated
        public Date FirstLogin;
        /** boolean indicating whether or not the user is currently banned for a title */
        @Deprecated
        public Boolean isBanned;
        /** timestamp for the last user login for this title */
        @Deprecated
        public Date LastLogin;
        /** source by which the user first joined the game, if known */
        @Deprecated
        public UserOrigination Origination;
        /** Title player account entity for this user */
        @Deprecated
        public EntityKey TitlePlayerAccount;
        
    }

    @Deprecated
    public static class UserTwitchInfo {
        /** Twitch ID */
        @Deprecated
        public String TwitchId;
        /** Twitch Username */
        @Deprecated
        public String TwitchUserName;
        
    }

    @Deprecated
    public static class UserXboxInfo {
        /** XBox user ID */
        @Deprecated
        public String XboxUserId;
        /** XBox user sandbox */
        @Deprecated
        public String XboxUserSandbox;
        
    }

    @Deprecated
    public static class ValidateAmazonReceiptRequest {
        /** Catalog version of the fulfilled items. If null, defaults to the primary catalog. */
        @Deprecated
        public String CatalogVersion;
        /** Currency used to pay for the purchase (ISO 4217 currency code). */
        @Deprecated
        public String CurrencyCode;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Amount of the stated currency paid, in centesimal units. */
        @Deprecated
        public Integer PurchasePrice;
        /** ReceiptId returned by the Amazon App Store in-app purchase API */
        @Deprecated
        public String ReceiptId;
        /** AmazonId of the user making the purchase as returned by the Amazon App Store in-app purchase API */
        @Deprecated
        public String UserId;
        
    }

    /**
     * Once verified, the catalog item matching the Amazon item name will be added to the user's inventory. This result should
     * be used for immediate updates to the local client game state as opposed to the GetUserInventory API which can have an up
     * to half second delay.
     */
    @Deprecated
    public static class ValidateAmazonReceiptResult {
        /** Fulfilled inventory items and recorded purchases in fulfillment of the validated receipt transactions. */
        @Deprecated
        public ArrayList<PurchaseReceiptFulfillment> Fulfillments;
        
    }

    /**
     * The packageName and productId are defined in the GooglePlay store. The productId must match the ItemId of the inventory
     * item in the PlayFab catalog for the title. This enables the PlayFab service to securely validate that the purchase is
     * for the correct item, in order to prevent uses from passing valid receipts as being for more expensive items (passing a
     * receipt for a 99-cent purchase as being for a $19.99 purchase, for example). Each receipt may be validated only once to
     * avoid granting the same item over and over from a single purchase.
     */
    @Deprecated
    public static class ValidateGooglePlayPurchaseRequest {
        /** Catalog version of the fulfilled items. If null, defaults to the primary catalog. */
        @Deprecated
        public String CatalogVersion;
        /** Currency used to pay for the purchase (ISO 4217 currency code). */
        @Deprecated
        public String CurrencyCode;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Amount of the stated currency paid, in centesimal units. */
        @Deprecated
        public Long PurchasePrice;
        /** Original JSON string returned by the Google Play IAB API. */
        @Deprecated
        public String ReceiptJson;
        /** Signature returned by the Google Play IAB API. */
        @Deprecated
        public String Signature;
        
    }

    /**
     * Once verified, the catalog item (ItemId) matching the GooglePlay store item (productId) will be added to the user's
     * inventory. This result should be used for immediate updates to the local client game state as opposed to the
     * GetUserInventory API which can have an up to half second delay.
     */
    @Deprecated
    public static class ValidateGooglePlayPurchaseResult {
        /** Fulfilled inventory items and recorded purchases in fulfillment of the validated receipt transactions. */
        @Deprecated
        public ArrayList<PurchaseReceiptFulfillment> Fulfillments;
        
    }

    /**
     * The CurrencyCode and PurchasePrice must match the price which was set up for the item in the Apple store. In addition,
     * The ItemId of the inventory in the PlayFab Catalog must match the Product ID as it was set up in the Apple store. This
     * enables the PlayFab service to securely validate that the purchase is for the correct item, in order to prevent uses
     * from passing valid receipts as being for more expensive items (passing a receipt for a 99-cent purchase as being for a
     * $19.99 purchase, for example).
     */
    @Deprecated
    public static class ValidateIOSReceiptRequest {
        /** Catalog version of the fulfilled items. If null, defaults to the primary catalog. */
        @Deprecated
        public String CatalogVersion;
        /** Currency used to pay for the purchase (ISO 4217 currency code). */
        @Deprecated
        public String CurrencyCode;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Amount of the stated currency paid, in centesimal units. */
        @Deprecated
        public Integer PurchasePrice;
        /** Base64 encoded receipt data, passed back by the App Store as a result of a successful purchase. */
        @Deprecated
        public String ReceiptData;
        
    }

    /**
     * Once verified, the catalog item matching the iTunes item name will be added to the user's inventory. This result should
     * be used for immediate updates to the local client game state as opposed to the GetUserInventory API which can have an up
     * to half second delay.
     */
    @Deprecated
    public static class ValidateIOSReceiptResult {
        /** Fulfilled inventory items and recorded purchases in fulfillment of the validated receipt transactions. */
        @Deprecated
        public ArrayList<PurchaseReceiptFulfillment> Fulfillments;
        
    }

    @Deprecated
    public static class ValidateWindowsReceiptRequest {
        /** Catalog version of the fulfilled items. If null, defaults to the primary catalog. */
        @Deprecated
        public String CatalogVersion;
        /** Currency used to pay for the purchase (ISO 4217 currency code). */
        @Deprecated
        public String CurrencyCode;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Amount of the stated currency paid, in centesimal units. */
        @Deprecated
        public Long PurchasePrice;
        /** XML Receipt returned by the Windows App Store in-app purchase API */
        @Deprecated
        public String Receipt;
        
    }

    /**
     * Once verified, the catalog item matching the Product name will be added to the user's inventory. This result should be
     * used for immediate updates to the local client game state as opposed to the GetUserInventory API which can have an up to
     * half second delay.
     */
    @Deprecated
    public static class ValidateWindowsReceiptResult {
        /** Fulfilled inventory items and recorded purchases in fulfillment of the validated receipt transactions. */
        @Deprecated
        public ArrayList<PurchaseReceiptFulfillment> Fulfillments;
        
    }

    @Deprecated
    public static class ValueToDateModel {
        /** ISO 4217 code of the currency used in the purchases */
        @Deprecated
        public String Currency;
        /**
         * Total value of the purchases in a whole number of 1/100 monetary units. For example, 999 indicates nine dollars and
         * ninety-nine cents when Currency is 'USD')
         */
        @Deprecated
        public Long TotalValue;
        /**
         * Total value of the purchases in a string representation of decimal monetary units. For example, '9.99' indicates nine
         * dollars and ninety-nine cents when Currency is 'USD'.
         */
        @Deprecated
        public String TotalValueAsDecimal;
        
    }

    @Deprecated
    public static class Variable {
        /** Name of the variable. */
        @Deprecated
        public String Name;
        /** Value of the variable. */
        @Deprecated
        public String Value;
        
    }

    @Deprecated
    public static class VirtualCurrencyRechargeTime {
        /**
         * Maximum value to which the regenerating currency will automatically increment. Note that it can exceed this value
         * through use of the AddUserVirtualCurrency API call. However, it will not regenerate automatically until it has fallen
         * below this value.
         */
        @Deprecated
        public Integer RechargeMax;
        /** Server timestamp in UTC indicating the next time the virtual currency will be incremented. */
        @Deprecated
        public Date RechargeTime;
        /** Time remaining (in seconds) before the next recharge increment of the virtual currency. */
        @Deprecated
        public Integer SecondsToRecharge;
        
    }

    /**
     * This API is designed to write a multitude of different client-defined events into PlayStream. It supports a flexible
     * JSON schema, which allowsfor arbitrary key-value pairs to describe any character-based event. The created event will be
     * locked to the authenticated title and player.
     */
    @Deprecated
    public static class WriteClientCharacterEventRequest {
        /** Custom event properties. Each property consists of a name (string) and a value (JSON object). */
        @Deprecated
        public Map<String,Object> Body;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * The name of the event, within the namespace scoped to the title. The naming convention is up to the caller, but it
         * commonly follows the subject_verb_object pattern (e.g. player_logged_in).
         */
        @Deprecated
        public String EventName;
        /** The time (in UTC) associated with this event. The value defaults to the current time. */
        @Deprecated
        public Date Timestamp;
        
    }

    /**
     * This API is designed to write a multitude of different event types into PlayStream. It supports a flexible JSON schema,
     * which allowsfor arbitrary key-value pairs to describe any player-based event. The created event will be locked to the
     * authenticated title and player.
     */
    @Deprecated
    public static class WriteClientPlayerEventRequest {
        /** Custom data properties associated with the event. Each property consists of a name (string) and a value (JSON object). */
        @Deprecated
        public Map<String,Object> Body;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * The name of the event, within the namespace scoped to the title. The naming convention is up to the caller, but it
         * commonly follows the subject_verb_object pattern (e.g. player_logged_in).
         */
        @Deprecated
        public String EventName;
        /** The time (in UTC) associated with this event. The value defaults to the current time. */
        @Deprecated
        public Date Timestamp;
        
    }

    @Deprecated
    public static class WriteEventResponse {
        /**
         * The unique identifier of the event. The values of this identifier consist of ASCII characters and are not constrained to
         * any particular format.
         */
        @Deprecated
        public String EventId;
        
    }

    /**
     * This API is designed to write a multitude of different client-defined events into PlayStream. It supports a flexible
     * JSON schema, which allowsfor arbitrary key-value pairs to describe any title-based event. The created event will be
     * locked to the authenticated title.
     */
    @Deprecated
    public static class WriteTitleEventRequest {
        /** Custom event properties. Each property consists of a name (string) and a value (JSON object). */
        @Deprecated
        public Map<String,Object> Body;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * The name of the event, within the namespace scoped to the title. The naming convention is up to the caller, but it
         * commonly follows the subject_verb_object pattern (e.g. player_logged_in).
         */
        @Deprecated
        public String EventName;
        /** The time (in UTC) associated with this event. The value defaults to the current time. */
        @Deprecated
        public Date Timestamp;
        
    }

    @Deprecated
    public static class XboxLiveAccountPlayFabIdPair {
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Xbox Live identifier. */
        @Deprecated
        public String PlayFabId;
        /** Unique Xbox Live identifier for a user. */
        @Deprecated
        public String XboxLiveAccountId;
        
    }

}
