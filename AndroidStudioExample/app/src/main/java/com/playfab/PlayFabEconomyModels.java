package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabEconomyModels {

    public static class CatalogAlternateId {
        /** Type of the alternate ID. */
        public String Type;
        /** Value of the alternate ID. */
        public String Value;
        
    }

    public static class CatalogConfig {
        /** A list of player entity keys that will have admin permissions. */
        public ArrayList<EntityKey> AdminEntities;
        /** A list of display properties to index. */
        public ArrayList<DisplayPropertyIndexInfo> DisplayPropertyIndexInfos;
        /** Flag defining whether catalog is enabled. */
        public Boolean IsCatalogEnabled;
        /** A set of player entity keys that are allowed to review content. */
        public ArrayList<EntityKey> ReviewerEntities;
        /** The set of configuration that only applies to user generated contents. */
        public UserGeneratedContentSpecificConfig UserGeneratedContent;
        
    }

    public static class CatalogItem {
        /** The alternate IDs associated with this item. */
        public ArrayList<CatalogAlternateId> AlternateIds;
        /** The set of contents associated with this item. */
        public ArrayList<Content> Contents;
        /** The client-defined type of the item. */
        public String ContentType;
        /** The date and time when this item was created. */
        public Date CreationDate;
        /** The ID of the creator of this catalog item. */
        public EntityKey CreatorEntity;
        /**
         * A dictionary of localized descriptions. Key is language code and localized string is the value. The neutral locale is
         * required.
         */
        public Map<String,String> Description;
        /** Game specific properties for display purposes. This is an arbitrary JSON blob. */
        public Object DisplayProperties;
        /** The user provided version of the item for display purposes. */
        public String DisplayVersion;
        /** The date of when the item will cease to be available. If not provided then the product will be available indefinitely. */
        public Date EndDate;
        /** The current ETag value that can be used for optimistic concurrency in the If-None-Match header. */
        public String ETag;
        /** The unique ID of the item. */
        public String Id;
        /** The images associated with this item. Images can be thumbnails or screenshots. */
        public ArrayList<Image> Images;
        /** Indicates if the item is hidden. */
        public Boolean IsHidden;
        /** A dictionary of localized keywords. Key is language code and localized list of keywords is the value. */
        public Map<String,KeywordSet> Keywords;
        /** The date and time this item was last updated. */
        public Date LastModifiedDate;
        /** The moderation state for this item. */
        public ModerationState Moderation;
        /** Rating summary for this item. */
        public Rating Rating;
        /** The date of when the item will be available. If not provided then the product will appear immediately. */
        public Date StartDate;
        /** The list of tags that are associated with this item. */
        public ArrayList<String> Tags;
        /**
         * A dictionary of localized titles. Key is language code and localized string is the value. The neutral locale is
         * required.
         */
        public Map<String,String> Title;
        /** The high-level type of the item. */
        public String Type;
        
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
        /** The maximum client version that this content is compatible with. */
        public String MaxClientVersion;
        /** The minimum client version that this content is compatible with. */
        public String MinClientVersion;
        /** The Azure CDN URL for retrieval of the catalog item binary content. */
        public String Url;
        
    }

    /** The item will not be published to the public catalog until the PublishItem API is called for the item. */
    public static class CreateDraftItemRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Metadata describing the new catalog item to be created. */
        public CatalogItem Item;
        /** Whether the item should be published immediately. */
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

    public static class DeleteEntityItemReviewsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
    }

    public static class DeleteEntityItemReviewsResponse {
        
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
        /** Number of items to retrieve. Maximum page size is 10. */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        
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
        /** Scan results for any items that failed content scans. */
        public ArrayList<ScanResult> FailedScanResults;
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
        /** Number of items to retrieve. Maximum page size is 200. If not specified, defaults to 10. */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The unique ID of the item. */
        public String Id;
        /** An OData orderBy used to order the results of the query. */
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

    public static enum HelpfulnessVote {
        None,
        UnHelpful,
        Helpful
    }

    public static class Image {
        /** The image unique ID. */
        public String Id;
        /** The client-defined type of this image. */
        public String Type;
        /** The URL for retrieval of the image. */
        public String Url;
        
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
        /** The number of negative helpfulness votes for this review. */
        public Integer HelpfulNegative;
        /** Total number of helpfulness votes for this review. */
        public Integer HelpfulnessVotes;
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
        /** Number of items to retrieve. Maximum page size is 225. Default value is 10. */
        public Integer Count;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** An OData filter used to refine the search query. */
        public String Filter;
        /** An OData orderBy used to order the results of the search query. */
        public String OrderBy;
        /** The text to search for. */
        public String Search;
        /**
         * An OData select query option used to augment the search results. If not defined, the default search result metadata will
         * be returned.
         */
        public String Select;
        
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
        /** Whether the item should be published immediately. */
        public Boolean Publish;
        
    }

    public static class UpdateDraftItemResponse {
        /** Updated metadata describing the catalog item just updated. */
        public CatalogItem Item;
        
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
        /** The set of content types that will be used for validation and if no values are provided then anything is allowed. */
        public ArrayList<String> ContentTypes;
        /** The set of tags that will be used for validation and if no values are provided then anything is allowed. */
        public ArrayList<String> Tags;
        
    }

}
