package com.test.example

object ActuallyUseProcessTreeMacro {

  def method(person: Person): Person = {
    person.copy(name = "NewName")
  }

  def main(args: Array[String]):Unit = {
    val p = Person("Joe", Pace.Slowly, Location.CentralAve)
    val mainSt = Location.MainSt
    val briskly = Pace.Briskly
    //method(p.walk(mainSt, briskly)) // SELECT p.mainStr, p.briskly from Person p where p.doing = "walking"

    println( MacroHeader.macroMethod(p.walk(Location.MainAve, briskly)) ) //hellooooooooooooooooo

    // macroMethod( p.walk(Location.MaintSt, briskly) )
    // => p.walk(Location.CentralAve, briskly)
  }

}
