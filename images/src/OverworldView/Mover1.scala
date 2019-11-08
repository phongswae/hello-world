package OverworldView

import javafx.event.EventHandler
import javafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.shape.Shape

abstract class Mover2(player: Shape) extends EventHandler[KeyEvent]{

  val LEFT: String
  val RIGHT: String
  val UP: String
  val DOWN: String

  override def handle(event: KeyEvent): Unit = {
    val keyCode = event.getCode
    event.getEventType.getName match {
      case "KEY_RELEASED" => keyCode.getName match {
        case this.LEFT => player.translateX
        case this.RIGHT => player.translateX
        case this.UP => player.translateY
        case this.DOWN => player.translateY
        case _ =>
      }
      case "KEY_PRESSED" => keyCode.getName match {
        case this.LEFT => player.translateX.value + 0.1111
        case this.RIGHT => player.translateX.value + 0.1111
        case this.UP => player.translateY.value + 0.1111
        case this.DOWN => player.translateY.value + 0.1111
        case _ =>
      }
      case _ =>
    }
  }
}
