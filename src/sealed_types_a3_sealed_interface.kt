package sealed_types_a3_sealed_interface

/*
    book Kotlin illustrated Guide
    Problem when add more request but forget to add to when of FrontDesk
    first solved by sealed_interface
*/

enum class Size { CUP, BUCKET, BAG }
sealed interface Request {
    val id: Int
}
class OrderRequest(override val id: Int, val size: Size) : Request
class RefundRequest(override val id: Int, val size: Size, val reason: String) : Request
class SupportRequest(override val id: Int, val text: String) : Request

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
    val order = OrderRequest(124, Size.CUP)
    val refund = RefundRequest(123, Size.CUP, "Don't like this")
    FrontDesk.receive(order)
    FrontDesk.receive(refund)
    println("-----------")
    val request = SupportRequest(789, "I can't open the bag of ice!")
    FrontDesk.receive(request)
}