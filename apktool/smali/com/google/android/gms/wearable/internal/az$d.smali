.class final Lcom/google/android/gms/wearable/internal/az$d;
.super Lcom/google/android/gms/wearable/internal/az$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/wearable/internal/az;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "d"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/wearable/internal/az$a",
        "<",
        "Lcom/google/android/gms/wearable/DataApi$DataItemResult;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/google/android/gms/common/api/BaseImplementation$b;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/BaseImplementation$b",
            "<",
            "Lcom/google/android/gms/wearable/DataApi$DataItemResult;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lcom/google/android/gms/wearable/internal/az$a;-><init>(Lcom/google/android/gms/common/api/BaseImplementation$b;)V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/wearable/internal/x;)V
    .locals 3

    new-instance v0, Lcom/google/android/gms/wearable/internal/f$b;

    iget v1, p1, Lcom/google/android/gms/wearable/internal/x;->statusCode:I

    invoke-static {v1}, Lcom/google/android/gms/wearable/internal/av;->gN(I)Lcom/google/android/gms/common/api/Status;

    move-result-object v1

    iget-object v2, p1, Lcom/google/android/gms/wearable/internal/x;->axM:Lcom/google/android/gms/wearable/internal/m;

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/wearable/internal/f$b;-><init>(Lcom/google/android/gms/common/api/Status;Lcom/google/android/gms/wearable/DataItem;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/wearable/internal/az$d;->A(Ljava/lang/Object;)V

    return-void
.end method
