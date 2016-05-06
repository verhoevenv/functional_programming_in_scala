package chapter4

import chapter4.Ex5.{sequence, traverse}
import org.scalatest.FunSuite

class Ex6Test extends FunSuite {
  val right1: Either[String, Int] = Right(1)
  val leftAbc: Either[String, Int] = Left("abc")

  test("map on right maps") {
    assert(right1.map(_ + 1) == Right(2))
  }

  test("map on left doesn't map") {
    assert(leftAbc.map(_ + 1) == leftAbc)
  }


  test("flatMap on right with return value right flattens") {
    assert(right1.flatMap(x => Right(x + 1)) == Right(2))
  }

  test("flatMap on right with return value left returns left") {
    assert(right1.flatMap(x => Left("xyzzy")) == Left("xyzzy"))
  }

  test("flatMap on left doesn't map flat") {
    assert(leftAbc.flatMap(x => Left("notUsed")) == leftAbc)
  }


  test("orElse on right gives the right") {
    assert(right1.orElse(Left("notUsed")) == right1)
  }

  test("orElse on right doesn't evaluate the argument") {
    assert(right1.orElse(throw new IllegalStateException()) == right1)
  }

  test("orElse on left returns else") {
    assert(leftAbc.orElse(Right("zyx")) == Right("zyx"))
  }


  test("map2 on right and right maps") {
    assert(right1.map2(right1)(_ + _) == Right(2))
  }

  test("map2 on right and left returns left") {
    assert(right1.map2(leftAbc)(_ + _) == leftAbc)
  }

  test("map2 on left and right returns left") {
    assert(leftAbc.map2(right1)(_ + _) == leftAbc)
  }

  test("map2 on left and left returns left") {
    assert(leftAbc.map2(leftAbc)(_ + _) == leftAbc)
  }

}
