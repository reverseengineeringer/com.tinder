package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class i$a$a
  implements i
{
  private IBinder le;
  
  i$a$a(IBinder paramIBinder)
  {
    le = paramIBinder;
  }
  
  public void a(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      localParcel1.writeFloat(paramFloat1);
      localParcel1.writeFloat(paramFloat2);
      le.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void a(a parama)
    throws RemoteException
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
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 56	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 62	com/google/android/gms/maps/model/internal/a:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/maps/model/internal/i$a$a:le	Landroid/os/IBinder;
    //   33: bipush 22
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 44 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 47	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 50	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 50	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 56	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 50	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 50	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   0	76	1	parama	a
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public boolean a(i parami)
    throws RemoteException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 30
    //   16: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +62 -> 82
    //   23: aload_1
    //   24: invokeinterface 67 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 70	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/google/android/gms/maps/model/internal/i$a$a:le	Landroid/os/IBinder;
    //   40: bipush 19
    //   42: aload 4
    //   44: aload 5
    //   46: iconst_0
    //   47: invokeinterface 44 5 0
    //   52: pop
    //   53: aload 5
    //   55: invokevirtual 47	android/os/Parcel:readException	()V
    //   58: aload 5
    //   60: invokevirtual 74	android/os/Parcel:readInt	()I
    //   63: istore_2
    //   64: iload_2
    //   65: ifeq +5 -> 70
    //   68: iconst_1
    //   69: istore_3
    //   70: aload 5
    //   72: invokevirtual 50	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: invokevirtual 50	android/os/Parcel:recycle	()V
    //   80: iload_3
    //   81: ireturn
    //   82: aconst_null
    //   83: astore_1
    //   84: goto -54 -> 30
    //   87: astore_1
    //   88: aload 5
    //   90: invokevirtual 50	android/os/Parcel:recycle	()V
    //   93: aload 4
    //   95: invokevirtual 50	android/os/Parcel:recycle	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	parami	i
    //   63	2	2	i	int
    //   1	80	3	bool	boolean
    //   5	89	4	localParcel1	Parcel
    //   10	79	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	87	finally
    //   23	30	87	finally
    //   30	64	87	finally
  }
  
  public IBinder asBinder()
  {
    return le;
  }
  
  public float getBearing()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      le.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public com.google.android.gms.maps.model.LatLngBounds getBounds()
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 30
    //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	com/google/android/gms/maps/model/internal/i$a$a:le	Landroid/os/IBinder;
    //   18: bipush 10
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 44 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 47	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 74	android/os/Parcel:readInt	()I
    //   37: ifeq +21 -> 58
    //   40: getstatic 87	com/google/android/gms/maps/model/LatLngBounds:CREATOR	Lcom/google/android/gms/maps/model/g;
    //   43: aload_3
    //   44: invokevirtual 93	com/google/android/gms/maps/model/g:dd	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/LatLngBounds;
    //   47: astore_1
    //   48: aload_3
    //   49: invokevirtual 50	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 50	android/os/Parcel:recycle	()V
    //   56: aload_1
    //   57: areturn
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -12 -> 48
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 50	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 50	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   47	13	1	localLatLngBounds	com.google.android.gms.maps.model.LatLngBounds
    //   63	10	1	localObject	Object
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	48	63	finally
  }
  
  public float getHeight()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      le.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getId()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      le.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public com.google.android.gms.maps.model.LatLng getPosition()
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 30
    //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	com/google/android/gms/maps/model/internal/i$a$a:le	Landroid/os/IBinder;
    //   18: iconst_4
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 44 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 47	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 74	android/os/Parcel:readInt	()I
    //   36: ifeq +21 -> 57
    //   39: getstatic 106	com/google/android/gms/maps/model/LatLng:CREATOR	Lcom/google/android/gms/maps/model/i;
    //   42: aload_3
    //   43: invokevirtual 112	com/google/android/gms/maps/model/i:de	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/LatLng;
    //   46: astore_1
    //   47: aload_3
    //   48: invokevirtual 50	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 50	android/os/Parcel:recycle	()V
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -12 -> 47
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 50	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 50	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	a
    //   46	13	1	localLatLng	com.google.android.gms.maps.model.LatLng
    //   62	10	1	localObject	Object
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	47	62	finally
  }
  
  public float getTransparency()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      le.transact(18, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public float getWidth()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      le.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public float getZIndex()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      le.transact(14, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int hashCodeRemote()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      le.transact(20, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isVisible()
    throws RemoteException
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      le.transact(16, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void m(com.google.android.gms.dynamic.d paramd)
    throws RemoteException
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
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 123 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 70	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/google/android/gms/maps/model/internal/i$a$a:le	Landroid/os/IBinder;
    //   34: bipush 21
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 44 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 47	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 50	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 50	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 50	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 50	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	paramd	com.google.android.gms.dynamic.d
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  public void remove()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      le.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setBearing(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      localParcel1.writeFloat(paramFloat);
      le.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setDimensions(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      localParcel1.writeFloat(paramFloat);
      le.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void setPosition(com.google.android.gms.maps.model.LatLng paramLatLng)
    throws RemoteException
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
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 56	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 129	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/maps/model/internal/i$a$a:le	Landroid/os/IBinder;
    //   33: iconst_3
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 44 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 47	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 50	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 50	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 56	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 50	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 50	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	a
    //   0	75	1	paramLatLng	com.google.android.gms.maps.model.LatLng
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  /* Error */
  public void setPositionFromBounds(com.google.android.gms.maps.model.LatLngBounds paramLatLngBounds)
    throws RemoteException
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
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 56	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 132	com/google/android/gms/maps/model/LatLngBounds:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/maps/model/internal/i$a$a:le	Landroid/os/IBinder;
    //   33: bipush 9
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 44 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 47	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 50	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 50	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 56	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 50	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 50	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   0	76	1	paramLatLngBounds	com.google.android.gms.maps.model.LatLngBounds
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  public void setTransparency(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      localParcel1.writeFloat(paramFloat);
      le.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      le.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setZIndex(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      localParcel1.writeFloat(paramFloat);
      le.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.internal.i.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */