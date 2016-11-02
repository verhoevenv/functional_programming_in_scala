package chapter6

import org.scalatest.FunSuite

class Ex10Test extends FunSuite {

  type MyRand[A] = State[RNG, A]

  val int: MyRand[Int] = State((rng: RNG) => rng.nextInt)

  test("unit") {
    val rng: RNG = IncrementingFrom(1)

    val (result, state): (Int, RNG) = State.unit(1)(rng)
    assert(result == 1)
    assert(state == IncrementingFrom(1))
  }

  test("map") {
    val rng: RNG = IncrementingFrom(1)

    val (result, state): (Int, RNG) = int.map(x => x + 1)(rng)
    assert(result == 1 + 1)
    assert(state == IncrementingFrom(2))
  }

  test("map2") {
    val rng: RNG = IncrementingFrom(1)

    val (result, state): (Int, RNG) = State.map2(int, int)(_ + _)(rng)
    assert(result == 1 + 2)
    assert(state == IncrementingFrom(3))
  }

  test("flatMap") {
    val rng: RNG = IncrementingFrom(1)

    val someF: MyRand[Int] = int.flatMap(n1 => if (n1 <= 1) State.unit(n1) else State.unit(-1))
    val (result1, state1) = someF(rng)
    val (result2, state2) = someF(state1)

    assert(result1 == 1)
    assert(state1 == IncrementingFrom(2))
    assert(result2 == -1)
    assert(state2 == IncrementingFrom(3))
  }

  test("sequence") {
    val rng: RNG = IncrementingFrom(1)

    val (result, state): (List[Int], RNG) = State.sequence(List(int, int, int))(rng)
    assert(result == List(1, 2, 3))
    assert(state == IncrementingFrom(4))
  }

  case class IncrementingFrom(value: Int) extends RNG {
    override def nextInt: (Int, RNG) = (value, IncrementingFrom(value + 1))
  }
}
