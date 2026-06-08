package class_obj_package_a1
/*
    book Kotlin illustrated Guide
    Class is a Custom Type
        Name : start with an uppercase letter
        Properties :
            class Circle(var radius: Double)
                radius
    Objects
            val smallCircle = Circle(5.2)
    Constructing object == call function with/out argument and return object of that TYPE
    Constructor : (var radius: Double)
    Method : a Member Function
    Singleton : single instance / object without state or own data
         = is to group similar funs or propertis into one class
        Keywork object instead of class
        object ShapePrinter {
            fun printCircle(circle: Circle) = ...
            fun printTriangle(triangle: Triangle) = ...
            fun printRectangle(rectangle: Rectangle) = ...
        }
        val circle = Circle(5.2)
        ShapePrinter.printCircle(circle)
   Package : Name Space to group Code elements (variables, fun, class, object...)
        using it with on the first line ->  shapes.circle
     Global is default Package

        package shapes
        import shapes.circle.shape as circle
        import shapes.rectangle.shape
        fun main() {
        val myShape = circle
        val myOtherShape = shape
}
 */

// parent class
open class Vehicle1 {
    open fun startEngine() {
        println("Vehicle1 engine started")
    }
}

// child class
class Car1 : Vehicle1() {
//    override fun startEngine() {
//        println("Car1 engine started")
//    }
}

class Circle(var radius: Double) {
    val pi: Double = 3.14
    private val pi1: Double = 3.14
    val circumference = 2 * pi * radius
    fun calculateCircumference1(radius: Double) = 2 * pi * radius // radius is local to calculateCircumference1 fun
    fun calculateCircumference0() = 2 * pi * radius
    fun calculateArea() = pi * radius * radius
}

fun main() {
    val circle = Circle(50.0)
    println(
        "radius =${circle.radius} \n" +
                "pi = ${circle.pi} \n" +
                "circumference = ${"%.2f".format(circle.circumference)} \n" +
                "funcion0 ${"%.2f".format(circle.calculateCircumference0())} \n" +
                "funcion1 ${"%.2f".format(circle.calculateCircumference1(5.0))} \n" +
                "Area ${"%.2f".format(circle.calculateArea())} \n" +
                "\n"
    )
//    println(" pi = ${circle.pi1} ") // Error it is private
//    println("radius =${circle.circumference} pi = ${circle.pi}  ")

    println("-----------")
    val myCar = Car1()
    myCar.startEngine()
}