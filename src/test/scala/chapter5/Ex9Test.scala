package chapter5

import org.scalatest.FunSuite

class Ex9Test extends FunSuite {

  test("from") {
    assert(Stream.from(6).take(2).toList == List(6, 7))
  }

}
