package game.comp

/**
 * Kelas TileNormal merepresentasikan tile tanpa ladder dan snake
 * merupakan subclass dari kelas Tile
 * merupakan bagian dari kelas Model
 */

/**
 * Merupakan Constructor dari kelas TileNormal
 * param newvalue merupakan posisi tile
 */
class TileNormal(override val newValue: Int) extends Tile(newValue) {
  this.target = this
}
