package generics_d1

/*
    Kotlin Generics Part 1: The Ultimate Guide with Practical Examples
    https://medium.com/@ramadan123sayed/kotlin-generics-the-ultimate-guide-with-practical-examples-ca3f5ca557e7
 */
//---------- Intro ------------------------------------
class Box0<T>(val content: T)

fun <T> printContent(content: T) {
    println(content)
}

class Box<T>(val content: T) {
    fun get_Content(): T {
        return content
    }
}

fun main1() {
    val doubleBox = Box(10.9)
    val intBox = Box(10)
    val stringBox = Box("Hello")
    println(intBox.get_Content()) // Output: 10
    println(stringBox.get_Content()) // Output: Hello
    println(doubleBox.get_Content()) // 10.9
}

//--------- Function ---------------
fun <T> printList(items: List<T>) {
    for (item in items) {
        println(item)
    }
}

fun main2() {
    val intList = listOf(1, 2, 3)
    val stringList = listOf("a", "b", "c")

    println("Printing integer list:")
    printList(intList) // Output: 1, 2, 3

    println("Printing string list:")
    printList(stringList) // Output: a, b, c

    // Works with custom types too
    data class User(val id: Int, val name: String)

    val userList = listOf(
        User(1, "Alice"),
        User(2, "Bob"),
        User(3, "Charlie")
    )

    println("Printing user list:")
    printList(userList) // Output: User(id=1, name=Alice), User(id=2, name=Bob), User(id=3, name=Charlie)
}

//--------- Advanced Generic Functions ---------------
// Transform a list of one type to another type
fun <T, R> List<T>.transformList(transform: (T) -> R): List<R> {
    return this.map { transform(it) }
}

// Find elements in a list that match a condition
fun <T> List<T>.findElements(predicate: (T) -> Boolean): List<T> {
    return this.filter { predicate(it) }
}

fun main3() {
    val numberList = listOf(1, 2, 3, 4, 5)

    // Transform numbers to strings
    val squaredNumbers = numberList.transformList { it * it }
    println("Squared numbers: $squaredNumbers") // Output: [1, 4, 9, 16, 25]

    // Find even numbers
    val evenNumbers = numberList.findElements { it % 2 == 0 }
    println("Even numbers: $evenNumbers") // Output: [2, 4]

    // Works with any type
    data class Product(val name: String, val price: Double)

    val products = listOf(
        Product("Laptop", 1200.0),
        Product("Phone", 800.0),
        Product("Headphones", 150.0)
    )

    // Transform products to their names
    val productNames = products.transformList { it.name }
    println("Product names: $productNames") // Output: [Laptop, Phone, Headphones]

    // Find products under $500
    val affordableProducts = products.findElements { it.price < 500.0 }
    println("Affordable products: $affordableProducts") // Output: [Product(name=Headphones, price=150.0)]
}

//------------------Generic Functions with Default Parameters -----------------
// Version 1: Simple approach with explicit default parameter
fun <T> getValueOrDefault(value: T?, defaultValue: T): T {
    return value ?: defaultValue
}

// Version 2: More advanced approach with type-specific defaults
//   Marking T as reified (combined with inline) preserves the type at runtime.
inline fun <reified T> getValueOrDefault(value: T?): T {
    return value ?: when (T::class) {
        String::class  -> "" as T  // compiler trusts you: T is String here
        Int::class     -> 0 as T
        Boolean::class -> false as T
        Double::class  -> 0.0 as T
        List::class    -> emptyList<Any>() as T
        Map::class     -> emptyMap<Any, Any>() as T
        else           -> throw NotImplementedError("No default value for type ${T::class.simpleName}")
    }
}

