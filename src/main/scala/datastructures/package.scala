import datastructures.list._

package object datastructures {

  @scala.annotation.tailrec
  def iterateOverCustomList[T](node: Node[T]): Unit = node match {
    case None =>
    case leaf: Leaf[_] => println(leaf.getHead); iterateOverCustomList(leaf.getTail)
  }

  implicit def fromIntToNode[T](int: T): Node[T] = new Leaf(int)

}
