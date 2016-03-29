package chapter2

import scala.annotation.tailrec

object Ex1 {
  def fib(n: Int) : Int = {
    @tailrec
    def go(n: Int, acc: Int, accmin1: Int) : Int = {
      if(n == 1) {
        acc
      } else {
        go(n-1, acc + accmin1, acc)
      }
    }

    go(n, 0, 1)
  }
}
