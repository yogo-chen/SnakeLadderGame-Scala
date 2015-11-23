package game.comp

/**
 * Merepresentasikan Tile yang memiliki tangga
 * merupakan subclass dari kelas Tile
 * 
 * @constructor membuat objek TileLadder / tile tangga 
 * @param newValue merupakan posisi dari tileladder, dan newtarget merupakan tempat ladder dituju
 */
class TileLadder(override val newValue: Int, newtarget: Tile) extends Tile(newValue) {
  this.target = newtarget
}
