.class final Lcom/google/android/m4b/maps/bq/bi$11;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/m4b/maps/bq/bh$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/m4b/maps/bq/bi;->a(Lcom/google/android/m4b/maps/model/CameraPosition;)Lcom/google/android/m4b/maps/bv/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private synthetic a:Lcom/google/android/m4b/maps/model/CameraPosition;


# direct methods
.method constructor <init>(Lcom/google/android/m4b/maps/bq/bi;Lcom/google/android/m4b/maps/model/CameraPosition;)V
    .locals 0

    .prologue
    .line 141
    iput-object p2, p0, Lcom/google/android/m4b/maps/bq/bi$11;->a:Lcom/google/android/m4b/maps/model/CameraPosition;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/m4b/maps/bq/bh;ILcom/google/android/m4b/maps/bq/bu;)V
    .locals 1

    .prologue
    .line 144
    sget-object v0, Lcom/google/android/m4b/maps/bq/bu$a;->aA:Lcom/google/android/m4b/maps/bq/bu$a;

    invoke-interface {p3, v0}, Lcom/google/android/m4b/maps/bq/bu;->b(Lcom/google/android/m4b/maps/bq/bu$a;)V

    .line 145
    iget-object v0, p0, Lcom/google/android/m4b/maps/bq/bi$11;->a:Lcom/google/android/m4b/maps/model/CameraPosition;

    invoke-interface {p1, v0, p2}, Lcom/google/android/m4b/maps/bq/bh;->a(Lcom/google/android/m4b/maps/model/CameraPosition;I)V

    .line 146
    return-void
.end method

.method public final toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 150
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/google/android/m4b/maps/bq/bu$a;->aA:Lcom/google/android/m4b/maps/bq/bu$a;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
