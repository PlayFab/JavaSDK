package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabMultiplayerModels {

    public static enum AccessPolicy {
        Public,
        Friends,
        Private
    }

    public static class AssetReference {
        /** The asset's file name. This is a filename with the .zip, .tar, or .tar.gz extension. */
        public String FileName;
        /** The asset's mount path. */
        public String MountPath;
        
    }

    public static class AssetReferenceParams {
        /** The asset's file name. */
        public String FileName;
        /** The asset's mount path. */
        public String MountPath;
        
    }

    public static class AssetSummary {
        /** The asset's file name. This is a filename with the .zip, .tar, or .tar.gz extension. */
        public String FileName;
        /** The metadata associated with the asset. */
        public Map<String,String> Metadata;
        
    }

    public static enum AzureRegion {
        AustraliaEast,
        AustraliaSoutheast,
        BrazilSouth,
        CentralUs,
        EastAsia,
        EastUs,
        EastUs2,
        JapanEast,
        JapanWest,
        NorthCentralUs,
        NorthEurope,
        SouthCentralUs,
        SoutheastAsia,
        WestEurope,
        WestUs,
        SouthAfricaNorth,
        WestCentralUs,
        KoreaCentral,
        FranceCentral,
        WestUs2,
        CentralIndia,
        UaeNorth,
        UkSouth,
        SwedenCentral
    }

    public static enum AzureVmFamily {
        A,
        Av2,
        Dv2,
        Dv3,
        F,
        Fsv2,
        Dasv4,
        Dav4,
        Dadsv5,
        Eav4,
        Easv4,
        Ev4,
        Esv4,
        Dsv3,
        Dsv2,
        NCasT4_v3,
        Ddv4,
        Ddsv4,
        HBv3,
        Ddv5,
        Ddsv5
    }

    public static enum AzureVmSize {
        Standard_A1,
        Standard_A2,
        Standard_A3,
        Standard_A4,
        Standard_A1_v2,
        Standard_A2_v2,
        Standard_A4_v2,
        Standard_A8_v2,
        Standard_D1_v2,
        Standard_D2_v2,
        Standard_D3_v2,
        Standard_D4_v2,
        Standard_D5_v2,
        Standard_D2_v3,
        Standard_D4_v3,
        Standard_D8_v3,
        Standard_D16_v3,
        Standard_F1,
        Standard_F2,
        Standard_F4,
        Standard_F8,
        Standard_F16,
        Standard_F2s_v2,
        Standard_F4s_v2,
        Standard_F8s_v2,
        Standard_F16s_v2,
        Standard_D2as_v4,
        Standard_D4as_v4,
        Standard_D8as_v4,
        Standard_D16as_v4,
        Standard_D2a_v4,
        Standard_D4a_v4,
        Standard_D8a_v4,
        Standard_D16a_v4,
        Standard_D2ads_v5,
        Standard_D4ads_v5,
        Standard_D8ads_v5,
        Standard_D16ads_v5,
        Standard_E2a_v4,
        Standard_E4a_v4,
        Standard_E8a_v4,
        Standard_E16a_v4,
        Standard_E2as_v4,
        Standard_E4as_v4,
        Standard_E8as_v4,
        Standard_E16as_v4,
        Standard_D2s_v3,
        Standard_D4s_v3,
        Standard_D8s_v3,
        Standard_D16s_v3,
        Standard_DS1_v2,
        Standard_DS2_v2,
        Standard_DS3_v2,
        Standard_DS4_v2,
        Standard_DS5_v2,
        Standard_NC4as_T4_v3,
        Standard_D2d_v4,
        Standard_D4d_v4,
        Standard_D8d_v4,
        Standard_D16d_v4,
        Standard_D2ds_v4,
        Standard_D4ds_v4,
        Standard_D8ds_v4,
        Standard_D16ds_v4,
        Standard_HB120_16rs_v3,
        Standard_HB120_32rs_v3,
        Standard_HB120_64rs_v3,
        Standard_HB120_96rs_v3,
        Standard_HB120rs_v3,
        Standard_D2d_v5,
        Standard_D4d_v5,
        Standard_D8d_v5,
        Standard_D16d_v5,
        Standard_D32d_v5,
        Standard_D2ds_v5,
        Standard_D4ds_v5,
        Standard_D8ds_v5,
        Standard_D16ds_v5,
        Standard_D32ds_v5
    }

    public static class BuildAliasDetailsResponse {
        /** The guid string alias Id of the alias to be created or updated. */
        public String AliasId;
        /** The alias name. */
        public String AliasName;
        /** Array of build selection criteria. */
        public ArrayList<BuildSelectionCriterion> BuildSelectionCriteria;
        
    }

    public static class BuildAliasParams {
        /** The guid string alias ID to use for the request. */
        public String AliasId;
        
    }

    public static class BuildRegion {
        /** The current multiplayer server stats for the region. */
        public CurrentServerStats CurrentServerStats;
        /** Optional settings to control dynamic adjustment of standby target */
        public DynamicStandbySettings DynamicStandbySettings;
        /** Whether the game assets provided for the build have been replicated to this region. */
        public Boolean IsAssetReplicationComplete;
        /** The maximum number of multiplayer servers for the region. */
        public Integer MaxServers;
        /** Regional override for the number of multiplayer servers to host on a single VM of the build. */
        public Integer MultiplayerServerCountPerVm;
        /** The build region. */
        public String Region;
        /** Optional settings to set the standby target to specified values during the supplied schedules */
        public ScheduledStandbySettings ScheduledStandbySettings;
        /** The target number of standby multiplayer servers for the region. */
        public Integer StandbyServers;
        /**
         * The status of multiplayer servers in the build region. Valid values are - Unknown, Initialized, Deploying, Deployed,
         * Unhealthy, Deleting, Deleted.
         */
        public String Status;
        /** Regional override for the VM size the build was created on. */
        public AzureVmSize VmSize;
        
    }

    public static class BuildRegionParams {
        /** Optional settings to control dynamic adjustment of standby target. If not specified, dynamic standby is disabled */
        public DynamicStandbySettings DynamicStandbySettings;
        /** The maximum number of multiplayer servers for the region. */
        public Integer MaxServers;
        /** Regional override for the number of multiplayer servers to host on a single VM of the build. */
        public Integer MultiplayerServerCountPerVm;
        /** The build region. */
        public String Region;
        /** Optional settings to set the standby target to specified values during the supplied schedules */
        public ScheduledStandbySettings ScheduledStandbySettings;
        /** The number of standby multiplayer servers for the region. */
        public Integer StandbyServers;
        /** Regional override for the VM size the build was created on. */
        public AzureVmSize VmSize;
        
    }

    public static class BuildSelectionCriterion {
        /** Dictionary of build ids and their respective weights for distribution of allocation requests. */
        public Map<String,Long> BuildWeightDistribution;
        
    }

    public static class BuildSummary {
        /** The guid string build ID of the build. */
        public String BuildId;
        /** The build name. */
        public String BuildName;
        /** The time the build was created in UTC. */
        public Date CreationTime;
        /** The metadata of the build. */
        public Map<String,String> Metadata;
        /** The configuration and status for each region in the build. */
        public ArrayList<BuildRegion> RegionConfigurations;
        
    }

    /**
     * Cancels all tickets of which the player is a member in a given queue that are not cancelled or matched. This API is
     * useful if you lose track of what tickets the player is a member of (if the title crashes for instance) and want to
     * "reset". The Entity field is optional if the caller is a player and defaults to that player. Players may not cancel
     * tickets for other people. The Entity field is required if the caller is a server (authenticated as the title).
     */
    public static class CancelAllMatchmakingTicketsForPlayerRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity key of the player whose tickets should be canceled. */
        public EntityKey Entity;
        /** The name of the queue from which a player's tickets should be canceled. */
        public String QueueName;
        
    }

    public static class CancelAllMatchmakingTicketsForPlayerResult {
        
    }

    /**
     * Cancels all backfill tickets of which the player is a member in a given queue that are not cancelled or matched. This
     * API is useful if you lose track of what tickets the player is a member of (if the server crashes for instance) and want
     * to "reset".
     */
    public static class CancelAllServerBackfillTicketsForPlayerRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity key of the player whose backfill tickets should be canceled. */
        public EntityKey Entity;
        /** The name of the queue from which a player's backfill tickets should be canceled. */
        public String QueueName;
        
    }

    public static class CancelAllServerBackfillTicketsForPlayerResult {
        
    }

    public static enum CancellationReason {
        Requested,
        Internal,
        Timeout
    }

    /**
     * Only servers and ticket members can cancel a ticket. The ticket can be in five different states when it is cancelled. 1:
     * the ticket is waiting for members to join it, and it has not started matching. If the ticket is cancelled at this stage,
     * it will never match. 2: the ticket is matching. If the ticket is cancelled, it will stop matching. 3: the ticket is
     * matched. A matched ticket cannot be cancelled. 4: the ticket is already cancelled and nothing happens. 5: the ticket is
     * waiting for a server. If the ticket is cancelled, server allocation will be stopped. A server may still be allocated due
     * to a race condition, but that will not be reflected in the ticket. There may be race conditions between the ticket
     * getting matched and the client making a cancellation request. The client must handle the possibility that the cancel
     * request fails if a match is found before the cancellation request is processed. We do not allow resubmitting a cancelled
     * ticket because players must consent to enter matchmaking again. Create a new ticket instead.
     */
    public static class CancelMatchmakingTicketRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the queue the ticket is in. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    public static class CancelMatchmakingTicketResult {
        
    }

    /**
     * Only servers can cancel a backfill ticket. The ticket can be in three different states when it is cancelled. 1: the
     * ticket is matching. If the ticket is cancelled, it will stop matching. 2: the ticket is matched. A matched ticket cannot
     * be cancelled. 3: the ticket is already cancelled and nothing happens. There may be race conditions between the ticket
     * getting matched and the server making a cancellation request. The server must handle the possibility that the cancel
     * request fails if a match is found before the cancellation request is processed. We do not allow resubmitting a cancelled
     * ticket. Create a new ticket instead.
     */
    public static class CancelServerBackfillTicketRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the queue the ticket is in. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    public static class CancelServerBackfillTicketResult {
        
    }

    public static class Certificate {
        /** Base64 encoded string contents of the certificate. */
        public String Base64EncodedValue;
        /** A name for the certificate. This is used to reference certificates in build configurations. */
        public String Name;
        /**
         * If required for your PFX certificate, use this field to provide a password that will be used to install the certificate
         * on the container.
         */
        public String Password;
        
    }

    public static class CertificateSummary {
        /** The name of the certificate. */
        public String Name;
        /** The thumbprint for the certificate. */
        public String Thumbprint;
        
    }

    public static class ConnectedPlayer {
        /** The player ID of the player connected to the multiplayer server. */
        public String PlayerId;
        
    }

    public static enum ContainerFlavor {
        ManagedWindowsServerCore,
        CustomLinux,
        ManagedWindowsServerCorePreview,
        Invalid
    }

    public static class ContainerImageReference {
        /** The container image name. */
        public String ImageName;
        /** The container tag. */
        public String Tag;
        
    }

    public static class CoreCapacity {
        /** The available core capacity for the (Region, VmFamily) */
        public Integer Available;
        /** The AzureRegion */
        public String Region;
        /** The total core capacity for the (Region, VmFamily) */
        public Integer Total;
        /** The AzureVmFamily */
        public AzureVmFamily VmFamily;
        
    }

    public static class CoreCapacityChange {
        /** New quota core limit for the given vm family/region. */
        public Integer NewCoreLimit;
        /** Region to change. */
        public String Region;
        /** Virtual machine family to change. */
        public AzureVmFamily VmFamily;
        
    }

    /** Creates a multiplayer server build alias and returns the created alias. */
    public static class CreateBuildAliasRequest {
        /** The alias name. */
        public String AliasName;
        /** Array of build selection criteria. */
        public ArrayList<BuildSelectionCriterion> BuildSelectionCriteria;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    /** Creates a multiplayer server build with a custom container and returns information about the build creation request. */
    public static class CreateBuildWithCustomContainerRequest {
        /**
         * When true, assets will not be copied for each server inside the VM. All serverswill run from the same set of assets, or
         * will have the same assets mounted in the container.
         */
        public Boolean AreAssetsReadonly;
        /** The build name. */
        public String BuildName;
        /** The flavor of container to create a build from. */
        public ContainerFlavor ContainerFlavor;
        /** The container reference, consisting of the image name and tag. */
        public ContainerImageReference ContainerImageReference;
        /** The container command to run when the multiplayer server has been allocated, including any arguments. */
        public String ContainerRunCommand;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The list of game assets related to the build. */
        public ArrayList<AssetReferenceParams> GameAssetReferences;
        /** The game certificates for the build. */
        public ArrayList<GameCertificateReferenceParams> GameCertificateReferences;
        /** The game secrets for the build. */
        public ArrayList<GameSecretReferenceParams> GameSecretReferences;
        /** The Linux instrumentation configuration for the build. */
        public LinuxInstrumentationConfiguration LinuxInstrumentationConfiguration;
        /**
         * Metadata to tag the build. The keys are case insensitive. The build metadata is made available to the server through
         * Game Server SDK (GSDK).Constraints: Maximum number of keys: 30, Maximum key length: 50, Maximum value length: 100
         */
        public Map<String,String> Metadata;
        /** The configuration for the monitoring application on the build */
        public MonitoringApplicationConfigurationParams MonitoringApplicationConfiguration;
        /** The number of multiplayer servers to host on a single VM. */
        public Integer MultiplayerServerCountPerVm;
        /** The ports to map the build on. */
        public ArrayList<Port> Ports;
        /** The region configurations for the build. */
        public ArrayList<BuildRegionParams> RegionConfigurations;
        /** The resource constraints to apply to each server on the VM (EXPERIMENTAL API) */
        public ServerResourceConstraintParams ServerResourceConstraints;
        /** The VM size to create the build on. */
        public AzureVmSize VmSize;
        /** The configuration for the VmStartupScript for the build */
        public VmStartupScriptParams VmStartupScriptConfiguration;
        
    }

    public static class CreateBuildWithCustomContainerResponse {
        /**
         * When true, assets will not be copied for each server inside the VM. All serverswill run from the same set of assets, or
         * will have the same assets mounted in the container.
         */
        public Boolean AreAssetsReadonly;
        /** The guid string build ID. Must be unique for every build. */
        public String BuildId;
        /** The build name. */
        public String BuildName;
        /** The flavor of container of the build. */
        public ContainerFlavor ContainerFlavor;
        /** The container command to run when the multiplayer server has been allocated, including any arguments. */
        public String ContainerRunCommand;
        /** The time the build was created in UTC. */
        public Date CreationTime;
        /** The custom game container image reference information. */
        public ContainerImageReference CustomGameContainerImage;
        /** The game assets for the build. */
        public ArrayList<AssetReference> GameAssetReferences;
        /** The game certificates for the build. */
        public ArrayList<GameCertificateReference> GameCertificateReferences;
        /** The game secrets for the build. */
        public ArrayList<GameSecretReference> GameSecretReferences;
        /** The Linux instrumentation configuration for this build. */
        public LinuxInstrumentationConfiguration LinuxInstrumentationConfiguration;
        /** The metadata of the build. */
        public Map<String,String> Metadata;
        /** The configuration for the monitoring application for the build */
        public MonitoringApplicationConfiguration MonitoringApplicationConfiguration;
        /** The number of multiplayer servers to host on a single VM of the build. */
        public Integer MultiplayerServerCountPerVm;
        /** The OS platform used for running the game process. */
        public String OsPlatform;
        /** The ports the build is mapped on. */
        public ArrayList<Port> Ports;
        /** The region configuration for the build. */
        public ArrayList<BuildRegion> RegionConfigurations;
        /** The resource constraints to apply to each server on the VM (EXPERIMENTAL API) */
        public ServerResourceConstraintParams ServerResourceConstraints;
        /** The type of game server being hosted. */
        public String ServerType;
        /**
         * When true, assets will be downloaded and uncompressed in memory, without the compressedversion being written first to
         * disc.
         */
        public Boolean UseStreamingForAssetDownloads;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        /** The configuration for the VmStartupScript feature for the build */
        public VmStartupScriptConfiguration VmStartupScriptConfiguration;
        
    }

    /** Creates a multiplayer server build with a managed container and returns information about the build creation request. */
    public static class CreateBuildWithManagedContainerRequest {
        /**
         * When true, assets will not be copied for each server inside the VM. All serverswill run from the same set of assets, or
         * will have the same assets mounted in the container.
         */
        public Boolean AreAssetsReadonly;
        /** The build name. */
        public String BuildName;
        /** The flavor of container to create a build from. */
        public ContainerFlavor ContainerFlavor;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The list of game assets related to the build. */
        public ArrayList<AssetReferenceParams> GameAssetReferences;
        /** The game certificates for the build. */
        public ArrayList<GameCertificateReferenceParams> GameCertificateReferences;
        /** The game secrets for the build. */
        public ArrayList<GameSecretReferenceParams> GameSecretReferences;
        /**
         * The directory containing the game executable. This would be the start path of the game assets that contain the main game
         * server executable. If not provided, a best effort will be made to extract it from the start game command.
         */
        public String GameWorkingDirectory;
        /** The instrumentation configuration for the build. */
        public InstrumentationConfiguration InstrumentationConfiguration;
        /**
         * Metadata to tag the build. The keys are case insensitive. The build metadata is made available to the server through
         * Game Server SDK (GSDK).Constraints: Maximum number of keys: 30, Maximum key length: 50, Maximum value length: 100
         */
        public Map<String,String> Metadata;
        /** The configuration for the monitoring application on the build */
        public MonitoringApplicationConfigurationParams MonitoringApplicationConfiguration;
        /** The number of multiplayer servers to host on a single VM. */
        public Integer MultiplayerServerCountPerVm;
        /** The ports to map the build on. */
        public ArrayList<Port> Ports;
        /** The region configurations for the build. */
        public ArrayList<BuildRegionParams> RegionConfigurations;
        /** The resource constraints to apply to each server on the VM (EXPERIMENTAL API) */
        public ServerResourceConstraintParams ServerResourceConstraints;
        /** The command to run when the multiplayer server is started, including any arguments. */
        public String StartMultiplayerServerCommand;
        /** The VM size to create the build on. */
        public AzureVmSize VmSize;
        /** The configuration for the VmStartupScript for the build */
        public VmStartupScriptParams VmStartupScriptConfiguration;
        /** The crash dump configuration for the build. */
        public WindowsCrashDumpConfiguration WindowsCrashDumpConfiguration;
        
    }

    public static class CreateBuildWithManagedContainerResponse {
        /**
         * When true, assets will not be copied for each server inside the VM. All serverswill run from the same set of assets, or
         * will have the same assets mounted in the container.
         */
        public Boolean AreAssetsReadonly;
        /** The guid string build ID. Must be unique for every build. */
        public String BuildId;
        /** The build name. */
        public String BuildName;
        /** The flavor of container of the build. */
        public ContainerFlavor ContainerFlavor;
        /** The time the build was created in UTC. */
        public Date CreationTime;
        /** The game assets for the build. */
        public ArrayList<AssetReference> GameAssetReferences;
        /** The game certificates for the build. */
        public ArrayList<GameCertificateReference> GameCertificateReferences;
        /** The game secrets for the build. */
        public ArrayList<GameSecretReference> GameSecretReferences;
        /**
         * The directory containing the game executable. This would be the start path of the game assets that contain the main game
         * server executable. If not provided, a best effort will be made to extract it from the start game command.
         */
        public String GameWorkingDirectory;
        /** The instrumentation configuration for this build. */
        public InstrumentationConfiguration InstrumentationConfiguration;
        /** The metadata of the build. */
        public Map<String,String> Metadata;
        /** The configuration for the monitoring application for the build */
        public MonitoringApplicationConfiguration MonitoringApplicationConfiguration;
        /** The number of multiplayer servers to host on a single VM of the build. */
        public Integer MultiplayerServerCountPerVm;
        /** The OS platform used for running the game process. */
        public String OsPlatform;
        /** The ports the build is mapped on. */
        public ArrayList<Port> Ports;
        /** The region configuration for the build. */
        public ArrayList<BuildRegion> RegionConfigurations;
        /** The resource constraints to apply to each server on the VM (EXPERIMENTAL API) */
        public ServerResourceConstraintParams ServerResourceConstraints;
        /** The type of game server being hosted. */
        public String ServerType;
        /** The command to run when the multiplayer server has been allocated, including any arguments. */
        public String StartMultiplayerServerCommand;
        /**
         * When true, assets will be downloaded and uncompressed in memory, without the compressedversion being written first to
         * disc.
         */
        public Boolean UseStreamingForAssetDownloads;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        /** The configuration for the VmStartupScript feature for the build */
        public VmStartupScriptConfiguration VmStartupScriptConfiguration;
        
    }

    /**
     * Creates a multiplayer server build with the game server running as a process and returns information about the build
     * creation request.
     */
    public static class CreateBuildWithProcessBasedServerRequest {
        /**
         * When true, assets will not be copied for each server inside the VM. All serverswill run from the same set of assets, or
         * will have the same assets mounted in the container.
         */
        public Boolean AreAssetsReadonly;
        /** The build name. */
        public String BuildName;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The list of game assets related to the build. */
        public ArrayList<AssetReferenceParams> GameAssetReferences;
        /** The game certificates for the build. */
        public ArrayList<GameCertificateReferenceParams> GameCertificateReferences;
        /** The game secrets for the build. */
        public ArrayList<GameSecretReferenceParams> GameSecretReferences;
        /**
         * The working directory for the game process. If this is not provided, the working directory will be set based on the
         * mount path of the game server executable.
         */
        public String GameWorkingDirectory;
        /** The instrumentation configuration for the Build. Used only if it is a Windows Build. */
        public InstrumentationConfiguration InstrumentationConfiguration;
        /**
         * Indicates whether this build will be created using the OS Preview versionPreview OS is recommended for dev builds to
         * detect any breaking changes before they are released to retail. Retail builds should set this value to false.
         */
        public Boolean IsOSPreview;
        /** The Linux instrumentation configuration for the Build. Used only if it is a Linux Build. */
        public LinuxInstrumentationConfiguration LinuxInstrumentationConfiguration;
        /**
         * Metadata to tag the build. The keys are case insensitive. The build metadata is made available to the server through
         * Game Server SDK (GSDK).Constraints: Maximum number of keys: 30, Maximum key length: 50, Maximum value length: 100
         */
        public Map<String,String> Metadata;
        /** The configuration for the monitoring application on the build */
        public MonitoringApplicationConfigurationParams MonitoringApplicationConfiguration;
        /** The number of multiplayer servers to host on a single VM. */
        public Integer MultiplayerServerCountPerVm;
        /** The OS platform used for running the game process. */
        public String OsPlatform;
        /** The ports to map the build on. */
        public ArrayList<Port> Ports;
        /** The region configurations for the build. */
        public ArrayList<BuildRegionParams> RegionConfigurations;
        /**
         * The command to run when the multiplayer server is started, including any arguments. The path to any executable should be
         * relative to the root asset folder when unzipped.
         */
        public String StartMultiplayerServerCommand;
        /** The VM size to create the build on. */
        public AzureVmSize VmSize;
        /** The configuration for the VmStartupScript for the build */
        public VmStartupScriptParams VmStartupScriptConfiguration;
        
    }

    public static class CreateBuildWithProcessBasedServerResponse {
        /**
         * When true, assets will not be copied for each server inside the VM. All serverswill run from the same set of assets, or
         * will have the same assets mounted in the container.
         */
        public Boolean AreAssetsReadonly;
        /** The guid string build ID. Must be unique for every build. */
        public String BuildId;
        /** The build name. */
        public String BuildName;
        /** The flavor of container of the build. */
        public ContainerFlavor ContainerFlavor;
        /** The time the build was created in UTC. */
        public Date CreationTime;
        /** The game assets for the build. */
        public ArrayList<AssetReference> GameAssetReferences;
        /** The game certificates for the build. */
        public ArrayList<GameCertificateReference> GameCertificateReferences;
        /** The game secrets for the build. */
        public ArrayList<GameSecretReference> GameSecretReferences;
        /**
         * The working directory for the game process. If this is not provided, the working directory will be set based on the
         * mount path of the game server executable.
         */
        public String GameWorkingDirectory;
        /** The instrumentation configuration for this build. */
        public InstrumentationConfiguration InstrumentationConfiguration;
        /**
         * Indicates whether this build will be created using the OS Preview versionPreview OS is recommended for dev builds to
         * detect any breaking changes before they are released to retail. Retail builds should set this value to false.
         */
        public Boolean IsOSPreview;
        /** The Linux instrumentation configuration for this build. */
        public LinuxInstrumentationConfiguration LinuxInstrumentationConfiguration;
        /** The metadata of the build. */
        public Map<String,String> Metadata;
        /** The configuration for the monitoring application for the build */
        public MonitoringApplicationConfiguration MonitoringApplicationConfiguration;
        /** The number of multiplayer servers to host on a single VM of the build. */
        public Integer MultiplayerServerCountPerVm;
        /** The OS platform used for running the game process. */
        public String OsPlatform;
        /** The ports the build is mapped on. */
        public ArrayList<Port> Ports;
        /** The region configuration for the build. */
        public ArrayList<BuildRegion> RegionConfigurations;
        /** The type of game server being hosted. */
        public String ServerType;
        /**
         * The command to run when the multiplayer server is started, including any arguments. The path to any executable is
         * relative to the root asset folder when unzipped.
         */
        public String StartMultiplayerServerCommand;
        /**
         * When true, assets will be downloaded and uncompressed in memory, without the compressedversion being written first to
         * disc.
         */
        public Boolean UseStreamingForAssetDownloads;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        /** The configuration for the VmStartupScript feature for the build */
        public VmStartupScriptConfiguration VmStartupScriptConfiguration;
        
    }

    /** Request to create a lobby. A Server or client can create a lobby. */
    public static class CreateLobbyRequest {
        /**
         * The policy indicating who is allowed to join the lobby, and the visibility to queries. May be 'Public', 'Friends' or
         * 'Private'. Public means the lobby is both visible in queries and any player may join, including invited players. Friends
         * means that users who are bidirectional friends of members in the lobby may search to find friend lobbies, to retrieve
         * its connection string. Private means the lobby is not visible in queries, and a player must receive an invitation to
         * join. Defaults to 'Public' on creation. Can only be changed by the lobby owner.
         */
        public AccessPolicy AccessPolicy;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * The private key-value pairs which are visible to all entities in the lobby. At most 30 key-value pairs may be stored
         * here, keys are limited to 30 characters and values to 1000. The total size of all lobbyData values may not exceed 4096
         * bytes. Keys are case sensitive.
         */
        public Map<String,String> LobbyData;
        /** The maximum number of players allowed in the lobby. The value must be between 2 and 128. */
        public Long MaxPlayers;
        /**
         * The member initially added to the lobby. Client must specify exactly one member, which is the creator's entity and
         * member data. Member PubSubConnectionHandle must be null or empty. Game servers must not specify any members.
         */
        public ArrayList<Member> Members;
        /** The lobby owner. Must be the calling entity. */
        public EntityKey Owner;
        /**
         * The policy for how a new owner is chosen. May be 'Automatic', 'Manual' or 'None'. Can only be specified by clients. If
         * client-owned and 'Automatic' - The Lobby service will automatically assign another connected owner when the current
         * owner leaves or disconnects. The useConnections property must be true. If client - owned and 'Manual' - Ownership is
         * protected as long as the current owner is connected. If the current owner leaves or disconnects any member may set
         * themselves as the current owner. The useConnections property must be true. If client-owned and 'None' - Any member can
         * set ownership. The useConnections property can be either true or false.
         */
        public OwnerMigrationPolicy OwnerMigrationPolicy;
        /**
         * The public key-value pairs which allow queries to differentiate between lobbies. Queries will refer to these key-value
         * pairs in their filter and order by clauses to retrieve lobbies fitting the specified criteria. At most 30 key-value
         * pairs may be stored here. Keys are of the format string_key1, string_key2 ... string_key30 for string values, or
         * number_key1, number_key2, ... number_key30 for numeric values.Numeric values are floats. Values can be at most 256
         * characters long. The total size of all searchData values may not exceed 1024 bytes.
         */
        public Map<String,String> SearchData;
        /**
         * A setting to control whether connections are used. Defaults to true. When true, notifications are sent to subscribed
         * players, disconnect detection removes connectionHandles, only owner migration policies using connections are allowed,
         * and lobbies must have at least one connected member to be searchable or be a server hosted lobby with a connected
         * server. If false, then notifications are not sent, connections are not allowed, and lobbies do not need connections to
         * be searchable.
         */
        public Boolean UseConnections;
        
    }

    public static class CreateLobbyResult {
        /** A field which indicates which lobby the user will be joining. */
        public String ConnectionString;
        /** Id to uniquely identify a lobby. */
        public String LobbyId;
        
    }

    /** The client specifies the creator's attributes and optionally a list of other users to match with. */
    public static class CreateMatchmakingTicketRequest {
        /** The User who created this ticket. */
        public MatchmakingPlayer Creator;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** How long to attempt matching this ticket in seconds. */
        public Integer GiveUpAfterSeconds;
        /** A list of Entity Keys of other users to match with. */
        public ArrayList<EntityKey> MembersToMatchWith;
        /** The Id of a match queue. */
        public String QueueName;
        
    }

    public static class CreateMatchmakingTicketResult {
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    /**
     * Creates a remote user to log on to a VM for a multiplayer server build in a specific region. Returns user credential
     * information necessary to log on.
     */
    public static class CreateRemoteUserRequest {
        /** The guid string build ID of to create the remote user for. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The expiration time for the remote user created. Defaults to expiring in one day if not specified. */
        public Date ExpirationTime;
        /** The region of virtual machine to create the remote user for. */
        public String Region;
        /** The username to create the remote user with. */
        public String Username;
        /** The virtual machine ID the multiplayer server is located on. */
        public String VmId;
        
    }

    public static class CreateRemoteUserResponse {
        /** The expiration time for the remote user created. */
        public Date ExpirationTime;
        /** The generated password for the remote user that was created. */
        public String Password;
        /** The username for the remote user that was created. */
        public String Username;
        
    }

    /** The server specifies all the members, their teams and their attributes, and the server details if applicable. */
    public static class CreateServerBackfillTicketRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** How long to attempt matching this ticket in seconds. */
        public Integer GiveUpAfterSeconds;
        /** The users who will be part of this ticket, along with their team assignments. */
        public ArrayList<MatchmakingPlayerWithTeamAssignment> Members;
        /** The Id of a match queue. */
        public String QueueName;
        /** The details of the server the members are connected to. */
        public ServerDetails ServerDetails;
        
    }

    public static class CreateServerBackfillTicketResult {
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    /** The server specifies all the members and their attributes. */
    public static class CreateServerMatchmakingTicketRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** How long to attempt matching this ticket in seconds. */
        public Integer GiveUpAfterSeconds;
        /** The users who will be part of this ticket. */
        public ArrayList<MatchmakingPlayer> Members;
        /** The Id of a match queue. */
        public String QueueName;
        
    }

    /** Creates a request to change a title's multiplayer server quotas. */
    public static class CreateTitleMultiplayerServersQuotaChangeRequest {
        /** A brief description of the requested changes. */
        public String ChangeDescription;
        /** Changes to make to the titles cores quota. */
        public ArrayList<CoreCapacityChange> Changes;
        /** Email to be contacted by our team about this request. Only required when a request is not approved. */
        public String ContactEmail;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Additional information about this request that our team can use to better understand the requirements. */
        public String Notes;
        /** When these changes would need to be in effect. Only required when a request is not approved. */
        public Date StartDate;
        
    }

    public static class CreateTitleMultiplayerServersQuotaChangeResponse {
        /** Id of the change request that was created. */
        public String RequestId;
        /** Determines if the request was approved or not. When false, our team is reviewing and may respond within 2 business days. */
        public Boolean WasApproved;
        
    }

    public static class CurrentServerStats {
        /** The number of active multiplayer servers. */
        public Integer Active;
        /** The number of multiplayer servers still downloading game resources (such as assets). */
        public Integer Propping;
        /** The number of standingby multiplayer servers. */
        public Integer StandingBy;
        /** The total number of multiplayer servers. */
        public Integer Total;
        
    }

    /** Deletes a multiplayer server game asset for a title. */
    public static class DeleteAssetRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The filename of the asset to delete. */
        public String FileName;
        
    }

    /** Deletes a multiplayer server build alias. */
    public static class DeleteBuildAliasRequest {
        /** The guid string alias ID of the alias to perform the action on. */
        public String AliasId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    /** Removes a multiplayer server build's region. */
    public static class DeleteBuildRegionRequest {
        /** The guid string ID of the build we want to update regions for. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The build region to delete. */
        public String Region;
        
    }

    /** Deletes a multiplayer server build. */
    public static class DeleteBuildRequest {
        /** The guid string build ID of the build to delete. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    /** Deletes a multiplayer server game certificate. */
    public static class DeleteCertificateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the certificate. */
        public String Name;
        
    }

    /**
     * Removes the specified container image repository. After this operation, a 'docker pull' will fail for all the tags of
     * the specified image. Morever, ListContainerImages will not return the specified image.
     */
    public static class DeleteContainerImageRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The container image repository we want to delete. */
        public String ImageName;
        
    }

    /** Request to delete a lobby. Only servers can delete lobbies. */
    public static class DeleteLobbyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The id of the lobby. */
        public String LobbyId;
        
    }

    /**
     * Deletes a remote user to log on to a VM for a multiplayer server build in a specific region. Returns user credential
     * information necessary to log on.
     */
    public static class DeleteRemoteUserRequest {
        /** The guid string build ID of the multiplayer server where the remote user is to delete. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The region of the multiplayer server where the remote user is to delete. */
        public String Region;
        /** The username of the remote user to delete. */
        public String Username;
        /** The virtual machine ID the multiplayer server is located on. */
        public String VmId;
        
    }

    /** Deletes a multiplayer server game secret. */
    public static class DeleteSecretRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the secret. */
        public String Name;
        
    }

    public static enum DirectPeerConnectivityOptions {
        None,
        SamePlatformType,
        DifferentPlatformType,
        AnyPlatformType,
        SameEntityLoginProvider,
        DifferentEntityLoginProvider,
        AnyEntityLoginProvider,
        AnyPlatformTypeAndEntityLoginProvider,
        OnlyServers
    }

    public static class DynamicStandbySettings {
        /**
         * List of auto standing by trigger values and corresponding standing by multiplier. Defaults to 1.5X at 50%, 3X at 25%,
         * and 4X at 5%
         */
        public ArrayList<DynamicStandbyThreshold> DynamicFloorMultiplierThresholds;
        /** When true, dynamic standby will be enabled */
        public Boolean IsEnabled;
        /** The time it takes to reduce target standing by to configured floor value after an increase. Defaults to 30 minutes */
        public Integer RampDownSeconds;
        
    }

    public static class DynamicStandbyThreshold {
        /** When the trigger threshold is reached, multiply by this value */
        public Double Multiplier;
        /** The multiplier will be applied when the actual standby divided by target standby floor is less than this value */
        public Double TriggerThresholdPercentage;
        
    }

    public static class EmptyResponse {
        
    }

    /**
     * Enables the multiplayer server feature for a title and returns the enabled status. The enabled status can be
     * Initializing, Enabled, and Disabled. It can up to 20 minutes or more for the title to be enabled for the feature. On
     * average, it can take up to 20 minutes for the title to be enabled for the feature.
     */
    public static class EnableMultiplayerServersForTitleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class EnableMultiplayerServersForTitleResponse {
        /** The enabled status for the multiplayer server features for the title. */
        public TitleMultiplayerServerEnabledStatus Status;
        
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://docs.microsoft.com/gaming/playfab/features/data/entities/available-built-in-entity-types */
        public String Type;
        
    }

    public static enum ExternalFriendSources {
        None,
        Steam,
        Facebook,
        Xbox,
        Psn,
        All
    }

    /** Request to find friends lobbies. Only a client can find friend lobbies. */
    public static class FindFriendLobbiesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Indicates which other platforms' friends this query should link to. */
        public ExternalFriendSources ExternalPlatformFriends;
        /**
         * OData style string that contains one or more filters. Only the following operators are supported: "and" (logical and),
         * "eq" (equal), "ne" (not equals), "ge" (greater than or equal), "gt" (greater than), "le" (less than or equal), and "lt"
         * (less than). The left-hand side of each OData logical expression should be either a search property key (e.g.
         * string_key1, number_key3, etc) or one of the pre-defined search keys all of which must be prefixed by "lobby/":
         * lobby/memberCount (number of players in a lobby), lobby/maxMemberCount (maximum number of players allowed in a lobby),
         * lobby/memberCountRemaining (remaining number of players who can be allowed in a lobby), lobby/membershipLock (must equal
         * 'Unlocked' or 'Locked'), lobby/amOwner (required to equal "true"), lobby/amMember (required to equal "true").
         */
        public String Filter;
        /**
         * OData style string that contains sorting for this query in either ascending ("asc") or descending ("desc") order.
         * OrderBy clauses are of the form "number_key1 asc" or the pre-defined search key "lobby/memberCount asc",
         * "lobby/memberCountRemaining desc" and "lobby/maxMemberCount desc". To sort by closest, a moniker `distance{number_key1 =
         * 5}` can be used to sort by distance from the given number. This field only supports either one sort clause or one
         * distance clause.
         */
        public String OrderBy;
        /** Request pagination information. */
        public PaginationRequest Pagination;
        /** Xbox token if Xbox friends should be included. Requires Xbox be configured on PlayFab. */
        public String XboxToken;
        
    }

    public static class FindFriendLobbiesResult {
        /** Array of lobbies found that matched FindFriendLobbies request. */
        public ArrayList<FriendLobbySummary> Lobbies;
        /** Pagination response for FindFriendLobbies request. */
        public PaginationResponse Pagination;
        
    }

    /** Request to find lobbies. */
    public static class FindLobbiesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * OData style string that contains one or more filters. Only the following operators are supported: "and" (logical and),
         * "eq" (equal), "ne" (not equals), "ge" (greater than or equal), "gt" (greater than), "le" (less than or equal), and "lt"
         * (less than). The left-hand side of each OData logical expression should be either a search property key (e.g.
         * string_key1, number_key3, etc) or one of the pre-defined search keys all of which must be prefixed by "lobby/":
         * lobby/memberCount (number of players in a lobby), lobby/maxMemberCount (maximum number of players allowed in a lobby),
         * lobby/memberCountRemaining (remaining number of players who can be allowed in a lobby), lobby/membershipLock (must equal
         * 'Unlocked' or 'Locked'), lobby/amOwner (required to equal "true"), lobby/amMember (required to equal "true").
         */
        public String Filter;
        /**
         * OData style string that contains sorting for this query in either ascending ("asc") or descending ("desc") order.
         * OrderBy clauses are of the form "number_key1 asc" or the pre-defined search key "lobby/memberCount asc",
         * "lobby/memberCountRemaining desc" and "lobby/maxMemberCount desc". To sort by closest, a moniker `distance{number_key1 =
         * 5}` can be used to sort by distance from the given number. This field only supports either one sort clause or one
         * distance clause.
         */
        public String OrderBy;
        /** Request pagination information. */
        public PaginationRequest Pagination;
        
    }

    public static class FindLobbiesResult {
        /** Array of lobbies found that matched FindLobbies request. */
        public ArrayList<LobbySummary> Lobbies;
        /** Pagination response for FindLobbies request. */
        public PaginationResponse Pagination;
        
    }

    public static class FriendLobbySummary {
        /**
         * A string used to join the lobby.This field is populated by the Lobby service.Invites are performed by communicating this
         * connectionString to other players.
         */
        public String ConnectionString;
        /** The current number of players in the lobby. */
        public Long CurrentPlayers;
        /** Friends in Lobby. */
        public ArrayList<EntityKey> Friends;
        /** Id to uniquely identify a lobby. */
        public String LobbyId;
        /** The maximum number of players allowed in the lobby. */
        public Long MaxPlayers;
        /** A setting indicating whether members are allowed to join this lobby. When Locked new members are prevented from joining. */
        public MembershipLock MembershipLock;
        /** The client or server entity which owns this lobby. */
        public EntityKey Owner;
        /** Search data. */
        public Map<String,String> SearchData;
        
    }

    public static class GameCertificateReference {
        /**
         * An alias for the game certificate. The game server will reference this alias via GSDK config to retrieve the game
         * certificate. This alias is used as an identifier in game server code to allow a new certificate with different Name
         * field to be uploaded without the need to change any game server code to reference the new Name.
         */
        public String GsdkAlias;
        /**
         * The name of the game certificate. This name should match the name of a certificate that was previously uploaded to this
         * title.
         */
        public String Name;
        
    }

    public static class GameCertificateReferenceParams {
        /**
         * An alias for the game certificate. The game server will reference this alias via GSDK config to retrieve the game
         * certificate. This alias is used as an identifier in game server code to allow a new certificate with different Name
         * field to be uploaded without the need to change any game server code to reference the new Name.
         */
        public String GsdkAlias;
        /**
         * The name of the game certificate. This name should match the name of a certificate that was previously uploaded to this
         * title.
         */
        public String Name;
        
    }

    public static class GameSecretReference {
        /** The name of the game secret. This name should match the name of a secret that was previously added to this title. */
        public String Name;
        
    }

    public static class GameSecretReferenceParams {
        /** The name of the game secret. This name should match the name of a secret that was previously added to this title. */
        public String Name;
        
    }

    /** Gets a URL that can be used to download the specified asset. */
    public static class GetAssetDownloadUrlRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The asset's file name to get the download URL for. */
        public String FileName;
        
    }

    public static class GetAssetDownloadUrlResponse {
        /** The asset's download URL. */
        public String AssetDownloadUrl;
        /** The asset's file name to get the download URL for. */
        public String FileName;
        
    }

    /** Gets the URL to upload assets to. */
    public static class GetAssetUploadUrlRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The asset's file name to get the upload URL for. */
        public String FileName;
        
    }

    public static class GetAssetUploadUrlResponse {
        /** The asset's upload URL. */
        public String AssetUploadUrl;
        /** The asset's file name to get the upload URL for. */
        public String FileName;
        
    }

    /** Returns the details about a multiplayer server build alias. */
    public static class GetBuildAliasRequest {
        /** The guid string alias ID of the alias to perform the action on. */
        public String AliasId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    /** Returns the details about a multiplayer server build. */
    public static class GetBuildRequest {
        /** The guid string build ID of the build to get. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class GetBuildResponse {
        /**
         * When true, assets will not be copied for each server inside the VM. All serverswill run from the same set of assets, or
         * will have the same assets mounted in the container.
         */
        public Boolean AreAssetsReadonly;
        /** The guid string build ID of the build. */
        public String BuildId;
        /** The build name. */
        public String BuildName;
        /** The current build status. Valid values are - Deploying, Deployed, DeletingRegion, Unhealthy. */
        public String BuildStatus;
        /** The flavor of container of he build. */
        public ContainerFlavor ContainerFlavor;
        /**
         * The container command to run when the multiplayer server has been allocated, including any arguments. This only applies
         * to custom builds. If the build is a managed build, this field will be null.
         */
        public String ContainerRunCommand;
        /** The time the build was created in UTC. */
        public Date CreationTime;
        /** The custom game container image for a custom build. */
        public ContainerImageReference CustomGameContainerImage;
        /** The game assets for the build. */
        public ArrayList<AssetReference> GameAssetReferences;
        /** The game certificates for the build. */
        public ArrayList<GameCertificateReference> GameCertificateReferences;
        /** The instrumentation configuration of the build. */
        public InstrumentationConfiguration InstrumentationConfiguration;
        /**
         * Metadata of the build. The keys are case insensitive. The build metadata is made available to the server through Game
         * Server SDK (GSDK).
         */
        public Map<String,String> Metadata;
        /** The number of multiplayer servers to hosted on a single VM of the build. */
        public Integer MultiplayerServerCountPerVm;
        /** The OS platform used for running the game process. */
        public String OsPlatform;
        /** The ports the build is mapped on. */
        public ArrayList<Port> Ports;
        /** The region configuration for the build. */
        public ArrayList<BuildRegion> RegionConfigurations;
        /** The resource constraints to apply to each server on the VM. */
        public ServerResourceConstraintParams ServerResourceConstraints;
        /** The type of game server being hosted. */
        public String ServerType;
        /**
         * The command to run when the multiplayer server has been allocated, including any arguments. This only applies to managed
         * builds. If the build is a custom build, this field will be null.
         */
        public String StartMultiplayerServerCommand;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        /** The configuration for the VmStartupScript feature for the build */
        public VmStartupScriptConfiguration VmStartupScriptConfiguration;
        
    }

    /**
     * Gets credentials to the container registry where game developers can upload custom container images to before creating a
     * new build.
     */
    public static class GetContainerRegistryCredentialsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class GetContainerRegistryCredentialsResponse {
        /** The url of the container registry. */
        public String DnsName;
        /** The password for accessing the container registry. */
        public String Password;
        /** The username for accessing the container registry. */
        public String Username;
        
    }

    /** Request to get a lobby. */
    public static class GetLobbyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The id of the lobby. */
        public String LobbyId;
        
    }

    public static class GetLobbyResult {
        /** The information pertaining to the requested lobby. */
        public Lobby Lobby;
        
    }

    /**
     * The ticket includes the invited players, their attributes if they have joined, the ticket status, the match Id when
     * applicable, etc. Only servers, the ticket creator and the invited players can get the ticket.
     */
    public static class GetMatchmakingTicketRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * Determines whether the matchmaking attributes will be returned as an escaped JSON string or as an un-escaped JSON
         * object.
         */
        public Boolean EscapeObject;
        /** The name of the queue to find a match for. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    public static class GetMatchmakingTicketResult {
        /**
         * The reason why the current ticket was canceled. This field is only set if the ticket is in canceled state. Please retry
         * if CancellationReason is RetryRequired.
         */
        public String CancellationReasonString;
        /** Change number used for differentiating older matchmaking status updates from newer ones. */
        public Long ChangeNumber;
        /** The server date and time at which ticket was created. */
        public Date Created;
        /** The Creator's entity key. */
        public EntityKey Creator;
        /** How long to attempt matching this ticket in seconds. */
        public Integer GiveUpAfterSeconds;
        /** The Id of a match. */
        public String MatchId;
        /** A list of Users that have joined this ticket. */
        public ArrayList<MatchmakingPlayer> Members;
        /** A list of PlayFab Ids of Users to match with. */
        public ArrayList<EntityKey> MembersToMatchWith;
        /** The Id of a match queue. */
        public String QueueName;
        /**
         * The current ticket status. Possible values are: WaitingForPlayers, WaitingForMatch, WaitingForServer, Canceled and
         * Matched.
         */
        public String Status;
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    /**
     * When matchmaking has successfully matched together a collection of tickets, it produces a 'match' with an Id. The match
     * contains all of the players that were matched together, and their team assigments. Only servers and ticket members can
     * get the match.
     */
    public static class GetMatchRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * Determines whether the matchmaking attributes will be returned as an escaped JSON string or as an un-escaped JSON
         * object.
         */
        public Boolean EscapeObject;
        /** The Id of a match. */
        public String MatchId;
        /** The name of the queue to join. */
        public String QueueName;
        /** Determines whether the matchmaking attributes for each user should be returned in the response for match request. */
        public Boolean ReturnMemberAttributes;
        
    }

    public static class GetMatchResult {
        /** A string that is used by players that are matched together to join an arranged lobby. */
        public String ArrangementString;
        /** The Id of a match. */
        public String MatchId;
        /** A list of Users that are matched together, along with their team assignments. */
        public ArrayList<MatchmakingPlayerWithTeamAssignment> Members;
        /**
         * A list of regions that the match could be played in sorted by preference. This value is only set if the queue has a
         * region selection rule.
         */
        public ArrayList<String> RegionPreferences;
        /** The details of the server that the match has been allocated to. */
        public ServerDetails ServerDetails;
        
    }

    /** Gets multiplayer server session details for a build in a specific region. */
    public static class GetMultiplayerServerDetailsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * The title generated guid string session ID of the multiplayer server to get details for. This is to keep track of
         * multiplayer server sessions.
         */
        public String SessionId;
        
    }

    public static class GetMultiplayerServerDetailsResponse {
        /** The identity of the build in which the server was allocated. */
        public String BuildId;
        /** The connected players in the multiplayer server. */
        public ArrayList<ConnectedPlayer> ConnectedPlayers;
        /** The fully qualified domain name of the virtual machine that is hosting this multiplayer server. */
        public String FQDN;
        /** The public IPv4 address of the virtual machine that is hosting this multiplayer server. */
        public String IPV4Address;
        /** The time (UTC) at which a change in the multiplayer server state was observed. */
        public Date LastStateTransitionTime;
        /** The ports the multiplayer server uses. */
        public ArrayList<Port> Ports;
        /** The list of public Ipv4 addresses associated with the server. */
        public ArrayList<PublicIpAddress> PublicIPV4Addresses;
        /** The region the multiplayer server is located in. */
        public String Region;
        /** The string server ID of the multiplayer server generated by PlayFab. */
        public String ServerId;
        /** The guid string session ID of the multiplayer server. */
        public String SessionId;
        /** The state of the multiplayer server. */
        public String State;
        /** The virtual machine ID that the multiplayer server is located on. */
        public String VmId;
        
    }

    /**
     * Gets multiplayer server logs for a specific server id in a region. The logs are available only after a server has
     * terminated.
     */
    public static class GetMultiplayerServerLogsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The server ID of multiplayer server to get logs for. */
        public String ServerId;
        
    }

    public static class GetMultiplayerServerLogsResponse {
        /** URL for logs download. */
        public String LogDownloadUrl;
        
    }

    /**
     * Gets multiplayer server logs for a specific server id in a region. The logs are available only after a server has
     * terminated.
     */
    public static class GetMultiplayerSessionLogsBySessionIdRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The server ID of multiplayer server to get logs for. */
        public String SessionId;
        
    }

    /**
     * Returns the matchmaking statistics for a queue. These include the number of players matching and the statistics related
     * to the time to match statistics in seconds (average and percentiles). Statistics are refreshed once every 5 minutes.
     * Servers can access all statistics no matter what the ClientStatisticsVisibility is configured to. Clients can access
     * statistics according to the ClientStatisticsVisibility. Client requests are forbidden if all visibility fields are
     * false.
     */
    public static class GetQueueStatisticsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the queue. */
        public String QueueName;
        
    }

    public static class GetQueueStatisticsResult {
        /** The current number of players in the matchmaking queue, who are waiting to be matched. */
        public Long NumberOfPlayersMatching;
        /** Statistics representing the time (in seconds) it takes for tickets to find a match. */
        public Statistics TimeToMatchStatisticsInSeconds;
        
    }

    /** Gets a remote login endpoint to a VM that is hosting a multiplayer server build in a specific region. */
    public static class GetRemoteLoginEndpointRequest {
        /** The guid string build ID of the multiplayer server to get remote login information for. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The region of the multiplayer server to get remote login information for. */
        public String Region;
        /** The virtual machine ID the multiplayer server is located on. */
        public String VmId;
        
    }

    public static class GetRemoteLoginEndpointResponse {
        /** The remote login IPV4 address of multiplayer server. */
        public String IPV4Address;
        /** The remote login port of multiplayer server. */
        public Integer Port;
        
    }

    /**
     * The ticket includes the players, their attributes, their teams, the ticket status, the match Id and the server details
     * when applicable, etc. Only servers can get the ticket.
     */
    public static class GetServerBackfillTicketRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * Determines whether the matchmaking attributes will be returned as an escaped JSON string or as an un-escaped JSON
         * object.
         */
        public Boolean EscapeObject;
        /** The name of the queue to find a match for. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    public static class GetServerBackfillTicketResult {
        /** The reason why the current ticket was canceled. This field is only set if the ticket is in canceled state. */
        public String CancellationReasonString;
        /** The server date and time at which ticket was created. */
        public Date Created;
        /** How long to attempt matching this ticket in seconds. */
        public Integer GiveUpAfterSeconds;
        /** The Id of a match. */
        public String MatchId;
        /** A list of Users that are part of this ticket, along with their team assignments. */
        public ArrayList<MatchmakingPlayerWithTeamAssignment> Members;
        /** The Id of a match queue. */
        public String QueueName;
        /** The details of the server the members are connected to. */
        public ServerDetails ServerDetails;
        /** The current ticket status. Possible values are: WaitingForMatch, Canceled and Matched. */
        public String Status;
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    /**
     * Gets the status of whether a title is enabled for the multiplayer server feature. The enabled status can be
     * Initializing, Enabled, and Disabled.
     */
    public static class GetTitleEnabledForMultiplayerServersStatusRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class GetTitleEnabledForMultiplayerServersStatusResponse {
        /** The enabled status for the multiplayer server features for the title. */
        public TitleMultiplayerServerEnabledStatus Status;
        
    }

    /** Gets a title's server quota change request. */
    public static class GetTitleMultiplayerServersQuotaChangeRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Id of the change request to get. */
        public String RequestId;
        
    }

    public static class GetTitleMultiplayerServersQuotaChangeResponse {
        /** The change request for this title. */
        public QuotaChange Change;
        
    }

    /** Gets the quotas for a title in relation to multiplayer servers. */
    public static class GetTitleMultiplayerServersQuotasRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class GetTitleMultiplayerServersQuotasResponse {
        /** The various quotas for multiplayer servers for the title. */
        public TitleMultiplayerServersQuotas Quotas;
        
    }

    public static class InstrumentationConfiguration {
        /** Designates whether windows instrumentation configuration will be enabled for this Build */
        public Boolean IsEnabled;
        /**
         * This property is deprecated, use IsEnabled. The list of processes to be monitored on a VM for this build. Providing
         * processes will turn on performance metrics collection for this build. Process names should not include extensions. If
         * the game server process is: GameServer.exe; then, ProcessesToMonitor = [ GameServer ]
         */
        public ArrayList<String> ProcessesToMonitor;
        
    }

    /**
     * Request to invite a player to a lobby the caller is already a member of. Only a client can invite another player to a
     * lobby.
     */
    public static class InviteToLobbyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity invited to the lobby. */
        public EntityKey InviteeEntity;
        /** The id of the lobby. */
        public String LobbyId;
        /** The member entity sending the invite. Must be a member of the lobby. */
        public EntityKey MemberEntity;
        
    }

    /** Request to join an arranged lobby. Only a client can join an arranged lobby. */
    public static class JoinArrangedLobbyRequest {
        /**
         * The policy indicating who is allowed to join the lobby, and the visibility to queries. May be 'Public', 'Friends' or
         * 'Private'. Public means the lobby is both visible in queries and any player may join, including invited players. Friends
         * means that users who are bidirectional friends of members in the lobby may search to find friend lobbies, to retrieve
         * its connection string. Private means the lobby is not visible in queries, and a player must receive an invitation to
         * join. Defaults to 'Public' on creation. Can only be changed by the lobby owner.
         */
        public AccessPolicy AccessPolicy;
        /**
         * A field which indicates which lobby the user will be joining. This field is opaque to everyone except the Lobby service
         * and the creator of the arrangementString (Matchmaking). This string defines a unique identifier for the arranged lobby
         * as well as the title and member the string is valid for. Arrangement strings have an expiration.
         */
        public String ArrangementString;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The maximum number of players allowed in the lobby. The value must be between 2 and 128. */
        public Long MaxPlayers;
        /**
         * The private key-value pairs used by the member to communicate information to other members and the owner. Visible to all
         * entities in the lobby. At most 30 key-value pairs may be stored here, keys are limited to 30 characters and values to
         * 1000. The total size of all memberData values may not exceed 4096 bytes. Keys are case sensitive.
         */
        public Map<String,String> MemberData;
        /** The member entity who is joining the lobby. The first member to join will be the lobby owner. */
        public EntityKey MemberEntity;
        /**
         * The policy for how a new owner is chosen. May be 'Automatic', 'Manual' or 'None'. Can only be specified by clients. If
         * client-owned and 'Automatic' - The Lobby service will automatically assign another connected owner when the current
         * owner leaves or disconnects. The useConnections property must be true. If client - owned and 'Manual' - Ownership is
         * protected as long as the current owner is connected. If the current owner leaves or disconnects any member may set
         * themselves as the current owner. The useConnections property must be true. If client-owned and 'None' - Any member can
         * set ownership. The useConnections property can be either true or false.
         */
        public OwnerMigrationPolicy OwnerMigrationPolicy;
        /**
         * A setting to control whether connections are used. Defaults to true. When true, notifications are sent to subscribed
         * players, disconnect detection removes connectionHandles, only owner migration policies using connections are allowed,
         * and lobbies must have at least one connected member to be searchable or be a server hosted lobby with a connected
         * server. If false, then notifications are not sent, connections are not allowed, and lobbies do not need connections to
         * be searchable.
         */
        public Boolean UseConnections;
        
    }

    /**
     * Preview: Request to join a lobby as a server. Only callable by a game_server entity and this is restricted to client
     * owned lobbies which are using connections.
     */
    public static class JoinLobbyAsServerRequest {
        /**
         * A field which indicates which lobby the game_server will be joining. This field is opaque to everyone except the Lobby
         * service.
         */
        public String ConnectionString;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * The private key-value pairs which are visible to all entities in the lobby but can only be modified by the joined
         * server.At most 30 key - value pairs may be stored here, keys are limited to 30 characters and values to 1000.The total
         * size of all serverData values may not exceed 4096 bytes.
         */
        public Map<String,String> ServerData;
        /**
         * The game_server entity which is joining the Lobby. If a different game_server entity has already joined the request will
         * fail unless the joined entity is disconnected, in which case the incoming game_server entity will replace the
         * disconnected entity.
         */
        public EntityKey ServerEntity;
        
    }

    public static class JoinLobbyAsServerResult {
        /** Successfully joined lobby's id. */
        public String LobbyId;
        
    }

    /** Request to join a lobby. Only a client can join a lobby. */
    public static class JoinLobbyRequest {
        /** A field which indicates which lobby the user will be joining. This field is opaque to everyone except the Lobby service. */
        public String ConnectionString;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * The private key-value pairs used by the member to communicate information to other members and the owner. Visible to all
         * entities in the lobby. At most 30 key-value pairs may be stored here, keys are limited to 30 characters and values to
         * 1000. The total size of all memberData values may not exceed 4096 bytes.Keys are case sensitive.
         */
        public Map<String,String> MemberData;
        /** The member entity who is joining the lobby. */
        public EntityKey MemberEntity;
        
    }

    public static class JoinLobbyResult {
        /** Successfully joined lobby's id. */
        public String LobbyId;
        
    }

    /**
     * Add the player to a matchmaking ticket and specify all of its matchmaking attributes. Players can join a ticket if and
     * only if their EntityKeys are already listed in the ticket's Members list. The matchmaking service automatically starts
     * matching the ticket against other matchmaking tickets once all players have joined the ticket. It is not possible to
     * join a ticket once it has started matching.
     */
    public static class JoinMatchmakingTicketRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The User who wants to join the ticket. Their Id must be listed in PlayFabIdsToMatchWith. */
        public MatchmakingPlayer Member;
        /** The name of the queue to join. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    public static class JoinMatchmakingTicketResult {
        
    }

    /**
     * Preview: Request for server to leave a lobby. Only a game_server entity can leave and this is restricted to client owned
     * lobbies which are using connections.
     */
    public static class LeaveLobbyAsServerRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The id of the lobby. */
        public String LobbyId;
        /**
         * The game_server entity leaving the lobby. If the game_server was subscribed to notifications, it will be unsubscribed.
         * If a the given game_server entity is not in the lobby, it will fail.
         */
        public EntityKey ServerEntity;
        
    }

    /** Request to leave a lobby. Only a client can leave a lobby. */
    public static class LeaveLobbyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The id of the lobby. */
        public String LobbyId;
        /** The member entity leaving the lobby. */
        public EntityKey MemberEntity;
        
    }

    public static class LinuxInstrumentationConfiguration {
        /** Designates whether Linux instrumentation configuration will be enabled for this Build */
        public Boolean IsEnabled;
        
    }

    /** Returns a list of multiplayer server game asset summaries for a title. */
    public static class ListAssetSummariesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;
        
    }

    public static class ListAssetSummariesResponse {
        /** The list of asset summaries. */
        public ArrayList<AssetSummary> AssetSummaries;
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** Returns a list of summarized details of all multiplayer server builds for a title. */
    public static class ListBuildAliasesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;
        
    }

    public static class ListBuildAliasesResponse {
        /** The list of build aliases for the title */
        public ArrayList<BuildAliasDetailsResponse> BuildAliases;
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** Returns a list of summarized details of all multiplayer server builds for a title. */
    public static class ListBuildSummariesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;
        
    }

    public static class ListBuildSummariesResponse {
        /** The list of build summaries for a title. */
        public ArrayList<BuildSummary> BuildSummaries;
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** Returns a list of multiplayer server game certificates for a title. */
    public static class ListCertificateSummariesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;
        
    }

    public static class ListCertificateSummariesResponse {
        /** The list of game certificates. */
        public ArrayList<CertificateSummary> CertificateSummaries;
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** Returns a list of the container images that have been uploaded to the container registry for a title. */
    public static class ListContainerImagesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;
        
    }

    public static class ListContainerImagesResponse {
        /** The list of container images. */
        public ArrayList<String> Images;
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** Returns a list of the tags for a particular container image that exists in the container registry for a title. */
    public static class ListContainerImageTagsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The container images we want to list tags for. */
        public String ImageName;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;
        
    }

    public static class ListContainerImageTagsResponse {
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        /** The list of tags for a particular container image. */
        public ArrayList<String> Tags;
        
    }

    /**
     * If the caller is a title, the EntityKey in the request is required. If the caller is a player, then it is optional. If
     * it is provided it must match the caller's entity.
     */
    public static class ListMatchmakingTicketsForPlayerRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity key for which to find the ticket Ids. */
        public EntityKey Entity;
        /** The name of the queue to find a match for. */
        public String QueueName;
        
    }

    public static class ListMatchmakingTicketsForPlayerResult {
        /** The list of ticket Ids the user is a member of. */
        public ArrayList<String> TicketIds;
        
    }

    /** Returns a list of multiplayer servers for a build in a specific region. */
    public static class ListMultiplayerServersRequest {
        /** The guid string build ID of the multiplayer servers to list. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The region the multiplayer servers to list. */
        public String Region;
        /** The skip token for the paged request. */
        public String SkipToken;
        
    }

    public static class ListMultiplayerServersResponse {
        /** The list of multiplayer server summary details. */
        public ArrayList<MultiplayerServerSummary> MultiplayerServerSummaries;
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** Returns a list of quality of service servers for party. */
    public static class ListPartyQosServersRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class ListPartyQosServersResponse {
        /** The page size on the response. */
        public Integer PageSize;
        /** The list of QoS servers. */
        public ArrayList<QosServer> QosServers;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** Returns a list of quality of service servers for a title. */
    public static class ListQosServersForTitleRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * Indicates that the response should contain Qos servers for all regions, including those where there are no builds
         * deployed for the title.
         */
        public Boolean IncludeAllRegions;
        /** Indicates the Routing Preference used by the Qos servers. The default Routing Preference is Microsoft */
        public String RoutingPreference;
        
    }

    public static class ListQosServersForTitleResponse {
        /** The page size on the response. */
        public Integer PageSize;
        /** The list of QoS servers. */
        public ArrayList<QosServer> QosServers;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** Returns a list of multiplayer server game secrets for a title. */
    public static class ListSecretSummariesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;
        
    }

    public static class ListSecretSummariesResponse {
        /** The page size on the response. */
        public Integer PageSize;
        /** The list of game secret. */
        public ArrayList<SecretSummary> SecretSummaries;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** List all server backfill ticket Ids the user is a member of. */
    public static class ListServerBackfillTicketsForPlayerRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity key for which to find the ticket Ids. */
        public EntityKey Entity;
        /** The name of the queue the tickets are in. */
        public String QueueName;
        
    }

    public static class ListServerBackfillTicketsForPlayerResult {
        /** The list of backfill ticket Ids the user is a member of. */
        public ArrayList<String> TicketIds;
        
    }

    /** List all server quota change requests for a title. */
    public static class ListTitleMultiplayerServersQuotaChangesRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class ListTitleMultiplayerServersQuotaChangesResponse {
        /** All change requests for this title. */
        public ArrayList<QuotaChange> Changes;
        
    }

    /** Returns a list of virtual machines for a title. */
    public static class ListVirtualMachineSummariesRequest {
        /** The guid string build ID of the virtual machines to list. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The region of the virtual machines to list. */
        public String Region;
        /** The skip token for the paged request. */
        public String SkipToken;
        
    }

    public static class ListVirtualMachineSummariesResponse {
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        /** The list of virtual machine summaries. */
        public ArrayList<VirtualMachineSummary> VirtualMachines;
        
    }

    public static class Lobby {
        /** A setting indicating who is allowed to join this lobby, as well as see it in queries. */
        public AccessPolicy AccessPolicy;
        /** A number that increments once for each request that modifies the lobby. */
        public Long ChangeNumber;
        /**
         * A string used to join the lobby. This field is populated by the Lobby service. Invites are performed by communicating
         * this connectionString to other players.
         */
        public String ConnectionString;
        /** Lobby data. */
        public Map<String,String> LobbyData;
        /** Id to uniquely identify a lobby. */
        public String LobbyId;
        /** The maximum number of players allowed in the lobby. */
        public Long MaxPlayers;
        /** Array of all lobby members. */
        public ArrayList<Member> Members;
        /** A setting indicating whether members are allowed to join this lobby. When Locked new members are prevented from joining. */
        public MembershipLock MembershipLock;
        /** The client or server entity which owns this lobby. */
        public EntityKey Owner;
        /** A setting indicating the owner migration policy. If server owned, this field is not present. */
        public OwnerMigrationPolicy OwnerMigrationPolicy;
        /**
         * An opaque string stored on a SubscribeToLobbyResource call, which indicates the connection an owner or member has with
         * PubSub.
         */
        public String PubSubConnectionHandle;
        /** Search data. */
        public Map<String,String> SearchData;
        /** Preview: Lobby joined server. This is not the server owner, rather the server that has joined a client owned lobby. */
        public LobbyServer Server;
        /** A flag which determines if connections are used. Defaults to true. Only set on create. */
        public Boolean UseConnections;
        
    }

    public static class LobbyEmptyResult {
        
    }

    public static class LobbyServer {
        /** Opaque string, stored on a Subscribe call, which indicates the connection a joined server has with PubSub. */
        public String PubSubConnectionHandle;
        /** Key-value pairs specific to the joined server. */
        public Map<String,String> ServerData;
        /** The server entity key. */
        public EntityKey ServerEntity;
        
    }

    public static class LobbySummary {
        /**
         * A string used to join the lobby.This field is populated by the Lobby service.Invites are performed by communicating this
         * connectionString to other players.
         */
        public String ConnectionString;
        /** The current number of players in the lobby. */
        public Long CurrentPlayers;
        /** Id to uniquely identify a lobby. */
        public String LobbyId;
        /** The maximum number of players allowed in the lobby. */
        public Long MaxPlayers;
        /** A setting indicating whether members are allowed to join this lobby. When Locked new members are prevented from joining. */
        public MembershipLock MembershipLock;
        /** The client or server entity which owns this lobby. */
        public EntityKey Owner;
        /** Search data. */
        public Map<String,String> SearchData;
        
    }

    /** A user in a matchmaking ticket. */
    public static class MatchmakingPlayer {
        /** The user's attributes custom to the title. */
        public MatchmakingPlayerAttributes Attributes;
        /** The entity key of the matchmaking user. */
        public EntityKey Entity;
        
    }

    /** The matchmaking attributes for a user. */
    public static class MatchmakingPlayerAttributes {
        /** A data object representing a user's attributes. */
        public Object DataObject;
        /** An escaped data object representing a user's attributes. */
        public String EscapedDataObject;
        
    }

    /** A player in a created matchmaking match with a team assignment. */
    public static class MatchmakingPlayerWithTeamAssignment {
        /**
         * The user's attributes custom to the title. These attributes will be null unless the request has ReturnMemberAttributes
         * flag set to true.
         */
        public MatchmakingPlayerAttributes Attributes;
        /** The entity key of the matchmaking user. */
        public EntityKey Entity;
        /** The Id of the team the User is assigned to. */
        public String TeamId;
        
    }

    public static class Member {
        /** Key-value pairs specific to member. */
        public Map<String,String> MemberData;
        /** The member entity key. */
        public EntityKey MemberEntity;
        /** Opaque string, stored on a Subscribe call, which indicates the connection an owner or member has with PubSub. */
        public String PubSubConnectionHandle;
        
    }

    public static enum MembershipLock {
        Unlocked,
        Locked
    }

    public static class MonitoringApplicationConfiguration {
        /** Asset which contains the monitoring application files and scripts. */
        public AssetReference AssetReference;
        /** Execution script name, this will be the main executable for the monitoring application. */
        public String ExecutionScriptName;
        /** Installation script name, this will be run before the ExecutionScript. */
        public String InstallationScriptName;
        /** Timespan the monitoring application will be kept alive when running from the start of the VM */
        public Double OnStartRuntimeInMinutes;
        
    }

    public static class MonitoringApplicationConfigurationParams {
        /** Asset which contains the monitoring application files and scripts. */
        public AssetReferenceParams AssetReference;
        /** Execution script name, this will be the main executable for the monitoring application. */
        public String ExecutionScriptName;
        /** Installation script name, this will be run before the ExecutionScript. */
        public String InstallationScriptName;
        /** Timespan the monitoring application will be kept alive when running from the start of the VM */
        public Double OnStartRuntimeInMinutes;
        
    }

    public static class MultiplayerServerSummary {
        /** The connected players in the multiplayer server. */
        public ArrayList<ConnectedPlayer> ConnectedPlayers;
        /** The time (UTC) at which a change in the multiplayer server state was observed. */
        public Date LastStateTransitionTime;
        /** The region the multiplayer server is located in. */
        public String Region;
        /** The string server ID of the multiplayer server generated by PlayFab. */
        public String ServerId;
        /** The title generated guid string session ID of the multiplayer server. */
        public String SessionId;
        /** The state of the multiplayer server. */
        public String State;
        /** The virtual machine ID that the multiplayer server is located on. */
        public String VmId;
        
    }

    public static enum OsPlatform {
        Windows,
        Linux
    }

    public static enum OwnerMigrationPolicy {
        None,
        Automatic,
        Manual,
        Server
    }

    public static class PaginationRequest {
        /** Continuation token returned as a result in a previous FindLobbies call. Cannot be specified by clients. */
        public String ContinuationToken;
        /** The number of lobbies that should be retrieved. Cannot be specified by servers, clients may specify any value up to 50 */
        public Long PageSizeRequested;
        
    }

    public static class PaginationResponse {
        /** Continuation token returned by server call. Not returned for clients */
        public String ContinuationToken;
        /** The number of lobbies that matched the search request. */
        public Long TotalMatchedLobbyCount;
        
    }

    public static class PartyInvitationConfiguration {
        /**
         * The list of PlayFab EntityKeys that the invitation allows to authenticate into the network. If this list is empty, all
         * users are allowed to authenticate using the invitation's identifier. This list may contain no more than 1024 items.
         */
        public ArrayList<EntityKey> EntityKeys;
        /** The invite identifier for this party. If this value is specified, it must be no longer than 127 characters. */
        public String Identifier;
        /** Controls which participants can revoke this invite. */
        public String Revocability;
        
    }

    public static enum PartyInvitationRevocability {
        Creator,
        Anyone
    }

    public static class PartyNetworkConfiguration {
        /** Controls whether and how to support direct peer-to-peer connection attempts among devices in the network. */
        public String DirectPeerConnectivityOptions;
        /** The maximum number of devices allowed to connect to the network. Must be between 1 and 32, inclusive. */
        public Long MaxDevices;
        /** The maximum number of devices allowed per user. Must be greater than 0. */
        public Long MaxDevicesPerUser;
        /** The maximum number of endpoints allowed per device. Must be between 0 and 32, inclusive. */
        public Long MaxEndpointsPerDevice;
        /** The maximum number of unique users allowed in the network. Must be greater than 0. */
        public Long MaxUsers;
        /** The maximum number of users allowed per device. Must be between 1 and 8, inclusive. */
        public Long MaxUsersPerDevice;
        /**
         * An optionally-specified configuration for the initial invitation for this party. If not provided, default configuration
         * values will be used: a title-unique invitation identifier will be generated, the revocability will be Anyone, and the
         * EntityID list will be empty.
         */
        public PartyInvitationConfiguration PartyInvitationConfiguration;
        
    }

    public static class Port {
        /** The name for the port. */
        public String Name;
        /** The number for the port. */
        public Integer Num;
        /** The protocol for the port. */
        public ProtocolType Protocol;
        
    }

    public static enum ProtocolType {
        TCP,
        UDP
    }

    public static class PublicIpAddress {
        /** FQDN of the public IP */
        public String FQDN;
        /** Server IP Address */
        public String IpAddress;
        /** Routing Type of the public IP. */
        public String RoutingType;
        
    }

    public static class QosServer {
        /** The region the QoS server is located in. */
        public String Region;
        /** The QoS server URL. */
        public String ServerUrl;
        
    }

    public static class QuotaChange {
        /** A brief description of the requested changes. */
        public String ChangeDescription;
        /** Requested changes to make to the titles cores quota. */
        public ArrayList<CoreCapacityChange> Changes;
        /** Whether or not this request is pending a review. */
        public Boolean IsPendingReview;
        /** Additional information about this request that our team can use to better understand the requirements. */
        public String Notes;
        /** Id of the change request. */
        public String RequestId;
        /** Comments by our team when a request is reviewed. */
        public String ReviewComments;
        /** Whether or not this request was approved. */
        public Boolean WasApproved;
        
    }

    /**
     * Request to remove a member from a lobby. Owners may remove other members from a lobby. Members cannot remove themselves
     * (use LeaveLobby instead).
     */
    public static class RemoveMemberFromLobbyRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The id of the lobby. */
        public String LobbyId;
        /** The member entity to be removed from the lobby. */
        public EntityKey MemberEntity;
        /** If true, removed member can never rejoin this lobby. */
        public Boolean PreventRejoin;
        
    }

    /** Requests a multiplayer server session from a particular build in any of the given preferred regions. */
    public static class RequestMultiplayerServerRequest {
        /** The identifiers of the build alias to use for the request. */
        public BuildAliasParams BuildAliasParams;
        /** The guid string build ID of the multiplayer server to request. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * Initial list of players (potentially matchmade) allowed to connect to the game. This list is passed to the game server
         * when requested (via GSDK) and can be used to validate players connecting to it.
         */
        public ArrayList<String> InitialPlayers;
        /**
         * The preferred regions to request a multiplayer server from. The Multiplayer Service will iterate through the regions in
         * the specified order and allocate a server from the first one that has servers available.
         */
        public ArrayList<String> PreferredRegions;
        /**
         * Data encoded as a string that is passed to the game server when requested. This can be used to to communicate
         * information such as game mode or map through the request flow.
         */
        public String SessionCookie;
        /** A guid string session ID created track the multiplayer server session over its life. */
        public String SessionId;
        
    }

    public static class RequestMultiplayerServerResponse {
        /** The identity of the build in which the server was allocated. */
        public String BuildId;
        /** The connected players in the multiplayer server. */
        public ArrayList<ConnectedPlayer> ConnectedPlayers;
        /** The fully qualified domain name of the virtual machine that is hosting this multiplayer server. */
        public String FQDN;
        /** The public IPv4 address of the virtual machine that is hosting this multiplayer server. */
        public String IPV4Address;
        /** The time (UTC) at which a change in the multiplayer server state was observed. */
        public Date LastStateTransitionTime;
        /** The ports the multiplayer server uses. */
        public ArrayList<Port> Ports;
        /** The list of public Ipv4 addresses associated with the server. */
        public ArrayList<PublicIpAddress> PublicIPV4Addresses;
        /** The region the multiplayer server is located in. */
        public String Region;
        /** The string server ID of the multiplayer server generated by PlayFab. */
        public String ServerId;
        /** The guid string session ID of the multiplayer server. */
        public String SessionId;
        /** The state of the multiplayer server. */
        public String State;
        /** The virtual machine ID that the multiplayer server is located on. */
        public String VmId;
        
    }

    /**
     * Requests a party session from a particular set of builds if build alias params is provided, in any of the given
     * preferred regions.
     */
    public static class RequestPartyServiceRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The network configuration for this request. */
        public PartyNetworkConfiguration NetworkConfiguration;
        /** A guid string party ID created track the party session over its life. */
        public String PartyId;
        /**
         * The preferred regions to request a party session from. The party service will iterate through the regions in the
         * specified order and allocate a party session from the first one that is available.
         */
        public ArrayList<String> PreferredRegions;
        
    }

    public static class RequestPartyServiceResponse {
        /**
         * The invitation identifier supplied in the PartyInvitationConfiguration, or the PlayFab-generated guid if none was
         * supplied.
         */
        public String InvitationId;
        /** The guid string party ID of the party session. */
        public String PartyId;
        /** A base-64 encoded string containing the serialized network descriptor for this party. */
        public String SerializedNetworkDescriptor;
        
    }

    /**
     * Gets new credentials to the container registry where game developers can upload custom container images to before
     * creating a new build.
     */
    public static class RolloverContainerRegistryCredentialsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    public static class RolloverContainerRegistryCredentialsResponse {
        /** The url of the container registry. */
        public String DnsName;
        /** The password for accessing the container registry. */
        public String Password;
        /** The username for accessing the container registry. */
        public String Username;
        
    }

    public static enum RoutingType {
        Microsoft,
        Internet
    }

    public static class Schedule {
        /** A short description about this schedule. For example, "Game launch on July 15th". */
        public String Description;
        /**
         * The date and time in UTC at which the schedule ends. If IsRecurringWeekly is true, this schedule will keep renewing for
         * future weeks until disabled or removed.
         */
        public Date EndTime;
        /** Disables the schedule. */
        public Boolean IsDisabled;
        /** If true, the StartTime and EndTime will get renewed every week. */
        public Boolean IsRecurringWeekly;
        /** The date and time in UTC at which the schedule starts. */
        public Date StartTime;
        /** The standby target to maintain for the duration of the schedule. */
        public Integer TargetStandby;
        
    }

    public static class ScheduledStandbySettings {
        /** When true, scheduled standby will be enabled */
        public Boolean IsEnabled;
        /** A list of non-overlapping schedules */
        public ArrayList<Schedule> ScheduleList;
        
    }

    public static class Secret {
        /** Optional secret expiration date. */
        public Date ExpirationDate;
        /** A name for the secret. This is used to reference secrets in build configurations. */
        public String Name;
        /** Secret value. */
        public String Value;
        
    }

    public static class SecretSummary {
        /** Optional secret expiration date. */
        public Date ExpirationDate;
        /** The name of the secret. */
        public String Name;
        /** The secret version auto-generated after upload. */
        public String Version;
        
    }

    public static class ServerDetails {
        /** The fully qualified domain name of the virtual machine that is hosting this multiplayer server. */
        public String Fqdn;
        /** The IPv4 address of the virtual machine that is hosting this multiplayer server. */
        public String IPV4Address;
        /** The ports the multiplayer server uses. */
        public ArrayList<Port> Ports;
        /** The server's region. */
        public String Region;
        /** The string server ID of the multiplayer server generated by PlayFab. */
        public String ServerId;
        
    }

    public static class ServerResourceConstraintParams {
        /** The maximum number of cores that each server is allowed to use. */
        public Double CpuLimit;
        /**
         * The maximum number of GiB of memory that each server is allowed to use. WARNING: After exceeding this limit, the server
         * will be killed
         */
        public Double MemoryLimitGB;
        
    }

    public static enum ServerType {
        Container,
        Process
    }

    /**
     * Executes the shutdown callback from the GSDK and terminates the multiplayer server session. The callback in the GSDK
     * will allow for graceful shutdown with a 15 minute timeoutIf graceful shutdown has not been completed before 15 minutes
     * have elapsed, the multiplayer server session will be forcefully terminated on it's own.
     */
    public static class ShutdownMultiplayerServerRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** A guid string session ID of the multiplayer server to shut down. */
        public String SessionId;
        
    }

    public static class Statistics {
        /** The average. */
        public Double Average;
        /** The 50th percentile. */
        public Double Percentile50;
        /** The 90th percentile. */
        public Double Percentile90;
        /** The 99th percentile. */
        public Double Percentile99;
        
    }

    /** Request to subscribe to lobby resource notifications. */
    public static class SubscribeToLobbyResourceRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity performing the subscription. */
        public EntityKey EntityKey;
        /** Opaque string, given to a client upon creating a connection with PubSub. */
        public String PubSubConnectionHandle;
        /** The name of the resource to subscribe to. */
        public String ResourceId;
        /** Version number for the subscription of this resource. */
        public Long SubscriptionVersion;
        /** Subscription type. */
        public SubscriptionType Type;
        
    }

    public static class SubscribeToLobbyResourceResult {
        /** Topic will be returned in all notifications that are the result of this subscription. */
        public String Topic;
        
    }

    public static enum SubscriptionType {
        LobbyChange,
        LobbyInvite
    }

    public static enum TitleMultiplayerServerEnabledStatus {
        Initializing,
        Enabled,
        Disabled
    }

    public static class TitleMultiplayerServersQuotas {
        /** The core capacity for the various regions and VM Family */
        public ArrayList<CoreCapacity> CoreCapacities;
        
    }

    /** Request to unsubscribe from lobby notifications. */
    public static class UnsubscribeFromLobbyResourceRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity which performed the subscription. */
        public EntityKey EntityKey;
        /** Opaque string, given to a client upon creating a connection with PubSub. */
        public String PubSubConnectionHandle;
        /** The name of the resource to unsubscribe from. */
        public String ResourceId;
        /** Version number passed for the subscription of this resource. */
        public Long SubscriptionVersion;
        /** Subscription type. */
        public SubscriptionType Type;
        
    }

    /**
     * Removes the specified tag from the image. After this operation, a 'docker pull' will fail for the specified image and
     * tag combination. Morever, ListContainerImageTags will not return the specified tag.
     */
    public static class UntagContainerImageRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The container image which tag we want to remove. */
        public String ImageName;
        /** The tag we want to remove. */
        public String Tag;
        
    }

    /** Creates a multiplayer server build alias and returns the created alias. */
    public static class UpdateBuildAliasRequest {
        /** The guid string alias Id of the alias to be updated. */
        public String AliasId;
        /** The alias name. */
        public String AliasName;
        /** Array of build selection criteria. */
        public ArrayList<BuildSelectionCriterion> BuildSelectionCriteria;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    /** Updates a multiplayer server build's name. */
    public static class UpdateBuildNameRequest {
        /** The guid string ID of the build we want to update the name of. */
        public String BuildId;
        /** The build name. */
        public String BuildName;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    /** Updates a multiplayer server build's region. */
    public static class UpdateBuildRegionRequest {
        /** The guid string ID of the build we want to update regions for. */
        public String BuildId;
        /** The updated region configuration that should be applied to the specified build. */
        public BuildRegionParams BuildRegion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    /** Updates a multiplayer server build's regions. */
    public static class UpdateBuildRegionsRequest {
        /** The guid string ID of the build we want to update regions for. */
        public String BuildId;
        /** The updated region configuration that should be applied to the specified build. */
        public ArrayList<BuildRegionParams> BuildRegions;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        
    }

    /**
     * Preview: Request to update the serverData and serverEntity in case of migration. Only a game_server entity can update
     * this information and this is restricted to client owned lobbies which are using connections.
     */
    public static class UpdateLobbyAsServerRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The id of the lobby. */
        public String LobbyId;
        /**
         * The private key-value pairs which are visible to all entities in the lobby and modifiable by the joined server.
         * Optional. Sets or updates key-value pairs on the lobby. Only the current lobby lobby server can set serverData. Keys may
         * be an arbitrary string of at most 30 characters. The total size of all serverData values may not exceed 4096 bytes.
         * Values are not individually limited. There can be up to 30 key-value pairs stored here. Keys are case sensitive.
         */
        public Map<String,String> ServerData;
        /**
         * The keys to delete from the lobby serverData. Optional. Optional. Deletes key-value pairs on the lobby. Only the current
         * joined lobby server can delete serverData. All the specified keys will be removed from the serverData. Keys that do not
         * exist in the lobby are a no-op. If the key to delete exists in the serverData (same request) it will result in a bad
         * request.
         */
        public ArrayList<String> ServerDataToDelete;
        /**
         * The lobby server. Optional. Set a different server as the joined server of the lobby (there can only be 1 joined
         * server). When changing the server the previous server will automatically be unsubscribed.
         */
        public EntityKey ServerEntity;
        
    }

    /** Request to update a lobby. */
    public static class UpdateLobbyRequest {
        /**
         * The policy indicating who is allowed to join the lobby, and the visibility to queries. May be 'Public', 'Friends' or
         * 'Private'. Public means the lobby is both visible in queries and any player may join, including invited players. Friends
         * means that users who are bidirectional friends of members in the lobby may search to find friend lobbies, to retrieve
         * its connection string. Private means the lobby is not visible in queries, and a player must receive an invitation to
         * join. Defaults to 'Public' on creation. Can only be changed by the lobby owner.
         */
        public AccessPolicy AccessPolicy;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * The private key-value pairs which are visible to all entities in the lobby. Optional. Sets or updates key-value pairs on
         * the lobby. Only the current lobby owner can set lobby data. Keys may be an arbitrary string of at most 30 characters.
         * The total size of all lobbyData values may not exceed 4096 bytes. Values are not individually limited. There can be up
         * to 30 key-value pairs stored here. Keys are case sensitive.
         */
        public Map<String,String> LobbyData;
        /** The keys to delete from the lobby LobbyData. Optional. Behaves similar to searchDataToDelete, but applies to lobbyData. */
        public ArrayList<String> LobbyDataToDelete;
        /** The id of the lobby. */
        public String LobbyId;
        /**
         * The maximum number of players allowed in the lobby. Updates the maximum allowed number of players in the lobby. Only the
         * current lobby owner can set this. If set, the value must be greater than or equal to the number of members currently in
         * the lobby.
         */
        public Long MaxPlayers;
        /**
         * The private key-value pairs used by the member to communicate information to other members and the owner. Optional. Sets
         * or updates new key-value pairs on the caller's member data. New keys will be added with their values and existing keys
         * will be updated with the new values. Visible to all entities in the lobby. At most 30 key-value pairs may be stored
         * here, keys are limited to 30 characters and values to 1000. The total size of all memberData values may not exceed 4096
         * bytes. Keys are case sensitive. Servers cannot specifiy this.
         */
        public Map<String,String> MemberData;
        /**
         * The keys to delete from the lobby MemberData. Optional. Deletes key-value pairs on the caller's member data. All the
         * specified keys will be removed from the caller's member data. Keys that do not exist are a no-op. If the key to delete
         * exists in the memberData (same request) it will result in a bad request. Servers cannot specifiy this.
         */
        public ArrayList<String> MemberDataToDelete;
        /** The member entity whose data is being modified. Servers cannot specify this. */
        public EntityKey MemberEntity;
        /**
         * A setting indicating whether the lobby is locked. May be 'Unlocked' or 'Locked'. When Locked new members are not allowed
         * to join. Defaults to 'Unlocked' on creation. Can only be changed by the lobby owner.
         */
        public MembershipLock MembershipLock;
        /**
         * The lobby owner. Optional. Set to transfer ownership of the lobby. If client - owned and 'Automatic' - The Lobby service
         * will automatically assign another connected owner when the current owner leaves or disconnects. useConnections must be
         * true. If client - owned and 'Manual' - Ownership is protected as long as the current owner is connected. If the current
         * owner leaves or disconnects any member may set themselves as the current owner. The useConnections property must be
         * true. If client-owned and 'None' - Any member can set ownership. The useConnections property can be either true or
         * false. For all client-owned lobbies when the owner leaves and a new owner can not be automatically selected - The owner
         * field is set to null. For all client-owned lobbies when the owner disconnects and a new owner can not be automatically
         * selected - The owner field remains unchanged and the current owner retains all owner abilities for the lobby. If
         * server-owned (must be 'Server') - Any server can set ownership. The useConnections property must be true.
         */
        public EntityKey Owner;
        /**
         * The public key-value pairs which allow queries to differentiate between lobbies. Optional. Sets or updates key-value
         * pairs on the lobby for use with queries. Only the current lobby owner can set search data. New keys will be added with
         * their values and existing keys will be updated with the new values. There can be up to 30 key-value pairs stored here.
         * Keys are of the format string_key1, string_key2... string_key30 for string values, or number_key1, number_key2, ...
         * number_key30 for numeric values. Numeric values are floats. Values can be at most 256 characters long. The total size of
         * all searchData values may not exceed 1024 bytes.Keys are case sensitive.
         */
        public Map<String,String> SearchData;
        /**
         * The keys to delete from the lobby SearchData. Optional. Deletes key-value pairs on the lobby. Only the current lobby
         * owner can delete search data. All the specified keys will be removed from the search data. Keys that do not exist in the
         * lobby are a no-op.If the key to delete exists in the searchData (same request) it will result in a bad request.
         */
        public ArrayList<String> SearchDataToDelete;
        
    }

    /** Uploads a multiplayer server game certificate. */
    public static class UploadCertificateRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Forces the certificate renewal if the certificate already exists. Default is false */
        public Boolean ForceUpdate;
        /** The game certificate to upload. */
        public Certificate GameCertificate;
        
    }

    /** Uploads a multiplayer server game secret. */
    public static class UploadSecretRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** Forces the secret renewal if the secret already exists. Default is false */
        public Boolean ForceUpdate;
        /** The game secret to add. */
        public Secret GameSecret;
        
    }

    public static class VirtualMachineSummary {
        /** The virtual machine health status. */
        public String HealthStatus;
        /** The virtual machine state. */
        public String State;
        /** The virtual machine ID. */
        public String VmId;
        
    }

    public static class VmStartupScriptConfiguration {
        /** Optional port requests (name/protocol) that will be used by the VmStartupScript. Max of 5 requests. */
        public ArrayList<VmStartupScriptPortRequest> PortRequests;
        /** Asset which contains the VmStartupScript script and any other required files. */
        public AssetReference VmStartupScriptAssetReference;
        
    }

    public static class VmStartupScriptParams {
        /** Optional port requests (name/protocol) that will be used by the VmStartupScript. Max of 5 requests. */
        public ArrayList<VmStartupScriptPortRequestParams> PortRequests;
        /** Asset which contains the VmStartupScript script and any other required files. */
        public AssetReferenceParams VmStartupScriptAssetReference;
        
    }

    public static class VmStartupScriptPortRequest {
        /** The name for the port. */
        public String Name;
        /** The protocol for the port. */
        public ProtocolType Protocol;
        
    }

    public static class VmStartupScriptPortRequestParams {
        /** The name for the port. */
        public String Name;
        /** The protocol for the port. */
        public ProtocolType Protocol;
        
    }

    public static class WindowsCrashDumpConfiguration {
        /** See https://docs.microsoft.com/en-us/windows/win32/wer/collecting-user-mode-dumps for valid values. */
        public Integer CustomDumpFlags;
        /** See https://docs.microsoft.com/en-us/windows/win32/wer/collecting-user-mode-dumps for valid values. */
        public Integer DumpType;
        /** Designates whether automatic crash dump capturing will be enabled for this Build. */
        public Boolean IsEnabled;
        
    }

}
