package decorator

class Mozzarella(val newPizza: Pizza) extends ToppingDecorator(newPizza) {
  println("Adding Dough")
  println("Adding Moz")

  // Returns the result of calling getDescription() for
  // PlainPizza and adds " mozzarella" to it
  override def getDescription: String = tempPizza.getDescription + ", mozzarella"

  override def getCost: Double = {
    println("Cost of Moz: " + .50)
    tempPizza.getCost + .50
  }
}
