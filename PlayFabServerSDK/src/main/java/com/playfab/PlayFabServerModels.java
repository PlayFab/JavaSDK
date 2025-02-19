package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabServerModels {

    @Deprecated
    public static class AdCampaignAttribution {
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
    public static class AddCharacterVirtualCurrencyRequest {
        /**
         * Amount to be added to the character balance of the specified virtual currency. Maximum VC balance is Int32
         * (2,147,483,647). Any increase over this value will be discarded.
         */
        @Deprecated
        public Integer Amount;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** PlayFab unique identifier of the user whose virtual currency balance is to be incremented. */
        @Deprecated
        public String PlayFabId;
        /** Name of the virtual currency which is to be incremented. */
        @Deprecated
        public String VirtualCurrency;
        
    }

    @Deprecated
    public static class AddFriendRequest {
        /** Email address of the user being added. */
        @Deprecated
        public String FriendEmail;
        /** The PlayFab identifier of the user being added. */
        @Deprecated
        public String FriendPlayFabId;
        /** Title-specific display name of the user to being added. */
        @Deprecated
        public String FriendTitleDisplayName;
        /** The PlayFab username of the user being added */
        @Deprecated
        public String FriendUsername;
        /** PlayFab identifier of the player to add a new friend. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class AddGenericIDRequest {
        /** Generic service identifier to add to the player account. */
        @Deprecated
        public GenericServiceId GenericId;
        /** PlayFabId of the user to link. */
        @Deprecated
        public String PlayFabId;
        
    }

    /**
     * This API will trigger a player_tag_added event and add a tag with the given TagName and PlayFabID to the corresponding
     * player profile. TagName can be used for segmentation and it is limited to 256 characters. Also there is a limit on the
     * number of tags a title can have.
     */
    @Deprecated
    public static class AddPlayerTagRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Unique tag for player profile. */
        @Deprecated
        public String TagName;
        
    }

    @Deprecated
    public static class AddPlayerTagResult {
        
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
    public static class AddUserVirtualCurrencyRequest {
        /**
         * Amount to be added to the user balance of the specified virtual currency. Maximum VC balance is Int32 (2,147,483,647).
         * Any increase over this value will be discarded.
         */
        @Deprecated
        public Integer Amount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** PlayFab unique identifier of the user whose virtual currency balance is to be increased. */
        @Deprecated
        public String PlayFabId;
        /** Name of the virtual currency which is to be incremented. */
        @Deprecated
        public String VirtualCurrency;
        
    }

    @Deprecated
    public static class AdvancedPushPlatformMsg {
        /**
         * Stops GoogleCloudMessaging notifications from including both notification and data properties and instead only sends the
         * data property.
         */
        @Deprecated
        public Boolean GCMDataOnly;
        /** The Json the platform should receive. */
        @Deprecated
        public String Json;
        /** The platform that should receive the Json. */
        @Deprecated
        public PushNotificationPlatform Platform;
        
    }

    /**
     * Note that data returned may be Personally Identifying Information (PII), such as email address, and so care should be
     * taken in how this data is stored and managed. Since this call will always return the relevant information for users who
     * have accessed the title, the recommendation is to not store this data locally.
     */
    @Deprecated
    public static class AuthenticateSessionTicketRequest {
        /** Session ticket as issued by a PlayFab client login API. */
        @Deprecated
        public String SessionTicket;
        
    }

    @Deprecated
    public static class AuthenticateSessionTicketResult {
        /** Indicates if token was expired at request time. */
        @Deprecated
        public Boolean IsSessionTicketExpired;
        /** Account info for the user whose session ticket was supplied. */
        @Deprecated
        public UserAccountInfo UserInfo;
        
    }

    @Deprecated
    public static class AwardSteamAchievementItem {
        /** Unique Steam achievement name. */
        @Deprecated
        public String AchievementName;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Result of the award attempt (only valid on response, not on request). */
        @Deprecated
        public Boolean Result;
        
    }

    @Deprecated
    public static class AwardSteamAchievementRequest {
        /** Array of achievements to grant and the users to whom they are to be granted. */
        @Deprecated
        public ArrayList<AwardSteamAchievementItem> Achievements;
        
    }

    @Deprecated
    public static class AwardSteamAchievementResult {
        /** Array of achievements granted. */
        @Deprecated
        public ArrayList<AwardSteamAchievementItem> AchievementResults;
        
    }

    /** Contains information for a ban. */
    @Deprecated
    public static class BanInfo {
        /** The active state of this ban. Expired bans may still have this value set to true but they will have no effect. */
        @Deprecated
        public Boolean Active;
        /** The unique Ban Id associated with this ban. */
        @Deprecated
        public String BanId;
        /** The time when this ban was applied. */
        @Deprecated
        public Date Created;
        /** The time when this ban expires. Permanent bans do not have expiration date. */
        @Deprecated
        public Date Expires;
        /** The IP address on which the ban was applied. May affect multiple players. */
        @Deprecated
        public String IPAddress;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** The reason why this ban was applied. */
        @Deprecated
        public String Reason;
        /** The family type of the user that is included in the ban. */
        @Deprecated
        public String UserFamilyType;
        
    }

    /** Represents a single ban request. */
    @Deprecated
    public static class BanRequest {
        /** The duration in hours for the ban. Leave this blank for a permanent ban. */
        @Deprecated
        public Long DurationInHours;
        /** IP address to be banned. May affect multiple players. */
        @Deprecated
        public String IPAddress;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** The reason for this ban. Maximum 140 characters. */
        @Deprecated
        public String Reason;
        /** The family type of the user that should be included in the ban if applicable. May affect multiple players. */
        @Deprecated
        public UserFamilyType UserFamilyType;
        
    }

    /**
     * The existence of each user will not be verified. When banning by IP or MAC address, multiple players may be affected, so
     * use this feature with caution. Returns information about the new bans.
     */
    @Deprecated
    public static class BanUsersRequest {
        /** List of ban requests to be applied. Maximum 100. */
        @Deprecated
        public ArrayList<BanRequest> Bans;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class BanUsersResult {
        /** Information on the bans that were applied */
        @Deprecated
        public ArrayList<BanInfo> BanData;
        
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
    public static enum ChurnRiskLevel {
        NoData,
        LowRisk,
        MediumRisk,
        HighRisk
    }

    @Deprecated
    public static enum CloudScriptRevisionOption {
        Live,
        Latest,
        Specific
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
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
    public static class ContactEmailInfo {
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

    /**
     * This function will delete the specified character from the list allowed by the user, and will also delete any inventory
     * or VC currently held by that character. It will NOT delete any statistics associated for this character, in order to
     * preserve leaderboard integrity.
     */
    @Deprecated
    public static class DeleteCharacterFromUserRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /**
         * If true, the character's inventory will be transferred up to the owning user; otherwise, this request will purge those
         * items.
         */
        @Deprecated
        public Boolean SaveCharacterInventory;
        
    }

    @Deprecated
    public static class DeleteCharacterFromUserResult {
        
    }

    /**
     * Deletes all data associated with the player, including statistics, custom data, inventory, purchases, virtual currency
     * balances, characters and shared group memberships. Removes the player from all leaderboards and player search indexes.
     * Does not delete PlayStream event history associated with the player. Does not delete the publisher user account that
     * created the player in the title nor associated data such as username, password, email address, account linkages, or
     * friends list. Note, this API queues the player for deletion and returns immediately. It may take several minutes or more
     * before all player data is fully deleted. Until the player data is fully deleted, attempts to recreate the player with
     * the same user account in the same title will fail with the 'AccountDeleted' error. This API must be enabled for use as
     * an option in the game manager website. It is disabled by default.
     */
    @Deprecated
    public static class DeletePlayerRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class DeletePlayerResult {
        
    }

    /** Represents the request to delete a push notification template. */
    @Deprecated
    public static class DeletePushNotificationTemplateRequest {
        /** Id of the push notification template to be deleted. */
        @Deprecated
        public String PushNotificationTemplateId;
        
    }

    @Deprecated
    public static class DeletePushNotificationTemplateResult {
        
    }

    @Deprecated
    public static class DeleteSharedGroupRequest {
        /** Unique identifier for the shared group. */
        @Deprecated
        public String SharedGroupId;
        
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
    public static class EvaluateRandomResultTableRequest {
        /**
         * Specifies the catalog version that should be used to evaluate the Random Result Table. If unspecified, uses
         * default/primary catalog.
         */
        @Deprecated
        public String CatalogVersion;
        /** The unique identifier of the Random Result Table to use. */
        @Deprecated
        public String TableId;
        
    }

    /**
     * Note that if the Random Result Table contains no entries, or does not exist for the catalog specified (the Primary
     * catalog if one is not specified), an InvalidDropTable error will be returned.
     */
    @Deprecated
    public static class EvaluateRandomResultTableResult {
        /** Unique identifier for the item returned from the Random Result Table evaluation, for the given catalog. */
        @Deprecated
        public String ResultItemId;
        
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
    public static class ExecuteCloudScriptServerRequest {
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
        /** The unique user identifier for the player on whose behalf the script is being run */
        @Deprecated
        public String PlayFabId;
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
    public static enum GenericErrorCodes {
        Success,
        UnkownError,
        InvalidParams,
        AccountNotFound,
        AccountBanned,
        InvalidUsernameOrPassword,
        InvalidTitleId,
        InvalidEmailAddress,
        EmailAddressNotAvailable,
        InvalidUsername,
        InvalidPassword,
        UsernameNotAvailable,
        InvalidSteamTicket,
        AccountAlreadyLinked,
        LinkedAccountAlreadyClaimed,
        InvalidFacebookToken,
        AccountNotLinked,
        FailedByPaymentProvider,
        CouponCodeNotFound,
        InvalidContainerItem,
        ContainerNotOwned,
        KeyNotOwned,
        InvalidItemIdInTable,
        InvalidReceipt,
        ReceiptAlreadyUsed,
        ReceiptCancelled,
        GameNotFound,
        GameModeNotFound,
        InvalidGoogleToken,
        UserIsNotPartOfDeveloper,
        InvalidTitleForDeveloper,
        TitleNameConflicts,
        UserisNotValid,
        ValueAlreadyExists,
        BuildNotFound,
        PlayerNotInGame,
        InvalidTicket,
        InvalidDeveloper,
        InvalidOrderInfo,
        RegistrationIncomplete,
        InvalidPlatform,
        UnknownError,
        SteamApplicationNotOwned,
        WrongSteamAccount,
        TitleNotActivated,
        RegistrationSessionNotFound,
        NoSuchMod,
        FileNotFound,
        DuplicateEmail,
        ItemNotFound,
        ItemNotOwned,
        ItemNotRecycleable,
        ItemNotAffordable,
        InvalidVirtualCurrency,
        WrongVirtualCurrency,
        WrongPrice,
        NonPositiveValue,
        InvalidRegion,
        RegionAtCapacity,
        ServerFailedToStart,
        NameNotAvailable,
        InsufficientFunds,
        InvalidDeviceID,
        InvalidPushNotificationToken,
        NoRemainingUses,
        InvalidPaymentProvider,
        PurchaseInitializationFailure,
        DuplicateUsername,
        InvalidBuyerInfo,
        NoGameModeParamsSet,
        BodyTooLarge,
        ReservedWordInBody,
        InvalidTypeInBody,
        InvalidRequest,
        ReservedEventName,
        InvalidUserStatistics,
        NotAuthenticated,
        StreamAlreadyExists,
        ErrorCreatingStream,
        StreamNotFound,
        InvalidAccount,
        PurchaseDoesNotExist,
        InvalidPurchaseTransactionStatus,
        APINotEnabledForGameClientAccess,
        NoPushNotificationARNForTitle,
        BuildAlreadyExists,
        BuildPackageDoesNotExist,
        CustomAnalyticsEventsNotEnabledForTitle,
        InvalidSharedGroupId,
        NotAuthorized,
        MissingTitleGoogleProperties,
        InvalidItemProperties,
        InvalidPSNAuthCode,
        InvalidItemId,
        PushNotEnabledForAccount,
        PushServiceError,
        ReceiptDoesNotContainInAppItems,
        ReceiptContainsMultipleInAppItems,
        InvalidBundleID,
        JavascriptException,
        InvalidSessionTicket,
        UnableToConnectToDatabase,
        InternalServerError,
        InvalidReportDate,
        ReportNotAvailable,
        DatabaseThroughputExceeded,
        InvalidGameTicket,
        ExpiredGameTicket,
        GameTicketDoesNotMatchLobby,
        LinkedDeviceAlreadyClaimed,
        DeviceAlreadyLinked,
        DeviceNotLinked,
        PartialFailure,
        PublisherNotSet,
        ServiceUnavailable,
        VersionNotFound,
        RevisionNotFound,
        InvalidPublisherId,
        DownstreamServiceUnavailable,
        APINotIncludedInTitleUsageTier,
        DAULimitExceeded,
        APIRequestLimitExceeded,
        InvalidAPIEndpoint,
        BuildNotAvailable,
        ConcurrentEditError,
        ContentNotFound,
        CharacterNotFound,
        CloudScriptNotFound,
        ContentQuotaExceeded,
        InvalidCharacterStatistics,
        PhotonNotEnabledForTitle,
        PhotonApplicationNotFound,
        PhotonApplicationNotAssociatedWithTitle,
        InvalidEmailOrPassword,
        FacebookAPIError,
        InvalidContentType,
        KeyLengthExceeded,
        DataLengthExceeded,
        TooManyKeys,
        FreeTierCannotHaveVirtualCurrency,
        MissingAmazonSharedKey,
        AmazonValidationError,
        InvalidPSNIssuerId,
        PSNInaccessible,
        ExpiredAuthToken,
        FailedToGetEntitlements,
        FailedToConsumeEntitlement,
        TradeAcceptingUserNotAllowed,
        TradeInventoryItemIsAssignedToCharacter,
        TradeInventoryItemIsBundle,
        TradeStatusNotValidForCancelling,
        TradeStatusNotValidForAccepting,
        TradeDoesNotExist,
        TradeCancelled,
        TradeAlreadyFilled,
        TradeWaitForStatusTimeout,
        TradeInventoryItemExpired,
        TradeMissingOfferedAndAcceptedItems,
        TradeAcceptedItemIsBundle,
        TradeAcceptedItemIsStackable,
        TradeInventoryItemInvalidStatus,
        TradeAcceptedCatalogItemInvalid,
        TradeAllowedUsersInvalid,
        TradeInventoryItemDoesNotExist,
        TradeInventoryItemIsConsumed,
        TradeInventoryItemIsStackable,
        TradeAcceptedItemsMismatch,
        InvalidKongregateToken,
        FeatureNotConfiguredForTitle,
        NoMatchingCatalogItemForReceipt,
        InvalidCurrencyCode,
        NoRealMoneyPriceForCatalogItem,
        TradeInventoryItemIsNotTradable,
        TradeAcceptedCatalogItemIsNotTradable,
        UsersAlreadyFriends,
        LinkedIdentifierAlreadyClaimed,
        CustomIdNotLinked,
        TotalDataSizeExceeded,
        DeleteKeyConflict,
        InvalidXboxLiveToken,
        ExpiredXboxLiveToken,
        ResettableStatisticVersionRequired,
        NotAuthorizedByTitle,
        NoPartnerEnabled,
        InvalidPartnerResponse,
        APINotEnabledForGameServerAccess,
        StatisticNotFound,
        StatisticNameConflict,
        StatisticVersionClosedForWrites,
        StatisticVersionInvalid,
        APIClientRequestRateLimitExceeded,
        InvalidJSONContent,
        InvalidDropTable,
        StatisticVersionAlreadyIncrementedForScheduledInterval,
        StatisticCountLimitExceeded,
        StatisticVersionIncrementRateExceeded,
        ContainerKeyInvalid,
        CloudScriptExecutionTimeLimitExceeded,
        NoWritePermissionsForEvent,
        CloudScriptFunctionArgumentSizeExceeded,
        CloudScriptAPIRequestCountExceeded,
        CloudScriptAPIRequestError,
        CloudScriptHTTPRequestError,
        InsufficientGuildRole,
        GuildNotFound,
        OverLimit,
        EventNotFound,
        InvalidEventField,
        InvalidEventName,
        CatalogNotConfigured,
        OperationNotSupportedForPlatform,
        SegmentNotFound,
        StoreNotFound,
        InvalidStatisticName,
        TitleNotQualifiedForLimit,
        InvalidServiceLimitLevel,
        ServiceLimitLevelInTransition,
        CouponAlreadyRedeemed,
        GameServerBuildSizeLimitExceeded,
        GameServerBuildCountLimitExceeded,
        VirtualCurrencyCountLimitExceeded,
        VirtualCurrencyCodeExists,
        TitleNewsItemCountLimitExceeded,
        InvalidTwitchToken,
        TwitchResponseError,
        ProfaneDisplayName,
        UserAlreadyAdded,
        InvalidVirtualCurrencyCode,
        VirtualCurrencyCannotBeDeleted,
        IdentifierAlreadyClaimed,
        IdentifierNotLinked,
        InvalidContinuationToken,
        ExpiredContinuationToken,
        InvalidSegment,
        InvalidSessionId,
        SessionLogNotFound,
        InvalidSearchTerm,
        TwoFactorAuthenticationTokenRequired,
        GameServerHostCountLimitExceeded,
        PlayerTagCountLimitExceeded,
        RequestAlreadyRunning,
        ActionGroupNotFound,
        MaximumSegmentBulkActionJobsRunning,
        NoActionsOnPlayersInSegmentJob,
        DuplicateStatisticName,
        ScheduledTaskNameConflict,
        ScheduledTaskCreateConflict,
        InvalidScheduledTaskName,
        InvalidTaskSchedule,
        SteamNotEnabledForTitle,
        LimitNotAnUpgradeOption,
        NoSecretKeyEnabledForCloudScript,
        TaskNotFound,
        TaskInstanceNotFound,
        InvalidIdentityProviderId,
        MisconfiguredIdentityProvider,
        InvalidScheduledTaskType,
        BillingInformationRequired,
        LimitedEditionItemUnavailable,
        InvalidAdPlacementAndReward,
        AllAdPlacementViewsAlreadyConsumed,
        GoogleOAuthNotConfiguredForTitle,
        GoogleOAuthError,
        UserNotFriend,
        InvalidSignature,
        InvalidPublicKey,
        GoogleOAuthNoIdTokenIncludedInResponse,
        StatisticUpdateInProgress,
        LeaderboardVersionNotAvailable,
        StatisticAlreadyHasPrizeTable,
        PrizeTableHasOverlappingRanks,
        PrizeTableHasMissingRanks,
        PrizeTableRankStartsAtZero,
        InvalidStatistic,
        ExpressionParseFailure,
        ExpressionInvokeFailure,
        ExpressionTooLong,
        DataUpdateRateExceeded,
        RestrictedEmailDomain,
        EncryptionKeyDisabled,
        EncryptionKeyMissing,
        EncryptionKeyBroken,
        NoSharedSecretKeyConfigured,
        SecretKeyNotFound,
        PlayerSecretAlreadyConfigured,
        APIRequestsDisabledForTitle,
        InvalidSharedSecretKey,
        PrizeTableHasNoRanks,
        ProfileDoesNotExist,
        ContentS3OriginBucketNotConfigured,
        InvalidEnvironmentForReceipt,
        EncryptedRequestNotAllowed,
        SignedRequestNotAllowed,
        RequestViewConstraintParamsNotAllowed,
        BadPartnerConfiguration,
        XboxBPCertificateFailure,
        XboxXASSExchangeFailure,
        InvalidEntityId,
        StatisticValueAggregationOverflow,
        EmailMessageFromAddressIsMissing,
        EmailMessageToAddressIsMissing,
        SmtpServerAuthenticationError,
        SmtpServerLimitExceeded,
        SmtpServerInsufficientStorage,
        SmtpServerCommunicationError,
        SmtpServerGeneralFailure,
        EmailClientTimeout,
        EmailClientCanceledTask,
        EmailTemplateMissing,
        InvalidHostForTitleId,
        EmailConfirmationTokenDoesNotExist,
        EmailConfirmationTokenExpired,
        AccountDeleted,
        PlayerSecretNotConfigured,
        InvalidSignatureTime,
        NoContactEmailAddressFound,
        InvalidAuthToken,
        AuthTokenDoesNotExist,
        AuthTokenExpired,
        AuthTokenAlreadyUsedToResetPassword,
        MembershipNameTooLong,
        MembershipNotFound,
        GoogleServiceAccountInvalid,
        GoogleServiceAccountParseFailure,
        EntityTokenMissing,
        EntityTokenInvalid,
        EntityTokenExpired,
        EntityTokenRevoked,
        InvalidProductForSubscription,
        XboxInaccessible,
        SubscriptionAlreadyTaken,
        SmtpAddonNotEnabled,
        APIConcurrentRequestLimitExceeded,
        XboxRejectedXSTSExchangeRequest,
        VariableNotDefined,
        TemplateVersionNotDefined,
        FileTooLarge,
        TitleDeleted,
        TitleContainsUserAccounts,
        TitleDeletionPlayerCleanupFailure,
        EntityFileOperationPending,
        NoEntityFileOperationPending,
        EntityProfileVersionMismatch,
        TemplateVersionTooOld,
        MembershipDefinitionInUse,
        PaymentPageNotConfigured,
        FailedLoginAttemptRateLimitExceeded,
        EntityBlockedByGroup,
        RoleDoesNotExist,
        EntityIsAlreadyMember,
        DuplicateRoleId,
        GroupInvitationNotFound,
        GroupApplicationNotFound,
        OutstandingInvitationAcceptedInstead,
        OutstandingApplicationAcceptedInstead,
        RoleIsGroupDefaultMember,
        RoleIsGroupAdmin,
        RoleNameNotAvailable,
        GroupNameNotAvailable,
        EmailReportAlreadySent,
        EmailReportRecipientBlacklisted,
        EventNamespaceNotAllowed,
        EventEntityNotAllowed,
        InvalidEntityType,
        NullTokenResultFromAad,
        InvalidTokenResultFromAad,
        NoValidCertificateForAad,
        InvalidCertificateForAad,
        DuplicateDropTableId,
        MultiplayerServerError,
        MultiplayerServerTooManyRequests,
        MultiplayerServerNoContent,
        MultiplayerServerBadRequest,
        MultiplayerServerUnauthorized,
        MultiplayerServerForbidden,
        MultiplayerServerNotFound,
        MultiplayerServerConflict,
        MultiplayerServerInternalServerError,
        MultiplayerServerUnavailable,
        ExplicitContentDetected,
        PIIContentDetected,
        InvalidScheduledTaskParameter,
        PerEntityEventRateLimitExceeded,
        TitleDefaultLanguageNotSet,
        EmailTemplateMissingDefaultVersion,
        FacebookInstantGamesIdNotLinked,
        InvalidFacebookInstantGamesSignature,
        FacebookInstantGamesAuthNotConfiguredForTitle,
        EntityProfileConstraintValidationFailed,
        TelemetryIngestionKeyPending,
        TelemetryIngestionKeyNotFound,
        StatisticChildNameInvalid,
        DataIntegrityError,
        VirtualCurrencyCannotBeSetToOlderVersion,
        VirtualCurrencyMustBeWithinIntegerRange,
        EmailTemplateInvalidSyntax,
        EmailTemplateMissingCallback,
        PushNotificationTemplateInvalidPayload,
        InvalidLocalizedPushNotificationLanguage,
        MissingLocalizedPushNotificationMessage,
        PushNotificationTemplateMissingPlatformPayload,
        PushNotificationTemplatePayloadContainsInvalidJson,
        PushNotificationTemplateContainsInvalidIosPayload,
        PushNotificationTemplateContainsInvalidAndroidPayload,
        PushNotificationTemplateIosPayloadMissingNotificationBody,
        PushNotificationTemplateAndroidPayloadMissingNotificationBody,
        PushNotificationTemplateNotFound,
        PushNotificationTemplateMissingDefaultVersion,
        PushNotificationTemplateInvalidSyntax,
        PushNotificationTemplateNoCustomPayloadForV1,
        NoLeaderboardForStatistic,
        TitleNewsMissingDefaultLanguage,
        TitleNewsNotFound,
        TitleNewsDuplicateLanguage,
        TitleNewsMissingTitleOrBody,
        TitleNewsInvalidLanguage,
        EmailRecipientBlacklisted,
        InvalidGameCenterAuthRequest,
        GameCenterAuthenticationFailed,
        CannotEnablePartiesForTitle,
        PartyError,
        PartyRequests,
        PartyNoContent,
        PartyBadRequest,
        PartyUnauthorized,
        PartyForbidden,
        PartyNotFound,
        PartyConflict,
        PartyInternalServerError,
        PartyUnavailable,
        PartyTooManyRequests,
        PushNotificationTemplateMissingName,
        CannotEnableMultiplayerServersForTitle,
        WriteAttemptedDuringExport,
        MultiplayerServerTitleQuotaCoresExceeded,
        AutomationRuleNotFound,
        EntityAPIKeyLimitExceeded,
        EntityAPIKeyNotFound,
        EntityAPIKeyOrSecretInvalid,
        EconomyServiceUnavailable,
        EconomyServiceInternalError,
        QueryRateLimitExceeded,
        EntityAPIKeyCreationDisabledForEntity,
        ForbiddenByEntityPolicy,
        UpdateInventoryRateLimitExceeded,
        StudioCreationRateLimited,
        StudioCreationInProgress,
        DuplicateStudioName,
        StudioNotFound,
        StudioDeleted,
        StudioDeactivated,
        StudioActivated,
        TitleCreationRateLimited,
        TitleCreationInProgress,
        DuplicateTitleName,
        TitleActivationRateLimited,
        TitleActivationInProgress,
        TitleDeactivated,
        TitleActivated,
        CloudScriptAzureFunctionsExecutionTimeLimitExceeded,
        CloudScriptAzureFunctionsArgumentSizeExceeded,
        CloudScriptAzureFunctionsReturnSizeExceeded,
        CloudScriptAzureFunctionsHTTPRequestError,
        VirtualCurrencyBetaGetError,
        VirtualCurrencyBetaCreateError,
        VirtualCurrencyBetaInitialDepositSaveError,
        VirtualCurrencyBetaSaveError,
        VirtualCurrencyBetaDeleteError,
        VirtualCurrencyBetaRestoreError,
        VirtualCurrencyBetaSaveConflict,
        VirtualCurrencyBetaUpdateError,
        InsightsManagementDatabaseNotFound,
        InsightsManagementOperationNotFound,
        InsightsManagementErrorPendingOperationExists,
        InsightsManagementSetPerformanceLevelInvalidParameter,
        InsightsManagementSetStorageRetentionInvalidParameter,
        InsightsManagementGetStorageUsageInvalidParameter,
        InsightsManagementGetOperationStatusInvalidParameter,
        DuplicatePurchaseTransactionId,
        EvaluationModePlayerCountExceeded,
        GetPlayersInSegmentRateLimitExceeded,
        CloudScriptFunctionNameSizeExceeded,
        PaidInsightsFeaturesNotEnabled,
        CloudScriptAzureFunctionsQueueRequestError,
        EvaluationModeTitleCountExceeded,
        InsightsManagementTitleNotInFlight,
        LimitNotFound,
        LimitNotAvailableViaAPI,
        InsightsManagementSetStorageRetentionBelowMinimum,
        InsightsManagementSetStorageRetentionAboveMaximum,
        AppleNotEnabledForTitle,
        InsightsManagementNewActiveEventExportLimitInvalid,
        InsightsManagementSetPerformanceRateLimited,
        PartyRequestsThrottledFromRateLimiter,
        XboxServiceTooManyRequests,
        NintendoSwitchNotEnabledForTitle,
        RequestMultiplayerServersThrottledFromRateLimiter,
        TitleDataOverrideNotFound,
        DuplicateKeys,
        WasNotCreatedWithCloudRoot,
        LegacyMultiplayerServersDeprecated,
        VirtualCurrencyCurrentlyUnavailable,
        SteamUserNotFound,
        ElasticSearchOperationFailed,
        NotImplemented,
        PublisherNotFound,
        PublisherDeleted,
        ApiDisabledForMigration,
        ResourceNameUpdateNotAllowed,
        ApiNotEnabledForTitle,
        DuplicateTitleNameForPublisher,
        AzureTitleCreationInProgress,
        TitleConstraintsPublisherDeletion,
        InvalidPlayerAccountPoolId,
        PlayerAccountPoolNotFound,
        PlayerAccountPoolDeleted,
        TitleCleanupInProgress,
        AzureResourceConcurrentOperationInProgress,
        TitlePublisherUpdateNotAllowed,
        AzureResourceManagerNotSupportedInStamp,
        ApiNotIncludedInAzurePlayFabFeatureSet,
        GoogleServiceAccountFailedAuth,
        GoogleAPIServiceUnavailable,
        GoogleAPIServiceUnknownError,
        NoValidIdentityForAad,
        PlayerIdentityLinkNotFound,
        PhotonApplicationIdAlreadyInUse,
        CloudScriptUnableToDeleteProductionRevision,
        CustomIdNotFound,
        AutomationInvalidInput,
        AutomationInvalidRuleName,
        AutomationRuleAlreadyExists,
        AutomationRuleLimitExceeded,
        InvalidGooglePlayGamesServerAuthCode,
        PlayStreamConnectionFailed,
        InvalidEventContents,
        InsightsV1Deprecated,
        AnalysisSubscriptionNotFound,
        AnalysisSubscriptionFailed,
        AnalysisSubscriptionFoundAlready,
        AnalysisSubscriptionManagementInvalidInput,
        InvalidGameCenterId,
        InvalidNintendoSwitchAccountId,
        EntityAPIKeysNotSupported,
        IpAddressBanned,
        EntityLineageBanned,
        NamespaceMismatch,
        InvalidServiceConfiguration,
        InvalidNamespaceMismatch,
        LeaderboardColumnLengthMismatch,
        InvalidStatisticScore,
        LeaderboardColumnsNotSpecified,
        LeaderboardMaxSizeTooLarge,
        InvalidAttributeStatisticsSpecified,
        LeaderboardNotFound,
        TokenSigningKeyNotFound,
        LeaderboardNameConflict,
        LinkedStatisticColumnMismatch,
        NoLinkedStatisticToLeaderboard,
        StatDefinitionAlreadyLinkedToLeaderboard,
        LinkingStatsNotAllowedForEntityType,
        LeaderboardCountLimitExceeded,
        LeaderboardSizeLimitExceeded,
        LeaderboardDefinitionModificationNotAllowedWhileLinked,
        StatisticDefinitionModificationNotAllowedWhileLinked,
        LeaderboardUpdateNotAllowedWhileLinked,
        CloudScriptAzureFunctionsEventHubRequestError,
        ExternalEntityNotAllowedForTier,
        InvalidBaseTimeForInterval,
        EntityTypeMismatchWithStatDefinition,
        SpecifiedVersionLeaderboardNotFound,
        LeaderboardColumnLengthMismatchWithStatDefinition,
        DuplicateColumnNameFound,
        LinkedStatisticColumnNotFound,
        LinkedStatisticColumnRequired,
        MultipleLinkedStatisticsNotAllowed,
        DuplicateLinkedStatisticColumnNameFound,
        AggregationTypeNotAllowedForMultiColumnStatistic,
        MaxQueryableVersionsValueNotAllowedForTier,
        StatisticDefinitionHasNullOrEmptyVersionConfiguration,
        StatisticColumnLengthMismatch,
        InvalidExternalEntityId,
        UpdatingStatisticsUsingTransactionIdNotAvailableForFreeTier,
        TransactionAlreadyApplied,
        ReportDataNotRetrievedSuccessfully,
        ResetIntervalCannotBeModified,
        VersionIncrementRateExceeded,
        MatchmakingEntityInvalid,
        MatchmakingPlayerAttributesInvalid,
        MatchmakingQueueNotFound,
        MatchmakingMatchNotFound,
        MatchmakingTicketNotFound,
        MatchmakingAlreadyJoinedTicket,
        MatchmakingTicketAlreadyCompleted,
        MatchmakingQueueConfigInvalid,
        MatchmakingMemberProfileInvalid,
        NintendoSwitchDeviceIdNotLinked,
        MatchmakingNotEnabled,
        MatchmakingPlayerAttributesTooLarge,
        MatchmakingNumberOfPlayersInTicketTooLarge,
        MatchmakingAttributeInvalid,
        MatchmakingPlayerHasNotJoinedTicket,
        MatchmakingRateLimitExceeded,
        MatchmakingTicketMembershipLimitExceeded,
        MatchmakingUnauthorized,
        MatchmakingQueueLimitExceeded,
        MatchmakingRequestTypeMismatch,
        MatchmakingBadRequest,
        PubSubFeatureNotEnabledForTitle,
        PubSubTooManyRequests,
        PubSubConnectionNotFoundForEntity,
        PubSubConnectionHandleInvalid,
        PubSubSubscriptionLimitExceeded,
        TitleConfigNotFound,
        TitleConfigUpdateConflict,
        TitleConfigSerializationError,
        CatalogApiNotImplemented,
        CatalogEntityInvalid,
        CatalogTitleIdMissing,
        CatalogPlayerIdMissing,
        CatalogClientIdentityInvalid,
        CatalogOneOrMoreFilesInvalid,
        CatalogItemMetadataInvalid,
        CatalogItemIdInvalid,
        CatalogSearchParameterInvalid,
        CatalogFeatureDisabled,
        CatalogConfigInvalid,
        CatalogItemTypeInvalid,
        CatalogBadRequest,
        CatalogTooManyRequests,
        InvalidCatalogItemConfiguration,
        ExportInvalidStatusUpdate,
        ExportInvalidPrefix,
        ExportBlobContainerDoesNotExist,
        ExportNotFound,
        ExportCouldNotUpdate,
        ExportInvalidStorageType,
        ExportAmazonBucketDoesNotExist,
        ExportInvalidBlobStorage,
        ExportKustoException,
        ExportKustoConnectionFailed,
        ExportUnknownError,
        ExportCantEditPendingExport,
        ExportLimitExports,
        ExportLimitEvents,
        ExportInvalidPartitionStatusModification,
        ExportCouldNotCreate,
        ExportNoBackingDatabaseFound,
        ExportCouldNotDelete,
        ExportCannotDetermineEventQuery,
        ExportInvalidQuerySchemaModification,
        ExportQuerySchemaMissingRequiredColumns,
        ExportCannotParseQuery,
        ExportControlCommandsNotAllowed,
        ExportQueryMissingTableReference,
        ExportInsightsV1Deprecated,
        ExplorerBasicInvalidQueryName,
        ExplorerBasicInvalidQueryDescription,
        ExplorerBasicInvalidQueryConditions,
        ExplorerBasicInvalidQueryStartDate,
        ExplorerBasicInvalidQueryEndDate,
        ExplorerBasicInvalidQueryGroupBy,
        ExplorerBasicInvalidQueryAggregateType,
        ExplorerBasicInvalidQueryAggregateProperty,
        ExplorerBasicLoadQueriesError,
        ExplorerBasicLoadQueryError,
        ExplorerBasicCreateQueryError,
        ExplorerBasicDeleteQueryError,
        ExplorerBasicUpdateQueryError,
        ExplorerBasicSavedQueriesLimit,
        ExplorerBasicSavedQueryNotFound,
        TenantShardMapperShardNotFound,
        TitleNotEnabledForParty,
        PartyVersionNotFound,
        MultiplayerServerBuildReferencedByMatchmakingQueue,
        MultiplayerServerBuildReferencedByBuildAlias,
        MultiplayerServerBuildAliasReferencedByMatchmakingQueue,
        PartySerializationError,
        ExperimentationExperimentStopped,
        ExperimentationExperimentRunning,
        ExperimentationExperimentNotFound,
        ExperimentationExperimentNeverStarted,
        ExperimentationExperimentDeleted,
        ExperimentationClientTimeout,
        ExperimentationInvalidVariantConfiguration,
        ExperimentationInvalidVariableConfiguration,
        ExperimentInvalidId,
        ExperimentationNoScorecard,
        ExperimentationTreatmentAssignmentFailed,
        ExperimentationTreatmentAssignmentDisabled,
        ExperimentationInvalidDuration,
        ExperimentationMaxExperimentsReached,
        ExperimentationExperimentSchedulingInProgress,
        ExperimentationInvalidEndDate,
        ExperimentationInvalidStartDate,
        ExperimentationMaxDurationExceeded,
        ExperimentationExclusionGroupNotFound,
        ExperimentationExclusionGroupInsufficientCapacity,
        ExperimentationExclusionGroupCannotDelete,
        ExperimentationExclusionGroupInvalidTrafficAllocation,
        ExperimentationExclusionGroupInvalidName,
        MaxActionDepthExceeded,
        TitleNotOnUpdatedPricingPlan,
        SegmentManagementTitleNotInFlight,
        SegmentManagementNoExpressionTree,
        SegmentManagementTriggerActionCountOverLimit,
        SegmentManagementSegmentCountOverLimit,
        SegmentManagementInvalidSegmentId,
        SegmentManagementInvalidInput,
        SegmentManagementInvalidSegmentName,
        DeleteSegmentRateLimitExceeded,
        CreateSegmentRateLimitExceeded,
        UpdateSegmentRateLimitExceeded,
        GetSegmentsRateLimitExceeded,
        AsyncExportNotInFlight,
        AsyncExportNotFound,
        AsyncExportRateLimitExceeded,
        AnalyticsSegmentCountOverLimit,
        SnapshotNotFound,
        InventoryApiNotImplemented,
        LobbyDoesNotExist,
        LobbyRateLimitExceeded,
        LobbyPlayerAlreadyJoined,
        LobbyNotJoinable,
        LobbyMemberCannotRejoin,
        LobbyCurrentPlayersMoreThanMaxPlayers,
        LobbyPlayerNotPresent,
        LobbyBadRequest,
        LobbyPlayerMaxLobbyLimitExceeded,
        LobbyNewOwnerMustBeConnected,
        LobbyCurrentOwnerStillConnected,
        LobbyMemberIsNotOwner,
        LobbyServerMismatch,
        LobbyServerNotFound,
        LobbyDifferentServerAlreadyJoined,
        LobbyServerAlreadyJoined,
        LobbyIsNotClientOwned,
        LobbyDoesNotUseConnections,
        EventSamplingInvalidRatio,
        EventSamplingInvalidEventNamespace,
        EventSamplingInvalidEventName,
        EventSamplingRatioNotFound,
        TelemetryKeyNotFound,
        TelemetryKeyInvalidName,
        TelemetryKeyAlreadyExists,
        TelemetryKeyInvalid,
        TelemetryKeyCountOverLimit,
        TelemetryKeyDeactivated,
        TelemetryKeyLongInsightsRetentionNotAllowed,
        EventSinkConnectionInvalid,
        EventSinkConnectionUnauthorized,
        EventSinkRegionInvalid,
        EventSinkLimitExceeded,
        EventSinkSasTokenInvalid,
        EventSinkNotFound,
        EventSinkNameInvalid,
        EventSinkSasTokenPermissionInvalid,
        EventSinkSecretInvalid,
        EventSinkTenantNotFound,
        EventSinkAadNotFound,
        EventSinkDatabaseNotFound,
        EventSinkTitleUnauthorized,
        EventSinkInsufficientRoleAssignment,
        EventSinkContainerNotFound,
        EventSinkTenantIdInvalid,
        OperationCanceled,
        InvalidDisplayNameRandomSuffixLength,
        AllowNonUniquePlayerDisplayNamesDisableNotAllowed,
        PartitionedEventInvalid,
        PartitionedEventCountOverLimit,
        ManageEventNamespaceInvalid,
        ManageEventNameInvalid,
        ManagedEventNotFound,
        ManageEventsInvalidRatio,
        ManagedEventInvalid,
        PlayerCustomPropertiesPropertyNameTooLong,
        PlayerCustomPropertiesPropertyNameIsInvalid,
        PlayerCustomPropertiesStringPropertyValueTooLong,
        PlayerCustomPropertiesValueIsInvalidType,
        PlayerCustomPropertiesVersionMismatch,
        PlayerCustomPropertiesPropertyCountTooHigh,
        PlayerCustomPropertiesDuplicatePropertyName,
        PlayerCustomPropertiesPropertyDoesNotExist,
        AddonAlreadyExists,
        AddonDoesntExist,
        CopilotDisabled,
        CopilotInvalidRequest,
        TrueSkillUnauthorized,
        TrueSkillInvalidTitleId,
        TrueSkillInvalidScenarioId,
        TrueSkillInvalidModelId,
        TrueSkillInvalidModelName,
        TrueSkillInvalidPlayerIds,
        TrueSkillInvalidEntityKey,
        TrueSkillInvalidConditionKey,
        TrueSkillInvalidConditionValue,
        TrueSkillInvalidConditionAffinityWeight,
        TrueSkillInvalidEventName,
        TrueSkillMatchResultCreated,
        TrueSkillMatchResultAlreadySubmitted,
        TrueSkillBadPlayerIdInMatchResult,
        TrueSkillInvalidBotIdInMatchResult,
        TrueSkillDuplicatePlayerInMatchResult,
        TrueSkillNoPlayerInMatchResultTeam,
        TrueSkillPlayersInMatchResultExceedingLimit,
        TrueSkillInvalidPreMatchPartyInMatchResult,
        TrueSkillInvalidTimestampInMatchResult,
        TrueSkillStartTimeMissingInMatchResult,
        TrueSkillEndTimeMissingInMatchResult,
        TrueSkillInvalidPlayerSecondsPlayedInMatchResult,
        TrueSkillNoTeamInMatchResult,
        TrueSkillNotEnoughTeamsInMatchResult,
        TrueSkillInvalidRanksInMatchResult,
        TrueSkillNoWinnerInMatchResult,
        TrueSkillMissingRequiredCondition,
        TrueSkillMissingRequiredEvent,
        TrueSkillUnknownEventName,
        TrueSkillInvalidEventCount,
        TrueSkillUnknownConditionKey,
        TrueSkillUnknownConditionValue,
        TrueSkillScenarioConfigDoesNotExist,
        TrueSkillUnknownModelId,
        TrueSkillNoModelInScenario,
        TrueSkillNotSupportedForTitle,
        TrueSkillModelIsNotActive,
        TrueSkillUnauthorizedToQueryOtherPlayerSkills,
        TrueSkillInvalidMaxIterations,
        TrueSkillEndTimeBeforeStartTime,
        TrueSkillInvalidJobId,
        TrueSkillInvalidMetadataId,
        TrueSkillMissingBuildVerison,
        TrueSkillJobAlreadyExists,
        TrueSkillJobNotFound,
        TrueSkillOperationCanceled,
        TrueSkillActiveModelLimitExceeded,
        TrueSkillTotalModelLimitExceeded,
        TrueSkillUnknownInitialModelId,
        TrueSkillUnauthorizedForJob,
        TrueSkillInvalidScenarioName,
        TrueSkillConditionStateIsRequired,
        TrueSkillEventStateIsRequired,
        TrueSkillDuplicateEvent,
        TrueSkillDuplicateCondition,
        TrueSkillInvalidAnomalyThreshold,
        TrueSkillConditionKeyLimitExceeded,
        TrueSkillConditionValuePerKeyLimitExceeded,
        TrueSkillInvalidTimestamp,
        TrueSkillEventLimitExceeded,
        TrueSkillInvalidPlayers,
        TrueSkillTrueSkillPlayerNull,
        TrueSkillInvalidPlayerId,
        TrueSkillInvalidSquadSize,
        TrueSkillConditionSetNotInModel,
        TrueSkillModelStateInvalidForOperation,
        TrueSkillScenarioContainsActiveModel,
        TrueSkillInvalidConditionRank,
        GameSaveManifestNotFound,
        GameSaveManifestVersionAlreadyExists,
        GameSaveConflictUpdatingManifest,
        GameSaveManifestUpdatesNotAllowed,
        GameSaveFileAlreadyExists,
        GameSaveManifestVersionNotFinalized,
        GameSaveUnknownFileInManifest,
        GameSaveFileExceededReportedSize,
        GameSaveFileNotUploaded,
        GameSaveBadRequest,
        GameSaveOperationNotAllowed,
        GameSaveDataStorageQuotaExceeded,
        GameSaveNewerManifestExists,
        GameSaveBaseVersionNotAvailable,
        GameSaveManifestVersionQuarantined,
        StateShareForbidden,
        StateShareTitleNotInFlight,
        StateShareStateNotFound,
        StateShareLinkNotFound,
        StateShareStateRedemptionLimitExceeded,
        StateShareStateRedemptionLimitNotUpdated,
        StateShareCreatedStatesLimitExceeded,
        StateShareIdMissingOrMalformed
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

    /** Request has no paramaters. */
    @Deprecated
    public static class GetAllSegmentsRequest {
        
    }

    @Deprecated
    public static class GetAllSegmentsResult {
        /** Array of segments for this title. */
        @Deprecated
        public ArrayList<GetSegmentResult> Segments;
        
    }

    @Deprecated
    public static class GetCatalogItemsRequest {
        /** Which catalog is being requested. If null, uses the default catalog. */
        @Deprecated
        public String CatalogVersion;
        
    }

    @Deprecated
    public static class GetCatalogItemsResult {
        /** Array of items which can be purchased. */
        @Deprecated
        @Unordered("ItemId")
        public ArrayList<CatalogItem> Catalog;
        
    }

    /**
     * Data is stored as JSON key-value pairs. If the Keys parameter is provided, the data object returned will only contain
     * the data specific to the indicated Keys. Otherwise, the full set of custom user data will be returned.
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Array of virtual currency balance(s) belonging to the character. */
        @Deprecated
        public Map<String,Integer> VirtualCurrency;
        /** Array of remaining times and timestamps for virtual currencies. */
        @Deprecated
        public Map<String,VirtualCurrencyRechargeTime> VirtualCurrencyRechargeTimes;
        
    }

    @Deprecated
    public static class GetCharacterLeaderboardRequest {
        /** Maximum number of entries to retrieve. */
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

    /**
     * Character statistics are similar to user statistics in that they are numeric values which may only be updated by a
     * server operation, in order to minimize the opportunity for unauthorized changes. In addition to being available for use
     * by the title, the statistics are used for all leaderboard operations in PlayFab.
     */
    @Deprecated
    public static class GetCharacterStatisticsRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetCharacterStatisticsResult {
        /** Unique identifier of the character for the statistics. */
        @Deprecated
        public String CharacterId;
        /** Character statistics for the requested user. */
        @Deprecated
        public Map<String,Integer> CharacterStatistics;
        /** PlayFab unique identifier of the user whose character statistics are being returned. */
        @Deprecated
        public String PlayFabId;
        
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
        /** Maximum number of entries to retrieve. */
        @Deprecated
        public Integer MaxResultsCount;
        /** The player whose friend leaderboard to get */
        @Deprecated
        public String PlayFabId;
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
        /** PlayFab identifier of the player whose friend list to get. */
        @Deprecated
        public String PlayFabId;
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
     * recently, and only friends who also plays this game will be included. For Xbox Live, user has to have logged into the
     * Xbox Live recently, and only friends who also play this game will be included.
     */
    @Deprecated
    public static class GetFriendsListResult {
        /** Array of friends found. */
        @Deprecated
        public ArrayList<FriendInfo> Friends;
        
    }

    @Deprecated
    public static class GetLeaderboardAroundCharacterRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Maximum number of entries to retrieve. */
        @Deprecated
        public Integer MaxResultsCount;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
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
    public static class GetLeaderboardAroundUserRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Maximum number of entries to retrieve. */
        @Deprecated
        public Integer MaxResultsCount;
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
        /** Unique identifier for the title-specific statistic for the leaderboard. */
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
    public static class GetLeaderboardAroundUserResult {
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
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
        /** Maximum number of entries to retrieve. */
        @Deprecated
        public Integer MaxResultsCount;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client,
         * only the allowed client profile properties for the title may be requested. These allowed properties are configured in
         * the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        @Deprecated
        public PlayerProfileViewConstraints ProfileConstraints;
        /** First entry in the leaderboard to be retrieved. */
        @Deprecated
        public Integer StartPosition;
        /** Unique identifier for the title-specific statistic for the leaderboard. */
        @Deprecated
        public String StatisticName;
        /** The version of the leaderboard to get. */
        @Deprecated
        public Integer Version;
        
    }

    /** Note that the Position of the user in the results is for the overall leaderboard. */
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
    public static class GetPlayerCombinedInfoRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** PlayFabId of the user whose data will be returned */
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
    public static class GetPlayerSegmentsResult {
        /** Array of segments the requested player currently belongs to. */
        @Deprecated
        public ArrayList<GetSegmentResult> Segments;
        
    }

    /**
     * Initial request must contain at least a Segment ID. Subsequent requests must contain the Segment ID as well as the
     * Continuation Token. Failure to send the Continuation Token will result in a new player segment list being generated.
     * Each time the Continuation Token is passed in the length of the Total Seconds to Live is refreshed. If too much time
     * passes between requests to the point that a subsequent request is past the Total Seconds to Live an error will be
     * returned and paging will be terminated. This API is resource intensive and should not be used in scenarios which might
     * generate high request volumes. Only one request to this API at a time should be made per title. Concurrent requests to
     * the API may be rejected with the APIConcurrentRequestLimitExceeded error.
     */
    @Deprecated
    public static class GetPlayersInSegmentRequest {
        /** Continuation token if retrieving subsequent pages of results. */
        @Deprecated
        public String ContinuationToken;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * If set to true, the profiles are loaded asynchronously and the response will include a continuation token and
         * approximate profile count until the first batch of profiles is loaded. Use this parameter to help avoid network
         * timeouts.
         */
        @Deprecated
        public Boolean GetProfilesAsync;
        /**
         * Maximum is 10,000. The value 0 will prevent loading any profiles and return only the count of profiles matching this
         * segment.
         */
        @Deprecated
        public Long MaxBatchSize;
        /**
         * Number of seconds to keep the continuation token active. After token expiration it is not possible to continue paging
         * results. Default is 300 (5 minutes). Maximum is 5,400 (90 minutes).
         */
        @Deprecated
        public Long SecondsToLive;
        /** Unique identifier for this segment. */
        @Deprecated
        public String SegmentId;
        
    }

    @Deprecated
    public static class GetPlayersInSegmentResult {
        /** Continuation token to use to retrieve subsequent pages of results. If token returns null there are no more results. */
        @Deprecated
        public String ContinuationToken;
        /** Array of player profiles in this segment. */
        @Deprecated
        public ArrayList<PlayerProfile> PlayerProfiles;
        /** Count of profiles matching this segment. */
        @Deprecated
        public Integer ProfilesInSegment;
        
    }

    @Deprecated
    public static class GetPlayersSegmentsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetPlayerStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** user for whom statistics are being requested */
        @Deprecated
        public String PlayFabId;
        /** statistics to return */
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
        /** PlayFab unique identifier of the user whose statistics are being returned */
        @Deprecated
        public String PlayFabId;
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

    /** For Facebook Instant Games identifiers which have not been linked to PlayFab accounts, null will be returned. */
    @Deprecated
    public static class GetPlayFabIDsFromFacebookInstantGamesIdsResult {
        /** Mapping of Facebook Instant Games identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<FacebookInstantGamesPlayFabIdPair> Data;
        
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

    /** For Nintendo Switch Device identifiers which have not been linked to PlayFab accounts, null will be returned. */
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

    /** For Steam identifiers which have not been linked to PlayFab accounts, null will be returned. */
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
    public static class GetRandomResultTablesRequest {
        /**
         * Specifies the catalog version that should be used to retrieve the Random Result Tables. If unspecified, uses
         * default/primary catalog.
         */
        @Deprecated
        public String CatalogVersion;
        /** The unique identifier of the Random Result Table to use. */
        @Deprecated
        public ArrayList<String> TableIDs;
        
    }

    /**
     * Note that if a specified Random Result Table contains no entries, or does not exist in the catalog, an InvalidDropTable
     * error will be returned.
     */
    @Deprecated
    public static class GetRandomResultTablesResult {
        /** array of random result tables currently available */
        @Deprecated
        public Map<String,RandomResultTableListing> Tables;
        
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
    public static class GetServerCustomIDsFromPlayFabIDsRequest {
        /**
         * Array of unique PlayFab player identifiers for which the title needs to get server custom identifiers. Cannot contain
         * more than 25 identifiers.
         */
        @Deprecated
        public ArrayList<String> PlayFabIDs;
        
    }

    /** For a PlayFab account that isn't associated with a server custom identity, ServerCustomId will be null. */
    @Deprecated
    public static class GetServerCustomIDsFromPlayFabIDsResult {
        /** Mapping of server custom player identifiers to PlayFab identifiers. */
        @Deprecated
        public ArrayList<ServerCustomIDPlayFabIDPair> Data;
        
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
    public static class GetStoreItemsServerRequest {
        /** Catalog version to store items from. Use default catalog version if null */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Optional identifier for the player to use in requesting the store information - if used, segment overrides will be
         * applied
         */
        @Deprecated
        public String PlayFabId;
        /** Unqiue identifier for the store which is being requested */
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
     * build. If an override label is specified in the request, the overrides are applied automatically and returned with the
     * title data. Note that there may up to a minute delay in between updating title data and this API call returning the
     * newest value.
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
        /** Array of localized news items. */
        @Deprecated
        public ArrayList<TitleNewsItem> News;
        
    }

    /**
     * This API allows for access to details regarding a user in the PlayFab service, usually for purposes of customer support.
     * Note that data returned may be Personally Identifying Information (PII), such as email address, and so care should be
     * taken in how this data is stored and managed. Since this call will always return the relevant information for users who
     * have accessed the title, the recommendation is to not store this data locally.
     */
    @Deprecated
    public static class GetUserAccountInfoRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetUserAccountInfoResult {
        /** Account details for the user whose information was requested. */
        @Deprecated
        public UserAccountInfo UserInfo;
        
    }

    /** Get all bans for a user, including inactive and expired bans. */
    @Deprecated
    public static class GetUserBansRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetUserBansResult {
        /** Information about the bans */
        @Deprecated
        public ArrayList<BanInfo> BanData;
        
    }

    /**
     * Data is stored as JSON key-value pairs. If the Keys parameter is provided, the data object returned will only contain
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
        /** Specific keys to search for in the custom user data. */
        @Deprecated
        public ArrayList<String> Keys;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
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
        /** PlayFab unique identifier of the user whose custom data is being returned. */
        @Deprecated
        public String PlayFabId;
        
    }

    /**
     * All items currently in the user inventory will be returned, irrespective of how they were acquired (via purchasing,
     * grants, coupons, etc.). Items that are expired, fully consumed, or are no longer valid are not considered to be in the
     * user's current inventory, and so will not be not included.
     */
    @Deprecated
    public static class GetUserInventoryRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetUserInventoryResult {
        /** Array of inventory items belonging to the user. */
        @Deprecated
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> Inventory;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Array of virtual currency balance(s) belonging to the user. */
        @Deprecated
        public Map<String,Integer> VirtualCurrency;
        /** Array of remaining times and timestamps for virtual currencies. */
        @Deprecated
        public Map<String,VirtualCurrencyRechargeTime> VirtualCurrencyRechargeTimes;
        
    }

    /** Grants a character to the user of the type and name specified in the request. */
    @Deprecated
    public static class GrantCharacterToUserRequest {
        /** Non-unique display name of the character being granted (1-40 characters in length). */
        @Deprecated
        public String CharacterName;
        /** Type of the character being granted; statistics can be sliced based on this value. */
        @Deprecated
        public String CharacterType;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GrantCharacterToUserResult {
        /** Unique identifier tagged to this character. */
        @Deprecated
        public String CharacterId;
        
    }

    /**
     * Result of granting an item to a user. Note, to retrieve additional information for an item such as Tags, Description
     * that are the same across all instances of the item, a call to GetCatalogItems is required. The ItemID of can be matched
     * to a catalog entry, which contains the additional information. Also note that Custom Data is only set when the User's
     * specific instance has updated the CustomData via a call to UpdateUserInventoryItemCustomData. Other fields such as
     * UnitPrice and UnitCurrency are only set when the item was granted via a purchase.
     */
    @Deprecated
    public static class GrantedItemInstance implements Comparable<GrantedItemInstance> {
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
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Timestamp for when this instance was purchased. */
        @Deprecated
        public Date PurchaseDate;
        /** Total number of remaining uses, if this is a consumable item. */
        @Deprecated
        public Integer RemainingUses;
        /** Result of this operation. */
        @Deprecated
        public Boolean Result;
        /** Currency type for the cost of the catalog item. Not available when granting items. */
        @Deprecated
        public String UnitCurrency;
        /** Cost of the catalog item in the given currency. Not available when granting items. */
        @Deprecated
        public Long UnitPrice;
        /** The number of uses that were added or removed to this item in this call. */
        @Deprecated
        public Integer UsesIncrementedBy;
        
        public int compareTo(GrantedItemInstance other) {
            if (other == null || other.ItemInstanceId == null) return 1;
            if (ItemInstanceId == null) return -1;
            return ItemInstanceId.compareTo(other.ItemInstanceId);
        }
    }

    /**
     * This function directly adds inventory items to the character's inventories. As a result of this operations, the user
     * will not be charged any transaction fee, regardless of the inventory item catalog definition. Please note that the
     * processing time for inventory grants and purchases increases fractionally the more items are in the inventory, and the
     * more items are in the grant/purchase operation.
     */
    @Deprecated
    public static class GrantItemsToCharacterRequest {
        /** String detailing any additional information concerning this operation. */
        @Deprecated
        public String Annotation;
        /** Catalog version from which items are to be granted. */
        @Deprecated
        public String CatalogVersion;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Array of itemIds to grant to the user. */
        @Deprecated
        public ArrayList<String> ItemIds;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GrantItemsToCharacterResult {
        /** Array of items granted to users. */
        @Deprecated
        public ArrayList<GrantedItemInstance> ItemGrantResults;
        
    }

    /**
     * This function directly adds inventory items to the user's inventories. As a result of this operations, the user will not
     * be charged any transaction fee, regardless of the inventory item catalog definition. Please note that the processing
     * time for inventory grants and purchases increases fractionally the more items are in the inventory, and the more items
     * are in the grant/purchase operation.
     */
    @Deprecated
    public static class GrantItemsToUserRequest {
        /** String detailing any additional information concerning this operation. */
        @Deprecated
        public String Annotation;
        /** Catalog version from which items are to be granted. */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Array of itemIds to grant to the user. */
        @Deprecated
        public ArrayList<String> ItemIds;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    /** Please note that the order of the items in the response may not match the order of items in the request. */
    @Deprecated
    public static class GrantItemsToUserResult {
        /** Array of items granted to users. */
        @Deprecated
        public ArrayList<GrantedItemInstance> ItemGrantResults;
        
    }

    /**
     * This function directly adds inventory items to user inventories. As a result of this operations, the user will not be
     * charged any transaction fee, regardless of the inventory item catalog definition. Please note that the processing time
     * for inventory grants and purchases increases fractionally the more items are in the inventory, and the more items are in
     * the grant/purchase operation.
     */
    @Deprecated
    public static class GrantItemsToUsersRequest {
        /** Catalog version from which items are to be granted. */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Array of items to grant and the users to whom the items are to be granted. */
        @Deprecated
        @Unordered
        public ArrayList<ItemGrant> ItemGrants;
        
    }

    /** Please note that the order of the items in the response may not match the order of items in the request. */
    @Deprecated
    public static class GrantItemsToUsersResult {
        /** Array of items granted to users. */
        @Deprecated
        public ArrayList<GrantedItemInstance> ItemGrantResults;
        
    }

    @Deprecated
    public static class ItemGrant {
        /** String detailing any additional information concerning this operation. */
        @Deprecated
        public String Annotation;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may
         * not begin with a '!' character or be null.
         */
        @Deprecated
        public Map<String,String> Data;
        /** Unique identifier of the catalog item to be granted to the user. */
        @Deprecated
        public String ItemId;
        /**
         * Optional list of Data-keys to remove from UserData. Some SDKs cannot insert null-values into Data due to language
         * constraints. Use this to delete the keys directly.
         */
        @Deprecated
        public ArrayList<String> KeysToRemove;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class LinkNintendoServiceAccountSubjectRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to a specific Nintendo Service Account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** The Nintendo Service Account subject or id to link to the PlayFab user. */
        @Deprecated
        public String Subject;
        
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class LinkNintendoSwitchDeviceIdResult {
        
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Redirect URI supplied to PlayStation :tm: Network when requesting an auth code */
        @Deprecated
        public String RedirectUri;
        
    }

    @Deprecated
    public static class LinkPSNAccountResult {
        
    }

    @Deprecated
    public static class LinkPSNIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Id of the PlayStation :tm: Network issuer environment. If null, defaults to production environment. */
        @Deprecated
        public Integer IssuerId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Id of the PlayStation :tm: Network user. Also known as the PSN Account Id. */
        @Deprecated
        public String PSNUserId;
        
    }

    @Deprecated
    public static class LinkPSNIdResponse {
        
    }

    @Deprecated
    public static class LinkServerCustomIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the custom ID, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Unique PlayFab identifier. */
        @Deprecated
        public String PlayFabId;
        /** Unique server custom identifier for this player. */
        @Deprecated
        public String ServerCustomId;
        
    }

    @Deprecated
    public static class LinkServerCustomIdResult {
        
    }

    @Deprecated
    public static class LinkSteamIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Xbox Live identifier. */
        @Deprecated
        public String PlayFabId;
        /** Unique Steam identifier for a user. */
        @Deprecated
        public String SteamId;
        
    }

    @Deprecated
    public static class LinkSteamIdResult {
        
    }

    @Deprecated
    public static class LinkXboxAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** If another user is already linked to the account, unlink the other user and re-link. */
        @Deprecated
        public Boolean ForceLink;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Xbox Live identifier. */
        @Deprecated
        public String PlayFabId;
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

    /** Contains the localized push notification content. */
    @Deprecated
    public static class LocalizedPushNotificationProperties {
        /** Message of the localized push notification template. */
        @Deprecated
        public String Message;
        /** Subject of the localized push notification template. */
        @Deprecated
        public String Subject;
        
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
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Id of the PlayStation :tm: Network issuer environment. If null, defaults to production environment. */
        @Deprecated
        public Integer IssuerId;
        /** Redirect URI supplied to PlayStation :tm: Network when requesting an auth code */
        @Deprecated
        public String RedirectUri;
        
    }

    @Deprecated
    public static class LoginWithServerCustomIdRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /** The backend server identifier for this player. */
        @Deprecated
        public String ServerCustomId;
        
    }

    /**
     * If this is the first time a user has signed in with the Steam ID and CreateAccount is set to true, a new PlayFab account
     * will be created and linked to the Steam account. In this case, no email or username will be associated with the PlayFab
     * account. Otherwise, if no PlayFab account is linked to the Steam account, an error indicating this will be returned, so
     * that the title can guide the user through creation of a PlayFab account. Steam users that are not logged into the Steam
     * Client app will only have their Steam username synced, other data, such as currency and country will not be available
     * until they login while the Client is open.
     */
    @Deprecated
    public static class LoginWithSteamIdRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** Unique Steam identifier for a user. */
        @Deprecated
        public String SteamId;
        
    }

    /**
     * If this is the first time a user has signed in with the Xbox ID and CreateAccount is set to true, a new PlayFab account
     * will be created and linked to the Xbox Live account. In this case, no email or username will be associated with the
     * PlayFab account. Otherwise, if no PlayFab account is linked to the Xbox Live account, an error indicating this will be
     * returned, so that the title can guide the user through creation of a PlayFab account.
     */
    @Deprecated
    public static class LoginWithXboxIdRequest {
        /** Automatically create a PlayFab account if one is not currently linked to this ID. */
        @Deprecated
        public Boolean CreateAccount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /** The id of Xbox Live sandbox. */
        @Deprecated
        public String Sandbox;
        /** Unique Xbox identifier for a user. */
        @Deprecated
        public String XboxId;
        
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
        /** Flags for which pieces of info to return for the user. */
        @Deprecated
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
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
    public static class ModifyCharacterVirtualCurrencyResult {
        /** Balance of the virtual currency after modification. */
        @Deprecated
        public Integer Balance;
        /** Name of the virtual currency which was modified. */
        @Deprecated
        public String VirtualCurrency;
        
    }

    /**
     * This function can both add and remove uses of an inventory item. If the number of uses drops below zero, the item will
     * be removed from active inventory.
     */
    @Deprecated
    public static class ModifyItemUsesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique instance identifier of the item to be modified. */
        @Deprecated
        public String ItemInstanceId;
        /** PlayFab unique identifier of the user whose item is being modified. */
        @Deprecated
        public String PlayFabId;
        /** Number of uses to add to the item. Can be negative to remove uses. */
        @Deprecated
        public Integer UsesToAdd;
        
    }

    @Deprecated
    public static class ModifyItemUsesResult {
        /** Unique instance identifier of the item with uses consumed. */
        @Deprecated
        public String ItemInstanceId;
        /** Number of uses remaining on the item. */
        @Deprecated
        public Integer RemainingUses;
        
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
     * Transfers an item from a character to another character that is owned by the same user. This will remove the item from
     * the character's inventory (until and unless it is moved back), and will enable the other character to make use of the
     * item instead.
     */
    @Deprecated
    public static class MoveItemToCharacterFromCharacterRequest {
        /** Unique identifier of the character that currently has the item. */
        @Deprecated
        public String GivingCharacterId;
        /** Unique PlayFab assigned instance identifier of the item */
        @Deprecated
        public String ItemInstanceId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Unique identifier of the character that will be receiving the item. */
        @Deprecated
        public String ReceivingCharacterId;
        
    }

    @Deprecated
    public static class MoveItemToCharacterFromCharacterResult {
        
    }

    /**
     * Transfers an item from a user to a character she owns. This will remove the item from the user's inventory (until and
     * unless it is moved back), and will enable the character to make use of the item instead.
     */
    @Deprecated
    public static class MoveItemToCharacterFromUserRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Unique PlayFab assigned instance identifier of the item */
        @Deprecated
        public String ItemInstanceId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class MoveItemToCharacterFromUserResult {
        
    }

    /**
     * Transfers an item from a character to the owning user. This will remove the item from the character's inventory (until
     * and unless it is moved back), and will enable the user to make use of the item instead.
     */
    @Deprecated
    public static class MoveItemToUserFromCharacterRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Unique PlayFab assigned instance identifier of the item */
        @Deprecated
        public String ItemInstanceId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class MoveItemToUserFromCharacterResult {
        
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
    public static class PlayerLinkedAccount {
        /** Linked account's email */
        @Deprecated
        public String Email;
        /** Authentication platform */
        @Deprecated
        public LoginIdentityProvider Platform;
        /** Platform user identifier */
        @Deprecated
        public String PlatformUserId;
        /** Linked account's username */
        @Deprecated
        public String Username;
        
    }

    @Deprecated
    public static class PlayerLocation {
        /** City of the player's geographic location. */
        @Deprecated
        public String City;
        /** The two-character continent code for this location */
        @Deprecated
        public ContinentCode ContinentCode;
        /** The two-character ISO 3166-1 country code for the country associated with the location */
        @Deprecated
        public CountryCode CountryCode;
        /** Latitude coordinate of the player's geographic location. */
        @Deprecated
        public Double Latitude;
        /** Longitude coordinate of the player's geographic location. */
        @Deprecated
        public Double Longitude;
        
    }

    @Deprecated
    public static class PlayerProfile {
        /** Array of ad campaigns player has been attributed to */
        @Deprecated
        public ArrayList<AdCampaignAttribution> AdCampaignAttributions;
        /** Image URL of the player's avatar. */
        @Deprecated
        public String AvatarUrl;
        /** Banned until UTC Date. If permanent ban this is set for 20 years after the original ban date. */
        @Deprecated
        public Date BannedUntil;
        /** The prediction of the player to churn within the next seven days. */
        @Deprecated
        public ChurnRiskLevel ChurnPrediction;
        /** Array of contact email addresses associated with the player */
        @Deprecated
        public ArrayList<ContactEmailInfo> ContactEmailAddresses;
        /** Player record created */
        @Deprecated
        public Date Created;
        /** Player Display Name */
        @Deprecated
        public String DisplayName;
        /** Last login */
        @Deprecated
        public Date LastLogin;
        /** Array of third party accounts linked to this player */
        @Deprecated
        public ArrayList<PlayerLinkedAccount> LinkedAccounts;
        /** Dictionary of player's locations by type. */
        @Deprecated
        public Map<String,PlayerLocation> Locations;
        /** Player account origination */
        @Deprecated
        public LoginIdentityProvider Origination;
        /** List of player variants for experimentation */
        @Deprecated
        public ArrayList<String> PlayerExperimentVariants;
        /** PlayFab Player ID */
        @Deprecated
        public String PlayerId;
        /** Array of player statistics */
        @Deprecated
        public ArrayList<PlayerStatistic> PlayerStatistics;
        /** Publisher this player belongs to */
        @Deprecated
        public String PublisherId;
        /** Array of configured push notification end points */
        @Deprecated
        public ArrayList<PushNotificationRegistration> PushNotificationRegistrations;
        /** Dictionary of player's statistics using only the latest version's value */
        @Deprecated
        public Map<String,Integer> Statistics;
        /** List of player's tags for segmentation. */
        @Deprecated
        public ArrayList<String> Tags;
        /** Title ID this profile applies to */
        @Deprecated
        public String TitleId;
        /** A sum of player's total purchases in USD across all currencies. */
        @Deprecated
        public Long TotalValueToDateInUSD;
        /** Dictionary of player's total purchases by currency. */
        @Deprecated
        public Map<String,Long> ValuesToDate;
        /** Dictionary of player's virtual currency balances */
        @Deprecated
        public Map<String,Integer> VirtualCurrencyBalances;
        
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
    public static class PlayerStatistic {
        /** Statistic ID */
        @Deprecated
        public String Id;
        /** Statistic name */
        @Deprecated
        public String Name;
        /** Current statistic value */
        @Deprecated
        public Integer StatisticValue;
        /** Statistic version (0 if not a versioned statistic) */
        @Deprecated
        public Integer StatisticVersion;
        
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

    @Deprecated
    public static class PushNotificationPackage {
        /** Numerical badge to display on App icon (iOS only) */
        @Deprecated
        public Integer Badge;
        /** This must be a JSON formatted object. For use with developer-created custom Push Notification plugins */
        @Deprecated
        public String CustomData;
        /** Icon file to display with the message (Not supported for iOS) */
        @Deprecated
        public String Icon;
        /** Content of the message (all platforms) */
        @Deprecated
        public String Message;
        /** Sound file to play with the message (all platforms) */
        @Deprecated
        public String Sound;
        /** Title/Subject of the message. Not supported for iOS */
        @Deprecated
        public String Title;
        
    }

    @Deprecated
    public static enum PushNotificationPlatform {
        ApplePushNotificationService,
        GoogleCloudMessaging
    }

    @Deprecated
    public static class PushNotificationRegistration {
        /** Notification configured endpoint */
        @Deprecated
        public String NotificationEndpointARN;
        /** Push notification platform */
        @Deprecated
        public PushNotificationPlatform Platform;
        
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

    @Deprecated
    public static class RandomResultTableListing {
        /** Catalog version this table is associated with */
        @Deprecated
        public String CatalogVersion;
        /** Child nodes that indicate what kind of drop table item this actually is. */
        @Deprecated
        public ArrayList<ResultTableNode> Nodes;
        /** Unique name for this drop table */
        @Deprecated
        public String TableId;
        
    }

    /**
     * Coupon codes can be created for any item, or set of items, in the catalog for the title. This operation causes the
     * coupon to be consumed, and the specific items to be awarded to the user. Attempting to re-use an already consumed code,
     * or a code which has not yet been created in the service, will result in an error.
     */
    @Deprecated
    public static class RedeemCouponRequest {
        /** Catalog version of the coupon. */
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class RedeemCouponResult {
        /** Items granted to the player as a result of redeeming the coupon. */
        @Deprecated
        public ArrayList<ItemInstance> GrantedItems;
        
    }

    @Deprecated
    public static class RemoveFriendRequest {
        /** PlayFab identifier of the friend account which is to be removed. */
        @Deprecated
        public String FriendPlayFabId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class RemoveGenericIDRequest {
        /** Generic service identifier to be removed from the player. */
        @Deprecated
        public GenericServiceId GenericId;
        /** PlayFabId of the user to remove. */
        @Deprecated
        public String PlayFabId;
        
    }

    /**
     * This API will trigger a player_tag_removed event and remove a tag with the given TagName and PlayFabID from the
     * corresponding player profile. TagName can be used for segmentation and it is limited to 256 characters
     */
    @Deprecated
    public static class RemovePlayerTagRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Unique tag for player profile. */
        @Deprecated
        public String TagName;
        
    }

    @Deprecated
    public static class RemovePlayerTagResult {
        
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

    @Deprecated
    public static class ReportPlayerServerRequest {
        /** Optional additional comment by reporting player. */
        @Deprecated
        public String Comment;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab identifier of the reported player. */
        @Deprecated
        public String ReporteeId;
        /** PlayFabId of the reporting player. */
        @Deprecated
        public String ReporterId;
        
    }

    /**
     * Players are currently limited to five reports per day. Attempts by a single user account to submit reports beyond five
     * will result in Updated being returned as false.
     */
    @Deprecated
    public static class ReportPlayerServerResult {
        /** The number of remaining reports which may be filed today by this reporting player. */
        @Deprecated
        public Integer SubmissionsRemaining;
        
    }

    @Deprecated
    public static class ResultTableNode {
        /** Either an ItemId, or the TableId of another random result table */
        @Deprecated
        public String ResultItem;
        /** Whether this entry in the table is an item or a link to another table */
        @Deprecated
        public ResultTableNodeType ResultItemType;
        /** How likely this is to be rolled - larger numbers add more weight */
        @Deprecated
        public Integer Weight;
        
    }

    @Deprecated
    public static enum ResultTableNodeType {
        ItemId,
        TableId
    }

    /**
     * Setting the active state of all non-expired bans for a user to Inactive. Expired bans with an Active state will be
     * ignored, however. Returns information about applied updates only.
     */
    @Deprecated
    public static class RevokeAllBansForUserRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class RevokeAllBansForUserResult {
        /** Information on the bans that were revoked. */
        @Deprecated
        public ArrayList<BanInfo> BanData;
        
    }

    /**
     * Setting the active state of all bans requested to Inactive regardless of whether that ban has already expired. BanIds
     * that do not exist will be skipped. Returns information about applied updates only.
     */
    @Deprecated
    public static class RevokeBansRequest {
        /** Ids of the bans to be revoked. Maximum 100. */
        @Deprecated
        public ArrayList<String> BanIds;
        
    }

    @Deprecated
    public static class RevokeBansResult {
        /** Information on the bans that were revoked */
        @Deprecated
        public ArrayList<BanInfo> BanData;
        
    }

    @Deprecated
    public static class RevokeInventoryItem {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Unique PlayFab assigned instance identifier of the item */
        @Deprecated
        public String ItemInstanceId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    /**
     * In cases where the inventory item in question is a "crate", and the items it contained have already been dispensed, this
     * will not revoke access or otherwise remove the items which were dispensed.
     */
    @Deprecated
    public static class RevokeInventoryItemRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Unique PlayFab assigned instance identifier of the item */
        @Deprecated
        public String ItemInstanceId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    /**
     * In cases where the inventory item in question is a "crate", and the items it contained have already been dispensed, this
     * will not revoke access or otherwise remove the items which were dispensed.
     */
    @Deprecated
    public static class RevokeInventoryItemsRequest {
        /** Array of player items to revoke, between 1 and 25 items. */
        @Deprecated
        public ArrayList<RevokeInventoryItem> Items;
        
    }

    @Deprecated
    public static class RevokeInventoryItemsResult {
        /** Collection of any errors that occurred during processing. */
        @Deprecated
        public ArrayList<RevokeItemError> Errors;
        
    }

    @Deprecated
    public static class RevokeInventoryResult {
        
    }

    @Deprecated
    public static class RevokeItemError {
        /** Specific error that was encountered. */
        @Deprecated
        public GenericErrorCodes Error;
        /** Item information that failed to be revoked. */
        @Deprecated
        public RevokeInventoryItem Item;
        
    }

    /** Represents the save push notification template request. */
    @Deprecated
    public static class SavePushNotificationTemplateRequest {
        /** Android JSON for the notification template. */
        @Deprecated
        public String AndroidPayload;
        /** Id of the push notification template. */
        @Deprecated
        public String Id;
        /** IOS JSON for the notification template. */
        @Deprecated
        public String IOSPayload;
        /** Dictionary of localized push notification templates with the language as the key. */
        @Deprecated
        public Map<String,LocalizedPushNotificationProperties> LocalizedPushNotificationTemplates;
        /** Name of the push notification template. */
        @Deprecated
        public String Name;
        
    }

    /** Represents the save push notification template result. */
    @Deprecated
    public static class SavePushNotificationTemplateResult {
        /** Id of the push notification template that was saved. */
        @Deprecated
        public String PushNotificationTemplateId;
        
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
     * PlayFab accounts which have valid email address or username will be able to receive a password reset email using this
     * API.The email sent must be an account recovery email template. The username or email can be passed in to send the email
     */
    @Deprecated
    public static class SendCustomAccountRecoveryEmailRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** User email address attached to their account */
        @Deprecated
        public String Email;
        /** The email template id of the account recovery email template to send. */
        @Deprecated
        public String EmailTemplateId;
        /** The user's username requesting an account recovery. */
        @Deprecated
        public String Username;
        
    }

    @Deprecated
    public static class SendCustomAccountRecoveryEmailResult {
        
    }

    /**
     * Sends an email for only players that have contact emails associated with them. Takes in an email template ID
     * specifyingthe email template to send.
     */
    @Deprecated
    public static class SendEmailFromTemplateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The email template id of the email template to send. */
        @Deprecated
        public String EmailTemplateId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class SendEmailFromTemplateResult {
        
    }

    /** Represents the request for sending a push notification template to a recipient. */
    @Deprecated
    public static class SendPushNotificationFromTemplateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Id of the push notification template. */
        @Deprecated
        public String PushNotificationTemplateId;
        /** PlayFabId of the push notification recipient. */
        @Deprecated
        public String Recipient;
        
    }

    @Deprecated
    public static class SendPushNotificationRequest {
        /**
         * Allows you to provide precisely formatted json to target devices. This is an advanced feature, allowing you to deliver
         * to custom plugin logic, fields, or functionality not natively supported by PlayFab.
         */
        @Deprecated
        public ArrayList<AdvancedPushPlatformMsg> AdvancedPlatformDelivery;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Text of message to send. */
        @Deprecated
        public String Message;
        /**
         * Defines all possible push attributes like message, title, icon, etc. Some parameters are device specific - please see
         * the PushNotificationPackage documentation for details.
         */
        @Deprecated
        public PushNotificationPackage Package;
        /** PlayFabId of the recipient of the push notification. */
        @Deprecated
        public String Recipient;
        /** Subject of message to send (may not be displayed in all platforms) */
        @Deprecated
        public String Subject;
        /** Target Platforms that should receive the Message or Package. If omitted, we will send to all available platforms. */
        @Deprecated
        public ArrayList<PushNotificationPlatform> TargetPlatforms;
        
    }

    @Deprecated
    public static class SendPushNotificationResult {
        
    }

    @Deprecated
    public static class ServerCustomIDPlayFabIDPair {
        /** Unique PlayFab identifier. */
        @Deprecated
        public String PlayFabId;
        /** Unique server custom identifier for this player. */
        @Deprecated
        public String ServerCustomId;
        
    }

    @Deprecated
    public static class ServerLoginResult {
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
     * This operation is not additive. It will completely replace the tag list for the specified user. Please note that only
     * users in the PlayFab friends list can be assigned tags. Attempting to set a tag on a friend only included in the friends
     * list from a social site integration (such as Facebook or Steam) will return the AccountNotFound error.
     */
    @Deprecated
    public static class SetFriendTagsRequest {
        /** PlayFab identifier of the friend account to which the tag(s) should be applied. */
        @Deprecated
        public String FriendPlayFabId;
        /** PlayFab identifier of the player whose friend is to be updated. */
        @Deprecated
        public String PlayFabId;
        /** Array of tags to set on the friend account. */
        @Deprecated
        public ArrayList<String> Tags;
        
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
        /** Player secret that is used to verify API request signatures (Enterprise Only). */
        @Deprecated
        public String PlayerSecret;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class SetPlayerSecretResult {
        
    }

    /**
     * This API is designed to store publisher-specific values which can be read, but not written to, by the client. This data
     * is shared across all titles assigned to a particular publisher, and can be used for cross-game coordination. Only titles
     * assigned to a publisher can use this API. This operation is additive. If a Key does not exist in the current dataset, it
     * will be added with the specified Value. If it already exists, the Value for that key will be overwritten with the new
     * Value. For more information email helloplayfab@microsoft.com
     */
    @Deprecated
    public static class SetPublisherDataRequest {
        /**
         * key we want to set a value on (note, this is additive - will only replace an existing key's value if they are the same
         * name.) Keys are trimmed of whitespace. Keys may not begin with the '!' character.
         */
        @Deprecated
        public String Key;
        /** new value to set. Set to null to remove a value */
        @Deprecated
        public String Value;
        
    }

    @Deprecated
    public static class SetPublisherDataResult {
        
    }

    /**
     * This API is designed to store title specific values which can be read, but not written to, by the client. For example, a
     * developer could choose to store values which modify the user experience, such as enemy spawn rates, weapon strengths,
     * movement speeds, etc. This allows a developer to update the title without the need to create, test, and ship a new
     * build. This operation is additive. If a Key does not exist in the current dataset, it will be added with the specified
     * Value. If it already exists, the Value for that key will be overwritten with the new Value.
     */
    @Deprecated
    public static class SetTitleDataRequest {
        /**
         * key we want to set a value on (note, this is additive - will only replace an existing key's value if they are the same
         * name.) Keys are trimmed of whitespace. Keys may not begin with the '!' character.
         */
        @Deprecated
        public String Key;
        /** new value to set. Set to null to remove a value */
        @Deprecated
        public String Value;
        
    }

    @Deprecated
    public static class SetTitleDataResult {
        
    }

    @Deprecated
    public static class SharedGroupDataRecord {
        /** Timestamp for when this data was last updated. */
        @Deprecated
        public Date LastUpdated;
        /** PlayFabId of the user to last update this value. */
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

    @Deprecated
    public static class SubtractCharacterVirtualCurrencyRequest {
        /** Amount to be subtracted from the user balance of the specified virtual currency. */
        @Deprecated
        public Integer Amount;
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Name of the virtual currency which is to be decremented. */
        @Deprecated
        public String VirtualCurrency;
        
    }

    @Deprecated
    public static class SubtractUserVirtualCurrencyRequest {
        /** Amount to be subtracted from the user balance of the specified virtual currency. */
        @Deprecated
        public Integer Amount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** PlayFab unique identifier of the user whose virtual currency balance is to be decreased. */
        @Deprecated
        public String PlayFabId;
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
        /** News item body. */
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
    public static class UnlinkNintendoServiceAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class UnlinkNintendoSwitchDeviceIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Nintendo Switch Device identifier for the user. If not specified, the most recently signed in device ID will be used. */
        @Deprecated
        public String NintendoSwitchDeviceId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class UnlinkNintendoSwitchDeviceIdResult {
        
    }

    @Deprecated
    public static class UnlinkPSNAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class UnlinkPSNAccountResult {
        
    }

    @Deprecated
    public static class UnlinkServerCustomIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab identifier. */
        @Deprecated
        public String PlayFabId;
        /** Unique server custom identifier for this player. */
        @Deprecated
        public String ServerCustomId;
        
    }

    @Deprecated
    public static class UnlinkServerCustomIdResult {
        
    }

    @Deprecated
    public static class UnlinkSteamIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Steam account. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class UnlinkSteamIdResult {
        
    }

    @Deprecated
    public static class UnlinkXboxAccountRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Xbox Live identifier. */
        @Deprecated
        public String PlayFabId;
        
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    /** The items and vc found within the container. These will be added and stacked in your inventory as appropriate. */
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    /** Represents a single update ban request. */
    @Deprecated
    public static class UpdateBanRequest {
        /** The updated active state for the ban. Null for no change. */
        @Deprecated
        public Boolean Active;
        /** The id of the ban to be updated. */
        @Deprecated
        public String BanId;
        /** The updated expiration date for the ban. Null for no change. */
        @Deprecated
        public Date Expires;
        /** The updated IP address for the ban. Null for no change. */
        @Deprecated
        public String IPAddress;
        /** Whether to make this ban permanent. Set to true to make this ban permanent. This will not modify Active state. */
        @Deprecated
        public Boolean Permanent;
        /** The updated reason for the ban to be updated. Maximum 140 characters. Null for no change. */
        @Deprecated
        public String Reason;
        /** The updated family type of the user that should be included in the ban. Null for no change. */
        @Deprecated
        public UserFamilyType UserFamilyType;
        
    }

    /**
     * For each ban, only updates the values that are set. Leave any value to null for no change. If a ban could not be found,
     * the rest are still applied. Returns information about applied updates only.
     */
    @Deprecated
    public static class UpdateBansRequest {
        /** List of bans to be updated. Maximum 100. */
        @Deprecated
        public ArrayList<UpdateBanRequest> Bans;
        
    }

    @Deprecated
    public static class UpdateBansResult {
        /** Information on the bans that were updated */
        @Deprecated
        public ArrayList<BanInfo> BanData;
        
    }

    /**
     * This function performs an additive update of the arbitrary JSON object containing the custom data for the user. In
     * updating the custom data object, keys which already exist in the object will have their values overwritten, while keys
     * with null values will be removed. No other key-value pairs will be changed apart from those specified in the call.
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
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
     * Character statistics are similar to user statistics in that they are numeric values which may only be updated by a
     * server operation, in order to minimize the opportunity for unauthorized changes. In addition to being available for use
     * by the title, the statistics are used for all leaderboard operations in PlayFab.
     */
    @Deprecated
    public static class UpdateCharacterStatisticsRequest {
        /** Unique PlayFab assigned ID for a specific character owned by a user */
        @Deprecated
        public String CharacterId;
        /** Statistics to be updated with the provided values. */
        @Deprecated
        public Map<String,Integer> CharacterStatistics;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class UpdateCharacterStatisticsResult {
        
    }

    /**
     * This operation is additive. Statistics not currently defined will be added, while those already defined will be updated
     * with the given values. All other user statistics will remain unchanged.
     */
    @Deprecated
    public static class UpdatePlayerStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Indicates whether the statistics provided should be set, regardless of the aggregation method set on the statistic.
         * Default is false.
         */
        @Deprecated
        public Boolean ForceUpdate;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
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
     * This function performs an additive update of the arbitrary JSON object containing the custom data for the user. In
     * updating the custom data object, keys which already exist in the object will have their values overwritten, while keys
     * with null values will be removed. No other key-value pairs will be changed apart from those specified in the call.
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
        /** Permission to be applied to all user data keys written in this request. Defaults to "private" if not set. */
        @Deprecated
        public UserDataPermission Permission;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
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
     * This function performs an additive update of the arbitrary JSON object containing the custom data for the user. In
     * updating the custom data object, keys which already exist in the object will have their values overwritten, keys with
     * null values will be removed. No other key-value pairs will be changed apart from those specified in the call.
     */
    @Deprecated
    public static class UpdateUserInternalDataRequest {
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    /**
     * This function performs an additive update of the arbitrary JSON object containing the custom data for the item instance
     * which belongs to the specified user. In updating the custom data object, keys which already exist in the object will
     * have their values overwritten, while keys with null values will be removed. No other key-value pairs will be changed
     * apart from those specified in the call.
     */
    @Deprecated
    public static class UpdateUserInventoryItemDataRequest {
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
        /** Unique PlayFab assigned instance identifier of the item */
        @Deprecated
        public String ItemInstanceId;
        /**
         * Optional list of Data-keys to remove from UserData. Some SDKs cannot insert null-values into Data due to language
         * constraints. Use this to delete the keys directly.
         */
        @Deprecated
        public ArrayList<String> KeysToRemove;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
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
    public static enum UserFamilyType {
        None,
        Xbox,
        Steam
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
     * This API is designed to write a multitude of different event types into PlayStream. It supports a flexible JSON schema,
     * which allowsfor arbitrary key-value pairs to describe any character-based event. The created event will be locked to the
     * authenticated title.
     */
    @Deprecated
    public static class WriteServerCharacterEventRequest {
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** The time (in UTC) associated with this event. The value defaults to the current time. */
        @Deprecated
        public Date Timestamp;
        
    }

    /**
     * This API is designed to write a multitude of different event types into PlayStream. It supports a flexible JSON schema,
     * which allowsfor arbitrary key-value pairs to describe any player-based event. The created event will be locked to the
     * authenticated title.
     */
    @Deprecated
    public static class WriteServerPlayerEventRequest {
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
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** The time (in UTC) associated with this event. The value defaults to the current time. */
        @Deprecated
        public Date Timestamp;
        
    }

    /**
     * This API is designed to write a multitude of different event types into PlayStream. It supports a flexible JSON schema,
     * which allowsfor arbitrary key-value pairs to describe any title-based event. The created event will be locked to the
     * authenticated title.
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
