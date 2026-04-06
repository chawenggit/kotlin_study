import kotlin.math.PI

fun hello() {
    return println("Hello, world! 123456")
}

fun hello_woReturn() {
    println("Hello, world! 123456")
}

fun printMessageWithPrefix(message: String, prefix: String) {
    println("[$prefix] $message")
}

// default parameter
fun printMessageWithPrefix1(message: String, prefix: String = "Info") {
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

    hello()
    printMessageWithPrefix("Log", "Hello")
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    printMessageWithPrefix1("Lox")
    println(sum(1, 2))
    println(circleArea(1))
    println(circleArea_single_exp(2))
    println(intervalInSeconds(1))
}

