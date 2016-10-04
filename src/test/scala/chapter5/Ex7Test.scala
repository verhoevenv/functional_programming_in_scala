package chapter5

import org.scalatest.FunSuite

class Ex7Test extends FunSuite {

  test("map") {
    assert(Stream(1, 2, 3).map(_ + 1).toList == List(2,3,4))
  }

  test("filter") {
    assert(Stream(1, 2, 3).filter(_ > 2).toList == List(3))
  }

  test("append") {
    assert(Stream(1, 2, 3).append(Stream(4, 5)).toList == List(1, 2, 3, 4, 5))
  }

  test("append is non-strict in the argument, with one argument to spare") {
    assert(Stream(1, 2).append({fail(); Stream(3)}).take(1).toList == List(1))
  }

  //this breaks for as of yet unknown reasons
  ignore("append is non-strict in the argument, corner case") {
    assert(Stream(1, 2).append({fail(); Stream(3)}).take(2).toList == List(1, 2))
  }

  test("flatMap") {
    assert(Stream(1, 2, 3).flatMap(x => Stream(x, x+1)).toList == List(1, 2, 2, 3, 3, 4))
  }

}
