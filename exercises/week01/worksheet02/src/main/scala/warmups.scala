/**
  * Created by pabloren on 29/01/2017.
  */

object warmups {
  def main(args: Array[String]): Unit = {
    var i = readLine("What's your number \n").toInt

    while(i != 0) {
      print("you have entered " + i + " the square is " + i*i)
      i = readLine("\nWhat's your number").toInt
    }

//  Use a for loop Write a program to print out the numbers 1 through 25 and,
//  for each number, print its square and its cube on the same line.
//  (You can use + to combine strings and numbers into a single string.)

    var j = 1
    while( j <= 25 ) {
      println("the square of " + j + " is " + j*j + " and it's cube is " + j*j*j)
      j += 1
    }

    isEven(6)

  }

  //    write a function named isEven that,
  //    given a single Int as a parameter,
  //    returns true if the remainder when divided by 2 is zero (the operator that gives you the remainder is %),
  //    and false otherwise. Reload the program and try calling the function with various numbers.

  def isEven(num: Int): Boolean = {
    if ((num % 2) == 0) {
      print("is even")
      true
    }
    else {
      print("is odd")
      false
    }
  }
}