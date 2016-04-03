package chapter3

import chapter3.Ex24.hasSubsequence
import org.scalatest.FunSuite

class Ex24Test extends FunSuite {

  test("hasSubSequence, example 1") {
    assert(hasSubsequence(List(1,2,3,4),List(1,2)))
  }

  test("hasSubSequence, example 2") {
    assert(hasSubsequence(List(1,2,3,4),List(2,3)))
  }

  test("hasSubSequence, example 3") {
    assert(hasSubsequence(List(1,2,3,4),List(4)))
  }

  test("hasSubSequence, example 4") {
    assert(!hasSubsequence(List(1,2,3,4),List(3,2)))
  }


}
