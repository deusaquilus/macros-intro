package com.test.example

object ActuallyUseProcessTreeMacro {

  def main(args: Array[String]):Unit = { //helloooooooooooo
    val foo: String = "blah"
    println( "Result Is: " + UseProcessTreeMacro.run(foo) )
    println( "Result Is: " + UseProcessTreeMacro.run(foo.toUpperCase()) )
    println( "Result Is: " + UseProcessTreeMacro.run(foo.substring(2)) )

    println( "Result Is: " + UseProcessTreeMacro.run("blahbabdyblah") )
    println( "Result Is: " + UseProcessTreeMacro.run("blahbabdyblah".toUpperCase) )
    println( "Result Is: " + UseProcessTreeMacro.run("blahbabdyblah".substring(2)) )

    println( "Result Is: " + UseProcessTreeMacro.run(() => {
      import java.util.ArrayList
      new ArrayList[String](4)
    }) )
  }

}
