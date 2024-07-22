package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabEconomyModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** API methods for managing the catalog. Inventory manages in-game assets for any given entity. */
public class PlayFabEconomyAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Add inventory items. Up to 10,000 stacks of items can be added to a single inventory collection. Stack size is uncapped.
     * @param request AddInventoryItemsRequest
     * @return Async Task will return AddInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<AddInventoryItemsResponse>> AddInventoryItemsAsync(final AddInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddInventoryItemsResponse>>() {
            public PlayFabResult<AddInventoryItemsResponse> call() throws Exception {
                return privateAddInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Add inventory items. Up to 10,000 stacks of items can be added to a single inventory collection. Stack size is uncapped.
     * @param request AddInventoryItemsRequest
     * @return AddInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<AddInventoryItemsResponse> AddInventoryItems(final AddInventoryItemsRequest request) {
        FutureTask<PlayFabResult<AddInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<AddInventoryItemsResponse>>() {
            public PlayFabResult<AddInventoryItemsResponse> call() throws Exception {
                return privateAddInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<AddInventoryItemsResponse> exceptionResult = new PlayFabResult<AddInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Add inventory items. Up to 10,000 stacks of items can be added to a single inventory collection. Stack size is uncapped. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<AddInventoryItemsResponse> privateAddInventoryItemsAsync(final AddInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/AddInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<AddInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddInventoryItemsResponse>>(){}.getType());
        AddInventoryItemsResponse result = resultData.data;

        PlayFabResult<AddInventoryItemsResponse> pfResult = new PlayFabResult<AddInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates a new item in the working catalog using provided metadata.
     * @param request CreateDraftItemRequest
     * @return Async Task will return CreateDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateDraftItemResponse>> CreateDraftItemAsync(final CreateDraftItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateDraftItemResponse>>() {
            public PlayFabResult<CreateDraftItemResponse> call() throws Exception {
                return privateCreateDraftItemAsync(request);
            }
        });
    }

    /**
     * Creates a new item in the working catalog using provided metadata.
     * @param request CreateDraftItemRequest
     * @return CreateDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateDraftItemResponse> CreateDraftItem(final CreateDraftItemRequest request) {
        FutureTask<PlayFabResult<CreateDraftItemResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateDraftItemResponse>>() {
            public PlayFabResult<CreateDraftItemResponse> call() throws Exception {
                return privateCreateDraftItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateDraftItemResponse> exceptionResult = new PlayFabResult<CreateDraftItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a new item in the working catalog using provided metadata. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateDraftItemResponse> privateCreateDraftItemAsync(final CreateDraftItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/CreateDraftItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateDraftItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateDraftItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateDraftItemResponse>>(){}.getType());
        CreateDraftItemResponse result = resultData.data;

        PlayFabResult<CreateDraftItemResponse> pfResult = new PlayFabResult<CreateDraftItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates one or more upload URLs which can be used by the client to upload raw file data. Content URls and uploaded
     * content will be garbage collected after 24 hours if not attached to a draft or published item. Detailed pricing info
     * around uploading content can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/pricing/meters/catalog-meters
     * @param request CreateUploadUrlsRequest
     * @return Async Task will return CreateUploadUrlsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateUploadUrlsResponse>> CreateUploadUrlsAsync(final CreateUploadUrlsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateUploadUrlsResponse>>() {
            public PlayFabResult<CreateUploadUrlsResponse> call() throws Exception {
                return privateCreateUploadUrlsAsync(request);
            }
        });
    }

    /**
     * Creates one or more upload URLs which can be used by the client to upload raw file data. Content URls and uploaded
     * content will be garbage collected after 24 hours if not attached to a draft or published item. Detailed pricing info
     * around uploading content can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/pricing/meters/catalog-meters
     * @param request CreateUploadUrlsRequest
     * @return CreateUploadUrlsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateUploadUrlsResponse> CreateUploadUrls(final CreateUploadUrlsRequest request) {
        FutureTask<PlayFabResult<CreateUploadUrlsResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateUploadUrlsResponse>>() {
            public PlayFabResult<CreateUploadUrlsResponse> call() throws Exception {
                return privateCreateUploadUrlsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateUploadUrlsResponse> exceptionResult = new PlayFabResult<CreateUploadUrlsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Creates one or more upload URLs which can be used by the client to upload raw file data. Content URls and uploaded
     * content will be garbage collected after 24 hours if not attached to a draft or published item. Detailed pricing info
     * around uploading content can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/pricing/meters/catalog-meters
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateUploadUrlsResponse> privateCreateUploadUrlsAsync(final CreateUploadUrlsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/CreateUploadUrls"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateUploadUrlsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateUploadUrlsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateUploadUrlsResponse>>(){}.getType());
        CreateUploadUrlsResponse result = resultData.data;

        PlayFabResult<CreateUploadUrlsResponse> pfResult = new PlayFabResult<CreateUploadUrlsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes all reviews, helpfulness votes, and ratings submitted by the entity specified.
     * @param request DeleteEntityItemReviewsRequest
     * @return Async Task will return DeleteEntityItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteEntityItemReviewsResponse>> DeleteEntityItemReviewsAsync(final DeleteEntityItemReviewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteEntityItemReviewsResponse>>() {
            public PlayFabResult<DeleteEntityItemReviewsResponse> call() throws Exception {
                return privateDeleteEntityItemReviewsAsync(request);
            }
        });
    }

    /**
     * Deletes all reviews, helpfulness votes, and ratings submitted by the entity specified.
     * @param request DeleteEntityItemReviewsRequest
     * @return DeleteEntityItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteEntityItemReviewsResponse> DeleteEntityItemReviews(final DeleteEntityItemReviewsRequest request) {
        FutureTask<PlayFabResult<DeleteEntityItemReviewsResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteEntityItemReviewsResponse>>() {
            public PlayFabResult<DeleteEntityItemReviewsResponse> call() throws Exception {
                return privateDeleteEntityItemReviewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteEntityItemReviewsResponse> exceptionResult = new PlayFabResult<DeleteEntityItemReviewsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes all reviews, helpfulness votes, and ratings submitted by the entity specified. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteEntityItemReviewsResponse> privateDeleteEntityItemReviewsAsync(final DeleteEntityItemReviewsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/DeleteEntityItemReviews"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteEntityItemReviewsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteEntityItemReviewsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteEntityItemReviewsResponse>>(){}.getType());
        DeleteEntityItemReviewsResponse result = resultData.data;

        PlayFabResult<DeleteEntityItemReviewsResponse> pfResult = new PlayFabResult<DeleteEntityItemReviewsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Delete an Inventory Collection. More information about Inventory Collections can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/inventory/collections
     * @param request DeleteInventoryCollectionRequest
     * @return Async Task will return DeleteInventoryCollectionResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteInventoryCollectionResponse>> DeleteInventoryCollectionAsync(final DeleteInventoryCollectionRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteInventoryCollectionResponse>>() {
            public PlayFabResult<DeleteInventoryCollectionResponse> call() throws Exception {
                return privateDeleteInventoryCollectionAsync(request);
            }
        });
    }

    /**
     * Delete an Inventory Collection. More information about Inventory Collections can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/inventory/collections
     * @param request DeleteInventoryCollectionRequest
     * @return DeleteInventoryCollectionResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteInventoryCollectionResponse> DeleteInventoryCollection(final DeleteInventoryCollectionRequest request) {
        FutureTask<PlayFabResult<DeleteInventoryCollectionResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteInventoryCollectionResponse>>() {
            public PlayFabResult<DeleteInventoryCollectionResponse> call() throws Exception {
                return privateDeleteInventoryCollectionAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteInventoryCollectionResponse> exceptionResult = new PlayFabResult<DeleteInventoryCollectionResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Delete an Inventory Collection. More information about Inventory Collections can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/inventory/collections
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteInventoryCollectionResponse> privateDeleteInventoryCollectionAsync(final DeleteInventoryCollectionRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/DeleteInventoryCollection"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteInventoryCollectionResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteInventoryCollectionResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteInventoryCollectionResponse>>(){}.getType());
        DeleteInventoryCollectionResponse result = resultData.data;

        PlayFabResult<DeleteInventoryCollectionResponse> pfResult = new PlayFabResult<DeleteInventoryCollectionResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Delete inventory items
     * @param request DeleteInventoryItemsRequest
     * @return Async Task will return DeleteInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteInventoryItemsResponse>> DeleteInventoryItemsAsync(final DeleteInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteInventoryItemsResponse>>() {
            public PlayFabResult<DeleteInventoryItemsResponse> call() throws Exception {
                return privateDeleteInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Delete inventory items
     * @param request DeleteInventoryItemsRequest
     * @return DeleteInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteInventoryItemsResponse> DeleteInventoryItems(final DeleteInventoryItemsRequest request) {
        FutureTask<PlayFabResult<DeleteInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteInventoryItemsResponse>>() {
            public PlayFabResult<DeleteInventoryItemsResponse> call() throws Exception {
                return privateDeleteInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteInventoryItemsResponse> exceptionResult = new PlayFabResult<DeleteInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Delete inventory items */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteInventoryItemsResponse> privateDeleteInventoryItemsAsync(final DeleteInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/DeleteInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteInventoryItemsResponse>>(){}.getType());
        DeleteInventoryItemsResponse result = resultData.data;

        PlayFabResult<DeleteInventoryItemsResponse> pfResult = new PlayFabResult<DeleteInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes an item from working catalog and all published versions from the public catalog.
     * @param request DeleteItemRequest
     * @return Async Task will return DeleteItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteItemResponse>> DeleteItemAsync(final DeleteItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteItemResponse>>() {
            public PlayFabResult<DeleteItemResponse> call() throws Exception {
                return privateDeleteItemAsync(request);
            }
        });
    }

    /**
     * Removes an item from working catalog and all published versions from the public catalog.
     * @param request DeleteItemRequest
     * @return DeleteItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteItemResponse> DeleteItem(final DeleteItemRequest request) {
        FutureTask<PlayFabResult<DeleteItemResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteItemResponse>>() {
            public PlayFabResult<DeleteItemResponse> call() throws Exception {
                return privateDeleteItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteItemResponse> exceptionResult = new PlayFabResult<DeleteItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Removes an item from working catalog and all published versions from the public catalog. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteItemResponse> privateDeleteItemAsync(final DeleteItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/DeleteItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteItemResponse>>(){}.getType());
        DeleteItemResponse result = resultData.data;

        PlayFabResult<DeleteItemResponse> pfResult = new PlayFabResult<DeleteItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Execute a list of Inventory Operations. A maximum list of 50 operations can be performed by a single request. There is
     * also a limit to 300 items that can be modified/added in a single request. For example, adding a bundle with 50 items
     * counts as 50 items modified. All operations must be done within a single inventory collection. This API has a reduced
     * RPS compared to an individual inventory operation with Player Entities limited to 60 requests in 90 seconds.
     * @param request ExecuteInventoryOperationsRequest
     * @return Async Task will return ExecuteInventoryOperationsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ExecuteInventoryOperationsResponse>> ExecuteInventoryOperationsAsync(final ExecuteInventoryOperationsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ExecuteInventoryOperationsResponse>>() {
            public PlayFabResult<ExecuteInventoryOperationsResponse> call() throws Exception {
                return privateExecuteInventoryOperationsAsync(request);
            }
        });
    }

    /**
     * Execute a list of Inventory Operations. A maximum list of 50 operations can be performed by a single request. There is
     * also a limit to 300 items that can be modified/added in a single request. For example, adding a bundle with 50 items
     * counts as 50 items modified. All operations must be done within a single inventory collection. This API has a reduced
     * RPS compared to an individual inventory operation with Player Entities limited to 60 requests in 90 seconds.
     * @param request ExecuteInventoryOperationsRequest
     * @return ExecuteInventoryOperationsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ExecuteInventoryOperationsResponse> ExecuteInventoryOperations(final ExecuteInventoryOperationsRequest request) {
        FutureTask<PlayFabResult<ExecuteInventoryOperationsResponse>> task = new FutureTask(new Callable<PlayFabResult<ExecuteInventoryOperationsResponse>>() {
            public PlayFabResult<ExecuteInventoryOperationsResponse> call() throws Exception {
                return privateExecuteInventoryOperationsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ExecuteInventoryOperationsResponse> exceptionResult = new PlayFabResult<ExecuteInventoryOperationsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Execute a list of Inventory Operations. A maximum list of 50 operations can be performed by a single request. There is
     * also a limit to 300 items that can be modified/added in a single request. For example, adding a bundle with 50 items
     * counts as 50 items modified. All operations must be done within a single inventory collection. This API has a reduced
     * RPS compared to an individual inventory operation with Player Entities limited to 60 requests in 90 seconds.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ExecuteInventoryOperationsResponse> privateExecuteInventoryOperationsAsync(final ExecuteInventoryOperationsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/ExecuteInventoryOperations"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ExecuteInventoryOperationsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ExecuteInventoryOperationsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ExecuteInventoryOperationsResponse>>(){}.getType());
        ExecuteInventoryOperationsResponse result = resultData.data;

        PlayFabResult<ExecuteInventoryOperationsResponse> pfResult = new PlayFabResult<ExecuteInventoryOperationsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Transfer a list of inventory items. A maximum list of 50 operations can be performed by a single request. When the
     * response code is 202, one or more operations did not complete within the timeframe of the request. You can identify the
     * pending operations by looking for OperationStatus = 'InProgress'. You can check on the operation status at anytime
     * within 1 day of the request by passing the TransactionToken to the GetInventoryOperationStatus API.
     * @param request ExecuteTransferOperationsRequest
     * @return Async Task will return ExecuteTransferOperationsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ExecuteTransferOperationsResponse>> ExecuteTransferOperationsAsync(final ExecuteTransferOperationsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ExecuteTransferOperationsResponse>>() {
            public PlayFabResult<ExecuteTransferOperationsResponse> call() throws Exception {
                return privateExecuteTransferOperationsAsync(request);
            }
        });
    }

    /**
     * Transfer a list of inventory items. A maximum list of 50 operations can be performed by a single request. When the
     * response code is 202, one or more operations did not complete within the timeframe of the request. You can identify the
     * pending operations by looking for OperationStatus = 'InProgress'. You can check on the operation status at anytime
     * within 1 day of the request by passing the TransactionToken to the GetInventoryOperationStatus API.
     * @param request ExecuteTransferOperationsRequest
     * @return ExecuteTransferOperationsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ExecuteTransferOperationsResponse> ExecuteTransferOperations(final ExecuteTransferOperationsRequest request) {
        FutureTask<PlayFabResult<ExecuteTransferOperationsResponse>> task = new FutureTask(new Callable<PlayFabResult<ExecuteTransferOperationsResponse>>() {
            public PlayFabResult<ExecuteTransferOperationsResponse> call() throws Exception {
                return privateExecuteTransferOperationsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ExecuteTransferOperationsResponse> exceptionResult = new PlayFabResult<ExecuteTransferOperationsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Transfer a list of inventory items. A maximum list of 50 operations can be performed by a single request. When the
     * response code is 202, one or more operations did not complete within the timeframe of the request. You can identify the
     * pending operations by looking for OperationStatus = 'InProgress'. You can check on the operation status at anytime
     * within 1 day of the request by passing the TransactionToken to the GetInventoryOperationStatus API.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ExecuteTransferOperationsResponse> privateExecuteTransferOperationsAsync(final ExecuteTransferOperationsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/ExecuteTransferOperations"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ExecuteTransferOperationsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ExecuteTransferOperationsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ExecuteTransferOperationsResponse>>(){}.getType());
        ExecuteTransferOperationsResponse result = resultData.data;

        PlayFabResult<ExecuteTransferOperationsResponse> pfResult = new PlayFabResult<ExecuteTransferOperationsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the configuration for the catalog. Only Title Entities can call this API. There is a limit of 100 requests in 10
     * seconds for this API. More information about the Catalog Config can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/settings
     * @param request GetCatalogConfigRequest
     * @return Async Task will return GetCatalogConfigResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCatalogConfigResponse>> GetCatalogConfigAsync(final GetCatalogConfigRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCatalogConfigResponse>>() {
            public PlayFabResult<GetCatalogConfigResponse> call() throws Exception {
                return privateGetCatalogConfigAsync(request);
            }
        });
    }

    /**
     * Gets the configuration for the catalog. Only Title Entities can call this API. There is a limit of 100 requests in 10
     * seconds for this API. More information about the Catalog Config can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/settings
     * @param request GetCatalogConfigRequest
     * @return GetCatalogConfigResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCatalogConfigResponse> GetCatalogConfig(final GetCatalogConfigRequest request) {
        FutureTask<PlayFabResult<GetCatalogConfigResponse>> task = new FutureTask(new Callable<PlayFabResult<GetCatalogConfigResponse>>() {
            public PlayFabResult<GetCatalogConfigResponse> call() throws Exception {
                return privateGetCatalogConfigAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCatalogConfigResponse> exceptionResult = new PlayFabResult<GetCatalogConfigResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Gets the configuration for the catalog. Only Title Entities can call this API. There is a limit of 100 requests in 10
     * seconds for this API. More information about the Catalog Config can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/settings
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCatalogConfigResponse> privateGetCatalogConfigAsync(final GetCatalogConfigRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetCatalogConfig"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCatalogConfigResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetCatalogConfigResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCatalogConfigResponse>>(){}.getType());
        GetCatalogConfigResponse result = resultData.data;

        PlayFabResult<GetCatalogConfigResponse> pfResult = new PlayFabResult<GetCatalogConfigResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves an item from the working catalog. This item represents the current working state of the item. GetDraftItem
     * does not work off a cache of the Catalog and should be used when trying to get recent item updates. However, please note
     * that item references data is cached and may take a few moments for changes to propagate.
     * @param request GetDraftItemRequest
     * @return Async Task will return GetDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetDraftItemResponse>> GetDraftItemAsync(final GetDraftItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetDraftItemResponse>>() {
            public PlayFabResult<GetDraftItemResponse> call() throws Exception {
                return privateGetDraftItemAsync(request);
            }
        });
    }

    /**
     * Retrieves an item from the working catalog. This item represents the current working state of the item. GetDraftItem
     * does not work off a cache of the Catalog and should be used when trying to get recent item updates. However, please note
     * that item references data is cached and may take a few moments for changes to propagate.
     * @param request GetDraftItemRequest
     * @return GetDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetDraftItemResponse> GetDraftItem(final GetDraftItemRequest request) {
        FutureTask<PlayFabResult<GetDraftItemResponse>> task = new FutureTask(new Callable<PlayFabResult<GetDraftItemResponse>>() {
            public PlayFabResult<GetDraftItemResponse> call() throws Exception {
                return privateGetDraftItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetDraftItemResponse> exceptionResult = new PlayFabResult<GetDraftItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves an item from the working catalog. This item represents the current working state of the item. GetDraftItem
     * does not work off a cache of the Catalog and should be used when trying to get recent item updates. However, please note
     * that item references data is cached and may take a few moments for changes to propagate.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetDraftItemResponse> privateGetDraftItemAsync(final GetDraftItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetDraftItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetDraftItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetDraftItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetDraftItemResponse>>(){}.getType());
        GetDraftItemResponse result = resultData.data;

        PlayFabResult<GetDraftItemResponse> pfResult = new PlayFabResult<GetDraftItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog. Up to 50 IDs can be retrieved in a single request.
     * GetDraftItems does not work off a cache of the Catalog and should be used when trying to get recent item updates.
     * @param request GetDraftItemsRequest
     * @return Async Task will return GetDraftItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetDraftItemsResponse>> GetDraftItemsAsync(final GetDraftItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetDraftItemsResponse>>() {
            public PlayFabResult<GetDraftItemsResponse> call() throws Exception {
                return privateGetDraftItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog. Up to 50 IDs can be retrieved in a single request.
     * GetDraftItems does not work off a cache of the Catalog and should be used when trying to get recent item updates.
     * @param request GetDraftItemsRequest
     * @return GetDraftItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetDraftItemsResponse> GetDraftItems(final GetDraftItemsRequest request) {
        FutureTask<PlayFabResult<GetDraftItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetDraftItemsResponse>>() {
            public PlayFabResult<GetDraftItemsResponse> call() throws Exception {
                return privateGetDraftItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetDraftItemsResponse> exceptionResult = new PlayFabResult<GetDraftItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog. Up to 50 IDs can be retrieved in a single request.
     * GetDraftItems does not work off a cache of the Catalog and should be used when trying to get recent item updates.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetDraftItemsResponse> privateGetDraftItemsAsync(final GetDraftItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetDraftItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetDraftItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetDraftItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetDraftItemsResponse>>(){}.getType());
        GetDraftItemsResponse result = resultData.data;

        PlayFabResult<GetDraftItemsResponse> pfResult = new PlayFabResult<GetDraftItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog created by the Entity. Up to 50 items can be returned at
     * once. You can use continuation tokens to paginate through results that return greater than the limit.
     * GetEntityDraftItems does not work off a cache of the Catalog and should be used when trying to get recent item updates.
     * @param request GetEntityDraftItemsRequest
     * @return Async Task will return GetEntityDraftItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityDraftItemsResponse>> GetEntityDraftItemsAsync(final GetEntityDraftItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityDraftItemsResponse>>() {
            public PlayFabResult<GetEntityDraftItemsResponse> call() throws Exception {
                return privateGetEntityDraftItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog created by the Entity. Up to 50 items can be returned at
     * once. You can use continuation tokens to paginate through results that return greater than the limit.
     * GetEntityDraftItems does not work off a cache of the Catalog and should be used when trying to get recent item updates.
     * @param request GetEntityDraftItemsRequest
     * @return GetEntityDraftItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityDraftItemsResponse> GetEntityDraftItems(final GetEntityDraftItemsRequest request) {
        FutureTask<PlayFabResult<GetEntityDraftItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityDraftItemsResponse>>() {
            public PlayFabResult<GetEntityDraftItemsResponse> call() throws Exception {
                return privateGetEntityDraftItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetEntityDraftItemsResponse> exceptionResult = new PlayFabResult<GetEntityDraftItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog created by the Entity. Up to 50 items can be returned at
     * once. You can use continuation tokens to paginate through results that return greater than the limit.
     * GetEntityDraftItems does not work off a cache of the Catalog and should be used when trying to get recent item updates.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityDraftItemsResponse> privateGetEntityDraftItemsAsync(final GetEntityDraftItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetEntityDraftItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityDraftItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityDraftItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityDraftItemsResponse>>(){}.getType());
        GetEntityDraftItemsResponse result = resultData.data;

        PlayFabResult<GetEntityDraftItemsResponse> pfResult = new PlayFabResult<GetEntityDraftItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the submitted review for the specified item by the authenticated entity. Individual ratings and reviews data update
     * in near real time with delays within a few seconds.
     * @param request GetEntityItemReviewRequest
     * @return Async Task will return GetEntityItemReviewResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityItemReviewResponse>> GetEntityItemReviewAsync(final GetEntityItemReviewRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityItemReviewResponse>>() {
            public PlayFabResult<GetEntityItemReviewResponse> call() throws Exception {
                return privateGetEntityItemReviewAsync(request);
            }
        });
    }

    /**
     * Gets the submitted review for the specified item by the authenticated entity. Individual ratings and reviews data update
     * in near real time with delays within a few seconds.
     * @param request GetEntityItemReviewRequest
     * @return GetEntityItemReviewResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityItemReviewResponse> GetEntityItemReview(final GetEntityItemReviewRequest request) {
        FutureTask<PlayFabResult<GetEntityItemReviewResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityItemReviewResponse>>() {
            public PlayFabResult<GetEntityItemReviewResponse> call() throws Exception {
                return privateGetEntityItemReviewAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetEntityItemReviewResponse> exceptionResult = new PlayFabResult<GetEntityItemReviewResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Gets the submitted review for the specified item by the authenticated entity. Individual ratings and reviews data update
     * in near real time with delays within a few seconds.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityItemReviewResponse> privateGetEntityItemReviewAsync(final GetEntityItemReviewRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetEntityItemReview"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityItemReviewResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityItemReviewResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityItemReviewResponse>>(){}.getType());
        GetEntityItemReviewResponse result = resultData.data;

        PlayFabResult<GetEntityItemReviewResponse> pfResult = new PlayFabResult<GetEntityItemReviewResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get Inventory Collection Ids. Up to 50 Ids can be returned at once (or 250 with response compression enabled). You can
     * use continuation tokens to paginate through results that return greater than the limit. It can take a few seconds for
     * new collection Ids to show up.
     * @param request GetInventoryCollectionIdsRequest
     * @return Async Task will return GetInventoryCollectionIdsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetInventoryCollectionIdsResponse>> GetInventoryCollectionIdsAsync(final GetInventoryCollectionIdsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetInventoryCollectionIdsResponse>>() {
            public PlayFabResult<GetInventoryCollectionIdsResponse> call() throws Exception {
                return privateGetInventoryCollectionIdsAsync(request);
            }
        });
    }

    /**
     * Get Inventory Collection Ids. Up to 50 Ids can be returned at once (or 250 with response compression enabled). You can
     * use continuation tokens to paginate through results that return greater than the limit. It can take a few seconds for
     * new collection Ids to show up.
     * @param request GetInventoryCollectionIdsRequest
     * @return GetInventoryCollectionIdsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetInventoryCollectionIdsResponse> GetInventoryCollectionIds(final GetInventoryCollectionIdsRequest request) {
        FutureTask<PlayFabResult<GetInventoryCollectionIdsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetInventoryCollectionIdsResponse>>() {
            public PlayFabResult<GetInventoryCollectionIdsResponse> call() throws Exception {
                return privateGetInventoryCollectionIdsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetInventoryCollectionIdsResponse> exceptionResult = new PlayFabResult<GetInventoryCollectionIdsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Get Inventory Collection Ids. Up to 50 Ids can be returned at once (or 250 with response compression enabled). You can
     * use continuation tokens to paginate through results that return greater than the limit. It can take a few seconds for
     * new collection Ids to show up.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetInventoryCollectionIdsResponse> privateGetInventoryCollectionIdsAsync(final GetInventoryCollectionIdsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/GetInventoryCollectionIds"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetInventoryCollectionIdsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetInventoryCollectionIdsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetInventoryCollectionIdsResponse>>(){}.getType());
        GetInventoryCollectionIdsResponse result = resultData.data;

        PlayFabResult<GetInventoryCollectionIdsResponse> pfResult = new PlayFabResult<GetInventoryCollectionIdsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get current inventory items.
     * @param request GetInventoryItemsRequest
     * @return Async Task will return GetInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetInventoryItemsResponse>> GetInventoryItemsAsync(final GetInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetInventoryItemsResponse>>() {
            public PlayFabResult<GetInventoryItemsResponse> call() throws Exception {
                return privateGetInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Get current inventory items.
     * @param request GetInventoryItemsRequest
     * @return GetInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetInventoryItemsResponse> GetInventoryItems(final GetInventoryItemsRequest request) {
        FutureTask<PlayFabResult<GetInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetInventoryItemsResponse>>() {
            public PlayFabResult<GetInventoryItemsResponse> call() throws Exception {
                return privateGetInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetInventoryItemsResponse> exceptionResult = new PlayFabResult<GetInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get current inventory items. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetInventoryItemsResponse> privateGetInventoryItemsAsync(final GetInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/GetInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetInventoryItemsResponse>>(){}.getType());
        GetInventoryItemsResponse result = resultData.data;

        PlayFabResult<GetInventoryItemsResponse> pfResult = new PlayFabResult<GetInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get the status of an inventory operation using an OperationToken. You can check on the operation status at anytime
     * within 1 day of the request by passing the TransactionToken to the this API.
     * @param request GetInventoryOperationStatusRequest
     * @return Async Task will return GetInventoryOperationStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetInventoryOperationStatusResponse>> GetInventoryOperationStatusAsync(final GetInventoryOperationStatusRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetInventoryOperationStatusResponse>>() {
            public PlayFabResult<GetInventoryOperationStatusResponse> call() throws Exception {
                return privateGetInventoryOperationStatusAsync(request);
            }
        });
    }

    /**
     * Get the status of an inventory operation using an OperationToken. You can check on the operation status at anytime
     * within 1 day of the request by passing the TransactionToken to the this API.
     * @param request GetInventoryOperationStatusRequest
     * @return GetInventoryOperationStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetInventoryOperationStatusResponse> GetInventoryOperationStatus(final GetInventoryOperationStatusRequest request) {
        FutureTask<PlayFabResult<GetInventoryOperationStatusResponse>> task = new FutureTask(new Callable<PlayFabResult<GetInventoryOperationStatusResponse>>() {
            public PlayFabResult<GetInventoryOperationStatusResponse> call() throws Exception {
                return privateGetInventoryOperationStatusAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetInventoryOperationStatusResponse> exceptionResult = new PlayFabResult<GetInventoryOperationStatusResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Get the status of an inventory operation using an OperationToken. You can check on the operation status at anytime
     * within 1 day of the request by passing the TransactionToken to the this API.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetInventoryOperationStatusResponse> privateGetInventoryOperationStatusAsync(final GetInventoryOperationStatusRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/GetInventoryOperationStatus"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetInventoryOperationStatusResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetInventoryOperationStatusResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetInventoryOperationStatusResponse>>(){}.getType());
        GetInventoryOperationStatusResponse result = resultData.data;

        PlayFabResult<GetInventoryOperationStatusResponse> pfResult = new PlayFabResult<GetInventoryOperationStatusResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves an item from the public catalog. GetItem does not work off a cache of the Catalog and should be used when
     * trying to get recent item updates. However, please note that item references data is cached and may take a few moments
     * for changes to propagate.
     * @param request GetItemRequest
     * @return Async Task will return GetItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemResponse>> GetItemAsync(final GetItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemResponse>>() {
            public PlayFabResult<GetItemResponse> call() throws Exception {
                return privateGetItemAsync(request);
            }
        });
    }

    /**
     * Retrieves an item from the public catalog. GetItem does not work off a cache of the Catalog and should be used when
     * trying to get recent item updates. However, please note that item references data is cached and may take a few moments
     * for changes to propagate.
     * @param request GetItemRequest
     * @return GetItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemResponse> GetItem(final GetItemRequest request) {
        FutureTask<PlayFabResult<GetItemResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemResponse>>() {
            public PlayFabResult<GetItemResponse> call() throws Exception {
                return privateGetItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemResponse> exceptionResult = new PlayFabResult<GetItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves an item from the public catalog. GetItem does not work off a cache of the Catalog and should be used when
     * trying to get recent item updates. However, please note that item references data is cached and may take a few moments
     * for changes to propagate.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemResponse> privateGetItemAsync(final GetItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemResponse>>(){}.getType());
        GetItemResponse result = resultData.data;

        PlayFabResult<GetItemResponse> pfResult = new PlayFabResult<GetItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Search for a given item and return a set of bundles and stores containing the item. Up to 50 items can be returned at
     * once. You can use continuation tokens to paginate through results that return greater than the limit. This API is
     * intended for tooling/automation scenarios and has a reduced RPS with Player Entities limited to 30 requests in 300
     * seconds and Title Entities limited to 100 requests in 10 seconds.
     * @param request GetItemContainersRequest
     * @return Async Task will return GetItemContainersResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemContainersResponse>> GetItemContainersAsync(final GetItemContainersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemContainersResponse>>() {
            public PlayFabResult<GetItemContainersResponse> call() throws Exception {
                return privateGetItemContainersAsync(request);
            }
        });
    }

    /**
     * Search for a given item and return a set of bundles and stores containing the item. Up to 50 items can be returned at
     * once. You can use continuation tokens to paginate through results that return greater than the limit. This API is
     * intended for tooling/automation scenarios and has a reduced RPS with Player Entities limited to 30 requests in 300
     * seconds and Title Entities limited to 100 requests in 10 seconds.
     * @param request GetItemContainersRequest
     * @return GetItemContainersResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemContainersResponse> GetItemContainers(final GetItemContainersRequest request) {
        FutureTask<PlayFabResult<GetItemContainersResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemContainersResponse>>() {
            public PlayFabResult<GetItemContainersResponse> call() throws Exception {
                return privateGetItemContainersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemContainersResponse> exceptionResult = new PlayFabResult<GetItemContainersResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Search for a given item and return a set of bundles and stores containing the item. Up to 50 items can be returned at
     * once. You can use continuation tokens to paginate through results that return greater than the limit. This API is
     * intended for tooling/automation scenarios and has a reduced RPS with Player Entities limited to 30 requests in 300
     * seconds and Title Entities limited to 100 requests in 10 seconds.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemContainersResponse> privateGetItemContainersAsync(final GetItemContainersRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItemContainers"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemContainersResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemContainersResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemContainersResponse>>(){}.getType());
        GetItemContainersResponse result = resultData.data;

        PlayFabResult<GetItemContainersResponse> pfResult = new PlayFabResult<GetItemContainersResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the moderation state for an item, including the concern category and string reason. More information about
     * moderation states can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/ugc/moderation
     * @param request GetItemModerationStateRequest
     * @return Async Task will return GetItemModerationStateResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemModerationStateResponse>> GetItemModerationStateAsync(final GetItemModerationStateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemModerationStateResponse>>() {
            public PlayFabResult<GetItemModerationStateResponse> call() throws Exception {
                return privateGetItemModerationStateAsync(request);
            }
        });
    }

    /**
     * Gets the moderation state for an item, including the concern category and string reason. More information about
     * moderation states can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/ugc/moderation
     * @param request GetItemModerationStateRequest
     * @return GetItemModerationStateResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemModerationStateResponse> GetItemModerationState(final GetItemModerationStateRequest request) {
        FutureTask<PlayFabResult<GetItemModerationStateResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemModerationStateResponse>>() {
            public PlayFabResult<GetItemModerationStateResponse> call() throws Exception {
                return privateGetItemModerationStateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemModerationStateResponse> exceptionResult = new PlayFabResult<GetItemModerationStateResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Gets the moderation state for an item, including the concern category and string reason. More information about
     * moderation states can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/ugc/moderation
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemModerationStateResponse> privateGetItemModerationStateAsync(final GetItemModerationStateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItemModerationState"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemModerationStateResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemModerationStateResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemModerationStateResponse>>(){}.getType());
        GetItemModerationStateResponse result = resultData.data;

        PlayFabResult<GetItemModerationStateResponse> pfResult = new PlayFabResult<GetItemModerationStateResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the status of a publish of an item.
     * @param request GetItemPublishStatusRequest
     * @return Async Task will return GetItemPublishStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemPublishStatusResponse>> GetItemPublishStatusAsync(final GetItemPublishStatusRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemPublishStatusResponse>>() {
            public PlayFabResult<GetItemPublishStatusResponse> call() throws Exception {
                return privateGetItemPublishStatusAsync(request);
            }
        });
    }

    /**
     * Gets the status of a publish of an item.
     * @param request GetItemPublishStatusRequest
     * @return GetItemPublishStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemPublishStatusResponse> GetItemPublishStatus(final GetItemPublishStatusRequest request) {
        FutureTask<PlayFabResult<GetItemPublishStatusResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemPublishStatusResponse>>() {
            public PlayFabResult<GetItemPublishStatusResponse> call() throws Exception {
                return privateGetItemPublishStatusAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemPublishStatusResponse> exceptionResult = new PlayFabResult<GetItemPublishStatusResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the status of a publish of an item. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemPublishStatusResponse> privateGetItemPublishStatusAsync(final GetItemPublishStatusRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItemPublishStatus"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemPublishStatusResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemPublishStatusResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemPublishStatusResponse>>(){}.getType());
        GetItemPublishStatusResponse result = resultData.data;

        PlayFabResult<GetItemPublishStatusResponse> pfResult = new PlayFabResult<GetItemPublishStatusResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get a paginated set of reviews associated with the specified item. Individual ratings and reviews data update in near
     * real time with delays within a few seconds.
     * @param request GetItemReviewsRequest
     * @return Async Task will return GetItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemReviewsResponse>> GetItemReviewsAsync(final GetItemReviewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemReviewsResponse>>() {
            public PlayFabResult<GetItemReviewsResponse> call() throws Exception {
                return privateGetItemReviewsAsync(request);
            }
        });
    }

    /**
     * Get a paginated set of reviews associated with the specified item. Individual ratings and reviews data update in near
     * real time with delays within a few seconds.
     * @param request GetItemReviewsRequest
     * @return GetItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemReviewsResponse> GetItemReviews(final GetItemReviewsRequest request) {
        FutureTask<PlayFabResult<GetItemReviewsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemReviewsResponse>>() {
            public PlayFabResult<GetItemReviewsResponse> call() throws Exception {
                return privateGetItemReviewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemReviewsResponse> exceptionResult = new PlayFabResult<GetItemReviewsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Get a paginated set of reviews associated with the specified item. Individual ratings and reviews data update in near
     * real time with delays within a few seconds.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemReviewsResponse> privateGetItemReviewsAsync(final GetItemReviewsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItemReviews"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemReviewsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemReviewsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemReviewsResponse>>(){}.getType());
        GetItemReviewsResponse result = resultData.data;

        PlayFabResult<GetItemReviewsResponse> pfResult = new PlayFabResult<GetItemReviewsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get a summary of all ratings and reviews associated with the specified item. Summary ratings data is cached with update
     * data coming within 15 minutes.
     * @param request GetItemReviewSummaryRequest
     * @return Async Task will return GetItemReviewSummaryResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemReviewSummaryResponse>> GetItemReviewSummaryAsync(final GetItemReviewSummaryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemReviewSummaryResponse>>() {
            public PlayFabResult<GetItemReviewSummaryResponse> call() throws Exception {
                return privateGetItemReviewSummaryAsync(request);
            }
        });
    }

    /**
     * Get a summary of all ratings and reviews associated with the specified item. Summary ratings data is cached with update
     * data coming within 15 minutes.
     * @param request GetItemReviewSummaryRequest
     * @return GetItemReviewSummaryResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemReviewSummaryResponse> GetItemReviewSummary(final GetItemReviewSummaryRequest request) {
        FutureTask<PlayFabResult<GetItemReviewSummaryResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemReviewSummaryResponse>>() {
            public PlayFabResult<GetItemReviewSummaryResponse> call() throws Exception {
                return privateGetItemReviewSummaryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemReviewSummaryResponse> exceptionResult = new PlayFabResult<GetItemReviewSummaryResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Get a summary of all ratings and reviews associated with the specified item. Summary ratings data is cached with update
     * data coming within 15 minutes.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemReviewSummaryResponse> privateGetItemReviewSummaryAsync(final GetItemReviewSummaryRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItemReviewSummary"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemReviewSummaryResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemReviewSummaryResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemReviewSummaryResponse>>(){}.getType());
        GetItemReviewSummaryResponse result = resultData.data;

        PlayFabResult<GetItemReviewSummaryResponse> pfResult = new PlayFabResult<GetItemReviewSummaryResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves items from the public catalog. Up to 50 items can be returned at once. GetItems does not work off a cache of
     * the Catalog and should be used when trying to get recent item updates. However, please note that item references data is
     * cached and may take a few moments for changes to propagate.
     * @param request GetItemsRequest
     * @return Async Task will return GetItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemsResponse>> GetItemsAsync(final GetItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemsResponse>>() {
            public PlayFabResult<GetItemsResponse> call() throws Exception {
                return privateGetItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves items from the public catalog. Up to 50 items can be returned at once. GetItems does not work off a cache of
     * the Catalog and should be used when trying to get recent item updates. However, please note that item references data is
     * cached and may take a few moments for changes to propagate.
     * @param request GetItemsRequest
     * @return GetItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemsResponse> GetItems(final GetItemsRequest request) {
        FutureTask<PlayFabResult<GetItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemsResponse>>() {
            public PlayFabResult<GetItemsResponse> call() throws Exception {
                return privateGetItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemsResponse> exceptionResult = new PlayFabResult<GetItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Retrieves items from the public catalog. Up to 50 items can be returned at once. GetItems does not work off a cache of
     * the Catalog and should be used when trying to get recent item updates. However, please note that item references data is
     * cached and may take a few moments for changes to propagate.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemsResponse> privateGetItemsAsync(final GetItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemsResponse>>(){}.getType());
        GetItemsResponse result = resultData.data;

        PlayFabResult<GetItemsResponse> pfResult = new PlayFabResult<GetItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the access tokens.
     * @param request GetMicrosoftStoreAccessTokensRequest
     * @return Async Task will return GetMicrosoftStoreAccessTokensResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetMicrosoftStoreAccessTokensResponse>> GetMicrosoftStoreAccessTokensAsync(final GetMicrosoftStoreAccessTokensRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetMicrosoftStoreAccessTokensResponse>>() {
            public PlayFabResult<GetMicrosoftStoreAccessTokensResponse> call() throws Exception {
                return privateGetMicrosoftStoreAccessTokensAsync(request);
            }
        });
    }

    /**
     * Gets the access tokens.
     * @param request GetMicrosoftStoreAccessTokensRequest
     * @return GetMicrosoftStoreAccessTokensResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetMicrosoftStoreAccessTokensResponse> GetMicrosoftStoreAccessTokens(final GetMicrosoftStoreAccessTokensRequest request) {
        FutureTask<PlayFabResult<GetMicrosoftStoreAccessTokensResponse>> task = new FutureTask(new Callable<PlayFabResult<GetMicrosoftStoreAccessTokensResponse>>() {
            public PlayFabResult<GetMicrosoftStoreAccessTokensResponse> call() throws Exception {
                return privateGetMicrosoftStoreAccessTokensAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetMicrosoftStoreAccessTokensResponse> exceptionResult = new PlayFabResult<GetMicrosoftStoreAccessTokensResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the access tokens. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetMicrosoftStoreAccessTokensResponse> privateGetMicrosoftStoreAccessTokensAsync(final GetMicrosoftStoreAccessTokensRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/GetMicrosoftStoreAccessTokens"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetMicrosoftStoreAccessTokensResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetMicrosoftStoreAccessTokensResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetMicrosoftStoreAccessTokensResponse>>(){}.getType());
        GetMicrosoftStoreAccessTokensResponse result = resultData.data;

        PlayFabResult<GetMicrosoftStoreAccessTokensResponse> pfResult = new PlayFabResult<GetMicrosoftStoreAccessTokensResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get transaction history for a player. Up to 250 Events can be returned at once. You can use continuation tokens to
     * paginate through results that return greater than the limit. Getting transaction history has a lower RPS limit than
     * getting a Player's inventory with Player Entities having a limit of 30 requests in 300 seconds.
     * @param request GetTransactionHistoryRequest
     * @return Async Task will return GetTransactionHistoryResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetTransactionHistoryResponse>> GetTransactionHistoryAsync(final GetTransactionHistoryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTransactionHistoryResponse>>() {
            public PlayFabResult<GetTransactionHistoryResponse> call() throws Exception {
                return privateGetTransactionHistoryAsync(request);
            }
        });
    }

    /**
     * Get transaction history for a player. Up to 250 Events can be returned at once. You can use continuation tokens to
     * paginate through results that return greater than the limit. Getting transaction history has a lower RPS limit than
     * getting a Player's inventory with Player Entities having a limit of 30 requests in 300 seconds.
     * @param request GetTransactionHistoryRequest
     * @return GetTransactionHistoryResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetTransactionHistoryResponse> GetTransactionHistory(final GetTransactionHistoryRequest request) {
        FutureTask<PlayFabResult<GetTransactionHistoryResponse>> task = new FutureTask(new Callable<PlayFabResult<GetTransactionHistoryResponse>>() {
            public PlayFabResult<GetTransactionHistoryResponse> call() throws Exception {
                return privateGetTransactionHistoryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetTransactionHistoryResponse> exceptionResult = new PlayFabResult<GetTransactionHistoryResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Get transaction history for a player. Up to 250 Events can be returned at once. You can use continuation tokens to
     * paginate through results that return greater than the limit. Getting transaction history has a lower RPS limit than
     * getting a Player's inventory with Player Entities having a limit of 30 requests in 300 seconds.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetTransactionHistoryResponse> privateGetTransactionHistoryAsync(final GetTransactionHistoryRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/GetTransactionHistory"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTransactionHistoryResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetTransactionHistoryResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTransactionHistoryResponse>>(){}.getType());
        GetTransactionHistoryResponse result = resultData.data;

        PlayFabResult<GetTransactionHistoryResponse> pfResult = new PlayFabResult<GetTransactionHistoryResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Initiates a publish of an item from the working catalog to the public catalog. You can use the GetItemPublishStatus API
     * to track the state of the item publish.
     * @param request PublishDraftItemRequest
     * @return Async Task will return PublishDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<PublishDraftItemResponse>> PublishDraftItemAsync(final PublishDraftItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<PublishDraftItemResponse>>() {
            public PlayFabResult<PublishDraftItemResponse> call() throws Exception {
                return privatePublishDraftItemAsync(request);
            }
        });
    }

    /**
     * Initiates a publish of an item from the working catalog to the public catalog. You can use the GetItemPublishStatus API
     * to track the state of the item publish.
     * @param request PublishDraftItemRequest
     * @return PublishDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<PublishDraftItemResponse> PublishDraftItem(final PublishDraftItemRequest request) {
        FutureTask<PlayFabResult<PublishDraftItemResponse>> task = new FutureTask(new Callable<PlayFabResult<PublishDraftItemResponse>>() {
            public PlayFabResult<PublishDraftItemResponse> call() throws Exception {
                return privatePublishDraftItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<PublishDraftItemResponse> exceptionResult = new PlayFabResult<PublishDraftItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Initiates a publish of an item from the working catalog to the public catalog. You can use the GetItemPublishStatus API
     * to track the state of the item publish.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<PublishDraftItemResponse> privatePublishDraftItemAsync(final PublishDraftItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/PublishDraftItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<PublishDraftItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<PublishDraftItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<PublishDraftItemResponse>>(){}.getType());
        PublishDraftItemResponse result = resultData.data;

        PlayFabResult<PublishDraftItemResponse> pfResult = new PlayFabResult<PublishDraftItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Purchase an item or bundle. Up to 10,000 stacks of items can be added to a single inventory collection. Stack size is
     * uncapped.
     * @param request PurchaseInventoryItemsRequest
     * @return Async Task will return PurchaseInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<PurchaseInventoryItemsResponse>> PurchaseInventoryItemsAsync(final PurchaseInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<PurchaseInventoryItemsResponse>>() {
            public PlayFabResult<PurchaseInventoryItemsResponse> call() throws Exception {
                return privatePurchaseInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Purchase an item or bundle. Up to 10,000 stacks of items can be added to a single inventory collection. Stack size is
     * uncapped.
     * @param request PurchaseInventoryItemsRequest
     * @return PurchaseInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<PurchaseInventoryItemsResponse> PurchaseInventoryItems(final PurchaseInventoryItemsRequest request) {
        FutureTask<PlayFabResult<PurchaseInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<PurchaseInventoryItemsResponse>>() {
            public PlayFabResult<PurchaseInventoryItemsResponse> call() throws Exception {
                return privatePurchaseInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<PurchaseInventoryItemsResponse> exceptionResult = new PlayFabResult<PurchaseInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Purchase an item or bundle. Up to 10,000 stacks of items can be added to a single inventory collection. Stack size is
     * uncapped.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<PurchaseInventoryItemsResponse> privatePurchaseInventoryItemsAsync(final PurchaseInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/PurchaseInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<PurchaseInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<PurchaseInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<PurchaseInventoryItemsResponse>>(){}.getType());
        PurchaseInventoryItemsResponse result = resultData.data;

        PlayFabResult<PurchaseInventoryItemsResponse> pfResult = new PlayFabResult<PurchaseInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Redeem items.
     * @param request RedeemAppleAppStoreInventoryItemsRequest
     * @return Async Task will return RedeemAppleAppStoreInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse>> RedeemAppleAppStoreInventoryItemsAsync(final RedeemAppleAppStoreInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse>>() {
            public PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse> call() throws Exception {
                return privateRedeemAppleAppStoreInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Redeem items.
     * @param request RedeemAppleAppStoreInventoryItemsRequest
     * @return RedeemAppleAppStoreInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse> RedeemAppleAppStoreInventoryItems(final RedeemAppleAppStoreInventoryItemsRequest request) {
        FutureTask<PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse>>() {
            public PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse> call() throws Exception {
                return privateRedeemAppleAppStoreInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse> exceptionResult = new PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Redeem items. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse> privateRedeemAppleAppStoreInventoryItemsAsync(final RedeemAppleAppStoreInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/RedeemAppleAppStoreInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RedeemAppleAppStoreInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RedeemAppleAppStoreInventoryItemsResponse>>(){}.getType());
        RedeemAppleAppStoreInventoryItemsResponse result = resultData.data;

        PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse> pfResult = new PlayFabResult<RedeemAppleAppStoreInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Redeem items.
     * @param request RedeemGooglePlayInventoryItemsRequest
     * @return Async Task will return RedeemGooglePlayInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RedeemGooglePlayInventoryItemsResponse>> RedeemGooglePlayInventoryItemsAsync(final RedeemGooglePlayInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemGooglePlayInventoryItemsResponse>>() {
            public PlayFabResult<RedeemGooglePlayInventoryItemsResponse> call() throws Exception {
                return privateRedeemGooglePlayInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Redeem items.
     * @param request RedeemGooglePlayInventoryItemsRequest
     * @return RedeemGooglePlayInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RedeemGooglePlayInventoryItemsResponse> RedeemGooglePlayInventoryItems(final RedeemGooglePlayInventoryItemsRequest request) {
        FutureTask<PlayFabResult<RedeemGooglePlayInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<RedeemGooglePlayInventoryItemsResponse>>() {
            public PlayFabResult<RedeemGooglePlayInventoryItemsResponse> call() throws Exception {
                return privateRedeemGooglePlayInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RedeemGooglePlayInventoryItemsResponse> exceptionResult = new PlayFabResult<RedeemGooglePlayInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Redeem items. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RedeemGooglePlayInventoryItemsResponse> privateRedeemGooglePlayInventoryItemsAsync(final RedeemGooglePlayInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/RedeemGooglePlayInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RedeemGooglePlayInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RedeemGooglePlayInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RedeemGooglePlayInventoryItemsResponse>>(){}.getType());
        RedeemGooglePlayInventoryItemsResponse result = resultData.data;

        PlayFabResult<RedeemGooglePlayInventoryItemsResponse> pfResult = new PlayFabResult<RedeemGooglePlayInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Redeem items.
     * @param request RedeemMicrosoftStoreInventoryItemsRequest
     * @return Async Task will return RedeemMicrosoftStoreInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse>> RedeemMicrosoftStoreInventoryItemsAsync(final RedeemMicrosoftStoreInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse>>() {
            public PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse> call() throws Exception {
                return privateRedeemMicrosoftStoreInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Redeem items.
     * @param request RedeemMicrosoftStoreInventoryItemsRequest
     * @return RedeemMicrosoftStoreInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse> RedeemMicrosoftStoreInventoryItems(final RedeemMicrosoftStoreInventoryItemsRequest request) {
        FutureTask<PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse>>() {
            public PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse> call() throws Exception {
                return privateRedeemMicrosoftStoreInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse> exceptionResult = new PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Redeem items. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse> privateRedeemMicrosoftStoreInventoryItemsAsync(final RedeemMicrosoftStoreInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/RedeemMicrosoftStoreInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RedeemMicrosoftStoreInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RedeemMicrosoftStoreInventoryItemsResponse>>(){}.getType());
        RedeemMicrosoftStoreInventoryItemsResponse result = resultData.data;

        PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse> pfResult = new PlayFabResult<RedeemMicrosoftStoreInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Redeem items.
     * @param request RedeemNintendoEShopInventoryItemsRequest
     * @return Async Task will return RedeemNintendoEShopInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RedeemNintendoEShopInventoryItemsResponse>> RedeemNintendoEShopInventoryItemsAsync(final RedeemNintendoEShopInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemNintendoEShopInventoryItemsResponse>>() {
            public PlayFabResult<RedeemNintendoEShopInventoryItemsResponse> call() throws Exception {
                return privateRedeemNintendoEShopInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Redeem items.
     * @param request RedeemNintendoEShopInventoryItemsRequest
     * @return RedeemNintendoEShopInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RedeemNintendoEShopInventoryItemsResponse> RedeemNintendoEShopInventoryItems(final RedeemNintendoEShopInventoryItemsRequest request) {
        FutureTask<PlayFabResult<RedeemNintendoEShopInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<RedeemNintendoEShopInventoryItemsResponse>>() {
            public PlayFabResult<RedeemNintendoEShopInventoryItemsResponse> call() throws Exception {
                return privateRedeemNintendoEShopInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RedeemNintendoEShopInventoryItemsResponse> exceptionResult = new PlayFabResult<RedeemNintendoEShopInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Redeem items. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RedeemNintendoEShopInventoryItemsResponse> privateRedeemNintendoEShopInventoryItemsAsync(final RedeemNintendoEShopInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/RedeemNintendoEShopInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RedeemNintendoEShopInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RedeemNintendoEShopInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RedeemNintendoEShopInventoryItemsResponse>>(){}.getType());
        RedeemNintendoEShopInventoryItemsResponse result = resultData.data;

        PlayFabResult<RedeemNintendoEShopInventoryItemsResponse> pfResult = new PlayFabResult<RedeemNintendoEShopInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Redeem items.
     * @param request RedeemPlayStationStoreInventoryItemsRequest
     * @return Async Task will return RedeemPlayStationStoreInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse>> RedeemPlayStationStoreInventoryItemsAsync(final RedeemPlayStationStoreInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse>>() {
            public PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse> call() throws Exception {
                return privateRedeemPlayStationStoreInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Redeem items.
     * @param request RedeemPlayStationStoreInventoryItemsRequest
     * @return RedeemPlayStationStoreInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse> RedeemPlayStationStoreInventoryItems(final RedeemPlayStationStoreInventoryItemsRequest request) {
        FutureTask<PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse>>() {
            public PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse> call() throws Exception {
                return privateRedeemPlayStationStoreInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse> exceptionResult = new PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Redeem items. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse> privateRedeemPlayStationStoreInventoryItemsAsync(final RedeemPlayStationStoreInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/RedeemPlayStationStoreInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RedeemPlayStationStoreInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RedeemPlayStationStoreInventoryItemsResponse>>(){}.getType());
        RedeemPlayStationStoreInventoryItemsResponse result = resultData.data;

        PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse> pfResult = new PlayFabResult<RedeemPlayStationStoreInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Redeem items.
     * @param request RedeemSteamInventoryItemsRequest
     * @return Async Task will return RedeemSteamInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<RedeemSteamInventoryItemsResponse>> RedeemSteamInventoryItemsAsync(final RedeemSteamInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemSteamInventoryItemsResponse>>() {
            public PlayFabResult<RedeemSteamInventoryItemsResponse> call() throws Exception {
                return privateRedeemSteamInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Redeem items.
     * @param request RedeemSteamInventoryItemsRequest
     * @return RedeemSteamInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<RedeemSteamInventoryItemsResponse> RedeemSteamInventoryItems(final RedeemSteamInventoryItemsRequest request) {
        FutureTask<PlayFabResult<RedeemSteamInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<RedeemSteamInventoryItemsResponse>>() {
            public PlayFabResult<RedeemSteamInventoryItemsResponse> call() throws Exception {
                return privateRedeemSteamInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<RedeemSteamInventoryItemsResponse> exceptionResult = new PlayFabResult<RedeemSteamInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Redeem items. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<RedeemSteamInventoryItemsResponse> privateRedeemSteamInventoryItemsAsync(final RedeemSteamInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/RedeemSteamInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RedeemSteamInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<RedeemSteamInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RedeemSteamInventoryItemsResponse>>(){}.getType());
        RedeemSteamInventoryItemsResponse result = resultData.data;

        PlayFabResult<RedeemSteamInventoryItemsResponse> pfResult = new PlayFabResult<RedeemSteamInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Submit a report for an item, indicating in what way the item is inappropriate.
     * @param request ReportItemRequest
     * @return Async Task will return ReportItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ReportItemResponse>> ReportItemAsync(final ReportItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReportItemResponse>>() {
            public PlayFabResult<ReportItemResponse> call() throws Exception {
                return privateReportItemAsync(request);
            }
        });
    }

    /**
     * Submit a report for an item, indicating in what way the item is inappropriate.
     * @param request ReportItemRequest
     * @return ReportItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ReportItemResponse> ReportItem(final ReportItemRequest request) {
        FutureTask<PlayFabResult<ReportItemResponse>> task = new FutureTask(new Callable<PlayFabResult<ReportItemResponse>>() {
            public PlayFabResult<ReportItemResponse> call() throws Exception {
                return privateReportItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ReportItemResponse> exceptionResult = new PlayFabResult<ReportItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Submit a report for an item, indicating in what way the item is inappropriate. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ReportItemResponse> privateReportItemAsync(final ReportItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/ReportItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReportItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ReportItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReportItemResponse>>(){}.getType());
        ReportItemResponse result = resultData.data;

        PlayFabResult<ReportItemResponse> pfResult = new PlayFabResult<ReportItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Submit a report for a review
     * @param request ReportItemReviewRequest
     * @return Async Task will return ReportItemReviewResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ReportItemReviewResponse>> ReportItemReviewAsync(final ReportItemReviewRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReportItemReviewResponse>>() {
            public PlayFabResult<ReportItemReviewResponse> call() throws Exception {
                return privateReportItemReviewAsync(request);
            }
        });
    }

    /**
     * Submit a report for a review
     * @param request ReportItemReviewRequest
     * @return ReportItemReviewResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ReportItemReviewResponse> ReportItemReview(final ReportItemReviewRequest request) {
        FutureTask<PlayFabResult<ReportItemReviewResponse>> task = new FutureTask(new Callable<PlayFabResult<ReportItemReviewResponse>>() {
            public PlayFabResult<ReportItemReviewResponse> call() throws Exception {
                return privateReportItemReviewAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ReportItemReviewResponse> exceptionResult = new PlayFabResult<ReportItemReviewResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Submit a report for a review */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ReportItemReviewResponse> privateReportItemReviewAsync(final ReportItemReviewRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/ReportItemReview"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReportItemReviewResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ReportItemReviewResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReportItemReviewResponse>>(){}.getType());
        ReportItemReviewResponse result = resultData.data;

        PlayFabResult<ReportItemReviewResponse> pfResult = new PlayFabResult<ReportItemReviewResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates or updates a review for the specified item. More information around the caching surrounding item ratings and
     * reviews can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/ratings#ratings-design-and-caching
     * @param request ReviewItemRequest
     * @return Async Task will return ReviewItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ReviewItemResponse>> ReviewItemAsync(final ReviewItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReviewItemResponse>>() {
            public PlayFabResult<ReviewItemResponse> call() throws Exception {
                return privateReviewItemAsync(request);
            }
        });
    }

    /**
     * Creates or updates a review for the specified item. More information around the caching surrounding item ratings and
     * reviews can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/ratings#ratings-design-and-caching
     * @param request ReviewItemRequest
     * @return ReviewItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ReviewItemResponse> ReviewItem(final ReviewItemRequest request) {
        FutureTask<PlayFabResult<ReviewItemResponse>> task = new FutureTask(new Callable<PlayFabResult<ReviewItemResponse>>() {
            public PlayFabResult<ReviewItemResponse> call() throws Exception {
                return privateReviewItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ReviewItemResponse> exceptionResult = new PlayFabResult<ReviewItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Creates or updates a review for the specified item. More information around the caching surrounding item ratings and
     * reviews can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/ratings#ratings-design-and-caching
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ReviewItemResponse> privateReviewItemAsync(final ReviewItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/ReviewItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReviewItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ReviewItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReviewItemResponse>>(){}.getType());
        ReviewItemResponse result = resultData.data;

        PlayFabResult<ReviewItemResponse> pfResult = new PlayFabResult<ReviewItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Executes a search against the public catalog using the provided search parameters and returns a set of paginated
     * results. SearchItems uses a cache of the catalog with item updates taking up to a few minutes to propagate. You should
     * use the GetItem API for when trying to immediately get recent item updates. More information about the Search API can be
     * found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/search
     * @param request SearchItemsRequest
     * @return Async Task will return SearchItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SearchItemsResponse>> SearchItemsAsync(final SearchItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SearchItemsResponse>>() {
            public PlayFabResult<SearchItemsResponse> call() throws Exception {
                return privateSearchItemsAsync(request);
            }
        });
    }

    /**
     * Executes a search against the public catalog using the provided search parameters and returns a set of paginated
     * results. SearchItems uses a cache of the catalog with item updates taking up to a few minutes to propagate. You should
     * use the GetItem API for when trying to immediately get recent item updates. More information about the Search API can be
     * found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/search
     * @param request SearchItemsRequest
     * @return SearchItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SearchItemsResponse> SearchItems(final SearchItemsRequest request) {
        FutureTask<PlayFabResult<SearchItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<SearchItemsResponse>>() {
            public PlayFabResult<SearchItemsResponse> call() throws Exception {
                return privateSearchItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SearchItemsResponse> exceptionResult = new PlayFabResult<SearchItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Executes a search against the public catalog using the provided search parameters and returns a set of paginated
     * results. SearchItems uses a cache of the catalog with item updates taking up to a few minutes to propagate. You should
     * use the GetItem API for when trying to immediately get recent item updates. More information about the Search API can be
     * found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/catalog/search
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SearchItemsResponse> privateSearchItemsAsync(final SearchItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/SearchItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SearchItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SearchItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SearchItemsResponse>>(){}.getType());
        SearchItemsResponse result = resultData.data;

        PlayFabResult<SearchItemsResponse> pfResult = new PlayFabResult<SearchItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the moderation state for an item, including the concern category and string reason. More information about
     * moderation states can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/ugc/moderation
     * @param request SetItemModerationStateRequest
     * @return Async Task will return SetItemModerationStateResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetItemModerationStateResponse>> SetItemModerationStateAsync(final SetItemModerationStateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetItemModerationStateResponse>>() {
            public PlayFabResult<SetItemModerationStateResponse> call() throws Exception {
                return privateSetItemModerationStateAsync(request);
            }
        });
    }

    /**
     * Sets the moderation state for an item, including the concern category and string reason. More information about
     * moderation states can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/ugc/moderation
     * @param request SetItemModerationStateRequest
     * @return SetItemModerationStateResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetItemModerationStateResponse> SetItemModerationState(final SetItemModerationStateRequest request) {
        FutureTask<PlayFabResult<SetItemModerationStateResponse>> task = new FutureTask(new Callable<PlayFabResult<SetItemModerationStateResponse>>() {
            public PlayFabResult<SetItemModerationStateResponse> call() throws Exception {
                return privateSetItemModerationStateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetItemModerationStateResponse> exceptionResult = new PlayFabResult<SetItemModerationStateResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Sets the moderation state for an item, including the concern category and string reason. More information about
     * moderation states can be found here: https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/ugc/moderation
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetItemModerationStateResponse> privateSetItemModerationStateAsync(final SetItemModerationStateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/SetItemModerationState"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetItemModerationStateResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetItemModerationStateResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetItemModerationStateResponse>>(){}.getType());
        SetItemModerationStateResponse result = resultData.data;

        PlayFabResult<SetItemModerationStateResponse> pfResult = new PlayFabResult<SetItemModerationStateResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Submit a vote for a review, indicating whether the review was helpful or unhelpful.
     * @param request SubmitItemReviewVoteRequest
     * @return Async Task will return SubmitItemReviewVoteResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SubmitItemReviewVoteResponse>> SubmitItemReviewVoteAsync(final SubmitItemReviewVoteRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SubmitItemReviewVoteResponse>>() {
            public PlayFabResult<SubmitItemReviewVoteResponse> call() throws Exception {
                return privateSubmitItemReviewVoteAsync(request);
            }
        });
    }

    /**
     * Submit a vote for a review, indicating whether the review was helpful or unhelpful.
     * @param request SubmitItemReviewVoteRequest
     * @return SubmitItemReviewVoteResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SubmitItemReviewVoteResponse> SubmitItemReviewVote(final SubmitItemReviewVoteRequest request) {
        FutureTask<PlayFabResult<SubmitItemReviewVoteResponse>> task = new FutureTask(new Callable<PlayFabResult<SubmitItemReviewVoteResponse>>() {
            public PlayFabResult<SubmitItemReviewVoteResponse> call() throws Exception {
                return privateSubmitItemReviewVoteAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SubmitItemReviewVoteResponse> exceptionResult = new PlayFabResult<SubmitItemReviewVoteResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Submit a vote for a review, indicating whether the review was helpful or unhelpful. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SubmitItemReviewVoteResponse> privateSubmitItemReviewVoteAsync(final SubmitItemReviewVoteRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/SubmitItemReviewVote"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SubmitItemReviewVoteResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SubmitItemReviewVoteResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SubmitItemReviewVoteResponse>>(){}.getType());
        SubmitItemReviewVoteResponse result = resultData.data;

        PlayFabResult<SubmitItemReviewVoteResponse> pfResult = new PlayFabResult<SubmitItemReviewVoteResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Subtract inventory items.
     * @param request SubtractInventoryItemsRequest
     * @return Async Task will return SubtractInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SubtractInventoryItemsResponse>> SubtractInventoryItemsAsync(final SubtractInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SubtractInventoryItemsResponse>>() {
            public PlayFabResult<SubtractInventoryItemsResponse> call() throws Exception {
                return privateSubtractInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Subtract inventory items.
     * @param request SubtractInventoryItemsRequest
     * @return SubtractInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SubtractInventoryItemsResponse> SubtractInventoryItems(final SubtractInventoryItemsRequest request) {
        FutureTask<PlayFabResult<SubtractInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<SubtractInventoryItemsResponse>>() {
            public PlayFabResult<SubtractInventoryItemsResponse> call() throws Exception {
                return privateSubtractInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SubtractInventoryItemsResponse> exceptionResult = new PlayFabResult<SubtractInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Subtract inventory items. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SubtractInventoryItemsResponse> privateSubtractInventoryItemsAsync(final SubtractInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/SubtractInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SubtractInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SubtractInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SubtractInventoryItemsResponse>>(){}.getType());
        SubtractInventoryItemsResponse result = resultData.data;

        PlayFabResult<SubtractInventoryItemsResponse> pfResult = new PlayFabResult<SubtractInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Submit a request to takedown one or more reviews.
     * @param request TakedownItemReviewsRequest
     * @return Async Task will return TakedownItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<TakedownItemReviewsResponse>> TakedownItemReviewsAsync(final TakedownItemReviewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<TakedownItemReviewsResponse>>() {
            public PlayFabResult<TakedownItemReviewsResponse> call() throws Exception {
                return privateTakedownItemReviewsAsync(request);
            }
        });
    }

    /**
     * Submit a request to takedown one or more reviews.
     * @param request TakedownItemReviewsRequest
     * @return TakedownItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<TakedownItemReviewsResponse> TakedownItemReviews(final TakedownItemReviewsRequest request) {
        FutureTask<PlayFabResult<TakedownItemReviewsResponse>> task = new FutureTask(new Callable<PlayFabResult<TakedownItemReviewsResponse>>() {
            public PlayFabResult<TakedownItemReviewsResponse> call() throws Exception {
                return privateTakedownItemReviewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<TakedownItemReviewsResponse> exceptionResult = new PlayFabResult<TakedownItemReviewsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Submit a request to takedown one or more reviews. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<TakedownItemReviewsResponse> privateTakedownItemReviewsAsync(final TakedownItemReviewsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/TakedownItemReviews"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<TakedownItemReviewsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<TakedownItemReviewsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<TakedownItemReviewsResponse>>(){}.getType());
        TakedownItemReviewsResponse result = resultData.data;

        PlayFabResult<TakedownItemReviewsResponse> pfResult = new PlayFabResult<TakedownItemReviewsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Transfer inventory items. When transferring across collections, a 202 response indicates that the transfer did not
     * complete within the timeframe of the request. You can identify the pending operations by looking for OperationStatus =
     * 'InProgress'. You can check on the operation status at anytime within 1 day of the request by passing the
     * TransactionToken to the GetInventoryOperationStatus API. More information about item transfer scenarios can be found
     * here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/inventory/?tabs=inventory-game-manager#transfer-inventory-items
     * @param request TransferInventoryItemsRequest
     * @return Async Task will return TransferInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<TransferInventoryItemsResponse>> TransferInventoryItemsAsync(final TransferInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<TransferInventoryItemsResponse>>() {
            public PlayFabResult<TransferInventoryItemsResponse> call() throws Exception {
                return privateTransferInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Transfer inventory items. When transferring across collections, a 202 response indicates that the transfer did not
     * complete within the timeframe of the request. You can identify the pending operations by looking for OperationStatus =
     * 'InProgress'. You can check on the operation status at anytime within 1 day of the request by passing the
     * TransactionToken to the GetInventoryOperationStatus API. More information about item transfer scenarios can be found
     * here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/inventory/?tabs=inventory-game-manager#transfer-inventory-items
     * @param request TransferInventoryItemsRequest
     * @return TransferInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<TransferInventoryItemsResponse> TransferInventoryItems(final TransferInventoryItemsRequest request) {
        FutureTask<PlayFabResult<TransferInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<TransferInventoryItemsResponse>>() {
            public PlayFabResult<TransferInventoryItemsResponse> call() throws Exception {
                return privateTransferInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<TransferInventoryItemsResponse> exceptionResult = new PlayFabResult<TransferInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Transfer inventory items. When transferring across collections, a 202 response indicates that the transfer did not
     * complete within the timeframe of the request. You can identify the pending operations by looking for OperationStatus =
     * 'InProgress'. You can check on the operation status at anytime within 1 day of the request by passing the
     * TransactionToken to the GetInventoryOperationStatus API. More information about item transfer scenarios can be found
     * here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/inventory/?tabs=inventory-game-manager#transfer-inventory-items
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<TransferInventoryItemsResponse> privateTransferInventoryItemsAsync(final TransferInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/TransferInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<TransferInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<TransferInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<TransferInventoryItemsResponse>>(){}.getType());
        TransferInventoryItemsResponse result = resultData.data;

        PlayFabResult<TransferInventoryItemsResponse> pfResult = new PlayFabResult<TransferInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the configuration for the catalog. Only Title Entities can call this API. There is a limit of 10 requests in 10
     * seconds for this API. More information about the Catalog Config can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/settings
     * @param request UpdateCatalogConfigRequest
     * @return Async Task will return UpdateCatalogConfigResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCatalogConfigResponse>> UpdateCatalogConfigAsync(final UpdateCatalogConfigRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCatalogConfigResponse>>() {
            public PlayFabResult<UpdateCatalogConfigResponse> call() throws Exception {
                return privateUpdateCatalogConfigAsync(request);
            }
        });
    }

    /**
     * Updates the configuration for the catalog. Only Title Entities can call this API. There is a limit of 10 requests in 10
     * seconds for this API. More information about the Catalog Config can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/settings
     * @param request UpdateCatalogConfigRequest
     * @return UpdateCatalogConfigResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCatalogConfigResponse> UpdateCatalogConfig(final UpdateCatalogConfigRequest request) {
        FutureTask<PlayFabResult<UpdateCatalogConfigResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdateCatalogConfigResponse>>() {
            public PlayFabResult<UpdateCatalogConfigResponse> call() throws Exception {
                return privateUpdateCatalogConfigAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateCatalogConfigResponse> exceptionResult = new PlayFabResult<UpdateCatalogConfigResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Updates the configuration for the catalog. Only Title Entities can call this API. There is a limit of 10 requests in 10
     * seconds for this API. More information about the Catalog Config can be found here:
     * https://learn.microsoft.com/en-us/gaming/playfab/features/economy-v2/settings
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCatalogConfigResponse> privateUpdateCatalogConfigAsync(final UpdateCatalogConfigRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/UpdateCatalogConfig"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCatalogConfigResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateCatalogConfigResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCatalogConfigResponse>>(){}.getType());
        UpdateCatalogConfigResponse result = resultData.data;

        PlayFabResult<UpdateCatalogConfigResponse> pfResult = new PlayFabResult<UpdateCatalogConfigResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Update the metadata for an item in the working catalog.
     * @param request UpdateDraftItemRequest
     * @return Async Task will return UpdateDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateDraftItemResponse>> UpdateDraftItemAsync(final UpdateDraftItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateDraftItemResponse>>() {
            public PlayFabResult<UpdateDraftItemResponse> call() throws Exception {
                return privateUpdateDraftItemAsync(request);
            }
        });
    }

    /**
     * Update the metadata for an item in the working catalog.
     * @param request UpdateDraftItemRequest
     * @return UpdateDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateDraftItemResponse> UpdateDraftItem(final UpdateDraftItemRequest request) {
        FutureTask<PlayFabResult<UpdateDraftItemResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdateDraftItemResponse>>() {
            public PlayFabResult<UpdateDraftItemResponse> call() throws Exception {
                return privateUpdateDraftItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateDraftItemResponse> exceptionResult = new PlayFabResult<UpdateDraftItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Update the metadata for an item in the working catalog. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateDraftItemResponse> privateUpdateDraftItemAsync(final UpdateDraftItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/UpdateDraftItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateDraftItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateDraftItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateDraftItemResponse>>(){}.getType());
        UpdateDraftItemResponse result = resultData.data;

        PlayFabResult<UpdateDraftItemResponse> pfResult = new PlayFabResult<UpdateDraftItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Update inventory items
     * @param request UpdateInventoryItemsRequest
     * @return Async Task will return UpdateInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateInventoryItemsResponse>> UpdateInventoryItemsAsync(final UpdateInventoryItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateInventoryItemsResponse>>() {
            public PlayFabResult<UpdateInventoryItemsResponse> call() throws Exception {
                return privateUpdateInventoryItemsAsync(request);
            }
        });
    }

    /**
     * Update inventory items
     * @param request UpdateInventoryItemsRequest
     * @return UpdateInventoryItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateInventoryItemsResponse> UpdateInventoryItems(final UpdateInventoryItemsRequest request) {
        FutureTask<PlayFabResult<UpdateInventoryItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdateInventoryItemsResponse>>() {
            public PlayFabResult<UpdateInventoryItemsResponse> call() throws Exception {
                return privateUpdateInventoryItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateInventoryItemsResponse> exceptionResult = new PlayFabResult<UpdateInventoryItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Update inventory items */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateInventoryItemsResponse> privateUpdateInventoryItemsAsync(final UpdateInventoryItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Inventory/UpdateInventoryItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateInventoryItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateInventoryItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateInventoryItemsResponse>>(){}.getType());
        UpdateInventoryItemsResponse result = resultData.data;

        PlayFabResult<UpdateInventoryItemsResponse> pfResult = new PlayFabResult<UpdateInventoryItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

}
