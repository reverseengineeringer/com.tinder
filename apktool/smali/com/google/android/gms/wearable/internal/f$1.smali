.class Lcom/google/android/gms/wearable/internal/f$1;
.super Lcom/google/android/gms/wearable/internal/d;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/wearable/internal/f;->putDataItem(Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/wearable/PutDataRequest;)Lcom/google/android/gms/common/api/PendingResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/wearable/internal/d",
        "<",
        "Lcom/google/android/gms/wearable/DataApi$DataItemResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic axx:Lcom/google/android/gms/wearable/PutDataRequest;

.field final synthetic axy:Lcom/google/android/gms/wearable/internal/f;


# direct methods
.method constructor <init>(Lcom/google/android/gms/wearable/internal/f;Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/wearable/PutDataRequest;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/wearable/internal/f$1;->axy:Lcom/google/android/gms/wearable/internal/f;

    iput-object p3, p0, Lcom/google/android/gms/wearable/internal/f$1;->axx:Lcom/google/android/gms/wearable/PutDataRequest;

    invoke-direct {p0, p2}, Lcom/google/android/gms/wearable/internal/d;-><init>(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic a(Lcom/google/android/gms/common/api/Api$a;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    check-cast p1, Lcom/google/android/gms/wearable/internal/ba;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/wearable/internal/f$1;->a(Lcom/google/android/gms/wearable/internal/ba;)V

    return-void
.end method

.method protected a(Lcom/google/android/gms/wearable/internal/ba;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/f$1;->axx:Lcom/google/android/gms/wearable/PutDataRequest;

    invoke-virtual {p1, p0, v0}, Lcom/google/android/gms/wearable/internal/ba;->a(Lcom/google/android/gms/common/api/BaseImplementation$b;Lcom/google/android/gms/wearable/PutDataRequest;)V

    return-void
.end method

.method public aE(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/wearable/DataApi$DataItemResult;
    .locals 2

    new-instance v0, Lcom/google/android/gms/wearable/internal/f$b;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/google/android/gms/wearable/internal/f$b;-><init>(Lcom/google/android/gms/common/api/Status;Lcom/google/android/gms/wearable/DataItem;)V

    return-object v0
.end method

.method public synthetic c(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Result;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/wearable/internal/f$1;->aE(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/wearable/DataApi$DataItemResult;

    move-result-object v0

    return-object v0
.end method
