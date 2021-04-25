package Assignment1
import java.util.concurrent.TimeUnit
import scala.concurrent
import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}
import scala.concurrent.duration._




object part7_ extends App {
  object Service1{
    def call(input:Int):Future[Int]=Future{
      TimeUnit.MILLISECONDS.sleep(500)
      input+1
    }
  }

  object Service2{
    def call(input:Int):Future[Int]=Future{
      TimeUnit.MILLISECONDS.sleep(500)
      input+2
    }
  }

  val comprehensionResult = for {
    r1 <- Service1.call(1)
    r2 <- Service2.call(r1)
  } yield r2

  comprehensionResult.onComplete {
    case Success(v) => println(s"  -- comprehensionResult : $v")
    case Failure(e) => println(s" -- error $e")
  }

  TimeUnit.SECONDS.sleep(2)

  println("[DEMONSTRATION] sequence")
  val sequence: Future[List[Int]] = Future.sequence(List(Service1.call(1), Service2.call(2)))

  sequence.onComplete {
    case Success(list) => println(list)
    case Failure(e) => println(e)
  }

  Await.result(sequence, 2.second)


  val allRoots:Double=>List[Double]=input => {
    val result = Math.sqrt(input)
    List(-result, result)
  }

  println("-- handling non determinism1 : "+allRoots(4.0).map(Math.abs).head )
  println("-- handling non determinism2 : "+allRoots(4.0).filter(_>0).head )

  case class Purchase(productName: String, date: String, profit: Int)
  val purchasesOnDate: String => List[Purchase]= _ match {
    case ("01-01-2016") => List(Purchase("tv","01-01-2016",300),Purchase("console","01-01-2016",200))
  }
  println("  -- counting profit - moving from set of possible values into a single value")
  val singleProfit=purchasesOnDate("01-01-2016").map(_.profit).reduce(_+_)
  println("  -- singleProfit : "+singleProfit)

  println(List(1,2,3).reduce(_+_))
  //1+2 - 3,3 -- 3+3



}
