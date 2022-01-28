package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.TLObjectUtils
import java.io.InputStream
import java.io.OutputStream

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLObjectVector<T : TLObject> : TLVector<T>() {
    override fun serializeItem(item: T, stream: OutputStream) {
        stream.write(item.serialize())
    }

    @Suppress("UNCHECKED_CAST")
    override fun deserializeItem(stream: InputStream, context: TLContext): T = context.deserializeMessage(stream) as T

    override fun computeSerializedSize(): Int = TLObjectUtils.SIZE_CONSTRUCTOR_ID + TLObjectUtils.SIZE_INT32 + sumOf(TLObject::computeSerializedSize)


    /* override fun serializeItem(item: T, tlSerializer: TLSerializer) {
        tlSerializer.writeTLObject(item)
    }

    override fun deserializeItem(tlDeserializer: TLDeserializer): T = tlDeserializer.readTLObject()

    override fun computeSerializedSize() =
        TLObjectUtils.SIZE_CONSTRUCTOR_ID + TLObjectUtils.SIZE_INT32 + sumOf(TLObject::computeSerializedSize)*/
}