package decorator

// Implements the Pizza interface with only the required
// methods from the interface
// Every Pizza made will start as a PlainPizza
class PlainPizza extends Pizza {
  def getDescription: String = {
    return "Thin dough"
  }

  def getCost: Double = {
    System.out.println("Cost of Dough: " + 4.00)
    return 4.00
  }
}
