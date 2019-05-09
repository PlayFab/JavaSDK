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
        ChinaNorth2
    }

    public static enum AzureVmFamily {
        A,
        Av2,
        Dv2,
        F,
        Fsv2
    }

    public static enum AzureVmSize {
        Standard_D1_v2,
        Standard_D2_v2,
        Standard_D3_v2,
        Standard_D4_v2,
        Standard_D5_v2,
        Standard_A1_v2,
        Standard_A2_v2,
        Standard_A4_v2,
        Standard_A8_v2,
        Standard_F1,
        Standard_F2,
        Standard_F4,
        Standard_F8,
        Standard_F16,
        Standard_F2s_v2,
        Standard_F4s_v2,
        Standard_F8s_v2,
        Standard_F16s_v2,
        Standard_A1,
        Standard_A2,
        Standard_A3,
        Standard_A4
    }

    public static class BuildRegion {
        /** The current multiplayer server stats for the region. */
        public CurrentServerStats CurrentServerStats;
        /** The maximum number of multiplayer servers for the region. */
        public Integer MaxServers;
        /** The build region. */
        public AzureRegion Region;
        /** The number of standby multiplayer servers for the region. */
        public Integer StandbyServers;
        /**
         * The status of multiplayer servers in the build region. Valid values are - Unknown, Initialized, Deploying, Deployed,
         * Unhealthy.
         */
        public String Status;
        
    }

    public static class BuildRegionParams {
        /** The maximum number of multiplayer servers for the region. */
        public Integer MaxServers;
        /** The build region. */
        public AzureRegion Region;
        /** The number of standby multiplayer servers for the region. */
        public Integer StandbyServers;
        
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
        /** The entity key of the player whose tickets should be canceled. */
        public EntityKey Entity;
        /** The name of the queue from which a player's tickets should be canceled. */
        public String QueueName;
        
    }

    public static class CancelAllMatchmakingTicketsForPlayerResult {
        
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
        /** The name of the queue the ticket is in. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    public static class CancelMatchmakingTicketResult {
        
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
        ManagedWindowsServerCorePreview
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
        public AzureRegion Region;
        /** The total core capacity for the (Region, VmFamily) */
        public Integer Total;
        /** The AzureVmFamily */
        public AzureVmFamily VmFamily;
        
    }

    /** Creates a multiplayer server build with a custom container and returns information about the build creation request. */
    public static class CreateBuildWithCustomContainerRequest {
        /** The build name. */
        public String BuildName;
        /** The flavor of container to create a build from. */
        public ContainerFlavor ContainerFlavor;
        /** The container reference, consisting of the image name and tag. */
        public ContainerImageReference ContainerImageReference;
        /**
         * The name of the container repository.
         * @deprecated Please use ContainerImageReference instead.
         */
        @Deprecated
        public String ContainerRepositoryName;
        /** The container command to run when the multiplayer server has been allocated, including any arguments. */
        public String ContainerRunCommand;
        /**
         * The tag for the container.
         * @deprecated Please use ContainerImageReference instead.
         */
        @Deprecated
        public String ContainerTag;
        /** The list of game assets related to the build. */
        public ArrayList<AssetReferenceParams> GameAssetReferences;
        /** The game certificates for the build. */
        public ArrayList<GameCertificateReferenceParams> GameCertificateReferences;
        /**
         * Metadata to tag the build. The keys are case insensitive. The build metadata is made available to the server through
         * Game Server SDK (GSDK).
         */
        public Map<String,String> Metadata;
        /** The number of multiplayer servers to host on a single VM. */
        public Integer MultiplayerServerCountPerVm;
        /** The ports to map the build on. */
        public ArrayList<Port> Ports;
        /** The region configurations for the build. */
        public ArrayList<BuildRegionParams> RegionConfigurations;
        /** The VM size to create the build on. */
        public AzureVmSize VmSize;
        
    }

    public static class CreateBuildWithCustomContainerResponse {
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
        /** The metadata of the build. */
        public Map<String,String> Metadata;
        /** The number of multiplayer servers to host on a single VM of the build. */
        public Integer MultiplayerServerCountPerVm;
        /** The ports the build is mapped on. */
        public ArrayList<Port> Ports;
        /** The region configuration for the build. */
        public ArrayList<BuildRegion> RegionConfigurations;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        
    }

    /** Creates a multiplayer server build with a managed container and returns information about the build creation request. */
    public static class CreateBuildWithManagedContainerRequest {
        /** The build name. */
        public String BuildName;
        /** The flavor of container to create a build from. */
        public ContainerFlavor ContainerFlavor;
        /** The list of game assets related to the build. */
        public ArrayList<AssetReferenceParams> GameAssetReferences;
        /** The game certificates for the build. */
        public ArrayList<GameCertificateReferenceParams> GameCertificateReferences;
        /**
         * Metadata to tag the build. The keys are case insensitive. The build metadata is made available to the server through
         * Game Server SDK (GSDK).
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
        /** The VM size to create the build on. */
        public AzureVmSize VmSize;
        
    }

    public static class CreateBuildWithManagedContainerResponse {
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
        /** The metadata of the build. */
        public Map<String,String> Metadata;
        /** The number of multiplayer servers to host on a single VM of the build. */
        public Integer MultiplayerServerCountPerVm;
        /** The ports the build is mapped on. */
        public ArrayList<Port> Ports;
        /** The region configuration for the build. */
        public ArrayList<BuildRegion> RegionConfigurations;
        /** The command to run when the multiplayer server has been allocated, including any arguments. */
        public String StartMultiplayerServerCommand;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        
    }

    /** The client specifies the creator's attributes and optionally a list of other users to match with. */
    public static class CreateMatchmakingTicketRequest {
        /** The User who created this ticket. */
        public MatchmakingPlayer Creator;
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
        /** The expiration time for the remote user created. Defaults to expiring in one day if not specified. */
        public Date ExpirationTime;
        /** The region of virtual machine to create the remote user for. */
        public AzureRegion Region;
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

    /** The server specifies all the members and their attributes. */
    public static class CreateServerMatchmakingTicketRequest {
        /** How long to attempt matching this ticket in seconds. */
        public Integer GiveUpAfterSeconds;
        /** The users who will be part of this ticket. */
        public ArrayList<MatchmakingPlayer> Members;
        /** The Id of a match queue. */
        public String QueueName;
        
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
        /** The filename of the asset to delete. */
        public String FileName;
        
    }

    /** Deletes a multiplayer server build. */
    public static class DeleteBuildRequest {
        /** The guid string build ID of the build to delete. */
        public String BuildId;
        
    }

    /** Deletes a multiplayer server game certificate. */
    public static class DeleteCertificateRequest {
        /** The name of the certificate. */
        public String Name;
        
    }

    /**
     * Deletes a remote user to log on to a VM for a multiplayer server build in a specific region. Returns user credential
     * information necessary to log on.
     */
    public static class DeleteRemoteUserRequest {
        /** The guid string build ID of the multiplayer server where the remote user is to delete. */
        public String BuildId;
        /** The region of the multiplayer server where the remote user is to delete. */
        public AzureRegion Region;
        /** The username of the remote user to delete. */
        public String Username;
        /** The virtual machine ID the multiplayer server is located on. */
        public String VmId;
        
    }

    public static class EmptyResponse {
        
    }

    /**
     * Enables the multiplayer server feature for a title and returns the enabled status. The enabled status can be
     * Initializing, Enabled, and Disabled. It can up to 20 minutes or more for the title to be enabled for the feature. On
     * average, it can take up to 20 minutes for the title to be enabled for the feature.
     */
    public static class EnableMultiplayerServersForTitleRequest {
        
    }

    public static class EnableMultiplayerServersForTitleResponse {
        /** The enabled status for the multiplayer server features for the title. */
        public TitleMultiplayerServerEnabledStatus Status;
        
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://api.playfab.com/docs/tutorials/entities/entitytypes */
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
    public static class GetAssetUploadUrlRequest {
        /** The asset's file name to get the upload URL for. */
        public String FileName;
        
    }

    public static class GetAssetUploadUrlResponse {
        /** The asset's upload URL. */
        public String AssetUploadUrl;
        /** The asset's file name to get the upload URL for. */
        public String FileName;
        
    }

    /** Returns the details about a multiplayer server build. */
    public static class GetBuildRequest {
        /** The guid string build ID of the build to get. */
        public String BuildId;
        
    }

    public static class GetBuildResponse {
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
        /**
         * Metadata of the build. The keys are case insensitive. The build metadata is made available to the server through Game
         * Server SDK (GSDK).
         */
        public Map<String,String> Metadata;
        /** The number of multiplayer servers to hosted on a single VM of the build. */
        public Integer MultiplayerServerCountPerVm;
        /** The ports the build is mapped on. */
        public ArrayList<Port> Ports;
        /** The region configuration for the build. */
        public ArrayList<BuildRegion> RegionConfigurations;
        /**
         * The command to run when the multiplayer server has been allocated, including any arguments. This only applies to managed
         * builds. If the build is a custom build, this field will be null.
         */
        public String StartMultiplayerServerCommand;
        /** The VM size the build was created on. */
        public AzureVmSize VmSize;
        
    }

    /**
     * Gets credentials to the container registry where game developers can upload custom container images to before creating a
     * new build.
     */
    public static class GetContainerRegistryCredentialsRequest {
        
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
    public static class GetMatchmakingTicketRequest {
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
        /** The reason why the current ticket was canceled. This field is only set if the ticket is in canceled state. */
        public CancellationReason CancellationReason;
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
        /** The guid string build ID of the multiplayer server to get details for. */
        public String BuildId;
        /** The region the multiplayer server is located in to get details for. */
        public AzureRegion Region;
        /**
         * The title generated guid string session ID of the multiplayer server to get details for. This is to keep track of
         * multiplayer server sessions.
         */
        public String SessionId;
        
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
        public AzureRegion Region;
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
     * Returns the matchmaking statistics for a queue. These include the number of players matching and the statistics related
     * to the time to match statistics in seconds (average and percentiles). Statistics are refreshed once every 5 minutes.
     * Servers can access all statistics no matter what the ClientStatisticsVisibility is configured to. Clients can access
     * statistics according to the ClientStatisticsVisibility. Client requests are forbidden if all visibility fields are
     * false.
     */
    public static class GetQueueStatisticsRequest {
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
        /** The region of the multiplayer server to get remote login information for. */
        public AzureRegion Region;
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
     * Gets the status of whether a title is enabled for the multiplayer server feature. The enabled status can be
     * Initializing, Enabled, and Disabled.
     */
    public static class GetTitleEnabledForMultiplayerServersStatusRequest {
        
    }

    public static class GetTitleEnabledForMultiplayerServersStatusResponse {
        /** The enabled status for the multiplayer server features for the title. */
        public TitleMultiplayerServerEnabledStatus Status;
        
    }

    /** Gets the quotas for a title in relation to multiplayer servers. */
    public static class GetTitleMultiplayerServersQuotasRequest {
        
    }

    public static class GetTitleMultiplayerServersQuotasResponse {
        /** The various quotas for multiplayer servers for the title. */
        public TitleMultiplayerServersQuotas Quotas;
        
    }

    /**
     * Add the player to a matchmaking ticket and specify all of its matchmaking attributes. Players can join a ticket if and
     * only if their EntityKeys are already listed in the ticket's Members list. The matchmaking service automatically starts
     * matching the ticket against other matchmaking tickets once all players have joined the ticket. It is not possible to
     * join a ticket once it has started matching.
     */
    public static class JoinMatchmakingTicketRequest {
        /** The User who wants to join the ticket. Their Id must be listed in PlayFabIdsToMatchWith. */
        public MatchmakingPlayer Member;
        /** The name of the queue to join. */
        public String QueueName;
        /** The Id of the ticket to find a match for. */
        public String TicketId;
        
    }

    public static class JoinMatchmakingTicketResult {
        
    }

    /** Returns a list of multiplayer server game asset summaries for a title. */
    public static class ListAssetSummariesRequest {
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
    public static class ListBuildSummariesRequest {
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
        /** The container images we want to list tags for. */
        public String ImageName;
        
    }

    public static class ListContainerImageTagsResponse {
        /** The list of tags for a particular container image. */
        public ArrayList<String> Tags;
        
    }

    /**
     * If the caller is a title, the EntityKey in the request is required. If the caller is a player, then it is optional. If
     * it is provided it must match the caller's entity.
     */
    public static class ListMatchmakingTicketsForPlayerRequest {
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
        /** The page size for the request. */
        public Integer PageSize;
        /** The region the multiplayer servers to list. */
        public AzureRegion Region;
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

    /** Returns a list of quality of service servers. */
    public static class ListQosServersRequest {
        
    }

    public static class ListQosServersResponse {
        /** The page size on the response. */
        public Integer PageSize;
        /** The list of QoS servers. */
        public ArrayList<QosServer> QosServers;
        /** The skip token for the paged response. */
        public String SkipToken;
        
    }

    /** Returns a list of virtual machines for a title. */
    public static class ListVirtualMachineSummariesRequest {
        /** The guid string build ID of the virtual machines to list. */
        public String BuildId;
        /** The page size for the request. */
        public Integer PageSize;
        /** The region of the virtual machines to list. */
        public AzureRegion Region;
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

    public static class MultiplayerServerSummary {
        /** The connected players in the multiplayer server. */
        public ArrayList<ConnectedPlayer> ConnectedPlayers;
        /** The time (UTC) at which a change in the multiplayer server state was observed. */
        public Date LastStateTransitionTime;
        /** The region the multiplayer server is located in. */
        public AzureRegion Region;
        /** The string server ID of the multiplayer server generated by PlayFab. */
        public String ServerId;
        /** The title generated guid string session ID of the multiplayer server. */
        public String SessionId;
        /** The state of the multiplayer server. */
        public String State;
        /** The virtual machine ID that the multiplayer server is located on. */
        public String VmId;
        
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
        public AzureRegion Region;
        /** The QoS server URL. */
        public String ServerUrl;
        
    }

    /** Requests a multiplayer server session from a particular build in any of the given preferred regions. */
    public static class RequestMultiplayerServerRequest {
        /** The guid string build ID of the multiplayer server to request. */
        public String BuildId;
        /**
         * Initial list of players (potentially matchmade) allowed to connect to the game. This list is passed to the game server
         * when requested (via GSDK) and can be used to validate players connecting to it.
         */
        public ArrayList<String> InitialPlayers;
        /**
         * The preferred regions to request a multiplayer server from. The Multiplayer Service will iterate through the regions in
         * the specified order and allocate a server from the first one that has servers available.
         */
        public ArrayList<AzureRegion> PreferredRegions;
        /**
         * Data encoded as a string that is passed to the game server when requested. This can be used to to communicate
         * information such as game mode or map through the request flow.
         */
        public String SessionCookie;
        /** A guid string session ID created track the multiplayer server session over its life. */
        public String SessionId;
        
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
        public AzureRegion Region;
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
    public static class RolloverContainerRegistryCredentialsRequest {
        
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

    /**
     * Executes the shutdown callback from the GSDK and terminates the multiplayer server session. The callback in the GSDK
     * will allow for graceful shutdown with a 15 minute timeoutIf graceful shutdown has not been completed before 15 minutes
     * have elapsed, the multiplayer server session will be forcefully terminated on it's own.
     */
    public static class ShutdownMultiplayerServerRequest {
        /** The guid string build ID of the multiplayer server to delete. */
        public String BuildId;
        /** The region of the multiplayer server to shut down. */
        public AzureRegion Region;
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

    public static enum TitleMultiplayerServerEnabledStatus {
        Initializing,
        Enabled,
        Disabled
    }

    public static class TitleMultiplayerServersQuotas {
        /** The core capacity for the various regions and VM Family */
        public ArrayList<CoreCapacity> CoreCapacities;
        
    }

    /** Updates a multiplayer server build's regions. */
    public static class UpdateBuildRegionsRequest {
        /** The guid string ID of the build we want to update regions for. */
        public String BuildId;
        /** The updated region configuration that should be applied to the specified build. */
        public ArrayList<BuildRegionParams> BuildRegions;
        
    }

    /** Uploads a multiplayer server game certificate. */
    public static class UploadCertificateRequest {
        /** The game certificate to upload. */
        public Certificate GameCertificate;
        
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
