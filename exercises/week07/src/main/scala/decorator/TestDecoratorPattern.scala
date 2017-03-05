package decorator

import java.text.DecimalFormat

object TestDecoratorPattern {
  private val decimalFormat: DecimalFormat = new DecimalFormat("#.##")

  def main(args: Array[String]) {
    var pizza: Pizza = new Spinach(new GreenOlives(new RomaTomatoes(new SimplyVegPizza)))
    print(pizza)
    pizza = new Ham(new Cheese(new Cheese(new Meat(new SimplyNonVegPizza))))
    print(pizza)
  }

  private def print(pizza: Pizza) {
    System.out.println("Desc: " + pizza.getDesc)
    System.out.println("Price: " + decimalFormat.format(pizza.getPrice))
  }
}
