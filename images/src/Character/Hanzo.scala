package Character

class Hanzo (  var attack: Int = 15, var defense: Int = 7, var mgattk: Int = 15, var mgdef: Int = 7, var hp: Int = 150, var maxhp: Int = 150, var mp: Int = 150, var maxmp: Int = 150, var exp: Int = 0, var maxexp: Int = 150, var lvl: Int = 5, var alive: Boolean = true) {
  def exptoLevel(mainplayer: Character, mainplayer2: Character): Unit ={
    if (mainplayer2.alive == false) {
      this.exp += mainplayer2.maxhp
      while (this.exp >= maxexp) {
        lvl += 1
        maxexp += 150
      }
    }
  }
  def attributesGained(hanzo: Hanzo): Unit ={
    hanzo.hp = 150 + (hanzo.lvl * 5)
    hanzo.mp = 150 + (hanzo.lvl * 5)
    hanzo.maxhp = 150 + (hanzo.lvl * 5)
    hanzo.maxmp = 150 + (hanzo.lvl * 5)
    hanzo.attack = 15 + (hanzo.lvl * 3)
    hanzo.defense = 7 + (hanzo.lvl * 2)
    hanzo.mgattk = 15 + (hanzo.lvl * 3)
    hanzo.mgdef = 7 + (hanzo.lvl * 2)
  }
  def takeDamage(Dmg: Int): Unit ={
    hp -= Dmg
    if(hp <= 0) alive = false
  }
  def arrowShot(hanzo: Hanzo): Unit ={
    var shotfired = hanzo.attack - defense
    takeDamage(shotfired)
  }
 /* abstract def battleOptions(): List[String] = {
    var movelist: List[String] = List("Whole Hog", "Take a Breather", "Scrap Shot")
    movelist
  }*/
}
