package chapter3

import chapter3.Ex18.map
import org.scalatest.FunSuite

class Ex18Test extends FunSuite {

  test("map") {
    assert(map(List(1,2,3))(_ + 2) == List(3,4,5))
  }

}
