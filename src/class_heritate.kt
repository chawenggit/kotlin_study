// open is to make Parent be heritateed
open class Parent(val name: String) {
    init {        println("Hi i am $name")
    }
}

//class Child(val name: String, val age: Int) : Parent(name) {
// without val name = use name from parent
class Child(name: String, val age: Int) : Parent(name) {
    init {
        println("Hi i am $name, $age")
    }
}

fun main() {
    val person = Parent("Jack")
    val child = Child("John", 30)

}
