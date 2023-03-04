package part1basics

object CBNvsCBV extends App{
  def calledByValue(x:Long):Unit = { // Value is computed before call, same value used everywhere
    println("by value "+x)
    println("by value "+x)
  }

  def calledByName(x: => Long): Unit = { //expression is passed literally, expression is evaluated at every use within
    println("by name " + x)
    println("by name " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x) // el => significa que se ejecuta el parametro cuando se llame, no antes de la ejecucion de la funcion

  printFirst(34, infinite()) // El infinite() nunca llega a ejecutar ya que es un parametro calle by Name
}
