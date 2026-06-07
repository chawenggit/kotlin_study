package generics_a6_fun

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

//**  Create Extension Fun
fun <T : Beverage> T.pourIntoMug() = Mug(this)
val mug_ext = Coffee.MEDIUM_ROAST.pourIntoMug()

fun main() {
    println(mug1)
    println(mug1.beverage)

    println(mug_ext)
    println(mug_ext.beverage)
}