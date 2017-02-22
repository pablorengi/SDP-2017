import scala.io.StdIn._

trait Instruction {
    def action(name:String*): String
}

trait Add extends Instruction
trait Sub extends Instruction

case class AddImpl() extends Instruction {
    def action(name: String*): String = s"Executing an instruction $name"
//    def action(name: String, anotherName: String)

}

object FooMain extends App {
    print("Enter a class name: ")
    val name = readLine 
    try {
        Class.forName(name)
        val className = name + "Impl"
        try {
            val actualClass = Class.forName(className)
            val foo = actualClass.newInstance.asInstanceOf[Instruction]
            println(foo)
            println(foo.action("Crash the machine!"))
        }
        catch {
            case ex: ClassNotFoundException =>
                println(s"No implementation for [$name] found")
        }
    }
    catch {
        case ex: ClassNotFoundException => 
            println(s"No class of instruction [$name]")
    }
}