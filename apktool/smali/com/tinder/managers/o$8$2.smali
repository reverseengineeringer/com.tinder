.class Lcom/tinder/managers/o$8$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/tinder/d/w;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tinder/managers/o$8;->a(Lcom/android/volley/VolleyError;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/tinder/managers/o$8;


# direct methods
.method constructor <init>(Lcom/tinder/managers/o$8;)V
    .locals 0

    .prologue
    .line 679
    iput-object p1, p0, Lcom/tinder/managers/o$8$2;->a:Lcom/tinder/managers/o$8;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 699
    const-string v0, "Login retry successful, get recs again"

    invoke-static {v0}, Lcom/tinder/utils/q;->a(Ljava/lang/String;)V

    .line 700
    iget-object v0, p0, Lcom/tinder/managers/o$8$2;->a:Lcom/tinder/managers/o$8;

    iget-object v0, v0, Lcom/tinder/managers/o$8;->a:Lcom/tinder/managers/o;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/tinder/managers/o;->a(Lcom/tinder/managers/o;Z)V

    .line 701
    iget-object v0, p0, Lcom/tinder/managers/o$8$2;->a:Lcom/tinder/managers/o$8;

    iget-object v0, v0, Lcom/tinder/managers/o$8;->a:Lcom/tinder/managers/o;

    invoke-virtual {v0}, Lcom/tinder/managers/o;->f()V

    .line 702
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 683
    const-string v0, "Login retry unsuccessful"

    invoke-static {v0}, Lcom/tinder/utils/q;->a(Ljava/lang/String;)V

    .line 685
    iget-object v0, p0, Lcom/tinder/managers/o$8$2;->a:Lcom/tinder/managers/o$8;

    iget-object v0, v0, Lcom/tinder/managers/o$8;->a:Lcom/tinder/managers/o;

    invoke-virtual {v0}, Lcom/tinder/managers/o;->s()V

    .line 686
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 691
    const-string v0, "Not authentication problem"

    invoke-static {v0}, Lcom/tinder/utils/q;->a(Ljava/lang/String;)V

    .line 692
    iget-object v0, p0, Lcom/tinder/managers/o$8$2;->a:Lcom/tinder/managers/o$8;

    iget-object v0, v0, Lcom/tinder/managers/o$8;->a:Lcom/tinder/managers/o;

    invoke-static {v0, v1}, Lcom/tinder/managers/o;->a(Lcom/tinder/managers/o;Z)V

    .line 693
    iget-object v0, p0, Lcom/tinder/managers/o$8$2;->a:Lcom/tinder/managers/o$8;

    iget-object v0, v0, Lcom/tinder/managers/o$8;->a:Lcom/tinder/managers/o;

    invoke-virtual {v0, v1}, Lcom/tinder/managers/o;->b(Z)V

    .line 694
    return-void
.end method
