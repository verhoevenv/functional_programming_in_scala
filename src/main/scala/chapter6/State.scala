package chapter6

object State {

  def unit[A,S](a: A): State[S, A] = State(s => (a, s))

  def map2[S,A,B,C](st1: State[S, A], st2: State[S, B])(f: (A,B) => C): State[S, C] =
    State(s => {
      val (a, s2) = st1(s)
      val (b, s3) = st2(s2)
      (f(a, b), s3)
    })

  def sequence[S, A](fs: List[State[S, A]]): State[S, List[A]] =
    (fs foldRight (unit(List()): State[S, List[A]])) { (rand, y) => map2(rand, y)(_ :: _) }

  def get[S]: State[S, S] = State(s => (s, s))
  def set[S](s: S): State[S, Unit] = State(_ => ((), s))

  def modify[S](f: S => S): State[S, Unit] = for {
    s <- get
    _ <- set(f(s))
  } yield ()
}

case class State[S, +A](run: S => (A, S)) {
  def apply(s: S): (A, S) = run(s)

  def map[B](f: A => B): State[S, B] =
    State(s => {
      val (a, s2) = run(s)
      (f(a), s2)
    })

  def flatMap[B](f: A => State[S, B]): State[S, B] =
    State(s => {
      val (a, s2) = run(s)
      f(a)(s2)
    })

}


