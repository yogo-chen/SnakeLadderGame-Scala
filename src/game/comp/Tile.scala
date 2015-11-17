package game.comp

abstract class Tile(val newValue : Int) {
	protected var value : Int = newValue
	protected var target : Tile = this

	def getValue() : Int = {
		return this.value
	}

	def getTarget() : Int = {
		return this.target.getValue()
	}

	override def toString() : String = {
		val resVal : Object = this.value.asInstanceOf[Object]
		val resTarget : Object = this.target.getValue().asInstanceOf[Object]
		if(this.target == this){
			return (String.format("%3d-   ", resVall))
		} else {
			return (String.format("%3d-%-3d", resVal, resTarget))
		}
	}
}
