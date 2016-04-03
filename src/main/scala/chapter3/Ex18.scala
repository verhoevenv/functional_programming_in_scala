package chapter3

import chapter3.List.foldRight

object Ex18 {

  def map[A,B](as: List[A])(f: A => B): List[B] = foldRight(as, Nil:List[B])((h,t) => Cons(f(h), t))

}
