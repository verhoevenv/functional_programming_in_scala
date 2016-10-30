package chapter6

import chapter6.Ex4._
import org.scalatest.FunSuite

class Ex4Test extends FunSuite {

  test("ints") {
    val rng: RNG = SimpleRNG(1)

    val (resultList, _) = ints(100)(rng)

    assert(resultList.distinct.size == resultList.size)
  }




}
