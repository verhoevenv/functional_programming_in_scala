package chapter6

import chapter6.Ex3._
import org.scalatest.FunSuite

class Ex3Test extends FunSuite {

  test("intDouble") {
    val rng: RNG = SimpleRNG(1)

    val ((intResult, doubleResult), _) = intDouble(rng)

    assert(doubleResult >= 0 && doubleResult < 1)
  }

  test("doubleInt") {
    val rng: RNG = SimpleRNG(1)

    val ((doubleResult, intResult), _) = doubleInt(rng)

    assert(doubleResult >= 0 && doubleResult < 1)
  }

  test("double3") {
    val rng: RNG = SimpleRNG(1)

    val ((d1, d2, d3), _) = double3(rng)

    assert(d1 >= 0 && d1 < 1)
    assert(d2 >= 0 && d2 < 1)
    assert(d3 >= 0 && d3 < 1)
    assert(d1 != d2 && d2 != d3 && d1 != d3)
  }



}
