package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabAdminModels {

    public static class AdCampaignAttribution {
        /**
         * Attribution network name
         */
        public String Platform;
        /**
         * Attribution campaign identifier
         */
        public String CampaignId;
        /**
         * UTC time stamp of attribution
         */
        public Date AttributedAt;
        
    }

    public static class AddNewsRequest {
        /**
         * Time this news was published. If not set, defaults to now.
         */
        public Date Timestamp;
        /**
         * Title (headline) of the news item
         */
        public String Title;
        /**
         * Body text of the news
         */
        public String Body;
        
    }

    public static class AddNewsResult {
        /**
         * Unique id of the new news item
         */
        public String NewsId;
        
    }

    public static class AddServerBuildRequest {
        /**
         * unique identifier for the build executable
         */
        public String BuildId;
        /**
         * appended to the end of the command line when starting game servers
         */
        public String CommandLineTemplate;
        /**
         * path to the game server executable. Defaults to gameserver.exe
         */
        public String ExecutablePath;
        /**
         * server host regions in which this build should be running and available
         */
        public ArrayList<Region> ActiveRegions;
        /**
         * developer comment(s) for this build
         */
        public String Comment;
        /**
         * maximum number of game server instances that can run on a single host machine
         */
        public Integer MaxGamesPerHost;
        /**
         * minimum capacity of additional game server instances that can be started before the autoscaling service starts new host machines (given the number of current running host machines and game server instances)
         */
        public Integer MinFreeGameSlots;
        
    }

    public static class AddServerBuildResult {
        /**
         * unique identifier for this build executable
         */
        public String BuildId;
        /**
         * array of regions where this build can used, when it is active
         */
        public ArrayList<Region> ActiveRegions;
        /**
         * maximum number of game server instances that can run on a single host machine
         */
        public Integer MaxGamesPerHost;
        /**
         * minimum capacity of additional game server instances that can be started before the autoscaling service starts new host machines (given the number of current running host machines and game server instances)
         */
        public Integer MinFreeGameSlots;
        /**
         * appended to the end of the command line when starting game servers
         */
        public String CommandLineTemplate;
        /**
         * path to the game server executable. Defaults to gameserver.exe
         */
        public String ExecutablePath;
        /**
         * developer comment(s) for this build
         */
        public String Comment;
        /**
         * time this build was last modified (or uploaded, if this build has never been modified)
         */
        public Date Timestamp;
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected.
         */
        public String TitleId;
        /**
         * the current status of the build validation and processing steps
         */
        public GameBuildStatus Status;
        
    }

    public static class AddUserVirtualCurrencyRequest {
        /**
         * PlayFab unique identifier of the user whose virtual currency balance is to be increased.
         */
        public String PlayFabId;
        /**
         * Name of the virtual currency which is to be incremented.
         */
        public String VirtualCurrency;
        /**
         * Amount to be added to the user balance of the specified virtual currency. Maximum VC balance is Int32 (2,147,483,647). Any increase over this value will be discarded.
         */
        public Integer Amount;
        
    }

    public static class AddVirtualCurrencyTypesRequest {
        /**
         * List of virtual currencies and their initial deposits (the amount a user is granted when signing in for the first time) to the title
         */
        public ArrayList<VirtualCurrencyData> VirtualCurrencies;
        
    }

    public static class BlankResult {
        
    }
    /**
     *  A purchasable item from the item catalog
     */
    public static class CatalogItem implements Comparable<CatalogItem> {
        /**
         * unique identifier for this item
         */
        public String ItemId;
        /**
         * class to which the item belongs
         */
        public String ItemClass;
        /**
         * catalog version for this item
         */
        public String CatalogVersion;
        /**
         * text name for the item, to show in-game
         */
        public String DisplayName;
        /**
         * text description of item, to show in-game
         */
        public String Description;
        /**
         * price of this item in virtual currencies and "RM" (the base Real Money purchase price, in USD pennies)
         */
        public Map<String,Long> VirtualCurrencyPrices;
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
         * game specific custom data
         */
        public String CustomData;
        /**
         * defines the consumable properties (number of uses, timeout) for the item
         */
        public CatalogItemConsumableInfo Consumable;
        /**
         * defines the container properties for the item - what items it contains, including random drop tables and virtual currencies, and what item (if any) is required to open it via the UnlockContainerItem API
         */
        public CatalogItemContainerInfo Container;
        /**
         * defines the bundle properties for the item - bundles are items which contain other items, including random drop tables and virtual currencies
         */
        public CatalogItemBundleInfo Bundle;
        /**
         * if true, then an item instance of this type can be used to grant a character to a user.
         */
        public Boolean CanBecomeCharacter;
        /**
         * if true, then only one item instance of this type will exist and its remaininguses will be incremented instead. RemainingUses will cap out at Int32.Max (2,147,483,647). All subsequent increases will be discarded
         */
        public Boolean IsStackable;
        /**
         * if true, then an item instance of this type can be traded between players using the trading APIs
         */
        public Boolean IsTradable;
        /**
         * URL to the item image. For Facebook purchase to display the image on the item purchase page, this must be set to an HTTP URL.
         */
        public String ItemImageUrl;
        
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
         * duration in seconds for how long the item will remain in the player inventory - once elapsed, the item will be removed
         */
        public Long UsagePeriod;
        /**
         * all inventory item instances in the player inventory sharing a non-null UsagePeriodGroup have their UsagePeriod values added together, and share the result - when that period has elapsed, all the items in the group will be removed
         */
        public String UsagePeriodGroup;
        
    }
    /**
     *  Containers are inventory items that can hold other items defined in the catalog, as well as virtual currency, which is added to the player inventory when the container is unlocked, using the UnlockContainerItem API. The items can be anything defined in the catalog, as well as RandomResultTable objects which will be resolved when the container is unlocked. Containers and their keys should be defined as Consumable (having a limited number of uses) in their catalog defintiions, unless the intent is for the player to be able to re-use them infinitely.
     */
    public static class CatalogItemContainerInfo {
        /**
         * ItemId for the catalog item used to unlock the container, if any (if not specified, a call to UnlockContainerItem will open the container, adding the contents to the player inventory and currency balances)
         */
        public String KeyItemId;
        /**
         * unique ItemId values for all items which will be added to the player inventory, once the container has been unlocked
         */
        @Unordered
        public ArrayList<String> ItemContents;
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

    public static class CloudScriptFile {
        /**
         * Name of the javascript file. These names are not used internally by the server, they are only for developer organizational purposes.
         */
        public String Filename;
        /**
         * Contents of the Cloud Script javascript. Must be string-escaped javascript.
         */
        public String FileContents;
        
    }

    public static class CloudScriptVersionStatus {
        /**
         * Version number
         */
        public Integer Version;
        /**
         * Published code revision for this Cloud Script version
         */
        public Integer PublishedRevision;
        /**
         * Most recent revision for this Cloud Script version
         */
        public Integer LatestRevision;
        
    }

    public static class ContentInfo {
        /**
         * Key of the content
         */
        public String Key;
        /**
         * Size of the content in bytes
         */
        public Long Size;
        /**
         * Last modified time
         */
        public Date LastModified;
        
    }

    public static class CreatePlayerStatisticDefinitionRequest {
        /**
         * unique name of the statistic
         */
        public String StatisticName;
        /**
         * interval at which the values of the statistic for all players are reset (resets begin at the next interval boundary)
         */
        public StatisticResetIntervalOption VersionChangeInterval;
        /**
         * the aggregation method to use in updating the statistic (defaults to last)
         */
        public StatisticAggregationMethod AggregationMethod;
        
    }

    public static class CreatePlayerStatisticDefinitionResult {
        /**
         * created statistic definition
         */
        public PlayerStatisticDefinition Statistic;
        
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

    public static class DeleteContentRequest {
        /**
         * Key of the content item to be deleted
         */
        public String Key;
        
    }

    public static class DeleteUsersRequest {
        /**
         * An array of unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public ArrayList<String> PlayFabIds;
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected.
         */
        public String TitleId;
        
    }

    public static class DeleteUsersResult {
        
    }

    public static enum GameBuildStatus {
        Available,
        Validating,
        InvalidBuildPackage,
        Processing,
        FailedToProcess
    }

    public static class GameModeInfo {
        /**
         * specific game mode type
         */
        public String Gamemode;
        /**
         * minimum user count required for this Game Server Instance to continue (usually 1)
         */
        public Long MinPlayerCount;
        /**
         * maximum user count a specific Game Server Instance can support
         */
        public Long MaxPlayerCount;
        /**
         * whether to start as an open session, meaning that players can matchmake into it (defaults to true)
         */
        public Boolean StartOpen;
        
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

    public static class GetCloudScriptRevisionRequest {
        /**
         * Version number. If left null, defaults to the latest version
         */
        public Integer Version;
        /**
         * Revision number. If left null, defaults to the latest revision
         */
        public Integer Revision;
        
    }

    public static class GetCloudScriptRevisionResult {
        /**
         * Version number.
         */
        public Integer Version;
        /**
         * Revision number.
         */
        public Integer Revision;
        /**
         * Time this revision was created
         */
        public Date CreatedAt;
        /**
         * List of Cloud Script files in this revision.
         */
        public ArrayList<CloudScriptFile> Files;
        /**
         * True if this is the currently published revision
         */
        public Boolean IsPublished;
        
    }

    public static class GetCloudScriptVersionsRequest {
        
    }

    public static class GetCloudScriptVersionsResult {
        /**
         * List of versions
         */
        public ArrayList<CloudScriptVersionStatus> Versions;
        
    }

    public static class GetContentListRequest {
        /**
         * Limits the response to keys that begin with the specified prefix. You can use prefixes to list contents under a folder, or for a specified version, etc.
         */
        public String Prefix;
        
    }

    public static class GetContentListResult {
        /**
         * Number of content items returned. We currently have a maximum of 1000 items limit.
         */
        public Integer ItemCount;
        /**
         * The total size of listed contents in bytes.
         */
        public Long TotalSize;
        /**
         * List of content items.
         */
        public ArrayList<ContentInfo> Contents;
        
    }

    public static class GetContentUploadUrlRequest {
        /**
         * Key of the content item to upload, usually formatted as a path, e.g. images/a.png
         */
        public String Key;
        /**
         * A standard MIME type describing the format of the contents. The same MIME type has to be set in the header when uploading the content. If not specified, the MIME type is 'binary/octet-stream' by default.
         */
        public String ContentType;
        
    }

    public static class GetContentUploadUrlResult {
        /**
         * URL for uploading content via HTTP PUT method. The URL will expire in 1 hour.
         */
        public String URL;
        
    }

    public static class GetDataReportRequest {
        /**
         * Report name
         */
        public String ReportName;
        /**
         * Reporting year (UTC)
         */
        public Integer Year;
        /**
         * Reporting month (UTC)
         */
        public Integer Month;
        /**
         * Reporting year (UTC)
         */
        public Integer Day;
        
    }

    public static class GetDataReportResult {
        /**
         * The URL where the requested report can be downloaded.
         */
        public String DownloadUrl;
        
    }

    public static class GetMatchmakerGameInfoRequest {
        /**
         * unique identifier of the lobby for which info is being requested
         */
        public String LobbyId;
        
    }

    public static class GetMatchmakerGameInfoResult {
        /**
         * unique identifier of the lobby 
         */
        public String LobbyId;
        /**
         * unique identifier of the Game Server Instance for this lobby
         */
        public String TitleId;
        /**
         * time when the Game Server Instance was created
         */
        public Date StartTime;
        /**
         * time when Game Server Instance is currently scheduled to end
         */
        public Date EndTime;
        /**
         * game mode for this Game Server Instance
         */
        public String Mode;
        /**
         * version identifier of the game server executable binary being run
         */
        public String BuildVersion;
        /**
         * region in which the Game Server Instance is running
         */
        public Region Region;
        /**
         * array of unique PlayFab identifiers for users currently connected to this Game Server Instance
         */
        @Unordered
        public ArrayList<String> Players;
        /**
         * IP address for this Game Server Instance
         */
        public String ServerAddress;
        /**
         * communication port for this Game Server Instance
         */
        public Long ServerPort;
        
    }

    public static class GetMatchmakerGameModesRequest {
        /**
         * previously uploaded build version for which game modes are being requested
         */
        public String BuildVersion;
        
    }

    public static class GetMatchmakerGameModesResult {
        /**
         * array of game modes available for the specified build
         */
        public ArrayList<GameModeInfo> GameModes;
        
    }

    public static class GetPlayerSegmentsResult {
        /**
         * Array of segments the requested player currently belongs to.
         */
        public ArrayList<GetSegmentResult> Segments;
        
    }

    public static class GetPlayersInSegmentRequest {
        /**
         * Unique identifier for this segment.
         */
        public String SegmentId;
        /**
         * Number of seconds to keep the continuation token active. After token expiration it is not possible to continue paging results. Default is 300 (5 minutes). Maximum is 1,800 (30 minutes).
         */
        public Long SecondsToLive;
        /**
         * Maximum number of profiles to load. Default is 1,000. Maximum is 10,000.
         */
        public Long MaxBatchSize;
        /**
         * Continuation token if retrieving subsequent pages of results.
         */
        public String ContinuationToken;
        
    }

    public static class GetPlayersInSegmentResult {
        /**
         * Count of profiles matching this segment.
         */
        public Integer ProfilesInSegment;
        /**
         * Continuation token to use to retrieve subsequent pages of results. If token returns null there are no more results.
         */
        public String ContinuationToken;
        /**
         * Array of player profiles in this segment.
         */
        public ArrayList<PlayerProfile> PlayerProfiles;
        
    }

    public static class GetPlayersSegmentsRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetPlayerStatisticDefinitionsRequest {
        
    }

    public static class GetPlayerStatisticDefinitionsResult {
        /**
         * the player statistic definitions for the title
         */
        public ArrayList<PlayerStatisticDefinition> Statistics;
        
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

    public static class GetPublisherDataRequest {
        /**
         *  array of keys to get back data from the Publisher data blob, set by the admin tools
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
         * catalog version to fetch tables from. Use default catalog version if null
         */
        public String CatalogVersion;
        
    }

    public static class GetRandomResultTablesResult {
        /**
         * array of random result tables currently available
         */
        public Map<String,RandomResultTableListing> Tables;
        
    }

    public static class GetSegmentResult {
        /**
         * Unique identifier for this segment.
         */
        public String Id;
        /**
         * Segment name.
         */
        public String Name;
        /**
         * Identifier of the segments AB Test, if it is attached to one.
         */
        public String ABTestParent;
        
    }

    public static class GetServerBuildInfoRequest {
        /**
         * unique identifier of the previously uploaded build executable for which information is being requested
         */
        public String BuildId;
        
    }
    /**
     *  Information about a particular server build
     */
    public static class GetServerBuildInfoResult implements Comparable<GetServerBuildInfoResult> {
        /**
         * unique identifier for this build executable
         */
        public String BuildId;
        /**
         * array of regions where this build can used, when it is active
         */
        @Unordered
        public ArrayList<Region> ActiveRegions;
        /**
         * maximum number of game server instances that can run on a single host machine
         */
        public Integer MaxGamesPerHost;
        /**
         * minimum capacity of additional game server instances that can be started before the autoscaling service starts new host machines (given the number of current running host machines and game server instances)
         */
        public Integer MinFreeGameSlots;
        /**
         * developer comment(s) for this build
         */
        public String Comment;
        /**
         * time this build was last modified (or uploaded, if this build has never been modified)
         */
        public Date Timestamp;
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected.
         */
        public String TitleId;
        /**
         * the current status of the build validation and processing steps
         */
        public GameBuildStatus Status;
        /**
         * error message, if any, about this build
         */
        public String ErrorMessage;
        
        public int compareTo(GetServerBuildInfoResult other) {
            if (other == null || other.BuildId == null) return 1;
            if (BuildId == null) return -1;
            return BuildId.compareTo(other.BuildId);
        }
        
    }

    public static class GetServerBuildUploadURLRequest {
        /**
         * unique identifier of the game server build to upload
         */
        public String BuildId;
        
    }

    public static class GetServerBuildUploadURLResult {
        /**
         * pre-authorized URL for uploading the game server build package
         */
        public String URL;
        
    }

    public static class GetStoreItemsRequest {
        /**
         * catalog version to store items from. Use default catalog version if null
         */
        public String CatalogVersion;
        /**
         * Unqiue identifier for the store which is being requested.
         */
        public String StoreId;
        
    }

    public static class GetStoreItemsResult {
        /**
         * Array of items which can be purchased from this store.
         */
        @Unordered("ItemId")
        public ArrayList<StoreItem> Store;
        
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

    public static class GetUserDataRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Specific keys to search for in the custom user data.
         */
        public ArrayList<String> Keys;
        /**
         * The version that currently exists according to the caller. The call will return the data for all of the keys if the version in the system is greater than this.
         */
        public Long IfChangedFromDataVersion;
        
    }

    public static class GetUserDataResult {
        /**
         * PlayFab unique identifier of the user whose custom data is being returned.
         */
        public String PlayFabId;
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        /**
         * User specific data for this title.
         */
        public Map<String,UserDataRecord> Data;
        
    }

    public static class GetUserInventoryRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class GetUserInventoryResult {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Array of inventory items belonging to the user.
         */
        @Unordered("ItemInstanceId")
        public ArrayList<ItemInstance> Inventory;
        /**
         * Array of virtual currency balance(s) belonging to the user.
         */
        public Map<String,Integer> VirtualCurrency;
        /**
         * Array of remaining times and timestamps for virtual currencies.
         */
        public Map<String,VirtualCurrencyRechargeTime> VirtualCurrencyRechargeTimes;
        
    }
    /**
     *  Result of granting an item to a user
     */
    public static class GrantedItemInstance implements Comparable<GrantedItemInstance> {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Result of this operation.
         */
        public Boolean Result;
        /**
         * Unique identifier for the inventory item, as defined in the catalog.
         */
        public String ItemId;
        /**
         * Unique item identifier for this specific instance of the item.
         */
        public String ItemInstanceId;
        /**
         * Class name for the inventory item, as defined in the catalog.
         */
        public String ItemClass;
        /**
         * Timestamp for when this instance was purchased.
         */
        public Date PurchaseDate;
        /**
         * Timestamp for when this instance will expire.
         */
        public Date Expiration;
        /**
         * Total number of remaining uses, if this is a consumable item.
         */
        public Integer RemainingUses;
        /**
         * The number of uses that were added or removed to this item in this call.
         */
        public Integer UsesIncrementedBy;
        /**
         * Game specific comment associated with this instance when it was added to the user inventory.
         */
        public String Annotation;
        /**
         * Catalog version for the inventory item, when this instance was created.
         */
        public String CatalogVersion;
        /**
         * Unique identifier for the parent inventory item, as defined in the catalog, for object which were added from a bundle or container.
         */
        public String BundleParent;
        /**
         * CatalogItem.DisplayName at the time this item was purchased.
         */
        public String DisplayName;
        /**
         * Currency type for the cost of the catalog item.
         */
        public String UnitCurrency;
        /**
         * Cost of the catalog item in the given currency.
         */
        public Long UnitPrice;
        /**
         * Array of unique items that were awarded when this catalog item was purchased.
         */
        public ArrayList<String> BundleContents;
        /**
         * A set of custom key-value pairs on the inventory item.
         */
        public Map<String,String> CustomData;
        
        public int compareTo(GrantedItemInstance other) {
            if (other == null || other.ItemInstanceId == null) return 1;
            if (ItemInstanceId == null) return -1;
            return ItemInstanceId.compareTo(other.ItemInstanceId);
        }
        
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

    public static class IncrementPlayerStatisticVersionRequest {
        /**
         * unique name of the statistic
         */
        public String StatisticName;
        
    }

    public static class IncrementPlayerStatisticVersionResult {
        /**
         * version change history of the statistic
         */
        public PlayerStatisticVersion StatisticVersion;
        
    }

    public static class ItemGrant {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique identifier of the catalog item to be granted to the user.
         */
        public String ItemId;
        /**
         * String detailing any additional information concerning this operation.
         */
        public String Annotation;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character.
         */
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData.  Some SDKs cannot insert null-values into Data due to language constraints.  Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        
    }
    /**
     *  A unique instance of an item in a user's inventory. Note, to retrieve additional information for an item instance (such as Tags, Description, or Custom Data that are set on the root catalog item), a call to GetCatalogItems is required. The Item ID of the instance can then be matched to a catalog entry, which contains the additional information. Also note that Custom Data is only set here from a call to UpdateUserInventoryItemCustomData.
     */
    public static class ItemInstance implements Comparable<ItemInstance> {
        /**
         * Unique identifier for the inventory item, as defined in the catalog.
         */
        public String ItemId;
        /**
         * Unique item identifier for this specific instance of the item.
         */
        public String ItemInstanceId;
        /**
         * Class name for the inventory item, as defined in the catalog.
         */
        public String ItemClass;
        /**
         * Timestamp for when this instance was purchased.
         */
        public Date PurchaseDate;
        /**
         * Timestamp for when this instance will expire.
         */
        public Date Expiration;
        /**
         * Total number of remaining uses, if this is a consumable item.
         */
        public Integer RemainingUses;
        /**
         * The number of uses that were added or removed to this item in this call.
         */
        public Integer UsesIncrementedBy;
        /**
         * Game specific comment associated with this instance when it was added to the user inventory.
         */
        public String Annotation;
        /**
         * Catalog version for the inventory item, when this instance was created.
         */
        public String CatalogVersion;
        /**
         * Unique identifier for the parent inventory item, as defined in the catalog, for object which were added from a bundle or container.
         */
        public String BundleParent;
        /**
         * CatalogItem.DisplayName at the time this item was purchased.
         */
        public String DisplayName;
        /**
         * Currency type for the cost of the catalog item.
         */
        public String UnitCurrency;
        /**
         * Cost of the catalog item in the given currency.
         */
        public Long UnitPrice;
        /**
         * Array of unique items that were awarded when this catalog item was purchased.
         */
        public ArrayList<String> BundleContents;
        /**
         * A set of custom key-value pairs on the inventory item.
         */
        public Map<String,String> CustomData;
        
        public int compareTo(ItemInstance other) {
            if (other == null || other.ItemInstanceId == null) return 1;
            if (ItemInstanceId == null) return -1;
            return ItemInstanceId.compareTo(other.ItemInstanceId);
        }
        
    }

    public static class ListBuildsRequest {
        
    }

    public static class ListBuildsResult {
        /**
         * array of uploaded game server builds
         */
        @Unordered("BuildId")
        public ArrayList<GetServerBuildInfoResult> Builds;
        
    }

    public static class ListVirtualCurrencyTypesRequest {
        
    }

    public static class ListVirtualCurrencyTypesResult {
        /**
         * List of virtual currency names defined for this title
         */
        @Unordered
        public ArrayList<VirtualCurrencyData> VirtualCurrencies;
        
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
        Twitch
    }

    public static class LookupUserAccountInfoRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * User email address attached to their account
         */
        public String Email;
        /**
         * PlayFab username for the account (3-20 characters)
         */
        public String Username;
        /**
         * Title specific username to match against existing user accounts
         */
        public String TitleDisplayName;
        
    }

    public static class LookupUserAccountInfoResult {
        /**
         * User info for the user matching the request
         */
        public UserAccountInfo UserInfo;
        
    }

    public static class ModifyMatchmakerGameModesRequest {
        /**
         * previously uploaded build version for which game modes are being specified
         */
        public String BuildVersion;
        /**
         * array of game modes (Note: this will replace all game modes for the indicated build version)
         */
        public ArrayList<GameModeInfo> GameModes;
        
    }

    public static class ModifyMatchmakerGameModesResult {
        
    }

    public static class ModifyServerBuildRequest {
        /**
         * unique identifier of the previously uploaded build executable to be updated
         */
        public String BuildId;
        /**
         * new timestamp
         */
        public Date Timestamp;
        /**
         * array of regions where this build can used, when it is active
         */
        public ArrayList<Region> ActiveRegions;
        /**
         * maximum number of game server instances that can run on a single host machine
         */
        public Integer MaxGamesPerHost;
        /**
         * minimum capacity of additional game server instances that can be started before the autoscaling service starts new host machines (given the number of current running host machines and game server instances)
         */
        public Integer MinFreeGameSlots;
        /**
         * appended to the end of the command line when starting game servers
         */
        public String CommandLineTemplate;
        /**
         * path to the game server executable. Defaults to gameserver.exe
         */
        public String ExecutablePath;
        /**
         * developer comment(s) for this build
         */
        public String Comment;
        
    }

    public static class ModifyServerBuildResult {
        /**
         * unique identifier for this build executable
         */
        public String BuildId;
        /**
         * array of regions where this build can used, when it is active
         */
        public ArrayList<Region> ActiveRegions;
        /**
         * maximum number of game server instances that can run on a single host machine
         */
        public Integer MaxGamesPerHost;
        /**
         * minimum capacity of additional game server instances that can be started before the autoscaling service starts new host machines (given the number of current running host machines and game server instances)
         */
        public Integer MinFreeGameSlots;
        /**
         * appended to the end of the command line when starting game servers
         */
        public String CommandLineTemplate;
        /**
         * path to the game server executable. Defaults to gameserver.exe
         */
        public String ExecutablePath;
        /**
         * developer comment(s) for this build
         */
        public String Comment;
        /**
         * time this build was last modified (or uploaded, if this build has never been modified)
         */
        public Date Timestamp;
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected.
         */
        public String TitleId;
        /**
         * the current status of the build validation and processing steps
         */
        public GameBuildStatus Status;
        
    }

    public static class ModifyUserVirtualCurrencyResult {
        /**
         * User currency was subtracted from.
         */
        public String PlayFabId;
        /**
         * Name of the virtual currency which was modified.
         */
        public String VirtualCurrency;
        /**
         * Amount added or subtracted from the user's virtual currency. Maximum VC balance is Int32 (2,147,483,647). Any increase over this value will be discarded.
         */
        public Integer BalanceChange;
        /**
         * Balance of the virtual currency after modification.
         */
        public Integer Balance;
        
    }

    public static class PlayerLinkedAccount {
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
        /**
         * Linked account's email
         */
        public String Email;
        
    }

    public static class PlayerProfile {
        /**
         * PlayFab Player ID
         */
        public String PlayerId;
        /**
         * Title ID this profile applies to
         */
        public String TitleId;
        /**
         * Player Display Name
         */
        public String DisplayName;
        /**
         * Player account origination
         */
        public LoginIdentityProvider Origination;
        /**
         * Player record created
         */
        public Date Created;
        /**
         * Last login
         */
        public Date LastLogin;
        /**
         * Banned until UTC Date. If permanent ban this is set for 20 years after the original ban date.
         */
        public Date BannedUntil;
        /**
         * Dictionary of player's statistics using only the latest version's value
         */
        public Map<String,Integer> Statistics;
        /**
         * Dictionary of player's total currency purchases. The key VTD is a sum of all player_realmoney_purchase events OrderTotals.
         */
        public Map<String,Long> ValuesToDate;
        /**
         * Dictionary of player's virtual currency balances
         */
        public Map<String,Integer> VirtualCurrencyBalances;
        /**
         * Array of ad campaigns player has been attributed to
         */
        public ArrayList<AdCampaignAttribution> AdCampaignAttributions;
        /**
         * Array of configured push notification end points
         */
        public ArrayList<PushNotificationRegistration> PushNotificationRegistrations;
        /**
         * Array of third party accounts linked to this player
         */
        public ArrayList<PlayerLinkedAccount> LinkedAccounts;
        /**
         * Array of player statistics
         */
        public ArrayList<PlayerStatistic> PlayerStatistics;
        
    }

    public static class PlayerStatistic {
        /**
         * Statistic ID
         */
        public String Id;
        /**
         * Statistic version (0 if not a versioned statistic)
         */
        public Integer StatisticVersion;
        /**
         * Current statistic value
         */
        public Integer StatisticValue;
        /**
         * Statistic name
         */
        public String Name;
        
    }

    public static class PlayerStatisticDefinition {
        /**
         * unique name of the statistic
         */
        public String StatisticName;
        /**
         * current active version of the statistic, incremented each time the statistic resets
         */
        public Long CurrentVersion;
        /**
         * interval at which the values of the statistic for all players are reset automatically
         */
        public StatisticResetIntervalOption VersionChangeInterval;
        /**
         * the aggregation method to use in updating the statistic (defaults to last)
         */
        public StatisticAggregationMethod AggregationMethod;
        
    }

    public static class PlayerStatisticVersion {
        /**
         * name of the statistic when the version became active
         */
        public String StatisticName;
        /**
         * version of the statistic
         */
        public Long Version;
        /**
         * time at which the statistic version was scheduled to become active, based on the configured ResetInterval
         */
        public Date ScheduledActivationTime;
        /**
         * time when the statistic version became active
         */
        public Date ActivationTime;
        /**
         * time at which the statistic version was scheduled to become inactive, based on the configured ResetInterval
         */
        public Date ScheduledDeactivationTime;
        /**
         * time when the statistic version became inactive due to statistic version incrementing
         */
        public Date DeactivationTime;
        /**
         * status of the process of saving player statistic values of the previous version to a downloadable archive
         */
        public StatisticVersionArchivalStatus ArchivalStatus;
        /**
         * URL for the downloadable archive of player statistic values, if available
         */
        public String ArchiveDownloadUrl;
        
    }

    public static enum PushNotificationPlatform {
        ApplePushNotificationService,
        GoogleCloudMessaging
    }

    public static class PushNotificationRegistration {
        /**
         * Push notification platform
         */
        public PushNotificationPlatform Platform;
        /**
         * Notification configured endpoint
         */
        public String NotificationEndpointARN;
        
    }

    public static class RandomResultTable {
        /**
         * Unique name for this drop table
         */
        public String TableId;
        /**
         * Child nodes that indicate what kind of drop table item this actually is.
         */
        public ArrayList<ResultTableNode> Nodes;
        
    }

    public static class RandomResultTableListing {
        /**
         * Catalog version this table is associated with
         */
        public String CatalogVersion;
        /**
         * Unique name for this drop table
         */
        public String TableId;
        /**
         * Child nodes that indicate what kind of drop table item this actually is.
         */
        public ArrayList<ResultTableNode> Nodes;
        
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

    public static class RemoveServerBuildRequest {
        /**
         * unique identifier of the previously uploaded build executable to be removed
         */
        public String BuildId;
        
    }

    public static class RemoveServerBuildResult {
        
    }

    public static class RemoveVirtualCurrencyTypesRequest {
        /**
         * List of virtual currencies to delete
         */
        public ArrayList<VirtualCurrencyData> VirtualCurrencies;
        
    }

    public static class ResetCharacterStatisticsRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        
    }

    public static class ResetCharacterStatisticsResult {
        
    }

    public static class ResetUsersRequest {
        /**
         * Array of users to reset
         */
        public ArrayList<UserCredentials> Users;
        
    }

    public static class ResetUserStatisticsRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class ResetUserStatisticsResult {
        
    }

    public static class ResultTableNode {
        /**
         * Whether this entry in the table is an item or a link to another table
         */
        public ResultTableNodeType ResultItemType;
        /**
         * Either an ItemId, or the TableId of another random result table
         */
        public String ResultItem;
        /**
         * How likely this is to be rolled - larger numbers add more weight
         */
        public Integer Weight;
        
    }

    public static enum ResultTableNodeType {
        ItemId,
        TableId
    }

    public static class RevokeInventoryItemRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Unique PlayFab assigned instance identifier of the item
         */
        public String ItemInstanceId;
        
    }

    public static class RevokeInventoryResult {
        
    }

    public static class SendAccountRecoveryEmailRequest {
        /**
         * User email address attached to their account
         */
        public String Email;
        
    }

    public static class SendAccountRecoveryEmailResult {
        
    }

    public static class SetPublishedRevisionRequest {
        /**
         * Version number
         */
        public Integer Version;
        /**
         * Revision to make the current published revision
         */
        public Integer Revision;
        
    }

    public static class SetPublishedRevisionResult {
        
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

    public static class SetupPushNotificationRequest {
        /**
         * name of the application sending the message (application names must be made up of only uppercase and lowercase ASCII letters, numbers, underscores, hyphens, and periods, and must be between 1 and 256 characters long)
         */
        public String Name;
        /**
         * supported notification platforms are Apple Push Notification Service (APNS and APNS_SANDBOX) for iOS and Google Cloud Messaging (GCM) for Android
         */
        public String Platform;
        /**
         * for APNS, this is the PlatformPrincipal (SSL Certificate)
         */
        public String Key;
        /**
         * Credential is the Private Key for APNS/APNS_SANDBOX, and the API Key for GCM
         */
        public String Credential;
        /**
         * replace any existing ARN with the newly generated one. If this is set to false, an error will be returned if notifications have already setup for this platform.
         */
        public Boolean OverwriteOldARN;
        
    }

    public static class SetupPushNotificationResult {
        /**
         * Amazon Resource Name for the created notification topic.
         */
        public String ARN;
        
    }

    public static enum StatisticAggregationMethod {
        Last,
        Min,
        Max,
        Sum
    }

    public static enum StatisticResetIntervalOption {
        Never,
        Hour,
        Day,
        Week,
        Month
    }

    public static enum StatisticVersionArchivalStatus {
        NotScheduled,
        Scheduled,
        Queued,
        InProgress,
        Complete
    }
    /**
     *  A store entry that list a catalog item at a particular price
     */
    public static class StoreItem implements Comparable<StoreItem> {
        /**
         * unique identifier of the item as it exists in the catalog - note that this must exactly match the ItemId from the catalog
         */
        public String ItemId;
        /**
         * price of this item in virtual currencies and "RM" (the base Real Money purchase price, in USD pennies)
         */
        public Map<String,Long> VirtualCurrencyPrices;
        /**
         * override prices for this item for specific currencies
         */
        public Map<String,Long> RealCurrencyPrices;
        
        public int compareTo(StoreItem other) {
            if (other == null || other.ItemId == null) return 1;
            if (ItemId == null) return -1;
            return ItemId.compareTo(other.ItemId);
        }
        
    }

    public static class SubtractUserVirtualCurrencyRequest {
        /**
         * PlayFab unique identifier of the user whose virtual currency balance is to be decreased.
         */
        public String PlayFabId;
        /**
         * Name of the virtual currency which is to be decremented.
         */
        public String VirtualCurrency;
        /**
         * Amount to be subtracted from the user balance of the specified virtual currency.
         */
        public Integer Amount;
        
    }

    public static enum TitleActivationStatus {
        None,
        ActivatedTitleKey,
        PendingSteam,
        ActivatedSteam,
        RevokedSteam
    }

    public static class UpdateCatalogItemsRequest {
        /**
         * Which catalog is being updated. If null, uses the default catalog.
         */
        public String CatalogVersion;
        /**
         * Array of catalog items to be submitted. Note that while CatalogItem has a parameter for CatalogVersion, it is not required and ignored in this call.
         */
        public ArrayList<CatalogItem> Catalog;
        
    }

    public static class UpdateCatalogItemsResult {
        
    }

    public static class UpdateCloudScriptRequest {
        /**
         * Deprecated - unused
         */
        public Integer Version;
        /**
         * List of Cloud Script files to upload to create the new revision. Must have at least one file.
         */
        public ArrayList<CloudScriptFile> Files;
        /**
         * Immediately publish the new revision
         */
        public Boolean Publish;
        /**
         * PlayFab user ID of the developer initiating the request.
         */
        public String DeveloperPlayFabId;
        
    }

    public static class UpdateCloudScriptResult {
        /**
         * Cloud Script version updated
         */
        public Integer Version;
        /**
         * New revision number created
         */
        public Integer Revision;
        
    }

    public static class UpdatePlayerStatisticDefinitionRequest {
        /**
         * unique name of the statistic
         */
        public String StatisticName;
        /**
         * interval at which the values of the statistic for all players are reset (changes are effective at the next occurance of the new interval boundary)
         */
        public StatisticResetIntervalOption VersionChangeInterval;
        /**
         * the aggregation method to use in updating the statistic (defaults to last)
         */
        public StatisticAggregationMethod AggregationMethod;
        
    }

    public static class UpdatePlayerStatisticDefinitionResult {
        /**
         * updated statistic definition
         */
        public PlayerStatisticDefinition Statistic;
        
    }

    public static class UpdateRandomResultTablesRequest {
        /**
         * which catalog is being updated. If null, update the current default catalog version
         */
        public String CatalogVersion;
        /**
         * array of random result tables to make available (Note: specifying an existing TableId will result in overwriting that table, while any others will be added to the available set)
         */
        public ArrayList<RandomResultTable> Tables;
        
    }

    public static class UpdateRandomResultTablesResult {
        
    }

    public static class UpdateStoreItemsRequest {
        /**
         * catalog version of the store to update. If null, uses the default catalog.
         */
        public String CatalogVersion;
        /**
         * unqiue identifier for the store which is to be updated
         */
        public String StoreId;
        /**
         * array of store items - references to catalog items, with specific pricing - to be added
         */
        public ArrayList<StoreItem> Store;
        
    }

    public static class UpdateStoreItemsResult {
        
    }

    public static class UpdateUserDataRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character.
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
        
    }

    public static class UpdateUserDataResult {
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        
    }

    public static class UpdateUserInternalDataRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character.
         */
        public Map<String,String> Data;
        /**
         * Optional list of Data-keys to remove from UserData.  Some SDKs cannot insert null-values into Data due to language constraints.  Use this to delete the keys directly.
         */
        public ArrayList<String> KeysToRemove;
        
    }

    public static class UpdateUserTitleDisplayNameRequest {
        /**
         * PlayFab unique identifier of the user whose title specific display name is to be changed
         */
        public String PlayFabId;
        /**
         * new title display name for the user - must be between 3 and 25 characters
         */
        public String DisplayName;
        
    }

    public static class UpdateUserTitleDisplayNameResult {
        /**
         * current title display name for the user (this will be the original display name if the rename attempt failed)
         */
        public String DisplayName;
        
    }

    public static class UserAccountInfo {
        /**
         * Unique identifier for the user account
         */
        public String PlayFabId;
        /**
         * Timestamp indicating when the user account was created
         */
        public Date Created;
        /**
         * User account name in the PlayFab service
         */
        public String Username;
        /**
         * Title-specific information for the user account
         */
        public UserTitleInfo TitleInfo;
        /**
         * Personal information for the user which is considered more sensitive
         */
        public UserPrivateAccountInfo PrivateInfo;
        /**
         * User Facebook information, if a Facebook account has been linked
         */
        public UserFacebookInfo FacebookInfo;
        /**
         * User Steam information, if a Steam account has been linked
         */
        public UserSteamInfo SteamInfo;
        /**
         * User Gamecenter information, if a Gamecenter account has been linked
         */
        public UserGameCenterInfo GameCenterInfo;
        /**
         * User iOS device information, if an iOS device has been linked
         */
        public UserIosDeviceInfo IosDeviceInfo;
        /**
         * User Android device information, if an Android device has been linked
         */
        public UserAndroidDeviceInfo AndroidDeviceInfo;
        /**
         * User Kongregate account information, if a Kongregate account has been linked
         */
        public UserKongregateInfo KongregateInfo;
        /**
         * User Twitch account information, if a Twitch account has been linked
         */
        public UserTwitchInfo TwitchInfo;
        /**
         * User PSN account information, if a PSN account has been linked
         */
        public UserPsnInfo PsnInfo;
        /**
         * User Google account information, if a Google account has been linked
         */
        public UserGoogleInfo GoogleInfo;
        /**
         * User XBox account information, if a XBox account has been linked
         */
        public UserXboxInfo XboxInfo;
        /**
         * Custom ID information, if a custom ID has been assigned
         */
        public UserCustomIdInfo CustomIdInfo;
        
    }

    public static class UserAndroidDeviceInfo {
        /**
         * Android device ID
         */
        public String AndroidDeviceId;
        
    }

    public static class UserCredentials {
        /**
         * Username of user to reset
         */
        public String Username;
        /**
         * Password for the PlayFab account (6-100 characters)
         */
        public String Password;
        
    }

    public static class UserCustomIdInfo {
        /**
         * Custom ID
         */
        public String CustomId;
        
    }
    /**
     *  Indicates whether a given data key is private (readable only by the player) or public (readable by all players). When a player makes a GetUserData request about another player, only keys marked Public will be returned.
     */ 
    public static enum UserDataPermission {
        Private,
        Public
    }

    public static class UserDataRecord {
        /**
         * Data stored for the specified user data key.
         */
        public String Value;
        /**
         * Timestamp for when this data was last updated.
         */
        public Date LastUpdated;
        /**
         * Indicates whether this data can be read by all users (public) or only the user (private). This is used for GetUserData requests being made by one player about another player.
         */
        public UserDataPermission Permission;
        
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
         * Google ID
         */
        public String GoogleId;
        /**
         * Email address of the Google account
         */
        public String GoogleEmail;
        /**
         * Locale of the Google account
         */
        public String GoogleLocale;
        /**
         * Gender information of the Google account
         */
        public String GoogleGender;
        
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
        Twitch
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
         * Steam identifier
         */
        public String SteamId;
        /**
         * the country in which the player resides, from Steam data
         */
        public String SteamCountry;
        /**
         * currency type set in the user Steam account
         */
        public Currency SteamCurrency;
        /**
         * what stage of game ownership the user is listed as being in, from Steam
         */
        public TitleActivationStatus SteamActivationStatus;
        
    }

    public static class UserTitleInfo {
        /**
         * name of the user, as it is displayed in-game
         */
        public String DisplayName;
        /**
         * source by which the user first joined the game, if known
         */
        public UserOrigination Origination;
        /**
         * timestamp indicating when the user was first associated with this game (this can differ significantly from when the user first registered with PlayFab)
         */
        public Date Created;
        /**
         * timestamp for the last user login for this title
         */
        public Date LastLogin;
        /**
         * timestamp indicating when the user first signed into this game (this can differ from the Created timestamp, as other events, such as issuing a beta key to the user, can associate the title to the user)
         */
        public Date FirstLogin;
        /**
         * boolean indicating whether or not the user is currently banned for a title
         */
        public Boolean isBanned;
        
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

    public static class VirtualCurrencyData {
        /**
         * unique one- or two-character identifier for this currency type (e.g.: "CC", "G")
         */
        public String CurrencyCode;
        /**
         * friendly name to show in the developer portal, reports, etc.
         */
        public String DisplayName;
        /**
         * amount to automatically grant users upon first login to the title
         */
        public Integer InitialDeposit;
        /**
         * rate at which the currency automatically be added to over time, in units per day (24 hours)
         */
        public Integer RechargeRate;
        /**
         * maximum amount to which the currency will recharge (cannot exceed MaxAmount, but can be less)
         */
        public Integer RechargeMax;
        
    }

    public static class VirtualCurrencyRechargeTime {
        /**
         * Time remaining (in seconds) before the next recharge increment of the virtual currency.
         */
        public Integer SecondsToRecharge;
        /**
         * Server timestamp in UTC indicating the next time the virtual currency will be incremented.
         */
        public Date RechargeTime;
        /**
         * Maximum value to which the regenerating currency will automatically increment. Note that it can exceed this value through use of the AddUserVirtualCurrency API call. However, it will not regenerate automatically until it has fallen below this value.
         */
        public Integer RechargeMax;
        
    }

}
