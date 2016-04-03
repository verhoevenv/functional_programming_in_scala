package chapter3

import chapter3.List.foldRight

object Ex16 {

  def addOne(l: List[Int]): List[Int] = foldRight(l, Nil:List[Int])((h, t) => Cons(h+1, t))

}
