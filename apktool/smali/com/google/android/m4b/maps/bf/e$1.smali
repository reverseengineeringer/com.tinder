.class final Lcom/google/android/m4b/maps/bf/e$1;
.super Landroid/os/Handler;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/m4b/maps/bf/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private synthetic a:Lcom/google/android/m4b/maps/bf/e;


# direct methods
.method constructor <init>(Lcom/google/android/m4b/maps/bf/e;)V
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/google/android/m4b/maps/bf/e$1;->a:Lcom/google/android/m4b/maps/bf/e;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 3

    .prologue
    .line 194
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 208
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unknown message id "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p1, Landroid/os/Message;->what:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 196
    :pswitch_0
    iget-object v2, p0, Lcom/google/android/m4b/maps/bf/e$1;->a:Lcom/google/android/m4b/maps/bf/e;

    iget v0, p1, Landroid/os/Message;->arg1:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    move v1, v0

    :goto_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/m4b/maps/bf/q;

    invoke-static {v2, v1, v0}, Lcom/google/android/m4b/maps/bf/e;->a(Lcom/google/android/m4b/maps/bf/e;ZLcom/google/android/m4b/maps/bf/q;)V

    .line 206
    :goto_1
    return-void

    .line 196
    :cond_0
    const/4 v0, 0x0

    move v1, v0

    goto :goto_0

    .line 199
    :pswitch_1
    iget-object v0, p0, Lcom/google/android/m4b/maps/bf/e$1;->a:Lcom/google/android/m4b/maps/bf/e;

    iget v0, p1, Landroid/os/Message;->arg1:I

    goto :goto_1

    .line 202
    :pswitch_2
    iget-object v0, p0, Lcom/google/android/m4b/maps/bf/e$1;->a:Lcom/google/android/m4b/maps/bf/e;

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v0, v1}, Lcom/google/android/m4b/maps/bf/e;->c(I)V

    goto :goto_1

    .line 205
    :pswitch_3
    iget-object v0, p0, Lcom/google/android/m4b/maps/bf/e$1;->a:Lcom/google/android/m4b/maps/bf/e;

    invoke-virtual {v0}, Lcom/google/android/m4b/maps/bf/e;->a()V

    goto :goto_1

    .line 194
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
