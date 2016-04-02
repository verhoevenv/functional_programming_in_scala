package chapter2

import chapter2.Ex3.curry
import chapter2.Ex4.uncurry
import org.scalatest.FunSuite

class Ex4Test extends FunSuite {

  test("an example of uncurrying as there's no real need to test this because there's only one possible implementation") {
    val curriedSumFunction: Int => Int => Int = x => y => x + y

    val twoArgumentSum = uncurry(curriedSumFunction)

    assert(List(1, 2, 3).reduce(twoArgumentSum) == 6)

    // note that the following is a syntax error:
    //List(1, 2, 3).reduce(curriedSumFunction)
  }

}
