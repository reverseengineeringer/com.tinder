.class final enum Lcom/google/common/cache/CacheBuilder$OneWeigher;
.super Ljava/lang/Enum;
.source "SourceFile"

# interfaces
.implements Lcom/google/common/cache/i;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/common/cache/CacheBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "OneWeigher"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/common/cache/CacheBuilder$OneWeigher;",
        ">;",
        "Lcom/google/common/cache/i",
        "<",
        "Ljava/lang/Object;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/google/common/cache/CacheBuilder$OneWeigher;

.field private static final synthetic b:[Lcom/google/common/cache/CacheBuilder$OneWeigher;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 192
    new-instance v0, Lcom/google/common/cache/CacheBuilder$OneWeigher;

    const-string v1, "INSTANCE"

    invoke-direct {v0, v1, v2}, Lcom/google/common/cache/CacheBuilder$OneWeigher;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/common/cache/CacheBuilder$OneWeigher;->a:Lcom/google/common/cache/CacheBuilder$OneWeigher;

    .line 191
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/google/common/cache/CacheBuilder$OneWeigher;

    sget-object v1, Lcom/google/common/cache/CacheBuilder$OneWeigher;->a:Lcom/google/common/cache/CacheBuilder$OneWeigher;

    aput-object v1, v0, v2

    sput-object v0, Lcom/google/common/cache/CacheBuilder$OneWeigher;->b:[Lcom/google/common/cache/CacheBuilder$OneWeigher;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 191
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/common/cache/CacheBuilder$OneWeigher;
    .locals 1

    .prologue
    .line 191
    const-class v0, Lcom/google/common/cache/CacheBuilder$OneWeigher;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/common/cache/CacheBuilder$OneWeigher;

    return-object v0
.end method

.method public static values()[Lcom/google/common/cache/CacheBuilder$OneWeigher;
    .locals 1

    .prologue
    .line 191
    sget-object v0, Lcom/google/common/cache/CacheBuilder$OneWeigher;->b:[Lcom/google/common/cache/CacheBuilder$OneWeigher;

    invoke-virtual {v0}, [Lcom/google/common/cache/CacheBuilder$OneWeigher;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/common/cache/CacheBuilder$OneWeigher;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 195
    const/4 v0, 0x1

    return v0
.end method