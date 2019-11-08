package Character
package Party
package Hanzo
import org.scalatest._

class Test extends FunSuite {
 test("testing damage"){

    var obj1 : Character = new Character
    obj1.takeDamage( 5)
    assert(obj1.hp == 95)

    var obj2 : Character = new Character
    obj2.takeDamage(5)
    assert(obj2.alive == true )

    var obj3 : Character = new Character
    obj3.takeDamage(100)
    assert(obj3.alive == false)
  }

 test("phys attack and mag attack"){
    var me : Character = new Character

    me.physattack(me)
    assert(me.hp == 95)

    me.magattack(me)
    assert(me.hp == 90)

    me.magattack(me)
    assert(me.mp == 90)
  }

  // For EXP TESTING

  test("test exp gained"){
    var player1: Character = new Character
    var player2: Character = new Character(alive = false)
    player1.exptoLevel(player1,player2)
    assert(player1.exp == 100)
  }

  test("test level gained"){
    var player1: Character = new Character
    var player2: Character = new Character(alive = false)
    player1.exptoLevel(player1,player2)
    assert(player1.lvl == 1)
  }

  test("test for attributes increasing"){
    var player1: Character = new Character

    player1.lvl = 3
    player1.attributesGained(player1)
    assert(player1.hp == 115)
    assert(player1.mp == 115)
    assert(player1.maxhp == 115)
    assert(player1.maxmp == 115)
    assert(player1.attack == 19)
    assert(player1.defense == 11)
    assert(player1.mgattk == 19)
    assert(player1.mgdef == 11)

    player1.lvl = 6
    player1.attributesGained(player1)
    assert(player1.hp == 130)
    assert(player1.mp == 130)
    assert(player1.maxhp == 130)
    assert(player1.maxmp == 130)
    assert(player1.attack == 28)
    assert(player1.defense == 17)
    assert(player1.mgattk == 28)
    assert(player1.mgdef == 17)
  }

  test("Multiple level"){
    var player1: Character = new Character
    var player2: Character = new Character
    player2.alive = false
    player1.exp += 1500
    player1.exptoLevel(player1, player2)
    assert(player1.lvl == 11)
  }

  // Party Test Cases

  test("Party Exp Distributed"){
    var player1t1: Character = new Character
    var player2t1: Character = new Character
    var player3t1: Character = new Character
    var player4t1: Character = new Character

    var player1t2: Character = new Character
    var player2t2: Character = new Character
    var player3t2: Character = new Character
    var player4t2: Character = new Character

    player1t1.alive = false
    player2t1.alive = false
    var team1list: List [Character] = List (player1t1,player2t1,player3t1,player4t1)
    var team2list: List [Character] = List (player1t2,player2t2,player3t2,player4t2)

    var teamwinner: Party = new Party(team1list)
    var teamloser: Party = new Party(team2list)
    teamwinner.partySplitter(teamloser)
    var expSum: Int = 0
    for (i <- teamwinner.partylist) {
      expSum += i.exp
    }
    assert(expSum == 400)
    assert(player3t1.exp == 200)
    assert(player4t1.exp == 200)
  }

  ///LAB 4
 /* test("test for Hanzo's Stats"){
    var player1: Hanzo = new Hanzo

    player1.lvl = 1
    player1.attributesGained(player1)
    assert(player1.hp == 150 )
    assert(player1.mp == 150)
    assert(player1.maxhp == 150)
    assert(player1.maxmp == 150)
    assert(player1.attack == 15)
    assert(player1.defense == 7)
    assert(player1.mgattk == 15)
    assert(player1.mgdef == 7)

    player1.lvl = 5
    player1.attributesGained(player1)
    assert(player1.hp == 175)
    assert(player1.mp == 175)
    assert(player1.maxhp == 175)
    assert(player1.maxmp == 175)
    assert(player1.attack == 30)
    assert(player1.defense == 17)
    assert(player1.mgattk == 30)
    assert(player1.mgdef == 17)
  }*/
}
