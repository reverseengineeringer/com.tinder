.class Lcom/facebook/stetho/websocket/Frame;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final OPCODE_BINARY_FRAME:B = 0x2t

.field public static final OPCODE_CONNECTION_CLOSE:B = 0x8t

.field public static final OPCODE_CONNECTION_PING:B = 0x9t

.field public static final OPCODE_CONNECTION_PONG:B = 0xat

.field public static final OPCODE_TEXT_FRAME:B = 0x1t


# instance fields
.field public fin:Z

.field public hasMask:Z

.field public maskingKey:[B

.field public opcode:B

.field public payloadData:[B

.field public payloadLen:J

.field public rsv1:Z

.field public rsv2:Z

.field public rsv3:Z


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private decodeFirstByte(B)V
    .locals 3

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 57
    and-int/lit16 v0, p1, 0x80

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcom/facebook/stetho/websocket/Frame;->fin:Z

    .line 58
    and-int/lit8 v0, p1, 0x40

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/facebook/stetho/websocket/Frame;->rsv1:Z

    .line 59
    and-int/lit8 v0, p1, 0x20

    if-eqz v0, :cond_2

    move v0, v1

    :goto_2
    iput-boolean v0, p0, Lcom/facebook/stetho/websocket/Frame;->rsv2:Z

    .line 60
    and-int/lit8 v0, p1, 0x10

    if-eqz v0, :cond_3

    :goto_3
    iput-boolean v1, p0, Lcom/facebook/stetho/websocket/Frame;->rsv3:Z

    .line 61
    and-int/lit8 v0, p1, 0xf

    int-to-byte v0, v0

    iput-byte v0, p0, Lcom/facebook/stetho/websocket/Frame;->opcode:B

    .line 62
    return-void

    :cond_0
    move v0, v2

    .line 57
    goto :goto_0

    :cond_1
    move v0, v2

    .line 58
    goto :goto_1

    :cond_2
    move v0, v2

    .line 59
    goto :goto_2

    :cond_3
    move v1, v2

    .line 60
    goto :goto_3
.end method

.method private decodeLength(BLjava/io/InputStream;)J
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v6, 0x8

    .line 83
    const/16 v0, 0x7d

    if-gt p1, v0, :cond_1

    .line 84
    int-to-long v0, p1

    .line 93
    :cond_0
    :goto_0
    return-wide v0

    .line 85
    :cond_1
    const/16 v0, 0x7e

    if-ne p1, v0, :cond_2

    .line 86
    invoke-static {p2}, Lcom/facebook/stetho/websocket/Frame;->readByteOrThrow(Ljava/io/InputStream;)B

    move-result v0

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v0, v0, 0x8

    invoke-static {p2}, Lcom/facebook/stetho/websocket/Frame;->readByteOrThrow(Ljava/io/InputStream;)B

    move-result v1

    and-int/lit16 v1, v1, 0xff

    or-int/2addr v0, v1

    int-to-long v0, v0

    goto :goto_0

    .line 87
    :cond_2
    const/16 v0, 0x7f

    if-ne p1, v0, :cond_3

    .line 88
    const-wide/16 v2, 0x0

    .line 89
    const/4 v0, 0x0

    move v7, v0

    move-wide v0, v2

    move v2, v7

    :goto_1
    if-ge v2, v6, :cond_0

    .line 90
    invoke-static {p2}, Lcom/facebook/stetho/websocket/Frame;->readByteOrThrow(Ljava/io/InputStream;)B

    move-result v3

    and-int/lit16 v3, v3, 0xff

    int-to-long v4, v3

    or-long/2addr v0, v4

    .line 91
    shl-long v4, v0, v6

    .line 89
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    move-wide v0, v4

    goto :goto_1

    .line 95
    :cond_3
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected length byte: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static decodeMaskingKey(Ljava/io/InputStream;)[B
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 124
    const/4 v0, 0x4

    new-array v0, v0, [B

    .line 125
    const/4 v1, 0x0

    array-length v2, v0

    invoke-static {p0, v0, v1, v2}, Lcom/facebook/stetho/websocket/Frame;->readBytesOrThrow(Ljava/io/InputStream;[BII)V

    .line 126
    return-object v0
.end method

.method private encodeFirstByte()B
    .locals 2

    .prologue
    .line 65
    const/4 v0, 0x0

    .line 66
    iget-boolean v1, p0, Lcom/facebook/stetho/websocket/Frame;->fin:Z

    if-eqz v1, :cond_0

    .line 67
    const/16 v0, 0x80

    int-to-byte v0, v0

    .line 69
    :cond_0
    iget-boolean v1, p0, Lcom/facebook/stetho/websocket/Frame;->rsv1:Z

    if-eqz v1, :cond_1

    .line 70
    or-int/lit8 v0, v0, 0x40

    int-to-byte v0, v0

    .line 72
    :cond_1
    iget-boolean v1, p0, Lcom/facebook/stetho/websocket/Frame;->rsv2:Z

    if-eqz v1, :cond_2

    .line 73
    or-int/lit8 v0, v0, 0x20

    int-to-byte v0, v0

    .line 75
    :cond_2
    iget-boolean v1, p0, Lcom/facebook/stetho/websocket/Frame;->rsv3:Z

    if-eqz v1, :cond_3

    .line 76
    or-int/lit8 v0, v0, 0x10

    int-to-byte v0, v0

    .line 78
    :cond_3
    iget-byte v1, p0, Lcom/facebook/stetho/websocket/Frame;->opcode:B

    and-int/lit8 v1, v1, 0xf

    or-int/2addr v0, v1

    int-to-byte v0, v0

    .line 79
    return v0
.end method

.method private static encodeLength(J)[B
    .locals 10

    .prologue
    const/4 v8, 0x2

    const/16 v7, 0x8

    const/4 v6, 0x1

    const/4 v2, 0x0

    const-wide/16 v4, 0xff

    .line 100
    const-wide/16 v0, 0x7d

    cmp-long v0, p0, v0

    if-gtz v0, :cond_0

    .line 101
    new-array v0, v6, [B

    long-to-int v1, p0

    int-to-byte v1, v1

    aput-byte v1, v0, v2

    .line 109
    :goto_0
    return-object v0

    .line 102
    :cond_0
    const-wide/32 v0, 0xffff

    cmp-long v0, p0, v0

    if-gtz v0, :cond_1

    .line 103
    const/4 v0, 0x3

    new-array v0, v0, [B

    const/16 v1, 0x7e

    aput-byte v1, v0, v2

    shr-long v2, p0, v7

    and-long/2addr v2, v4

    long-to-int v1, v2

    int-to-byte v1, v1

    aput-byte v1, v0, v6

    and-long v2, p0, v4

    long-to-int v1, v2

    int-to-byte v1, v1

    aput-byte v1, v0, v8

    goto :goto_0

    .line 109
    :cond_1
    const/16 v0, 0x9

    new-array v0, v0, [B

    const/16 v1, 0x7f

    aput-byte v1, v0, v2

    const/16 v1, 0x38

    shr-long v2, p0, v1

    and-long/2addr v2, v4

    long-to-int v1, v2

    int-to-byte v1, v1

    aput-byte v1, v0, v6

    const/16 v1, 0x30

    shr-long v2, p0, v1

    and-long/2addr v2, v4

    long-to-int v1, v2

    int-to-byte v1, v1

    aput-byte v1, v0, v8

    const/4 v1, 0x3

    const/16 v2, 0x28

    shr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    const/4 v1, 0x4

    const/16 v2, 0x20

    shr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    const/4 v1, 0x5

    const/16 v2, 0x18

    shr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    const/4 v1, 0x6

    const/16 v2, 0x10

    shr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    const/4 v1, 0x7

    shr-long v2, p0, v7

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    and-long v2, p0, v4

    long-to-int v1, v2

    int-to-byte v1, v1

    aput-byte v1, v0, v7

    goto :goto_0
.end method

.method private static readByteOrThrow(Ljava/io/InputStream;)B
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 142
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v0

    .line 143
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 144
    new-instance v0, Ljava/io/EOFException;

    invoke-direct {v0}, Ljava/io/EOFException;-><init>()V

    throw v0

    .line 146
    :cond_0
    int-to-byte v0, v0

    return v0
.end method

.method private static readBytesOrThrow(Ljava/io/InputStream;[BII)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 131
    :goto_0
    if-lez p3, :cond_1

    .line 132
    invoke-virtual {p0, p1, p2, p3}, Ljava/io/InputStream;->read([BII)I

    move-result v0

    .line 133
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 134
    new-instance v0, Ljava/io/EOFException;

    invoke-direct {v0}, Ljava/io/EOFException;-><init>()V

    throw v0

    .line 136
    :cond_0
    sub-int/2addr p3, v0

    .line 137
    add-int/2addr p2, v0

    .line 138
    goto :goto_0

    .line 139
    :cond_1
    return-void
.end method


# virtual methods
.method public readFrom(Ljava/io/BufferedInputStream;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 32
    invoke-static {p1}, Lcom/facebook/stetho/websocket/Frame;->readByteOrThrow(Ljava/io/InputStream;)B

    move-result v0

    invoke-direct {p0, v0}, Lcom/facebook/stetho/websocket/Frame;->decodeFirstByte(B)V

    .line 33
    invoke-static {p1}, Lcom/facebook/stetho/websocket/Frame;->readByteOrThrow(Ljava/io/InputStream;)B

    move-result v2

    .line 34
    and-int/lit16 v0, v2, 0x80

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/facebook/stetho/websocket/Frame;->hasMask:Z

    .line 35
    and-int/lit16 v0, v2, -0x81

    int-to-byte v0, v0

    invoke-direct {p0, v0, p1}, Lcom/facebook/stetho/websocket/Frame;->decodeLength(BLjava/io/InputStream;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/facebook/stetho/websocket/Frame;->payloadLen:J

    .line 36
    iget-boolean v0, p0, Lcom/facebook/stetho/websocket/Frame;->hasMask:Z

    if-eqz v0, :cond_1

    invoke-static {p1}, Lcom/facebook/stetho/websocket/Frame;->decodeMaskingKey(Ljava/io/InputStream;)[B

    move-result-object v0

    :goto_1
    iput-object v0, p0, Lcom/facebook/stetho/websocket/Frame;->maskingKey:[B

    .line 37
    iget-wide v2, p0, Lcom/facebook/stetho/websocket/Frame;->payloadLen:J

    long-to-int v0, v2

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/facebook/stetho/websocket/Frame;->payloadData:[B

    .line 38
    iget-object v0, p0, Lcom/facebook/stetho/websocket/Frame;->payloadData:[B

    iget-wide v2, p0, Lcom/facebook/stetho/websocket/Frame;->payloadLen:J

    long-to-int v2, v2

    invoke-static {p1, v0, v1, v2}, Lcom/facebook/stetho/websocket/Frame;->readBytesOrThrow(Ljava/io/InputStream;[BII)V

    .line 39
    iget-object v0, p0, Lcom/facebook/stetho/websocket/Frame;->maskingKey:[B

    iget-object v2, p0, Lcom/facebook/stetho/websocket/Frame;->payloadData:[B

    iget-wide v4, p0, Lcom/facebook/stetho/websocket/Frame;->payloadLen:J

    long-to-int v3, v4

    invoke-static {v0, v2, v1, v3}, Lcom/facebook/stetho/websocket/MaskingHelper;->unmask([B[BII)V

    .line 40
    return-void

    :cond_0
    move v0, v1

    .line 34
    goto :goto_0

    .line 36
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public writeTo(Ljava/io/BufferedOutputStream;)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 43
    invoke-direct {p0}, Lcom/facebook/stetho/websocket/Frame;->encodeFirstByte()B

    move-result v0

    invoke-virtual {p1, v0}, Ljava/io/BufferedOutputStream;->write(I)V

    .line 44
    iget-wide v0, p0, Lcom/facebook/stetho/websocket/Frame;->payloadLen:J

    invoke-static {v0, v1}, Lcom/facebook/stetho/websocket/Frame;->encodeLength(J)[B

    move-result-object v0

    .line 45
    iget-boolean v1, p0, Lcom/facebook/stetho/websocket/Frame;->hasMask:Z

    if-eqz v1, :cond_0

    .line 46
    aget-byte v1, v0, v4

    or-int/lit16 v1, v1, 0x80

    int-to-byte v1, v1

    aput-byte v1, v0, v4

    .line 48
    :cond_0
    array-length v1, v0

    invoke-virtual {p1, v0, v4, v1}, Ljava/io/BufferedOutputStream;->write([BII)V

    .line 50
    iget-boolean v0, p0, Lcom/facebook/stetho/websocket/Frame;->hasMask:Z

    if-eqz v0, :cond_1

    .line 51
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Writing masked data not implemented"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 53
    :cond_1
    iget-object v0, p0, Lcom/facebook/stetho/websocket/Frame;->payloadData:[B

    iget-wide v2, p0, Lcom/facebook/stetho/websocket/Frame;->payloadLen:J

    long-to-int v1, v2

    invoke-virtual {p1, v0, v4, v1}, Ljava/io/BufferedOutputStream;->write([BII)V

    .line 54
    return-void
.end method
