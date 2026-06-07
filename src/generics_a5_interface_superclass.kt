package generics_a5_interface_superclass

/*
    book Kotlin illustrated Guide
*/

class Dish<T> (private var food: T){
    fun replaceFood(newFood: T){
        println("replace $food with $newFood")
        food = newFood
    }
    fun getFood(): T = food
}

//* Generics with Multiple Type Parameters (rarely used)
//  class ComboOrder<T : Food, U : Beverage>(val food: T, val beverage: U)
//  val combo: ComboOrder<Pastry, Tea> = ComboOrder(Pastry.MUFFIN, Tea.GREEN_TEA)

enum class Soup { TOMATO, CARROT, PUMKIN }

//** Generic Interfaces and Superclasses
//--------------------------------
//  interface can be generic
interface Dish_I<T> {
    val food: T
}
//  interface  implement 1
class BowlOfSoup(override val food: Soup) : Dish_I<Soup>
val bowlOfSoup1: BowlOfSoup = BowlOfSoup(Soup.TOMATO)

//  interface implement 2
class Bowl<F>(override val food: F) : Dish_I<F>
val bowlOfSoup2 = Bowl(Soup.CARROT)

//--------------------------------
//  superclass and open class can be generic
// ✗ Case 1 — val in parent is final, child tries to override
open class Dish_C1<T>(val food: T)
//class BowlOfSoup_C1(override val food: Soup) : Dish_C1<Soup>(food)
//***! ERROR: food is final and cannot be overridden

// ✓ Case 2 — parent opens it, child overrides
open class Dish_C2<T>(open val food: T)
class BowlOfSoup_C2(override val food: Soup) : Dish_C2<Soup>(food)
// OK ✓

// ✓ Case 3 — simplest, no conflict at all
open class Dish_C3<T>(val food: T)
class BowlOfSoup_S2(food: Soup) : Dish_C3<Soup>(food)
// OK ✓ — just forward, no re-declaration



fun main() {
    val food1 = Dish("Omlet")
    food1.replaceFood("Sandwich")
    println(food1.getFood())

    println(bowlOfSoup1)
    println(bowlOfSoup1.food)

    println(bowlOfSoup2)
    println(bowlOfSoup2.food)


}