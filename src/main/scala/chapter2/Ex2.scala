package chapter2

import scala.annotation.tailrec

object Ex2 {
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def loop(n: Int) : Boolean = {
      if(n >= as.length) true
      else if(!ordered(as(n-1), as(n))) false
      else loop(n+1)
    }
    loop(1)
  }
}
