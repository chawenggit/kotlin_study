interface Media {
    // Write your code here
    val title: String
    fun play()
}

class Audio(override val title: String, val composer:String) : Media {// Write your code here
    override fun play(): Unit{
        println("Playing audio: $title, composed by $composer")
    }
}

fun main() {
    val audio = Audio("Symphony No. 5", "Beethoven")
    audio.play()
    // Playing audio: Symphony No. 5, composed by Beethoven
}