.class Lcom/tinder/views/d$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/tinder/d/ae;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tinder/views/d;->setMenu(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/tinder/views/d;


# direct methods
.method constructor <init>(Lcom/tinder/views/d;)V
    .locals 0

    .prologue
    .line 224
    iput-object p1, p0, Lcom/tinder/views/d$5;->a:Lcom/tinder/views/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 1

    .prologue
    .line 228
    const-string v0, "ENTER"

    invoke-static {v0}, Lcom/tinder/utils/q;->a(Ljava/lang/String;)V

    .line 230
    iget-object v0, p0, Lcom/tinder/views/d$5;->a:Lcom/tinder/views/d;

    invoke-static {v0}, Lcom/tinder/views/d;->a(Lcom/tinder/views/d;)Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/tinder/activities/ActivityMain;

    if-eqz v0, :cond_0

    .line 232
    iget-object v0, p0, Lcom/tinder/views/d$5;->a:Lcom/tinder/views/d;

    invoke-static {v0}, Lcom/tinder/views/d;->a(Lcom/tinder/views/d;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/tinder/activities/ActivityMain;

    invoke-virtual {v0}, Lcom/tinder/activities/ActivityMain;->g()V

    .line 234
    :cond_0
    return-void
.end method
