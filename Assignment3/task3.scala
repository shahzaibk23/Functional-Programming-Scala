package Assignment3

object task3 extends App {

  def Euclidean(lst:Vector[Int]) = Math.sqrt(lst.map(Math.pow(_,2)).reduce(_+_))

  val v = Vector(1,2,3,4,5)

  Euclidean(v)

}
