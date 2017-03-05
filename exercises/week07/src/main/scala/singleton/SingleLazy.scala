package singleton

/**
  * Created by pabloren on 04/03/2017.
  */

object SingleLazy {
  private lazy val instance: SingleLazy = new SingleLazy

  def getInstance(): SingleLazy = instance
}
class SingleLazy private() {
  private[singleton] val someData: Array[String] = Array("name", "some description")

}
