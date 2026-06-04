package class_delegation_a3_delegate_come

/*
    Chef and Waiter have the same fun prepareEntree so next interfaces come in
    Problem interface does not help boilerplate
    solve by delegation which need 2 things
        1.Interface to delegate
        2.object to be delegated to
 */

interface KitchenService {
    fun prepareEntree(name: String): Entree?
}

class Chef : KitchenService {
    override fun prepareEntree(name: String): Entree? = when (name) {
        "Tossed Salad"
            -> Entree.TOSSED_SALAD

        "Salmon on Rice" -> Entree.SALMON_ON_RICE
        else
            -> null
    }
}

class Waiter(private val chef: Chef) : KitchenService by chef {
    // The waiter can prepare a beverage by himself...
    fun prepareBeverage(name: String): Beverage? = when (name) {
        "Water" -> Beverage.WATER
        "Soda" -> Beverage.SODA
        else -> null
    }
}

enum class Entree { TOSSED_SALAD, SALMON_ON_RICE }
enum class Beverage { WATER, SODA }


fun main() {
    val waiter = Waiter(Chef())
    val beverage = waiter.prepareBeverage("Soda")
    val entree = waiter.prepareEntree("Salmon on Rice")
    println(beverage)
    println(entree)

}