package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabCloudScriptModels {

    @Deprecated
    public static class AdCampaignAttributionModel {
        /** UTC time stamp of attribution */
        @Deprecated
        public Date AttributedAt;
        /** Attribution campaign identifier */
        @Deprecated
        public String CampaignId;
        /** Attribution network name */
        @Deprecated
        public String Platform;
        
    }

    @Deprecated
    public static enum CloudScriptRevisionOption {
        Live,
        Latest,
        Specific
    }

    @Deprecated
    public static class ContactEmailInfoModel {
        /** The email address */
        @Deprecated
        public String EmailAddress;
        /** The name of the email info data */
        @Deprecated
        public String Name;
        /** The verification status of the email */
        @Deprecated
        public EmailVerificationStatus VerificationStatus;
        
    }

    @Deprecated
    public static enum ContinentCode {
        AF,
        AN,
        AS,
        EU,
        NA,
        OC,
        SA,
        Unknown
    }

    @Deprecated
    public static enum CountryCode {
        AF,
        AX,
        AL,
        DZ,
        AS,
        AD,
        AO,
        AI,
        AQ,
        AG,
        AR,
        AM,
        AW,
        AU,
        AT,
        AZ,
        BS,
        BH,
        BD,
        BB,
        BY,
        BE,
        BZ,
        BJ,
        BM,
        BT,
        BO,
        BQ,
        BA,
        BW,
        BV,
        BR,
        IO,
        BN,
        BG,
        BF,
        BI,
        KH,
        CM,
        CA,
        CV,
        KY,
        CF,
        TD,
        CL,
        CN,
        CX,
        CC,
        CO,
        KM,
        CG,
        CD,
        CK,
        CR,
        CI,
        HR,
        CU,
        CW,
        CY,
        CZ,
        DK,
        DJ,
        DM,
        DO,
        EC,
        EG,
        SV,
        GQ,
        ER,
        EE,
        ET,
        FK,
        FO,
        FJ,
        FI,
        FR,
        GF,
        PF,
        TF,
        GA,
        GM,
        GE,
        DE,
        GH,
        GI,
        GR,
        GL,
        GD,
        GP,
        GU,
        GT,
        GG,
        GN,
        GW,
        GY,
        HT,
        HM,
        VA,
        HN,
        HK,
        HU,
        IS,
        IN,
        ID,
        IR,
        IQ,
        IE,
        IM,
        IL,
        IT,
        JM,
        JP,
        JE,
        JO,
        KZ,
        KE,
        KI,
        KP,
        KR,
        KW,
        KG,
        LA,
        LV,
        LB,
        LS,
        LR,
        LY,
        LI,
        LT,
        LU,
        MO,
        MK,
        MG,
        MW,
        MY,
        MV,
        ML,
        MT,
        MH,
        MQ,
        MR,
        MU,
        YT,
        MX,
        FM,
        MD,
        MC,
        MN,
        ME,
        MS,
        MA,
        MZ,
        MM,
        NA,
        NR,
        NP,
        NL,
        NC,
        NZ,
        NI,
        NE,
        NG,
        NU,
        NF,
        MP,
        NO,
        OM,
        PK,
        PW,
        PS,
        PA,
        PG,
        PY,
        PE,
        PH,
        PN,
        PL,
        PT,
        PR,
        QA,
        RE,
        RO,
        RU,
        RW,
        BL,
        SH,
        KN,
        LC,
        MF,
        PM,
        VC,
        WS,
        SM,
        ST,
        SA,
        SN,
        RS,
        SC,
        SL,
        SG,
        SX,
        SK,
        SI,
        SB,
        SO,
        ZA,
        GS,
        SS,
        ES,
        LK,
        SD,
        SR,
        SJ,
        SZ,
        SE,
        CH,
        SY,
        TW,
        TJ,
        TZ,
        TH,
        TL,
        TG,
        TK,
        TO,
        TT,
        TN,
        TR,
        TM,
        TC,
        TV,
        UG,
        UA,
        AE,
        GB,
        US,
        UM,
        UY,
        UZ,
        VU,
        VE,
        VN,
        VG,
        VI,
        WF,
        EH,
        YE,
        ZM,
        ZW,
        Unknown
    }

    @Deprecated
    public static enum EmailVerificationStatus {
        Unverified,
        Pending,
        Confirmed
    }

    @Deprecated
    public static class EmptyResult {
        
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
    public static class EventHubFunctionModel {
        /** The connection string for the event hub. */
        @Deprecated
        public String ConnectionString;
        /** The name of the event hub that triggers the Azure Function. */
        @Deprecated
        public String EventHubName;
        /** The name the function was registered under. */
        @Deprecated
        public String FunctionName;
        
    }

    @Deprecated
    public static class ExecuteCloudScriptResult {
        /** Number of PlayFab API requests issued by the CloudScript function */
        @Deprecated
        public Integer APIRequestsIssued;
        /** Information about the error, if any, that occurred during execution */
        @Deprecated
        public ScriptExecutionError Error;
        @Deprecated
        public Double ExecutionTimeSeconds;
        /** The name of the function that executed */
        @Deprecated
        public String FunctionName;
        /** The object returned from the CloudScript function, if any */
        @Deprecated
        public Object FunctionResult;
        /**
         * Flag indicating if the FunctionResult was too large and was subsequently dropped from this event. This only occurs if
         * the total event size is larger than 350KB.
         */
        @Deprecated
        public Boolean FunctionResultTooLarge;
        /** Number of external HTTP requests issued by the CloudScript function */
        @Deprecated
        public Integer HttpRequestsIssued;
        /**
         * Entries logged during the function execution. These include both entries logged in the function code using log.info()
         * and log.error() and error entries for API and HTTP request failures.
         */
        @Deprecated
        public ArrayList<LogStatement> Logs;
        /**
         * Flag indicating if the logs were too large and were subsequently dropped from this event. This only occurs if the total
         * event size is larger than 350KB after the FunctionResult was removed.
         */
        @Deprecated
        public Boolean LogsTooLarge;
        @Deprecated
        public Long MemoryConsumedBytes;
        /**
         * Processor time consumed while executing the function. This does not include time spent waiting on API calls or HTTP
         * requests.
         */
        @Deprecated
        public Double ProcessorTimeSeconds;
        /** The revision of the CloudScript that executed */
        @Deprecated
        public Integer Revision;
        
    }

    /** Executes CloudScript with the entity profile that is defined in the request. */
    @Deprecated
    public static class ExecuteEntityCloudScriptRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** The name of the CloudScript function to execute */
        @Deprecated
        public String FunctionName;
        /** Object that is passed in to the function as the first argument */
        @Deprecated
        public Object FunctionParameter;
        /**
         * Generate a 'entity_executed_cloudscript' PlayStream event containing the results of the function execution and other
         * contextual information. This event will show up in the PlayStream debugger console for the player in Game Manager.
         */
        @Deprecated
        public Boolean GeneratePlayStreamEvent;
        /**
         * Option for which revision of the CloudScript to execute. 'Latest' executes the most recently created revision, 'Live'
         * executes the current live, published revision, and 'Specific' executes the specified revision. The default value is
         * 'Specific', if the SpecificRevision parameter is specified, otherwise it is 'Live'.
         */
        @Deprecated
        public CloudScriptRevisionOption RevisionSelection;
        /** The specific revision to execute, when RevisionSelection is set to 'Specific' */
        @Deprecated
        public Integer SpecificRevision;
        
    }

    /** Executes an Azure Function with the profile of the entity that is defined in the request. */
    @Deprecated
    public static class ExecuteFunctionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The optional entity to perform this action on. Defaults to the currently logged in entity. */
        @Deprecated
        public EntityKey Entity;
        /** The name of the CloudScript function to execute */
        @Deprecated
        public String FunctionName;
        /** Object that is passed in to the function as the FunctionArgument field of the FunctionExecutionContext data structure */
        @Deprecated
        public Object FunctionParameter;
        /**
         * Generate a 'entity_executed_cloudscript_function' PlayStream event containing the results of the function execution and
         * other contextual information. This event will show up in the PlayStream debugger console for the player in Game Manager.
         */
        @Deprecated
        public Boolean GeneratePlayStreamEvent;
        
    }

    @Deprecated
    public static class ExecuteFunctionResult {
        /** Error from the CloudScript Azure Function. */
        @Deprecated
        public FunctionExecutionError Error;
        /** The amount of time the function took to execute */
        @Deprecated
        public Integer ExecutionTimeMilliseconds;
        /** The name of the function that executed */
        @Deprecated
        public String FunctionName;
        /** The object returned from the function, if any */
        @Deprecated
        public Object FunctionResult;
        /** Flag indicating if the FunctionResult was too large and was subsequently dropped from this event. */
        @Deprecated
        public Boolean FunctionResultTooLarge;
        
    }

    @Deprecated
    public static class FunctionExecutionError {
        /**
         * Error code, such as CloudScriptAzureFunctionsExecutionTimeLimitExceeded, CloudScriptAzureFunctionsArgumentSizeExceeded,
         * CloudScriptAzureFunctionsReturnSizeExceeded or CloudScriptAzureFunctionsHTTPRequestError
         */
        @Deprecated
        public String Error;
        /** Details about the error */
        @Deprecated
        public String Message;
        /** Point during the execution of the function at which the error occurred, if any */
        @Deprecated
        public String StackTrace;
        
    }

    @Deprecated
    public static class FunctionModel {
        /** The address of the function. */
        @Deprecated
        public String FunctionAddress;
        /** The name the function was registered under. */
        @Deprecated
        public String FunctionName;
        /** The trigger type for the function. */
        @Deprecated
        public String TriggerType;
        
    }

    @Deprecated
    public static class GetFunctionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the function to register */
        @Deprecated
        public String FunctionName;
        
    }

    @Deprecated
    public static class GetFunctionResult {
        /** The connection string for the storage account containing the queue for a queue trigger Azure Function. */
        @Deprecated
        public String ConnectionString;
        /** The URL to be invoked to execute an HTTP triggered function. */
        @Deprecated
        public String FunctionUrl;
        /** The name of the queue for a queue trigger Azure Function. */
        @Deprecated
        public String QueueName;
        /** The trigger type for the function. */
        @Deprecated
        public String TriggerType;
        
    }

    @Deprecated
    public static class HttpFunctionModel {
        /** The name the function was registered under. */
        @Deprecated
        public String FunctionName;
        /** The URL of the function. */
        @Deprecated
        public String FunctionUrl;
        
    }

    @Deprecated
    public static class LinkedPlatformAccountModel {
        /** Linked account email of the user on the platform, if available */
        @Deprecated
        public String Email;
        /** Authentication platform */
        @Deprecated
        public LoginIdentityProvider Platform;
        /** Unique account identifier of the user on the platform */
        @Deprecated
        public String PlatformUserId;
        /** Linked account username of the user on the platform, if available */
        @Deprecated
        public String Username;
        
    }

    @Deprecated
    public static class ListEventHubFunctionsResult {
        /** The list of EventHub triggered functions that are currently registered for the title. */
        @Deprecated
        public ArrayList<EventHubFunctionModel> Functions;
        
    }

    /**
     * A title can have many functions, ListHttpFunctions will return a list of all the currently registered HTTP triggered
     * functions for a given title.
     */
    @Deprecated
    public static class ListFunctionsRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        
    }

    @Deprecated
    public static class ListFunctionsResult {
        /** The list of functions that are currently registered for the title. */
        @Deprecated
        public ArrayList<FunctionModel> Functions;
        
    }

    @Deprecated
    public static class ListHttpFunctionsResult {
        /** The list of HTTP triggered functions that are currently registered for the title. */
        @Deprecated
        public ArrayList<HttpFunctionModel> Functions;
        
    }

    @Deprecated
    public static class ListQueuedFunctionsResult {
        /** The list of Queue triggered functions that are currently registered for the title. */
        @Deprecated
        public ArrayList<QueuedFunctionModel> Functions;
        
    }

    @Deprecated
    public static class LocationModel {
        /** City name. */
        @Deprecated
        public String City;
        /** The two-character continent code for this location */
        @Deprecated
        public ContinentCode ContinentCode;
        /** The two-character ISO 3166-1 country code for the country associated with the location */
        @Deprecated
        public CountryCode CountryCode;
        /** Latitude coordinate of the geographic location. */
        @Deprecated
        public Double Latitude;
        /** Longitude coordinate of the geographic location. */
        @Deprecated
        public Double Longitude;
        
    }

    @Deprecated
    public static enum LoginIdentityProvider {
        Unknown,
        PlayFab,
        Custom,
        GameCenter,
        GooglePlay,
        Steam,
        XBoxLive,
        PSN,
        Kongregate,
        Facebook,
        IOSDevice,
        AndroidDevice,
        Twitch,
        WindowsHello,
        GameServer,
        CustomServer,
        NintendoSwitch,
        FacebookInstantGames,
        OpenIdConnect,
        Apple,
        NintendoSwitchAccount,
        GooglePlayGames,
        XboxMobileStore,
        King
    }

    @Deprecated
    public static class LogStatement {
        /** Optional object accompanying the message as contextual information */
        @Deprecated
        public Object Data;
        /** 'Debug', 'Info', or 'Error' */
        @Deprecated
        public String Level;
        @Deprecated
        public String Message;
        
    }

    @Deprecated
    public static class MembershipModel {
        /** Whether this membership is active. That is, whether the MembershipExpiration time has been reached. */
        @Deprecated
        public Boolean IsActive;
        /** The time this membership expires */
        @Deprecated
        public Date MembershipExpiration;
        /** The id of the membership */
        @Deprecated
        public String MembershipId;
        /**
         * Membership expirations can be explicitly overridden (via game manager or the admin api). If this membership has been
         * overridden, this will be the new expiration time.
         */
        @Deprecated
        public Date OverrideExpiration;
        /** The list of subscriptions that this player has for this membership */
        @Deprecated
        public ArrayList<SubscriptionModel> Subscriptions;
        
    }

    /**
     * Identifier by either name or ID. Note that a name may change due to renaming, or reused after being deleted. ID is
     * immutable and unique.
     */
    @Deprecated
    public static class NameIdentifier {
        /** Id Identifier, if present */
        @Deprecated
        public String Id;
        /** Name Identifier, if present */
        @Deprecated
        public String Name;
        
    }

    @Deprecated
    public static class PlayerProfileModel {
        /** List of advertising campaigns the player has been attributed to */
        @Deprecated
        public ArrayList<AdCampaignAttributionModel> AdCampaignAttributions;
        /** URL of the player's avatar image */
        @Deprecated
        public String AvatarUrl;
        /** If the player is currently banned, the UTC Date when the ban expires */
        @Deprecated
        public Date BannedUntil;
        /** List of all contact email info associated with the player account */
        @Deprecated
        public ArrayList<ContactEmailInfoModel> ContactEmailAddresses;
        /** Player record created */
        @Deprecated
        public Date Created;
        /** Player display name */
        @Deprecated
        public String DisplayName;
        /**
         * List of experiment variants for the player. Note that these variants are not guaranteed to be up-to-date when returned
         * during login because the player profile is updated only after login. Instead, use the LoginResult.TreatmentAssignment
         * property during login to get the correct variants and variables.
         */
        @Deprecated
        public ArrayList<String> ExperimentVariants;
        /** UTC time when the player most recently logged in to the title */
        @Deprecated
        public Date LastLogin;
        /** List of all authentication systems linked to this player account */
        @Deprecated
        public ArrayList<LinkedPlatformAccountModel> LinkedAccounts;
        /** List of geographic locations from which the player has logged in to the title */
        @Deprecated
        public ArrayList<LocationModel> Locations;
        /** List of memberships for the player, along with whether are expired. */
        @Deprecated
        public ArrayList<MembershipModel> Memberships;
        /** Player account origination */
        @Deprecated
        public LoginIdentityProvider Origination;
        /** PlayFab player account unique identifier */
        @Deprecated
        public String PlayerId;
        /** Publisher this player belongs to */
        @Deprecated
        public String PublisherId;
        /** List of configured end points registered for sending the player push notifications */
        @Deprecated
        public ArrayList<PushNotificationRegistrationModel> PushNotificationRegistrations;
        /** List of leaderboard statistic values for the player */
        @Deprecated
        public ArrayList<StatisticModel> Statistics;
        /** List of player's tags for segmentation */
        @Deprecated
        public ArrayList<TagModel> Tags;
        /** Title ID this player profile applies to */
        @Deprecated
        public String TitleId;
        /**
         * Sum of the player's purchases made with real-money currencies, converted to US dollars equivalent and represented as a
         * whole number of cents (1/100 USD). For example, 999 indicates nine dollars and ninety-nine cents.
         */
        @Deprecated
        public Long TotalValueToDateInUSD;
        /** List of the player's lifetime purchase totals, summed by real-money currency */
        @Deprecated
        public ArrayList<ValueToDateModel> ValuesToDate;
        
    }

    @Deprecated
    public static class PlayStreamEventEnvelopeModel {
        /** The ID of the entity the event is about. */
        @Deprecated
        public String EntityId;
        /** The type of the entity the event is about. */
        @Deprecated
        public String EntityType;
        /** Data specific to this event. */
        @Deprecated
        public String EventData;
        /** The name of the event. */
        @Deprecated
        public String EventName;
        /** The namespace of the event. */
        @Deprecated
        public String EventNamespace;
        /** Settings for the event. */
        @Deprecated
        public String EventSettings;
        
    }

    @Deprecated
    public static class PostFunctionResultForEntityTriggeredActionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The result of the function execution. */
        @Deprecated
        public ExecuteFunctionResult FunctionResult;
        
    }

    @Deprecated
    public static class PostFunctionResultForFunctionExecutionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The entity to perform this action on. */
        @Deprecated
        public EntityKey Entity;
        /** The result of the function execution. */
        @Deprecated
        public ExecuteFunctionResult FunctionResult;
        
    }

    @Deprecated
    public static class PostFunctionResultForPlayerTriggeredActionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The result of the function execution. */
        @Deprecated
        public ExecuteFunctionResult FunctionResult;
        /** The player profile the function was invoked with. */
        @Deprecated
        public PlayerProfileModel PlayerProfile;
        /** The triggering PlayStream event, if any, that caused the function to be invoked. */
        @Deprecated
        public PlayStreamEventEnvelopeModel PlayStreamEventEnvelope;
        
    }

    @Deprecated
    public static class PostFunctionResultForScheduledTaskRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The result of the function execution */
        @Deprecated
        public ExecuteFunctionResult FunctionResult;
        /** The id of the scheduled task that invoked the function. */
        @Deprecated
        public NameIdentifier ScheduledTaskId;
        
    }

    @Deprecated
    public static enum PushNotificationPlatform {
        ApplePushNotificationService,
        GoogleCloudMessaging
    }

    @Deprecated
    public static class PushNotificationRegistrationModel {
        /** Notification configured endpoint */
        @Deprecated
        public String NotificationEndpointARN;
        /** Push notification platform */
        @Deprecated
        public PushNotificationPlatform Platform;
        
    }

    @Deprecated
    public static class QueuedFunctionModel {
        /** The connection string for the Azure Storage Account that hosts the queue. */
        @Deprecated
        public String ConnectionString;
        /** The name the function was registered under. */
        @Deprecated
        public String FunctionName;
        /** The name of the queue that triggers the Azure Function. */
        @Deprecated
        public String QueueName;
        
    }

    /**
     * A title can have many functions, RegisterEventHubFunction associates a function name with an event hub name and
     * connection string.
     */
    @Deprecated
    public static class RegisterEventHubFunctionRequest {
        /** A connection string for the namespace of the event hub for the Azure Function. */
        @Deprecated
        public String ConnectionString;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the event hub for the Azure Function. */
        @Deprecated
        public String EventHubName;
        /** The name of the function to register */
        @Deprecated
        public String FunctionName;
        
    }

    @Deprecated
    public static class RegisterHttpFunctionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the function to register */
        @Deprecated
        public String FunctionName;
        /** Full URL for Azure Function that implements the function. */
        @Deprecated
        public String FunctionUrl;
        
    }

    /**
     * A title can have many functions, RegisterQueuedFunction associates a function name with a queue name and connection
     * string.
     */
    @Deprecated
    public static class RegisterQueuedFunctionRequest {
        /** A connection string for the storage account that hosts the queue for the Azure Function. */
        @Deprecated
        public String ConnectionString;
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the function to register */
        @Deprecated
        public String FunctionName;
        /** The name of the queue for the Azure Function. */
        @Deprecated
        public String QueueName;
        
    }

    @Deprecated
    public static class ScriptExecutionError {
        /**
         * Error code, such as CloudScriptNotFound, JavascriptException, CloudScriptFunctionArgumentSizeExceeded,
         * CloudScriptAPIRequestCountExceeded, CloudScriptAPIRequestError, or CloudScriptHTTPRequestError
         */
        @Deprecated
        public String Error;
        /** Details about the error */
        @Deprecated
        public String Message;
        /** Point during the execution of the script at which the error occurred, if any */
        @Deprecated
        public String StackTrace;
        
    }

    @Deprecated
    public static class StatisticModel {
        /** Statistic name */
        @Deprecated
        public String Name;
        /** Statistic value */
        @Deprecated
        public Integer Value;
        /** Statistic version (0 if not a versioned statistic) */
        @Deprecated
        public Integer Version;
        
    }

    @Deprecated
    public static class SubscriptionModel {
        /** When this subscription expires. */
        @Deprecated
        public Date Expiration;
        /** The time the subscription was orignially purchased */
        @Deprecated
        public Date InitialSubscriptionTime;
        /** Whether this subscription is currently active. That is, if Expiration &gt; now. */
        @Deprecated
        public Boolean IsActive;
        /** The status of this subscription, according to the subscription provider. */
        @Deprecated
        public SubscriptionProviderStatus Status;
        /** The id for this subscription */
        @Deprecated
        public String SubscriptionId;
        /** The item id for this subscription from the primary catalog */
        @Deprecated
        public String SubscriptionItemId;
        /** The provider for this subscription. Apple or Google Play are supported today. */
        @Deprecated
        public String SubscriptionProvider;
        
    }

    @Deprecated
    public static enum SubscriptionProviderStatus {
        NoError,
        Cancelled,
        UnknownError,
        BillingError,
        ProductUnavailable,
        CustomerDidNotAcceptPriceChange,
        FreeTrial,
        PaymentPending
    }

    @Deprecated
    public static class TagModel {
        /** Full value of the tag, including namespace */
        @Deprecated
        public String TagValue;
        
    }

    @Deprecated
    public static enum TriggerType {
        HTTP,
        Queue,
        EventHub
    }

    @Deprecated
    public static class UnregisterFunctionRequest {
        /** The optional custom tags associated with the request (e.g. build number, external trace identifiers, etc.). */
        @Deprecated
        public Map<String,String> CustomTags;
        /** The name of the function to register */
        @Deprecated
        public String FunctionName;
        
    }

    @Deprecated
    public static class ValueToDateModel {
        /** ISO 4217 code of the currency used in the purchases */
        @Deprecated
        public String Currency;
        /**
         * Total value of the purchases in a whole number of 1/100 monetary units. For example, 999 indicates nine dollars and
         * ninety-nine cents when Currency is 'USD')
         */
        @Deprecated
        public Long TotalValue;
        /**
         * Total value of the purchases in a string representation of decimal monetary units. For example, '9.99' indicates nine
         * dollars and ninety-nine cents when Currency is 'USD'.
         */
        @Deprecated
        public String TotalValueAsDecimal;
        
    }

}
