package decorator

// Has a "Has a" relationship with Pizza. This is an
// Aggregation Relationship

abstract class ToppingDecorator(var tempPizza: Pizza) extends Pizza {
  // Assigns the type instance to this attribute
  // of a Pizza
  // All decorators can dynamically customize the Pizza
  // instance PlainPizza because of this

  override def getDescription = tempPizza.getDescription

  override def getCost = tempPizza.getCost
}
