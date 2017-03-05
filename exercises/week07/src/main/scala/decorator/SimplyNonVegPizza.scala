package decorator

class SimplyNonVegPizza extends Pizza {

  private var description = "SimplyNonVegPizza (350)"
  private var price = 350.00

  def getDesc: String = description

  def getPrice: Double = price
}
