package helo

object part3 extends App{

  val divideTenBy: Int => Option[Int] = b => if (b != 0) Some(10 / b) else None

  val list: List[Int] = List(5)
  val firstOptionalElement: Option[Int] = list.headOption

  println(firstOptionalElement)
                                          // Some(7) == , 7 => func == Some(Some(output))
  val divisionResult: Option[Option[Int]] = firstOptionalElement.map(divideTenBy)
  println("  -- Option.map : " + divisionResult)

  val divisionResult2: Option[Int] = firstOptionalElement.flatMap(divideTenBy)
  println("  -- Option.flatMap : " + divisionResult2)
                                          // Option[Option[Option[Option[Int]]]] -- Some(Some(Some(Some(2))))
  val resultMultipleOptions: Option[Int] = divideTenBy(2).flatMap(divideTenBy).flatMap(divideTenBy).flatMap(divideTenBy)
  println("  -- Multiple options : " + resultMultipleOptions)

  println("\n {COMPANY EXAMPLE}")
  case class Picture(asciiArt: String)
  case class Page(url: String, pictures: List[Picture])
  case class User(name: String, homePage: Option[Page])

  val john = User("John", Some(Page("www.john.com", List(Picture("♪┏(°.°)┛┗(°.°)┓┗(°.°)┛┏(°.°)┓ ♪")))))
  val jane = User("Jane", None)

  john.homePage.map(p => p.pictures.headOption).foreach(println)
  john.homePage.flatMap(p => p.pictures.headOption).foreach(println)
  jane.homePage.flatMap(p => p.pictures.headOption).foreach(println)

}

