package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract interface oq
  extends IInterface
{
  public abstract void a(String paramString, ov paramov, or paramor)
    throws RemoteException;
  
  public abstract void a(String paramString, ov paramov, List<or> paramList)
    throws RemoteException;
  
  public abstract void a(String paramString, ov paramov, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements oq
  {
    public static oq bI(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
      if ((localIInterface != null) && ((localIInterface instanceof oq))) {
        return (oq)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      String str = null;
      Object localObject2 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel2 = ov.CREATOR.du(paramParcel1);; paramParcel2 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject1 = or.CREATOR.dt(paramParcel1);
          }
          a(str, paramParcel2, (or)localObject1);
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
        localObject1 = paramParcel1.readString();
        paramParcel2 = str;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = ov.CREATOR.du(paramParcel1);
        }
        a((String)localObject1, paramParcel2, paramParcel1.createTypedArrayList(or.CREATOR));
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
      localObject1 = paramParcel1.readString();
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = ov.CREATOR.du(paramParcel1);
      }
      a((String)localObject1, paramParcel2, paramParcel1.createByteArray());
      return true;
    }
    
    private static class a
      implements oq
    {
      private IBinder le;
      
      a(IBinder paramIBinder)
      {
        le = paramIBinder;
      }
      
      public void a(String paramString, ov paramov, or paramor)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
            localParcel.writeString(paramString);
            if (paramov != null)
            {
              localParcel.writeInt(1);
              paramov.writeToParcel(localParcel, 0);
              if (paramor != null)
              {
                localParcel.writeInt(1);
                paramor.writeToParcel(localParcel, 0);
                le.transact(2, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      /* Error */
      public void a(String paramString, ov paramov, List<or> paramList)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: aload 4
        //   7: ldc 30
        //   9: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 4
        //   14: aload_1
        //   15: invokevirtual 37	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   18: aload_2
        //   19: ifnull +43 -> 62
        //   22: aload 4
        //   24: iconst_1
        //   25: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   28: aload_2
        //   29: aload 4
        //   31: iconst_0
        //   32: invokevirtual 47	com/google/android/gms/internal/ov:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload 4
        //   37: aload_3
        //   38: invokevirtual 65	android/os/Parcel:writeTypedList	(Ljava/util/List;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/internal/oq$a$a:le	Landroid/os/IBinder;
        //   45: iconst_3
        //   46: aload 4
        //   48: aconst_null
        //   49: iconst_1
        //   50: invokeinterface 56 5 0
        //   55: pop
        //   56: aload 4
        //   58: invokevirtual 59	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   68: goto -33 -> 35
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 59	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramString	String
        //   0	79	2	paramov	ov
        //   0	79	3	paramList	List<or>
        //   3	70	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	18	71	finally
        //   22	35	71	finally
        //   35	56	71	finally
        //   62	68	71	finally
      }
      
      /* Error */
      public void a(String paramString, ov paramov, byte[] paramArrayOfByte)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: aload 4
        //   7: ldc 30
        //   9: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 4
        //   14: aload_1
        //   15: invokevirtual 37	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   18: aload_2
        //   19: ifnull +43 -> 62
        //   22: aload 4
        //   24: iconst_1
        //   25: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   28: aload_2
        //   29: aload 4
        //   31: iconst_0
        //   32: invokevirtual 47	com/google/android/gms/internal/ov:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload 4
        //   37: aload_3
        //   38: invokevirtual 72	android/os/Parcel:writeByteArray	([B)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/internal/oq$a$a:le	Landroid/os/IBinder;
        //   45: iconst_4
        //   46: aload 4
        //   48: aconst_null
        //   49: iconst_1
        //   50: invokeinterface 56 5 0
        //   55: pop
        //   56: aload 4
        //   58: invokevirtual 59	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   68: goto -33 -> 35
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 59	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramString	String
        //   0	79	2	paramov	ov
        //   0	79	3	paramArrayOfByte	byte[]
        //   3	70	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	18	71	finally
        //   22	35	71	finally
        //   35	56	71	finally
        //   62	68	71	finally
      }
      
      public IBinder asBinder()
      {
        return le;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.oq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */