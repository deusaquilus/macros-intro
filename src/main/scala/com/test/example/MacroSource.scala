package com.test.example

import reflect.macros.{Context => MacroContext}
import scala.language.experimental.macros

class MacroSource(val c:MacroContext) {
  import c.universe._

  def macroMethod(expression: Tree): Tree = {
    val outputExpression =
      expression match {

         case q"$p.walk($loc, briskly)" =>
           loc match {
             case Select(Ident(TermName(_)), TermName(term)) if (term.startsWith("Main")) =>
               println("Matched The Expression")
               q"$p.walk(Location.CentralAve, briskly)"
             case other =>
               println("Did not match expression, returning initial expression")
               expression
           }

//        case Apply(Select(id @ Ident(_), TermName("walk")), List(  // p.walk(
//          Select(Ident(TermName("Location")), TermName("MainSt")), // Location.MainSt
//          Ident(TermName("briskly"))                               // briskly)
//        )) => {
//          println("Case Matched, Changing Location!")
//          Apply(Select(id, TermName("walk")), List(                      // p.walk(
//            Select(Ident(TermName("Location")), TermName("CentralAve")), // Location.CentralAve
//            Ident(TermName("briskly"))                                   // briskly)
//          ))
//          // Person(?, Location.CentralAve, briskly)
//        }
        case other => other
      }

    println(s"Initial Expression: ${showRaw(expression)}")
    println(s"Output Expression: ${showRaw(outputExpression)}")
    outputExpression
  }
}
