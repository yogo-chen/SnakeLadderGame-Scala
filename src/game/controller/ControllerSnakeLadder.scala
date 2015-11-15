

package game.controller
import game.view._
import game.model._

class ControllerSnakeLadder (val option:Int ){
  var opt : Int= option
  
  
  
  def getOptionGame():Unit={
    if(opt==1){
      getVersusLawan()
    }
    else {
      getVersusKomputer()    
    }
    
  }
  
 private def getVersusLawan():Unit={
    var game:Game = new Game("Pemain 1","Pemain 2")
    game.start()
    while(!game.isGameOver()){
      game.play()
    }
  }
 private def getVersusKomputer():Unit={
    var game:Game = new Game("Pemain")
    game.start()
    while(!game.isGameOver()){
      game.play()
    }
   
  }
  
  
  
  
  
}
