package Assignment3

object task11 extends App {

  import scala.language.implicitConversions

  implicit def list2ordered[A](x: List[A])
                              (implicit elem2ordered: A => Ordered[A]): Ordered[List[A]] =

    new Ordered[List[A]] {

      def compare(that: List[A]): Int = 1
    }

  val l1 = list2ordered(List(1,2,3))
  println(l1)

  val l2 = l1.compare(List(1,2,3))
  println(l2)

}
