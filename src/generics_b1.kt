package generics_b1


/*
    book 2024 Building_Kotlin_Applications Mounir_Boussetta
    medium: https://medium.com/@ramadan123sayed/kotlin-generics-the-ultimate-guide-with-practical-examples-ca3f5ca557e7
    medium: https://medium.com/@huseyinozkoc/kotlin-generics-db50dd74fb24
    web: https://www.geeksforgeeks.org/kotlin/kotlin-generics/
    0. Imagine a container that can hold any type of object,
    1. Why use Generics
        - make code clean, flexible and reusable for every type
        - type safe : make the complier know the correct type using
            -> type invariance Box<Int> can not be used with a Box<Any> even Int is a subtype of Any
    2. generics parameter = type parameter(T)
    3. syntax
        ClassName_Or_InterfaceName<T>
        fun <T> methodOrFunctionName(parameter: T)
            where E = element T = type K = key V = value N = Number
    4. Invariance = "Must Be The Exact Same Type
    4. Covariance  : unlock Invariance


 */
// -------- Introduction ---------
class GenericType<T>(t: T) {
    var value = t
}

val genericObj: GenericType<String> = GenericType<String>("Generic type")
val genericObj2 = GenericType("Generic type")
val map = mapOf("A" to 12.0, "B" to 20.5)

class Patient<T>(value: T) {
    var age: T = value

    init {
        println(age)
    }
}

private fun mainIntro() {
    val patient1 = Patient(1)
    val patient2 = Patient("2")
}

fun <T> printList(items: List<T>) {
    for (item in items) {
        print("$item ,")
    }
    println()
}

fun mainIntro2() {
    val intList = listOf(1, 2, 3)
    val stringList = listOf("a", "b", "c")

    // Works with custom types too
    data class User(val id: Int, val name: String)

    val userList = listOf(
        User(1, "Alice"),
        User(2, "Bob"),
        User(3, "Charlie")
    )

    printList(intList)
    printList(stringList)
    printList(userList) // Output: User(id=1, name=Alice), User(id=2, name=Bob), User(id=3, name=Charlie)
}

// ------------ more complex generic function ------------
//Extension Function Transform a list of one type to another type
fun <T, R> List<T>.transformList(transform: (T) -> R): List<R> {
    return this.map { transform(it) }
}

// Find elements in a list that match a condition
fun <T> List<T>.findElements(predicate: (T) -> Boolean): List<T> {
    return this.filter { predicate(it) }
}

