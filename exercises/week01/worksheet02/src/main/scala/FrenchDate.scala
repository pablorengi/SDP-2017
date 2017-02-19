/**
  * Created by pabloren on 02/02/2017.
  */
import java.util.{Date, Locale}
import java.text.DateFormat._

object FrenchDate {
  def main(args: Array[String]) {
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now)

    oncePerSecond(() =>
      println("time flies like an arrow..."))
  }
  def oncePerSecond(callback: () => Unit) {
    var timer = 0
    while (timer < 1000) {
      callback()
      Thread sleep 1000
      timer += 1
    }
  }
}