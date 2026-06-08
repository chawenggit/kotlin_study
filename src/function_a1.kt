package function_a1
import kotlin.math.PI
/*
    book Kotlin illustrated Guide
    fun circumference(radius: Double) = 2 * pi * radius
    From Function
    1. An argument is a value that we pass function, the argument is 5.2.
    2. A parameter is a variable that hold an argument named radius.

    Syntax
        fun funName(para1: Type): Return Type = or {}
    FUNCTION Bodies
        Expression body : for simple expression
            fun circumference(radius: Double) = 2 * pi * radius
        Block body
            fun hello() { return println("Hello, world! 123456") }
    Default Arguments
        fun printMessageWithPrefix1(message: String, prefix: String = "Info") {}
    Named Argument calling
        printMessageWithPrefix(prefix = "Log", message = "Hello")
    Entry Point main()
    String Template  : with ${expression}
          println("The circumference is ${circumference(1.0)}")
*/

fun hello_woReturn() {
    println("Hello, world! 123456")
}

fun printMessageWithPrefix(message: String, prefix: String) {
    println("[$prefix] $message")
}



fun sum(x: Int, y: Int): Int {
    return x + y
}

fun circleArea(r: Int): Double {
    return PI * (r * r)
}

fun circleArea_single_exp(r: Int): Double = PI * (r * r)

fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) = ((hours * 60) + minutes) * 60 + seconds

fun main() {

//    hello()
    printMessageWithPrefix("Log", "Hello")

    printMessageWithPrefix1("Lox")
    println(sum(1, 2))
    println(circleArea(1))
    println(circleArea_single_exp(2))
    println(intervalInSeconds(1))
}

