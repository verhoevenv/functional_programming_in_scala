package chapter6

import chapter5.Stream
import chapter6.Ex2.double
import org.scalatest.FunSuite

class Ex2Test extends FunSuite {

  test("double generates numbers between 0 (inclusive) and 1 (exclusive)") {
    var rng: RNG = SimpleRNG(1)

    for(_ <- 1 to 10000) {
      val (result, newRng) = double(rng)
      assert(result >= 0 && result < 1)
      rng = newRng
    }
  }

  test("double generates at least 10000 different numbers") {
    val rng: RNG = SimpleRNG(1)
    val randomNumbers: List[Double] = Stream.unfold(rng){r => Some(double(r))}.take(10000).toList
    assert(randomNumbers.distinct.size == randomNumbers.size)
  }

  test("double handles Int.MinValue properly") {
    val rng: RNG = new RNG {
      override def nextInt: (Int, RNG) = (Int.MinValue, this)
    }
    val (result, _) = double(rng)
    assert(result >= 0 && result < 1)
  }

  test("double handles Int.MaxValue properly") {
    val rng: RNG = new RNG {
      override def nextInt: (Int, RNG) = (Int.MaxValue, this)
    }
    val (result, _) = double(rng)
    assert(result >= 0 && result < 1)
  }

}
