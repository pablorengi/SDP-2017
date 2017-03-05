/**
  * Created by pabloren on 04/03/2017.
  */
package factory

object CreatorTest {
  var factory: Creator = new ConcreteCreator
  var prod: Product = factory.makeProduct()
}
