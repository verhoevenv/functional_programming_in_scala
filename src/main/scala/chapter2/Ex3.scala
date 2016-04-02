package chapter2

object Ex3 {
  def curry[A,B,C](f: (A,B) => C) : A => (B => C) = {
    (x: A) => (y: B) => f(x, y)
  }
}
