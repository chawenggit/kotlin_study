package sealed_types_a1_intro

/*
    book Kotlin illustrated Guide
    intro
*/

enum class Size { CUP, BUCKET, BAG }
interface Request {
    val id: Int
}
class OrderRequest(override val id: Int, val size: Size) : Request
class RefundRequest(override val id: Int, val size: Size, val reason: String) : Request

object FrontDesk {
    fun receive(request: Request) {
        println("FrontDesk Handling request #${request.id}")
        when (request) {
            is OrderRequest -> IceCubeFactory.fulfillOrder(request)
            is RefundRequest -> IceCubeFactory.fulfillRefund(request)
        }
    }
}

object IceCubeFactory {
    fun fulfillOrder(order: OrderRequest) = println("IceCubeFactory order #${order.id}")
    fun fulfillRefund(refund: RefundRequest) = println("IceCubeFactory refund #${refund.id}")
}


fun main() {
    val order = OrderRequest(124, Size.CUP)
    val refund = RefundRequest(123, Size.CUP, "Don't like this")
    FrontDesk.receive(order)
    FrontDesk.receive(refund)
}