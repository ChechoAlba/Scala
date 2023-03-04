package part1basics

object Functions extends App {
  def aFunction(a:String, b:Int)  = {
    a + " " + b

  }

  println(aFunction("hello", 16))
  def aParameterlessFunction():Int =42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString:String, n:Int):String ={
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello ",3))

  // WHEN YOU NEED LOOPS, USE RECURSION

  def aFunctionWithSideEffect(aString: String):Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int,b :Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
  1. a greeting function
  2. Factoral function
  3. A finobacci function
    f(1) = 1
    f(2) = 1
    f(n) = f(n-1) + f(n-2)
  4. Tests if a number is prime
  */

  def greetingFunction (name:String, age:Int):Unit = println("Hi, my name is " +name+ " and I am " +age+ " years old")
  greetingFunction("Sergio", 33)

  def factoralFunction (n:Int):Int = {
    if (n <= 0) 1
    else n * factoralFunction(n-1)
  }
  println(factoralFunction(4))

  def finobacciFunction(n:Int):Int={
    if (n <= 2) 1
    else finobacciFunction(n-1) + finobacciFunction(n-2)
  }
  println(finobacciFunction(4))

  def isPrime(n:Int):Boolean = {
    def isPrimeUntil(t:Int):Boolean = {
      if (t <=1 ) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n / 2)
  }
  println(isPrime(97))
}
