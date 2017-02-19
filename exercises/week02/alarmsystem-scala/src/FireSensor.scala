import scala.util.Random

class FireSensor extends HazardSensor {

  var r: Random = Random
  var battery: Double = 100.0

  override def isTriggered: Boolean = {
    //5% of the time it is called, it raises an alarm
    //Drains 10% battery between each poll
    battery = battery - 10
    if((r.nextDouble() * 100) > 5.0 ) true
    else false
  }

  override def getLocation: String = null

  override def getBatteryPercentage: Double = {
    battery
  }
}
