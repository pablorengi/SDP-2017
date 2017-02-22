package factory

// This is a factory thats only job is creating ships
// By encapsulating ship creation, we only have one
// place to make modifications
class EnemyShipFactory {
  // This could be used as a static method if we
  // are willing to give up subclassing it
  def makeEnemyShip(newShipType: String): EnemyShip = {
    val newShip: EnemyShip = null
    if (newShipType == "U") {
      return new UFOEnemyShip
    }
    else if (newShipType == "R") {
      return new RocketEnemyShip
    }
    else if (newShipType == "B") {
      return new BigUFOEnemyShip
    }
    else return null
  }
}
