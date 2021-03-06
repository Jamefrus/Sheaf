@file:Suppress("PackageDirectoryMismatch", "unused")
@file:JvmMultifileClass
@file:JvmName("PrimitiveIteratorUtil")

//define temp=su.jfdev.ekollections
package su.jfdev.ekollections.iterator

//define Short=#PRIM#
//define short=#prim#

import org.eclipse.collections.api.iterator.ByteIterator
import su.jfdev.ekollections.util.Primitives.NULL_Byte
import java.util.*
import kotlin.collections.ByteIterator as KtIterator

inline fun ByteIterator.all(crossinline condition: (Byte) -> Boolean) = none { !condition(it) }

inline fun ByteIterator.none(crossinline condition: (Byte) -> Boolean): Boolean {
    only(condition) {
        return false
    }
    return true
}

inline fun ByteIterator.count(crossinline condition: (Byte) -> Boolean): Int {
    var counter = 0
    only(condition) {
        counter++
    }
    return counter
}


inline fun ByteIterator.any(crossinline condition: (Byte) -> Boolean): Boolean {
    only(condition) {
        return true
    }
    return false
}

inline fun ByteIterator.`index of last`(crossinline condition: (Byte) -> Boolean): Int {
    var last = -1
    indexedOnly(condition) { i, it ->
        last = i
    }
    return last
}


inline fun ByteIterator.`index of first`(crossinline condition: (Byte) -> Boolean): Int {
    indexedOnly(condition) { i, it ->
        return i
    }
    return -1
}

inline fun ByteIterator.first(crossinline condition: (Byte) -> Boolean) = firstOr(condition) { throw NoSuchElementException() }
inline fun ByteIterator.firstOr(elseReturn: Byte, crossinline condition: (Byte) -> Boolean) = firstOr(condition) { elseReturn }
inline fun ByteIterator.firstOr(crossinline condition: (Byte) -> Boolean, elseDo: () -> Byte): Byte {
    only(condition) {
        return it
    }
    return elseDo()
}

inline fun ByteIterator.last(crossinline condition: (Byte) -> Boolean) = lastOr(condition) { throw NoSuchElementException() }
inline fun ByteIterator.lastOr(elseReturn: Byte, crossinline condition: (Byte) -> Boolean) = lastOr(condition) { elseReturn }
inline fun ByteIterator.lastOr(crossinline condition: (Byte) -> Boolean, elseDo: () -> Byte): Byte {
    var existCandidate: Boolean = false
    var candidate: Byte = NULL_Byte
    only(condition) {
        existCandidate = true
        candidate = it
    }
    if (existCandidate) return candidate
    else return elseDo()
}


inline fun ByteIterator.single(crossinline condition: (Byte) -> Boolean) = singleOr(condition) { error("Iterator contains 0 or 2+ elements") }
inline fun ByteIterator.singleOr(elseReturn: Byte, crossinline condition: (Byte) -> Boolean) = singleOr(condition) { elseReturn }
inline fun ByteIterator.singleOr(crossinline condition: (Byte) -> Boolean, elseDo: () -> Byte): Byte {
    var existCandidate: Boolean = false
    var candidate: Byte = NULL_Byte
    only(condition) {
        if (existCandidate) return elseDo()
        else {
            existCandidate = true
            candidate = it
        }
    }
    if (existCandidate) return candidate
    else return elseDo()
}

inline fun ByteIterator.indexedOnly(crossinline condition: (Byte) -> Boolean, procedure: (Int, Byte) -> Unit) {
    indexedIterate { i, it ->
        if (condition(it)) procedure(i, it)
    }
}

inline fun ByteIterator.only(crossinline condition: (Byte) -> Boolean, procedure: (Byte) -> Unit) {
    iterate {
        if (condition(it)) procedure(it)
    }
}

inline infix fun ByteIterator.indexedIterate(procedure: (Int, Byte) -> Unit) {
    var index = 0
    while (hasNext()) procedure(index++, next())
}

inline infix fun ByteIterator.iterate(procedure: (Byte) -> Unit) {
    while (hasNext()) procedure(next())
}

operator fun ByteIterator.iterator(): KtIterator = object: KtIterator() {
    override fun nextByte() = this@iterator.next()
    override fun hasNext(): Boolean = this@iterator.hasNext()
}
