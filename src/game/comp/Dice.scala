package game.comp

import scala.util.Random
/**
 * Kelas yang merepresentasikan dadu yang akan dikocok saat permainan
 * Merupakan bagian dari kelas Model
 */
class Dice {
  private var r: Random = new Random()

  /**
   * method pengocokan dadu, random dari nilai 1 sampai 6
   * return nilai dadu
   */
  def roll(): Int = {
    return r.nextInt(6) + 1
  }
}
