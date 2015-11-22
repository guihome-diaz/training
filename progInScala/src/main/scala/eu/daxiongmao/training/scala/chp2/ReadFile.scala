package eu.daxiongmao.training.scala.chp2
import scala.io.Source

object ReadFile {

  def main (args: Array[String] ) {
    // Read content of the file provided by args(0)
    if (args.length > 0) {
      readFileContent(args(0))
    } else {
      Console.err.println("You must provide a filename (absolute path) to read")
    }
  }

  def readFileContent(filePath: String): Unit = {
    for (line <- Source.fromFile(filePath).getLines()) {
      println(" | " + line)
    }
  }


}
