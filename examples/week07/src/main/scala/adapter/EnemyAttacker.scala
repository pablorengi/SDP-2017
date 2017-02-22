package adapter

// This is the Target Interface : This is what the client
// expects to work with. It is the adapters job to make new
// classes compatible with this one.
trait EnemyAttacker {
  def fireWeapon()

  def driveForward()

  def assignDriver(driverName: String)
}
