package Assignment3

object task5 {
  import scala.util.control.Breaks._


  // UP TO DOWN COUNTER
  class UptoDownCounter{
    val initial = 0
    val max = 10

    var state = mainObj.idle
    var count = initial

    while (true){
      state match {
        case "idle" => {
          print(s"${count}\n")
          count = count + 1
          state = mainObj.up
        }
        case "up" => {
          if (count == max){
            count = count - 1
            state = mainObj.down
          }
          else{
            count = count + 1
            println(count)
          }
        }
        case "down" => {
          if(count == initial){
            state = mainObj.quit
          } else {
            count = count - 1
            println(count)
          }
        }
        case "quit" => break
      }
    }
  }


  object mainObj extends Enumeration {

    val idle = "idle"
    val up = "up"
    val down = "down"
    val quit = "quit"

    def main(args:Array[String]): Unit = {
      val obj = new UptoDownCounter()
    }
  }

}
