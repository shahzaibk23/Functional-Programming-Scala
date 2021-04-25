package assignment2

object task2 extends App {

  def charArray(start:Int):List[Char] = {

    def wrapper(list:List[Char], state:Int, end:Int):List[Char] = {
      if(state == end) list
      else wrapper(state.toChar :: list, state + 1, end)
    }

    wrapper(List(), start, 123).reverse

  }

  // a === 97
  println(charArray(97))
}
