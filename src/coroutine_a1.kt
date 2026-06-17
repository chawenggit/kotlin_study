package coroutine_a1

/*
   https://medium.com/@anandgaur2207/kotlin-coroutines-in-depth-37a5412df0e9
.
 */

import kotlinx.coroutines.*
// Simulating network data fetch with suspend function
suspend fun fetchWeatherData(city: String): String {
    delay(2000) // Simulate network delay
    return "Sunny, 24°C in $city"
}
// Main function to run the coroutine
fun main() = runBlocking {
    println("Fetching weather data...")
    val weather = fetchWeatherData("New York")
    println("Weather data: $weather")
}