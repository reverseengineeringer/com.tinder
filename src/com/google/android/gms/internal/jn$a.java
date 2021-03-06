package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;

final class jn$a
{
  private final String Ng;
  private final a Nh;
  private final HashSet<jl<?>.f> Ni;
  private boolean Nj;
  private IBinder Nk;
  private ComponentName Nl;
  private int mState;
  
  public jn$a(jn paramjn, String paramString)
  {
    Ng = paramString;
    Nh = new a();
    Ni = new HashSet();
    mState = 2;
  }
  
  public void a(jl<?>.f paramjl)
  {
    Ni.add(paramjl);
  }
  
  public void b(jl<?>.f paramjl)
  {
    Ni.remove(paramjl);
  }
  
  public boolean c(jl<?>.f paramjl)
  {
    return Ni.contains(paramjl);
  }
  
  public IBinder getBinder()
  {
    return Nk;
  }
  
  public ComponentName getComponentName()
  {
    return Nl;
  }
  
  public int getState()
  {
    return mState;
  }
  
  public void hA()
  {
    Intent localIntent = new Intent(Ng).setPackage("com.google.android.gms");
    Nj = jn.b(Nm).bindService(localIntent, Nh, 129);
    if (Nj)
    {
      mState = 3;
      return;
    }
    jn.b(Nm).unbindService(Nh);
  }
  
  public void hB()
  {
    jn.b(Nm).unbindService(Nh);
    Nj = false;
    mState = 2;
  }
  
  public String hC()
  {
    return Ng;
  }
  
  public boolean hD()
  {
    return Ni.isEmpty();
  }
  
  public boolean isBound()
  {
    return Nj;
  }
  
  public class a
    implements ServiceConnection
  {
    public a() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      synchronized (jn.a(Nm))
      {
        jn.a.a(jn.a.this, paramIBinder);
        jn.a.a(jn.a.this, paramComponentName);
        Iterator localIterator = jn.a.a(jn.a.this).iterator();
        if (localIterator.hasNext()) {
          ((jl.f)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
        }
      }
      jn.a.a(jn.a.this, 1);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      synchronized (jn.a(Nm))
      {
        jn.a.a(jn.a.this, null);
        jn.a.a(jn.a.this, paramComponentName);
        Iterator localIterator = jn.a.a(jn.a.this).iterator();
        if (localIterator.hasNext()) {
          ((jl.f)localIterator.next()).onServiceDisconnected(paramComponentName);
        }
      }
      jn.a.a(jn.a.this, 2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.jn.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */