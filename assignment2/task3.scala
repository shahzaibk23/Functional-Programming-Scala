package assignment2

object task3 extends App {

  def sumOfArrays(array1:Array[Double], array2:Array[Double]):Array[Double] = {

    def wrapper(array1: Array[Double], array2: Array[Double], index:Int, array:Array[Double]):Array[Double] = {
      if(index == array1.size) array
      else wrapper(array1,array2,index+1, array :+ array1(index) + array2(index) )
    }
    wrapper(array1, array2, 0, Array())
  }

  println(sumOfArrays(Array(1, 2, 3), Array(4, 5, 6)).mkString("Array(", ", ", ")"))

}
