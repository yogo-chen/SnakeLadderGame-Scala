package game.comp

/**
 * Kelas Game yang merepresentasikan permainan Ular Tangga
 * Merupakan bagian dari kelas Model
 *
 * Constructor pertama kelas Game, parameter 2 string untuk pemain pertama dan kedua
 */
class Game(val newp1: String, val newp2: String) {
  private var p1: Player = new Player(newp1)
  private var p2: Player = new Player(newp2)
  private var curPlayer: Player = _
  private var board: Board = new Board()
  private var dice: Dice = new Dice()

  private var versusComputer: Boolean = false
  private var gameOver: Boolean = false
  private var lastRoll: Int = _
  private var firstPosition: Int = _
  private var afterRollPosition: Int = _
  private var finalPosition: Int = _

  /**
   * Constructor kedua dari Kelas Game, yang merepresentasikan permainan melawan komputer
   * param 1 string merupakan nama pemain manusia
   */
  def this(newp1: String) {
    this(newp1, "Bot")
    this.versusComputer = true
  }

  /**
   * Method yang menunjukkan permainan dimulai, seluruh pemain diset menjadi berada di posisi pertama
   */
  def start() {
    var zero = new Tile(0) {
      override def toString(): String = return ""
    }
    this.p1.setPosition(zero)
    this.p2.setPosition(zero)
    this.curPlayer = this.p1
    printBoardString()
    printStatus()
  }

  /**
   * method yang menjalankan permainan ular tangga
   */
  def play() {
    if (this.versusComputer) {
      playPVBot()
    } else {
      playPVP()
    }
  }

  /**
   * method yang mengembalikan player sekarang
   */
  def getCurPlayer(): Player = {
    return this.curPlayer
  }

  /**
   * method untuk memeriksa apakah permainan telah berakhir
   * return true jika permainan berakhir, false sebaliknya
   */
  def isGameOver(): Boolean = {
    return this.gameOver
  }

  /**
   * mencetak papan permainan ular tangga
   */
  def printBoardString() {
    println(this.board)
  }

  private def playPVP() {
    updatePosition()
    printBoardString()
    printStatus()
    endPlay()
  }

  private def playPVBot() {
    printBoardString()
    do {
      updatePosition()
      printStatus()
      endPlay()
    } while (this.curPlayer == this.p2 && !this.gameOver);
  }

  private def endPlay() {
    if (this.curPlayer.getPosition == 100) {
      this.gameOver = true
      printWinner()
    } else if (this.lastRoll != 6) {
      this.curPlayer = if (this.curPlayer == this.p1) this.p2 else this.p1
    }
  }

  private def printStatus() {
    var r = new String()
    if (this.lastRoll != 0) {
      r += "\nDice roll " + this.lastRoll
      r += "\n" + this.curPlayer + " move from " + this.firstPosition +
        " to " +
        this.afterRollPosition
      if (this.board.getTile(this.afterRollPosition).isInstanceOf[TileLadder]) {
        r += "\nYaay, " + this.curPlayer + " found a ladder to " +
          this.finalPosition
      } else if (this.board.getTile(this.afterRollPosition).isInstanceOf[TileSnake]) {
        r += "\nAwww, " + this.curPlayer + " found a snake to " + this.finalPosition
      }
    }
    r += "\n" + this.p1 + "'s position : " + this.p1.getPosition +
      "\n"
    r += this.p2 + "'s position : " + this.p2.getPosition
    println(r)
  }

  private def printWinner() {
    println("\nCONGRATULATION!!!")
    println(this.curPlayer + " is the winner!")
  }

  private def updatePosition() {
    roll()
    setFirstPosition()
    setAfterRollPosition()
    setFinalPosition()
    setCurPlayerPosition()
  }

  private def roll() {
    this.lastRoll = this.dice.roll()
  }

  private def setFirstPosition() {
    this.firstPosition = this.curPlayer.getPosition
  }

  private def setAfterRollPosition() {
    var position = this.firstPosition + this.lastRoll
    if (position > 100) {
      position = 200 - position
    }
    this.afterRollPosition = position
  }

  private def setFinalPosition() {
    this.finalPosition = this.board.getTile(this.afterRollPosition).getTarget
  }

  private def setCurPlayerPosition() {
    this.curPlayer.setPosition(this.board.getTile(this.finalPosition))
  }
}
