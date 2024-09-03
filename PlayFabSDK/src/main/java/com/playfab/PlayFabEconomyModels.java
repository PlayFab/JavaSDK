package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabEconomyModels {

    public static class AddInventoryItemsOperation {
        /** The amount to add to the current item amount. */
        public Integer Amount;
        /** The duration to add to the current item expiration date. */
        public Double DurationInSeconds;
        /** The inventory item the operation applies to. */
        public InventoryItemReference Item;
        /** The values to apply to a stack newly created by this operation. */
        public InitialValues NewStackValues;
        
    }

    /** Given an entity type, entity identifier and container details, will add the specified inventory items. */
    public static class AddInventoryItemsRequest {
        /** The amount to add for the current item. */
        public Integer Amount;
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The duration to add to the current item expiration date. */
        public Double DurationInSeconds;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        public String IdempotencyId;
        /** The inventory item the request applies to. */
        public InventoryItemReference Item;
        /** The values to apply to a stack newly created by this request. */
        public InitialValues NewStackValues;
        
    }

    public static class AddInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /** The idempotency id used in the request. */
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        public ArrayList<String> TransactionIds;
        
    }

    public static class AlternateId {
        /** Type of the alternate ID. */
        public String Type;
        /** Value of the alternate ID. */
        public String Value;
        
    }

    public static class CatalogAlternateId {
        /** Type of the alternate ID. */
        public String Type;
        /** Value of the alternate ID. */
        public String Value;
        
    }

    public static class CatalogConfig {
        /** A list of player entity keys that will have admin permissions. There is a maximum of 64 entities that can be added. */
        public ArrayList<EntityKey> AdminEntities;
        /** The set of configuration that only applies to catalog items. */
        public CatalogSpecificConfig Catalog;
        /** A list of deep link formats. Up to 10 can be added. */
        public ArrayList<DeepLinkFormat> DeepLinkFormats;
        /**
         * A list of display properties to index. Up to 5 mappings can be added per Display Property Type. More info on display
         * properties can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/content-types-tags-and-properties#displayproperties
         */
        public ArrayList<DisplayPropertyIndexInfo> DisplayPropertyIndexInfos;
        /** The set of configuration that only applies to Files. */
        public FileConfig File;
        /** The set of configuration that only applies to Images. */
        public ImageConfig Image;
        /** Flag defining whether catalog is enabled. */
        public Boolean IsCatalogEnabled;
        /**
         * A list of Platforms that can be applied to catalog items. Each platform can have a maximum character length of 40 and up
         * to 128 platforms can be listed.
         */
        public ArrayList<String> Platforms;
        /** The set of configuration that only applies to Ratings and Reviews. */
        public ReviewConfig Review;
        /** A set of player entity keys that are allowed to review content. There is a maximum of 128 entities that can be added. */
        public ArrayList<EntityKey> ReviewerEntities;
        /** The set of configuration that only applies to user generated contents. */
        public UserGeneratedContentSpecificConfig UserGeneratedContent;
        
    }

    public static class CatalogItem {
        /**
         * The alternate IDs associated with this item. An alternate ID can be set to 'FriendlyId' or any of the supported
         * marketplace names.
         */
        public ArrayList<CatalogAlternateId> AlternateIds;
        /** The set of content/files associated with this item. Up to 100 files can be added to an item. */
        public ArrayList<Content> Contents;
        /** The client-defined type of the item. */
        public String ContentType;
        /** The date and time when this item was created. */
        public Date CreationDate;
        /** The ID of the creator of this catalog item. */
        public EntityKey CreatorEntity;
        /** The set of platform specific deep links for this item. */
        public ArrayList<DeepLink> DeepLinks;
        /**
         * The Stack Id that will be used as default for this item in Inventory when an explicit one is not provided. This
         * DefaultStackId can be a static stack id or '{guid}', which will generate a unique stack id for the item. If null,
         * Inventory's default stack id will be used.
         */
        public String DefaultStackId;
        /**
         * A dictionary of localized descriptions. Key is language code and localized string is the value. The NEUTRAL locale is
         * required. Descriptions have a 10000 character limit per country code.
         */
        public Map<String,String> Description;
        /**
         * Game specific properties for display purposes. This is an arbitrary JSON blob. The Display Properties field has a 10000
         * byte limit per item.
         */
        public Object DisplayProperties;
        /** The user provided version of the item for display purposes. Maximum character length of 50. */
        public String DisplayVersion;
        /** The date of when the item will cease to be available. If not provided then the product will be available indefinitely. */
        public Date EndDate;
        /** The current ETag value that can be used for optimistic concurrency in the If-None-Match header. */
        public String ETag;
        /** The unique ID of the item. */
        public String Id;
        /**
         * The images associated with this item. Images can be thumbnails or screenshots. Up to 100 images can be added to an item.
         * Only .png, .jpg, .gif, and .bmp file types can be uploaded
         */
        public ArrayList<Image> Images;
        /** Indicates if the item is hidden. */
        public Boolean IsHidden;
        /**
         * The item references associated with this item. For example, the items in a Bundle/Store/Subscription. Every item can
         * have up to 50 item references.
         */
        public ArrayList<CatalogItemReference> ItemReferences;
        /**
         * A dictionary of localized keywords. Key is language code and localized list of keywords is the value. Keywords have a 50
         * character limit per keyword and up to 32 keywords can be added per country code.
         */
        public Map<String,KeywordSet> Keywords;
        /** The date and time this item was last updated. */
        public Date LastModifiedDate;
        /** The moderation state for this item. */
        public ModerationState Moderation;
        /** The platforms supported by this item. */
        public ArrayList<String> Platforms;
        /** The prices the item can be purchased for. */
        public CatalogPriceOptions PriceOptions;
        /** Rating summary for this item. */
        public Rating Rating;
        /** The date of when the item will be available. If not provided then the product will appear immediately. */
        public Date StartDate;
        /** Optional details for stores items. */
        public StoreDetails StoreDetails;
        /** The list of tags that are associated with this item. Up to 32 tags can be added to an item. */
        public ArrayList<String> Tags;
        /**
         * A dictionary of localized titles. Key is language code and localized string is the value. The NEUTRAL locale is
         * required. Titles have a 512 character limit per country code.
         */
        public Map<String,String> Title;
        /**
         * The high-level type of the item. The following item types are supported: bundle, catalogItem, currency, store, ugc,
         * subscription.
         */
        public String Type;
        
    }

    public static class CatalogItemReference {
        /** The amount of the catalog item. */
        public Integer Amount;
        /** The unique ID of the catalog item. */
        public String Id;
        /** The prices the catalog item can be purchased for. */
        public CatalogPriceOptions PriceOptions;
        
    }

    public static class CatalogPrice {
        /** The amounts of the catalog item price. Each price can have up to 15 item amounts. */
        public ArrayList<CatalogPriceAmount> Amounts;
        /** The per-unit amount this price can be used to purchase. */
        public Integer UnitAmount;
        /** The per-unit duration this price can be used to purchase. The maximum duration is 100 years. */
        public Double UnitDurationInSeconds;
        
    }

    public static class CatalogPriceAmount {
        /** The amount of the price. */
        public Integer Amount;
        /** The Item Id of the price. */
        public String ItemId;
        
    }

    public static class CatalogPriceAmountOverride {
        /** The exact value that should be utilized in the override. */
        public Integer FixedValue;
        /** The id of the item this override should utilize. */
        public String ItemId;
        /**
         * The multiplier that will be applied to the base Catalog value to determine what value should be utilized in the
         * override.
         */
        public Double Multiplier;
        
    }

    public static class CatalogPriceOptions {
        /** Prices of the catalog item. An item can have up to 15 prices */
        public ArrayList<CatalogPrice> Prices;
        
    }

    public static class CatalogPriceOptionsOverride {
        /** The prices utilized in the override. */
        public ArrayList<CatalogPriceOverride> Prices;
        
    }

    public static class CatalogPriceOverride {
        /** The currency amounts utilized in the override for a singular price. */
        public ArrayList<CatalogPriceAmountOverride> Amounts;
        
    }

    public static class CatalogSpecificConfig {
        /**
         * The set of content types that will be used for validation. Each content type can have a maximum character length of 40
         * and up to 128 types can be listed.
         */
        public ArrayList<String> ContentTypes;
        /**
         * The set of tags that will be used for validation. Each tag can have a maximum character length of 32 and up to 1024 tags
         * can be listed.
         */
        public ArrayList<String> Tags;
        
    }

    public static class CategoryRatingConfig {
        /** Name of the category. */
        public String Name;
        
    }

    public static enum ConcernCategory {
        None,
        OffensiveContent,
        ChildExploitation,
        MalwareOrVirus,
        PrivacyConcerns,
        MisleadingApp,
        PoorPerformance,
        ReviewResponse,
        SpamAdvertising,
        Profanity
    }

    public static class Content {
        /** The content unique ID. */
        public String Id;
        /**
         * The maximum client version that this content is compatible with. Client Versions can be up to 3 segments separated by
         * periods(.) and each segment can have a maximum value of 65535.
         */
        public String MaxClientVersion;
        /**
         * The minimum client version that this content is compatible with. Client Versions can be up to 3 segments separated by
         * periods(.) and each segment can have a maximum value of 65535.
         */
        public String MinClientVersion;
        /**
         * The list of tags that are associated with this content. Tags must be defined in the Catalog Config before being used in
         * content.
         */
        public ArrayList<String> Tags;
        /** The client-defined type of the content. Content Types must be defined in the Catalog Config before being used. */
        public String Type;
        /** The Azure CDN URL for retrieval of the catalog item binary content. */
        public String Url;
        
    }

    public static class ContentFeed {
        
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
        ZW,
        Unknown
    }

    /** The item will not be published to the public catalog until the PublishItem API is called for the item. */
    public static class CreateDraftItemRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Metadata describing the new catalog item to be created. */
        public CatalogItem Item;
        /** Whether the item should be published immediately. This value is optional, defaults to false. */
        public Boolean Publish;
        
    }

    public static class CreateDraftItemResponse {
        /** Updated metadata describing the catalog item just created. */
        public CatalogItem Item;
        
    }

    /**
     * Upload URLs point to Azure Blobs; clients must follow the Microsoft Azure Storage Blob Service REST API pattern for
     * uploading content. The response contains upload URLs and IDs for each file. The IDs and URLs returned must be added to
     * the item metadata and committed using the CreateDraftItem or UpdateDraftItem Item APIs.
     */
    public static class CreateUploadUrlsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Description of the files to be uploaded by the client. */
        public ArrayList<UploadInfo> Files;
        
    }

    public static class CreateUploadUrlsResponse {
        /** List of URLs metadata for the files to be uploaded by the client. */
        public ArrayList<UploadUrlMetadata> UploadUrls;
        
    }

    public static class DeepLink {
        /** Target platform for this deep link. */
        public String Platform;
        /** The deep link for this platform. */
        public String Url;
        
    }

    public static class DeepLinkFormat {
        /** The format of the deep link to return. The format should contain '{id}' to represent where the item ID should be placed. */
        public String Format;
        /** The target platform for the deep link. */
        public String Platform;
        
    }

    public static class DeleteEntityItemReviewsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class DeleteEntityItemReviewsResponse {
        
    }

    /** Delete an Inventory Collection by the specified Id for an Entity */
    public static class DeleteInventoryCollectionRequest {
        /** The inventory collection id the request applies to. */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity the request is about. Set to the caller by default. */
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        
    }

    public static class DeleteInventoryCollectionResponse {
        
    }

    public static class DeleteInventoryItemsOperation {
        /** The inventory item the operation applies to. */
        public InventoryItemReference Item;
        
    }

    /** Given an entity type, entity identifier and container details, will delete the entity's inventory items */
    public static class DeleteInventoryItemsRequest {
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        public String IdempotencyId;
        /** The inventory item the request applies to. */
        public InventoryItemReference Item;
        
    }

    public static class DeleteInventoryItemsResponse {
        /** ETags are used for concurrency checking when updating resources. */
        public String ETag;
        /** The idempotency id used in the request. */
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        public ArrayList<String> TransactionIds;
        
    }

    public static class DeleteItemRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The unique ID of the item. */
        public String Id;
        
    }

    public static class DeleteItemResponse {
        
    }

    public static class DisplayPropertyIndexInfo {
        /** The property name in the 'DisplayProperties' property to be indexed. */
        public String Name;
        /** The type of the property to be indexed. */
        public DisplayPropertyType Type;
        
    }

    public static enum DisplayPropertyType {
        None,
        QueryDateTime,
        QueryDouble,
        QueryString,
        SearchString
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://docs.microsoft.com/gaming/playfab/features/data/entities/available-built-in-entity-types */
        public String Type;
        
    }

    /** Execute a list of Inventory Operations for an Entity */
    public static class ExecuteInventoryOperationsRequest {
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        public String IdempotencyId;
        /**
         * The operations to run transactionally. The operations will be executed in-order sequentially and will succeed or fail as
         * a batch. Up to 50 operations can be added.
         */
        public ArrayList<InventoryOperation> Operations;
        
    }

    public static class ExecuteInventoryOperationsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /** The idempotency id used in the request. */
        public String IdempotencyId;
        /** The ids of the transactions that occurred as a result of the request. */
        public ArrayList<String> TransactionIds;
        
    }

    /** Transfer the specified list of inventory items of an entity's container Id to another entity's container Id. */
    public static class ExecuteTransferOperationsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The inventory collection id the request is transferring from. (Default="default") */
        public String GivingCollectionId;
        /** The entity the request is transferring from. Set to the caller by default. */
        public EntityKey GivingEntity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String GivingETag;
        /** The idempotency id for the request. */
        public String IdempotencyId;
        /**
         * The transfer operations to run transactionally. The operations will be executed in-order sequentially and will succeed
         * or fail as a batch. Up to 50 operations can be added.
         */
        public ArrayList<TransferInventoryItemsOperation> Operations;
        /** The inventory collection id the request is transferring to. (Default="default") */
        public String ReceivingCollectionId;
        /** The entity the request is transferring to. Set to the caller by default. */
        public EntityKey ReceivingEntity;
        
    }

    public static class ExecuteTransferOperationsResponse {
        /**
         * ETags are used for concurrency checking when updating resources (before transferring from). This value will be empty if
         * the operation has not completed yet. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String GivingETag;
        /** The ids of transactions that occurred as a result of the request's giving action. */
        public ArrayList<String> GivingTransactionIds;
        /** The Idempotency ID for this request. */
        public String IdempotencyId;
        /**
         * The transfer operation status. Possible values are 'InProgress' or 'Completed'. If the operation has completed, the
         * response code will be 200. Otherwise, it will be 202.
         */
        public String OperationStatus;
        /**
         * The token that can be used to get the status of the transfer operation. This will only have a value if OperationStatus
         * is 'InProgress'.
         */
        public String OperationToken;
        /**
         * ETags are used for concurrency checking when updating resources (before transferring to). This value will be empty if
         * the operation has not completed yet.
         */
        public String ReceivingETag;
        /** The ids of transactions that occurred as a result of the request's receiving action. */
        public ArrayList<String> ReceivingTransactionIds;
        
    }

    public static class FileConfig {
        /**
         * The set of content types that will be used for validation. Each content type can have a maximum character length of 40
         * and up to 128 types can be listed.
         */
        public ArrayList<String> ContentTypes;
        /**
         * The set of tags that will be used for validation. Each tag can have a maximum character length of 32 and up to 1024 tags
         * can be listed.
         */
        public ArrayList<String> Tags;
        
    }

    public static class FilterOptions {
        /**
         * The OData filter utilized. Mutually exclusive with 'IncludeAllItems'. More info about Filter Complexity limits can be
         * found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/search#limits
         */
        public String Filter;
        /** The flag that overrides the filter and allows for returning all catalog items. Mutually exclusive with 'Filter'. */
        public Boolean IncludeAllItems;
        
    }

    public static class GetCatalogConfigRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class GetCatalogConfigResponse {
        /** The catalog configuration. */
        public CatalogConfig Config;
        
    }

    public static class GetDraftItemRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The unique ID of the item. */
        public String Id;
        
    }

    public static class GetDraftItemResponse {
        /** Full metadata of the catalog item requested. */
        public CatalogItem Item;
        
    }

    public static class GetDraftItemsRequest {
        /** List of item alternate IDs. */
        public ArrayList<CatalogAlternateId> AlternateIds;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** List of Item Ids. */
        public ArrayList<String> Ids;
        
    }

    public static class GetDraftItemsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        public String ContinuationToken;
        /** A set of items created by the entity. */
        public ArrayList<CatalogItem> Items;
        
    }

    public static class GetEntityDraftItemsRequest {
        /**
         * An opaque token used to retrieve the next page of items created by the caller, if any are available. Should be null on
         * initial request.
         */
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Default value is 10. */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * OData Filter to refine the items returned. CatalogItem properties 'type' can be used in the filter. For example: "type
         * eq 'ugc'"
         */
        public String Filter;
        
    }

    public static class GetEntityDraftItemsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        public String ContinuationToken;
        /** A set of items created by the entity. */
        public ArrayList<CatalogItem> Items;
        
    }

    public static class GetEntityItemReviewRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The unique ID of the item. */
        public String Id;
        
    }

    public static class GetEntityItemReviewResponse {
        /** The review the entity submitted for the requested item. */
        public Review Review;
        
    }

    /** Get a list of Inventory Collection Ids for the specified Entity */
    public static class GetInventoryCollectionIdsRequest {
        /** An opaque token used to retrieve the next page of collection ids, if any are available. */
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. The default value is 10 */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity the request is about. Set to the caller by default. */
        public EntityKey Entity;
        
    }

    public static class GetInventoryCollectionIdsResponse {
        /** The requested inventory collection ids. */
        public ArrayList<String> CollectionIds;
        /** An opaque token used to retrieve the next page of collection ids, if any are available. */
        public String ContinuationToken;
        
    }

    /** Given an entity type, entity identifier and container details, will get the entity's inventory items. */
    public static class GetInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        public String CollectionId;
        /**
         * An opaque token used to retrieve the next page of items in the inventory, if any are available. Should be null on
         * initial request.
         */
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Maximum page size is 50. The default value is 10 */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * OData Filter to refine the items returned. InventoryItem properties 'type', 'id', and 'stackId' can be used in the
         * filter. For example: "type eq 'currency'"
         */
        public String Filter;
        
    }

    public static class GetInventoryItemsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        public String ContinuationToken;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /** The requested inventory items. */
        public ArrayList<InventoryItem> Items;
        
    }

    /** Get the status of an Inventory Operation using an OperationToken. */
    public static class GetInventoryOperationStatusRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class GetInventoryOperationStatusResponse {
        /** The inventory operation status. */
        public String OperationStatus;
        
    }

    /** Given an item, return a set of bundles and stores containing the item. */
    public static class GetItemContainersRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /**
         * An opaque token used to retrieve the next page of items in the inventory, if any are available. Should be null on
         * initial request.
         */
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Default value is 10. */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The unique ID of the item. */
        public String Id;
        
    }

    public static class GetItemContainersResponse {
        /** List of Bundles and Stores containing the requested items. */
        public ArrayList<CatalogItem> Containers;
        /** An opaque token used to retrieve the next page of items, if any are available. */
        public String ContinuationToken;
        
    }

    public static class GetItemModerationStateRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The unique ID of the item. */
        public String Id;
        
    }

    public static class GetItemModerationStateResponse {
        /** The current moderation state for the requested item. */
        public ModerationState State;
        
    }

    public static class GetItemPublishStatusRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The unique ID of the item. */
        public String Id;
        
    }

    public static class GetItemPublishStatusResponse {
        /** High level status of the published item. */
        public PublishResult Result;
        /** Descriptive message about the current status of the publish. */
        public String StatusMessage;
        
    }

    public static class GetItemRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The unique ID of the item. */
        public String Id;
        
    }

    /** Get item result. */
    public static class GetItemResponse {
        /** The item result. */
        public CatalogItem Item;
        
    }

    public static class GetItemReviewsRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** An opaque token used to retrieve the next page of items, if any are available. */
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Default value is 10. */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The unique ID of the item. */
        public String Id;
        /**
         * An OData orderBy used to order the results of the query. Possible values are Helpfulness, Rating, and Submitted (For
         * example: "Submitted desc")
         */
        public String OrderBy;
        
    }

    public static class GetItemReviewsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        public String ContinuationToken;
        /** The paginated set of results. */
        public ArrayList<Review> Reviews;
        
    }

    public static class GetItemReviewSummaryRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The unique ID of the item. */
        public String Id;
        
    }

    public static class GetItemReviewSummaryResponse {
        /** The least favorable review for this item. */
        public Review LeastFavorableReview;
        /** The most favorable review for this item. */
        public Review MostFavorableReview;
        /** The summary of ratings associated with this item. */
        public Rating Rating;
        /** The total number of reviews associated with this item. */
        public Integer ReviewsCount;
        
    }

    public static class GetItemsRequest {
        /** List of item alternate IDs. */
        public ArrayList<CatalogAlternateId> AlternateIds;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** List of Item Ids. */
        public ArrayList<String> Ids;
        
    }

    public static class GetItemsResponse {
        /** Metadata of set of items. */
        public ArrayList<CatalogItem> Items;
        
    }

    /** Gets the access tokens for Microsoft Store authentication. */
    public static class GetMicrosoftStoreAccessTokensRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class GetMicrosoftStoreAccessTokensResponse {
        /**
         * The collections access token for calling https://onestore.microsoft.com/b2b/keys/create/collections to obtain a
         * CollectionsIdKey for the user
         */
        public String CollectionsAccessToken;
        /** The date the collections access token expires */
        public Date CollectionsAccessTokenExpirationDate;
        
    }

    /** Get transaction history for specified entity and collection. */
    public static class GetTransactionHistoryRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        public String CollectionId;
        /** An opaque token used to retrieve the next page of items, if any are available. Should be null on initial request. */
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. The default value is 10 */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * An OData filter used to refine the TransactionHistory. Transaction properties 'timestamp', 'transactionid', 'apiname'
         * and 'operationtype' can be used in the filter. Properties 'transactionid', 'apiname', and 'operationtype' cannot be used
         * together in a single request. The 'timestamp' property can be combined with 'apiname' or 'operationtype' in a single
         * request. For example: "timestamp ge 2023-06-20T23:30Z" or "transactionid eq '10'" or "(timestamp ge 2023-06-20T23:30Z)
         * and (apiname eq 'AddInventoryItems')". By default, a 6 month timespan from the current date is used.
         */
        public String Filter;
        /**
         * An OData orderby to order TransactionHistory results. The only supported values are 'timestamp asc' or 'timestamp desc'.
         * Default orderby is 'timestamp asc'
         */
        public String OrderBy;
        
    }

    public static class GetTransactionHistoryResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. Should be null on initial request. */
        public String ContinuationToken;
        /** The requested inventory transactions. */
        public ArrayList<Transaction> Transactions;
        
    }

    public static class GooglePlayProductPurchase {
        /** The Product ID (SKU) of the InApp product purchased from the Google Play store. */
        public String ProductId;
        /** The token provided to the player's device when the product was purchased */
        public String Token;
        
    }

    public static enum HelpfulnessVote {
        None,
        UnHelpful,
        Helpful
    }

    public static class Image {
        /** The image unique ID. */
        public String Id;
        /**
         * The client-defined tag associated with this image. Tags must be defined in the Catalog Config before being used in
         * images
         */
        public String Tag;
        /** Images can be defined as either a "thumbnail" or "screenshot". There can only be one "thumbnail" image per item. */
        public String Type;
        /** The URL for retrieval of the image. */
        public String Url;
        
    }

    public static class ImageConfig {
        /**
         * The set of tags that will be used for validation. Each tag can have a maximum character length of 32 and up to 1024 tags
         * can be listed.
         */
        public ArrayList<String> Tags;
        
    }

    public static class InitialValues {
        /** Game specific properties for display purposes. The Display Properties field has a 1000 byte limit. */
        public Object DisplayProperties;
        
    }

    public static class InventoryItem {
        /** The amount of the item. */
        public Integer Amount;
        /**
         * Game specific properties for display purposes. This is an arbitrary JSON blob. The Display Properties field has a 1000
         * byte limit.
         */
        public Object DisplayProperties;
        /** Only used for subscriptions. The date of when the item will expire in UTC. */
        public Date ExpirationDate;
        /** The id of the item. This should correspond to the item id in the catalog. */
        public String Id;
        /** The stack id of the item. */
        public String StackId;
        /** The type of the item. This should correspond to the item type in the catalog. */
        public String Type;
        
    }

    public static class InventoryItemReference {
        /** The inventory item alternate id the request applies to. */
        public AlternateId AlternateId;
        /** The inventory item id the request applies to. */
        public String Id;
        /** The inventory stack id the request should redeem to. (Default="default") */
        public String StackId;
        
    }

    public static class InventoryOperation {
        /** The add operation. */
        public AddInventoryItemsOperation Add;
        /** The delete operation. */
        public DeleteInventoryItemsOperation Delete;
        /** The purchase operation. */
        public PurchaseInventoryItemsOperation Purchase;
        /** The subtract operation. */
        public SubtractInventoryItemsOperation Subtract;
        /** The transfer operation. */
        public TransferInventoryItemsOperation Transfer;
        /** The update operation. */
        public UpdateInventoryItemsOperation Update;
        
    }

    public static class KeywordSet {
        /** A list of localized keywords. */
        public ArrayList<String> Values;
        
    }

    public static class ModerationState {
        /** The date and time this moderation state was last updated. */
        public Date LastModifiedDate;
        /** The current stated reason for the associated item being moderated. */
        public String Reason;
        /** The current moderation status for the associated item. */
        public ModerationStatus Status;
        
    }

    public static enum ModerationStatus {
        Unknown,
        AwaitingModeration,
        Approved,
        Rejected
    }

    public static class PayoutDetails {
        
    }

    public static class Permissions {
        /**
         * The list of ids of Segments that the a player can be in to purchase from the store. When a value is provided, the player
         * must be in at least one of the segments listed for the purchase to be allowed.
         */
        public ArrayList<String> SegmentIds;
        
    }

    /**
     * The call kicks off a workflow to publish the item to the public catalog. The Publish Status API should be used to
     * monitor the publish job.
     */
    public static class PublishDraftItemRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * ETag of the catalog item to published from the working catalog to the public catalog. Used for optimistic concurrency.
         * If the provided ETag does not match the ETag in the current working catalog, the request will be rejected. If not
         * provided, the current version of the document in the working catalog will be published.
         */
        public String ETag;
        /** The unique ID of the item. */
        public String Id;
        
    }

    public static class PublishDraftItemResponse {
        
    }

    public static enum PublishResult {
        Unknown,
        Pending,
        Succeeded,
        Failed,
        Canceled
    }

    public static class PurchaseInventoryItemsOperation {
        /** The amount to purchase. */
        public Integer Amount;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the operation should be deleted from the inventory. (Default =
         * false)
         */
        public Boolean DeleteEmptyStacks;
        /** The duration to purchase. */
        public Double DurationInSeconds;
        /** The inventory item the operation applies to. */
        public InventoryItemReference Item;
        /** The values to apply to a stack newly created by this operation. */
        public InitialValues NewStackValues;
        /**
         * The per-item price the item is expected to be purchased at. This must match a value configured in the Catalog or
         * specified Store.
         */
        public ArrayList<PurchasePriceAmount> PriceAmounts;
        /** The id of the Store to purchase the item from. */
        public String StoreId;
        
    }

    /** Purchase a single item or bundle, paying the associated price. */
    public static class PurchaseInventoryItemsRequest {
        /** The amount to purchase. */
        public Integer Amount;
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the request should be deleted from the inventory.
         * (Default=false)
         */
        public Boolean DeleteEmptyStacks;
        /** The duration to purchase. */
        public Double DurationInSeconds;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        public String IdempotencyId;
        /** The inventory item the request applies to. */
        public InventoryItemReference Item;
        /** The values to apply to a stack newly created by this request. */
        public InitialValues NewStackValues;
        /**
         * The per-item price the item is expected to be purchased at. This must match a value configured in the Catalog or
         * specified Store.
         */
        public ArrayList<PurchasePriceAmount> PriceAmounts;
        /** The id of the Store to purchase the item from. */
        public String StoreId;
        
    }

    public static class PurchaseInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /** The idempotency id used in the request. */
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        public ArrayList<String> TransactionIds;
        
    }

    public static class PurchaseOverride {
        
    }

    public static class PurchaseOverridesInfo {
        
    }

    public static class PurchasePriceAmount {
        /** The amount of the inventory item to use in the purchase . */
        public Integer Amount;
        /** The inventory item id to use in the purchase . */
        public String ItemId;
        /** The inventory stack id the to use in the purchase. Set to "default" by default */
        public String StackId;
        
    }

    public static class Rating {
        /** The average rating for this item. */
        public Float Average;
        /** The total count of 1 star ratings for this item. */
        public Integer Count1Star;
        /** The total count of 2 star ratings for this item. */
        public Integer Count2Star;
        /** The total count of 3 star ratings for this item. */
        public Integer Count3Star;
        /** The total count of 4 star ratings for this item. */
        public Integer Count4Star;
        /** The total count of 5 star ratings for this item. */
        public Integer Count5Star;
        /** The total count of ratings for this item. */
        public Integer TotalCount;
        
    }

    public static class RealMoneyPriceDetails {
        
    }

    /** Redeem items from the Apple App Store. */
    public static class RedeemAppleAppStoreInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The receipt provided by the Apple marketplace upon successful purchase. */
        public String Receipt;
        
    }

    public static class RedeemAppleAppStoreInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem items from the Google Play Store. */
    public static class RedeemGooglePlayInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The list of purchases to redeem */
        public ArrayList<GooglePlayProductPurchase> Purchases;
        
    }

    public static class RedeemGooglePlayInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem items from the Microsoft Store. */
    public static class RedeemMicrosoftStoreInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        public String CollectionId;
        /** The OneStore Collections Id Key used for AAD authentication. */
        public String CollectionsIdKey;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * Xbox Token used for delegated business partner authentication. Token provided by the Xbox Live SDK method
         * GetTokenAndSignatureAsync("POST", "https://playfabapi.com/", "").
         */
        public String XboxToken;
        
    }

    public static class RedeemMicrosoftStoreInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem items from the Nintendo EShop. */
    public static class RedeemNintendoEShopInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The Nintendo provided token authorizing redemption */
        public String NintendoServiceAccountIdToken;
        
    }

    public static class RedeemNintendoEShopInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem items from the PlayStation Store. */
    public static class RedeemPlayStationStoreInventoryItemsRequest {
        /** Auth code returned by PlayStation :tm: Network OAuth system. */
        public String AuthorizationCode;
        /** The id of the entity's collection to perform this action on. (Default="default") */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** Redirect URI supplied to PlayStation :tm: Network when requesting an auth code. */
        public String RedirectUri;
        /** Optional Service Label to pass into the request. */
        public String ServiceLabel;
        
    }

    public static class RedeemPlayStationStoreInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem inventory items from Steam. */
    public static class RedeemSteamInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class RedeemSteamInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        public ArrayList<String> TransactionIds;
        
    }

    public static class RedemptionFailure {
        /** The marketplace failure code. */
        public String FailureCode;
        /** The marketplace error details explaining why the offer failed to redeem. */
        public String FailureDetails;
        /** The Marketplace Alternate ID being redeemed. */
        public String MarketplaceAlternateId;
        /** The transaction id in the external marketplace. */
        public String MarketplaceTransactionId;
        
    }

    public static class RedemptionSuccess {
        /** The Marketplace Alternate ID being redeemed. */
        public String MarketplaceAlternateId;
        /** The transaction id in the external marketplace. */
        public String MarketplaceTransactionId;
        /** The timestamp for when the redeem was completed. */
        public Date SuccessTimestamp;
        
    }

    public static class ReportItemRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** Category of concern for this report. */
        public ConcernCategory ConcernCategory;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The unique ID of the item. */
        public String Id;
        /** The string reason for this report. */
        public String Reason;
        
    }

    public static class ReportItemResponse {
        
    }

    /** Submit a report for an inappropriate review, allowing the submitting user to specify their concern. */
    public static class ReportItemReviewRequest {
        /** An alternate ID of the item associated with the review. */
        public CatalogAlternateId AlternateId;
        /** The reason this review is being reported. */
        public ConcernCategory ConcernCategory;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The string ID of the item associated with the review. */
        public String ItemId;
        /** The string reason for this report. */
        public String Reason;
        /** The ID of the review to submit a report for. */
        public String ReviewId;
        
    }

    public static class ReportItemReviewResponse {
        
    }

    public static class Review {
        /** The star rating associated with each selected category in this review. */
        public Map<String,Integer> CategoryRatings;
        /** The number of negative helpfulness votes for this review. */
        public Integer HelpfulNegative;
        /** The number of positive helpfulness votes for this review. */
        public Integer HelpfulPositive;
        /** Indicates whether the review author has the item installed. */
        public Boolean IsInstalled;
        /** The ID of the item being reviewed. */
        public String ItemId;
        /** The version of the item being reviewed. */
        public String ItemVersion;
        /** The locale for which this review was submitted in. */
        public String Locale;
        /** Star rating associated with this review. */
        public Integer Rating;
        /** The ID of the author of the review. */
        public EntityKey ReviewerEntity;
        /** Deprecated. Use ReviewerEntity instead. This property will be removed in a future release. */
        public String ReviewerId;
        /** The ID of the review. */
        public String ReviewId;
        /** The full text of this review. */
        public String ReviewText;
        /** The date and time this review was last submitted. */
        public Date Submitted;
        /** The title of this review. */
        public String Title;
        
    }

    public static class ReviewConfig {
        /** A set of categories that can be applied toward ratings and reviews. */
        public ArrayList<CategoryRatingConfig> CategoryRatings;
        
    }

    public static class ReviewItemRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The unique ID of the item. */
        public String Id;
        /** The review to submit. */
        public Review Review;
        
    }

    public static class ReviewItemResponse {
        
    }

    public static class ReviewTakedown {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The ID of the item associated with the review to take down. */
        public String ItemId;
        /** The ID of the review to take down. */
        public String ReviewId;
        
    }

    public static class ScanResult {
        /** The URL of the item which failed the scan. */
        public String Url;
        
    }

    public static class SearchItemsRequest {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Maximum page size is 50. Default value is 10. */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * An OData filter used to refine the search query (For example: "type eq 'ugc'"). More info about Filter Complexity limits
         * can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/search#limits
         */
        public String Filter;
        /** The locale to be returned in the result. */
        public String Language;
        /** An OData orderBy used to order the results of the search query. For example: "rating/average asc" */
        public String OrderBy;
        /** The text to search for. */
        public String Search;
        /**
         * An OData select query option used to augment the search results. If not defined, the default search result metadata will
         * be returned.
         */
        public String Select;
        /** The store to restrict the search request to. */
        public StoreReference Store;
        
    }

    public static class SearchItemsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        public String ContinuationToken;
        /** The paginated set of results for the search query. */
        public ArrayList<CatalogItem> Items;
        
    }

    public static class SetItemModerationStateRequest {
        /** An alternate ID associated with this item. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The unique ID of the item. */
        public String Id;
        /** The reason for the moderation state change for the associated item. */
        public String Reason;
        /** The status to set for the associated item. */
        public ModerationStatus Status;
        
    }

    public static class SetItemModerationStateResponse {
        
    }

    public static class StoreDetails {
        /** The options for the filter in filter-based stores. These options are mutually exclusive with item references. */
        public FilterOptions FilterOptions;
        /** The permissions that control which players can purchase from the store. */
        public Permissions Permissions;
        /** The global prices utilized in the store. These options are mutually exclusive with price options in item references. */
        public CatalogPriceOptionsOverride PriceOptionsOverride;
        
    }

    public static class StoreReference {
        /** An alternate ID of the store. */
        public CatalogAlternateId AlternateId;
        /** The unique ID of the store. */
        public String Id;
        
    }

    public static class SubmitItemReviewVoteRequest {
        /** An alternate ID of the item associated with the review. */
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The string ID of the item associated with the review. */
        public String ItemId;
        /** The ID of the review to submit a helpfulness vote for. */
        public String ReviewId;
        /** The helpfulness vote of the review. */
        public HelpfulnessVote Vote;
        
    }

    public static class SubmitItemReviewVoteResponse {
        
    }

    public static class SubscriptionDetails {
        /** The length of time that the subscription will last in seconds. */
        public Double DurationInSeconds;
        
    }

    public static class SubtractInventoryItemsOperation {
        /** The amount to subtract from the current item amount. */
        public Integer Amount;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the request should be deleted from the inventory. (Default =
         * false).
         */
        public Boolean DeleteEmptyStacks;
        /** The duration to subtract from the current item expiration date. */
        public Double DurationInSeconds;
        /** The inventory item the operation applies to. */
        public InventoryItemReference Item;
        
    }

    /** Given an entity type, entity identifier and container details, will subtract the specified inventory items. */
    public static class SubtractInventoryItemsRequest {
        /** The amount to subtract for the current item. */
        public Integer Amount;
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the request should be deleted from the inventory.
         * (Default=false)
         */
        public Boolean DeleteEmptyStacks;
        /** The duration to subtract from the current item expiration date. */
        public Double DurationInSeconds;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        public String IdempotencyId;
        /** The inventory item the request applies to. */
        public InventoryItemReference Item;
        
    }

    public static class SubtractInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /** The idempotency id used in the request. */
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        public ArrayList<String> TransactionIds;
        
    }

    /**
     * Submit a request to takedown one or more reviews, removing them from public view. Authors will still be able to see
     * their reviews after being taken down.
     */
    public static class TakedownItemReviewsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The set of reviews to take down. */
        public ArrayList<ReviewTakedown> Reviews;
        
    }

    public static class TakedownItemReviewsResponse {
        
    }

    public static class Transaction {
        /** The API call that caused this transaction. */
        public String ApiName;
        /** The type of item that the the operation occurred on. */
        public String ItemType;
        /** The operations that occurred. */
        public ArrayList<TransactionOperation> Operations;
        /** The type of operation that was run. */
        public String OperationType;
        /** Additional details about the transaction. Null if it was not a purchase operation. */
        public TransactionPurchaseDetails PurchaseDetails;
        /** Additional details about the transaction. Null if it was not a redeem operation. */
        public TransactionRedeemDetails RedeemDetails;
        /** The time this transaction occurred in UTC. */
        public Date Timestamp;
        /** The id of the transaction. This should be treated like an opaque token. */
        public String TransactionId;
        /** Additional details about the transaction. Null if it was not a transfer operation. */
        public TransactionTransferDetails TransferDetails;
        
    }

    public static class TransactionOperation {
        /** The amount of items in this transaction. */
        public Integer Amount;
        /** The duration modified in this transaction. */
        public Double DurationInSeconds;
        /** The friendly id of the items in this transaction. */
        public String ItemFriendlyId;
        /** The item id of the items in this transaction. */
        public String ItemId;
        /** The type of item that the operation occurred on. */
        public String ItemType;
        /** The stack id of the items in this transaction. */
        public String StackId;
        /** The type of the operation that occurred. */
        public String Type;
        
    }

    public static class TransactionPurchaseDetails {
        /** The friendly id of the Store the item was purchased from or null. */
        public String StoreFriendlyId;
        /** The id of the Store the item was purchased from or null. */
        public String StoreId;
        
    }

    public static class TransactionRedeemDetails {
        /** The marketplace that the offer is being redeemed from. */
        public String Marketplace;
        /** The transaction Id returned from the marketplace. */
        public String MarketplaceTransactionId;
        /** The offer Id of the item being redeemed. */
        public String OfferId;
        
    }

    public static class TransactionTransferDetails {
        /** The collection id the items were transferred from or null if it was the current collection. */
        public String GivingCollectionId;
        /** The entity the items were transferred from or null if it was the current entity. */
        public EntityKey GivingEntity;
        /** The collection id the items were transferred to or null if it was the current collection. */
        public String ReceivingCollectionId;
        /** The entity the items were transferred to or null if it was the current entity. */
        public EntityKey ReceivingEntity;
        /** The id of the transfer that occurred. */
        public String TransferId;
        
    }

    public static class TransferInventoryItemsOperation {
        /** The amount to transfer. */
        public Integer Amount;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the operation should be deleted from the inventory. (Default =
         * false)
         */
        public Boolean DeleteEmptyStacks;
        /** The inventory item the operation is transferring from. */
        public InventoryItemReference GivingItem;
        /** The values to apply to a stack newly created by this operation. */
        public InitialValues NewStackValues;
        /** The inventory item the operation is transferring to. */
        public InventoryItemReference ReceivingItem;
        
    }

    /** Transfer the specified inventory items of an entity's container Id to another entity's container Id. */
    public static class TransferInventoryItemsRequest {
        /** The amount to transfer . */
        public Integer Amount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the request should be deleted from the inventory. (Default =
         * false)
         */
        public Boolean DeleteEmptyStacks;
        /** The inventory collection id the request is transferring from. (Default="default") */
        public String GivingCollectionId;
        /** The entity the request is transferring from. Set to the caller by default. */
        public EntityKey GivingEntity;
        /**
         * ETags are used for concurrency checking when updating resources (before transferring from). More information about using
         * ETags can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String GivingETag;
        /** The inventory item the request is transferring from. */
        public InventoryItemReference GivingItem;
        /** The idempotency id for the request. */
        public String IdempotencyId;
        /** The values to apply to a stack newly created by this request. */
        public InitialValues NewStackValues;
        /** The inventory collection id the request is transferring to. (Default="default") */
        public String ReceivingCollectionId;
        /** The entity the request is transferring to. Set to the caller by default. */
        public EntityKey ReceivingEntity;
        /** The inventory item the request is transferring to. */
        public InventoryItemReference ReceivingItem;
        
    }

    public static class TransferInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources (after transferring from). More information about using
         * ETags can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String GivingETag;
        /** The ids of transactions that occurred as a result of the request's giving action. */
        public ArrayList<String> GivingTransactionIds;
        /** The idempotency id for the request. */
        public String IdempotencyId;
        /**
         * The transfer operation status. Possible values are 'InProgress' or 'Completed'. If the operation has completed, the
         * response code will be 200. Otherwise, it will be 202.
         */
        public String OperationStatus;
        /**
         * The token that can be used to get the status of the transfer operation. This will only have a value if OperationStatus
         * is 'InProgress'.
         */
        public String OperationToken;
        /** The ids of transactions that occurred as a result of the request's receiving action. */
        public ArrayList<String> ReceivingTransactionIds;
        
    }

    public static class UpdateCatalogConfigRequest {
        /** The updated catalog configuration. */
        public CatalogConfig Config;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class UpdateCatalogConfigResponse {
        
    }

    public static class UpdateDraftItemRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Updated metadata describing the catalog item to be updated. */
        public CatalogItem Item;
        /** Whether the item should be published immediately. This value is optional, defaults to false. */
        public Boolean Publish;
        
    }

    public static class UpdateDraftItemResponse {
        /** Updated metadata describing the catalog item just updated. */
        public CatalogItem Item;
        
    }

    public static class UpdateInventoryItemsOperation {
        /** The inventory item to update with the specified values. */
        public InventoryItem Item;
        
    }

    /** Given an entity type, entity identifier and container details, will update the entity's inventory items */
    public static class UpdateInventoryItemsRequest {
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        public String IdempotencyId;
        /** The inventory item to update with the specified values. */
        public InventoryItem Item;
        
    }

    public static class UpdateInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        public String ETag;
        /** The idempotency id used in the request. */
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        public ArrayList<String> TransactionIds;
        
    }

    public static class UploadInfo {
        /** Name of the file to be uploaded. */
        public String FileName;
        
    }

    public static class UploadUrlMetadata {
        /** Name of the file for which this upload URL was requested. */
        public String FileName;
        /** Unique ID for the binary content to be uploaded to the target URL. */
        public String Id;
        /** URL for the binary content to be uploaded to. */
        public String Url;
        
    }

    public static class UserGeneratedContentSpecificConfig {
        /** The set of content types that will be used for validation. */
        public ArrayList<String> ContentTypes;
        /** The set of tags that will be used for validation. */
        public ArrayList<String> Tags;
        
    }

}
