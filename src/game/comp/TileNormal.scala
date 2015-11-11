package game.comp

class TileNormal(override val value:Int) extends Tile(value){
this.target=this
  
  
  override def toString(): String = {
   val res : Object = this.value.asInstanceOf[Object]
    return (String.format("%3d -    ",res))
  }
}
