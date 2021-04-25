package Assignment1


class User(var name:String){}

object part1_exercises extends App{


  def UsersDAO(list:List[String],user:User): Unit ={
    if(list.contains(user.name)){
      println("<h1> SUCCESSSSSS </h1> \n <p> WELCOME "+user.name+ " </p>")
    } else {
      println("<h1> SORRY USER NOT FOUND :/ </h1>")
    }
  }

  UsersDAO(List("abc","def"), new User("cc"))


}
