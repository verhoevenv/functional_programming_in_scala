package chapter6

object Ex4 {
  def ints(count: Int)(rng: RNG): (List[Int], RNG) = count match {
    case 0 => (List(), rng)
    case n => {
      val (res, next) = rng.nextInt
      val (resList, next2) = ints(n-1)(next)
      (res :: resList, next2)
    }
  }

}
