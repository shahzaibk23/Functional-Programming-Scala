package Assignment1

object part7_ex extends App {

  case class Driver(name: String)

  case class Car(model: String)

  val drivers = List(Driver("John"), Driver("Jane"), Driver("Kubica"))
  val cars = List(Car("Polonez"), Car("Porsche"))

  def combinations() = for {
    car <- cars
    driver <- drivers
  } yield (driver.name, car.model)

  combinations().foreach(println


  )
}
