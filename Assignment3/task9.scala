package Assignment3

object task9 extends App {

  val l = List(1,2,3)

  def apply(l:List[Int]) = println(l.reduce(_+_))

  apply(l)

}
