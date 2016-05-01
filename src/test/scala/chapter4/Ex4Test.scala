package chapter4

import chapter4.Ex4.sequence
import org.scalatest.FunSuite

class Ex4Test extends FunSuite {

  test("sequence") {
    assert(sequence(List(Some(1), Some(2))) == Some(List(1,2)))
  }

  test("sequence of empty list gives empty list") {
    assert(sequence(List()) == Some(List()))
  }

  test("sequence with only None gives None") {
    assert(sequence(List(None)) == None)
  }

  test("sequence with values and None gives None") {
    assert(sequence(List(Some(1), None, Some(2))) == None)
  }

}
