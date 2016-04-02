package chapter3

import chapter3.Ex10.foldLeft
import chapter3.Ex9.length
import org.scalatest.FunSuite

class Ex10Test extends FunSuite {

  test("foldLeft") {
    assert(foldLeft(List(1,2,3), "")((x: String, y: Int) => x + y) == "123")
  }

}
