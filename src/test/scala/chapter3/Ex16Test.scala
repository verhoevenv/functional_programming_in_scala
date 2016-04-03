package chapter3

import chapter3.Ex16.addOne
import org.scalatest.FunSuite

class Ex16Test extends FunSuite {

  test("addOne") {
    assert(addOne(List(1,2,3)) == List(2,3,4))
  }

}
