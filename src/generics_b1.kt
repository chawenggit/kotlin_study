package generics_b1


/*
    book 2024 Building_Kotlin_Applications Mounir_Boussetta
    1. generics parameter = type parameter(T)
    2. syntax
        ClassName_Or_InterfaceName<T>
        while E = element T = type K = key V = value N = Number

 */
// -------- Introduction ---------
class GenericType<T>(t: T) {
    var value = t
}

val genericObj: GenericType<String> = GenericType<String>("Generic type")
val genericObj2 = GenericType("Generic type")
val map = mapOf("A" to 12.0, "B" to 20.5)
class Patient<T>(value: T) {
    var age:T = value
    init {
        println(age)
    }
}

private fun main_intro() {
    val patient1 = Patient(1)
    val patient2 = Patient("2")
}

// -------- Function --------------------
fun main() {
    main_intro()

}