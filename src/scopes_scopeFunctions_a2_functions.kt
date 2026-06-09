package scopes_scopeFunctions_a2_functions

/*
    book Kotlin illustrated Guide
     1. Scope Function : the higher-order function with lambda parameter
        use object
     2. THIS and IT are parameter to Scope FUN point to the same object
        T.() == this :: i am inside of object
        (T) == it    :: i am outside of object
 */
fun main() {
    //
//---------------with---this------------------
    // with(obj) {} read as " with this object, do the following. "
    // is not Extension Fun : since no dot notation
    // for initial
    // return lambda result
    /*
    public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return receiver.block()
}
     */
    data class Address(
        var street1: String = "",
        var street2: String = "",
        var city: String = "",
        var state: String = "",
        var postalCode: String = ""
    )

    val address = Address()  // create instance
    // from
    address.street1 = "9801 Maple Ave"
    address.street2 = "Apartment 255"
    address.city = "Rocksteady"
    address.state = "IN"
    address.postalCode = "12345"
    // using with()
    with(address) { // hidden "this" on each property as Receiver obj
        street1 = "9801 Maple Ave"
        street2 = "Apartment 255"
        city = "Rocksteady"
        state = "IN"
        postalCode = "12345"
    }

//---------------run---this------------------
    /*
    public inline fun <T, R> T.run(block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}
     */
    // it is Extension FUN and for initial
    // return lambda result
    val adr1 = address.run {
        street1 = "the 9801 Maple Ave"
        street2 = "Apartment 255"
        city = "Rocksteady"
        state = "IN"
        postalCode = "12345"

        state // last is result
    }
    println(
        address.street1
            .run { this.uppercase() }
            .removePrefix("THE")
    )
//---------------let--it-------------------
    /*
    public inline fun <T, R> T.let(block: (T) -> R): R {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        return block(this)
    }
    */
    //Use it for null checks or transforming an object into something else.
    // return lambda result
    val name: String? = null //"string_input"
    //name = null
    val length = name?.let {
        println(it)
        it.length   // return
    }
    println(length)

    println(
        "the hello world"
            .let { it.uppercase() }
            .removePrefix("THE")
            .let { "'$it'" }
    )
//---------------also--it-------------------
    /*
    public inline fun <T> T.also(block: (T) -> Unit): T {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        block(this)
        return this
     }
     */
    //Good for side effects (logging, debugging) without modifying the object.
    // return obj
    println(
        "the hello world"
            .also { println(it) }
            .also(::println) // also hands the string DIRECTLY to println ==  .also { s -> println(s) }  == .also { println(it) }
            .removePrefix("the")
    )

//---------------apply--this-------------------
    /*
    public inline fun <T> T.apply(block: T.() -> Unit): T {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        block()
        return this
     }
     */
    //Good for side effects (logging, debugging) without modifying the object.
    // return obj
    println(
        "the hello world"
            .apply { println(this) }
            .removeSuffix("world")
    )

}