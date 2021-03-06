package com.google.android.m4b.maps.bt;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;

public final class e
{
  private static final Uri a;
  
  static
  {
    Uri localUri = Uri.parse("http://plus.google.com/");
    a = localUri;
    localUri.buildUpon().appendPath("circles").appendPath("find").build();
  }
  
  public static Intent a()
  {
    return new Intent("android.settings.DATE_SETTINGS");
  }
  
  public static Intent a(String paramString)
  {
    paramString = Uri.fromParts("package", paramString, null);
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(paramString);
    return localIntent;
  }
  
  public static Intent b(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("market://details").buildUpon().appendQueryParameter("id", paramString).build());
    localIntent.setPackage("com.android.vending");
    localIntent.addFlags(524288);
    return localIntent;
  }
}

/* Location:
 * Qualified Name:     com.google.android.m4b.maps.bt.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */