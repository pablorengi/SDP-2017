package decorator

class Spinach(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    tempPizza.getDesc + ", Spinach (7.92)"
  }

  override def getPrice: Double = tempPizza.getPrice + 7.92
}
