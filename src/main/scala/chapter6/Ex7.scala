package chapter6

import chapter6.RNG._

object Ex7 {
  def ints(count: Int): Rand[List[Int]] =
    sequence(List.fill(count)(int))

}
