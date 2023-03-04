package part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {
  def factorial(n:Int):Int = {
    if (n<=1) 1
    else {
      println("Computing factorial of " + n + " first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }


  def anotherFactorial (n:Int): BigInt = {
    @tailrec
    def factHelper(x:Int, accumulator: BigInt): BigInt =
      if(x<=1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = USE RECURSIVE CALL AS THE LAST EXPRESSION

    factHelper(n, 1)
  }
  //println(anotherFactorial(5000))
  /*
  anotherFactorial(10)
  factHelper(10, 1) factHelper(9, 10 * 1) factHelper(8, 9 * 10 * 1)...factHelper(2, 2*....* 10 * 1)
  factHelper(1, 1*2*3..*10) = 1*2*3..*10 -> Factorial
  */

  /*
    WHEN YOU NEED LOOPS, USE_TAIL_RECURSION
    CONCATENATE A STRING N TIMES
    IS PRIME FUNCTION TAIL RECURSIVE
   FINOBACCI FUNCTION TAIL RECURSIVE
  */
  def concatenateStrings(aString:String, n:Int):String={
    @tailrec
    def concaStringsHelp(acString :String, x:Int):String = {
      if (x<=1) acString
      else concaStringsHelp( acString + aString, x-1 )
    }
    concaStringsHelp(aString, n)
  }
  println(concatenateStrings("Sergio",10))
  def finobacciFunction(n: Int): Int = {
    @tailrec
    def finobacciHelp(x:Int, last: Int, nextToLast:Int):Int = {
      if (x >= n) last
      else finobacciHelp(x+1, last + nextToLast, last)
    }
    if (n<=2) 1
    else finobacciHelp(2, 1, 1)
  }
  println(finobacciFunction(8)) // 1 1 2 3 5 8 13 21
}
