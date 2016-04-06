package chapter3

import chapter3.Ex26.maximum
import org.scalatest.FunSuite

class Ex26Test extends FunSuite {

  test("maximum") {
    assert(maximum(Branch(Branch(Leaf(3), Leaf(6)), Leaf(1))) == 6)
  }

}
