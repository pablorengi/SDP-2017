import scala.util.Random

/**
  * Created by pabloren on 12/02/2017.
  */
class HeatSensor extends SecuritySensor {

  var r: Random = Random

  override def isTriggered: Boolean = {
    //5% of the time it is called, it raises an alarm
    //Drains 10% battery between each poll
    if((r.nextDouble() * 100) > 5.0 ) true
    else false
  }

  override def getLocation: String = null

}
