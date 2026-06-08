package lamda_funRef_a1
/*  REFs
    1 book Kotlin illustrated Guide
    Lambda Syntax use { }
        val lambdaName: (InputType) -> ReturnType = { parameter -> body }
        (InputType) -> ReturnType == Function type
        { parameter -> body } == Lambda == Function Reference
    - Function type, reference
    - A function reference ::OtherFunName
    - the implicit it parameter
    - Higher-order FUN = function that get/return  fun refer
    - tailing lambda : when the last parameter is lambda function , so it can be outside of fun ()
    - Returning Function Ref
    - Lambdas with Multiple Statements : it returns from the last statement
    - Closures :: a function bundled together with its captured environment.

 */
//----------------- Lambdas with Multiple Statements : it returns from the last statement
val withFiveDollarsOff = calculateTotal(20.0) { price ->
    val result = price - 5.0
    println("Initial price: $price")
    println("Discounted price: $result")
    result
}

// --------------- Returning Function Ref -----------
/*
fun discount(couponCode: String): (Double) -> Double = when (couponCode) {
    "FIVE_BUCKS" -> ::discountFiveDollars
    "TAKE_10"-> ::discountTenPercent
    else-> ::noDiscount
}

val applyDiscount: (Double) -> Double = { it - 5.0 }
fun discountFiveDollars(price: Double): Double = price - 5.0
*/
//----------------Closures--------------------------
fun calculateTotal(initialPrice: Double, applyDiscount: (Double) -> Double): Double {
    val priceAfterDiscount = applyDiscount(initialPrice)
    val total = priceAfterDiscount * 0.7 //taxMultiplier
    return total
}

fun discount1(couponCode: String): (Double) -> Double = when (couponCode) {
    "FIVE_BUCKS" -> { price -> price - 5.0 }
    "TAKE_10"-> { price -> price * 0.9 }
    else-> { price -> price }
}
    // add more discount promotions -> issue
fun discount2(couponCode: String): (Double) -> Double = when (couponCode) {
    "FIVE_BUCKS" -> { price -> price - 5.0 }
    "NINE_BUCKS" -> { price -> price - 9.0 }
    "TAKE_10"-> { price -> price * 0.9 }
    "TAKE_15"-> { price -> price * 0.85 }
    else-> { price -> price }
}
    //--------solved by closures (the function nearby)-----
fun amountDiscount(amountOff: Double): (Double) -> Double = { price -> price - amountOff }
fun percentageDiscount(percentageOff: Double): (Double) -> Double {
    val multiplier = 1.0 - percentageOff
    return { price -> price * multiplier }
}

fun discount3(couponCode: String): (Double) -> Double = when (couponCode) {
    "FIVE_BUCKS" -> amountDiscount(5.0)
    "NINE_BUCKS" -> amountDiscount(9.0)
    "TAKE_10"-> percentageDiscount(0.10)
    "TAKE_15"-> percentageDiscount(0.15)
    else-> { price -> price }
}
val applyDiscount2 = discount3("FIVE_BUCKS")
val applyDiscount3 : (Double) -> Double = discount3("FIVE_BUCKS")
//------------------------------------------------

fun main() {

//***  a function reference ::funName
//    val applyDiscount = ::discountFiveDollars
//    println("applyDiscount =  $applyDiscount ------------LEFT = ${applyDiscount(15.5)} " )
//***  lambda
    val upperCaseString = { text: String -> text.uppercase() }
    val lenString = { text: String -> text.length }
    println(upperCaseString("hello"))
    println(lenString("hello"))
//-----------------------------
    val numbers = listOf(2, 1, 0, -2, 3, -4, 5, -6, 7)
    val positives = numbers.filter({ x -> x > 0 }) // without Int since it can infer
    val isNegative = { x: Int -> x < 0 } // need Int since it can not infer
    val negatives = numbers.filter(isNegative)
    println(positives)
    println(negatives)

//***    Trailing lambda
    val doubled = numbers.map { x -> x * 2 }
    val add2 = numbers.map({ x -> x + 2 })
    val isTripled = { x: Int -> x * 3 }
    val tripled = numbers.map(isTripled)

    println(numbers)
    println(doubled)
    println(tripled)
    println(add2)

//  Function type
//For example: (String) -> String or (Int, Int) -> Int.
    val upperCaseString_1: (String) -> String = { text -> text.uppercase() }
    println(upperCaseString_1("hello"))

    //  Return function
    fun toSeconds(time: String): (Int) -> Int = when (time) {
        "hour" -> { value -> value * 60 * 60 }
        "minute" -> { value -> value * 60 }
        "second" -> { value -> value }
        else -> { value -> value }
    }

    val timesInMinutes = listOf(2, 10, 15, 1)

    val min2sec = toSeconds("minute")
    var totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
    println("Total time is $totalTimeInSeconds secs")

    totalTimeInSeconds = timesInMinutes.map(toSeconds("second")).sum()
    println("Total time is $totalTimeInSeconds secs")

    totalTimeInSeconds = timesInMinutes.map(toSeconds("hour")).sum()
    println("Total time is $totalTimeInSeconds secs")

//    Invoke separately
    println({ text: String -> text.uppercase() }("hello invoke"))

//    Exercise 1
//      to generate list urls
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = actions.map { act -> "$prefix/$id/$act" }
    println(urls)

    //    Exercise 2n to print Hello n time
    fun repeatN(n: Int, action: () -> Unit) {
        for (x in 1..n) {
            action()
        }
    }
    repeatN(5, { println("Hello") }) // full lambda
    repeatN(5) { println("Hi") } // Tailing lambda
}