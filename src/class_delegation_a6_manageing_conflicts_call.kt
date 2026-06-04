package class_delegation_a6_manageing_conflicts_call

/*
    Chef and Waiter have the same fun prepareEntree so next interfaces come in
    Problem same multiple function name
    solve by delegation which need 2 things
        1.Interface to delegate
        2.object to be delegated to
 */

interface KitchenService {
    fun prepareEntree(name: String): Entree?
    fun receiveCompliment(message: String)
}

interface BarService {
    fun prepareBeverage(name: String): Beverage?
    fun receiveCompliment(message: String)
}

class Bartender : BarService {
    override fun prepareBeverage(name: String): Beverage? = when (name) {
        "Water" -> Beverage.WATER
        "Soda" -> Beverage.SODA
        "Peach Tea" -> Beverage.PEACH_ICED_TEA
        "Tea-Lemonade" -> Beverage.TEA_LEMONADE
        else
            -> null
    }

    override fun receiveCompliment(message: String) =
        println("Bartender received a compliment: $message")
}

class Chef : KitchenService {
    override fun prepareEntree(name: String): Entree? = when (name) {
        "Tossed Salad" -> Entree.TOSSED_SALAD
        "Salmon on Rice" -> Entree.SALMON_ON_RICE
        else -> null
    }

    override fun receiveCompliment(message: String) =
        println("Chef received a compliment: $message")
}

class Waiter(
    private val chef: Chef,
    private val bartender: Bartender
) : KitchenService by chef, BarService by bartender {

    fun acceptPayment(money: Int) = println("Thank you for paying for your meal")

    override fun prepareEntree(name: String): Entree? =
        if (name == "Tossed Salad") Entree.TOSSED_SALAD else chef.prepareEntree(name)

    override fun receiveCompliment(message: String) = when {
        message.contains("entree") -> chef.receiveCompliment(message)
        message.contains("beverage") -> bartender.receiveCompliment(message)
        else -> println("Waiter received compliment: $message")
    }
}

enum class Beverage { WATER, SODA, PEACH_ICED_TEA, TEA_LEMONADE }
enum class Entree { TOSSED_SALAD, SALMON_ON_RICE }


fun main() {
    val waiter = Waiter(Chef(), Bartender())
    waiter.receiveCompliment("The salmon entree was fantastic!")
    waiter.receiveCompliment("The peach tea beverage was fantastic!")
    waiter.receiveCompliment("The service was fantastic!")

}