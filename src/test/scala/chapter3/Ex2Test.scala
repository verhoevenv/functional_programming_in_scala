package chapter3

import chapter3.Ex2.tail
import org.scalatest.FunSuite

class Ex2Test extends FunSuite {

  test("The tail of a list is the list without the first element") {
    assert(tail(List(1,2,3)) == List(2,3))
  }

  test("The tail of Nil is Nil") {
    assert(tail(Nil) == Nil)
  }

  // Alternatively, the tail of Nil could be said to be ill-defined, so we could
  // -> throw an exception (which makes tail non-pure)
  // -> or search for another return value to encapsulate that error
  //
  // I presume the next chapter will talk more about this
}
