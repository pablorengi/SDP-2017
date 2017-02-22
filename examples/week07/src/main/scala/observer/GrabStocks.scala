package observer

object GrabStocks extends App {
  // Create the Subject object
  // It will handle updating all observers
  // as well as deleting and adding them
  val stockGrabber: StockGrabber = new StockGrabber

  // Create an Observer that will be sent updates from Subject
  val observer1: StockObserver = new StockObserver(stockGrabber)
  stockGrabber.setIBMPrice(197.00)
  stockGrabber.setAAPLPrice(677.60)
  stockGrabber.setGOOGPrice(676.40)

  val observer2: StockObserver = new StockObserver(stockGrabber)
  stockGrabber.setIBMPrice(197.00)
  stockGrabber.setAAPLPrice(677.60)
  stockGrabber.setGOOGPrice(676.40)

  // Delete one of the observers
  stockGrabber.unregister(observer2);
  stockGrabber.setIBMPrice(197.00)
  stockGrabber.setAAPLPrice(677.60)
  stockGrabber.setGOOGPrice(676.40)

  // Create 3 threads using the Runnable interface
  // GetTheStock implements Runnable, so it doesn't waste
  // its one extendable class option
  val getIBM: Runnable = new GetTheStock(stockGrabber, 2, "IBM", 197.00)
  val getAAPL: Runnable = new GetTheStock(stockGrabber, 2, "AAPL", 677.60)
  val getGOOG: Runnable = new GetTheStock(stockGrabber, 2, "GOOG", 676.40)

  // Call for the code in run to execute
  new Thread(getIBM).start()
  new Thread(getAAPL).start()
  new Thread(getGOOG).start()
}
