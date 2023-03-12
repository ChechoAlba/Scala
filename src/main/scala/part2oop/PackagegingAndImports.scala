package part2oop

import playground.{Playground, PrinceCharming, Cinderella => Princess}

import java.util.Date
import java.sql.Date

object PackagegingAndImports extends App{
  //package members are accessible by their simple name
  val writer = new Writer("Sergio", "Alba", 2023)
  // import package
  val playground =  Playground

  // package are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  //imports
  val prince = new PrinceCharming
  val princess = new Princess

  //1.use fq names
  // val date = new Date
  val sqlDate = new java.sql.Date(2018, 5 , 4)
  //2. use aliasing

  //default imports
  // java.lang - String, Object, Exception
  // Scala - Int, Nothing, Function
  // scala.Predef / println, ???
}
