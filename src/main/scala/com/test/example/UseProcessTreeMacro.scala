package com.test.example

import scala.language.experimental.macros

object UseProcessTreeMacro {
  def run(expression:Any):Any = macro ProcessTreeMacro.run
}
