fun main() {
//    Extension functions let you add new functions to existing classes without modifying their source code
//ref  https://claude.ai/chat/65665826-29be-4a40-9f37-e0c9e23075b1
//    Basic Syntax
//    fun ClassName.functionName(params): ReturnType {
//        // 'this' refers to the instance of ClassName
//    } // may without "{ } "

//    THE RECEIVER
//    is the OBJECT that the extension function is called on

    val readOnlyShapes = listOf("triangle", "square", "circle")
    println(readOnlyShapes.first())

    // Add bold as extension function of String Class
    fun String.bold(): String = "<b>$this</b>"
    println(readOnlyShapes.last().bold())
    println("test".bold())
    /*
        //Example 1
        class HttpClient {
            fun request(method: String, url: String, headers: Map<String, String>): HttpResponse {
                // Network code
            }
        }

        fun HttpClient.get(url: String): HttpResponse = request("GET", url, emptyMap())
        fun HttpClient.post(url: String): HttpResponse = request("POST", url, emptyMap())

        //Example 2
        class HttpClient {
            fun request(method: String, url: String, headers: Map<String, String>): HttpResponse {
                println("Requesting $method to $url with headers: $headers")
                return HttpResponse("Response from $url")
            }
        }

        fun HttpClient.get(url: String): HttpResponse = request("GET", url, emptyMap())

        val client = HttpClient()

        // Making a GET request using request() directly
        val getResponseWithMember = client.request("GET", "https://example.com", emptyMap())

        // Making a GET request using the get() extension function
        // The client instance is the receiver
        val getResponseWithExtension = client.get("https://example.com")
    */
//Exercise 1
    fun Int.isPositive(): Boolean = this > 0  // Write your code here

    println(1.isPositive())
    // true

    //Exercise2
    fun String.toLowercaseString(): String = this.lowercase() // Write your code here
    fun String.toUppercaseString(): String = this.uppercase() // Write your code here

    println("Hello World!".toLowercaseString())
    println("Hello World!".toUppercaseString())
    // hello world!


}
//https://kotlinlang.org/docs/kotlin-tour-intermediate-extension-functions.html#extension-functions-exercise-2