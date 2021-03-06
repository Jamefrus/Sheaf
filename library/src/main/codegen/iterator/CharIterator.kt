@file:Suppress("PackageDirectoryMismatch", "unused")
@file:JvmMultifileClass
@file:JvmName("PrimitiveIteratorUtil")

//define temp=su.jfdev.ekollections
package su.jfdev.ekollections.iterator

//define Short=#PRIM#
//define short=#prim#

import org.eclipse.collections.api.iterator.CharIterator
import su.jfdev.ekollections.util.Primitives.NULL_Char
import java.util.*
import kotlin.collections.CharIterator as KtIterator

inline fun CharIterator.all(crossinline condition: (Char) -> Boolean) = none { !condition(it) }

inline fun CharIterator.none(crossinline condition: (Char) -> Boolean): Boolean {
    only(condition) {
        return false
    }
    return true
}

inline fun CharIterator.count(crossinline condition: (Char) -> Boolean): Int {
    var counter = 0
    only(condition) {
        counter++
    }
    return counter
}


inline fun CharIterator.any(crossinline condition: (Char) -> Boolean): Boolean {
    only(condition) {
        return true
    }
    return false
}

inline fun CharIterator.`index of last`(crossinline condition: (Char) -> Boolean): Int {
    var last = -1
    indexedOnly(condition) { i, it ->
        last = i
    }
    return last
}


inline fun CharIterator.`index of first`(crossinline condition: (Char) -> Boolean): Int {
    indexedOnly(condition) { i, it ->
        return i
    }
    return -1
}

inline fun CharIterator.first(crossinline condition: (Char) -> Boolean) = firstOr(condition) { throw NoSuchElementException() }
inline fun CharIterator.firstOr(elseReturn: Char, crossinline condition: (Char) -> Boolean) = firstOr(condition) { elseReturn }
inline fun CharIterator.firstOr(crossinline condition: (Char) -> Boolean, elseDo: () -> Char): Char {
    only(condition) {
        return it
    }
    return elseDo()
}

inline fun CharIterator.last(crossinline condition: (Char) -> Boolean) = lastOr(condition) { throw NoSuchElementException() }
inline fun CharIterator.lastOr(elseReturn: Char, crossinline condition: (Char) -> Boolean) = lastOr(condition) { elseReturn }
inline fun CharIterator.lastOr(crossinline condition: (Char) -> Boolean, elseDo: () -> Char): Char {
    var existCandidate: Boolean = false
    var candidate: Char = NULL_Char
    only(condition) {
        existCandidate = true
        candidate = it
    }
    if (existCandidate) return candidate
    else return elseDo()
}


inline fun CharIterator.single(crossinline condition: (Char) -> Boolean) = singleOr(condition) { error("Iterator contains 0 or 2+ elements") }
inline fun CharIterator.singleOr(elseReturn: Char, crossinline condition: (Char) -> Boolean) = singleOr(condition) { elseReturn }
inline fun CharIterator.singleOr(crossinline condition: (Char) -> Boolean, elseDo: () -> Char): Char {
    var existCandidate: Boolean = false
    var candidate: Char = NULL_Char
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

inline fun CharIterator.indexedOnly(crossinline condition: (Char) -> Boolean, procedure: (Int, Char) -> Unit) {
    indexedIterate { i, it ->
        if (condition(it)) procedure(i, it)
    }
}

inline fun CharIterator.only(crossinline condition: (Char) -> Boolean, procedure: (Char) -> Unit) {
    iterate {
        if (condition(it)) procedure(it)
    }
}

inline infix fun CharIterator.indexedIterate(procedure: (Int, Char) -> Unit) {
    var index = 0
    while (hasNext()) procedure(index++, next())
}

inline infix fun CharIterator.iterate(procedure: (Char) -> Unit) {
    while (hasNext()) procedure(next())
}

operator fun CharIterator.iterator(): KtIterator = object: KtIterator() {
    override fun nextChar() = this@iterator.next()
    override fun hasNext(): Boolean = this@iterator.hasNext()
}
