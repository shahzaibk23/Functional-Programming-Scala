package assignment2

object ex2 extends App {
  val m1 = Map("abc" -> "xyz")
  //m1 += ("def" -> "uvw") This is not possible because val creates an immutable Map

  var m2 = Map("abc" -> "xyz")
  m2 += ("def" -> "uvw") // This is possible now because var creates mutable Map

  // Same goes for Set

  val s1 = Set(2, 4, 5)
  //s1 += (3,4) not possible because of val

  var s2 = Set(2, 4, 5)
  s2 += (3,4) // possible because of var


  println(m1,m2)
  println(s1,s2)

}
