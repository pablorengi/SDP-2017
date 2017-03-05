package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject with Commentary{
  var commentary: String = ""
  override def subscribeObserver(observer: Observer): Unit = subscribers += observer

  override def unSubscribeObserver(observer: Observer): Unit = {
    // Get the index of the observer to delete
    val observerIndex = subscribers.indexOf(observer)
    // Print out message (Have to increment index to match)

    System.out.println("Observer " + (observerIndex + 1) + " deleted")

    subscribers -= observer
  }

  override def notifyObservers(): Unit = {
    for(subscriber <- subscribers) {
      subscriber.update(commentary)
    }
  }

  override def subjectDetails: String = title

  override def setDesc(desc: String): Unit = {
    commentary = desc
    notifyObservers()
  }
}
