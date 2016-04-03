package chapter3

import chapter3.Ex22.addLists
import org.scalatest.FunSuite

class Ex22Test extends FunSuite {

  test("addLists") {
    assert(addLists(List(1,2,3), List(4,5,6)) == List(5,7,9))
  }

  test("addLists only adds up to the shortest length of the lists") {
    assert(addLists(List(1,2,3), List(4,5)) == List(5,7))
    assert(addLists(List(1,2), List(4,5,6)) == List(5,7))
  }

}
