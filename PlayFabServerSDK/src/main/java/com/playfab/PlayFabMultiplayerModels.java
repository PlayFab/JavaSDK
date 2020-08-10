package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabMultiplayerModels {

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
        ChinaEast2,
        ChinaNorth2,
        SouthAfricaNorth,
        CentralUsEuap
    }

    public static enum AzureVmFamily {
        A,
        Av2,
        Dv2,
        Dv3,
        F,
        Fsv2,
        Dasv4
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
        Standard_D16as_v4
    }

    public static class BuildAliasDetailsResponse {
        /** The guid string alias Id of the alias to be created or updated. */
        public String AliasId;
        /** The alias name. */
        public String AliasName;
        /** Array of build selection criteria. */
        public ArrayList<BuildSelectionCriterion> BuildSelectionCriteria;
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        
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
        /** The maximum number of multiplayer servers for the region. */
        public Integer MaxServers;
        /** The build region. */
        public String Region;
        /** The target number of standby multiplayer servers for the region. */
        public Integer StandbyServers;
        /**
         * The status of multiplayer servers in the build region. Valid values are - Unknown, Initialized, Deploying, Deployed,
         * Unhealthy, Deleting, Deleted.
         */
        public String Status;
        
    }

    public static class BuildRegionParams {
        /** Optional settings to control dynamic adjustment of standby target. If not specified, dynamic standby is disabled */
        public DynamicStandbySettings DynamicStandbySettings;
        /** The maximum number of multiplayer servers for the region. */
        public Integer MaxServers;
        /** The build region. */
        public String Region;
        /** The number of standby multiplayer servers for the region. */
        public Integer StandbyServers;
        
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
    public static class CancelAllMatchmakingTicketsForPlayerRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity key of the player whose tickets should be canceled. */
        public EntityKey Entity;
        /** The name of the queue from which a player's tickets should be canceled. */
        public String QueueName;

        public CancelAllMatchmakingTicketsForPlayerRequest() {
        }

        public CancelAllMatchmakingTicketsForPlayerRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class CancelAllMatchmakingTicketsForPlayerResult {
        
    }

    /**
     * Cancels all backfill tickets of which the player is a member in a given queue that are not cancelled or matched. This
     * API is useful if you lose track of what tickets the player is a member of (if the server crashes for instance) and want
     * to "reset".
     */
    public static class CancelAllServerBackfillTicketsForPlayerRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity key of the player whose backfill tickets should be canceled. */
        public EntityKey Entity;
        /** The name of the queue from which a player's backfill tickets should be canceled. */
        public String QueueName;

        public CancelAllServerBackfillTicketsForPlayerRequest() {
        }

        public CancelAllServerBackfillTicketsForPlayerRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class CancelMatchmakingTicketRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the queue the ticket is in. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;

        public CancelMatchmakingTicketRequest() {
        }

        public CancelMatchmakingTicketRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class CancelServerBackfillTicketRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the queue the ticket is in. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;

        public CancelServerBackfillTicketRequest() {
        }

        public CancelServerBackfillTicketRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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

    /** Creates a multiplayer server build alias and returns the created alias. */
    public static class CreateBuildAliasRequest extends PlayFabRequestSettingsModel {
        /** The alias name. */
        public String AliasName;
        /** Array of build selection criteria. */
        public ArrayList<BuildSelectionCriterion> BuildSelectionCriteria;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public CreateBuildAliasRequest() {
        }

        public CreateBuildAliasRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Creates a multiplayer server build with a custom container and returns information about the build creation request. */
    public static class CreateBuildWithCustomContainerRequest extends PlayFabRequestSettingsModel {
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
        /** The Linux instrumentation configuration for the build. */
        public LinuxInstrumentationConfiguration LinuxInstrumentationConfiguration;
        /**
         * Metadata to tag the build. The keys are case insensitive. The build metadata is made available to the server through
         * Game Server SDK (GSDK).Constraints: Maximum number of keys: 30, Maximum key length: 50, Maximum value length: 100
         */
        public Map<String,String> Metadata;
        /** The number of multiplayer servers to host on a single VM. */
        public Integer MultiplayerServerCountPerVm;
        /** The ports to map the build on. */
        public ArrayList<Port> Ports;
        /** The region configurations for the build. */
        public ArrayList<BuildRegionParams> RegionConfigurations;
        /**
         * When true, assets will be downloaded and uncompressed in memory, without the compressedversion being written first to
         * disc.
         */
        public Boolean UseStreamingForAssetDownloads;
        /** The VM size to create the build on. */
        public AzureVmSize VmSize;

        public CreateBuildWithCustomContainerRequest() {
        }

        public CreateBuildWithCustomContainerRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
        /** The Linux instrumentation configuration for this build. */
        public LinuxInstrumentationConfiguration LinuxInstrumentationConfiguration;
        /** The metadata of the build. */
        public Map<String,String> Metadata;
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
         * When true, assets will be downloaded and uncompressed in memory, without the compressedversion being written first to
         * disc.
         */
        public Boolean UseStreamingForAssetDownloads;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        
    }

    /** Creates a multiplayer server build with a managed container and returns information about the build creation request. */
    public static class CreateBuildWithManagedContainerRequest extends PlayFabRequestSettingsModel {
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
        /** The number of multiplayer servers to host on a single VM. */
        public Integer MultiplayerServerCountPerVm;
        /** The ports to map the build on. */
        public ArrayList<Port> Ports;
        /** The region configurations for the build. */
        public ArrayList<BuildRegionParams> RegionConfigurations;
        /** The command to run when the multiplayer server is started, including any arguments. */
        public String StartMultiplayerServerCommand;
        /**
         * When true, assets will be downloaded and uncompressed in memory, without the compressedversion being written first to
         * disc.
         */
        public Boolean UseStreamingForAssetDownloads;
        /** The VM size to create the build on. */
        public AzureVmSize VmSize;

        public CreateBuildWithManagedContainerRequest() {
        }

        public CreateBuildWithManagedContainerRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
        /**
         * The directory containing the game executable. This would be the start path of the game assets that contain the main game
         * server executable. If not provided, a best effort will be made to extract it from the start game command.
         */
        public String GameWorkingDirectory;
        /** The instrumentation configuration for this build. */
        public InstrumentationConfiguration InstrumentationConfiguration;
        /** The metadata of the build. */
        public Map<String,String> Metadata;
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
        /** The command to run when the multiplayer server has been allocated, including any arguments. */
        public String StartMultiplayerServerCommand;
        /**
         * When true, assets will be downloaded and uncompressed in memory, without the compressedversion being written first to
         * disc.
         */
        public Boolean UseStreamingForAssetDownloads;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        
    }

    /**
     * Creates a multiplayer server build with the game server running as a process and returns information about the build
     * creation request.
     */
    public static class CreateBuildWithProcessBasedServerRequest extends PlayFabRequestSettingsModel {
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
        /**
         * The working directory for the game process. If this is not provided, the working directory will be set based on the
         * mount path of the game server executable.
         */
        public String GameWorkingDirectory;
        /** The instrumentation configuration for the build. */
        public InstrumentationConfiguration InstrumentationConfiguration;
        /**
         * Metadata to tag the build. The keys are case insensitive. The build metadata is made available to the server through
         * Game Server SDK (GSDK).Constraints: Maximum number of keys: 30, Maximum key length: 50, Maximum value length: 100
         */
        public Map<String,String> Metadata;
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
        /**
         * When true, assets will be downloaded and uncompressed in memory, without the compressedversion being written first to
         * disc.
         */
        public Boolean UseStreamingForAssetDownloads;
        /** The VM size to create the build on. */
        public AzureVmSize VmSize;

        public CreateBuildWithProcessBasedServerRequest() {
        }

        public CreateBuildWithProcessBasedServerRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
        /**
         * The working directory for the game process. If this is not provided, the working directory will be set based on the
         * mount path of the game server executable.
         */
        public String GameWorkingDirectory;
        /** The instrumentation configuration for this build. */
        public InstrumentationConfiguration InstrumentationConfiguration;
        /** The metadata of the build. */
        public Map<String,String> Metadata;
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
        
    }

    /** The client specifies the creator's attributes and optionally a list of other users to match with. */
    public static class CreateMatchmakingTicketRequest extends PlayFabRequestSettingsModel {
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

        public CreateMatchmakingTicketRequest() {
        }

        public CreateMatchmakingTicketRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class CreateMatchmakingTicketResult {
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    /**
     * Creates a remote user to log on to a VM for a multiplayer server build in a specific region. Returns user credential
     * information necessary to log on.
     */
    public static class CreateRemoteUserRequest extends PlayFabRequestSettingsModel {
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

        public CreateRemoteUserRequest() {
        }

        public CreateRemoteUserRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class CreateServerBackfillTicketRequest extends PlayFabRequestSettingsModel {
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

        public CreateServerBackfillTicketRequest() {
        }

        public CreateServerBackfillTicketRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class CreateServerBackfillTicketResult {
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    /** The server specifies all the members and their attributes. */
    public static class CreateServerMatchmakingTicketRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** How long to attempt matching this ticket in seconds. */
        public Integer GiveUpAfterSeconds;
        /** The users who will be part of this ticket. */
        public ArrayList<MatchmakingPlayer> Members;
        /** The Id of a match queue. */
        public String QueueName;

        public CreateServerMatchmakingTicketRequest() {
        }

        public CreateServerMatchmakingTicketRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class DeleteAssetRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The filename of the asset to delete. */
        public String FileName;

        public DeleteAssetRequest() {
        }

        public DeleteAssetRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Deletes a multiplayer server build alias. */
    public static class DeleteBuildAliasRequest extends PlayFabRequestSettingsModel {
        /** The guid string alias ID of the alias to perform the action on. */
        public String AliasId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public DeleteBuildAliasRequest() {
        }

        public DeleteBuildAliasRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Removes a multiplayer server build's region. */
    public static class DeleteBuildRegionRequest extends PlayFabRequestSettingsModel {
        /** The guid string ID of the build we want to update regions for. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The build region to delete. */
        public String Region;

        public DeleteBuildRegionRequest() {
        }

        public DeleteBuildRegionRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Deletes a multiplayer server build. */
    public static class DeleteBuildRequest extends PlayFabRequestSettingsModel {
        /** The guid string build ID of the build to delete. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public DeleteBuildRequest() {
        }

        public DeleteBuildRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Deletes a multiplayer server game certificate. */
    public static class DeleteCertificateRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the certificate. */
        public String Name;

        public DeleteCertificateRequest() {
        }

        public DeleteCertificateRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /**
     * Removes the specified container image repository. After this operation, a 'docker pull' will fail for all the tags of
     * the specified image. Morever, ListContainerImages will not return the specified image.
     */
    public static class DeleteContainerImageRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The container image repository we want to delete. */
        public String ImageName;

        public DeleteContainerImageRequest() {
        }

        public DeleteContainerImageRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /**
     * Deletes a remote user to log on to a VM for a multiplayer server build in a specific region. Returns user credential
     * information necessary to log on.
     */
    public static class DeleteRemoteUserRequest extends PlayFabRequestSettingsModel {
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

        public DeleteRemoteUserRequest() {
        }

        public DeleteRemoteUserRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class EnableMultiplayerServersForTitleRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public EnableMultiplayerServersForTitleRequest() {
        }

        public EnableMultiplayerServersForTitleRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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

    /** Gets the URL to upload assets to. */
    public static class GetAssetUploadUrlRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The asset's file name to get the upload URL for. */
        public String FileName;

        public GetAssetUploadUrlRequest() {
        }

        public GetAssetUploadUrlRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetAssetUploadUrlResponse {
        /** The asset's upload URL. */
        public String AssetUploadUrl;
        /** The asset's file name to get the upload URL for. */
        public String FileName;
        
    }

    /** Returns the details about a multiplayer server build alias. */
    public static class GetBuildAliasRequest extends PlayFabRequestSettingsModel {
        /** The guid string alias ID of the alias to perform the action on. */
        public String AliasId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public GetBuildAliasRequest() {
        }

        public GetBuildAliasRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Returns the details about a multiplayer server build. */
    public static class GetBuildRequest extends PlayFabRequestSettingsModel {
        /** The guid string build ID of the build to get. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public GetBuildRequest() {
        }

        public GetBuildRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
        /** The type of game server being hosted. */
        public String ServerType;
        /**
         * The command to run when the multiplayer server has been allocated, including any arguments. This only applies to managed
         * builds. If the build is a custom build, this field will be null.
         */
        public String StartMultiplayerServerCommand;
        /**
         * When true, assets will be downloaded and uncompressed in memory, without the compressedversion being written first to
         * disc.
         */
        public Boolean UseStreamingForAssetDownloads;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        
    }

    /**
     * Gets credentials to the container registry where game developers can upload custom container images to before creating a
     * new build.
     */
    public static class GetContainerRegistryCredentialsRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public GetContainerRegistryCredentialsRequest() {
        }

        public GetContainerRegistryCredentialsRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetContainerRegistryCredentialsResponse {
        /** The url of the container registry. */
        public String DnsName;
        /** The password for accessing the container registry. */
        public String Password;
        /** The username for accessing the container registry. */
        public String Username;
        
    }

    /**
     * The ticket includes the invited players, their attributes if they have joined, the ticket status, the match Id when
     * applicable, etc. Only servers, the ticket creator and the invited players can get the ticket.
     */
    public static class GetMatchmakingTicketRequest extends PlayFabRequestSettingsModel {
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

        public GetMatchmakingTicketRequest() {
        }

        public GetMatchmakingTicketRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetMatchmakingTicketResult {
        /** The reason why the current ticket was canceled. This field is only set if the ticket is in canceled state. */
        public String CancellationReasonString;
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
    public static class GetMatchRequest extends PlayFabRequestSettingsModel {
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

        public GetMatchRequest() {
        }

        public GetMatchRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetMatchResult {
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
    public static class GetMultiplayerServerDetailsRequest extends PlayFabRequestSettingsModel {
        /** The guid string build ID of the multiplayer server to get details for. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The region the multiplayer server is located in to get details for. */
        public String Region;
        /**
         * The title generated guid string session ID of the multiplayer server to get details for. This is to keep track of
         * multiplayer server sessions.
         */
        public String SessionId;

        public GetMultiplayerServerDetailsRequest() {
        }

        public GetMultiplayerServerDetailsRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetMultiplayerServerDetailsResponse {
        /** The connected players in the multiplayer server. */
        public ArrayList<ConnectedPlayer> ConnectedPlayers;
        /** The fully qualified domain name of the virtual machine that is hosting this multiplayer server. */
        public String FQDN;
        /** The IPv4 address of the virtual machine that is hosting this multiplayer server. */
        public String IPV4Address;
        /** The time (UTC) at which a change in the multiplayer server state was observed. */
        public Date LastStateTransitionTime;
        /** The ports the multiplayer server uses. */
        public ArrayList<Port> Ports;
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
    public static class GetMultiplayerServerLogsRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The server ID of multiplayer server to get logs for. */
        public String ServerId;

        public GetMultiplayerServerLogsRequest() {
        }

        public GetMultiplayerServerLogsRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetMultiplayerServerLogsResponse {
        /** URL for logs download. */
        public String LogDownloadUrl;
        
    }

    /**
     * Gets multiplayer server logs for a specific server id in a region. The logs are available only after a server has
     * terminated.
     */
    public static class GetMultiplayerSessionLogsBySessionIdRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The server ID of multiplayer server to get logs for. */
        public String SessionId;

        public GetMultiplayerSessionLogsBySessionIdRequest() {
        }

        public GetMultiplayerSessionLogsBySessionIdRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /**
     * Returns the matchmaking statistics for a queue. These include the number of players matching and the statistics related
     * to the time to match statistics in seconds (average and percentiles). Statistics are refreshed once every 5 minutes.
     * Servers can access all statistics no matter what the ClientStatisticsVisibility is configured to. Clients can access
     * statistics according to the ClientStatisticsVisibility. Client requests are forbidden if all visibility fields are
     * false.
     */
    public static class GetQueueStatisticsRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The name of the queue. */
        public String QueueName;

        public GetQueueStatisticsRequest() {
        }

        public GetQueueStatisticsRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetQueueStatisticsResult {
        /** The current number of players in the matchmaking queue, who are waiting to be matched. */
        public Long NumberOfPlayersMatching;
        /** Statistics representing the time (in seconds) it takes for tickets to find a match. */
        public Statistics TimeToMatchStatisticsInSeconds;
        
    }

    /** Gets a remote login endpoint to a VM that is hosting a multiplayer server build in a specific region. */
    public static class GetRemoteLoginEndpointRequest extends PlayFabRequestSettingsModel {
        /** The guid string build ID of the multiplayer server to get remote login information for. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The region of the multiplayer server to get remote login information for. */
        public String Region;
        /** The virtual machine ID the multiplayer server is located on. */
        public String VmId;

        public GetRemoteLoginEndpointRequest() {
        }

        public GetRemoteLoginEndpointRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class GetServerBackfillTicketRequest extends PlayFabRequestSettingsModel {
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

        public GetServerBackfillTicketRequest() {
        }

        public GetServerBackfillTicketRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class GetTitleEnabledForMultiplayerServersStatusRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public GetTitleEnabledForMultiplayerServersStatusRequest() {
        }

        public GetTitleEnabledForMultiplayerServersStatusRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetTitleEnabledForMultiplayerServersStatusResponse {
        /** The enabled status for the multiplayer server features for the title. */
        public TitleMultiplayerServerEnabledStatus Status;
        
    }

    /** Gets the quotas for a title in relation to multiplayer servers. */
    public static class GetTitleMultiplayerServersQuotasRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public GetTitleMultiplayerServersQuotasRequest() {
        }

        public GetTitleMultiplayerServersQuotasRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class GetTitleMultiplayerServersQuotasResponse {
        /** The various quotas for multiplayer servers for the title. */
        public TitleMultiplayerServersQuotas Quotas;
        
    }

    public static class InstrumentationConfiguration {
        /**
         * The list of processes to be monitored on a VM for this build. Providing processes will turn on performance metrics
         * collection for this build. Process names should not include extensions. If the game server process is: GameServer.exe;
         * then, ProcessesToMonitor = [ GameServer ]
         */
        public ArrayList<String> ProcessesToMonitor;
        
    }

    /**
     * Add the player to a matchmaking ticket and specify all of its matchmaking attributes. Players can join a ticket if and
     * only if their EntityKeys are already listed in the ticket's Members list. The matchmaking service automatically starts
     * matching the ticket against other matchmaking tickets once all players have joined the ticket. It is not possible to
     * join a ticket once it has started matching.
     */
    public static class JoinMatchmakingTicketRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The User who wants to join the ticket. Their Id must be listed in PlayFabIdsToMatchWith. */
        public MatchmakingPlayer Member;
        /** The name of the queue to join. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;

        public JoinMatchmakingTicketRequest() {
        }

        public JoinMatchmakingTicketRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class JoinMatchmakingTicketResult {
        
    }

    public static class LinuxInstrumentationConfiguration {
        /** Designates whether Linux instrumentation configuration will be enabled for this Build */
        public Boolean IsEnabled;
        
    }

    /** Returns a list of multiplayer server game asset summaries for a title. */
    public static class ListAssetSummariesRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;

        public ListAssetSummariesRequest() {
        }

        public ListAssetSummariesRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class ListAssetSummariesResponse {
        /** The list of asset summaries. */
        public ArrayList<AssetSummary> AssetSummaries;
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    public static class ListBuildAliasesForTitleResponse {
        /** The list of build aliases for the title */
        public ArrayList<BuildAliasDetailsResponse> BuildAliases;
        
    }

    /** Returns a list of summarized details of all multiplayer server builds for a title. */
    public static class ListBuildSummariesRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;

        public ListBuildSummariesRequest() {
        }

        public ListBuildSummariesRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class ListCertificateSummariesRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;

        public ListCertificateSummariesRequest() {
        }

        public ListCertificateSummariesRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class ListContainerImagesRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The page size for the request. */
        public Integer PageSize;
        /** The skip token for the paged request. */
        public String SkipToken;

        public ListContainerImagesRequest() {
        }

        public ListContainerImagesRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class ListContainerImageTagsRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The container images we want to list tags for. */
        public String ImageName;

        public ListContainerImageTagsRequest() {
        }

        public ListContainerImageTagsRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class ListContainerImageTagsResponse {
        /** The list of tags for a particular container image. */
        public ArrayList<String> Tags;
        
    }

    /**
     * If the caller is a title, the EntityKey in the request is required. If the caller is a player, then it is optional. If
     * it is provided it must match the caller's entity.
     */
    public static class ListMatchmakingTicketsForPlayerRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity key for which to find the ticket Ids. */
        public EntityKey Entity;
        /** The name of the queue to find a match for. */
        public String QueueName;

        public ListMatchmakingTicketsForPlayerRequest() {
        }

        public ListMatchmakingTicketsForPlayerRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class ListMatchmakingTicketsForPlayerResult {
        /** The list of ticket Ids the user is a member of. */
        public ArrayList<String> TicketIds;
        
    }

    /** Returns a list of multiplayer servers for a build in a specific region. */
    public static class ListMultiplayerServersRequest extends PlayFabRequestSettingsModel {
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

        public ListMultiplayerServersRequest() {
        }

        public ListMultiplayerServersRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class ListPartyQosServersRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /**
         * Qos servers version
         * @deprecated Do not use
         */
        @Deprecated
        public String Version;

        public ListPartyQosServersRequest() {
        }

        public ListPartyQosServersRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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
    public static class ListQosServersForTitleRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public ListQosServersForTitleRequest() {
        }

        public ListQosServersForTitleRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class ListQosServersForTitleResponse {
        /** The page size on the response. */
        public Integer PageSize;
        /** The list of QoS servers. */
        public ArrayList<QosServer> QosServers;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /**
     * Returns a list of quality of service servers.
     * @deprecated Do not use
     */
    @Deprecated
    public static class ListQosServersRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public ListQosServersRequest() {
        }

        public ListQosServersRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** @deprecated Do not use */
    @Deprecated
    public static class ListQosServersResponse {
        /** The page size on the response. */
        public Integer PageSize;
        /** The list of QoS servers. */
        public ArrayList<QosServer> QosServers;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** List all server backfill ticket Ids the user is a member of. */
    public static class ListServerBackfillTicketsForPlayerRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The entity key for which to find the ticket Ids. */
        public EntityKey Entity;
        /** The name of the queue the tickets are in. */
        public String QueueName;

        public ListServerBackfillTicketsForPlayerRequest() {
        }

        public ListServerBackfillTicketsForPlayerRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class ListServerBackfillTicketsForPlayerResult {
        /** The list of backfill ticket Ids the user is a member of. */
        public ArrayList<String> TicketIds;
        
    }

    /** Returns a list of virtual machines for a title. */
    public static class ListVirtualMachineSummariesRequest extends PlayFabRequestSettingsModel {
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

        public ListVirtualMachineSummariesRequest() {
        }

        public ListVirtualMachineSummariesRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class ListVirtualMachineSummariesResponse {
        /** The page size on the response. */
        public Integer PageSize;
        /** The skip token for the paged response. */
        public String SkipToken;
        /** The list of virtual machine summaries. */
        public ArrayList<VirtualMachineSummary> VirtualMachines;
        
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

    /** Returns a list of summarized details of all multiplayer server builds for a title. */
    public static class MultiplayerEmptyRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public MultiplayerEmptyRequest() {
        }

        public MultiplayerEmptyRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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

    public static class QosServer {
        /** The region the QoS server is located in. */
        public String Region;
        /** The QoS server URL. */
        public String ServerUrl;
        
    }

    /** Requests a multiplayer server session from a particular build in any of the given preferred regions. */
    public static class RequestMultiplayerServerRequest extends PlayFabRequestSettingsModel {
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

        public RequestMultiplayerServerRequest() {
        }

        public RequestMultiplayerServerRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class RequestMultiplayerServerResponse {
        /** The connected players in the multiplayer server. */
        public ArrayList<ConnectedPlayer> ConnectedPlayers;
        /** The fully qualified domain name of the virtual machine that is hosting this multiplayer server. */
        public String FQDN;
        /** The IPv4 address of the virtual machine that is hosting this multiplayer server. */
        public String IPV4Address;
        /** The time (UTC) at which a change in the multiplayer server state was observed. */
        public Date LastStateTransitionTime;
        /** The ports the multiplayer server uses. */
        public ArrayList<Port> Ports;
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
     * Gets new credentials to the container registry where game developers can upload custom container images to before
     * creating a new build.
     */
    public static class RolloverContainerRegistryCredentialsRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public RolloverContainerRegistryCredentialsRequest() {
        }

        public RolloverContainerRegistryCredentialsRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class RolloverContainerRegistryCredentialsResponse {
        /** The url of the container registry. */
        public String DnsName;
        /** The password for accessing the container registry. */
        public String Password;
        /** The username for accessing the container registry. */
        public String Username;
        
    }

    public static class ServerDetails {
        /** The IPv4 address of the virtual machine that is hosting this multiplayer server. */
        public String IPV4Address;
        /** The ports the multiplayer server uses. */
        public ArrayList<Port> Ports;
        /** The server's region. */
        public String Region;
        
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
    public static class ShutdownMultiplayerServerRequest extends PlayFabRequestSettingsModel {
        /** The guid string build ID of the multiplayer server to delete. */
        public String BuildId;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The region of the multiplayer server to shut down. */
        public String Region;
        /** A guid string session ID of the multiplayer server to shut down. */
        public String SessionId;

        public ShutdownMultiplayerServerRequest() {
        }

        public ShutdownMultiplayerServerRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
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

    public static enum TitleMultiplayerServerEnabledStatus {
        Initializing,
        Enabled,
        Disabled
    }

    public static class TitleMultiplayerServersQuotas {
        /** The core capacity for the various regions and VM Family */
        public ArrayList<CoreCapacity> CoreCapacities;
        
    }

    /**
     * Removes the specified tag from the image. After this operation, a 'docker pull' will fail for the specified image and
     * tag combination. Morever, ListContainerImageTags will not return the specified tag.
     */
    public static class UntagContainerImageRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The container image which tag we want to remove. */
        public String ImageName;
        /** The tag we want to remove. */
        public String Tag;

        public UntagContainerImageRequest() {
        }

        public UntagContainerImageRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Creates a multiplayer server build alias and returns the created alias. */
    public static class UpdateBuildAliasRequest extends PlayFabRequestSettingsModel {
        /** The guid string alias Id of the alias to be updated. */
        public String AliasId;
        /** The alias name. */
        public String AliasName;
        /** Array of build selection criteria. */
        public ArrayList<BuildSelectionCriterion> BuildSelectionCriteria;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public UpdateBuildAliasRequest() {
        }

        public UpdateBuildAliasRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Updates a multiplayer server build's region. */
    public static class UpdateBuildRegionRequest extends PlayFabRequestSettingsModel {
        /** The guid string ID of the build we want to update regions for. */
        public String BuildId;
        /** The updated region configuration that should be applied to the specified build. */
        public BuildRegionParams BuildRegion;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public UpdateBuildRegionRequest() {
        }

        public UpdateBuildRegionRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Updates a multiplayer server build's regions. */
    public static class UpdateBuildRegionsRequest extends PlayFabRequestSettingsModel {
        /** The guid string ID of the build we want to update regions for. */
        public String BuildId;
        /** The updated region configuration that should be applied to the specified build. */
        public ArrayList<BuildRegionParams> BuildRegions;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;

        public UpdateBuildRegionsRequest() {
        }

        public UpdateBuildRegionsRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    /** Uploads a multiplayer server game certificate. */
    public static class UploadCertificateRequest extends PlayFabRequestSettingsModel {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        public Map<String,String> CustomTags;
        /** The game certificate to upload. */
        public Certificate GameCertificate;

        public UploadCertificateRequest() {
        }

        public UploadCertificateRequest(String titleId, String developerSecretKey) {
            super(titleId, developerSecretKey);
        }
    }

    public static class VirtualMachineSummary {
        /** The virtual machine health status. */
        public String HealthStatus;
        /** The virtual machine state. */
        public String State;
        /** The virtual machine ID. */
        public String VmId;
        
    }

}
