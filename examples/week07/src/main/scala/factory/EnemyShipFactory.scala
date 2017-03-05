package factory

// This is a factory who's only job is creating ships
// By encapsulating ship creation, we only have one
// place to make modifications
class EnemyShipFactory {
  // This could be used as a static method if we
  // are willing to give up subclassing it
  def makeEnemyShip(newShipType: String): EnemyShip = {
    val newShip: EnemyShip = null
    if (newShipType == "U") {
      new UFOEnemyShip
    }
    else if (newShipType == "R") {
      new RocketEnemyShip
    }
    else if (newShipType == "B") {
      new BigUFOEnemyShip
    }
    else null
  }
}
