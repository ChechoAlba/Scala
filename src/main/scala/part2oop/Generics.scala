package part2oop

object Generics extends App{

  class MyList[A] {
    // Use Generic Type could be A or whatever
    // Use the same code on many potentially types

  }
  class MyMap[k,v]

  val myIntList = new MyList[Int]
  val myStringList = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]
  // multiple  types

  // Variance: if B extends A, should List[B] extends List [A]
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  // yes [A+] COVARIANCE
  class CoVarianceList[+A]
  val animal:Animal = new Cat
  val animalList:CoVarianceList[Animal] = new CoVarianceList[Cat]
  // no default [A]
  class InvarianList[A]
  val invariantAnimalList: InvarianList[Animal] = new InvarianList[Animal]
  // cotravariant [-A]
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]
  //BOunded types <:
  class Cage[A <: Animal](animal:A)
  val cage = new Cage(new Dog)

  class Car
  //generic type need proper type
  //val newCage = new Cage(new Car)
}
