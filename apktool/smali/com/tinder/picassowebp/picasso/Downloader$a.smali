.class public Lcom/tinder/picassowebp/picasso/Downloader$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tinder/picassowebp/picasso/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field final a:Ljava/io/InputStream;

.field final b:Landroid/graphics/Bitmap;

.field final c:Z

.field final d:J


# direct methods
.method public constructor <init>(Ljava/io/InputStream;ZJ)V
    .locals 3

    .prologue
    .line 115
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 116
    if-nez p1, :cond_0

    .line 118
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Stream may not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 120
    :cond_0
    iput-object p1, p0, Lcom/tinder/picassowebp/picasso/Downloader$a;->a:Ljava/io/InputStream;

    .line 121
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/tinder/picassowebp/picasso/Downloader$a;->b:Landroid/graphics/Bitmap;

    .line 122
    iput-boolean p2, p0, Lcom/tinder/picassowebp/picasso/Downloader$a;->c:Z

    .line 123
    iput-wide p3, p0, Lcom/tinder/picassowebp/picasso/Downloader$a;->d:J

    .line 124
    return-void
.end method


# virtual methods
.method public a()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/tinder/picassowebp/picasso/Downloader$a;->a:Ljava/io/InputStream;

    return-object v0
.end method

.method public b()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/tinder/picassowebp/picasso/Downloader$a;->b:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public c()J
    .locals 2

    .prologue
    .line 149
    iget-wide v0, p0, Lcom/tinder/picassowebp/picasso/Downloader$a;->d:J

    return-wide v0
.end method
