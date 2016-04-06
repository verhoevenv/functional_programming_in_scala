package chapter3

import Function.const

object Ex29 {

  def fold[A,B](t: Tree[A])(leafer: A => B)(combiner: B => B => B): B = t match {
    case Leaf(v) => leafer(v)
    case Branch(l, r) => combiner(fold(l)(leafer)(combiner))(fold(r)(leafer)(combiner))
  }

  def size[A](t: Tree[A]): Int = fold(t)(const(1))(l => r => l + r + 1)
  def maximum(t: Tree[Int]): Int = fold(t)(identity)(l => r => l max r)
  def depth[A](t: Tree[A]): Int = fold(t)(const(1))(l => r => (l max r) + 1)
  def map[A,B](t: Tree[A])(f: A => B): Tree[B] = fold(t)(v => Leaf(f(v)) : Tree[B])(l => r => Branch(l, r))

}
