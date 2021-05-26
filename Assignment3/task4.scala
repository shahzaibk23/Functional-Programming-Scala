package Assignment3

object task4 extends App {

  # 11.2
  val uList = List(1,2,3,4,5)
  val uList_Twice = uList.map(_*2)
  println(uList_Twice)
  def f(x:Int) = if(x>2) x*x else None
  val ulist_Squared = uList.map(f(_))
  println(ulist_Squared)

  # 11.3
  val uList = List(1,2,3,4,5)
  def g(v:Int) = List(v-1, v, v+1)
  val ulist_Extended = uList.map(g(_))
  println(ulist_Extended)
  val ulist_Extended_flatmap = uList.flatMap(g(_))
  println(ulist_Extended_flatmap)

  # 11.4
  val ulist = List(1,2,3,4,5)
  def f(x:Int): Option[Int] = if(x>2) Some(x) else None
  val ulist_selective = ulist.map(f(_))
  println(ulist_selective)
  val ulist_selective_flatmap = uList.flatMap(f(_))


}
