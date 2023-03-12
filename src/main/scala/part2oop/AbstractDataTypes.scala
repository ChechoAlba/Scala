package part2oop

object AbstractDataTypes extends App{
  // abstract members
  abstract class Animal {
    val creatureType: String
    def eat:Unit
  }
  // you can not instance an abstract class
  //Use an abstract class for extends from it new classes -> you have to override the vals and methods
  class Dog extends Animal{
    override val creatureType: String = "Canine"
    override def eat:Unit = println("crunch crunch")

    //traits
    trait Carnivore{
      def eat(animal: Animal):Unit
      val preferredMeal: String = "fresh meat"
    }

    trait ColdBlooded
    class Crocodile extends Animal with Carnivore with ColdBlooded {
      override val creatureType: String = "croc"
      def eat: Unit = println("nomnomnom")
      def eat(animal: Animal): Unit = println(s"I am croc and I am eating ${animal.creatureType}")
      val dog = new Dog
      val croc = new Crocodile
      croc.eat(dog)

      // traits vs abstract classes
      // 1 - traits do not have constructor parameters
//      2 - multiple traits may be inherited by the same class
//      3 - traits = behavior
    }
  }
}
