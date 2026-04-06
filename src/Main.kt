val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
val shapesLocked: List<String> = shapes

fun main() {
// Read only list
    val readOnlyShapes = listOf("triangle", "square", "circle")
    println("readOnlyShapes = ${readOnlyShapes}")
// [triangle, square, circle]
    println("shapesLocked = ${shapesLocked}")
    println("The first item in the list is: ${shapesLocked.first()}")
    println("The last item in the list is: ${shapesLocked.last()}")
    println("The second item in the list is: ${shapesLocked[1]}")
    println("The number of  item in the list is: ${shapesLocked.count()}")
    shapes.add("1")
    println("The number of  item in the shape is: ${shapes.count()}")
}