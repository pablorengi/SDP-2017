package observer

// This interface handles adding, deleting and updating all observers
trait Subject {
  def register(o: Observer)

  def unregister(o: Observer)

  def notifyObserver
}