fun mainIntro3() {
    val numberList = listOf(1, 2, 3, 4, 5)

    // Transform numbers to strings
    val squaredNumbers = numberList.transformList { it * it }
    println("Squared numbers: $squaredNumbers") // Output: [1, 4, 9, 16, 25]

    // Find even numbers
    val evenNumbers = numberList.findElements { it % 2 != 0 }
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

// --------Generic Functions with Default Parameters--------------------
// Version 1: Simple approach with explicit default parameter
fun <T> getValueOrDefault(value: T?, defaultValue: T): T {
    return value ?: defaultValue
}

// Version 2: More advanced approach with type-specific defaults
inline fun <reified T> getValueOrDefault(value: T?): T {
    return value ?: when (T::class) {
        String::class  -> "" as T
        Int::class     -> 0 as T
        Boolean::class -> false as T
        Double::class  -> 0.0 as T
        List::class    -> emptyList<Any>() as T
        Map::class     -> emptyMap<Any, Any>() as T
        else           -> throw NotImplementedError("No default value for type ${T::class.simpleName}")
    }
}

fun mainDefaultParameter() {
    // Version 1: Using explicit defaults
    println(getValueOrDefault("Hello", "Default")) // Output: Hello
    println(getValueOrDefault(null, "Default"))    // Output: Default
    println("-----------------------")
    // Version 2: Using type-specific defaults (requires explicit type)
    println(getValueOrDefault(12))
    println(getValueOrDefault<String>("Hello"))    // Output: Hello
    println(getValueOrDefault<String>(null))       // Output: "" (empty string)
    println(getValueOrDefault<Int>(null))          // Output: 0
    println(getValueOrDefault<Boolean>(null))      // Output: false

    // Custom types with Version 1
    data class User(val name: String)

    val defaultUser = User("Anonymous")
    println(getValueOrDefault(null, defaultUser))  // Output: User(name=Anonymous)
}
// --------Generic Function --------------------
//fun <T> methodOrFunctionName(parameter: T)

fun <T> printValue(value: T) {
    println(value)
}

fun main_fun() {
    printValue<Int>(120)
    printValue<Boolean>(true)
    printValue("Hello Kotlin")
}

// --------Generic constraints --------------------
//       to limit Upper Bound Types it supports
open class BaseClass {
    override fun toString(): String {
        return this.javaClass.simpleName
    }
}

class Derived(val name: String) : BaseClass()
class Child(val name: String) : BaseClass()
class OtherClass(val name: String)

fun <T : BaseClass> returnElementAsList(element: T?): List<T> {
    if (element == null) return emptyList()
    return listOf(element)
}

// ------------ constrain generic function ------------
private fun main_constrain() {
    val list = returnElementAsList<BaseClass>(Derived("Derived")) // Ok
    val list2 = returnElementAsList<BaseClass>(Child("Child")) // Ok
    val list3 = returnElementAsList<BaseClass>(BaseClass()) // Ok
//    val list4 =
//        returnElementAsList<OtherClass>(OtherClass("Other")) // Compile time error:Expected BaseClassprintln(list)
    println("list = ${list}")
    println("list2 = ${list2}")
    println("list3 = ${list3}")
}

// must satisfy upper bounds and where conditions


// ------------ Why Not Just Use Any ------------
class AnyBox(var content: Any)
class GenericBox<T>(var content: T)

fun mainAnyProblem() {
    // 1. THE ANY PROBLEM
    val anyBox = AnyBox(123)

    // The compiler only sees 'Any'. It has no idea 'content' is a String.
    // anyBox.content.length) // ❌ ERROR: 'length' is not a property of 'Any'

    // We are forced to use 'as' (Explicit Casting).
    // This is like driving blindfolded; if we guess wrong, the app crashes!
    val length = (anyBox.content as String).length
    println(length)
    // ❌ CRASH: This compiles perfectly but kills the app at runtime!
    // val number = anyBox.content as Int // ClassCastException: String cannot be Int


    // 2. THE GENERIC SOLUTION
//    val genericBox = GenericBox<String>(123) // Compile Error
    val genericBox = GenericBox<String>("Hello Generics") // ok

    // The compiler HAS vision. It knows 'content' is definitely a String.
    // No casting required, no risk of ClassCastException.
    val safeLength = genericBox.content.length // ✅ Safe and clean


    // 3. UNDERSTANDING INVARIANCE (The Type Lock)
    // Because Generics are invariant, you can't accidentally change the type.
    // val stringBox: GenericBox<String> = GenericBox(123) // Compile Error == *** Invariance Generic
    val stringBox: GenericBox<String> = GenericBox("Kotlin")

    // ❌ ERROR: Even though String is a type of Any, GenericBox<String>
    // is NOT a GenericBox<Any>. They are NOT interchangeable.
    // val anyBoxType: GenericBox<Any> = stringBox // Compile Error == *** Invariance Generic

    // This "Type Lock" (Invariance) is what prevents you from
    // accidentally putting an 'Int' into your 'String' box later.
}

// ------------ Covariance (out) ------------
class Dog : Animal()
abstract class Animal()

class Producer<out T>(val item: T) {
    fun get(): T = item   // ✅ can only OUTPUT T
    // fun set(t: T) = .. // ❌ cannot INPUT T
}

fun mainOut() {

    val dogProducer: Producer<Dog> = Producer(Dog())
    val animalProducer: Producer<Animal> = dogProducer  // ✅ allowed
}

// ------------ generic class ------------
class ValueWithHistory<T>(private var value: T) {
    private var history: List<T> = listOf(value)
    fun setValue(value: T) {
        this.value = value
        this.history += value
    }

    fun currentValue(): T = value
    fun history(): List<T> = history
}

fun mainClass() {
    val letter = ValueWithHistory<String>("A")
// The type of letter is ValueWithHistory<String>
    letter.setValue("B")
// letter.setValue(123) <- this would not compile
    val l = letter.currentValue() // the type of l is String
    println(l) // B
    val h = letter.history() // the type of h is List<String>
    println(h) // [A, B]
}

fun main() {
    mainClass()
//    mainOut()
//    mainAnyProblem()
//    mainDefaultParameter()
//    mainIntro3()
//    main_constrain2()

}