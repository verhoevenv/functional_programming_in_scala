package chapter6

import chapter6.RNG._

object Ex8 {
  def nonNegativeLessThan(n: Int): Rand[Int] =
    flatMap(Ex1.nonNegativeInt) {
      res => {
        val mod = res % n
        if(res + (n-1) - mod >= 0) {
          unit(mod)
        } else {
          nonNegativeLessThan(n)
        }
      }
    }

}
