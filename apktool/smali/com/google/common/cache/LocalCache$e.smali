.class final Lcom/google/common/cache/LocalCache$e;
.super Lcom/google/common/cache/LocalCache$a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/common/cache/LocalCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "e"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/common/cache/LocalCache",
        "<TK;TV;>.a<",
        "Ljava/util/Map$Entry",
        "<TK;TV;>;>;"
    }
.end annotation


# instance fields
.field final synthetic c:Lcom/google/common/cache/LocalCache;


# direct methods
.method constructor <init>(Lcom/google/common/cache/LocalCache;Ljava/util/concurrent/ConcurrentMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/ConcurrentMap",
            "<**>;)V"
        }
    .end annotation

    .prologue
    .line 4432
    iput-object p1, p0, Lcom/google/common/cache/LocalCache$e;->c:Lcom/google/common/cache/LocalCache;

    .line 4433
    invoke-direct {p0, p1, p2}, Lcom/google/common/cache/LocalCache$a;-><init>(Lcom/google/common/cache/LocalCache;Ljava/util/concurrent/ConcurrentMap;)V

    .line 4434
    return-void
.end method


# virtual methods
.method public contains(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 4443
    instance-of v1, p1, Ljava/util/Map$Entry;

    if-nez v1, :cond_1

    .line 4453
    :cond_0
    :goto_0
    return v0

    .line 4446
    :cond_1
    check-cast p1, Ljava/util/Map$Entry;

    .line 4447
    invoke-interface {p1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    .line 4448
    if-eqz v1, :cond_0

    .line 4451
    iget-object v2, p0, Lcom/google/common/cache/LocalCache$e;->c:Lcom/google/common/cache/LocalCache;

    invoke-virtual {v2, v1}, Lcom/google/common/cache/LocalCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 4453
    if-eqz v1, :cond_0

    iget-object v2, p0, Lcom/google/common/cache/LocalCache$e;->c:Lcom/google/common/cache/LocalCache;

    iget-object v2, v2, Lcom/google/common/cache/LocalCache;->h:Lcom/google/common/base/Equivalence;

    invoke-interface {p1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3, v1}, Lcom/google/common/base/Equivalence;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;>;"
        }
    .end annotation

    .prologue
    .line 4438
    new-instance v0, Lcom/google/common/cache/LocalCache$d;

    iget-object v1, p0, Lcom/google/common/cache/LocalCache$e;->c:Lcom/google/common/cache/LocalCache;

    invoke-direct {v0, v1}, Lcom/google/common/cache/LocalCache$d;-><init>(Lcom/google/common/cache/LocalCache;)V

    return-object v0
.end method

.method public remove(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 4458
    instance-of v1, p1, Ljava/util/Map$Entry;

    if-nez v1, :cond_1

    .line 4463
    :cond_0
    :goto_0
    return v0

    .line 4461
    :cond_1
    check-cast p1, Ljava/util/Map$Entry;

    .line 4462
    invoke-interface {p1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    .line 4463
    if-eqz v1, :cond_0

    iget-object v2, p0, Lcom/google/common/cache/LocalCache$e;->c:Lcom/google/common/cache/LocalCache;

    invoke-interface {p1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Lcom/google/common/cache/LocalCache;->remove(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method
