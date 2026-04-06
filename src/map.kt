fun main() {
    // Read-only map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to "10110")
    println(readOnlyJuiceMenu)
// {apple=100, kiwi=190, orange=100}

// Mutable map with explicit type declaration
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(juiceMenu)
// {apple=100, kiwi=190, orange=100}
    val juiceMenuLocked: Map<String, Int> = juiceMenu
// Read-only map
//    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("The value of apple juice is: ${readOnlyJuiceMenu["apple"]}")
    println("The value of organge juice is: ${readOnlyJuiceMenu["orange"]}")
// The value of apple juice is: 100

    // Read-only map
    println("This map has ${readOnlyJuiceMenu.count()} key-value pairs")
// This map has 3 key-value pairs
    println(readOnlyJuiceMenu.containsKey("kiwi"))
// true

    println("orange" in readOnlyJuiceMenu.keys)
// true

// Alternatively, you don't need to use the keys property
    println("orange" in readOnlyJuiceMenu)
// true

    println(200 in readOnlyJuiceMenu.values)
// false

    val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")// Write your code here
    val n = 2
    println("$n is spelled as '${number2word[n]}'")
}