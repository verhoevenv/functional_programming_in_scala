package chapter6

object Ex3 {
  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (intRes, next1): (Int, RNG) = rng.nextInt
    val (doubleRes, next2): (Double, RNG) = Ex2.double(next1)

    ((intRes, doubleRes), next2)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val (doubleRes, next1): (Double, RNG) = Ex2.double(rng)
    val (intRes, next2): (Int, RNG) = next1.nextInt

    ((doubleRes, intRes), next2)
  }

  def double3(rng: RNG): ((Double, Double, Double), RNG) = {
    val (d1, next1): (Double, RNG) = Ex2.double(rng)
    val (d2, next2): (Double, RNG) = Ex2.double(next1)
    val (d3, next3): (Double, RNG) = Ex2.double(next2)

    ((d1, d2, d3), next3)
  }

}
