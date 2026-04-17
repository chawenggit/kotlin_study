//A class that has only one instance that is easily accessible is called a SINGLETON.
// Normal OBJECT
object JustOne{
    val n = 12
    fun f(x:Int) = x* this.n
    fun g() = this.n
}

object DoAuth{
    fun takeParams(username: String , pwd: String){
        println("input Auth parms = $username , password =$pwd")
    }
}

// INHERITE from Interface and or Class
interface Auth{
    fun takeParamsI(username: String , pwd: String) {
        println("Interface input auth parms = $username , password = $pwd")
    }
}

object DoAuthInHer: Auth{
    override fun takeParamsI(username: String, password: String){
        println("Heritate Interface input auth parms = $username , password = $password")
    }
    fun takeParams(username: String, password: String){
        println("not input auth parms = $username , password = $password")
    }
}

fun main() {
    println(JustOne.n)
    println(JustOne.f(4))
    DoAuth.takeParams("chaweng", "123456")
    DoAuthInHer.takeParams("chaweng", "1234")

}
//https://kotlinlang.org/docs/kotlin-tour-intermediate-objects.html#object-declarations