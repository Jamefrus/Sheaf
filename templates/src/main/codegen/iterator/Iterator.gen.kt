@file:Suppress("PackageDirectoryMismatch", "unused")
@file:JvmMultifileClass
@file:JvmName("PrimitiveIteratorUtil")

//define temp=su.jfdev.ekollections
package temp.iterator

//define Short=#PRIM#
//define short=#prim#

import org.eclipse.collections.api.iterator.ShortIterator
import su.jfdev.ekollections.util.Primitives.NULL_Short
import java.util.*
import kotlin.collections.ShortIterator as KtIterator

inline fun ShortIterator.all(crossinline condition: (Short) -> Boolean) = none { !condition(it) }

inline fun ShortIterator.none(crossinline condition: (Short) -> Boolean): Boolean {
    only(condition) {
        return false
    }
    return true
}

inline fun ShortIterator.count(crossinline condition: (Short) -> Boolean): Int {
    var counter = 0
    only(condition) {
        counter++
    }
    return counter
}


inline fun ShortIterator.any(crossinline condition: (Short) -> Boolean): Boolean {
    only(condition) {
        return true
    }
    return false
}

inline fun ShortIterator.`index of last`(crossinline condition: (Short) -> Boolean): Int {
    var last = -1
    indexedOnly(condition) { i, it ->
        last = i
    }
    return last
}


inline fun ShortIterator.`index of first`(crossinline condition: (Short) -> Boolean): Int {
    indexedOnly(condition) { i, it ->
        return i
    }
    return -1
}

inline fun ShortIterator.first(crossinline condition: (Short) -> Boolean) = firstOr(condition) { throw NoSuchElementException() }
inline fun ShortIterator.firstOr(elseReturn: Short, crossinline condition: (Short) -> Boolean) = firstOr(condition) { elseReturn }
inline fun ShortIterator.firstOr(crossinline condition: (Short) -> Boolean, elseDo: () -> Short): Short {
    only(condition) {
        return it
    }
    return elseDo()
}

inline fun ShortIterator.last(crossinline condition: (Short) -> Boolean) = lastOr(condition) { throw NoSuchElementException() }
inline fun ShortIterator.lastOr(elseReturn: Short, crossinline condition: (Short) -> Boolean) = lastOr(condition) { elseReturn }
inline fun ShortIterator.lastOr(crossinline condition: (Short) -> Boolean, elseDo: () -> Short): Short {
    var existCandidate: Boolean = false
    var candidate: Short = NULL_Short
    only(condition) {
        existCandidate = true
        candidate = it
    }
    if (existCandidate) return candidate
    else return elseDo()
}


inline fun ShortIterator.single(crossinline condition: (Short) -> Boolean) = singleOr(condition) { error("Iterator contains 0 or 2+ elements") }
inline fun ShortIterator.singleOr(elseReturn: Short, crossinline condition: (Short) -> Boolean) = singleOr(condition) { elseReturn }
inline fun ShortIterator.singleOr(crossinline condition: (Short) -> Boolean, elseDo: () -> Short): Short {
    var existCandidate: Boolean = false
    var candidate: Short = NULL_Short
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

inline fun ShortIterator.indexedOnly(crossinline condition: (Short) -> Boolean, procedure: (Int, Short) -> Unit) {
    indexedIterate { i, it ->
        if (condition(it)) procedure(i, it)
    }
}

inline fun ShortIterator.only(crossinline condition: (Short) -> Boolean, procedure: (Short) -> Unit) {
    iterate {
        if (condition(it)) procedure(it)
    }
}

inline infix fun ShortIterator.indexedIterate(procedure: (Int, Short) -> Unit) {
    var index = 0
    while (hasNext()) procedure(index++, next())
}

inline infix fun ShortIterator.iterate(procedure: (Short) -> Unit) {
    while (hasNext()) procedure(next())
}

operator fun ShortIterator.iterator(): KtIterator = object: KtIterator() {
    override fun nextShort() = this@iterator.next()
    override fun hasNext(): Boolean = this@iterator.hasNext()
}