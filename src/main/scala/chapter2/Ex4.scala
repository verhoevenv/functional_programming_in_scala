package chapter2

object Ex4 {
  def uncurry[A,B,C](f: A => B => C) : (A, B) => C = {
    (x: A, y: B) => f(x)(y)
  }
}
