package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabProgressionModels {

    public static class CreateLeaderboardDefinitionRequest {
        /** Leaderboard columns describing the sort directions, cannot be changed after creation. */
        public ArrayList<LeaderboardColumn> Columns;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * The entity type being represented on the leaderboard. If it doesn't correspond to the PlayFab entity types, use
         * 'external' as the type.
         */
        public String EntityType;
        /** A name for the leaderboard, unique per title. */
        public String Name;
        /** Maximum number of entries on this leaderboard */
        public Integer SizeLimit;
        /** The version reset configuration for the leaderboard definition. */
        public VersionConfiguration VersionConfiguration;
        
    }

    public static class CreateStatisticDefinitionRequest {
        /** The columns for the statistic defining the aggregation method for each column. */
        public ArrayList<StatisticColumn> Columns;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity type allowed to have score(s) for this statistic. */
        public String EntityType;
        /** Name of the statistic. Must be less than 50 characters. Restricted to a-Z, 0-9, '(', ')', '_', '-' and '.'. */
        public String Name;
        /** The version reset configuration for the statistic definition. */
        public VersionConfiguration VersionConfiguration;
        
    }

    public static class DeleteLeaderboardDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the leaderboard definition to delete. */
        public String Name;
        
    }

    public static class DeleteLeaderboardEntriesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The unique Ids of the entries to delete from the leaderboard. */
        public ArrayList<String> EntityIds;
        /** The name of the leaderboard. */
        public String Name;
        
    }

    public static class DeleteStatisticDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Name of the statistic to delete. */
        public String Name;
        
    }

    public static class DeleteStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** Collection of statistics to remove from this entity. */
        public ArrayList<StatisticDelete> Statistics;
        
    }

    public static class DeleteStatisticsResponse {
        /** The entity id and type. */
        public EntityKey Entity;
        
    }

    public static class EmptyResponse {
        
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://docs.microsoft.com/gaming/playfab/features/data/entities/available-built-in-entity-types */
        public String Type;
        
    }

    /** Individual rank of an entity in a leaderboard */
    public static class EntityLeaderboardEntry {
        /** Entity's display name. */
        public String DisplayName;
        /** Entity identifier. */
        public EntityKey Entity;
        /** The time at which the last update to the entry was recorded on the server. */
        public Date LastUpdated;
        /** An opaque blob of data stored on the leaderboard entry. Note that the metadata is not used for ranking purposes. */
        public String Metadata;
        /** Position on the leaderboard. */
        public Integer Rank;
        /** Scores for the entry. */
        public ArrayList<String> Scores;
        
    }

    public static class EntityStatistics {
        /** Entity key */
        public EntityKey EntityKey;
        /** All statistics for the given entitykey */
        public ArrayList<EntityStatisticValue> Statistics;
        
    }

    public static class EntityStatisticValue {
        /** Metadata associated with the Statistic. */
        public String Metadata;
        /** Statistic name */
        public String Name;
        /** Statistic scores */
        public ArrayList<String> Scores;
        /** Statistic version */
        public Integer Version;
        
    }

    public static enum ExternalFriendSources {
        None,
        Steam,
        Facebook,
        Xbox,
        Psn,
        All
    }

    /** Request to load a leaderboard. */
    public static class GetEntityLeaderboardRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Name of the leaderboard. */
        public String LeaderboardName;
        /** Maximum number of results to return from the leaderboard. Minimum 1, maximum 1,000. */
        public Long PageSize;
        /** Index position to start from. 1 is beginning of leaderboard. */
        public Long StartingPosition;
        /** Optional version of the leaderboard, defaults to current version. */
        public Long Version;
        
    }

    /** Leaderboard response */
    public static class GetEntityLeaderboardResponse {
        /** Leaderboard columns describing the sort directions, */
        public ArrayList<LeaderboardColumn> Columns;
        /** Individual entity rankings in the leaderboard, in sorted order by rank. */
        public ArrayList<EntityLeaderboardEntry> Rankings;
        /** Version of the leaderboard being returned. */
        public Long Version;
        
    }

    public static class GetFriendLeaderboardForEntityRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /**
         * Indicates which other platforms' friends should be included in the response. In HTTP, it is represented as a
         * comma-separated list of platforms.
         */
        public ExternalFriendSources ExternalFriendSources;
        /** Name of the leaderboard. */
        public String LeaderboardName;
        /** Optional version of the leaderboard, defaults to current version. */
        public Long Version;
        /** Xbox token if Xbox friends should be included. Requires Xbox be configured on PlayFab. */
        public String XboxToken;
        
    }

    /** Request to load a section of a leaderboard centered on a specific entity. */
    public static class GetLeaderboardAroundEntityRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** Name of the leaderboard. */
        public String LeaderboardName;
        /**
         * Number of surrounding entries to return (in addition to specified entity). In general, the number of ranks above and
         * below will be split into half. For example, if the specified value is 10, 5 ranks above and 5 ranks below will be
         * retrieved. However, the numbers will get skewed in either direction when the specified entity is towards the top or
         * bottom of the leaderboard. Also, the number of entries returned can be lower than the value specified for entries at the
         * bottom of the leaderboard.
         */
        public Long MaxSurroundingEntries;
        /** Optional version of the leaderboard, defaults to current. */
        public Long Version;
        
    }

    public static class GetLeaderboardDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the leaderboard to retrieve the definition for. */
        public String Name;
        
    }

    public static class GetLeaderboardDefinitionResponse {
        /** Sort direction of the leaderboard columns, cannot be changed after creation. */
        public ArrayList<LeaderboardColumn> Columns;
        /** Created time, in UTC */
        public Date Created;
        /**
         * The entity type being represented on the leaderboard. If it doesn't correspond to the PlayFab entity types, use
         * 'external' as the type.
         */
        public String EntityType;
        /** Last time, in UTC, leaderboard version was incremented. */
        public Date LastResetTime;
        /** A name for the leaderboard, unique per title. */
        public String Name;
        /** Maximum number of entries on this leaderboard */
        public Integer SizeLimit;
        /** Latest Leaderboard version. */
        public Long Version;
        /** The version reset configuration for the leaderboard definition. */
        public VersionConfiguration VersionConfiguration;
        
    }

    /** Request a leaderboard limited to a collection of entities. */
    public static class GetLeaderboardForEntitiesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Collection of Entity IDs to include in the leaderboard. */
        public ArrayList<String> EntityIds;
        /** Name of the leaderboard. */
        public String LeaderboardName;
        /** Optional version of the leaderboard, defaults to current. */
        public Long Version;
        
    }

    public static class GetStatisticDefinitionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Name of the statistic. Must be less than 50 characters. */
        public String Name;
        
    }

    public static class GetStatisticDefinitionResponse {
        /** The columns for the statistic defining the aggregation method for each column. */
        public ArrayList<StatisticColumn> Columns;
        /** Created time, in UTC */
        public Date Created;
        /** The entity type that can have this statistic. */
        public String EntityType;
        /** Last time, in UTC, statistic version was incremented. */
        public Date LastResetTime;
        /** The list of leaderboards that are linked to this statistic definition. */
        public ArrayList<String> LinkedLeaderboardNames;
        /** Name of the statistic. */
        public String Name;
        /** Statistic version. */
        public Long Version;
        /** The version reset configuration for the leaderboard definition. */
        public VersionConfiguration VersionConfiguration;
        
    }

    public static class GetStatisticDefinitionsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class GetStatisticDefinitionsResponse {
        /** List of statistic definitions for the title. */
        public ArrayList<StatisticDefinition> StatisticDefinitions;
        
    }

    public static class GetStatisticsForEntitiesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Collection of Entity IDs to retrieve statistics for. */
        public ArrayList<EntityKey> Entities;
        
    }

    public static class GetStatisticsForEntitiesResponse {
        /** A mapping of statistic name to the columns defined in the corresponding definition. */
        public Map<String,StatisticColumnCollection> ColumnDetails;
        /** List of entities mapped to their statistics. Only the latest version of a statistic is returned. */
        public ArrayList<EntityStatistics> EntitiesStatistics;
        
    }

    public static class GetStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetStatisticsResponse {
        /** A mapping of statistic name to the columns defined in the corresponding definition. */
        public Map<String,StatisticColumnCollection> ColumnDetails;
        /** The entity id and type. */
        public EntityKey Entity;
        /** List of statistics keyed by Name. Only the latest version of a statistic is returned. */
        public Map<String,EntityStatisticValue> Statistics;
        
    }

    public static class IncrementLeaderboardVersionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the leaderboard to increment the version for. */
        public String Name;
        
    }

    public static class IncrementLeaderboardVersionResponse {
        /** New Leaderboard version. */
        public Long Version;
        
    }

    public static class IncrementStatisticVersionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Name of the statistic to increment the version of. */
        public String Name;
        
    }

    public static class IncrementStatisticVersionResponse {
        /** New statistic version. */
        public Long Version;
        
    }

    public static class LeaderboardColumn {
        /**
         * If the value for this column is sourced from a statistic, details of the linked column. Null if the leaderboard is not
         * linked.
         */
        public LinkedStatisticColumn LinkedStatisticColumn;
        /** A name for the leaderboard column, unique per leaderboard definition. */
        public String Name;
        /** The sort direction for this column. */
        public LeaderboardSortDirection SortDirection;
        
    }

    public static class LeaderboardDefinition {
        /** Sort direction of the leaderboard columns, cannot be changed after creation. */
        public ArrayList<LeaderboardColumn> Columns;
        /** Created time, in UTC */
        public Date Created;
        /**
         * The entity type being represented on the leaderboard. If it doesn't correspond to the PlayFab entity types, use
         * 'external' as the type.
         */
        public String EntityType;
        /** Last time, in UTC, leaderboard version was incremented. */
        public Date LastResetTime;
        /** A name for the leaderboard, unique per title. */
        public String Name;
        /** Maximum number of entries on this leaderboard */
        public Integer SizeLimit;
        /** Latest Leaderboard version. */
        public Long Version;
        /** The version reset configuration for the leaderboard definition. */
        public VersionConfiguration VersionConfiguration;
        
    }

    public static class LeaderboardEntryUpdate {
        /** The unique Id for the entry. If using PlayFab Entities, this would be the entityId of the entity. */
        public String EntityId;
        /**
         * Arbitrary metadata to store along side the leaderboard entry, will be returned by all Leaderboard APIs. Must be less
         * than 50 UTF8 encoded characters.
         */
        public String Metadata;
        /**
         * The scores for the leaderboard. The number of values provided here must match the number of columns in the Leaderboard
         * definition.
         */
        public ArrayList<String> Scores;
        
    }

    public static enum LeaderboardSortDirection {
        Descending,
        Ascending
    }

    public static class LinkedStatisticColumn {
        /** The name of the statistic column that this leaderboard column is sourced from. */
        public String LinkedStatisticColumnName;
        /** The name of the statistic. */
        public String LinkedStatisticName;
        
    }

    public static class ListLeaderboardDefinitionsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class ListLeaderboardDefinitionsResponse {
        /** List of leaderboard definitions for the title. */
        public ArrayList<LeaderboardDefinition> LeaderboardDefinitions;
        
    }

    public static class ListStatisticDefinitionsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class ListStatisticDefinitionsResponse {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** List of statistic definitions for the title. */
        public ArrayList<StatisticDefinition> StatisticDefinitions;
        
    }

    public static enum ResetInterval {
        Manual,
        Hour,
        Day,
        Week,
        Month
    }

    public static enum StatisticAggregationMethod {
        Last,
        Min,
        Max,
        Sum
    }

    public static class StatisticColumn {
        /** Aggregation method for calculating new value of a statistic. */
        public StatisticAggregationMethod AggregationMethod;
        /** Name of the statistic column, as originally configured. */
        public String Name;
        
    }

    public static class StatisticColumnCollection {
        /** Columns for the statistic defining the aggregation method for each column. */
        public ArrayList<StatisticColumn> Columns;
        
    }

    public static class StatisticDefinition {
        /** The columns for the statistic defining the aggregation method for each column. */
        public ArrayList<StatisticColumn> Columns;
        /** Created time, in UTC */
        public Date Created;
        /** The entity type that can have this statistic. */
        public String EntityType;
        /** Last time, in UTC, statistic version was incremented. */
        public Date LastResetTime;
        /** The list of leaderboards that are linked to this statistic definition. */
        public ArrayList<String> LinkedLeaderboardNames;
        /** Name of the statistic. */
        public String Name;
        /** Statistic version. */
        public Long Version;
        /** The version reset configuration for the leaderboard definition. */
        public VersionConfiguration VersionConfiguration;
        
    }

    public static class StatisticDelete {
        /** Name of the statistic, as originally configured. */
        public String Name;
        
    }

    public static class StatisticUpdate {
        /**
         * Arbitrary metadata to store along side the statistic, will be returned by all Leaderboard APIs. Must be less than 50
         * UTF8 encoded characters.
         */
        public String Metadata;
        /** Name of the statistic, as originally configured. */
        public String Name;
        /**
         * Statistic scores for the entity. This will be used in accordance with the aggregation method configured for the
         * statistics.The maximum value allowed for each individual score is 9223372036854775807. The minimum value for each
         * individual score is -9223372036854775807The values are formatted as strings to avoid interop issues with client
         * libraries unable to handle 64bit integers.
         */
        public ArrayList<String> Scores;
        /** Optional field to indicate the version of the statistic to set. When empty defaults to the statistic's current version. */
        public Long Version;
        
    }

    public static class UnlinkLeaderboardFromStatisticRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the leaderboard definition to unlink. */
        public String Name;
        /** The name of the statistic definition to unlink. */
        public String StatisticName;
        
    }

    public static class UpdateLeaderboardEntriesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entries to add or update on the leaderboard. */
        public ArrayList<LeaderboardEntryUpdate> Entries;
        /** The name of the leaderboard. */
        public String LeaderboardName;
        
    }

    public static class UpdateStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        /** Collection of statistics to update, maximum 50. */
        public ArrayList<StatisticUpdate> Statistics;
        
    }

    public static class UpdateStatisticsResponse {
        /** A mapping of statistic name to the columns defined in the corresponding definition. */
        public Map<String,StatisticColumnCollection> ColumnDetails;
        /** The entity id and type. */
        public EntityKey Entity;
        /** Updated entity profile statistics. */
        public Map<String,EntityStatisticValue> Statistics;
        
    }

    public static class VersionConfiguration {
        /** The maximum number of versions of this leaderboard/statistic that can be queried. */
        public Integer MaxQueryableVersions;
        /**
         * Reset interval that statistics or leaderboards will reset on. When using Manual intervalthe reset can only be increased
         * by calling the Increase version API. When using Hour interval the resetwill occur at the start of the next hour UTC
         * time. When using Day interval the reset will occur at thestart of the next day in UTC time. When using the Week interval
         * the reset will occur at the start ofthe next Monday in UTC time. When using Month interval the reset will occur at the
         * start of the nextmonth in UTC time.
         */
        public ResetInterval ResetInterval;
        
    }

}
