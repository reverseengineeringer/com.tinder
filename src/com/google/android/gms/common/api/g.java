package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import java.util.List;

public class g
  extends Fragment
  implements DialogInterface.OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult>
{
  private boolean KC;
  private int KD = -1;
  private ConnectionResult KE;
  private final Handler KF = new Handler(Looper.getMainLooper());
  private final SparseArray<b> KG = new SparseArray();
  
  public static g a(FragmentActivity paramFragmentActivity)
  {
    jx.aU("Must be called from main thread of process");
    FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
    try
    {
      g localg = (g)localFragmentManager.findFragmentByTag("GmsSupportLifecycleFragment");
      if (localg != null)
      {
        paramFragmentActivity = localg;
        if (!localg.isRemoving()) {}
      }
      else
      {
        paramFragmentActivity = new g();
        localFragmentManager.beginTransaction().add(paramFragmentActivity, "GmsSupportLifecycleFragment").commit();
        localFragmentManager.executePendingTransactions();
      }
      return paramFragmentActivity;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", paramFragmentActivity);
    }
  }
  
  private void a(int paramInt, ConnectionResult paramConnectionResult)
  {
    if (!KC)
    {
      KC = true;
      KD = paramInt;
      KE = paramConnectionResult;
      KF.post(new c(paramInt, paramConnectionResult));
    }
  }
  
  private void aq(int paramInt)
  {
    if (paramInt == KD) {
      gR();
    }
  }
  
  private void b(int paramInt, ConnectionResult paramConnectionResult)
  {
    Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
    Object localObject = (b)KG.get(paramInt);
    if (localObject != null)
    {
      ao(paramInt);
      localObject = KK;
      if (localObject != null) {
        ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
      }
    }
    gR();
  }
  
  private void gR()
  {
    int i = 0;
    KC = false;
    KD = -1;
    KE = null;
    LoaderManager localLoaderManager = getLoaderManager();
    while (i < KG.size())
    {
      int j = KG.keyAt(i);
      a locala = ap(j);
      if (locala != null) {
        locala.gS();
      }
      localLoaderManager.initLoader(j, null, this);
      i += 1;
    }
  }
  
  public void a(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    jx.b(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (KG.indexOfKey(paramInt) < 0) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Already managing a GoogleApiClient with id " + paramInt);
      paramGoogleApiClient = new b(paramGoogleApiClient, paramOnConnectionFailedListener, null);
      KG.put(paramInt, paramGoogleApiClient);
      if (getActivity() != null) {
        getLoaderManager().initLoader(paramInt, null, this);
      }
      return;
    }
  }
  
  public void a(Loader<ConnectionResult> paramLoader, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.isSuccess())
    {
      aq(paramLoader.getId());
      return;
    }
    a(paramLoader.getId(), paramConnectionResult);
  }
  
  public GoogleApiClient an(int paramInt)
  {
    if (getActivity() != null)
    {
      a locala = ap(paramInt);
      if (locala != null) {
        return KH;
      }
    }
    return null;
  }
  
  public void ao(int paramInt)
  {
    getLoaderManager().destroyLoader(paramInt);
    KG.remove(paramInt);
  }
  
  a ap(int paramInt)
  {
    try
    {
      a locala = (a)getLoaderManager().getLoader(paramInt);
      return locala;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", localClassCastException);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label66;
      }
      gR();
      return;
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0) {
        break;
      }
      paramInt1 = i;
      continue;
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = i;
    }
    label66:
    b(KD, KE);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    int i = 0;
    if (i < KG.size())
    {
      int j = KG.keyAt(i);
      paramActivity = ap(j);
      if ((paramActivity != null) && (KG.valueAt(i)).KH != KH)) {
        getLoaderManager().restartLoader(j, null, this);
      }
      for (;;)
      {
        i += 1;
        break;
        getLoaderManager().initLoader(j, null, this);
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    b(KD, KE);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      KC = paramBundle.getBoolean("resolving_error", false);
      KD = paramBundle.getInt("failed_client_id", -1);
      if (KD >= 0) {
        KE = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public Loader<ConnectionResult> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new a(getActivity(), KG.get(paramInt)).KH);
  }
  
  public void onLoaderReset(Loader<ConnectionResult> paramLoader)
  {
    if (paramLoader.getId() == KD) {
      gR();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", KC);
    if (KD >= 0)
    {
      paramBundle.putInt("failed_client_id", KD);
      paramBundle.putInt("failed_status", KE.getErrorCode());
      paramBundle.putParcelable("failed_resolution", KE.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (!KC)
    {
      int i = 0;
      while (i < KG.size())
      {
        getLoaderManager().initLoader(KG.keyAt(i), null, this);
        i += 1;
      }
    }
  }
  
  static class a
    extends Loader<ConnectionResult>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    public final GoogleApiClient KH;
    private boolean KI;
    private ConnectionResult KJ;
    
    public a(Context paramContext, GoogleApiClient paramGoogleApiClient)
    {
      super();
      KH = paramGoogleApiClient;
    }
    
    private void a(ConnectionResult paramConnectionResult)
    {
      KJ = paramConnectionResult;
      if ((isStarted()) && (!isAbandoned())) {
        deliverResult(paramConnectionResult);
      }
    }
    
    public void gS()
    {
      if (KI)
      {
        KI = false;
        if ((isStarted()) && (!isAbandoned())) {
          KH.connect();
        }
      }
    }
    
    public void onConnected(Bundle paramBundle)
    {
      KI = false;
      a(ConnectionResult.Iu);
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      KI = true;
      a(paramConnectionResult);
    }
    
    public void onConnectionSuspended(int paramInt) {}
    
    protected void onReset()
    {
      KJ = null;
      KI = false;
      KH.unregisterConnectionCallbacks(this);
      KH.unregisterConnectionFailedListener(this);
      KH.disconnect();
    }
    
    protected void onStartLoading()
    {
      super.onStartLoading();
      KH.registerConnectionCallbacks(this);
      KH.registerConnectionFailedListener(this);
      if (KJ != null) {
        deliverResult(KJ);
      }
      if ((!KH.isConnected()) && (!KH.isConnecting()) && (!KI)) {
        KH.connect();
      }
    }
    
    protected void onStopLoading()
    {
      KH.disconnect();
    }
  }
  
  private static class b
  {
    public final GoogleApiClient KH;
    public final GoogleApiClient.OnConnectionFailedListener KK;
    
    private b(GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      KH = paramGoogleApiClient;
      KK = paramOnConnectionFailedListener;
    }
  }
  
  private class c
    implements Runnable
  {
    private final int KL;
    private final ConnectionResult KM;
    
    public c(int paramInt, ConnectionResult paramConnectionResult)
    {
      KL = paramInt;
      KM = paramConnectionResult;
    }
    
    public void run()
    {
      if (KM.hasResolution()) {
        try
        {
          int i = getActivity().getSupportFragmentManager().getFragments().indexOf(g.this);
          KM.startResolutionForResult(getActivity(), (i + 1 << 16) + 1);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          g.a(g.this);
          return;
        }
      }
      if (GooglePlayServicesUtil.isUserRecoverableError(KM.getErrorCode()))
      {
        GooglePlayServicesUtil.showErrorDialogFragment(KM.getErrorCode(), getActivity(), g.this, 2, g.this);
        return;
      }
      g.a(g.this, KL, KM);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */