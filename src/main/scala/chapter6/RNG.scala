package chapter6

trait RNG {
  def nextInt: (Int, RNG)
}
