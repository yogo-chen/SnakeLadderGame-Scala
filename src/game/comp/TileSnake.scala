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

	
	/**
	 * method yang merepresentasikan posisi pemain awal dan akhir 
	 * */
	override def toString() : String = {
		val resVal : Object = this.value.asInstanceOf[Object]
		val resTarget : Object = this.target.getValue().asInstanceOf[Object]
		return (String.format("%3d - %-3d", resVal, resTarget))
	}
}
