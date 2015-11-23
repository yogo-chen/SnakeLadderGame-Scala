package game.comp

/**
 * Merepresentasikan Tile yang memiliki ular
 * merupakan subclass dari kelas Tile
 * 
 * @constructor membuat Tile Ular / tile ular
 * @param newValue merupakan posisi dari tileladder, dan newtarget merupakan tempat ladder dituju
 */
class TileSnake(override val newValue: Int, newtarget: Tile) extends Tile(newValue) {
  this.target = newtarget
}
