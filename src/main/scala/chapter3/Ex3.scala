package chapter3

object Ex3 {
  def setHead[A](v: A, xs: List[A]) : List[A] = xs match {
    case Nil => Nil
    case Cons(h, t) => Cons(v, t)
  }
}
