package chapter2

import chapter2.Ex2.isSorted
import org.scalatest.FunSuite

class Ex2Test extends FunSuite {

  test("The array with 1, 2, 3 is sorted according to less-than") {
    assert(isSorted(Array(1, 2, 3), (x: Int, y: Int) => x < y))
  }

  test("The array with 2, 1 is not sorted according to less-than") {
    assert(!isSorted(Array(2, 1), (x: Int, y: Int) => x < y))
  }

  test("The array with 1, 2, 2 is not sorted according to less-than") {
    assert(!isSorted(Array(1, 2, 2), (x: Int, y: Int) => x < y))
  }

  test("The array with 1, 2, 2 is sorted according to less-than-or-equal") {
    assert(isSorted(Array(1, 2, 2), (x: Int, y: Int) => x <= y))
  }

  test("The array with 'A', 'AAA', 'AAAAA' is sorted according to length") {
    assert(isSorted(Array("A", "AAA", "AAAAA"), (x: String, y: String) => x.length < y.length))
  }


}
