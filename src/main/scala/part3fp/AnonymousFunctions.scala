package part3fp

object AnonymousFunctions extends App{

  //anonymous functions (LAMBDA)
  val doubler: Int => Int = x => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val doSomething: () => Int = () => 3

  println(doSomething) // function itself
  println(doSomething()) // call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b
  /*
    Exercises:
    1. My list replace all FunctionX calls with lambdas
    2. Rewrite the special adder as an anonymous function
  */

  val supperAdd = (x: Int) => (y: Int) => x + y
  println(supperAdd (3)(4))

}
