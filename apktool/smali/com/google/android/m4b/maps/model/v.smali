.class public Lcom/google/android/m4b/maps/model/v;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    return-void
.end method

.method static a(Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;Landroid/os/Parcel;)V
    .locals 3

    .prologue
    .line 95
    invoke-static {p1}, Lcom/google/android/m4b/maps/f/b;->a(Landroid/os/Parcel;)I

    move-result v0

    .line 98
    const/4 v1, 0x1

    .line 100
    invoke-virtual {p0}, Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;->a()I

    move-result v2

    .line 98
    invoke-static {p1, v1, v2}, Lcom/google/android/m4b/maps/f/b;->a(Landroid/os/Parcel;II)V

    .line 105
    const/4 v1, 0x2

    iget v2, p0, Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;->a:F

    invoke-static {p1, v1, v2}, Lcom/google/android/m4b/maps/f/b;->a(Landroid/os/Parcel;IF)V

    .line 112
    const/4 v1, 0x3

    iget v2, p0, Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;->b:F

    invoke-static {p1, v1, v2}, Lcom/google/android/m4b/maps/f/b;->a(Landroid/os/Parcel;IF)V

    .line 119
    const/4 v1, 0x4

    iget v2, p0, Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;->c:F

    invoke-static {p1, v1, v2}, Lcom/google/android/m4b/maps/f/b;->a(Landroid/os/Parcel;IF)V

    .line 127
    invoke-static {p1, v0}, Lcom/google/android/m4b/maps/f/b;->a(Landroid/os/Parcel;I)V

    .line 128
    return-void
.end method


# virtual methods
.method public a(Landroid/os/Parcel;)Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;
    .locals 7

    .prologue
    const/4 v0, 0x0

    .line 17
    invoke-static {p1}, Lcom/google/android/m4b/maps/f/a;->a(Landroid/os/Parcel;)I

    move-result v4

    .line 20
    const/4 v1, 0x0

    move v2, v0

    move v3, v1

    move v1, v0

    .line 29
    :goto_0
    invoke-virtual {p1}, Landroid/os/Parcel;->dataPosition()I

    move-result v5

    if-ge v5, v4, :cond_0

    .line 30
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 31
    const v6, 0xffff

    and-int/2addr v6, v5

    packed-switch v6, :pswitch_data_0

    .line 74
    invoke-static {p1, v5}, Lcom/google/android/m4b/maps/f/a;->b(Landroid/os/Parcel;I)V

    goto :goto_0

    .line 36
    :pswitch_0
    invoke-static {p1, v5}, Lcom/google/android/m4b/maps/f/a;->f(Landroid/os/Parcel;I)I

    move-result v3

    goto :goto_0

    .line 46
    :pswitch_1
    invoke-static {p1, v5}, Lcom/google/android/m4b/maps/f/a;->i(Landroid/os/Parcel;I)F

    move-result v2

    goto :goto_0

    .line 56
    :pswitch_2
    invoke-static {p1, v5}, Lcom/google/android/m4b/maps/f/a;->i(Landroid/os/Parcel;I)F

    move-result v1

    goto :goto_0

    .line 66
    :pswitch_3
    invoke-static {p1, v5}, Lcom/google/android/m4b/maps/f/a;->i(Landroid/os/Parcel;I)F

    move-result v0

    goto :goto_0

    .line 79
    :cond_0
    invoke-virtual {p1}, Landroid/os/Parcel;->dataPosition()I

    move-result v5

    if-eq v5, v4, :cond_1

    .line 80
    new-instance v0, Lcom/google/android/m4b/maps/f/a$a;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Overread allowed size end="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcom/google/android/m4b/maps/f/a$a;-><init>(Ljava/lang/String;Landroid/os/Parcel;)V

    throw v0

    .line 83
    :cond_1
    new-instance v4, Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;

    invoke-direct {v4, v3, v2, v1, v0}, Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;-><init>(IFFF)V

    .line 87
    return-object v4

    .line 31
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public a(I)[Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;
    .locals 1

    .prologue
    .line 91
    new-array v0, p1, [Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;

    return-object v0
.end method

.method public synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 10
    invoke-virtual {p0, p1}, Lcom/google/android/m4b/maps/model/v;->a(Landroid/os/Parcel;)Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;

    move-result-object v0

    return-object v0
.end method

.method public synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 10
    invoke-virtual {p0, p1}, Lcom/google/android/m4b/maps/model/v;->a(I)[Lcom/google/android/m4b/maps/model/StreetViewPanoramaCamera;

    move-result-object v0

    return-object v0
.end method