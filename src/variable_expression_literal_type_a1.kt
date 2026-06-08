package variable_expression_literal_type_a1
/*
    book Kotlin illustrated Guide
 ** LITERAL — a fixed, hardcoded value written directly in code
Basic Type
true        // Boolean literal
42          // Int/Long literal
3.14        // Double literal

'A'         // Char literal
"Hello"     // String literal

 ** EXPRESSION — anything that PRODUCES / EVALUATES TO a value
1 + 2                    // evaluates to 3
mug.beverage             // evaluates to Coffee.DARK_ROAST
if (x > 0) "pos" else "neg"   // evaluates to a String
Coffee.DARK_ROAST        // evaluates to an enum value

// STATEMENT — a COMPLETE UNIT of action, does something, NO value returned
val x = 5                // declares a variable
println("Hi")            // performs an action
for (i in 1..5) { }     // performs a loop
*/

fun main() {
    // VAR : mutable variable
    var whole: Int = 11  // [1]
    var words: String = "A value"  // [4]
    whole++
    words += "end"

    // VAL : immutable variable
    val fractional: Double = 1.4  // [2]
    val trueOrFalse: Boolean = true // [3]
    val character: Char = 'z'  // [5]
    val lines: String = """Triple quotes let"""
}
