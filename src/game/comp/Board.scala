

package game.comp
import scala.util.Random

class Board {
  
 var tiles : Array[Tile] = new Array[Tile](100)
 generateTiles(10,10)
  
 
 def getTile(value:Int):Tile={
   return this.tiles(value-1)
 }
 
 def getBoard():Array[Tile]={
   return this.tiles
 }
 
 private def generateTiles(snake:Int,ladder:Int):Unit={
   var r : Random = new Random()
   generateNormalTiles()
   generateSnakeTiles(r,snake)
   generateLadderTiles(r,ladder)
 }
 
 private  def generateNormalTiles():Unit={
   for(i<-this.tiles.length-1 to 0 by -1 ){
       this.tiles(i)= new TileNormal(i+1)
   }
 }
   private  def  generateSnakeTiles(r : Random, snake:Int):Unit={
    var initial:Int=0
    var target:Int=0
    //while(snake==0){
    for(i<-snake to 0 by -1 ){
       do {
         
         initial = r.nextInt(79)+20
       }while((!(this.tiles(initial).isInstanceOf[TileNormal])))  
       do{
         target=r.nextInt(initial-10)+1
       } while (!(this.tiles(target).isInstanceOf[TileNormal]))
     this.tiles(initial) = new TileSnake(initial+1,this.tiles(target))
    }
 }
   
   private  def generateLadderTiles(r:Random, ladder:Int ):Unit={
     var initial:Int=0
     var target:Int=0
     for(i<-ladder to 0 by -1 ){
        do{
         initial = r.nextInt(79)+1
        }while (!(this.tiles(initial).isInstanceOf[TileNormal]))
       do{
         target = r.nextInt(99-initial)+initial
       }while(!(this.tiles(target).isInstanceOf[TileNormal]))
       this.tiles(initial)= new TileLadder(initial+1, this.tiles(target))   
     }
   }
}
     
