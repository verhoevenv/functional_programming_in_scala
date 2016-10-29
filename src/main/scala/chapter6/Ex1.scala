package chapter6

object Ex1 {
  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (res, next) = rng.nextInt
    (res >>> 1, next)
  }
}
