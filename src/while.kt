fun main() {
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 20) {
        println("Eat cake ${cakesEaten + 1} ")
        cakesEaten += 2
        if (cakesEaten % 4 == 0) {
            break
        }
    }
    do {
        println("Bake a cake $cakesBaked")
        cakesBaked++
    } while (cakesBaked < cakesEaten)

    var pizzaSlices = 0
    while (pizzaSlices < 8) {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    }
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")

    do {
        println("There's only $pizzaSlices slice/s of pizza :(")
        pizzaSlices--
    } while (pizzaSlices > 0)


    val words = listOf("dinosaur", "limousine", "magazine", "language")
    // Write your code here
    for (word in words) {
        if (word[0] != 'l') {
            continue
        }
        println("the word with the first leter is l is $word")

    }

}