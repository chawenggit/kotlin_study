package sealed_types_a5_sealed_type_vs_enum_class

import kotlin.random.Random

/*
    book Kotlin illustrated Guide
    diff with Enum Class            SEALED TYPE                     ENUM CLASS
        1. For IF/WHEN check        type by using "is keyword"      value
        2. Build-in Properties      none                            many such as ordinal sequence
        3. Interation               no                              can iterate
        4. decide to use think of   limit types                     limit value {1-n}

*/

enum class Size { CUP, BUCKET, BAG }
sealed class Request {
    val id: Int = Random.nextInt()
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

enum class SchnauzerBreed { MINIATURE, STANDARD, GIANT }
fun describe(breed: SchnauzerBreed) = when (breed) {
    SchnauzerBreed.MINIATURE -> "Small"
    SchnauzerBreed.STANDARD-> "Medium"
    SchnauzerBreed.GIANT-> "Large"
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