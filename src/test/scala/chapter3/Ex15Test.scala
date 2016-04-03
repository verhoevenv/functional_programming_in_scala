package chapter3

import chapter3.Ex15.concatenate
import org.scalatest.FunSuite

import scala.collection.immutable.IndexedSeq

class Ex15Test extends FunSuite {

  test("concatenate") {
    assert(concatenate(List(List(1,2,3), List(3,2), Nil, List(37))) == List(1,2,3,3,2,37))
  }

  //unignore and run to get CSV output of length of list vs time to concatenate
  //the data suggests concatenate is linear
  ignore("concatenate has linear time complexity") {
    val timings: IndexedSeq[(Int, Long)] = 100.to(10000, step = 100).map(i => {
      val lists: List[List[Int]] = createLists(i)
      val timing: Long = time(() => concatenate(lists))
      (i, timing)
    })

    timings.foreach {
      case (i, time) => println(s"$i,$time")
    }
  }

  def time[R](block: () => Unit): Long = {
    val t0 = System.nanoTime()
    block()
    val t1 = System.nanoTime()
    t1-t0
  }

  def createLists(numLists: Int): List[List[Int]] = {
    val lists: Seq[List[Int]] = Seq.fill(numLists)(List(numLists))
    List(lists:_*)
  }
}
