package assignment2

object ex4 extends App {

  val array = Array(1,2,3,4,2,2,2)


  println(array.map(_ * 3).mkString("Array(", ", ", ")"))

  println(array.count(_ == 2))
}
