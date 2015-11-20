import game.SnakeLadderTextMode
/**
 * Kelas yang merepresentasikan Tester permainan Snake and Ladder
 */
object Main {
  def main(args: Array[String]) {
    val game = new SnakeLadderTextMode()
    game.start()
  }
}
