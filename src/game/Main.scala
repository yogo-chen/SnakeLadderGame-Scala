package game;

import game.comp._
import java.util.Arrays
import java.util.LinkedList

object Main {

  def main(args:Array[String]) : Unit = {
    var game : Game = new Game("Pemain")
    game.start()
    while(!game.isGameOver()){
      game.play()
    }
  }
  
}
  
  
