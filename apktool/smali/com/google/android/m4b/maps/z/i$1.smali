.class final Lcom/google/android/m4b/maps/z/i$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/m4b/maps/ad/b;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/m4b/maps/z/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private synthetic a:Lcom/google/android/m4b/maps/z/i;


# direct methods
.method constructor <init>(Lcom/google/android/m4b/maps/z/i;)V
    .locals 0

    .prologue
    .line 927
    iput-object p1, p0, Lcom/google/android/m4b/maps/z/i$1;->a:Lcom/google/android/m4b/maps/z/i;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/m4b/maps/m/a$c;ILcom/google/android/m4b/maps/ay/bh;)V
    .locals 1

    .prologue
    .line 931
    const/4 v0, 0x2

    if-eq p2, v0, :cond_0

    .line 933
    if-nez p2, :cond_0

    .line 934
    iget-object v0, p0, Lcom/google/android/m4b/maps/z/i$1;->a:Lcom/google/android/m4b/maps/z/i;

    invoke-static {v0, p3}, Lcom/google/android/m4b/maps/z/i;->a(Lcom/google/android/m4b/maps/z/i;Lcom/google/android/m4b/maps/bq/bs;)V

    .line 936
    :cond_0
    return-void
.end method
