package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabInsightsModels {

    @Deprecated
    public static class InsightsEmptyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class InsightsGetDetailsResponse {
        /** Amount of data (in MB) currently used by Insights. */
        @Deprecated
        public Long DataUsageMb;
        /** Details of any error that occurred while retrieving Insights details. */
        @Deprecated
        public String ErrorMessage;
        /** Allowed range of values for performance level and data storage retention. */
        @Deprecated
        public InsightsGetLimitsResponse Limits;
        /** List of pending Insights operations for the title. */
        @Deprecated
        public ArrayList<InsightsGetOperationStatusResponse> PendingOperations;
        /** Current Insights performance level setting. */
        @Deprecated
        public Integer PerformanceLevel;
        /** Current Insights data storage retention value in days. */
        @Deprecated
        public Integer RetentionDays;
        
    }

    @Deprecated
    public static class InsightsGetLimitsResponse {
        /** Default Insights performance level. */
        @Deprecated
        public Integer DefaultPerformanceLevel;
        /** Default Insights data storage retention days. */
        @Deprecated
        public Integer DefaultStorageRetentionDays;
        /** Maximum allowed data storage retention days. */
        @Deprecated
        public Integer StorageMaxRetentionDays;
        /** Minimum allowed data storage retention days. */
        @Deprecated
        public Integer StorageMinRetentionDays;
        /** List of Insights submeter limits for the allowed performance levels. */
        @Deprecated
        public ArrayList<InsightsPerformanceLevel> SubMeters;
        
    }

    /** Returns the current status for the requested operation id. */
    @Deprecated
    public static class InsightsGetOperationStatusRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Id of the Insights operation. */
        @Deprecated
        public String OperationId;
        
    }

    @Deprecated
    public static class InsightsGetOperationStatusResponse {
        /** Optional message related to the operation details. */
        @Deprecated
        public String Message;
        /** Time the operation was completed. */
        @Deprecated
        public Date OperationCompletedTime;
        /** Id of the Insights operation. */
        @Deprecated
        public String OperationId;
        /** Time the operation status was last updated. */
        @Deprecated
        public Date OperationLastUpdated;
        /** Time the operation started. */
        @Deprecated
        public Date OperationStartedTime;
        /** The type of operation, SetPerformance or SetStorageRetention. */
        @Deprecated
        public String OperationType;
        /** The value requested for the operation. */
        @Deprecated
        public Integer OperationValue;
        /** Current status of the operation. */
        @Deprecated
        public String Status;
        
    }

    /** Returns a list of operations that are in the pending state for the requested operation type. */
    @Deprecated
    public static class InsightsGetPendingOperationsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The type of pending operations requested, or blank for all operation types. */
        @Deprecated
        public String OperationType;
        
    }

    @Deprecated
    public static class InsightsGetPendingOperationsResponse {
        /** List of pending Insights operations. */
        @Deprecated
        public ArrayList<InsightsGetOperationStatusResponse> PendingOperations;
        
    }

    @Deprecated
    public static class InsightsOperationResponse {
        /** Optional message related to the operation details. */
        @Deprecated
        public String Message;
        /** Id of the Insights operation. */
        @Deprecated
        public String OperationId;
        /** The type of operation, SetPerformance or SetStorageRetention. */
        @Deprecated
        public String OperationType;
        
    }

    @Deprecated
    public static class InsightsPerformanceLevel {
        /** Number of allowed active event exports. */
        @Deprecated
        public Integer ActiveEventExports;
        /** Maximum cache size. */
        @Deprecated
        public Integer CacheSizeMB;
        /** Maximum number of concurrent queries. */
        @Deprecated
        public Integer Concurrency;
        /** Number of Insights credits consumed per minute. */
        @Deprecated
        public Double CreditsPerMinute;
        /** Maximum events per second. */
        @Deprecated
        public Integer EventsPerSecond;
        /** Performance level. */
        @Deprecated
        public Integer Level;
        /** Maximum amount of memory allowed per query. */
        @Deprecated
        public Integer MaxMemoryPerQueryMB;
        /** Amount of compute power allocated for queries and operations. */
        @Deprecated
        public Integer VirtualCpuCores;
        
    }

    /** Sets the performance level to the requested value. Use the GetLimits method to get the allowed values. */
    @Deprecated
    public static class InsightsSetPerformanceRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The Insights performance level to apply to the title. */
        @Deprecated
        public Integer PerformanceLevel;
        
    }

    /** Sets the data storage retention to the requested value. Use the GetLimits method to get the range of allowed values. */
    @Deprecated
    public static class InsightsSetStorageRetentionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The Insights data storage retention value (in days) to apply to the title. */
        @Deprecated
        public Integer RetentionDays;
        
    }

}
