package game.comp

/**
 * Kelas Player yang merepresentasikan pemain di dalam SnakeLadder
 * merupakan bagian dari kelas Model
 * */
 
 /**
  * Constructor dari kelas Player
  * param newname merupakan nama pemain
  * */
class Player(val newname : String) {
	protected var name : String = newname //nama pemain
	protected var position : Tile = _//posisi pemain

	/**
	 * Method yang berfungsi untuk mengeset posisi pemain
	 * */
	def setPosition(tile : Tile) : Unit = {
		this.position = tile
	}

	/**
	 * Method yang berfungsi untuk mendapatkan posisi pemain
	 * return posisi pemain
	 * */
	def getPosition() : Int = {
		return this.position.getValue()
	}

	/**
	 * Method yang berfungsi mendapatkan nama pemain
	 * return nama pemain
	 * */
	def getName() : String = {
		return this.name
	}
	
	/**
	 * Method yang berfungsi mendapatkan nama pemain
	 * return nama pemain
	 * */
	override def toString() : String = {
		return this.name
	}
}
