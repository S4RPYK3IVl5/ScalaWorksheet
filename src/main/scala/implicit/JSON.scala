package `implicit`

trait JSON {}
case class JSONStr(string: String) extends JSON
case class JSONNum(int: Int) extends JSON
case class JSONBoolean(boolean: Boolean) extends JSON
