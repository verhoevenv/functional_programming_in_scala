package chapter5

import org.scalatest.FunSuite

class Ex14Test extends FunSuite {

  test("startsWith positive case") {
    assert(Stream(1, 2, 3) startsWith Stream(1, 2))
  }

  test("startsWith negative case") {
    assert(!(Stream(1, 2, 3) startsWith Stream(1, 3)))
  }

  import Stream.cons
  import Stream.empty

  test("startsWith doesn't consume more than needed, positive case") {
    assert(cons(1, cons(2, cons({fail(); 3}, empty))) startsWith Stream(1))
  }

  test("startsWith doesn't consume more than needed, negative case") {
    assert(!(cons(1, cons(2, cons({fail(); 3}, empty))) startsWith Stream(5)))
  }

}
