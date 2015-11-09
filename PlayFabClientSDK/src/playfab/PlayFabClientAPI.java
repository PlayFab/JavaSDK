package playfab;

import playfab.internal.*;
import playfab.PlayFabClientModels.*;
import playfab.PlayFabErrors.*;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;


/**
 * APIs which provide the full range of PlayFab features available to the client - authentication, account and data management, inventory, friends, matchmaking, reporting, and platform-specific functionality
 */
public class PlayFabClientAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-DD'T'hh:mm:ss.SSS'Z'").create();
    
    /**
     * Gets a Photon custom authentication token that can be used to securely join the player into a Photon room. See https://playfab.com/using-photon-playfab for more details.
     */
    public static FutureTask<PlayFabResult<GetPhotonAuthenticationTokenResult>> GetPhotonAuthenticationTokenAsync(GetPhotonAuthenticationTokenRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPhotonAuthenticationTokenResult>>() {
            public PlayFabResult<GetPhotonAuthenticationTokenResult> call() throws Exception {
                return privateGetPhotonAuthenticationTokenAsync(request);
            }
        });
    }

    /**
     * Gets a Photon custom authentication token that can be used to securely join the player into a Photon room. See https://playfab.com/using-photon-playfab for more details.
     */
    public static PlayFabResult<GetPhotonAuthenticationTokenResult> GetPhotonAuthenticationToken(GetPhotonAuthenticationTokenRequest request) {
        FutureTask<PlayFabResult<GetPhotonAuthenticationTokenResult>> task = new FutureTask(new Callable<PlayFabResult<GetPhotonAuthenticationTokenResult>>() {
            public PlayFabResult<GetPhotonAuthenticationTokenResult> call() throws Exception {
                return privateGetPhotonAuthenticationTokenAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Gets a Photon custom authentication token that can be used to securely join the player into a Photon room. See https://playfab.com/using-photon-playfab for more details.
     */
    private static PlayFabResult<GetPhotonAuthenticationTokenResult> privateGetPhotonAuthenticationTokenAsync(GetPhotonAuthenticationTokenRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetPhotonAuthenticationToken", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPhotonAuthenticationTokenResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPhotonAuthenticationTokenResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPhotonAuthenticationTokenResult>>(){}.getType()); 
        GetPhotonAuthenticationTokenResult result = resultData.data;
        
        PlayFabResult<GetPhotonAuthenticationTokenResult> pfResult = new PlayFabResult<GetPhotonAuthenticationTokenResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Signs the user in using the Android device identifier, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithAndroidDeviceIDAsync(LoginWithAndroidDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithAndroidDeviceIDAsync(request);
            }
        });
    }

    /**
     * Signs the user in using the Android device identifier, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static PlayFabResult<LoginResult> LoginWithAndroidDeviceID(LoginWithAndroidDeviceIDRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithAndroidDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Signs the user in using the Android device identifier, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    private static PlayFabResult<LoginResult> privateLoginWithAndroidDeviceIDAsync(LoginWithAndroidDeviceIDRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LoginWithAndroidDeviceID", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType()); 
        LoginResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Signs the user in using a custom unique identifier generated by the title, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithCustomIDAsync(LoginWithCustomIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithCustomIDAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a custom unique identifier generated by the title, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static PlayFabResult<LoginResult> LoginWithCustomID(LoginWithCustomIDRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithCustomIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Signs the user in using a custom unique identifier generated by the title, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    private static PlayFabResult<LoginResult> privateLoginWithCustomIDAsync(LoginWithCustomIDRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LoginWithCustomID", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType()); 
        LoginResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithEmailAddressAsync(LoginWithEmailAddressRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithEmailAddressAsync(request);
            }
        });
    }

    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static PlayFabResult<LoginResult> LoginWithEmailAddress(LoginWithEmailAddressRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithEmailAddressAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    private static PlayFabResult<LoginResult> privateLoginWithEmailAddressAsync(LoginWithEmailAddressRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LoginWithEmailAddress", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType()); 
        LoginResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Signs the user in using a Facebook access token, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithFacebookAsync(LoginWithFacebookRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithFacebookAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Facebook access token, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static PlayFabResult<LoginResult> LoginWithFacebook(LoginWithFacebookRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithFacebookAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Signs the user in using a Facebook access token, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    private static PlayFabResult<LoginResult> privateLoginWithFacebookAsync(LoginWithFacebookRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LoginWithFacebook", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType()); 
        LoginResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Signs the user in using a Google account access token, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithGoogleAccountAsync(LoginWithGoogleAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithGoogleAccountAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Google account access token, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static PlayFabResult<LoginResult> LoginWithGoogleAccount(LoginWithGoogleAccountRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithGoogleAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Signs the user in using a Google account access token, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    private static PlayFabResult<LoginResult> privateLoginWithGoogleAccountAsync(LoginWithGoogleAccountRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LoginWithGoogleAccount", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType()); 
        LoginResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Signs the user in using the vendor-specific iOS device identifier, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithIOSDeviceIDAsync(LoginWithIOSDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithIOSDeviceIDAsync(request);
            }
        });
    }

    /**
     * Signs the user in using the vendor-specific iOS device identifier, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static PlayFabResult<LoginResult> LoginWithIOSDeviceID(LoginWithIOSDeviceIDRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithIOSDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Signs the user in using the vendor-specific iOS device identifier, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    private static PlayFabResult<LoginResult> privateLoginWithIOSDeviceIDAsync(LoginWithIOSDeviceIDRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LoginWithIOSDeviceID", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType()); 
        LoginResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Signs the user in using a Kongregate player account.
     */
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithKongregateAsync(LoginWithKongregateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithKongregateAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Kongregate player account.
     */
    public static PlayFabResult<LoginResult> LoginWithKongregate(LoginWithKongregateRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithKongregateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Signs the user in using a Kongregate player account.
     */
    private static PlayFabResult<LoginResult> privateLoginWithKongregateAsync(LoginWithKongregateRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LoginWithKongregate", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType()); 
        LoginResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithPlayFabAsync(LoginWithPlayFabRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithPlayFabAsync(request);
            }
        });
    }

    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static PlayFabResult<LoginResult> LoginWithPlayFab(LoginWithPlayFabRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithPlayFabAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    private static PlayFabResult<LoginResult> privateLoginWithPlayFabAsync(LoginWithPlayFabRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LoginWithPlayFab", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType()); 
        LoginResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Signs the user in using a Steam authentication ticket, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static FutureTask<PlayFabResult<LoginResult>> LoginWithSteamAsync(LoginWithSteamRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithSteamAsync(request);
            }
        });
    }

    /**
     * Signs the user in using a Steam authentication ticket, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    public static PlayFabResult<LoginResult> LoginWithSteam(LoginWithSteamRequest request) {
        FutureTask<PlayFabResult<LoginResult>> task = new FutureTask(new Callable<PlayFabResult<LoginResult>>() {
            public PlayFabResult<LoginResult> call() throws Exception {
                return privateLoginWithSteamAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Signs the user in using a Steam authentication ticket, returning a session identifier that can subsequently be used for API calls which require an authenticated user
     */
    private static PlayFabResult<LoginResult> privateLoginWithSteamAsync(LoginWithSteamRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LoginWithSteam", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LoginResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LoginResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LoginResult>>(){}.getType()); 
        LoginResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<LoginResult> pfResult = new PlayFabResult<LoginResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Registers a new Playfab user account, returning a session identifier that can subsequently be used for API calls which require an authenticated user. You must supply either a username or an email address.
     */
    public static FutureTask<PlayFabResult<RegisterPlayFabUserResult>> RegisterPlayFabUserAsync(RegisterPlayFabUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RegisterPlayFabUserResult>>() {
            public PlayFabResult<RegisterPlayFabUserResult> call() throws Exception {
                return privateRegisterPlayFabUserAsync(request);
            }
        });
    }

    /**
     * Registers a new Playfab user account, returning a session identifier that can subsequently be used for API calls which require an authenticated user. You must supply either a username or an email address.
     */
    public static PlayFabResult<RegisterPlayFabUserResult> RegisterPlayFabUser(RegisterPlayFabUserRequest request) {
        FutureTask<PlayFabResult<RegisterPlayFabUserResult>> task = new FutureTask(new Callable<PlayFabResult<RegisterPlayFabUserResult>>() {
            public PlayFabResult<RegisterPlayFabUserResult> call() throws Exception {
                return privateRegisterPlayFabUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Registers a new Playfab user account, returning a session identifier that can subsequently be used for API calls which require an authenticated user. You must supply either a username or an email address.
     */
    private static PlayFabResult<RegisterPlayFabUserResult> privateRegisterPlayFabUserAsync(RegisterPlayFabUserRequest request) throws Exception {
        request.TitleId = PlayFabSettings.TitleId != null ? PlayFabSettings.TitleId : request.TitleId;
			if(request.TitleId == null) throw new Exception ("Must be have PlayFabSettings.TitleId set to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/RegisterPlayFabUser", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RegisterPlayFabUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RegisterPlayFabUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RegisterPlayFabUserResult>>(){}.getType()); 
        RegisterPlayFabUserResult result = resultData.data;
        AuthKey = result.SessionTicket != null ? result.SessionTicket : AuthKey;

        PlayFabResult<RegisterPlayFabUserResult> pfResult = new PlayFabResult<RegisterPlayFabUserResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds playfab username/password auth to an existing semi-anonymous account created via a 3rd party auth method.
     */
    public static FutureTask<PlayFabResult<AddUsernamePasswordResult>> AddUsernamePasswordAsync(AddUsernamePasswordRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddUsernamePasswordResult>>() {
            public PlayFabResult<AddUsernamePasswordResult> call() throws Exception {
                return privateAddUsernamePasswordAsync(request);
            }
        });
    }

    /**
     * Adds playfab username/password auth to an existing semi-anonymous account created via a 3rd party auth method.
     */
    public static PlayFabResult<AddUsernamePasswordResult> AddUsernamePassword(AddUsernamePasswordRequest request) {
        FutureTask<PlayFabResult<AddUsernamePasswordResult>> task = new FutureTask(new Callable<PlayFabResult<AddUsernamePasswordResult>>() {
            public PlayFabResult<AddUsernamePasswordResult> call() throws Exception {
                return privateAddUsernamePasswordAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds playfab username/password auth to an existing semi-anonymous account created via a 3rd party auth method.
     */
    private static PlayFabResult<AddUsernamePasswordResult> privateAddUsernamePasswordAsync(AddUsernamePasswordRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/AddUsernamePassword", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddUsernamePasswordResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AddUsernamePasswordResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddUsernamePasswordResult>>(){}.getType()); 
        AddUsernamePasswordResult result = resultData.data;
        
        PlayFabResult<AddUsernamePasswordResult> pfResult = new PlayFabResult<AddUsernamePasswordResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the user's PlayFab account details
     */
    public static FutureTask<PlayFabResult<GetAccountInfoResult>> GetAccountInfoAsync(GetAccountInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetAccountInfoResult>>() {
            public PlayFabResult<GetAccountInfoResult> call() throws Exception {
                return privateGetAccountInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves the user's PlayFab account details
     */
    public static PlayFabResult<GetAccountInfoResult> GetAccountInfo(GetAccountInfoRequest request) {
        FutureTask<PlayFabResult<GetAccountInfoResult>> task = new FutureTask(new Callable<PlayFabResult<GetAccountInfoResult>>() {
            public PlayFabResult<GetAccountInfoResult> call() throws Exception {
                return privateGetAccountInfoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the user's PlayFab account details
     */
    private static PlayFabResult<GetAccountInfoResult> privateGetAccountInfoAsync(GetAccountInfoRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetAccountInfo", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetAccountInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetAccountInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetAccountInfoResult>>(){}.getType()); 
        GetAccountInfoResult result = resultData.data;
        
        PlayFabResult<GetAccountInfoResult> pfResult = new PlayFabResult<GetAccountInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers.
     */
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>> GetPlayFabIDsFromFacebookIDsAsync(GetPlayFabIDsFromFacebookIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromFacebookIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers.
     */
    public static PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> GetPlayFabIDsFromFacebookIDs(GetPlayFabIDsFromFacebookIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromFacebookIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers.
     */
    private static PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> privateGetPlayFabIDsFromFacebookIDsAsync(GetPlayFabIDsFromFacebookIDsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetPlayFabIDsFromFacebookIDs", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPlayFabIDsFromFacebookIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromFacebookIDsResult>>(){}.getType()); 
        GetPlayFabIDsFromFacebookIDsResult result = resultData.data;
        
        PlayFabResult<GetPlayFabIDsFromFacebookIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromFacebookIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Game Center identifiers (referenced in the Game Center Programming Guide as the Player Identifier).
     */
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>> GetPlayFabIDsFromGameCenterIDsAsync(GetPlayFabIDsFromGameCenterIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGameCenterIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Game Center identifiers (referenced in the Game Center Programming Guide as the Player Identifier).
     */
    public static PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> GetPlayFabIDsFromGameCenterIDs(GetPlayFabIDsFromGameCenterIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGameCenterIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Game Center identifiers (referenced in the Game Center Programming Guide as the Player Identifier).
     */
    private static PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> privateGetPlayFabIDsFromGameCenterIDsAsync(GetPlayFabIDsFromGameCenterIDsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetPlayFabIDsFromGameCenterIDs", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPlayFabIDsFromGameCenterIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromGameCenterIDsResult>>(){}.getType()); 
        GetPlayFabIDsFromGameCenterIDsResult result = resultData.data;
        
        PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromGameCenterIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Google identifiers. The Google identifiers are the IDs for the user accounts, available as "id" in the Google+ People API calls.
     */
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>> GetPlayFabIDsFromGoogleIDsAsync(GetPlayFabIDsFromGoogleIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGoogleIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Google identifiers. The Google identifiers are the IDs for the user accounts, available as "id" in the Google+ People API calls.
     */
    public static PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> GetPlayFabIDsFromGoogleIDs(GetPlayFabIDsFromGoogleIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromGoogleIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Google identifiers. The Google identifiers are the IDs for the user accounts, available as "id" in the Google+ People API calls.
     */
    private static PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> privateGetPlayFabIDsFromGoogleIDsAsync(GetPlayFabIDsFromGoogleIDsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetPlayFabIDsFromGoogleIDs", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPlayFabIDsFromGoogleIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromGoogleIDsResult>>(){}.getType()); 
        GetPlayFabIDsFromGoogleIDsResult result = resultData.data;
        
        PlayFabResult<GetPlayFabIDsFromGoogleIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromGoogleIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Steam identifiers. The Steam identifiers  are the profile IDs for the user accounts, available as SteamId in the Steamworks Community API calls.
     */
    public static FutureTask<PlayFabResult<GetPlayFabIDsFromSteamIDsResult>> GetPlayFabIDsFromSteamIDsAsync(GetPlayFabIDsFromSteamIDsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromSteamIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromSteamIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromSteamIDsAsync(request);
            }
        });
    }

    /**
     * Retrieves the unique PlayFab identifiers for the given set of Steam identifiers. The Steam identifiers  are the profile IDs for the user accounts, available as SteamId in the Steamworks Community API calls.
     */
    public static PlayFabResult<GetPlayFabIDsFromSteamIDsResult> GetPlayFabIDsFromSteamIDs(GetPlayFabIDsFromSteamIDsRequest request) {
        FutureTask<PlayFabResult<GetPlayFabIDsFromSteamIDsResult>> task = new FutureTask(new Callable<PlayFabResult<GetPlayFabIDsFromSteamIDsResult>>() {
            public PlayFabResult<GetPlayFabIDsFromSteamIDsResult> call() throws Exception {
                return privateGetPlayFabIDsFromSteamIDsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the unique PlayFab identifiers for the given set of Steam identifiers. The Steam identifiers  are the profile IDs for the user accounts, available as SteamId in the Steamworks Community API calls.
     */
    private static PlayFabResult<GetPlayFabIDsFromSteamIDsResult> privateGetPlayFabIDsFromSteamIDsAsync(GetPlayFabIDsFromSteamIDsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetPlayFabIDsFromSteamIDs", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayFabIDsFromSteamIDsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPlayFabIDsFromSteamIDsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayFabIDsFromSteamIDsResult>>(){}.getType()); 
        GetPlayFabIDsFromSteamIDsResult result = resultData.data;
        
        PlayFabResult<GetPlayFabIDsFromSteamIDsResult> pfResult = new PlayFabResult<GetPlayFabIDsFromSteamIDsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves all requested data for a user in one unified request. By default, this API returns all  data for the locally signed-in user. The input parameters may be used to limit the data retrieved to any subset of the available data, as well as retrieve the available data for a different user. Note that certain data, including inventory, virtual currency balances, and personally identifying information, may only be retrieved for the locally signed-in user. In the example below, a request is made for the account details, virtual currency balances, and specified user data for the locally signed-in user.
     */
    public static FutureTask<PlayFabResult<GetUserCombinedInfoResult>> GetUserCombinedInfoAsync(GetUserCombinedInfoRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserCombinedInfoResult>>() {
            public PlayFabResult<GetUserCombinedInfoResult> call() throws Exception {
                return privateGetUserCombinedInfoAsync(request);
            }
        });
    }

    /**
     * Retrieves all requested data for a user in one unified request. By default, this API returns all  data for the locally signed-in user. The input parameters may be used to limit the data retrieved to any subset of the available data, as well as retrieve the available data for a different user. Note that certain data, including inventory, virtual currency balances, and personally identifying information, may only be retrieved for the locally signed-in user. In the example below, a request is made for the account details, virtual currency balances, and specified user data for the locally signed-in user.
     */
    public static PlayFabResult<GetUserCombinedInfoResult> GetUserCombinedInfo(GetUserCombinedInfoRequest request) {
        FutureTask<PlayFabResult<GetUserCombinedInfoResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserCombinedInfoResult>>() {
            public PlayFabResult<GetUserCombinedInfoResult> call() throws Exception {
                return privateGetUserCombinedInfoAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves all requested data for a user in one unified request. By default, this API returns all  data for the locally signed-in user. The input parameters may be used to limit the data retrieved to any subset of the available data, as well as retrieve the available data for a different user. Note that certain data, including inventory, virtual currency balances, and personally identifying information, may only be retrieved for the locally signed-in user. In the example below, a request is made for the account details, virtual currency balances, and specified user data for the locally signed-in user.
     */
    private static PlayFabResult<GetUserCombinedInfoResult> privateGetUserCombinedInfoAsync(GetUserCombinedInfoRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetUserCombinedInfo", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserCombinedInfoResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserCombinedInfoResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserCombinedInfoResult>>(){}.getType()); 
        GetUserCombinedInfoResult result = resultData.data;
        
        PlayFabResult<GetUserCombinedInfoResult> pfResult = new PlayFabResult<GetUserCombinedInfoResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Links the Android device identifier to the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<LinkAndroidDeviceIDResult>> LinkAndroidDeviceIDAsync(LinkAndroidDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkAndroidDeviceIDResult>>() {
            public PlayFabResult<LinkAndroidDeviceIDResult> call() throws Exception {
                return privateLinkAndroidDeviceIDAsync(request);
            }
        });
    }

    /**
     * Links the Android device identifier to the user's PlayFab account
     */
    public static PlayFabResult<LinkAndroidDeviceIDResult> LinkAndroidDeviceID(LinkAndroidDeviceIDRequest request) {
        FutureTask<PlayFabResult<LinkAndroidDeviceIDResult>> task = new FutureTask(new Callable<PlayFabResult<LinkAndroidDeviceIDResult>>() {
            public PlayFabResult<LinkAndroidDeviceIDResult> call() throws Exception {
                return privateLinkAndroidDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Links the Android device identifier to the user's PlayFab account
     */
    private static PlayFabResult<LinkAndroidDeviceIDResult> privateLinkAndroidDeviceIDAsync(LinkAndroidDeviceIDRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LinkAndroidDeviceID", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkAndroidDeviceIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LinkAndroidDeviceIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkAndroidDeviceIDResult>>(){}.getType()); 
        LinkAndroidDeviceIDResult result = resultData.data;
        
        PlayFabResult<LinkAndroidDeviceIDResult> pfResult = new PlayFabResult<LinkAndroidDeviceIDResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Links the custom identifier, generated by the title, to the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<LinkCustomIDResult>> LinkCustomIDAsync(LinkCustomIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkCustomIDResult>>() {
            public PlayFabResult<LinkCustomIDResult> call() throws Exception {
                return privateLinkCustomIDAsync(request);
            }
        });
    }

    /**
     * Links the custom identifier, generated by the title, to the user's PlayFab account
     */
    public static PlayFabResult<LinkCustomIDResult> LinkCustomID(LinkCustomIDRequest request) {
        FutureTask<PlayFabResult<LinkCustomIDResult>> task = new FutureTask(new Callable<PlayFabResult<LinkCustomIDResult>>() {
            public PlayFabResult<LinkCustomIDResult> call() throws Exception {
                return privateLinkCustomIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Links the custom identifier, generated by the title, to the user's PlayFab account
     */
    private static PlayFabResult<LinkCustomIDResult> privateLinkCustomIDAsync(LinkCustomIDRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LinkCustomID", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkCustomIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LinkCustomIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkCustomIDResult>>(){}.getType()); 
        LinkCustomIDResult result = resultData.data;
        
        PlayFabResult<LinkCustomIDResult> pfResult = new PlayFabResult<LinkCustomIDResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Links the Facebook account associated with the provided Facebook access token to the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<LinkFacebookAccountResult>> LinkFacebookAccountAsync(LinkFacebookAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkFacebookAccountResult>>() {
            public PlayFabResult<LinkFacebookAccountResult> call() throws Exception {
                return privateLinkFacebookAccountAsync(request);
            }
        });
    }

    /**
     * Links the Facebook account associated with the provided Facebook access token to the user's PlayFab account
     */
    public static PlayFabResult<LinkFacebookAccountResult> LinkFacebookAccount(LinkFacebookAccountRequest request) {
        FutureTask<PlayFabResult<LinkFacebookAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkFacebookAccountResult>>() {
            public PlayFabResult<LinkFacebookAccountResult> call() throws Exception {
                return privateLinkFacebookAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Links the Facebook account associated with the provided Facebook access token to the user's PlayFab account
     */
    private static PlayFabResult<LinkFacebookAccountResult> privateLinkFacebookAccountAsync(LinkFacebookAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LinkFacebookAccount", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkFacebookAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LinkFacebookAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkFacebookAccountResult>>(){}.getType()); 
        LinkFacebookAccountResult result = resultData.data;
        
        PlayFabResult<LinkFacebookAccountResult> pfResult = new PlayFabResult<LinkFacebookAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<LinkGameCenterAccountResult>> LinkGameCenterAccountAsync(LinkGameCenterAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkGameCenterAccountResult>>() {
            public PlayFabResult<LinkGameCenterAccountResult> call() throws Exception {
                return privateLinkGameCenterAccountAsync(request);
            }
        });
    }

    /**
     * Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account
     */
    public static PlayFabResult<LinkGameCenterAccountResult> LinkGameCenterAccount(LinkGameCenterAccountRequest request) {
        FutureTask<PlayFabResult<LinkGameCenterAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkGameCenterAccountResult>>() {
            public PlayFabResult<LinkGameCenterAccountResult> call() throws Exception {
                return privateLinkGameCenterAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account
     */
    private static PlayFabResult<LinkGameCenterAccountResult> privateLinkGameCenterAccountAsync(LinkGameCenterAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LinkGameCenterAccount", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkGameCenterAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LinkGameCenterAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkGameCenterAccountResult>>(){}.getType()); 
        LinkGameCenterAccountResult result = resultData.data;
        
        PlayFabResult<LinkGameCenterAccountResult> pfResult = new PlayFabResult<LinkGameCenterAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Links the currently signed-in user account to the Google account specified by the Google account access token
     */
    public static FutureTask<PlayFabResult<LinkGoogleAccountResult>> LinkGoogleAccountAsync(LinkGoogleAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkGoogleAccountResult>>() {
            public PlayFabResult<LinkGoogleAccountResult> call() throws Exception {
                return privateLinkGoogleAccountAsync(request);
            }
        });
    }

    /**
     * Links the currently signed-in user account to the Google account specified by the Google account access token
     */
    public static PlayFabResult<LinkGoogleAccountResult> LinkGoogleAccount(LinkGoogleAccountRequest request) {
        FutureTask<PlayFabResult<LinkGoogleAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkGoogleAccountResult>>() {
            public PlayFabResult<LinkGoogleAccountResult> call() throws Exception {
                return privateLinkGoogleAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Links the currently signed-in user account to the Google account specified by the Google account access token
     */
    private static PlayFabResult<LinkGoogleAccountResult> privateLinkGoogleAccountAsync(LinkGoogleAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LinkGoogleAccount", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkGoogleAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LinkGoogleAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkGoogleAccountResult>>(){}.getType()); 
        LinkGoogleAccountResult result = resultData.data;
        
        PlayFabResult<LinkGoogleAccountResult> pfResult = new PlayFabResult<LinkGoogleAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Links the vendor-specific iOS device identifier to the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<LinkIOSDeviceIDResult>> LinkIOSDeviceIDAsync(LinkIOSDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkIOSDeviceIDResult>>() {
            public PlayFabResult<LinkIOSDeviceIDResult> call() throws Exception {
                return privateLinkIOSDeviceIDAsync(request);
            }
        });
    }

    /**
     * Links the vendor-specific iOS device identifier to the user's PlayFab account
     */
    public static PlayFabResult<LinkIOSDeviceIDResult> LinkIOSDeviceID(LinkIOSDeviceIDRequest request) {
        FutureTask<PlayFabResult<LinkIOSDeviceIDResult>> task = new FutureTask(new Callable<PlayFabResult<LinkIOSDeviceIDResult>>() {
            public PlayFabResult<LinkIOSDeviceIDResult> call() throws Exception {
                return privateLinkIOSDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Links the vendor-specific iOS device identifier to the user's PlayFab account
     */
    private static PlayFabResult<LinkIOSDeviceIDResult> privateLinkIOSDeviceIDAsync(LinkIOSDeviceIDRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LinkIOSDeviceID", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkIOSDeviceIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LinkIOSDeviceIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkIOSDeviceIDResult>>(){}.getType()); 
        LinkIOSDeviceIDResult result = resultData.data;
        
        PlayFabResult<LinkIOSDeviceIDResult> pfResult = new PlayFabResult<LinkIOSDeviceIDResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Links the Kongregate identifier to the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<LinkKongregateAccountResult>> LinkKongregateAsync(LinkKongregateAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkKongregateAccountResult>>() {
            public PlayFabResult<LinkKongregateAccountResult> call() throws Exception {
                return privateLinkKongregateAsync(request);
            }
        });
    }

    /**
     * Links the Kongregate identifier to the user's PlayFab account
     */
    public static PlayFabResult<LinkKongregateAccountResult> LinkKongregate(LinkKongregateAccountRequest request) {
        FutureTask<PlayFabResult<LinkKongregateAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkKongregateAccountResult>>() {
            public PlayFabResult<LinkKongregateAccountResult> call() throws Exception {
                return privateLinkKongregateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Links the Kongregate identifier to the user's PlayFab account
     */
    private static PlayFabResult<LinkKongregateAccountResult> privateLinkKongregateAsync(LinkKongregateAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LinkKongregate", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkKongregateAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LinkKongregateAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkKongregateAccountResult>>(){}.getType()); 
        LinkKongregateAccountResult result = resultData.data;
        
        PlayFabResult<LinkKongregateAccountResult> pfResult = new PlayFabResult<LinkKongregateAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Links the Steam account associated with the provided Steam authentication ticket to the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<LinkSteamAccountResult>> LinkSteamAccountAsync(LinkSteamAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LinkSteamAccountResult>>() {
            public PlayFabResult<LinkSteamAccountResult> call() throws Exception {
                return privateLinkSteamAccountAsync(request);
            }
        });
    }

    /**
     * Links the Steam account associated with the provided Steam authentication ticket to the user's PlayFab account
     */
    public static PlayFabResult<LinkSteamAccountResult> LinkSteamAccount(LinkSteamAccountRequest request) {
        FutureTask<PlayFabResult<LinkSteamAccountResult>> task = new FutureTask(new Callable<PlayFabResult<LinkSteamAccountResult>>() {
            public PlayFabResult<LinkSteamAccountResult> call() throws Exception {
                return privateLinkSteamAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Links the Steam account associated with the provided Steam authentication ticket to the user's PlayFab account
     */
    private static PlayFabResult<LinkSteamAccountResult> privateLinkSteamAccountAsync(LinkSteamAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LinkSteamAccount", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LinkSteamAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LinkSteamAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LinkSteamAccountResult>>(){}.getType()); 
        LinkSteamAccountResult result = resultData.data;
        
        PlayFabResult<LinkSteamAccountResult> pfResult = new PlayFabResult<LinkSteamAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to change the password
     */
    public static FutureTask<PlayFabResult<SendAccountRecoveryEmailResult>> SendAccountRecoveryEmailAsync(SendAccountRecoveryEmailRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SendAccountRecoveryEmailResult>>() {
            public PlayFabResult<SendAccountRecoveryEmailResult> call() throws Exception {
                return privateSendAccountRecoveryEmailAsync(request);
            }
        });
    }

    /**
     * Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to change the password
     */
    public static PlayFabResult<SendAccountRecoveryEmailResult> SendAccountRecoveryEmail(SendAccountRecoveryEmailRequest request) {
        FutureTask<PlayFabResult<SendAccountRecoveryEmailResult>> task = new FutureTask(new Callable<PlayFabResult<SendAccountRecoveryEmailResult>>() {
            public PlayFabResult<SendAccountRecoveryEmailResult> call() throws Exception {
                return privateSendAccountRecoveryEmailAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to change the password
     */
    private static PlayFabResult<SendAccountRecoveryEmailResult> privateSendAccountRecoveryEmailAsync(SendAccountRecoveryEmailRequest request) throws Exception {
        
        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/SendAccountRecoveryEmail", request, null, null);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SendAccountRecoveryEmailResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<SendAccountRecoveryEmailResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SendAccountRecoveryEmailResult>>(){}.getType()); 
        SendAccountRecoveryEmailResult result = resultData.data;
        
        PlayFabResult<SendAccountRecoveryEmailResult> pfResult = new PlayFabResult<SendAccountRecoveryEmailResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Unlinks the related Android device identifier from the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<UnlinkAndroidDeviceIDResult>> UnlinkAndroidDeviceIDAsync(UnlinkAndroidDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkAndroidDeviceIDResult>>() {
            public PlayFabResult<UnlinkAndroidDeviceIDResult> call() throws Exception {
                return privateUnlinkAndroidDeviceIDAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Android device identifier from the user's PlayFab account
     */
    public static PlayFabResult<UnlinkAndroidDeviceIDResult> UnlinkAndroidDeviceID(UnlinkAndroidDeviceIDRequest request) {
        FutureTask<PlayFabResult<UnlinkAndroidDeviceIDResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkAndroidDeviceIDResult>>() {
            public PlayFabResult<UnlinkAndroidDeviceIDResult> call() throws Exception {
                return privateUnlinkAndroidDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Unlinks the related Android device identifier from the user's PlayFab account
     */
    private static PlayFabResult<UnlinkAndroidDeviceIDResult> privateUnlinkAndroidDeviceIDAsync(UnlinkAndroidDeviceIDRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UnlinkAndroidDeviceID", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkAndroidDeviceIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UnlinkAndroidDeviceIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkAndroidDeviceIDResult>>(){}.getType()); 
        UnlinkAndroidDeviceIDResult result = resultData.data;
        
        PlayFabResult<UnlinkAndroidDeviceIDResult> pfResult = new PlayFabResult<UnlinkAndroidDeviceIDResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Unlinks the related custom identifier from the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<UnlinkCustomIDResult>> UnlinkCustomIDAsync(UnlinkCustomIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkCustomIDResult>>() {
            public PlayFabResult<UnlinkCustomIDResult> call() throws Exception {
                return privateUnlinkCustomIDAsync(request);
            }
        });
    }

    /**
     * Unlinks the related custom identifier from the user's PlayFab account
     */
    public static PlayFabResult<UnlinkCustomIDResult> UnlinkCustomID(UnlinkCustomIDRequest request) {
        FutureTask<PlayFabResult<UnlinkCustomIDResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkCustomIDResult>>() {
            public PlayFabResult<UnlinkCustomIDResult> call() throws Exception {
                return privateUnlinkCustomIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Unlinks the related custom identifier from the user's PlayFab account
     */
    private static PlayFabResult<UnlinkCustomIDResult> privateUnlinkCustomIDAsync(UnlinkCustomIDRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UnlinkCustomID", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkCustomIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UnlinkCustomIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkCustomIDResult>>(){}.getType()); 
        UnlinkCustomIDResult result = resultData.data;
        
        PlayFabResult<UnlinkCustomIDResult> pfResult = new PlayFabResult<UnlinkCustomIDResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Unlinks the related Facebook account from the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<UnlinkFacebookAccountResult>> UnlinkFacebookAccountAsync(UnlinkFacebookAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkFacebookAccountResult>>() {
            public PlayFabResult<UnlinkFacebookAccountResult> call() throws Exception {
                return privateUnlinkFacebookAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Facebook account from the user's PlayFab account
     */
    public static PlayFabResult<UnlinkFacebookAccountResult> UnlinkFacebookAccount(UnlinkFacebookAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkFacebookAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkFacebookAccountResult>>() {
            public PlayFabResult<UnlinkFacebookAccountResult> call() throws Exception {
                return privateUnlinkFacebookAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Unlinks the related Facebook account from the user's PlayFab account
     */
    private static PlayFabResult<UnlinkFacebookAccountResult> privateUnlinkFacebookAccountAsync(UnlinkFacebookAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UnlinkFacebookAccount", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkFacebookAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UnlinkFacebookAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkFacebookAccountResult>>(){}.getType()); 
        UnlinkFacebookAccountResult result = resultData.data;
        
        PlayFabResult<UnlinkFacebookAccountResult> pfResult = new PlayFabResult<UnlinkFacebookAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Unlinks the related Game Center account from the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<UnlinkGameCenterAccountResult>> UnlinkGameCenterAccountAsync(UnlinkGameCenterAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkGameCenterAccountResult>>() {
            public PlayFabResult<UnlinkGameCenterAccountResult> call() throws Exception {
                return privateUnlinkGameCenterAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Game Center account from the user's PlayFab account
     */
    public static PlayFabResult<UnlinkGameCenterAccountResult> UnlinkGameCenterAccount(UnlinkGameCenterAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkGameCenterAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkGameCenterAccountResult>>() {
            public PlayFabResult<UnlinkGameCenterAccountResult> call() throws Exception {
                return privateUnlinkGameCenterAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Unlinks the related Game Center account from the user's PlayFab account
     */
    private static PlayFabResult<UnlinkGameCenterAccountResult> privateUnlinkGameCenterAccountAsync(UnlinkGameCenterAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UnlinkGameCenterAccount", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkGameCenterAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UnlinkGameCenterAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkGameCenterAccountResult>>(){}.getType()); 
        UnlinkGameCenterAccountResult result = resultData.data;
        
        PlayFabResult<UnlinkGameCenterAccountResult> pfResult = new PlayFabResult<UnlinkGameCenterAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Unlinks the related Google account from the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<UnlinkGoogleAccountResult>> UnlinkGoogleAccountAsync(UnlinkGoogleAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkGoogleAccountResult>>() {
            public PlayFabResult<UnlinkGoogleAccountResult> call() throws Exception {
                return privateUnlinkGoogleAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Google account from the user's PlayFab account
     */
    public static PlayFabResult<UnlinkGoogleAccountResult> UnlinkGoogleAccount(UnlinkGoogleAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkGoogleAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkGoogleAccountResult>>() {
            public PlayFabResult<UnlinkGoogleAccountResult> call() throws Exception {
                return privateUnlinkGoogleAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Unlinks the related Google account from the user's PlayFab account
     */
    private static PlayFabResult<UnlinkGoogleAccountResult> privateUnlinkGoogleAccountAsync(UnlinkGoogleAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UnlinkGoogleAccount", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkGoogleAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UnlinkGoogleAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkGoogleAccountResult>>(){}.getType()); 
        UnlinkGoogleAccountResult result = resultData.data;
        
        PlayFabResult<UnlinkGoogleAccountResult> pfResult = new PlayFabResult<UnlinkGoogleAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Unlinks the related iOS device identifier from the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<UnlinkIOSDeviceIDResult>> UnlinkIOSDeviceIDAsync(UnlinkIOSDeviceIDRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkIOSDeviceIDResult>>() {
            public PlayFabResult<UnlinkIOSDeviceIDResult> call() throws Exception {
                return privateUnlinkIOSDeviceIDAsync(request);
            }
        });
    }

    /**
     * Unlinks the related iOS device identifier from the user's PlayFab account
     */
    public static PlayFabResult<UnlinkIOSDeviceIDResult> UnlinkIOSDeviceID(UnlinkIOSDeviceIDRequest request) {
        FutureTask<PlayFabResult<UnlinkIOSDeviceIDResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkIOSDeviceIDResult>>() {
            public PlayFabResult<UnlinkIOSDeviceIDResult> call() throws Exception {
                return privateUnlinkIOSDeviceIDAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Unlinks the related iOS device identifier from the user's PlayFab account
     */
    private static PlayFabResult<UnlinkIOSDeviceIDResult> privateUnlinkIOSDeviceIDAsync(UnlinkIOSDeviceIDRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UnlinkIOSDeviceID", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkIOSDeviceIDResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UnlinkIOSDeviceIDResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkIOSDeviceIDResult>>(){}.getType()); 
        UnlinkIOSDeviceIDResult result = resultData.data;
        
        PlayFabResult<UnlinkIOSDeviceIDResult> pfResult = new PlayFabResult<UnlinkIOSDeviceIDResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Unlinks the related Kongregate identifier from the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<UnlinkKongregateAccountResult>> UnlinkKongregateAsync(UnlinkKongregateAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkKongregateAccountResult>>() {
            public PlayFabResult<UnlinkKongregateAccountResult> call() throws Exception {
                return privateUnlinkKongregateAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Kongregate identifier from the user's PlayFab account
     */
    public static PlayFabResult<UnlinkKongregateAccountResult> UnlinkKongregate(UnlinkKongregateAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkKongregateAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkKongregateAccountResult>>() {
            public PlayFabResult<UnlinkKongregateAccountResult> call() throws Exception {
                return privateUnlinkKongregateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Unlinks the related Kongregate identifier from the user's PlayFab account
     */
    private static PlayFabResult<UnlinkKongregateAccountResult> privateUnlinkKongregateAsync(UnlinkKongregateAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UnlinkKongregate", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkKongregateAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UnlinkKongregateAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkKongregateAccountResult>>(){}.getType()); 
        UnlinkKongregateAccountResult result = resultData.data;
        
        PlayFabResult<UnlinkKongregateAccountResult> pfResult = new PlayFabResult<UnlinkKongregateAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Unlinks the related Steam account from the user's PlayFab account
     */
    public static FutureTask<PlayFabResult<UnlinkSteamAccountResult>> UnlinkSteamAccountAsync(UnlinkSteamAccountRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlinkSteamAccountResult>>() {
            public PlayFabResult<UnlinkSteamAccountResult> call() throws Exception {
                return privateUnlinkSteamAccountAsync(request);
            }
        });
    }

    /**
     * Unlinks the related Steam account from the user's PlayFab account
     */
    public static PlayFabResult<UnlinkSteamAccountResult> UnlinkSteamAccount(UnlinkSteamAccountRequest request) {
        FutureTask<PlayFabResult<UnlinkSteamAccountResult>> task = new FutureTask(new Callable<PlayFabResult<UnlinkSteamAccountResult>>() {
            public PlayFabResult<UnlinkSteamAccountResult> call() throws Exception {
                return privateUnlinkSteamAccountAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Unlinks the related Steam account from the user's PlayFab account
     */
    private static PlayFabResult<UnlinkSteamAccountResult> privateUnlinkSteamAccountAsync(UnlinkSteamAccountRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UnlinkSteamAccount", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlinkSteamAccountResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UnlinkSteamAccountResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlinkSteamAccountResult>>(){}.getType()); 
        UnlinkSteamAccountResult result = resultData.data;
        
        PlayFabResult<UnlinkSteamAccountResult> pfResult = new PlayFabResult<UnlinkSteamAccountResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the title specific display name for the user
     */
    public static FutureTask<PlayFabResult<UpdateUserTitleDisplayNameResult>> UpdateUserTitleDisplayNameAsync(UpdateUserTitleDisplayNameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserTitleDisplayNameResult>>() {
            public PlayFabResult<UpdateUserTitleDisplayNameResult> call() throws Exception {
                return privateUpdateUserTitleDisplayNameAsync(request);
            }
        });
    }

    /**
     * Updates the title specific display name for the user
     */
    public static PlayFabResult<UpdateUserTitleDisplayNameResult> UpdateUserTitleDisplayName(UpdateUserTitleDisplayNameRequest request) {
        FutureTask<PlayFabResult<UpdateUserTitleDisplayNameResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserTitleDisplayNameResult>>() {
            public PlayFabResult<UpdateUserTitleDisplayNameResult> call() throws Exception {
                return privateUpdateUserTitleDisplayNameAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the title specific display name for the user
     */
    private static PlayFabResult<UpdateUserTitleDisplayNameResult> privateUpdateUserTitleDisplayNameAsync(UpdateUserTitleDisplayNameRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UpdateUserTitleDisplayName", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserTitleDisplayNameResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserTitleDisplayNameResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserTitleDisplayNameResult>>(){}.getType()); 
        UpdateUserTitleDisplayNameResult result = resultData.data;
        
        PlayFabResult<UpdateUserTitleDisplayNameResult> pfResult = new PlayFabResult<UpdateUserTitleDisplayNameResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of ranked friends of the current player for the given statistic, starting from the indicated point in the leaderboard
     */
    public static FutureTask<PlayFabResult<GetLeaderboardResult>> GetFriendLeaderboardAsync(GetFriendLeaderboardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetFriendLeaderboardAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked friends of the current player for the given statistic, starting from the indicated point in the leaderboard
     */
    public static PlayFabResult<GetLeaderboardResult> GetFriendLeaderboard(GetFriendLeaderboardRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetFriendLeaderboardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of ranked friends of the current player for the given statistic, starting from the indicated point in the leaderboard
     */
    private static PlayFabResult<GetLeaderboardResult> privateGetFriendLeaderboardAsync(GetFriendLeaderboardRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetFriendLeaderboard", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetLeaderboardResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardResult>>(){}.getType()); 
        GetLeaderboardResult result = resultData.data;
        
        PlayFabResult<GetLeaderboardResult> pfResult = new PlayFabResult<GetLeaderboardResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard
     */
    public static FutureTask<PlayFabResult<GetLeaderboardResult>> GetLeaderboardAsync(GetLeaderboardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetLeaderboardAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard
     */
    public static PlayFabResult<GetLeaderboardResult> GetLeaderboard(GetLeaderboardRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardResult>>() {
            public PlayFabResult<GetLeaderboardResult> call() throws Exception {
                return privateGetLeaderboardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard
     */
    private static PlayFabResult<GetLeaderboardResult> privateGetLeaderboardAsync(GetLeaderboardRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetLeaderboard", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetLeaderboardResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardResult>>(){}.getType()); 
        GetLeaderboardResult result = resultData.data;
        
        PlayFabResult<GetLeaderboardResult> pfResult = new PlayFabResult<GetLeaderboardResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user
     */
    public static FutureTask<PlayFabResult<GetLeaderboardAroundCurrentUserResult>> GetLeaderboardAroundCurrentUserAsync(GetLeaderboardAroundCurrentUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundCurrentUserResult>>() {
            public PlayFabResult<GetLeaderboardAroundCurrentUserResult> call() throws Exception {
                return privateGetLeaderboardAroundCurrentUserAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user
     */
    public static PlayFabResult<GetLeaderboardAroundCurrentUserResult> GetLeaderboardAroundCurrentUser(GetLeaderboardAroundCurrentUserRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardAroundCurrentUserResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundCurrentUserResult>>() {
            public PlayFabResult<GetLeaderboardAroundCurrentUserResult> call() throws Exception {
                return privateGetLeaderboardAroundCurrentUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user
     */
    private static PlayFabResult<GetLeaderboardAroundCurrentUserResult> privateGetLeaderboardAroundCurrentUserAsync(GetLeaderboardAroundCurrentUserRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetLeaderboardAroundCurrentUser", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardAroundCurrentUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetLeaderboardAroundCurrentUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardAroundCurrentUserResult>>(){}.getType()); 
        GetLeaderboardAroundCurrentUserResult result = resultData.data;
        
        PlayFabResult<GetLeaderboardAroundCurrentUserResult> pfResult = new PlayFabResult<GetLeaderboardAroundCurrentUserResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the user which is readable and writable by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserDataAsync(GetUserDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetUserData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserPublisherData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the publisher-specific custom data for the user which is readable and writable by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherDataAsync(GetUserDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetUserPublisherData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the publisher-specific custom data for the user which can only be read by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserPublisherReadOnlyDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the publisher-specific custom data for the user which can only be read by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserPublisherReadOnlyData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserPublisherReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the publisher-specific custom data for the user which can only be read by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserPublisherReadOnlyDataAsync(GetUserDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetUserPublisherReadOnlyData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the user which can only be read by the client
     */
    public static FutureTask<PlayFabResult<GetUserDataResult>> GetUserReadOnlyDataAsync(GetUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the user which can only be read by the client
     */
    public static PlayFabResult<GetUserDataResult> GetUserReadOnlyData(GetUserDataRequest request) {
        FutureTask<PlayFabResult<GetUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserDataResult>>() {
            public PlayFabResult<GetUserDataResult> call() throws Exception {
                return privateGetUserReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the user which can only be read by the client
     */
    private static PlayFabResult<GetUserDataResult> privateGetUserReadOnlyDataAsync(GetUserDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetUserReadOnlyData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserDataResult>>(){}.getType()); 
        GetUserDataResult result = resultData.data;
        
        PlayFabResult<GetUserDataResult> pfResult = new PlayFabResult<GetUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the details of all title-specific statistics for the user
     */
    public static FutureTask<PlayFabResult<GetUserStatisticsResult>> GetUserStatisticsAsync(GetUserStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserStatisticsResult>>() {
            public PlayFabResult<GetUserStatisticsResult> call() throws Exception {
                return privateGetUserStatisticsAsync(request);
            }
        });
    }

    /**
     * Retrieves the details of all title-specific statistics for the user
     */
    public static PlayFabResult<GetUserStatisticsResult> GetUserStatistics(GetUserStatisticsRequest request) {
        FutureTask<PlayFabResult<GetUserStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserStatisticsResult>>() {
            public PlayFabResult<GetUserStatisticsResult> call() throws Exception {
                return privateGetUserStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the details of all title-specific statistics for the user
     */
    private static PlayFabResult<GetUserStatisticsResult> privateGetUserStatisticsAsync(GetUserStatisticsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetUserStatistics", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserStatisticsResult>>(){}.getType()); 
        GetUserStatisticsResult result = resultData.data;
        
        PlayFabResult<GetUserStatisticsResult> pfResult = new PlayFabResult<GetUserStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Creates and updates the title-specific custom data for the user which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserDataAsync(UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserDataAsync(request);
            }
        });
    }

    /**
     * Creates and updates the title-specific custom data for the user which is readable and writable by the client
     */
    public static PlayFabResult<UpdateUserDataResult> UpdateUserData(UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Creates and updates the title-specific custom data for the user which is readable and writable by the client
     */
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserDataAsync(UpdateUserDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UpdateUserData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType()); 
        UpdateUserDataResult result = resultData.data;
        
        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Creates and updates the publisher-specific custom data for the user which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<UpdateUserDataResult>> UpdateUserPublisherDataAsync(UpdateUserDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherDataAsync(request);
            }
        });
    }

    /**
     * Creates and updates the publisher-specific custom data for the user which is readable and writable by the client
     */
    public static PlayFabResult<UpdateUserDataResult> UpdateUserPublisherData(UpdateUserDataRequest request) {
        FutureTask<PlayFabResult<UpdateUserDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserDataResult>>() {
            public PlayFabResult<UpdateUserDataResult> call() throws Exception {
                return privateUpdateUserPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Creates and updates the publisher-specific custom data for the user which is readable and writable by the client
     */
    private static PlayFabResult<UpdateUserDataResult> privateUpdateUserPublisherDataAsync(UpdateUserDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UpdateUserPublisherData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserDataResult>>(){}.getType()); 
        UpdateUserDataResult result = resultData.data;
        
        PlayFabResult<UpdateUserDataResult> pfResult = new PlayFabResult<UpdateUserDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the values of the specified title-specific statistics for the user
     */
    public static FutureTask<PlayFabResult<UpdateUserStatisticsResult>> UpdateUserStatisticsAsync(UpdateUserStatisticsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateUserStatisticsResult>>() {
            public PlayFabResult<UpdateUserStatisticsResult> call() throws Exception {
                return privateUpdateUserStatisticsAsync(request);
            }
        });
    }

    /**
     * Updates the values of the specified title-specific statistics for the user
     */
    public static PlayFabResult<UpdateUserStatisticsResult> UpdateUserStatistics(UpdateUserStatisticsRequest request) {
        FutureTask<PlayFabResult<UpdateUserStatisticsResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateUserStatisticsResult>>() {
            public PlayFabResult<UpdateUserStatisticsResult> call() throws Exception {
                return privateUpdateUserStatisticsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the values of the specified title-specific statistics for the user
     */
    private static PlayFabResult<UpdateUserStatisticsResult> privateUpdateUserStatisticsAsync(UpdateUserStatisticsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UpdateUserStatistics", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateUserStatisticsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateUserStatisticsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateUserStatisticsResult>>(){}.getType()); 
        UpdateUserStatisticsResult result = resultData.data;
        
        PlayFabResult<UpdateUserStatisticsResult> pfResult = new PlayFabResult<UpdateUserStatisticsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     */
    public static FutureTask<PlayFabResult<GetCatalogItemsResult>> GetCatalogItemsAsync(GetCatalogItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCatalogItemsResult>>() {
            public PlayFabResult<GetCatalogItemsResult> call() throws Exception {
                return privateGetCatalogItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     */
    public static PlayFabResult<GetCatalogItemsResult> GetCatalogItems(GetCatalogItemsRequest request) {
        FutureTask<PlayFabResult<GetCatalogItemsResult>> task = new FutureTask(new Callable<PlayFabResult<GetCatalogItemsResult>>() {
            public PlayFabResult<GetCatalogItemsResult> call() throws Exception {
                return privateGetCatalogItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the specified version of the title's catalog of virtual goods, including all defined properties
     */
    private static PlayFabResult<GetCatalogItemsResult> privateGetCatalogItemsAsync(GetCatalogItemsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetCatalogItems", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCatalogItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCatalogItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCatalogItemsResult>>(){}.getType()); 
        GetCatalogItemsResult result = resultData.data;
        
        PlayFabResult<GetCatalogItemsResult> pfResult = new PlayFabResult<GetCatalogItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the set of items defined for the specified store, including all prices defined
     */
    public static FutureTask<PlayFabResult<GetStoreItemsResult>> GetStoreItemsAsync(GetStoreItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetStoreItemsResult>>() {
            public PlayFabResult<GetStoreItemsResult> call() throws Exception {
                return privateGetStoreItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves the set of items defined for the specified store, including all prices defined
     */
    public static PlayFabResult<GetStoreItemsResult> GetStoreItems(GetStoreItemsRequest request) {
        FutureTask<PlayFabResult<GetStoreItemsResult>> task = new FutureTask(new Callable<PlayFabResult<GetStoreItemsResult>>() {
            public PlayFabResult<GetStoreItemsResult> call() throws Exception {
                return privateGetStoreItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the set of items defined for the specified store, including all prices defined
     */
    private static PlayFabResult<GetStoreItemsResult> privateGetStoreItemsAsync(GetStoreItemsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetStoreItems", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetStoreItemsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetStoreItemsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetStoreItemsResult>>(){}.getType()); 
        GetStoreItemsResult result = resultData.data;
        
        PlayFabResult<GetStoreItemsResult> pfResult = new PlayFabResult<GetStoreItemsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the key-value store of custom title settings
     */
    public static FutureTask<PlayFabResult<GetTitleDataResult>> GetTitleDataAsync(GetTitleDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom title settings
     */
    public static PlayFabResult<GetTitleDataResult> GetTitleData(GetTitleDataRequest request) {
        FutureTask<PlayFabResult<GetTitleDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetTitleDataResult>>() {
            public PlayFabResult<GetTitleDataResult> call() throws Exception {
                return privateGetTitleDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the key-value store of custom title settings
     */
    private static PlayFabResult<GetTitleDataResult> privateGetTitleDataAsync(GetTitleDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetTitleData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetTitleDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleDataResult>>(){}.getType()); 
        GetTitleDataResult result = resultData.data;
        
        PlayFabResult<GetTitleDataResult> pfResult = new PlayFabResult<GetTitleDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title news feed, as configured in the developer portal
     */
    public static FutureTask<PlayFabResult<GetTitleNewsResult>> GetTitleNewsAsync(GetTitleNewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTitleNewsResult>>() {
            public PlayFabResult<GetTitleNewsResult> call() throws Exception {
                return privateGetTitleNewsAsync(request);
            }
        });
    }

    /**
     * Retrieves the title news feed, as configured in the developer portal
     */
    public static PlayFabResult<GetTitleNewsResult> GetTitleNews(GetTitleNewsRequest request) {
        FutureTask<PlayFabResult<GetTitleNewsResult>> task = new FutureTask(new Callable<PlayFabResult<GetTitleNewsResult>>() {
            public PlayFabResult<GetTitleNewsResult> call() throws Exception {
                return privateGetTitleNewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title news feed, as configured in the developer portal
     */
    private static PlayFabResult<GetTitleNewsResult> privateGetTitleNewsAsync(GetTitleNewsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetTitleNews", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTitleNewsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetTitleNewsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTitleNewsResult>>(){}.getType()); 
        GetTitleNewsResult result = resultData.data;
        
        PlayFabResult<GetTitleNewsResult> pfResult = new PlayFabResult<GetTitleNewsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Increments the user's balance of the specified virtual currency by the stated amount
     */
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> AddUserVirtualCurrencyAsync(AddUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateAddUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Increments the user's balance of the specified virtual currency by the stated amount
     */
    public static PlayFabResult<ModifyUserVirtualCurrencyResult> AddUserVirtualCurrency(AddUserVirtualCurrencyRequest request) {
        FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateAddUserVirtualCurrencyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Increments the user's balance of the specified virtual currency by the stated amount
     */
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateAddUserVirtualCurrencyAsync(AddUserVirtualCurrencyRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/AddUserVirtualCurrency", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult>>(){}.getType()); 
        ModifyUserVirtualCurrencyResult result = resultData.data;
        
        PlayFabResult<ModifyUserVirtualCurrencyResult> pfResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and virtual currency balances as appropriate
     */
    public static FutureTask<PlayFabResult<ConfirmPurchaseResult>> ConfirmPurchaseAsync(ConfirmPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ConfirmPurchaseResult>>() {
            public PlayFabResult<ConfirmPurchaseResult> call() throws Exception {
                return privateConfirmPurchaseAsync(request);
            }
        });
    }

    /**
     * Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and virtual currency balances as appropriate
     */
    public static PlayFabResult<ConfirmPurchaseResult> ConfirmPurchase(ConfirmPurchaseRequest request) {
        FutureTask<PlayFabResult<ConfirmPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<ConfirmPurchaseResult>>() {
            public PlayFabResult<ConfirmPurchaseResult> call() throws Exception {
                return privateConfirmPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and virtual currency balances as appropriate
     */
    private static PlayFabResult<ConfirmPurchaseResult> privateConfirmPurchaseAsync(ConfirmPurchaseRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/ConfirmPurchase", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ConfirmPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ConfirmPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ConfirmPurchaseResult>>(){}.getType()); 
        ConfirmPurchaseResult result = resultData.data;
        
        PlayFabResult<ConfirmPurchaseResult> pfResult = new PlayFabResult<ConfirmPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's inventory.
     */
    public static FutureTask<PlayFabResult<ConsumeItemResult>> ConsumeItemAsync(ConsumeItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ConsumeItemResult>>() {
            public PlayFabResult<ConsumeItemResult> call() throws Exception {
                return privateConsumeItemAsync(request);
            }
        });
    }

    /**
     * Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's inventory.
     */
    public static PlayFabResult<ConsumeItemResult> ConsumeItem(ConsumeItemRequest request) {
        FutureTask<PlayFabResult<ConsumeItemResult>> task = new FutureTask(new Callable<PlayFabResult<ConsumeItemResult>>() {
            public PlayFabResult<ConsumeItemResult> call() throws Exception {
                return privateConsumeItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's inventory.
     */
    private static PlayFabResult<ConsumeItemResult> privateConsumeItemAsync(ConsumeItemRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/ConsumeItem", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ConsumeItemResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ConsumeItemResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ConsumeItemResult>>(){}.getType()); 
        ConsumeItemResult result = resultData.data;
        
        PlayFabResult<ConsumeItemResult> pfResult = new PlayFabResult<ConsumeItemResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the specified character's current inventory of virtual goods
     */
    public static FutureTask<PlayFabResult<GetCharacterInventoryResult>> GetCharacterInventoryAsync(GetCharacterInventoryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterInventoryResult>>() {
            public PlayFabResult<GetCharacterInventoryResult> call() throws Exception {
                return privateGetCharacterInventoryAsync(request);
            }
        });
    }

    /**
     * Retrieves the specified character's current inventory of virtual goods
     */
    public static PlayFabResult<GetCharacterInventoryResult> GetCharacterInventory(GetCharacterInventoryRequest request) {
        FutureTask<PlayFabResult<GetCharacterInventoryResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterInventoryResult>>() {
            public PlayFabResult<GetCharacterInventoryResult> call() throws Exception {
                return privateGetCharacterInventoryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the specified character's current inventory of virtual goods
     */
    private static PlayFabResult<GetCharacterInventoryResult> privateGetCharacterInventoryAsync(GetCharacterInventoryRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetCharacterInventory", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterInventoryResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterInventoryResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterInventoryResult>>(){}.getType()); 
        GetCharacterInventoryResult result = resultData.data;
        
        PlayFabResult<GetCharacterInventoryResult> pfResult = new PlayFabResult<GetCharacterInventoryResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a completed purchase along with its current PlayFab status.
     */
    public static FutureTask<PlayFabResult<GetPurchaseResult>> GetPurchaseAsync(GetPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPurchaseResult>>() {
            public PlayFabResult<GetPurchaseResult> call() throws Exception {
                return privateGetPurchaseAsync(request);
            }
        });
    }

    /**
     * Retrieves a completed purchase along with its current PlayFab status.
     */
    public static PlayFabResult<GetPurchaseResult> GetPurchase(GetPurchaseRequest request) {
        FutureTask<PlayFabResult<GetPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<GetPurchaseResult>>() {
            public PlayFabResult<GetPurchaseResult> call() throws Exception {
                return privateGetPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a completed purchase along with its current PlayFab status.
     */
    private static PlayFabResult<GetPurchaseResult> privateGetPurchaseAsync(GetPurchaseRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetPurchase", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPurchaseResult>>(){}.getType()); 
        GetPurchaseResult result = resultData.data;
        
        PlayFabResult<GetPurchaseResult> pfResult = new PlayFabResult<GetPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the user's current inventory of virtual goods
     */
    public static FutureTask<PlayFabResult<GetUserInventoryResult>> GetUserInventoryAsync(GetUserInventoryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetUserInventoryResult>>() {
            public PlayFabResult<GetUserInventoryResult> call() throws Exception {
                return privateGetUserInventoryAsync(request);
            }
        });
    }

    /**
     * Retrieves the user's current inventory of virtual goods
     */
    public static PlayFabResult<GetUserInventoryResult> GetUserInventory(GetUserInventoryRequest request) {
        FutureTask<PlayFabResult<GetUserInventoryResult>> task = new FutureTask(new Callable<PlayFabResult<GetUserInventoryResult>>() {
            public PlayFabResult<GetUserInventoryResult> call() throws Exception {
                return privateGetUserInventoryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the user's current inventory of virtual goods
     */
    private static PlayFabResult<GetUserInventoryResult> privateGetUserInventoryAsync(GetUserInventoryRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetUserInventory", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetUserInventoryResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetUserInventoryResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetUserInventoryResult>>(){}.getType()); 
        GetUserInventoryResult result = resultData.data;
        
        PlayFabResult<GetUserInventoryResult> pfResult = new PlayFabResult<GetUserInventoryResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Selects a payment option for purchase order created via StartPurchase
     */
    public static FutureTask<PlayFabResult<PayForPurchaseResult>> PayForPurchaseAsync(PayForPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<PayForPurchaseResult>>() {
            public PlayFabResult<PayForPurchaseResult> call() throws Exception {
                return privatePayForPurchaseAsync(request);
            }
        });
    }

    /**
     * Selects a payment option for purchase order created via StartPurchase
     */
    public static PlayFabResult<PayForPurchaseResult> PayForPurchase(PayForPurchaseRequest request) {
        FutureTask<PlayFabResult<PayForPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<PayForPurchaseResult>>() {
            public PlayFabResult<PayForPurchaseResult> call() throws Exception {
                return privatePayForPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Selects a payment option for purchase order created via StartPurchase
     */
    private static PlayFabResult<PayForPurchaseResult> privatePayForPurchaseAsync(PayForPurchaseRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/PayForPurchase", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<PayForPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<PayForPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<PayForPurchaseResult>>(){}.getType()); 
        PayForPurchaseResult result = resultData.data;
        
        PlayFabResult<PayForPurchaseResult> pfResult = new PlayFabResult<PayForPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as well as what the client believes the price to be. This lets the server fail the purchase if the price has changed.
     */
    public static FutureTask<PlayFabResult<PurchaseItemResult>> PurchaseItemAsync(PurchaseItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<PurchaseItemResult>>() {
            public PlayFabResult<PurchaseItemResult> call() throws Exception {
                return privatePurchaseItemAsync(request);
            }
        });
    }

    /**
     * Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as well as what the client believes the price to be. This lets the server fail the purchase if the price has changed.
     */
    public static PlayFabResult<PurchaseItemResult> PurchaseItem(PurchaseItemRequest request) {
        FutureTask<PlayFabResult<PurchaseItemResult>> task = new FutureTask(new Callable<PlayFabResult<PurchaseItemResult>>() {
            public PlayFabResult<PurchaseItemResult> call() throws Exception {
                return privatePurchaseItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as well as what the client believes the price to be. This lets the server fail the purchase if the price has changed.
     */
    private static PlayFabResult<PurchaseItemResult> privatePurchaseItemAsync(PurchaseItemRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/PurchaseItem", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<PurchaseItemResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<PurchaseItemResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<PurchaseItemResult>>(){}.getType()); 
        PurchaseItemResult result = resultData.data;
        
        PlayFabResult<PurchaseItemResult> pfResult = new PlayFabResult<PurchaseItemResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds the virtual goods associated with the coupon to the user's inventory. Coupons can be generated  via the Promotions->Coupons tab in the PlayFab Game Manager. See this post for more information on coupons:  https://playfab.com/blog/using-stores-and-coupons-game-manager/
     */
    public static FutureTask<PlayFabResult<RedeemCouponResult>> RedeemCouponAsync(RedeemCouponRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RedeemCouponResult>>() {
            public PlayFabResult<RedeemCouponResult> call() throws Exception {
                return privateRedeemCouponAsync(request);
            }
        });
    }

    /**
     * Adds the virtual goods associated with the coupon to the user's inventory. Coupons can be generated  via the Promotions->Coupons tab in the PlayFab Game Manager. See this post for more information on coupons:  https://playfab.com/blog/using-stores-and-coupons-game-manager/
     */
    public static PlayFabResult<RedeemCouponResult> RedeemCoupon(RedeemCouponRequest request) {
        FutureTask<PlayFabResult<RedeemCouponResult>> task = new FutureTask(new Callable<PlayFabResult<RedeemCouponResult>>() {
            public PlayFabResult<RedeemCouponResult> call() throws Exception {
                return privateRedeemCouponAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds the virtual goods associated with the coupon to the user's inventory. Coupons can be generated  via the Promotions->Coupons tab in the PlayFab Game Manager. See this post for more information on coupons:  https://playfab.com/blog/using-stores-and-coupons-game-manager/
     */
    private static PlayFabResult<RedeemCouponResult> privateRedeemCouponAsync(RedeemCouponRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/RedeemCoupon", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RedeemCouponResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RedeemCouponResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RedeemCouponResult>>(){}.getType()); 
        RedeemCouponResult result = resultData.data;
        
        PlayFabResult<RedeemCouponResult> pfResult = new PlayFabResult<RedeemCouponResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Submit a report for another player (due to bad bahavior, etc.), so that customer service representatives for the title can take action concerning potentially toxic players.
     */
    public static FutureTask<PlayFabResult<ReportPlayerClientResult>> ReportPlayerAsync(ReportPlayerClientRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReportPlayerClientResult>>() {
            public PlayFabResult<ReportPlayerClientResult> call() throws Exception {
                return privateReportPlayerAsync(request);
            }
        });
    }

    /**
     * Submit a report for another player (due to bad bahavior, etc.), so that customer service representatives for the title can take action concerning potentially toxic players.
     */
    public static PlayFabResult<ReportPlayerClientResult> ReportPlayer(ReportPlayerClientRequest request) {
        FutureTask<PlayFabResult<ReportPlayerClientResult>> task = new FutureTask(new Callable<PlayFabResult<ReportPlayerClientResult>>() {
            public PlayFabResult<ReportPlayerClientResult> call() throws Exception {
                return privateReportPlayerAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Submit a report for another player (due to bad bahavior, etc.), so that customer service representatives for the title can take action concerning potentially toxic players.
     */
    private static PlayFabResult<ReportPlayerClientResult> privateReportPlayerAsync(ReportPlayerClientRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/ReportPlayer", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReportPlayerClientResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ReportPlayerClientResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReportPlayerClientResult>>(){}.getType()); 
        ReportPlayerClientResult result = resultData.data;
        
        PlayFabResult<ReportPlayerClientResult> pfResult = new PlayFabResult<ReportPlayerClientResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Creates an order for a list of items from the title catalog
     */
    public static FutureTask<PlayFabResult<StartPurchaseResult>> StartPurchaseAsync(StartPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<StartPurchaseResult>>() {
            public PlayFabResult<StartPurchaseResult> call() throws Exception {
                return privateStartPurchaseAsync(request);
            }
        });
    }

    /**
     * Creates an order for a list of items from the title catalog
     */
    public static PlayFabResult<StartPurchaseResult> StartPurchase(StartPurchaseRequest request) {
        FutureTask<PlayFabResult<StartPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<StartPurchaseResult>>() {
            public PlayFabResult<StartPurchaseResult> call() throws Exception {
                return privateStartPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Creates an order for a list of items from the title catalog
     */
    private static PlayFabResult<StartPurchaseResult> privateStartPurchaseAsync(StartPurchaseRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/StartPurchase", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<StartPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<StartPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<StartPurchaseResult>>(){}.getType()); 
        StartPurchaseResult result = resultData.data;
        
        PlayFabResult<StartPurchaseResult> pfResult = new PlayFabResult<StartPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Decrements the user's balance of the specified virtual currency by the stated amount
     */
    public static FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> SubtractUserVirtualCurrencyAsync(SubtractUserVirtualCurrencyRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateSubtractUserVirtualCurrencyAsync(request);
            }
        });
    }

    /**
     * Decrements the user's balance of the specified virtual currency by the stated amount
     */
    public static PlayFabResult<ModifyUserVirtualCurrencyResult> SubtractUserVirtualCurrency(SubtractUserVirtualCurrencyRequest request) {
        FutureTask<PlayFabResult<ModifyUserVirtualCurrencyResult>> task = new FutureTask(new Callable<PlayFabResult<ModifyUserVirtualCurrencyResult>>() {
            public PlayFabResult<ModifyUserVirtualCurrencyResult> call() throws Exception {
                return privateSubtractUserVirtualCurrencyAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Decrements the user's balance of the specified virtual currency by the stated amount
     */
    private static PlayFabResult<ModifyUserVirtualCurrencyResult> privateSubtractUserVirtualCurrencyAsync(SubtractUserVirtualCurrencyRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/SubtractUserVirtualCurrency", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ModifyUserVirtualCurrencyResult>>(){}.getType()); 
        ModifyUserVirtualCurrencyResult result = resultData.data;
        
        PlayFabResult<ModifyUserVirtualCurrencyResult> pfResult = new PlayFabResult<ModifyUserVirtualCurrencyResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Unlocks a container item in the user's inventory and consumes a key item of the type indicated by the container item
     */
    public static FutureTask<PlayFabResult<UnlockContainerItemResult>> UnlockContainerItemAsync(UnlockContainerItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UnlockContainerItemResult>>() {
            public PlayFabResult<UnlockContainerItemResult> call() throws Exception {
                return privateUnlockContainerItemAsync(request);
            }
        });
    }

    /**
     * Unlocks a container item in the user's inventory and consumes a key item of the type indicated by the container item
     */
    public static PlayFabResult<UnlockContainerItemResult> UnlockContainerItem(UnlockContainerItemRequest request) {
        FutureTask<PlayFabResult<UnlockContainerItemResult>> task = new FutureTask(new Callable<PlayFabResult<UnlockContainerItemResult>>() {
            public PlayFabResult<UnlockContainerItemResult> call() throws Exception {
                return privateUnlockContainerItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Unlocks a container item in the user's inventory and consumes a key item of the type indicated by the container item
     */
    private static PlayFabResult<UnlockContainerItemResult> privateUnlockContainerItemAsync(UnlockContainerItemRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UnlockContainerItem", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UnlockContainerItemResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UnlockContainerItemResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UnlockContainerItemResult>>(){}.getType()); 
        UnlockContainerItemResult result = resultData.data;
        
        PlayFabResult<UnlockContainerItemResult> pfResult = new PlayFabResult<UnlockContainerItemResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds the PlayFab user, based upon a match against a supplied unique identifier, to the friend list of the local user. At least one of FriendPlayFabId,FriendUsername,FriendEmail, or FriendTitleDisplayName should be initialized.
     */
    public static FutureTask<PlayFabResult<AddFriendResult>> AddFriendAsync(AddFriendRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddFriendResult>>() {
            public PlayFabResult<AddFriendResult> call() throws Exception {
                return privateAddFriendAsync(request);
            }
        });
    }

    /**
     * Adds the PlayFab user, based upon a match against a supplied unique identifier, to the friend list of the local user. At least one of FriendPlayFabId,FriendUsername,FriendEmail, or FriendTitleDisplayName should be initialized.
     */
    public static PlayFabResult<AddFriendResult> AddFriend(AddFriendRequest request) {
        FutureTask<PlayFabResult<AddFriendResult>> task = new FutureTask(new Callable<PlayFabResult<AddFriendResult>>() {
            public PlayFabResult<AddFriendResult> call() throws Exception {
                return privateAddFriendAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds the PlayFab user, based upon a match against a supplied unique identifier, to the friend list of the local user. At least one of FriendPlayFabId,FriendUsername,FriendEmail, or FriendTitleDisplayName should be initialized.
     */
    private static PlayFabResult<AddFriendResult> privateAddFriendAsync(AddFriendRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/AddFriend", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddFriendResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AddFriendResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddFriendResult>>(){}.getType()); 
        AddFriendResult result = resultData.data;
        
        PlayFabResult<AddFriendResult> pfResult = new PlayFabResult<AddFriendResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the current friend list for the local user, constrained to users who have PlayFab accounts. Friends from linked accounts (Facebook, Steam) are also included. You may optionally exclude some linked services' friends.
     */
    public static FutureTask<PlayFabResult<GetFriendsListResult>> GetFriendsListAsync(GetFriendsListRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetFriendsListResult>>() {
            public PlayFabResult<GetFriendsListResult> call() throws Exception {
                return privateGetFriendsListAsync(request);
            }
        });
    }

    /**
     * Retrieves the current friend list for the local user, constrained to users who have PlayFab accounts. Friends from linked accounts (Facebook, Steam) are also included. You may optionally exclude some linked services' friends.
     */
    public static PlayFabResult<GetFriendsListResult> GetFriendsList(GetFriendsListRequest request) {
        FutureTask<PlayFabResult<GetFriendsListResult>> task = new FutureTask(new Callable<PlayFabResult<GetFriendsListResult>>() {
            public PlayFabResult<GetFriendsListResult> call() throws Exception {
                return privateGetFriendsListAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the current friend list for the local user, constrained to users who have PlayFab accounts. Friends from linked accounts (Facebook, Steam) are also included. You may optionally exclude some linked services' friends.
     */
    private static PlayFabResult<GetFriendsListResult> privateGetFriendsListAsync(GetFriendsListRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetFriendsList", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetFriendsListResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetFriendsListResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetFriendsListResult>>(){}.getType()); 
        GetFriendsListResult result = resultData.data;
        
        PlayFabResult<GetFriendsListResult> pfResult = new PlayFabResult<GetFriendsListResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Removes a specified user from the friend list of the local user
     */
    public static FutureTask<PlayFabResult<RemoveFriendResult>> RemoveFriendAsync(RemoveFriendRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemoveFriendResult>>() {
            public PlayFabResult<RemoveFriendResult> call() throws Exception {
                return privateRemoveFriendAsync(request);
            }
        });
    }

    /**
     * Removes a specified user from the friend list of the local user
     */
    public static PlayFabResult<RemoveFriendResult> RemoveFriend(RemoveFriendRequest request) {
        FutureTask<PlayFabResult<RemoveFriendResult>> task = new FutureTask(new Callable<PlayFabResult<RemoveFriendResult>>() {
            public PlayFabResult<RemoveFriendResult> call() throws Exception {
                return privateRemoveFriendAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Removes a specified user from the friend list of the local user
     */
    private static PlayFabResult<RemoveFriendResult> privateRemoveFriendAsync(RemoveFriendRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/RemoveFriend", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RemoveFriendResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RemoveFriendResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RemoveFriendResult>>(){}.getType()); 
        RemoveFriendResult result = resultData.data;
        
        PlayFabResult<RemoveFriendResult> pfResult = new PlayFabResult<RemoveFriendResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Updates the tag list for a specified user in the friend list of the local user
     */
    public static FutureTask<PlayFabResult<SetFriendTagsResult>> SetFriendTagsAsync(SetFriendTagsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetFriendTagsResult>>() {
            public PlayFabResult<SetFriendTagsResult> call() throws Exception {
                return privateSetFriendTagsAsync(request);
            }
        });
    }

    /**
     * Updates the tag list for a specified user in the friend list of the local user
     */
    public static PlayFabResult<SetFriendTagsResult> SetFriendTags(SetFriendTagsRequest request) {
        FutureTask<PlayFabResult<SetFriendTagsResult>> task = new FutureTask(new Callable<PlayFabResult<SetFriendTagsResult>>() {
            public PlayFabResult<SetFriendTagsResult> call() throws Exception {
                return privateSetFriendTagsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Updates the tag list for a specified user in the friend list of the local user
     */
    private static PlayFabResult<SetFriendTagsResult> privateSetFriendTagsAsync(SetFriendTagsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/SetFriendTags", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetFriendTagsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<SetFriendTagsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetFriendTagsResult>>(){}.getType()); 
        SetFriendTagsResult result = resultData.data;
        
        PlayFabResult<SetFriendTagsResult> pfResult = new PlayFabResult<SetFriendTagsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Registers the iOS device to receive push notifications
     */
    public static FutureTask<PlayFabResult<RegisterForIOSPushNotificationResult>> RegisterForIOSPushNotificationAsync(RegisterForIOSPushNotificationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RegisterForIOSPushNotificationResult>>() {
            public PlayFabResult<RegisterForIOSPushNotificationResult> call() throws Exception {
                return privateRegisterForIOSPushNotificationAsync(request);
            }
        });
    }

    /**
     * Registers the iOS device to receive push notifications
     */
    public static PlayFabResult<RegisterForIOSPushNotificationResult> RegisterForIOSPushNotification(RegisterForIOSPushNotificationRequest request) {
        FutureTask<PlayFabResult<RegisterForIOSPushNotificationResult>> task = new FutureTask(new Callable<PlayFabResult<RegisterForIOSPushNotificationResult>>() {
            public PlayFabResult<RegisterForIOSPushNotificationResult> call() throws Exception {
                return privateRegisterForIOSPushNotificationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Registers the iOS device to receive push notifications
     */
    private static PlayFabResult<RegisterForIOSPushNotificationResult> privateRegisterForIOSPushNotificationAsync(RegisterForIOSPushNotificationRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/RegisterForIOSPushNotification", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RegisterForIOSPushNotificationResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RegisterForIOSPushNotificationResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RegisterForIOSPushNotificationResult>>(){}.getType()); 
        RegisterForIOSPushNotificationResult result = resultData.data;
        
        PlayFabResult<RegisterForIOSPushNotificationResult> pfResult = new PlayFabResult<RegisterForIOSPushNotificationResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Restores all in-app purchases based on the given refresh receipt.
     */
    public static FutureTask<PlayFabResult<RestoreIOSPurchasesResult>> RestoreIOSPurchasesAsync(RestoreIOSPurchasesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RestoreIOSPurchasesResult>>() {
            public PlayFabResult<RestoreIOSPurchasesResult> call() throws Exception {
                return privateRestoreIOSPurchasesAsync(request);
            }
        });
    }

    /**
     * Restores all in-app purchases based on the given refresh receipt.
     */
    public static PlayFabResult<RestoreIOSPurchasesResult> RestoreIOSPurchases(RestoreIOSPurchasesRequest request) {
        FutureTask<PlayFabResult<RestoreIOSPurchasesResult>> task = new FutureTask(new Callable<PlayFabResult<RestoreIOSPurchasesResult>>() {
            public PlayFabResult<RestoreIOSPurchasesResult> call() throws Exception {
                return privateRestoreIOSPurchasesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Restores all in-app purchases based on the given refresh receipt.
     */
    private static PlayFabResult<RestoreIOSPurchasesResult> privateRestoreIOSPurchasesAsync(RestoreIOSPurchasesRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/RestoreIOSPurchases", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RestoreIOSPurchasesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RestoreIOSPurchasesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RestoreIOSPurchasesResult>>(){}.getType()); 
        RestoreIOSPurchasesResult result = resultData.data;
        
        PlayFabResult<RestoreIOSPurchasesResult> pfResult = new PlayFabResult<RestoreIOSPurchasesResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the purchased catalog item
     */
    public static FutureTask<PlayFabResult<ValidateIOSReceiptResult>> ValidateIOSReceiptAsync(ValidateIOSReceiptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ValidateIOSReceiptResult>>() {
            public PlayFabResult<ValidateIOSReceiptResult> call() throws Exception {
                return privateValidateIOSReceiptAsync(request);
            }
        });
    }

    /**
     * Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the purchased catalog item
     */
    public static PlayFabResult<ValidateIOSReceiptResult> ValidateIOSReceipt(ValidateIOSReceiptRequest request) {
        FutureTask<PlayFabResult<ValidateIOSReceiptResult>> task = new FutureTask(new Callable<PlayFabResult<ValidateIOSReceiptResult>>() {
            public PlayFabResult<ValidateIOSReceiptResult> call() throws Exception {
                return privateValidateIOSReceiptAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the purchased catalog item
     */
    private static PlayFabResult<ValidateIOSReceiptResult> privateValidateIOSReceiptAsync(ValidateIOSReceiptRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/ValidateIOSReceipt", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ValidateIOSReceiptResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ValidateIOSReceiptResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ValidateIOSReceiptResult>>(){}.getType()); 
        ValidateIOSReceiptResult result = resultData.data;
        
        PlayFabResult<ValidateIOSReceiptResult> pfResult = new PlayFabResult<ValidateIOSReceiptResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Get details about all current running game servers matching the given parameters.
     */
    public static FutureTask<PlayFabResult<CurrentGamesResult>> GetCurrentGamesAsync(CurrentGamesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CurrentGamesResult>>() {
            public PlayFabResult<CurrentGamesResult> call() throws Exception {
                return privateGetCurrentGamesAsync(request);
            }
        });
    }

    /**
     * Get details about all current running game servers matching the given parameters.
     */
    public static PlayFabResult<CurrentGamesResult> GetCurrentGames(CurrentGamesRequest request) {
        FutureTask<PlayFabResult<CurrentGamesResult>> task = new FutureTask(new Callable<PlayFabResult<CurrentGamesResult>>() {
            public PlayFabResult<CurrentGamesResult> call() throws Exception {
                return privateGetCurrentGamesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Get details about all current running game servers matching the given parameters.
     */
    private static PlayFabResult<CurrentGamesResult> privateGetCurrentGamesAsync(CurrentGamesRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetCurrentGames", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CurrentGamesResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<CurrentGamesResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CurrentGamesResult>>(){}.getType()); 
        CurrentGamesResult result = resultData.data;
        
        PlayFabResult<CurrentGamesResult> pfResult = new PlayFabResult<CurrentGamesResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     *  Get details about the regions hosting game servers matching the given parameters.
     */
    public static FutureTask<PlayFabResult<GameServerRegionsResult>> GetGameServerRegionsAsync(GameServerRegionsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GameServerRegionsResult>>() {
            public PlayFabResult<GameServerRegionsResult> call() throws Exception {
                return privateGetGameServerRegionsAsync(request);
            }
        });
    }

    /**
     *  Get details about the regions hosting game servers matching the given parameters.
     */
    public static PlayFabResult<GameServerRegionsResult> GetGameServerRegions(GameServerRegionsRequest request) {
        FutureTask<PlayFabResult<GameServerRegionsResult>> task = new FutureTask(new Callable<PlayFabResult<GameServerRegionsResult>>() {
            public PlayFabResult<GameServerRegionsResult> call() throws Exception {
                return privateGetGameServerRegionsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     *  Get details about the regions hosting game servers matching the given parameters.
     */
    private static PlayFabResult<GameServerRegionsResult> privateGetGameServerRegionsAsync(GameServerRegionsRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetGameServerRegions", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GameServerRegionsResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GameServerRegionsResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GameServerRegionsResult>>(){}.getType()); 
        GameServerRegionsResult result = resultData.data;
        
        PlayFabResult<GameServerRegionsResult> pfResult = new PlayFabResult<GameServerRegionsResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Attempts to locate a game session matching the given parameters. Note that parameters specified in the search are required (they are not weighting factors). If a slot is found in a server instance matching the parameters, the slot will be assigned to that player, removing it from the availabe set. In that case, the information on the game session will be returned, otherwise the Status returned will be GameNotFound. Note that EnableQueue is deprecated at this time.
     */
    public static FutureTask<PlayFabResult<MatchmakeResult>> MatchmakeAsync(MatchmakeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<MatchmakeResult>>() {
            public PlayFabResult<MatchmakeResult> call() throws Exception {
                return privateMatchmakeAsync(request);
            }
        });
    }

    /**
     * Attempts to locate a game session matching the given parameters. Note that parameters specified in the search are required (they are not weighting factors). If a slot is found in a server instance matching the parameters, the slot will be assigned to that player, removing it from the availabe set. In that case, the information on the game session will be returned, otherwise the Status returned will be GameNotFound. Note that EnableQueue is deprecated at this time.
     */
    public static PlayFabResult<MatchmakeResult> Matchmake(MatchmakeRequest request) {
        FutureTask<PlayFabResult<MatchmakeResult>> task = new FutureTask(new Callable<PlayFabResult<MatchmakeResult>>() {
            public PlayFabResult<MatchmakeResult> call() throws Exception {
                return privateMatchmakeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Attempts to locate a game session matching the given parameters. Note that parameters specified in the search are required (they are not weighting factors). If a slot is found in a server instance matching the parameters, the slot will be assigned to that player, removing it from the availabe set. In that case, the information on the game session will be returned, otherwise the Status returned will be GameNotFound. Note that EnableQueue is deprecated at this time.
     */
    private static PlayFabResult<MatchmakeResult> privateMatchmakeAsync(MatchmakeRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/Matchmake", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<MatchmakeResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<MatchmakeResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<MatchmakeResult>>(){}.getType()); 
        MatchmakeResult result = resultData.data;
        
        PlayFabResult<MatchmakeResult> pfResult = new PlayFabResult<MatchmakeResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Start a new game server with a given configuration, add the current player and return the connection information.
     */
    public static FutureTask<PlayFabResult<StartGameResult>> StartGameAsync(StartGameRequest request) {
        return new FutureTask(new Callable<PlayFabResult<StartGameResult>>() {
            public PlayFabResult<StartGameResult> call() throws Exception {
                return privateStartGameAsync(request);
            }
        });
    }

    /**
     * Start a new game server with a given configuration, add the current player and return the connection information.
     */
    public static PlayFabResult<StartGameResult> StartGame(StartGameRequest request) {
        FutureTask<PlayFabResult<StartGameResult>> task = new FutureTask(new Callable<PlayFabResult<StartGameResult>>() {
            public PlayFabResult<StartGameResult> call() throws Exception {
                return privateStartGameAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Start a new game server with a given configuration, add the current player and return the connection information.
     */
    private static PlayFabResult<StartGameResult> privateStartGameAsync(StartGameRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/StartGame", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<StartGameResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<StartGameResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<StartGameResult>>(){}.getType()); 
        StartGameResult result = resultData.data;
        
        PlayFabResult<StartGameResult> pfResult = new PlayFabResult<StartGameResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Registers the Android device to receive push notifications
     */
    public static FutureTask<PlayFabResult<AndroidDevicePushNotificationRegistrationResult>> AndroidDevicePushNotificationRegistrationAsync(AndroidDevicePushNotificationRegistrationRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AndroidDevicePushNotificationRegistrationResult>>() {
            public PlayFabResult<AndroidDevicePushNotificationRegistrationResult> call() throws Exception {
                return privateAndroidDevicePushNotificationRegistrationAsync(request);
            }
        });
    }

    /**
     * Registers the Android device to receive push notifications
     */
    public static PlayFabResult<AndroidDevicePushNotificationRegistrationResult> AndroidDevicePushNotificationRegistration(AndroidDevicePushNotificationRegistrationRequest request) {
        FutureTask<PlayFabResult<AndroidDevicePushNotificationRegistrationResult>> task = new FutureTask(new Callable<PlayFabResult<AndroidDevicePushNotificationRegistrationResult>>() {
            public PlayFabResult<AndroidDevicePushNotificationRegistrationResult> call() throws Exception {
                return privateAndroidDevicePushNotificationRegistrationAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Registers the Android device to receive push notifications
     */
    private static PlayFabResult<AndroidDevicePushNotificationRegistrationResult> privateAndroidDevicePushNotificationRegistrationAsync(AndroidDevicePushNotificationRegistrationRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/AndroidDevicePushNotificationRegistration", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AndroidDevicePushNotificationRegistrationResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AndroidDevicePushNotificationRegistrationResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AndroidDevicePushNotificationRegistrationResult>>(){}.getType()); 
        AndroidDevicePushNotificationRegistrationResult result = resultData.data;
        
        PlayFabResult<AndroidDevicePushNotificationRegistrationResult> pfResult = new PlayFabResult<AndroidDevicePushNotificationRegistrationResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Validates a Google Play purchase and gives the corresponding item to the player.
     */
    public static FutureTask<PlayFabResult<ValidateGooglePlayPurchaseResult>> ValidateGooglePlayPurchaseAsync(ValidateGooglePlayPurchaseRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ValidateGooglePlayPurchaseResult>>() {
            public PlayFabResult<ValidateGooglePlayPurchaseResult> call() throws Exception {
                return privateValidateGooglePlayPurchaseAsync(request);
            }
        });
    }

    /**
     * Validates a Google Play purchase and gives the corresponding item to the player.
     */
    public static PlayFabResult<ValidateGooglePlayPurchaseResult> ValidateGooglePlayPurchase(ValidateGooglePlayPurchaseRequest request) {
        FutureTask<PlayFabResult<ValidateGooglePlayPurchaseResult>> task = new FutureTask(new Callable<PlayFabResult<ValidateGooglePlayPurchaseResult>>() {
            public PlayFabResult<ValidateGooglePlayPurchaseResult> call() throws Exception {
                return privateValidateGooglePlayPurchaseAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Validates a Google Play purchase and gives the corresponding item to the player.
     */
    private static PlayFabResult<ValidateGooglePlayPurchaseResult> privateValidateGooglePlayPurchaseAsync(ValidateGooglePlayPurchaseRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/ValidateGooglePlayPurchase", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ValidateGooglePlayPurchaseResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ValidateGooglePlayPurchaseResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ValidateGooglePlayPurchaseResult>>(){}.getType()); 
        ValidateGooglePlayPurchaseResult result = resultData.data;
        
        PlayFabResult<ValidateGooglePlayPurchaseResult> pfResult = new PlayFabResult<ValidateGooglePlayPurchaseResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Logs a custom analytics event
     */
    public static FutureTask<PlayFabResult<LogEventResult>> LogEventAsync(LogEventRequest request) {
        return new FutureTask(new Callable<PlayFabResult<LogEventResult>>() {
            public PlayFabResult<LogEventResult> call() throws Exception {
                return privateLogEventAsync(request);
            }
        });
    }

    /**
     * Logs a custom analytics event
     */
    public static PlayFabResult<LogEventResult> LogEvent(LogEventRequest request) {
        FutureTask<PlayFabResult<LogEventResult>> task = new FutureTask(new Callable<PlayFabResult<LogEventResult>>() {
            public PlayFabResult<LogEventResult> call() throws Exception {
                return privateLogEventAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Logs a custom analytics event
     */
    private static PlayFabResult<LogEventResult> privateLogEventAsync(LogEventRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/LogEvent", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<LogEventResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<LogEventResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<LogEventResult>>(){}.getType()); 
        LogEventResult result = resultData.data;
        
        PlayFabResult<LogEventResult> pfResult = new PlayFabResult<LogEventResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users in the group can add new members.
     */
    public static FutureTask<PlayFabResult<AddSharedGroupMembersResult>> AddSharedGroupMembersAsync(AddSharedGroupMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AddSharedGroupMembersResult>>() {
            public PlayFabResult<AddSharedGroupMembersResult> call() throws Exception {
                return privateAddSharedGroupMembersAsync(request);
            }
        });
    }

    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users in the group can add new members.
     */
    public static PlayFabResult<AddSharedGroupMembersResult> AddSharedGroupMembers(AddSharedGroupMembersRequest request) {
        FutureTask<PlayFabResult<AddSharedGroupMembersResult>> task = new FutureTask(new Callable<PlayFabResult<AddSharedGroupMembersResult>>() {
            public PlayFabResult<AddSharedGroupMembersResult> call() throws Exception {
                return privateAddSharedGroupMembersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users in the group can add new members.
     */
    private static PlayFabResult<AddSharedGroupMembersResult> privateAddSharedGroupMembersAsync(AddSharedGroupMembersRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/AddSharedGroupMembers", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AddSharedGroupMembersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AddSharedGroupMembersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AddSharedGroupMembersResult>>(){}.getType()); 
        AddSharedGroupMembersResult result = resultData.data;
        
        PlayFabResult<AddSharedGroupMembersResult> pfResult = new PlayFabResult<AddSharedGroupMembersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the group. Upon creation, the current user will be the only member of the group.
     */
    public static FutureTask<PlayFabResult<CreateSharedGroupResult>> CreateSharedGroupAsync(CreateSharedGroupRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateSharedGroupResult>>() {
            public PlayFabResult<CreateSharedGroupResult> call() throws Exception {
                return privateCreateSharedGroupAsync(request);
            }
        });
    }

    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the group. Upon creation, the current user will be the only member of the group.
     */
    public static PlayFabResult<CreateSharedGroupResult> CreateSharedGroup(CreateSharedGroupRequest request) {
        FutureTask<PlayFabResult<CreateSharedGroupResult>> task = new FutureTask(new Callable<PlayFabResult<CreateSharedGroupResult>>() {
            public PlayFabResult<CreateSharedGroupResult> call() throws Exception {
                return privateCreateSharedGroupAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the group. Upon creation, the current user will be the only member of the group.
     */
    private static PlayFabResult<CreateSharedGroupResult> privateCreateSharedGroupAsync(CreateSharedGroupRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/CreateSharedGroup", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateSharedGroupResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<CreateSharedGroupResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateSharedGroupResult>>(){}.getType()); 
        CreateSharedGroupResult result = resultData.data;
        
        PlayFabResult<CreateSharedGroupResult> pfResult = new PlayFabResult<CreateSharedGroupResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the key-value store of custom publisher settings
     */
    public static FutureTask<PlayFabResult<GetPublisherDataResult>> GetPublisherDataAsync(GetPublisherDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPublisherDataResult>>() {
            public PlayFabResult<GetPublisherDataResult> call() throws Exception {
                return privateGetPublisherDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the key-value store of custom publisher settings
     */
    public static PlayFabResult<GetPublisherDataResult> GetPublisherData(GetPublisherDataRequest request) {
        FutureTask<PlayFabResult<GetPublisherDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetPublisherDataResult>>() {
            public PlayFabResult<GetPublisherDataResult> call() throws Exception {
                return privateGetPublisherDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the key-value store of custom publisher settings
     */
    private static PlayFabResult<GetPublisherDataResult> privateGetPublisherDataAsync(GetPublisherDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetPublisherData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPublisherDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPublisherDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPublisherDataResult>>(){}.getType()); 
        GetPublisherDataResult result = resultData.data;
        
        PlayFabResult<GetPublisherDataResult> pfResult = new PlayFabResult<GetPublisherDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. Non-members of the group may use this to retrieve group data, including membership, but they will not receive data for keys marked as private.
     */
    public static FutureTask<PlayFabResult<GetSharedGroupDataResult>> GetSharedGroupDataAsync(GetSharedGroupDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetSharedGroupDataResult>>() {
            public PlayFabResult<GetSharedGroupDataResult> call() throws Exception {
                return privateGetSharedGroupDataAsync(request);
            }
        });
    }

    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. Non-members of the group may use this to retrieve group data, including membership, but they will not receive data for keys marked as private.
     */
    public static PlayFabResult<GetSharedGroupDataResult> GetSharedGroupData(GetSharedGroupDataRequest request) {
        FutureTask<PlayFabResult<GetSharedGroupDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetSharedGroupDataResult>>() {
            public PlayFabResult<GetSharedGroupDataResult> call() throws Exception {
                return privateGetSharedGroupDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves data stored in a shared group object, as well as the list of members in the group. Non-members of the group may use this to retrieve group data, including membership, but they will not receive data for keys marked as private.
     */
    private static PlayFabResult<GetSharedGroupDataResult> privateGetSharedGroupDataAsync(GetSharedGroupDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetSharedGroupData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetSharedGroupDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetSharedGroupDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetSharedGroupDataResult>>(){}.getType()); 
        GetSharedGroupDataResult result = resultData.data;
        
        PlayFabResult<GetSharedGroupDataResult> pfResult = new PlayFabResult<GetSharedGroupDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the group can remove members. If as a result of the call, zero users remain with access, the group and its associated data will be deleted.
     */
    public static FutureTask<PlayFabResult<RemoveSharedGroupMembersResult>> RemoveSharedGroupMembersAsync(RemoveSharedGroupMembersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RemoveSharedGroupMembersResult>>() {
            public PlayFabResult<RemoveSharedGroupMembersResult> call() throws Exception {
                return privateRemoveSharedGroupMembersAsync(request);
            }
        });
    }

    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the group can remove members. If as a result of the call, zero users remain with access, the group and its associated data will be deleted.
     */
    public static PlayFabResult<RemoveSharedGroupMembersResult> RemoveSharedGroupMembers(RemoveSharedGroupMembersRequest request) {
        FutureTask<PlayFabResult<RemoveSharedGroupMembersResult>> task = new FutureTask(new Callable<PlayFabResult<RemoveSharedGroupMembersResult>>() {
            public PlayFabResult<RemoveSharedGroupMembersResult> call() throws Exception {
                return privateRemoveSharedGroupMembersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the group can remove members. If as a result of the call, zero users remain with access, the group and its associated data will be deleted.
     */
    private static PlayFabResult<RemoveSharedGroupMembersResult> privateRemoveSharedGroupMembersAsync(RemoveSharedGroupMembersRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/RemoveSharedGroupMembers", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RemoveSharedGroupMembersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RemoveSharedGroupMembersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RemoveSharedGroupMembersResult>>(){}.getType()); 
        RemoveSharedGroupMembersResult result = resultData.data;
        
        PlayFabResult<RemoveSharedGroupMembersResult> pfResult = new PlayFabResult<RemoveSharedGroupMembersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated or added in this call will be readable by users not in the group. By default, data permissions are set to Private. Regardless of the permission setting, only members of the group can update the data.
     */
    public static FutureTask<PlayFabResult<UpdateSharedGroupDataResult>> UpdateSharedGroupDataAsync(UpdateSharedGroupDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateSharedGroupDataResult>>() {
            public PlayFabResult<UpdateSharedGroupDataResult> call() throws Exception {
                return privateUpdateSharedGroupDataAsync(request);
            }
        });
    }

    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated or added in this call will be readable by users not in the group. By default, data permissions are set to Private. Regardless of the permission setting, only members of the group can update the data.
     */
    public static PlayFabResult<UpdateSharedGroupDataResult> UpdateSharedGroupData(UpdateSharedGroupDataRequest request) {
        FutureTask<PlayFabResult<UpdateSharedGroupDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateSharedGroupDataResult>>() {
            public PlayFabResult<UpdateSharedGroupDataResult> call() throws Exception {
                return privateUpdateSharedGroupDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated or added in this call will be readable by users not in the group. By default, data permissions are set to Private. Regardless of the permission setting, only members of the group can update the data.
     */
    private static PlayFabResult<UpdateSharedGroupDataResult> privateUpdateSharedGroupDataAsync(UpdateSharedGroupDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UpdateSharedGroupData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateSharedGroupDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateSharedGroupDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateSharedGroupDataResult>>(){}.getType()); 
        UpdateSharedGroupDataResult result = resultData.data;
        
        PlayFabResult<UpdateSharedGroupDataResult> pfResult = new PlayFabResult<UpdateSharedGroupDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific URL for Cloud Script servers. This must be queried once, prior  to making any calls to RunCloudScript.
     */
    public static FutureTask<PlayFabResult<GetCloudScriptUrlResult>> GetCloudScriptUrlAsync(GetCloudScriptUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCloudScriptUrlResult>>() {
            public PlayFabResult<GetCloudScriptUrlResult> call() throws Exception {
                return privateGetCloudScriptUrlAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific URL for Cloud Script servers. This must be queried once, prior  to making any calls to RunCloudScript.
     */
    public static PlayFabResult<GetCloudScriptUrlResult> GetCloudScriptUrl(GetCloudScriptUrlRequest request) {
        FutureTask<PlayFabResult<GetCloudScriptUrlResult>> task = new FutureTask(new Callable<PlayFabResult<GetCloudScriptUrlResult>>() {
            public PlayFabResult<GetCloudScriptUrlResult> call() throws Exception {
                return privateGetCloudScriptUrlAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific URL for Cloud Script servers. This must be queried once, prior  to making any calls to RunCloudScript.
     */
    private static PlayFabResult<GetCloudScriptUrlResult> privateGetCloudScriptUrlAsync(GetCloudScriptUrlRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetCloudScriptUrl", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCloudScriptUrlResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCloudScriptUrlResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCloudScriptUrlResult>>(){}.getType()); 
        GetCloudScriptUrlResult result = resultData.data;
        PlayFabSettings.LogicServerURL = result.Url;

        PlayFabResult<GetCloudScriptUrlResult> pfResult = new PlayFabResult<GetCloudScriptUrlResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Triggers a particular server action, passing the provided inputs to the hosted Cloud Script. An action in this context is a handler in the JavaScript. NOTE: Before calling this API, you must call GetCloudScriptUrl to be assigned a Cloud Script server URL. When using an official PlayFab SDK, this URL is stored internally in the SDK, but GetCloudScriptUrl must still be manually called.
     */
    public static FutureTask<PlayFabResult<RunCloudScriptResult>> RunCloudScriptAsync(RunCloudScriptRequest request) {
        return new FutureTask(new Callable<PlayFabResult<RunCloudScriptResult>>() {
            public PlayFabResult<RunCloudScriptResult> call() throws Exception {
                return privateRunCloudScriptAsync(request);
            }
        });
    }

    /**
     * Triggers a particular server action, passing the provided inputs to the hosted Cloud Script. An action in this context is a handler in the JavaScript. NOTE: Before calling this API, you must call GetCloudScriptUrl to be assigned a Cloud Script server URL. When using an official PlayFab SDK, this URL is stored internally in the SDK, but GetCloudScriptUrl must still be manually called.
     */
    public static PlayFabResult<RunCloudScriptResult> RunCloudScript(RunCloudScriptRequest request) {
        FutureTask<PlayFabResult<RunCloudScriptResult>> task = new FutureTask(new Callable<PlayFabResult<RunCloudScriptResult>>() {
            public PlayFabResult<RunCloudScriptResult> call() throws Exception {
                return privateRunCloudScriptAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Triggers a particular server action, passing the provided inputs to the hosted Cloud Script. An action in this context is a handler in the JavaScript. NOTE: Before calling this API, you must call GetCloudScriptUrl to be assigned a Cloud Script server URL. When using an official PlayFab SDK, this URL is stored internally in the SDK, but GetCloudScriptUrl must still be manually called.
     */
    private static PlayFabResult<RunCloudScriptResult> privateRunCloudScriptAsync(RunCloudScriptRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetLogicURL() + "/Client/RunCloudScript", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<RunCloudScriptResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<RunCloudScriptResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<RunCloudScriptResult>>(){}.getType()); 
        RunCloudScriptResult result = resultData.data;
        
        PlayFabResult<RunCloudScriptResult> pfResult = new PlayFabResult<RunCloudScriptResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent  HTTP GET to the returned URL will attempt to download the content. A HEAD query to the returned URL will attempt to  retrieve the metadata of the content. Note that a successful result does not guarantee the existence of this content -  if it has not been uploaded, the query to retrieve the data will fail. See this post for more information:  https://support.playfab.com/support/discussions/topics/1000059929
     */
    public static FutureTask<PlayFabResult<GetContentDownloadUrlResult>> GetContentDownloadUrlAsync(GetContentDownloadUrlRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetContentDownloadUrlResult>>() {
            public PlayFabResult<GetContentDownloadUrlResult> call() throws Exception {
                return privateGetContentDownloadUrlAsync(request);
            }
        });
    }

    /**
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent  HTTP GET to the returned URL will attempt to download the content. A HEAD query to the returned URL will attempt to  retrieve the metadata of the content. Note that a successful result does not guarantee the existence of this content -  if it has not been uploaded, the query to retrieve the data will fail. See this post for more information:  https://support.playfab.com/support/discussions/topics/1000059929
     */
    public static PlayFabResult<GetContentDownloadUrlResult> GetContentDownloadUrl(GetContentDownloadUrlRequest request) {
        FutureTask<PlayFabResult<GetContentDownloadUrlResult>> task = new FutureTask(new Callable<PlayFabResult<GetContentDownloadUrlResult>>() {
            public PlayFabResult<GetContentDownloadUrlResult> call() throws Exception {
                return privateGetContentDownloadUrlAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * This API retrieves a pre-signed URL for accessing a content file for the title. A subsequent  HTTP GET to the returned URL will attempt to download the content. A HEAD query to the returned URL will attempt to  retrieve the metadata of the content. Note that a successful result does not guarantee the existence of this content -  if it has not been uploaded, the query to retrieve the data will fail. See this post for more information:  https://support.playfab.com/support/discussions/topics/1000059929
     */
    private static PlayFabResult<GetContentDownloadUrlResult> privateGetContentDownloadUrlAsync(GetContentDownloadUrlRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetContentDownloadUrl", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetContentDownloadUrlResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetContentDownloadUrlResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetContentDownloadUrlResult>>(){}.getType()); 
        GetContentDownloadUrlResult result = resultData.data;
        
        PlayFabResult<GetContentDownloadUrlResult> pfResult = new PlayFabResult<GetContentDownloadUrlResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Lists all of the characters that belong to a specific user.
     */
    public static FutureTask<PlayFabResult<ListUsersCharactersResult>> GetAllUsersCharactersAsync(ListUsersCharactersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ListUsersCharactersResult>>() {
            public PlayFabResult<ListUsersCharactersResult> call() throws Exception {
                return privateGetAllUsersCharactersAsync(request);
            }
        });
    }

    /**
     * Lists all of the characters that belong to a specific user.
     */
    public static PlayFabResult<ListUsersCharactersResult> GetAllUsersCharacters(ListUsersCharactersRequest request) {
        FutureTask<PlayFabResult<ListUsersCharactersResult>> task = new FutureTask(new Callable<PlayFabResult<ListUsersCharactersResult>>() {
            public PlayFabResult<ListUsersCharactersResult> call() throws Exception {
                return privateGetAllUsersCharactersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Lists all of the characters that belong to a specific user.
     */
    private static PlayFabResult<ListUsersCharactersResult> privateGetAllUsersCharactersAsync(ListUsersCharactersRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetAllUsersCharacters", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ListUsersCharactersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<ListUsersCharactersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ListUsersCharactersResult>>(){}.getType()); 
        ListUsersCharactersResult result = resultData.data;
        
        PlayFabResult<ListUsersCharactersResult> pfResult = new PlayFabResult<ListUsersCharactersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of ranked characters for the given statistic, starting from the indicated point in the leaderboard
     */
    public static FutureTask<PlayFabResult<GetCharacterLeaderboardResult>> GetCharacterLeaderboardAsync(GetCharacterLeaderboardRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterLeaderboardResult>>() {
            public PlayFabResult<GetCharacterLeaderboardResult> call() throws Exception {
                return privateGetCharacterLeaderboardAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked characters for the given statistic, starting from the indicated point in the leaderboard
     */
    public static PlayFabResult<GetCharacterLeaderboardResult> GetCharacterLeaderboard(GetCharacterLeaderboardRequest request) {
        FutureTask<PlayFabResult<GetCharacterLeaderboardResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterLeaderboardResult>>() {
            public PlayFabResult<GetCharacterLeaderboardResult> call() throws Exception {
                return privateGetCharacterLeaderboardAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of ranked characters for the given statistic, starting from the indicated point in the leaderboard
     */
    private static PlayFabResult<GetCharacterLeaderboardResult> privateGetCharacterLeaderboardAsync(GetCharacterLeaderboardRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetCharacterLeaderboard", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterLeaderboardResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterLeaderboardResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterLeaderboardResult>>(){}.getType()); 
        GetCharacterLeaderboardResult result = resultData.data;
        
        PlayFabResult<GetCharacterLeaderboardResult> pfResult = new PlayFabResult<GetCharacterLeaderboardResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of ranked characters for the given statistic, centered on the currently signed-in user
     */
    public static FutureTask<PlayFabResult<GetLeaderboardAroundCharacterResult>> GetLeaderboardAroundCharacterAsync(GetLeaderboardAroundCharacterRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundCharacterResult>>() {
            public PlayFabResult<GetLeaderboardAroundCharacterResult> call() throws Exception {
                return privateGetLeaderboardAroundCharacterAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of ranked characters for the given statistic, centered on the currently signed-in user
     */
    public static PlayFabResult<GetLeaderboardAroundCharacterResult> GetLeaderboardAroundCharacter(GetLeaderboardAroundCharacterRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardAroundCharacterResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardAroundCharacterResult>>() {
            public PlayFabResult<GetLeaderboardAroundCharacterResult> call() throws Exception {
                return privateGetLeaderboardAroundCharacterAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of ranked characters for the given statistic, centered on the currently signed-in user
     */
    private static PlayFabResult<GetLeaderboardAroundCharacterResult> privateGetLeaderboardAroundCharacterAsync(GetLeaderboardAroundCharacterRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetLeaderboardAroundCharacter", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardAroundCharacterResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetLeaderboardAroundCharacterResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardAroundCharacterResult>>(){}.getType()); 
        GetLeaderboardAroundCharacterResult result = resultData.data;
        
        PlayFabResult<GetLeaderboardAroundCharacterResult> pfResult = new PlayFabResult<GetLeaderboardAroundCharacterResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves a list of all of the user's characters for the given statistic.
     */
    public static FutureTask<PlayFabResult<GetLeaderboardForUsersCharactersResult>> GetLeaderboardForUserCharactersAsync(GetLeaderboardForUsersCharactersRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetLeaderboardForUsersCharactersResult>>() {
            public PlayFabResult<GetLeaderboardForUsersCharactersResult> call() throws Exception {
                return privateGetLeaderboardForUserCharactersAsync(request);
            }
        });
    }

    /**
     * Retrieves a list of all of the user's characters for the given statistic.
     */
    public static PlayFabResult<GetLeaderboardForUsersCharactersResult> GetLeaderboardForUserCharacters(GetLeaderboardForUsersCharactersRequest request) {
        FutureTask<PlayFabResult<GetLeaderboardForUsersCharactersResult>> task = new FutureTask(new Callable<PlayFabResult<GetLeaderboardForUsersCharactersResult>>() {
            public PlayFabResult<GetLeaderboardForUsersCharactersResult> call() throws Exception {
                return privateGetLeaderboardForUserCharactersAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves a list of all of the user's characters for the given statistic.
     */
    private static PlayFabResult<GetLeaderboardForUsersCharactersResult> privateGetLeaderboardForUserCharactersAsync(GetLeaderboardForUsersCharactersRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetLeaderboardForUserCharacters", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetLeaderboardForUsersCharactersResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetLeaderboardForUsersCharactersResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetLeaderboardForUsersCharactersResult>>(){}.getType()); 
        GetLeaderboardForUsersCharactersResult result = resultData.data;
        
        PlayFabResult<GetLeaderboardForUsersCharactersResult> pfResult = new PlayFabResult<GetLeaderboardForUsersCharactersResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Grants the specified character type to the user.
     */
    public static FutureTask<PlayFabResult<GrantCharacterToUserResult>> GrantCharacterToUserAsync(GrantCharacterToUserRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GrantCharacterToUserResult>>() {
            public PlayFabResult<GrantCharacterToUserResult> call() throws Exception {
                return privateGrantCharacterToUserAsync(request);
            }
        });
    }

    /**
     * Grants the specified character type to the user.
     */
    public static PlayFabResult<GrantCharacterToUserResult> GrantCharacterToUser(GrantCharacterToUserRequest request) {
        FutureTask<PlayFabResult<GrantCharacterToUserResult>> task = new FutureTask(new Callable<PlayFabResult<GrantCharacterToUserResult>>() {
            public PlayFabResult<GrantCharacterToUserResult> call() throws Exception {
                return privateGrantCharacterToUserAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Grants the specified character type to the user.
     */
    private static PlayFabResult<GrantCharacterToUserResult> privateGrantCharacterToUserAsync(GrantCharacterToUserRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GrantCharacterToUser", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GrantCharacterToUserResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GrantCharacterToUserResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GrantCharacterToUserResult>>(){}.getType()); 
        GrantCharacterToUserResult result = resultData.data;
        
        PlayFabResult<GrantCharacterToUserResult> pfResult = new PlayFabResult<GrantCharacterToUserResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the character which is readable and writable by the client
     */
    public static FutureTask<PlayFabResult<GetCharacterDataResult>> GetCharacterDataAsync(GetCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the character which is readable and writable by the client
     */
    public static PlayFabResult<GetCharacterDataResult> GetCharacterData(GetCharacterDataRequest request) {
        FutureTask<PlayFabResult<GetCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the character which is readable and writable by the client
     */
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterDataAsync(GetCharacterDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetCharacterData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterDataResult>>(){}.getType()); 
        GetCharacterDataResult result = resultData.data;
        
        PlayFabResult<GetCharacterDataResult> pfResult = new PlayFabResult<GetCharacterDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Retrieves the title-specific custom data for the character which can only be read by the client
     */
    public static FutureTask<PlayFabResult<GetCharacterDataResult>> GetCharacterReadOnlyDataAsync(GetCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterReadOnlyDataAsync(request);
            }
        });
    }

    /**
     * Retrieves the title-specific custom data for the character which can only be read by the client
     */
    public static PlayFabResult<GetCharacterDataResult> GetCharacterReadOnlyData(GetCharacterDataRequest request) {
        FutureTask<PlayFabResult<GetCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<GetCharacterDataResult>>() {
            public PlayFabResult<GetCharacterDataResult> call() throws Exception {
                return privateGetCharacterReadOnlyDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Retrieves the title-specific custom data for the character which can only be read by the client
     */
    private static PlayFabResult<GetCharacterDataResult> privateGetCharacterReadOnlyDataAsync(GetCharacterDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetCharacterReadOnlyData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCharacterDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetCharacterDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCharacterDataResult>>(){}.getType()); 
        GetCharacterDataResult result = resultData.data;
        
        PlayFabResult<GetCharacterDataResult> pfResult = new PlayFabResult<GetCharacterDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Creates and updates the title-specific custom data for the user's character which is readable  and writable by the client
     */
    public static FutureTask<PlayFabResult<UpdateCharacterDataResult>> UpdateCharacterDataAsync(UpdateCharacterDataRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterDataAsync(request);
            }
        });
    }

    /**
     * Creates and updates the title-specific custom data for the user's character which is readable  and writable by the client
     */
    public static PlayFabResult<UpdateCharacterDataResult> UpdateCharacterData(UpdateCharacterDataRequest request) {
        FutureTask<PlayFabResult<UpdateCharacterDataResult>> task = new FutureTask(new Callable<PlayFabResult<UpdateCharacterDataResult>>() {
            public PlayFabResult<UpdateCharacterDataResult> call() throws Exception {
                return privateUpdateCharacterDataAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Creates and updates the title-specific custom data for the user's character which is readable  and writable by the client
     */
    private static PlayFabResult<UpdateCharacterDataResult> privateUpdateCharacterDataAsync(UpdateCharacterDataRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/UpdateCharacterData", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCharacterDataResult>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<UpdateCharacterDataResult> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCharacterDataResult>>(){}.getType()); 
        UpdateCharacterDataResult result = resultData.data;
        
        PlayFabResult<UpdateCharacterDataResult> pfResult = new PlayFabResult<UpdateCharacterDataResult>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Accepts an open trade. If the call is successful, the offered and accepted items will be swapped between the two players' inventories.
     */
    public static FutureTask<PlayFabResult<AcceptTradeResponse>> AcceptTradeAsync(AcceptTradeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<AcceptTradeResponse>>() {
            public PlayFabResult<AcceptTradeResponse> call() throws Exception {
                return privateAcceptTradeAsync(request);
            }
        });
    }

    /**
     * Accepts an open trade. If the call is successful, the offered and accepted items will be swapped between the two players' inventories.
     */
    public static PlayFabResult<AcceptTradeResponse> AcceptTrade(AcceptTradeRequest request) {
        FutureTask<PlayFabResult<AcceptTradeResponse>> task = new FutureTask(new Callable<PlayFabResult<AcceptTradeResponse>>() {
            public PlayFabResult<AcceptTradeResponse> call() throws Exception {
                return privateAcceptTradeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Accepts an open trade. If the call is successful, the offered and accepted items will be swapped between the two players' inventories.
     */
    private static PlayFabResult<AcceptTradeResponse> privateAcceptTradeAsync(AcceptTradeRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/AcceptTrade", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<AcceptTradeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<AcceptTradeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<AcceptTradeResponse>>(){}.getType()); 
        AcceptTradeResponse result = resultData.data;
        
        PlayFabResult<AcceptTradeResponse> pfResult = new PlayFabResult<AcceptTradeResponse>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Cancels an open trade.
     */
    public static FutureTask<PlayFabResult<CancelTradeResponse>> CancelTradeAsync(CancelTradeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CancelTradeResponse>>() {
            public PlayFabResult<CancelTradeResponse> call() throws Exception {
                return privateCancelTradeAsync(request);
            }
        });
    }

    /**
     * Cancels an open trade.
     */
    public static PlayFabResult<CancelTradeResponse> CancelTrade(CancelTradeRequest request) {
        FutureTask<PlayFabResult<CancelTradeResponse>> task = new FutureTask(new Callable<PlayFabResult<CancelTradeResponse>>() {
            public PlayFabResult<CancelTradeResponse> call() throws Exception {
                return privateCancelTradeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Cancels an open trade.
     */
    private static PlayFabResult<CancelTradeResponse> privateCancelTradeAsync(CancelTradeRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/CancelTrade", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CancelTradeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<CancelTradeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CancelTradeResponse>>(){}.getType()); 
        CancelTradeResponse result = resultData.data;
        
        PlayFabResult<CancelTradeResponse> pfResult = new PlayFabResult<CancelTradeResponse>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Gets all trades the player has either opened or accepted, optionally filtered by trade status.
     */
    public static FutureTask<PlayFabResult<GetPlayerTradesResponse>> GetPlayerTradesAsync(GetPlayerTradesRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetPlayerTradesResponse>>() {
            public PlayFabResult<GetPlayerTradesResponse> call() throws Exception {
                return privateGetPlayerTradesAsync(request);
            }
        });
    }

    /**
     * Gets all trades the player has either opened or accepted, optionally filtered by trade status.
     */
    public static PlayFabResult<GetPlayerTradesResponse> GetPlayerTrades(GetPlayerTradesRequest request) {
        FutureTask<PlayFabResult<GetPlayerTradesResponse>> task = new FutureTask(new Callable<PlayFabResult<GetPlayerTradesResponse>>() {
            public PlayFabResult<GetPlayerTradesResponse> call() throws Exception {
                return privateGetPlayerTradesAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Gets all trades the player has either opened or accepted, optionally filtered by trade status.
     */
    private static PlayFabResult<GetPlayerTradesResponse> privateGetPlayerTradesAsync(GetPlayerTradesRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetPlayerTrades", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetPlayerTradesResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetPlayerTradesResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetPlayerTradesResponse>>(){}.getType()); 
        GetPlayerTradesResponse result = resultData.data;
        
        PlayFabResult<GetPlayerTradesResponse> pfResult = new PlayFabResult<GetPlayerTradesResponse>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Gets the current status of an existing trade.
     */
    public static FutureTask<PlayFabResult<GetTradeStatusResponse>> GetTradeStatusAsync(GetTradeStatusRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetTradeStatusResponse>>() {
            public PlayFabResult<GetTradeStatusResponse> call() throws Exception {
                return privateGetTradeStatusAsync(request);
            }
        });
    }

    /**
     * Gets the current status of an existing trade.
     */
    public static PlayFabResult<GetTradeStatusResponse> GetTradeStatus(GetTradeStatusRequest request) {
        FutureTask<PlayFabResult<GetTradeStatusResponse>> task = new FutureTask(new Callable<PlayFabResult<GetTradeStatusResponse>>() {
            public PlayFabResult<GetTradeStatusResponse> call() throws Exception {
                return privateGetTradeStatusAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Gets the current status of an existing trade.
     */
    private static PlayFabResult<GetTradeStatusResponse> privateGetTradeStatusAsync(GetTradeStatusRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/GetTradeStatus", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetTradeStatusResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<GetTradeStatusResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetTradeStatusResponse>>(){}.getType()); 
        GetTradeStatusResponse result = resultData.data;
        
        PlayFabResult<GetTradeStatusResponse> pfResult = new PlayFabResult<GetTradeStatusResponse>();
        pfResult.Result = result;
        return pfResult;
    }
    /**
     * Opens a new outstanding trade.
     */
    public static FutureTask<PlayFabResult<OpenTradeResponse>> OpenTradeAsync(OpenTradeRequest request) {
        return new FutureTask(new Callable<PlayFabResult<OpenTradeResponse>>() {
            public PlayFabResult<OpenTradeResponse> call() throws Exception {
                return privateOpenTradeAsync(request);
            }
        });
    }

    /**
     * Opens a new outstanding trade.
     */
    public static PlayFabResult<OpenTradeResponse> OpenTrade(OpenTradeRequest request) {
        FutureTask<PlayFabResult<OpenTradeResponse>> task = new FutureTask(new Callable<PlayFabResult<OpenTradeResponse>>() {
            public PlayFabResult<OpenTradeResponse> call() throws Exception {
                return privateOpenTradeAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            return null;
        }
    }
    
    /**
     * Opens a new outstanding trade.
     */
    private static PlayFabResult<OpenTradeResponse> privateOpenTradeAsync(OpenTradeRequest request) throws Exception {
        if (AuthKey == null) throw new Exception ("Must be logged in to call this method");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL() + "/Client/OpenTrade", request, "X-Authorization", AuthKey);
        task.run();
        Object httpResult = task.get();
        if(httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<OpenTradeResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;
        
        PlayFabJsonSuccess<OpenTradeResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<OpenTradeResponse>>(){}.getType()); 
        OpenTradeResponse result = resultData.data;
        
        PlayFabResult<OpenTradeResponse> pfResult = new PlayFabResult<OpenTradeResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    
    private static String AuthKey = null;
    
}
