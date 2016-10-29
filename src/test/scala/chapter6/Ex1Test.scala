package chapter6

import chapter6.Ex1.nonNegativeInt
import org.scalatest.FunSuite

class Ex1Test extends FunSuite {

  test("nonNegativeInt is referentially transparant") {
    val rng = SimpleRNG(1)

    val (result1, _) = nonNegativeInt(rng)
    val (result2, _) = nonNegativeInt(rng)

    assert(result1 == result2)
  }


  test("nonNegativeInt returns no negative numbers when chained") {
    var rng: RNG = SimpleRNG(1)

    for(_ <- 1 to 10000) {
      val (result, newRng) = nonNegativeInt(rng)
      assert(result >= 0)
      rng = newRng
    }
  }

  test("nonNegativeInt handles Int.MinValue") {
    val rng: RNG = new RNG {
      override def nextInt: (Int, RNG) = (Int.MinValue, this)
    }

    val (result, _) = nonNegativeInt(rng)

    assert(result >= 0)
  }


}
