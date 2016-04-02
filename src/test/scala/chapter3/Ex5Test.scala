package chapter3

import chapter3.Ex5.dropWhile
import org.scalatest.FunSuite

class Ex5Test extends FunSuite {

  def isEven(x: Int): Boolean = x % 2 == 0

  test("dropwhile") {
    assert(dropWhile(List(2,4,5,6), isEven) == List(5,6))
  }

  test("dropwhile on Nil returns Nil") {
    assert(dropWhile(Nil, isEven) == Nil)
  }
}
