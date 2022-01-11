package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLSponsoredMessages extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x2a3c381f;

    protected TLBytes randomId;

    protected TLAbsPeer fromId;

    protected String message;

    protected String startParam;

    protected TLVector<TLAbsMessageEntity> entities;

    private final String _constructor = "sponsoredMessage#2a3c381f ";

    public TLSponsoredMessages() {
    }

    public TLSponsoredMessages(TLBytes randomId, TLAbsPeer fromId, String message, String startParam, TLVector<TLAbsMessageEntity> entities) {
        this.randomId = randomId;
        this.fromId = fromId;
        this.message = message;
        this.startParam = startParam;
        this.entities = entities;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(randomId, stream);
        writeTLObject(fromId, stream);
        writeString(message, stream);
        writeString(startParam, stream);
        writeTLVector(entities, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        randomId = readTLBytes(stream, context);
        fromId = readTLObject(stream, context, TLAbsPeer.class, -1);
        message = readTLString(stream);
        startParam = readTLString(stream);
        entities = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLBytes getRandomId() {
        return randomId;
    }

    public void setRandomId(TLBytes randomId) {
        this.randomId = randomId;
    }

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStartParam() {
        return startParam;
    }

    public void setStartParam(String startParam) {
        this.startParam = startParam;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }
}
