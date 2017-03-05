package observer

case class SMSUsers(s: Subject, msg: String) extends Observer {
  def update(desc: String): Unit = println(msg + " has received the message: " + desc)

  override def subscribe(): Unit = {
    println(msg + " is subscribing to " + s.subjectDetails + "\n")
    s.subscribeObserver(this)
  }

  def unSubscribe(): Unit = {
    println(msg + " is unsubscribing to " + s.subjectDetails +"\n")
    s.unSubscribeObserver(this)
  }
}
