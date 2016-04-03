package chapter3

import chapter3.Ex23.zipWith
import org.scalatest.FunSuite

class Ex23Test extends FunSuite {

  test("zipWith") {
    assert(zipWith(List(1,2,3), List(3,2,1))(_ > _) == List(false,false,true))
  }


}
