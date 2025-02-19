package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabExperimentationModels {

    @Deprecated
    public static enum AnalysisTaskState {
        Waiting,
        ReadyForSubmission,
        SubmittingToPipeline,
        Running,
        Completed,
        Failed,
        Canceled
    }

    /** Given a title entity token and exclusion group details, will create a new exclusion group for the title. */
    @Deprecated
    public static class CreateExclusionGroupRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Description of the exclusion group. */
        @Deprecated
        public String Description;
        /** Friendly name of the exclusion group. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class CreateExclusionGroupResult {
        /** Identifier of the exclusion group. */
        @Deprecated
        public String ExclusionGroupId;
        
    }

    /** Given a title entity token and experiment details, will create a new experiment for the title. */
    @Deprecated
    public static class CreateExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Description of the experiment. */
        @Deprecated
        public String Description;
        /** When experiment should end. */
        @Deprecated
        public Date EndDate;
        /** Id of the exclusion group. */
        @Deprecated
        public String ExclusionGroupId;
        /** Percentage of exclusion group traffic that will see this experiment. */
        @Deprecated
        public Long ExclusionGroupTrafficAllocation;
        /** Type of experiment. */
        @Deprecated
        public ExperimentType ExperimentType;
        /** Friendly name of the experiment. */
        @Deprecated
        public String Name;
        /** Id of the segment to which this experiment applies. Defaults to the 'All Players' segment. */
        @Deprecated
        public String SegmentId;
        /** When experiment should start. */
        @Deprecated
        public Date StartDate;
        /**
         * List of title player account IDs that automatically receive treatments in the experiment, but are not included when
         * calculating experiment metrics.
         */
        @Deprecated
        public ArrayList<String> TitlePlayerAccountTestIds;
        /** List of variants for the experiment. */
        @Deprecated
        public ArrayList<Variant> Variants;
        
    }

    @Deprecated
    public static class CreateExperimentResult {
        /** The ID of the new experiment. */
        @Deprecated
        public String ExperimentId;
        
    }

    /** Given an entity token and an exclusion group ID this API deletes the exclusion group. */
    @Deprecated
    public static class DeleteExclusionGroupRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The ID of the exclusion group to delete. */
        @Deprecated
        public String ExclusionGroupId;
        
    }

    /**
     * Given an entity token and an experiment ID this API deletes the experiment. A running experiment must be stopped before
     * it can be deleted.
     */
    @Deprecated
    public static class DeleteExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The ID of the experiment to delete. */
        @Deprecated
        public String ExperimentId;
        
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

    @Deprecated
    public static class ExclusionGroupTrafficAllocation {
        /** Id of the experiment. */
        @Deprecated
        public String ExperimentId;
        /** Percentage of exclusion group traffic that will see this experiment. */
        @Deprecated
        public Long TrafficAllocation;
        
    }

    @Deprecated
    public static class Experiment {
        /** Description of the experiment. */
        @Deprecated
        public String Description;
        /** When experiment should end/was ended. */
        @Deprecated
        public Date EndDate;
        /** Id of the exclusion group for this experiment. */
        @Deprecated
        public String ExclusionGroupId;
        /** Percentage of exclusion group traffic that will see this experiment. */
        @Deprecated
        public Long ExclusionGroupTrafficAllocation;
        /** Type of experiment. */
        @Deprecated
        public ExperimentType ExperimentType;
        /** Id of the experiment. */
        @Deprecated
        public String Id;
        /** Friendly name of the experiment. */
        @Deprecated
        public String Name;
        /** Id of the segment to which this experiment applies. Defaults to the 'All Players' segment. */
        @Deprecated
        public String SegmentId;
        /** When experiment should start/was started. */
        @Deprecated
        public Date StartDate;
        /** State experiment is currently in. */
        @Deprecated
        public ExperimentState State;
        /**
         * List of title player account IDs that automatically receive treatments in the experiment, but are not included when
         * calculating experiment metrics.
         */
        @Deprecated
        public ArrayList<String> TitlePlayerAccountTestIds;
        /** List of variants for the experiment. */
        @Deprecated
        public ArrayList<Variant> Variants;
        
    }

    @Deprecated
    public static class ExperimentExclusionGroup {
        /** Description of the exclusion group. */
        @Deprecated
        public String Description;
        /** Id of the exclusion group. */
        @Deprecated
        public String ExclusionGroupId;
        /** Friendly name of the exclusion group. */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static enum ExperimentState {
        New,
        Started,
        Stopped,
        Deleted
    }

    @Deprecated
    public static enum ExperimentType {
        Active,
        Snapshot
    }

    /** Given a title entity token will return the list of all exclusion groups for a title. */
    @Deprecated
    public static class GetExclusionGroupsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class GetExclusionGroupsResult {
        /** List of exclusion groups for the title. */
        @Deprecated
        public ArrayList<ExperimentExclusionGroup> ExclusionGroups;
        
    }

    /**
     * Given a title entity token and an exclusion group ID, will return the list of traffic allocations for the exclusion
     * group.
     */
    @Deprecated
    public static class GetExclusionGroupTrafficRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The ID of the exclusion group. */
        @Deprecated
        public String ExclusionGroupId;
        
    }

    @Deprecated
    public static class GetExclusionGroupTrafficResult {
        /** List of traffic allocations for the exclusion group. */
        @Deprecated
        public ArrayList<ExclusionGroupTrafficAllocation> TrafficAllocations;
        
    }

    /**
     * Given a title entity token will return the list of all experiments for a title, including scheduled, started, stopped or
     * completed experiments.
     */
    @Deprecated
    public static class GetExperimentsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class GetExperimentsResult {
        /** List of experiments for the title. */
        @Deprecated
        public ArrayList<Experiment> Experiments;
        
    }

    /** Given a title entity token and experiment details, will return the latest available scorecard. */
    @Deprecated
    public static class GetLatestScorecardRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The ID of the experiment. */
        @Deprecated
        public String ExperimentId;
        
    }

    @Deprecated
    public static class GetLatestScorecardResult {
        /** Scorecard for the experiment of the title. */
        @Deprecated
        public Scorecard Scorecard;
        
    }

    /**
     * Given a title player or a title entity token, returns the treatment variants and variables assigned to the entity across
     * all running experiments
     */
    @Deprecated
    public static class GetTreatmentAssignmentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        
    }

    @Deprecated
    public static class GetTreatmentAssignmentResult {
        /** Treatment assignment for the entity. */
        @Deprecated
        public TreatmentAssignment TreatmentAssignment;
        
    }

    @Deprecated
    public static class MetricData {
        /** The upper bound of the confidence interval for the relative delta (Delta.RelativeValue). */
        @Deprecated
        public Double ConfidenceIntervalEnd;
        /** The lower bound of the confidence interval for the relative delta (Delta.RelativeValue). */
        @Deprecated
        public Double ConfidenceIntervalStart;
        /** The absolute delta between TreatmentStats.Average and ControlStats.Average. */
        @Deprecated
        public Float DeltaAbsoluteChange;
        /** The relative delta ratio between TreatmentStats.Average and ControlStats.Average. */
        @Deprecated
        public Float DeltaRelativeChange;
        /** The machine name of the metric. */
        @Deprecated
        public String InternalName;
        /** Indicates if a movement was detected on that metric. */
        @Deprecated
        public String Movement;
        /** The readable name of the metric. */
        @Deprecated
        public String Name;
        /** The expectation that a movement is real */
        @Deprecated
        public Float PMove;
        /** The p-value resulting from the statistical test run for this metric */
        @Deprecated
        public Float PValue;
        /** The threshold for observing sample ratio mismatch. */
        @Deprecated
        public Float PValueThreshold;
        /** Indicates if the movement is statistically significant. */
        @Deprecated
        public String StatSigLevel;
        /** Observed standard deviation value of the metric. */
        @Deprecated
        public Float StdDev;
        /** Observed average value of the metric. */
        @Deprecated
        public Float Value;
        
    }

    @Deprecated
    public static class Scorecard {
        /** Represents the date the scorecard was generated. */
        @Deprecated
        public String DateGenerated;
        /** Represents the duration of scorecard analysis. */
        @Deprecated
        public String Duration;
        /** Represents the number of events processed for the generation of this scorecard */
        @Deprecated
        public Double EventsProcessed;
        /** Id of the experiment. */
        @Deprecated
        public String ExperimentId;
        /** Friendly name of the experiment. */
        @Deprecated
        public String ExperimentName;
        /** Represents the latest compute job status. */
        @Deprecated
        public AnalysisTaskState LatestJobStatus;
        /** Represents the presence of a sample ratio mismatch in the scorecard data. */
        @Deprecated
        public Boolean SampleRatioMismatch;
        /** Scorecard containing list of analysis. */
        @Deprecated
        public ArrayList<ScorecardDataRow> ScorecardDataRows;
        
    }

    @Deprecated
    public static class ScorecardDataRow {
        /** Represents whether the variant is control or not. */
        @Deprecated
        public Boolean IsControl;
        /** Data of the analysis with the internal name of the metric as the key and an object of metric data as value. */
        @Deprecated
        public Map<String,MetricData> MetricDataRows;
        /** Represents the player count in the variant. */
        @Deprecated
        public Long PlayerCount;
        /** Name of the variant of analysis. */
        @Deprecated
        public String VariantName;
        
    }

    /** Given a title entity token and an experiment ID, this API starts the experiment. */
    @Deprecated
    public static class StartExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The ID of the experiment to start. */
        @Deprecated
        public String ExperimentId;
        
    }

    /** Given a title entity token and an experiment ID, this API stops the experiment if it is running. */
    @Deprecated
    public static class StopExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The ID of the experiment to stop. */
        @Deprecated
        public String ExperimentId;
        
    }

    @Deprecated
    public static class TreatmentAssignment {
        /** List of the experiment variables. */
        @Deprecated
        public ArrayList<Variable> Variables;
        /** List of the experiment variants. */
        @Deprecated
        public ArrayList<String> Variants;
        
    }

    /** Given an entity token and exclusion group details this API updates the exclusion group. */
    @Deprecated
    public static class UpdateExclusionGroupRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Description of the exclusion group. */
        @Deprecated
        public String Description;
        /** The ID of the exclusion group to update. */
        @Deprecated
        public String ExclusionGroupId;
        /** Friendly name of the exclusion group. */
        @Deprecated
        public String Name;
        
    }

    /**
     * Given a title entity token and experiment details, this API updates the experiment. If an experiment is already running,
     * only the description and duration properties can be updated.
     */
    @Deprecated
    public static class UpdateExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** Description of the experiment. */
        @Deprecated
        public String Description;
        /** When experiment should end. */
        @Deprecated
        public Date EndDate;
        /** Id of the exclusion group. */
        @Deprecated
        public String ExclusionGroupId;
        /** Percentage of exclusion group traffic that will see this experiment. */
        @Deprecated
        public Long ExclusionGroupTrafficAllocation;
        /** Type of experiment. */
        @Deprecated
        public ExperimentType ExperimentType;
        /** Id of the experiment. */
        @Deprecated
        public String Id;
        /** Friendly name of the experiment. */
        @Deprecated
        public String Name;
        /** Id of the segment to which this experiment applies. Defaults to the 'All Players' segment. */
        @Deprecated
        public String SegmentId;
        /** When experiment should start. */
        @Deprecated
        public Date StartDate;
        /**
         * List of title player account IDs that automatically receive treatments in the experiment, but are not included when
         * calculating experiment metrics.
         */
        @Deprecated
        public ArrayList<String> TitlePlayerAccountTestIds;
        /** List of variants for the experiment. */
        @Deprecated
        public ArrayList<Variant> Variants;
        
    }

    @Deprecated
    public static class Variable {
        /** Name of the variable. */
        @Deprecated
        public String Name;
        /** Value of the variable. */
        @Deprecated
        public String Value;
        
    }

    @Deprecated
    public static class Variant {
        /** Description of the variant. */
        @Deprecated
        public String Description;
        /** Id of the variant. */
        @Deprecated
        public String Id;
        /** Specifies if variant is control for experiment. */
        @Deprecated
        public Boolean IsControl;
        /** Name of the variant. */
        @Deprecated
        public String Name;
        /** Id of the TitleDataOverride to use with this variant. */
        @Deprecated
        public String TitleDataOverrideLabel;
        /** Percentage of target audience traffic that will see this variant. */
        @Deprecated
        public Long TrafficPercentage;
        /** Variables returned by this variant. */
        @Deprecated
        public ArrayList<Variable> Variables;
        
    }

}
