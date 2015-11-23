package eu.daxiongmao.training.scala.chp8

import scala.io.Source


object FunctionsAndClosures {

  def main(args: Array[String]) {
    val testFileUrl = this.getClass.getResource("/Readme.txt")

    // =========== INNER FUNCTIONS =============
    // Output file's lines with min with of 15 characters
    println("Test 1 - inner function")
    processFileV1(testFileUrl.getPath, 15)

    // Output file's lines with min with of 5 characters
    println("Test 2 - inner function re-using upper function's arguments")
    processFileV2(testFileUrl.getPath, 5)


    // =========== FUNCTIONS literals as variables (first-class functions) =============
    println("Test 3 - literals as variables")
    val increase = (x: Int) => x + 1
    val y = increase(10)
    assert(y == 11)
    println("183 will be increase to: " + increase(183))


    val increaseALot = (x: Int) => {
      (x * 10 + x + 1) * x
    }
    println("183 will be increase a lot to: " + increaseALot(183))


    // =========== Example of filter with type detection ===========
    println("Test 4 - filtering and type detection")
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    // 'classic' expression
    println("Numbers filters: " + someNumbers.filter((x: Int) => x > 0))
    // Shortcut expression (auto detection of types)
    println("Numbers filters (type detection): " + someNumbers.filter((x) => x > 0))
    println("Numbers filters (type detection, short): " + someNumbers.filter(x => x > 0))
    // Extremely short expression using '_'.
    //   underscores as placeholders for one or more parameters,
    //   as long as each parameter appears only one time within the function literal.
    println("Numbers filters (type detection, '_' operator): " + someNumbers.filter(_ > 0))


    // =========== '_' examples ===========
    println("Test 5 - literals as variables")
    // Usage of '_' in loops
    println("List of numbers: ")
    someNumbers.foreach(println _)
    // When a function as only one arg. you don't need to put the _
    println("List of numbers [short]: ")
    someNumbers.foreach(println)
    // Function alias: usage of '_' to match all arguments
    val sumClassical = sum(1, 4, 5)
    val sumSymlink = sum _
    val sumModern = sumSymlink(1, 4, 5)
    assert(sumClassical == sumModern)
    // functions renaming
    val sumAlternate = sum(10, _:Int, 5)
    val sumAlternateResult = sumAlternate(7)
    assert(22 == sumAlternateResult)


    // =========== Closure ===========
    println("Test 6 - Closure")
    val constant = 90
    val addConstant = (x: Int) => x + constant
    println("simple closure example: " + constant + " + 12 = " + addConstant(12))


    // =========== varargs (* operator) ===========
    println("Test 7 - Varargs [repeated parameters]")
    // standard use
    echo("This", " is", " like", " Java:", " public void myMethod(String...) { }")
    // Array use (dynamic cast with '_')
    println("")
    val testString = Array("This"," is", " another", " example"," using", " Array[]")
    echo(testString: _*)


    // ============ Functions defaults ============
    // You can check listing 8.3 to set a default method parameter value so it can become optional


  }



  // Example of inner function within a function
  def processFileV1(filename: String, width: Int) {
    def printLinesWithMinWidth(filename: String, width: Int, line: String) {
      if (line.length > width)
        println(filename + ": " + line)
    }
    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      printLinesWithMinWidth(filename, width, line)
    }
  }

  // Example of inner function within a function, using the same arguments
  def processFileV2(filename: String, width: Int) {
    // (i) the inner function can access the upper function's arguments
    def printLinesWithMinWidth(line: String) {
      if (line.length > width)
        println(filename + ": " + line)
    }
    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      printLinesWithMinWidth(line)
    }
  }

  def sum(a: Int, b: Int, c: Int) = a + b + c


  // Like Java varargs (String...)
  def echo(args: String*) = for (arg <- args) print(arg)
}
