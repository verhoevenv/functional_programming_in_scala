package chapter6

import chapter6.Ex7.ints
import chapter6.RNG._
import org.scalatest.FunSuite

class Ex8Test extends FunSuite {

  test("flatMap") {
    val rng: RNG = IncrementingFrom(1)

    val someF: Rand[Int] = flatMap(int)(n1 => if (n1 <= 1) unit(n1) else unit(-1))
    val (result1, state1) = someF(rng)
    val (result2, state2) = someF(state1)

    assert(result1 == 1)
    assert(state1 == IncrementingFrom(2))
    assert(result2 == -1)
    assert(state2 == IncrementingFrom(3))
  }

  test("nonNegativeLessThan") {
    var rng: RNG = SimpleRNG(1)

    for(_ <- 1 to 10000) {
      val (result, newRng) = Ex8.nonNegativeLessThan(20)(rng)
      assert(result >= 0 && result < 20)
      rng = newRng
    }

  }

  case class IncrementingFrom(value: Int) extends RNG {
    override def nextInt: (Int, RNG) = (value, IncrementingFrom(value + 1))
  }
}
