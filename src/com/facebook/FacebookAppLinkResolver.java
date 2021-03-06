package com.facebook;

import a.b;
import a.b.a;
import a.e;
import a.f;
import a.f.a;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.model.GraphObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAppLinkResolver
{
  private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
  private static final String APP_LINK_KEY = "app_links";
  private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
  private static final String APP_LINK_TARGET_CLASS_KEY = "class";
  private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
  private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
  private static final String APP_LINK_TARGET_URL_KEY = "url";
  private static final String APP_LINK_WEB_TARGET_KEY = "web";
  private final HashMap<Uri, b> cachedAppLinks = new HashMap();
  
  private static b.a getAndroidTargetFromJson(JSONObject paramJSONObject)
  {
    Object localObject = null;
    String str1 = tryGetStringFromJson(paramJSONObject, "package", null);
    if (str1 == null) {
      return null;
    }
    String str2 = tryGetStringFromJson(paramJSONObject, "class", null);
    String str3 = tryGetStringFromJson(paramJSONObject, "app_name", null);
    String str4 = tryGetStringFromJson(paramJSONObject, "url", null);
    paramJSONObject = (JSONObject)localObject;
    if (str4 != null) {
      paramJSONObject = Uri.parse(str4);
    }
    return new b.a(str1, str2, paramJSONObject, str3);
  }
  
  private static Uri getWebFallbackUriFromJson(Uri paramUri, JSONObject paramJSONObject)
  {
    Object localObject = null;
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("web");
      if (!tryGetBooleanFromJson(paramJSONObject, "should_fallback", true)) {
        return null;
      }
      String str = tryGetStringFromJson(paramJSONObject, "url", null);
      paramJSONObject = (JSONObject)localObject;
      if (str != null) {
        paramJSONObject = Uri.parse(str);
      }
      if (paramJSONObject != null) {
        return paramJSONObject;
      }
    }
    catch (JSONException paramJSONObject) {}
    return paramUri;
  }
  
  private static boolean tryGetBooleanFromJson(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean(paramString);
      return bool;
    }
    catch (JSONException paramJSONObject) {}
    return paramBoolean;
  }
  
  private static String tryGetStringFromJson(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString1);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject) {}
    return paramString2;
  }
  
  public f<b> getAppLinkFromUrlInBackground(final Uri paramUri)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramUri);
    getAppLinkFromUrlsInBackground(localArrayList).b(new e()
    {
      public b then(f<Map<Uri, b>> paramAnonymousf)
        throws Exception
      {
        return (b)((Map)paramAnonymousf.e()).get(paramUri);
      }
    });
  }
  
  public f<Map<Uri, b>> getAppLinkFromUrlsInBackground(List<Uri> arg1)
  {
    HashMap localHashMap = new HashMap();
    final HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = ???.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Uri localUri = (Uri)((Iterator)localObject2).next();
      synchronized (cachedAppLinks)
      {
        b localb = (b)cachedAppLinks.get(localUri);
        if (localb != null) {
          localHashMap.put(localUri, localb);
        }
      }
      if (!localHashSet.isEmpty()) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(localUri.toString());
      localHashSet.add(localUri);
    }
    if (localHashSet.isEmpty()) {
      return f.a(localObject1);
    }
    ??? = f.a();
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("ids", localStringBuilder.toString());
    ((Bundle)localObject2).putString("fields", String.format("%s.fields(%s,%s)", new Object[] { "app_links", "android", "web" }));
    new Request(null, "", (Bundle)localObject2, null, new Request.Callback()
    {
      public void onCompleted(Response paramAnonymousResponse)
      {
        Object localObject1 = paramAnonymousResponse.getError();
        if (localObject1 != null)
        {
          paramList.b(((FacebookRequestError)localObject1).getException());
          return;
        }
        paramAnonymousResponse = paramAnonymousResponse.getGraphObject();
        if (paramAnonymousResponse != null) {}
        for (paramAnonymousResponse = paramAnonymousResponse.getInnerJSONObject(); paramAnonymousResponse == null; paramAnonymousResponse = null)
        {
          paramList.b(localObject1);
          return;
        }
        localObject1 = localHashSet.iterator();
        Uri localUri;
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localUri = (Uri)((Iterator)localObject1).next();
        } while (!paramAnonymousResponse.has(localUri.toString()));
        for (;;)
        {
          int i;
          try
          {
            ??? = paramAnonymousResponse.getJSONObject(localUri.toString()).getJSONObject("app_links");
            Object localObject4 = ((JSONObject)???).getJSONArray("android");
            int j = ((JSONArray)localObject4).length();
            ArrayList localArrayList = new ArrayList(j);
            i = 0;
            if (i < j)
            {
              b.a locala = FacebookAppLinkResolver.getAndroidTargetFromJson(((JSONArray)localObject4).getJSONObject(i));
              if (locala == null) {
                break label273;
              }
              localArrayList.add(locala);
              break label273;
            }
            localObject4 = new b(localUri, localArrayList, FacebookAppLinkResolver.getWebFallbackUriFromJson(localUri, (JSONObject)???));
            localObject1.put(localUri, localObject4);
            synchronized (cachedAppLinks)
            {
              cachedAppLinks.put(localUri, localObject4);
            }
          }
          catch (JSONException localJSONException) {}
          paramList.b(localObject1);
          return;
          label273:
          i += 1;
        }
      }
    }).executeAsync();
    return ???.a();
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookAppLinkResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */