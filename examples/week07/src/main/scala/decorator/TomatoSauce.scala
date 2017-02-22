package decorator

class TomatoSauce(val newPizza: Pizza) extends ToppingDecorator(newPizza) {
  System.out.println("Adding Sauce")

  // Returns the result of calling getDescription() for
  // PlainPizza, Mozzarella and then TomatoSauce
  override def getDescription: String = {
    return tempPizza.getDescription + ", tomato sauce"
  }

  override def getCost: Double = {
    System.out.println("Cost of Sauce: " + .35)
    return tempPizza.getCost + .35
  }
}
