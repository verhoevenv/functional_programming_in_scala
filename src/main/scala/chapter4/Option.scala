package chapter4

case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]
sealed trait Option[+A] {

  // Ex 1

  def map[B](f: A => B): Option[B] =
    this match {
      case Some(a) => Some(f(a))
      case None => None
    }

  def getOrElse[B >: A](default: => B): B =
    this match {
      case Some(a) => a
      case None => default
    }

  def flatMap[B](f: A => Option[B]): Option[B] = map(f) getOrElse None

  def filter(f: A => Boolean): Option[A] = flatMap(x => if(f(x)) Some(x) else None )

  def orElse[B >: A](ob: => Option[B]): Option[B] = map(Some(_)) getOrElse ob

}
