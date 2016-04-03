package chapter3

import chapter3.List.foldRight

object Ex20 {

  def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] = {
    foldRight(as, Nil:List[B])((x,y) => {
      Ex14.append(f(x), y)
    })
  }

}
