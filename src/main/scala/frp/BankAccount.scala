package frp

import frp.api.Var

class BankAccount {
  val balance = Var(0)

  def deposit(x: Int): Unit = {
    val curBalance = balance()
    balance() = curBalance + x
  }
  def withdraw(x: Int): Unit = {
    val curBalance = balance()
    balance() = curBalance - x
  }

}
