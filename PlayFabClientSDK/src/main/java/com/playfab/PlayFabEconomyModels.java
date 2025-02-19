package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabEconomyModels {

    @Deprecated
    public static class AddInventoryItemsOperation {
        /** The amount to add to the current item amount. */
        @Deprecated
        public Integer Amount;
        /** The duration to add to the current item expiration date. */
        @Deprecated
        public Double DurationInSeconds;
        /** The inventory item the operation applies to. */
        @Deprecated
        public InventoryItemReference Item;
        /** The values to apply to a stack newly created by this operation. */
        @Deprecated
        public InitialValues NewStackValues;
        
    }

    /** Given an entity type, entity identifier and container details, will add the specified inventory items. */
    @Deprecated
    public static class AddInventoryItemsRequest {
        /** The amount to add for the current item. */
        @Deprecated
        public Integer Amount;
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The duration to add to the current item expiration date. */
        @Deprecated
        public Double DurationInSeconds;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        @Deprecated
        public String IdempotencyId;
        /** The inventory item the request applies to. */
        @Deprecated
        public InventoryItemReference Item;
        /** The values to apply to a stack newly created by this request. */
        @Deprecated
        public InitialValues NewStackValues;
        
    }

    @Deprecated
    public static class AddInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /** The idempotency id used in the request. */
        @Deprecated
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    @Deprecated
    public static class AlternateId {
        /** Type of the alternate ID. */
        @Deprecated
        public String Type;
        /** Value of the alternate ID. */
        @Deprecated
        public String Value;
        
    }

    @Deprecated
    public static class CatalogAlternateId {
        /** Type of the alternate ID. */
        @Deprecated
        public String Type;
        /** Value of the alternate ID. */
        @Deprecated
        public String Value;
        
    }

    @Deprecated
    public static class CatalogConfig {
        /** A list of player entity keys that will have admin permissions. There is a maximum of 64 entities that can be added. */
        @Deprecated
        public ArrayList<EntityKey> AdminEntities;
        /** The set of configuration that only applies to catalog items. */
        @Deprecated
        public CatalogSpecificConfig Catalog;
        /** A list of deep link formats. Up to 10 can be added. */
        @Deprecated
        public ArrayList<DeepLinkFormat> DeepLinkFormats;
        /**
         * A list of display properties to index. Up to 5 mappings can be added per Display Property Type. More info on display
         * properties can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/content-types-tags-and-properties#displayproperties
         */
        @Deprecated
        public ArrayList<DisplayPropertyIndexInfo> DisplayPropertyIndexInfos;
        /** The set of configuration that only applies to Files. */
        @Deprecated
        public FileConfig File;
        /** The set of configuration that only applies to Images. */
        @Deprecated
        public ImageConfig Image;
        /** Flag defining whether catalog is enabled. */
        @Deprecated
        public Boolean IsCatalogEnabled;
        /**
         * A list of Platforms that can be applied to catalog items. Each platform can have a maximum character length of 40 and up
         * to 128 platforms can be listed.
         */
        @Deprecated
        public ArrayList<String> Platforms;
        /** The set of configuration that only applies to Ratings and Reviews. */
        @Deprecated
        public ReviewConfig Review;
        /** A set of player entity keys that are allowed to review content. There is a maximum of 128 entities that can be added. */
        @Deprecated
        public ArrayList<EntityKey> ReviewerEntities;
        /** The set of configuration that only applies to user generated contents. */
        @Deprecated
        public UserGeneratedContentSpecificConfig UserGeneratedContent;
        
    }

    @Deprecated
    public static class CatalogItem {
        /**
         * The alternate IDs associated with this item. An alternate ID can be set to 'FriendlyId' or any of the supported
         * marketplace names.
         */
        @Deprecated
        public ArrayList<CatalogAlternateId> AlternateIds;
        /** The set of content/files associated with this item. Up to 100 files can be added to an item. */
        @Deprecated
        public ArrayList<Content> Contents;
        /** The client-defined type of the item. */
        @Deprecated
        public String ContentType;
        /** The date and time when this item was created. */
        @Deprecated
        public Date CreationDate;
        /** The ID of the creator of this catalog item. */
        @Deprecated
        public EntityKey CreatorEntity;
        /** The set of platform specific deep links for this item. */
        @Deprecated
        public ArrayList<DeepLink> DeepLinks;
        /**
         * The Stack Id that will be used as default for this item in Inventory when an explicit one is not provided. This
         * DefaultStackId can be a static stack id or '{guid}', which will generate a unique stack id for the item. If null,
         * Inventory's default stack id will be used.
         */
        @Deprecated
        public String DefaultStackId;
        /**
         * A dictionary of localized descriptions. Key is language code and localized string is the value. The NEUTRAL locale is
         * required. Descriptions have a 10000 character limit per country code.
         */
        @Deprecated
        public Map<String,String> Description;
        /**
         * Game specific properties for display purposes. This is an arbitrary JSON blob. The Display Properties field has a 10000
         * byte limit per item.
         */
        @Deprecated
        public Object DisplayProperties;
        /** The user provided version of the item for display purposes. Maximum character length of 50. */
        @Deprecated
        public String DisplayVersion;
        /** The date of when the item will cease to be available. If not provided then the product will be available indefinitely. */
        @Deprecated
        public Date EndDate;
        /** The current ETag value that can be used for optimistic concurrency in the If-None-Match header. */
        @Deprecated
        public String ETag;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        /**
         * The images associated with this item. Images can be thumbnails or screenshots. Up to 100 images can be added to an item.
         * Only .png, .jpg, .gif, and .bmp file types can be uploaded
         */
        @Deprecated
        public ArrayList<Image> Images;
        /** Indicates if the item is hidden. */
        @Deprecated
        public Boolean IsHidden;
        /**
         * The item references associated with this item. For example, the items in a Bundle/Store/Subscription. Every item can
         * have up to 50 item references.
         */
        @Deprecated
        public ArrayList<CatalogItemReference> ItemReferences;
        /**
         * A dictionary of localized keywords. Key is language code and localized list of keywords is the value. Keywords have a 50
         * character limit per keyword and up to 32 keywords can be added per country code.
         */
        @Deprecated
        public Map<String,KeywordSet> Keywords;
        /** The date and time this item was last updated. */
        @Deprecated
        public Date LastModifiedDate;
        /** The moderation state for this item. */
        @Deprecated
        public ModerationState Moderation;
        /** The platforms supported by this item. */
        @Deprecated
        public ArrayList<String> Platforms;
        /** The prices the item can be purchased for. */
        @Deprecated
        public CatalogPriceOptions PriceOptions;
        /** Rating summary for this item. */
        @Deprecated
        public Rating Rating;
        /** The real price the item was purchased for per marketplace. */
        @Deprecated
        public RealMoneyPriceDetails RealMoneyPriceDetails;
        /** The date of when the item will be available. If not provided then the product will appear immediately. */
        @Deprecated
        public Date StartDate;
        /** Optional details for stores items. */
        @Deprecated
        public StoreDetails StoreDetails;
        /** The list of tags that are associated with this item. Up to 32 tags can be added to an item. */
        @Deprecated
        public ArrayList<String> Tags;
        /**
         * A dictionary of localized titles. Key is language code and localized string is the value. The NEUTRAL locale is
         * required. Titles have a 512 character limit per country code.
         */
        @Deprecated
        public Map<String,String> Title;
        /**
         * The high-level type of the item. The following item types are supported: bundle, catalogItem, currency, store, ugc,
         * subscription.
         */
        @Deprecated
        public String Type;
        
    }

    @Deprecated
    public static class CatalogItemReference {
        /** The amount of the catalog item. */
        @Deprecated
        public Integer Amount;
        /** The unique ID of the catalog item. */
        @Deprecated
        public String Id;
        /** The prices the catalog item can be purchased for. */
        @Deprecated
        public CatalogPriceOptions PriceOptions;
        
    }

    @Deprecated
    public static class CatalogPrice {
        /** The amounts of the catalog item price. Each price can have up to 15 item amounts. */
        @Deprecated
        public ArrayList<CatalogPriceAmount> Amounts;
        /** The per-unit amount this price can be used to purchase. */
        @Deprecated
        public Integer UnitAmount;
        /** The per-unit duration this price can be used to purchase. The maximum duration is 100 years. */
        @Deprecated
        public Double UnitDurationInSeconds;
        
    }

    @Deprecated
    public static class CatalogPriceAmount {
        /** The amount of the price. */
        @Deprecated
        public Integer Amount;
        /** The Item Id of the price. */
        @Deprecated
        public String ItemId;
        
    }

    @Deprecated
    public static class CatalogPriceAmountOverride {
        /** The exact value that should be utilized in the override. */
        @Deprecated
        public Integer FixedValue;
        /** The id of the item this override should utilize. */
        @Deprecated
        public String ItemId;
        /**
         * The multiplier that will be applied to the base Catalog value to determine what value should be utilized in the
         * override.
         */
        @Deprecated
        public Double Multiplier;
        
    }

    @Deprecated
    public static class CatalogPriceOptions {
        /** Prices of the catalog item. An item can have up to 15 prices */
        @Deprecated
        public ArrayList<CatalogPrice> Prices;
        
    }

    @Deprecated
    public static class CatalogPriceOptionsOverride {
        /** The prices utilized in the override. */
        @Deprecated
        public ArrayList<CatalogPriceOverride> Prices;
        
    }

    @Deprecated
    public static class CatalogPriceOverride {
        /** The currency amounts utilized in the override for a singular price. */
        @Deprecated
        public ArrayList<CatalogPriceAmountOverride> Amounts;
        
    }

    @Deprecated
    public static class CatalogSpecificConfig {
        /**
         * The set of content types that will be used for validation. Each content type can have a maximum character length of 40
         * and up to 128 types can be listed.
         */
        @Deprecated
        public ArrayList<String> ContentTypes;
        /**
         * The set of tags that will be used for validation. Each tag can have a maximum character length of 32 and up to 1024 tags
         * can be listed.
         */
        @Deprecated
        public ArrayList<String> Tags;
        
    }

    @Deprecated
    public static class CategoryRatingConfig {
        /** Name of the category. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
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

    @Deprecated
    public static class Content {
        /** The content unique ID. */
        @Deprecated
        public String Id;
        /**
         * The maximum client version that this content is compatible with. Client Versions can be up to 3 segments separated by
         * periods(.) and each segment can have a maximum value of 65535.
         */
        @Deprecated
        public String MaxClientVersion;
        /**
         * The minimum client version that this content is compatible with. Client Versions can be up to 3 segments separated by
         * periods(.) and each segment can have a maximum value of 65535.
         */
        @Deprecated
        public String MinClientVersion;
        /**
         * The list of tags that are associated with this content. Tags must be defined in the Catalog Config before being used in
         * content.
         */
        @Deprecated
        public ArrayList<String> Tags;
        /** The client-defined type of the content. Content Types must be defined in the Catalog Config before being used. */
        @Deprecated
        public String Type;
        /** The Azure CDN URL for retrieval of the catalog item binary content. */
        @Deprecated
        public String Url;
        
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

    /** The item will not be published to the public catalog until the PublishItem API is called for the item. */
    @Deprecated
    public static class CreateDraftItemRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Metadata describing the new catalog item to be created. */
        @Deprecated
        public CatalogItem Item;
        /** Whether the item should be published immediately. This value is optional, defaults to false. */
        @Deprecated
        public Boolean Publish;
        
    }

    @Deprecated
    public static class CreateDraftItemResponse {
        /** Updated metadata describing the catalog item just created. */
        @Deprecated
        public CatalogItem Item;
        
    }

    /**
     * Upload URLs point to Azure Blobs; clients must follow the Microsoft Azure Storage Blob Service REST API pattern for
     * uploading content. The response contains upload URLs and IDs for each file. The IDs and URLs returned must be added to
     * the item metadata and committed using the CreateDraftItem or UpdateDraftItem Item APIs.
     */
    @Deprecated
    public static class CreateUploadUrlsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Description of the files to be uploaded by the client. */
        @Deprecated
        public ArrayList<UploadInfo> Files;
        
    }

    @Deprecated
    public static class CreateUploadUrlsResponse {
        /** List of URLs metadata for the files to be uploaded by the client. */
        @Deprecated
        public ArrayList<UploadUrlMetadata> UploadUrls;
        
    }

    @Deprecated
    public static class DeepLink {
        /** Target platform for this deep link. */
        @Deprecated
        public String Platform;
        /** The deep link for this platform. */
        @Deprecated
        public String Url;
        
    }

    @Deprecated
    public static class DeepLinkFormat {
        /** The format of the deep link to return. The format should contain '{id}' to represent where the item ID should be placed. */
        @Deprecated
        public String Format;
        /** The target platform for the deep link. */
        @Deprecated
        public String Platform;
        
    }

    @Deprecated
    public static class DeleteEntityItemReviewsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class DeleteEntityItemReviewsResponse {
        
    }

    /** Delete an Inventory Collection by the specified Id for an Entity */
    @Deprecated
    public static class DeleteInventoryCollectionRequest {
        /** The inventory collection id the request applies to. */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity the request is about. Set to the caller by default. */
        @Deprecated
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        
    }

    @Deprecated
    public static class DeleteInventoryCollectionResponse {
        
    }

    @Deprecated
    public static class DeleteInventoryItemsOperation {
        /** The inventory item the operation applies to. */
        @Deprecated
        public InventoryItemReference Item;
        
    }

    /** Given an entity type, entity identifier and container details, will delete the entity's inventory items */
    @Deprecated
    public static class DeleteInventoryItemsRequest {
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        @Deprecated
        public String IdempotencyId;
        /** The inventory item the request applies to. */
        @Deprecated
        public InventoryItemReference Item;
        
    }

    @Deprecated
    public static class DeleteInventoryItemsResponse {
        /** ETags are used for concurrency checking when updating resources. */
        @Deprecated
        public String ETag;
        /** The idempotency id used in the request. */
        @Deprecated
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    @Deprecated
    public static class DeleteItemRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        
    }

    @Deprecated
    public static class DeleteItemResponse {
        
    }

    @Deprecated
    public static class DisplayPropertyIndexInfo {
        /** The property name in the 'DisplayProperties' property to be indexed. */
        @Deprecated
        public String Name;
        /** The type of the property to be indexed. */
        @Deprecated
        public DisplayPropertyType Type;
        
    }

    @Deprecated
    public static enum DisplayPropertyType {
        None,
        QueryDateTime,
        QueryDouble,
        QueryString,
        SearchString
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

    /** Execute a list of Inventory Operations for an Entity */
    @Deprecated
    public static class ExecuteInventoryOperationsRequest {
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        @Deprecated
        public String IdempotencyId;
        /**
         * The operations to run transactionally. The operations will be executed in-order sequentially and will succeed or fail as
         * a batch. Up to 50 operations can be added.
         */
        @Deprecated
        public ArrayList<InventoryOperation> Operations;
        
    }

    @Deprecated
    public static class ExecuteInventoryOperationsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /** The idempotency id used in the request. */
        @Deprecated
        public String IdempotencyId;
        /** The ids of the transactions that occurred as a result of the request. */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    /** Transfer the specified list of inventory items of an entity's container Id to another entity's container Id. */
    @Deprecated
    public static class ExecuteTransferOperationsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The inventory collection id the request is transferring from. (Default="default") */
        @Deprecated
        public String GivingCollectionId;
        /** The entity the request is transferring from. Set to the caller by default. */
        @Deprecated
        public EntityKey GivingEntity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String GivingETag;
        /** The idempotency id for the request. */
        @Deprecated
        public String IdempotencyId;
        /**
         * The transfer operations to run transactionally. The operations will be executed in-order sequentially and will succeed
         * or fail as a batch. Up to 50 operations can be added.
         */
        @Deprecated
        public ArrayList<TransferInventoryItemsOperation> Operations;
        /** The inventory collection id the request is transferring to. (Default="default") */
        @Deprecated
        public String ReceivingCollectionId;
        /** The entity the request is transferring to. Set to the caller by default. */
        @Deprecated
        public EntityKey ReceivingEntity;
        
    }

    @Deprecated
    public static class ExecuteTransferOperationsResponse {
        /**
         * ETags are used for concurrency checking when updating resources (before transferring from). This value will be empty if
         * the operation has not completed yet. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String GivingETag;
        /** The ids of transactions that occurred as a result of the request's giving action. */
        @Deprecated
        public ArrayList<String> GivingTransactionIds;
        /** The Idempotency ID for this request. */
        @Deprecated
        public String IdempotencyId;
        /**
         * The transfer operation status. Possible values are 'InProgress' or 'Completed'. If the operation has completed, the
         * response code will be 200. Otherwise, it will be 202.
         */
        @Deprecated
        public String OperationStatus;
        /**
         * The token that can be used to get the status of the transfer operation. This will only have a value if OperationStatus
         * is 'InProgress'.
         */
        @Deprecated
        public String OperationToken;
        /**
         * ETags are used for concurrency checking when updating resources (before transferring to). This value will be empty if
         * the operation has not completed yet.
         */
        @Deprecated
        public String ReceivingETag;
        /** The ids of transactions that occurred as a result of the request's receiving action. */
        @Deprecated
        public ArrayList<String> ReceivingTransactionIds;
        
    }

    @Deprecated
    public static class FileConfig {
        /**
         * The set of content types that will be used for validation. Each content type can have a maximum character length of 40
         * and up to 128 types can be listed.
         */
        @Deprecated
        public ArrayList<String> ContentTypes;
        /**
         * The set of tags that will be used for validation. Each tag can have a maximum character length of 32 and up to 1024 tags
         * can be listed.
         */
        @Deprecated
        public ArrayList<String> Tags;
        
    }

    @Deprecated
    public static class FilterOptions {
        /**
         * The OData filter utilized. Mutually exclusive with 'IncludeAllItems'. More info about Filter Complexity limits can be
         * found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/search#limits
         */
        @Deprecated
        public String Filter;
        /** The flag that overrides the filter and allows for returning all catalog items. Mutually exclusive with 'Filter'. */
        @Deprecated
        public Boolean IncludeAllItems;
        
    }

    @Deprecated
    public static class GetCatalogConfigRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class GetCatalogConfigResponse {
        /** The catalog configuration. */
        @Deprecated
        public CatalogConfig Config;
        
    }

    @Deprecated
    public static class GetDraftItemRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        
    }

    @Deprecated
    public static class GetDraftItemResponse {
        /** Full metadata of the catalog item requested. */
        @Deprecated
        public CatalogItem Item;
        
    }

    @Deprecated
    public static class GetDraftItemsRequest {
        /** List of item alternate IDs. */
        @Deprecated
        public ArrayList<CatalogAlternateId> AlternateIds;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** List of Item Ids. */
        @Deprecated
        public ArrayList<String> Ids;
        
    }

    @Deprecated
    public static class GetDraftItemsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        @Deprecated
        public String ContinuationToken;
        /** A set of items created by the entity. */
        @Deprecated
        public ArrayList<CatalogItem> Items;
        
    }

    @Deprecated
    public static class GetEntityDraftItemsRequest {
        /**
         * An opaque token used to retrieve the next page of items created by the caller, if any are available. Should be null on
         * initial request.
         */
        @Deprecated
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Default value is 10. */
        @Deprecated
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * OData Filter to refine the items returned. CatalogItem properties 'type' can be used in the filter. For example: "type
         * eq 'ugc'"
         */
        @Deprecated
        public String Filter;
        
    }

    @Deprecated
    public static class GetEntityDraftItemsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        @Deprecated
        public String ContinuationToken;
        /** A set of items created by the entity. */
        @Deprecated
        public ArrayList<CatalogItem> Items;
        
    }

    @Deprecated
    public static class GetEntityItemReviewRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        
    }

    @Deprecated
    public static class GetEntityItemReviewResponse {
        /** The review the entity submitted for the requested item. */
        @Deprecated
        public Review Review;
        
    }

    /** Get a list of Inventory Collection Ids for the specified Entity */
    @Deprecated
    public static class GetInventoryCollectionIdsRequest {
        /** An opaque token used to retrieve the next page of collection ids, if any are available. */
        @Deprecated
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. The default value is 10 */
        @Deprecated
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity the request is about. Set to the caller by default. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetInventoryCollectionIdsResponse {
        /** The requested inventory collection ids. */
        @Deprecated
        public ArrayList<String> CollectionIds;
        /** An opaque token used to retrieve the next page of collection ids, if any are available. */
        @Deprecated
        public String ContinuationToken;
        
    }

    /** Given an entity type, entity identifier and container details, will get the entity's inventory items. */
    @Deprecated
    public static class GetInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        @Deprecated
        public String CollectionId;
        /**
         * An opaque token used to retrieve the next page of items in the inventory, if any are available. Should be null on
         * initial request.
         */
        @Deprecated
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Maximum page size is 50. The default value is 10 */
        @Deprecated
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * OData Filter to refine the items returned. InventoryItem properties 'type', 'id', and 'stackId' can be used in the
         * filter. For example: "type eq 'currency'"
         */
        @Deprecated
        public String Filter;
        
    }

    @Deprecated
    public static class GetInventoryItemsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        @Deprecated
        public String ContinuationToken;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /** The requested inventory items. */
        @Deprecated
        public ArrayList<InventoryItem> Items;
        
    }

    /** Get the status of an Inventory Operation using an OperationToken. */
    @Deprecated
    public static class GetInventoryOperationStatusRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetInventoryOperationStatusResponse {
        /** The inventory operation status. */
        @Deprecated
        public String OperationStatus;
        
    }

    /** Given an item, return a set of bundles and stores containing the item. */
    @Deprecated
    public static class GetItemContainersRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /**
         * An opaque token used to retrieve the next page of items in the inventory, if any are available. Should be null on
         * initial request.
         */
        @Deprecated
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Default value is 10. */
        @Deprecated
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        
    }

    @Deprecated
    public static class GetItemContainersResponse {
        /** List of Bundles and Stores containing the requested items. */
        @Deprecated
        public ArrayList<CatalogItem> Containers;
        /** An opaque token used to retrieve the next page of items, if any are available. */
        @Deprecated
        public String ContinuationToken;
        
    }

    @Deprecated
    public static class GetItemModerationStateRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        
    }

    @Deprecated
    public static class GetItemModerationStateResponse {
        /** The current moderation state for the requested item. */
        @Deprecated
        public ModerationState State;
        
    }

    @Deprecated
    public static class GetItemPublishStatusRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        
    }

    @Deprecated
    public static class GetItemPublishStatusResponse {
        /** High level status of the published item. */
        @Deprecated
        public PublishResult Result;
        /** Descriptive message about the current status of the publish. */
        @Deprecated
        public String StatusMessage;
        
    }

    @Deprecated
    public static class GetItemRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        
    }

    /** Get item result. */
    @Deprecated
    public static class GetItemResponse {
        /** The item result. */
        @Deprecated
        public CatalogItem Item;
        
    }

    @Deprecated
    public static class GetItemReviewsRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** An opaque token used to retrieve the next page of items, if any are available. */
        @Deprecated
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Default value is 10. */
        @Deprecated
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        /**
         * An OData orderBy used to order the results of the query. Possible values are Helpfulness, Rating, and Submitted (For
         * example: "Submitted desc")
         */
        @Deprecated
        public String OrderBy;
        
    }

    @Deprecated
    public static class GetItemReviewsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        @Deprecated
        public String ContinuationToken;
        /** The paginated set of results. */
        @Deprecated
        public ArrayList<Review> Reviews;
        
    }

    @Deprecated
    public static class GetItemReviewSummaryRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        
    }

    @Deprecated
    public static class GetItemReviewSummaryResponse {
        /** The least favorable review for this item. */
        @Deprecated
        public Review LeastFavorableReview;
        /** The most favorable review for this item. */
        @Deprecated
        public Review MostFavorableReview;
        /** The summary of ratings associated with this item. */
        @Deprecated
        public Rating Rating;
        /** The total number of reviews associated with this item. */
        @Deprecated
        public Integer ReviewsCount;
        
    }

    @Deprecated
    public static class GetItemsRequest {
        /** List of item alternate IDs. */
        @Deprecated
        public ArrayList<CatalogAlternateId> AlternateIds;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** List of Item Ids. */
        @Deprecated
        public ArrayList<String> Ids;
        
    }

    @Deprecated
    public static class GetItemsResponse {
        /** Metadata of set of items. */
        @Deprecated
        public ArrayList<CatalogItem> Items;
        
    }

    /** Gets the access tokens for Microsoft Store authentication. */
    @Deprecated
    public static class GetMicrosoftStoreAccessTokensRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class GetMicrosoftStoreAccessTokensResponse {
        /**
         * The collections access token for calling https://onestore.microsoft.com/b2b/keys/create/collections to obtain a
         * CollectionsIdKey for the user
         */
        @Deprecated
        public String CollectionsAccessToken;
        /** The date the collections access token expires */
        @Deprecated
        public Date CollectionsAccessTokenExpirationDate;
        
    }

    /** Get transaction history for specified entity and collection. */
    @Deprecated
    public static class GetTransactionHistoryRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        @Deprecated
        public String CollectionId;
        /** An opaque token used to retrieve the next page of items, if any are available. Should be null on initial request. */
        @Deprecated
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. The default value is 10 */
        @Deprecated
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * An OData filter used to refine the TransactionHistory. Transaction properties 'timestamp', 'transactionid', 'apiname'
         * and 'operationtype' can be used in the filter. Properties 'transactionid', 'apiname', and 'operationtype' cannot be used
         * together in a single request. The 'timestamp' property can be combined with 'apiname' or 'operationtype' in a single
         * request. For example: "timestamp ge 2023-06-20T23:30Z" or "transactionid eq '10'" or "(timestamp ge 2023-06-20T23:30Z)
         * and (apiname eq 'AddInventoryItems')". By default, a 6 month timespan from the current date is used.
         */
        @Deprecated
        public String Filter;
        /**
         * An OData orderby to order TransactionHistory results. The only supported values are 'timestamp asc' or 'timestamp desc'.
         * Default orderby is 'timestamp asc'
         */
        @Deprecated
        public String OrderBy;
        
    }

    @Deprecated
    public static class GetTransactionHistoryResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. Should be null on initial request. */
        @Deprecated
        public String ContinuationToken;
        /** The requested inventory transactions. */
        @Deprecated
        public ArrayList<Transaction> Transactions;
        
    }

    @Deprecated
    public static class GooglePlayProductPurchase {
        /** The Product ID (SKU) of the InApp product purchased from the Google Play store. */
        @Deprecated
        public String ProductId;
        /** The token provided to the player's device when the product was purchased */
        @Deprecated
        public String Token;
        
    }

    @Deprecated
    public static enum HelpfulnessVote {
        None,
        UnHelpful,
        Helpful
    }

    @Deprecated
    public static class Image {
        /** The image unique ID. */
        @Deprecated
        public String Id;
        /**
         * The client-defined tag associated with this image. Tags must be defined in the Catalog Config before being used in
         * images
         */
        @Deprecated
        public String Tag;
        /** Images can be defined as either a "thumbnail" or "screenshot". There can only be one "thumbnail" image per item. */
        @Deprecated
        public String Type;
        /** The URL for retrieval of the image. */
        @Deprecated
        public String Url;
        
    }

    @Deprecated
    public static class ImageConfig {
        /**
         * The set of tags that will be used for validation. Each tag can have a maximum character length of 32 and up to 1024 tags
         * can be listed.
         */
        @Deprecated
        public ArrayList<String> Tags;
        
    }

    @Deprecated
    public static class InitialValues {
        /** Game specific properties for display purposes. The Display Properties field has a 1000 byte limit. */
        @Deprecated
        public Object DisplayProperties;
        
    }

    @Deprecated
    public static class InventoryItem {
        /** The amount of the item. */
        @Deprecated
        public Integer Amount;
        /**
         * Game specific properties for display purposes. This is an arbitrary JSON blob. The Display Properties field has a 1000
         * byte limit.
         */
        @Deprecated
        public Object DisplayProperties;
        /** Only used for subscriptions. The date of when the item will expire in UTC. */
        @Deprecated
        public Date ExpirationDate;
        /** The id of the item. This should correspond to the item id in the catalog. */
        @Deprecated
        public String Id;
        /** The stack id of the item. */
        @Deprecated
        public String StackId;
        /** The type of the item. This should correspond to the item type in the catalog. */
        @Deprecated
        public String Type;
        
    }

    @Deprecated
    public static class InventoryItemReference {
        /** The inventory item alternate id the request applies to. */
        @Deprecated
        public AlternateId AlternateId;
        /** The inventory item id the request applies to. */
        @Deprecated
        public String Id;
        /** The inventory stack id the request should redeem to. (Default="default") */
        @Deprecated
        public String StackId;
        
    }

    @Deprecated
    public static class InventoryOperation {
        /** The add operation. */
        @Deprecated
        public AddInventoryItemsOperation Add;
        /** The delete operation. */
        @Deprecated
        public DeleteInventoryItemsOperation Delete;
        /** The purchase operation. */
        @Deprecated
        public PurchaseInventoryItemsOperation Purchase;
        /** The subtract operation. */
        @Deprecated
        public SubtractInventoryItemsOperation Subtract;
        /** The transfer operation. */
        @Deprecated
        public TransferInventoryItemsOperation Transfer;
        /** The update operation. */
        @Deprecated
        public UpdateInventoryItemsOperation Update;
        
    }

    @Deprecated
    public static class KeywordSet {
        /** A list of localized keywords. */
        @Deprecated
        public ArrayList<String> Values;
        
    }

    @Deprecated
    public static class ModerationState {
        /** The date and time this moderation state was last updated. */
        @Deprecated
        public Date LastModifiedDate;
        /** The current stated reason for the associated item being moderated. */
        @Deprecated
        public String Reason;
        /** The current moderation status for the associated item. */
        @Deprecated
        public ModerationStatus Status;
        
    }

    @Deprecated
    public static enum ModerationStatus {
        Unknown,
        AwaitingModeration,
        Approved,
        Rejected
    }

    @Deprecated
    public static class Permissions {
        /**
         * The list of ids of Segments that the a player can be in to purchase from the store. When a value is provided, the player
         * must be in at least one of the segments listed for the purchase to be allowed.
         */
        @Deprecated
        public ArrayList<String> SegmentIds;
        
    }

    /**
     * The call kicks off a workflow to publish the item to the public catalog. The Publish Status API should be used to
     * monitor the publish job.
     */
    @Deprecated
    public static class PublishDraftItemRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * ETag of the catalog item to published from the working catalog to the public catalog. Used for optimistic concurrency.
         * If the provided ETag does not match the ETag in the current working catalog, the request will be rejected. If not
         * provided, the current version of the document in the working catalog will be published.
         */
        @Deprecated
        public String ETag;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        
    }

    @Deprecated
    public static class PublishDraftItemResponse {
        
    }

    @Deprecated
    public static enum PublishResult {
        Unknown,
        Pending,
        Succeeded,
        Failed,
        Canceled
    }

    @Deprecated
    public static class PurchaseInventoryItemsOperation {
        /** The amount to purchase. */
        @Deprecated
        public Integer Amount;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the operation should be deleted from the inventory. (Default =
         * false)
         */
        @Deprecated
        public Boolean DeleteEmptyStacks;
        /** The duration to purchase. */
        @Deprecated
        public Double DurationInSeconds;
        /** The inventory item the operation applies to. */
        @Deprecated
        public InventoryItemReference Item;
        /** The values to apply to a stack newly created by this operation. */
        @Deprecated
        public InitialValues NewStackValues;
        /**
         * The per-item price the item is expected to be purchased at. This must match a value configured in the Catalog or
         * specified Store.
         */
        @Deprecated
        public ArrayList<PurchasePriceAmount> PriceAmounts;
        /** The id of the Store to purchase the item from. */
        @Deprecated
        public String StoreId;
        
    }

    /** Purchase a single item or bundle, paying the associated price. */
    @Deprecated
    public static class PurchaseInventoryItemsRequest {
        /** The amount to purchase. */
        @Deprecated
        public Integer Amount;
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the request should be deleted from the inventory.
         * (Default=false)
         */
        @Deprecated
        public Boolean DeleteEmptyStacks;
        /** The duration to purchase. */
        @Deprecated
        public Double DurationInSeconds;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        @Deprecated
        public String IdempotencyId;
        /** The inventory item the request applies to. */
        @Deprecated
        public InventoryItemReference Item;
        /** The values to apply to a stack newly created by this request. */
        @Deprecated
        public InitialValues NewStackValues;
        /**
         * The per-item price the item is expected to be purchased at. This must match a value configured in the Catalog or
         * specified Store.
         */
        @Deprecated
        public ArrayList<PurchasePriceAmount> PriceAmounts;
        /** The id of the Store to purchase the item from. */
        @Deprecated
        public String StoreId;
        
    }

    @Deprecated
    public static class PurchaseInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /** The idempotency id used in the request. */
        @Deprecated
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    @Deprecated
    public static class PurchaseOverridesInfo {
        
    }

    @Deprecated
    public static class PurchasePriceAmount {
        /** The amount of the inventory item to use in the purchase . */
        @Deprecated
        public Integer Amount;
        /** The inventory item id to use in the purchase . */
        @Deprecated
        public String ItemId;
        /** The inventory stack id the to use in the purchase. Set to "default" by default */
        @Deprecated
        public String StackId;
        
    }

    @Deprecated
    public static class Rating {
        /** The average rating for this item. */
        @Deprecated
        public Float Average;
        /** The total count of 1 star ratings for this item. */
        @Deprecated
        public Integer Count1Star;
        /** The total count of 2 star ratings for this item. */
        @Deprecated
        public Integer Count2Star;
        /** The total count of 3 star ratings for this item. */
        @Deprecated
        public Integer Count3Star;
        /** The total count of 4 star ratings for this item. */
        @Deprecated
        public Integer Count4Star;
        /** The total count of 5 star ratings for this item. */
        @Deprecated
        public Integer Count5Star;
        /** The total count of ratings for this item. */
        @Deprecated
        public Integer TotalCount;
        
    }

    @Deprecated
    public static class RealMoneyPriceDetails {
        /** The 'AppleAppStore' price amount per CurrencyCode. 'USD' supported only. */
        @Deprecated
        public Map<String,Integer> AppleAppStorePrices;
        /** The 'GooglePlay' price amount per CurrencyCode. 'USD' supported only. */
        @Deprecated
        public Map<String,Integer> GooglePlayPrices;
        /** The 'MicrosoftStore' price amount per CurrencyCode. 'USD' supported only. */
        @Deprecated
        public Map<String,Integer> MicrosoftStorePrices;
        /** The 'NintendoEShop' price amount per CurrencyCode. 'USD' supported only. */
        @Deprecated
        public Map<String,Integer> NintendoEShopPrices;
        /** The 'PlayStationStore' price amount per CurrencyCode. 'USD' supported only. */
        @Deprecated
        public Map<String,Integer> PlayStationStorePrices;
        /** The 'Steam' price amount per CurrencyCode. 'USD' supported only. */
        @Deprecated
        public Map<String,Integer> SteamPrices;
        
    }

    /** Redeem items from the Apple App Store. */
    @Deprecated
    public static class RedeemAppleAppStoreInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The receipt provided by the Apple marketplace upon successful purchase. */
        @Deprecated
        public String Receipt;
        
    }

    @Deprecated
    public static class RedeemAppleAppStoreInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem items from the Google Play Store. */
    @Deprecated
    public static class RedeemGooglePlayInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The list of purchases to redeem */
        @Deprecated
        public ArrayList<GooglePlayProductPurchase> Purchases;
        
    }

    @Deprecated
    public static class RedeemGooglePlayInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem items from the Microsoft Store. */
    @Deprecated
    public static class RedeemMicrosoftStoreInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        @Deprecated
        public String CollectionId;
        /** The OneStore Collections Id Key used for AAD authentication. */
        @Deprecated
        public String CollectionsIdKey;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * Xbox Token used for delegated business partner authentication. Token provided by the Xbox Live SDK method
         * GetTokenAndSignatureAsync("POST", "https://playfabapi.com/", "").
         */
        @Deprecated
        public String XboxToken;
        
    }

    @Deprecated
    public static class RedeemMicrosoftStoreInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem items from the Nintendo EShop. */
    @Deprecated
    public static class RedeemNintendoEShopInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The Nintendo provided token authorizing redemption */
        @Deprecated
        public String NintendoServiceAccountIdToken;
        
    }

    @Deprecated
    public static class RedeemNintendoEShopInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem items from the PlayStation Store. */
    @Deprecated
    public static class RedeemPlayStationStoreInventoryItemsRequest {
        /** Auth code returned by PlayStation :tm: Network OAuth system. */
        @Deprecated
        public String AuthorizationCode;
        /** The id of the entity's collection to perform this action on. (Default="default") */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** Redirect URI supplied to PlayStation :tm: Network when requesting an auth code. */
        @Deprecated
        public String RedirectUri;
        /** Optional Service Label to pass into the request. */
        @Deprecated
        public String ServiceLabel;
        
    }

    @Deprecated
    public static class RedeemPlayStationStoreInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    /** Redeem inventory items from Steam. */
    @Deprecated
    public static class RedeemSteamInventoryItemsRequest {
        /** The id of the entity's collection to perform this action on. (Default="default") */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class RedeemSteamInventoryItemsResponse {
        /** The list of failed redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionFailure> Failed;
        /** The list of successful redemptions from the external marketplace. */
        @Deprecated
        public ArrayList<RedemptionSuccess> Succeeded;
        /** The Transaction IDs associated with the inventory modifications */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    @Deprecated
    public static class RedemptionFailure {
        /** The marketplace failure code. */
        @Deprecated
        public String FailureCode;
        /** The marketplace error details explaining why the offer failed to redeem. */
        @Deprecated
        public String FailureDetails;
        /** The Marketplace Alternate ID being redeemed. */
        @Deprecated
        public String MarketplaceAlternateId;
        /** The transaction id in the external marketplace. */
        @Deprecated
        public String MarketplaceTransactionId;
        
    }

    @Deprecated
    public static class RedemptionSuccess {
        /** The Marketplace Alternate ID being redeemed. */
        @Deprecated
        public String MarketplaceAlternateId;
        /** The transaction id in the external marketplace. */
        @Deprecated
        public String MarketplaceTransactionId;
        /** The timestamp for when the redeem was completed. */
        @Deprecated
        public Date SuccessTimestamp;
        
    }

    @Deprecated
    public static class ReportItemRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** Category of concern for this report. */
        @Deprecated
        public ConcernCategory ConcernCategory;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        /** The string reason for this report. */
        @Deprecated
        public String Reason;
        
    }

    @Deprecated
    public static class ReportItemResponse {
        
    }

    /** Submit a report for an inappropriate review, allowing the submitting user to specify their concern. */
    @Deprecated
    public static class ReportItemReviewRequest {
        /** An alternate ID of the item associated with the review. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The reason this review is being reported. */
        @Deprecated
        public ConcernCategory ConcernCategory;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The string ID of the item associated with the review. */
        @Deprecated
        public String ItemId;
        /** The string reason for this report. */
        @Deprecated
        public String Reason;
        /** The ID of the review to submit a report for. */
        @Deprecated
        public String ReviewId;
        
    }

    @Deprecated
    public static class ReportItemReviewResponse {
        
    }

    @Deprecated
    public static class Review {
        /** The star rating associated with each selected category in this review. */
        @Deprecated
        public Map<String,Integer> CategoryRatings;
        /** The number of negative helpfulness votes for this review. */
        @Deprecated
        public Integer HelpfulNegative;
        /** The number of positive helpfulness votes for this review. */
        @Deprecated
        public Integer HelpfulPositive;
        /** Indicates whether the review author has the item installed. */
        @Deprecated
        public Boolean IsInstalled;
        /** The ID of the item being reviewed. */
        @Deprecated
        public String ItemId;
        /** The version of the item being reviewed. */
        @Deprecated
        public String ItemVersion;
        /** The locale for which this review was submitted in. */
        @Deprecated
        public String Locale;
        /** Star rating associated with this review. */
        @Deprecated
        public Integer Rating;
        /** The ID of the author of the review. */
        @Deprecated
        public EntityKey ReviewerEntity;
        /** The ID of the review. */
        @Deprecated
        public String ReviewId;
        /** The full text of this review. */
        @Deprecated
        public String ReviewText;
        /** The date and time this review was last submitted. */
        @Deprecated
        public Date Submitted;
        /** The title of this review. */
        @Deprecated
        public String Title;
        
    }

    @Deprecated
    public static class ReviewConfig {
        /** A set of categories that can be applied toward ratings and reviews. */
        @Deprecated
        public ArrayList<CategoryRatingConfig> CategoryRatings;
        
    }

    @Deprecated
    public static class ReviewItemRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        /** The review to submit. */
        @Deprecated
        public Review Review;
        
    }

    @Deprecated
    public static class ReviewItemResponse {
        
    }

    @Deprecated
    public static class ReviewTakedown {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The ID of the item associated with the review to take down. */
        @Deprecated
        public String ItemId;
        /** The ID of the review to take down. */
        @Deprecated
        public String ReviewId;
        
    }

    @Deprecated
    public static class SearchItemsRequest {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        @Deprecated
        public String ContinuationToken;
        /** Number of items to retrieve. This value is optional. Maximum page size is 50. Default value is 10. */
        @Deprecated
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * An OData filter used to refine the search query (For example: "type eq 'ugc'"). More info about Filter Complexity limits
         * can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/search#limits
         */
        @Deprecated
        public String Filter;
        /** The locale to be returned in the result. */
        @Deprecated
        public String Language;
        /** An OData orderBy used to order the results of the search query. For example: "rating/average asc" */
        @Deprecated
        public String OrderBy;
        /** The text to search for. */
        @Deprecated
        public String Search;
        /**
         * An OData select query option used to augment the search results. If not defined, the default search result metadata will
         * be returned.
         */
        @Deprecated
        public String Select;
        /** The store to restrict the search request to. */
        @Deprecated
        public StoreReference Store;
        
    }

    @Deprecated
    public static class SearchItemsResponse {
        /** An opaque token used to retrieve the next page of items, if any are available. */
        @Deprecated
        public String ContinuationToken;
        /** The paginated set of results for the search query. */
        @Deprecated
        public ArrayList<CatalogItem> Items;
        
    }

    @Deprecated
    public static class SetItemModerationStateRequest {
        /** An alternate ID associated with this item. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The unique ID of the item. */
        @Deprecated
        public String Id;
        /** The reason for the moderation state change for the associated item. */
        @Deprecated
        public String Reason;
        /** The status to set for the associated item. */
        @Deprecated
        public ModerationStatus Status;
        
    }

    @Deprecated
    public static class SetItemModerationStateResponse {
        
    }

    @Deprecated
    public static class StoreDetails {
        /** The options for the filter in filter-based stores. These options are mutually exclusive with item references. */
        @Deprecated
        public FilterOptions FilterOptions;
        /** The permissions that control which players can purchase from the store. */
        @Deprecated
        public Permissions Permissions;
        /** The global prices utilized in the store. These options are mutually exclusive with price options in item references. */
        @Deprecated
        public CatalogPriceOptionsOverride PriceOptionsOverride;
        
    }

    @Deprecated
    public static class StoreReference {
        /** An alternate ID of the store. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The unique ID of the store. */
        @Deprecated
        public String Id;
        
    }

    @Deprecated
    public static class SubmitItemReviewVoteRequest {
        /** An alternate ID of the item associated with the review. */
        @Deprecated
        public CatalogAlternateId AlternateId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The string ID of the item associated with the review. */
        @Deprecated
        public String ItemId;
        /** The ID of the review to submit a helpfulness vote for. */
        @Deprecated
        public String ReviewId;
        /** The helpfulness vote of the review. */
        @Deprecated
        public HelpfulnessVote Vote;
        
    }

    @Deprecated
    public static class SubmitItemReviewVoteResponse {
        
    }

    @Deprecated
    public static class SubtractInventoryItemsOperation {
        /** The amount to subtract from the current item amount. */
        @Deprecated
        public Integer Amount;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the request should be deleted from the inventory. (Default =
         * false).
         */
        @Deprecated
        public Boolean DeleteEmptyStacks;
        /** The duration to subtract from the current item expiration date. */
        @Deprecated
        public Double DurationInSeconds;
        /** The inventory item the operation applies to. */
        @Deprecated
        public InventoryItemReference Item;
        
    }

    /** Given an entity type, entity identifier and container details, will subtract the specified inventory items. */
    @Deprecated
    public static class SubtractInventoryItemsRequest {
        /** The amount to subtract for the current item. */
        @Deprecated
        public Integer Amount;
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the request should be deleted from the inventory.
         * (Default=false)
         */
        @Deprecated
        public Boolean DeleteEmptyStacks;
        /** The duration to subtract from the current item expiration date. */
        @Deprecated
        public Double DurationInSeconds;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        @Deprecated
        public String IdempotencyId;
        /** The inventory item the request applies to. */
        @Deprecated
        public InventoryItemReference Item;
        
    }

    @Deprecated
    public static class SubtractInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /** The idempotency id used in the request. */
        @Deprecated
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    /**
     * Submit a request to takedown one or more reviews, removing them from public view. Authors will still be able to see
     * their reviews after being taken down.
     */
    @Deprecated
    public static class TakedownItemReviewsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The set of reviews to take down. */
        @Deprecated
        public ArrayList<ReviewTakedown> Reviews;
        
    }

    @Deprecated
    public static class TakedownItemReviewsResponse {
        
    }

    @Deprecated
    public static class Transaction {
        /** The API call that caused this transaction. */
        @Deprecated
        public String ApiName;
        /** The type of item that the the operation occurred on. */
        @Deprecated
        public String ItemType;
        /** The operations that occurred. */
        @Deprecated
        public ArrayList<TransactionOperation> Operations;
        /** The type of operation that was run. */
        @Deprecated
        public String OperationType;
        /** Additional details about the transaction. Null if it was not a purchase operation. */
        @Deprecated
        public TransactionPurchaseDetails PurchaseDetails;
        /** Additional details about the transaction. Null if it was not a redeem operation. */
        @Deprecated
        public TransactionRedeemDetails RedeemDetails;
        /** The time this transaction occurred in UTC. */
        @Deprecated
        public Date Timestamp;
        /** The id of the transaction. This should be treated like an opaque token. */
        @Deprecated
        public String TransactionId;
        /** Additional details about the transaction. Null if it was not a transfer operation. */
        @Deprecated
        public TransactionTransferDetails TransferDetails;
        
    }

    @Deprecated
    public static class TransactionOperation {
        /** The amount of items in this transaction. */
        @Deprecated
        public Integer Amount;
        /** The duration modified in this transaction. */
        @Deprecated
        public Double DurationInSeconds;
        /** The friendly id of the items in this transaction. */
        @Deprecated
        public String ItemFriendlyId;
        /** The item id of the items in this transaction. */
        @Deprecated
        public String ItemId;
        /** The type of item that the operation occurred on. */
        @Deprecated
        public String ItemType;
        /** The stack id of the items in this transaction. */
        @Deprecated
        public String StackId;
        /** The type of the operation that occurred. */
        @Deprecated
        public String Type;
        
    }

    @Deprecated
    public static class TransactionPurchaseDetails {
        /** The friendly id of the Store the item was purchased from or null. */
        @Deprecated
        public String StoreFriendlyId;
        /** The id of the Store the item was purchased from or null. */
        @Deprecated
        public String StoreId;
        
    }

    @Deprecated
    public static class TransactionRedeemDetails {
        /** The marketplace that the offer is being redeemed from. */
        @Deprecated
        public String Marketplace;
        /** The transaction Id returned from the marketplace. */
        @Deprecated
        public String MarketplaceTransactionId;
        /** The offer Id of the item being redeemed. */
        @Deprecated
        public String OfferId;
        
    }

    @Deprecated
    public static class TransactionTransferDetails {
        /** The collection id the items were transferred from or null if it was the current collection. */
        @Deprecated
        public String GivingCollectionId;
        /** The entity the items were transferred from or null if it was the current entity. */
        @Deprecated
        public EntityKey GivingEntity;
        /** The collection id the items were transferred to or null if it was the current collection. */
        @Deprecated
        public String ReceivingCollectionId;
        /** The entity the items were transferred to or null if it was the current entity. */
        @Deprecated
        public EntityKey ReceivingEntity;
        /** The id of the transfer that occurred. */
        @Deprecated
        public String TransferId;
        
    }

    @Deprecated
    public static class TransferInventoryItemsOperation {
        /** The amount to transfer. */
        @Deprecated
        public Integer Amount;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the operation should be deleted from the inventory. (Default =
         * false)
         */
        @Deprecated
        public Boolean DeleteEmptyStacks;
        /** The inventory item the operation is transferring from. */
        @Deprecated
        public InventoryItemReference GivingItem;
        /** The values to apply to a stack newly created by this operation. */
        @Deprecated
        public InitialValues NewStackValues;
        /** The inventory item the operation is transferring to. */
        @Deprecated
        public InventoryItemReference ReceivingItem;
        
    }

    /** Transfer the specified inventory items of an entity's container Id to another entity's container Id. */
    @Deprecated
    public static class TransferInventoryItemsRequest {
        /** The amount to transfer . */
        @Deprecated
        public Integer Amount;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * Indicates whether stacks reduced to an amount of 0 during the request should be deleted from the inventory. (Default =
         * false)
         */
        @Deprecated
        public Boolean DeleteEmptyStacks;
        /** The inventory collection id the request is transferring from. (Default="default") */
        @Deprecated
        public String GivingCollectionId;
        /** The entity the request is transferring from. Set to the caller by default. */
        @Deprecated
        public EntityKey GivingEntity;
        /**
         * ETags are used for concurrency checking when updating resources (before transferring from). More information about using
         * ETags can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String GivingETag;
        /** The inventory item the request is transferring from. */
        @Deprecated
        public InventoryItemReference GivingItem;
        /** The idempotency id for the request. */
        @Deprecated
        public String IdempotencyId;
        /** The values to apply to a stack newly created by this request. */
        @Deprecated
        public InitialValues NewStackValues;
        /** The inventory collection id the request is transferring to. (Default="default") */
        @Deprecated
        public String ReceivingCollectionId;
        /** The entity the request is transferring to. Set to the caller by default. */
        @Deprecated
        public EntityKey ReceivingEntity;
        /** The inventory item the request is transferring to. */
        @Deprecated
        public InventoryItemReference ReceivingItem;
        
    }

    @Deprecated
    public static class TransferInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources (after transferring from). More information about using
         * ETags can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String GivingETag;
        /** The ids of transactions that occurred as a result of the request's giving action. */
        @Deprecated
        public ArrayList<String> GivingTransactionIds;
        /** The idempotency id for the request. */
        @Deprecated
        public String IdempotencyId;
        /**
         * The transfer operation status. Possible values are 'InProgress' or 'Completed'. If the operation has completed, the
         * response code will be 200. Otherwise, it will be 202.
         */
        @Deprecated
        public String OperationStatus;
        /**
         * The token that can be used to get the status of the transfer operation. This will only have a value if OperationStatus
         * is 'InProgress'.
         */
        @Deprecated
        public String OperationToken;
        /** The ids of transactions that occurred as a result of the request's receiving action. */
        @Deprecated
        public ArrayList<String> ReceivingTransactionIds;
        
    }

    @Deprecated
    public static class UpdateCatalogConfigRequest {
        /** The updated catalog configuration. */
        @Deprecated
        public CatalogConfig Config;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class UpdateCatalogConfigResponse {
        
    }

    @Deprecated
    public static class UpdateDraftItemRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Updated metadata describing the catalog item to be updated. */
        @Deprecated
        public CatalogItem Item;
        /** Whether the item should be published immediately. This value is optional, defaults to false. */
        @Deprecated
        public Boolean Publish;
        
    }

    @Deprecated
    public static class UpdateDraftItemResponse {
        /** Updated metadata describing the catalog item just updated. */
        @Deprecated
        public CatalogItem Item;
        
    }

    @Deprecated
    public static class UpdateInventoryItemsOperation {
        /** The inventory item to update with the specified values. */
        @Deprecated
        public InventoryItem Item;
        
    }

    /** Given an entity type, entity identifier and container details, will update the entity's inventory items */
    @Deprecated
    public static class UpdateInventoryItemsRequest {
        /**
         * The id of the entity's collection to perform this action on. (Default="default"). The number of inventory collections is
         * unlimited.
         */
        @Deprecated
        public String CollectionId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /**
         * The Idempotency ID for this request. Idempotency IDs can be used to prevent operation replay in the medium term but will
         * be garbage collected eventually.
         */
        @Deprecated
        public String IdempotencyId;
        /** The inventory item to update with the specified values. */
        @Deprecated
        public InventoryItem Item;
        
    }

    @Deprecated
    public static class UpdateInventoryItemsResponse {
        /**
         * ETags are used for concurrency checking when updating resources. More information about using ETags can be found here:
         * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/etags
         */
        @Deprecated
        public String ETag;
        /** The idempotency id used in the request. */
        @Deprecated
        public String IdempotencyId;
        /** The ids of transactions that occurred as a result of the request. */
        @Deprecated
        public ArrayList<String> TransactionIds;
        
    }

    @Deprecated
    public static class UploadInfo {
        /** Name of the file to be uploaded. */
        @Deprecated
        public String FileName;
        
    }

    @Deprecated
    public static class UploadUrlMetadata {
        /** Name of the file for which this upload URL was requested. */
        @Deprecated
        public String FileName;
        /** Unique ID for the binary content to be uploaded to the target URL. */
        @Deprecated
        public String Id;
        /** URL for the binary content to be uploaded to. */
        @Deprecated
        public String Url;
        
    }

    @Deprecated
    public static class UserGeneratedContentSpecificConfig {
        /** The set of content types that will be used for validation. */
        @Deprecated
        public ArrayList<String> ContentTypes;
        /** The set of tags that will be used for validation. */
        @Deprecated
        public ArrayList<String> Tags;
        
    }

}
