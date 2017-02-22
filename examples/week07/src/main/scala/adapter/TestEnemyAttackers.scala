package adapter

object TestEnemyAttackers extends App {
  val rx7Tank = new EnemyTank
  val fredTheRobot = new EnemyRobot
  val robotAdapter: EnemyAttacker = new EnemyRobotAdapter(fredTheRobot)

  println("The Robot")
  fredTheRobot.reactToHuman("Paul")
  fredTheRobot.walkForward()
  fredTheRobot.smashWithHands()
  println()

  println("The Enemy Tank")
  rx7Tank.assignDriver("Frank")
  rx7Tank.driveForward()
  rx7Tank.fireWeapon()
  println()

  println("The Robot with Adapter")
  robotAdapter.assignDriver("Mark")
  robotAdapter.driveForward()
  robotAdapter.fireWeapon()
}
