package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * auth.sentCodeTypeFlashCall#ab03c6d9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSentCodeTypeFlashCall() : TLAbsSentCodeType() {
    var pattern: String = ""

    private val _constructor: String = "auth.sentCodeTypeFlashCall#ab03c6d9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(pattern: String) : this() {
        this.pattern = pattern
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(pattern)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        pattern = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(pattern)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSentCodeTypeFlashCall) return false
        if (other === this) return true

        return pattern == other.pattern
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xab03c6d9.toInt()
    }
}