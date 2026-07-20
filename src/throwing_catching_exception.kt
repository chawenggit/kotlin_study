package throwing
fun divide(a: Int, b: Int): Int {
    if (b == 0) {
        throw ArithmeticException("Cannot divide by zero")
    }
    return a / b
}

fun main1() {
    try {
        val result = divide(10, 0)
        println("Result: $result")
    } catch (e: ArithmeticException) {
        println("Caught an error: ${e.message}")
    } finally {
        println("This always runs, error or not")
    }
}

fun processInput(input: String) {
    try {
        val number = input.toInt()
        println(100 / number)
    } catch (e: NumberFormatException) {
        println("Not a valid number: $input")
    } catch (e: ArithmeticException) {
        println("Math error: ${e.message}")
    }
}

fun main2() {
    processInput("abc")   // Not a valid number: abc
    processInput("0")     // Math error: / by zero
    processInput("5")     // 20
}
fun main() {
    main2()
}