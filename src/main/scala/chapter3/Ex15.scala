package chapter3

import chapter3.List.foldRight

object Ex15 {
  def concatenate[A](ls: List[List[A]]): List[A] = foldRight(ls, Nil: List[A])((x: List[A], y: List[A]) => Ex14.append(x, y))

}
