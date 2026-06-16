package generics_c1

/*
    book 2019 First Head Kotlin
    https://github.com/juan-sicardo/HeadFirstKotlin
 * This code is meant to illustrate the use of generics, and generic types:
 * covariant, contravariant and invariant.
    If a generic type is covariant, it means that you can use a subtype in place
    of a supertype.
 */

abstract class Pet(var name: String)
class Cat(name: String) : Pet(name)
class Dog(name: String) : Pet(name)
class Fish(name: String) : Pet(name)

class Vet<T : Pet> {
    fun treat(t: T) {
        println("Treat Pet ${t.name}")
    }
}

class Contest<T : Pet>(var vet: Vet<in T>) {
    val scores: MutableMap<T, Int> = mutableMapOf()

    fun addScore(t: T, score: Int = 0) {
        if (score >= 0) scores[t] = score
    }

    fun getWinners(): MutableSet<T> {
        val winners: MutableSet<T> = mutableSetOf()
        val highScore = scores.values.maxOrNull<Int>() ?: 0

        for ((t, score) in scores) {
            if (score == highScore) winners.add(t)
        }

        return winners
    }
}

interface Retailer<out T> {
    fun sell(): T
}

class CatRetailer : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("")
    }
}

class DogRetailer : Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell Dog")
        return Dog("")
    }
}

class FishRetailer : Retailer<Fish> {
    override fun sell(): Fish {
        println("Sell Fish")
        return Fish("")
    }
}

fun main1(args: Array<String>) {
    val catFuzz = Cat("Fuzz Lightyear")
    val catKatsu = Cat("Katsu")
    val fishFinny = Fish("Finny McGraw")

    val catVet = Vet<Cat>()
    val fishVet = Vet<Fish>()
    val petVet = Vet<Pet>()

    catVet.treat(catFuzz)
    petVet.treat(catKatsu)
    petVet.treat(fishFinny)

    val catContest = Contest<Cat>(catVet)
    catContest.addScore(catFuzz, 50)
    catContest.addScore(catKatsu, 45)
    val topCat = catContest.getWinners().first()
    println("Cat contest winner is ${topCat.name}")

    val petContest = Contest<Pet>(petVet)
    petContest.addScore(catFuzz, 50)
    petContest.addScore(fishFinny, 56)
    val topPet = petContest.getWinners().first()
    println("Pet contest winnerr is ${topPet.name}")

    val fishContest = Contest<Fish>(petVet)

    val dogRetailer: Retailer<Dog> = DogRetailer()
    val catRetailer: Retailer<Cat> = CatRetailer()
    val petRetailer: Retailer<Pet> = CatRetailer()  // must use out for type covariant
    petRetailer.sell()
}

class InClass<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}

fun main(args: Array<String>) {
    val inClassObject = InClass<Number>()
    val integ: InClass<Int> = inClassObject
    println(integ.toString(23))
}
