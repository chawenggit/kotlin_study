class Chicken(val name: String, var numberOfEggs: Int = 0)  {
    fun speak() = println("Cluck!")
}

class Pig(val name: String, val excitementLevel: Int)  {
    fun speak() {
        repeat(excitementLevel) {
            println("Oink!")
        }
    }
}

class Cow(val name: String) {
    fun speak() = println("Moo!")
}

class Farmer(val name: String) {
    fun greet(chick: Chicken) {
        println("Good morning, ${chick.name}!")
        chick.speak()
    }
    fun greet(pig: Pig) {
        println("Good morning, ${pig.name}!")
        pig.speak()
    }

    fun greet(cow: Cow) {
        println("Good morning, ${cow.name}!")
        cow.speak()
    }
}

/*
    Problem1 : multiple overriding greet fun
 */

fun main() {
    val henry = Chicken("Henry")
    val piggy = Pig("Piggy",3)
    val cowdy = Cow("Cowdy")
    val sue = Farmer("Sue")
    sue.greet(henry)
    sue.greet(piggy)
    sue.greet(cowdy)
}