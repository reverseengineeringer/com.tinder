.class final Lcom/google/android/m4b/maps/r/b$1;
.super Lcom/google/android/m4b/maps/r/c;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/m4b/maps/r/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/m4b/maps/r/c",
        "<[B>;"
    }
.end annotation


# direct methods
.method constructor <init>(ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 26
    const/16 v0, 0x64

    invoke-direct {p0, v0, p2}, Lcom/google/android/m4b/maps/r/c;-><init>(ILjava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final bridge synthetic a()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 26
    const/16 v0, 0x100a

    new-array v0, v0, [B

    return-object v0
.end method
