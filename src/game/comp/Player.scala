

package game.comp

class Player(val newname:String) {
  protected var name  : String = newname
  protected var position :Tile=_
  
  def setPosition(tile:Tile):Unit ={
    this.position=tile
  }
  
  def getPosition():Int={
   return this.position.getValue()
}
  
  def getName():String={
    return this.name
  }
  override def toString():String={
    return this.name
  }
}
