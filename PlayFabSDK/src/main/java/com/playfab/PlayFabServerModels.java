package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabServerModels {

    public static class AdCampaignAttribution {
        /**
         * UTC time stamp of attribution
         */
        public Date AttributedAt;
        /**
         * Attribution campaign identifier
         */
        public String CampaignId;
        /**
         * Attribution network name
         */
        public String Platform;
        
    }

    public static class AdCampaignAttributionModel {
        /**
         * UTC time stamp of attribution
         */
        public Date AttributedAt;
        /**
         * Attribution campaign identifier
         */
        public String CampaignId;
        /**
         * Attribution network name
         */
        public String Platform;
        
    }

    public static class AddCharacterVirtualCurrencyRequest {
        /**
         * Amount to be added to the character balance of the specified virtual currency. Maximum VC balance is Int32 (2,147,483,647). Any increase over this value will be discarded.
         */
        public Integer Amount;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * PlayFab unique identifier of the user whose virtual currency balance is to be incremented.
         */
        public String PlayFabId;
        /**
         * Name of the virtual currency which is to be incremented.
         */
        public String VirtualCurrency;
        
    }

    public static class AddFriendRequest {
        /**
         * Email address of the user being added.
         */
        public String FriendEmail;
        /**
         * The PlayFab identifier of the user being added.
         */
        public String FriendPlayFabId;
        /**
         * Title-specific display name of the user to being added.
         */
        public String FriendTitleDisplayName;
        /**
         * The PlayFab username of the user being added
         */
        public String FriendUsername;
        /**
         * PlayFab identifier of the player to add a new friend.
         */
        public String PlayFabId;
        
    }

    public static class AddPlayerTagRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique tag for player profile.
         */
        public String TagName;
        
    }

    public static class AddPlayerTagResult {
        
    }

    public static class AddSharedGroupMembersRequest {
        /**
         * An array of unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public ArrayList<String> PlayFabIds;
        /**
         * Unique identifier for the shared group.
         */
        public String SharedGroupId;
        
    }

    public static class AddSharedGroupMembersResult {
        
    }

    public static class AddUserVirtualCurrencyRequest {
        /**
         * Amount to be added to the user balance of the specified virtual currency. Maximum VC balance is Int32 (2,147,483,647). Any increase over this value will be discarded.
         */
        public Integer Amount;
        /**
         * PlayFab unique identifier of the user whose virtual currency balance is to be increased.
         */
        public String PlayFabId;
        /**
         * Name of the virtual currency which is to be incremented.
         */
        public String VirtualCurrency;
        
    }

    public static class AdvancedPushPlatformMsg {
        /**
         * The Json the platform should receive.
         */
        public String Json;
        /**
         * The platform that should receive the Json.
         */
        public PushNotificationPlatform Platform;
        
    }

    public static class AuthenticateSessionTicketRequest {
        /**
         * Session ticket as issued by a PlayFab client login API.
         */
        public String SessionTicket;
        
    }

    public static class AuthenticateSessionTicketResult {
        /**
         * Account info for the user whose session ticket was supplied.
         */
        public UserAccountInfo UserInfo;
        
    }

    public static class AwardSteamAchievementItem {
        /**
         * Unique Steam achievement name.
         */
        public String AchievementName;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Result of the award attempt (only valid on response, not on request).
         */
        public Boolean Result;
        
    }

    public static class AwardSteamAchievementRequest {
        /**
         * Array of achievements to grant and the users to whom they are to be granted.
         */
        public ArrayList<AwardSteamAchievementItem> Achievements;
        
    }

    public static class AwardSteamAchievementResult {
        /**
         * Array of achievements granted.
         */
        public ArrayList<AwardSteamAchievementItem> AchievementResults;
        
    }

    /**
     * Contains information for a ban.
     */
    public static class BanInfo {
        /**
         * The active state of this ban. Expired bans may still have this value set to true but they will have no effect.
         */
        public Boolean Active;
        /**
         * The unique Ban Id associated with this ban.
         */
        public String BanId;
        /**
         * The time when this ban was applied.
         */
        public Date Created;
        /**
         * The time when this ban expires. Permanent bans do not have expiration date.
         */
        public Date Expires;
        /**
         * The IP address on which the ban was applied. May affect multiple players.
         */
        public String IPAddress;
        /**
         * The MAC address on which the ban was applied. May affect multiple players.
         */
        public String MACAddress;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * The reason why this ban was applied.
         */
        public String Reason;
        
    }

    /**
     * Represents a single ban request.
     */
    public static class BanRequest {
        /**
         * The duration in hours for the ban. Leave this blank for a permanent ban.
         */
        public Long DurationInHours;
        /**
         * IP address to be banned. May affect multiple players.
         */
        public String IPAddress;
        /**
         * MAC address to be banned. May affect multiple players.
         */
        public String MACAddress;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * The reason for this ban. Maximum 140 characters.
         */
        public String Reason;
        
    }

    public static class BanUsersRequest {
        /**
         * List of ban requests to be applied. Maximum 100.
         */
        public ArrayList<BanRequest> Bans;
        
    }

    public static class BanUsersResult {
        /**
         * Information on the bans that were applied
         */
        public ArrayList<BanInfo> BanData;
        
    }

    /**
     * A purchasable item from the item catalog
     */
    public static class CatalogItem implements Comparable<CatalogItem> {
        /**
         * defines the bundle properties for the item - bundles are items which contain other items, including random drop tables and virtual currencies
         */
        public CatalogItemBundleInfo Bundle;
        /**
         * if true, then an item instance of this type can be used to grant a character to a user.
         */
        public Boolean CanBecomeCharacter;
        /**
         * catalog version for this item
         */
        public String CatalogVersion;
        /**
         * defines the consumable properties (number of uses, timeout) for the item
         */
        public CatalogItemConsumableInfo Consumable;
        /**
         * defines the container properties for the item - what items it contains, including random drop tables and virtual currencies, and what item (if any) is required to open it via the UnlockContainerItem API
         */
        public CatalogItemContainerInfo Container;
        /**
         * game specific custom data
         */
        public String CustomData;
        /**
         * text description of item, to show in-game
         */
        public String Description;
        /**
         * text name for the item, to show in-game
         */
        public String DisplayName;
        /**
         * If the item has IsLImitedEdition set to true, and this is the first time this ItemId has been defined as a limited edition item, this value determines the total number of instances to allocate for the title. Once this limit has been reached, no more instances of this ItemId can be created, and attempts to purchase or grant it will return a Result of false for that ItemId. If the item has already been defined to have a limited edition count, or if this value is less than zero, it will be ignored.
         */
        public Integer InitialLimitedEditionCount;
        /**
         * BETA: If true, then only a fixed number can ever be granted.
         */
        public Boolean IsLimitedEdition;
        /**
         * if true, then only one item instance of this type will exist and its remaininguses will be incremented instead. RemainingUses will cap out at Int32.Max (2,147,483,647). All subsequent increases will be discarded
         */
        public Boolean IsStackable;
        /**
         * if true, then an item instance of this type can be traded between players using the trading APIs
         */
        public Boolean IsTradable;
        /**
         * class to which the item belongs
         */
        public String ItemClass;
        /**
         * unique identifier for this item
         */
        public String ItemId;
        /**
         * URL to the item image. For Facebook purchase to display the image on the item purchase page, this must be set to an HTTP URL.
         */
        public String ItemImageUrl;
        /**
         * override prices for this item for specific currencies
         */
        public Map<String,Long> RealCurrencyPrices;
        /**
         * list of item tags
         */
        @Unordered
        public ArrayList<String> Tags;
        /**
         * price of this item in virtual currencies and "RM" (the base Real Money purchase price, in USD pennies)
         */
        public Map<String,Long> VirtualCurrencyPrices;
        
        public int compareTo(CatalogItem other) {
            if (other == null || other.ItemId == null) return 1;
            if (ItemId == null) return -1;
            return ItemId.compareTo(other.ItemId);
        }
    }

    public static class CatalogItemBundleInfo {
        /**
         * unique ItemId values for all items which will be added to the player inventory when the bundle is added
         */
        @Unordered
        public ArrayList<String> BundledItems;
        /**
         * unique TableId values for all RandomResultTable objects which are part of the bundle (random tables will be resolved and add the relevant items to the player inventory when the bundle is added)
         */
        @Unordered
        public ArrayList<String> BundledResultTables;
        /**
         * virtual currency types and balances which will be added to the player inventory when the bundle is added
         */
        public Map<String,Long> BundledVirtualCurrencies;
        
    }

    public static class CatalogItemConsumableInfo {
        /**
         * number of times this object can be used, after which it will be removed from the player inventory
         */
        public Long UsageCount;
        /**
         * duration in seconds for how long the item will remain in the player inventory - once elapsed, the item will be removed (recommended minimum value is 5 seconds, as lower values can cause the item to expire before operations depending on this item's details have completed)
         */
        public Long UsagePeriod;
        /**
         * all inventory item instances in the player inventory sharing a non-null UsagePeriodGroup have their UsagePeriod values added together, and share the result - when that period has elapsed, all the items in the group will be removed
         */
        public String UsagePeriodGroup;
        
    }

    /**
     * Containers are inventory items that can hold other items defined in the catalog, as well as virtual currency, which is added to the player inventory when the container is unlocked, using the UnlockContainerItem API. The items can be anything defined in the catalog, as well as RandomResultTable objects which will be resolved when the container is unlocked. Containers and their keys should be defined as Consumable (having a limited number of uses) in their catalog defintiions, unless the intent is for the player to be able to re-use them infinitely.
     */
    public static class CatalogItemContainerInfo {
        /**
         * unique ItemId values for all items which will be added to the player inventory, once the container has been unlocked
         */
        @Unordered
        public ArrayList<String> ItemContents;
        /**
         * ItemId for the catalog item used to unlock the container, if any (if not specified, a call to UnlockContainerItem will open the container, adding the contents to the player inventory and currency balances)
         */
        public String KeyItemId;
        /**
         * unique TableId values for all RandomResultTable objects which are part of the container (once unlocked, random tables will be resolved and add the relevant items to the player inventory)
         */
        @Unordered
        public ArrayList<String> ResultTableContents;
        /**
         * virtual currency types and balances which will be added to the player inventory when the container is unlocked
         */
        public Map<String,Long> VirtualCurrencyContents;
        
    }

    public static class CharacterInventory {
        /**
         * The id of this character.
         */
        public String CharacterId;
        /**
         * The inventory of this character.
         */
        public ArrayList<ItemInstance> Inventory;
        
    }

    public static class CharacterLeaderboardEntry {
        /**
         * PlayFab unique identifier of the character that belongs to the user for this leaderboard entry.
         */
        public String CharacterId;
        /**
         * Title-specific display name of the character for this leaderboard entry.
         */
        public String CharacterName;
        /**
         * Name of the character class for this entry.
         */
        public String CharacterType;
        /**
         * Title-specific display name of the user for this leaderboard entry.
         */
        public String DisplayName;
        /**
         * PlayFab unique identifier of the user for this leaderboard entry.
         */
        public String PlayFabId;
        /**
         * User's overall position in the leaderboard.
         */
        public Integer Position;
        /**
         * Specific value of the user's statistic.
         */
        public Integer StatValue;
        
    }

    public static class CharacterResult {
        /**
         * The id for this character on this player.
         */
        public String CharacterId;
        /**
         * The name of this character.
         */
        public String CharacterName;
        /**
         * The type-string that was given to this character on creation.
         */
        public String CharacterType;
        
    }

    public static enum CloudScriptRevisionOption {
        Live,
        Latest,
        Specific
    }

    public static class ConsumeItemRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Number of uses to consume from the item.
         */
        public Integer ConsumeCount;
        /**
         * Unique instance identifier of the item to be consumed.
         */
        public String ItemInstanceId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class ConsumeItemResult {
        /**
         * Unique instance identifier of the item with uses consumed.
         */
        public String ItemInstanceId;
        /**
         * Number of uses remaining on the item.
         */
        public Integer RemainingUses;
        
    }

    public static class ContactEmailInfo {
        /**
         * The email address
         */
        public String EmailAddress;
        /**
         * The name of the email info data
         */
        public String Name;
        /**
         * The verification status of the email
         */
        public EmailVerificationStatus VerificationStatus;
        
    }

    public static class ContactEmailInfoModel {
        /**
         * The email address
         */
        public String EmailAddress;
        /**
         * The name of the email info data
         */
        public String Name;
        
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

    public static class CreateSharedGroupRequest {
        /**
         * Unique identifier for the shared group (a random identifier will be assigned, if one is not specified).
         */
        public String SharedGroupId;
        
    }

    public static class CreateSharedGroupResult {
        /**
         * Unique identifier for the shared group.
         */
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

    public static class DeleteCharacterFromUserRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * If true, the character's inventory will be transferred up to the owning user; otherwise, this request will purge those items.
         */
        public Boolean SaveCharacterInventory;
        
    }

    public static class DeleteCharacterFromUserResult {
        
    }

    public static class DeleteSharedGroupRequest {
        /**
         * Unique identifier for the shared group.
         */
        public String SharedGroupId;
        
    }

    public static class DeleteUsersRequest {
        /**
         * An array of unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public ArrayList<String> PlayFabIds;
        /**
         * Unique identifier for the title, found in the Settings &gt; Game Properties section of the PlayFab developer site when a title has been selected.
         */
        public String TitleId;
        
    }

    public static class DeleteUsersResult {
        
    }

    public static class DeregisterGameRequest {
        /**
         * Unique identifier for the Game Server Instance that is being deregistered.
         */
        public String LobbyId;
        
    }

    public static class DeregisterGameResponse {
        
    }

    public static enum EmailVerificationStatus {
        Unverified,
        Pending,
        Confirmed
    }

    public static class EmptyResult {
        
    }

    public static class EvaluateRandomResultTableRequest {
        /**
         * Specifies the catalog version that should be used to evaluate the Random Result Table.  If unspecified, uses default/primary catalog.
         */
        public String CatalogVersion;
        /**
         * The unique identifier of the Random Result Table to use.
         */
        public String TableId;
        
    }

    public static class EvaluateRandomResultTableResult {
        /**
         * Unique identifier for the item returned from the Random Result Table evaluation, for the given catalog.
         */
        public String ResultItemId;
        
    }

    public static class ExecuteCloudScriptResult {
        /**
         * Number of PlayFab API requests issued by the CloudScript function
         */
        public Integer APIRequestsIssued;
        /**
         * Information about the error, if any, that occurred during execution
         */
        public ScriptExecutionError Error;
        public Double ExecutionTimeSeconds;
        /**
         * The name of the function that executed
         */
        public String FunctionName;
        /**
         * The object returned from the CloudScript function, if any
         */
        public Object FunctionResult;
        /**
         * Flag indicating if the FunctionResult was too large and was subsequently dropped from this event. This only occurs if the total event size is larger than 350KB.
         */
        public Boolean FunctionResultTooLarge;
        /**
         * Number of external HTTP requests issued by the CloudScript function
         */
        public Integer HttpRequestsIssued;
        /**
         * Entries logged during the function execution. These include both entries logged in the function code using log.info() and log.error() and error entries for API and HTTP request failures.
         */
        public ArrayList<LogStatement> Logs;
        /**
         * Flag indicating if the logs were too large and were subsequently dropped from this event. This only occurs if the total event size is larger than 350KB after the FunctionResult was removed.
         */
        public Boolean LogsTooLarge;
        public Long MemoryConsumedBytes;
        /**
         * Processor time consumed while executing the function. This does not include time spent waiting on API calls or HTTP requests.
         */
        public Double ProcessorTimeSeconds;
        /**
         * The revision of the CloudScript that executed
         */
        public Integer Revision;
        
    }

    public static class ExecuteCloudScriptServerRequest {
        /**
         * The name of the CloudScript function to execute
         */
        public String FunctionName;
        /**
         * Object that is passed in to the function as the first argument
         */
        public Object FunctionParameter;
        /**
         * Generate a 'player_executed_cloudscript' PlayStream event containing the results of the function execution and other contextual information. This event will show up in the PlayStream debugger console for the player in Game Manager.
         */
        public Boolean GeneratePlayStreamEvent;
        /**
         * The unique user identifier for the player on whose behalf the script is being run
         */
        public String PlayFabId;
        /**
         * Option for which revision of the CloudScript to execute. 'Latest' executes the most recently created revision, 'Live' executes the current live, published revision, and 'Specific' executes the specified revision. The default value is 'Specific', if the SpeificRevision parameter is specified, otherwise it is 'Live'.
         */
        public CloudScriptRevisionOption RevisionSelection;
        /**
         * The specivic revision to execute, when RevisionSelection is set to 'Specific'
         */
        public Integer SpecificRevision;
        
    }

    public static class FacebookPlayFabIdPair {
        /**
         * Unique Facebook identifier for a user.
         */
        public String FacebookId;
        /**
         * Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Facebook identifier.
         */
        public String PlayFabId;
        
    }

    public static class FriendInfo {
        /**
         * Unique lobby identifier of the Game Server Instance to which this player is currently connected.
         */
        public String CurrentMatchmakerLobbyId;
        /**
         * Available Facebook information (if the user and PlayFab friend are also connected in Facebook).
         */
        public UserFacebookInfo FacebookInfo;
        /**
         * PlayFab unique identifier for this friend.
         */
        public String FriendPlayFabId;
        /**
         * Available Game Center information (if the user and PlayFab friend are also connected in Game Center).
         */
        public UserGameCenterInfo GameCenterInfo;
        /**
         * The profile of the user, if requested.
         */
        public PlayerProfileModel Profile;
        /**
         * Available Steam information (if the user and PlayFab friend are also connected in Steam).
         */
        public UserSteamInfo SteamInfo;
        /**
         * Tags which have been associated with this friend.
         */
        public ArrayList<String> Tags;
        /**
         * Title-specific display name for this friend.
         */
        public String TitleDisplayName;
        /**
         * PlayFab unique username for this friend.
         */
        public String Username;
        
    }

    public static enum GameInstanceState {
        Open,
        Closed
    }

    /**
     * @deprecated Do not use
     */
    @Deprecated
    public static class GetActionGroupResult {
        /**
         * Action Group ID
         */
        public String Id;
        /**
         * Action Group name
         */
        public String Name;
        
    }

    /**
     * @deprecated Do not use
     */
    @Deprecated
    public static class GetAllActionGroupsRequest {
        
    }

    /**
     * @deprecated Do not use
     */
    @Deprecated
    public static class GetAllActionGroupsResult {
        /**
         * List of Action Groups.
         */
        public ArrayList<GetActionGroupResult> ActionGroups;
        
    }

    public static class GetAllSegmentsRequest {
        
    }

    public static class GetAllSegmentsResult {
        /**
         * Array of segments for this title.
         */
        public ArrayList<GetSegmentResult> Segments;
        
    }

    public static class GetCatalogItemsRequest {
        /**
         * Which catalog is being requested. If null, uses the default catalog.
         */
        public String CatalogVersion;
        
    }

    public static class GetCatalogItemsResult {
        /**
         * Array of items which can be purchased.
         */
        @Unordered("ItemId")
        public ArrayList<CatalogItem> Catalog;
        
    }

    public static class GetCharacterDataRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * The version that currently exists according to the caller. The call will return the data for all of the keys if the version in the system is greater than this.
         */
        public Long IfChangedFromDataVersion;
        /**
         * Specific keys to search for in the custom user data.
         */
        public ArrayList<String> Keys;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetCharacterDataResult {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * User specific data for this title.
         */
        public Map<String,UserDataRecord> Data;
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetCharacterInventoryRequest {
        /**
         * Used to limit results to only those from a specific catalog version.
         */
        public String CatalogVersion;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetCharacterInventoryResult {
        /**
         * Unique identifier of the character for this inventory.
         */
        public String CharacterId;
        /**
         * Array of inventory items belonging to the character.
         */
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> Inventory;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Array of virtual currency balance(s) belonging to the character.
         */
        public Map<String,Integer> VirtualCurrency;
        /**
         * Array of remaining times and timestamps for virtual currencies.
         */
        public Map<String,VirtualCurrencyRechargeTime> VirtualCurrencyRechargeTimes;
        
    }

    public static class GetCharacterLeaderboardRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Optional character type on which to filter the leaderboard entries.
         */
        public String CharacterType;
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        /**
         * First entry in the leaderboard to be retrieved.
         */
        public Integer StartPosition;
        /**
         * Unique identifier for the title-specific statistic for the leaderboard.
         */
        public String StatisticName;
        
    }

    public static class GetCharacterLeaderboardResult {
        /**
         * Ordered list of leaderboard entries.
         */
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    public static class GetCharacterStatisticsRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetCharacterStatisticsResult {
        /**
         * Unique identifier of the character for the statistics.
         */
        public String CharacterId;
        /**
         * Character statistics for the requested user.
         */
        public Map<String,Integer> CharacterStatistics;
        /**
         * PlayFab unique identifier of the user whose character statistics are being returned.
         */
        public String PlayFabId;
        
    }

    public static class GetContentDownloadUrlRequest {
        /**
         * HTTP method to fetch item - GET or HEAD. Use HEAD when only fetching metadata. Default is GET.
         */
        public String HttpMethod;
        /**
         * Key of the content item to fetch, usually formatted as a path, e.g. images/a.png
         */
        public String Key;
        /**
         * True if download through CDN. CDN provides better download bandwidth and time. However, if you want latest, non-cached version of the content, set this to false. Default is true.
         */
        public Boolean ThruCDN;
        
    }

    public static class GetContentDownloadUrlResult {
        /**
         * URL for downloading content via HTTP GET or HEAD method. The URL will expire in 1 hour.
         */
        public String URL;
        
    }

    public static class GetFriendLeaderboardRequest {
        /**
         * Indicates whether Facebook friends should be included in the response. Default is true.
         */
        public Boolean IncludeFacebookFriends;
        /**
         * Indicates whether Steam service friends should be included in the response. Default is true.
         */
        public Boolean IncludeSteamFriends;
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        /**
         * The player whose friend leaderboard to get
         */
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client, only the allowed client profile properties for the title may be requested. These allowed properties are configured in the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        /**
         * Position in the leaderboard to start this listing (defaults to the first entry).
         */
        public Integer StartPosition;
        /**
         * Statistic used to rank friends for this leaderboard.
         */
        public String StatisticName;
        /**
         * The version of the leaderboard to get.
         */
        public Integer Version;
        
    }

    public static class GetFriendsListRequest {
        /**
         * Indicates whether Facebook friends should be included in the response. Default is true.
         */
        public Boolean IncludeFacebookFriends;
        /**
         * Indicates whether Steam service friends should be included in the response. Default is true.
         */
        public Boolean IncludeSteamFriends;
        /**
         * PlayFab identifier of the player whose friend list to get.
         */
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client, only the allowed client profile properties for the title may be requested. These allowed properties are configured in the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        
    }

    public static class GetFriendsListResult {
        /**
         * Array of friends found.
         */
        public ArrayList<FriendInfo> Friends;
        
    }

    public static class GetLeaderboardAroundCharacterRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Optional character type on which to filter the leaderboard entries.
         */
        public String CharacterType;
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique identifier for the title-specific statistic for the leaderboard.
         */
        public String StatisticName;
        
    }

    public static class GetLeaderboardAroundCharacterResult {
        /**
         * Ordered list of leaderboard entries.
         */
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    public static class GetLeaderboardAroundUserRequest {
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client, only the allowed client profile properties for the title may be requested. These allowed properties are configured in the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        /**
         * Unique identifier for the title-specific statistic for the leaderboard.
         */
        public String StatisticName;
        /**
         * The version of the leaderboard to get.
         */
        public Integer Version;
        
    }

    public static class GetLeaderboardAroundUserResult {
        /**
         * Ordered listing of users and their positions in the requested leaderboard.
         */
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        /**
         * The time the next scheduled reset will occur. Null if the leaderboard does not reset on a schedule.
         */
        public Date NextReset;
        /**
         * The version of the leaderboard returned.
         */
        public Integer Version;
        
    }

    public static class GetLeaderboardForUsersCharactersRequest {
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique identifier for the title-specific statistic for the leaderboard.
         */
        public String StatisticName;
        
    }

    public static class GetLeaderboardForUsersCharactersResult {
        /**
         * Ordered list of leaderboard entries.
         */
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    public static class GetLeaderboardRequest {
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client, only the allowed client profile properties for the title may be requested. These allowed properties are configured in the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        /**
         * First entry in the leaderboard to be retrieved.
         */
        public Integer StartPosition;
        /**
         * Unique identifier for the title-specific statistic for the leaderboard.
         */
        public String StatisticName;
        /**
         * The version of the leaderboard to get.
         */
        public Integer Version;
        
    }

    public static class GetLeaderboardResult {
        /**
         * Ordered listing of users and their positions in the requested leaderboard.
         */
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        /**
         * The time the next scheduled reset will occur. Null if the leaderboard does not reset on a schedule.
         */
        public Date NextReset;
        /**
         * The version of the leaderboard returned.
         */
        public Integer Version;
        
    }

    public static class GetPlayerCombinedInfoRequest {
        /**
         * Flags for which pieces of info to return for the user.
         */
        public GetPlayerCombinedInfoRequestParams InfoRequestParameters;
        /**
         * PlayFabId of the user whose data will be returned
         */
        public String PlayFabId;
        
    }

    public static class GetPlayerCombinedInfoRequestParams {
        /**
         * Whether to get character inventories. Defaults to false.
         */
        public Boolean GetCharacterInventories;
        /**
         * Whether to get the list of characters. Defaults to false.
         */
        public Boolean GetCharacterList;
        /**
         * Whether to get player profile. Defaults to false.
         */
        public Boolean GetPlayerProfile;
        /**
         * Whether to get player statistics. Defaults to false.
         */
        public Boolean GetPlayerStatistics;
        /**
         * Whether to get title data. Defaults to false.
         */
        public Boolean GetTitleData;
        /**
         * Whether to get the player's account Info. Defaults to false
         */
        public Boolean GetUserAccountInfo;
        /**
         * Whether to get the player's custom data. Defaults to false
         */
        public Boolean GetUserData;
        /**
         * Whether to get the player's inventory. Defaults to false
         */
        public Boolean GetUserInventory;
        /**
         * Whether to get the player's read only data. Defaults to false
         */
        public Boolean GetUserReadOnlyData;
        /**
         * Whether to get the player's virtual currency balances. Defaults to false
         */
        public Boolean GetUserVirtualCurrency;
        /**
         * Specific statistics to retrieve. Leave null to get all keys. Has no effect if GetPlayerStatistics is false
         */
        public ArrayList<String> PlayerStatisticNames;
        /**
         * Specifies the properties to return from the player profile. Defaults to returning the player's display name.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        /**
         * Specific keys to search for in the custom data. Leave null to get all keys. Has no effect if GetTitleData is false
         */
        public ArrayList<String> TitleDataKeys;
        /**
         * Specific keys to search for in the custom data. Leave null to get all keys. Has no effect if GetUserData is false
         */
        public ArrayList<String> UserDataKeys;
        /**
         * Specific keys to search for in the custom data. Leave null to get all keys. Has no effect if GetUserReadOnlyData is false
         */
        public ArrayList<String> UserReadOnlyDataKeys;
        
    }

    public static class GetPlayerCombinedInfoResult {
        /**
         * Results for requested info.
         */
        public GetPlayerCombinedInfoResultPayload InfoResultPayload;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetPlayerCombinedInfoResultPayload {
        /**
         * Account information for the user. This is always retrieved.
         */
        public UserAccountInfo AccountInfo;
        /**
         * Inventories for each character for the user.
         */
        public ArrayList<CharacterInventory> CharacterInventories;
        /**
         * List of characters for the user.
         */
        public ArrayList<CharacterResult> CharacterList;
        /**
         * The profile of the players. This profile is not guaranteed to be up-to-date. For a new player, this profile will not exist.
         */
        public PlayerProfileModel PlayerProfile;
        /**
         * List of statistics for this player.
         */
        public ArrayList<StatisticValue> PlayerStatistics;
        /**
         * Title data for this title.
         */
        public Map<String,String> TitleData;
        /**
         * User specific custom data.
         */
        public Map<String,UserDataRecord> UserData;
        /**
         * The version of the UserData that was returned.
         */
        public Long UserDataVersion;
        /**
         * Array of inventory items in the user's current inventory.
         */
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> UserInventory;
        /**
         * User specific read-only data.
         */
        public Map<String,UserDataRecord> UserReadOnlyData;
        /**
         * The version of the Read-Only UserData that was returned.
         */
        public Long UserReadOnlyDataVersion;
        /**
         * Dictionary of virtual currency balance(s) belonging to the user.
         */
        public Map<String,Integer> UserVirtualCurrency;
        /**
         * Dictionary of remaining times and timestamps for virtual currencies.
         */
        public Map<String,VirtualCurrencyRechargeTime> UserVirtualCurrencyRechargeTimes;
        
    }

    public static class GetPlayerProfileRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * If non-null, this determines which properties of the resulting player profiles to return. For API calls from the client, only the allowed client profile properties for the title may be requested. These allowed properties are configured in the Game Manager "Client Profile Options" tab in the "Settings" section.
         */
        public PlayerProfileViewConstraints ProfileConstraints;
        
    }

    public static class GetPlayerProfileResult {
        /**
         * The profile of the player. This profile is not guaranteed to be up-to-date. For a new player, this profile will not exist.
         */
        public PlayerProfileModel PlayerProfile;
        
    }

    public static class GetPlayerSegmentsResult {
        /**
         * Array of segments the requested player currently belongs to.
         */
        public ArrayList<GetSegmentResult> Segments;
        
    }

    public static class GetPlayersInSegmentRequest {
        /**
         * Continuation token if retrieving subsequent pages of results.
         */
        public String ContinuationToken;
        /**
         * Maximum number of profiles to load. Default is 1,000. Maximum is 10,000.
         */
        public Long MaxBatchSize;
        /**
         * Number of seconds to keep the continuation token active. After token expiration it is not possible to continue paging results. Default is 300 (5 minutes). Maximum is 1,800 (30 minutes).
         */
        public Long SecondsToLive;
        /**
         * Unique identifier for this segment.
         */
        public String SegmentId;
        
    }

    public static class GetPlayersInSegmentResult {
        /**
         * Continuation token to use to retrieve subsequent pages of results. If token returns null there are no more results.
         */
        public String ContinuationToken;
        /**
         * Array of player profiles in this segment.
         */
        public ArrayList<PlayerProfile> PlayerProfiles;
        /**
         * Count of profiles matching this segment.
         */
        public Integer ProfilesInSegment;
        
    }

    public static class GetPlayersSegmentsRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetPlayerStatisticsRequest {
        /**
         * user for whom statistics are being requested
         */
        public String PlayFabId;
        /**
         * statistics to return
         */
        public ArrayList<String> StatisticNames;
        /**
         * statistics to return, if StatisticNames is not set (only statistics which have a version matching that provided will be returned)
         */
        public ArrayList<StatisticNameVersion> StatisticNameVersions;
        
    }

    public static class GetPlayerStatisticsResult {
        /**
         * PlayFab unique identifier of the user whose statistics are being returned
         */
        public String PlayFabId;
        /**
         * User statistics for the requested user.
         */
        public ArrayList<StatisticValue> Statistics;
        
    }

    public static class GetPlayerStatisticVersionsRequest {
        /**
         * unique name of the statistic
         */
        public String StatisticName;
        
    }

    public static class GetPlayerStatisticVersionsResult {
        /**
         * version change history of the statistic
         */
        public ArrayList<PlayerStatisticVersion> StatisticVersions;
        
    }

    public static class GetPlayerTagsRequest {
        /**
         * Optional namespace to filter results by
         */
        public String Namespace;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetPlayerTagsResult {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Canonical tags (including namespace and tag's name) for the requested user
         */
        public ArrayList<String> Tags;
        
    }

    public static class GetPlayFabIDsFromFacebookIDsRequest {
        /**
         * Array of unique Facebook identifiers for which the title needs to get PlayFab identifiers.
         */
        public ArrayList<String> FacebookIDs;
        
    }

    public static class GetPlayFabIDsFromFacebookIDsResult {
        /**
         * Mapping of Facebook identifiers to PlayFab identifiers.
         */
        public ArrayList<FacebookPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromSteamIDsRequest {
        /**
         * Array of unique Steam identifiers (Steam profile IDs) for which the title needs to get PlayFab identifiers.
         */
        public ArrayList<String> SteamStringIDs;
        
    }

    public static class GetPlayFabIDsFromSteamIDsResult {
        /**
         * Mapping of Steam identifiers to PlayFab identifiers.
         */
        public ArrayList<SteamPlayFabIdPair> Data;
        
    }

    public static class GetPublisherDataRequest {
        /**
         * array of keys to get back data from the Publisher data blob, set by the admin tools
         */
        public ArrayList<String> Keys;
        
    }

    public static class GetPublisherDataResult {
        /**
         * a dictionary object of key / value pairs
         */
        public Map<String,String> Data;
        
    }

    public static class GetRandomResultTablesRequest {
        /**
         * Specifies the catalog version that should be used to retrieve the Random Result Tables.  If unspecified, uses default/primary catalog.
         */
        public String CatalogVersion;
        /**
         * The unique identifier of the Random Result Table to use.
         */
        public ArrayList<String> TableIDs;
        
    }

    public static class GetRandomResultTablesResult {
        /**
         * array of random result tables currently available
         */
        public Map<String,RandomResultTableListing> Tables;
        
    }

    public static class GetSegmentResult {
        /**
         * Identifier of the segments AB Test, if it is attached to one.
         */
        public String ABTestParent;
        /**
         * Unique identifier for this segment.
         */
        public String Id;
        /**
         * Segment name.
         */
        public String Name;
        
    }

    public static class GetSharedGroupDataRequest {
        /**
         * If true, return the list of all members of the shared group.
         */
        public Boolean GetMembers;
        /**
         * Specific keys to retrieve from the shared group (if not specified, all keys will be returned, while an empty array indicates that no keys should be returned).
         */
        public ArrayList<String> Keys;
        /**
         * Unique identifier for the shared group.
         */
        public String SharedGroupId;
        
    }

    public static class GetSharedGroupDataResult {
        /**
         * Data for the requested keys.
         */
        public Map<String,SharedGroupDataRecord> Data;
        /**
         * List of PlayFabId identifiers for the members of this group, if requested.
         */
        public ArrayList<String> Members;
        
    }

    public static class GetTimeRequest {
        
    }

    public static class GetTimeResult {
        /**
         * Current server time when the request was received, in UTC
         */
        public Date Time;
        
    }

    public static class GetTitleDataRequest {
        /**
         * Specific keys to search for in the title data (leave null to get all keys)
         */
        public ArrayList<String> Keys;
        
    }

    public static class GetTitleDataResult {
        /**
         * a dictionary object of key / value pairs
         */
        public Map<String,String> Data;
        
    }

    public static class GetTitleNewsRequest {
        /**
         * Limits the results to the last n entries. Defaults to 10 if not set.
         */
        public Integer Count;
        
    }

    public static class GetTitleNewsResult {
        /**
         * Array of news items.
         */
        public ArrayList<TitleNewsItem> News;
        
    }

    public static class GetUserAccountInfoRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetUserAccountInfoResult {
        /**
         * Account details for the user whose information was requested.
         */
        public UserAccountInfo UserInfo;
        
    }

    public static class GetUserBansRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetUserBansResult {
        /**
         * Information about the bans
         */
        public ArrayList<BanInfo> BanData;
        
    }

    public static class GetUserDataRequest {
        /**
         * The version that currently exists according to the caller. The call will return the data for all of the keys if the version in the system is greater than this.
         */
        public Long IfChangedFromDataVersion;
        /**
         * Specific keys to search for in the custom user data.
         */
        public ArrayList<String> Keys;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetUserDataResult {
        /**
         * User specific data for this title.
         */
        public Map<String,UserDataRecord> Data;
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        /**
         * PlayFab unique identifier of the user whose custom data is being returned.
         */
        public String PlayFabId;
        
    }

    public static class GetUserInventoryRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetUserInventoryResult {
        /**
         * Array of inventory items belonging to the user.
         */
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> Inventory;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Array of virtual currency balance(s) belonging to the user.
         */
        public Map<String,Integer> VirtualCurrency;
        /**
         * Array of remaining times and timestamps for virtual currencies.
         */
        public Map<String,VirtualCurrencyRechargeTime> VirtualCurrencyRechargeTimes;
        
    }

    public static class GrantCharacterToUserRequest {
        /**
         * Non-unique display name of the character being granted (1-20 characters in length).
         */
        public String CharacterName;
        /**
         * Type of the character being granted; statistics can be sliced based on this value.
         */
        public String CharacterType;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GrantCharacterToUserResult {
        /**
         * Unique identifier tagged to this character.
         */
        public String CharacterId;
        
    }

    /**
     * Result of granting an item to a user
     */
    public static class GrantedItemInstance implements Comparable<GrantedItemInstance> {
        /**
         * Game specific comment associated with this instance when it was added to the user inventory.
         */
        public String Annotation;
        /**
         * Array of unique items that were awarded when this catalog item was purchased.
         */
        public ArrayList<String> BundleContents;
        /**
         * Unique identifier for the parent inventory item, as defined in the catalog, for object which were added from a bundle or container.
         */
        public String BundleParent;
        /**
         * Catalog version for the inventory item, when this instance was created.
         */
        public String CatalogVersion;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * A set of custom key-value pairs on the inventory item.
         */
        public Map<String,String> CustomData;
        /**
         * CatalogItem.DisplayName at the time this item was purchased.
         */
        public String DisplayName;
        /**
         * Timestamp for when this instance will expire.
         */
        public Date Expiration;
        /**
         * Class name for the inventory item, as defined in the catalog.
         */
        public String ItemClass;
        /**
         * Unique identifier for the inventory item, as defined in the catalog.
         */
        public String ItemId;
        /**
         * Unique item identifier for this specific instance of the item.
         */
        public String ItemInstanceId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Timestamp for when this instance was purchased.
         */
        public Date PurchaseDate;
        /**
         * Total number of remaining uses, if this is a consumable item.
         */
        public Integer RemainingUses;
        /**
         * Result of this operation.
         */
        public Boolean Result;
        /**
         * Currency type for the cost of the catalog item.
         */
        public String UnitCurrency;
        /**
         * Cost of the catalog item in the given currency.
         */
        public Long UnitPrice;
        /**
         * The number of uses that were added or removed to this item in this call.
         */
        public Integer UsesIncrementedBy;
        
        public int compareTo(GrantedItemInstance other) {
            if (other == null || other.ItemInstanceId == null) return 1;
            if (ItemInstanceId == null) return -1;
            return ItemInstanceId.compareTo(other.ItemInstanceId);
        }
    }

    public static class GrantItemsToCharacterRequest {
        /**
         * String detailing any additional information concerning this operation.
         */
        public String Annotation;
        /**
         * Catalog version from which items are to be granted.
         */
        public String CatalogVersion;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Array of itemIds to grant to the user.
         */
        public ArrayList<String> ItemIds;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GrantItemsToCharacterResult {
        /**
         * Array of items granted to users.
         */
        public ArrayList<GrantedItemInstance> ItemGrantResults;
        
    }

    public static class GrantItemsToUserRequest {
        /**
         * String detailing any additional information concerning this operation.
         */
        public String Annotation;
        /**
         * Catalog version from which items are to be granted.
         */
        public String CatalogVersion;
        /**
         * Array of itemIds to grant to the user.
         */
        public ArrayList<String> ItemIds;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GrantItemsToUserResult {
        /**
         * Array of items granted to users.
         */
        public ArrayList<GrantedItemInstance> ItemGrantResults;
        
    }

    public static class GrantItemsToUsersRequest {
        /**
         * Catalog version from which items are to be granted.
         */
        public String CatalogVersion;
        /**
         * Array of items to grant and the users to whom the items are to be granted.
         */
        @Unordered
        public ArrayList<ItemGrant> ItemGrants;
        
    }

    public static class GrantItemsToUsersResult {
        /**
         * Array of items granted to users.
         */
        public ArrayList<GrantedItemInstance> ItemGrantResults;
        
    }

    public static class ItemGrant {
        /**
         * String detailing any additional information concerning this operation.
         */
        public String Annotation;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character or be null.
         */
        public Map<String,String> Data;
        /**
         * Unique identifier of the catalog item to be granted to the user.
         */
        public String ItemId;
        /**
         * Optional list of Data-keys to remove from UserData.  Some SDKs cannot insert null-values into Data due to language constraints.  Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    /**
     * A unique instance of an item in a user's inventory. Note, to retrieve additional information for an item instance (such as Tags, Description, or Custom Data that are set on the root catalog item), a call to GetCatalogItems is required. The Item ID of the instance can then be matched to a catalog entry, which contains the additional information. Also note that Custom Data is only set here from a call to UpdateUserInventoryItemCustomData.
     */
    public static class ItemInstance implements Comparable<ItemInstance> {
        /**
         * Game specific comment associated with this instance when it was added to the user inventory.
         */
        public String Annotation;
        /**
         * Array of unique items that were awarded when this catalog item was purchased.
         */
        public ArrayList<String> BundleContents;
        /**
         * Unique identifier for the parent inventory item, as defined in the catalog, for object which were added from a bundle or container.
         */
        public String BundleParent;
        /**
         * Catalog version for the inventory item, when this instance was created.
         */
        public String CatalogVersion;
        /**
         * A set of custom key-value pairs on the inventory item.
         */
        public Map<String,String> CustomData;
        /**
         * CatalogItem.DisplayName at the time this item was purchased.
         */
        public String DisplayName;
        /**
         * Timestamp for when this instance will expire.
         */
        public Date Expiration;
        /**
         * Class name for the inventory item, as defined in the catalog.
         */
        public String ItemClass;
        /**
         * Unique identifier for the inventory item, as defined in the catalog.
         */
        public String ItemId;
        /**
         * Unique item identifier for this specific instance of the item.
         */
        public String ItemInstanceId;
        /**
         * Timestamp for when this instance was purchased.
         */
        public Date PurchaseDate;
        /**
         * Total number of remaining uses, if this is a consumable item.
         */
        public Integer RemainingUses;
        /**
         * Currency type for the cost of the catalog item.
         */
        public String UnitCurrency;
        /**
         * Cost of the catalog item in the given currency.
         */
        public Long UnitPrice;
        /**
         * The number of uses that were added or removed to this item in this call.
         */
        public Integer UsesIncrementedBy;
        
        public int compareTo(ItemInstance other) {
            if (other == null || other.ItemInstanceId == null) return 1;
            if (ItemInstanceId == null) return -1;
            return ItemInstanceId.compareTo(other.ItemInstanceId);
        }
    }

    public static class LinkedPlatformAccountModel {
        /**
         * Linked account email of the user on the platform, if available
         */
        public String Email;
        /**
         * Authentication platform
         */
        public LoginIdentityProvider Platform;
        /**
         * Unique account identifier of the user on the platform
         */
        public String PlatformUserId;
        /**
         * Linked account username of the user on the platform, if available
         */
        public String Username;
        
    }

    public static class ListUsersCharactersRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class ListUsersCharactersResult {
        /**
         * The requested list of characters.
         */
        public ArrayList<CharacterResult> Characters;
        
    }

    public static class LocationModel {
        /**
         * City name.
         */
        public String City;
        /**
         * The two-character continent code for this location
         */
        public ContinentCode ContinentCode;
        /**
         * The two-character ISO 3166-1 country code for the country associated with the location
         */
        public CountryCode CountryCode;
        /**
         * Latitude coordinate of the geographic location.
         */
        public Double Latitude;
        /**
         * Longitude coordinate of the geographic location.
         */
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
        WindowsHello
    }

    public static class LogStatement {
        /**
         * Optional object accompanying the message as contextual information
         */
        public Object Data;
        /**
         * 'Debug', 'Info', or 'Error'
         */
        public String Level;
        public String Message;
        
    }

    public static class MembershipModel {
        /**
         * Whether this membership is active. That is, whether the MembershipExpiration time has been reached.
         */
        public Boolean IsActive;
        /**
         * The time this membership expires
         */
        public Date MembershipExpiration;
        /**
         * The id of the membership
         */
        public String MembershipId;
        /**
         * Membership expirations can be explicitly overridden (via game manager or the admin api). If this membership has been overridden, this will be the new expiration time.
         */
        public Date OverrideExpiration;
        /**
         * The list of subscriptions that this player has for this membership
         */
        public ArrayList<SubscriptionModel> Subscriptions;
        
    }

    public static class ModifyCharacterVirtualCurrencyResult {
        /**
         * Balance of the virtual currency after modification.
         */
        public Integer Balance;
        /**
         * Name of the virtual currency which was modified.
         */
        public String VirtualCurrency;
        
    }

    public static class ModifyItemUsesRequest {
        /**
         * Unique instance identifier of the item to be modified.
         */
        public String ItemInstanceId;
        /**
         * PlayFab unique identifier of the user whose item is being modified.
         */
        public String PlayFabId;
        /**
         * Number of uses to add to the item. Can be negative to remove uses.
         */
        public Integer UsesToAdd;
        
    }

    public static class ModifyItemUsesResult {
        /**
         * Unique instance identifier of the item with uses consumed.
         */
        public String ItemInstanceId;
        /**
         * Number of uses remaining on the item.
         */
        public Integer RemainingUses;
        
    }

    public static class ModifyUserVirtualCurrencyResult {
        /**
         * Balance of the virtual currency after modification.
         */
        public Integer Balance;
        /**
         * Amount added or subtracted from the user's virtual currency. Maximum VC balance is Int32 (2,147,483,647). Any increase over this value will be discarded.
         */
        public Integer BalanceChange;
        /**
         * User currency was subtracted from.
         */
        public String PlayFabId;
        /**
         * Name of the virtual currency which was modified.
         */
        public String VirtualCurrency;
        
    }

    public static class MoveItemToCharacterFromCharacterRequest {
        /**
         * Unique identifier of the character that currently has the item.
         */
        public String GivingCharacterId;
        /**
         * Unique PlayFab assigned instance identifier of the item
         */
        public String ItemInstanceId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique identifier of the character that will be receiving the item.
         */
        public String ReceivingCharacterId;
        
    }

    public static class MoveItemToCharacterFromCharacterResult {
        
    }

    public static class MoveItemToCharacterFromUserRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Unique PlayFab assigned instance identifier of the item
         */
        public String ItemInstanceId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class MoveItemToCharacterFromUserResult {
        
    }

    public static class MoveItemToUserFromCharacterRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Unique PlayFab assigned instance identifier of the item
         */
        public String ItemInstanceId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class MoveItemToUserFromCharacterResult {
        
    }

    public static class NotifyMatchmakerPlayerLeftRequest {
        /**
         * Unique identifier of the Game Instance the user is leaving.
         */
        public String LobbyId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class NotifyMatchmakerPlayerLeftResult {
        /**
         * State of user leaving the Game Server Instance.
         */
        public PlayerConnectionState PlayerState;
        
    }

    public static enum PlayerConnectionState {
        Unassigned,
        Connecting,
        Participating,
        Participated
    }

    public static class PlayerLeaderboardEntry {
        /**
         * Title-specific display name of the user for this leaderboard entry.
         */
        public String DisplayName;
        /**
         * PlayFab unique identifier of the user for this leaderboard entry.
         */
        public String PlayFabId;
        /**
         * User's overall position in the leaderboard.
         */
        public Integer Position;
        /**
         * The profile of the user, if requested.
         */
        public PlayerProfileModel Profile;
        /**
         * Specific value of the user's statistic.
         */
        public Integer StatValue;
        
    }

    public static class PlayerLinkedAccount {
        /**
         * Linked account's email
         */
        public String Email;
        /**
         * Authentication platform
         */
        public LoginIdentityProvider Platform;
        /**
         * Platform user identifier
         */
        public String PlatformUserId;
        /**
         * Linked account's username
         */
        public String Username;
        
    }

    public static class PlayerLocation {
        /**
         * City of the player's geographic location.
         */
        public String City;
        /**
         * The two-character continent code for this location
         */
        public ContinentCode ContinentCode;
        /**
         * The two-character ISO 3166-1 country code for the country associated with the location
         */
        public CountryCode CountryCode;
        /**
         * Latitude coordinate of the player's geographic location.
         */
        public Double Latitude;
        /**
         * Longitude coordinate of the player's geographic location.
         */
        public Double Longitude;
        
    }

    public static class PlayerProfile {
        /**
         * Array of ad campaigns player has been attributed to
         */
        public ArrayList<AdCampaignAttribution> AdCampaignAttributions;
        /**
         * Image URL of the player's avatar.
         */
        public String AvatarUrl;
        /**
         * Banned until UTC Date. If permanent ban this is set for 20 years after the original ban date.
         */
        public Date BannedUntil;
        /**
         * Array of contact email addresses associated with the player
         */
        public ArrayList<ContactEmailInfo> ContactEmailAddresses;
        /**
         * Player record created
         */
        public Date Created;
        /**
         * Player Display Name
         */
        public String DisplayName;
        /**
         * Last login
         */
        public Date LastLogin;
        /**
         * Array of third party accounts linked to this player
         */
        public ArrayList<PlayerLinkedAccount> LinkedAccounts;
        /**
         * Dictionary of player's locations by type.
         */
        public Map<String,PlayerLocation> Locations;
        /**
         * Player account origination
         */
        public LoginIdentityProvider Origination;
        /**
         * PlayFab Player ID
         */
        public String PlayerId;
        /**
         * Array of player statistics
         */
        public ArrayList<PlayerStatistic> PlayerStatistics;
        /**
         * Publisher this player belongs to
         */
        public String PublisherId;
        /**
         * Array of configured push notification end points
         */
        public ArrayList<PushNotificationRegistration> PushNotificationRegistrations;
        /**
         * Dictionary of player's statistics using only the latest version's value
         */
        public Map<String,Integer> Statistics;
        /**
         * List of player's tags for segmentation.
         */
        public ArrayList<String> Tags;
        /**
         * Title ID this profile applies to
         */
        public String TitleId;
        /**
         * A sum of player's total purchases in USD across all currencies.
         */
        public Long TotalValueToDateInUSD;
        /**
         * Dictionary of player's total purchases by currency.
         */
        public Map<String,Long> ValuesToDate;
        /**
         * Dictionary of player's virtual currency balances
         */
        public Map<String,Integer> VirtualCurrencyBalances;
        
    }

    public static class PlayerProfileModel {
        /**
         * List of advertising campaigns the player has been attributed to
         */
        public ArrayList<AdCampaignAttributionModel> AdCampaignAttributions;
        /**
         * URL of the player's avatar image
         */
        public String AvatarUrl;
        /**
         * If the player is currently banned, the UTC Date when the ban expires
         */
        public Date BannedUntil;
        /**
         * List of all contact email info associated with the player account
         */
        public ArrayList<ContactEmailInfoModel> ContactEmailAddresses;
        /**
         * Player record created
         */
        public Date Created;
        /**
         * Player display name
         */
        public String DisplayName;
        /**
         * UTC time when the player most recently logged in to the title
         */
        public Date LastLogin;
        /**
         * List of all authentication systems linked to this player account
         */
        public ArrayList<LinkedPlatformAccountModel> LinkedAccounts;
        /**
         * List of geographic locations from which the player has logged in to the title
         */
        public ArrayList<LocationModel> Locations;
        /**
         * List of memberships for the player, along with whether are expired.
         */
        public ArrayList<MembershipModel> Memberships;
        /**
         * Player account origination
         */
        public LoginIdentityProvider Origination;
        /**
         * PlayFab player account unique identifier
         */
        public String PlayerId;
        /**
         * Publisher this player belongs to
         */
        public String PublisherId;
        /**
         * List of configured end points registered for sending the player push notifications
         */
        public ArrayList<PushNotificationRegistrationModel> PushNotificationRegistrations;
        /**
         * List of leaderboard statistic values for the player
         */
        public ArrayList<StatisticModel> Statistics;
        /**
         * List of player's tags for segmentation
         */
        public ArrayList<TagModel> Tags;
        /**
         * Title ID this player profile applies to
         */
        public String TitleId;
        /**
         * Sum of the player's purchases made with real-money currencies, converted to US dollars equivalent and represented as a whole number of cents (1/100 USD).              For example, 999 indicates nine dollars and ninety-nine cents.
         */
        public Long TotalValueToDateInUSD;
        /**
         * List of the player's lifetime purchase totals, summed by real-money currency
         */
        public ArrayList<ValueToDateModel> ValuesToDate;
        /**
         * List of the player's virtual currency balances
         */
        public ArrayList<VirtualCurrencyBalanceModel> VirtualCurrencyBalances;
        
    }

    public static class PlayerProfileViewConstraints {
        /**
         * Whether to show player's avatar URL. Defaults to false
         */
        public Boolean ShowAvatarUrl;
        /**
         * Whether to show the banned until time. Defaults to false
         */
        public Boolean ShowBannedUntil;
        /**
         * Whether to show campaign attributions. Defaults to false
         */
        public Boolean ShowCampaignAttributions;
        /**
         * Whether to show contact email addresses. Defaults to false
         */
        public Boolean ShowContactEmailAddresses;
        /**
         * Whether to show the created date. Defaults to false
         */
        public Boolean ShowCreated;
        /**
         * Whether to show the display name. Defaults to false
         */
        public Boolean ShowDisplayName;
        /**
         * Whether to show the last login time. Defaults to false
         */
        public Boolean ShowLastLogin;
        /**
         * Whether to show the linked accounts. Defaults to false
         */
        public Boolean ShowLinkedAccounts;
        /**
         * Whether to show player's locations. Defaults to false
         */
        public Boolean ShowLocations;
        /**
         * Whether to show player's membership information. Defaults to false
         */
        public Boolean ShowMemberships;
        /**
         * Whether to show origination. Defaults to false
         */
        public Boolean ShowOrigination;
        /**
         * Whether to show push notification registrations. Defaults to false
         */
        public Boolean ShowPushNotificationRegistrations;
        /**
         * Reserved for future development
         */
        public Boolean ShowStatistics;
        /**
         * Whether to show tags. Defaults to false
         */
        public Boolean ShowTags;
        /**
         * Whether to show the total value to date in usd. Defaults to false
         */
        public Boolean ShowTotalValueToDateInUsd;
        /**
         * Whether to show the values to date. Defaults to false
         */
        public Boolean ShowValuesToDate;
        
    }

    public static class PlayerStatistic {
        /**
         * Statistic ID
         */
        public String Id;
        /**
         * Statistic name
         */
        public String Name;
        /**
         * Current statistic value
         */
        public Integer StatisticValue;
        /**
         * Statistic version (0 if not a versioned statistic)
         */
        public Integer StatisticVersion;
        
    }

    public static class PlayerStatisticVersion {
        /**
         * time when the statistic version became active
         */
        public Date ActivationTime;
        /**
         * time when the statistic version became inactive due to statistic version incrementing
         */
        public Date DeactivationTime;
        /**
         * time at which the statistic version was scheduled to become active, based on the configured ResetInterval
         */
        public Date ScheduledActivationTime;
        /**
         * time at which the statistic version was scheduled to become inactive, based on the configured ResetInterval
         */
        public Date ScheduledDeactivationTime;
        /**
         * name of the statistic when the version became active
         */
        public String StatisticName;
        /**
         * version of the statistic
         */
        public Long Version;
        
    }

    public static class PushNotificationPackage {
        /**
         * Arbitrary string that will be delivered with the message. Suggested use: JSON formatted object
         */
        public String CustomData;
        /**
         * Icon file to display with the message
         */
        public String Icon;
        /**
         * Content of the message
         */
        public String Message;
        /**
         * If set, represents a timestamp for when the device should display the message. Local format should be formatted as: yyyy-MM-dd HH:mm:ss or UTC timestamp formatted as yyyy-MM-ddTHH:mm:ssZ. Delivery is not delayed, scheduling is expected to be handled by the device.
         */
        public String ScheduleDate;
        /**
         * Sound file to play with the message
         */
        public String Sound;
        /**
         * Title/Subject of the message
         */
        public String Title;
        
    }

    public static enum PushNotificationPlatform {
        ApplePushNotificationService,
        GoogleCloudMessaging
    }

    public static class PushNotificationRegistration {
        /**
         * Notification configured endpoint
         */
        public String NotificationEndpointARN;
        /**
         * Push notification platform
         */
        public PushNotificationPlatform Platform;
        
    }

    public static class PushNotificationRegistrationModel {
        /**
         * Notification configured endpoint
         */
        public String NotificationEndpointARN;
        /**
         * Push notification platform
         */
        public PushNotificationPlatform Platform;
        
    }

    public static class RandomResultTableListing {
        /**
         * Catalog version this table is associated with
         */
        public String CatalogVersion;
        /**
         * Child nodes that indicate what kind of drop table item this actually is.
         */
        public ArrayList<ResultTableNode> Nodes;
        /**
         * Unique name for this drop table
         */
        public String TableId;
        
    }

    public static class RedeemCouponRequest {
        /**
         * Catalog version of the coupon.
         */
        public String CatalogVersion;
        /**
         * Optional identifier for the Character that should receive the item. If null, item is added to the player
         */
        public String CharacterId;
        /**
         * Generated coupon code to redeem.
         */
        public String CouponCode;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class RedeemCouponResult {
        /**
         * Items granted to the player as a result of redeeming the coupon.
         */
        public ArrayList<ItemInstance> GrantedItems;
        
    }

    public static class RedeemMatchmakerTicketRequest {
        /**
         * Unique identifier of the Game Server Instance that is asking for validation of the authorization ticket.
         */
        public String LobbyId;
        /**
         * Server authorization ticket passed back from a call to Matchmake or StartGame.
         */
        public String Ticket;
        
    }

    public static class RedeemMatchmakerTicketResult {
        /**
         * Error value if the ticket was not validated.
         */
        public String Error;
        /**
         * Boolean indicating whether the ticket was validated by the PlayFab service.
         */
        public Boolean TicketIsValid;
        /**
         * User account information for the user validated.
         */
        public UserAccountInfo UserInfo;
        
    }

    public static class RefreshGameServerInstanceHeartbeatRequest {
        /**
         * Unique identifier of the Game Server Instance for which the heartbeat is updated.
         */
        public String LobbyId;
        
    }

    public static class RefreshGameServerInstanceHeartbeatResult {
        
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

    public static class RegisterGameRequest {
        /**
         * Unique identifier of the build running on the Game Server Instance.
         */
        public String Build;
        /**
         * Game Mode the Game Server instance is running. Note that this must be defined in the Game Modes tab in the PlayFab Game Manager, along with the Build ID (the same Game Mode can be defined for multiple Build IDs).
         */
        public String GameMode;
        /**
         * Previous lobby id if re-registering an existing game.
         */
        public String LobbyId;
        /**
         * Region in which the Game Server Instance is running. For matchmaking using non-AWS region names, set this to any AWS region and use Tags (below) to specify your custom region.
         */
        public Region Region;
        /**
         * IP address of the Game Server Instance.
         */
        public String ServerHost;
        /**
         * Port number for communication with the Game Server Instance.
         */
        public String ServerPort;
        /**
         * Tags for the Game Server Instance
         */
        public Map<String,String> Tags;
        
    }

    public static class RegisterGameResponse {
        /**
         * Unique identifier generated for the Game Server Instance that is registered. If LobbyId is specified in request and the game still exists in PlayFab, the LobbyId in request is returned. Otherwise a new lobby id will be returned.
         */
        public String LobbyId;
        
    }

    public static class RemoveFriendRequest {
        /**
         * PlayFab identifier of the friend account which is to be removed.
         */
        public String FriendPlayFabId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class RemovePlayerTagRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique tag for player profile.
         */
        public String TagName;
        
    }

    public static class RemovePlayerTagResult {
        
    }

    public static class RemoveSharedGroupMembersRequest {
        /**
         * An array of unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public ArrayList<String> PlayFabIds;
        /**
         * Unique identifier for the shared group.
         */
        public String SharedGroupId;
        
    }

    public static class RemoveSharedGroupMembersResult {
        
    }

    public static class ReportPlayerServerRequest {
        /**
         * Optional additional comment by reporting player.
         */
        public String Comment;
        /**
         * Unique PlayFab identifier of the reported player.
         */
        public String ReporteeId;
        /**
         * PlayFabId of the reporting player.
         */
        public String ReporterId;
        
    }

    public static class ReportPlayerServerResult {
        /**
         * The number of remaining reports which may be filed today by this reporting player.
         */
        public Integer SubmissionsRemaining;
        
    }

    public static class ResultTableNode {
        /**
         * Either an ItemId, or the TableId of another random result table
         */
        public String ResultItem;
        /**
         * Whether this entry in the table is an item or a link to another table
         */
        public ResultTableNodeType ResultItemType;
        /**
         * How likely this is to be rolled - larger numbers add more weight
         */
        public Integer Weight;
        
    }

    public static enum ResultTableNodeType {
        ItemId,
        TableId
    }

    public static class RevokeAllBansForUserRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class RevokeAllBansForUserResult {
        /**
         * Information on the bans that were revoked.
         */
        public ArrayList<BanInfo> BanData;
        
    }

    public static class RevokeBansRequest {
        /**
         * Ids of the bans to be revoked. Maximum 100.
         */
        public ArrayList<String> BanIds;
        
    }

    public static class RevokeBansResult {
        /**
         * Information on the bans that were revoked
         */
        public ArrayList<BanInfo> BanData;
        
    }

    public static class RevokeInventoryItemRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Unique PlayFab assigned instance identifier of the item
         */
        public String ItemInstanceId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class RevokeInventoryResult {
        
    }

    public static class ScriptExecutionError {
        /**
         * Error code, such as CloudScriptNotFound, JavascriptException, CloudScriptFunctionArgumentSizeExceeded, CloudScriptAPIRequestCountExceeded, CloudScriptAPIRequestError, or CloudScriptHTTPRequestError
         */
        public String Error;
        /**
         * Details about the error
         */
        public String Message;
        /**
         * Point during the execution of the script at which the error occurred, if any
         */
        public String StackTrace;
        
    }

    public static class SendPushNotificationRequest {
        /**
         * Allows you to provide precisely formatted json to target devices. This is an advanced feature, allowing you to deliver to custom plugin logic, fields, or functionality not natively supported by PlayFab.
         */
        public ArrayList<AdvancedPushPlatformMsg> AdvancedPlatformDelivery;
        /**
         * Text of message to send.
         */
        public String Message;
        /**
         * Defines all possible push attributes like message, title, icon, etc. Not fully supported for iOS devices.
         */
        public PushNotificationPackage Package;
        /**
         * PlayFabId of the recipient of the push notification.
         */
        public String Recipient;
        /**
         * Subject of message to send (may not be displayed in all platforms.
         */
        public String Subject;
        /**
         * Target Platforms that should receive the Message or Package. If omitted, we will send to all available platforms.
         */
        public ArrayList<PushNotificationPlatform> TargetPlatforms;
        
    }

    public static class SendPushNotificationResult {
        
    }

    public static class SetFriendTagsRequest {
        /**
         * PlayFab identifier of the friend account to which the tag(s) should be applied.
         */
        public String FriendPlayFabId;
        /**
         * PlayFab identifier of the player whose friend is to be updated.
         */
        public String PlayFabId;
        /**
         * Array of tags to set on the friend account.
         */
        public ArrayList<String> Tags;
        
    }

    public static class SetGameServerInstanceDataRequest {
        /**
         * Custom data to set for the specified game server instance.
         */
        public String GameServerData;
        /**
         * Unique identifier of the Game Instance to be updated, in decimal format.
         */
        public String LobbyId;
        
    }

    public static class SetGameServerInstanceDataResult {
        
    }

    public static class SetGameServerInstanceStateRequest {
        /**
         * Unique identifier of the Game Instance to be updated, in decimal format.
         */
        public String LobbyId;
        /**
         * State to set for the specified game server instance.
         */
        public GameInstanceState State;
        
    }

    public static class SetGameServerInstanceStateResult {
        
    }

    public static class SetGameServerInstanceTagsRequest {
        /**
         * Unique identifier of the Game Server Instance to be updated.
         */
        public String LobbyId;
        /**
         * Tags to set for the specified Game Server Instance. Note that this is the complete list of tags to be associated with the Game Server Instance.
         */
        public Map<String,String> Tags;
        
    }

    public static class SetGameServerInstanceTagsResult {
        
    }

    public static class SetPlayerSecretRequest {
        /**
         * Player secret that is used to verify API request signatures (Enterprise Only).
         */
        public String PlayerSecret;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class SetPlayerSecretResult {
        
    }

    public static class SetPublisherDataRequest {
        /**
         * key we want to set a value on (note, this is additive - will only replace an existing key's value if they are the same name.) Keys are trimmed of whitespace. Keys may not begin with the '!' character.
         */
        public String Key;
        /**
         * new value to set. Set to null to remove a value
         */
        public String Value;
        
    }

    public static class SetPublisherDataResult {
        
    }

    public static class SetTitleDataRequest {
        /**
         * key we want to set a value on (note, this is additive - will only replace an existing key's value if they are the same name.) Keys are trimmed of whitespace. Keys may not begin with the '!' character.
         */
        public String Key;
        /**
         * new value to set. Set to null to remove a value
         */
        public String Value;
        
    }

    public static class SetTitleDataResult {
        
    }

    public static class SharedGroupDataRecord {
        /**
         * Timestamp for when this data was last updated.
         */
        public Date LastUpdated;
        /**
         * PlayFabId of the user to last update this value.
         */
        public String LastUpdatedBy;
        /**
         * Indicates whether this data can be read by all users (public) or only members of the group (private).
         */
        public UserDataPermission Permission;
        /**
         * Data stored for the specified group data key.
         */
        public String Value;
        
    }

    public static class StatisticModel {
        /**
         * Statistic name
         */
        public String Name;
        /**
         * Statistic value
         */
        public Integer Value;
        /**
         * Statistic version (0 if not a versioned statistic)
         */
        public Integer Version;
        
    }

    public static class StatisticNameVersion {
        /**
         * unique name of the statistic
         */
        public String StatisticName;
        /**
         * the version of the statistic to be returned
         */
        public Long Version;
        
    }

    public static class StatisticUpdate {
        /**
         * unique name of the statistic
         */
        public String StatisticName;
        /**
         * statistic value for the player
         */
        public Integer Value;
        /**
         * for updates to an existing statistic value for a player, the version of the statistic when it was loaded. Null when setting the statistic value for the first time.
         */
        public Long Version;
        
    }

    public static class StatisticValue {
        /**
         * unique name of the statistic
         */
        public String StatisticName;
        /**
         * statistic value for the player
         */
        public Integer Value;
        /**
         * for updates to an existing statistic value for a player, the version of the statistic when it was loaded
         */
        public Long Version;
        
    }

    public static class SteamPlayFabIdPair {
        /**
         * Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Steam identifier.
         */
        public String PlayFabId;
        /**
         * Unique Steam identifier for a user.
         */
        public String SteamStringId;
        
    }

    public static class SubscriptionModel {
        /**
         * When this subscription expires.
         */
        public Date Expiration;
        /**
         * The time the subscription was orignially purchased
         */
        public Date InitialSubscriptionTime;
        /**
         * Whether this subscription is currently active. That is, if Expiration &gt; now.
         */
        public Boolean IsActive;
        /**
         * The status of this subscription, according to the subscription provider.
         */
        public SubscriptionProviderStatus Status;
        /**
         * The id for this subscription
         */
        public String SubscriptionId;
        /**
         * The item id for this subscription from the primary catalog
         */
        public String SubscriptionItemId;
        /**
         * The provider for this subscription. Apple or Google Play are supported today.
         */
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

    public static class SubtractCharacterVirtualCurrencyRequest {
        /**
         * Amount to be subtracted from the user balance of the specified virtual currency.
         */
        public Integer Amount;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Name of the virtual currency which is to be decremented.
         */
        public String VirtualCurrency;
        
    }

    public static class SubtractUserVirtualCurrencyRequest {
        /**
         * Amount to be subtracted from the user balance of the specified virtual currency.
         */
        public Integer Amount;
        /**
         * PlayFab unique identifier of the user whose virtual currency balance is to be decreased.
         */
        public String PlayFabId;
        /**
         * Name of the virtual currency which is to be decremented.
         */
        public String VirtualCurrency;
        
    }

    public static class TagModel {
        /**
         * Full value of the tag, including namespace
         */
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
        /**
         * News item text.
         */
        public String Body;
        /**
         * Unique identifier of news item.
         */
        public String NewsId;
        /**
         * Date and time when the news items was posted.
         */
        public Date Timestamp;
        /**
         * Title of the news item.
         */
        public String Title;
        
    }

    public static class UnlockContainerInstanceRequest {
        /**
         * Specifies the catalog version that should be used to determine container contents.  If unspecified, uses catalog associated with the item instance.
         */
        public String CatalogVersion;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * ItemInstanceId of the container to unlock.
         */
        public String ContainerItemInstanceId;
        /**
         * ItemInstanceId of the key that will be consumed by unlocking this container.  If the container requires a key, this parameter is required.
         */
        public String KeyItemInstanceId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class UnlockContainerItemRequest {
        /**
         * Specifies the catalog version that should be used to determine container contents.  If unspecified, uses default/primary catalog.
         */
        public String CatalogVersion;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Catalog ItemId of the container type to unlock.
         */
        public String ContainerItemId;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class UnlockContainerItemResult {
        /**
         * Items granted to the player as a result of unlocking the container.
         */
        public ArrayList<ItemInstance> GrantedItems;
        /**
         * Unique instance identifier of the container unlocked.
         */
        public String UnlockedItemInstanceId;
        /**
         * Unique instance identifier of the key used to unlock the container, if applicable.
         */
        public String UnlockedWithItemInstanceId;
        /**
         * Virtual currency granted to the player as a result of unlocking the container.
         */
        public Map<String,Long> VirtualCurrency;
        
    }

    public static class UpdateAvatarUrlRequest {
        /**
         * URL of the avatar image. If empty, it removes the existing avatar URL.
         */
        public String ImageUrl;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    /**
     * Represents a single update ban request.
     */
    public static class UpdateBanRequest {
        /**
         * The updated active state for the ban. Null for no change.
         */
        public Boolean Active;
        /**
         * The id of the ban to be updated.
         */
        public String BanId;
        /**
         * The updated expiration date for the ban. Null for no change.
         */
        public Date Expires;
        /**
         * The updated IP address for the ban. Null for no change.
         */
        public String IPAddress;
        /**
         * The updated MAC address for the ban. Null for no change.
         */
        public String MACAddress;
        /**
         * Whether to make this ban permanent. Set to true to make this ban permanent. This will not modify Active state.
         */
        public Boolean Permanent;
        /**
         * The updated reason for the ban to be updated. Maximum 140 characters. Null for no change.
         */
        public String Reason;
        
    }

    public static class UpdateBansRequest {
        /**
         * List of bans to be updated. Maximum 100.
         */
        public ArrayList<UpdateBanRequest> Bans;
        
    }

    public static class UpdateBansResult {
        /**
         * Information on the bans that were updated
         */
        public ArrayList<BanInfo> BanData;
        
    }

    public static class UpdateCharacterDataRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character or be null.
         */
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData.  Some SDKs cannot insert null-values into Data due to language constraints.  Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        /**
         * Permission to be applied to all user data keys written in this request. Defaults to "private" if not set.
         */
        public UserDataPermission Permission;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class UpdateCharacterDataResult {
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        
    }

    public static class UpdateCharacterStatisticsRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Statistics to be updated with the provided values.
         */
        public Map<String,Integer> CharacterStatistics;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class UpdateCharacterStatisticsResult {
        
    }

    public static class UpdatePlayerStatisticsRequest {
        /**
         * Indicates whether the statistics provided should be set, regardless of the aggregation method set on the statistic. Default is false.
         */
        public Boolean ForceUpdate;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Statistics to be updated with the provided values
         */
        public ArrayList<StatisticUpdate> Statistics;
        
    }

    public static class UpdatePlayerStatisticsResult {
        
    }

    public static class UpdateSharedGroupDataRequest {
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character or be null.
         */
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData.  Some SDKs cannot insert null-values into Data due to language constraints.  Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        /**
         * Permission to be applied to all user data keys in this request.
         */
        public UserDataPermission Permission;
        /**
         * Unique identifier for the shared group.
         */
        public String SharedGroupId;
        
    }

    public static class UpdateSharedGroupDataResult {
        
    }

    public static class UpdateUserDataRequest {
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character or be null.
         */
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData.  Some SDKs cannot insert null-values into Data due to language constraints.  Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        /**
         * Permission to be applied to all user data keys written in this request. Defaults to "private" if not set.
         */
        public UserDataPermission Permission;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class UpdateUserDataResult {
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        
    }

    public static class UpdateUserInternalDataRequest {
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character or be null.
         */
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData.  Some SDKs cannot insert null-values into Data due to language constraints.  Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class UpdateUserInventoryItemDataRequest {
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character or be null.
         */
        public Map<String,String> Data;
        /**
         * Unique PlayFab assigned instance identifier of the item
         */
        public String ItemInstanceId;
        /**
         * Optional list of Data-keys to remove from UserData.  Some SDKs cannot insert null-values into Data due to language constraints.  Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class UserAccountInfo {
        /**
         * User Android device information, if an Android device has been linked
         */
        public UserAndroidDeviceInfo AndroidDeviceInfo;
        /**
         * Timestamp indicating when the user account was created
         */
        public Date Created;
        /**
         * Custom ID information, if a custom ID has been assigned
         */
        public UserCustomIdInfo CustomIdInfo;
        /**
         * User Facebook information, if a Facebook account has been linked
         */
        public UserFacebookInfo FacebookInfo;
        /**
         * User Gamecenter information, if a Gamecenter account has been linked
         */
        public UserGameCenterInfo GameCenterInfo;
        /**
         * User Google account information, if a Google account has been linked
         */
        public UserGoogleInfo GoogleInfo;
        /**
         * User iOS device information, if an iOS device has been linked
         */
        public UserIosDeviceInfo IosDeviceInfo;
        /**
         * User Kongregate account information, if a Kongregate account has been linked
         */
        public UserKongregateInfo KongregateInfo;
        /**
         * Unique identifier for the user account
         */
        public String PlayFabId;
        /**
         * Personal information for the user which is considered more sensitive
         */
        public UserPrivateAccountInfo PrivateInfo;
        /**
         * User PSN account information, if a PSN account has been linked
         */
        public UserPsnInfo PsnInfo;
        /**
         * User Steam information, if a Steam account has been linked
         */
        public UserSteamInfo SteamInfo;
        /**
         * Title-specific information for the user account
         */
        public UserTitleInfo TitleInfo;
        /**
         * User Twitch account information, if a Twitch account has been linked
         */
        public UserTwitchInfo TwitchInfo;
        /**
         * User account name in the PlayFab service
         */
        public String Username;
        /**
         * User XBox account information, if a XBox account has been linked
         */
        public UserXboxInfo XboxInfo;
        
    }

    public static class UserAndroidDeviceInfo {
        /**
         * Android device ID
         */
        public String AndroidDeviceId;
        
    }

    public static class UserCustomIdInfo {
        /**
         * Custom ID
         */
        public String CustomId;
        
    }

    /**
     * Indicates whether a given data key is private (readable only by the player) or public (readable by all players). When a player makes a GetUserData request about another player, only keys marked Public will be returned.
     */
    public static enum UserDataPermission {
        Private,
        Public
    }

    public static class UserDataRecord {
        /**
         * Timestamp for when this data was last updated.
         */
        public Date LastUpdated;
        /**
         * Indicates whether this data can be read by all users (public) or only the user (private). This is used for GetUserData requests being made by one player about another player.
         */
        public UserDataPermission Permission;
        /**
         * Data stored for the specified user data key.
         */
        public String Value;
        
    }

    public static class UserFacebookInfo {
        /**
         * Facebook identifier
         */
        public String FacebookId;
        /**
         * Facebook full name
         */
        public String FullName;
        
    }

    public static class UserGameCenterInfo {
        /**
         * Gamecenter identifier
         */
        public String GameCenterId;
        
    }

    public static class UserGoogleInfo {
        /**
         * Email address of the Google account
         */
        public String GoogleEmail;
        /**
         * Gender information of the Google account
         */
        public String GoogleGender;
        /**
         * Google ID
         */
        public String GoogleId;
        /**
         * Locale of the Google account
         */
        public String GoogleLocale;
        
    }

    public static class UserIosDeviceInfo {
        /**
         * iOS device ID
         */
        public String IosDeviceId;
        
    }

    public static class UserKongregateInfo {
        /**
         * Kongregate ID
         */
        public String KongregateId;
        /**
         * Kongregate Username
         */
        public String KongregateName;
        
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
        WindowsHello
    }

    public static class UserPrivateAccountInfo {
        /**
         * user email address
         */
        public String Email;
        
    }

    public static class UserPsnInfo {
        /**
         * PSN account ID
         */
        public String PsnAccountId;
        /**
         * PSN online ID
         */
        public String PsnOnlineId;
        
    }

    public static class UserSteamInfo {
        /**
         * what stage of game ownership the user is listed as being in, from Steam
         */
        public TitleActivationStatus SteamActivationStatus;
        /**
         * the country in which the player resides, from Steam data
         */
        public String SteamCountry;
        /**
         * currency type set in the user Steam account
         */
        public Currency SteamCurrency;
        /**
         * Steam identifier
         */
        public String SteamId;
        
    }

    public static class UserTitleInfo {
        /**
         * URL to the player's avatar.
         */
        public String AvatarUrl;
        /**
         * timestamp indicating when the user was first associated with this game (this can differ significantly from when the user first registered with PlayFab)
         */
        public Date Created;
        /**
         * name of the user, as it is displayed in-game
         */
        public String DisplayName;
        /**
         * timestamp indicating when the user first signed into this game (this can differ from the Created timestamp, as other events, such as issuing a beta key to the user, can associate the title to the user)
         */
        public Date FirstLogin;
        /**
         * boolean indicating whether or not the user is currently banned for a title
         */
        public Boolean isBanned;
        /**
         * timestamp for the last user login for this title
         */
        public Date LastLogin;
        /**
         * source by which the user first joined the game, if known
         */
        public UserOrigination Origination;
        
    }

    public static class UserTwitchInfo {
        /**
         * Twitch ID
         */
        public String TwitchId;
        /**
         * Twitch Username
         */
        public String TwitchUserName;
        
    }

    public static class UserXboxInfo {
        /**
         * XBox user ID
         */
        public String XboxUserId;
        
    }

    public static class ValueToDateModel {
        /**
         * ISO 4217 code of the currency used in the purchases
         */
        public String Currency;
        /**
         * Total value of the purchases in a whole number of 1/100 monetary units. For example, 999 indicates nine dollars and ninety-nine cents when Currency is 'USD')
         */
        public Long TotalValue;
        /**
         * Total value of the purchases in a string representation of decimal monetary units. For example, '9.99' indicates nine dollars and ninety-nine cents when Currency is 'USD'.
         */
        public String TotalValueAsDecimal;
        
    }

    public static class VirtualCurrencyBalanceModel {
        /**
         * Name of the virtual currency
         */
        public String Currency;
        /**
         * Balance of the virtual currency
         */
        public Integer TotalValue;
        
    }

    public static class VirtualCurrencyRechargeTime {
        /**
         * Maximum value to which the regenerating currency will automatically increment. Note that it can exceed this value through use of the AddUserVirtualCurrency API call. However, it will not regenerate automatically until it has fallen below this value.
         */
        public Integer RechargeMax;
        /**
         * Server timestamp in UTC indicating the next time the virtual currency will be incremented.
         */
        public Date RechargeTime;
        /**
         * Time remaining (in seconds) before the next recharge increment of the virtual currency.
         */
        public Integer SecondsToRecharge;
        
    }

    public static class WriteEventResponse {
        /**
         * The unique identifier of the event. The values of this identifier consist of ASCII characters and are not constrained to any particular format.
         */
        public String EventId;
        
    }

    public static class WriteServerCharacterEventRequest {
        /**
         * Custom event properties. Each property consists of a name (string) and a value (JSON object).
         */
        public Map<String,Object> Body;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * The name of the event, within the namespace scoped to the title. The naming convention is up to the caller, but it commonly follows the subject_verb_object pattern (e.g. player_logged_in).
         */
        public String EventName;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * The time (in UTC) associated with this event. The value dafaults to the current time.
         */
        public Date Timestamp;
        
    }

    public static class WriteServerPlayerEventRequest {
        /**
         * Custom data properties associated with the event. Each property consists of a name (string) and a value (JSON object).
         */
        public Map<String,Object> Body;
        /**
         * The name of the event, within the namespace scoped to the title. The naming convention is up to the caller, but it commonly follows the subject_verb_object pattern (e.g. player_logged_in).
         */
        public String EventName;
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * The time (in UTC) associated with this event. The value dafaults to the current time.
         */
        public Date Timestamp;
        
    }

    public static class WriteTitleEventRequest {
        /**
         * Custom event properties. Each property consists of a name (string) and a value (JSON object).
         */
        public Map<String,Object> Body;
        /**
         * The name of the event, within the namespace scoped to the title. The naming convention is up to the caller, but it commonly follows the subject_verb_object pattern (e.g. player_logged_in).
         */
        public String EventName;
        /**
         * The time (in UTC) associated with this event. The value dafaults to the current time.
         */
        public Date Timestamp;
        
    }

}
