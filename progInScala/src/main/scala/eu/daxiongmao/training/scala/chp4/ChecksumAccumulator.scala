package eu.daxiongmao.training.scala.chp4

import scala.collection.mutable.Map

/**
  * Example of companion object, based on Programming in Scala - Listing 4.2
  *
  * This show we can have both a CLASS and a SINGLETON ("object") with the same name inside the same file.
  * You'll find use examples of such an object in Chapter4
  */
class ChecksumAccumulator {
  private var sum = 0
  def add(letter: Byte) { sum += letter }
  def checksum(): Int = ~ (sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = Map[String, Int]()

  def calculate(text: String): Int =
    if (cache.contains(text))
      cache(text)
    else {
      val accumlator = new ChecksumAccumulator
      for (letter <- text)
        accumlator.add(letter.toByte)
      val checksum = accumlator.checksum()
      cache += (text -> checksum)
      checksum
    }
}
