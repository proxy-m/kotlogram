package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.StreamUtils.readTLObject
import com.github.badoualy.telegram.tl.StreamUtils.writeTLObject
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

/**
 * updatePeerSettings#6a7e7366
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePeerSettings() : TLAbsUpdate() {

    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6a7e7366
    }

    var peer: TLAbsPeer = TLPeerChat()

    var settings: TLPeerSettings = TLPeerSettings()

    private val _constructor: String = "updatePeerSettings#6a7e7366"

    constructor(peer: TLAbsPeer, settings: TLPeerSettings) : this() {
        this.peer = peer
        this.settings = settings
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeTLObject(peer, stream)
        writeTLObject(settings, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream?, context: TLContext?) = with(stream)  {
        peer = readTLObject(stream, context, TLAbsPeer::class.java, -1)
        settings = readTLObject(stream, context, TLPeerSettings::class.java, TLPeerSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun getConstructorId(): Int = CONSTRUCTOR_ID

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePeerSettings) return false
        if (other === this) return true

        return peer == other.peer
                && settings == other.settings
    }

    override fun hashCode(): Int {
        var result = peer.hashCode()
        result = 31 * result + settings.hashCode()
        return result
    }
}
