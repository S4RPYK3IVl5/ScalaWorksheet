import recursive._
import collections._
import expressions._
import `implicit`._
import datastructures._
import datastructures.list.Node
import datastructures.list.Leaf
import datastructures.list.None
import frp.BankAccount
import frp.api._
import frp._


object main{
  def main(args: Array[String]): Unit = {

//     println(noc(9, 6)) // 3

//    goThroughCollection(List(1, 4, 7, 10)) // [ 1, 4, 7, 10 ]
//    println()

//    generateNumberFromOneToHundred().foreach(x => print(x + " ")) // 0 1 2 3 4 5 ... 97 98 99
//    println()

//    println(infinitySeq(0).take(100).toList) //List(0, 1, 2, 3, 4, 5, ... 96, 97, 98, 99)
//    println(infinitySeq(0).take(100).map(_*4).toList) //List(0, 4, 8, 12, ... 392, 396)

//    println(infinityPrimeNumbers(infinitySeq(2)).take(10).toList) // List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)

    // This is use case of functional react programming API
//    fictionalReactProgrammingAPI

    // Example of beautiful magic of implicit variables
//   println(createJSON)

    iterateOverCustomList(new Leaf(1, new Leaf(3, new Leaf(-5)))) //1, 3, -5
    println()

    // Substitute the tail of current Leaf
    val substituteList = new Leaf(1) += new Leaf(3)
    iterateOverCustomList(substituteList) //1, 3
    println()

    // Add Leafs to the and of list
    val addedList = new Leaf(1) +++ new Leaf(3) +++ new Leaf(-5)
    iterateOverCustomList(addedList) //1, 3, -5
    println()

    // Add Leafs to the and of list
    val implictedList: Node[Int] = 1 +++ 3 +++ -5
    iterateOverCustomList(implictedList) //1, 3, -5

  }
}
