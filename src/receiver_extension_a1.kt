package receiver_extension_a1

/*
    book Kotlin illustrated Guide
    1. Receiver
    2. Extension function to Class
        can not access the private member
    3. Nullable Receiver Types
    4. Extension properties to Class
 */
class Dog {
    fun speak() {
        println("BARK!")
    }

    fun play() {
        // this.speak()  // this is RECEIVER can be omitted (implicit RECEIVER)
        speak()
    }

    val play1 = ::speak // function ref
}

// Extension Properties
val String.isShort1: Boolean
    get() = this.length < 20

fun main() {
    fun singleQuoted(original: String) = "'$original'"
    println(singleQuoted("test"))
//---------------------------------------------------------------
    // dot notation with String object to call its method
    val title = "The Robots from Planet X3"
    val loudTitle = title.uppercase()
    println(loudTitle) // THE ROBOTS FROM PLANET X3
//---------------------------------------------------------------
    // can chain with DOT NOTATION
    println(singleQuoted(title.removePrefix("The ")).uppercase()) // THE ROBOTS FROM PLANET X3
    //.removePrefix -> .uppercase -> singleQuoted
    // how to make singleQuoted work with DOT
    // RECEIVER is the object on the left of DOT
//---------------------------------------------------------------
    // Create CLASS Dog
    val fido = Dog()
    fido.speak()
    fido.play()  // fido is the object which is explicit RECEIVER
    //    fido.play1()
//---------------------------------------------------------------
    // after learning the RECEIVER so define Extension function to CLASS
    // from fun singleQuoted(original: String) = "'$original'" transformed to
    fun String.singleQuoted() = "'$this'"  // ***
    // String is the receiver type
    // this is the receiver parameter
    // Dot call can be used now
    println( // do from Top to Bottom
        (title
            .removePrefix("The "))
            .uppercase()
            .singleQuoted()
    ) // THE ROBOTS FROM PLANET X3
//---------------------------------------------------------------
    /*
    Kotlin visibility modifiers at a glance:
    Modifier            Visible to
    -------------------------------------
    (none / default)    Same package only
    public              Everywhere
    internal            Same module only
    private             Same file only
     */
//---------------------------------------------------------------
    // Nullable Receiver Types
    val title1: String? = null
    println(title1?.singleQuoted()) // null
    //*** function Overloading ***
    fun String?.singleQuoted() = "'$this'"
    println(title1.singleQuoted()) // 'null'
    println(title1?.singleQuoted()) // null  // not the same as above
//---------------------------------------------------------------
// Extension Properties
//    val String.isLong1: Boolean
    val string = "This string is long enough"
    val isItShort = string.isShort1
    println(isItShort)
}