package chapter3

import chapter3.List.foldRight

object Ex19 {

  def filter[A](as: List[A])(f: A => Boolean): List[A] = {
    foldRight(as, Nil:List[A])((x, y) => {
      if(f(x)) Cons(x, y)
      else y
    })
  }

}
