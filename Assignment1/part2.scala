package Assignment1

object part2 extends App{
  var i: Int  = 4

  val multiplyByTwo: Int => Int = i => i * 2

  // experiment with String return
  val multiplyByTwo3: Int => String = i => "hh"

  // alternative
  def multiplyByTwo1(i: Int): Int = {
    return i * 2
  }
  // yes, this function id pure
  println(multiplyByTwo(2))

  val display: Int => String = i => s"  -- RESULT : $i"
  // yes it has the knowledge of context

  println(display(5))

  val some: Option[Int] = Some(7)
  some.map(multiplyByTwo).foreach(i => println(s"  -- multiplied by two : $i"))



  val s: Option[Int] = some.map(multiplyByTwo)
  println(s)

//  val newSum = some.map(multiplyByTwo)
//  println(multiplyByTwo(newSum))


  val default = some.filter(_ > 10).getOrElse(-1) // condition false

  val default2 = Some(17).filter(_ > 10).getOrElse(-1) // condition true

  println(default)
//  def deafulFunc(i:Int) = {
//    if(i > 10)
//  }
  some.filter(_ > 10).orElse(Some(-1)).map(i => s" -- filter(remove) & orElse -1 : i=$i").foreach(println)
  some.filter(_ < 10).orElse(Some(-1)).map(i => s" -- filter & orElse : i=$i").foreach(println)

  // orElse takes   and returns optional value
  // getOrElse takes and returns alternate value


  some match {
    case Some(value) => println(s"  -- pattern matching value : $value")
    case None => println(s"  --  pattern matching is empty")
  }

  val onSuccess: Int => String = i => s"business value $i"
  val onError: String = "raise an error"
  val result = None.fold(onError)(onSuccess)


  // fold, pattern matching and filter does the same job.
  println(result)




}
