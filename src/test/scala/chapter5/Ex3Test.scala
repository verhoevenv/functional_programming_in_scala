package chapter5

import org.scalatest.FunSuite

class Ex3Test extends FunSuite {

  test("takeWhile returns all starting elements matching the predicate") {
    assert(Stream(1, 2, 3, 4, 3, 2, 1).takeWhile(_ < 3).toList == List(1, 2))
  }

  import Stream._

  test("takeWhile evaluates only once") {
    val inputStream: Stream[Int] = cons(maxOnce(1), cons(maxOnce(2), cons(never(3), empty)))
    val filteredStream: Stream[Int] = inputStream.takeWhile(_ < 2)

    assert(filteredStream.toList == List(1))
  }

  def maxOnce[A]: A => A = failAfter(1)
  def never[A]: A => A = failAfter(0)

  def failAfter[A](n: Int): A => A = {
    var amount = 0
    x => {
      amount += 1
      if(amount > n) {
        fail()
      }
      x
    }
  }
}
