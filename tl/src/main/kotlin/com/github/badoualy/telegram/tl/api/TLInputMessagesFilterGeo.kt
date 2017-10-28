package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterGeo#e7026d0d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterGeo : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterGeo#e7026d0d"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterGeo) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe7026d0d.toInt()
    }
}