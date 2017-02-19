/**
  * Created by pabloren on 29/01/2017.
  */
object NumberPersonalities {
  val limit = 100

  def main(args: Array[String]): Unit = {

    for(i <- 1 to limit) {
      print(i)
      if (isPrime(i)) {
        print(" p, ")
      }
      if (isHappy(i)) {
        print("h, ")
      }
      if (isTriangular(i)) {
        print("t, ")
      }
      if (isSquare(30)) {
        print("s, ")
      }
      if (isSmug(4)) {
        print("sm, ")
      }
      if (isHonest(4)) {
        print("ht, ")
      }
      if (isPronic(4)) {
        print("pr, ")
      }
      if (isDeficient(4)) {
        print("d, ")
      }
      if (isPerfect(4)) {
        print("per, ")
      }
      if (isAbundant(4)) {
        print("ab, ")
      }
    }

  }
  def isPrime(n: Int): Boolean  = {
    for(i <- 2 to n - 1) {
      if( n % i == 0) {
        false
      }
    }
    true
  }

  def isHappy(n: Int): Boolean = {
    var number = n
    var result = 0
    var tmp = 0

    while(number > 0) {
      tmp = number % 10
      result = result + (tmp * tmp)
      number = (number / 10)
    }

    if(result == 1) {
      true
    } else if (result == 4) {
      false
    } else {
      isHappy(result)
    }

  }

  def isTriangular(n: Int): Boolean = {
    var tmp = n
    for(i <- 1 to n) {
      tmp = tmp - i
      if(tmp == 0) return true
    }
    false
  }

   def isSquare(n: Int): Boolean = {
     var result = 0
     var step = 1
     for(j <- 1 to n) {
       result += step - n
       step += 2
     }

     if(result == 0) true
     else false
   }

   def isSmug(n: Int): Boolean = {
     var result = 0
     var step = 1
     var test = true
     for(j <- 1 to n) {
       step = j * j
       result += step - n
       if(!isSquare(result)) test = false
     }
     test
   }

   def isHonest(n: Int): Boolean = {

     for(k <- 1 until n) {
       if (n / k == k || (n / k) < k) {
        return true
       }
     }
     false
   }

   def isPronic(n: Int): Boolean = {
     var result = 0
     for(j <- 1 to n) {
       result += j * (j + 1)
       if(result == n) {
         return true
       }
       result = 0
     }
     false
   }

   def isDeficient(n: Int): Boolean = {

    if(sumOfPositiveDivisorsOf(n) < n) return true
    else return false
   }

   def isPerfect(n: Int): Boolean = {

     if(sumOfPositiveDivisorsOf(n) == n) return true
     else return false
   }

   def isAbundant(n: Int): Boolean = {

     if(sumOfPositiveDivisorsOf(n) > n) return true
     else return false
   }

   def sumOfPositiveDivisorsOf(n: Int): Int = {
     var sum = 0
     for(i <- 1 to n) {
       if(n % i == 0) sum += i
     }
     sum
   }

}