package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabProgressionModels {

    @Deprecated
    public static class CreateLeaderboardDefinitionRequest {
        /** Leaderboard columns describing the sort directions, cannot be changed after creation. */
        @Deprecated
        public ArrayList<LeaderboardColumn> Columns;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /**
         * The entity type being represented on the leaderboard. If it doesn't correspond to the PlayFab entity types, use
         * 'external' as the type.
         */
        @Deprecated
        public String EntityType;
        /** A name for the leaderboard, unique per title. */
        @Deprecated
        public String Name;
        /** Maximum number of entries on this leaderboard */
        @Deprecated
        public Integer SizeLimit;
        /** The version reset configuration for the leaderboard definition. */
        @Deprecated
        public VersionConfiguration VersionConfiguration;
        
    }

    @Deprecated
    public static class CreateStatisticDefinitionRequest {
        /** The columns for the statistic defining the aggregation method for each column. */
        @Deprecated
        public ArrayList<StatisticColumn> Columns;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity type allowed to have score(s) for this statistic. */
        @Deprecated
        public String EntityType;
        /** Name of the statistic. Must be less than 150 characters. Restricted to a-Z, 0-9, '(', ')', '_', '-' and '.'. */
        @Deprecated
        public String Name;
        /** The version reset configuration for the statistic definition. */
        @Deprecated
        public VersionConfiguration VersionConfiguration;
        
    }

    @Deprecated
    public static class DeleteLeaderboardDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the leaderboard definition to delete. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class DeleteLeaderboardEntriesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The unique Ids of the entries to delete from the leaderboard. */
        @Deprecated
        public ArrayList<String> EntityIds;
        /** The name of the leaderboard. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class DeleteStatisticDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Name of the statistic to delete. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class DeleteStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** Collection of statistics to remove from this entity. */
        @Deprecated
        public ArrayList<StatisticDelete> Statistics;
        
    }

    @Deprecated
    public static class DeleteStatisticsResponse {
        /** The entity id and type. */
        @Deprecated
        public EntityKey Entity;
        
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

    /** Individual rank of an entity in a leaderboard */
    @Deprecated
    public static class EntityLeaderboardEntry {
        /** Entity's display name. */
        @Deprecated
        public String DisplayName;
        /** Entity identifier. */
        @Deprecated
        public EntityKey Entity;
        /** The time at which the last update to the entry was recorded on the server. */
        @Deprecated
        public Date LastUpdated;
        /** An opaque blob of data stored on the leaderboard entry. Note that the metadata is not used for ranking purposes. */
        @Deprecated
        public String Metadata;
        /** Position on the leaderboard. */
        @Deprecated
        public Integer Rank;
        /** Scores for the entry. */
        @Deprecated
        public ArrayList<String> Scores;
        
    }

    @Deprecated
    public static class EntityStatistics {
        /** Entity key */
        @Deprecated
        public EntityKey EntityKey;
        /** All statistics for the given entitykey */
        @Deprecated
        public ArrayList<EntityStatisticValue> Statistics;
        
    }

    @Deprecated
    public static class EntityStatisticValue {
        /** Metadata associated with the Statistic. */
        @Deprecated
        public String Metadata;
        /** Statistic name */
        @Deprecated
        public String Name;
        /** Statistic scores */
        @Deprecated
        public ArrayList<String> Scores;
        /** Statistic version */
        @Deprecated
        public Integer Version;
        
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

    /** Request to load a leaderboard. */
    @Deprecated
    public static class GetEntityLeaderboardRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Name of the leaderboard. */
        @Deprecated
        public String LeaderboardName;
        /** Maximum number of results to return from the leaderboard. Minimum 1, maximum 1,000. */
        @Deprecated
        public Long PageSize;
        /** Index position to start from. 1 is beginning of leaderboard. */
        @Deprecated
        public Long StartingPosition;
        /** Optional version of the leaderboard, defaults to current version. */
        @Deprecated
        public Long Version;
        
    }

    /** Leaderboard response */
    @Deprecated
    public static class GetEntityLeaderboardResponse {
        /** Leaderboard columns describing the sort directions. */
        @Deprecated
        public ArrayList<LeaderboardColumn> Columns;
        /** The number of entries on the leaderboard. */
        @Deprecated
        public Long EntryCount;
        /** The time the next scheduled reset will occur. Null if the leaderboard does not reset on a schedule. */
        @Deprecated
        public Date NextReset;
        /** Individual entity rankings in the leaderboard, in sorted order by rank. */
        @Deprecated
        public ArrayList<EntityLeaderboardEntry> Rankings;
        /** Version of the leaderboard being returned. */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class GetFriendLeaderboardForEntityRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /**
         * Indicates which other platforms' friends should be included in the response. In HTTP, it is represented as a
         * comma-separated list of platforms.
         */
        @Deprecated
        public ExternalFriendSources ExternalFriendSources;
        /** Name of the leaderboard. */
        @Deprecated
        public String LeaderboardName;
        /** Optional version of the leaderboard, defaults to current version. */
        @Deprecated
        public Long Version;
        /** Xbox token if Xbox friends should be included. Requires Xbox be configured on PlayFab. */
        @Deprecated
        public String XboxToken;
        
    }

    /** Request to load a section of a leaderboard centered on a specific entity. */
    @Deprecated
    public static class GetLeaderboardAroundEntityRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** Name of the leaderboard. */
        @Deprecated
        public String LeaderboardName;
        /**
         * Number of surrounding entries to return (in addition to specified entity). In general, the number of ranks above and
         * below will be split into half. For example, if the specified value is 10, 5 ranks above and 5 ranks below will be
         * retrieved. However, the numbers will get skewed in either direction when the specified entity is towards the top or
         * bottom of the leaderboard. Also, the number of entries returned can be lower than the value specified for entries at the
         * bottom of the leaderboard.
         */
        @Deprecated
        public Long MaxSurroundingEntries;
        /** Optional version of the leaderboard, defaults to current. */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class GetLeaderboardDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the leaderboard to retrieve the definition for. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class GetLeaderboardDefinitionResponse {
        /** Sort direction of the leaderboard columns, cannot be changed after creation. */
        @Deprecated
        public ArrayList<LeaderboardColumn> Columns;
        /** Created time, in UTC */
        @Deprecated
        public Date Created;
        /**
         * The entity type being represented on the leaderboard. If it doesn't correspond to the PlayFab entity types, use
         * 'external' as the type.
         */
        @Deprecated
        public String EntityType;
        /** Last time, in UTC, leaderboard version was incremented. */
        @Deprecated
        public Date LastResetTime;
        /** A name for the leaderboard, unique per title. */
        @Deprecated
        public String Name;
        /** Maximum number of entries on this leaderboard */
        @Deprecated
        public Integer SizeLimit;
        /** Latest Leaderboard version. */
        @Deprecated
        public Long Version;
        /** The version reset configuration for the leaderboard definition. */
        @Deprecated
        public VersionConfiguration VersionConfiguration;
        
    }

    /** Request a leaderboard limited to a collection of entities. */
    @Deprecated
    public static class GetLeaderboardForEntitiesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Collection of Entity IDs to include in the leaderboard. */
        @Deprecated
        public ArrayList<String> EntityIds;
        /** Name of the leaderboard. */
        @Deprecated
        public String LeaderboardName;
        /** Optional version of the leaderboard, defaults to current. */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class GetStatisticDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Name of the statistic. Must be less than 150 characters. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class GetStatisticDefinitionResponse {
        /** The columns for the statistic defining the aggregation method for each column. */
        @Deprecated
        public ArrayList<StatisticColumn> Columns;
        /** Created time, in UTC */
        @Deprecated
        public Date Created;
        /** The entity type that can have this statistic. */
        @Deprecated
        public String EntityType;
        /** Last time, in UTC, statistic version was incremented. */
        @Deprecated
        public Date LastResetTime;
        /** The list of leaderboards that are linked to this statistic definition. */
        @Deprecated
        public ArrayList<String> LinkedLeaderboardNames;
        /** Name of the statistic. */
        @Deprecated
        public String Name;
        /** Statistic version. */
        @Deprecated
        public Long Version;
        /** The version reset configuration for the leaderboard definition. */
        @Deprecated
        public VersionConfiguration VersionConfiguration;
        
    }

    @Deprecated
    public static class GetStatisticsForEntitiesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Collection of Entity IDs to retrieve statistics for. */
        @Deprecated
        public ArrayList<EntityKey> Entities;
        
    }

    @Deprecated
    public static class GetStatisticsForEntitiesResponse {
        /** A mapping of statistic name to the columns defined in the corresponding definition. */
        @Deprecated
        public Map<String,StatisticColumnCollection> ColumnDetails;
        /** List of entities mapped to their statistics. Only the latest version of a statistic is returned. */
        @Deprecated
        public ArrayList<EntityStatistics> EntitiesStatistics;
        
    }

    @Deprecated
    public static class GetStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetStatisticsResponse {
        /** A mapping of statistic name to the columns defined in the corresponding definition. */
        @Deprecated
        public Map<String,StatisticColumnCollection> ColumnDetails;
        /** The entity id and type. */
        @Deprecated
        public EntityKey Entity;
        /** List of statistics keyed by Name. Only the latest version of a statistic is returned. */
        @Deprecated
        public Map<String,EntityStatisticValue> Statistics;
        
    }

    @Deprecated
    public static class IncrementLeaderboardVersionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the leaderboard to increment the version for. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class IncrementLeaderboardVersionResponse {
        /** New Leaderboard version. */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class IncrementStatisticVersionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Name of the statistic to increment the version of. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class IncrementStatisticVersionResponse {
        /** New statistic version. */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class LeaderboardColumn {
        /**
         * If the value for this column is sourced from a statistic, details of the linked column. Null if the leaderboard is not
         * linked.
         */
        @Deprecated
        public LinkedStatisticColumn LinkedStatisticColumn;
        /** A name for the leaderboard column, unique per leaderboard definition. */
        @Deprecated
        public String Name;
        /** The sort direction for this column. */
        @Deprecated
        public LeaderboardSortDirection SortDirection;
        
    }

    @Deprecated
    public static class LeaderboardDefinition {
        /** Sort direction of the leaderboard columns, cannot be changed after creation. */
        @Deprecated
        public ArrayList<LeaderboardColumn> Columns;
        /** Created time, in UTC */
        @Deprecated
        public Date Created;
        /**
         * The entity type being represented on the leaderboard. If it doesn't correspond to the PlayFab entity types, use
         * 'external' as the type.
         */
        @Deprecated
        public String EntityType;
        /** Last time, in UTC, leaderboard version was incremented. */
        @Deprecated
        public Date LastResetTime;
        /** A name for the leaderboard, unique per title. */
        @Deprecated
        public String Name;
        /** Maximum number of entries on this leaderboard */
        @Deprecated
        public Integer SizeLimit;
        /** Latest Leaderboard version. */
        @Deprecated
        public Long Version;
        /** The version reset configuration for the leaderboard definition. */
        @Deprecated
        public VersionConfiguration VersionConfiguration;
        
    }

    @Deprecated
    public static class LeaderboardEntryUpdate {
        /** The unique Id for the entry. If using PlayFab Entities, this would be the entityId of the entity. */
        @Deprecated
        public String EntityId;
        /**
         * Arbitrary metadata to store along side the leaderboard entry, will be returned by all Leaderboard APIs. Must be less
         * than 50 UTF8 encoded characters.
         */
        @Deprecated
        public String Metadata;
        /**
         * The scores for the leaderboard. The number of values provided here must match the number of columns in the Leaderboard
         * definition.
         */
        @Deprecated
        public ArrayList<String> Scores;
        
    }

    @Deprecated
    public static enum LeaderboardSortDirection {
        Descending,
        Ascending
    }

    @Deprecated
    public static class LinkedStatisticColumn {
        /** The name of the statistic column that this leaderboard column is sourced from. */
        @Deprecated
        public String LinkedStatisticColumnName;
        /** The name of the statistic. */
        @Deprecated
        public String LinkedStatisticName;
        
    }

    @Deprecated
    public static class ListLeaderboardDefinitionsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class ListLeaderboardDefinitionsResponse {
        /** List of leaderboard definitions for the title. */
        @Deprecated
        public ArrayList<LeaderboardDefinition> LeaderboardDefinitions;
        
    }

    @Deprecated
    public static class ListStatisticDefinitionsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class ListStatisticDefinitionsResponse {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** List of statistic definitions for the title. */
        @Deprecated
        public ArrayList<StatisticDefinition> StatisticDefinitions;
        
    }

    @Deprecated
    public static enum ResetInterval {
        Manual,
        Hour,
        Day,
        Week,
        Month
    }

    @Deprecated
    public static enum StatisticAggregationMethod {
        Last,
        Min,
        Max,
        Sum
    }

    @Deprecated
    public static class StatisticColumn {
        /** Aggregation method for calculating new value of a statistic. */
        @Deprecated
        public StatisticAggregationMethod AggregationMethod;
        /** Name of the statistic column, as originally configured. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class StatisticColumnCollection {
        /** Columns for the statistic defining the aggregation method for each column. */
        @Deprecated
        public ArrayList<StatisticColumn> Columns;
        
    }

    @Deprecated
    public static class StatisticDefinition {
        /** The columns for the statistic defining the aggregation method for each column. */
        @Deprecated
        public ArrayList<StatisticColumn> Columns;
        /** Created time, in UTC */
        @Deprecated
        public Date Created;
        /** The entity type that can have this statistic. */
        @Deprecated
        public String EntityType;
        /** Last time, in UTC, statistic version was incremented. */
        @Deprecated
        public Date LastResetTime;
        /** The list of leaderboards that are linked to this statistic definition. */
        @Deprecated
        public ArrayList<String> LinkedLeaderboardNames;
        /** Name of the statistic. */
        @Deprecated
        public String Name;
        /** Statistic version. */
        @Deprecated
        public Long Version;
        /** The version reset configuration for the leaderboard definition. */
        @Deprecated
        public VersionConfiguration VersionConfiguration;
        
    }

    @Deprecated
    public static class StatisticDelete {
        /** Name of the statistic, as originally configured. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class StatisticUpdate {
        /**
         * Arbitrary metadata to store along side the statistic, will be returned by all Leaderboard APIs. Must be less than 50
         * UTF8 encoded characters.
         */
        @Deprecated
        public String Metadata;
        /** Name of the statistic, as originally configured. */
        @Deprecated
        public String Name;
        /**
         * Statistic scores for the entity. This will be used in accordance with the aggregation method configured for the
         * statistics.The maximum value allowed for each individual score is 9223372036854775807. The minimum value for each
         * individual score is -9223372036854775807The values are formatted as strings to avoid interop issues with client
         * libraries unable to handle 64bit integers.
         */
        @Deprecated
        public ArrayList<String> Scores;
        /** Optional field to indicate the version of the statistic to set. When empty defaults to the statistic's current version. */
        @Deprecated
        public Long Version;
        
    }

    @Deprecated
    public static class UnlinkLeaderboardFromStatisticRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the leaderboard definition to unlink. */
        @Deprecated
        public String Name;
        /** The name of the statistic definition to unlink. */
        @Deprecated
        public String StatisticName;
        
    }

    @Deprecated
    public static class UpdateLeaderboardDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the leaderboard to update the definition for. */
        @Deprecated
        public String Name;
        /** Maximum number of entries on this leaderboard */
        @Deprecated
        public Integer SizeLimit;
        /** The version reset configuration for the leaderboard definition. */
        @Deprecated
        public VersionConfiguration VersionConfiguration;
        
    }

    @Deprecated
    public static class UpdateLeaderboardEntriesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entries to add or update on the leaderboard. */
        @Deprecated
        public ArrayList<LeaderboardEntryUpdate> Entries;
        /** The name of the leaderboard. */
        @Deprecated
        public String LeaderboardName;
        
    }

    @Deprecated
    public static class UpdateStatisticDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Name of the statistic. Must be less than 150 characters. Restricted to a-Z, 0-9, '(', ')', '_', '-' and '.'. */
        @Deprecated
        public String Name;
        /** The version reset configuration for the statistic definition. */
        @Deprecated
        public VersionConfiguration VersionConfiguration;
        
    }

    @Deprecated
    public static class UpdateStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** Collection of statistics to update, maximum 50. */
        @Deprecated
        public ArrayList<StatisticUpdate> Statistics;
        /**
         * Optional transactionId of this update which can be used to ensure idempotence. Using this field is still in testing
         * stage.
         */
        @Deprecated
        public String TransactionId;
        
    }

    @Deprecated
    public static class UpdateStatisticsResponse {
        /** A mapping of statistic name to the columns defined in the corresponding definition. */
        @Deprecated
        public Map<String,StatisticColumnCollection> ColumnDetails;
        /** The entity id and type. */
        @Deprecated
        public EntityKey Entity;
        /** Updated entity profile statistics. */
        @Deprecated
        public Map<String,EntityStatisticValue> Statistics;
        
    }

    @Deprecated
    public static class VersionConfiguration {
        /** The maximum number of versions of this leaderboard/statistic that can be queried. */
        @Deprecated
        public Integer MaxQueryableVersions;
        /**
         * Reset interval that statistics or leaderboards will reset on. When using Manual intervalthe reset can only be increased
         * by calling the Increase version API. When using Hour interval the resetwill occur at the start of the next hour UTC
         * time. When using Day interval the reset will occur at thestart of the next day in UTC time. When using the Week interval
         * the reset will occur at the start ofthe next Monday in UTC time. When using Month interval the reset will occur at the
         * start of the nextmonth in UTC time.
         */
        @Deprecated
        public ResetInterval ResetInterval;
        
    }

}
