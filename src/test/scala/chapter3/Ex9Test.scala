package chapter3

import chapter3.Ex9.length
import org.scalatest.FunSuite

class Ex9Test extends FunSuite {

 test("length of a list") {
    assert(length(List(1,2,3)) == 3)
  }

 test("length of Nil is 0") {
    assert(length(Nil) == 0)
  }

}
