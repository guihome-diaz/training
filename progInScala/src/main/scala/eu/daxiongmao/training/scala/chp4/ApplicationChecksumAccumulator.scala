package eu.daxiongmao.training.scala.chp4

/**
  * By extending the APPLICATION trait we don't need a main().
  * Everything will be consider as main() ! :-)
  *
  * !!!!! CAREFUL !!!!
  * Only use it for simple and single-thread applications or it will fail.
  */
object ApplicationChecksumAccumulator extends App {
  val txt = "So cool this Application root class! No main() required! But only for single-thread applications"
  val checksum = ChecksumAccumulator.calculate(txt)
  println("Checksum = " + checksum)
}
