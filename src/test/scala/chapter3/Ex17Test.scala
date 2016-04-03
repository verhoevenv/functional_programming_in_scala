package chapter3

import chapter3.Ex17.asStrings
import org.scalatest.FunSuite

class Ex17Test extends FunSuite {

  test("asStrings") {
    assert(asStrings(List(1.0,2.0,3.0)) == List("1.0","2.0","3.0"))
  }

}
