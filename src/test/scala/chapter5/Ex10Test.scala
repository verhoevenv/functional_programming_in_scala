package chapter5

import org.scalatest.FunSuite

class Ex10Test extends FunSuite {

  test("fibs") {
    assert(Stream.fibs.take(7).toList == List(0, 1, 1, 2, 3, 5, 8))
  }

}
