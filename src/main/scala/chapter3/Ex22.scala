package chapter3

object Ex22 {

  def addLists(l1: List[Int], l2: List[Int]): List[Int] = (l1,l2) match {
    case (Cons(h1,t1),Cons(h2,t2)) => Cons(h1 + h2, addLists(t1,t2))
    case (Nil, Nil) => Nil
    case _ => Nil
  }

}
