package chapter3

import chapter3.Ex25.size
import org.scalatest.FunSuite

class Ex25Test extends FunSuite {

  //Note that there is no such thing as an empty Tree
  test("size of singleton tree is 1") {
    assert(size(Leaf("1")) == 1)
  }

  test("size") {
    assert(size(Branch(Branch(Leaf("a"), Leaf("b")), Branch(Leaf("c"), Leaf("d")))) == 7)
  }

}
