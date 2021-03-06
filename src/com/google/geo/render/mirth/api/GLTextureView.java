package com.google.geo.render.mirth.api;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.GLWrapper;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static final i a = new i((byte)0);
  private final WeakReference<GLTextureView> b = new WeakReference(this);
  private h c;
  private GLSurfaceView.Renderer d;
  private boolean e;
  private GLSurfaceView.EGLConfigChooser f;
  private e g;
  private f h;
  private GLSurfaceView.GLWrapper i;
  private int j;
  private int k;
  private boolean l;
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void c()
  {
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), paramAnonymousInt3 - paramAnonymousInt1, paramAnonymousInt4 - paramAnonymousInt2);
      }
    });
  }
  
  private void d()
  {
    if (c != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    c.a(paramRunnable);
  }
  
  protected void finalize()
  {
    try
    {
      if (c != null) {
        c.f();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return j;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return l;
  }
  
  public int getRenderMode()
  {
    return c.b();
  }
  
  public void k_()
  {
    c.c();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((e) && (d != null)) {
      if (c == null) {
        break label74;
      }
    }
    label74:
    for (int m = c.b();; m = 1)
    {
      c = new h(b);
      if (m != 1) {
        c.a(m);
      }
      c.start();
      e = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (c != null) {
      c.f();
    }
    e = true;
    super.onDetachedFromWindow();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    c.d();
    c.a(paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    c.e();
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    c.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setDebugFlags(int paramInt)
  {
    j = paramInt;
  }
  
  public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser paramEGLConfigChooser)
  {
    d();
    f = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new k(paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    d();
    k = paramInt;
  }
  
  public void setEGLContextFactory(e parame)
  {
    d();
    g = parame;
  }
  
  public void setEGLWindowSurfaceFactory(f paramf)
  {
    d();
    h = paramf;
  }
  
  public void setGLWrapper(GLSurfaceView.GLWrapper paramGLWrapper)
  {
    i = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    l = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    c.a(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    d();
    if (f == null) {
      f = new k(true);
    }
    if (g == null) {
      g = new c((byte)0);
    }
    if (h == null) {
      h = new d((byte)0);
    }
    d = paramRenderer;
    c = new h(b);
    c.start();
  }
  
  abstract class a
    implements GLSurfaceView.EGLConfigChooser
  {
    private int[] a;
    
    public a(int[] paramArrayOfInt)
    {
      if (GLTextureView.a(GLTextureView.this) != 2) {}
      for (;;)
      {
        a = paramArrayOfInt;
        return;
        int i = paramArrayOfInt.length;
        this$1 = new int[i + 2];
        System.arraycopy(paramArrayOfInt, 0, GLTextureView.this, 0, i - 1);
        GLTextureView.this[(i - 1)] = 12352;
        GLTextureView.this[i] = 4;
        GLTextureView.this[(i + 1)] = 12344;
        paramArrayOfInt = GLTextureView.this;
      }
    }
    
    abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, a, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, a, arrayOfEGLConfig, i, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      }
      paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      if (paramEGL10 == null) {
        throw new IllegalArgumentException("No config chosen");
      }
      return paramEGL10;
    }
  }
  
  class b
    extends GLTextureView.a
  {
    private final int[] a = new int[1];
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      super(new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 });
      b = paramInt1;
      c = paramInt2;
      d = paramInt3;
      e = paramInt4;
      f = paramInt5;
      g = paramInt6;
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      paramInt2 = 0;
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, a)) {
        paramInt2 = a[0];
      }
      return paramInt2;
    }
    
    public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((k >= f) && (m >= g))
        {
          k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
          if ((k == b) && (m == c) && (n == d) && (i1 == e)) {
            return localEGLConfig;
          }
        }
        i += 1;
      }
      return null;
    }
  }
  
  class c
    implements GLTextureView.e
  {
    private c() {}
    
    public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = 12440;
      arrayOfInt[1] = GLTextureView.a(GLTextureView.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (GLTextureView.a(GLTextureView.this) != 0) {}
      for (;;)
      {
        return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        arrayOfInt = null;
      }
    }
    
    public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
        GLTextureView.g.a("eglDestroyContex", paramEGL10.eglGetError());
      }
    }
  }
  
  static class d
    implements GLTextureView.f
  {
    public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        Log.e("GLTextureView", "eglCreateWindowSurface", paramEGL10);
      }
      return null;
    }
    
    public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
  
  public static abstract interface e
  {
    public abstract EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  public static abstract interface f
  {
    public abstract EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  static class g
  {
    EGLConfig a;
    private final WeakReference<GLTextureView> b;
    private EGL10 c;
    private EGLDisplay d;
    private EGLSurface e;
    private EGLContext f;
    
    public g(WeakReference<GLTextureView> paramWeakReference)
    {
      b = paramWeakReference;
    }
    
    public static void a(String paramString, int paramInt)
    {
      throw new RuntimeException(b(paramString, paramInt));
    }
    
    public static void a(String paramString1, String paramString2, int paramInt)
    {
      Log.w(paramString1, b(paramString2, paramInt));
    }
    
    public static String b(String paramString, int paramInt)
    {
      return paramString + " failed: " + paramInt;
    }
    
    private void g()
    {
      if ((e != null) && (e != EGL10.EGL_NO_SURFACE))
      {
        c.eglMakeCurrent(d, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        GLTextureView localGLTextureView = (GLTextureView)b.get();
        if (localGLTextureView != null) {
          GLTextureView.d(localGLTextureView).a(c, d, e);
        }
        e = null;
      }
    }
    
    public void a()
    {
      c = ((EGL10)EGLContext.getEGL());
      d = c.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (d == EGL10.EGL_NO_DISPLAY) {
        throw new RuntimeException("eglGetDisplay failed");
      }
      Object localObject = new int[2];
      if (!c.eglInitialize(d, (int[])localObject)) {
        throw new RuntimeException("eglInitialize failed");
      }
      localObject = (GLTextureView)b.get();
      if (localObject == null) {
        a = null;
      }
      for (f = null;; f = GLTextureView.c((GLTextureView)localObject).a(c, d, a))
      {
        if ((f == null) || (f == EGL10.EGL_NO_CONTEXT))
        {
          f = null;
          a("createContext", c.eglGetError());
        }
        e = null;
        return;
        a = GLTextureView.b((GLTextureView)localObject).chooseConfig(c, d);
      }
    }
    
    public boolean b()
    {
      if (c == null) {
        throw new RuntimeException("egl not initialized");
      }
      if (d == null) {
        throw new RuntimeException("eglDisplay not initialized");
      }
      if (a == null) {
        throw new RuntimeException("mEglConfig not initialized");
      }
      g();
      GLTextureView localGLTextureView = (GLTextureView)b.get();
      if (localGLTextureView != null) {}
      for (e = GLTextureView.d(localGLTextureView).a(c, d, a, localGLTextureView.getSurfaceTexture()); (e == null) || (e == EGL10.EGL_NO_SURFACE); e = null)
      {
        if (c.eglGetError() == 12299) {
          Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        }
        return false;
      }
      if (!c.eglMakeCurrent(d, e, e, f))
      {
        a("EGLHelper", "eglMakeCurrent", c.eglGetError());
        return false;
      }
      return true;
    }
    
    final GL c()
    {
      GL localGL2 = f.getGL();
      GLTextureView localGLTextureView = (GLTextureView)b.get();
      Object localObject = localGL2;
      GL localGL1;
      int i;
      if (localGLTextureView != null)
      {
        localGL1 = localGL2;
        if (GLTextureView.e(localGLTextureView) != null) {
          localGL1 = GLTextureView.e(localGLTextureView).wrap(localGL2);
        }
        localObject = localGL1;
        if ((GLTextureView.f(localGLTextureView) & 0x3) != 0)
        {
          i = 0;
          if ((GLTextureView.f(localGLTextureView) & 0x1) != 0) {
            i = 1;
          }
          if ((GLTextureView.f(localGLTextureView) & 0x2) == 0) {
            break label106;
          }
        }
      }
      label106:
      for (localObject = new GLTextureView.j();; localObject = null)
      {
        localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
        return (GL)localObject;
      }
    }
    
    public int d()
    {
      if (!c.eglSwapBuffers(d, e)) {
        return c.eglGetError();
      }
      return 12288;
    }
    
    public void e()
    {
      g();
    }
    
    public void f()
    {
      if (f != null)
      {
        GLTextureView localGLTextureView = (GLTextureView)b.get();
        if (localGLTextureView != null) {
          GLTextureView.c(localGLTextureView).a(c, d, f);
        }
        f = null;
      }
      if (d != null)
      {
        c.eglTerminate(d);
        d = null;
      }
    }
  }
  
  static class h
    extends Thread
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l = 0;
    private int m = 0;
    private int n = 1;
    private boolean o = true;
    private boolean p;
    private final ArrayList<Runnable> q = new ArrayList();
    private boolean r = true;
    private GLTextureView.g s;
    private final WeakReference<GLTextureView> t;
    
    h(WeakReference<GLTextureView> paramWeakReference)
    {
      t = paramWeakReference;
    }
    
    private void h()
    {
      if (i)
      {
        i = false;
        s.e();
      }
    }
    
    private void i()
    {
      if (h)
      {
        s.f();
        h = false;
        GLTextureView.b().c(this);
      }
    }
    
    /* Error */
    private void j()
    {
      // Byte code:
      //   0: aload_0
      //   1: new 67	com/google/geo/render/mirth/api/GLTextureView$g
      //   4: dup
      //   5: aload_0
      //   6: getfield 55	com/google/geo/render/mirth/api/GLTextureView$h:t	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 85	com/google/geo/render/mirth/api/GLTextureView$g:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 65	com/google/geo/render/mirth/api/GLTextureView$h:s	Lcom/google/geo/render/mirth/api/GLTextureView$g;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 71	com/google/geo/render/mirth/api/GLTextureView$h:h	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 63	com/google/geo/render/mirth/api/GLTextureView$h:i	Z
      //   25: iconst_0
      //   26: istore 10
      //   28: aconst_null
      //   29: astore 22
      //   31: iconst_0
      //   32: istore_1
      //   33: iconst_0
      //   34: istore_3
      //   35: iconst_0
      //   36: istore 5
      //   38: iconst_0
      //   39: istore 6
      //   41: iconst_0
      //   42: istore 7
      //   44: iconst_0
      //   45: istore 8
      //   47: iconst_0
      //   48: istore 9
      //   50: aconst_null
      //   51: astore 21
      //   53: iconst_0
      //   54: istore_2
      //   55: iconst_0
      //   56: istore 4
      //   58: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   61: astore 23
      //   63: aload 23
      //   65: monitorenter
      //   66: iload 10
      //   68: istore 11
      //   70: iload 7
      //   72: istore 10
      //   74: iload 4
      //   76: istore 14
      //   78: aload_0
      //   79: getfield 87	com/google/geo/render/mirth/api/GLTextureView$h:a	Z
      //   82: ifeq +34 -> 116
      //   85: aload 23
      //   87: monitorexit
      //   88: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   91: astore 21
      //   93: aload 21
      //   95: monitorenter
      //   96: aload_0
      //   97: invokespecial 89	com/google/geo/render/mirth/api/GLTextureView$h:h	()V
      //   100: aload_0
      //   101: invokespecial 91	com/google/geo/render/mirth/api/GLTextureView$h:i	()V
      //   104: aload 21
      //   106: monitorexit
      //   107: return
      //   108: astore 22
      //   110: aload 21
      //   112: monitorexit
      //   113: aload 22
      //   115: athrow
      //   116: aload_0
      //   117: getfield 43	com/google/geo/render/mirth/api/GLTextureView$h:q	Ljava/util/ArrayList;
      //   120: invokevirtual 95	java/util/ArrayList:isEmpty	()Z
      //   123: ifne +93 -> 216
      //   126: aload_0
      //   127: getfield 43	com/google/geo/render/mirth/api/GLTextureView$h:q	Ljava/util/ArrayList;
      //   130: iconst_0
      //   131: invokevirtual 99	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   134: checkcast 101	java/lang/Runnable
      //   137: astore 21
      //   139: iload 10
      //   141: istore 7
      //   143: iload 6
      //   145: istore 12
      //   147: iload_1
      //   148: istore 4
      //   150: iload 11
      //   152: istore 10
      //   154: iload 7
      //   156: istore 6
      //   158: iload 12
      //   160: istore 7
      //   162: iload_2
      //   163: istore_1
      //   164: iload 14
      //   166: istore_2
      //   167: aload 23
      //   169: monitorexit
      //   170: aload 21
      //   172: ifnull +614 -> 786
      //   175: aload 21
      //   177: invokeinterface 104 1 0
      //   182: iload 6
      //   184: istore 11
      //   186: aconst_null
      //   187: astore 21
      //   189: iload_1
      //   190: istore 12
      //   192: iload_2
      //   193: istore 6
      //   195: iload 4
      //   197: istore_1
      //   198: iload 12
      //   200: istore_2
      //   201: iload 6
      //   203: istore 4
      //   205: iload 7
      //   207: istore 6
      //   209: iload 11
      //   211: istore 7
      //   213: goto -155 -> 58
      //   216: aload_0
      //   217: getfield 106	com/google/geo/render/mirth/api/GLTextureView$h:d	Z
      //   220: aload_0
      //   221: getfield 108	com/google/geo/render/mirth/api/GLTextureView$h:c	Z
      //   224: if_icmpeq +985 -> 1209
      //   227: aload_0
      //   228: getfield 108	com/google/geo/render/mirth/api/GLTextureView$h:c	Z
      //   231: istore 19
      //   233: aload_0
      //   234: aload_0
      //   235: getfield 108	com/google/geo/render/mirth/api/GLTextureView$h:c	Z
      //   238: putfield 106	com/google/geo/render/mirth/api/GLTextureView$h:d	Z
      //   241: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   244: invokevirtual 113	java/lang/Object:notifyAll	()V
      //   247: iload_3
      //   248: istore 4
      //   250: aload_0
      //   251: getfield 115	com/google/geo/render/mirth/api/GLTextureView$h:k	Z
      //   254: ifeq +19 -> 273
      //   257: aload_0
      //   258: invokespecial 89	com/google/geo/render/mirth/api/GLTextureView$h:h	()V
      //   261: aload_0
      //   262: invokespecial 91	com/google/geo/render/mirth/api/GLTextureView$h:i	()V
      //   265: aload_0
      //   266: iconst_0
      //   267: putfield 115	com/google/geo/render/mirth/api/GLTextureView$h:k	Z
      //   270: iconst_1
      //   271: istore 4
      //   273: iload 10
      //   275: istore 7
      //   277: iload 10
      //   279: ifeq +14 -> 293
      //   282: aload_0
      //   283: invokespecial 89	com/google/geo/render/mirth/api/GLTextureView$h:h	()V
      //   286: aload_0
      //   287: invokespecial 91	com/google/geo/render/mirth/api/GLTextureView$h:i	()V
      //   290: iconst_0
      //   291: istore 7
      //   293: iload 19
      //   295: ifeq +14 -> 309
      //   298: aload_0
      //   299: getfield 63	com/google/geo/render/mirth/api/GLTextureView$h:i	Z
      //   302: ifeq +7 -> 309
      //   305: aload_0
      //   306: invokespecial 89	com/google/geo/render/mirth/api/GLTextureView$h:h	()V
      //   309: iload 19
      //   311: ifeq +48 -> 359
      //   314: aload_0
      //   315: getfield 71	com/google/geo/render/mirth/api/GLTextureView$h:h	Z
      //   318: ifeq +41 -> 359
      //   321: aload_0
      //   322: getfield 55	com/google/geo/render/mirth/api/GLTextureView$h:t	Ljava/lang/ref/WeakReference;
      //   325: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   328: checkcast 6	com/google/geo/render/mirth/api/GLTextureView
      //   331: astore 24
      //   333: aload 24
      //   335: ifnonnull +312 -> 647
      //   338: iconst_0
      //   339: istore 20
      //   341: iload 20
      //   343: ifeq +12 -> 355
      //   346: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   349: invokevirtual 123	com/google/geo/render/mirth/api/GLTextureView$i:a	()Z
      //   352: ifeq +7 -> 359
      //   355: aload_0
      //   356: invokespecial 91	com/google/geo/render/mirth/api/GLTextureView$h:i	()V
      //   359: iload 19
      //   361: ifeq +19 -> 380
      //   364: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   367: invokevirtual 125	com/google/geo/render/mirth/api/GLTextureView$i:b	()Z
      //   370: ifeq +10 -> 380
      //   373: aload_0
      //   374: getfield 65	com/google/geo/render/mirth/api/GLTextureView$h:s	Lcom/google/geo/render/mirth/api/GLTextureView$g;
      //   377: invokevirtual 73	com/google/geo/render/mirth/api/GLTextureView$g:f	()V
      //   380: aload_0
      //   381: getfield 127	com/google/geo/render/mirth/api/GLTextureView$h:e	Z
      //   384: ifne +37 -> 421
      //   387: aload_0
      //   388: getfield 129	com/google/geo/render/mirth/api/GLTextureView$h:g	Z
      //   391: ifne +30 -> 421
      //   394: aload_0
      //   395: getfield 63	com/google/geo/render/mirth/api/GLTextureView$h:i	Z
      //   398: ifeq +7 -> 405
      //   401: aload_0
      //   402: invokespecial 89	com/google/geo/render/mirth/api/GLTextureView$h:h	()V
      //   405: aload_0
      //   406: iconst_1
      //   407: putfield 129	com/google/geo/render/mirth/api/GLTextureView$h:g	Z
      //   410: aload_0
      //   411: iconst_0
      //   412: putfield 131	com/google/geo/render/mirth/api/GLTextureView$h:f	Z
      //   415: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   418: invokevirtual 113	java/lang/Object:notifyAll	()V
      //   421: aload_0
      //   422: getfield 127	com/google/geo/render/mirth/api/GLTextureView$h:e	Z
      //   425: ifeq +21 -> 446
      //   428: aload_0
      //   429: getfield 129	com/google/geo/render/mirth/api/GLTextureView$h:g	Z
      //   432: ifeq +14 -> 446
      //   435: aload_0
      //   436: iconst_0
      //   437: putfield 129	com/google/geo/render/mirth/api/GLTextureView$h:g	Z
      //   440: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   443: invokevirtual 113	java/lang/Object:notifyAll	()V
      //   446: iload 14
      //   448: istore 12
      //   450: iload 5
      //   452: istore 13
      //   454: iload 14
      //   456: ifeq +20 -> 476
      //   459: iconst_0
      //   460: istore 13
      //   462: iconst_0
      //   463: istore 12
      //   465: aload_0
      //   466: iconst_1
      //   467: putfield 133	com/google/geo/render/mirth/api/GLTextureView$h:p	Z
      //   470: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   473: invokevirtual 113	java/lang/Object:notifyAll	()V
      //   476: iload 4
      //   478: istore_3
      //   479: iload 6
      //   481: istore 15
      //   483: iload 8
      //   485: istore 16
      //   487: iload 9
      //   489: istore 17
      //   491: iload 11
      //   493: istore 18
      //   495: aload_0
      //   496: invokespecial 135	com/google/geo/render/mirth/api/GLTextureView$h:k	()Z
      //   499: ifeq +250 -> 749
      //   502: iload 4
      //   504: istore_3
      //   505: iload 11
      //   507: istore 10
      //   509: aload_0
      //   510: getfield 71	com/google/geo/render/mirth/api/GLTextureView$h:h	Z
      //   513: ifne +14 -> 527
      //   516: iload 4
      //   518: ifeq +139 -> 657
      //   521: iconst_0
      //   522: istore_3
      //   523: iload 11
      //   525: istore 10
      //   527: aload_0
      //   528: getfield 71	com/google/geo/render/mirth/api/GLTextureView$h:h	Z
      //   531: ifeq +667 -> 1198
      //   534: aload_0
      //   535: getfield 63	com/google/geo/render/mirth/api/GLTextureView$h:i	Z
      //   538: ifne +660 -> 1198
      //   541: aload_0
      //   542: iconst_1
      //   543: putfield 63	com/google/geo/render/mirth/api/GLTextureView$h:i	Z
      //   546: iconst_1
      //   547: istore 9
      //   549: iconst_1
      //   550: istore 5
      //   552: iconst_1
      //   553: istore 4
      //   555: aload_0
      //   556: getfield 63	com/google/geo/render/mirth/api/GLTextureView$h:i	Z
      //   559: ifeq +659 -> 1218
      //   562: aload_0
      //   563: getfield 45	com/google/geo/render/mirth/api/GLTextureView$h:r	Z
      //   566: ifeq +615 -> 1181
      //   569: iconst_1
      //   570: istore_2
      //   571: aload_0
      //   572: getfield 47	com/google/geo/render/mirth/api/GLTextureView$h:l	I
      //   575: istore 6
      //   577: aload_0
      //   578: getfield 49	com/google/geo/render/mirth/api/GLTextureView$h:m	I
      //   581: istore_1
      //   582: iconst_1
      //   583: istore 8
      //   585: iconst_1
      //   586: istore 5
      //   588: aload_0
      //   589: iconst_0
      //   590: putfield 45	com/google/geo/render/mirth/api/GLTextureView$h:r	Z
      //   593: aload_0
      //   594: iconst_0
      //   595: putfield 51	com/google/geo/render/mirth/api/GLTextureView$h:o	Z
      //   598: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   601: invokevirtual 113	java/lang/Object:notifyAll	()V
      //   604: iload 4
      //   606: istore 11
      //   608: iload 12
      //   610: istore 4
      //   612: iload 6
      //   614: istore 12
      //   616: iload 7
      //   618: istore 6
      //   620: iload_2
      //   621: istore 7
      //   623: iload 5
      //   625: istore 9
      //   627: iload 4
      //   629: istore_2
      //   630: iload_1
      //   631: istore 4
      //   633: iload 12
      //   635: istore_1
      //   636: iload 8
      //   638: istore 5
      //   640: iload 11
      //   642: istore 8
      //   644: goto -477 -> 167
      //   647: aload 24
      //   649: invokestatic 138	com/google/geo/render/mirth/api/GLTextureView:g	(Lcom/google/geo/render/mirth/api/GLTextureView;)Z
      //   652: istore 20
      //   654: goto -313 -> 341
      //   657: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   660: aload_0
      //   661: invokevirtual 141	com/google/geo/render/mirth/api/GLTextureView$i:b	(Lcom/google/geo/render/mirth/api/GLTextureView$h;)Z
      //   664: istore 19
      //   666: iload 4
      //   668: istore_3
      //   669: iload 11
      //   671: istore 10
      //   673: iload 19
      //   675: ifeq -148 -> 527
      //   678: aload_0
      //   679: getfield 65	com/google/geo/render/mirth/api/GLTextureView$h:s	Lcom/google/geo/render/mirth/api/GLTextureView$g;
      //   682: invokevirtual 143	com/google/geo/render/mirth/api/GLTextureView$g:a	()V
      //   685: aload_0
      //   686: iconst_1
      //   687: putfield 71	com/google/geo/render/mirth/api/GLTextureView$h:h	Z
      //   690: iconst_1
      //   691: istore 10
      //   693: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   696: invokevirtual 113	java/lang/Object:notifyAll	()V
      //   699: iload 4
      //   701: istore_3
      //   702: goto -175 -> 527
      //   705: astore 21
      //   707: aload 23
      //   709: monitorexit
      //   710: aload 21
      //   712: athrow
      //   713: astore 22
      //   715: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   718: astore 21
      //   720: aload 21
      //   722: monitorenter
      //   723: aload_0
      //   724: invokespecial 89	com/google/geo/render/mirth/api/GLTextureView$h:h	()V
      //   727: aload_0
      //   728: invokespecial 91	com/google/geo/render/mirth/api/GLTextureView$h:i	()V
      //   731: aload 21
      //   733: monitorexit
      //   734: aload 22
      //   736: athrow
      //   737: astore 21
      //   739: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   742: aload_0
      //   743: invokevirtual 81	com/google/geo/render/mirth/api/GLTextureView$i:c	(Lcom/google/geo/render/mirth/api/GLTextureView$h;)V
      //   746: aload 21
      //   748: athrow
      //   749: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   752: invokevirtual 146	java/lang/Object:wait	()V
      //   755: iload 12
      //   757: istore 14
      //   759: iload 13
      //   761: istore 5
      //   763: iload 15
      //   765: istore 6
      //   767: iload 7
      //   769: istore 10
      //   771: iload 16
      //   773: istore 8
      //   775: iload 17
      //   777: istore 9
      //   779: iload 18
      //   781: istore 11
      //   783: goto -705 -> 78
      //   786: iload 9
      //   788: ifeq +390 -> 1178
      //   791: aload_0
      //   792: getfield 65	com/google/geo/render/mirth/api/GLTextureView$h:s	Lcom/google/geo/render/mirth/api/GLTextureView$g;
      //   795: invokevirtual 147	com/google/geo/render/mirth/api/GLTextureView$g:b	()Z
      //   798: ifeq +295 -> 1093
      //   801: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   804: astore 23
      //   806: aload 23
      //   808: monitorenter
      //   809: aload_0
      //   810: iconst_1
      //   811: putfield 149	com/google/geo/render/mirth/api/GLTextureView$h:j	Z
      //   814: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   817: invokevirtual 113	java/lang/Object:notifyAll	()V
      //   820: aload 23
      //   822: monitorexit
      //   823: iconst_0
      //   824: istore 9
      //   826: iload 8
      //   828: ifeq +347 -> 1175
      //   831: aload_0
      //   832: getfield 65	com/google/geo/render/mirth/api/GLTextureView$h:s	Lcom/google/geo/render/mirth/api/GLTextureView$g;
      //   835: invokevirtual 152	com/google/geo/render/mirth/api/GLTextureView$g:c	()Ljavax/microedition/khronos/opengles/GL;
      //   838: checkcast 154	javax/microedition/khronos/opengles/GL10
      //   841: astore 22
      //   843: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   846: aload 22
      //   848: invokevirtual 157	com/google/geo/render/mirth/api/GLTextureView$i:a	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   851: iconst_0
      //   852: istore 8
      //   854: iload 10
      //   856: istore 11
      //   858: iload 10
      //   860: ifeq +42 -> 902
      //   863: aload_0
      //   864: getfield 55	com/google/geo/render/mirth/api/GLTextureView$h:t	Ljava/lang/ref/WeakReference;
      //   867: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   870: checkcast 6	com/google/geo/render/mirth/api/GLTextureView
      //   873: astore 23
      //   875: aload 23
      //   877: ifnull +360 -> 1237
      //   880: aload 23
      //   882: invokestatic 160	com/google/geo/render/mirth/api/GLTextureView:h	(Lcom/google/geo/render/mirth/api/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   885: aload 22
      //   887: aload_0
      //   888: getfield 65	com/google/geo/render/mirth/api/GLTextureView$h:s	Lcom/google/geo/render/mirth/api/GLTextureView$g;
      //   891: getfield 163	com/google/geo/render/mirth/api/GLTextureView$g:a	Ljavax/microedition/khronos/egl/EGLConfig;
      //   894: invokeinterface 169 3 0
      //   899: goto +338 -> 1237
      //   902: iload 7
      //   904: istore 10
      //   906: iload 7
      //   908: ifeq +38 -> 946
      //   911: aload_0
      //   912: getfield 55	com/google/geo/render/mirth/api/GLTextureView$h:t	Ljava/lang/ref/WeakReference;
      //   915: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   918: checkcast 6	com/google/geo/render/mirth/api/GLTextureView
      //   921: astore 23
      //   923: aload 23
      //   925: ifnull +318 -> 1243
      //   928: aload 23
      //   930: invokestatic 160	com/google/geo/render/mirth/api/GLTextureView:h	(Lcom/google/geo/render/mirth/api/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   933: aload 22
      //   935: iload_1
      //   936: iload 4
      //   938: invokeinterface 173 4 0
      //   943: goto +300 -> 1243
      //   946: aload_0
      //   947: getfield 55	com/google/geo/render/mirth/api/GLTextureView$h:t	Ljava/lang/ref/WeakReference;
      //   950: invokevirtual 121	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   953: checkcast 6	com/google/geo/render/mirth/api/GLTextureView
      //   956: astore 23
      //   958: aload 23
      //   960: ifnull +15 -> 975
      //   963: aload 23
      //   965: invokestatic 160	com/google/geo/render/mirth/api/GLTextureView:h	(Lcom/google/geo/render/mirth/api/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   968: aload 22
      //   970: invokeinterface 176 2 0
      //   975: aload_0
      //   976: getfield 65	com/google/geo/render/mirth/api/GLTextureView$h:s	Lcom/google/geo/render/mirth/api/GLTextureView$g;
      //   979: invokevirtual 179	com/google/geo/render/mirth/api/GLTextureView$g:d	()I
      //   982: istore 12
      //   984: iload 6
      //   986: istore 7
      //   988: iload 12
      //   990: lookupswitch	default:+259->1249, 12288:+61->1051, 12302:+262->1252
      //   1016: ldc -75
      //   1018: ldc -73
      //   1020: iload 12
      //   1022: invokestatic 186	com/google/geo/render/mirth/api/GLTextureView$g:a	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1025: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   1028: astore 23
      //   1030: aload 23
      //   1032: monitorenter
      //   1033: aload_0
      //   1034: iconst_1
      //   1035: putfield 131	com/google/geo/render/mirth/api/GLTextureView$h:f	Z
      //   1038: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   1041: invokevirtual 113	java/lang/Object:notifyAll	()V
      //   1044: aload 23
      //   1046: monitorexit
      //   1047: iload 6
      //   1049: istore 7
      //   1051: iload 5
      //   1053: ifeq +162 -> 1215
      //   1056: iconst_1
      //   1057: istore_2
      //   1058: iload_1
      //   1059: istore 12
      //   1061: iload_2
      //   1062: istore 6
      //   1064: iload 4
      //   1066: istore_1
      //   1067: iload 12
      //   1069: istore_2
      //   1070: iload 6
      //   1072: istore 4
      //   1074: iload 10
      //   1076: istore 6
      //   1078: iload 11
      //   1080: istore 10
      //   1082: goto -1024 -> 58
      //   1085: astore 21
      //   1087: aload 23
      //   1089: monitorexit
      //   1090: aload 21
      //   1092: athrow
      //   1093: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   1096: astore 23
      //   1098: aload 23
      //   1100: monitorenter
      //   1101: aload_0
      //   1102: iconst_1
      //   1103: putfield 149	com/google/geo/render/mirth/api/GLTextureView$h:j	Z
      //   1106: aload_0
      //   1107: iconst_1
      //   1108: putfield 131	com/google/geo/render/mirth/api/GLTextureView$h:f	Z
      //   1111: invokestatic 76	com/google/geo/render/mirth/api/GLTextureView:b	()Lcom/google/geo/render/mirth/api/GLTextureView$i;
      //   1114: invokevirtual 113	java/lang/Object:notifyAll	()V
      //   1117: aload 23
      //   1119: monitorexit
      //   1120: iload 6
      //   1122: istore 11
      //   1124: iload_1
      //   1125: istore 12
      //   1127: iload_2
      //   1128: istore 6
      //   1130: iload 4
      //   1132: istore_1
      //   1133: iload 12
      //   1135: istore_2
      //   1136: iload 6
      //   1138: istore 4
      //   1140: iload 7
      //   1142: istore 6
      //   1144: iload 11
      //   1146: istore 7
      //   1148: goto -1090 -> 58
      //   1151: astore 21
      //   1153: aload 23
      //   1155: monitorexit
      //   1156: aload 21
      //   1158: athrow
      //   1159: astore 21
      //   1161: aload 23
      //   1163: monitorexit
      //   1164: aload 21
      //   1166: athrow
      //   1167: astore 22
      //   1169: aload 21
      //   1171: monitorexit
      //   1172: aload 22
      //   1174: athrow
      //   1175: goto -321 -> 854
      //   1178: goto -352 -> 826
      //   1181: iload 13
      //   1183: istore 8
      //   1185: iload_2
      //   1186: istore 6
      //   1188: iload 5
      //   1190: istore_2
      //   1191: iload 9
      //   1193: istore 5
      //   1195: goto -602 -> 593
      //   1198: iload 6
      //   1200: istore 5
      //   1202: iload 8
      //   1204: istore 4
      //   1206: goto -651 -> 555
      //   1209: iconst_0
      //   1210: istore 19
      //   1212: goto -965 -> 247
      //   1215: goto -157 -> 1058
      //   1218: iload 5
      //   1220: istore 15
      //   1222: iload 4
      //   1224: istore 16
      //   1226: iload 9
      //   1228: istore 17
      //   1230: iload 10
      //   1232: istore 18
      //   1234: goto -485 -> 749
      //   1237: iconst_0
      //   1238: istore 11
      //   1240: goto -338 -> 902
      //   1243: iconst_0
      //   1244: istore 10
      //   1246: goto -300 -> 946
      //   1249: goto -233 -> 1016
      //   1252: iconst_1
      //   1253: istore 7
      //   1255: goto -204 -> 1051
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1258	0	this	h
      //   32	1101	1	i1	int
      //   54	1137	2	i2	int
      //   34	668	3	i3	int
      //   56	1167	4	i4	int
      //   36	1183	5	i5	int
      //   39	1160	6	i6	int
      //   42	1212	7	i7	int
      //   45	1158	8	i8	int
      //   48	1179	9	i9	int
      //   26	1219	10	i10	int
      //   68	1171	11	i11	int
      //   145	989	12	i12	int
      //   452	730	13	i13	int
      //   76	682	14	i14	int
      //   481	740	15	i15	int
      //   485	740	16	i16	int
      //   489	740	17	i17	int
      //   493	740	18	i18	int
      //   231	980	19	bool1	boolean
      //   339	314	20	bool2	boolean
      //   51	137	21	localObject1	Object
      //   705	6	21	localObject2	Object
      //   737	10	21	localRuntimeException	RuntimeException
      //   1085	6	21	localObject3	Object
      //   1151	6	21	localObject4	Object
      //   1159	11	21	localObject5	Object
      //   29	1	22	localObject6	Object
      //   108	6	22	localObject7	Object
      //   713	22	22	localObject8	Object
      //   841	128	22	localGL10	javax.microedition.khronos.opengles.GL10
      //   1167	6	22	localObject9	Object
      //   331	317	24	localGLTextureView	GLTextureView
      // Exception table:
      //   from	to	target	type
      //   96	107	108	finally
      //   78	88	705	finally
      //   116	139	705	finally
      //   167	170	705	finally
      //   216	247	705	finally
      //   250	270	705	finally
      //   282	290	705	finally
      //   298	309	705	finally
      //   314	333	705	finally
      //   346	355	705	finally
      //   355	359	705	finally
      //   364	380	705	finally
      //   380	405	705	finally
      //   405	421	705	finally
      //   421	446	705	finally
      //   465	476	705	finally
      //   495	502	705	finally
      //   509	516	705	finally
      //   527	546	705	finally
      //   555	569	705	finally
      //   571	582	705	finally
      //   588	593	705	finally
      //   593	604	705	finally
      //   647	654	705	finally
      //   657	666	705	finally
      //   678	685	705	finally
      //   685	690	705	finally
      //   693	699	705	finally
      //   739	749	705	finally
      //   749	755	705	finally
      //   58	66	713	finally
      //   175	182	713	finally
      //   707	713	713	finally
      //   791	809	713	finally
      //   831	851	713	finally
      //   863	875	713	finally
      //   880	899	713	finally
      //   911	923	713	finally
      //   928	943	713	finally
      //   946	958	713	finally
      //   963	975	713	finally
      //   975	984	713	finally
      //   1016	1033	713	finally
      //   1087	1093	713	finally
      //   1093	1101	713	finally
      //   1153	1159	713	finally
      //   1161	1167	713	finally
      //   678	685	737	java/lang/RuntimeException
      //   809	823	1085	finally
      //   1101	1120	1151	finally
      //   1033	1047	1159	finally
      //   723	734	1167	finally
    }
    
    private boolean k()
    {
      return (!d) && (e) && (!f) && (l > 0) && (m > 0) && ((o) || (n == 1));
    }
    
    public void a(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 1)) {
        throw new IllegalArgumentException("renderMode");
      }
      synchronized (GLTextureView.b())
      {
        n = paramInt;
        GLTextureView.b().notifyAll();
        return;
      }
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      synchronized ()
      {
        l = paramInt1;
        m = paramInt2;
        r = true;
        o = true;
        p = false;
        GLTextureView.b().notifyAll();
        for (;;)
        {
          if ((!b) && (!d) && (!p))
          {
            boolean bool = a();
            if (bool) {
              try
              {
                GLTextureView.b().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void a(Runnable paramRunnable)
    {
      if (paramRunnable == null) {
        throw new IllegalArgumentException("r must not be null");
      }
      synchronized (GLTextureView.b())
      {
        q.add(paramRunnable);
        GLTextureView.b().notifyAll();
        return;
      }
    }
    
    public boolean a()
    {
      return (h) && (i) && (k());
    }
    
    public int b()
    {
      synchronized ()
      {
        int i1 = n;
        return i1;
      }
    }
    
    public void c()
    {
      synchronized ()
      {
        o = true;
        GLTextureView.b().notifyAll();
        return;
      }
    }
    
    public void d()
    {
      synchronized ()
      {
        e = true;
        j = false;
        GLTextureView.b().notifyAll();
        for (;;)
        {
          if ((g) && (!j))
          {
            boolean bool = b;
            if (!bool) {
              try
              {
                GLTextureView.b().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void e()
    {
      synchronized ()
      {
        e = false;
        GLTextureView.b().notifyAll();
        for (;;)
        {
          if (!g)
          {
            boolean bool = b;
            if (!bool) {
              try
              {
                GLTextureView.b().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void f()
    {
      synchronized ()
      {
        a = true;
        GLTextureView.b().notifyAll();
        for (;;)
        {
          boolean bool = b;
          if (!bool) {
            try
            {
              GLTextureView.b().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    
    public void g()
    {
      k = true;
      GLTextureView.b().notifyAll();
    }
    
    public void run()
    {
      setName("GLThread " + getId());
      try
      {
        j();
        GLTextureView.b().a(this);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException = localInterruptedException;
        GLTextureView.b().a(this);
        return;
      }
      finally
      {
        localObject = finally;
        GLTextureView.b().a(this);
        throw ((Throwable)localObject);
      }
    }
  }
  
  static class i
  {
    private boolean a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private GLTextureView.h f;
    
    private void c()
    {
      if (!a)
      {
        b = 131072;
        if (b >= 131072) {
          d = true;
        }
        a = true;
      }
    }
    
    public void a(GLTextureView.h paramh)
    {
      try
      {
        GLTextureView.h.a(paramh, true);
        if (f == paramh) {
          f = null;
        }
        notifyAll();
        return;
      }
      finally {}
    }
    
    /* Error */
    public void a(javax.microedition.khronos.opengles.GL10 paramGL10)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 44	com/google/geo/render/mirth/api/GLTextureView$i:c	Z
      //   8: ifne +65 -> 73
      //   11: aload_0
      //   12: invokespecial 46	com/google/geo/render/mirth/api/GLTextureView$i:c	()V
      //   15: aload_1
      //   16: sipush 7937
      //   19: invokeinterface 52 2 0
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 28	com/google/geo/render/mirth/api/GLTextureView$i:b	I
      //   29: ldc 26
      //   31: if_icmpge +23 -> 54
      //   34: aload_1
      //   35: ldc 54
      //   37: invokevirtual 60	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   40: ifne +36 -> 76
      //   43: iconst_1
      //   44: istore_2
      //   45: aload_0
      //   46: iload_2
      //   47: putfield 30	com/google/geo/render/mirth/api/GLTextureView$i:d	Z
      //   50: aload_0
      //   51: invokevirtual 41	java/lang/Object:notifyAll	()V
      //   54: aload_0
      //   55: getfield 30	com/google/geo/render/mirth/api/GLTextureView$i:d	Z
      //   58: ifne +23 -> 81
      //   61: iload_3
      //   62: istore_2
      //   63: aload_0
      //   64: iload_2
      //   65: putfield 62	com/google/geo/render/mirth/api/GLTextureView$i:e	Z
      //   68: aload_0
      //   69: iconst_1
      //   70: putfield 44	com/google/geo/render/mirth/api/GLTextureView$i:c	Z
      //   73: aload_0
      //   74: monitorexit
      //   75: return
      //   76: iconst_0
      //   77: istore_2
      //   78: goto -33 -> 45
      //   81: iconst_0
      //   82: istore_2
      //   83: goto -20 -> 63
      //   86: astore_1
      //   87: aload_0
      //   88: monitorexit
      //   89: aload_1
      //   90: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	91	0	this	i
      //   0	91	1	paramGL10	javax.microedition.khronos.opengles.GL10
      //   44	39	2	bool1	boolean
      //   1	61	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   4	43	86	finally
      //   45	54	86	finally
      //   54	61	86	finally
      //   63	73	86	finally
    }
    
    public boolean a()
    {
      try
      {
        boolean bool = e;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    public boolean b()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial 46	com/google/geo/render/mirth/api/GLTextureView$i:c	()V
      //   6: aload_0
      //   7: getfield 30	com/google/geo/render/mirth/api/GLTextureView$i:d	Z
      //   10: istore_1
      //   11: iload_1
      //   12: ifne +9 -> 21
      //   15: iconst_1
      //   16: istore_1
      //   17: aload_0
      //   18: monitorexit
      //   19: iload_1
      //   20: ireturn
      //   21: iconst_0
      //   22: istore_1
      //   23: goto -6 -> 17
      //   26: astore_2
      //   27: aload_0
      //   28: monitorexit
      //   29: aload_2
      //   30: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	31	0	this	i
      //   10	13	1	bool	boolean
      //   26	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	11	26	finally
    }
    
    public boolean b(GLTextureView.h paramh)
    {
      if ((f == paramh) || (f == null))
      {
        f = paramh;
        notifyAll();
      }
      do
      {
        return true;
        c();
      } while (d);
      if (f != null) {
        f.g();
      }
      return false;
    }
    
    public void c(GLTextureView.h paramh)
    {
      if (f == paramh) {
        f = null;
      }
      notifyAll();
    }
  }
  
  static class j
    extends Writer
  {
    private final StringBuilder a = new StringBuilder();
    
    private void a()
    {
      if (a.length() > 0)
      {
        Log.v("GLTextureView", a.toString());
        a.delete(0, a.length());
      }
    }
    
    public void close()
    {
      a();
    }
    
    public void flush()
    {
      a();
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      int i = 0;
      if (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          a();
        }
        for (;;)
        {
          i += 1;
          break;
          a.append(c);
        }
      }
    }
  }
  
  class k
    extends GLTextureView.b
  {
    public k(boolean paramBoolean) {}
  }
}

/* Location:
 * Qualified Name:     com.google.geo.render.mirth.api.GLTextureView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */