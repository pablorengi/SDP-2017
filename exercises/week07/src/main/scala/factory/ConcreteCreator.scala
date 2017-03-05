package factory

/**
  * Created by pabloren on 04/03/2017.
  */
class ConcreteCreator extends Creator{
  override def makeProduct(): Product = new ConcreteProduct
}
