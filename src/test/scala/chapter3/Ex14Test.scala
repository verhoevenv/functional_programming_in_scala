package chapter3

import chapter3.Ex14.append
import org.scalatest.FunSuite

class Ex14Test extends FunSuite {

  test("append") {
    assert(append(List(1,2,3), List(3,2,37)) == List(1,2,3,3,2,37))
  }

}
