import org.scalatest.{BeforeAndAfter, FunSuite}

/**
  * Created by pabloren on 19/02/2017.
  */
class CounterTest extends FunSuite with BeforeAndAfter{
  var counter: Counter = _
  var adder: Adder = _
  before {
    counter = new Counter(20)
    adder = new Adder(20)
  }

  test("It should add up/deduct correctly") {
    assert(counter.inc().count == 21 )
    assert(counter.dec().count == 19 )
    assert(counter.inc(5).count == 25 )
  }

  test("It should work with adders") {
    assert(counter.adjust(adder).count == 40 )
  }

}
