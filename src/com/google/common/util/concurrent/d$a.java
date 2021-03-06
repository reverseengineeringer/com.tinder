package com.google.common.util.concurrent;

import com.google.common.base.g;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class d$a<V>
  implements e<V>
{
  private static final Logger a = Logger.getLogger(a.class.getName());
  
  public void a(Runnable paramRunnable, Executor paramExecutor)
  {
    g.a(paramRunnable, "Runnable was null.");
    g.a(paramExecutor, "Executor was null.");
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      a.log(Level.SEVERE, "RuntimeException while executing runnable " + paramRunnable + " with executor " + paramExecutor, localRuntimeException);
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public abstract V get()
    throws ExecutionException;
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws ExecutionException
  {
    g.a(paramTimeUnit);
    return (V)get();
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.common.util.concurrent.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */