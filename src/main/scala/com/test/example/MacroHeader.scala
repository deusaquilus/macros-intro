package com.test.example

import scala.language.experimental.macros

object MacroHeader {
  def macroMethod(expression:Person):Any = macro MacroSource.macroMethod
}
