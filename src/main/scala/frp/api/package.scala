package frp

import scala.util.DynamicVariable

package object api {

  class Signal[T](expr: => T) {

    import Signal._
    private var curExpr: () => T = _
    private var curVal: T = _
    private var observers: Set[Signal[_]] = Set()

    update(expr)

    protected def computeValue(): Unit = {
      curVal = caller.withValue(this)(curExpr())
      observers.foreach(_.computeValue())
    }

    protected def update(expr: => T) = {
      curExpr = () => expr
      computeValue()
    }

    def apply() = {
      observers += caller.value
      curVal
    }

    override def toString: String = "Signal " + curVal

  }

  object Signal {
    val caller = new DynamicVariable[Signal[_]](NoSignal)
    def apply[T](expr: => T) = new Signal(expr)
  }

  object NoSignal extends Signal[Nothing](???) {
    override def computeValue(): Unit = {}
  }

  class Var[T](expr: => T) extends Signal[T](expr) {
    override def update(expr: => T): Unit = super.update(expr)
    override def toString: String = "Var " + expr
  }

  object Var { def apply[T](expr: => T) = new Var(expr) }


  def consolidated(accts: List[BankAccount]): Signal[Int] =
    Signal(accts.map(_.balance()).sum)

}
