package class_delegation_a3_multiple_delegates

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

interface BarService {
    fun prepareBeverage(name: String): Beverage?
}

class Bartender: BarService {
    override fun prepareBeverage(name: String): Beverage? = when (name) {
        "Water"-> Beverage.WATER
        "Soda"-> Beverage.SODA
        "Peach Tea"-> Beverage.PEACH_ICED_TEA
        "Tea-Lemonade" -> Beverage.TEA_LEMONADE
        else
            -> null
    }
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

class Waiter(
    private val chef: Chef,
    private val bartender: Bartender
) : KitchenService by chef ,BarService by bartender {
//    override fun prepareBeverage(name: String) = bartender.prepareBeverage(name)  // can be commented
}

enum class Beverage { WATER, SODA, PEACH_ICED_TEA, TEA_LEMONADE }
enum class Entree { TOSSED_SALAD, SALMON_ON_RICE }


fun main() {
    val waiter = Waiter(Chef(), Bartender())
    val beverage = waiter.prepareBeverage("Soda")
    val entree = waiter.prepareEntree("Salmon on Rice")
    println(beverage)
    println(entree)

}