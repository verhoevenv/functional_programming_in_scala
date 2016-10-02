package chapter5

import org.scalatest.FunSuite

class Ex5Test extends FunSuite {

  test("takeWhile returns all starting elements matching the predicate") {
    assert(Stream(1, 2, 3, 4, 3, 2, 1).takeWhile_fold(_ < 3).toList == List(1, 2))
  }

}
