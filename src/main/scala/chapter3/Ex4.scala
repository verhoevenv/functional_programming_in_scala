package chapter3

object Ex4 {
  def drop[A](n: Int, xs: List[A]) : List[A] = {
    if(n==0) xs
    else xs match {
      case Nil => Nil
      case Cons(h, t) => drop(n-1, t)
    }
  }
}
