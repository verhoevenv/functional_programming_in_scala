package chapter6

sealed trait Input
case object Coin extends Input
case object Turn extends Input

case class Machine(locked: Boolean, candies: Int, coins: Int) {

  //TODO do this with traverse:
  //def traverse: (Input => State[Machine, Unit]) => (List[Input] => State[Machine, List[Unit]])
  //of ook (Applicative/Traversable) def traverse: (Y => A[Z]) => (T[Y] => A[T[Z]])

}

object Machine {
  def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] = {
    ???
  }
}

