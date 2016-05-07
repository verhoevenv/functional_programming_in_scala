package chapter4

object Ex7 {
  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = traverse(es)(x => x)
  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] = {
    val emptyList: Either[E, List[B]] = Right(List())
    as.foldRight(emptyList) {
      (a, b) => f(a).map2(b) { _ :: _ }
    }
  }
}
