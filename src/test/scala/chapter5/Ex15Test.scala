package chapter5

import org.scalatest.FunSuite

class Ex15Test extends FunSuite {

  test("tails") {
    assert(Stream(1, 2, 3).tails.toListDeep == List(List(1, 2, 3), List(2, 3), List(3)))
  }

}
