package Exercises

import scala.util.NotGiven

abstract  class MyList[+A]  {
  /*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  override special method toString => a string representation of the list
  */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element:B): MyList[B]
  def printElements:String
  override def toString:String = "[" + printElements + "]"

  def map[B] (transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  //CONCATENATION
  def ++[B >: A] (list: MyList[B]): MyList[B]

}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()

  def tail: Nothing = throw new NoSuchElementException()

  def isEmpty: Boolean = true

  def add[B >:Nothing] (element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  //concatenation
  def ++[B >: Nothing] (list: MyList[B]): MyList[B] = list

}

case class Cons[+A] (h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add [B>:A] (element: B): MyList[B] =  new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h.toString + " "  + t.printElements

  def filter (predicate: A => Boolean): MyList[A] =
    if (predicate.apply(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /*
  [1,2,3].map(n*2)
   = new Cons(2, [2,3].map(n*2)
  = new Cons(2, new Cons (4, [3].map(n*2)
  = new Cons(2, new Cons(4, new Cons (6, Empty.map(n*2)))
  = new Cons(2, new Cons(4, new Cons (6, Empty)))
  */
  //High order functions
  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer.apply(h), t.map(transformer))

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer.apply(h) ++ t.flatMap(transformer)

  def ++[B >: A] (list: MyList[B]): MyList[B] =
    new Cons(h, t ++ list)

}
/*
trait MyPredicate[-T] {
  def test (elem: T): Boolean
}

trait MyTransformer[-A,B]{
  def transfom (elem:A) :B
}
*/

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", new Cons("OOB", Empty)))

  println(listOfStrings.toString)
  println(listOfIntegers.toString)

  println(listOfIntegers.filter(new Function1[Int, Boolean] {
    override def apply(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println(listOfIntegers.map(new Function1[Int,Int]{
    override def apply(elem: Int): Int = elem * 2
  }).toString)

  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]]{
    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)

  // like lambdas

  println(listOfIntegers.filter(elem => elem % 2 == 0).toString)
  println(listOfIntegers.filter(_ % 2 == 0).toString)

  println(listOfIntegers.map(elem => elem * 2).toString)
  println(listOfIntegers.map(_ * 2).toString)

  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString)




  val clonelistOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(clonelistOfIntegers == listOfIntegers)
}