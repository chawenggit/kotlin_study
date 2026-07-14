package function_b1

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {  //        Property getter declaration
            return height == width
        }
}
fun main() {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}