package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabMatchmakerModels {

    public static class AuthUserRequest {
        /**
         * Session Ticket provided by the client.
         */
        public String AuthorizationTicket;
        
    }

    public static class AuthUserResponse {
        /**
         * Boolean indicating if the user has been authorized to use the external match-making service.
         */
        public Boolean Authorized;
        /**
         * PlayFab unique identifier of the account that has been authorized.
         */
        public String PlayFabId;
        
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

    public static class PlayerJoinedRequest {
        /**
         * Unique identifier of the Game Server Instance the user is joining.
         */
        public String LobbyId;
        /**
         * PlayFab unique identifier for the user joining.
         */
        public String PlayFabId;
        
    }

    public static class PlayerJoinedResponse {
        
    }

    public static class PlayerLeftRequest {
        /**
         * Unique identifier of the Game Server Instance the user is leaving.
         */
        public String LobbyId;
        /**
         * PlayFab unique identifier for the user leaving.
         */
        public String PlayFabId;
        
    }

    public static class PlayerLeftResponse {
        
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

    public static class StartGameRequest {
        /**
         * Unique identifier of the previously uploaded build executable which is to be started.
         */
        public String Build;
        /**
         * Region with which to associate the server, for filtering.
         */
        public Region Region;
        /**
         * Game mode for this Game Server Instance.
         */
        public String GameMode;
        /**
         * Custom command line argument when starting game server process.
         */
        public String CustomCommandLineData;
        /**
         * HTTP endpoint URL for receiving game status events, if using an external matchmaker. When the game ends, PlayFab will make a POST request to this URL with the X-SecretKey header set to the value of the game's secret and an application/json body of { "EventName": "game_ended", "GameID": "<gameid>" }.
         */
        public String ExternalMatchmakerEventEndpoint;
        
    }

    public static class StartGameResponse {
        /**
         * Unique identifier for the game/lobby in the new Game Server Instance.
         */
        public String GameID;
        /**
         * IP address of the new Game Server Instance.
         */
        public String ServerHostname;
        /**
         * Port number for communication with the Game Server Instance.
         */
        public Long ServerPort;
        
    }

    public static class UserInfoRequest {
        /**
         * PlayFab unique identifier of the user whose information is being requested.
         */
        public String PlayFabId;
        /**
         * Minimum catalog version for which data is requested (filters the results to only contain inventory items which have a catalog version of this or higher).
         */
        public Integer MinCatalogVersion;
        
    }

    public static class UserInfoResponse {
        /**
         * PlayFab unique identifier of the user whose information was requested.
         */
        public String PlayFabId;
        /**
         * PlayFab unique user name.
         */
        public String Username;
        /**
         * Title specific display name, if set.
         */
        public String TitleDisplayName;
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
         * Boolean indicating whether the user is a developer.
         */
        public Boolean IsDeveloper;
        /**
         * Steam unique identifier, if the user has an associated Steam account.
         */
        public String SteamId;
        
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
