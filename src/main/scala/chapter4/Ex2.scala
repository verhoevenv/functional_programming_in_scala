package chapter4

object Ex2 {
  def variance(xs: Seq[Double]): Option[Double] = {
    def mean(ns: Seq[Double]) : Option[Double] = if(ns.isEmpty) None else Some(ns.sum / ns.length)

    mean(xs)
      .map(m => xs.map(x => math.pow(x - m, 2)))
      .flatMap(mean)
  }
}
