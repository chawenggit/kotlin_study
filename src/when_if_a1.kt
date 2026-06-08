package when_if_a1
import kotlin.random.Random

/*
    book Kotlin illustrated Guide
    WHEN EXPRESSION
        1. ==  SWITCH CASE (in C but without break so it can not fall through)
        2. must be exhaustive
    IF EXPRESSION get the result from the last expression
    Augmented Assignments
        wattage += 12 // wattage = wattage + 12
 */
fun main() {

    val obj = "Hello"

    val result = when (obj) {
        // If obj equals "1", sets result to "one"
        "1"     -> "One"
        // If obj equals "Hello", sets result to "Greeting"
        "Hello" -> "Greeting"
        // Sets result to "Unknown" if no previous condition is satisfied
        else    -> "Unknown"
    }
    println(result)
// Greeting
    val trafficLightState = "Red" // This can be "Green", "Yellow", or "Red"

    var trafficAction = when {
        trafficLightState == "Green"  -> "Go"
        trafficLightState == "Yellow" -> "Slow down"
        trafficLightState == "Red"    -> "Stop"
        else                          -> "Malfunction"
    }

    println(trafficAction)
    // Stop
    trafficAction = when (trafficLightState) {
        "Green"  -> "Go"
        "Yellow" -> "Slow down"
        "Red"    -> "Stop"
        else     -> "Malfunction"
    }

    println(trafficAction)
    // Stop
    val firstResult = Random.nextInt(6)
    val secondResult = Random.nextInt(6)
    var res = "loose"
    if (firstResult == secondResult) {
        res = " win"
    }
    println("${firstResult}==${secondResult} = ${result}")

    val button = "A"

    println(
        when (button) {
            "A"  -> "YES"
            else -> "NO"
        }
    )
    val dice = Random.nextInt(6)
    println(
        " dice = ${dice} : ${
            when (dice) {
                1    -> "1_"
                2    -> "2_"
                3    -> "3_"
                4    -> "4_"
                5    -> "5_"
                else -> "6_"
            }
        }"
    )

    val temperature = 53
    val reaction = when {
        temperature > 60 -> "It's too hot!"
        temperature < 50 -> "It's too cold!"
        else             -> "It's just right!"
    }
    println(reaction)
    println("----------------------IF-------------------------")

    var isLightbulbOn = true
    val reaction1 =  // from the last expression
        if (isLightbulbOn) {
            isLightbulbOn = false
            "I just turned the light off."
        } else {
            isLightbulbOn = true
            "I just turned the light on."
        }
    println("$reaction1 + $isLightbulbOn ")


}