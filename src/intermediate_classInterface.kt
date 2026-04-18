// ABSTRACT CLASSES
abstract class Product(val name: String, var price: Double) {
    // Abstract property for the product category
    abstract val category: String

    // A function that can be shared by all products
    fun productInfo(): String {
        return "Product: $name, Category: $category, Price: $price"
    }
}

class Electronic(name: String, price: Double, val warranty: Int) : Product(name, price) {
    override val category = "Electronic"
}

/* INTERFACE
Although abstract classes are great for sharing code in this way,
they are restricted because classes in Kotlin only support SINGLE INHERITANCE.
If you need to inherit from multiple sources, consider using interfaces.
*/

interface PaymentMethod {
    // Functions are inheritable by default
    fun initiatePayment(amount: Double): String {
        return "Default Processing payment of $$amount..."  // default logic
    }
}

interface PaymentType {
    val paymentType: String
}

class CreditCardPayment(val cardNumber: String, val cardHolderName: String, val expiryDate: String) : PaymentMethod,
    PaymentType {
    override fun initiatePayment(amount: Double): String {
        // Simulate processing payment with credit card
        return "Own Payment of $$amount initiated using Credit Card ending in ${cardNumber.takeLast(4)}."
    }

    override val paymentType = "CreditCardPayment"
}

/* DELEGATION
*/

interface DrawingTool {
    val color: String
    fun draw(shape: String)
    fun erase(area: String)
    fun getToolInfo(): String
}

// Without DELEGATION
class PenTool : DrawingTool {
    override val color: String = "black"

    override fun draw(shape: String) {
        println("Drawing $shape using a pen in $color")
    }

    override fun erase(area: String) {
        println("Erasing $area with pen tool")
    }

    override fun getToolInfo(): String {
        return "PenTool(color=$color)"
    }
}

class CanvasSession(val tool: DrawingTool) : DrawingTool {
    override val color: String = "blue"

    override fun draw(shape: String) {
        tool.draw(shape)
    }

    override fun erase(area: String) {
        tool.erase(area)
    }

    override fun getToolInfo(): String {
        return tool.getToolInfo()
    }
}

// With DELEGATION
class CanvasSessionDelegation(val tool: DrawingTool) : DrawingTool by tool {
    // No boilerplate code!
    override val color: String = "blue"
}

fun main() {
    // Creates an instance of the Electronic class
    val laptop = Electronic(name = "Laptop", price = 1000.0, warranty = 2)

    println(laptop.productInfo())
    // Product: Laptop, Category: Electronic, Price: 1000.0

//    INTERFACE
    val paymentMethod = CreditCardPayment("1234 5678 9012 3456", "John Doe", "12/25")
    println(paymentMethod.initiatePayment(100.0))
    // Payment of $100.0 initiated using Credit Card ending in 3456.
    println("Payment: ${paymentMethod.paymentType}")

// DELEGATION
    val penTool = PenTool()
    val canvas = CanvasSessionDelegation(penTool)
    println("${canvas.color}")
    canvas
}

//https://kotlinlang.org/docs/kotlin-tour-intermediate-classes-interfaces.html#abstract-classesnext page