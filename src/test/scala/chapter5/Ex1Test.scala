package chapter5

import org.scalatest.FunSuite

class Ex1Test extends FunSuite {

  test("toList converts a Stream to a List") {
    assert(Stream(1, 2, 3).toList == List(1, 2, 3))
  }


}
