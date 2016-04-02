package chapter3

import scala.annotation.tailrec

object Ex10 {
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    @tailrec
    def loop(acc: B, l: List[A]): B = l match {
      case Nil => acc
      case Cons(h, t) => loop(f(acc, h), t)
    }
    loop(z, as)
  }
}
