package part2oop

import scala.language.postfixOps

object MethodNotations extends App{
  class Person (val name: String, favoriteMovie: String, val age:Int = 32){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person):String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person):String = s"${this.name} is hanging out with ${person.name}"
    def +(aString: String):Person = new Person(s"$name ($aString)", favoriteMovie)
    def unary_! : String = s"$name, what the heck"
    def unary_+ :Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply():String = s"Hi, my name is $name and I like $favoriteMovie"

    def learns(subject:String) :String = s"${this.name} learns $subject"
    def learnsScala: String = this.learns("Scala")

    def apply(nTimes:Int):String = s"${this.name} watched ${this.favoriteMovie} $nTimes times"
  }
  val mary = new Person("Mary", "Inception")
  println (mary.likes("Inception"))
  println(mary likes "Inception") //equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person ("tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS.
  // Akka actors have !?

  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  //unary prefix only works with - + ! ~

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive )
  println(mary isAlive )

  //apply
  println(mary.apply())
  println(mary()) // equivalent / i defined an apply method

  // Exercises
  /*
  1. Overload the + operator
    mary + "the rockstar" = > new person "Mary (the rockstar)"
  */
  val maryTRS = mary.+("the rockstar")
  println(maryTRS.name)

  /* Add an age to the person class
  Add a unary + operator => new person with the age + 1
  +mary => mary with the age incrementer
  */
  val maryPlusOne = +mary
  println(maryPlusOne.age)
  /* Add a learns method in the Person class = mary learns Scala
  * add a learnsScala method, calls learns method with "Scala"
  use it in postfix notation
  * */
  println(mary learnsScala)

  /*
  overload the apply method
  mary.apply(2) => "mary watched inception 2 times"
  */
  println(mary(5))



}
