package films

/**
  * Created by pabloren on 19/02/2017.
  */
case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
  def name: String = {
    firstName + " " + lastName
  }
}


object Director {

  def older(director1: Director, director2: Director): Director = {
    if(director1.yearOfBirth < director2.yearOfBirth) director1
    else director2
  }
}