package Character
package Party


class Party (var partylist: List[Character]){
  def partySplitter(partydefeated: Party): Unit ={
    var survivorcount: Int = 0
    for (i <- partylist){
      if (i.alive){
        survivorcount += 1
      }
    }
    var expSum: Int = 0
    for (i <- partydefeated.partylist){
      expSum += i.maxhp
    }
    for (i <- partylist){
      if (i.alive){
        i.exp += expSum/survivorcount
      }
    }
  }
}
