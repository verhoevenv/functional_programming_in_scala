package chapter3

import chapter3.Ex11._
import org.scalatest.FunSuite

class Ex11Test extends FunSuite {

  test("sum") {
    assert(sum(List(1,2,3,4)) == 10)
  }

 test("product") {
    assert(product(List(1.0,2.0,3.0,4.0)) == 24.0)
  }

 test("length") {
    assert(length(List("A", "B", "C")) == 3)
  }

}
