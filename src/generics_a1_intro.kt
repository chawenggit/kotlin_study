package generics_a1_intro
/*
    book Kotlin illustrated Guide
 */
// FIRST DAY
enum class Coffee { LIGHT_ROAST, MEDIUM_ROAST, DARK_ROAST }
class Mug(val beverage: Coffee)
fun drink(coffee: Coffee) = println("Drinking coffee: $coffee")

// NEXT DAY
enum class Tea { GREEN_TEA, BLACK_TEA, RED_TEA }
class TeaMug(val tea: Tea)
   // change name
class CoffeeMug(val beverage: Coffee)
    // override drink
fun drink(tea: Tea) = println("Drinking tea: $tea")

//ISSUES  NEXT WEEK expand more beverages it must create new more CLASS

fun main() {
    val mug = Mug(Coffee.MEDIUM_ROAST)
    drink(coffee = Coffee.LIGHT_ROAST)
    drink(mug.beverage)
//   next day
    drink(Tea.GREEN_TEA)
}