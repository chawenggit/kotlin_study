package dataClass_Destructuring_a1

/*
    book Kotlin illustrated Guide
    1 Equal Operator(==)
        1 Reference Equality (memory address)
        2 Value Equality (data)
    2 Referential Equality Operator(===)(to check if it is the same instance )
    3 hasCode = for check type uniqueness
    4 toString() = for print(object)
    5 DataClass care for Value (what's inside)

 */

//----------Use Regular Class for data ---------------------
class DollarBill_Regular(val amount: Int) {
    override fun equals(other: Any?) =
        if (other is DollarBill) amount.equals(other.amount) else false

    override fun hashCode() = amount.hashCode()
    override fun toString() = "DollarBill(amount=$amount)"
}

val bill1_reg = DollarBill_Regular(100)
val bill2_req = DollarBill_Regular(100)
fun showDataClass_reg() {
    println("isTheSameValue = ${bill1_reg == bill2_req} ")
    println("size = ${mutableSetOf(bill1_reg, bill2_req).size}") //2
    println("isTheSameObj = ${bill1_reg === bill2_req} ")
    println("hasCode = ${bill1_reg.hashCode()}")
    println("toString = $bill1_reg")
}

//----------Use DataClass ---------------------
data class DollarBill(val amount: Int)

val bill1 = DollarBill(100)
val bill2 = DollarBill(100)
fun showDataClass() {
    println("isTheSameValue = ${bill1 == bill2} ")
    println("size = ${mutableSetOf(bill1, bill2).size}") //1 due to set must have unique element
    println("isTheSameObj = ${bill1 === bill2} ")
    println("hasCode = ${bill1.hashCode()}")
    println("toString = $bill1")
}

//----------Copying Data Classes--------------------
data class Book(val title: String, var price: Int)

val book = Book("The Malt Shop Caper", 18)
fun copyDataClass() {
    println("book18 = ${book}")
    book.price = 20  // var
    println("book20 = ${book}")
    // The price just went up!
    val newBook_copyOldWay = Book(book.title, 20)    // new obj with same name
    val newBook_copy = book.copy(price = 20)    // ***** new obj with same name *****
    println("newBook = ${newBook_copyOldWay}")
    println("newBook = ${newBook_copy}")
}

fun main() {
//    showDataClass_reg()
//    showDataClass()
    copyDataClass()
}