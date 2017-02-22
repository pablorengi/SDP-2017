package factory

import java.util.Scanner

object EnemyShipTesting extends App {
  // Create the factory object
  val shipFactory: EnemyShipFactory = new EnemyShipFactory
  val userInput: Scanner = new Scanner(System.in)
  // Enemy ship object
  var theEnemy: EnemyShip = null

  print("What type of ship? (U / R / B)")
  if (userInput.hasNextLine) {
    val typeOfShip: String = userInput.nextLine
    theEnemy = shipFactory.makeEnemyShip(typeOfShip)
    if (theEnemy != null) {
      doStuffEnemy(theEnemy)
    }
    else System.out.print("Please enter U, R, or B next time")
  }
  /*
          EnemyShip theEnemy = null;

      // Old way of creating objects
      // When we use new we are not being dynamic

      EnemyShip ufoShip = new UFOEnemyShip();

      doStuffEnemy(ufoShip);

      print("\n");

      // -----------------------------------------

      // This allows me to make the program more dynamic
      // It doesn't close the code from being modified
      // and that is bad!

      // Defines an input stream to watch: keyboard
      Scanner userInput = new Scanner(System.in);

      String enemyShipOption = "";

      print("What type of ship? (U or R)");

      if (userInput.hasNextLine()){

        enemyShipOption = userInput.nextLine();

      }

      if (enemyShipOption == "U"){

        theEnemy = new UFOEnemyShip();


      } else

      if (enemyShipOption == "R"){

        theEnemy = new RocketEnemyShip();

      } else {

        theEnemy = new BigUFOEnemyShip();

      }

      doStuffEnemy(theEnemy);

      // --------------------------------------------
      */

  // Executes methods of the super class
  def doStuffEnemy(anEnemyShip: EnemyShip) {
    anEnemyShip.displayEnemyShip()
    anEnemyShip.followHeroShip()
    anEnemyShip.enemyShipShoots()
  }
}
