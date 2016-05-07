package chapter4

import chapter4.Ex7.{sequence, traverse}
import org.scalatest.FunSuite

class Ex7Test extends FunSuite {

  test("traverse") {
    assert(traverse(List(1, 2))(x => Right(x + 1)) == Right(List(2,3)))
  }

  test("traverse of empty list gives empty list") {
    assert(traverse(List())(x => Right(x.toString)) == Right(List()))
  }

  test("traverse gives first failure") {
    assert(traverse(List(0, 1, 2))(x => if(x >= 1) Left(x) else Right(x + 1)) == Left(1))
  }

  test("traverse of empty list gives empty list, even when function would fail") {
    assert(traverse(List())(x => Left("An error!")) == Right(List()))
  }


  test("sequence") {
    assert(sequence(List(Right(1), Right(2))) == Right(List(1,2)))
  }

  test("sequence of empty list gives empty list") {
    assert(sequence(List()) == Right(List()))
  }

  test("sequence gives first Left encountered (in foldright order)") {
    assert(sequence(List(Right(1), Left("an error"), Right(2), Left("more errors"))) == Left("an error"))
  }

}
