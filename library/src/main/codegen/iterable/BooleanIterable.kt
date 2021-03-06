@file:Suppress("PackageDirectoryMismatch", "unused", "NOTHING_TO_INLINE")
@file:JvmMultifileClass
@file:JvmName("PrimitiveIterableUtil")

//define temp=su.jfdev.ekollections
package su.jfdev.ekollections.iterable

//define Short=#PRIM#
//define short=#prim#

import org.eclipse.collections.api.*
import su.jfdev.ekollections.iterator.*

inline operator fun BooleanIterable.iterator() = booleanIterator().iterator()
inline operator fun BooleanIterable.contains(other: Boolean): Boolean = contains(other)
inline operator fun BooleanIterable.contains(other: BooleanIterable): Boolean = containsAll(other)

inline infix fun BooleanIterable.iterate(procedure: (Boolean) -> Unit) = booleanIterator().iterate(procedure)

inline infix fun BooleanIterable.all(crossinline condition: (Boolean) -> Boolean) = booleanIterator().all(condition)
inline infix fun BooleanIterable.none(crossinline condition: (Boolean) -> Boolean) = booleanIterator().none(condition)
inline infix fun BooleanIterable.count(crossinline condition: (Boolean) -> Boolean) = booleanIterator().count(condition)
inline infix fun BooleanIterable.any(crossinline condition: (Boolean) -> Boolean) = booleanIterator().any(condition)

inline infix fun BooleanIterable.`index of last`(crossinline condition: (Boolean) -> Boolean)  = booleanIterator().`index of last`(condition)
inline infix fun BooleanIterable.`index of first`(crossinline condition: (Boolean) -> Boolean)  = booleanIterator().`index of first`(condition)

inline infix fun BooleanIterable.first(crossinline condition: (Boolean) -> Boolean)  = booleanIterator().first(condition)
inline fun BooleanIterable.firstOr(elseReturn: Boolean, crossinline condition: (Boolean) -> Boolean) = booleanIterator().firstOr(elseReturn, condition)

inline infix fun BooleanIterable.last(crossinline condition: (Boolean) -> Boolean)  = booleanIterator().last(condition)
inline fun BooleanIterable.lastOr(elseReturn: Boolean, crossinline condition: (Boolean) -> Boolean) = booleanIterator().lastOr(elseReturn, condition)

inline infix fun BooleanIterable.single(crossinline condition: (Boolean) -> Boolean)  = booleanIterator().single(condition)
inline fun BooleanIterable.singleOr(elseReturn: Boolean, crossinline condition: (Boolean) -> Boolean) = booleanIterator().singleOr(elseReturn, condition)
