package chapter3

import chapter3.List.foldRight


object Ex14 {
  def append[A](a1: List[A], a2: List[A]): List[A] = foldRight(a1,a2)(Cons(_,_))

}
