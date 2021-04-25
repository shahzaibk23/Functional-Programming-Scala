package Assignment1

object part4_exercises extends App {


  def join(o1: Option[String], o2: Option[String], o3: Option[String]): Option[String] = for {
    oo1 <- o1
    oo2 <- o2
    oo3 <- o3
  } yield oo1 + oo2 + oo3

  println(join(Some("Syeda "), Some("Fizza "), Some("JAFFERY")))
  val list = List(-2,-1)
  //apply operation to get sum of all elements of the list
  val result = list.foldRight(0)(_ - _)
  val result2 = list.foldLeft(0)(_ - _)
  //print result
  println(result)
  println(result2)
  println(2 | 1)

  //ADDITIONAL
  object EffectsLibrary {

    sealed trait Maybe[+A] {
      def flatMap[B](f: A => Maybe[B]): Maybe[B] = this match {
        case Just(v) => f(v)
        case Empty => Empty
      }

      def map[B](f: A => B): Maybe[B] = this match {
        case Just(v) => Just(f(v))
        case Empty => Empty
      }
    }

    case class Just[A](value: A) extends Maybe[A]

    case object Empty extends Maybe[Nothing]


    //EXERCISE - use for comprehension
    def map2[A, B, C](m1: Maybe[A], m2: Maybe[B])(f: (A, B) => C): Maybe[C] = for {
      o1 <- m1
      o2 <- m2
    } yield f(o1,o2)

    //use foldRight & map2   || flatMap & map & recursion
//    def sequence[A](l: List[Maybe[A]]): Maybe[List[A]] = ???

    def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f
    def liftMaybe[A, B](f: A => B): Maybe[A] => Maybe[B] = ma => ma map f
  }



}
