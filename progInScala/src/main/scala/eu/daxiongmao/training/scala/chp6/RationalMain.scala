package eu.daxiongmao.training.scala.chp6


object RationalMain extends App {

  // ========= Class instances ==========
  val x = new Rational(1, 2)
  val y = new Rational(2, 3)
  println("x = " + x)
  println("y = " + y)

  // ========= Constructor params verification =========
  try {
    val z = new Rational(8, 0)
    println("Something is wrong!!! :( You should not be able to create such objects!!")
  } catch  {
    case e: IllegalArgumentException => println("As expected you cannot create a rational with denominator == 0")
  }

  // ============ Operations =========
  val sumXY = x.add(y)
  println("sum X + Y = " + sumXY)

  val isXlessThanY = x.lessThan(y)
  println("is X less than Y? " + isXlessThanY)
  println("is Y less than X? " + y.lessThan(x))

  val alpha = new Rational(89, 119)
  val delta = new Rational(52, 71)
  println(f"What is the bigger number: $alpha%s or $delta%s ? " + alpha.getMax(delta))

  val realNumber = new Rational(9)
  println(f"What is the bigger number: $alpha%s or $realNumber%s ? " + alpha.getMax(realNumber))


  val num1 = new Rational(90, 300)
  val num2 = new Rational(85, 200)
  println(f"What is the bigger number: $num1%s or $num2%s ? " + num1.getMax(num2))
  println(f"Sum using method declaration: $num1%s add $num2%s = " + num1.add(num2))
  println(f"Sum using mathematics sign: $num1%s + $num2%s = " + (num1 + num2))

  println(f"Multiplication using method declaration: $num1%s multiple $num2%s = " + num1.multiple(num2))
  println(f"Multiplication using mathematics sign: $num1%s * $num2%s = " + (num1 * num2))

  val realNumber2 = 5;
  println(f"$num1%s + $realNumber2%s = " + (num1 + realNumber2))
  println(f"$num1%s * $realNumber2%s = " + (num1 * realNumber2))
  println(f"$num1%s - $realNumber2%s = " + (num1 - realNumber2))
  println(f"$num1%s / $realNumber2%s = " + (num1 / realNumber2))
}
