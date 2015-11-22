package eu.daxiongmao.training.scala.chp2

import java.text.DateFormat
import java.util.{Date, Locale}

object Chapter2and3introduction {

  def main (args: Array[String]) {
    println("Hello world! This is my first scala test")

    println("===================== BASICS ====================")
    // Variables and java integration
    val now = new Date
    val dateFormat = DateFormat getTimeInstance(DateFormat.LONG, Locale.FRANCE)
    val dateFormatString = dateFormat format now
    println("It is " + dateFormatString)

    // A variable with a manually assigned type (this is NOT recommended)
    val valStringTest: String = "Specific, strongly typed, variable"
    println(valStringTest)

    // Careful!
    // "val" => immutable variable [= java 'final'] ; you cannot change the value
    // "var" => mutable variable ; you can change the value later on
    var varStringTest = "This is a mutable String. You can change it later on"
    varStringTest = "Let's change the value to something else!"
    println(varStringTest)
    println(" ")

    // Method call
    println("===================== Function call ====================")
    val maxNumber = maxFullSyntax(1, 4)
    println("Max number (expected: 4): " + maxNumber)
    println(" ")

    // Method that returns many values
    println("===================== Advanced function call ====================")
    println("this will return many types and values at once")
    val tupleMinMax = minMax(5, 3)
    println("Min: " + tupleMinMax._1 + " | Max: " + tupleMinMax._2 + " | " + tupleMinMax._3)
    println(" ")


    arrays()
    lists()
    maps()


    println("===================== Functions style ====================")
    val testArray = Array.apply("\nThis", "is", "a", "loop", "test", "to", "compare", "programming", "styles", ".")
    printArgsImperativeStyle(testArray)
    printArgsSemiFunctional(testArray)
    printArgsFunctional(testArray)


    println("===================== Read file from src/main/resources ====================")
    val fileToReadUrl = Chapter2and3introduction.getClass().getResource("Readme.txt")
    ReadFile.readFileContent(fileToReadUrl.getFile())

  }


  /**
    * Simple function that returns the higher parameter.
    * This is how you write a complete function with a return type + body
    */
  def maxFullSyntax(x:Int, y:Int): Int = {
    if (x > y)
      x
    else
      y
  }

  /**
    * Short way to express the same as maxFullSyntax
    * This is like Java: (x > y) ? x : y
    */
  def maxShortSyntax(x:Int, y:Int) = if(x > y) x else y

  /**
    * To get BOTH min + max into 1 method.
    * Thanks to "tuple" scala can return an array of Values, different types allowed.
    * @param x
    * @param y
    * @return
   *         Tuple3._1 = min
    *         Tuple3._2 = max
    *         Tuple3._3 = String: min _ max
    */
  def minMax(x: Int, y: Int): Tuple3[Int, Int, String] = {
    if (x < y) {
      return (x, y, x + "_" + y)
    } else {
      return (y, x, y + "_" + x)
    }
  }


  def arrays(): Unit = {
    println("===================== ARRAY ====================")
    // Size is fixed (immutable).
    // Content can change (mutable)
    // Array affectation uses () == you can call the method "update" to perform the same action
    val stringArray = new Array[String](3)
    stringArray(0) = "This"
    stringArray(1) = "is"
    stringArray update (2, "a test")

    // Loop "old school"
    println("1st array - ")
    for (currentVal <- stringArray) {
      print(currentVal + " ")
    }
    println(" ")

    // Better array factory
    val stringArray2 = Array.apply("\nThis", "is", "a", "second", "test")
    // Loop "new school" == This is like java8 streams.
    print("2nd array - ")
    stringArray2.foreach(currentVal => print(currentVal + " "))
    println(" ")

    // Another factory (recommended, less verbose)
    val stringArray3 = Array("\nThis", "is", "another", "test", "using", "single line", "declaration\n")
    print("3rd array - ")
    stringArray3.foreach(currentVal => print(currentVal + " "))
    println(" ")
  }

  def lists(): Unit = {
    println("===================== LIST ====================")
    // List are completely immutable: both size AND content cannot change.
    val oneTwoThreeFourFive = List(1, 2, 3, 4, 5)
    println("A list has a default string representation: " + oneTwoThreeFourFive)

    // You can concatenate list, it will return a NEW list
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println("If " + oneTwo + " and " + threeFour + " are two lists")
    println("  Thus, " + oneTwoThreeFour + " is another list, a new one.")

    // You can add values to a list, however the result is a NEW list with the prepend value
    val twoThree = List(2, 3)
    val oneTwoThree = 1 :: twoThree
    println("List with prepend value: " + oneTwoThree)

    // You can use empty list 'Nil'
    val oneTwoFive = 1 :: 2 :: 5 :: Nil
    println("List build using preprend & Nil: " + oneTwoFive)
    println(" ")
  }

  def maps(): Unit = {
    println("===================== MAP ====================")
    val myNewSet = Set("Guillaume", "Sisi")

    // MAP (immutable)
    val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V")
    val romanNumeral2 = romanNumeral + (9 -> "IX")
    println(romanNumeral)
    println(romanNumeral2)
    // Careful the following value is NOT added to the map, just to the printOut function
    println(romanNumeral2 + (8 -> "IIX"))

    // Map (mutable)
    var romanNumeral3 = scala.collection.mutable.Map(10 -> "X", 5 -> "V", 2 -> "II")
    romanNumeral3 += (1 -> "I")
    println(romanNumeral3)
    println(" ")
  }

  @deprecated("This is not functional programming", since = "0.1.0")
  def printArgsImperativeStyle(args: Array[String]): Unit = {
    println("=== loop imperative style ===")
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }

  @deprecated("This is not 100% functional programming", since = "0.1.0")
  def printArgsSemiFunctional(args: Array[String]): Unit = {
    println("=== loop semi functional style ===")
    for (arg <- args)
      println(arg)
  }

  def printArgsFunctional(args: Array[String]): Unit = {
    println("=== loop functional style ===")
    args.foreach(println)
  }

  }
