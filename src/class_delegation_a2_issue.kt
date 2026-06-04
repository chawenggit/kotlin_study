package class_delegation_a2_issue
/*
    Chef and Waiter have the same fun prepareEntree so next interfaces come in
    Problem interface does not help boilerplate
 */

interface KitchenService {
    fun prepareEntree(name: String): Entree?
}

class Chef :KitchenService {
    override fun prepareEntree(name: String): Entree? = when (name) {
        "Tossed Salad"
            -> Entree.TOSSED_SALAD
        "Salmon on Rice" -> Entree.SALMON_ON_RICE
        else
            -> null
    }
}

class Waiter(private val chef: Chef) :KitchenService {
    // The waiter can prepare a beverage by himself...
    fun prepareBeverage(name: String): Beverage? = when (name) {
        "Water" -> Beverage.WATER
        "Soda"-> Beverage.SODA
        else-> null
    }
    fun acceptPayment(money: Int) = println("Thank you for paying for your meal")
    // ... but needs the chef to prepare an entree
    override fun prepareEntree(name: String): Entree? = chef.prepareEntree(name)
}

enum class Entree { TOSSED_SALAD, SALMON_ON_RICE }
enum class Beverage { WATER, SODA }

val waiter = Waiter(Chef())
val beverage = waiter.prepareBeverage("Soda")
val entree = waiter.prepareEntree("Salmon on Rice")