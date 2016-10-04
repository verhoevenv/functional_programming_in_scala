package chapter5

import org.scalatest.FunSuite

class Ex11Test extends FunSuite {

  test("unfold for infinite stream") {
    assert(Stream.unfold(1)(x => Some(("A" * x, x * 2))).take(4).toList == List("A", "AA", "AAAA", "AAAAAAAA"))
  }

  test("unfold for finite stream") {
    assert(Stream.unfold(4)(x => if(x == 0) None else Some(("A" * x, x - 1))).toList == List("AAAA", "AAA", "AA", "A"))
  }

}
