package chapter5

import org.scalatest.FunSuite

class Ex4Test extends FunSuite {

  test("forAll returns true if all elements match") {
    assert(Stream(1, 2).forAll(_ < 3))
  }

  test("forAll returns false if not all elements match") {
    assert(!Stream(1, 2, 3, 4).forAll(_ < 3))
  }

  test("forAll terminates early after the first non-matching element") {
    assert(!Stream(lz(1), lz(2), lz(3), () => {fail(); 4}).forAll(_() < 3))
  }

  def lz[A](x: A) = () => x
}
