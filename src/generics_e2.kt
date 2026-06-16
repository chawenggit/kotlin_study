package generics_e2

/*
    video "The Complete Android & Kotlin Development Course" /2. Generics Upper Bounds
 */
//---------- Intro ------------------------------------
open class Player(val name: String)
class FootballPlayer(name: String) : Player(name)
class BaseballPlayer(name: String) : Player(name)
open class GamePlayer(name: String) : Player(name)
class CounterStrikePlayer(name: String) : GamePlayer(name)

class Team<T: Player>(val teamName: String, val players: MutableList<T>) {
    fun addPlayer(player: T) {
        if (!players.contains(player)) {
            players.add(player)
            println("${player.name} is added to $teamName")
        } else {
            println("${player.name} is already in $teamName")
        }
    }
}

fun main1() {
    val footballPlayer1 = FootballPlayer("FOOTBALL player 1")
    val footballPlayer2 = FootballPlayer("FOOTBALL player 2")

    val baseballPlayer1 = BaseballPlayer("BASEBALL player 1")
    val baseballPlayer2 = BaseballPlayer("BASEBALL player 2")

    val teamFootball = Team("LIVER POOL", mutableListOf(footballPlayer1))
//    footballTeam.addPlayer(footballPlayer2)

    val teamBaseball = Team("BASEBALL TEAM", mutableListOf(baseballPlayer2))
//    baseballTeam.addPlayer(baseballPlayer1)

    val teamFootballP = Team<Player>("FOOTBALL TEAM_P", mutableListOf())
    teamFootballP.addPlayer(footballPlayer1)

}

fun main() {
    main1()

}