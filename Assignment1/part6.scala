package Assignment1

import scala.util.Try

object part6 extends App {

  val toInt:String=>Int = _.toInt
  val addOne:Int=>Int=_+1
  val multiplyByTwo:Int => Int=_*2
  val simpleComposition=toInt andThen addOne andThen multiplyByTwo
  println("  -- pure result : "+simpleComposition("5"))

//  simpleComposition("notANumber") // this will throw an exception

  val toIntTotal: String => Try[Int] = input => Try(input.toInt)

  println(toIntTotal("2"))

  val composed = toIntTotal.andThen(input => input.map(addOne))

  println("  -- composed type correct : " + composed("1"))
  println("  -- composed type incorrect : " + composed("notANumber"))


}
