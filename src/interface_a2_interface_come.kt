interface FarmAnimal { // can not instantiate
    val name: String
    fun speak()
}

class Chicken(override val name: String, var numberOfEggs: Int = 0) :FarmAnimal {
    override fun speak() = println("Cluck!")
}

class Pig(override val name: String, val excitementLevel: Int) :FarmAnimal {
    override fun speak() {
        repeat(excitementLevel) {
            println("Oink!")
        }
    }
}

class Cow(override val name: String) : FarmAnimal {
    override fun speak() = println("Moo!")
}

class Farmer(val name: String) {
    fun greet(animal: FarmAnimal) {
        println("Good morning, ${animal.name}!")
        animal.speak()
    }
}

/*
    It says "Class implement the Interface"
    Problem1 : multiple overriding greet fun
    Solution : using interface and it removes that multiple greet fun
 */

fun main() {
    val henry = Chicken("Henry")
    val piggy = Pig("Piggy", 3)
    val cowdy = Cow("Cowdy")
    val sue = Farmer("Sue")
    sue.greet(henry)
    sue.greet(piggy)
    sue.greet(cowdy)
}