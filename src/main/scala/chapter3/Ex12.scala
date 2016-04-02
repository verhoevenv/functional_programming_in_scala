package chapter3

import chapter3.Ex10.foldLeft

object Ex12 {
  //Compare with Ex8, mind = blown
  def reverse[A](l: List[A]): List[A] = foldLeft(l, Nil:List[A])((x,y) => Cons(y,x))
}
