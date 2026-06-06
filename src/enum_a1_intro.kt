package enum_a1_intro
/*
    book Kotlin illustrated Guide
    ENUM CLASS is the special kind of CLASS to limit number of values
 */
val nameOfSchnauzer: String = "Shadow"
val breedOfSchnauzer: String = "Miniature"
// String type does not limit breed of Schnauzer so here com ENUM CLASS
// 1 key word = enum class
// 2 class name
// 3 enum entries
enum class SchnauzerBreed {
    MINIATURE,
    STANDARD,
    GIANT
}
// Using
// Note this Class can not be instantiated
val breed: SchnauzerBreed = SchnauzerBreed.GIANT
//  with WHEN
fun describe(breed: SchnauzerBreed) = when (breed) {
    SchnauzerBreed.MINIATURE -> "Small"
    SchnauzerBreed.STANDARD-> "Medium"
    SchnauzerBreed.GIANT-> "Large"
//  no  else -> "None" since it is exhaust
}

// Adding Properties and FUNs since it is a CLASS
//    33,47,65 is a constructor argument and the entries are the INSTANCE
enum class SchnauzerBreed1(val height: Int) {
    MINIATURE(33),
    STANDARD(47),
    GIANT(65)
}

//include a property that does not require a constructor argument.
enum class SchnauzerBreed2(val height: Int) {
    MINIATURE(33),
    STANDARD(47),
    GIANT(65);  // stop entries with semicolon
    // then insert global properties/ global FUN below this semicolon
    val family: String = "Schnauzer"
    fun isShorterThan(centimeters: Int) = height < centimeters
}
// Built-In Properties
//  1 Ordinal(index)
//  2 Name :: to get the String
//
enum class SchnauzerBreed3(val height: Int) {
    MINIATURE(33), // ordinal = 0 , name = MINIATURE
    STANDARD(47),// ordinal = 1
    GIANT(65)// ordinal = 2
}
fun main() {
    println(SchnauzerBreed1.MINIATURE.height) // access its Property = 33

    println(SchnauzerBreed2.GIANT.height)
    println(SchnauzerBreed2.GIANT.family)

    println(SchnauzerBreed2.GIANT.isShorterThan(7))

    println(SchnauzerBreed3.GIANT.name) // GIANT

}