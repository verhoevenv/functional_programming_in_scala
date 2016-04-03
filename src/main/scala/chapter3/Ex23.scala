package chapter3

object Ex23 {

  def zipWith[A,B,C](l1: List[A], l2: List[B])(f: (A, B) => C): List[C] = (l1,l2) match {
    case (Cons(h1,t1),Cons(h2,t2)) => Cons(f(h1, h2), zipWith(t1,t2)(f))
    case (Nil, Nil) => Nil
    case _ => Nil
  }

}
