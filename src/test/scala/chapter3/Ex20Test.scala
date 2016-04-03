package chapter3

import chapter3.Ex20.flatMap
import org.scalatest.FunSuite

class Ex20Test extends FunSuite {

  test("flatMap") {
    assert(flatMap(List(1,2,3))(i => List(i,i)) == List(1,1,2,2,3,3))
  }

}
