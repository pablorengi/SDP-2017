package decorator

class Ham(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    tempPizza.getDesc + ", Ham (18.12)"
  }

  override def getPrice: Double = tempPizza.getPrice + 18.12
}
