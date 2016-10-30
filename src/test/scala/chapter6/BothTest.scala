package chapter6

import chapter6.RNG._
import chapter6.Ex5.double
import org.scalatest.FunSuite

class BothTest extends FunSuite {

  val randIntDouble: Rand[(Int, Double)] = both(int, double)
  val randDoubleInt: Rand[(Double, Int)] = both(double, int)

  test("intDouble") {
    val rng: RNG = SimpleRNG(1)

    val ((intResult, doubleResult), _) = randIntDouble(rng)

    assert(doubleResult >= 0 && doubleResult < 1)
  }

  test("doubleInt") {
    val rng: RNG = SimpleRNG(1)

    val ((doubleResult, intResult), _) = randDoubleInt(rng)

    assert(doubleResult >= 0 && doubleResult < 1)
  }

}
