package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabAdminModels {

    /** If the task instance has already completed, there will be no-op. */
    @Deprecated
    public static class AbortTaskInstanceRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** ID of a task instance that is being aborted. */
        @Deprecated
        public String TaskInstanceId;
        
    }

    /** The work to be performed on each entity which can only be of one type. */
    @Deprecated
    public static class Action {
        /** Action content to add inventory item v2 */
        @Deprecated
        public AddInventoryItemV2Content AddInventoryItemV2Content;
        /** Action content to ban player */
        @Deprecated
        public BanPlayerContent BanPlayerContent;
        /** Action content to delete inventory item v2 */
        @Deprecated
        public DeleteInventoryItemV2Content DeleteInventoryItemV2Content;
        /** Action content to delete player */
        @Deprecated
        public DeletePlayerContent DeletePlayerContent;
        /** Action content to execute cloud script */
        @Deprecated
        public ExecuteCloudScriptContent ExecuteCloudScriptContent;
        /** Action content to execute azure function */
        @Deprecated
        public ExecuteFunctionContent ExecuteFunctionContent;
        /** Action content to grant item */
        @Deprecated
        public GrantItemContent GrantItemContent;
        /** Action content to grant virtual currency */
        @Deprecated
        public GrantVirtualCurrencyContent GrantVirtualCurrencyContent;
        /** Action content to increment player statistic */
        @Deprecated
        public IncrementPlayerStatisticContent IncrementPlayerStatisticContent;
        /** Action content to send push notification */
        @Deprecated
        public PushNotificationContent PushNotificationContent;
        /** Action content to send email */
        @Deprecated
        public SendEmailContent SendEmailContent;
        /** Action content to subtract inventory item v2 */
        @Deprecated
        public SubtractInventoryItemV2Content SubtractInventoryItemV2Content;
        
    }

    @Deprecated
    public static class ActionsOnPlayersInSegmentTaskParameter {
        /** List of actions to perform on each player in a segment. Each action object can contain only one action type. */
        @Deprecated
        public ArrayList<Action> Actions;
        /** ID of the segment to perform actions on. */
        @Deprecated
        public String SegmentId;
        
    }

    @Deprecated
    public static class ActionsOnPlayersInSegmentTaskSummary {
        /** UTC timestamp when the task completed. */
        @Deprecated
        public Date CompletedAt;
        /** Error message for last processing attempt, if an error occured. */
        @Deprecated
        public String ErrorMessage;
        /** Flag indicating if the error was fatal, if false job will be retried. */
        @Deprecated
        public Boolean ErrorWasFatal;
        /** Estimated time remaining in seconds. */
        @Deprecated
        public Double EstimatedSecondsRemaining;
        /** Progress represented as percentage. */
        @Deprecated
        public Double PercentComplete;
        /** If manually scheduled, ID of user who scheduled the task. */
        @Deprecated
        public String ScheduledByUserId;
        /** UTC timestamp when the task started. */
        @Deprecated
        public Date StartedAt;
        /** Current status of the task instance. */
        @Deprecated
        public TaskInstanceStatus Status;
        /** Identifier of the task this instance belongs to. */
        @Deprecated
        public NameIdentifier TaskIdentifier;
        /** ID of the task instance. */
        @Deprecated
        public String TaskInstanceId;
        /** Total players in segment when task was started. */
        @Deprecated
        public Integer TotalPlayersInSegment;
        /** Total number of players that have had the actions applied to. */
        @Deprecated
        public Integer TotalPlayersProcessed;
        
    }

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
    public static class AdCampaignSegmentFilter {
        /** Campaign id. */
        @Deprecated
        public String CampaignId;
        /** Campaign source. */
        @Deprecated
        public String CampaignSource;
        /** Campaign comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        
    }

    @Deprecated
    public static class AddInventoryItemsV2SegmentAction {
        /** Amount of the item to be granted to a player */
        @Deprecated
        public Integer Amount;
        /** The collection id for where the item will be granted in the player inventory */
        @Deprecated
        public String CollectionId;
        /** The duration in seconds of the subscription to be granted to a player */
        @Deprecated
        public Integer DurationInSeconds;
        /** The id of item to be granted to the player */
        @Deprecated
        public String ItemId;
        /** The stack id for where the item will be granted in the player inventory */
        @Deprecated
        public String StackId;
        
    }

    @Deprecated
    public static class AddInventoryItemV2Content {
        /** Amount of the item to be granted to a player */
        @Deprecated
        public Integer Amount;
        /** The collection id for where the item will be granted in the player inventory */
        @Deprecated
        public String CollectionId;
        /** The duration in seconds of the subscription to be granted to a player */
        @Deprecated
        public Integer DurationInSeconds;
        /** The id of item to be granted to the player */
        @Deprecated
        public String ItemId;
        /** The stack id for where the item will be granted in the player inventory */
        @Deprecated
        public String StackId;
        
    }

    @Deprecated
    public static class AddLocalizedNewsRequest {
        /** Localized body text of the news. */
        @Deprecated
        public String Body;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Language of the news item. */
        @Deprecated
        public String Language;
        /** Unique id of the updated news item. */
        @Deprecated
        public String NewsId;
        /** Localized title (headline) of the news item. */
        @Deprecated
        public String Title;
        
    }

    @Deprecated
    public static class AddLocalizedNewsResult {
        
    }

    @Deprecated
    public static class AddNewsRequest {
        /** Default body text of the news. */
        @Deprecated
        public String Body;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Time this news was published. If not set, defaults to now. */
        @Deprecated
        public Date Timestamp;
        /** Default title (headline) of the news item. */
        @Deprecated
        public String Title;
        
    }

    @Deprecated
    public static class AddNewsResult {
        /** Unique id of the new news item */
        @Deprecated
        public String NewsId;
        
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

    /**
     * This operation is additive. Any new currencies defined in the array will be added to the set of those available for the
     * title, while any CurrencyCode identifiers matching existing ones in the game will be overwritten with the new values.
     */
    @Deprecated
    public static class AddVirtualCurrencyTypesRequest {
        /**
         * List of virtual currencies and their initial deposits (the amount a user is granted when signing in for the first time)
         * to the title
         */
        @Deprecated
        public ArrayList<VirtualCurrencyData> VirtualCurrencies;
        
    }

    @Deprecated
    public static class AllPlayersSegmentFilter {
        
    }

    @Deprecated
    public static class ApiCondition {
        /** Require that API calls contain an RSA encrypted payload or signed headers. */
        @Deprecated
        public Conditionals HasSignatureOrEncryption;
        
    }

    @Deprecated
    public static enum AuthTokenType {
        Email
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

    @Deprecated
    public static class BanPlayerContent {
        /** Duration(in hours) to ban a player. If not provided, the player will be banned permanently. */
        @Deprecated
        public Integer BanDurationHours;
        /** Reason to ban a player */
        @Deprecated
        public String BanReason;
        
    }

    @Deprecated
    public static class BanPlayerSegmentAction {
        /** Ban hours duration. */
        @Deprecated
        public Long BanHours;
        /** Reason for ban. */
        @Deprecated
        public String ReasonForBan;
        
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

    @Deprecated
    public static class BlankResult {
        
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

    /** This returns the total number of these items available. */
    @Deprecated
    public static class CheckLimitedEditionItemAvailabilityRequest {
        /** Which catalog is being updated. If null, uses the default catalog. */
        @Deprecated
        public String CatalogVersion;
        /** The item to check for. */
        @Deprecated
        public String ItemId;
        
    }

    @Deprecated
    public static class CheckLimitedEditionItemAvailabilityResult {
        /** The amount of the specified resource remaining. */
        @Deprecated
        public Integer Amount;
        
    }

    @Deprecated
    public static class ChurnPredictionSegmentFilter {
        /** Comparison */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** RiskLevel */
        @Deprecated
        public ChurnRiskLevel RiskLevel;
        
    }

    @Deprecated
    public static enum ChurnRiskLevel {
        NoData,
        LowRisk,
        MediumRisk,
        HighRisk
    }

    @Deprecated
    public static class CloudScriptFile {
        /** Contents of the Cloud Script javascript. Must be string-escaped javascript. */
        @Deprecated
        public String FileContents;
        /**
         * Name of the javascript file. These names are not used internally by the server, they are only for developer
         * organizational purposes.
         */
        @Deprecated
        public String Filename;
        
    }

    @Deprecated
    public static class CloudScriptTaskParameter {
        /** Argument to pass to the CloudScript function. */
        @Deprecated
        public Object Argument;
        /** Name of the CloudScript function to execute. */
        @Deprecated
        public String FunctionName;
        
    }

    @Deprecated
    public static class CloudScriptTaskSummary {
        /** UTC timestamp when the task completed. */
        @Deprecated
        public Date CompletedAt;
        /** Estimated time remaining in seconds. */
        @Deprecated
        public Double EstimatedSecondsRemaining;
        /** Progress represented as percentage. */
        @Deprecated
        public Double PercentComplete;
        /** Result of CloudScript execution */
        @Deprecated
        public ExecuteCloudScriptResult Result;
        /** If manually scheduled, ID of user who scheduled the task. */
        @Deprecated
        public String ScheduledByUserId;
        /** UTC timestamp when the task started. */
        @Deprecated
        public Date StartedAt;
        /** Current status of the task instance. */
        @Deprecated
        public TaskInstanceStatus Status;
        /** Identifier of the task this instance belongs to. */
        @Deprecated
        public NameIdentifier TaskIdentifier;
        /** ID of the task instance. */
        @Deprecated
        public String TaskInstanceId;
        
    }

    @Deprecated
    public static class CloudScriptVersionStatus {
        /** Most recent revision for this Cloud Script version */
        @Deprecated
        public Integer LatestRevision;
        /** Published code revision for this Cloud Script version */
        @Deprecated
        public Integer PublishedRevision;
        /** Version number */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static enum Conditionals {
        Any,
        True,
        False
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
    public static class ContentInfo {
        /** Key of the content */
        @Deprecated
        public String Key;
        /** Last modified time */
        @Deprecated
        public Date LastModified;
        /** Size of the content in bytes */
        @Deprecated
        public Double Size;
        
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
     * Task name is unique within a title. Using a task name that's already taken will cause a name conflict error. Too many
     * create-task requests within a short time will cause a create conflict error.
     */
    @Deprecated
    public static class CreateActionsOnPlayerSegmentTaskRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Description the task */
        @Deprecated
        public String Description;
        /** Whether the schedule is active. Inactive schedule will not trigger task execution. */
        @Deprecated
        public Boolean IsActive;
        /** Name of the task. This is a unique identifier for tasks in the title. */
        @Deprecated
        public String Name;
        /** Task details related to segment and action */
        @Deprecated
        public ActionsOnPlayersInSegmentTaskParameter Parameter;
        /** Cron expression for the run schedule of the task. The expression should be in UTC. */
        @Deprecated
        public String Schedule;
        
    }

    /**
     * Task name is unique within a title. Using a task name that's already taken will cause a name conflict error. Too many
     * create-task requests within a short time will cause a create conflict error.
     */
    @Deprecated
    public static class CreateCloudScriptTaskRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Description the task */
        @Deprecated
        public String Description;
        /** Whether the schedule is active. Inactive schedule will not trigger task execution. */
        @Deprecated
        public Boolean IsActive;
        /** Name of the task. This is a unique identifier for tasks in the title. */
        @Deprecated
        public String Name;
        /** Task details related to CloudScript */
        @Deprecated
        public CloudScriptTaskParameter Parameter;
        /** Cron expression for the run schedule of the task. The expression should be in UTC. */
        @Deprecated
        public String Schedule;
        
    }

    /**
     * Task name is unique within a title. Using a task name that's already taken will cause a name conflict error. Too many
     * create-task requests within a short time will cause a create conflict error.
     */
    @Deprecated
    public static class CreateInsightsScheduledScalingTaskRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Description the task */
        @Deprecated
        public String Description;
        /** Whether the schedule is active. Inactive schedule will not trigger task execution. */
        @Deprecated
        public Boolean IsActive;
        /** Name of the task. This is a unique identifier for tasks in the title. */
        @Deprecated
        public String Name;
        /** Task details related to Insights Scaling */
        @Deprecated
        public InsightsScalingTaskParameter Parameter;
        /** Cron expression for the run schedule of the task. The expression should be in UTC. */
        @Deprecated
        public String Schedule;
        
    }

    @Deprecated
    public static class CreateOpenIdConnectionRequest {
        /** The client ID given by the ID provider. */
        @Deprecated
        public String ClientId;
        /** The client secret given by the ID provider. */
        @Deprecated
        public String ClientSecret;
        /** A name for the connection that identifies it within the title. */
        @Deprecated
        public String ConnectionId;
        /** Ignore 'nonce' claim in identity tokens. */
        @Deprecated
        public Boolean IgnoreNonce;
        /**
         * The discovery document URL to read issuer information from. This must be the absolute URL to the JSON OpenId
         * Configuration document and must be accessible from the internet. If you don't know it, try your issuer URL followed by
         * "/.well-known/openid-configuration". For example, if the issuer is https://example.com, try
         * https://example.com/.well-known/openid-configuration
         */
        @Deprecated
        public String IssuerDiscoveryUrl;
        /** Manually specified information for an OpenID Connect issuer. */
        @Deprecated
        public OpenIdIssuerInformation IssuerInformation;
        /** Override the issuer name for user indexing and lookup. */
        @Deprecated
        public String IssuerOverride;
        
    }

    /**
     * Player Shared Secret Keys are used for the call to Client/GetTitlePublicKey, which exchanges the shared secret for an
     * RSA CSP blob to be used to encrypt the payload of account creation requests when that API requires a signature header.
     */
    @Deprecated
    public static class CreatePlayerSharedSecretRequest {
        /** Friendly name for this key */
        @Deprecated
        public String FriendlyName;
        
    }

    @Deprecated
    public static class CreatePlayerSharedSecretResult {
        /** The player shared secret to use when calling Client/GetTitlePublicKey */
        @Deprecated
        public String SecretKey;
        
    }

    /**
     * Statistics are numeric values, with each statistic in the title also generating a leaderboard. The ResetInterval enables
     * automatically resetting leaderboards on a specified interval. Upon reset, the statistic updates to a new version with no
     * values (effectively removing all players from the leaderboard). The previous version's statistic values are also
     * archived for retrieval, if needed (see GetPlayerStatisticVersions). Statistics not created via a call to
     * CreatePlayerStatisticDefinition by default have a VersionChangeInterval of Never, meaning they do not reset on a
     * schedule, but they can be set to do so via a call to UpdatePlayerStatisticDefinition. Once a statistic has been reset
     * (sometimes referred to as versioned or incremented), the now-previous version can still be written to for up a short,
     * pre-defined period (currently 10 seconds), to prevent issues with levels completing around the time of the reset. Also,
     * once reset, the historical statistics for players in the title may be retrieved using the URL specified in the version
     * information (GetPlayerStatisticVersions). The AggregationMethod determines what action is taken when a new statistic
     * value is submitted - always update with the new value (Last), use the highest of the old and new values (Max), use the
     * smallest (Min), or add them together (Sum).
     */
    @Deprecated
    public static class CreatePlayerStatisticDefinitionRequest {
        /** the aggregation method to use in updating the statistic (defaults to last) */
        @Deprecated
        public StatisticAggregationMethod AggregationMethod;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** unique name of the statistic */
        @Deprecated
        public String StatisticName;
        /** interval at which the values of the statistic for all players are reset (resets begin at the next interval boundary) */
        @Deprecated
        public StatisticResetIntervalOption VersionChangeInterval;
        
    }

    @Deprecated
    public static class CreatePlayerStatisticDefinitionResult {
        /** created statistic definition */
        @Deprecated
        public PlayerStatisticDefinition Statistic;
        
    }

    /** Send all the segment details part of CreateSegmentRequest */
    @Deprecated
    public static class CreateSegmentRequest {
        /** Segment model with all of the segment properties data. */
        @Deprecated
        public SegmentModel SegmentModel;
        
    }

    @Deprecated
    public static class CreateSegmentResponse {
        /** Error message. */
        @Deprecated
        public String ErrorMessage;
        /** Segment id. */
        @Deprecated
        public String SegmentId;
        
    }

    @Deprecated
    public static class CreateTaskResult {
        /** ID of the task */
        @Deprecated
        public String TaskId;
        
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

    @Deprecated
    public static class DeleteContentRequest {
        /** Key of the content item to be deleted */
        @Deprecated
        public String Key;
        
    }

    @Deprecated
    public static class DeleteInventoryItemsV2SegmentAction {
        /** The collection id for where the item will be removed from the player inventory */
        @Deprecated
        public String CollectionId;
        /** The id of item to be removed from the player */
        @Deprecated
        public String ItemId;
        /** The stack id for where the item will be removed from the player inventory */
        @Deprecated
        public String StackId;
        
    }

    @Deprecated
    public static class DeleteInventoryItemV2Content {
        /** The collection id for where the item will be removed from the player inventory */
        @Deprecated
        public String CollectionId;
        /** The id of item to be removed from the player */
        @Deprecated
        public String ItemId;
        /** The stack id for where the item will be removed from the player inventory */
        @Deprecated
        public String StackId;
        
    }

    /**
     * Deletes all data associated with the master player account, including data from all titles the player has played, such
     * as statistics, custom data, inventory, purchases, virtual currency balances, characters, group memberships, publisher
     * data, credential data, account linkages, friends list, PlayStream event data, and telemetry event data. Removes the
     * player from all leaderboards and player search indexes. Note, this API queues the player for deletion and returns a
     * receipt immediately. Record the receipt ID for future reference. It may take some time before all player data is fully
     * deleted. Upon completion of the deletion, an email will be sent to the notification email address configured for the
     * title confirming the deletion. Until the player data is fully deleted, attempts to recreate the player with the same
     * user account in the same title will fail with the 'AccountDeleted' error. It is highly recommended to know the impact of
     * the deletion by calling GetPlayedTitleList, before calling this API.
     */
    @Deprecated
    public static class DeleteMasterPlayerAccountRequest {
        /** Developer created string to identify a user without PlayFab ID */
        @Deprecated
        public String MetaData;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class DeleteMasterPlayerAccountResult {
        /**
         * A notification email with this job receipt Id will be sent to the title notification email address when deletion is
         * complete.
         */
        @Deprecated
        public String JobReceiptId;
        /** List of titles from which the player's data will be deleted. */
        @Deprecated
        public ArrayList<String> TitleIds;
        
    }

    /**
     * Deletes any PlayStream or telemetry event associated with the player from PlayFab. Note, this API queues the data for
     * asynchronous deletion. It may take some time before the data is deleted.
     */
    @Deprecated
    public static class DeleteMasterPlayerEventDataRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class DeleteMasterPlayerEventDataResult {
        
    }

    /** This API lets developers delete a membership subscription. */
    @Deprecated
    public static class DeleteMembershipSubscriptionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Id of the membership to apply the override expiration date to. */
        @Deprecated
        public String MembershipId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Id of the subscription that should be deleted from the membership. */
        @Deprecated
        public String SubscriptionId;
        
    }

    @Deprecated
    public static class DeleteMembershipSubscriptionResult {
        
    }

    @Deprecated
    public static class DeleteOpenIdConnectionRequest {
        /** unique name of the connection */
        @Deprecated
        public String ConnectionId;
        
    }

    @Deprecated
    public static class DeletePlayerContent {
        
    }

    /**
     * Deletes all data associated with the player, including statistics, custom data, inventory, purchases, virtual currency
     * balances, characters and shared group memberships. Removes the player from all leaderboards and player search indexes.
     * Does not delete PlayStream event history associated with the player. Does not delete the publisher user account that
     * created the player in the title nor associated data such as username, password, email address, account linkages, or
     * friends list. Note, this API queues the player for deletion and returns immediately. It may take several minutes or more
     * before all player data is fully deleted. Until the player data is fully deleted, attempts to recreate the player with
     * the same user account in the same title will fail with the 'AccountDeleted' error.
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

    @Deprecated
    public static class DeletePlayerSegmentAction {
        
    }

    /**
     * Player Shared Secret Keys are used for the call to Client/GetTitlePublicKey, which exchanges the shared secret for an
     * RSA CSP blob to be used to encrypt the payload of account creation requests when that API requires a signature header.
     */
    @Deprecated
    public static class DeletePlayerSharedSecretRequest {
        /** The shared secret key to delete */
        @Deprecated
        public String SecretKey;
        
    }

    @Deprecated
    public static class DeletePlayerSharedSecretResult {
        
    }

    @Deprecated
    public static class DeletePlayerStatisticSegmentAction {
        /** Statistic name. */
        @Deprecated
        public String StatisticName;
        
    }

    /** Send segment id planning to delete part of DeleteSegmentRequest object */
    @Deprecated
    public static class DeleteSegmentRequest {
        /** Segment id. */
        @Deprecated
        public String SegmentId;
        
    }

    @Deprecated
    public static class DeleteSegmentsResponse {
        /** Error message. */
        @Deprecated
        public String ErrorMessage;
        
    }

    /** This non-reversible operation will permanently delete the requested store. */
    @Deprecated
    public static class DeleteStoreRequest {
        /** catalog version of the store to delete. If null, uses the default catalog. */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** unqiue identifier for the store which is to be deleted */
        @Deprecated
        public String StoreId;
        
    }

    @Deprecated
    public static class DeleteStoreResult {
        
    }

    /**
     * After a task is deleted, for tracking purposes, the task instances belonging to this task will still remain. They will
     * become orphaned and does not belongs to any task. Executions of any in-progress task instances will continue. If the
     * task specified does not exist, the deletion is considered a success.
     */
    @Deprecated
    public static class DeleteTaskRequest {
        /** Specify either the task ID or the name of task to be deleted. */
        @Deprecated
        public NameIdentifier Identifier;
        
    }

    /** Will delete all the title data associated with the given override label. */
    @Deprecated
    public static class DeleteTitleDataOverrideRequest {
        /** Name of the override. */
        @Deprecated
        public String OverrideLabel;
        
    }

    @Deprecated
    public static class DeleteTitleDataOverrideResult {
        
    }

    /**
     * Deletes all data associated with the title, including catalog, virtual currencies, leaderboard statistics, Cloud Script
     * revisions, segment definitions, event rules, tasks, add-ons, secret keys, data encryption keys, and permission policies.
     * Removes the title from its studio and removes all associated developer roles and permissions. Does not delete PlayStream
     * event history associated with the title. Note, this API queues the title for deletion and returns immediately. It may
     * take several hours or more before all title data is fully deleted. All player accounts in the title must be deleted
     * before deleting the title. If any player accounts exist, the API will return a 'TitleContainsUserAccounts' error. Until
     * the title data is fully deleted, attempts to call APIs with the title will fail with the 'TitleDeleted' error.
     */
    @Deprecated
    public static class DeleteTitleRequest {
        
    }

    @Deprecated
    public static class DeleteTitleResult {
        
    }

    @Deprecated
    public static enum EffectType {
        Allow,
        Deny
    }

    @Deprecated
    public static class EmailNotificationSegmentAction {
        /** Email template id. */
        @Deprecated
        public String EmailTemplateId;
        /** Email template name. */
        @Deprecated
        public String EmailTemplateName;
        
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
    public static class ExecuteAzureFunctionSegmentAction {
        /** Azure function. */
        @Deprecated
        public String AzureFunction;
        /** Azure function parameter. */
        @Deprecated
        public Object FunctionParameter;
        /** Generate play stream event. */
        @Deprecated
        public Boolean GenerateFunctionExecutedEvents;
        
    }

    @Deprecated
    public static class ExecuteCloudScriptContent {
        /** Arguments(JSON) to be passed into the cloudscript method */
        @Deprecated
        public String CloudScriptMethodArguments;
        /** Cloudscript method name */
        @Deprecated
        public String CloudScriptMethodName;
        /** Publish cloudscript results as playstream event */
        @Deprecated
        public Boolean PublishResultsToPlayStream;
        
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
    public static class ExecuteCloudScriptSegmentAction {
        /** Cloud script function. */
        @Deprecated
        public String CloudScriptFunction;
        /** Generate play stream event. */
        @Deprecated
        public Boolean CloudScriptPublishResultsToPlayStream;
        /** Cloud script function parameter. */
        @Deprecated
        public Object FunctionParameter;
        /** Cloud script function parameter json text. */
        @Deprecated
        public String FunctionParameterJson;
        
    }

    @Deprecated
    public static class ExecuteFunctionContent {
        /** Arguments(JSON) to be passed into the cloudscript azure function */
        @Deprecated
        public String CloudScriptFunctionArguments;
        /** Cloudscript azure function name */
        @Deprecated
        public String CloudScriptFunctionName;
        /** Publish results from executing the azure function as playstream event */
        @Deprecated
        public Boolean PublishResultsToPlayStream;
        
    }

    /**
     * Exports all data associated with the master player account, including data from all titles the player has played, such
     * as statistics, custom data, inventory, purchases, virtual currency balances, characters, group memberships, publisher
     * data, credential data, account linkages, friends list, PlayStream event data, and telemetry event data. Note, this API
     * queues the player for export and returns a receipt immediately. Record the receipt ID for future reference. It may take
     * some time before the export is available for download. Upon completion of the export, an email containing the URL to
     * download the export dump will be sent to the notification email address configured for the title.
     */
    @Deprecated
    public static class ExportMasterPlayerDataRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class ExportMasterPlayerDataResult {
        /**
         * An email with this job receipt Id containing the export download link will be sent to the title notification email
         * address when the export is complete.
         */
        @Deprecated
        public String JobReceiptId;
        
    }

    /** Request must contain the Segment ID */
    @Deprecated
    public static class ExportPlayersInSegmentRequest {
        /** Unique identifier of the requested segment. */
        @Deprecated
        public String SegmentId;
        
    }

    @Deprecated
    public static class ExportPlayersInSegmentResult {
        /** Unique identifier of the export for the requested Segment. */
        @Deprecated
        public String ExportId;
        /** Unique identifier of the requested Segment. */
        @Deprecated
        public String SegmentId;
        
    }

    @Deprecated
    public static class FirstLoginDateSegmentFilter {
        /** First player login date comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** First player login date. */
        @Deprecated
        public Date LogInDate;
        
    }

    @Deprecated
    public static class FirstLoginTimespanSegmentFilter {
        /** First player login duration comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** First player login duration. */
        @Deprecated
        public Double DurationInMinutes;
        
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
    public static class GetActionsOnPlayersInSegmentTaskInstanceResult {
        /** Parameter of this task instance */
        @Deprecated
        public ActionsOnPlayersInSegmentTaskParameter Parameter;
        /** Status summary of the actions-on-players-in-segment task instance */
        @Deprecated
        public ActionsOnPlayersInSegmentTaskSummary Summary;
        
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

    @Deprecated
    public static class GetCloudScriptRevisionRequest {
        /** Revision number. If left null, defaults to the latest revision */
        @Deprecated
        public Integer Revision;
        /** Version number. If left null, defaults to the latest version */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static class GetCloudScriptRevisionResult {
        /** Time this revision was created */
        @Deprecated
        public Date CreatedAt;
        /** List of Cloud Script files in this revision. */
        @Deprecated
        public ArrayList<CloudScriptFile> Files;
        /** True if this is the currently published revision */
        @Deprecated
        public Boolean IsPublished;
        /** Revision number. */
        @Deprecated
        public Integer Revision;
        /** Version number. */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static class GetCloudScriptTaskInstanceResult {
        /** Parameter of this task instance */
        @Deprecated
        public CloudScriptTaskParameter Parameter;
        /** Status summary of the CloudScript task instance */
        @Deprecated
        public CloudScriptTaskSummary Summary;
        
    }

    @Deprecated
    public static class GetCloudScriptVersionsRequest {
        
    }

    @Deprecated
    public static class GetCloudScriptVersionsResult {
        /** List of versions */
        @Deprecated
        public ArrayList<CloudScriptVersionStatus> Versions;
        
    }

    @Deprecated
    public static class GetContentListRequest {
        /**
         * Limits the response to keys that begin with the specified prefix. You can use prefixes to list contents under a folder,
         * or for a specified version, etc.
         */
        @Deprecated
        public String Prefix;
        
    }

    @Deprecated
    public static class GetContentListResult {
        /** List of content items. */
        @Deprecated
        public ArrayList<ContentInfo> Contents;
        /** Number of content items returned. We currently have a maximum of 1000 items limit. */
        @Deprecated
        public Integer ItemCount;
        /** The total size of listed contents in bytes. */
        @Deprecated
        public Long TotalSize;
        
    }

    @Deprecated
    public static class GetContentUploadUrlRequest {
        /**
         * A standard MIME type describing the format of the contents. The same MIME type has to be set in the header when
         * uploading the content. If not specified, the MIME type is 'binary/octet-stream' by default.
         */
        @Deprecated
        public String ContentType;
        /** Key of the content item to upload, usually formatted as a path, e.g. images/a.png */
        @Deprecated
        public String Key;
        
    }

    @Deprecated
    public static class GetContentUploadUrlResult {
        /**
         * URL for uploading content via HTTP PUT method. The URL requires the 'x-ms-blob-type' header to have the value
         * 'BlockBlob'. The URL will expire in approximately one hour.
         */
        @Deprecated
        public String URL;
        
    }

    /**
     * Gets the download URL for the requested report data (in CSV form). The reports available through this API call are those
     * available in the Game Manager, in the Analytics-&gt;Reports tab.
     */
    @Deprecated
    public static class GetDataReportRequest {
        /** Reporting year (UTC) */
        @Deprecated
        public Integer Day;
        /** Reporting month (UTC) */
        @Deprecated
        public Integer Month;
        /** Report name */
        @Deprecated
        public String ReportName;
        /** Reporting year (UTC) */
        @Deprecated
        public Integer Year;
        
    }

    @Deprecated
    public static class GetDataReportResult {
        /**
         * The URL where the requested report can be downloaded. This can be any PlayFab generated reports. The full list of
         * reports can be found at: https://docs.microsoft.com/en-us/gaming/playfab/features/analytics/reports/quickstart.
         */
        @Deprecated
        public String DownloadUrl;
        
    }

    /** Useful for identifying titles of which the player's data will be deleted by DeleteMasterPlayer. */
    @Deprecated
    public static class GetPlayedTitleListRequest {
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class GetPlayedTitleListResult {
        /** List of titles the player has played */
        @Deprecated
        public ArrayList<String> TitleIds;
        
    }

    /**
     * Gets a player ID from an auth token. The token expires after 30 minutes and cannot be used to look up a player when
     * expired.
     */
    @Deprecated
    public static class GetPlayerIdFromAuthTokenRequest {
        /** The auth token of the player requesting the password reset. */
        @Deprecated
        public String Token;
        /** The type of auth token of the player requesting the password reset. */
        @Deprecated
        public AuthTokenType TokenType;
        
    }

    @Deprecated
    public static class GetPlayerIdFromAuthTokenResult {
        /** The player ID from the token passed in */
        @Deprecated
        public String PlayFabId;
        
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
     * Player Shared Secret Keys are used for the call to Client/GetTitlePublicKey, which exchanges the shared secret for an
     * RSA CSP blob to be used to encrypt the payload of account creation requests when that API requires a signature header.
     */
    @Deprecated
    public static class GetPlayerSharedSecretsRequest {
        
    }

    @Deprecated
    public static class GetPlayerSharedSecretsResult {
        /** The player shared secret to use when calling Client/GetTitlePublicKey */
        @Deprecated
        public ArrayList<SharedSecret> SharedSecrets;
        
    }

    /** Request must contain the ExportId */
    @Deprecated
    public static class GetPlayersInSegmentExportRequest {
        /** Unique identifier of the export for the requested Segment. */
        @Deprecated
        public String ExportId;
        
    }

    @Deprecated
    public static class GetPlayersInSegmentExportResponse {
        /** Url from which the index file can be downloaded. */
        @Deprecated
        public String IndexUrl;
        /** Shows the current status of the export */
        @Deprecated
        public String State;
        
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
    public static class GetPlayerStatisticDefinitionsRequest {
        
    }

    /**
     * Statistics are numeric values, with each statistic in the title also generating a leaderboard. The ResetInterval defines
     * the period of time at which the leaderboard for the statistic will automatically reset. Upon reset, the statistic
     * updates to a new version with no values (effectively removing all players from the leaderboard). The previous version's
     * statistic values are also archived for retrieval, if needed (see GetPlayerStatisticVersions). Statistics not created via
     * a call to CreatePlayerStatisticDefinition by default have a VersionChangeInterval of Never, meaning they do not reset on
     * a schedule, but they can be set to do so via a call to UpdatePlayerStatisticDefinition. Once a statistic has been reset
     * (sometimes referred to as versioned or incremented), the previous version can still be written to for up a short,
     * pre-defined period (currently 10 seconds), to prevent issues with levels completing around the time of the reset. Also,
     * once reset, the historical statistics for players in the title may be retrieved using the URL specified in the version
     * information (GetPlayerStatisticVersions). The AggregationMethod defines what action is taken when a new statistic value
     * is submitted - always update with the new value (Last), use the highest of the old and new values (Max), use the
     * smallest (Min), or add them together (Sum).
     */
    @Deprecated
    public static class GetPlayerStatisticDefinitionsResult {
        /** the player statistic definitions for the title */
        @Deprecated
        public ArrayList<PlayerStatisticDefinition> Statistics;
        
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

    /**
     * Statistics are numeric values, with each statistic in the title also generating a leaderboard. The information returned
     * in the results defines the state of a specific version of a statistic, including when it was or will become the
     * currently active version, when it will (or did) become a previous version, and its archival state if it is no longer the
     * active version. For a statistic which has been reset, once the archival status is Complete, the full set of statistics
     * for all players in the leaderboard for that version may be retrieved via the ArchiveDownloadUrl. Statistics which have
     * not been reset (incremented/versioned) will only have a single version which is not scheduled to reset.
     */
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

    /** Views the requested policy. Today, the only supported policy is 'ApiPolicy'. */
    @Deprecated
    public static class GetPolicyRequest {
        /** The name of the policy to read. Only supported name is 'ApiPolicy'. */
        @Deprecated
        public String PolicyName;
        
    }

    @Deprecated
    public static class GetPolicyResponse {
        /** The name of the policy read. */
        @Deprecated
        public String PolicyName;
        /** Policy version. */
        @Deprecated
        public Integer PolicyVersion;
        /** The statements in the requested policy. */
        @Deprecated
        public ArrayList<PermissionStatement> Statements;
        
    }

    /**
     * This API is designed to return publisher-specific values which can be read, but not written to, by the client. This data
     * is shared across all titles assigned to a particular publisher, and can be used for cross-game coordination. Only titles
     * assigned to a publisher can use this API. For more information email helloplayfab@microsoft.com. This AdminAPI call for
     * getting title data guarantees no delay in between update and retrieval of newly set data.
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
        /** catalog version to fetch tables from. Use default catalog version if null */
        @Deprecated
        public String CatalogVersion;
        
    }

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

    /** Given input segment ids, return list of segments. */
    @Deprecated
    public static class GetSegmentsRequest {
        /** Segment ids to filter title segments. */
        @Deprecated
        public ArrayList<String> SegmentIds;
        
    }

    @Deprecated
    public static class GetSegmentsResponse {
        /** Error message. */
        @Deprecated
        public String ErrorMessage;
        /** List of title segments. */
        @Deprecated
        public ArrayList<SegmentModel> Segments;
        
    }

    /**
     * A store contains an array of references to items defined in the catalog, along with the prices for the item, in both
     * real world and virtual currencies. These prices act as an override to any prices defined in the catalog. In this way,
     * the base definitions of the items may be defined in the catalog, with all associated properties, while the pricing can
     * be set for each store, as needed. This allows for subsets of goods to be defined for different purposes (in order to
     * simplify showing some, but not all catalog items to users, based upon different characteristics), along with unique
     * prices. Note that all prices defined in the catalog and store definitions for the item are considered valid, and that a
     * compromised client can be made to send a request for an item based upon any of these definitions. If no price is
     * specified in the store for an item, the price set in the catalog should be displayed to the user.
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
     * The result includes detail information that's specific to a CloudScript task. Only CloudScript tasks configured as "Run
     * Cloud Script function once" will be retrieved. To get a list of task instances by task, status, or time range, use
     * GetTaskInstances.
     */
    @Deprecated
    public static class GetTaskInstanceRequest {
        /** ID of the requested task instance. */
        @Deprecated
        public String TaskInstanceId;
        
    }

    /**
     * Only the most recent 100 task instances are returned, ordered by start time descending. The results are generic basic
     * information for task instances. To get detail information specific to each task type, use Get*TaskInstance based on its
     * corresponding task type.
     */
    @Deprecated
    public static class GetTaskInstancesRequest {
        /** Optional range-from filter for task instances' StartedAt timestamp. */
        @Deprecated
        public Date StartedAtRangeFrom;
        /** Optional range-to filter for task instances' StartedAt timestamp. */
        @Deprecated
        public Date StartedAtRangeTo;
        /** Optional filter for task instances that are of a specific status. */
        @Deprecated
        public TaskInstanceStatus StatusFilter;
        /**
         * Name or ID of the task whose instances are being queried. If not specified, return all task instances that satisfy
         * conditions set by other filters.
         */
        @Deprecated
        public NameIdentifier TaskIdentifier;
        
    }

    @Deprecated
    public static class GetTaskInstancesResult {
        /**
         * Basic status summaries of the queried task instances. Empty If no task instances meets the filter criteria. To get
         * detailed status summary, use Get*TaskInstance API according to task type (e.g.
         * GetActionsOnPlayersInSegmentTaskInstance).
         */
        @Deprecated
        public ArrayList<TaskInstanceBasicSummary> Summaries;
        
    }

    @Deprecated
    public static class GetTasksRequest {
        /** Provide either the task ID or the task name to get a specific task. If not specified, return all defined tasks. */
        @Deprecated
        public NameIdentifier Identifier;
        
    }

    @Deprecated
    public static class GetTasksResult {
        /** Result tasks. Empty if there is no task found. */
        @Deprecated
        public ArrayList<ScheduledTask> Tasks;
        
    }

    /**
     * This API method is designed to return title specific values which can be read by the client. For example, a developer
     * could choose to store values which modify the user experience, such as enemy spawn rates, weapon strengths, movement
     * speeds, etc. This allows a developer to update the title without the need to create, test, and ship a new build. If an
     * override label is specified in the request, the overrides are applied automatically and returned with the title data.
     * Note that due to caching, there may up to a minute delay in between updating title data and a query returning the newest
     * value.
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
     * user's current inventory, and so will not be not included. There can be a delay of up to a half a second for inventory
     * changes to be reflected in the GetUserInventory API response.
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

    @Deprecated
    public static class GrantItemContent {
        /** The catalog version of the item to be granted to the player */
        @Deprecated
        public String CatalogVersion;
        /** The id of item to be granted to the player */
        @Deprecated
        public String ItemId;
        /** Quantity of the item to be granted to a player */
        @Deprecated
        public Integer ItemQuantity;
        
    }

    @Deprecated
    public static class GrantItemSegmentAction {
        /** Item catalog id. */
        @Deprecated
        public String CatelogId;
        /** Item id. */
        @Deprecated
        public String ItemId;
        /** Item quantity. */
        @Deprecated
        public Long Quantity;
        
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
    public static class GrantVirtualCurrencyContent {
        /** Amount of currency to be granted to a player */
        @Deprecated
        public Integer CurrencyAmount;
        /** Code of the currency to be granted to a player */
        @Deprecated
        public String CurrencyCode;
        
    }

    @Deprecated
    public static class GrantVirtualCurrencySegmentAction {
        /** Virtual currency amount. */
        @Deprecated
        public Integer Amount;
        /** Virtual currency code. */
        @Deprecated
        public String CurrencyCode;
        
    }

    /**
     * This operation will increment the global counter for the number of these items available. This number cannot be
     * decremented, except by actual grants.
     */
    @Deprecated
    public static class IncrementLimitedEditionItemAvailabilityRequest {
        /** Amount to increase availability by. */
        @Deprecated
        public Integer Amount;
        /** Which catalog is being updated. If null, uses the default catalog. */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The item which needs more availability. */
        @Deprecated
        public String ItemId;
        
    }

    @Deprecated
    public static class IncrementLimitedEditionItemAvailabilityResult {
        
    }

    @Deprecated
    public static class IncrementPlayerStatisticContent {
        /** Amount(in whole number) to increase the player statistic by */
        @Deprecated
        public Integer StatisticChangeBy;
        /** Name of the player statistic to be incremented */
        @Deprecated
        public String StatisticName;
        
    }

    @Deprecated
    public static class IncrementPlayerStatisticSegmentAction {
        /** Increment value. */
        @Deprecated
        public Integer IncrementValue;
        /** Statistic name. */
        @Deprecated
        public String StatisticName;
        
    }

    /**
     * Statistics are numeric values, with each statistic in the title also generating a leaderboard. When this call is made on
     * a given statistic, this forces a reset of that statistic. Upon reset, the statistic updates to a new version with no
     * values (effectively removing all players from the leaderboard). The previous version's statistic values are also
     * archived for retrieval, if needed (see GetPlayerStatisticVersions). Statistics not created via a call to
     * CreatePlayerStatisticDefinition by default have a VersionChangeInterval of Never, meaning they do not reset on a
     * schedule, but they can be set to do so via a call to UpdatePlayerStatisticDefinition. Once a statistic has been reset
     * (sometimes referred to as versioned or incremented), the now-previous version can still be written to for up a short,
     * pre-defined period (currently 10 seconds), to prevent issues with levels completing around the time of the reset. Also,
     * once reset, the historical statistics for players in the title may be retrieved using the URL specified in the version
     * information (GetPlayerStatisticVersions).
     */
    @Deprecated
    public static class IncrementPlayerStatisticVersionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** unique name of the statistic */
        @Deprecated
        public String StatisticName;
        
    }

    @Deprecated
    public static class IncrementPlayerStatisticVersionResult {
        /** version change history of the statistic */
        @Deprecated
        public PlayerStatisticVersion StatisticVersion;
        
    }

    @Deprecated
    public static class InsightsScalingTaskParameter {
        /** Insights Performance Level to scale to. */
        @Deprecated
        public Integer Level;
        
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
    public static class LastLoginDateSegmentFilter {
        /** Last player login date comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** Last player login date. */
        @Deprecated
        public Date LogInDate;
        
    }

    @Deprecated
    public static class LastLoginTimespanSegmentFilter {
        /** Last player login duration comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** Last player login duration. */
        @Deprecated
        public Double DurationInMinutes;
        
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
    public static class LinkedUserAccountHasEmailSegmentFilter {
        /** Login provider comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** Login provider. */
        @Deprecated
        public SegmentLoginIdentityProvider LoginProvider;
        
    }

    @Deprecated
    public static class LinkedUserAccountSegmentFilter {
        /** Login provider. */
        @Deprecated
        public SegmentLoginIdentityProvider LoginProvider;
        
    }

    @Deprecated
    public static class ListOpenIdConnectionRequest {
        
    }

    @Deprecated
    public static class ListOpenIdConnectionResponse {
        /** The list of Open ID Connections */
        @Deprecated
        public ArrayList<OpenIdConnection> Connections;
        
    }

    @Deprecated
    public static class ListVirtualCurrencyTypesRequest {
        
    }

    @Deprecated
    public static class ListVirtualCurrencyTypesResult {
        /** List of virtual currency names defined for this title */
        @Deprecated
        @Unordered
        public ArrayList<VirtualCurrencyData> VirtualCurrencies;
        
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
    public static class LocationSegmentFilter {
        /** Segment country code. */
        @Deprecated
        public SegmentCountryCode CountryCode;
        
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

    /**
     * This API allows for access to details regarding a user in the PlayFab service, usually for purposes of customer support.
     * Note that data returned may be Personally Identifying Information (PII), such as email address, and so care should be
     * taken in how this data is stored and managed. Since this call will always return the relevant information for users who
     * have accessed the title, the recommendation is to not store this data locally.
     */
    @Deprecated
    public static class LookupUserAccountInfoRequest {
        /** User email address attached to their account */
        @Deprecated
        public String Email;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /** Title specific username to match against existing user accounts */
        @Deprecated
        public String TitleDisplayName;
        /** PlayFab username for the account (3-20 characters) */
        @Deprecated
        public String Username;
        
    }

    @Deprecated
    public static class LookupUserAccountInfoResult {
        /** User info for the user matching the request */
        @Deprecated
        public UserAccountInfo UserInfo;
        
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
    public static class OpenIdConnection {
        /** The client ID given by the ID provider. */
        @Deprecated
        public String ClientId;
        /** The client secret given by the ID provider. */
        @Deprecated
        public String ClientSecret;
        /** A name for the connection to identify it within the title. */
        @Deprecated
        public String ConnectionId;
        /** Shows if data about the connection will be loaded from the issuer's discovery document */
        @Deprecated
        public Boolean DiscoverConfiguration;
        /** Ignore 'nonce' claim in identity tokens. */
        @Deprecated
        public Boolean IgnoreNonce;
        /** Information for an OpenID Connect provider. */
        @Deprecated
        public OpenIdIssuerInformation IssuerInformation;
        /** Override the issuer name for user indexing and lookup. */
        @Deprecated
        public String IssuerOverride;
        
    }

    @Deprecated
    public static class OpenIdIssuerInformation {
        /** Authorization endpoint URL to direct users to for signin. */
        @Deprecated
        public String AuthorizationUrl;
        /** The URL of the issuer of the tokens. This must match the exact URL of the issuer field in tokens. */
        @Deprecated
        public String Issuer;
        /** JSON Web Key Set for validating the signature of tokens. */
        @Deprecated
        public Object JsonWebKeySet;
        /** Token endpoint URL for code verification. */
        @Deprecated
        public String TokenUrl;
        
    }

    @Deprecated
    public static class PermissionStatement {
        /** The action this statement effects. The only supported action is 'Execute'. */
        @Deprecated
        public String Action;
        /** Additional conditions to be applied for API Resources. */
        @Deprecated
        public ApiCondition ApiConditions;
        /** A comment about the statement. Intended solely for bookkeeping and debugging. */
        @Deprecated
        public String Comment;
        /** The effect this statement will have. It could be either Allow or Deny */
        @Deprecated
        public EffectType Effect;
        /** The principal this statement will effect. The only supported principal is '*'. */
        @Deprecated
        public String Principal;
        /**
         * The resource this statements effects. The only supported resources look like 'pfrn:api--*' for all apis, or
         * 'pfrn:api--/Client/ConfirmPurchase' for specific apis.
         */
        @Deprecated
        public String Resource;
        
    }

    @Deprecated
    public static class PlayerChurnPredictionSegmentFilter {
        /** Comparison */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** RiskLevel */
        @Deprecated
        public ChurnRiskLevel RiskLevel;
        
    }

    @Deprecated
    public static class PlayerChurnPredictionTimeSegmentFilter {
        /** Comparison */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** DurationInDays */
        @Deprecated
        public Double DurationInDays;
        
    }

    @Deprecated
    public static class PlayerChurnPreviousPredictionSegmentFilter {
        /** Comparison */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** RiskLevel */
        @Deprecated
        public ChurnRiskLevel RiskLevel;
        
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
    public static class PlayerStatisticDefinition {
        /** the aggregation method to use in updating the statistic (defaults to last) */
        @Deprecated
        public StatisticAggregationMethod AggregationMethod;
        /** current active version of the statistic, incremented each time the statistic resets */
        @Deprecated
        public Long CurrentVersion;
        /** unique name of the statistic */
        @Deprecated
        public String StatisticName;
        /** interval at which the values of the statistic for all players are reset automatically */
        @Deprecated
        public StatisticResetIntervalOption VersionChangeInterval;
        
    }

    @Deprecated
    public static class PlayerStatisticVersion {
        /** time when the statistic version became active */
        @Deprecated
        public Date ActivationTime;
        /** URL for the downloadable archive of player statistic values, if available */
        @Deprecated
        public String ArchiveDownloadUrl;
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
        /** status of the statistic version */
        @Deprecated
        public StatisticVersionStatus Status;
        /** version of the statistic */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class PushNotificationContent {
        /** Text of message to send. */
        @Deprecated
        public String Message;
        /** Id of the push notification template. */
        @Deprecated
        public String PushNotificationTemplateId;
        /** Subject of message to send (may not be displayed in all platforms) */
        @Deprecated
        public String Subject;
        
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
    public static class PushNotificationSegmentAction {
        /** Push notification template id. */
        @Deprecated
        public String PushNotificationTemplateId;
        
    }

    @Deprecated
    public static class PushNotificationSegmentFilter {
        /** Push notification device platform. */
        @Deprecated
        public SegmentPushNotificationDevicePlatform PushNotificationDevicePlatform;
        
    }

    @Deprecated
    public static enum PushSetupPlatform {
        GCM,
        APNS,
        APNS_SANDBOX
    }

    @Deprecated
    public static class RandomResultTable {
        /** Child nodes that indicate what kind of drop table item this actually is. */
        @Deprecated
        public ArrayList<ResultTableNode> Nodes;
        /** Unique name for this drop table */
        @Deprecated
        public String TableId;
        
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

    @Deprecated
    public static class RefundPurchaseRequest {
        /** Unique order ID for the purchase in question. */
        @Deprecated
        public String OrderId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /**
         * The Reason parameter should correspond with the payment providers reason field, if they require one such as Facebook. In
         * the case of Facebook this must match one of their refund or dispute resolution enums (See:
         * https://developers.facebook.com/docs/payments/implementation-guide/handling-disputes-refunds)
         */
        @Deprecated
        public String Reason;
        
    }

    @Deprecated
    public static class RefundPurchaseResponse {
        /** The order's updated purchase status. */
        @Deprecated
        public String PurchaseStatus;
        
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

    /**
     * Virtual currencies to be removed cannot have entries in any catalog nor store for the title. Note that this operation
     * will not remove player balances for the removed currencies; if a deleted currency is recreated at any point, user
     * balances will be in an undefined state.
     */
    @Deprecated
    public static class RemoveVirtualCurrencyTypesRequest {
        /** List of virtual currencies to delete */
        @Deprecated
        public ArrayList<VirtualCurrencyData> VirtualCurrencies;
        
    }

    /**
     * Note that this action cannot be un-done. All statistics for this character will be deleted, removing the user from all
     * leaderboards for the game.
     */
    @Deprecated
    public static class ResetCharacterStatisticsRequest {
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
    public static class ResetCharacterStatisticsResult {
        
    }

    /**
     * Resets a player's password taking in a new password based and validating the user based off of a token sent to the
     * playerto their email. The token expires after 30 minutes.
     */
    @Deprecated
    public static class ResetPasswordRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The new password for the player. */
        @Deprecated
        public String Password;
        /** The token of the player requesting the password reset. */
        @Deprecated
        public String Token;
        
    }

    @Deprecated
    public static class ResetPasswordResult {
        
    }

    /**
     * Note that this action cannot be un-done. All statistics for this user will be deleted, removing the user from all
     * leaderboards for the game.
     */
    @Deprecated
    public static class ResetUserStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class ResetUserStatisticsResult {
        
    }

    @Deprecated
    public static enum ResolutionOutcome {
        Revoke,
        Reinstate,
        Manual
    }

    @Deprecated
    public static class ResolvePurchaseDisputeRequest {
        /** Unique order ID for the purchase in question. */
        @Deprecated
        public String OrderId;
        /**
         * Enum for the desired purchase result state after notifying the payment provider. Valid values are Revoke, Reinstate and
         * Manual. Manual will cause no change to the order state.
         */
        @Deprecated
        public ResolutionOutcome Outcome;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        /**
         * The Reason parameter should correspond with the payment providers reason field, if they require one such as Facebook. In
         * the case of Facebook this must match one of their refund or dispute resolution enums (See:
         * https://developers.facebook.com/docs/payments/implementation-guide/handling-disputes-refunds)
         */
        @Deprecated
        public String Reason;
        
    }

    @Deprecated
    public static class ResolvePurchaseDisputeResponse {
        /** The order's updated purchase status. */
        @Deprecated
        public String PurchaseStatus;
        
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

    /** The returned task instance ID can be used to query for task execution status. */
    @Deprecated
    public static class RunTaskRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Provide either the task ID or the task name to run a task. */
        @Deprecated
        public NameIdentifier Identifier;
        
    }

    @Deprecated
    public static class RunTaskResult {
        /**
         * ID of the task instance that is started. This can be used in Get*TaskInstance (e.g. GetCloudScriptTaskInstance) API call
         * to retrieve status for the task instance.
         */
        @Deprecated
        public String TaskInstanceId;
        
    }

    @Deprecated
    public static class ScheduledTask {
        /** Description the task */
        @Deprecated
        public String Description;
        /** Whether the schedule is active. Inactive schedule will not trigger task execution. */
        @Deprecated
        public Boolean IsActive;
        /** UTC time of last run */
        @Deprecated
        public Date LastRunTime;
        /** Name of the task. This is a unique identifier for tasks in the title. */
        @Deprecated
        public String Name;
        /** UTC time of next run */
        @Deprecated
        public Date NextRunTime;
        /**
         * Task parameter. Different types of task have different parameter structure. See each task type's create API
         * documentation for the details.
         */
        @Deprecated
        public Object Parameter;
        /** Cron expression for the run schedule of the task. The expression should be in UTC. */
        @Deprecated
        public String Schedule;
        /** ID of the task */
        @Deprecated
        public String TaskId;
        /** Task type. */
        @Deprecated
        public ScheduledTaskType Type;
        
    }

    @Deprecated
    public static enum ScheduledTaskType {
        CloudScript,
        ActionsOnPlayerSegment,
        CloudScriptAzureFunctions,
        InsightsScheduledScaling
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

    @Deprecated
    public static class SegmentAndDefinition {
        /** Filter property for ad campaign filter. */
        @Deprecated
        public AdCampaignSegmentFilter AdCampaignFilter;
        /** property for all player filter. */
        @Deprecated
        public AllPlayersSegmentFilter AllPlayersFilter;
        /** Filter property for player churn risk level. */
        @Deprecated
        public ChurnPredictionSegmentFilter ChurnPredictionFilter;
        /** Filter property for first login date. */
        @Deprecated
        public FirstLoginDateSegmentFilter FirstLoginDateFilter;
        /** Filter property for first login timespan. */
        @Deprecated
        public FirstLoginTimespanSegmentFilter FirstLoginFilter;
        /** Filter property for last login date. */
        @Deprecated
        public LastLoginDateSegmentFilter LastLoginDateFilter;
        /** Filter property for last login timespan. */
        @Deprecated
        public LastLoginTimespanSegmentFilter LastLoginFilter;
        /** Filter property for linked in user account. */
        @Deprecated
        public LinkedUserAccountSegmentFilter LinkedUserAccountFilter;
        /** Filter property for linked in user account has email. */
        @Deprecated
        public LinkedUserAccountHasEmailSegmentFilter LinkedUserAccountHasEmailFilter;
        /** Filter property for location. */
        @Deprecated
        public LocationSegmentFilter LocationFilter;
        /** Filter property for current player churn value. */
        @Deprecated
        public PlayerChurnPredictionSegmentFilter PlayerChurnPredictionFilter;
        /** Filter property for player churn timespan. */
        @Deprecated
        public PlayerChurnPredictionTimeSegmentFilter PlayerChurnPredictionTimeFilter;
        /** Filter property for previous player churn value. */
        @Deprecated
        public PlayerChurnPreviousPredictionSegmentFilter PlayerChurnPreviousPredictionFilter;
        /** Filter property for push notification. */
        @Deprecated
        public PushNotificationSegmentFilter PushNotificationFilter;
        /** Filter property for statistics. */
        @Deprecated
        public StatisticSegmentFilter StatisticFilter;
        /** Filter property for tags. */
        @Deprecated
        public TagSegmentFilter TagFilter;
        /** Filter property for total value to date in USD. */
        @Deprecated
        public TotalValueToDateInUSDSegmentFilter TotalValueToDateInUSDFilter;
        /** Filter property for user origination. */
        @Deprecated
        public UserOriginationSegmentFilter UserOriginationFilter;
        /** Filter property for value to date. */
        @Deprecated
        public ValueToDateSegmentFilter ValueToDateFilter;
        /** Filter property for virtual currency. */
        @Deprecated
        public VirtualCurrencyBalanceSegmentFilter VirtualCurrencyBalanceFilter;
        
    }

    @Deprecated
    public static enum SegmentCountryCode {
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

    @Deprecated
    public static enum SegmentCurrency {
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

    @Deprecated
    public static enum SegmentFilterComparison {
        GreaterThan,
        LessThan,
        EqualTo,
        NotEqualTo,
        GreaterThanOrEqual,
        LessThanOrEqual,
        Exists,
        Contains,
        NotContains
    }

    @Deprecated
    public static enum SegmentLoginIdentityProvider {
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
        GooglePlayGames
    }

    @Deprecated
    public static class SegmentModel {
        /** Segment description. */
        @Deprecated
        public String Description;
        /** Segment actions for current entered segment players. */
        @Deprecated
        public ArrayList<SegmentTrigger> EnteredSegmentActions;
        /** Segment last updated date time. */
        @Deprecated
        public Date LastUpdateTime;
        /** Segment actions for current left segment players. */
        @Deprecated
        public ArrayList<SegmentTrigger> LeftSegmentActions;
        /** Segment name. */
        @Deprecated
        public String Name;
        /** Segment id in hex. */
        @Deprecated
        public String SegmentId;
        /** Segment or definitions. This includes segment and definitions and filters. */
        @Deprecated
        public ArrayList<SegmentOrDefinition> SegmentOrDefinitions;
        
    }

    @Deprecated
    public static class SegmentOrDefinition {
        /** List of segment and definitions. */
        @Deprecated
        public ArrayList<SegmentAndDefinition> SegmentAndDefinitions;
        
    }

    @Deprecated
    public static enum SegmentPushNotificationDevicePlatform {
        ApplePushNotificationService,
        GoogleCloudMessaging
    }

    @Deprecated
    public static class SegmentTrigger {
        /** Add inventory item v2 segment trigger action. */
        @Deprecated
        public AddInventoryItemsV2SegmentAction AddInventoryItemsV2Action;
        /** Ban player segment trigger action. */
        @Deprecated
        public BanPlayerSegmentAction BanPlayerAction;
        /** Delete inventory item v2 segment trigger action. */
        @Deprecated
        public DeleteInventoryItemsV2SegmentAction DeleteInventoryItemsV2Action;
        /** Delete player segment trigger action. */
        @Deprecated
        public DeletePlayerSegmentAction DeletePlayerAction;
        /** Delete player statistic segment trigger action. */
        @Deprecated
        public DeletePlayerStatisticSegmentAction DeletePlayerStatisticAction;
        /** Email notification segment trigger action. */
        @Deprecated
        public EmailNotificationSegmentAction EmailNotificationAction;
        /** Execute azure function segment trigger action. */
        @Deprecated
        public ExecuteAzureFunctionSegmentAction ExecuteAzureFunctionAction;
        /** Execute cloud script segment trigger action. */
        @Deprecated
        public ExecuteCloudScriptSegmentAction ExecuteCloudScriptAction;
        /** Grant item segment trigger action. */
        @Deprecated
        public GrantItemSegmentAction GrantItemAction;
        /** Grant virtual currency segment trigger action. */
        @Deprecated
        public GrantVirtualCurrencySegmentAction GrantVirtualCurrencyAction;
        /** Increment player statistic segment trigger action. */
        @Deprecated
        public IncrementPlayerStatisticSegmentAction IncrementPlayerStatisticAction;
        /** Push notification segment trigger action. */
        @Deprecated
        public PushNotificationSegmentAction PushNotificationAction;
        /** Subtract inventory item v2 segment trigger action. */
        @Deprecated
        public SubtractInventoryItemsV2SegmentAction SubtractInventoryItemsV2Action;
        
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
        
    }

    @Deprecated
    public static class SendAccountRecoveryEmailResult {
        
    }

    @Deprecated
    public static class SendEmailContent {
        /** The email template id of the email template to send. */
        @Deprecated
        public String EmailTemplateId;
        
    }

    /** This API lets developers set overrides for membership expirations, independent of any subscriptions setting it. */
    @Deprecated
    public static class SetMembershipOverrideRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Expiration time for the membership in DateTime format, will override any subscription expirations. */
        @Deprecated
        public Date ExpirationTime;
        /** Id of the membership to apply the override expiration date to. */
        @Deprecated
        public String MembershipId;
        /** Unique PlayFab assigned ID of the user on whom the operation will be performed. */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class SetMembershipOverrideResult {
        
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

    @Deprecated
    public static class SetPublishedRevisionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Revision to make the current published revision */
        @Deprecated
        public Integer Revision;
        /** Version number */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static class SetPublishedRevisionResult {
        
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
     * Will set the given key values in the specified override or the primary title data based on whether the label is provided
     * or not.
     */
    @Deprecated
    public static class SetTitleDataAndOverridesRequest {
        /**
         * List of titleData key-value pairs to set/delete. Use an empty value to delete an existing key; use a non-empty value to
         * create/update a key.
         */
        @Deprecated
        public ArrayList<TitleDataKeyValue> KeyValues;
        /** Name of the override. */
        @Deprecated
        public String OverrideLabel;
        
    }

    @Deprecated
    public static class SetTitleDataAndOverridesResult {
        
    }

    /**
     * This operation is additive. If a Key does not exist in the current dataset, it will be added with the specified Value.
     * If it already exists, the Value for that key will be overwritten with the new Value.
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

    /**
     * When using the Apple Push Notification service (APNS) or the development version (APNS_SANDBOX), the APNS Private Key
     * should be used as the Credential in this call. With Google Cloud Messaging (GCM), the Android API Key should be used.
     * The current ARN (if one exists) can be overwritten by setting the OverwriteOldARN boolean to true.
     */
    @Deprecated
    public static class SetupPushNotificationRequest {
        /** Credential is the Private Key for APNS/APNS_SANDBOX, and the API Key for GCM */
        @Deprecated
        public String Credential;
        /** for APNS, this is the PlatformPrincipal (SSL Certificate) */
        @Deprecated
        public String Key;
        /** This field is deprecated and any usage of this will cause the API to fail. */
        @Deprecated
        public String Name;
        /**
         * replace any existing ARN with the newly generated one. If this is set to false, an error will be returned if
         * notifications have already setup for this platform.
         */
        @Deprecated
        public Boolean OverwriteOldARN;
        /**
         * supported notification platforms are Apple Push Notification Service (APNS and APNS_SANDBOX) for iOS and Google Cloud
         * Messaging (GCM) for Android
         */
        @Deprecated
        public PushSetupPlatform Platform;
        
    }

    @Deprecated
    public static class SetupPushNotificationResult {
        /** Amazon Resource Name for the created notification topic. */
        @Deprecated
        public String ARN;
        
    }

    @Deprecated
    public static class SharedSecret {
        /** Flag to indicate if this key is disabled */
        @Deprecated
        public Boolean Disabled;
        /** Friendly name for this key */
        @Deprecated
        public String FriendlyName;
        /** The player shared secret to use when calling Client/GetTitlePublicKey */
        @Deprecated
        public String SecretKey;
        
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
    public static enum StatisticAggregationMethod {
        Last,
        Min,
        Max,
        Sum
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
    public static enum StatisticResetIntervalOption {
        Never,
        Hour,
        Day,
        Week,
        Month
    }

    @Deprecated
    public static class StatisticSegmentFilter {
        /** Statistic filter comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** Statistic filter value. */
        @Deprecated
        public String FilterValue;
        /** Statistic name. */
        @Deprecated
        public String Name;
        /** Use current version of statistic? */
        @Deprecated
        public Boolean UseCurrentVersion;
        /** Statistic version. */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static enum StatisticVersionArchivalStatus {
        NotScheduled,
        Scheduled,
        Queued,
        InProgress,
        Complete
    }

    @Deprecated
    public static enum StatisticVersionStatus {
        Active,
        SnapshotPending,
        Snapshot,
        ArchivalPending,
        Archived
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
    public static class SubtractInventoryItemsV2SegmentAction {
        /** Amount of the item to removed from the player */
        @Deprecated
        public Integer Amount;
        /** The collection id for where the item will be removed from the player inventory */
        @Deprecated
        public String CollectionId;
        /** The duration in seconds to be removed from the subscription in the players inventory */
        @Deprecated
        public Integer DurationInSeconds;
        /** The id of item to be removed from the player */
        @Deprecated
        public String ItemId;
        /** The stack id for where the item will be removed from the player inventory */
        @Deprecated
        public String StackId;
        
    }

    @Deprecated
    public static class SubtractInventoryItemV2Content {
        /** Amount of the item to removed from the player */
        @Deprecated
        public Integer Amount;
        /** The collection id for where the item will be removed from the player inventory */
        @Deprecated
        public String CollectionId;
        /** The duration in seconds to be removed from the subscription in the players inventory */
        @Deprecated
        public Integer DurationInSeconds;
        /** The id of item to be removed from the player */
        @Deprecated
        public String ItemId;
        /** The stack id for where the item will be removed from the player inventory */
        @Deprecated
        public String StackId;
        
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
    public static class TagSegmentFilter {
        /** Tag comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** Tag value. */
        @Deprecated
        public String TagValue;
        
    }

    @Deprecated
    public static class TaskInstanceBasicSummary {
        /** UTC timestamp when the task completed. */
        @Deprecated
        public Date CompletedAt;
        /** Error message for last processing attempt, if an error occured. */
        @Deprecated
        public String ErrorMessage;
        /** Estimated time remaining in seconds. */
        @Deprecated
        public Double EstimatedSecondsRemaining;
        /** Progress represented as percentage. */
        @Deprecated
        public Double PercentComplete;
        /** If manually scheduled, ID of user who scheduled the task. */
        @Deprecated
        public String ScheduledByUserId;
        /** UTC timestamp when the task started. */
        @Deprecated
        public Date StartedAt;
        /** Current status of the task instance. */
        @Deprecated
        public TaskInstanceStatus Status;
        /** Identifier of the task this instance belongs to. */
        @Deprecated
        public NameIdentifier TaskIdentifier;
        /** ID of the task instance. */
        @Deprecated
        public String TaskInstanceId;
        /** Type of the task. */
        @Deprecated
        public ScheduledTaskType Type;
        
    }

    @Deprecated
    public static enum TaskInstanceStatus {
        Succeeded,
        Starting,
        InProgress,
        Failed,
        Aborted,
        Stalled
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
    public static class TitleDataKeyValue {
        /**
         * Key we want to set a value on (note, this is additive - will only replace an existing key's value if they are the same
         * name.) Keys are trimmed of whitespace. Keys may not begin with the '!' character.
         */
        @Deprecated
        public String Key;
        /** New value to set. Set to null to remove a value */
        @Deprecated
        public String Value;
        
    }

    @Deprecated
    public static class TotalValueToDateInUSDSegmentFilter {
        /** Total value to date USD amount. */
        @Deprecated
        public String Amount;
        /** Total value to date USD comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        
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
     * When used for SetCatalogItems, this operation is not additive. Using it will cause the indicated catalog version to be
     * created from scratch. If there is an existing catalog with the version number in question, it will be deleted and
     * replaced with only the items specified in this call. When used for UpdateCatalogItems, this operation is additive. Items
     * with ItemId values not currently in the catalog will be added, while those with ItemId values matching items currently
     * in the catalog will overwrite those items with the given values.
     */
    @Deprecated
    public static class UpdateCatalogItemsRequest {
        /**
         * Array of catalog items to be submitted. Note that while CatalogItem has a parameter for CatalogVersion, it is not
         * required and ignored in this call.
         */
        @Deprecated
        public ArrayList<CatalogItem> Catalog;
        /** Which catalog is being updated. If null, uses the default catalog. */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Should this catalog be set as the default catalog. Defaults to true. If there is currently no default catalog, this will
         * always set it.
         */
        @Deprecated
        public Boolean SetAsDefaultCatalog;
        
    }

    @Deprecated
    public static class UpdateCatalogItemsResult {
        
    }

    @Deprecated
    public static class UpdateCloudScriptRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** PlayFab user ID of the developer initiating the request. */
        @Deprecated
        public String DeveloperPlayFabId;
        /** List of Cloud Script files to upload to create the new revision. Must have at least one file. */
        @Deprecated
        public ArrayList<CloudScriptFile> Files;
        /** Immediately publish the new revision */
        @Deprecated
        public Boolean Publish;
        
    }

    @Deprecated
    public static class UpdateCloudScriptResult {
        /** New revision number created */
        @Deprecated
        public Integer Revision;
        /** Cloud Script version updated */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static class UpdateOpenIdConnectionRequest {
        /** The client ID given by the ID provider. */
        @Deprecated
        public String ClientId;
        /** The client secret given by the ID provider. */
        @Deprecated
        public String ClientSecret;
        /** A name for the connection that identifies it within the title. */
        @Deprecated
        public String ConnectionId;
        /** Ignore 'nonce' claim in identity tokens. */
        @Deprecated
        public Boolean IgnoreNonce;
        /** The issuer URL or discovery document URL to read issuer information from */
        @Deprecated
        public String IssuerDiscoveryUrl;
        /** Manually specified information for an OpenID Connect issuer. */
        @Deprecated
        public OpenIdIssuerInformation IssuerInformation;
        /** Override the issuer name for user indexing and lookup. */
        @Deprecated
        public String IssuerOverride;
        
    }

    /**
     * Player Shared Secret Keys are used for the call to Client/GetTitlePublicKey, which exchanges the shared secret for an
     * RSA CSP blob to be used to encrypt the payload of account creation requests when that API requires a signature header.
     */
    @Deprecated
    public static class UpdatePlayerSharedSecretRequest {
        /** Disable or Enable this key */
        @Deprecated
        public Boolean Disabled;
        /** Friendly name for this key */
        @Deprecated
        public String FriendlyName;
        /** The shared secret key to update */
        @Deprecated
        public String SecretKey;
        
    }

    @Deprecated
    public static class UpdatePlayerSharedSecretResult {
        
    }

    /**
     * Statistics are numeric values, with each statistic in the title also generating a leaderboard. The ResetInterval enables
     * automatically resetting leaderboards on a specified interval. Upon reset, the statistic updates to a new version with no
     * values (effectively removing all players from the leaderboard). The previous version's statistic values are also
     * archived for retrieval, if needed (see GetPlayerStatisticVersions). Statistics not created via a call to
     * CreatePlayerStatisticDefinition by default have a VersionChangeInterval of Never, meaning they do not reset on a
     * schedule, but they can be set to do so via a call to UpdatePlayerStatisticDefinition. Once a statistic has been reset
     * (sometimes referred to as versioned or incremented), the now-previous version can still be written to for up a short,
     * pre-defined period (currently 10 seconds), to prevent issues with levels completing around the time of the reset. Also,
     * once reset, the historical statistics for players in the title may be retrieved using the URL specified in the version
     * information (GetPlayerStatisticVersions). The AggregationMethod determines what action is taken when a new statistic
     * value is submitted - always update with the new value (Last), use the highest of the old and new values (Max), use the
     * smallest (Min), or add them together (Sum).
     */
    @Deprecated
    public static class UpdatePlayerStatisticDefinitionRequest {
        /** the aggregation method to use in updating the statistic (defaults to last) */
        @Deprecated
        public StatisticAggregationMethod AggregationMethod;
        /** unique name of the statistic */
        @Deprecated
        public String StatisticName;
        /**
         * interval at which the values of the statistic for all players are reset (changes are effective at the next occurance of
         * the new interval boundary)
         */
        @Deprecated
        public StatisticResetIntervalOption VersionChangeInterval;
        
    }

    @Deprecated
    public static class UpdatePlayerStatisticDefinitionResult {
        /** updated statistic definition */
        @Deprecated
        public PlayerStatisticDefinition Statistic;
        
    }

    /**
     * Updates permissions for your title. Policies affect what is allowed to happen on your title. Your policy is a collection
     * of statements that, together, govern particular area for your title. Today, the only allowed policy is called
     * 'ApiPolicy' and it governs what API calls are allowed. To verify that you have the latest version always download the
     * current policy from GetPolicy before uploading a new policy. PlayFab updates the base policy periodically and will
     * automatically apply it to the uploaded policy. Overwriting the combined policy blindly may result in unexpected API
     * errors.
     */
    @Deprecated
    public static class UpdatePolicyRequest {
        /** Whether to overwrite or append to the existing policy. */
        @Deprecated
        public Boolean OverwritePolicy;
        /** The name of the policy being updated. Only supported name is 'ApiPolicy' */
        @Deprecated
        public String PolicyName;
        /** Version of the policy to update. Must be the latest (as returned by GetPolicy). */
        @Deprecated
        public Integer PolicyVersion;
        /** The new statements to include in the policy. */
        @Deprecated
        public ArrayList<PermissionStatement> Statements;
        
    }

    @Deprecated
    public static class UpdatePolicyResponse {
        /** The name of the policy that was updated. */
        @Deprecated
        public String PolicyName;
        /** The statements included in the new version of the policy. */
        @Deprecated
        public ArrayList<PermissionStatement> Statements;
        
    }

    /**
     * This operation is additive. Tables with TableId values not currently defined will be added, while those with TableId
     * values matching Tables currently in the catalog will be overwritten with the given values.
     */
    @Deprecated
    public static class UpdateRandomResultTablesRequest {
        /** which catalog is being updated. If null, update the current default catalog version */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * array of random result tables to make available (Note: specifying an existing TableId will result in overwriting that
         * table, while any others will be added to the available set)
         */
        @Deprecated
        public ArrayList<RandomResultTable> Tables;
        
    }

    @Deprecated
    public static class UpdateRandomResultTablesResult {
        
    }

    /** Update segment properties data which are planning to update */
    @Deprecated
    public static class UpdateSegmentRequest {
        /** Segment model with all of the segment properties data. */
        @Deprecated
        public SegmentModel SegmentModel;
        
    }

    @Deprecated
    public static class UpdateSegmentResponse {
        /** Error message. */
        @Deprecated
        public String ErrorMessage;
        /** Segment id. */
        @Deprecated
        public String SegmentId;
        
    }

    /**
     * When used for SetStoreItems, this operation is not additive. Using it will cause the indicated virtual store to be
     * created from scratch. If there is an existing store with the same storeId, it will be deleted and replaced with only the
     * items specified in this call. When used for UpdateStoreItems, this operation is additive. Items with ItemId values not
     * currently in the store will be added, while those with ItemId values matching items currently in the catalog will
     * overwrite those items with the given values. In both cases, a store contains an array of references to items defined in
     * the catalog, along with the prices for the item, in both real world and virtual currencies. These prices act as an
     * override to any prices defined in the catalog. In this way, the base definitions of the items may be defined in the
     * catalog, with all associated properties, while the pricing can be set for each store, as needed. This allows for subsets
     * of goods to be defined for different purposes (in order to simplify showing some, but not all catalog items to users,
     * based upon different characteristics), along with unique prices. Note that all prices defined in the catalog and store
     * definitions for the item are considered valid, and that a compromised client can be made to send a request for an item
     * based upon any of these definitions. If no price is specified in the store for an item, the price set in the catalog
     * should be displayed to the user.
     */
    @Deprecated
    public static class UpdateStoreItemsRequest {
        /** Catalog version of the store to update. If null, uses the default catalog. */
        @Deprecated
        public String CatalogVersion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Additional data about the store */
        @Deprecated
        public StoreMarketingModel MarketingData;
        /** Array of store items - references to catalog items, with specific pricing - to be added */
        @Deprecated
        public ArrayList<StoreItem> Store;
        /** Unique identifier for the store which is to be updated */
        @Deprecated
        public String StoreId;
        
    }

    @Deprecated
    public static class UpdateStoreItemsResult {
        
    }

    /**
     * Note that when calling this API, all properties of the task have to be provided, including properties that you do not
     * want to change. Parameters not specified would be set to default value. If the task name in the update request is new, a
     * task rename operation will be executed before updating other fields of the task. WARNING: Renaming of a task may break
     * logics where the task name is used as an identifier.
     */
    @Deprecated
    public static class UpdateTaskRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Description the task */
        @Deprecated
        public String Description;
        /** Specify either the task ID or the name of the task to be updated. */
        @Deprecated
        public NameIdentifier Identifier;
        /** Whether the schedule is active. Inactive schedule will not trigger task execution. */
        @Deprecated
        public Boolean IsActive;
        /** Name of the task. This is a unique identifier for tasks in the title. */
        @Deprecated
        public String Name;
        /** Parameter object specific to the task type. See each task type's create API documentation for details. */
        @Deprecated
        public Object Parameter;
        /** Cron expression for the run schedule of the task. The expression should be in UTC. */
        @Deprecated
        public String Schedule;
        /** Task type. */
        @Deprecated
        public ScheduledTaskType Type;
        
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
     * In addition to the PlayFab username, titles can make use of a DisplayName which is also a unique identifier, but
     * specific to the title. This allows for unique names which more closely match the theme or genre of a title, for example.
     * This API enables changing that name, whether due to a customer request, an offensive name choice, etc.
     */
    @Deprecated
    public static class UpdateUserTitleDisplayNameRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** New title display name for the user - must be between 3 and 25 characters */
        @Deprecated
        public String DisplayName;
        /** PlayFab unique identifier of the user whose title specific display name is to be changed */
        @Deprecated
        public String PlayFabId;
        
    }

    @Deprecated
    public static class UpdateUserTitleDisplayNameResult {
        /** current title display name for the user (this will be the original display name if the rename attempt failed) */
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
    public static class UserOriginationSegmentFilter {
        /** User login provider. */
        @Deprecated
        public SegmentLoginIdentityProvider LoginProvider;
        
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
    public static class ValueToDateSegmentFilter {
        /** Value to date amount. */
        @Deprecated
        public String Amount;
        /** Value to date comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** Currency using for filter. */
        @Deprecated
        public SegmentCurrency Currency;
        
    }

    @Deprecated
    public static class VirtualCurrencyBalanceSegmentFilter {
        /** Total amount. */
        @Deprecated
        public Integer Amount;
        /** Amount comparison. */
        @Deprecated
        public SegmentFilterComparison Comparison;
        /** Currency code. */
        @Deprecated
        public String CurrencyCode;
        
    }

    @Deprecated
    public static class VirtualCurrencyData {
        /** unique two-character identifier for this currency type (e.g.: "CC") */
        @Deprecated
        public String CurrencyCode;
        /** friendly name to show in the developer portal, reports, etc. */
        @Deprecated
        public String DisplayName;
        /** amount to automatically grant users upon first login to the title */
        @Deprecated
        public Integer InitialDeposit;
        /** maximum amount to which the currency will recharge (cannot exceed MaxAmount, but can be less) */
        @Deprecated
        public Integer RechargeMax;
        /** rate at which the currency automatically be added to over time, in units per day (24 hours) */
        @Deprecated
        public Integer RechargeRate;
        
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

}
