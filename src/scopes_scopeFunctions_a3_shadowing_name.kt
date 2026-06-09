package scopes_scopeFunctions_a3_shadowing_name

/*
    book Kotlin illustrated Guide
    1 Shadowing Name

*/
//--------Shadowing Name inner scope wins:
class Book(val title: String) {          // (1) class property — this.title
    fun printChapter(number: Int, title: String) {  // (2) parameter — title
        println("Chapter $number: $title")
        // which "title" is used here?  → (2) parameter wins — it SHADOWS (1)
        println(title)        // (2) parameter — "Chapter Title"  (inner scope wins)
        println(this.title)   // (1) class property — must use "this." to reach it
    }
}

//--------Example -------
class Person(val name: String) {
    fun sayHello() = println("Hello!")
}
class Dog(val name: String) {
    fun bark() = println("Ruff!")
}

val person = Person("Julia")
val dog = Dog("Sparky")

fun main() {
    with(person) {
            println("name_person = ${this.name}")
        with(dog) {
            println("name dog = ${this.name}")
        }
    }
}