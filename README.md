# INTRODUCTION
Repository about my first Scala course.
The code and excercises in this repository are relationship with an Udemy course about Scala.

## Section 01 Scala Basics
* Values, variables and Types
* Expressions
* Functions
* Type Inference
* Recursion
* Call by Name vs Call by Value
* Default and Named Arguments
* Operations on Strings

## Section 02 Oriented object programming
* OOB Basics
* Methods Notations
  * Infix notations: for methods with one parameter mary likes "Inception" (object method parameter)
  * prefix notation !mary == mary.unary_! (only allowed +,-,!,~)
  * postfix notation, for methods with no parameters => mary.isAlive == mary isAlive
  * apply method / is special, you can call the method how a function method() mary.apply() == mary()
* Scala objects
  * Scala does not have static values methods
  * are in ther own class
  * are the only instance
  * singleton pattern in one line
  * Scala companions
    * can access each others private members
  * Scala applications
* Inheritance
  * Class extends class - inheritance all no private-protected methods

## The tech stack of this repo is:
* Scala 3.2.2
* IntelliJ
* JVM Jdk - 17
* sbt 1.8.2