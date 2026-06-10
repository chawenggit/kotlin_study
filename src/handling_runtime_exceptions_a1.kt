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

//  ----------The Call Stack---------------------
fun annc(number: Int, task: String): String {
    val ordinal = ordinal(number)
    return "The $ordinal thing I will do is $task."
}
//val first = annc(1, "clean my room")
//    println(first)

//  ----------Call Stacks, Exceptions, and Error Messages--------------------
/*     val first = annc(9, "clean my room") // "The first thing I will do is clean my room."
     Error
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 6
	at java.base/java.util.Arrays$ArrayList.get(Arrays.java:4225)
	at handling_runtime_exceptions_a1.Handling_runtime_exceptions_a1Kt.ordinal(handling_runtime_exceptions_a1.kt:19)
	at handling_runtime_exceptions_a1.Handling_runtime_exceptions_a1Kt.annc(handling_runtime_exceptions_a1.kt:26)
	at handling_runtime_exceptions_a1.Handling_runtime_exceptions_a1Kt.main(handling_runtime_exceptions_a1.kt:46)
	at handling_runtime_exceptions_a1.Handling_runtime_exceptions_a1Kt.main(handling_runtime_exceptions_a1.kt)

	Exception = Index 9 out of bounds for length 6
	Call Stack = from Bottom Up
	each error line shows : Function -> FileName -> Line Number
	click to jump to error place
*/
fun showError() {
    val first = annc(9, "clean my room") // "The first thing I will do is clean my room."
    println(first)
}

//  ----------Catching Exceptions--------------------
fun catch() {
    val tasks = listOf(1 to "clean my room", 9 to "take out trash", 5 to "feed the dog")
    tasks.forEach { (number, task) ->
        try {
            println(annc(number, task))
        } catch (exception: Exception) {
            println("CATCH  n=$number TASK=$task EXCEPT= $exception MSG=${exception.message}")
        }
    }
}

//  ----------looping over the Stack Trace--------------------
fun catch_loop() {
    val tasks = listOf(1 to "clean my room", 9 to "take out trash", 5 to "feed the dog")
    tasks.forEach { (number, task) ->
        try {
            println(annc(number, task))
        } catch (e: Exception) {
            e.stackTrace             // array of frames, crash at top
                .reversed()          // flip → main() at top, crash at bottom
                .drop(1)             // remove last JVM internal frame
                .joinToString(" -> ") { "${it.methodName}()" }
                // extract method names, join with arrow
                .let { println("Error: $it") }
            // print the result
        }
    }
}
fun main() {
    catch_loop()
}