package chapter3

import chapter3.Ex10.foldLeft
import chapter3.Ex23.zipWith

object Ex24 {

  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
    def subMatchesStart: Boolean = foldLeft(zipWith(sup, sub)(_ == _), true)(_ && _)
    sup match {
      case Nil => false
      case Cons(h, t) =>
        if(subMatchesStart) true
        else hasSubsequence(t, sub)
    }
  }

}
