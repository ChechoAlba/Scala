package part1basics

object DefaultArgs extends App{
  def trFact(n:Int, acc:Int = 1):Int = {
    if (n<=1) acc
    else trFact(n-1, n*acc)
  }
  val fact10 = trFact(10)

  def savedPicture(format: String = "jpg" , width:Int =1920, height:Int = 1080): Unit = print("Saved Picture")
  savedPicture("bpm")
  savedPicture(width = 980, format = "jpeg", height = 540)
}
