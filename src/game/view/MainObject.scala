

package game.view

import game.controller._
import java.util.Scanner

object MainObject {
  
  var sc : Scanner= new Scanner(System.in)
  var opt : Int=_
  
  
  def main(args:Array[String]) : Unit = {
   println("ULAR TANGGA")
   println()
   println("PILIH LAWAN!")
   println("1. LAWAN PLAYER")
   println("2. LAWAN KOMPUTER")
   println("Pilih")
   opt = sc.nextInt()
   getOpt()
   
  }
  
  def getOpt():Unit={
    var controller : ControllerSnakeLadder = new ControllerSnakeLadder(opt)
    controller.getOptionGame()
    
  }
}
