package chapter6

import org.scalatest.FunSuite

class Ex11Test extends FunSuite {

  ignore("state machines") {
    val initialState : Machine = Machine(locked = false, candies = 5, coins = 10)
    val inputs: List[Input] = List(Coin, Turn, Coin, Turn, Coin)

    val ((coins, candies), endState): ((Int, Int), Machine) = Machine.simulateMachine(inputs)(initialState)

    assert(candies == 3)
    assert(coins == 13)
    assert(endState == Machine(locked = true, candies = 3, coins = 13))
  }

}
