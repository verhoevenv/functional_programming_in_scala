package chapter6

import chapter6.RNG._
import org.scalatest.FunSuite

class Ex6Test extends FunSuite {

  test("map2") {
    val rng: RNG = IncrementingFrom(1)

    val (result, state): (Int, RNG) = map2(int, int)(_ + _)(rng)
    assert(result == 1 + 2)
    assert(state == IncrementingFrom(3))
  }

  case class IncrementingFrom(value: Int) extends RNG {
    override def nextInt: (Int, RNG) = (value, IncrementingFrom(value + 1))
  }
}
