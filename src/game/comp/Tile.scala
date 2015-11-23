package game.comp

/**
 * Kelas abstrak Tile mempresentasikan kotak pada Board permainan
 * @constructor membuat sebuah tile baru dengan nomor posisi
 * @param newValue angka untuk menentukan nomor posisi
 */
abstract class Tile(val newValue: Int) {
  protected var value: Int = newValue
  protected var target: Tile = this
  
  /**
   * method getter dari atribut value
   * @return nomor posisi
   */
  def getValue(): Int = {
    return this.value
  }

  /**
   * method getter dari atribut target
   * @return nomor posisi target
   */
  def getTarget(): Int = {
    return this.target.getValue()
  }
  
  /**
   * method yang meng-Override toString
   * @return String dari atribut kelas Tile
   */
  override def toString(): String = {
    val resVal: Object = this.value.asInstanceOf[Object]
    val resTarget: Object = this.target.getValue().asInstanceOf[Object]
    if (this.target == this) {
      return (String.format("%3d-   ", resVal))
    } else {
      return (String.format("%3d-%-3d", resVal, resTarget))
    }
  }
}
