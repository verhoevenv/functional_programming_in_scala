package chapter3

object Ex2 {
  def tail[A](xs: List[A]) : List[A] = xs match {
    case Nil => Nil
    case Cons(h, t) => t
  }
}
