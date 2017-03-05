package decorator

/**
  * Created by pabloren on 04/03/2017.
  */
abstract class PizzaDecorator(var tempPizza: Pizza) extends Pizza {
  override def getDesc: String = tempPizza.getDesc

  override def getPrice: Double = tempPizza.getPrice
}
