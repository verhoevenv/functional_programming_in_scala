package chapter6

object Ex2 {
  def double(rng: RNG): (Double, RNG) = {
    val (res, next) = rng.nextInt
    (res.toDouble / Math.pow(2, 32) + 0.5, next)
  }
}
