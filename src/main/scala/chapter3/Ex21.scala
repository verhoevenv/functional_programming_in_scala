package chapter3

import chapter3.Ex20.flatMap

object Ex21 {

  def filter[A](as: List[A])(f: A => Boolean): List[A] = {
    flatMap(as)(x => if(f(x)) List(x) else Nil)
  }

}
