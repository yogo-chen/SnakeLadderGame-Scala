package game

import game.comp._
import java.util.Scanner


/**
 * Kelas yang merepresentasikan text view bagi user
 * @constructor membuat objek text view permainan
 **/
class SnakeLadderTextMode {


/**
 * Method start untuk memulai permainan, dan memberikan option tipe pemain (bot atau pemain), dan memulai permainan 
 **/
  def start() {
    val in = new Scanner(System.in)
    var input = new String()
    do {
      println("ULAR TANGGA")
      println("1. Player versus Player")
      println("2. Player versus Computer")
      print("Option : ")
      input = in.nextLine().trim()
    } while (!checkOption(input));
    var game: Game = null
    if (java.lang.Integer.parseInt(input) == 1) {
      var p1: String = null
      var p2: String = null
      do {
        print("Player 1 name : ")
        p1 = in.nextLine().trim()
      } while (p1 == "");
      do {
        print("Player 2 name : ")
        p2 = in.nextLine().trim()
      } while (p2 == "");
      game = new Game(p1, p2)
    } else {
      var p1: String = null
      do {
        print("Player name : ")
        p1 = in.nextLine().trim()
      } while (p1 == "");
      game = new Game(p1)
    }
    game.start()
    while (!game.isGameOver) {
      print("\nNow is " + game.getCurPlayer + "'s turn! Press enter to play...")
      in.nextLine()
      game.play()
    }
  }


  private def checkOption(pilihan: String): Boolean = {
    var res = true
    try {
      val value = java.lang.Integer.parseInt(pilihan)
      if (value != 1 && value != 2) {
        res = false
      }
    } catch {
      case e: Exception => res = false
    }
    if (!res) {
      println("You can only choose between 1 or 2!\n")
    }
    res
  }
}
