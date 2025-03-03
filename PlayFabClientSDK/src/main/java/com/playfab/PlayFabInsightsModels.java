package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabInsightsModels {

    public static class InsightsEmptyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class InsightsGetDetailsResponse {
        /** Amount of data (in MB) currently used by Insights. */
        public Long DataUsageMb;
        /** Details of any error that occurred while retrieving Insights details. */
        public String ErrorMessage;
        /** Allowed range of values for performance level and data storage retention. */
        public InsightsGetLimitsResponse Limits;
        /** List of pending Insights operations for the title. */
        public ArrayList<InsightsGetOperationStatusResponse> PendingOperations;
        /** Current Insights performance level setting. */
        public Integer PerformanceLevel;
        /** Current Insights data storage retention value in days. */
        public Integer RetentionDays;
        
    }

    public static class InsightsGetLimitsResponse {
        /** Default Insights performance level. */
        public Integer DefaultPerformanceLevel;
        /** Default Insights data storage retention days. */
        public Integer DefaultStorageRetentionDays;
        /** Maximum allowed data storage retention days. */
        public Integer StorageMaxRetentionDays;
        /** Minimum allowed data storage retention days. */
        public Integer StorageMinRetentionDays;
        /** List of Insights submeter limits for the allowed performance levels. */
        public ArrayList<InsightsPerformanceLevel> SubMeters;
        
    }

    /** Returns the current status for the requested operation id. */
    public static class InsightsGetOperationStatusRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Id of the Insights operation. */
        public String OperationId;
        
    }

    public static class InsightsGetOperationStatusResponse {
        /** Optional message related to the operation details. */
        public String Message;
        /** Time the operation was completed. */
        public Date OperationCompletedTime;
        /** Id of the Insights operation. */
        public String OperationId;
        /** Time the operation status was last updated. */
        public Date OperationLastUpdated;
        /** Time the operation started. */
        public Date OperationStartedTime;
        /** The type of operation, SetPerformance or SetStorageRetention. */
        public String OperationType;
        /** The value requested for the operation. */
        public Integer OperationValue;
        /** Current status of the operation. */
        public String Status;
        
    }

    /** Returns a list of operations that are in the pending state for the requested operation type. */
    public static class InsightsGetPendingOperationsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The type of pending operations requested, or blank for all operation types. */
        public String OperationType;
        
    }

    public static class InsightsGetPendingOperationsResponse {
        /** List of pending Insights operations. */
        public ArrayList<InsightsGetOperationStatusResponse> PendingOperations;
        
    }

    public static class InsightsOperationResponse {
        /** Optional message related to the operation details. */
        public String Message;
        /** Id of the Insights operation. */
        public String OperationId;
        /** The type of operation, SetPerformance or SetStorageRetention. */
        public String OperationType;
        
    }

    public static class InsightsPerformanceLevel {
        /** Number of allowed active event exports. */
        public Integer ActiveEventExports;
        /** Maximum cache size. */
        public Integer CacheSizeMB;
        /** Maximum number of concurrent queries. */
        public Integer Concurrency;
        /** Number of Insights credits consumed per minute. */
        public Double CreditsPerMinute;
        /** Maximum events per second. */
        public Integer EventsPerSecond;
        /** Performance level. */
        public Integer Level;
        /** Maximum amount of memory allowed per query. */
        public Integer MaxMemoryPerQueryMB;
        /** Amount of compute power allocated for queries and operations. */
        public Integer VirtualCpuCores;
        
    }

    /** Sets the performance level to the requested value. Use the GetLimits method to get the allowed values. */
    public static class InsightsSetPerformanceRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The Insights performance level to apply to the title. */
        public Integer PerformanceLevel;
        
    }

    /** Sets the data storage retention to the requested value. Use the GetLimits method to get the range of allowed values. */
    public static class InsightsSetStorageRetentionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The Insights data storage retention value (in days) to apply to the title. */
        public Integer RetentionDays;
        
    }

}
