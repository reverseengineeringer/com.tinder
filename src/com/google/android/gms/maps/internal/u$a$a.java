package com.google.android.gms.maps.internal;

import android.os.IBinder;

class u$a$a
  implements u
{
  private IBinder le;
  
  u$a$a(IBinder paramIBinder)
  {
    le = paramIBinder;
  }
  
  /* Error */
  public void a(IStreetViewPanoramaDelegate paramIStreetViewPanoramaDelegate)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 30
    //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 40 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/google/android/gms/maps/internal/u$a$a:le	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 49 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 52	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 55	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 55	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 55	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 55	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	a
    //   0	73	1	paramIStreetViewPanoramaDelegate	IStreetViewPanoramaDelegate
    //   3	65	2	localParcel1	android.os.Parcel
    //   7	57	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  public IBinder asBinder()
  {
    return le;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.internal.u.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */