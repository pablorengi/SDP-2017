package observer

// Represents each Observer that is monitoring changes in the subject
object StockObserver {
  private var observerIDTracker: Int = 0
}

class StockObserver(// Will hold reference to the StockGrabber object
                    var stockGrabber: Subject) extends Observer {
  // Store the reference to the stockGrabber object so
  // I can make calls to its methods
  // Assign an observer ID and increment the static counter
  StockObserver.observerIDTracker += 1;
  val observerID = StockObserver.observerIDTracker
  
  // Message notifies user of new observer
  println("New Observer " + observerID)

  // Add the observer to the Subjects ArrayList
  stockGrabber.register(this)
  private var ibmPrice: Double = .0
  private var aaplPrice: Double = .0

  // Static used as a counter
  private var googPrice: Double = .0

  // Called to update all observers
  override def update(ibmPrice: Double, aaplPrice: Double, googPrice: Double) {
    this.ibmPrice = ibmPrice
    this.aaplPrice = aaplPrice
    this.googPrice = googPrice
    printThePrices()
  }

  def printThePrices() = println(observerID +
    "\nIBM: " + ibmPrice +
    "\nAAPL: " + aaplPrice +
    "\nGOOG: " + googPrice + "\n")
}


