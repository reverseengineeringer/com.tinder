.class Lcom/tinder/fragments/p$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tinder/fragments/p;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/tinder/fragments/p;


# direct methods
.method constructor <init>(Lcom/tinder/fragments/p;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/tinder/fragments/p$2;->a:Lcom/tinder/fragments/p;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 92
    iget-object v0, p0, Lcom/tinder/fragments/p$2;->a:Lcom/tinder/fragments/p;

    invoke-static {v0}, Lcom/tinder/fragments/p;->a(Lcom/tinder/fragments/p;)Landroid/support/v4/view/ViewPager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 93
    return-void
.end method
