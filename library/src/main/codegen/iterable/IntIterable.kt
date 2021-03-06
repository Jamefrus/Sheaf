@file:Suppress("PackageDirectoryMismatch", "unused", "NOTHING_TO_INLINE")
@file:JvmMultifileClass
@file:JvmName("PrimitiveIterableUtil")

//define temp=su.jfdev.ekollections
package su.jfdev.ekollections.iterable

//define Short=#PRIM#
//define short=#prim#

import org.eclipse.collections.api.*
import su.jfdev.ekollections.iterator.*

inline operator fun IntIterable.iterator() = intIterator().iterator()
inline operator fun IntIterable.contains(other: Int): Boolean = contains(other)
inline operator fun IntIterable.contains(other: IntIterable): Boolean = containsAll(other)

inline infix fun IntIterable.iterate(procedure: (Int) -> Unit) = intIterator().iterate(procedure)

inline infix fun IntIterable.all(crossinline condition: (Int) -> Boolean) = intIterator().all(condition)
inline infix fun IntIterable.none(crossinline condition: (Int) -> Boolean) = intIterator().none(condition)
inline infix fun IntIterable.count(crossinline condition: (Int) -> Boolean) = intIterator().count(condition)
inline infix fun IntIterable.any(crossinline condition: (Int) -> Boolean) = intIterator().any(condition)

inline infix fun IntIterable.`index of last`(crossinline condition: (Int) -> Boolean)  = intIterator().`index of last`(condition)
inline infix fun IntIterable.`index of first`(crossinline condition: (Int) -> Boolean)  = intIterator().`index of first`(condition)

inline infix fun IntIterable.first(crossinline condition: (Int) -> Boolean)  = intIterator().first(condition)
inline fun IntIterable.firstOr(elseReturn: Int, crossinline condition: (Int) -> Boolean) = intIterator().firstOr(elseReturn, condition)

inline infix fun IntIterable.last(crossinline condition: (Int) -> Boolean)  = intIterator().last(condition)
inline fun IntIterable.lastOr(elseReturn: Int, crossinline condition: (Int) -> Boolean) = intIterator().lastOr(elseReturn, condition)

inline infix fun IntIterable.single(crossinline condition: (Int) -> Boolean)  = intIterator().single(condition)
inline fun IntIterable.singleOr(elseReturn: Int, crossinline condition: (Int) -> Boolean) = intIterator().singleOr(elseReturn, condition)
