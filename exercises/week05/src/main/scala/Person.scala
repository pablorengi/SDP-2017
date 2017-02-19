/**
  * Created by pabloren on 19/02/2017.
  */
case class Person(first: String, last: String) {
}

object Person extends App{
  def apply(wholeName: String): Person = {
    val parts = wholeName.split(" ")
    new Person(parts(0), parts(1))
  }
  print(Person("John Smith"))
}


