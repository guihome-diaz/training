package eu.daxiongmao.training.scala.chp4


/**
  * To run a method from another singleton ("object" scala).
  */
object RunChecksumAccumulator {

  def main(args: Array[String]) {
      val txt = "This is an example of string to compute checksum"
      val checksum = ChecksumAccumulator.calculate(txt)
      println("Checksum = " + checksum)
  }

}
