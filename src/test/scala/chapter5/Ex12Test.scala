package chapter5

import org.scalatest.FunSuite

class Ex12Test extends FunSuite {

  test("fibs_unfold") {
    assert(Stream.fibs_unfold.take(7).toList == List(0, 1, 1, 2, 3, 5, 8))
  }

  test("from_unfold") {
    assert(Stream.from_unfold(6).take(2).toList == List(6, 7))
  }

  test("constant_unfold") {
    assert(Stream.constant("BEER").take(4).toList == List("BEER", "BEER", "BEER", "BEER"))
  }

  test("ones_unfold") {
    assert(Stream.ones.take(4).toList == List(1, 1, 1, 1))
  }

}
