package Assignment3

object task6 extends App {

  case class Numbers(var x1:Int, var x2:Int)

  val obj = Numbers(3,6)

  val obj2 = obj.copy()

  obj.x1 = 5

  obj
  obj2

}
