package chapter5

sealed trait Stream[+A] {
  def toList: List[A] =
    this match {
      case Empty => List()
      case Cons(h, t) => h() :: t().toList
    }

  def take(n: Int) : Stream[A] =
    this match {
      case Cons(h, t) => if(n == 0) Empty else Cons(h, () => t().take(n-1))
      case _ => this
    }

  def drop(n: Int) : Stream[A] =
    this match {
      case Cons(h, t) => if(n == 0) this else t().drop(n-1)
      case _ => this
    }

  def takeWhile(p: A => Boolean): Stream[A] =
    this match {
      case Cons(h, t) => if(!p(h())) Empty else Cons(h, () => t().takeWhile(p))
      case _ => this
    }

  def foldRight[B](z: => B)(f: (A, => B) => B): B =
    this match {
      case Cons(h, t) => f(h(), t().foldRight(z)(f))
      case _ => z
    }

  import chapter5.Stream._

  def forAll(p: A => Boolean): Boolean =
    foldRight(true)((elem, lazyRecursiveFoldValue) => p(elem) && lazyRecursiveFoldValue)

  def takeWhile_fold(p: A => Boolean): Stream[A] =
    foldRight(empty: Stream[A])((a, b) => if(p(a)) cons(a, b) else Empty)

  def headOption : Option[A] =
    foldRight(Option.empty : Option[A])((a,_) => Some(a))

  def map[B](f: A => B): Stream[B] =
    foldRight(empty: Stream[B])((a, b) => cons(f(a), b))

  def filter(p: A => Boolean): Stream[A] =
    foldRight(empty: Stream[A])((a, b) => if(p(a)) cons(a, b) else b)

  def append[AA >: A](other: => Stream[AA]): Stream[AA] =
    foldRight(other)(cons(_, _))

  def flatMap[B](f: A => Stream[B]): Stream[B] =
    foldRight(empty: Stream[B])((a, b) => f(a) append b)

}

case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]


object Stream {
  def cons[A](hd: => A, tl: => Stream[A]) : Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] =
    if(as.isEmpty) empty else cons(as.head, apply(as.tail: _*))

  val ones: Stream[Int] = cons(1, ones)

  def constant[A](a: A): Stream[A] = cons(a, constant(a))
}
