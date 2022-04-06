package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabExperimentationModels {

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
    public static class CreateExclusionGroupRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Description of the exclusion group. */
        public String Description;
        /** Friendly name of the exclusion group. */
        public String Name;
        
    }

    public static class CreateExclusionGroupResult {
        /** Identifier of the exclusion group. */
        public String ExclusionGroupId;
        
    }

    /** Given a title entity token and experiment details, will create a new experiment for the title. */
    public static class CreateExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Description of the experiment. */
        public String Description;
        /** When experiment should end. */
        public Date EndDate;
        /** Id of the exclusion group. */
        public String ExclusionGroupId;
        /** Percentage of exclusion group traffic that will see this experiment. */
        public Long ExclusionGroupTrafficAllocation;
        /** Type of experiment. */
        public ExperimentType ExperimentType;
        /** Friendly name of the experiment. */
        public String Name;
        /** Id of the segment to which this experiment applies. Defaults to the 'All Players' segment. */
        public String SegmentId;
        /** When experiment should start. */
        public Date StartDate;
        /**
         * List of title player account IDs that automatically receive treatments in the experiment, but are not included when
         * calculating experiment metrics.
         */
        public ArrayList<String> TitlePlayerAccountTestIds;
        /** List of variants for the experiment. */
        public ArrayList<Variant> Variants;
        
    }

    public static class CreateExperimentResult {
        /** The ID of the new experiment. */
        public String ExperimentId;
        
    }

    /** Given an entity token and an exclusion group ID this API deletes the exclusion group. */
    public static class DeleteExclusionGroupRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The ID of the exclusion group to delete. */
        public String ExclusionGroupId;
        
    }

    /**
     * Given an entity token and an experiment ID this API deletes the experiment. A running experiment must be stopped before
     * it can be deleted.
     */
    public static class DeleteExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The ID of the experiment to delete. */
        public String ExperimentId;
        
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

    public static class ExclusionGroupTrafficAllocation {
        /** Id of the experiment. */
        public String ExperimentId;
        /** Percentage of exclusion group traffic that will see this experiment. */
        public Long TrafficAllocation;
        
    }

    public static class Experiment {
        /** Description of the experiment. */
        public String Description;
        /** When experiment should end/was ended. */
        public Date EndDate;
        /** Id of the exclusion group for this experiment. */
        public String ExclusionGroupId;
        /** Percentage of exclusion group traffic that will see this experiment. */
        public Long ExclusionGroupTrafficAllocation;
        /** Type of experiment. */
        public ExperimentType ExperimentType;
        /** Id of the experiment. */
        public String Id;
        /** Friendly name of the experiment. */
        public String Name;
        /** Id of the segment to which this experiment applies. Defaults to the 'All Players' segment. */
        public String SegmentId;
        /** When experiment should start/was started. */
        public Date StartDate;
        /** State experiment is currently in. */
        public ExperimentState State;
        /**
         * List of title player account IDs that automatically receive treatments in the experiment, but are not included when
         * calculating experiment metrics.
         */
        public ArrayList<String> TitlePlayerAccountTestIds;
        /** List of variants for the experiment. */
        public ArrayList<Variant> Variants;
        
    }

    public static class ExperimentExclusionGroup {
        /** Description of the exclusion group. */
        public String Description;
        /** Id of the exclusion group. */
        public String ExclusionGroupId;
        /** Friendly name of the exclusion group. */
        public String Name;
        
    }

    public static enum ExperimentState {
        New,
        Started,
        Stopped,
        Deleted
    }

    public static enum ExperimentType {
        Active,
        Snapshot
    }

    /** Given a title entity token will return the list of all exclusion groups for a title. */
    public static class GetExclusionGroupsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class GetExclusionGroupsResult {
        /** List of exclusion groups for the title. */
        public ArrayList<ExperimentExclusionGroup> ExclusionGroups;
        
    }

    /**
     * Given a title entity token and an exclusion group ID, will return the list of traffic allocations for the exclusion
     * group.
     */
    public static class GetExclusionGroupTrafficRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The ID of the exclusion group. */
        public String ExclusionGroupId;
        
    }

    public static class GetExclusionGroupTrafficResult {
        /** List of traffic allocations for the exclusion group. */
        public ArrayList<ExclusionGroupTrafficAllocation> TrafficAllocations;
        
    }

    /**
     * Given a title entity token will return the list of all experiments for a title, including scheduled, started, stopped or
     * completed experiments.
     */
    public static class GetExperimentsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class GetExperimentsResult {
        /** List of experiments for the title. */
        public ArrayList<Experiment> Experiments;
        
    }

    /** Given a title entity token and experiment details, will return the latest available scorecard. */
    public static class GetLatestScorecardRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The ID of the experiment. */
        public String ExperimentId;
        
    }

    public static class GetLatestScorecardResult {
        /** Scorecard for the experiment of the title. */
        public Scorecard Scorecard;
        
    }

    /**
     * Given a title player or a title entity token, returns the treatment variants and variables assigned to the entity across
     * all running experiments
     */
    public static class GetTreatmentAssignmentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        public EntityKey Entity;
        
    }

    public static class GetTreatmentAssignmentResult {
        /** Treatment assignment for the entity. */
        public TreatmentAssignment TreatmentAssignment;
        
    }

    public static class MetricData {
        /** The upper bound of the confidence interval for the relative delta (Delta.RelativeValue). */
        public Double ConfidenceIntervalEnd;
        /** The lower bound of the confidence interval for the relative delta (Delta.RelativeValue). */
        public Double ConfidenceIntervalStart;
        /** The absolute delta between TreatmentStats.Average and ControlStats.Average. */
        public Float DeltaAbsoluteChange;
        /** The relative delta ratio between TreatmentStats.Average and ControlStats.Average. */
        public Float DeltaRelativeChange;
        /** The machine name of the metric. */
        public String InternalName;
        /** Indicates if a movement was detected on that metric. */
        public String Movement;
        /** The readable name of the metric. */
        public String Name;
        /** The expectation that a movement is real */
        public Float PMove;
        /** The p-value resulting from the statistical test run for this metric */
        public Float PValue;
        /** The threshold for observing sample ratio mismatch. */
        public Float PValueThreshold;
        /** Indicates if the movement is statistically significant. */
        public String StatSigLevel;
        /** Observed standard deviation value of the metric. */
        public Float StdDev;
        /** Observed average value of the metric. */
        public Float Value;
        
    }

    public static class Scorecard {
        /** Represents the date the scorecard was generated. */
        public String DateGenerated;
        /** Represents the duration of scorecard analysis. */
        public String Duration;
        /** Represents the number of events processed for the generation of this scorecard */
        public Double EventsProcessed;
        /** Id of the experiment. */
        public String ExperimentId;
        /** Friendly name of the experiment. */
        public String ExperimentName;
        /** Represents the latest compute job status. */
        public AnalysisTaskState LatestJobStatus;
        /** Represents the presence of a sample ratio mismatch in the scorecard data. */
        public Boolean SampleRatioMismatch;
        /** Scorecard containing list of analysis. */
        public ArrayList<ScorecardDataRow> ScorecardDataRows;
        
    }

    public static class ScorecardDataRow {
        /** Represents whether the variant is control or not. */
        public Boolean IsControl;
        /** Data of the analysis with the internal name of the metric as the key and an object of metric data as value. */
        public Map<String,MetricData> MetricDataRows;
        /** Represents the player count in the variant. */
        public Long PlayerCount;
        /** Name of the variant of analysis. */
        public String VariantName;
        
    }

    /** Given a title entity token and an experiment ID, this API starts the experiment. */
    public static class StartExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The ID of the experiment to start. */
        public String ExperimentId;
        
    }

    /** Given a title entity token and an experiment ID, this API stops the experiment if it is running. */
    public static class StopExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The ID of the experiment to stop. */
        public String ExperimentId;
        
    }

    public static class TreatmentAssignment {
        /** List of the experiment variables. */
        public ArrayList<Variable> Variables;
        /** List of the experiment variants. */
        public ArrayList<String> Variants;
        
    }

    /** Given an entity token and exclusion group details this API updates the exclusion group. */
    public static class UpdateExclusionGroupRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Description of the exclusion group. */
        public String Description;
        /** The ID of the exclusion group to update. */
        public String ExclusionGroupId;
        /** Friendly name of the exclusion group. */
        public String Name;
        
    }

    /**
     * Given a title entity token and experiment details, this API updates the experiment. If an experiment is already running,
     * only the description and duration properties can be updated.
     */
    public static class UpdateExperimentRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Description of the experiment. */
        public String Description;
        /** When experiment should end. */
        public Date EndDate;
        /** Id of the exclusion group. */
        public String ExclusionGroupId;
        /** Percentage of exclusion group traffic that will see this experiment. */
        public Long ExclusionGroupTrafficAllocation;
        /** Type of experiment. */
        public ExperimentType ExperimentType;
        /** Id of the experiment. */
        public String Id;
        /** Friendly name of the experiment. */
        public String Name;
        /** Id of the segment to which this experiment applies. Defaults to the 'All Players' segment. */
        public String SegmentId;
        /** When experiment should start. */
        public Date StartDate;
        /**
         * List of title player account IDs that automatically receive treatments in the experiment, but are not included when
         * calculating experiment metrics.
         */
        public ArrayList<String> TitlePlayerAccountTestIds;
        /** List of variants for the experiment. */
        public ArrayList<Variant> Variants;
        
    }

    public static class Variable {
        /** Name of the variable. */
        public String Name;
        /** Value of the variable. */
        public String Value;
        
    }

    public static class Variant {
        /** Description of the variant. */
        public String Description;
        /** Id of the variant. */
        public String Id;
        /** Specifies if variant is control for experiment. */
        public Boolean IsControl;
        /** Name of the variant. */
        public String Name;
        /** Id of the TitleDataOverride to use with this variant. */
        public String TitleDataOverrideLabel;
        /** Percentage of target audience traffic that will see this variant. */
        public Long TrafficPercentage;
        /** Variables returned by this variant. */
        public ArrayList<Variable> Variables;
        
    }

}
