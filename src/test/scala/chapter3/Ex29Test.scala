package chapter3

import chapter3.Ex29._
import org.scalatest.FunSuite

class Ex29Test extends FunSuite {

  test("size of singleton tree is 1") {
    assert(size(Leaf("1")) == 1)
  }

  test("size") {
    assert(size(Branch(Branch(Leaf("a"), Leaf("b")), Branch(Leaf("c"), Leaf("d")))) == 7)
  }

  test("maximum") {
    assert(maximum(Branch(Branch(Leaf(3), Leaf(6)), Leaf(1))) == 6)
  }


  test("depth of singleton tree is 1") {
    assert(depth(Leaf(3)) == 1)
  }

  test("depth") {
    assert(depth(Branch(Branch(Leaf(3), Branch(Leaf(1), Leaf(3))), Leaf(1))) == 4)
  }


  test("map") {
    val treeBefore: Branch[Int] = Branch(Branch(Leaf(3), Leaf(1)), Leaf(-1))
    val treeAfter: Branch[Int] = Branch(Branch(Leaf(6), Leaf(2)), Leaf(-2))
    assert(map(treeBefore)(_ * 2) == treeAfter)
  }

}
