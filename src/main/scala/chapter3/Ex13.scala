package chapter3

import chapter3.Ex10.foldLeft
import chapter3.Ex12.reverse
import chapter3.List.foldRight

object Ex13 {
  def leftInTermsOfRight[A,B](as: List[A], z: B)(f: (B,A) => B): B = {
    foldRight(reverse(as), z)((x, y) => f(y, x))
  }

  def rightInTermsOfLeft[A,B](as: List[A], z: B)(f: (A,B) => B): B = {
    foldLeft(reverse(as), z)((x, y) => f(y, x))
  }
}
