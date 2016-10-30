package chapter6

import chapter6.RNG._
import org.scalatest.FunSuite

class Ex9Test extends FunSuite {


  test("map with flatmap") {
    val rng: RNG = IncrementingFrom(1)

    val (result, state): (Int, RNG) = mapFM(int)(_ + 1)(rng)
    assert(result == 1 + 1)
    assert(state == IncrementingFrom(2))
  }

  test("map2 with flatmap") {
    val rng: RNG = IncrementingFrom(1)

    val (result, state): (Int, RNG) = map2FM(int, int)(_ + _)(rng)
    assert(result == 1 + 2)
    assert(state == IncrementingFrom(3))
  }

  case class IncrementingFrom(value: Int) extends RNG {
    override def nextInt: (Int, RNG) = (value, IncrementingFrom(value + 1))
  }
}
