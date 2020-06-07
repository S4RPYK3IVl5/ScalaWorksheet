package object expressions {

  /*
   * Basic example of for expression, under the hood it translated to
   * x.flatMap(xVal => y.map(yVal => xVal + "" + yVal)).foreach(_.toInt)
   */
  def generateNumberFromOneToHundred() = {
    val x = 0 to 9
    val y = 0.to(9)
    x.flatMap(xVal => y.map(yVal => xVal + "" + yVal)).foreach(_.toInt)
    for {
      xVal <- x
      yVal <- y
    } yield (xVal + "" + yVal).toInt
  }


}
