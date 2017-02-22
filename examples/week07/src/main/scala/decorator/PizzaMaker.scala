package decorator

object PizzaMaker extends App {
  // The PlainPizza object is sent to the Mozzarella constructor
  // and then to the TomatoSauce constructor
  val basicPizza: Pizza = new TomatoSauce(new Mozzarella(new PlainPizza))
  println("Ingredients: " + basicPizza.getDescription)
  println("Price: " + basicPizza.getCost)
}
