@file:Suppress("PackageDirectoryMismatch", "unused", "NOTHING_TO_INLINE")
@file:JvmMultifileClass
@file:JvmName("PrimitiveIterableUtil")

//define temp=su.jfdev.ekollections
package su.jfdev.ekollections.iterable

//define Short=#PRIM#
//define short=#prim#

import org.eclipse.collections.api.*
import su.jfdev.ekollections.iterator.*

inline operator fun DoubleIterable.iterator() = doubleIterator().iterator()
inline operator fun DoubleIterable.contains(other: Double): Boolean = contains(other)
inline operator fun DoubleIterable.contains(other: DoubleIterable): Boolean = containsAll(other)

inline infix fun DoubleIterable.iterate(procedure: (Double) -> Unit) = doubleIterator().iterate(procedure)

inline infix fun DoubleIterable.all(crossinline condition: (Double) -> Boolean) = doubleIterator().all(condition)
inline infix fun DoubleIterable.none(crossinline condition: (Double) -> Boolean) = doubleIterator().none(condition)
inline infix fun DoubleIterable.count(crossinline condition: (Double) -> Boolean) = doubleIterator().count(condition)
inline infix fun DoubleIterable.any(crossinline condition: (Double) -> Boolean) = doubleIterator().any(condition)

inline infix fun DoubleIterable.`index of last`(crossinline condition: (Double) -> Boolean)  = doubleIterator().`index of last`(condition)
inline infix fun DoubleIterable.`index of first`(crossinline condition: (Double) -> Boolean)  = doubleIterator().`index of first`(condition)

inline infix fun DoubleIterable.first(crossinline condition: (Double) -> Boolean)  = doubleIterator().first(condition)
inline fun DoubleIterable.firstOr(elseReturn: Double, crossinline condition: (Double) -> Boolean) = doubleIterator().firstOr(elseReturn, condition)

inline infix fun DoubleIterable.last(crossinline condition: (Double) -> Boolean)  = doubleIterator().last(condition)
inline fun DoubleIterable.lastOr(elseReturn: Double, crossinline condition: (Double) -> Boolean) = doubleIterator().lastOr(elseReturn, condition)

inline infix fun DoubleIterable.single(crossinline condition: (Double) -> Boolean)  = doubleIterator().single(condition)
inline fun DoubleIterable.singleOr(elseReturn: Double, crossinline condition: (Double) -> Boolean) = doubleIterator().singleOr(elseReturn, condition)
