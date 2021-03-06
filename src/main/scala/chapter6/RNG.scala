package chapter6

object RNG {
  type Rand[+A] = RNG => (A, RNG)

  val int: Rand[Int] = _.nextInt
  def unit[A](a: A): Rand[A] = rng => (a, rng)
  def map[A,B](s: Rand[A])(f: A => B): Rand[B] =
    rng => {
      val (a, rng2) = s(rng)
      (f(a), rng2)
    }

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A,B) => C): Rand[C] =
    rng => {
      val (a, rng2) = ra(rng)
      val (b, rng3) = rb(rng2)
      (f(a, b), rng3)
    }

  def both[A, B](ra: Rand[A], rb: Rand[B]): Rand[(A,B)] = map2(ra, rb)((_, _))

  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] =
    (fs foldRight (unit(List()): Rand[List[A]])) { (rand, y) => map2(rand, y)(_ :: _) }

  def flatMap[A,B](f: Rand[A])(g: A => Rand[B]): Rand[B] =
    rng => {
      val (res, state) = f(rng)
      g(res)(state)
    }

  def mapFM[A,B](s: Rand[A])(f: A => B): Rand[B] =
    flatMap(s)(res => unit(f(res)))

  def map2FM[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A,B) => C): Rand[C] =
    flatMap(both(ra, rb))(res => unit(f.tupled(res)))

}

trait RNG {
  def nextInt: (Int, RNG)
}
