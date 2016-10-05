package chapter5

import org.scalatest.FunSuite

class Ex13Test extends FunSuite {

  test("map_unfold") {
    assert(Stream(1, 2, 3).map_unfold(_ + 1).toList == List(2,3,4))
  }

  test("take_unfold") {
    assert(Stream(1, 2, 3, 4).take_unfold(2).toList == List(1, 2))
  }

  test("takeWhile_unfold") {
    assert(Stream(1, 2, 3, 4, 3, 2, 1).takeWhile_unfold(_ < 3).toList == List(1, 2))
  }

  test("zipWith_unfold") {
    assert(Stream(1, 2, 3).zipWith(Stream(1, 2, 3))(_ + _).toList == List(2, 4, 6))
  }

  test("zipAll_unfold") {
    assert(Stream(1, 2).zipall(Stream("a")).toList == List((Some(1), Some("a")), (Some(2), None)))
  }

}
