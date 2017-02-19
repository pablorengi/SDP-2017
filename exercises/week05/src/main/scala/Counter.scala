/**
  * Created by pabloren on 19/02/2017.
  */
case class Counter(count: Int) {
  def inc(input: Int = 1): Counter =  new Counter(count + input)
  def dec(input: Int = 1): Counter = new Counter(count - input)
  def adjust(adder: Adder): Counter = new Counter(adder.add(count))
}


case class Adder(amount: Int) {
  def add(in: Int): Int = in + amount
}
