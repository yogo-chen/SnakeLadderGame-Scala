package game.comp

/**
 * Merepresentasikan Tile yang memiliki ular
 * merupakan subclass dari kelas Tile
 * merupakan bagian dari kelas model
 * */
 
 
 /**
  * Constructor TileSnake
  * param newValue merupakan posisi dari tileladder, dan newtarget merupakan tempat ladder dituju
  * */
class TileSnake(override val newValue : Int, val newtarget : Tile) extends Tile (newValue) {
	this.target = newtarget
}
