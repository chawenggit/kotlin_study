package abstract_openClass_a1

/*
    book Kotlin illustrated Guide
    1 Base class vs Interface
    Base class  →  BLUEPRINT with storage
                - defines structure
                - holds actual data
                - manages its own state
                - Visibility: private, public, internal
                - Instantiation
                - must be marked with OPEN or ABSTRACT class to be inherited

    Interface   →  CONTRACT with no storage
                - defines roles
                - no data
                - just promises behavior

    2 Subclass extends the abstract class(or Superclass)
    3 the two concepts of class part
        class interface = outside see it
        class implementation = inside do it
    4 Protected Visibility
        public     →  no walls    — everyone enters
        internal   →  module wall — only teammates enter
        protected  →  family wall — only class + children  enter
        private    →  personal    — only I enter
    5  Abstract Class with functions and properties can be:
        - abstract : has only interface without implement
        - open : has implement and can be overridden
        - final : has implement and can not be overridden (default in Kotlin)
    6 Open Class can be both extended and instantiated

 */
//----------original Car Class-----------
class Car {
    private var speed = 0.0
    private fun makeEngineSound() = println("Vrrrrrr...")
    fun accelerate() {
        speed += 1.0
        makeEngineSound()
    }
}

//----------new abstract Car Class-----------
abstract class Car0 {
    private var speed = 0.0
    private fun makeEngineSound() = println("Vrrrrrr...")
    fun accelerate() {
        speed += 1.0
        makeEngineSound()
    }
}

//----------new abstract Car Class with constructor -----------
abstract class Car00(private val acceleration: Double) {
    private var speed = 0.0
    private fun makeEngineSound() = println("Vrrrrrr...")
    fun accelerate() {
        speed += 1.0
        makeEngineSound()
    }
}

//----------create subclass ----------- older car low accel
class Clunker : Car00(0.25) // force all Clunker object acceleration = 0.25

//create subclass and relay constructor arg to superclass (common practice)
class Clunker1(val acceleration: Double) : Car00(acceleration) {
    // solve above
    val speed = acceleration
}

//----------class interface and implementation ---------
class Circle(
    var radius: Double                  //------ interface
) {
    private val pi: Double = 3.14       //====== implementation
    fun circumference() =               //------ interface
        2 * pi * radius                 //====== implementation
}

//----------Overriding Members ---------
// like delegation overriding
abstract class Car01(private val acceleration: Double) {
    private var speed = 0.0
    protected open fun makeEngineSound() = println("Vrrrrrr...")  // by update to protected open
    fun accelerate() {
        speed += 1.0
        makeEngineSound()
    }
}

class Clunker01(acceleration: Double) : Car01(acceleration) {
    override fun makeEngineSound() = println("putt-putt-putt")
}

//----------Open Class ---------
open class Car10(private val acceleration: Double) {
    private var speed = 0.0
    protected open fun makeEngineSound() = println("Vrrrrrr...")  // must be open and protected
    fun accelerate() {
        speed += 1.0
        makeEngineSound()
    }
}


class Clunker10(acceleration: Double) : Car10(acceleration) {
    override fun makeEngineSound() = println("putt-putt-putt")
}

val car10 = Car10(0.7)  // can extend
val clunker10 = Clunker10(0.7)

// ----------- Getter and Setter Visibility Modifiers ---------
open class Car20(private val acceleration: Double) {
    private var speed = 0.0
    protected open fun makeEngineSound() = println("Vrrrrrr...")  // must be open and protected
    fun accelerate() {
        speed += 1.0
        makeEngineSound()
    }
}


class MuscleCar : Car10(5.0) {
    override fun makeEngineSound() = when{
        println("putt-putt-putt")
    }
}

fun main() {
    val myCar = Clunker1(0.7)
    println(myCar.speed)
    println(myCar.acceleration)
//    myCar.accelerate()
//    println(myCar.speed)


}