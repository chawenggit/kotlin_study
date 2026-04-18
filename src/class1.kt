import java.lang.classfile.instruction.StackInstruction

//primary constructors
class Person(val name: String, var age: Int) {
    init {
        require(age >= 0) { "Age cannot be negative" }
        println("Person created: $name")
    }

    override fun toString(): String {
        return "Person(name=$name, age=$age)"
    }
}

// secondary constructor
class Car(val make: String, val model: String, val year: Int) {
    //    property init inside class body
    var color: String = " No Color"

    constructor() : this("no make", "no model1", 0)
    constructor(make: String) : this(make, "no model2", 1)
    constructor(make: String, model: String) : this(make, model, 2)

    override fun toString(): String =
        "Make=${this.make}, Model=$model, year=$year , color=$color"
}

// init block
class Person1(val name: String) {

    val greeting = "Hello, $name".also { println("1. Property initialized") }

    init {
        println("2. Init block runs")
    }

    constructor(name: String, age: Int) : this(name) {
        println("3. Secondary constructor runs")
    }
}


fun main() {
    val pa = Person("Paul", 25)
    println(pa)
    val c1 = Car()
    val c2 = Car("Nissan")
    val c3 = Car("Toyota", "Prius")
    val c4 = Car("Ford", "Mustang", 2024)
    println(c1)
    println(c2)
    println(c3)
    println(c4)
    val p_ini = Person1("Pauly", 28)
    println(p_ini)

}
