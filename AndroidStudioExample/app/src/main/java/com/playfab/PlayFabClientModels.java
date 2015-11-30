package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabClientModels {

    public static class AcceptTradeRequest {
        /**
         * Player who opened trade.
         */
        public String OfferingPlayerId;
        /**
         * Trade identifier.
         */
        public String TradeId;
        /**
         * Items from the accepting player's inventory in exchange for the offered items in the trade. In the case of a gift, this will be null.
         */
        public ArrayList<String> AcceptedInventoryInstanceIds;
        
    }

    public static class AcceptTradeResponse {
        public TradeInfo Trade;
        
    }

    public static class AddFriendRequest {
        /**
         * PlayFab identifier of the user to attempt to add to the local user's friend list.
         */
        public String FriendPlayFabId;
        /**
         * PlayFab username of the user to attempt to add to the local user's friend list.
         */
        public String FriendUsername;
        /**
         * Email address of the user to attempt to add to the local user's friend list.
         */
        public String FriendEmail;
        /**
         * Title-specific display name of the user to attempt to add to the local user's friend list.
         */
        public String FriendTitleDisplayName;
        
    }

    public static class AddFriendResult {
        /**
         * True if the friend request was processed successfully.
         */
        public Boolean Created;
        
    }

    public static class AddSharedGroupMembersRequest {
        /**
         * Unique identifier for the shared group.
         */
        public String SharedGroupId;
        /**
         * An array of unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public ArrayList<String> PlayFabIds;
        
    }

    public static class AddSharedGroupMembersResult {
        
    }

    public static class AddUsernamePasswordRequest {
        /**
         * PlayFab username for the account (3-20 characters)
         */
        public String Username;
        /**
         * User email address attached to their account
         */
        public String Email;
        /**
         * Password for the PlayFab account (6-30 characters)
         */
        public String Password;
        
    }

    public static class AddUsernamePasswordResult {
        /**
         * PlayFab unique user name.
         */
        public String Username;
        
    }

    public static class AddUserVirtualCurrencyRequest {
        /**
         * Name of the virtual currency which is to be incremented.
         */
        public String VirtualCurrency;
        /**
         * Amount to be added to the user balance of the specified virtual currency.
         */
        public Integer Amount;
        
    }

    public static class AndroidDevicePushNotificationRegistrationRequest {
        /**
         * Registration ID provided by the Google Cloud Messaging service when the title registered to receive push notifications (see the GCM documentation, here: http://developer.android.com/google/gcm/client.html).
         */
        public String DeviceToken;
        /**
         * If true, send a test push message immediately after sucessful registration. Defaults to false.
         */
        public Boolean SendPushNotificationConfirmation;
        /**
         * Message to display when confirming push notification.
         */
        public String ConfirmationMessege;
        
    }

    public static class AndroidDevicePushNotificationRegistrationResult {
        
    }

    public static class CancelTradeRequest {
        /**
         * Trade identifier.
         */
        public String TradeId;
        
    }

    public static class CancelTradeResponse {
        public TradeInfo Trade;
        
    }

    public static class CartItem {
        /**
         * Unique identifier for the catalog item.
         */
        public String ItemId;
        /**
         * Class name to which catalog item belongs.
         */
        public String ItemClass;
        /**
         * Unique instance identifier for this catalog item.
         */
        public String ItemInstanceId;
        /**
         * Display name for the catalog item.
         */
        public String DisplayName;
        /**
         * Description of the catalog item.
         */
        public String Description;
        /**
         * Cost of the catalog item for each applicable virtual currency.
         */
        public Map<String,Long> VirtualCurrencyPrices;
        /**
         * Cost of the catalog item for each applicable real world currency.
         */
        public Map<String,Long> RealCurrencyPrices;
        /**
         * Amount of each applicable virtual currency which will be received as a result of purchasing this catalog item.
         */
        public Map<String,Long> VCAmount;
        
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

    public static class CharacterLeaderboardEntry {
        /**
         * PlayFab unique identifier of the user for this leaderboard entry.
         */
        public String PlayFabId;
        /**
         * PlayFab unique identifier of the character that belongs to the user for this leaderboard entry.
         */
        public String CharacterId;
        /**
         * Title-specific display name of the character for this leaderboard entry.
         */
        public String CharacterName;
        /**
         * Title-specific display name of the user for this leaderboard entry.
         */
        public String DisplayName;
        /**
         * Name of the character class for this entry.
         */
        public String CharacterType;
        /**
         * Specific value of the user's statistic.
         */
        public Integer StatValue;
        /**
         * User's overall position in the leaderboard.
         */
        public Integer Position;
        
    }

    public static class CharacterResult {
        public String CharacterId;
        public String CharacterName;
        public String CharacterType;
        
    }

    public static class ConfirmPurchaseRequest {
        /**
         * Purchase order identifier returned from StartPurchase.
         */
        public String OrderId;
        
    }

    public static class ConfirmPurchaseResult {
        /**
         * Purchase order identifier.
         */
        public String OrderId;
        /**
         * Date and time of the purchase.
         */
        public Date PurchaseDate;
        /**
         * Array of items purchased.
         */
        public ArrayList<ItemInstance> Items;
        
    }

    public static class ConsumeItemRequest {
        /**
         * Unique instance identifier of the item to be consumed.
         */
        public String ItemInstanceId;
        /**
         * Number of uses to consume from the item.
         */
        public Integer ConsumeCount;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        
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

    public static class ConsumePSNEntitlementsRequest {
        /**
         * Which catalog to match granted entitlements against. If null, defaults to title default catalog
         */
        public String CatalogVersion;
        /**
         * Id of the PSN service label to consume entitlements from
         */
        public Integer ServiceLabel;
        
    }

    public static class ConsumePSNEntitlementsResult {
        /**
         * Array of items granted to the player as a result of consuming entitlements.
         */
        @Unordered("ItemInstanceId")
		public ArrayList<ItemInstance> ItemsGranted;
        
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

    public static class CurrentGamesRequest {
        /**
         * region to check for game instances
         */
        public Region Region;
        /**
         * version of build to match against
         */
        public String BuildVersion;
        /**
         * game mode to look for (optional)
         */
        public String GameMode;
        /**
         * statistic name to find statistic-based matches (optional)
         */
        public String StatisticName;
        
    }

    public static class CurrentGamesResult {
        /**
         * array of games found
         */
        public ArrayList<GameInfo> Games;
        /**
         * total number of players across all servers
         */
        public Integer PlayerCount;
        /**
         * number of games running
         */
        public Integer GameCount;
        
    }

    public static class EmptyResult {
        
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
         * PlayFab unique identifier for this friend.
         */
        public String FriendPlayFabId;
        /**
         * PlayFab unique username for this friend.
         */
        public String Username;
        /**
         * Title-specific display name for this friend.
         */
        public String TitleDisplayName;
        /**
         * Tags which have been associated with this friend.
         */
        public ArrayList<String> Tags;
        /**
         * Unique lobby identifier of the Game Server Instance to which this player is currently connected.
         */
        public String CurrentMatchmakerLobbyId;
        /**
         * Available Facebook information (if the user and PlayFab friend are also connected in Facebook).
         */
        public UserFacebookInfo FacebookInfo;
        /**
         * Available Steam information (if the user and PlayFab friend are also connected in Steam).
         */
        public UserSteamInfo SteamInfo;
        /**
         * Available Game Center information (if the user and PlayFab friend are also connected in Game Center).
         */
        public UserGameCenterInfo GameCenterInfo;
        
    }

    public static class GameCenterPlayFabIdPair {
        /**
         * Unique Game Center identifier for a user.
         */
        public String GameCenterId;
        /**
         * Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Game Center identifier.
         */
        public String PlayFabId;
        
    }

    public static class GameInfo {
        /**
         * region to which this server is associated
         */
        public Region Region;
        /**
         * unique lobby identifier for this game server
         */
        public String LobbyID;
        /**
         * build version this server is running
         */
        public String BuildVersion;
        /**
         * game mode this server is running
         */
        public String GameMode;
        /**
         * stastic used to match this game in player statistic matchmaking
         */
        public String StatisticName;
        /**
         * maximum players this server can support
         */
        public Integer MaxPlayers;
        /**
         * array of strings of current player names on this server (note that these are PlayFab usernames, as opposed to title display names)
         */
        public ArrayList<String> PlayerUserIds;
        /**
         * duration in seconds this server has been running
         */
        public Long RunTime;
        /**
         * game specific string denoting server configuration
         */
        public String GameServerState;
        
    }

    public static class GameServerRegionsRequest {
        /**
         * version of game server for which stats are being requested
         */
        public String BuildVersion;
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        
    }

    public static class GameServerRegionsResult {
        /**
         * array of regions found matching the request parameters
         */
        public ArrayList<RegionInfo> Regions;
        
    }

    public static class GetAccountInfoRequest {
        /**
         * Unique PlayFab identifier of the user whose info is being requested. Optional, defaults to the authenticated user if no other lookup identifier set.
         */
        public String PlayFabId;
        /**
         * PlayFab Username for the account to find (if no PlayFabId is specified).
         */
        public String Username;
        /**
         * User email address for the account to find (if no Username is specified).
         */
        public String Email;
        /**
         * Title-specific username for the account to find (if no Email is set).
         */
        public String TitleDisplayName;
        
    }

    public static class GetAccountInfoResult {
        /**
         * Account information for the local user.
         */
        public UserAccountInfo AccountInfo;
        
    }

    public static class GetCatalogItemsRequest {
        /**
         * Which catalog is being requested.
         */
        public String CatalogVersion;
        
    }

    public static class GetCatalogItemsResult {
        /**
         * Array of inventory objects.
         */
        @Unordered("ItemId")
		public ArrayList<CatalogItem> Catalog;
        
    }

    public static class GetCharacterDataRequest {
        /**
         * Unique PlayFab identifier of the user to load data for. Optional, defaults to yourself if not set.
         */
        public String PlayFabId;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Specific keys to search for in the custom user data.
         */
        public ArrayList<String> Keys;
        /**
         * The version that currently exists according to the caller. The call will return the data for all of the keys if the version in the system is greater than this.
         */
        public Integer IfChangedFromDataVersion;
        
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
        
    }

    public static class GetCharacterInventoryRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        /**
         * Used to limit results to only those from a specific catalog version.
         */
        public String CatalogVersion;
        
    }

    public static class GetCharacterInventoryResult {
        /**
         * PlayFab unique identifier of the user whose character inventory is being returned.
         */
        public String PlayFabId;
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
         * Optional character type on which to filter the leaderboard entries.
         */
        public String CharacterType;
        /**
         * Unique identifier for the title-specific statistic for the leaderboard.
         */
        public String StatisticName;
        /**
         * First entry in the leaderboard to be retrieved.
         */
        public Integer StartPosition;
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        
    }

    public static class GetCharacterLeaderboardResult {
        /**
         * Ordered list of leaderboard entries.
         */
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    public static class GetCloudScriptUrlRequest {
        /**
         * Cloud Script Version to use. Defaults to 1.
         */
        public Integer Version;
        /**
         * Specifies whether the URL returned should be the one for the most recently uploaded Revision of the Cloud Script (true), or the Revision most recently set to live (false). Defaults to false.
         */
        public Boolean Testing;
        
    }

    public static class GetCloudScriptUrlResult {
        /**
         * URL of the Cloud Script logic server.
         */
        public String Url;
        
    }

    public static class GetContentDownloadUrlRequest {
        /**
         * Key of the content item to fetch, usually formatted as a path, e.g. images/a.png
         */
        public String Key;
        /**
         * HTTP method to fetch item - GET or HEAD. Use HEAD when only fetching metadata. Default is GET.
         */
        public String HttpMethod;
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
         * Statistic used to rank friends for this leaderboard.
         */
        public String StatisticName;
        /**
         * Position in the leaderboard to start this listing (defaults to the first entry).
         */
        public Integer StartPosition;
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        /**
         * Indicates whether Steam service friends should be included in the response. Default is true.
         */
        public Boolean IncludeSteamFriends;
        /**
         * Indicates whether Facebook friends should be included in the response. Default is true.
         */
        public Boolean IncludeFacebookFriends;
        
    }

    public static class GetFriendsListRequest {
        /**
         * Indicates whether Steam service friends should be included in the response. Default is true.
         */
        public Boolean IncludeSteamFriends;
        /**
         * Indicates whether Facebook friends should be included in the response. Default is true.
         */
        public Boolean IncludeFacebookFriends;
        
    }

    public static class GetFriendsListResult {
        /**
         * Array of friends found.
         */
        public ArrayList<FriendInfo> Friends;
        
    }

    public static class GetLeaderboardAroundCharacterRequest {
        /**
         * Unique identifier for the title-specific statistic for the leaderboard.
         */
        public String StatisticName;
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
        
    }

    public static class GetLeaderboardAroundCharacterResult {
        /**
         * Ordered list of leaderboard entries.
         */
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    public static class GetLeaderboardAroundCurrentUserRequest {
        /**
         * Statistic used to rank players for this leaderboard.
         */
        public String StatisticName;
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        
    }

    public static class GetLeaderboardAroundCurrentUserResult {
        /**
         * Ordered listing of users and their positions in the requested leaderboard.
         */
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        
    }

    public static class GetLeaderboardForUsersCharactersRequest {
        /**
         * Unique identifier for the title-specific statistic for the leaderboard.
         */
        public String StatisticName;
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        
    }

    public static class GetLeaderboardForUsersCharactersResult {
        /**
         * Ordered list of leaderboard entries.
         */
        public ArrayList<CharacterLeaderboardEntry> Leaderboard;
        
    }

    public static class GetLeaderboardRequest {
        /**
         * Statistic used to rank players for this leaderboard.
         */
        public String StatisticName;
        /**
         * Position in the leaderboard to start this listing (defaults to the first entry).
         */
        public Integer StartPosition;
        /**
         * Maximum number of entries to retrieve.
         */
        public Integer MaxResultsCount;
        
    }

    public static class GetLeaderboardResult {
        /**
         * Ordered listing of users and their positions in the requested leaderboard.
         */
        public ArrayList<PlayerLeaderboardEntry> Leaderboard;
        
    }

    public static class GetPhotonAuthenticationTokenRequest {
        public String PhotonApplicationId;
        
    }

    public static class GetPhotonAuthenticationTokenResult {
        public String PhotonCustomAuthenticationToken;
        
    }

    public static class GetPlayerTradesRequest {
        /**
         * Returns only trades with the given status. If null, returns all trades.
         */
        public TradeStatus StatusFilter;
        
    }

    public static class GetPlayerTradesResponse {
        public ArrayList<TradeInfo> OpenedTrades;
        public ArrayList<TradeInfo> AcceptedTrades;
        
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

    public static class GetPlayFabIDsFromGameCenterIDsRequest {
        /**
         * Array of unique Game Center identifiers (the Player Identifier) for which the title needs to get PlayFab identifiers.
         */
        public ArrayList<String> GameCenterIDs;
        
    }

    public static class GetPlayFabIDsFromGameCenterIDsResult {
        /**
         * Mapping of Game Center identifiers to PlayFab identifiers.
         */
        public ArrayList<GameCenterPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromGoogleIDsRequest {
        /**
         * Array of unique Google identifiers (Google+ user IDs) for which the title needs to get PlayFab identifiers.
         */
        public ArrayList<String> GoogleIDs;
        
    }

    public static class GetPlayFabIDsFromGoogleIDsResult {
        /**
         * Mapping of Google identifiers to PlayFab identifiers.
         */
        public ArrayList<GooglePlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromPSNAccountIDsRequest {
        /**
         * Array of unique PlayStation Network identifiers for which the title needs to get PlayFab identifiers.
         */
        public ArrayList<String> PSNAccountIDs;
        /**
         * Id of the PSN issuer environment. If null, defaults to 256 (production)
         */
        public Integer IssuerId;
        
    }

    public static class GetPlayFabIDsFromPSNAccountIDsResult {
        /**
         * Mapping of PlayStation Network identifiers to PlayFab identifiers.
         */
        public ArrayList<PSNAccountPlayFabIdPair> Data;
        
    }

    public static class GetPlayFabIDsFromSteamIDsRequest {
        /**
         * Array of unique Steam identifiers (Steam profile IDs) for which the title needs to get PlayFab identifiers.
         */
        public ArrayList<Long> SteamIDs;
        
    }

    public static class GetPlayFabIDsFromSteamIDsResult {
        /**
         * Mapping of Steam identifiers to PlayFab identifiers.
         */
        public ArrayList<SteamPlayFabIdPair> Data;
        
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

    public static class GetPurchaseRequest {
        /**
         * Purchase order identifier.
         */
        public String OrderId;
        
    }

    public static class GetPurchaseResult {
        /**
         * Purchase order identifier.
         */
        public String OrderId;
        /**
         * Payment provider used for transaction (If not VC)
         */
        public String PaymentProvider;
        /**
         * Provider transaction ID (If not VC)
         */
        public String TransactionId;
        /**
         * PlayFab transaction status
         */
        public String TransactionStatus;
        /**
         * Date and time of the purchase.
         */
        public Date PurchaseDate;
        /**
         * Array of items purchased.
         */
        public ArrayList<ItemInstance> Items;
        
    }

    public static class GetSharedGroupDataRequest {
        /**
         * Unique identifier for the shared group.
         */
        public String SharedGroupId;
        /**
         * Specific keys to retrieve from the shared group (if not specified, all keys will be returned, while an empty array indicates that no keys should be returned).
         */
        public ArrayList<String> Keys;
        /**
         * If true, return the list of all members of the shared group.
         */
        public Boolean GetMembers;
        
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

    public static class GetStoreItemsRequest {
        /**
         * Unqiue identifier for the store which is being requested.
         */
        public String StoreId;
        /**
         * Catalog version for the requested store items. If null, defaults to most recent catalog.
         */
        public String CatalogVersion;
        
    }

    public static class GetStoreItemsResult {
        /**
         * Array of store items.
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

    public static class GetTradeStatusRequest {
        /**
         * Player who opened trade.
         */
        public String OfferingPlayerId;
        /**
         * Trade identifier as returned by OpenTradeOffer.
         */
        public String TradeId;
        
    }

    public static class GetTradeStatusResponse {
        public TradeInfo Trade;
        
    }

    public static class GetUserCombinedInfoRequest {
        /**
         * Unique PlayFab identifier of the user whose info is being requested. Optional, defaults to the authenticated user if no other lookup identifier set.
         */
        public String PlayFabId;
        /**
         * PlayFab Username for the account to find (if no PlayFabId is specified).
         */
        public String Username;
        /**
         * User email address for the account to find (if no Username is specified).
         */
        public String Email;
        /**
         * Title-specific username for the account to find (if no Email is set).
         */
        public String TitleDisplayName;
        /**
         * If set to false, account info will not be returned. Defaults to true.
         */
        public Boolean GetAccountInfo;
        /**
         * If set to false, inventory will not be returned. Defaults to true. Inventory will never be returned for users other than yourself.
         */
        public Boolean GetInventory;
        /**
         * If set to false, virtual currency balances will not be returned. Defaults to true. Currency balances will never be returned for users other than yourself.
         */
        public Boolean GetVirtualCurrency;
        /**
         * If set to false, custom user data will not be returned. Defaults to true.
         */
        public Boolean GetUserData;
        /**
         * User custom data keys to return. If set to null, all keys will be returned. For users other than yourself, only public data will be returned.
         */
        public ArrayList<String> UserDataKeys;
        /**
         * If set to false, read-only user data will not be returned. Defaults to true.
         */
        public Boolean GetReadOnlyData;
        /**
         * User read-only custom data keys to return. If set to null, all keys will be returned. For users other than yourself, only public data will be returned.
         */
        public ArrayList<String> ReadOnlyDataKeys;
        
    }

    public static class GetUserCombinedInfoResult {
        /**
         * Unique PlayFab identifier of the owner of the combined info.
         */
        public String PlayFabId;
        /**
         * Account information for the user.
         */
        public UserAccountInfo AccountInfo;
        /**
         * Array of inventory items in the user's current inventory.
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
        /**
         * User specific custom data.
         */
        public Map<String,UserDataRecord> Data;
        /**
         * The version of the UserData that was returned.
         */
        public Long DataVersion;
        /**
         * User specific read-only data.
         */
        public Map<String,UserDataRecord> ReadOnlyData;
        /**
         * The version of the Read-Only UserData that was returned.
         */
        public Long ReadOnlyDataVersion;
        
    }

    public static class GetUserDataRequest {
        /**
         * Specific keys to search for in the custom data. Leave null to get all keys.
         */
        public ArrayList<String> Keys;
        /**
         * Unique PlayFab identifier of the user to load data for. Optional, defaults to yourself if not set.
         */
        public String PlayFabId;
        /**
         * The version that currently exists according to the caller. The call will return the data for all of the keys if the version in the system is greater than this.
         */
        public Integer IfChangedFromDataVersion;
        
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
        
    }

    public static class GetUserInventoryRequest {
        
    }

    public static class GetUserInventoryResult {
        /**
         * Array of inventory items in the user's current inventory.
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

    public static class GetUserStatisticsRequest {
        
    }

    public static class GetUserStatisticsResult {
        /**
         * User statistics for the active title.
         */
        public Map<String,Integer> UserStatistics;
        
    }

    public static class GooglePlayFabIdPair {
        /**
         * Unique Google identifier for a user.
         */
        public String GoogleId;
        /**
         * Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Google identifier.
         */
        public String PlayFabId;
        
    }

    public static class GrantCharacterToUserRequest {
        /**
         * Catalog version from which items are to be granted.
         */
        public String CatalogVersion;
        /**
         * Catalog item identifier of the item in the user's inventory that corresponds to the character in the catalog to be created.
         */
        public String ItemId;
        /**
         * Non-unique display name of the character being granted.
         */
        public String CharacterName;
        
    }

    public static class GrantCharacterToUserResult {
        /**
         * Unique identifier tagged to this character.
         */
        public String CharacterId;
        /**
         * Type of character that was created.
         */
        public String CharacterType;
        public Boolean Result;
        
    }
    /**
     *  A unique instance of an item in a user's inventory
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

    public static class ItemPuchaseRequest {
        /**
         * Unique ItemId of the item to purchase.
         */
        public String ItemId;
        /**
         * How many of this item to purchase.
         */
        public Long Quantity;
        /**
         * Title-specific text concerning this purchase.
         */
        public String Annotation;
        /**
         * Items to be upgraded as a result of this purchase (upgraded items are hidden, as they are "replaced" by the new items).
         */
        public ArrayList<String> UpgradeFromItems;
        
    }

    public static class LinkAndroidDeviceIDRequest {
        /**
         * Android device identifier for the user's device.
         */
        public String AndroidDeviceId;
        /**
         * Specific Operating System version for the user's device.
         */
        public String OS;
        /**
         * Specific model of the user's device.
         */
        public String AndroidDevice;
        
    }

    public static class LinkAndroidDeviceIDResult {
        
    }

    public static class LinkCustomIDRequest {
        /**
         * Custom unique identifier for the user, generated by the title.
         */
        public String CustomId;
        
    }

    public static class LinkCustomIDResult {
        
    }

    public static class LinkFacebookAccountRequest {
        /**
         * Unique identifier from Facebook for the user.
         */
        public String AccessToken;
        /**
         * If this Facebook account is already linked to a Playfab account, this will unlink the old account before linking the new one. Be careful when using this call, as it may orphan the old account. Defaults to false.
         */
        public Boolean ForceLink;
        
    }

    public static class LinkFacebookAccountResult {
        
    }

    public static class LinkGameCenterAccountRequest {
        /**
         * Game Center identifier for the player account to be linked.
         */
        public String GameCenterId;
        
    }

    public static class LinkGameCenterAccountResult {
        
    }

    public static class LinkGoogleAccountRequest {
        /**
         * Unique token from Google Play for the user.
         */
        public String AccessToken;
        
    }

    public static class LinkGoogleAccountResult {
        
    }

    public static class LinkIOSDeviceIDRequest {
        /**
         * Vendor-specific iOS identifier for the user's device.
         */
        public String DeviceId;
        /**
         * Specific Operating System version for the user's device.
         */
        public String OS;
        /**
         * Specific model of the user's device.
         */
        public String DeviceModel;
        
    }

    public static class LinkIOSDeviceIDResult {
        
    }

    public static class LinkKongregateAccountRequest {
        /**
         * Numeric user ID assigned by Kongregate
         */
        public String KongregateId;
        /**
         * Valid session auth ticket issued by Kongregate
         */
        public String AuthTicket;
        
    }

    public static class LinkKongregateAccountResult {
        
    }

    public static class LinkPSNAccountRequest {
        /**
         * Authentication code provided by the PlayStation Network.
         */
        public String AuthCode;
        /**
         * Redirect URI supplied to PSN when requesting an auth code
         */
        public String RedirectUri;
        /**
         * Id of the PSN issuer environment. If null, defaults to 256 (production)
         */
        public Integer IssuerId;
        
    }

    public static class LinkPSNAccountResult {
        
    }

    public static class LinkSteamAccountRequest {
        /**
         * Authentication token for the user, returned as a byte array from Steam, and converted to a string (for example, the byte 0x08 should become "08").
         */
        public String SteamTicket;
        
    }

    public static class LinkSteamAccountResult {
        
    }

    public static class ListUsersCharactersRequest {
        /**
         * Unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public String PlayFabId;
        
    }

    public static class ListUsersCharactersResult {
        public ArrayList<CharacterResult> Characters;
        
    }

    public static class LogEventRequest {
        /**
         * Optional timestamp for this event. If null, the a timestamp is auto-assigned to the event on the server.
         */
        public Date Timestamp;
        /**
         * A unique event name which will be used as the table name in the Redshift database. The name will be made lower case, and cannot not contain spaces. The use of underscores is recommended, for readability. Events also cannot match reserved terms. The PlayFab reserved terms are 'log_in' and 'purchase', 'create' and 'request', while the Redshift reserved terms can be found here: http://docs.aws.amazon.com/redshift/latest/dg/r_pg_keywords.html.
         */
        public String EventName;
        /**
         * Contains all the data for this event. Event Values can be strings, booleans or numerics (float, double, integer, long) and must be consistent on a per-event basis (if the Value for Key 'A' in Event 'Foo' is an integer the first time it is sent, it must be an integer in all subsequent 'Foo' events). As with event names, Keys must also not use reserved words (see above). Finally, the size of the Body for an event must be less than 32KB (UTF-8 format).
         */
        public Map<String,Object> Body;
        /**
         * Flag to set event Body as profile details in the Redshift database as well as a standard event.
         */
        public Boolean ProfileSetEvent;
        
    }

    public static class LogEventResult {
        
    }

    public static class LoginResult {
        /**
         * Unique token authorizing the user and game at the server level, for the current session.
         */
        public String SessionTicket;
        /**
         * Player's unique PlayFabId.
         */
        public String PlayFabId;
        /**
         * True if the account was newly created on this login.
         */
        public Boolean NewlyCreated;
        /**
         * Settings specific to this user.
         */
        public UserSettings SettingsForUser;
        
    }

    public static class LoginWithAndroidDeviceIDRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * Android device identifier for the user's device.
         */
        public String AndroidDeviceId;
        /**
         * Specific Operating System version for the user's device.
         */
        public String OS;
        /**
         * Specific model of the user's device.
         */
        public String AndroidDevice;
        /**
         * Automatically create a PlayFab account if one is not currently linked to this Android device.
         */
        public Boolean CreateAccount;
        
    }

    public static class LoginWithCustomIDRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * Custom unique identifier for the user, generated by the title.
         */
        public String CustomId;
        /**
         * Automatically create a PlayFab account if one is not currently linked to this Custom ID.
         */
        public Boolean CreateAccount;
        
    }

    public static class LoginWithEmailAddressRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * Email address for the account.
         */
        public String Email;
        /**
         * Password for the PlayFab account (6-30 characters)
         */
        public String Password;
        
    }

    public static class LoginWithFacebookRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * Unique identifier from Facebook for the user.
         */
        public String AccessToken;
        /**
         * Automatically create a PlayFab account if one is not currently linked to this Facebook account.
         */
        public Boolean CreateAccount;
        
    }

    public static class LoginWithGoogleAccountRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * Unique token from Google Play for the user.
         */
        public String AccessToken;
        /**
         * Automatically create a PlayFab account if one is not currently linked to this Google account.
         */
        public Boolean CreateAccount;
        public String PublisherId;
        
    }

    public static class LoginWithIOSDeviceIDRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * Vendor-specific iOS identifier for the user's device.
         */
        public String DeviceId;
        /**
         * Specific Operating System version for the user's device.
         */
        public String OS;
        /**
         * Specific model of the user's device.
         */
        public String DeviceModel;
        /**
         * Automatically create a PlayFab account if one is not currently linked to this iOS device.
         */
        public Boolean CreateAccount;
        
    }

    public static class LoginWithKongregateRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * Unique identifier from Kongregate for the user.
         */
        public String KongregateId;
        /**
         * Token issued by Kongregate's client API for the user.
         */
        public String AuthTicket;
        /**
         * Automatically create a PlayFab account if one is not currently linked to this Kongregate account.
         */
        public Boolean CreateAccount;
        
    }

    public static class LoginWithPlayFabRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * PlayFab username for the account.
         */
        public String Username;
        /**
         * Password for the PlayFab account (6-30 characters)
         */
        public String Password;
        
    }

    public static class LoginWithPSNRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * Auth code provided by the PSN OAuth provider.
         */
        public String AuthCode;
        /**
         * Redirect URI supplied to PSN when requesting an auth code
         */
        public String RedirectUri;
        /**
         * Id of the PSN issuer environment. If null, defaults to 256 (production)
         */
        public Integer IssuerId;
        /**
         * Automatically create a PlayFab account if one is not currently linked to this PSN account.
         */
        public Boolean CreateAccount;
        
    }

    public static class LoginWithSteamRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * Authentication token for the user, returned as a byte array from Steam, and converted to a string (for example, the byte 0x08 should become "08").
         */
        public String SteamTicket;
        /**
         * Automatically create a PlayFab account if one is not currently linked to this Steam account.
         */
        public Boolean CreateAccount;
        
    }

    public static class MatchmakeRequest {
        /**
         * build version to match against
         */
        public String BuildVersion;
        /**
         * region to match make against
         */
        public Region Region;
        /**
         * game mode to match make against
         */
        public String GameMode;
        /**
         * lobby identifier to match make against (used to select a specific server)
         */
        public String LobbyId;
        /**
         * player statistic to use in finding a match. May be null for no stat-based matching
         */
        public String StatisticName;
        /**
         * character to use for stats based matching. Leave null to use account stats
         */
        public String CharacterId;
        /**
         * [deprecated]
         */
        public Boolean EnableQueue;
        
    }

    public static class MatchmakeResult {
        /**
         * unique lobby identifier of the server matched
         */
        public String LobbyID;
        /**
         * IP address of the server
         */
        public String ServerHostname;
        /**
         * port number to use for non-http communications with the server
         */
        public Integer ServerPort;
        /**
         * server authorization ticket (used by RedeemCoupon to validate user insertion into the game)
         */
        public String Ticket;
        /**
         * timestamp for when the server will expire, if applicable
         */
        public String Expires;
        /**
         * time in milliseconds the application is configured to wait on matchmaking results
         */
        public Integer PollWaitTimeMS;
        /**
         * result of match making process
         */
        public MatchmakeStatus Status;
        
    }

    public static enum MatchmakeStatus {
        Complete,
        Waiting,
        GameNotFound
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

    public static class OpenTradeRequest {
        /**
         * Player inventory items offered for trade. If not set, the trade is effectively a gift request
         */
        public ArrayList<String> OfferedInventoryInstanceIds;
        /**
         * Catalog items accepted for the trade. If not set, the trade is effectively a gift.
         */
        public ArrayList<String> RequestedCatalogItemIds;
        /**
         * Players who are allowed to accept the trade. If null, the trade may be accepted by any player.
         */
        public ArrayList<String> AllowedPlayerIds;
        
    }

    public static class OpenTradeResponse {
        public TradeInfo Trade;
        
    }

    public static class PayForPurchaseRequest {
        /**
         * Purchase order identifier returned from StartPurchase.
         */
        public String OrderId;
        /**
         * Payment provider to use to fund the purchase.
         */
        public String ProviderName;
        /**
         * Currency to use to fund the purchase.
         */
        public String Currency;
        /**
         * Payment provider transaction identifier. Required for Facebook Payments.
         */
        public String ProviderTransactionId;
        
    }

    public static class PayForPurchaseResult {
        /**
         * Purchase order identifier.
         */
        public String OrderId;
        /**
         * Status of the transaction.
         */
        public TransactionStatus Status;
        /**
         * Virtual currency cost of the transaction.
         */
        public Map<String,Integer> VCAmount;
        /**
         * Real world currency for the transaction.
         */
        public String PurchaseCurrency;
        /**
         * Real world cost of the transaction.
         */
        public Long PurchasePrice;
        /**
         * Local credit applied to the transaction (provider specific).
         */
        public Long CreditApplied;
        /**
         * Provider used for the transaction.
         */
        public String ProviderData;
        /**
         * URL to the purchase provider page that details the purchase.
         */
        public String PurchaseConfirmationPageURL;
        /**
         * Current virtual currency totals for the user.
         */
        public Map<String,Integer> VirtualCurrency;
        
    }

    public static class PaymentOption {
        /**
         * Specific currency to use to fund the purchase.
         */
        public String Currency;
        /**
         * Name of the purchase provider for this option.
         */
        public String ProviderName;
        /**
         * Amount of the specified currency needed for the purchase.
         */
        public Long Price;
        /**
         * Amount of existing credit the user has with the provider.
         */
        public Long StoreCredit;
        
    }

    public static class PlayerLeaderboardEntry {
        /**
         * PlayFab unique identifier of the user for this leaderboard entry.
         */
        public String PlayFabId;
        /**
         * Title-specific display name of the user for this leaderboard entry.
         */
        public String DisplayName;
        /**
         * Specific value of the user's statistic.
         */
        public Integer StatValue;
        /**
         * User's overall position in the leaderboard.
         */
        public Integer Position;
        
    }

    public static class PSNAccountPlayFabIdPair {
        /**
         * Unique PlayStation Network identifier for a user.
         */
        public String PSNAccountId;
        /**
         * Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the PlayStation Network identifier.
         */
        public String PlayFabId;
        
    }

    public static class PurchaseItemRequest {
        /**
         * Unique identifier of the item to purchase.
         */
        public String ItemId;
        /**
         * Virtual currency to use to purchase the item.
         */
        public String VirtualCurrency;
        /**
         * Price the client expects to pay for the item (in case a new catalog or store was uploaded, with new prices).
         */
        public Integer Price;
        /**
         * Catalog version for the items to be purchased (defaults to most recent version.
         */
        public String CatalogVersion;
        /**
         * Store to buy this item through. If not set, prices default to those in the catalog.
         */
        public String StoreId;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        
    }

    public static class PurchaseItemResult {
        /**
         * Details for the items purchased.
         */
        public ArrayList<ItemInstance> Items;
        
    }

    public static class RedeemCouponRequest {
        /**
         * Generated coupon code to redeem.
         */
        public String CouponCode;
        /**
         * Catalog version of the coupon.
         */
        public String CatalogVersion;
        
    }

    public static class RedeemCouponResult {
        /**
         * Items granted to the player as a result of redeeming the coupon.
         */
        public ArrayList<ItemInstance> GrantedItems;
        
    }

    public static class RefreshPSNAuthTokenRequest {
        /**
         * Auth code returned by PSN OAuth system.
         */
        public String AuthCode;
        /**
         * Redirect URI supplied to PSN when requesting an auth code
         */
        public String RedirectUri;
        /**
         * Id of the PSN issuer environment. If null, defaults to 256 (production)
         */
        public Integer IssuerId;
        
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
        /**
         * unique identifier for the region
         */
        public Region Region;
        /**
         * name of the region
         */
        public String Name;
        /**
         * indicates whether the server specified is available in this region
         */
        public Boolean Available;
        /**
         * url to ping to get roundtrip time
         */
        public String PingUrl;
        
    }

    public static class RegisterForIOSPushNotificationRequest {
        /**
         * Unique token generated by the Apple Push Notification service when the title registered to receive push notifications.
         */
        public String DeviceToken;
        /**
         * If true, send a test push message immediately after sucessful registration. Defaults to false.
         */
        public Boolean SendPushNotificationConfirmation;
        /**
         * Message to display when confirming push notification.
         */
        public String ConfirmationMessage;
        
    }

    public static class RegisterForIOSPushNotificationResult {
        
    }

    public static class RegisterPlayFabUserRequest {
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        /**
         * PlayFab username for the account (3-20 characters)
         */
        public String Username;
        /**
         * User email address attached to their account
         */
        public String Email;
        /**
         * Password for the PlayFab account (6-30 characters)
         */
        public String Password;
        /**
         * An optional parameter that specifies whether both the username and email parameters are required. If true, both parameters are required; if false, the user must supply either the username or email parameter. The default value is true.
         */
        public Boolean RequireBothUsernameAndEmail;
        /**
         * An optional parameter for setting the display name for this title.
         */
        public String DisplayName;
        /**
         * [Deprecated - The Origination of a user is determined by the API call used to create the account. In the case of RegisterPlayFabUser, it will be Organic.
         */
        public String Origination;
        
    }

    public static class RegisterPlayFabUserResult {
        /**
         * PlayFab unique identifier for this newly created account.
         */
        public String PlayFabId;
        /**
         * Unique token identifying the user and game at the server level, for the current session.
         */
        public String SessionTicket;
        /**
         * PlayFab unique user name.
         */
        public String Username;
        /**
         * Settings specific to this user.
         */
        public UserSettings SettingsForUser;
        
    }

    public static class RemoveFriendRequest {
        /**
         * PlayFab identifier of the friend account which is to be removed.
         */
        public String FriendPlayFabId;
        
    }

    public static class RemoveFriendResult {
        
    }

    public static class RemoveSharedGroupMembersRequest {
        /**
         * Unique identifier for the shared group.
         */
        public String SharedGroupId;
        /**
         * An array of unique PlayFab assigned ID of the user on whom the operation will be performed.
         */
        public ArrayList<String> PlayFabIds;
        
    }

    public static class RemoveSharedGroupMembersResult {
        
    }

    public static class ReportPlayerClientRequest {
        /**
         * Unique PlayFab identifier of the reported player.
         */
        public String ReporteeId;
        /**
         * Optional additional comment by reporting player.
         */
        public String Comment;
        
    }

    public static class ReportPlayerClientResult {
        public Boolean Updated;
        public Integer SubmissionsRemaining;
        
    }

    public static class RestoreIOSPurchasesRequest {
        /**
         * Base64 encoded receipt data, passed back by the App Store as a result of a successful purchase.
         */
        public String ReceiptData;
        
    }

    public static class RestoreIOSPurchasesResult {
        
    }

    public static class RunCloudScriptRequest {
        /**
         * server action to trigger
         */
        public String ActionId;
        /**
         * parameters to pass into the action (If you use this, don't use ParamsEncoded)
         */
        public Object Params;
        /**
         * json-encoded parameters to pass into the action (If you use this, don't use Params)
         */
        public String ParamsEncoded;
        
    }

    public static class RunCloudScriptResult {
        /**
         * id of Cloud Script run
         */
        public String ActionId;
        /**
         * version of Cloud Script run
         */
        public Integer Version;
        /**
         * revision of Cloud Script run
         */
        public Integer Revision;
        /**
         * return values from the server action as a dynamic object
         */
        public Object Results;
        /**
         * return values from the server action as a JSON encoded string
         */
        public String ResultsEncoded;
        /**
         * any log statements generated during the run of this action
         */
        public String ActionLog;
        /**
         * time this script took to run, in seconds
         */
        public Double ExecutionTime;
        
    }

    public static class SendAccountRecoveryEmailRequest {
        /**
         * User email address attached to their account
         */
        public String Email;
        /**
         * Unique identifier for the title, found in the Settings > Game Properties section of the PlayFab developer site when a title has been selected
         */
        public String TitleId;
        public String PublisherId;
        
    }

    public static class SendAccountRecoveryEmailResult {
        
    }

    public static class SetFriendTagsRequest {
        /**
         * PlayFab identifier of the friend account to which the tag(s) should be applied.
         */
        public String FriendPlayFabId;
        /**
         * Array of tags to set on the friend account.
         */
        public ArrayList<String> Tags;
        
    }

    public static class SetFriendTagsResult {
        
    }

    public static class SharedGroupDataRecord {
        /**
         * Data stored for the specified group data key.
         */
        public String Value;
        /**
         * Unique PlayFab identifier of the user to last update this value.
         */
        public String LastUpdatedBy;
        /**
         * Timestamp for when this data was last updated.
         */
        public Date LastUpdated;
        /**
         * Indicates whether this data can be read by all users (public) or only members of the group (private).
         */
        public UserDataPermission Permission;
        
    }

    public static class StartGameRequest {
        /**
         * version information for the build of the game server which is to be started
         */
        public String BuildVersion;
        /**
         * the region to associate this server with for match filtering
         */
        public Region Region;
        /**
         * the title-defined game mode this server is to be running (defaults to 0 if there is only one mode)
         */
        public String GameMode;
        /**
         * player statistic for others to use in finding this game. May be null for no stat-based matching
         */
        public String StatisticName;
        /**
         * character to use for stats based matching. Leave null to use account stats
         */
        public String CharacterId;
        /**
         * custom command line argument when starting game server process
         */
        public String CustomCommandLineData;
        
    }

    public static class StartGameResult {
        /**
         * unique identifier for the lobby of the server started
         */
        public String LobbyID;
        /**
         * server IP address
         */
        public String ServerHostname;
        /**
         * port on the server to be used for communication
         */
        public Integer ServerPort;
        /**
         * unique identifier for the server
         */
        public String Ticket;
        /**
         * timestamp for when the server should expire, if applicable
         */
        public String Expires;
        /**
         * password required to log into the server
         */
        public String Password;
        
    }

    public static class StartPurchaseRequest {
        /**
         * Catalog version for the items to be purchased. Defaults to most recent catalog.
         */
        public String CatalogVersion;
        /**
         * Store through which to purchase items. If not set, prices will be pulled from the catalog itself.
         */
        public String StoreId;
        /**
         * Array of items to purchase.
         */
        public ArrayList<ItemPuchaseRequest> Items;
        
    }

    public static class StartPurchaseResult {
        /**
         * Purchase order identifier.
         */
        public String OrderId;
        /**
         * Cart items to be purchased.
         */
        public ArrayList<CartItem> Contents;
        /**
         * Available methods by which the user can pay.
         */
        public ArrayList<PaymentOption> PaymentOptions;
        /**
         * Current virtual currency totals for the user.
         */
        public Map<String,Integer> VirtualCurrencyBalances;
        
    }

    public static class SteamPlayFabIdPair {
        /**
         * Unique Steam identifier for a user.
         */
        public Long SteamId;
        /**
         * Unique PlayFab identifier for a user, or null if no PlayFab account is linked to the Steam identifier.
         */
        public String PlayFabId;
        
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

    public static class TitleNewsItem {
        /**
         * Date and time when the news items was posted.
         */
        public Date Timestamp;
        /**
         * Unique identifier of news item.
         */
        public String NewsId;
        /**
         * Title of the news item.
         */
        public String Title;
        /**
         * News item text.
         */
        public String Body;
        
    }

    public static class TradeInfo {
        public TradeStatus Status;
        public String TradeId;
        public String OfferingPlayerId;
        public ArrayList<String> OfferedInventoryInstanceIds;
        public ArrayList<String> OfferedCatalogItemIds;
        public ArrayList<String> RequestedCatalogItemIds;
        public ArrayList<String> AllowedPlayerIds;
        public String AcceptedPlayerId;
        public ArrayList<String> AcceptedInventoryInstanceIds;
        public Date OpenedAt;
        public Date FilledAt;
        public Date CancelledAt;
        public Date InvalidatedAt;
        
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

    public static class UnlinkAndroidDeviceIDRequest {
        /**
         * Android device identifier for the user's device. If not specified, the most recently signed in Android Device ID will be used.
         */
        public String AndroidDeviceId;
        
    }

    public static class UnlinkAndroidDeviceIDResult {
        
    }

    public static class UnlinkCustomIDRequest {
        /**
         * Custom unique identifier for the user, generated by the title. If not specified, the most recently signed in Custom ID will be used.
         */
        public String CustomId;
        
    }

    public static class UnlinkCustomIDResult {
        
    }

    public static class UnlinkFacebookAccountRequest {
        
    }

    public static class UnlinkFacebookAccountResult {
        
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
         * Vendor-specific iOS identifier for the user's device. If not specified, the most recently signed in iOS Device ID will be used.
         */
        public String DeviceId;
        
    }

    public static class UnlinkIOSDeviceIDResult {
        
    }

    public static class UnlinkKongregateAccountRequest {
        
    }

    public static class UnlinkKongregateAccountResult {
        
    }

    public static class UnlinkPSNAccountRequest {
        
    }

    public static class UnlinkPSNAccountResult {
        
    }

    public static class UnlinkSteamAccountRequest {
        
    }

    public static class UnlinkSteamAccountResult {
        
    }

    public static class UnlockContainerItemRequest {
        /**
         * Category ItemId of the container type to unlock.
         */
        public String ContainerItemId;
        /**
         * Catalog version of the container.
         */
        public String CatalogVersion;
        /**
         * Unique PlayFab assigned ID for a specific character owned by a user
         */
        public String CharacterId;
        
    }

    public static class UnlockContainerItemResult {
        /**
         * Unique instance identifier of the container unlocked.
         */
        public String UnlockedItemInstanceId;
        /**
         * Unique instance identifier of the key used to unlock the container, if applicable.
         */
        public String UnlockedWithItemInstanceId;
        /**
         * Items granted to the player as a result of unlocking the container.
         */
        public ArrayList<ItemInstance> GrantedItems;
        /**
         * Virtual currency granted to the player as a result of unlocking the container.
         */
        public Map<String,Long> VirtualCurrency;
        
    }

    public static class UpdateCharacterDataRequest {
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
        /**
         * Permission to be applied to all user data keys written in this request. Defaults to "private" if not set.
         */
        public UserDataPermission Permission;
        
    }

    public static class UpdateCharacterDataResult {
        /**
         * Indicates the current version of the data that has been set. This is incremented with every set call for that type of data (read-only, internal, etc). This version can be provided in Get calls to find updated data.
         */
        public Long DataVersion;
        
    }

    public static class UpdateSharedGroupDataRequest {
        /**
         * Unique identifier for the shared group.
         */
        public String SharedGroupId;
        /**
         * Key-value pairs to be written to the custom data. Note that keys are trimmed of whitespace, are limited in size, and may not begin with a '!' character.
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
        
    }

    public static class UpdateSharedGroupDataResult {
        
    }

    public static class UpdateUserDataRequest {
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

    public static class UpdateUserStatisticsRequest {
        /**
         * Statistics to be updated with the provided values.
         */
        public Map<String,Integer> UserStatistics;
        
    }

    public static class UpdateUserStatisticsResult {
        
    }

    public static class UpdateUserTitleDisplayNameRequest {
        /**
         * New title display name for the user - must be between 3 and 25 characters.
         */
        public String DisplayName;
        
    }

    public static class UpdateUserTitleDisplayNameResult {
        /**
         * Current title display name for the user (this will be the original display name if the rename attempt failed).
         */
        public String DisplayName;
        
    }

    public static class UserAccountInfo {
        /**
         * unique identifier for the user account
         */
        public String PlayFabId;
        /**
         * timestamp indicating when the user account was created
         */
        public Date Created;
        /**
         * user account name in the PlayFab service
         */
        public String Username;
        /**
         * title-specific information for the user account
         */
        public UserTitleInfo TitleInfo;
        /**
         * personal information for the user which is considered more sensitive
         */
        public UserPrivateAccountInfo PrivateInfo;
        /**
         * user Facebook information, if a Facebook account has been linked
         */
        public UserFacebookInfo FacebookInfo;
        /**
         * user Steam information, if a Steam account has been linked
         */
        public UserSteamInfo SteamInfo;
        /**
         * user Gamecenter information, if a Gamecenter account has been linked
         */
        public UserGameCenterInfo GameCenterInfo;
        
    }

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
         * Indicates whether this data can be read by all users (public) or only the user (private).
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
        XboxLive
    }

    public static class UserPrivateAccountInfo {
        /**
         * user email address
         */
        public String Email;
        
    }

    public static class UserSettings {
        public Boolean NeedsAttribution;
        
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

    public static class ValidateAmazonReceiptRequest {
        /**
         * ReceiptId returned by the Amazon App Store in-app purchase API
         */
        public String ReceiptId;
        /**
         * AmazonId of the user making the purchase as returned by the Amazon App Store in-app purchase API
         */
        public String UserId;
        /**
         * Catalog version to use when granting receipt item. If null, defaults to primary catalog.
         */
        public String CatalogVersion;
        /**
         * Currency used for the purchase.
         */
        public String CurrencyCode;
        /**
         * Amount of the stated currency paid for the object.
         */
        public Integer PurchasePrice;
        
    }

    public static class ValidateAmazonReceiptResult {
        
    }

    public static class ValidateGooglePlayPurchaseRequest {
        /**
         * Original JSON string returned by the Google Play IAB API.
         */
        public String ReceiptJson;
        /**
         * Signature returned by the Google Play IAB API.
         */
        public String Signature;
        /**
         * Currency used for the purchase.
         */
        public String CurrencyCode;
        /**
         * Amount of the stated currency paid for the object.
         */
        public Long PurchasePrice;
        
    }

    public static class ValidateGooglePlayPurchaseResult {
        
    }

    public static class ValidateIOSReceiptRequest {
        /**
         * Base64 encoded receipt data, passed back by the App Store as a result of a successful purchase.
         */
        public String ReceiptData;
        /**
         * Currency used for the purchase.
         */
        public String CurrencyCode;
        /**
         * Amount of the stated currency paid for the object.
         */
        public Integer PurchasePrice;
        
    }

    public static class ValidateIOSReceiptResult {
        
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
