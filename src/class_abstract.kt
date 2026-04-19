import kotlin.math.sqrt

abstract class Shape {
    abstract fun area(): Double  // abstract method
    open val name: String = "Shape"   // concrete property
    fun describe() {
        println("This is a $name")
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

class Square(val side: Double) : Shape() {
    override fun area(): Double {
        return side * side
    }
}

class Triangle(val height: Double, val base: Double) : Shape() {
    override fun area(): Double {
        return 0.5 * height * base
    }

    fun length(): Double  {
        val x = sqrt(height * height + base * base)
        return x + height + base
    }
    override val name : String = "Triangle"
}

fun main() {
    val circle = Circle(5.0)
    val square = Square(4.0)
    val triangle = Triangle(3.0, 4.0)
    triangle.describe()
    println("Area of the triagle: ${triangle.area()}")
    println("Round of the triagle: ${triangle.length()}")

    circle.describe()
    println("Area of the circle: ${circle.area()}")

    square.describe()
    println("Area of the square: ${square.area()}")
}