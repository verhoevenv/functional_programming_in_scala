package chapter3

import chapter3.Ex12.reverse
import org.scalatest.FunSuite

class Ex12Test extends FunSuite {

  test("reverse") {
    assert(reverse(List(1,2,3)) == List(3,2,1))
  }

  test("reverse of Nil is Nil") {
    assert(reverse(Nil) == Nil)
  }

}
