package chapter3

import chapter3.Ex6.init
import org.scalatest.FunSuite

class Ex6Test extends FunSuite {

 test("init") {
    assert(init(List(1,2,3,4)) == List(1,2,3))
  }

  test("init on singleton list return Nil") {
    assert(init(List(1)) == Nil)
  }

  test("init on Nil returns Nil") {
    assert(init(Nil) == Nil)
  }
}
