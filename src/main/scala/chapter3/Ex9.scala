package chapter3

import chapter3.List.foldRight

object Ex9 {
  def length[A](as: List[A]): Int = foldRight(as, 0)((_,y) => y + 1)
}
