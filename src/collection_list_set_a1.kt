package collection_list_set_a1

/*
    book Kotlin illustrated Guide
    Collection (have 2 types)
        Collection itself Type
        Element Type
    - Changing list
        Rule: Prefer val + mutableListOf over var + listOf
        when you need to add items — it's more memory efficient and the intent is clearer.
 */

fun main() {
//-------- accessing ---------
    val booksToRead = listOf(
        // MUTABLE
        "Tea with Agatha",
        "Mystery on First Avenue",
        "The Ravine of Sorrows",
        "Among the Aliens",
        "The Kingsford Manor Mystery",
    )
    for (bookName in booksToRead) println(bookName)
    // Collection type
    println(booksToRead::class.simpleName)        //Type = ArrayList
    // Element type
    println(booksToRead.first()::class.simpleName) // String
//    println(booksToRead[0]::class.simpleName) // String

//    booksToRead += "new books" // Error it is immutable
    println("last book = ${booksToRead.last()}")
//    println("booksToRead ${booksToRead.joinToString()}")

//-------- add or remove ---------
    var booksToRead1 = listOf(
        // ***** VAR  new memory created  use + / -  not .add or .substract
        // *** VAR
        "Tea with Agatha",
        "Mystery on First Avenue",
        "The Ravine of Sorrows",
        "Among the Aliens",
        "The Kingsford Manor Mystery",
    )
    booksToRead1 = booksToRead1 + "Beyond the Expanse"
    booksToRead1 = booksToRead1 - "Among the Aliens"
    println("booksToRead1 ${booksToRead1.joinToString()}")
    println("booksToRead1 get 4= ${booksToRead1.get(4)}")

//-------- List and MutableList ---------
    // convenient of handling elements faster than list
    var booksToRead2 = mutableListOf(
        // same old list is modified use .add or .substract
        // *** VAR
        "Tea with Agatha",
        "Mystery on First Avenue",
        "The Ravine of Sorrows",
        "Among the Aliens",
        "The Kingsford Manor Mystery",
    )
    booksToRead2.add("Beyond the Expanse")
    booksToRead2.remove("Among the Aliens")
    println("booksToRead2 ${booksToRead2.joinToString()} ")
    println("booksToRead2 get 2 = ${booksToRead2.get(2)} ")

//-------- Loop and Iteration ---------
    booksToRead.forEach { println(it) }
    booksToRead.forEachIndexed { index, string -> println("$index $string") }

//-------- Mapping ---------
    // use Lambda on each element
    val newListWithoutThe = booksToRead.map { title ->
        title.removePrefix("The ")
    }
    println("map = $newListWithoutThe ")

//-------- Sorting ---------
    // use Lambda on each element
    val sortedList = newListWithoutThe.sorted()
    println("sorted = $sortedList ")

// ------ Filtering Collections ----------: Including and Omitting Elements
    // --- Collection Operation Chains : since each return list
    val booksForNolan = booksToRead
        .map { title -> title.removePrefix("The ") }
        .sorted()
        .filter { title -> title.contains("Mystery") }
    println("filter = $booksForNolan ")

// ------ Sets ----------:
    val booksBySlim_RO: Set<String> = setOf(
        "The Malt Shop Caper",
        "Who is Mrs. W?",
        "At Midnight or Later",
    )
    val booksBySlim: MutableSet<String> = mutableSetOf(
        "The Malt Shop Caper",
        "Who is Mrs. W?",
        "At Midnight or Later",
    )
    booksBySlim.add("The Malt Shop Caper")
    println(booksBySlim)
// [The Malt Shop Caper, Who is Mrs. W?, At Midnight or Later]

    val bookList = listOf(
        "The Malt Shop Caper",
        "At Midnight or Later",
        "The Malt Shop Caper",
    )
    val bookSet = bookList.toSet() // bookSet has two elements
    println(bookList)
}
