package com.test.example

import reflect.macros.{Context => MacroContext}
import scala.language.experimental.macros

class ProcessTreeMacro(val c:MacroContext) {
  import c.universe._

  def run(expression: Tree) = {

    //println(showRaw(reify("foobar")))

    var changeOutput: Tree = null

    expression match {
      case Ident(TermName(value)) =>
        println("The expression is a term: " + value + " the tree was: " + expression)
      case Literal(Constant(value)) =>
        println("The expression is a constant value: " + value + " the tree was: " + expression)

//      case Apply(Select(value, TermName("toUpperCase")), _) =>
//        println("We detected to toUpperCase, remove it! Splice back in: " + showRaw(value))
//        changeOutput = value

      case q"$value.toUpperCase()" =>
        changeOutput = q"$value.substring(2)"

        println("We detected to toUpperCase, get the 4th char instead! Splice back in: " + showRaw(changeOutput))


      case other =>
        println("The expression was not matched: " + showRaw(expression))
    }

    if (changeOutput != null) changeOutput
    else expression
  }
}
