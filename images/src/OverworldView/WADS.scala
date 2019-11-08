package OverworldView

import scalafx.scene.shape.Shape

class WADS(player: Shape) extends Mover2(player) {
  override val LEFT: String = "A"
  override val RIGHT: String = "D"
  override val UP: String = "W"
  override val DOWN: String = "S"
}