package decorator

class GreenOlives(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    tempPizza.getDesc + ", Green Olives (5.47)"
  }

  override def getPrice: Double = tempPizza.getPrice + 5.47
}
