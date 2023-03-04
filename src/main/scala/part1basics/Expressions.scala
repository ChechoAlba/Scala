package part1basics

object Expressions extends App{
  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)

  println(1 == x)
  // == equality != > >= < <=

  println(!(1==x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works sith -= *= /= ..... side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  while (i<10){
    println(i)
    i += 1
  }

  // never write this again is more  for java / python.
  // EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit ===void
  println(aWeirdValue) // only value of unit ()

  // side effects: println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z>2) "hello" else "goodbye"
  }
  // Difference between hello world vs println hello world -> variable string vs expression unit side effects
  //2
  val someValue = {
    2 < 3
  } //is false boolean

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  } //42 int

}
