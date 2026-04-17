interface Refundable {
    // Write your code here
    fun refund(amount: Double) {
        println("Interface Refunded $$amount")
    }
}

abstract class PaymentMethod1(val name: String) {
    // Write your code here
    fun authorize(amount: Double) {
        println("Authorize $$amount")
    }

    abstract fun processPayment(amount: Double)
}

class CreditCard(name: String) : PaymentMethod1(name), Refundable { // Write your code here
    override fun processPayment(amount: Double) {
        println("Credit card $name pay $$amount")
    }

//    override fun refund(amount: Double) {
//        println("Credit refund")
//    }
}

fun main() {
    val visa = CreditCard("Visa")

    visa.authorize(100.0)
    // Authorizing payment of $100.0.
    visa.processPayment(100.0)
    // Processing credit card payment of $100.0.
    visa.refund(50.0)
    // Refunding $50.0 to the credit card.
}