

package game.controller
import game.view._
import game.model._
/**
 * Kelas Kontroller yang menghubungkan object yang berfungsi sebagai view, dan kelas Game yang berfungsi sebagai model
 **/

class ControllerSnakeLadder (val option:Int ){
  var opt : Int= option //pilihan option yang digunakan dalam permainan
  
  
  /**
   * method untuk mendapatkan hasil permainan per option, option 1 jika bermain dengan 2 player, option 2 jika bermain melawan komputer
   **/
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
