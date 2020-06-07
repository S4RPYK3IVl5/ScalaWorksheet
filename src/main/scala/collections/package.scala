package object collections {

  /*
   * Analogous of toString method on collection.
   * Here is basic example of pattern matching
   */
  def goThroughCollection[T](x: Seq[T]): Unit = {
    @scala.annotation.tailrec
    def loop(x: Seq[T]): Unit= x match {
      case head :: Nil => print(s"$head ]")
      case head :: xs => print(s"$head, "); loop(xs)
    }
    print("[ ")
    loop(x)
  }

  /*
   * Generate infinity sequence *from* until argument inside take method on returned LazyList
   */
  def infinitySeq(from: Int): LazyList[Int] = {
    from #:: infinitySeq(from + 1)
  }

  /*
   * Generate infinity sequence of prime numbers based on sequence until argument inside take method on returned LazyList
   */
  def infinityPrimeNumbers(lazyList: LazyList[Int]): LazyList[Int] = {
    lazyList.head #:: infinityPrimeNumbers(lazyList.tail filter (_%lazyList.head != 0))
  }
}
