package com.playfab;

import java.util.*;
import com.playfab.PlayFabUtil.*;

public class PlayFabCloudScriptModels {

    public static enum CloudScriptRevisionOption {
        Live,
        Latest,
        Specific
    }

    /** Combined entity type and ID structure which uniquely identifies a single entity. */
    public static class EntityKey {
        /** Unique ID of the entity. */
        public String Id;
        /** Entity type. See https://api.playfab.com/docs/tutorials/entities/entitytypes */
        public String Type;
        
    }

    public static class ExecuteCloudScriptResult {
        /** Number of PlayFab API requests issued by the CloudScript function */
        public Integer APIRequestsIssued;
        /** Information about the error, if any, that occurred during execution */
        public ScriptExecutionError Error;
        public Double ExecutionTimeSeconds;
        /** The name of the function that executed */
        public String FunctionName;
        /** The object returned from the CloudScript function, if any */
        public Object FunctionResult;
        /**
         * Flag indicating if the FunctionResult was too large and was subsequently dropped from this event. This only occurs if
         * the total event size is larger than 350KB.
         */
        public Boolean FunctionResultTooLarge;
        /** Number of external HTTP requests issued by the CloudScript function */
        public Integer HttpRequestsIssued;
        /**
         * Entries logged during the function execution. These include both entries logged in the function code using log.info()
         * and log.error() and error entries for API and HTTP request failures.
         */
        public ArrayList<LogStatement> Logs;
        /**
         * Flag indicating if the logs were too large and were subsequently dropped from this event. This only occurs if the total
         * event size is larger than 350KB after the FunctionResult was removed.
         */
        public Boolean LogsTooLarge;
        public Long MemoryConsumedBytes;
        /**
         * Processor time consumed while executing the function. This does not include time spent waiting on API calls or HTTP
         * requests.
         */
        public Double ProcessorTimeSeconds;
        /** The revision of the CloudScript that executed */
        public Integer Revision;
        
    }

    /** Executes CloudScript with the entity profile that is defined in the request. */
    public static class ExecuteEntityCloudScriptRequest {
        /** The entity to perform this action on. */
        public EntityKey Entity;
        /** The name of the CloudScript function to execute */
        public String FunctionName;
        /** Object that is passed in to the function as the first argument */
        public Object FunctionParameter;
        /**
         * Generate a 'entity_executed_cloudscript' PlayStream event containing the results of the function execution and other
         * contextual information. This event will show up in the PlayStream debugger console for the player in Game Manager.
         */
        public Boolean GeneratePlayStreamEvent;
        /**
         * Option for which revision of the CloudScript to execute. 'Latest' executes the most recently created revision, 'Live'
         * executes the current live, published revision, and 'Specific' executes the specified revision. The default value is
         * 'Specific', if the SpecificRevision parameter is specified, otherwise it is 'Live'.
         */
        public CloudScriptRevisionOption RevisionSelection;
        /** The specific revision to execute, when RevisionSelection is set to 'Specific' */
        public Integer SpecificRevision;
        
    }

    public static class LogStatement {
        /** Optional object accompanying the message as contextual information */
        public Object Data;
        /** 'Debug', 'Info', or 'Error' */
        public String Level;
        public String Message;
        
    }

    public static class ScriptExecutionError {
        /**
         * Error code, such as CloudScriptNotFound, JavascriptException, CloudScriptFunctionArgumentSizeExceeded,
         * CloudScriptAPIRequestCountExceeded, CloudScriptAPIRequestError, or CloudScriptHTTPRequestError
         */
        public String Error;
        /** Details about the error */
        public String Message;
        /** Point during the execution of the script at which the error occurred, if any */
        public String StackTrace;
        
    }

}
