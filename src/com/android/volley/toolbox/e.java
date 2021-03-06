package com.android.volley.toolbox;

import com.android.volley.a.a;
import com.android.volley.g;
import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class e
{
  public static long a(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException paramString) {}
    return 0L;
  }
  
  public static a.a a(g paramg)
  {
    int i = 0;
    long l4 = 0L;
    long l5 = System.currentTimeMillis();
    Map localMap = c;
    Object localObject1 = (String)localMap.get("Date");
    if (localObject1 != null) {}
    for (long l2 = a((String)localObject1);; l2 = 0L)
    {
      localObject1 = (String)localMap.get("Cache-Control");
      long l1;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).split(",");
        i = 0;
        l1 = 0L;
        if (i < localObject1.length)
        {
          localObject2 = localObject1[i].trim();
          if ((((String)localObject2).equals("no-cache")) || (((String)localObject2).equals("no-store"))) {
            return null;
          }
          if (((String)localObject2).startsWith("max-age=")) {}
          for (;;)
          {
            try
            {
              l3 = Long.parseLong(((String)localObject2).substring(8));
              l1 = l3;
            }
            catch (Exception localException)
            {
              continue;
              long l3 = 0L;
              continue;
            }
            i += 1;
            break;
            if ((((String)localObject2).equals("must-revalidate")) || (((String)localObject2).equals("proxy-revalidate"))) {
              l1 = 0L;
            }
          }
        }
        i = 1;
      }
      for (;;)
      {
        localObject1 = (String)localMap.get("Expires");
        if (localObject1 != null)
        {
          l3 = a((String)localObject1);
          localObject1 = (String)localMap.get("ETag");
          if (i != 0) {
            l1 = 1000L * l1 + l5;
          }
          for (;;)
          {
            localObject2 = new a.a();
            a = b;
            b = ((String)localObject1);
            e = l1;
            d = e;
            c = l2;
            f = localMap;
            return (a.a)localObject2;
            l1 = l4;
            if (l2 > 0L)
            {
              l1 = l4;
              if (l3 >= l2) {
                l1 = l3 - l2 + l5;
              }
            }
          }
        }
        l1 = 0L;
      }
    }
  }
  
  public static String a(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("Content-Type");
    if (paramMap != null)
    {
      paramMap = paramMap.split(";");
      int i = 1;
      while (i < paramMap.length)
      {
        String[] arrayOfString = paramMap[i].trim().split("=");
        if ((arrayOfString.length == 2) && (arrayOfString[0].equals("charset"))) {
          return arrayOfString[1];
        }
        i += 1;
      }
    }
    return "ISO-8859-1";
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */