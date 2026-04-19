// one function works for ANY type ✅
fun <T> addItem(list: MutableList<T>, item: T) {
    list.add(item)
}

fun main() {
    val ints = mutableListOf<Int>()
    val strings = mutableListOf<String>()

    addItem(ints, 42)           // T = Int
    addItem(strings, "hello")   // T = String
    println(ints)
    println(strings)
}