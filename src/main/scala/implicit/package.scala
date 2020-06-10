package object `implicit` {

  def createJSON(): Map[String, JSON] =
    Map(
      "name" -> "Andrey",
      "age" -> 19,
      "good boy" -> true
    )

  implicit def fromStrToJSON(string: String): JSON = JSONStr(string)
  implicit def fromIntToJSON(int: Int): JSON = JSONNum(int)
  implicit def fromBoolToJSON(boolean: Boolean): JSON = JSONBoolean(boolean)

}
