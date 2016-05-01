package chapter4

import chapter4.Ex3.map2

object Ex5 {
  def traverse[A,B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    val emptyList: Option[List[B]] = Some(List())
    a.foldRight(emptyList) { (a1, acc) => map2(f(a1), acc)(_ :: _) }
  }

  def sequence[A](a: List[Option[A]]): Option[List[A]] = traverse(a)(identity)
}
