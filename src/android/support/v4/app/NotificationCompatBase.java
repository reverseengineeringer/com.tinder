package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

class NotificationCompatBase
{
  public static abstract class Action
  {
    protected abstract PendingIntent getActionIntent();
    
    protected abstract Bundle getExtras();
    
    protected abstract int getIcon();
    
    protected abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();
    
    protected abstract CharSequence getTitle();
    
    public static abstract interface Factory
    {
      public abstract NotificationCompatBase.Action build(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput);
      
      public abstract NotificationCompatBase.Action[] newArray(int paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.NotificationCompatBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */