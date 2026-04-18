// parent class
open class Vehicle {
    open fun startEngine() {
        println("Vehicle engine started")
    }
}

// child class
class Car : Vehicle() {
    override fun startEngine() {
        println("Car engine started")
    }
}

fun main() {
    val myCar = Car()
    myCar.startEngine()
}