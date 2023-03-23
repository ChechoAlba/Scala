package part3fp

object HOFsCurries extends App{

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // Higher order function (HOF)
  // function that applies a function n times over a value X
  // nTimes (f, n, x)
  // nTimes (f, 3, x) = f(f(f(x)))
  def nTimes(f: Int => Int, n: Int, x:Int):Int = {
    if (n<=0) x
    else nTimes(f, n-1, f(x))
  }
  val plusOne: Int => Int = _ + 1
  println(plusOne(1)) // result = 2
  println(nTimes(plusOne, 10, 1))
  // return a lambda val y = increment10(1)
  def nTimesBetter(f: Int => Int, n:Int): (Int => Int) = {
    if ( n <=0 ) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1) (f(x))
  }
  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  //curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // lambda y = 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double):String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f") // curriedFormatter("%4.2f")(Math.PI)
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f") // curriedFormatter("%10.8f")(Math.PI)

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
  println(curriedFormatter("%4.2f")(Math.PI))
  println(curriedFormatter("%10.8f")(Math.PI))
}
