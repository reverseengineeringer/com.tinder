package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MaterialProgressDrawable$4
  implements Animation.AnimationListener
{
  MaterialProgressDrawable$4(MaterialProgressDrawable paramMaterialProgressDrawable, MaterialProgressDrawable.Ring paramRing) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    val$ring.storeOriginals();
    val$ring.goToNextColor();
    val$ring.setStartTrim(val$ring.getEndTrim());
    MaterialProgressDrawable.access$602(this$0, (MaterialProgressDrawable.access$600(this$0) + 1.0F) % 5.0F);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    MaterialProgressDrawable.access$602(this$0, 0.0F);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */