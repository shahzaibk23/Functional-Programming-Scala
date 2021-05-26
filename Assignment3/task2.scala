package Assignment3

object task2 extends App {

  val func = (a: Int,b:Int,c:Int) => (x:Int) => (a*(Math.pow(x,2))) + (b*x) + c
  val func2 = func(3,5,7)

  val listOfRandomXs = List.fill(10)(util.Random.nextInt(3 + 3) - 3)

  val l1:List[Int] = listOfRandomXs

  val l2:List[Double] = listOfRandomXs.map(func2(_))

  val zip1 = l1.zip(l2)
  val zip2 = zip1.zipWithIndex.map{case ((a,b),c) => (a,b,c)}

  // 3 pair zip
  println(zip2)

  var zip3 = l2.map((_,1))

  val result = zip3.reduce((a,b) => (a._1+b._1, a._2+b._2))
  println(result)

  val mean = (result._1).toFloat / (result._2).toFloat
  println(mean)




}
