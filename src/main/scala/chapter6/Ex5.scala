package chapter6

import chapter6.RNG._

object Ex5 {
  def double: Rand[Double] = {
    map(int)((res: Int) => res.toDouble / Math.pow(2, 32).+(0.5))
  }
}
