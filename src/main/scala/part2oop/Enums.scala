package part2oop

object Enums {
  enum Permissions{
    case READ, WRITE, EXECUTE, NONE

    // ADD FIELDS OR METHODS
    def openDocument():Unit=
      if (this == READ) println("opening document...")
      else println("reading not allowed")
  }

  val somePermissions:Permissions = Permissions.READ

  //constructor args
  enum PermissionsWithBits(bits: Int){
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }
  object PermissionsWithBits {
    def fromBits(bits:Int): PermissionsWithBits =
      PermissionsWithBits.NONE
  }
  //Standard API
  val somePermissionsOrdinal = somePermissions.ordinal //0 cause READ is firts
  val allPermisions = PermissionsWithBits.values // array of all posible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ") //Permissions.READ



  def main(args:Array[String]): Unit = {
    somePermissions.openDocument()
  }
}
