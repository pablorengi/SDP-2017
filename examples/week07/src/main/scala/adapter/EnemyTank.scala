package adapter

// EnemyTank implements EnemyAttacker perfectly
// Our job is to make classes with different methods
// from EnemyAttacker to work with the EnemyAttacker interface
import java.util.Random

class EnemyTank extends EnemyAttacker {
  private[adapter] val generator = new Random

  override def fireWeapon() {
    val attackDamage = generator.nextInt(10) + 1
    println("Enemy Tank Does " + attackDamage + " Damage")
  }

  override def driveForward() {
    val movement = generator.nextInt(5) + 1
    println("Enemy Tank moves " + movement + " spaces")
  }

  override def assignDriver(driverName: String) {
    println(driverName + " is driving the tank")
  }
}
