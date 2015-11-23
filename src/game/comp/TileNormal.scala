package game.comp

/**
 * Kelas TileNormal merepresentasikan tile tanpa ladder dan snake
 * merupakan subclass dari kelas Tile
 * 
 * @constructor membuat objek TileNormal / tile biasa
 * @param newValue merupakan posisi tile
 */
class TileNormal(override val newValue: Int) extends Tile(newValue) {
  this.target = this
}
