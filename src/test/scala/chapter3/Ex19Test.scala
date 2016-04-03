package chapter3

import chapter3.Ex19.filter
import org.scalatest.FunSuite

class Ex19Test extends FunSuite {

  def isEven(n: Int): Boolean = n % 2 == 0

  test("filter") {
    assert(filter(List(1,2,3))(isEven) == List(2))
  }

}
