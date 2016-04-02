package chapter2

import chapter2.Ex3.curry
import org.scalatest.FunSuite

class Ex3Test extends FunSuite {

  test("an example of currying as there's no real need to test this because there's only one possible implementation") {
    val multiplicationFunction: (Int, Int) => Int = _ * _
    val curriedMultiplication = curry(multiplicationFunction)

    val double = curriedMultiplication(2)

    // note that the following is a syntax error:
    //val nonCurriedDouble = multiplicationFunction(2)

    assert(double(3) == 6)
  }

}
