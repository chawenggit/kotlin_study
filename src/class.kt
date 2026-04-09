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
data class User(val name: String, val id: Int)

val user = User("Alex", 1)
val secondUser = User("Alex", 2)
val thirdUser = User("Max", 3)

// Automatically uses toString() function so that output is easy to read
// User(name=Alex, id=1)
//Create instance
val contact = Contact(1, "mary@gmail.com")
fun main() {
    println(contact.email)
    println(contact.category)
    contact.email = "jane@gmail.com"
    println(contact.email)
//    data class
    println(user)
    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    println(user.copy())
    println(user.copy("Max"))
    println(user.copy(id = 3))

    //*** Exercise 1
    data class Employee(val name: String, var salary: Int)

    val emp = Employee("Mary", 20)
    println(emp)
    emp.salary += 10
    println(emp)
    //*** Exercise 2

    // Write your code here
// data class Name(...)
    data class City(val name: String, val country: String)
    data class Name(val firstName: String, val lastName: String)
    data class Address(val street: String, val city: City)
    data class Person(val name: Name, val address: Address, val ownsAPet: Boolean = true)

    val person = Person(
        Name("John", "Smith"),
        Address("123 Fake Street", City("Springfield", "US")),
        ownsAPet = false
    )
    println(person)
    //*** Exercise 3
}

https://kotlinlang.org/docs/kotlin-tour-classes.html#exercise-3