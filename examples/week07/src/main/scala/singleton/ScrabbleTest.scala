package singleton

object ScrabbleTest extends App {
    // How you create a new instance of Singleton
    val newInstance = Singleton.getInstance
    // Get unique id for instance object
    println("1st Instance ID: " + System.identityHashCode(newInstance))

    // Get all of the letters stored in the List
    println(newInstance.getLetterList)

    val playerOneTiles = newInstance.getTiles(7)
    println("Player 1: " + playerOneTiles)
    println(newInstance.getLetterList)

    // Try to make another instance of Singleton
    // This doesn't work because the constructor is private
    // Singleton instanceTwo = new Singleton();
    // Try getting a new instance using getInstance
    val instanceTwo = Singleton.getInstance

    // Get unique id for the new instance object
    println("2nd Instance ID: " + System.identityHashCode(instanceTwo))

    // This returns the value of the first instance created
    println(instanceTwo.getLetterList)

    // Player 2 draws 7 tiles
    val playerTwoTiles = newInstance.getTiles(7)
    println("Player 2: " + playerTwoTiles)
}
