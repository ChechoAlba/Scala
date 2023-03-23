package part3fp

import scala.jdk.FunctionWrappers.RichFunction1AsToIntFunction

object WhatAFunction extends App{
  // Dream: Use functions as first class elements
  // Problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))
  // functiont types = Function1[A,B] .... FUNCTION 22
  val StringToIntConverter = new Function1[String, Int] {
    override def apply(element: String): Int = element.toInt
  }

  println(StringToIntConverter("3"))
  println(StringToIntConverter("3")+4)
  /*
  val adder = new Function2[Int, Int, Int]{
    override def apply (a:Int, b:Int): Int = a + b
  } */
  // Function Types Function2[A, B, R] === (A, B) => R
  val adder:((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  // ALL SCALA FUNCTIONS ARE OBJECTS. INSTANCES OF CLASSES DERIVATED OF FUNCTION1, FUNCTION2, ETC.
  /* Exercises
    1. A function which takes 2 strings and concatenates them
    2. Transform the MyPredicate and MyTransformer into function types
    3. Define a functions which takes an int and returns another function which takes an int and returns an int
      - what is the type of this function
      - how to do it
  */
  val concatenate:(String, String) => String = new Function2[String, String, String] {
    override def apply(a:String, b:String): String = a + b
  }

  val superAdder:Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]]{
    override def apply(x:Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
  
  // lambda
  val supperAdder2: (Int, Int) => Int = _ + _

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function
}


trait MyFunction[A, B] {
  def apply(element:A) : B
}