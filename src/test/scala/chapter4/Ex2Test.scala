package chapter4

import chapter4.Ex2.variance
import org.scalatest.FunSuite

class Ex2Test extends FunSuite {

  test("variance of empty sequence is None") {
    assert(variance(Seq()) == None)
  }

  test("variance of 3, 4, 7, 10 is 7.5") {
    assert(variance(Seq(3, 4, 7, 10)) == Some(7.5))
  }

}
