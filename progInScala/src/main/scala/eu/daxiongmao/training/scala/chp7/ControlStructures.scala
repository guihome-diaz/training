package eu.daxiongmao.training.scala.chp7


object ControlStructures extends App{


  println("from x to y (scala: TO y)")
  for (i <- 1 to 4)
    println("i = " + i)

  println("from x to y-1 (scala: UNTIL y)")
  for (i <- 1 until 4)
    println("i = " + i)

  println("from x to y-1 (scala: UNTIL y) with single condition")
  for (i <- 1 until 16 if (i % 2 == 0))
    println("i = " + i)

  println("from x to y-1 (scala: UNTIL y) with many conditions")
  for (i <- 1 until 30
            if (i % 2 == 0)
            if (i % 10 == 0)
      )
    println("i = " + i)

  // Only the last line of the yield is saved
  println("from x to y-1 (scala: UNTIL y) with many conditions, save results")
  val numbers = for (i <- 0 until 40
       if (i % 2 == 0)
       if (i % 10 == 0)
  ) yield {
    println("i = " + i)
    i
  }
  assert(numbers.size == 4)
  for (nb <- numbers)
    println("save value: " + nb)



  // Scala match (~ java Switch)
  // No break because it's not a cascade! You can yield the result in a val
  val item = "salt"
  val relatedItem = item match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case _ => "default case"
  }
  println("Item '" + item + "' is related to: " + relatedItem)

}
