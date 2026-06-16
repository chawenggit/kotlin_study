package generics_e2

/*
    video "The Complete Android & Kotlin Development Course" /2. Generics Upper Bounds
 */
//---------- Intro ------------------------------------
class Team<T : Player>(val teamName: String, private val players: MutableList<T>) {
    fun addPlayer(player: T) {
        if (!players.contains(player)) {
            players.add(player)                             // IN
            println("${player.name} is added to $teamName") // OUT
        } else {
            println("${player.name} is already in $teamName")
        }
    }
}
fun mainInvariance() {
    val p1 = Player("P1")
    val p2 : Player = FootballPlayer("PF1")
    val teamFootballP = Team<Player>(
        "FOOTBALL TEAM_P",
        mutableListOf<Player>(p1, p2) // this is not error since p2 is the Polymorphism property
        // if the law of invariance is error;
    )
}

class TeamOUT<T : Player>(val teamName: String, private val players: MutableList<out T>) {
    fun addPlayer(player: T) {
        if (!players.contains(player)) {
//            players.add(player)  // error because it is input parameter
            println("${player.name} is added to $teamName")
        } else {
            println("${player.name} is already in $teamName")
        }
    }
}
open class Player(val name: String)
class FootballPlayer(name: String) : Player(name)
class BaseballPlayer(name: String) : Player(name)
open class GamePlayer(name: String) : Player(name)
class CounterStrikePlayer(name: String) : GamePlayer(name)

class TeamIN<T : Player>(val teamName: String, private val players: MutableList<in T>) {
    fun addPlayer(player: T) {
        if (!players.contains(player)) {
            players.add(player)
            println("${player.name} is added to $teamName")
        } else {
            println("${player.name} is already in $teamName")
        }
    }
}

fun mainCovariance() {
    val gp1 = GamePlayer("GP1")
    val gp2 = GamePlayer("GP2")
    val csp1 = CounterStrikePlayer("GP2")
    val teamCntStrGame = TeamIN<CounterStrikePlayer>(
        "CNT STRIKE TEAM",
        mutableListOf(gp1))  // not error because of in
//    teamCntStrGame.addPlayer(gp2) // error because expect csp?
    teamCntStrGame.addPlayer(csp1) // OK
}

fun main() {
    mainCovariance()

}