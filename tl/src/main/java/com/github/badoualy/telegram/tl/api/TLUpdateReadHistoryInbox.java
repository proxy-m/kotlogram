package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateReadHistoryInbox extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x9c974fdf;

    protected int folderId;

    protected TLAbsPeer peer = new TLPeerChat();

    protected int maxId = 0;

    protected int stillUnreadCount = 0;

    protected int pts = 0;

    protected int ptsCount = 0;

    private final String _constructor = "updateReadHistoryInbox#9c974fdf";

    public TLUpdateReadHistoryInbox() {
    }

    public TLUpdateReadHistoryInbox(int folderId, TLAbsPeer peer, int maxId, int stillUnreadCount, int pts, int ptsCount) {
        this.folderId = folderId;
        this.peer = peer;
        this.maxId = maxId;
        this.stillUnreadCount = stillUnreadCount;
        this.pts = pts;
        this.ptsCount = ptsCount;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(folderId, stream);
        writeTLObject(peer, stream);
        writeInt(maxId, stream);
        writeInt(stillUnreadCount, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        folderId = readInt(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        maxId = readInt(stream);
        stillUnreadCount = readInt(stream);
        pts = readInt(stream);
        ptsCount = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public int getFolderId() { return folderId; }

    public void setFolderId(int folderId) { this.folderId = folderId; }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public int getStillUnreadCount() { return stillUnreadCount; }

    public void setStillUnreadCount(int stillUnreadCount) { this.stillUnreadCount = stillUnreadCount; }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int ptsCount) {
        this.ptsCount = ptsCount;
    }
}
