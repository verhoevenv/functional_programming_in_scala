package chapter3

import chapter3.Ex28.map
import org.scalatest.FunSuite

class Ex28Test extends FunSuite {

  test("map") {
    val treeBefore: Branch[Int] = Branch(Branch(Leaf(3), Leaf(1)), Leaf(-1))
    val treeAfter: Branch[Int] = Branch(Branch(Leaf(6), Leaf(2)), Leaf(-2))
    assert(map(treeBefore)(_ * 2) == treeAfter)
  }

}
