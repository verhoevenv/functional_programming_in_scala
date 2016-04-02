package chapter3

import org.scalatest.FunSuite

class Ex8Test extends FunSuite {

 test("Deep insights about foldRight happening here") {
    assert(Ex8.foldResult == List(1,2,3))
  }

}
