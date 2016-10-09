package chapter5

import org.scalatest.FunSuite

class Ex16Test extends FunSuite {

  test("scanRight") {
    assert(Stream(1, 2, 3).scanRight(0)(_ + _).toList == List(6, 5, 3, 0))
  }

}
