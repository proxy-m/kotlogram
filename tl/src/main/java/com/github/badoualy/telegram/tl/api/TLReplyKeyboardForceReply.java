package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLReplyKeyboardForceReply extends TLAbsReplyMarkup {

    public static final int CONSTRUCTOR_ID = 0x86b40b08;

    protected int flags;

    protected boolean singleUse;

    protected boolean selective;

    protected String placeholder;

    private final String _constructor = "replyKeyboardForceReply#86b40b08";

    public TLReplyKeyboardForceReply() {
    }

    public TLReplyKeyboardForceReply(boolean singleUse, boolean selective, String placeholder) {
        this.singleUse = singleUse;
        this.selective = selective;
        this.placeholder = placeholder;
    }

    /*
    TODO: rework flags compute according to
    https://core.telegram.org/mtproto/TL-combinators#conditional-fields
    */
    private void computeFlags() {
        flags = 0;
        flags = singleUse ? (flags | 1) : (flags & ~1);
        flags = selective ? (flags | 2) : (flags & ~2);
        flags = placeholder != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        singleUse = (flags & 2) != 0;
        selective = (flags & 4) != 0;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getSingleUse() {
        return singleUse;
    }

    public void setSingleUse(boolean singleUse) {
        this.singleUse = singleUse;
    }

    public boolean getSelective() {
        return selective;
    }

    public void setSelective(boolean selective) {
        this.selective = selective;
    }
}
