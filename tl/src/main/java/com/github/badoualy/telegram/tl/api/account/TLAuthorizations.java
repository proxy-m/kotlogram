package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAuthorization;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAuthorizations extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x4bff8ea0;

    protected TLVector<TLAuthorization> authorizations;

    protected int authorizationTtlDays;

    private final String _constructor = "account.authorizations#4bff8ea0";

    public TLAuthorizations() {
    }

    public TLAuthorizations(TLVector<TLAuthorization> authorizations, Integer authorizationTtlDays) {
        this.authorizations = authorizations;
        this.authorizationTtlDays = authorizationTtlDays;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(authorizations, stream);
        writeInt(authorizationTtlDays, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        authorizations = readTLVector(stream, context);
        authorizationTtlDays = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += authorizations.computeSerializedSize();
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

    public TLVector<TLAuthorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(TLVector<TLAuthorization> authorizations) {
        this.authorizations = authorizations;
    }

    public int getAuthorizationTtlDays() {
        return authorizationTtlDays;
    }

    public void setAuthorizationTtlDays(int authorizationTtlDays) {
        this.authorizationTtlDays = authorizationTtlDays;
    }
}
