package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ha;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class x
  extends Thread
  implements f
{
  private static x zM;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final LinkedBlockingQueue<Runnable> zJ = new LinkedBlockingQueue();
  private volatile boolean zK = false;
  private volatile String zL;
  private volatile ak zN;
  private final Lock zO;
  private final List<ha> zP = new ArrayList();
  
  private x(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (mContext = paramContext.getApplicationContext();; mContext = paramContext)
    {
      zP.add(new ha("appendVersion", "&_v".substring(1), "ma4.0.4"));
      zO = new ReentrantLock();
      start();
      return;
    }
  }
  
  static x A(Context paramContext)
  {
    if (zM == null) {
      zM = new x(paramContext);
    }
    return zM;
  }
  
  static String B(Context paramContext)
  {
    try
    {
      localObject = paramContext.openFileInput("gaInstallData");
      arrayOfByte = new byte[' '];
      i = ((FileInputStream)localObject).read(arrayOfByte, 0, 8192);
      if (((FileInputStream)localObject).available() > 0)
      {
        ae.T("Too much campaign data, ignoring it.");
        ((FileInputStream)localObject).close();
        paramContext.deleteFile("gaInstallData");
        return null;
      }
      ((FileInputStream)localObject).close();
      paramContext.deleteFile("gaInstallData");
      if (i <= 0)
      {
        ae.W("Campaign file is empty.");
        return null;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      byte[] arrayOfByte;
      int i;
      ae.U("No campaign data found.");
      return null;
      Object localObject = new String(arrayOfByte, 0, i);
      ae.U("Campaign found: " + (String)localObject);
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      ae.T("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return null;
  }
  
  static int ah(String paramString)
  {
    int k = 1;
    if (!TextUtils.isEmpty(paramString))
    {
      int j = paramString.length();
      int i = 0;
      j -= 1;
      for (;;)
      {
        k = i;
        if (j < 0) {
          break;
        }
        k = paramString.charAt(j);
        k = (i << 6 & 0xFFFFFFF) + k + (k << 14);
        int m = 0xFE00000 & k;
        i = k;
        if (m != 0) {
          i = k ^ m >> 21;
        }
        j -= 1;
      }
    }
    return k;
  }
  
  private void b(Runnable paramRunnable)
  {
    zJ.add(paramRunnable);
  }
  
  private String g(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void dQ()
  {
    b(new a(null));
  }
  
  public void dW()
  {
    b(new c(null));
  }
  
  public LinkedBlockingQueue<Runnable> dX()
  {
    return zJ;
  }
  
  public void dY()
  {
    init();
    Object localObject1 = new ArrayList();
    zJ.drainTo((Collection)localObject1);
    zO.lock();
    try
    {
      zK = true;
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Runnable localRunnable = (Runnable)((Iterator)localObject1).next();
          try
          {
            localRunnable.run();
          }
          catch (Throwable localThrowable)
          {
            ae.T("Error dispatching all events on exit, giving up: " + g(localThrowable));
          }
        }
      }
      return;
    }
    finally
    {
      zO.unlock();
    }
  }
  
  public void dispatch()
  {
    b(new b(null));
  }
  
  public Thread getThread()
  {
    return this;
  }
  
  /* Error */
  protected void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 200	com/google/android/gms/analytics/x:zN	Lcom/google/android/gms/analytics/ak;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 283	com/google/android/gms/analytics/w
    //   18: dup
    //   19: aload_0
    //   20: getfield 70	com/google/android/gms/analytics/x:mContext	Landroid/content/Context;
    //   23: aload_0
    //   24: invokespecial 286	com/google/android/gms/analytics/w:<init>	(Landroid/content/Context;Lcom/google/android/gms/analytics/f;)V
    //   27: putfield 200	com/google/android/gms/analytics/x:zN	Lcom/google/android/gms/analytics/ak;
    //   30: aload_0
    //   31: getfield 200	com/google/android/gms/analytics/x:zN	Lcom/google/android/gms/analytics/ak;
    //   34: invokeinterface 291 1 0
    //   39: goto -28 -> 11
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	x
    //   6	2	1	localak	ak
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	42	finally
    //   14	39	42	finally
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 299	android/os/Process:setThreadPriority	(I)V
    //   5: ldc2_w 300
    //   8: invokestatic 305	java/lang/Thread:sleep	(J)V
    //   11: aload_0
    //   12: invokevirtual 242	com/google/android/gms/analytics/x:init	()V
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 70	com/google/android/gms/analytics/x:mContext	Landroid/content/Context;
    //   20: invokestatic 307	com/google/android/gms/analytics/x:B	(Landroid/content/Context;)Ljava/lang/String;
    //   23: putfield 176	com/google/android/gms/analytics/x:zL	Ljava/lang/String;
    //   26: ldc_w 309
    //   29: invokestatic 312	com/google/android/gms/analytics/ae:V	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 57	com/google/android/gms/analytics/x:mClosed	Z
    //   36: ifne +165 -> 201
    //   39: aload_0
    //   40: getfield 53	com/google/android/gms/analytics/x:zJ	Ljava/util/concurrent/LinkedBlockingQueue;
    //   43: invokevirtual 315	java/util/concurrent/LinkedBlockingQueue:take	()Ljava/lang/Object;
    //   46: checkcast 267	java/lang/Runnable
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 98	com/google/android/gms/analytics/x:zO	Ljava/util/concurrent/locks/Lock;
    //   54: invokeinterface 251 1 0
    //   59: aload_0
    //   60: getfield 55	com/google/android/gms/analytics/x:zK	Z
    //   63: ifne +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 270 1 0
    //   72: aload_0
    //   73: getfield 98	com/google/android/gms/analytics/x:zO	Ljava/util/concurrent/locks/Lock;
    //   76: invokeinterface 277 1 0
    //   81: goto -49 -> 32
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 316	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   89: invokestatic 154	com/google/android/gms/analytics/ae:U	(Ljava/lang/String;)V
    //   92: goto -60 -> 32
    //   95: astore_1
    //   96: new 159	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 318
    //   106: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: aload_1
    //   111: invokespecial 274	com/google/android/gms/analytics/x:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   114: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 137	com/google/android/gms/analytics/ae:T	(Ljava/lang/String;)V
    //   123: ldc_w 320
    //   126: invokestatic 137	com/google/android/gms/analytics/ae:T	(Ljava/lang/String;)V
    //   129: aload_0
    //   130: iconst_1
    //   131: putfield 55	com/google/android/gms/analytics/x:zK	Z
    //   134: goto -102 -> 32
    //   137: astore_1
    //   138: ldc_w 322
    //   141: invokestatic 149	com/google/android/gms/analytics/ae:W	(Ljava/lang/String;)V
    //   144: goto -133 -> 11
    //   147: astore_1
    //   148: new 159	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 324
    //   158: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: aload_1
    //   163: invokespecial 274	com/google/android/gms/analytics/x:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   166: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 137	com/google/android/gms/analytics/ae:T	(Ljava/lang/String;)V
    //   175: ldc_w 326
    //   178: invokestatic 137	com/google/android/gms/analytics/ae:T	(Ljava/lang/String;)V
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 55	com/google/android/gms/analytics/x:zK	Z
    //   186: goto -154 -> 32
    //   189: astore_1
    //   190: aload_0
    //   191: getfield 98	com/google/android/gms/analytics/x:zO	Ljava/util/concurrent/locks/Lock;
    //   194: invokeinterface 277 1 0
    //   199: aload_1
    //   200: athrow
    //   201: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	x
    //   49	18	1	localRunnable	Runnable
    //   84	2	1	localInterruptedException1	InterruptedException
    //   95	16	1	localThrowable1	Throwable
    //   137	1	1	localInterruptedException2	InterruptedException
    //   147	16	1	localThrowable2	Throwable
    //   189	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	59	84	java/lang/InterruptedException
    //   72	81	84	java/lang/InterruptedException
    //   190	201	84	java/lang/InterruptedException
    //   39	59	95	java/lang/Throwable
    //   72	81	95	java/lang/Throwable
    //   85	92	95	java/lang/Throwable
    //   190	201	95	java/lang/Throwable
    //   5	11	137	java/lang/InterruptedException
    //   11	32	147	java/lang/Throwable
    //   59	72	189	finally
  }
  
  public void u(Map<String, String> paramMap)
  {
    b(new d(paramMap));
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      x.d(x.this).dQ();
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      x.d(x.this).dispatch();
    }
  }
  
  private class c
    implements Runnable
  {
    private c() {}
    
    public void run()
    {
      x.d(x.this).dW();
    }
  }
  
  private class d
    implements Runnable
  {
    private final Map<String, String> zR;
    
    d()
    {
      zR = new HashMap((Map)localObject);
      Object localObject = (String)((Map)localObject).get("&ht");
      this$1 = (x)localObject;
      if (localObject != null) {}
      try
      {
        Long.valueOf((String)localObject);
        this$1 = (x)localObject;
      }
      catch (NumberFormatException this$1)
      {
        for (;;)
        {
          long l;
          this$1 = null;
        }
      }
      if (x.this == null)
      {
        l = System.currentTimeMillis();
        zR.put("&ht", Long.toString(l));
      }
    }
    
    private String v(Map<String, String> paramMap)
    {
      if (paramMap.containsKey("useSecure"))
      {
        if (an.f((String)paramMap.get("useSecure"), true)) {
          return "https:";
        }
        return "http:";
      }
      return "https:";
    }
    
    private void w(Map<String, String> paramMap)
    {
      q localq = a.w(x.a(x.this));
      an.a(paramMap, "&adid", localq);
      an.a(paramMap, "&ate", localq);
    }
    
    private void x(Map<String, String> paramMap)
    {
      g localg = g.dZ();
      an.a(paramMap, "&an", localg);
      an.a(paramMap, "&av", localg);
      an.a(paramMap, "&aid", localg);
      an.a(paramMap, "&aiid", localg);
      paramMap.put("&v", "1");
    }
    
    private boolean y(Map<String, String> paramMap)
    {
      if (paramMap.get("&sf") == null) {
        return false;
      }
      double d = an.a((String)paramMap.get("&sf"), 100.0D);
      if (d >= 100.0D) {
        return false;
      }
      if (x.ah((String)paramMap.get("&cid")) % 10000 >= d * 100.0D)
      {
        if (paramMap.get("&t") == null) {}
        for (paramMap = "unknown";; paramMap = (String)paramMap.get("&t"))
        {
          ae.V(String.format("%s hit sampled out", new Object[] { paramMap }));
          return true;
        }
      }
      return false;
    }
    
    public void run()
    {
      w(zR);
      if (TextUtils.isEmpty((CharSequence)zR.get("&cid"))) {
        zR.put("&cid", k.el().getValue("&cid"));
      }
      if ((GoogleAnalytics.getInstance(x.a(x.this)).getAppOptOut()) || (y(zR))) {
        return;
      }
      if (!TextUtils.isEmpty(x.b(x.this)))
      {
        y.eK().D(true);
        zR.putAll(new HitBuilders.HitBuilder().setCampaignParamsFromUrl(x.b(x.this)).build());
        y.eK().D(false);
        x.a(x.this, null);
      }
      x(zR);
      Map localMap = ac.z(zR);
      x.d(x.this).b(localMap, Long.valueOf((String)zR.get("&ht")).longValue(), v(zR), x.c(x.this));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.analytics.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */