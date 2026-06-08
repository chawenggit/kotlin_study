package null_nullSafety_a1
/*  REFs
    1 https://kotlinlang.org/docs/kotlin-tour-null-safety.html#exercise
    2 book Kotlin illustrated Guide
    NULL = Type? == nullable type
    Elvis operator ?:
    not-null assertion operator !!    // dangerous should not use
    Safe-Call Operator .?
 */

class Payment
enum class Coffee { LIGHT_ROAST, MEDIUM_ROAST, DARK_ROAST }

fun main() {
    // neverNull has String type
    var neverNull: String? = "This can't be null"

    // Throws a compiler error
    neverNull = null

    // nullable has nullable String type
    var nullable: String? = "You can keep a null here"

    // This is OK
    nullable = null

    // By default, null values aren't accepted
    var inferredNonNull = "The compiler assumes non-nullable"

    // Throws a compiler error
//    inferredNonNull = null

    // notNull doesn't accept null values
    fun strLength(notNull: String): Int {
        return notNull.length
    }

//    println(strLength(neverNull)) // 18
//    println(strLength(nullable))  // Throws a compiler error


    fun describeString(maybeString: String?): String {
        if (maybeString != null && maybeString.length > 0) {
            return "String of length ${maybeString.length}"
        } else {
            return "Empty or null string"
        }
    }

    val nullString: String? = null
    println(describeString(nullString))
    // Empty or null string

    fun lengthString(maybeString: String?): Int? = maybeString?.length

    val nullString1: String? = null
    println(lengthString(nullString1))
    // null
    val nullString2: String? = null
    println(nullString2?.uppercase())

//    Elvis operator
    val nullString3: String? = null
    println(nullString3?.length ?: 0)
    // 0

    //    Exersise
    data class Employee(val name: String, var salary: Int)

    fun employeeById(id: Int) = when (id) {
        1    -> Employee("Mary", 20)
        2    -> null
        3    -> Employee("John", 21)
        4    -> Employee("Ann", 23)
        else -> null
    }

    fun salaryById(id: Int): Int {   // Write your code here
        val salary = employeeById(id)?.salary ?: 0
        return salary
    }
    println((1..5).sumOf { id -> salaryById(id) })
    println((1..5).map { id -> employeeById(id)?.name })

    fun orderCoffee(payment: Int?): Coffee {
        return Coffee.MEDIUM_ROAST
    }

    val payment: Int? = 1//null
//    val coffee = orderCoffee(payment!!) // ERROR AT RUNTIME!
//    println(coffee)

    println("----- Safe-call operator -----")
    val supportType = if (payment == null) "NULL" else payment::class.simpleName;
    println("Thank you for supporting us with your $supportType")
    // ✅ After — safe-call + Elvis
    val supportType1 = payment?.let { it::class.simpleName } ?: "NULL"
    println("Thank you for supporting us with your $supportType1")
    val supportType2: Int? = null //payment?.lowercase()//  { it::class.simpleName } ?: "NULL"
    println("Thank you for supporting us with your ${supportType2?.toString() ?: "NULL"}")

}
