package singleton

object ScrabbleTestThreads {
  def main(args: Array[String]) {
    // Create a new Thread created using the Runnable interface
    // Execute the code in run after 10 seconds
    val getTiles: Runnable = new GetTheTiles
    val getTilesAgain: Runnable = new GetTheTiles
    // Call for the code in the method run to execute
    new Thread(getTiles).start()
    new Thread(getTilesAgain).start()
  }
}
