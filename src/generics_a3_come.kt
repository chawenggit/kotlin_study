package generics_a3_come

import generics_a2_use_interface_help.Beverage

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
interface Beverage
enum class Tea : Beverage { GREEN_TEA, BLACK_TEA, RED_TEA }
enum class Coffee : Beverage { LIGHT_ROAST, MEDIUM_ROAST, DARK_ROAST }

class Mug<T>(val beverage: T) // generic type

val mug_c = Mug(Coffee.LIGHT_ROAST) // parameterized type
val mug_t = Mug(Tea.GREEN_TEA) // parameterized type.
//fun drink(coffee: Coffee) = println("Drinking coffee: $coffee")
////drink(mugOfCoffee.beverage)  // *** error because the compiler only know declared type
//
//interface Beverage
//enum class Tea : Beverage { GREEN_TEA, BLACK_TEA, RED_TEA }
//enum class Coffee : Beverage { LIGHT_ROAST, MEDIUM_ROAST, DARK_ROAST }
//class Mug(val beverage: Beverage)
//
//fun drink(coffee: Coffee) = println("Drinking coffee: $coffee")
//fun drink(tea: Tea) = println("Drinking tea: $tea")
////drink(mugOfCoffee.beverage)  // *** error because the compiler only know declared type
//drink(mugOfTea.beverage) //error

fun main() {
    println(mug_c)
    println(mug_t)
}