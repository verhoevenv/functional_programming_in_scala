package chapter3

import chapter3.Ex3.setHead
import org.scalatest.FunSuite

class Ex3Test extends FunSuite {

  test("Replacing the head of a list changes the first element") {
    assert(setHead(5, List(1,2,3)) == List(5,2,3))
  }

  test("Replacing the head of Nil returns Nil") {
    assert(setHead(5, Nil) == Nil)
  }

}
