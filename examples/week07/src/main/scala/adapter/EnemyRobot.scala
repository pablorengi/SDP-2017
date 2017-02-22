package adapter

// This is the Adaptee. The Adapter sends method calls
// to objects that use the EnemyAttacker interface
// to the right methods defined in EnemyRobot
import java.util.Random

class EnemyRobot {
  private[adapter] val generator: Random = new Random

  def smashWithHands() {
    val attackDamage: Int = generator.nextInt(10) + 1
    println("Enemy Robot Causes " + attackDamage + " Damage With Its Hands")
  }

  def walkForward() {
    val movement: Int = generator.nextInt(5) + 1
    println("Enemy Robot Walks Forward " + movement + " spaces")
  }

  def reactToHuman(driverName: String) {
    println("Enemy Robot Tramps on " + driverName)
  }
}