fun main4() {
    // Version 1: Using explicit defaults
    println(getValueOrDefault("Hello", "Default")) // Output: Hello
    println(getValueOrDefault(null, "Default"))    // Output: Default

    // Version 2: Using type-specific defaults (requires explicit type)
    println(getValueOrDefault<String>("Hello"))    // Output: Hello
    println(getValueOrDefault<String>(null))       // Output: "" (empty string)
    println(getValueOrDefault<Int>(null))          // Output: 0
    println(getValueOrDefault<Boolean>(null))      // Output: false

    // Custom types with Version 1
    data class User(val name: String)

    val defaultUser = User("Anonymous")
    println(getValueOrDefault(null, defaultUser))  // Output: User(name=Anonymous)
}

//---------------- Variance in Generics -------------------------------
/* *** If Dog is a subtype of Animal, is List<Dog> a subtype of List<Animal>? depends on VARIANCE ***/
//----------------1 Invariance (default in kotlin) -------------------------------
/*      instantiated generic type is considered distinct, regardless of the relationships between their type parameters.
        *** List<Dog> is not unrelated to List<Animal>
 */
class Container<T>(val value: T)

fun main5() {
    val stringContainer: Container<String> = Container("Hello")
//    val anyContainer: Container<Any> = stringContainer // Error: Type mismatch
    val anyContainerCorrect: Container<Any> = Container<Any>("Hello")
    println(anyContainerCorrect.value) // Output: Hello
}

//----------------2 Covariance (keyword :: out) -------------------------------
//  *** List<Dog> IS a subtype of List<Animal> — follows the type hierarchy.
// can output or read out , produce
open class Fruit

class Apple : Fruit1()

class FruitProducer<out T : Fruit1>(private val fruit: T) {
    fun produce(): T {
        return fruit
    }
}

fun main6() {
    val appleProducer: FruitProducer<Apple1> = FruitProducer(Apple1())
    val fruitProducer: FruitProducer<Fruit1> = appleProducer
    println(fruitProducer.produce().javaClass.simpleName) // Output: Apple instance
}

//----------------3 Contravariance (keyword :: in) -------------------------------
//  *** Consumer<Animal> IS a subtype of Consumer<Dog> — reverses the type hierarchy.
// can be input parameter
open class Fruit1

class Apple1 : Fruit1()

class FruitConsumer<in T : Fruit1> {
    fun consume(fruit: T) {
        println("Consuming a fruit ${fruit.javaClass.simpleName}")
    }
}

fun main7() {
    val fruitConsumer: FruitConsumer<Fruit1> = FruitConsumer()  // FruitConsumer can consume any Fruit
    val appleConsumer: FruitConsumer<Apple1> = fruitConsumer    // Contravariance allows this

    appleConsumer.consume(Apple1())  // Output: Consuming a fruit
}

//----------------more Example  -------------------------------
open class Fruit2

class Apple2 : Fruit2()

interface Source<out T> {
    fun next(): T
}

interface Sink<in T> {
    fun accept0()
    fun accept(item: T)
}

fun <T> feedSink(item: T, sink: Sink<T>) {
    sink.accept(item)
}

fun main8() {
    // out source -----------
    val stringSource: Source<String> = object : Source<String> {
        override fun next(): String = "stringSource"
    }
    val anySource: Source<Any> = stringSource   // out allow
    println(anySource.next()) // Output: stringSource

    // in sink -----------
    val fruitSink: Sink<Fruit2> = object : Sink<Fruit2> {
        override fun accept(item: Fruit2) {
            println("sink a fruit ${item.javaClass.simpleName}")
        }
        override fun accept0() {
            println("sink=${this.javaClass.simpleName}")
        }
    }
    val appleSink: Sink<Apple2> = fruitSink
    appleSink.accept0()
    feedSink(Apple2(), appleSink)
}

class ParameterizedConsumer<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}
fun main() {
    main8()
    val parameterizedConsumer = ParameterizedConsumer<Number>()

    val ref: ParameterizedConsumer<Double> = parameterizedConsumer

//    assertTrue(ref is ParameterizedConsumer<Double>)
}