package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.TLObjectUtils
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class TLRestrictionReason() : TLObject() {
    var platform: String = ""

    var reason: String = ""

    var text: String = ""

    private val _constructor: String = "restrictionReason#d072acb4"

    override fun getConstructorId() = CONSTRUCTOR_ID

    constructor(
        platform: String,
        reason: String,
        text: String
    ) : this() {
        this.platform = platform
        this.reason = reason
        this.text = text
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        stream.write(platform.toByteArray())
        stream.write(reason.toByteArray())
        stream.write(text.toByteArray())

    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream?, context: TLContext?) {
        platform = stream?.readBytes().toString()
        reason = stream?.readBytes().toString()
        text = stream?.readBytes().toString()
    }

    override fun computeSerializedSize(): Int {
        var size = TLObjectUtils.SIZE_CONSTRUCTOR_ID
        size += TLObjectUtils.computeTLStringSerializedSize(platform)
        size += TLObjectUtils.computeTLStringSerializedSize(reason)
        size += TLObjectUtils.computeTLStringSerializedSize(text)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRestrictionReason) return false
        if (other === this) return true

        return platform == other.platform
                && reason == other.reason
                && text == other.text
    }

    override fun hashCode(): Int {
        var result = platform.hashCode()
        result = 31 * result + reason.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + _constructor.hashCode()
        return result
    }

    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd072acb4.toInt()
    }
}