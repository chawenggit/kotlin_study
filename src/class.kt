class Customer
class Contact(val id: Int, var email: String) {
    val category: String = ""
}
//You can declare properties without val or var within parentheses
// but these properties are not accessible after an instance has been created
//class header (val id: Int, var email: String)

// default value
class Contact1(val id: Int, var email: String = "example@gmail.com") {
    val category: String = "work"
}

//Member function
//Data classes

//Create instance
val contact = Contact(1, "mary@gmail.com")
fun main() {
    println(contact.email)
    println(contact.category)
    contact.email = "jane@gmail.com"
    println(contact.email)
}