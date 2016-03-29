package chapter2

import chapter2.Ex1.fib
import org.scalatest.FunSuite

class Ex1Test extends FunSuite {

  test("The first Fibonacci number is 0") {
    assert(fib(1) == 0)
  }

  test("The second Fibonacci number is 1") {
    assert(fib(2) == 1)
  }

  test("The third Fibonacci number is 1") {
    assert(fib(3) == 1)
  }

  test("The fourth Fibonacci number is 2") {
    assert(fib(4) == 2)
  }

  test("The fifth Fibonacci number is 3") {
    assert(fib(5) == 3)
  }

  test("The sixth Fibonacci number is 5") {
    assert(fib(6) == 5)
  }

  test("The 47th Fibonacci number is 1836311903") {
    assert(fib(47) == 1836311903)
  }

  test("The 48th Fibonacci number overflows int range") {
    assert(fib(48) < 0)
  }

}
