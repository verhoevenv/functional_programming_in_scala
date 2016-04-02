package chapter3

import org.scalatest.FunSuite

class Ex13Test extends FunSuite {

  test("foldLeft reference") {
    assert(Ex10.foldLeft(List(1,2,3), "")((x: String, y: Int) => x + y) == "123")
  }

  test("foldLeft for leftInTermsOfRight") {
    assert(Ex13.leftInTermsOfRight(List(1,2,3), "")((x: String, y: Int) => x + y) == "123")
  }

  test("foldRight reference") {
    assert(List.foldRight(List(1, 2, 3), "")((x: Int, y: String) => "" + x + y) == "123")
  }

  test("foldRight for rightInTermsOfLeft") {
    assert(Ex13.rightInTermsOfLeft(List(1,2,3), "")((x: Int, y: String) => "" + x + y) == "123")
  }
}
