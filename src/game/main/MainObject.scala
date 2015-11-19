

package game.view

import game.comp.Game
import java.util.Arrays
import java.util.LinkedList
import java.util.Scanner
import scala.util.control.Breaks._

object Main {
  def main(args: Array[String]): Unit = {
    this.start
  }
  
  def start() {
      val in = new Scanner(System.in)
      var input : String = ""
        do {
            System.out.println("ULAR TANGGA")
            System.out.println("1. Player versus Player")
            System.out.println("2. Player versus Computer")
            System.out.print("Option : ")
            input = in.nextLine()
        } while (!checkOption(input))

        var game : Game = new Game()
        if (Integer.parseInt(input) == 1) {
            System.out.print("Player 1 name : ");
            var p1 : String = in.next()
            System.out.print("Player 2 name : ");
            var p2 : String = in.next()
            game = new Game(p1,p2) 
        } else {
            System.out.print("Player name : ");
            var p1 : String = in.next()
            game = new Game(p1) 
        }

        game.start()
        in.nextLine()

        while (!game.isGameOver()) {
            System.out.print("\nNow is " + game.getCurPlayer() + "'s turn! Play [Y/n] ? ")
            if (in.nextLine().trim().equalsIgnoreCase("n")) break
            game.play();
        }
  }

  def checkOption(pilihan:String): Boolean = {
        var res = true 
        var value = 0
        try {
            value = Integer.parseInt(pilihan)
            if (value != 1 && value != 2) {
                res = false;
            }
        } catch {
          case e: Exception => res = false
        }
        if (!res) {
            System.out.println("You can only choose between 1 or 2!\n")
        }
        return res
    }
  
}
