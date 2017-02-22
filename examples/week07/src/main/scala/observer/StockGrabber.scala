package observer

import scala.collection.mutable.ListBuffer

// Uses the Subject interface to update all Observers
class StockGrabber() extends Subject {
  // Creates an ArrayList to hold all observers
  private var observers = new ListBuffer[Observer]
  private var ibmPrice: Double = .0
  private var aaplPrice: Double = .0
  private var googPrice: Double = .0

  override def register(newObserver: Observer) {
    // Adds a new observer to the ArrayList
    observers += newObserver
  }

  override def unregister(deleteObserver: Observer) {
    // Get the index of the observer to delete
    val observerIndex = observers.indexOf(deleteObserver)
    // Print out message (Have to increment index to match)
    System.out.println("Observer " + (observerIndex + 1) + " deleted")
    // Removes observer from the ArrayList
    observers -= deleteObserver
  }

  // Change prices for all stocks and notifies observers of changes
  def setIBMPrice(newIBMPrice: Double) {
    this.ibmPrice = newIBMPrice
    notifyObserver()
  }

  override def notifyObserver() {
    // Cycle through all observers and notifies them of
    // price changes
    for (observer <- observers) {
      observer.update(ibmPrice, aaplPrice, googPrice)
    }
  }

  def setAAPLPrice(newAAPLPrice: Double) {
    this.aaplPrice = newAAPLPrice
    notifyObserver()
  }

  def setGOOGPrice(newGOOGPrice: Double) {
    this.googPrice = newGOOGPrice
    notifyObserver()
  }
}
