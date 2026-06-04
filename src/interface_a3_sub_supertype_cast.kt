package interface_a3_sub_supertype

/*
  Subtypes and Supertypes
  subtype and Substitution
  casting
       1. Smart Casts (with if and when )
       2. Explicit Casts (as?)
            which try to cast , if false, return null

  val henrietta: FarmAnimal = Chicken("Henrietta")
    can not
 */
interface FarmAnimal { // can not instantiate
    val name: String  //
    fun speak() { // Default function: Classes get this automatically!
        println("FarmAnimal Speak ")
    }
}

class Chicken(override val name: String, var numberOfEggs: Int = 0) : FarmAnimal {
    override fun speak() = println("Cluck!")
}

class Pig(override val name: String, val excitementLevel: Int) : FarmAnimal {
    override fun speak() {
        repeat(excitementLevel) {
            println("Oink!")
        }
    }
}

class Cow(override val name: String) : FarmAnimal {
//    override fun speak() = println("Moo!") // use default interface fun
}

class Farmer(val name: String) {
    fun greet(animal: FarmAnimal) {
        println("Good morning, ${animal.name}!")
        // Explicit Casts
        val chicken: Chicken? = animal as? Chicken
        chicken?.let { println("I see you have ${it.numberOfEggs} eggs today!") }

        animal.speak()
    }
}

/*
    It says "Class implement the Interface and must promise have all that interface need"
    Interfaces like Classes IS a custom type which can not be instantiated.
    it is Abstract/Contract type  or Supertype == more general type
    Class is Concrete Type or Subtype == more specific type

    Problem1 : multiple overriding greet fun
    Solution : using interface and it removes that multiple greet fun
 */

fun main() {
    val henry = Chicken("Henry")
    val piggy = Pig("Piggy", 3)
    val cowdy = Cow("Cowdy")
    val sue = Farmer("Sue")
    val henrietta: FarmAnimal = Chicken("Henrietta")
//    sue.greet(henry)
//    sue.greet(piggy)
//    sue.greet(cowdy)
    sue.greet(henrietta)
//    henrietta is explecitly is FarmAnimal not Chicken  it is Mask Interface
//    println(henrietta.numberOfEggs) //  error but can be solved by Smart Casting
    if (henrietta is Chicken) {  // Smart Casting
        println(henrietta.numberOfEggs) //  no error
    }

    val animals: List<FarmAnimal> = listOf(
        Pig("Hamlet", 1),
        Chicken("Henrietta"),
        Cow("Dairy Godmother"),
    )
    animals.forEachIndexed { index, it ->
        sue.greet(it)
        if (it is Chicken) {
            println("---- ${it.name} with index ${index} is the Checken with ${it.numberOfEggs} eggs ---") //  no error
        }
    }

}