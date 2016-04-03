package chapter3

import chapter3.List.foldRight

object Ex17 {

  def asStrings(l: List[Double]): List[String] = foldRight(l, Nil:List[String])((h, t) => Cons(h.toString, t))

}
