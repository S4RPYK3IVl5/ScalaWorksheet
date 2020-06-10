import frp.api.consolidated

package object frp {
  def functionalReactProgrammingAPI = {
    val aBank = new BankAccount()
    val bBank = new BankAccount()
    val cBank = new BankAccount()

    aBank deposit 10
    bBank deposit 20

    val sum = consolidated(List(aBank, bBank, cBank))
    println(sum())
    aBank deposit 5
    cBank deposit 15
    aBank withdraw 10
    println(sum())
  }
}
