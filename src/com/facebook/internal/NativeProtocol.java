package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.SessionDefaultAudience;
import com.facebook.Settings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;

public final class NativeProtocol
{
  public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
  public static final String ACTION_FEED_DIALOG_REPLY = "com.facebook.platform.action.reply.FEED_DIALOG";
  public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
  public static final String ACTION_LIKE_DIALOG_REPLY = "com.facebook.platform.action.reply.LIKE_DIALOG";
  public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
  public static final String ACTION_MESSAGE_DIALOG_REPLY = "com.facebook.platform.action.reply.MESSAGE_DIALOG";
  public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
  public static final String ACTION_OGACTIONPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGACTIONPUBLISH_DIALOG";
  public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
  public static final String ACTION_OGMESSAGEPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGMESSAGEPUBLISH_DIALOG";
  public static final String AUDIENCE_EVERYONE = "everyone";
  public static final String AUDIENCE_FRIENDS = "friends";
  public static final String AUDIENCE_ME = "only_me";
  public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
  public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
  public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
  private static final String CONTENT_SCHEME = "content://";
  public static final int DIALOG_REQUEST_CODE = 64207;
  public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
  public static final String ERROR_NETWORK_ERROR = "NetworkError";
  public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
  public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
  public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
  public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
  public static final String ERROR_USER_CANCELED = "UserCanceled";
  public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
  public static final String EXTRA_ACTION = "com.facebook.platform.extra.ACTION";
  public static final String EXTRA_ACTION_TYPE = "com.facebook.platform.extra.ACTION_TYPE";
  public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
  public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
  public static final String EXTRA_DATA_FAILURES_FATAL = "com.facebook.platform.extra.DATA_FAILURES_FATAL";
  public static final String EXTRA_DESCRIPTION = "com.facebook.platform.extra.DESCRIPTION";
  public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
  public static final String EXTRA_FRIEND_TAGS = "com.facebook.platform.extra.FRIENDS";
  public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
  public static final String EXTRA_IMAGE = "com.facebook.platform.extra.IMAGE";
  public static final String EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE = "com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE";
  public static final String EXTRA_LIKE_COUNT_STRING_WITH_LIKE = "com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE";
  public static final String EXTRA_LINK = "com.facebook.platform.extra.LINK";
  public static final String EXTRA_OBJECT_ID = "com.facebook.platform.extra.OBJECT_ID";
  public static final String EXTRA_OBJECT_IS_LIKED = "com.facebook.platform.extra.OBJECT_IS_LIKED";
  public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
  public static final String EXTRA_PHOTOS = "com.facebook.platform.extra.PHOTOS";
  public static final String EXTRA_PLACE_TAG = "com.facebook.platform.extra.PLACE";
  public static final String EXTRA_PREVIEW_PROPERTY_NAME = "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME";
  public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
  public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
  public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
  public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
  public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
  public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
  static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
  public static final String EXTRA_REF = "com.facebook.platform.extra.REF";
  public static final String EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE = "com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE";
  public static final String EXTRA_SOCIAL_SENTENCE_WITH_LIKE = "com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE";
  public static final String EXTRA_SUBTITLE = "com.facebook.platform.extra.SUBTITLE";
  public static final String EXTRA_TITLE = "com.facebook.platform.extra.TITLE";
  public static final String EXTRA_UNLIKE_TOKEN = "com.facebook.platform.extra.UNLIKE_TOKEN";
  private static final NativeAppInfo FACEBOOK_APP_INFO = new KatanaAppInfo(null);
  private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
  public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
  public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
  public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
  private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
  public static final String IMAGE_URL_KEY = "url";
  public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
  static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
  static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
  private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(new Integer[] { Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101) });
  public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
  public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
  public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
  public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
  public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
  public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
  public static final String METHOD_ARGS_ACTION = "ACTION";
  public static final String METHOD_ARGS_ACTION_TYPE = "ACTION_TYPE";
  public static final String METHOD_ARGS_DATA_FAILURES_FATAL = "DATA_FAILURES_FATAL";
  public static final String METHOD_ARGS_DESCRIPTION = "DESCRIPTION";
  public static final String METHOD_ARGS_FRIEND_TAGS = "FRIENDS";
  public static final String METHOD_ARGS_IMAGE = "IMAGE";
  public static final String METHOD_ARGS_LINK = "LINK";
  public static final String METHOD_ARGS_OBJECT_ID = "object_id";
  public static final String METHOD_ARGS_PHOTOS = "PHOTOS";
  public static final String METHOD_ARGS_PLACE_TAG = "PLACE";
  public static final String METHOD_ARGS_PREVIEW_PROPERTY_NAME = "PREVIEW_PROPERTY_NAME";
  public static final String METHOD_ARGS_REF = "REF";
  public static final String METHOD_ARGS_SUBTITLE = "SUBTITLE";
  public static final String METHOD_ARGS_TITLE = "TITLE";
  public static final int NO_PROTOCOL_AVAILABLE = -1;
  public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
  private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
  private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
  public static final int PROTOCOL_VERSION_20121101 = 20121101;
  public static final int PROTOCOL_VERSION_20130502 = 20130502;
  public static final int PROTOCOL_VERSION_20130618 = 20130618;
  public static final int PROTOCOL_VERSION_20131107 = 20131107;
  public static final int PROTOCOL_VERSION_20140204 = 20140204;
  public static final int PROTOCOL_VERSION_20140324 = 20140324;
  public static final int PROTOCOL_VERSION_20140701 = 20140701;
  public static final int PROTOCOL_VERSION_20141001 = 20141001;
  public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
  public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
  public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
  public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
  public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
  private static Map<String, List<NativeAppInfo>> actionToAppInfoMap;
  private static List<NativeAppInfo> facebookAppInfoList = buildFacebookAppList();
  
  static
  {
    actionToAppInfoMap = buildActionToAppInfoMap();
  }
  
  private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new MessengerAppInfo(null));
    localHashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.FEED_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", localArrayList);
    localHashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", localArrayList);
    return localHashMap;
  }
  
  private static List<NativeAppInfo> buildFacebookAppList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FACEBOOK_APP_INFO);
    localArrayList.add(new WakizashiAppInfo(null));
    return localArrayList;
  }
  
  private static Uri buildPlatformProviderVersionURI(NativeAppInfo paramNativeAppInfo)
  {
    return Uri.parse("content://" + paramNativeAppInfo.getPackage() + ".provider.PlatformProvider/versions");
  }
  
  public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> paramTreeSet, int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    paramTreeSet = paramTreeSet.descendingIterator();
    int j = -1;
    i -= 1;
    for (;;)
    {
      int k;
      if (paramTreeSet.hasNext())
      {
        k = ((Integer)paramTreeSet.next()).intValue();
        j = Math.max(j, k);
        while ((i >= 0) && (paramArrayOfInt[i] > k)) {
          i -= 1;
        }
        if (i >= 0) {
          break label72;
        }
      }
      label72:
      do
      {
        return -1;
        if (paramArrayOfInt[i] != k) {
          break;
        }
      } while (i % 2 != 0);
      return Math.min(j, paramInt);
    }
  }
  
  public static Intent createPlatformActivityIntent(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle)
  {
    Intent localIntent = findActivityIntent(paramContext, "com.facebook.platform.PLATFORM_ACTIVITY", paramString2);
    if (localIntent == null) {
      return null;
    }
    paramContext = Utility.getMetadataApplicationId(paramContext);
    localIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", paramInt).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", paramString2).putExtra("com.facebook.platform.extra.APPLICATION_ID", paramContext);
    if (isVersionCompatibleWithBucketedIntent(paramInt))
    {
      paramContext = new Bundle();
      paramContext.putString("action_id", paramString1);
      paramContext.putString("app_name", paramString3);
      localIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", paramContext);
      paramContext = paramBundle;
      if (paramBundle == null) {
        paramContext = new Bundle();
      }
      localIntent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", paramContext);
      return localIntent;
    }
    localIntent.putExtra("com.facebook.platform.protocol.CALL_ID", paramString1);
    localIntent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", paramString3);
    localIntent.putExtras(paramBundle);
    return localIntent;
  }
  
  public static Intent createPlatformServiceIntent(Context paramContext)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NativeAppInfo)localIterator.next();
      localObject = validateServiceIntent(paramContext, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(((NativeAppInfo)localObject).getPackage()).addCategory("android.intent.category.DEFAULT"), (NativeAppInfo)localObject);
      if (localObject != null) {
        return (Intent)localObject;
      }
    }
    return null;
  }
  
  public static Intent createProxyAuthIntent(Context paramContext, String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, SessionDefaultAudience paramSessionDefaultAudience)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NativeAppInfo)localIterator.next();
      Intent localIntent = new Intent().setClassName(((NativeAppInfo)localObject).getPackage(), "com.facebook.katana.ProxyAuth").putExtra("client_id", paramString1);
      if (!Utility.isNullOrEmpty(paramList)) {
        localIntent.putExtra("scope", TextUtils.join(",", paramList));
      }
      if (!Utility.isNullOrEmpty(paramString2)) {
        localIntent.putExtra("e2e", paramString2);
      }
      localIntent.putExtra("response_type", "token");
      localIntent.putExtra("return_scopes", "true");
      localIntent.putExtra("default_audience", paramSessionDefaultAudience.getNativeProtocolAudience());
      if (!Settings.getPlatformCompatibilityEnabled())
      {
        localIntent.putExtra("legacy_override", "v2.2");
        if (paramBoolean) {
          localIntent.putExtra("auth_type", "rerequest");
        }
      }
      localObject = validateActivityIntent(paramContext, localIntent, (NativeAppInfo)localObject);
      if (localObject != null) {
        return (Intent)localObject;
      }
    }
    return null;
  }
  
  public static Intent createTokenRefreshIntent(Context paramContext)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NativeAppInfo)localIterator.next();
      localObject = validateServiceIntent(paramContext, new Intent().setClassName(((NativeAppInfo)localObject).getPackage(), "com.facebook.katana.platform.TokenRefreshService"), (NativeAppInfo)localObject);
      if (localObject != null) {
        return (Intent)localObject;
      }
    }
    return null;
  }
  
  private static Intent findActivityIntent(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = (List)actionToAppInfoMap.get(paramString2);
    if (paramString2 == null) {}
    Intent localIntent;
    do
    {
      Iterator localIterator;
      for (paramString2 = null; !localIterator.hasNext(); paramString2 = null)
      {
        return paramString2;
        localIterator = paramString2.iterator();
      }
      paramString2 = (NativeAppInfo)localIterator.next();
      localIntent = validateActivityIntent(paramContext, new Intent().setAction(paramString1).setPackage(paramString2.getPackage()).addCategory("android.intent.category.DEFAULT"), paramString2);
      paramString2 = localIntent;
    } while (localIntent == null);
    return localIntent;
  }
  
  /* Error */
  private static TreeSet<Integer> getAllAvailableProtocolVersionsForAppInfo(Context paramContext, NativeAppInfo paramNativeAppInfo)
  {
    // Byte code:
    //   0: new 417	java/util/TreeSet
    //   3: dup
    //   4: invokespecial 569	java/util/TreeSet:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 575	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore_0
    //   13: aload_1
    //   14: invokestatic 577	com/facebook/internal/NativeProtocol:buildPlatformProviderVersionURI	(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;)Landroid/net/Uri;
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: iconst_1
    //   21: anewarray 579	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc_w 294
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 585	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull +55 -> 93
    //   41: aload_0
    //   42: invokeinterface 590 1 0
    //   47: ifeq +46 -> 93
    //   50: aload_2
    //   51: aload_0
    //   52: aload_0
    //   53: ldc_w 294
    //   56: invokeinterface 594 2 0
    //   61: invokeinterface 598 2 0
    //   66: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: invokevirtual 599	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: goto -32 -> 41
    //   76: astore_2
    //   77: aload_0
    //   78: astore_1
    //   79: aload_2
    //   80: astore_0
    //   81: aload_1
    //   82: ifnull +9 -> 91
    //   85: aload_1
    //   86: invokeinterface 602 1 0
    //   91: aload_0
    //   92: athrow
    //   93: aload_0
    //   94: ifnull +9 -> 103
    //   97: aload_0
    //   98: invokeinterface 602 1 0
    //   103: aload_2
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_1
    //   108: goto -27 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramContext	Context
    //   0	111	1	paramNativeAppInfo	NativeAppInfo
    //   7	44	2	localTreeSet	TreeSet
    //   76	28	2	localTreeSet1	TreeSet<Integer>
    // Exception table:
    //   from	to	target	type
    //   41	73	76	finally
    //   18	37	105	finally
  }
  
  public static Bundle getBridgeArgumentsFromIntent(Intent paramIntent)
  {
    if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent))) {
      return null;
    }
    return paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
  }
  
  public static UUID getCallIdFromIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return null;
      if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent)))
      {
        paramIntent = paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        if (paramIntent == null) {
          break label58;
        }
        paramIntent = paramIntent.getString("action_id");
      }
      while (paramIntent != null)
      {
        try
        {
          paramIntent = UUID.fromString(paramIntent);
          return paramIntent;
        }
        catch (IllegalArgumentException paramIntent)
        {
          return null;
        }
        paramIntent = paramIntent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        continue;
        label58:
        paramIntent = null;
      }
    }
  }
  
  public static Bundle getErrorDataFromResultIntent(Intent paramIntent)
  {
    if (!isErrorResult(paramIntent)) {
      return null;
    }
    Bundle localBundle = getBridgeArgumentsFromIntent(paramIntent);
    if (localBundle != null) {
      return localBundle.getBundle("error");
    }
    return paramIntent.getExtras();
  }
  
  public static Exception getExceptionFromErrorData(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str = paramBundle.getString("com.facebook.platform.status.ERROR_TYPE");
    paramBundle = paramBundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
    if ((str != null) && (str.equalsIgnoreCase("UserCanceled"))) {
      return new FacebookOperationCanceledException(paramBundle);
    }
    return new FacebookException(paramBundle);
  }
  
  public static int getLatestAvailableProtocolVersionForAction(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    return getLatestAvailableProtocolVersionForAppInfoList(paramContext, (List)actionToAppInfoMap.get(paramString), paramArrayOfInt);
  }
  
  private static int getLatestAvailableProtocolVersionForAppInfo(Context paramContext, NativeAppInfo paramNativeAppInfo, int[] paramArrayOfInt)
  {
    return computeLatestAvailableVersionFromVersionSpec(getAllAvailableProtocolVersionsForAppInfo(paramContext, paramNativeAppInfo), getLatestKnownVersion(), paramArrayOfInt);
  }
  
  private static int getLatestAvailableProtocolVersionForAppInfoList(Context paramContext, List<NativeAppInfo> paramList, int[] paramArrayOfInt)
  {
    if (paramList == null) {
      return -1;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = getLatestAvailableProtocolVersionForAppInfo(paramContext, (NativeAppInfo)paramList.next(), paramArrayOfInt);
      if (i != -1) {
        return i;
      }
    }
    return -1;
  }
  
  public static int getLatestAvailableProtocolVersionForService(Context paramContext, int paramInt)
  {
    return getLatestAvailableProtocolVersionForAppInfoList(paramContext, facebookAppInfoList, new int[] { paramInt });
  }
  
  public static final int getLatestKnownVersion()
  {
    return ((Integer)KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
  }
  
  public static int getProtocolVersionFromIntent(Intent paramIntent)
  {
    return paramIntent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
  }
  
  public static Bundle getSuccessResultsFromIntent(Intent paramIntent)
  {
    int i = getProtocolVersionFromIntent(paramIntent);
    paramIntent = paramIntent.getExtras();
    if ((!isVersionCompatibleWithBucketedIntent(i)) || (paramIntent == null)) {
      return paramIntent;
    }
    return paramIntent.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
  }
  
  public static boolean isErrorResult(Intent paramIntent)
  {
    Bundle localBundle = getBridgeArgumentsFromIntent(paramIntent);
    if (localBundle != null) {
      return localBundle.containsKey("error");
    }
    return paramIntent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
  }
  
  public static boolean isVersionCompatibleWithBucketedIntent(int paramInt)
  {
    return (KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(paramInt))) && (paramInt >= 20140701);
  }
  
  static Intent validateActivityIntent(Context paramContext, Intent paramIntent, NativeAppInfo paramNativeAppInfo)
  {
    if (paramIntent == null) {
      paramIntent = null;
    }
    ResolveInfo localResolveInfo;
    do
    {
      return paramIntent;
      localResolveInfo = paramContext.getPackageManager().resolveActivity(paramIntent, 0);
      if (localResolveInfo == null) {
        return null;
      }
    } while (paramNativeAppInfo.validateSignature(paramContext, activityInfo.packageName));
    return null;
  }
  
  static Intent validateServiceIntent(Context paramContext, Intent paramIntent, NativeAppInfo paramNativeAppInfo)
  {
    if (paramIntent == null) {
      paramIntent = null;
    }
    ResolveInfo localResolveInfo;
    do
    {
      return paramIntent;
      localResolveInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
      if (localResolveInfo == null) {
        return null;
      }
    } while (paramNativeAppInfo.validateSignature(paramContext, serviceInfo.packageName));
    return null;
  }
  
  private static class KatanaAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String KATANA_PACKAGE = "com.facebook.katana";
    
    private KatanaAppInfo()
    {
      super();
    }
    
    protected String getPackage()
    {
      return "com.facebook.katana";
    }
  }
  
  private static class MessengerAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String MESSENGER_PACKAGE = "com.facebook.orca";
    
    private MessengerAppInfo()
    {
      super();
    }
    
    protected String getPackage()
    {
      return "com.facebook.orca";
    }
  }
  
  private static abstract class NativeAppInfo
  {
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    private static final HashSet<String> validAppSignatureHashes = ;
    
    private static HashSet<String> buildAppSignatureHashes()
    {
      HashSet localHashSet = new HashSet();
      localHashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
      localHashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
      localHashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
      return localHashSet;
    }
    
    protected abstract String getPackage();
    
    public boolean validateSignature(Context paramContext, String paramString)
    {
      String str = Build.BRAND;
      int i = getApplicationInfoflags;
      if ((str.startsWith("generic")) && ((i & 0x2) != 0)) {}
      for (;;)
      {
        return true;
        try
        {
          paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
          paramContext = signatures;
          int j = paramContext.length;
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label89;
            }
            paramString = Utility.sha1hash(paramContext[i].toByteArray());
            if (validAppSignatureHashes.contains(paramString)) {
              break;
            }
            i += 1;
          }
          return false;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          return false;
        }
      }
    }
  }
  
  private static class WakizashiAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";
    
    private WakizashiAppInfo()
    {
      super();
    }
    
    protected String getPackage()
    {
      return "com.facebook.wakizashi";
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.NativeProtocol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */