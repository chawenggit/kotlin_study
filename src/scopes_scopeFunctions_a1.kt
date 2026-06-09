package scopes_scopeFunctions_a1

/*
    book Kotlin illustrated Guide
    1. Scopes
        : the region of code where a name (variable, function, class) is visible and accessible.
        package scope
        └── class scope
            └── function scope
                └── block scope  (if / for / while / lambda)
        Rules are
            Inner scope can see outer scope
            Outer scope cannot see inner scope
            When scope ends, everything inside is gone

     2. Scope Function : the higher-order function with lambda parameter
        use object

 */
// 1. PACKAGE (top-level) scope — visible to whole package
val packageLevel = "I'm everywhere in this package"
fun topLevelFun() {}

class Dog {
    // 2. CLASS scope — visible to all members of the class
    val classLevel = "I'm visible inside Dog"

    fun speak() {
        // 3. FUNCTION scope — visible only inside speak()
        val functionLevel = "I only exist here"

        if (true) {
            // 4. BLOCK scope — visible only inside this { }
            val blockLevel = "I only exist in this if-block"
        }
        // blockLevel is GONE here ❌
    }
    // functionLevel is GONE here ❌
}
// classLevel is GONE here ❌


fun main() {

}