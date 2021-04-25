package Assignment1

import com.sun.xml.internal.bind.v2.model.core.MaybeElement


object part2_exercises extends App{


  // --- filter fold
  def UsersDAS(id:Int, list:List[Int]) = {

    val success:Int => String = i => s"<h1> SUCCESSS </h1> "
    val error:String = "<h1> SORRY USER NOT FOUND </h1>"

    val check: Option[Int] = if (list.contains(id)) Some(id) else  None
    val check2: Option[Int] = Some(id).filter(list.contains)

    val result = check2.fold(error)(success)
    println(result)
  }

  // map fold
  def UsersDAS2(id:Int, list:List[Int]) = {

    val checker: Int => Option[Int] = i => if(list.contains(i)) Some(i) else None
    val checker2: Int => Option[Int] = i => Some(i).filter(list.contains)

    val success:Int => String = i => s"<h1> SUCCESSS </h1> "
    val error:String = "<h1> SORRY USER NOT FOUND </h1>"

    val decision: Option[Int] => String = i => i.fold(error)(success)

    Some(id).map(checker2).map(decision).foreach(println)

  }

  UsersDAS2(3,List(1,2))



  def lift[A, B](f: A => B): Option[A] => Option[B] = {
    func => func.map(f)
  } // _ == func => func



  val nums = List(1,2,3)

  val newN = nums.map(_+1)
  println(newN)

  val m1 = Map("geeks" -> 5, "for" -> 3, "cs" -> 2)

  // Applying empty method
  val result = m1.empty

  // Displays output
  println(result)


  // SEALED TRAITS FOR MAYBE, JUST , EMPTY
  sealed trait Maybe[+A]
  case class Just[A](value: A) extends Maybe[A]
  case object Empty extends Maybe[Nothing]

  // MAYBE MAP AND LIFT MAYBE!
  def maybeMap[A, B](m: Maybe[A])(f: A => B): Maybe[B] = m match {
    case Just(m) => Just(f(m))
    case Empty => Empty
  }
  def liftMaybe[A, B](f: A => B): Maybe[A] => Maybe[B] = {
    func => maybeMap(func)(f)
  }

}
