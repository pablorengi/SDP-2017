package decorator

// By going this route I'll have to create a new subclass
// for an infinite number of pizza.
// I'd also have to change prices in many classes
// when just 1 Pizza topping cost changes
// Inheritance is static while composition is dynamic
// Through composition I'll be able to add new functionality
// by writing new code rather than by changing current code

class ThreeCheesePizza extends Pizza {
  private var description = "Mozzarella, Fontina, Parmesan Cheese Pizza"
  private var cost = 10.50

  override def getDescription: String = description


  def setDescription(newDescription: String) {
    description = newDescription
  }

  override def getCost = cost

  def setCost(newCost: Double) {
    cost = newCost
  }
}
