package chapter5

import org.scalatest.FunSuite

class Ex2Test extends FunSuite {

  test("take returns the first elements of a stream") {
    assert(Stream(1, 2, 3).take(2).toList == List(1, 2))
  }

  test("take does not evaluate arguments") {
    Stream(() => fail(), () => fail()).take(1)
  }

  test("drop skips the first elements of a stream") {
    assert(Stream(1, 2, 3).drop(2).toList == List(3))
  }

  test("drop does not evaluate arguments") {
    Stream(() => fail(), () => fail()).drop(1)
  }

}
