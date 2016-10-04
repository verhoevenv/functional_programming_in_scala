package chapter5

import org.scalatest.FunSuite

class Ex8Test extends FunSuite {

  test("constant") {
    assert(Stream.constant("BEER").take(4).toList == List("BEER", "BEER", "BEER", "BEER"))
  }

}
