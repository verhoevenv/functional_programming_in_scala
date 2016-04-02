package chapter2

object Ex5 {
  def compose[A,B,C](f: A => B, g: B => C) : A => C = {
    (x: A) => g(f(x))
  }
}
