package handling_runtime_exceptions_a1

import dataClass_Destructuring_a1.Book1

/*
    book Kotlin illustrated Guide
    1. Exception: something unexpected happened

 */

/*  ----------Runtime Error---------------------
    Error : Compile time and Run time
    •At compile time, Kotlin can’t know whether a map will include a particular key. (See Listing 9.11).
    •At compile time, Kotlin can’t know what values we might get when we ask a database for data.
    •At compile time, Kotlin can’t know what a user might type into the keyboard when prompted. We could
        ask the user for a zip code, but might get a phone number instead.
*/
val ordinals = listOf("zeroth", "first", "second", "third", "fourth", "fifth")
fun ordinal(number: Int) = ordinals.get(number)
fun showRuntimeExceptions() {
    val place = ordinal(9) //9 = out of size  ! ***** runtime error
}

fun main() {
    showRuntimeExceptions()
}