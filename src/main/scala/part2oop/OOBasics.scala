package part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  // Calling methods
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter(0)
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
}
//Defining classes Parameters vs fields
class Person( name: String, val age: Int = 0) {
  //body
  val x = 2 //field
  println(1 + 3)


  //Defining methods
  def greet(name:String):Unit = println(s"${this.name} says: Hi, $name")
  //overloading
  def greet():Unit = println(s"Hi, I am $name")

  //multiple constructors
  def this(name:String) = this(name,0)
  def this() = this("John Doe")
}// Constructor
// Class parameters are not fields keyword val
/*
 Novel and a Writter

Writer: first name, surname, year
  -method: fullname

Novel: name, year of release, author
  -method authorAge
  -isWrittenBy(author)
  -copy (new year of release) = new instance of Novel
*/
class Writer(firstname:String, surname:String, val year:Int){
  def fullname:String = s"$firstname $surname"
}
class Novel (name: String, yearOfRelease:Int, author:Writer){
  def authorAge = yearOfRelease - author.year
  def isWrittenBy(author:Writer) = author == this.author
  def copy(newYearOfRelease:Int):Novel = new Novel (name, newYearOfRelease, author)
}
/*
* Counter class
receives an int value
method current count
method to incremente / decremente = new Counter
overload inc/dec to receive an amount
*  */
class Counter(ini:Int){
  def currentCount():Int = ini

  def increment: Counter = {
    println("Incrementing")
    new Counter(ini + 1)
  }

  def decrement: Counter = {
    println("Decrementing")
    new Counter(ini - 1)
  }

  def increment(number:Int): Counter = {
    if (number <=0) this
    else increment.increment(number - 1)
  }

  def decrement(number:Int): Counter = {
    // new Counter(ini - number)
    if (number<=0) this
    else decrement.decrement(number - 1)
  }

  def print = println(ini)
}