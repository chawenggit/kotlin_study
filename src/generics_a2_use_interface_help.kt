package generics_a2_use_interface_help
// FIRST DAY
interface Beverage
enum class Tea : Beverage { GREEN_TEA, BLACK_TEA, RED_TEA }
enum class Coffee : Beverage { LIGHT_ROAST, MEDIUM_ROAST, DARK_ROAST }
class Mug(val beverage: Beverage)

fun drink(coffee: Coffee) = println("Drinking coffee: $coffee")
fun drink(tea: Tea) = println("Drinking tea: $tea")
//drink(mugOfCoffee.beverage)  // *** error because the compiler only know declared type
//drink(mugOfTea.beverage) //error

fun main() {
    // ok for
//  val var   : Declared Type = Actual Type
    val coffee: Coffee = Coffee.MEDIUM_ROAST
    val beverage: Beverage = Coffee.MEDIUM_ROAST
    val anything: Any = Coffee.MEDIUM_ROAST
/*    variable can have more than one type at a time with rule  assign a narrow type to a wider type
    Declared Type : the type it has been declared == the main type
    Actual (Runtime)Type  : the specific type of object inside it
    Assignment compatibility : is it compatible

*/
    // not ok for
//    val beverage: Beverage = Coffee.MEDIUM_ROAST
//    val coffee: Coffee = beverage

//    *** So interfaces does not help ***

}