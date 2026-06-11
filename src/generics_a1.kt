package generics_a1


/*
    book Kotlin illustrated Guide
 */
//------------- DAY 1----------------
// START WITH COFFEE
enum class Coffee { LIGHT_ROAST, MEDIUM_ROAST, DARK_ROAST }
class Mug(val beverage: Coffee)

fun drinkDay1() {
    fun drink(coffee: Coffee) = println("Drinking coffee: $coffee")
    val mug = Mug(Coffee.LIGHT_ROAST)
    drink(Coffee.LIGHT_ROAST)
    drink(mug.beverage)
}

//------------- DAY 2 ----------------
// ADD TEA
enum class Tea { GREEN_TEA, BLACK_TEA, RED_TEA }
class TeaMug(val tea: Tea)
class CoffeeMug(val beverage: Coffee)

fun drinkDay2() {
    fun drink(coffee: Coffee) = println("Drinking coffee: $coffee")
    fun drink(tea: Tea) = println("Drinking tea: $tea")
    drink(Coffee.LIGHT_ROAST)
    drink(Tea.BLACK_TEA)  // overload
}

//------------- DAY 3 use INTERFACE----------------
// ADD CHOCOLATE -> ISSUE too much -> how to use one Mug Class to hold all
interface Beverage
enum class Tea3 : Beverage { GREEN_TEA, BLACK_TEA, RED_TEA }
enum class Coffee3 : Beverage { LIGHT_ROAST, MEDIUM_ROAST, DARK_ROAST }
class Mug3(val beverage: Beverage)

fun drinkDay3() {
    val mugOfCoffee = Mug3(Coffee3.LIGHT_ROAST)
    val mugOfTea = Mug3(Tea3.BLACK_TEA)
    fun drink(coffee: Coffee3) = println("Drinking coffee: $coffee")
    fun drink(tea: Tea3) = println("Drinking tea: $tea")
}

// ------------------book Kotlin in Action------------
val authors = listOf("Sveta", "Seb", "Dima", "Roman")
val readers = mutableListOf("Sveta", "Seb", "Dima", "Hidi")
fun main_test1() {
//fun <T> List<T>.slice(indices: IntRange): List<T>
    val nums = listOf(1, 2, 3, 4, 5)
    println(nums.slice(1..3))  // ✅ just use it — [2, 3, 4]
    val letters: List<Char> = ('a'..'z').toList()
    println(letters.slice(0..2)) // [a, b, c]
    println(letters.slice(10..13)) // [k, l, m, n]
    println(readers.filter { it !in authors })
    println(readers.filter { it in authors })
    println(listOf(1, 2, 3, 4).penultimate)
}

//  generic extension property (penultimate)
val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun main_test2() {
    // Generic function to process lists
    fun <T> List<T>.processEach(action: (T) -> Unit) {
        forEach { item -> action(item) }
    }
// ------------------book Kotlin for Java Developer ------------
// Use with different types:
    val numbers = listOf(33, 3, 38)
    numbers.processEach { println("Number: $it") }
    val names = listOf("Noemi", "Viena", "Jose")
    names.processEach { println("Name: $it") }
    val bools = listOf(true, false, true)
    bools.processEach { println("${it.javaClass.simpleName} = $it") }

}

fun main() {
    main_test2()
}