package datastructures

package object list {

  sealed trait Node[+T] {
    def isNull: Boolean
    def getHead: T
    def getTail: Node[T]

    def setTail[A >: T](newTail: Node[A]): Node[A]
    def +=[A >: T](newTail: Node[A]): Node[A] = setTail(newTail)

    def addTailToTheEnd[A >: T](newTail: Node[A]): Node[A]
    def +++[A >: T](newTail: Node[A]): Node[A] = addTailToTheEnd(newTail)

    override def toString: String = getHead.toString
  }

  class Leaf[+T](head: T, tail: Node[T] = None) extends Node[T] {
    override def isNull: Boolean = false
    override def getHead: T = head
    override def getTail: Node[T] = tail
    override def setTail[A >: T](newTail: Node[A]): Node[A] = new Leaf[A](head, newTail)
    override def addTailToTheEnd[A >: T](newTail: Node[A]): Node[A] = tail match {
      case None => new Leaf(head, newTail)
      case _ => new Leaf(head, tail.addTailToTheEnd(newTail))
    }
  }

  object None extends Node[Nothing] {
    override def isNull: Boolean = true
    override def getHead: Nothing = throw new IllegalArgumentException("Empty value does't has head")
    override def getTail: Node[Nothing] = throw new IllegalArgumentException("Empty value does't has a tail")
    override def setTail[A >: Nothing](newTail: Node[A]): Node[A] = throw new IllegalArgumentException("There is not ability to set the tail to None")
    override def addTailToTheEnd[A >: Nothing](newTail: Node[A]): Node[A] = throw new IllegalArgumentException("There is not ability to set the tail to None")
  }

}
