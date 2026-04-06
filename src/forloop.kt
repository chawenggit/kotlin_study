fun main() {
    for (number in 1..50) {
        // number is the iterator and 1..5 is the range
        if (number == 8) {
            break
        }
        else if (number % 4 == 0) {
            continue
        }
        println(number)
    }
    println()
// 12345
    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
// Yummy, it's a carrot cake!
// Yummy, it's a cheese cake!
// Yummy, it's a chocolate cake!
}