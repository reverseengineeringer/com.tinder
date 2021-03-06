package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;
import java.io.FileNotFoundException;

class PrintHelperKitkat$2$1
  extends AsyncTask<Uri, Boolean, Bitmap>
{
  PrintHelperKitkat$2$1(PrintHelperKitkat.2 param2, CancellationSignal paramCancellationSignal, PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback) {}
  
  protected Bitmap doInBackground(Uri... paramVarArgs)
  {
    try
    {
      paramVarArgs = PrintHelperKitkat.access$200(this$1.this$0, this$1.val$imageFile, 3500);
      return paramVarArgs;
    }
    catch (FileNotFoundException paramVarArgs) {}
    return null;
  }
  
  protected void onCancelled(Bitmap paramBitmap)
  {
    val$layoutResultCallback.onLayoutCancelled();
  }
  
  protected void onPostExecute(Bitmap paramBitmap)
  {
    boolean bool = true;
    super.onPostExecute(paramBitmap);
    this$1.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      paramBitmap = new PrintDocumentInfo.Builder(this$1.val$jobName).setContentType(1).setPageCount(1).build();
      if (!val$newPrintAttributes.equals(val$oldPrintAttributes)) {}
      for (;;)
      {
        val$layoutResultCallback.onLayoutFinished(paramBitmap, bool);
        return;
        bool = false;
      }
    }
    val$layoutResultCallback.onLayoutFailed(null);
  }
  
  protected void onPreExecute()
  {
    val$cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
    {
      public void onCancel()
      {
        PrintHelperKitkat.2.access$100(this$1);
        cancel(false);
      }
    });
  }
}

/* Location:
 * Qualified Name:     android.support.v4.print.PrintHelperKitkat.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */