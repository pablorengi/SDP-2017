package adapter

// The Adapter must provide an alternative action for
// the the methods that need to be used because
// EnemyAttacker was implemented.
// This adapter does this by containing an object
// of the same type as the Adaptee (EnemyRobot)
// All calls to EnemyAttacker methods are sent
// instead to methods used by EnemyRobot
class EnemyRobotAdapter(var theRobot: EnemyRobot) extends EnemyAttacker {
  override def fireWeapon() {
    theRobot.smashWithHands()
  }

  override def driveForward() {
    theRobot.walkForward()
  }

  override def assignDriver(driverName: String) {
    theRobot.reactToHuman(driverName)
  }
}
