package Assignment1

import com.sun.net.httpserver.Authenticator.{Failure, Success}
import javafx.scene.effect.FloatMap

import scala.util.{Failure, Success, Try}

object part5_ex extends App {

  def toStr(s:String):Option[String] = {
    try {
      Some(s)
    } catch {
      case e:Exception => None
    }
  }
  def addStr(s1: String, s2: String, s3: String, s4: String): String = {
    s1+s2+s3+s4
  }
  def tryToAdd(s1: String, s2: String, s3: String, s4: String)
  = for {
    ss1 <- toStr(s1)
    ss2 <- toStr(s2)
    ss3 <- toStr(s3)
    ss4 <- toStr(s4)
  } yield Try(ss1+ss2+ss3+ss4)

  println(tryToAdd("a ","b ","c ","d"))




}
