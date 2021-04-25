package assignment2

object ex3 extends App {


  def func(p1: Option[Int]):Unit = println(p1)


  func(Some(3))
  func(None)

}
