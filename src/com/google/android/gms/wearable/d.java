package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<c>
{
  static void a(c paramc, Parcel paramParcel, int paramInt)
  {
    paramInt = b.H(paramParcel);
    b.c(paramParcel, 1, CK);
    b.a(paramParcel, 2, paramc.getName(), false);
    b.a(paramParcel, 3, paramc.getAddress(), false);
    b.c(paramParcel, 4, paramc.getType());
    b.c(paramParcel, 5, paramc.getRole());
    b.a(paramParcel, 6, paramc.isEnabled());
    b.a(paramParcel, 7, paramc.isConnected());
    b.a(paramParcel, 8, paramc.rj(), false);
    b.H(paramParcel, paramInt);
  }
  
  public c em(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool1 = false;
    int m = a.G(paramParcel);
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    String str2 = null;
    String str3 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        str3 = a.o(paramParcel, n);
        break;
      case 3: 
        str2 = a.o(paramParcel, n);
        break;
      case 4: 
        j = a.g(paramParcel, n);
        break;
      case 5: 
        i = a.g(paramParcel, n);
        break;
      case 6: 
        bool2 = a.c(paramParcel, n);
        break;
      case 7: 
        bool1 = a.c(paramParcel, n);
        break;
      case 8: 
        str1 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new c(k, str3, str2, j, i, bool2, bool1, str1);
  }
  
  public c[] gv(int paramInt)
  {
    return new c[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */