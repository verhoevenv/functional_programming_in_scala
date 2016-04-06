package chapter3

object Ex27 {

  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(v) => 1
    case Branch(l, r) => (depth(l) max depth(r)) + 1
  }

}
