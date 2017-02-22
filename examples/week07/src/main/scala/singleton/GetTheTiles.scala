package singleton

class GetTheTiles extends Runnable {
  override def run() {
    // How you create a new instance of Singleton
    val newInstance: Singleton = Singleton.getInstance

    // Get unique id for instance object
    println("1st Instance ID: " + System.identityHashCode(newInstance))

    // Get all of the letters stored in the List
    println(newInstance.getLetterList)

    println("Player 1: " + newInstance.getTiles(7))
    println("Got Tiles")
  }
}
