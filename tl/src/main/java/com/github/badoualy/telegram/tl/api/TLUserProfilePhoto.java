package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserProfilePhoto extends TLAbsUserProfilePhoto {

    public static final int CONSTRUCTOR_ID = 0x82d1f706;

    protected int flags;

    protected boolean hasVideo = false;

    protected long photoId;

    protected TLBytes strippedThumb;

    protected int dcId = 0;

    private final String _constructor = "userProfilePhoto#82d1f706";

    public TLUserProfilePhoto() {
    }

    public TLUserProfilePhoto(boolean hasVideo, long photoId, TLBytes strippedThumb, int dcId) {
        this.hasVideo = hasVideo;
        this.photoId = photoId;
        this.strippedThumb = strippedThumb;
        this.dcId = dcId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(photoId, stream);
        writeTLBytes(strippedThumb, stream);
        writeInt(dcId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hasVideo = (flags & 1) != 0;
        photoId = readLong(stream);
        strippedThumb = (flags & 2) != 0 ? readTLBytes(stream, context) : null;
        dcId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_BOOLEAN;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(strippedThumb);
        size += SIZE_INT32;
        return size;
    }

    private void computeFlags() {
        flags = 0;
        flags = hasVideo ? (flags | 1) : (flags & ~1);
        flags = strippedThumb == null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public boolean isHasVideo() { return hasVideo; }

    public void setHasVideo(boolean hasVideo) { this.hasVideo = hasVideo; }

    public TLBytes getStrippedThumb() { return strippedThumb; }

    public void setStrippedThumb(TLBytes strippedThumb) { this.strippedThumb = strippedThumb; }

    public int getDcId() { return dcId; }

    public void setDcId(int dcId) { this.dcId = dcId; }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLUserProfilePhoto getAsUserProfilePhoto() {
        return this;
    }
}
