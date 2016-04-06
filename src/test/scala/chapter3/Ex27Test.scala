package chapter3

import chapter3.Ex27.depth
import org.scalatest.FunSuite

class Ex27Test extends FunSuite {

  test("depth of singleton tree is 1") {
    assert(depth(Leaf(3)) == 1)
  }

  test("depth") {
    assert(depth(Branch(Branch(Leaf(3), Branch(Leaf(1), Leaf(3))), Leaf(1))) == 4)
  }

}
