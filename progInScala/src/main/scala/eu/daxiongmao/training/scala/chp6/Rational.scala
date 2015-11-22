package eu.daxiongmao.training.scala.chp6

/**
  * This represents a rational number (x) where x = n/d <br>
  *   n = numerator<br>
  *   d = denominator<br>
  * <br>
  * Note that all values are immutable (~ Java: private final)
  */
class Rational(numer: Int, denom: Int) {

  // Construct validators
  require(denom != 0)

  // private attribute
  val greatestCommonDivisor = findGreatestCommonDivisor(numer.abs, denom.abs)

  // Associate constructor values to local attributes
  val numerator: Int = numer / greatestCommonDivisor
  val denominator: Int = denom / greatestCommonDivisor

  // Auxiliary constructor
  def this(realNumber: Int) = this(realNumber, 1)

  override def toString = numerator + "/" + denominator

  // Example of math operator + polymorphism
  def add(other: Rational): Rational = {
    new Rational(numerator * other.denominator + other.numerator * denominator, denominator * other.denominator)
  }
  def + (other: Rational): Rational = add(other)
  def + (other: Int): Rational = add(new Rational(other, 1))

  def multiple(other: Rational): Rational = {
    new Rational(numerator * other.numerator, denominator * other.denominator)
  }
  def * (other: Rational): Rational = multiple(other)
  def * (other: Int): Rational = multiple(new Rational(other, 1))

  def / (other: Rational): Rational = {
    new Rational(numerator * other.denominator, denominator * other.numerator)
  }
  def / (other: Int): Rational = /(new Rational(other, 1))

  // !!!! '-' is a keyword. You cannot call method - without this.
  def - (other: Rational): Rational = {
    new Rational(numerator * other.denominator - other.numerator * denominator, denominator * other.denominator)
  }
  def - (other: Int): Rational = this.-(new Rational(other, 1))


  def lessThan(other: Rational): Boolean = numerator * other.denominator < other.numerator * denominator

  def getMax(other: Rational): Rational = {
    if (this.lessThan(other)) {
      return other
    } else {
      return this
    }
  }

  private def findGreatestCommonDivisor(a: Int, b: Int): Int = {
      if (b == 0) {
        return a
      } else {
        return findGreatestCommonDivisor(b, a % b)
      }
  }

}
