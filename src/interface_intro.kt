interface FarmAnimal {
    val name: String
    fun speak()
}

class Chicken(override val name: String, var numberOfEggs: Int = 0) : FarmAnimal {
    override fun speak() = println("Cluck!")
}

class Pig(override val name: String, val excitementLevel: Int = 5) : FarmAnimal {
    override fun speak() {
        repeat(excitementLevel) {
            println("Oink!")
        }
    }
}

class Cow(override val name: String) :FarmAnimal {
    override fun speak() = println("Moo!")
}

class Farmer(val name: String) {
    fun greet(annimal: FarmAnimal) {
        println("Good morning, ${annimal.name}!")
        annimal.speak()
    }
}

fun main() {
    val henrietta = Chicken("Henrietta")
    val hamlet = Pig("Hamlet", 6)
    val cow = Cow("Co")
    val sue = Farmer("Sue")
//    henrietta.speak()
//    hamlet.speak()
    sue.greet(henrietta)
    sue.greet(hamlet)
    sue.greet(cow)

}