.class final enum Lcom/google/common/collect/MapMakerInternalMap$EntryFactory$5;
.super Lcom/google/common/collect/MapMakerInternalMap$EntryFactory;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/common/collect/MapMakerInternalMap$EntryFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 410
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/google/common/collect/MapMakerInternalMap$EntryFactory;-><init>(Ljava/lang/String;ILcom/google/common/collect/MapMakerInternalMap$1;)V

    return-void
.end method


# virtual methods
.method a(Lcom/google/common/collect/MapMakerInternalMap$Segment;Ljava/lang/Object;ILcom/google/common/collect/MapMakerInternalMap$i;)Lcom/google/common/collect/MapMakerInternalMap$i;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/google/common/collect/MapMakerInternalMap$Segment",
            "<TK;TV;>;TK;I",
            "Lcom/google/common/collect/MapMakerInternalMap$i",
            "<TK;TV;>;)",
            "Lcom/google/common/collect/MapMakerInternalMap$i",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 415
    new-instance v0, Lcom/google/common/collect/MapMakerInternalMap$s;

    iget-object v1, p1, Lcom/google/common/collect/MapMakerInternalMap$Segment;->g:Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v0, v1, p2, p3, p4}, Lcom/google/common/collect/MapMakerInternalMap$s;-><init>(Ljava/lang/ref/ReferenceQueue;Ljava/lang/Object;ILcom/google/common/collect/MapMakerInternalMap$i;)V

    return-object v0
.end method
