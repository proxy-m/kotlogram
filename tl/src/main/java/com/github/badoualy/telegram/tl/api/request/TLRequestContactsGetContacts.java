package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestContactsGetContacts extends TLMethod<TLAbsContacts> {
    public static final int CLASS_ID = 0x22c6aa08;

    protected String hash;

    public TLRequestContactsGetContacts() {
    }

    public TLRequestContactsGetContacts(String hash) {
        this.hash = hash;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsContacts deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsContacts)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsContacts) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(hash, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readTLString(stream);
    }

    @Override
    public String toString() {
        return "contacts.getContacts#22c6aa08";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}