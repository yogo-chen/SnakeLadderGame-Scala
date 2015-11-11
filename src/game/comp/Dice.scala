

package game.comp

import java.util.Random
class Dice {
  
  private var r : Random = new Random()
  
  def roll():Int={
    return r.nextInt(6)+1
  }
  
}
