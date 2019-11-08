package Character

class Roadhog (var attack: Int = 7, var defense: Int = 15, var mgattk: Int = 7, var mgdef: Int = 15, var hp: Int = 300, var maxhp: Int = 300, var mp: Int = 50, var maxmp: Int = 50, var exp: Int = 0, var maxexp: Int = 150, var lvl: Int = 1, var alive: Boolean = true){
  def exptoLevel(roadhog: Roadhog, mainplayer2: Character): Unit ={
    if (mainplayer2.alive == false) {
      this.exp += mainplayer2.maxhp
      while (this.exp >= maxexp) {
        lvl += 1
        maxexp += 150
      }
    }
  }
  def attributesGained(roadhog: Roadhog): Unit = {
    roadhog.hp = 300 + (roadhog.lvl * 5)
    roadhog.mp = 50 + (roadhog.lvl * 5)
    roadhog.maxhp = 300 + (roadhog.lvl * 5)
    roadhog.maxmp = 50 + (roadhog.lvl * 5)
    roadhog.attack = 7 + (roadhog.lvl * 3)
    roadhog.defense = 15 + (roadhog.lvl * 2)
    roadhog.mgattk = 7 + (roadhog.lvl * 3)
    roadhog.mgdef = 15 + (roadhog.lvl * 2)
  }
  def takeDamage(Dmg: Int): Unit = {
    hp -= Dmg
    if (hp <= 0) alive = false
  }
  def hookSling(roadhog: Roadhog): Unit = {
    var wholehog: Int = roadhog.mgattk - mgdef
    roadhog.mp -= 5
    if (roadhog.mp == 0) {
      wholehog = 0
    }
    takeDamage(wholehog)
  }
  /*abstract def battleOptions(roadhog: Roadhog): List[String] = {
    var movelist: List[String] = List("Whole Hog", "Take a Breather", "Scrap Shot")
    if (lvl >= 6){

      roadhog
    }


  }
  abstract def takeAction(action: String, hanzo: Hanzo): Unit = {

  }*/
}
