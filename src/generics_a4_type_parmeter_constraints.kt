package generics_a4_type_parmeter_constraints


/*
    book Kotlin illustrated Guide
    Declaring a Generic Type like parameter in FUN and CLASS
    fun cirx(__: Int) { }
    class Mug(val beverage: _____)
    Syntax
    class ClassName<T>(val variable:T)
        Ex. val mug = Mug<String>("Hi")
    type infering
        Ex. val mug = Mug("Hi"))
    generic type :
    parameterized type : specific type come from generic type
)
*/
sealed interface Beverage {
    val temperature: Int
}

enum class Tea : Beverage {
    GREEN_TEA, BLACK_TEA, RED_TEA;

    override val temperature: Int = 60
}

enum class Coffee : Beverage {
    LIGHT_ROAST, MEDIUM_ROAST, DARK_ROAST;

    override val temperature: Int = 57
}

// Constraint Generic Types Syntax
// T = Type Argument
//       to limit Types it supports
class Mug<T : Beverage>(val beverage: T) {
//    val temperature = beverage.temperature  // ! Error
}

// type explicit
val mug_c: Mug<Coffee> = Mug(Coffee.LIGHT_ROAST) // parameterized type
val mug_c1 = Mug<Coffee>(Coffee.LIGHT_ROAST) // parameterized type

// type inference without < type >
val mug_c2 = Mug(Coffee.LIGHT_ROAST) // parameterized type

val mug_t = Mug(Tea.GREEN_TEA) // parameterized type.

//val mug_s = Mug("String Coffee.LIGHT_ROAST")  // !Error

// without generic FUN
fun drink(coffee: Coffee) = println("Drinking coffee: $coffee")
fun drink(tea: Tea) = println("Drinking tea: $tea")

// with gerneric FUN
fun <T> drink_g(berverage: T) {
    println("--->Generic Drinking : $berverage")
    if (berverage is Tea) {
        println("   if >>Generic Drinking tea: $berverage")
    }
    when (berverage) {
        is Tea -> println("    when >>Generic Drinking tea: $berverage : ${berverage.temperature}")
        is Coffee -> println("     when >>Generic Drinking coffe: $berverage :${berverage.temperature}")
    }
}

fun main() {
    drink_g(mug_t.beverage)
    drink_g(mug_c1.beverage)
//    println(mug_s) // !Errors
}