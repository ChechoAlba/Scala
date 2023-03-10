package part2oop

object InheritanceAndTraits extends App{
  sealed class Animal {
    val creatureType: String = "domestic"
     def eat = println("nomnom")

  }
//Single class inheritance
  class Cat extends Animal{

    def crunch = {
      eat
      println(" crunch crunch ")
    }

  }

  val cat = new Cat
  cat.crunch

  //constructors
  class Person(name: String, age: Int) {
    def this(name:String) = this(name, 0)
  }
  class Adult (name:String, age: Int, idCard:String) extends Person(name, age) // always specified the parameters of the constructor parent

  class Babe (name:String, age: Int, idCard:String) extends Person(name)
  //overriding
  class Dog (override val creatureType:String ) extends Animal{
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("kb9")
  dog.eat
  println(dog.creatureType)

  //type substitution (broad: polymorphism)
  val unknownAnimal:Animal = new Dog("K9")
  unknownAnimal.eat

  // Overriding vs Overloading

  // super -> method or field of parent class
  // preventing overrides
  // 1 - use final on member
  // 2 - use final class / the entire class can not be extended
  // 3 - sealed the class = extend classes in THIS FILE, prevent extension in other files


}
