package chapter3

import org.scalatest.FunSuite

class Ex1Test extends FunSuite {

  test("The result of the match expression is 3") {
    assert(Ex1.matchResult == 3)
  }

}
