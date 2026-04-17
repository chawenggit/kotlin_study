abstract class SmartDevice (val name:String){
// Write your code here
    abstract fun turnOn()
    open fun turnOff(): Unit{
        println("parent $name is now ON.")
    }
}

class SmartLight(name: String) : SmartDevice(name) {
    override fun turnOn() {
        println("$name is now ON.")
    }

//    override fun turnOff() {
//        println("$name is now OFF.")
//    }

    fun adjustBrightness(level: Int) {
        println("Adjusting $name brightness to $level%.")
    }
}

class SmartThermostat(name: String) : SmartDevice(name) // Write your code here
{
    override fun turnOn() {
        println("$name is now ON.")
    }
    fun adjustTemperature(level: Int) {
        println("$name adj temp to $level%.")
    }
}

fun main() {
    val livingRoomLight = SmartLight("Living Room Light")
    val bedroomThermostat = SmartThermostat("Bedroom Thermostat")

    livingRoomLight.turnOn()
    // Living Room Light is now ON.
    livingRoomLight.adjustBrightness(50)
    // Adjusting Living Room Light brightness to 10%.
    livingRoomLight.turnOff()
    // Living Room Light is now OFF.

    bedroomThermostat.turnOn()
//    // Bedroom Thermostat thermostat is now heating.
    bedroomThermostat.adjustTemperature(5)
//    // Bedroom Thermostat thermostat set to 5°C.
    bedroomThermostat.turnOff()
//    // Bedroom Thermostat thermostat is now off.
}