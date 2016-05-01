package chapter4

import chapter4.Ex3.map2
import org.scalatest.FunSuite

class Ex3Test extends FunSuite {

  test("map2 with values executes computation") {
    assert(map2(Some(1),Some(2))(_ + _) == Some(3))
  }

  test("map2 with first argument None is None") {
    assert(map2(None: Option[Int],Some(2))(_ + _) == None)
  }

  test("map2 with second argument None is None") {
    assert(map2(Some(1), None: Option[Int])(_ + _) == None)
  }

}
