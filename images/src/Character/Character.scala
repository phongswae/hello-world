package Character


class Character(  var attack: Int = 10, var defense: Int = 5, var mgattk: Int = 10, var mgdef: Int = 5, var hp: Int = 100, var maxhp: Int = 100, var mp: Int = 100, var maxmp: Int = 100, var exp: Int = 0, var maxexp: Int = 150, var lvl: Int = 1, var alive: Boolean = true) {

  def takeDamage(Dmg: Int): Unit ={
    hp -= Dmg
    if(hp <= 0) alive = false
  }

  def physattack(char2 : Character): Unit ={
    var hit: Int = char2.attack - defense
    takeDamage(hit)
  }

  def magattack(char2: Character): Unit ={
    var spell: Int = char2.mgattk - mgdef
    char2.mp -= 5
    if (char2.mp == 0){
      spell = 0
    }
    takeDamage(spell)
  }

  def exptoLevel(mainplayer: Character, mainplayer2: Character): Unit ={
    if (mainplayer2.alive == false) {
      this.exp += mainplayer2.maxhp
      while (this.exp >= maxexp) {
        lvl += 1
        maxexp += 150
      }
    }
  }

  def attributesGained(mainplayer: Character): Unit ={
    mainplayer.hp = 100 + (mainplayer.lvl * 5)
    mainplayer.mp = 100 + (mainplayer.lvl * 5)
    mainplayer.maxhp = 100 + (mainplayer.lvl * 5)
    mainplayer.maxmp = 100 + (mainplayer.lvl * 5)
    mainplayer.attack = 10 + (mainplayer.lvl * 3)
    mainplayer.defense = 5 + (mainplayer.lvl * 2)
    mainplayer.mgattk = 10 + (mainplayer.lvl * 3)
    mainplayer.mgdef = 5 + (mainplayer.lvl * 2)
  }
}
