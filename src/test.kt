val intArray = intArrayOf(1, 2, 3, 4, 5)
val doubleArray = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
val charArray = charArrayOf('a', 'b', 'c', 'd', 'e')
val booleanArray = booleanArrayOf(true, false, true, false)

// 1. Using the constructor (size + default value)
val zeros = IntArray(5)              // [0, 0, 0, 0, 0]
val filled = IntArray(5) { it * 2 } // [0, 2, 4, 6, 8]

// 2. Using factory functions
val nums = intArrayOf(1, 2, 3, 4, 5)
val flags = booleanArrayOf(true, false, true)
val bytes = byteArrayOf(0x1, 0x2, 0xFF.toByte())

// 3. Other primitives
val doubles = doubleArrayOf(1.0, 2.5, 3.14)
val chars = charArrayOf('a', 'b', 'c')

fun main() {
    println(intArray)
    println(doubleArray)
    println(charArray)
    println(booleanArray)
    for (n in zeros) print("$n ")
    println("")
    for (n in booleanArray) print("$n ")
}