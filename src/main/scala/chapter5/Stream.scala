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

  def map_unfold[B](f: A => B): Stream[B] =
    unfold(this)(x => x.headOption.map(y => (f(y), x.drop(1))))

  def take_unfold(n: Int) : Stream[A] =
    unfold((this, n)) {
      case (_, 0) => None
      case (Empty, _) => None
      case (Cons(h, t), num) => Some(h(), (t(), num-1))
    }

  def takeWhile_unfold(p: A => Boolean): Stream[A] =
    unfold(this) {
      case Empty => None
      case Cons(h, t) => if(p(h())) Some(h(), t()) else None
    }

  def zipWith[B, C](o: Stream[B])(f : (A, B) => C): Stream[C] =
    unfold((this, o)) {
      case (Empty, _) => None
      case (_, Empty) => None
      case (Cons(h1, t1), Cons(h2, t2)) => Some(f(h1(), h2()), (t1(), t2()))
    }

  def zipall[B](o: Stream[B]): Stream[(Option[A], Option[B])] =
    unfold((this, o)) {
      case (Empty, Empty) => None
      case (Empty, Cons(h2, t2)) => Some((None, Some(h2())), (Empty, t2()))
      case (Cons(h1, t1), Empty) => Some((Some(h1()), None), (t1(), Empty))
      case (Cons(h1, t1), Cons(h2, t2)) => Some((Some(h1()), Some(h2())), (t1(), t2()))
    }
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

  def from(n: Int): Stream[Int] = cons(n, from(n + 1))

  val fibs: Stream[Int] = {
    def fibs(curr: Int, next: Int): Stream[Int] = {
      cons(curr, fibs(next, curr + next))
    }
    fibs(0, 1)
  }

  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] =
    f(z) match {
      case Some((v, s)) => cons(v, unfold(s)(f))
      case None => empty
    }

  def fibs_unfold: Stream[Int] = unfold((0, 1)) {
    case (cur, next) => Some(cur, (next, cur + next))
  }

  def from_unfold(n: Int): Stream[Int] = unfold(n){x => Some(x, x + 1)}

  import Function.const

  def constant_unfold[A](a: A): Stream[A] = unfold(a)(const(Some(a, a)))

  val ones_unfold: Stream[Int] = unfold(null)(const(Some(1, null)))

}
