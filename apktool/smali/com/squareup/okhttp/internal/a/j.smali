.class public final Lcom/squareup/okhttp/internal/a/j;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Lcom/squareup/okhttp/Protocol;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    sget-object v0, Lcom/squareup/okhttp/Protocol;->a:Lcom/squareup/okhttp/Protocol;

    if-ne p0, v0, :cond_0

    const-string v0, "HTTP/1.0"

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "HTTP/1.1"

    goto :goto_0
.end method

.method static a(Lcom/squareup/okhttp/n;Ljava/net/Proxy$Type;Lcom/squareup/okhttp/Protocol;)Ljava/lang/String;
    .locals 3

    .prologue
    const/16 v2, 0x20

    .line 19
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 20
    invoke-virtual {p0}, Lcom/squareup/okhttp/n;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 21
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 23
    invoke-static {p0, p1}, Lcom/squareup/okhttp/internal/a/j;->a(Lcom/squareup/okhttp/n;Ljava/net/Proxy$Type;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 24
    invoke-virtual {p0}, Lcom/squareup/okhttp/n;->a()Ljava/net/URL;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 29
    :goto_0
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 30
    invoke-static {p2}, Lcom/squareup/okhttp/internal/a/j;->a(Lcom/squareup/okhttp/Protocol;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 31
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 26
    :cond_0
    invoke-virtual {p0}, Lcom/squareup/okhttp/n;->a()Ljava/net/URL;

    move-result-object v1

    invoke-static {v1}, Lcom/squareup/okhttp/internal/a/j;->a(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method public static a(Ljava/net/URL;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 48
    invoke-virtual {p0}, Ljava/net/URL;->getFile()Ljava/lang/String;

    move-result-object v0

    .line 49
    if-nez v0, :cond_1

    const-string v0, "/"

    .line 51
    :cond_0
    :goto_0
    return-object v0

    .line 50
    :cond_1
    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static a(Lcom/squareup/okhttp/n;Ljava/net/Proxy$Type;)Z
    .locals 1

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/squareup/okhttp/n;->h()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    if-ne p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
