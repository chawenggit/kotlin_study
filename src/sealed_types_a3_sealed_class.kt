package sealed_types_a3_sealed_class

/*
    book Kotlin illustrated Guide
    In Kotlin, a sealed class is implicitly abstract but can be instantiated
    Since interfaces can’t hold state,
    Problem when add more request but forget to add to when of FrontDesk
    first solved by sealed_class
*/

enum class Size { CUP, BUCKET, BAG }
sealed class Request {
    val id: Int = kotlin.random.Random.nextInt()
}

class OrderRequest(val size: Size) : Request()
class RefundRequest(val size: Size, val reason: String) : Request()
class SupportRequest(val text: String) : Request()

object FrontDesk {
    fun receive(request: Request) {
        println("FrontDesk Handling request #${request.id}")
        when (request) {
            is OrderRequest -> IceCubeFactory.fulfillOrder(request)
            is RefundRequest -> IceCubeFactory.fulfillRefund(request)
            is SupportRequest -> HelpDesk.handle(request)
        }
    }
}

object IceCubeFactory {
    fun fulfillOrder(order: OrderRequest) = println("IceCubeFactory order #${order.id}")
    fun fulfillRefund(refund: RefundRequest) = println("IceCubeFactory refund #${refund.id}")
}

// adding
object HelpDesk {
    fun handle(request: SupportRequest) = println("Help desk is handling ${request.id}")
}

fun main() {
    val order = OrderRequest(Size.CUP)
    val refund = RefundRequest(Size.CUP, "Don't like this")
    FrontDesk.receive(order)
    FrontDesk.receive(refund)
    println("-----------")
    val request = SupportRequest("I can't open the bag of ice!")
    FrontDesk.receive(request)
}