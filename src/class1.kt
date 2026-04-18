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

fun main() {
    val myCar = Car1()
    myCar.startEngine()
}