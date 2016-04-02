package chapter2

import chapter2.Ex5.compose
import org.scalatest.FunSuite

class Ex5Test extends FunSuite {

  test("an example of composition as there's no real need to test this because there's only one possible implementation") {
    val sort = (xs: List[Int]) => xs.sorted
    val reverse = (xs: List[Int]) => xs.reverse

    val descSort = compose(sort, reverse)

    assert(descSort(List(1,3,2)) == List(3,2,1))
  }

}
