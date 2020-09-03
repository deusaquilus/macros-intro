package com.test.example

sealed trait Pace
object Pace {
  case object Briskly extends Pace
  case object Slowly extends Pace
}
sealed trait Location
object Location {
  case object MainSt extends Location
  case object MainAve extends Location
  case object CentralAve extends Location
}

case class Person(name:String, pace: Pace, location: Location) {
  def walk(location: Location, pace: Pace) =
    Person(name, pace, location)
}
