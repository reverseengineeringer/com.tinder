package com.mixpanel.android.mpmetrics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UpdateDisplayState$DisplayState$SurveyState$1
  implements Parcelable.Creator<UpdateDisplayState.DisplayState.SurveyState>
{
  public UpdateDisplayState.DisplayState.SurveyState a(Parcel paramParcel)
  {
    Bundle localBundle = new Bundle(UpdateDisplayState.DisplayState.SurveyState.class.getClassLoader());
    localBundle.readFromParcel(paramParcel);
    return new UpdateDisplayState.DisplayState.SurveyState(localBundle, null);
  }
  
  public UpdateDisplayState.DisplayState.SurveyState[] a(int paramInt)
  {
    return new UpdateDisplayState.DisplayState.SurveyState[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.SurveyState.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */