package singleton

/**
  * Created by pabloren on 04/03/2017.
  */

object Singleton {
  private val instance: Singleton = new Singleton()

  def getInstance(): Singleton = instance
}

class Singleton private() {
  private[singleton] val someData: Array[String] = Array("name", "some description")
}
