package chapter4

import chapter4.Ex3.map2

object Ex4 {
  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    val emptyList: Option[List[A]] = Some(List())
    a.foldRight(emptyList) { map2(_, _)(_ :: _) }
  }
}
