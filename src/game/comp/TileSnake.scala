package game.comp

class TileSnake(override val newValue : Int, val newtarget : Tile) extends Tile (newValue) {
	this.target = newtarget

	override def toString() : String = {
		val resVal : Object = this.value.asInstanceOf[Object]
		val resTarget : Object = this.target.getValue().asInstanceOf[Object]
		return (String.format("%3d - %-3d", resVal, resTarget))
	}
}
