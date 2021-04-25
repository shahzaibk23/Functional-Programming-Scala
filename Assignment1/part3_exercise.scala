package Assignment1

object part3_exercise extends App {

  val lastMeetup: MeetupDomain.User => Option[MeetupDomain.MeetupHistory] = i => Some(i.history.last)
  val listOfMeetups: MeetupDomain.User => Option[List[MeetupDomain.MeetupHistory]] = i => Some(i.history)
//  println(UsersDAO.find(1))m

  def usersLAstMeetup(user:Option[MeetupDomain.User], last:MeetupDomain.User => Option[MeetupDomain.MeetupHistory] ): Option[MeetupDomain.MeetupHistory] = user.flatMap(last)
  println(usersLAstMeetup(UsersDAO.find(1), lastMeetup))

  def meetupHistory(user:Option[MeetupDomain.User], func:MeetupDomain.User => Option[List[MeetupDomain.MeetupHistory]]):Unit = {
    user.flatMap(func).foreach(println)
  }


  meetupHistory(UsersDAO.find(1), listOfMeetups)
//  println(meetupHistory flatMap toHTML)



  object MeetupDomain {

    case class Picture(asciiArt: String)

    case class MeetupHistory(title: String, picture: Option[Picture])

    case class User(id: Int, name: String, email: String, history: List[MeetupHistory])

  }
  object UsersDAO {

    import MeetupDomain._

    val meetupHistory1 = MeetupHistory("FP Scala", Some(Picture("SCALA_LOGO")))
    val meetupHistory2 = MeetupHistory("FP Java", None)
    val user1 = User(1, "FirstUser", "firstEmail@domain.com", List(meetupHistory1, meetupHistory2))
    val user2 = User(2, "SecondUser", "secondEmail@domain.com", List())
    private val database = Map(1 -> user1, 2 -> user2)
    def find(id: Int): Option[User] = database.get(id)
  }

  object Conversions {

    import FrontEnd._
    import MeetupDomain._

    def userToHTML(u: User): HTML = s"""<a href="mailto:${u.email}">${u.name}</a>"""
    //EXERCISE
//    def meetupHistoryToHTML(mh: MeetupHistory) = ??? //"<h1>title</h1><img>image</img>"
  }
  object FrontEnd {
    type HTML = String
    def displayPage(body: String): HTML =s"""<html><body>$body</body></html>"""
    def displayError(content: String): HTML =s"""<h1>THERE IS AN ERROR : $content</h1>"""
  }


  //ADDITIONAL
  object EffectsLibrary {

    sealed trait Maybe[+A]
    case class Just[A](value: A) extends Maybe[A]
    case object Empty extends Maybe[Nothing]

    //EXERCISE
    def flatMap[A, B](m: Maybe[A])(f: A => Maybe[B]): Maybe[B] = m match {
      case Just(m) => f(m)
      case Empty => Empty
    }

    //EXERCISE
    def map2[A, B, C](m1: Maybe[A], m2: Maybe[B])(f: (A, B) => C): Maybe[C] = m1 match {
      case Just(m1) => m2 match {
        case Just(m2) => Just(f(m1,m2))
        case Empty => Empty
      }
      case Empty => Empty
    }

    def map[A, B](m: Maybe[A])(f: A => B): Maybe[B] = m match {
      case Just(v) => Just(f(v))
      case Empty => Empty
    }

    def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f
    def liftMaybe[A, B](f: A => B): Maybe[A] => Maybe[B] = ma => map(ma)(f)


  }



}
