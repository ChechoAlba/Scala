package Exercises

import com.sun.tools.sjavac.Transformer

import scala.runtime.Nothing$
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
  //hofs
  def foreach(f: A => Unit): Unit
  def sort(compare:(A,A)=>Int): MyList[A]
  def zipWith[B,C] (list: MyList[B], zip:(A,B)=>C): MyList[C]

  def fold[B] (start: B)(operator: (B, A) => B):B


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

  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing)=> Int) = Empty

  def zipWith[B,C](list:MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty

  def fold[B] (start: B)(operator: (B, Nothing) => B):B = start

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

  def foreach(f:A => Unit):Unit ={
    f(h)
    t.foreach(f)
  }

  def sort(compare:(A, A)=>Int): MyList[A] = {
    def insert(x:A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x,Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x,sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B,C] (list: MyList[B], zip:(A,B)=>C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }
  /*
  [1,2,3].fold(0)(+) =
  [2,3].fold(1)(+)
  =[3].fold(3)(+)
  =[].fold(6)(+)
  =6
  */
  def fold[B] (start: B)(operator: (B, A) => B):B =
    t.fold(operator(start, h))(operator)

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
  val anotherlistOfIntegers: MyList[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
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

  listOfIntegers.foreach(println)

  println(listOfIntegers.sort((x, y) => y - x))
  println(anotherlistOfIntegers.zipWith(listOfStrings, _ +" - " + _))

  println(listOfIntegers.fold(0)(_ + _))
}