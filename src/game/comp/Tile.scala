package game.comp

abstract class Tile(newValue:Int) {
protected  var  value : Int = newValue
  protected var target : Tile = this

  
  def getValue():Int={
    
    return this.value
    
  }
  
  def getTarget():Int={
    return this.target.getValue()
    
  }
  override def toString():String
  
  
  
  
}
