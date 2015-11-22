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
    val increase = (x: Int) => x + 1
    val y = increase(10)
    assert(y == 11)
    println("183 will be increase to: " + increase(183))


    val increaseAlot = (x: Int) => {
      (x * 10 + x + 1) * x
    }
    println("183 will be increase a lot to: " + increaseAlot(183))

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
}
