package part1basics

object ValuesVariablesTypes extends App {

    val x: Int = 42
    println(x)

    // VALS ARE IMMUTABLE
    // COMPILERS CAN INFER TYPES

    val aString:String = "hello"
    val anotherString:String = "goodbye"

    val aBoolean:Boolean = false
    val aChar: Char = 'a'
    val anInt: Int = x
    val sShort:Short = 46
    val aLong: Long = 5232479223L
    val aFloat: Float=2.0f
    val aDouble:Double = 3.14

    var aVariable:Int = 4

    aVariable = 5 //side effects

}
