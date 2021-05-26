package Assignment3

object task12 extends App {

  import scala.language.implicitConversions

  implicit val v: Int => String = (i:Int) => i.toString

  implicit def any2String[A](x1:A, x2:A)(implicit elem2String: A => String): String = x1 + x2

  any2String(2,3)
}
