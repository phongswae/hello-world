package OverworldView
import javafx.scene.input.KeyEvent
import play.api.libs.json.{JsValue, Json}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.image.Image
import scalafx.scene.layout.VBox
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Rectangle, Shape}
object Map extends JFXApp{
  var lastUpdateTime: Long = System.nanoTime()
  val kms: JsValue = Json.arr(Json.obj("type" -> "", "passable" -> true), Json.obj("type" -> "", "passable" -> true), Json.obj("type" -> "", "passable" -> false), Json.obj("type" -> "", "passable" -> true), Json.obj("type" -> "", "passable" -> true), Json.obj("type" -> "", "passable" -> true), Json.obj("type" -> "", "passable" -> true), Json.obj("type" -> "", "passable" -> true), Json.obj("type" -> "", "passable" -> true), Json.obj("type" -> "", "passable" -> true))
  val obtain1: JsValue = Json.obj(
    "mapSize" -> Json.obj("width" -> 500, "height" -> 500),
    "tiles" -> Json.arr(kms, kms, kms, kms, kms, kms, kms, kms, kms, kms)
  )
  val conversion: String = Json.stringify(obtain1)
  val parsed: JsValue = Json.parse(conversion)
  val skyhigh: String = obtain1("mapSize")("height").toString()
  val neoskyhigh: Int = skyhigh.toInt
  val earthbound: String = obtain1("mapSize")("width").toString()
  val neoearthbound: Int = earthbound.toInt

  /*val rect: Shape = new Rectangle{translateX = parsed2("playerParty")("location")("x").toString().toDouble
  translateY = parsed2("playerParty")("location")("y").toString().toDouble
  fill = Color.Blue}*/


  //println(parsed("tiles")(0)(9)("passable"))

  val paintedSkin: Canvas = new Canvas(500, 500)
  paintedSkin.getGraphicsContext2D.fillRect(50, 50, 50, 50)
  val caveaf: Image = new Image("https://vignette.wikia.nocookie.net/nintendo/images/0/04/Granite_Cave_%28Steven_Stone%27s_Room%29.png/revision/latest?cb=20120818145005&path-prefix=en")
  val rocklee: Image = new Image("https://opengameart.org/sites/default/files/stone2.jpg")
  val pikachu: Image = new Image("https://tr.rbxcdn.com/5d0fea705b36273eb62c9e98b9b82e20/420/420/Decal/Png")
  //val pikachuxy: ImageView = new ImageView(pikachu)
  //val together: Group = new Group(paintedSkin, pikachuxy)
   paintedSkin.getGraphicsContext2D.drawImage(caveaf, 0, 0, 500, 500)
 /* pikachuxy.setX(0)
  pikachuxy.setY(10)
  pikachuxy.setFitHeight(35)
  pikachuxy.setFitWidth(35)*/
  paintedSkin.getGraphicsContext2D.drawImage(pikachu,350,350, 35,35 )
  for (i <- 0 to ((neoskyhigh / 50) - 1)) {
    for (x <- 0 to ((neoearthbound / 50) - 1)) {
      if (parsed("tiles")(i)(x)("passable").toString() == "false") {
        paintedSkin.getGraphicsContext2D.drawImage(rocklee, i * 50, x * 50, 50, 50)
      }
    }
  }
  val verticalBox: VBox = new VBox() {
    children = List(paintedSkin)
  }
  this.stage = new PrimaryStage {
    title = "CSE Game"
    scene = new Scene(500, 500) {
      content = List(verticalBox)
      //addEventHandler(KeyEvent.ANY, new WADS(rect))
    }
  }
  val update: Long => Unit = (time: Long) => {
      val dt: Double = (time - lastUpdateTime) / 1000000000.0
      lastUpdateTime = time
      // println("ghuck")
      val obtain2: JsValue = Json.obj(
        "playerParty" -> Json.obj("location"->Json.obj("x"->0, "y"->0), "level"->1, "inBattle"->false),
        "otherParties"-> Json.arr(Json.obj("location" ->Json.obj("x"->0, "y"->0), "level"->1, "inBattle"->false)))
      val conversion2: String = Json.stringify(obtain2)
      val parsed2: JsValue = Json.parse(conversion2)
      println(obtain2)
    }

  AnimationTimer(update).start()
}
