package chapter4

import chapter4.Ex5.traverse
import chapter4.Ex5.sequence
import org.scalatest.FunSuite

class Ex5Test extends FunSuite {

  test("traverse") {
    assert(traverse(List(1, 2))(x => Some(x + 1)) == Some(List(2,3)))
  }

  test("traverse of empty list gives empty list") {
    assert(traverse(List())(x => Some(x.toString)) == Some(List()))
  }

  test("traverse with one failure gives None") {
    assert(traverse(List(0, 1, 2))(x => if(x == 1) None else Some(x)) == None)
  }

  test("traverse of empty list gives empty list, even when function would fail") {
    assert(traverse(List())(x => None) == Some(List()))
  }


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
