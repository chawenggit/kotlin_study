fun main() {
//    lambda
    val upperCaseString = { text: String -> text.uppercase() }
    val lenString = { text: String -> text.length }
    println(upperCaseString("hello"))
    println(lenString("hello"))

    val numbers = listOf(2, 1, 0, -2, 3, -4, 5, -6, 7)
    val positives = numbers.filter({ x -> x > 0 }) // without Int since it can infer

    val isNegative = { x: Int -> x < 0 } // need Int since it can not infer
    val negatives = numbers.filter(isNegative)

    println(positives)
    println(negatives)

//    Trailing lambda
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