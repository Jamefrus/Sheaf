@file:Suppress("PackageDirectoryMismatch", "unused", "NOTHING_TO_INLINE")
@file:JvmMultifileClass
@file:JvmName("PrimitiveIterableUtil")

//define temp=su.jfdev.ekollections
package su.jfdev.ekollections.iterable

//define Short=#PRIM#
//define short=#prim#

import org.eclipse.collections.api.*
import su.jfdev.ekollections.iterator.*

inline operator fun ByteIterable.iterator() = byteIterator().iterator()
inline operator fun ByteIterable.contains(other: Byte): Boolean = contains(other)
inline operator fun ByteIterable.contains(other: ByteIterable): Boolean = containsAll(other)

inline infix fun ByteIterable.iterate(procedure: (Byte) -> Unit) = byteIterator().iterate(procedure)

inline infix fun ByteIterable.all(crossinline condition: (Byte) -> Boolean) = byteIterator().all(condition)
inline infix fun ByteIterable.none(crossinline condition: (Byte) -> Boolean) = byteIterator().none(condition)
inline infix fun ByteIterable.count(crossinline condition: (Byte) -> Boolean) = byteIterator().count(condition)
inline infix fun ByteIterable.any(crossinline condition: (Byte) -> Boolean) = byteIterator().any(condition)

inline infix fun ByteIterable.`index of last`(crossinline condition: (Byte) -> Boolean)  = byteIterator().`index of last`(condition)
inline infix fun ByteIterable.`index of first`(crossinline condition: (Byte) -> Boolean)  = byteIterator().`index of first`(condition)

inline infix fun ByteIterable.first(crossinline condition: (Byte) -> Boolean)  = byteIterator().first(condition)
inline fun ByteIterable.firstOr(elseReturn: Byte, crossinline condition: (Byte) -> Boolean) = byteIterator().firstOr(elseReturn, condition)

inline infix fun ByteIterable.last(crossinline condition: (Byte) -> Boolean)  = byteIterator().last(condition)
inline fun ByteIterable.lastOr(elseReturn: Byte, crossinline condition: (Byte) -> Boolean) = byteIterator().lastOr(elseReturn, condition)

inline infix fun ByteIterable.single(crossinline condition: (Byte) -> Boolean)  = byteIterator().single(condition)
inline fun ByteIterable.singleOr(elseReturn: Byte, crossinline condition: (Byte) -> Boolean) = byteIterator().singleOr(elseReturn, condition)
