package decorator

class Cheese(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    tempPizza.getDesc + ", Cheese (20.72)"
  }

  override def getPrice: Double = tempPizza.getPrice + 20.72
}
