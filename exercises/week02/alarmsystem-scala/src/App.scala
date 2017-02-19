import java.io.IOException
import java.util.{Calendar, Scanner}

import scala.collection.mutable.ListBuffer

object App {
  private val EXIT: String = "exit"
  private val POLL: String = "poll"

  @throws[IOException]
  def main(args: Array[String]) {
    var sensorsList1: ListBuffer[Sensor] = new ListBuffer[Sensor]
    sensorsList1 += new FireSensor()
    sensorsList1 += new SmokeSensor()

    var sensorsList2: ListBuffer[Sensor] = new ListBuffer[Sensor]
    sensorsList2 += new HeatSensor()
    sensorsList2 += new HeatSensor()

    val controlUnit1: ControlUnit = new ControlUnit(sensorsList1)
    val controlUnit2: SecurityControlUnit = new SecurityControlUnit(sensorsList2)

    val scanner: Scanner = new Scanner(System.in)
    var input: String = ""

    val now = Calendar.getInstance()
    val currentHour = now.get(Calendar.HOUR_OF_DAY)
    val currentMinute = now.get(Calendar.MINUTE)

    println(s"current hour is $currentHour:$currentMinute")

    while (input != EXIT) {
      println("Type \"poll\" to poll all sensors once or \"exit\" to exit")
      input = scanner.nextLine
      if (input == POLL) {
        controlUnit1.pollSensors()
        if(currentHour.toInt > 22 && currentHour.toInt < 6) {
          controlUnit2.pollSensors()
        }
      }
    }
  }
}
