package part2oop

object AnonymousClasses extends App{
  abstract class Animal {
    def eat:Unit
  }
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("Anything")
  }
  println(funnyAnimal.getClass)

  /* AnonymousClasses$$anon$1
  The compiler do this:
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("Anything")
  }\val funnyAnimal: new AnonymousClasses$$anon$1
  */
  class Person (name: String) {
    def sayHi:Unit  = println(s"Hi, my name is $name, How can I help you?")
  }

  val jim = new Person("Jim") {
    override def sayHi:Unit = println(s"Hi, my name is Jim. How can I be of service?")
  }

    /*
    Generic trait MyPredicate[t] test vale of type t
    generic trait mytransformer [a,b] conver type a to type b
    my list map filter flatMap

    class EvenPredicate etends MyPredicate[Int]
    [1,2,3].map(n*2) = [2,4,6]
    [1,2,3,4].filtern%2) = [2,4]
    [1,2,3].flatMap(n=> [n,n+1]) = > [1,2,2,3,3,4]
    */


}
