// scope functions are a set of built-in functions or extension function that is used to execute a block of code in the context of an object
/*
    ex.
    val result = run
*/
fun main() {
    val x = run {
        val x = 10
        val y = 20
        x * y // return to run
    }
    println(" x run = $x")

    //LET
    fun sendNotification(recipientAddress: String): String {
        println("Yo $recipientAddress!")
        return "Notification sent!"
    }

    fun getNextAddress(): String {
        return "sebastian@jetbrains.com"
    }

    val address: String? = getNextAddress()
    address?.let { sendNotification(it) }
    /*
    ?.let only runs the block if address is not null
    it is the non-null value of address inside the block
    if address is null, it is safely skipped
    */

    // APPLY
    /*
        Key idea:
        APPLY returns its object and groups all setup code for an object in one block and removes repetitive prefixes.
        It is most useful when:
        Situation                                       Example
        Setting multiple properties                     token, timeout, retryCount
        Calling setup functions right after creation    connect(), authenticate()
        Keeping object creation and setup together      cleaner, easier to read
    */
    class Client() {
        var token: String? = null
        fun connect() = println("connected!")
        fun authenticate() = println("authenticated!")
        fun getData(): String {
            println("getting data!")
            return "Mock data"
        }
    }
    /* normal way without APPLY
        val client = Client()

        client.token = "asdf"
        client.connect()
        // connected!
        client.authenticate()
        // authenticated!
        client.getData()
        // getting data!
    */
    // WITH APPLY
    val client = Client().apply {
        token = getData()
        connect()
        authenticate()
    }
    println(client.token)

//RUN is similar to APPLY but the return value of the last line code of the block
    val client2 = Client().apply {
        token = "12345678"
    }

    val result = client2.run {
        connect()
        authenticate()
        getData()
    }

    println("result: $result")
    println("result1: ${result}")
    val result2 = "Hello".run {
        println(this) // "Hello"
        length        // returned
    } // result = 5
    println("result2: ${result2}")

//    ALSO
//    ALSO is most useful for logging/debugging without interrupting the chain:
//    ALSO is similar to APPLY but IT is used instead of THIS:
    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
    val reversedLongUppercaseMedals: List<String> =
        medals
            .map { it.uppercase() }
            .filter { it.length > 4 }
            .also { println(it) }
            .reversed()
    println(reversedLongUppercaseMedals)
    // [BRONZE, SILVER]

// WITH
// WITH is similar to RUN but you pass the object as an argument instead of calling it on the object.
    val result_with = with(client) {
        connect()
        authenticate()
        getData()  // returned
    }
    println("result_with: $result_with")


    /* RECAP SCOPE FUNCTION
FUNCTION    ACCESS to x via     RETURN value    USE case
------------------------------------------------------------
LET          it                 Lambda result   Perform null checks in your code and later perform further actions with the returned object.
APPLY        this               x               Initialize objects at the time of creation.
RUN          this               Lambda result   Initialize objects at the time of creation AND compute a result.
ALSO         it                 x               Complete additional actions before returning the object.
WITH         this               Lambda result   Call multiple functions on an object.
*/

    // Exercise1
    data class ProductInfo(val priceInDollars: Double?)

    class Product {
        fun getProductInfo(): ProductInfo? {
            return ProductInfo(100.0)
        }
    }

    fun convertToEuros(dollars: Double): Double {
        return dollars * 0.85
    }

    // Rewrite this function
    fun Product.getPriceInEuros(): Double? {
        return getProductInfo()?.priceInDollars?.let { convertToEuros(it) }
    }

    val product = Product()
    val priceInEuros = product.getPriceInEuros()

    if (priceInEuros != null) {
        println("Price in Euros: €$priceInEuros")
        // Price in Euros: €85.0
    } else {
        println("Price information is not available.")
    }

    //    Exercise2
    data class User(val id: Int, var email: String)

    // Write your code here
    fun updateEmail(user: User, newEmail: String): User = User(user.id, newEmail).apply {
        email = newEmail
    }.also { println("Updating email for user with ID: ${it.id}") }

    val user = User(1, "old_email@example.com")
    val updatedUser = updateEmail(user, "new_email@example.com")
    // Updating email for user with ID: 1

    println("Updated User: $updatedUser")
    // Updated User: User(id=1, email=new_email@example.com)

}
//https://kotlinlang.org/docs/kotlin-tour-intermediate-scope-functions.html#scope-functions-exercise-2
