import game.SnakeLadderTextMode
/**
 * Kelas Main yang memuat method main
 * @constructor Main object
 */
object Main {
  def main(args: Array[String]) {
    val game = new SnakeLadderTextMode()
    game.start()
  }
}
