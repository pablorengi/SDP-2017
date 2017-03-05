package decorator

class SimplyVegPizza extends Pizza {

  private var description = "SimplyVegPizza (230)"
  private var price = 230.00

  def getDesc: String = description

  def getPrice: Double =  price
}
