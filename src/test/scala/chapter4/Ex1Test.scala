package chapter4

import org.scalatest.FunSuite

class Ex1Test extends FunSuite {

  //using vals to ensure the Option has the right generic type
  val noneOption: Option[Int] = None
  val some5: Option[Int] = Some(5)

  test("map of None returns None") {
    assert(noneOption.map(s => s + 1) == None)
  }

  test("map of Some returns Some, with the function applied") {
    assert(some5.map(s => s + 1) == Some(6))
  }


  test("getOrElse of None returns the argument") {
    assert(noneOption.getOrElse(6) == 6)
  }

  test("getOrElse of Some returns the wrapped value") {
    assert(some5.getOrElse(6) == 5)
  }

  test("getOrElse of Some does not evaluate the argument") {
    assert(some5.getOrElse(throw new IllegalArgumentException) == 5)
  }


  test("flatMap of None with a failing function returns None") {
    assert(noneOption.flatMap(s => None) == None)
  }

  test("flatMap of None with a succeeding function returns None") {
    assert(noneOption.flatMap(s => Some(s + 1)) == None)
  }

  test("flatMap of Some with a failing function returns None") {
    assert(some5.flatMap(s => None) == None)
  }

  test("flatMap of Some with a succeeding function returns Some, with the function applied") {
    assert(some5.flatMap(s => Some(s + 1)) == Some(6))
  }


  test("filter of None returns None") {
    assert(noneOption.filter(_ => true) == None)
    assert(noneOption.filter(_ => false) == None)
  }

  test("filter of Some with a true predicate returns the optional") {
    assert(some5.filter(_ => true) == Some(5))
  }

  test("filter of Some with a false predicate returns None") {
    assert(some5.filter(_ => false) == None)
  }


  test("orElse of None returns the argument") {
    assert(noneOption.orElse(Some(6)) == Some(6))
  }

  test("orElse of Some returns the optional") {
    assert(some5.orElse(Some(6)) == Some(5))
  }

  test("orElse of Some does not evaluate the argument") {
    assert(some5.orElse(throw new IllegalArgumentException) == Some(5))
  }


}
