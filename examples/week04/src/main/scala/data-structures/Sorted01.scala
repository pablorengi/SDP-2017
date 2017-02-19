object Sorted {

  def isSorted[A](as: Array[A], ord: (A,A) => Boolean): Boolean = {
    def loop(a: Array[A], res: Boolean): Boolean = {
      if(!res) return false
      else if (a.isEmpty) res && true
      else if (a.length == 1) res && true
      else loop(a.tail, ord(a(0), a(1)))
    }
    loop(as, true)
  }

  def main(args: Array[String]) = {
    println(isSorted(Array(2,1,6,7), (x: Int, y: Int) => (x < y)))
  }
}