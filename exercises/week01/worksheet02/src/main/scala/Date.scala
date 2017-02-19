/**
  * Created by pabloren on 02/02/2017.
  */

trait Ord {
  def < (that: Any): Boolean
  def <=(that: Any): Boolean = (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}

class Date(y: Int, m: Int, d: Int) extends Ord {
  def year = y

  def month = m

  def day = d

  override def toString(): String = year + "-" + month + "-" + day

  override def equals(that: Any): Boolean = that.isInstanceOf[Date] && {
    val o = that.asInstanceOf[Date]
    o.day == day && o.month == month && o.year == year
  }

  def <(that: Any): Boolean = {
    if (!that.isInstanceOf[Date])
      error("cannot compare " + that + " and a Date")
    val o = that.asInstanceOf[Date]
    ( year < o.year ) ||
      ( year == o.year && ( month < o.month ||
        ( month == o.month && day < o.day ) ) )
  }

}

object Date {
  def main(args: Array[String]): Unit = {

    var firstDate = new Date(2000, 4, 8)
    var secondDate = new Date(2001, 4, 8)

    println(firstDate < secondDate)
    println(firstDate.toString())
    println(secondDate.toString())

  }
}
