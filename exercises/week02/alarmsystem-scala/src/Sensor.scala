trait Sensor {

  def isTriggered: Boolean

  def getLocation: String

  def getSensorType: String

}

trait SecuritySensor extends Sensor {
  override def getSensorType: String = "Security Sensor"
}

trait HazardSensor extends Sensor {

  override def getSensorType: String = "Hazard Sensor"

  def getBatteryPercentage: Double

}