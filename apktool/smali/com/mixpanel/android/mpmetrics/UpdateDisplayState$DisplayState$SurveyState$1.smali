.class final Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Parcel;)Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;
    .locals 3

    .prologue
    .line 114
    new-instance v0, Landroid/os/Bundle;

    const-class v1, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(Ljava/lang/ClassLoader;)V

    .line 115
    invoke-virtual {v0, p1}, Landroid/os/Bundle;->readFromParcel(Landroid/os/Parcel;)V

    .line 116
    new-instance v1, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;

    const/4 v2, 0x0

    invoke-direct {v1, v0, v2}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;-><init>(Landroid/os/Bundle;Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$1;)V

    return-object v1
.end method

.method public a(I)[Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;
    .locals 1

    .prologue
    .line 121
    new-array v0, p1, [Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;

    return-object v0
.end method

.method public synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 111
    invoke-virtual {p0, p1}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState$1;->a(Landroid/os/Parcel;)Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;

    move-result-object v0

    return-object v0
.end method

.method public synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 111
    invoke-virtual {p0, p1}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState$1;->a(I)[Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$SurveyState;

    move-result-object v0

    return-object v0
.end method
