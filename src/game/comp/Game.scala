package game.comp

/**
 * Kelas Game yang merepresentasikan permainan Ular Tangga
 * Merupakan bagian dari kelas Model
 * */
 
 /**
  * Constructor pertama kelas Game, parameter 2 string untuk pemain pertama dan kedua
  * */
class Game(val newp1 : String, val newp2 : String) {

	private var p1 : Player = new Player(newp1)
	private var p2 : Player = new Player(newp2)
	private var board : Board = new Board()
	private var dice : Dice = new Dice()
	private var versusComputer : Boolean = false
	private var gameOver : Boolean = false

	private var lastRoll : Int = _
	private var curPlayer : Player = _

	/**
	 * method untuk memeriksa apakah permainan telah berakhir
	 * return true jika permainan berakhir, false sebaliknya
	 */
	def isGameOver() : Boolean = {
		return this.gameOver
	}

	/**
	 *Constructor kedua dari Kelas Game, yang merepresentasikan permainan melawan komputer
	 * param 1 string merupakan nama pemain manusia
	 * */
	def this(newp1 : String) {
		this(newp1, "Bot")
		var board : Board = new Board()
		var dice : Dice = new Dice()
		var versusComputer : Boolean = true
		var gameOver : Boolean = false
	}

	/**
	 * Method yang menunjukkan permainan dimulai, seluruh pemain diset menjadi berada di posisi pertama
	 * */
	def start() : Unit = {
		p1.setPosition(board.getTile(1))
		p2.setPosition(board.getTile(1))
		curPlayer = p1
		printBoardString()
	}

	/**
	 * method yang menjalankan permainan ular tangga
	 */
	def play() : Unit = {
		lastRoll = dice roll()
		var position : Int = curPlayer.getPosition() + lastRoll
		this.curPlayer.setPosition(board.getTile(nextPosition(position)))
		printBoardString()
		end()
	}

	private def end() : Unit = {
		if (this.curPlayer.getPosition() == 100) {
			this.gameOver = true
			printWinner()
		} 
		else if (this.lastRoll != 6) {
			if (this.curPlayer == this.p1) {
				this.curPlayer = this.p2
			} 
			else {
				this.curPlayer = this.p1
			}
		}
	}

	private def printWinner() : Unit = {
		System.out.println("CONGRATULATION!!!")
		System.out.println(this.curPlayer + " is the winner!")
	}

	/**		
	 * mencetak papan permainan ular tangga		
	 */
	def printBoardString() : Unit = {
		var tiles : Array[Tile] = this.board.getBoard()
		var r : String = new String()
		for (i <- 0 to 9 by 1) {
			var puluhan : Int = i * 10
			if (i % 2 == 0) {//genap
				for (j <- 9 to 0 by -1) {
					r = " " + tiles(puluhan + j) + " |" + r
				}
			} else {//ganjil
				for (j <- 0 to 9 by 1) {
					r = " " + tiles(puluhan + j) + " |" + r
				}
			}
			r = "\n|" + r
		}
		if (this.lastRoll != 0) {
			r += "\nNow is " + this.curPlayer + "'s turn!"
			r += "\nDice Roll " + this.lastRoll
		}
		r += "\n" + p1 + "'s position : " + p1.getPosition() + "\n"
		r += p2 + "'s position : " + p2.getPosition()
		System.out.println(r)
	}

	private def nextPosition(value : Int) : Int = {
		var varVal : Int = value
		if (isOverlap(varVal)) {
			varVal = 200 - value
		}
		varVal = this.board.getTile(varVal).getTarget()
		return varVal
	}

	private def isOverlap(value : Int) : Boolean = {
		return value > 100
	}
}
