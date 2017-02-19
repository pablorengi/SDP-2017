object ListADT {

  // A sealed trait simply means that it can't be extended outside of
  // this file. This allows us to be certain that only the extensions
  // defined in this file exist.
  //
  // The +A notation indicates that A is a "covariant" type parameter.
  // This essentially means that if X is a subtype of Y then
  // List[X] is a subtype of List[Y]. The details of this are not
  // important at the moment.
  sealed trait List[+A]

  // A data constructor for the empty list.
  // Nothing is a subtype of all types - so, Nil can be considered
  // a List[Int], List[String], etc. which is important for our
  // definition.
  final case object Nil extends List[Nothing]

  // A data constructor for representing a non-empty list.
  final case class Cons[+A](head: A, tail: List[A]) extends List[A]

  // The list companion object.
  object List {
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x,xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0,_) => 0.0
      case Cons(x,xs) => x * product(xs)
    }

    def identity[A](xs: List[A]): List[A] = xs match {
      case _ => xs
    }

    def tail[A](xs: List[A]): List[A] = xs match {
      case Nil => throw new UnsupportedOperationException
      case Cons(x, xs) => xs
    }

    def setHead[A](xs: List[A], e: A): List[A] = xs match {
      case Nil => throw new UnsupportedOperationException
      case Cons(x, xs) => Cons(e, xs)
    }

    def apply[A](as: A*): List[A] = // public static void main(String... args) equiv in Java
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
  }

  def main(args: Array[String]): Unit = {
    var xs = List(1,2,3)
    println(xs)
    xs = List(1)
    println(xs)
    xs = List()
    println(xs)

    xs = List(1,2,3)
    println(xs + " summed is " + List.sum(xs))
    println("The identity of " + xs + " is " + List.identity(xs))
  }
}