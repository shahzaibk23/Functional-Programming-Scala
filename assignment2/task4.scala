package assignment2

object task4 extends App {

  def sumOfArray(array: Array[Int]):Int = {

    def wrapper(array: Array[Int], outputArray:Array[Int], index:Int):Array[Int] = {
      if(index == array.size) outputArray
      else wrapper(array, if(array(index)%2 == 0) outputArray :+ array(index) else outputArray, index+1)
    }

    wrapper(array, Array(), 0).size
  }

  val array = Array.fill(100)(util.Random.nextInt((100)))

  // recursive function
  println(sumOfArray(array))

  // count higher order function
  println(array.count(_ %2 == 0))

}
