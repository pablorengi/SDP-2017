package decorator

class RomaTomatoes(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    tempPizza.getDesc + ", Roma Tomatoes (5.20)"
  }

  override def getPrice: Double = tempPizza.getPrice + 5.20
}
