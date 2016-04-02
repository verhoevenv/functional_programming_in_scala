package chapter3

import chapter3.Ex4.drop
import org.scalatest.FunSuite

class Ex4Test extends FunSuite {

  test("Dropping elements of a list") {
    assert(drop(2, List(1,2,3,4)) == List(3,4))
  }

  test("Dropping more elements of a list than its length returns Nil") {
    assert(drop(6, List(1,2,3,4)) == Nil)
    assert(drop(1, Nil) == Nil)
  }

}
