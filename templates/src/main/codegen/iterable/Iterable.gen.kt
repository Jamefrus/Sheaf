@file:Suppress("PackageDirectoryMismatch", "unused", "NOTHING_TO_INLINE")
@file:JvmMultifileClass
@file:JvmName("PrimitiveIterableUtil")

//define temp=su.jfdev.ekollections
package temp.iterable

//define Short=#PRIM#
//define short=#prim#

import org.eclipse.collections.api.*
import temp.iterator.*

inline operator fun ShortIterable.iterator() = shortIterator().iterator()
inline operator fun ShortIterable.contains(other: Short): Boolean = contains(other)
inline operator fun ShortIterable.contains(other: ShortIterable): Boolean = containsAll(other)

inline infix fun ShortIterable.iterate(procedure: (Short) -> Unit) = shortIterator().iterate(procedure)

inline infix fun ShortIterable.all(crossinline condition: (Short) -> Boolean) = shortIterator().all(condition)
inline infix fun ShortIterable.none(crossinline condition: (Short) -> Boolean) = shortIterator().none(condition)
inline infix fun ShortIterable.count(crossinline condition: (Short) -> Boolean) = shortIterator().count(condition)
inline infix fun ShortIterable.any(crossinline condition: (Short) -> Boolean) = shortIterator().any(condition)

inline infix fun ShortIterable.`index of last`(crossinline condition: (Short) -> Boolean)  = shortIterator().`index of last`(condition)
inline infix fun ShortIterable.`index of first`(crossinline condition: (Short) -> Boolean)  = shortIterator().`index of first`(condition)

inline infix fun ShortIterable.first(crossinline condition: (Short) -> Boolean)  = shortIterator().first(condition)
inline fun ShortIterable.firstOr(elseReturn: Short, crossinline condition: (Short) -> Boolean) = shortIterator().firstOr(elseReturn, condition)

inline infix fun ShortIterable.last(crossinline condition: (Short) -> Boolean)  = shortIterator().last(condition)
inline fun ShortIterable.lastOr(elseReturn: Short, crossinline condition: (Short) -> Boolean) = shortIterator().lastOr(elseReturn, condition)

inline infix fun ShortIterable.single(crossinline condition: (Short) -> Boolean)  = shortIterator().single(condition)
inline fun ShortIterable.singleOr(elseReturn: Short, crossinline condition: (Short) -> Boolean) = shortIterator().singleOr(elseReturn, condition)