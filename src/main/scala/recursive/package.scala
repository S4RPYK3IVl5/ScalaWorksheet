package object recursive {

  /*
   * Find the smallest common multiple of the x and y parameters
   */
  @scala.annotation.tailrec
  def noc(x: Int, y: Int): Int = {
    if (x % y == 0) y
    else if (y % x == 0) x
    else noc(x, x % y)
  }

}
