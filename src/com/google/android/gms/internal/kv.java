package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class kv
  implements SafeParcelable
{
  public static final kw CREATOR = new kw();
  private final int CK;
  private final HashMap<String, HashMap<String, kr.a<?, ?>>> NV;
  private final ArrayList<a> NW;
  private final String NX;
  
  kv(int paramInt, ArrayList<a> paramArrayList, String paramString)
  {
    CK = paramInt;
    NW = null;
    NV = c(paramArrayList);
    NX = ((String)jx.i(paramString));
    hX();
  }
  
  public kv(Class<? extends kr> paramClass)
  {
    CK = 1;
    NW = null;
    NV = new HashMap();
    NX = paramClass.getCanonicalName();
  }
  
  private static HashMap<String, HashMap<String, kr.a<?, ?>>> c(ArrayList<a> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)paramArrayList.get(i);
      localHashMap.put(className, locala.ib());
      i += 1;
    }
    return localHashMap;
  }
  
  public void a(Class<? extends kr> paramClass, HashMap<String, kr.a<?, ?>> paramHashMap)
  {
    NV.put(paramClass.getCanonicalName(), paramHashMap);
  }
  
  public boolean b(Class<? extends kr> paramClass)
  {
    return NV.containsKey(paramClass.getCanonicalName());
  }
  
  public HashMap<String, kr.a<?, ?>> bg(String paramString)
  {
    return (HashMap)NV.get(paramString);
  }
  
  public int describeContents()
  {
    kw localkw = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return CK;
  }
  
  public void hX()
  {
    Iterator localIterator1 = NV.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (HashMap)NV.get(localObject);
      Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((kr.a)((HashMap)localObject).get((String)localIterator2.next())).a(this);
      }
    }
  }
  
  public void hY()
  {
    Iterator localIterator1 = NV.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      HashMap localHashMap1 = (HashMap)NV.get(str1);
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator2 = localHashMap1.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap2.put(str2, ((kr.a)localHashMap1.get(str2)).hN());
      }
      NV.put(str1, localHashMap2);
    }
  }
  
  ArrayList<a> hZ()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = NV.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, (HashMap)NV.get(str)));
    }
    return localArrayList;
  }
  
  public String ia()
  {
    return NX;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = NV.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (HashMap)NV.get(localObject);
      Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str).append(": ");
        localStringBuilder.append(((HashMap)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kw localkw = CREATOR;
    kw.a(this, paramParcel, paramInt);
  }
  
  public static class a
    implements SafeParcelable
  {
    public static final kx CREATOR = new kx();
    final ArrayList<kv.b> NY;
    final String className;
    final int versionCode;
    
    a(int paramInt, String paramString, ArrayList<kv.b> paramArrayList)
    {
      versionCode = paramInt;
      className = paramString;
      NY = paramArrayList;
    }
    
    a(String paramString, HashMap<String, kr.a<?, ?>> paramHashMap)
    {
      versionCode = 1;
      className = paramString;
      NY = a(paramHashMap);
    }
    
    private static ArrayList<kv.b> a(HashMap<String, kr.a<?, ?>> paramHashMap)
    {
      if (paramHashMap == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new kv.b(str, (kr.a)paramHashMap.get(str)));
      }
      return localArrayList;
    }
    
    public int describeContents()
    {
      kx localkx = CREATOR;
      return 0;
    }
    
    HashMap<String, kr.a<?, ?>> ib()
    {
      HashMap localHashMap = new HashMap();
      int j = NY.size();
      int i = 0;
      while (i < j)
      {
        kv.b localb = (kv.b)NY.get(i);
        localHashMap.put(fv, NZ);
        i += 1;
      }
      return localHashMap;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      kx localkx = CREATOR;
      kx.a(this, paramParcel, paramInt);
    }
  }
  
  public static class b
    implements SafeParcelable
  {
    public static final ku CREATOR = new ku();
    final kr.a<?, ?> NZ;
    final String fv;
    final int versionCode;
    
    b(int paramInt, String paramString, kr.a<?, ?> parama)
    {
      versionCode = paramInt;
      fv = paramString;
      NZ = parama;
    }
    
    b(String paramString, kr.a<?, ?> parama)
    {
      versionCode = 1;
      fv = paramString;
      NZ = parama;
    }
    
    public int describeContents()
    {
      ku localku = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ku localku = CREATOR;
      ku.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.kv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */