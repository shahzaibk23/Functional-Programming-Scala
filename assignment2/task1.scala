package assignment2
import scala.util.Random

object task1 extends App {

  // pure recursive function for generating random number of size itemsRange within range from starRange to endRange and putting them in list
  def numberGenerator(list: List[Int], startRange: Int, endRange:Int, itemsRange:Int):List[Int] = {
    def wrapper(list: List[Int],startRange: Int, endRange:Int, itemsRange:Int, count:Int ):List[Int] = {
      if(count == itemsRange) list
      else wrapper(Random.between(startRange,endRange) :: list, startRange,endRange,itemsRange,count+1)
    }
    wrapper(list, startRange, endRange, itemsRange, 0)
  }

  val list = numberGenerator(List(), 50,500, 15)
  println("List of Random Number: "+ list)


  // pure recursive function to find prime numbers from list and putting them in iterator
  def putPrimesInIterator(iterator:Iterable[Int],list:List[Int]):Iterable[Int] = {
    val isPrime:Int => Boolean = (num:Int) => ! ((2 until num-1) exists (num % _ == 0))
    def wrapper(iterator: Iterable[Int], list: List[Int], index:Int):Iterable[Int] = {
      if(index == list.length) iterator
      else wrapper(if(isPrime(list(index))) iterator ++ Iterable[Int](list(index)) else iterator, list, index +1 )
    }
    wrapper(iterator, list, 0)
  }

  val primes = putPrimesInIterator(Set(), list)
  println("List of Prime Numbers: " + primes)

  // pure function to use the scala collection SortedSet and sort any given Iterable.
  import scala.collection.SortedSet
  def sortSet[A](unsortedSet: Iterable[A])(implicit ordering: Ordering[A]): SortedSet[A] =
    SortedSet.empty[A] ++ unsortedSet
  println("Sorted List of Prime Numbers: " + sortSet(primes))

  // pure recursive function to put sortedIterable elements and put them in map, with their indexes as keys
  def addToMap(map:Map[Int,Int], sortedIterable: Iterable[Int]):Map[Int,Int] = {
    def wrapper(map:Map[Int,Int], sortedIterable:Iterable[Int], index:Int):Map[Int,Int] = {
      if(index == sortedIterable.size) map
      else wrapper(map + (index -> sortedIterable.drop(index).take(1).toList.head),sortedIterable, index+1)
    }
    wrapper(map, sortedIterable, 0)
  }
  var mapp:Map[Int, Int] = Map()
  val addedMap = addToMap(mapp, sortSet(primes))
  println("Map of Prime Numbers and their indexes" + addedMap)

}

