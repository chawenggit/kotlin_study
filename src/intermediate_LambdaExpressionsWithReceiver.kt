/*
    SYNTAX
    Type.(parameters) -> ReturnType
    while Regular Lamda
    val lambdaName: (InputType) -> ReturnType = { parameter -> body }

*/
fun main() {
// Declare a lambda with String as receiver
    val shout: String.() -> String = {
        this.uppercase() + "!!!"   // 'this' = the String it's called on
    }
    val shout1: String.() -> String = {
        uppercase() + "!1!"   // 'this' = the String it's called on
    }
// Two ways to invoke it:
    println("hello".shout1())        // → HELLO!!!
    println(shout("hello"))         // → HELLO!!!

//    With Parameters
    val repeat: String.(Int) -> String = { times ->
        this.repeat(times)   // 'this' is the String, 'times' is the param
    }

    println("ha".repeat(3))   // → hahaha

    //
    class Canvas {
        fun drawCircle() = println("🟠 Drawing a circle")
        fun drawSquare() = println("🟥 Drawing a square")
    }

    // Lambda expression with receiver definition
    fun render(block: Canvas.() -> Unit): Canvas {
        val canvas = Canvas()
        // Use the lambda expression with receiver
        canvas.block()
        return canvas
    }

    render {
        drawCircle()
        // 🟠 Drawing a circle
        drawSquare()
        // 🟥 Drawing a square
    }


}
//https://kotlinlang.org/docs/kotlin-tour-intermediate-lambdas-receiver.html#lambda-expressions-with-receiver