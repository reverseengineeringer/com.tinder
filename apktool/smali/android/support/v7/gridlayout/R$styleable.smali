.class public final Landroid/support/v7/gridlayout/R$styleable;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/gridlayout/R;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "styleable"
.end annotation


# static fields
.field public static final GridLayout:[I

.field public static final GridLayout_Layout:[I

.field public static final GridLayout_Layout_android_layout_height:I = 0x1

.field public static final GridLayout_Layout_android_layout_margin:I = 0x2

.field public static final GridLayout_Layout_android_layout_marginBottom:I = 0x6

.field public static final GridLayout_Layout_android_layout_marginLeft:I = 0x3

.field public static final GridLayout_Layout_android_layout_marginRight:I = 0x5

.field public static final GridLayout_Layout_android_layout_marginTop:I = 0x4

.field public static final GridLayout_Layout_android_layout_width:I = 0x0

.field public static final GridLayout_Layout_layout_column:I = 0x9

.field public static final GridLayout_Layout_layout_columnSpan:I = 0xa

.field public static final GridLayout_Layout_layout_gravity:I = 0xb

.field public static final GridLayout_Layout_layout_row:I = 0x7

.field public static final GridLayout_Layout_layout_rowSpan:I = 0x8

.field public static final GridLayout_alignmentMode:I = 0x4

.field public static final GridLayout_columnCount:I = 0x2

.field public static final GridLayout_columnOrderPreserved:I = 0x6

.field public static final GridLayout_orientation:I = 0x0

.field public static final GridLayout_rowCount:I = 0x1

.field public static final GridLayout_rowOrderPreserved:I = 0x5

.field public static final GridLayout_useDefaultMargins:I = 0x3


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    const/4 v0, 0x7

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Landroid/support/v7/gridlayout/R$styleable;->GridLayout:[I

    .line 49
    const/16 v0, 0xc

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    sput-object v0, Landroid/support/v7/gridlayout/R$styleable;->GridLayout_Layout:[I

    return-void

    .line 48
    :array_0
    .array-data 4
        0x7f010065
        0x7f010066
        0x7f010067
        0x7f010068
        0x7f010069
        0x7f01006a
        0x7f01006b
    .end array-data

    .line 49
    :array_1
    .array-data 4
        0x10100f4
        0x10100f5
        0x10100f6
        0x10100f7
        0x10100f8
        0x10100f9
        0x10100fa
        0x7f01006c
        0x7f01006d
        0x7f01006e
        0x7f01006f
        0x7f010070
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method