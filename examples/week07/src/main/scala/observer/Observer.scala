package observer

// The Observers update method is called when the Subject changes
trait Observer {
  def update(ibmPrice: Double, aaplPrice: Double, googPrice: Double)
}
