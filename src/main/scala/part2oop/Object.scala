package part2oop

object Object{
  //scala does not have class level functionality - Static
  object Person { // type + it is only instance
    // static class / level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person (name: String){
    //instance level functionality
  }
  // Scala Applications = Scala object with
  // def main (args: Array[String]):Unit

  def main(args: Array[String]):Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = singleton instance
    val mary = Person
    val john = Person
    println(mary == john)

    // Scala object instance from class
    val mary_class = new Person("Mary")
    val john_class = new Person("John")
    println(mary_class == john_class)

    val bobbie = Person(mary_class, john_class)


  }


}
