package chapter3

import chapter3.List.foldRight

object Ex8 {
  //ideally experimented with in a REPL! :)
  val foldResult = foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))
}
