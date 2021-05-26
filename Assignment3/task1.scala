package Assignment3

object task1 extends App {

  val func = (a: Int,b:Int,c:Int) => (x:Int) => (a*(Math.pow(x,2))) + (b*x) + c
  val func2 = func(3,5,7)

  val listOfRandomXs = Seq.fill(10)(util.Random.nextInt(3 + 3) - 3)

  println(listOfRandomXs)

  println(listOfRandomXs.map(func2(_)))





}
