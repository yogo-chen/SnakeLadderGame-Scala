package game.comp

class TileNormal( override val newValue:Int) extends Tile(newValue){
this.target=this
  
  
  override def toString(): String = {
   val res : Object = this.value.asInstanceOf[Object]
    return (String.format("%3d -    ",res))
 
}
}
