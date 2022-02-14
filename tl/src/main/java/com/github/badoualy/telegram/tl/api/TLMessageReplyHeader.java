package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

public class TLMessageReplyHeader extends TLObject {

    protected int replyToMsgId;
    protected TLAbsPeer replyToPeerId;
    protected Integer replyToTopId;

    protected int flags;

    private final String _constructor = "messageReplyHeader#a6d57763";

    public static final int CONSTRUCTOR_ID = 0xa6d57763;

    public TLMessageReplyHeader(int replyToMsgId, TLAbsPeer replyToPeerId, int replyToTopId) {
        this.replyToMsgId = replyToMsgId;
        this.replyToPeerId = replyToPeerId;
        this.replyToTopId = replyToTopId;
    }

    private void computeFlags() {
        flags = 0;
        flags = replyToPeerId != null ? (flags | 1) : (flags & ~1);
        flags = replyToTopId != null ? (flags | 2) : (flags & ~2);
    }


    @Override
    public int getConstructorId() { return CONSTRUCTOR_ID; }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(replyToMsgId, stream);
        writeTLObject(replyToPeerId, stream);
        writeInt(replyToTopId, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        replyToMsgId = readInt(stream);
        replyToPeerId = readTLObject(stream, context, TLAbsPeer.class, -1);
        replyToTopId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            size += replyToPeerId.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            size += SIZE_INT32;
        }

        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TLMessageReplyHeader that = (TLMessageReplyHeader) o;
        return replyToMsgId ==
                that.replyToMsgId &&
                flags == that.flags &&
                Objects.equals(replyToPeerId, that.replyToPeerId) &&
                Objects.equals(replyToTopId, that.replyToTopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyToMsgId, replyToPeerId, replyToTopId, flags);
    }
}
