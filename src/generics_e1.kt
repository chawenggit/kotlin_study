package generics_e1

/*
    video "The Complete Android & Kotlin Development Course"
    /1. Generics Type Parameters and Casting
 */
//---------- Intro ------------------------------------
open class Player(val name: String)
class FootballPlayer(name: String) : Player(name)
class BaseballPlayer(name: String) : Player(name)

class Team<T>(val teamName: String, val players: MutableList<T>) {
    fun addPlayer(player: T) {
        val playerName = (player as Player).name
        if (!players.contains(player)) {
            players.add(player)
            println("$playerName is added to ${this.teamName}")
        } else {
            println("$playerName is already in ${this.teamName}")
        }
    }
}

fun main1() {
    val footballPlayer1 = FootballPlayer("FOOTBALL player 1")
    val footballPlayer2 = FootballPlayer("FOOTBALL player 2")

    val baseballPlayer1 = BaseballPlayer("BASEBALL player 1")
    val baseballPlayer2 = BaseballPlayer("BASEBALL player 2")

    val footballTeam: Team<FootballPlayer>  = Team("Liver Pool", mutableListOf())
    footballTeam.addPlayer(footballPlayer1)
    footballTeam.addPlayer(footballPlayer2)
}

fun main() {
    main1()

}