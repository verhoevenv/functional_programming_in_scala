package chapter6

import chapter6.Ex7.ints
import chapter6.RNG._
import org.scalatest.FunSuite

class Ex7Test extends FunSuite {

  test("sequence") {
    val rng: RNG = IncrementingFrom(1)

    val (result, state): (List[Int], RNG) = sequence(List(int, int, int))(rng)
    assert(result == List(1, 2, 3))
    assert(state == IncrementingFrom(4))
  }


  test("ints with sequence") {
    val rng: RNG = SimpleRNG(1)

    val (resultList, _) = ints(100)(rng)

    assert(resultList.distinct.size == resultList.size)
  }

  case class IncrementingFrom(value: Int) extends RNG {
    override def nextInt: (Int, RNG) = (value, IncrementingFrom(value + 1))
  }
}
