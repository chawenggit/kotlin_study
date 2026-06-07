package generics_a6_fun

import generics_a3_come.Coffee
import generics_a3_come.Tea
import jdk.internal.org.jline.utils.Colors.s

/*
    book Kotlin illustrated Guide
*/

fun <T> drink_g(berverage: T) {
    println("--->Generic Drinking : $berverage")
    if (berverage is Tea) {
        println("   if >>Generic Drinking tea: $berverage")
    }
    when (berverage) {
        is Tea -> println("    when >>Generic Drinking tea: $berverage")
        is Coffee -> println("     when >>Generic Drinking coffe: $berverage")
    }
}

interface Beverage
enum class Tea : Beverage { GREEN_TEA, BLACK_TEA, RED_TEA }
enum class Coffee : Beverage { LIGHT_ROAST, MEDIUM_ROAST, DARK_ROAST }
class Mug<T>(val beverage: T) // generic type

fun <T : Beverage> serve(beverage: T): Mug<T> = Mug(beverage)

val mug1 = serve(Coffee.DARK_ROAST)
//error this
fun main() {

}