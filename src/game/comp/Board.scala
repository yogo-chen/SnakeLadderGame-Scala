package game.comp

import scala.util.Random

/**
 * Kelas Board yang merepresentaasikan papan dalam permainan SnakeLadder
 * merupakan bagian dari kelas model
 */
class Board {
  private var tiles: Array[Tile] = new Array[Tile](100) // kotak dalam 1 papan, terdiri dari 100 kotak
  generateTiles(10, 10)

  /**
   * method untuk mendapatkan tile pada suatu posisi
   * @return tile pada posisi tertentu
   */
  def getTile(value: Int): Tile = {
    return this.tiles(value - 1)
  }

  /**
   * method yang meng-Override method toString
   * @return board dalam bentuk text mode
   */
  override def toString(): String = {
    var r = new String()
    for (i <- 0 until 10) {
      val puluhan = i * 10
      if (i % 2 == 0) {
        var j = 9
        while (j >= 0) {
          r = this.tiles(puluhan + j) + "|" + r
          j -= 1
        }
      } else {
        for (j <- 0 until 10) {
          r = this.tiles(puluhan + j) + "|" + r
        }
      }
      r = "\n|" + r
    }
    r
  }
  
  /**
   * method yang memanggil method Generate Normal Tile, Ladder Tile, dan Snake Tile
   * @param snake jumlah ular dalam board
   * @param ladder jumlah tangga dalam board
   */
  private def generateTiles(snake: Int, ladder: Int) {
    var r: Random = new Random()
    generateNormalTiles()
    generateSnakeTiles(r, snake)
    generateLadderTiles(r, ladder)
  }
  
  /**
   * method yang men-Generate Normal Tile
   */
  private def generateNormalTiles() {
    for (i <- this.tiles.length - 1 to 0 by -1) {
      this.tiles(i) = new TileNormal(i + 1)
    }
  }
  
  /**
   * method yang men-Generate Snake Tile
   */
  private def generateSnakeTiles(r: Random, snake: Int) {
    var initial: Int = 0
    var target: Int = 0
    for (i <- snake to 0 by -1) {
      do {
        initial = r.nextInt(79) + 20
      } while ((!(this.tiles(initial).isInstanceOf[TileNormal])))
      do {
        target = r.nextInt(initial - 10) + 1
      } while (!(this.tiles(target).isInstanceOf[TileNormal]))
      this.tiles(initial) = new TileSnake(initial + 1, this.tiles(target))
    }
  }
  
  /**
   * method yang men-Generate Ladder Tile
   */
  private def generateLadderTiles(r: Random, ladder: Int) {
    var initial: Int = 0
    var target: Int = 0
    for (i <- ladder to 0 by -1) {
      do {
        initial = r.nextInt(79) + 1
      } while (!(this.tiles(initial).isInstanceOf[TileNormal]))
      do {
        target = r.nextInt(99 - initial) + initial
      } while (!(this.tiles(target).isInstanceOf[TileNormal]))
      this.tiles(initial) = new TileLadder(initial + 1, this.tiles(target))
    }
  }
}
