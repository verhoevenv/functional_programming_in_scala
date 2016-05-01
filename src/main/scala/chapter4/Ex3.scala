package chapter4

object Ex3 {
  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    a flatMap (av => b map (bv => f(av, bv)))
}
