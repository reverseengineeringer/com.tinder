.class Lcom/tinder/fragments/g$12;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tinder/fragments/g;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/tinder/fragments/g;


# direct methods
.method constructor <init>(Lcom/tinder/fragments/g;)V
    .locals 0

    .prologue
    .line 981
    iput-object p1, p0, Lcom/tinder/fragments/g$12;->a:Lcom/tinder/fragments/g;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 985
    iget-object v0, p0, Lcom/tinder/fragments/g$12;->a:Lcom/tinder/fragments/g;

    iget-object v0, v0, Lcom/tinder/fragments/g;->m:Landroid/widget/ScrollView;

    const/16 v1, 0x82

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->fullScroll(I)Z

    .line 986
    return-void
.end method
