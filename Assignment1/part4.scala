package helo

object part4 extends App {

  val some1 = Some(1)
  val some2 = Some(2)
  val some3 = Some(3)
  val some4 = Some(4)

  val result = some1.flatMap { a =>
    some2.flatMap { b =>
      some3.flatMap { c =>
        some4.map { d => a * b * c * d }
      }
    }
  }
  println(result)


  val resultComprehension = for {
    s1 <- some1
    s2 <- some2
    s3 <- some3
    s4 <- some4
  } yield s1 + s2 + s3 + s4

  println(resultComprehension)



}
