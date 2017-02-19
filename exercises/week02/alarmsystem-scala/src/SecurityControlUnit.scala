import scala.collection.mutable.ListBuffer

/**
  * Created by pabloren on 12/02/2017.
  */
class SecurityControlUnit(sensorsList: ListBuffer[Sensor])
  extends ControlUnit(sensorsList) {

  override def pollSensors() = {
    super.pollSensors()
  }
}
