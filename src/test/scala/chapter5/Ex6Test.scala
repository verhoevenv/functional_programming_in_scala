package chapter5

import org.scalatest.FunSuite

class Ex6Test extends FunSuite {

  test("headOption on an empty stream returns empty option") {
    assert(Stream.empty.headOption == Option.empty)
  }

  test("headOption on a non-empty stream returns Some of head") {
    assert(Stream(1,2,3).headOption == Some(1))
  }

}
