package com.extension_function

fun String.lastChar(): Char = this.get(this.length - 1)
// obmit this
fun String.lastChar_obmit(): Char = get(length - 1)
fun main1() {
    println("Alex".lastChar())
    println("Chaweng".lastChar())
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",//    Assigns default values
    prefix: String = "", //    for parameters
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main2() {
    val list = listOf(1, 2, 3)
    println(list.joinToString(":", prefix = "[", postfix = "]"))
// 1 2 3
}

fun <T> Collection<T>.joinToString1(
    separator: String = ", ",//    Assigns default values
    prefix: String = "", //    for parameters
    postfix: String = ""
): String {
    var result = prefix
    for ((index, element) in this.withIndex()) {
        if (index > 0) result += separator
        result += element
    }
    result += (postfix)
    return result
}

fun main3() {
    val list = listOf("A", 2, 3)
    println(list.joinToString1(":", prefix = "[", postfix = "]"))
// 1 2 3
}


fun main() {
    main3()

}