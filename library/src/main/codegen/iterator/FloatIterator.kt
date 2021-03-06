@file:Suppress("PackageDirectoryMismatch", "unused")
@file:JvmMultifileClass
@file:JvmName("PrimitiveIteratorUtil")

//define temp=su.jfdev.ekollections
package su.jfdev.ekollections.iterator

//define Short=#PRIM#
//define short=#prim#

import org.eclipse.collections.api.iterator.FloatIterator
import su.jfdev.ekollections.util.Primitives.NULL_Float
import java.util.*
import kotlin.collections.FloatIterator as KtIterator

inline fun FloatIterator.all(crossinline condition: (Float) -> Boolean) = none { !condition(it) }

inline fun FloatIterator.none(crossinline condition: (Float) -> Boolean): Boolean {
    only(condition) {
        return false
    }
    return true
}

inline fun FloatIterator.count(crossinline condition: (Float) -> Boolean): Int {
    var counter = 0
    only(condition) {
        counter++
    }
    return counter
}


inline fun FloatIterator.any(crossinline condition: (Float) -> Boolean): Boolean {
    only(condition) {
        return true
    }
    return false
}

inline fun FloatIterator.`index of last`(crossinline condition: (Float) -> Boolean): Int {
    var last = -1
    indexedOnly(condition) { i, it ->
        last = i
    }
    return last
}


inline fun FloatIterator.`index of first`(crossinline condition: (Float) -> Boolean): Int {
    indexedOnly(condition) { i, it ->
        return i
    }
    return -1
}

inline fun FloatIterator.first(crossinline condition: (Float) -> Boolean) = firstOr(condition) { throw NoSuchElementException() }
inline fun FloatIterator.firstOr(elseReturn: Float, crossinline condition: (Float) -> Boolean) = firstOr(condition) { elseReturn }
inline fun FloatIterator.firstOr(crossinline condition: (Float) -> Boolean, elseDo: () -> Float): Float {
    only(condition) {
        return it
    }
    return elseDo()
}

inline fun FloatIterator.last(crossinline condition: (Float) -> Boolean) = lastOr(condition) { throw NoSuchElementException() }
inline fun FloatIterator.lastOr(elseReturn: Float, crossinline condition: (Float) -> Boolean) = lastOr(condition) { elseReturn }
inline fun FloatIterator.lastOr(crossinline condition: (Float) -> Boolean, elseDo: () -> Float): Float {
    var existCandidate: Boolean = false
    var candidate: Float = NULL_Float
    only(condition) {
        existCandidate = true
        candidate = it
    }
    if (existCandidate) return candidate
    else return elseDo()
}


inline fun FloatIterator.single(crossinline condition: (Float) -> Boolean) = singleOr(condition) { error("Iterator contains 0 or 2+ elements") }
inline fun FloatIterator.singleOr(elseReturn: Float, crossinline condition: (Float) -> Boolean) = singleOr(condition) { elseReturn }
inline fun FloatIterator.singleOr(crossinline condition: (Float) -> Boolean, elseDo: () -> Float): Float {
    var existCandidate: Boolean = false
    var candidate: Float = NULL_Float
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

inline fun FloatIterator.indexedOnly(crossinline condition: (Float) -> Boolean, procedure: (Int, Float) -> Unit) {
    indexedIterate { i, it ->
        if (condition(it)) procedure(i, it)
    }
}

inline fun FloatIterator.only(crossinline condition: (Float) -> Boolean, procedure: (Float) -> Unit) {
    iterate {
        if (condition(it)) procedure(it)
    }
}

inline infix fun FloatIterator.indexedIterate(procedure: (Int, Float) -> Unit) {
    var index = 0
    while (hasNext()) procedure(index++, next())
}

inline infix fun FloatIterator.iterate(procedure: (Float) -> Unit) {
    while (hasNext()) procedure(next())
}

operator fun FloatIterator.iterator(): KtIterator = object: KtIterator() {
    override fun nextFloat() = this@iterator.next()
    override fun hasNext(): Boolean = this@iterator.hasNext()
}
