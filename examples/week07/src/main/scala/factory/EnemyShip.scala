package factory

abstract class EnemyShip {
  private val speed: Double = .0
  private val directionX: Double = .0
  private val directionY: Double = .0
  private var name: String = null
  private var amtDamage: Double = .0

  def followHeroShip() = println(getName + " is following the hero")

  def displayEnemyShip() = println(getName + " is on the screen")

  def enemyShipShoots() = println(getName + " attacks and does " + getDamage + " damage to hero")

  def getName = name

  def setName(newName: String) {
    name = newName
  }

  def getDamage = amtDamage

  def setDamage(newDamage: Double) {
    amtDamage = newDamage
  }
}
