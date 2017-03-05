package decorator

class Meat(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    tempPizza.getDesc + ", Meat (14.25)"
  }

  override def getPrice: Double = tempPizza.getPrice + 14.25
}
