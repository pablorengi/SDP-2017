package observer

import java.text.DecimalFormat

class GetTheStock(// Will hold reference to the StockGrabber object
                  var stockGrabber: Subject,
                  val newStartTime: Int, // private int startTime;
                  var stock: String,
                  var price: Double) // Store the reference to the stockGrabber object so
  extends Runnable {
  override def run() {
    var i: Int = 1
    while (i <= 20) {
      try {
        // Sleep for 2 seconds
        Thread.sleep(2000)
        // Use Thread.sleep(startTime * 1000); to
        // make sleep time variable
      }
      catch {
        case e: InterruptedException => {
          e.printStackTrace() // dumb, but it will have to do
        }
      }
      // Generates a random number between -.03 and .03
      val randNum: Double = (Math.random * (.06)) - .03

      // Change the price 
      price += randNum 

      stock match {
        case "IBM" => (stockGrabber.asInstanceOf[StockGrabber]).setIBMPrice(price)
        case "AAPL" => (stockGrabber.asInstanceOf[StockGrabber]).setAAPLPrice(price)
        case "GOOG" => (stockGrabber.asInstanceOf[StockGrabber]).setGOOGPrice(price)
        case _ =>
      }

      // Formats decimals to 2 places
      val df: DecimalFormat = new DecimalFormat("#.##")
      println(stock + ": " + df.format(price) + " " + df.format(randNum))
      println()
    }
    i += 1;
  }
}
