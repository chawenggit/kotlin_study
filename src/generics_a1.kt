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

// Instead of creating multiple classes:

class StringBox(val value: String)
class IntBox(val value: Int)
//class PersonBox(val value: Person)

// Create a single generic class:
class Box2<T>(val value: T) {
//    fun getValue(): T = value
}

// Use generic classes:
val stringBox2 = Box2("Hello")
val numberBox2 = Box2(100)
//val personBox2 = Box2(Person("Jose Lujan"))

// SynTax
class Container<T>(var content: T)

fun main_test3() {
    val myAContainer = Container("jose")
    val myBContainer = Container(9999)
    println(myAContainer.content)
    println(myBContainer.content)
}

/*
// Generic function to process lists
fun <T> List<T>.processEach(action: (T) -> Unit) {
    forEach { item -> action(item) }
}

// Use with different types:
val numbers = listOf(33, 3, 38)
numbers.processEach { println("Number: $it") }
val names = listOf("Noemi", "Viena", "Jose")
names.processEach { println("Name: $it") } */

/*
---- When to use generics?
     1.It is flexible and able to work with different data types in a safe and specific way
---- When not to use generics?
*** 1 know in advance that use only a specific type
*** 2 use simple action like printing (use Any)
// BAD (overcomplicated):
class UserRepository<T : User> {
fun save(item: T)
fun find(id: Int): T
}

// BETTER (simpler and clearer):
class UserRepository {
fun save(user: User)
fun find(id: Int): User
}

// If you only need to print items:
// BAD (unnecessarily generic):
fun <T> printItem(item: T) {
    println(item.toString())
}

// BETTER (simpler):
fun printItem(item: Any) {
    println(item.toString())
}
    When to use Any instead of generics
    1. It is common to all type (ex.toString())
    2. not need type flexibility
    3. simplify code

 */

//------- case of using generic over Any type ----------------------------
// Generic cart that only accepts types that implement PricedItem
interface PricedItem {
    fun get_Price(): Double // can not name getPrice since is the same getter of price
}

class Product(
    val name: String,
    val price: Double
) : PricedItem {
    override fun get_Price() = price
}

class DiscountedProduct(
    val name: String,
    val price: Double,
    val discount: Double
) : PricedItem {
    override fun get_Price() = price * (1 - discount)
}

class ShoppingCart_useAny {

    private val items = mutableListOf<Any>()

    fun addItem(item: Any) {
        items.add(item)
    }

    fun calculateTotal(): Double {
        var total = 0.0
        items.forEach { item ->

// We need to check the type of each item
            when (item) {
                is Product           -> total += item.price
                is DiscountedProduct -> total += item.price * (1 - item.discount)
                else                 -> println("Unrecognized product type")
            }
        }
        return total
    }
}

// Generic cart that only accepts types that implement PricedItem
class ShoppingCart<T : PricedItem> {
    private val items = mutableListOf<T>()

    fun addItem(item: T) {
        items.add(item)
    }

    fun calculateTotal(): Double {
        return items.sumOf { it.get_Price() }
    }
}

fun main_AnyVsGenerics() {
    val cart = ShoppingCart<PricedItem>()
    cart.addItem(Product("Laptop", 999.99))
    cart.addItem(DiscountedProduct("Phone", 599.99, 0.1))
//    cart.addItem("This shouldn't be here")//Error we can not add any type
    println(cart.calculateTotal()) // 1539.981
}
/* the avantages for this case of using Gererics over Any
    1.Type Safety: constrained type (<T : PricedItem>) without type checking
    2.Reuse and flexible
    3.Clean and safe code
 */

//------- Using generics with functions ----------------------------
fun <T> printItem(item: T) {
    println(item)
}

fun main_fun() {
    printItem("Viena")
    printItem(50)
    printItem(true)
}

fun main() {
    main_fun()
}