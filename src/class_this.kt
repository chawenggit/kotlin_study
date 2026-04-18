// show how to use this
class Book (var title: String, var author: String) {
    fun displayInfo(){
        println("t=$title, a=$author")
    }
    fun updateInfo(title: String, author1: String){
        this.title = title
        author = author1
    }
}

fun main() {
    val book1 = Book("John", "Doe")
    book1.displayInfo()
    book1.updateInfo("John2", "Doe2")
    book1.displayInfo()
}